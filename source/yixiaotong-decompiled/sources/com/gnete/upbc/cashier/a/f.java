package com.gnete.upbc.cashier.a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import client.android.yixiaotong.util.TimeUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: compiled from: AbstractAPI.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public abstract class f implements com.gnete.upbc.cashier.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3267a = getClass().getSimpleName();
    protected com.gnete.upbc.cashier.b.b b;

    /* JADX INFO: compiled from: AbstractAPI.java */
    public interface b {
        void a();

        void a(String str);

        void a(String str, Throwable th);
    }

    public f(com.gnete.upbc.cashier.b.b bVar) {
        this.b = bVar;
    }

    private String b(String str) {
        return new SimpleDateFormat(str, Locale.getDefault()).format(new Date());
    }

    protected abstract String a();

    @Override // com.gnete.upbc.cashier.a.a
    public void a(com.gnete.upbc.cashier.a.b bVar) {
        new a(bVar).start();
    }

    protected abstract void a(com.gnete.upbc.cashier.g.a.C0391a c0391a, com.gnete.upbc.cashier.a.b bVar);

    protected abstract void a(String str, Throwable th, com.gnete.upbc.cashier.a.b bVar);

    protected abstract JSONObject b();

    protected abstract void b(com.gnete.upbc.cashier.a.b bVar);

    protected String c() {
        com.gnete.upbc.cashier.g.a.C0391a c0391aA = com.gnete.upbc.cashier.g.a.b().b("sndDt", b("yyyyMMddHHmmss")).b("busiMerNo", this.b.b()).a("msgBody", b());
        StringBuilder sb = new StringBuilder("app_id=5f0bd990e43efc22205585a163f0d8e1&v=1.0.1&sign_alg=5&timestamp=");
        sb.append(b(TimeUtils.FORMATDATETIME)).append("&method=").append(a()).append("&biz_content=").append(Uri.encode(c0391aA.a().toString()));
        sb.append("&sign=").append(a(sb.toString()));
        return sb.toString();
    }

    /* JADX INFO: compiled from: AbstractAPI.java */
    class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.gnete.upbc.cashier.a.b f3268a;

        a(com.gnete.upbc.cashier.a.b bVar) {
            this.f3268a = bVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            f.this.a(com.gnete.upbc.cashier.a.d(), f.this.c(), new C0382a());
        }

        /* JADX INFO: renamed from: com.gnete.upbc.cashier.a.f$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AbstractAPI.java */
        class C0382a implements b {
            C0382a() {
            }

            @Override // com.gnete.upbc.cashier.a.f.b
            public void a(String str) {
                com.gnete.upbc.cashier.g.a.C0391a c0391aA = com.gnete.upbc.cashier.g.a.a(str);
                String strA = c0391aA.a("code", "");
                if (!TextUtils.equals("00000", strA)) {
                    f.this.a(String.format("%s(%s)", c0391aA.a("msg", "未知错误"), strA), (Throwable) null, a.this.f3268a);
                    return;
                }
                com.gnete.upbc.cashier.g.a.C0391a c0391aB = c0391aA.b("response");
                String strA2 = c0391aB.a("subCode", "");
                if (!TextUtils.equals("00000", strA2)) {
                    f.this.a(String.format("%s(%s)", c0391aB.a("subMsg", "未知错误"), strA2), (Throwable) null, a.this.f3268a);
                    return;
                }
                com.gnete.upbc.cashier.g.a.C0391a c0391aB2 = c0391aB.b("msgBody");
                String strA3 = c0391aB2.a("retCode", "");
                if (!TextUtils.equals("00000", strA3)) {
                    f.this.a(String.format("%s(%s)", c0391aB2.a("retMsg", "未知错误"), strA3), (Throwable) null, a.this.f3268a);
                } else {
                    a aVar = a.this;
                    f.this.a(c0391aB2, aVar.f3268a);
                }
            }

            @Override // com.gnete.upbc.cashier.a.f.b
            public void a(String str, Throwable th) {
                a aVar = a.this;
                f.this.a(str, th, aVar.f3268a);
            }

            @Override // com.gnete.upbc.cashier.a.f.b
            public void a() {
                a aVar = a.this;
                f.this.b(aVar.f3268a);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00ed A[Catch: IOException -> 0x00e9, TryCatch #0 {IOException -> 0x00e9, blocks: (B:46:0x00e5, B:50:0x00ed, B:52:0x00f2), top: B:57:0x00e5 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x00f2 A[Catch: IOException -> 0x00e9, TRY_LEAVE, TryCatch #0 {IOException -> 0x00e9, blocks: (B:46:0x00e5, B:50:0x00ed, B:52:0x00f2), top: B:57:0x00e5 }] */
    protected void a(String str, String str2, b bVar) {
        Throwable th;
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        String.format("请求地址 -> %s, 请求报文 -> %s", str, str2);
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setConnectTimeout(60000);
                    httpURLConnection.setReadTimeout(60000);
                    httpURLConnection.setRequestProperty("accept", "*/*");
                    httpURLConnection.setRequestProperty("connection", "Keep-Alive");
                    httpURLConnection.setRequestProperty("Charset", "UTF-8");
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setUseCaches(false);
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream(), StandardCharsets.UTF_8);
                    outputStreamWriter.write(str2);
                    outputStreamWriter.flush();
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode() == 200) {
                        inputStream = httpURLConnection.getInputStream();
                        try {
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int i = inputStream.read(bArr);
                                    if (i == -1) {
                                        break;
                                    } else {
                                        byteArrayOutputStream2.write(bArr, 0, i);
                                    }
                                }
                                String string = byteArrayOutputStream2.toString();
                                new StringBuilder().append("响应参数 -> ");
                                bVar.a(string);
                                byteArrayOutputStream = byteArrayOutputStream2;
                            } catch (Throwable th2) {
                                th = th2;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                try {
                                    Log.e(this.f3267a, th.getMessage(), th);
                                    bVar.a(th.getMessage(), th);
                                    if (byteArrayOutputStream != null) {
                                        byteArrayOutputStream.close();
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                } finally {
                                    if (byteArrayOutputStream != null) {
                                        try {
                                            byteArrayOutputStream.close();
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                            if (httpURLConnection != null) {
                                                httpURLConnection.disconnect();
                                            }
                                        } catch (IOException e) {
                                            Log.e(this.f3267a, e.getMessage(), e);
                                            bVar.a();
                                        }
                                    } else {
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                    }
                                    bVar.a();
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } else {
                        bVar.a(String.valueOf(httpURLConnection.getResponseCode()), null);
                        inputStream = null;
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    httpURLConnection.disconnect();
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = null;
                }
            } catch (Throwable th5) {
                th = th5;
                httpURLConnection = null;
                inputStream = null;
            }
        } catch (IOException e2) {
            Log.e(this.f3267a, e2.getMessage(), e2);
        }
    }

    private String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes(StandardCharsets.UTF_8));
                StringBuilder sb = new StringBuilder();
                for (byte b2 : bArrDigest) {
                    String hexString = Integer.toHexString(b2 & 255);
                    if (hexString.length() == 1) {
                        hexString = "0" + hexString;
                    }
                    sb.append(hexString);
                }
                return sb.toString();
            } catch (NoSuchAlgorithmException e) {
                Log.e(this.f3267a, e.getMessage(), e);
            }
        }
        return "";
    }
}
