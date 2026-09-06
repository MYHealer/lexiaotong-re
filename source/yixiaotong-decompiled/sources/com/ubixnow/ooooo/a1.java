package com.ubixnow.ooooo;

import android.text.TextUtils;
import com.ubixnow.utils.BaseUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class a1 implements e1 {
    private static final int OooO00o = 20000;
    private static final int OooO0O0 = 20000;
    private String OooO0OO = ooooO000.OooO0O0 + "net";
    private OooO0O0 OooO0Oo;
    private c1 OooO0o0;

    public static /* synthetic */ class OooO00o {
        public static final /* synthetic */ int[] OooO00o;

        static {
            OooO0O0.values();
            int[] iArr = new int[2];
            OooO00o = iArr;
            try {
                iArr[OooO0O0.Get.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                OooO00o[OooO0O0.Post.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum OooO0O0 {
        Get,
        Post
    }

    public a1(OooO0O0 oooO0O0) {
        this.OooO0Oo = oooO0O0;
    }

    private b1 OooO00o(HttpURLConnection httpURLConnection, int i, int i2) throws Exception {
        if (httpURLConnection == null) {
            ooooO000.OooO00o(this.OooO0OO, "connection == null");
            OooO00o(oOO00O0.networkError, "connection == null");
            return null;
        }
        if (i >= 5) {
            ooooO000.OooO00o(this.OooO0OO, "循环重定向超过5次");
            c1 c1Var = this.OooO0o0;
            if (c1Var != null) {
                c1Var.OooO00o(new oOO00OO(oOO00O0.httpStatuException, "循环重定向超过5次"));
            }
            return null;
        }
        try {
            b1 b1Var = new b1(httpURLConnection);
            int iOooO0O0 = b1Var.OooO0O0();
            if (iOooO0O0 > 300 && iOooO0O0 < 400) {
                String headerField = httpURLConnection.getHeaderField("Location");
                if (TextUtils.isEmpty(headerField)) {
                    ooooO000.OooO00o(this.OooO0OO, " location  == null");
                } else {
                    ooooO000.OooO00o(this.OooO0OO, "重定向 ： " + headerField);
                    i++;
                    b1Var = OooO00o(OooO00o(headerField), i, i2);
                }
            }
            return b1Var;
        } catch (SocketTimeoutException e) {
            if (i2 < 1) {
                ooooO000.OooO00o("重试请求");
                return OooO00o(OooO00o(OooO0Oo()), i, i2 + 1);
            }
            ooooO000.OooO00o(this.OooO0OO, "已达到重试上限");
            throw e;
        }
    }

    private HttpURLConnection OooO00o(HttpURLConnection httpURLConnection) throws Exception {
        OooO0O0(httpURLConnection);
        int iOrdinal = this.OooO0Oo.ordinal();
        if (iOrdinal == 0) {
            httpURLConnection.setRequestMethod("GET");
        } else if (iOrdinal == 1) {
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = null;
            try {
                try {
                    outputStream = httpURLConnection.getOutputStream();
                    byte[] bArrOooO0OO = OooO0OO();
                    if (bArrOooO0OO != null && bArrOooO0OO.length > 0) {
                        outputStream.write(bArrOooO0OO);
                    }
                    ooo0o.OooO00o(outputStream);
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                    ooo0o.OooO00o(outputStream);
                }
            } catch (Throwable th) {
                ooo0o.OooO00o(outputStream);
                throw th;
            }
        }
        return httpURLConnection;
    }

    private HttpURLConnection OooO00o(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(20000);
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setInstanceFollowRedirects(true);
        return httpURLConnection;
    }

    private void OooO00o(String str, String str2) {
        c1 c1Var = this.OooO0o0;
        if (c1Var != null) {
            c1Var.OooO00o(new oOO00OO(str, str2));
        }
    }

    private HttpsURLConnection OooO0O0(URL url) throws NoSuchAlgorithmException, IOException, KeyManagementException {
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
        httpsURLConnection.setConnectTimeout(20000);
        httpsURLConnection.setReadTimeout(20000);
        httpsURLConnection.setHostnameVerifier(new d1());
        httpsURLConnection.setInstanceFollowRedirects(true);
        return httpsURLConnection;
    }

    private void OooO0O0() {
        b1 b1VarOooO00o = null;
        try {
            try {
                b1VarOooO00o = OooO00o(OooO00o(OooO0Oo()), 1, 1);
                if (b1VarOooO00o == null) {
                    ooooO000.OooO00o(this.OooO0OO, "  httpResult  == null");
                    if (b1VarOooO00o != null) {
                        b1VarOooO00o.OooO00o();
                        return;
                    }
                    return;
                }
                int iOooO0O0 = b1VarOooO00o.OooO0O0();
                if (iOooO0O0 >= 200 && iOooO0O0 < 400) {
                    c1 c1Var = this.OooO0o0;
                    if (c1Var != null) {
                        c1Var.OooO00o(b1VarOooO00o);
                    }
                    b1VarOooO00o.OooO00o();
                    return;
                }
                OooO00o(iOooO0O0 + "", "NetException:" + b1.OooO00o(iOooO0O0));
                b1VarOooO00o.OooO00o();
            } catch (Exception e) {
                OooO00o(oOO00O0.networkError, e.getMessage());
                if (0 == 0) {
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                b1VarOooO00o.OooO00o();
            }
            throw th;
        }
    }

    public HttpURLConnection OooO00o(String str) throws Exception {
        if (TextUtils.isEmpty(str)) {
            ooooO000.OooO00o(this.OooO0OO, "url null!");
            return null;
        }
        URL url = new URL(str);
        return OooO00o(str.substring(0, str.indexOf(com.huawei.openalliance.ad.constant.x.bQ)).equals("https") ? OooO0O0(url) : OooO00o(url));
    }

    public void OooO00o(c1 c1Var) {
        this.OooO0o0 = c1Var;
    }

    public abstract void OooO0O0(HttpURLConnection httpURLConnection);

    public abstract byte[] OooO0OO();

    public abstract String OooO0Oo() throws Exception;

    @Override // java.lang.Runnable
    public void run() {
        if (a.OooO0O0(BaseUtils.getContext())) {
            OooO0O0();
        } else {
            ooooO000.OooO00o(this.OooO0OO, "没有网络连接，网络任务中断");
            OooO00o(oOO00O0.networkError, "没有网络连接，网络任务中断。status:" + a.OooO0oo);
        }
    }
}
