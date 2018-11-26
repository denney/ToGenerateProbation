/**
 * 
 */
package cn.substation.util;

//import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author wangp
 */
public class PostTest {
	public static void main(String[] args) {
		String url = "http://sn.erow.cn:58077/qxzd/home/UserLogin.ashx";
		String requestRtl = sendPOSTRequest(url, "UserNumber=0001&IdenfyCode=whcz1.L2017");
		System.out.println(requestRtl);
//		if (requestRtl != null) {
//			JSONObject result = new JSONObject(requestRtl);
//			System.out.println(result.getString("result"));
//			System.out.println(result.getString("Token"));
//		}
	}

	public static String sendPOSTRequest(String url, String params) {
		String result = null;
		try {
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("POST");
			conn.setConnectTimeout(45 * 1000);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestProperty("Connection", "Keep-Alive");
			// 写入参数
			OutputStream outputStream = conn.getOutputStream();
			outputStream.write(params.getBytes("UTF-8"));
			outputStream.flush();
			outputStream.close();

			int resultCode = conn.getResponseCode();
			if (resultCode == HttpURLConnection.HTTP_OK) {
				InputStream is = conn.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(is));
				String line;
				StringBuilder sb = new StringBuilder();
				while ((line = reader.readLine()) != null) {
					sb.append(line);
				}
				reader.close();
				is.close();
				result = sb.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
