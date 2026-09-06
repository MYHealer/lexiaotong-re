package client.android.yixiaotong.controller.weixin;

import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class OkHttpUtils {
    public static void sendHttpRequest(final String str, final HttpCallBackListener httpCallBackListener) {
        new Thread(new Runnable() { // from class: client.android.yixiaotong.controller.weixin.OkHttpUtils.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    URL url = new URL(str);
                    Log.e("test", str);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(8000);
                    httpURLConnection.setReadTimeout(8000);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        } else {
                            sb.append(line);
                        }
                    }
                    HttpCallBackListener httpCallBackListener2 = httpCallBackListener;
                    if (httpCallBackListener2 != null) {
                        httpCallBackListener2.onFinish(sb.toString());
                    }
                } catch (MalformedURLException e) {
                    HttpCallBackListener httpCallBackListener3 = httpCallBackListener;
                    if (httpCallBackListener3 != null) {
                        httpCallBackListener3.onError(e);
                    }
                    e.printStackTrace();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }).start();
    }
}
