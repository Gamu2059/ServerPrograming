package tdu_market.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * パスワードに関するユーティリティクラス<br>
 * 参考URL(2019/11/07閲覧)<br>
 * <a href="https://www.casleyconsulting.co.jp/blog/engineer/153/">https://www.casleyconsulting.co.jp/blog/engineer/153/</a>
 */
public final class PasswordUtil {

	private static final String CHARA_SET = "UTF-8";
	private static final String SHA_256 = "SHA-256";
	private static final String PBKDF2_WITH_HMAC_SHA_256 = "PBKDF2WithHmacSHA256";
	private static final int ITERATION_COUNT = 10000;
	private static final int KEY_LENGTH = 512;

	private static byte[] getHashedSalt(String salt) {

		MessageDigest messageDigest;

		try {
			messageDigest = MessageDigest.getInstance(SHA_256);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}

		try {
			messageDigest.update(salt.getBytes(CHARA_SET));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}

		return messageDigest.digest();
	}

	public static String getHashedPassword(String nonHashedPassword, String salt) {

		char[] passwordArray = nonHashedPassword.toCharArray();
		byte[] hashedSalt = getHashedSalt(salt);

		PBEKeySpec keySpec = new PBEKeySpec(passwordArray, hashedSalt, ITERATION_COUNT, KEY_LENGTH);

		SecretKeyFactory skf;
		try {
			skf = SecretKeyFactory.getInstance(PBKDF2_WITH_HMAC_SHA_256);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}

		SecretKey secretKey;
		try {
			secretKey = skf.generateSecret(keySpec);
		} catch (InvalidKeySpecException e) {
			throw new RuntimeException(e);
		}
		byte[] passwordByteArray = secretKey.getEncoded();

		// DatatypeConverterが無いので自力で16進数へ変換
		StringBuilder sb = new StringBuilder(64);
		for (byte b : passwordByteArray) {
			sb.append(String.format("%02x", b & 0xff));
		}

		return sb.toString();
	}

	private static Stream<Character> getRandomNumbers(int n) {
		SecureRandom random = new SecureRandom();
		IntStream chars = random.ints(n, '0', '9');
		return chars.mapToObj(d -> (char) d);
	}

	private static Stream<Character> getRandomChars(int n, boolean isUpperCase) {
		SecureRandom random = new SecureRandom();
		IntStream chars;
		if (isUpperCase) {
			chars = random.ints(n, 'A', 'Z');
		} else {
			chars = random.ints(n, 'a', 'z');
		}

		return chars.mapToObj(d -> (char) d);
	}

	public static String createNonHashedPassword() {

		Stream<Character> numStream = getRandomNumbers(4);
		Stream<Character> lowerStream = getRandomChars(4, false);
		Stream<Character> upperStream = getRandomChars(4, true);
		Stream<Character> pwdStream = Stream.concat(numStream, Stream.concat(lowerStream, upperStream));

		List<Character> list = pwdStream.collect(Collectors.toList());
		Collections.shuffle(list);
		String password = list.stream().collect(
				StringBuilder::new,
				StringBuilder::append,
				StringBuilder::append).toString();

		return password;
	}
}
