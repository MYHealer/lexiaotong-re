package com.hihonor.secure.android.common.ssl.util;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class j {
    private static final String A = "rootcas.bks";
    private static final String B = "";
    private static final String D = "bks";
    private static final String TAG = "X509CertificateUtil";
    private static final String ap = "052root";
    private static final String aq = "incas.bks";
    private static final String ar = "hihonor application integration ca";
    private Context k;

    public j(Context context) {
        this.k = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    public X509Certificate f(String str, String str2) throws Throwable {
        InputStream inputStreamOpen;
        ?? r1 = 0;
        X509Certificate x509Certificate = null;
        try {
            try {
                KeyStore keyStore = KeyStore.getInstance("bks");
                inputStreamOpen = this.k.getAssets().open(str);
                try {
                    inputStreamOpen.reset();
                    keyStore.load(inputStreamOpen, "".toCharArray());
                    X509Certificate x509Certificate2 = (X509Certificate) keyStore.getCertificate(str2);
                    f.c(inputStreamOpen);
                    x509Certificate = x509Certificate2;
                    str = inputStreamOpen;
                } catch (IOException e) {
                    e = e;
                    g.e(TAG, "loadBksCA: exception : " + e.getMessage());
                    f.c(inputStreamOpen);
                    str = inputStreamOpen;
                } catch (KeyStoreException e2) {
                    e = e2;
                    g.e(TAG, "loadBksCA: exception : " + e.getMessage());
                    f.c(inputStreamOpen);
                    str = inputStreamOpen;
                } catch (NoSuchAlgorithmException e3) {
                    e = e3;
                    g.e(TAG, "loadBksCA: exception : " + e.getMessage());
                    f.c(inputStreamOpen);
                    str = inputStreamOpen;
                } catch (CertificateException e4) {
                    e = e4;
                    g.e(TAG, "loadBksCA: exception : " + e.getMessage());
                    f.c(inputStreamOpen);
                    str = inputStreamOpen;
                }
            } catch (Throwable th) {
                th = th;
                r1 = str;
                f.c((InputStream) r1);
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            inputStreamOpen = null;
            g.e(TAG, "loadBksCA: exception : " + e.getMessage());
            f.c(inputStreamOpen);
            str = inputStreamOpen;
            return x509Certificate;
        } catch (KeyStoreException e6) {
            e = e6;
            inputStreamOpen = null;
            g.e(TAG, "loadBksCA: exception : " + e.getMessage());
            f.c(inputStreamOpen);
            str = inputStreamOpen;
            return x509Certificate;
        } catch (NoSuchAlgorithmException e7) {
            e = e7;
            inputStreamOpen = null;
            g.e(TAG, "loadBksCA: exception : " + e.getMessage());
            f.c(inputStreamOpen);
            str = inputStreamOpen;
            return x509Certificate;
        } catch (CertificateException e8) {
            e = e8;
            inputStreamOpen = null;
            g.e(TAG, "loadBksCA: exception : " + e.getMessage());
            f.c(inputStreamOpen);
            str = inputStreamOpen;
            return x509Certificate;
        } catch (Throwable th2) {
            th = th2;
            f.c((InputStream) r1);
            throw th;
        }
        return x509Certificate;
    }

    public X509Certificate l() {
        return f("rootcas.bks", "052root");
    }

    public X509Certificate m() {
        return f(aq, ar);
    }
}
