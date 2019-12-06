package tdu_market.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public class ImageUtil {

	public static String getImage(InputStream inputStream) {

		if (inputStream == null) {
			return null;
		}

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		String icon = null;

		try {
			byte[] buffer = new byte[1024];
			int bytesRead;
			boolean isEmpty = true;

			while ((bytesRead = inputStream.read(buffer)) != -1) {
				output.write(buffer, 0, bytesRead);
				isEmpty = false;
			}

			// 空と同意であればnullを返す
			if (isEmpty) {
				return null;
			}

			icon = Base64.getEncoder().encodeToString(output.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
			inputStream.close();
			output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return String.format("data:image/png;base64,%s", icon);
	}

}
