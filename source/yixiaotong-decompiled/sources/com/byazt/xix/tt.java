package com.byazt.xix;

import android.net.Network;
import android.text.TextUtils;
import com.byazt.bzd.n;
import java.io.Closeable;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 664, 13})
public class tt {
    /* JADX WARN: Code duplicated, block: B:40:0x00a9  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.io.InputStream] */
    public static JSONObject c(Network network, String str, String str2) {
        HttpsURLConnection httpsURLConnection;
        OutputStream outputStream;
        ?? inputStream;
        JSONObject jSONObject;
        ?? r0 = 0;
        if (str == null) {
            return null;
        }
        try {
            if (network == null) {
                httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
            } else {
                httpsURLConnection = (HttpsURLConnection) network.openConnection(new URL(str));
            }
            if (httpsURLConnection != null) {
                try {
                    httpsURLConnection.setConnectTimeout(10000);
                    httpsURLConnection.setReadTimeout(10000);
                    httpsURLConnection.setDoInput(true);
                    httpsURLConnection.setDefaultUseCaches(false);
                    if (!TextUtils.isEmpty(str2)) {
                        httpsURLConnection.setRequestMethod("POST");
                        httpsURLConnection.setDoOutput(true);
                        outputStream = httpsURLConnection.getOutputStream();
                        try {
                            outputStream.write(str2.getBytes());
                            outputStream.flush();
                        } catch (Throwable unused) {
                            inputStream = 0;
                            if (httpsURLConnection != null) {
                                httpsURLConnection.disconnect();
                            }
                            n.c(outputStream);
                            n.c((Closeable) inputStream);
                            return null;
                        }
                    } else {
                        httpsURLConnection.setRequestMethod("GET");
                        outputStream = null;
                    }
                    httpsURLConnection.connect();
                    if (httpsURLConnection.getResponseCode() == 200) {
                        inputStream = httpsURLConnection.getInputStream();
                        try {
                            byte[] bArr = new byte[2048];
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                int i = inputStream.read(bArr);
                                if (i <= 0) {
                                    break;
                                }
                                sb.append(new String(bArr, 0, i, StandardCharsets.UTF_8));
                            }
                            jSONObject = new JSONObject(sb.toString());
                            r0 = inputStream;
                        } catch (Throwable unused2) {
                            if (httpsURLConnection != null) {
                                httpsURLConnection.disconnect();
                            }
                            n.c(outputStream);
                            n.c((Closeable) inputStream);
                            return null;
                        }
                    } else {
                        jSONObject = null;
                    }
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                    n.c(outputStream);
                    n.c((Closeable) r0);
                    return jSONObject;
                } catch (Throwable unused3) {
                    outputStream = null;
                    inputStream = outputStream;
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                    n.c(outputStream);
                    n.c((Closeable) inputStream);
                    return null;
                }
            }
            if (httpsURLConnection != null) {
                httpsURLConnection.disconnect();
            }
            n.c((Closeable) null);
            n.c((Closeable) null);
            return null;
        } catch (Throwable unused4) {
            httpsURLConnection = null;
            outputStream = null;
        }
    }
}
