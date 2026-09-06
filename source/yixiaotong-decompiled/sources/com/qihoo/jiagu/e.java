package com.qihoo.jiagu;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.util.Base64;
import com.kuaishou.weapon.p0.g;
import com.qihoo.bugreport.CrashReport;
import com.qihoo.bugreport.javacrash.ExceptionHandleReporter;
import com.qihoo.bugreport.javacrash.ReportField;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
public final class e extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ boolean f8454a;
    private /* synthetic */ JSONObject b;
    private /* synthetic */ ExceptionHandleReporter c;

    public e(ExceptionHandleReporter exceptionHandleReporter, boolean z, JSONObject jSONObject) {
        this.c = exceptionHandleReporter;
        this.f8454a = z;
        this.b = jSONObject;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        String str;
        Throwable th;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        try {
            Context context = this.c.c;
            boolean z = c.a(context, g.b) && ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1).isConnected();
            boolean zC = !this.f8454a ? c.c(this.c.c, "opentestCrashCollect") : false;
            if (z || zC) {
                new d();
                JSONObject jSONObject = this.b;
                if (jSONObject == null) {
                    return;
                }
                String string = jSONObject.toString();
                if (string.length() == 0 || Build.VERSION.SDK_INT < 8) {
                    return;
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(string.getBytes());
                gZIPOutputStream.flush();
                gZIPOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byte[] bArr = new byte[16];
                new Random().nextBytes(bArr);
                Cipher cipher = Cipher.getInstance("RC4");
                cipher.init(1, new SecretKeySpec(bArr, "RC4"));
                byte[] bArrUpdate = cipher.update(byteArray);
                byte[] bArr2 = new byte[bArrUpdate.length + 16 + 4];
                System.arraycopy(new byte[]{(byte) 16, (byte) 0, (byte) 0, (byte) 0}, 0, bArr2, 0, 4);
                System.arraycopy(bArr, 0, bArr2, 4, 16);
                System.arraycopy(bArrUpdate, 0, bArr2, 20, bArrUpdate.length);
                String strEncodeToString = Base64.encodeToString(bArr2, 0);
                String strEncode = URLEncoder.encode(strEncodeToString, "UTF-8");
                String strA = c.a(strEncode.getBytes());
                if (strA == null) {
                    str = null;
                } else {
                    byte[] bytes = strA.getBytes();
                    byte[] bArr3 = new byte[16];
                    byte[] bArr4 = new byte[48];
                    new Random().nextBytes(bArr3);
                    byte[] bytes2 = c.a(bArr3).getBytes();
                    System.arraycopy(bytes, 16, bArr4, 0, 16);
                    System.arraycopy(bytes2, 0, bArr4, 16, 16);
                    System.arraycopy(bytes, 0, bArr4, 32, 16);
                    str = new String(bArr4);
                }
                if (z) {
                    new c();
                    HttpPost httpPost = new HttpPost(b.a());
                    httpPost.addHeader("User-Agent", "Android");
                    httpPost.addHeader("Accept", "*/*");
                    httpPost.addHeader("cpv", "3");
                    BasicHttpParams basicHttpParams = new BasicHttpParams();
                    HttpConnectionParams.setConnectionTimeout(basicHttpParams, b.b());
                    HttpConnectionParams.setSoTimeout(basicHttpParams, b.c());
                    DefaultHttpClient defaultHttpClient = new DefaultHttpClient(basicHttpParams);
                    ArrayList arrayList = new ArrayList(2);
                    arrayList.add(new BasicNameValuePair("c", strEncodeToString));
                    arrayList.add(new BasicNameValuePair("x", str));
                    boolean zC2 = c.c(CrashReport.a(), "jg_qihoo_test_file");
                    if (zC2) {
                        f.a("CRASH_REPORT", "crash_data:" + strEncodeToString);
                    }
                    try {
                        httpPost.setEntity(new UrlEncodedFormEntity(arrayList));
                    } catch (UnsupportedEncodingException e) {
                    }
                    try {
                        HttpResponse httpResponseExecute = defaultHttpClient.execute(httpPost);
                        httpResponseExecute.getStatusLine().getStatusCode();
                        if (zC2) {
                            f.a("CRASH_REPORT", "response_code:" + httpResponseExecute.getStatusLine().getStatusCode());
                        }
                    } catch (IOException e2) {
                    }
                }
                if (!zC || jSONObject == null || strEncode == null || str == null) {
                    return;
                }
                try {
                    if (!jSONObject.has(ReportField.ct.name())) {
                        return;
                    }
                    File file = new File(CrashReport.a().getFilesDir().getAbsolutePath() + "/crashCollect");
                    if (!file.exists() && !file.isDirectory()) {
                        file.mkdirs();
                        d.a("chmod 777 " + file.getAbsolutePath());
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("cpv=3").append("&c=").append(strEncode).append("&x=").append(str);
                    synchronized (d.class) {
                        try {
                            File file2 = new File(file + "/" + String.valueOf(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.ENGLISH).parse(jSONObject.getString(ReportField.ct.name())).getTime()));
                            try {
                                fileOutputStream2 = new FileOutputStream(file2);
                                try {
                                    fileOutputStream2.write(stringBuffer.toString().getBytes());
                                    fileOutputStream2.flush();
                                    try {
                                        fileOutputStream2.close();
                                    } catch (IOException e3) {
                                    }
                                    d.a("chmod 777 " + file2.getAbsolutePath());
                                } catch (Exception e4) {
                                    if (fileOutputStream2 != null) {
                                        try {
                                            fileOutputStream2.close();
                                        } catch (IOException e5) {
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileOutputStream = fileOutputStream2;
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                            throw th;
                                        } catch (IOException e6) {
                                            throw th;
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Exception e7) {
                                fileOutputStream2 = null;
                            } catch (Throwable th3) {
                                th = th3;
                                fileOutputStream = null;
                            }
                        } catch (Exception e8) {
                        }
                    }
                } catch (Throwable th4) {
                }
            }
        } catch (Throwable th5) {
        }
    }
}
