package com.hihonor.secure.android.common.ssl;

import android.content.Context;
import com.hihonor.secure.android.common.ssl.util.g;
import com.hihonor.secure.android.common.ssl.util.j;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c implements X509TrustManager {
    private static final String TAG = "WebViewX509TrustManger";
    private X509Certificate R;
    private List<X509TrustManager> S = new ArrayList();

    public c(Context context) {
        if (context == null) {
            throw new NullPointerException("WebViewX509TrustManger context is null");
        }
        com.hihonor.secure.android.common.ssl.util.c.setContext(context);
        X509Certificate x509CertificateL = new j(context).l();
        this.R = x509CertificateL;
        if (x509CertificateL == null) {
            throw new NullPointerException("WebViewX509TrustManger cannot get root ca");
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        g.c(TAG, "checkClientTrusted");
        if (!this.S.isEmpty()) {
            this.S.get(0).checkClientTrusted(x509CertificateArr, str);
            return;
        }
        throw new CertificateException("checkClientTrusted CertificateException");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        g.c(TAG, "checkServerTrusted");
        boolean zA = false;
        for (byte b = 0; b < x509CertificateArr.length; b = (byte) (b + 1)) {
            g.b(TAG, "checkServerTrusted " + ((int) b) + " : " + x509CertificateArr[b].getIssuerDN().getName());
        }
        X509Certificate[] x509CertificateArr2 = new X509Certificate[x509CertificateArr.length];
        for (byte b2 = 0; b2 < x509CertificateArr.length; b2 = (byte) (b2 + 1)) {
            x509CertificateArr2[b2] = x509CertificateArr[(x509CertificateArr.length - 1) - b2];
        }
        CertificateException e = new CertificateException("root CA CertificateException");
        try {
            zA = com.hihonor.secure.android.common.ssl.util.b.a(this.R, x509CertificateArr2);
        } catch (InvalidKeyException e2) {
            g.e(TAG, "checkServerTrusted InvalidKeyException: " + e2.getMessage());
        } catch (NoSuchAlgorithmException e3) {
            g.e(TAG, "checkServerTrusted NoSuchAlgorithmException: " + e3.getMessage());
        } catch (NoSuchProviderException e4) {
            g.e(TAG, "checkServerTrusted NoSuchProviderException: " + e4.getMessage());
        } catch (SignatureException e5) {
            g.e(TAG, "checkServerTrusted SignatureException: " + e5.getMessage());
        } catch (CertificateException e6) {
            e = e6;
            g.e(TAG, "checkServerTrusted CertificateException: " + e.getMessage());
        }
        if (!zA) {
            throw e;
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<X509TrustManager> it = this.S.iterator();
            while (it.hasNext()) {
                arrayList.addAll(Arrays.asList(it.next().getAcceptedIssuers()));
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        } catch (Exception e) {
            g.e(TAG, "getAcceptedIssuers exception : " + e.getMessage());
            return new X509Certificate[0];
        }
    }
}
