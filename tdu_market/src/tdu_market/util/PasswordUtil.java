package tdu_market.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

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
}
