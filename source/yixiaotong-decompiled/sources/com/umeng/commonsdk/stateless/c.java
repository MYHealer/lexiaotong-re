package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.g;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.umeng.analytics.pro.am;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.File;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: UMSLNetWorkSenderHelper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9246a = "10.0.0.172";
    private int b = 80;
    private Context c;

    public c(Context context) {
        this.c = context;
    }

    private void a() {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(this.c, "sl_domain_p", "");
        if (TextUtils.isEmpty(strImprintProperty)) {
            return;
        }
        a.i = DataHelper.assembleStatelessURL(strImprintProperty);
    }

    private void b() {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(this.c, "sl_domain_p", "");
        String strImprintProperty2 = UMEnvelopeBuild.imprintProperty(this.c, "oversea_sl_domain_p", "");
        if (!TextUtils.isEmpty(strImprintProperty)) {
            a.h = DataHelper.assembleStatelessURL(strImprintProperty);
        }
        if (!TextUtils.isEmpty(strImprintProperty2)) {
            a.k = DataHelper.assembleStatelessURL(strImprintProperty2);
        }
        a.i = a.k;
        if (TextUtils.isEmpty(com.umeng.commonsdk.statistics.b.b)) {
            return;
        }
        if (com.umeng.commonsdk.statistics.b.b.startsWith("460") || com.umeng.commonsdk.statistics.b.b.startsWith("461")) {
            a.i = a.h;
        }
    }

    private boolean c() {
        NetworkInfo activeNetworkInfo;
        String extraInfo;
        Context context = this.c;
        if (context == null || context.getPackageManager().checkPermission(g.b, this.c.getPackageName()) != 0) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.c.getSystemService("connectivity");
            return (!DeviceConfig.checkPermission(this.c, g.b) || connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || activeNetworkInfo.getType() == 1 || (extraInfo = activeNetworkInfo.getExtraInfo()) == null || (!extraInfo.equals("cmwap") && !extraInfo.equals("3gwap") && !extraInfo.equals("uniwap"))) ? false : true;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.c, th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v15, types: [javax.net.ssl.HttpsURLConnection] */
    /* JADX WARN: Type inference failed for: r14v22 */
    /* JADX WARN: Type inference failed for: r14v23 */
    /* JADX WARN: Type inference failed for: r14v24 */
    /* JADX WARN: Type inference failed for: r14v25 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v8, types: [javax.net.ssl.HttpsURLConnection] */
    public boolean a(byte[] bArr, String str, String str2, String str3) {
        boolean z = false;
        if (bArr == null || str == null) {
            ULog.i("walle", "[stateless] sendMessage, envelopeByte == null || path == null ");
            return false;
        }
        if (SdkVersion.SDK_TYPE == 0) {
            a();
        } else {
            a.h = a.k;
            b();
        }
        String str4 = a.i;
        boolean zIsEmpty = TextUtils.isEmpty(str2);
        HttpsURLConnection httpsURLConnection = str2;
        if (zIsEmpty) {
            httpsURLConnection = str4;
        }
        OutputStream outputStream = null;
        try {
            try {
                if (c()) {
                    httpsURLConnection = (HttpsURLConnection) new URL(((String) httpsURLConnection) + File.separator + str).openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.f9246a, this.b)));
                } else {
                    httpsURLConnection = (HttpsURLConnection) new URL(((String) httpsURLConnection) + File.separator + str).openConnection();
                }
                try {
                    httpsURLConnection.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                    SSLContext sSLContext = SSLContext.getInstance("TLS");
                    sSLContext.init(null, null, new SecureRandom());
                    httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
                    httpsURLConnection.setRequestProperty("X-Umeng-UTC", String.valueOf(System.currentTimeMillis()));
                    httpsURLConnection.setRequestProperty("Msg-Type", "envelope/json");
                    httpsURLConnection.setRequestProperty("Content-Type", am.aP + str3);
                    httpsURLConnection.setRequestProperty("SM-IMP", "1");
                    httpsURLConnection.setConnectTimeout(KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
                    httpsURLConnection.setReadTimeout(KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
                    httpsURLConnection.setRequestMethod("POST");
                    httpsURLConnection.setDoOutput(true);
                    httpsURLConnection.setDoInput(true);
                    httpsURLConnection.setUseCaches(false);
                    outputStream = httpsURLConnection.getOutputStream();
                    outputStream.write(bArr);
                    outputStream.flush();
                    httpsURLConnection.connect();
                    if (httpsURLConnection.getResponseCode() == 200) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send stateless message success : " + a.i + "/" + str);
                        z = true;
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception unused) {
                        }
                    }
                    if (httpsURLConnection != 0) {
                        try {
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> stateless: disconnect connection.");
                            httpsURLConnection.disconnect();
                        } catch (Throwable unused2) {
                        }
                    }
                } catch (SSLHandshakeException e) {
                    e = e;
                    MLog.e("SSLHandshakeException, Failed to send message.", e);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    if (httpsURLConnection != 0) {
                    }
                    return z;
                } catch (Throwable th) {
                    th = th;
                    MLog.e("Exception,Failed to send message.", th);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception unused4) {
                        }
                    }
                    if (httpsURLConnection != 0) {
                    }
                    return z;
                }
            } catch (Throwable th2) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception unused5) {
                    }
                }
                if (httpsURLConnection != 0) {
                    try {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> stateless: disconnect connection.");
                        httpsURLConnection.disconnect();
                        throw th2;
                    } catch (Throwable unused6) {
                        throw th2;
                    }
                }
                throw th2;
            }
        } catch (SSLHandshakeException e2) {
            e = e2;
            httpsURLConnection = 0;
        } catch (Throwable th3) {
            th = th3;
            httpsURLConnection = 0;
        }
        return z;
    }
}
