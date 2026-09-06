package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class CertificateUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4552a = "CertificateUtil";

    private CertificateUtil() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    public static X509Certificate getHwCbgRootCA(Context context) throws Throwable {
        InputStream inputStreamOpen;
        ?? r1 = 0;
        X509Certificate x509Certificate = null;
        try {
            try {
                KeyStore keyStore = KeyStore.getInstance(j.e);
                inputStreamOpen = context.getAssets().open("hmsrootcas.bks");
                try {
                    inputStreamOpen.reset();
                    keyStore.load(inputStreamOpen, "".toCharArray());
                    x509Certificate = (X509Certificate) keyStore.getCertificate(j.f);
                    context = inputStreamOpen;
                } catch (IOException e) {
                    e = e;
                    g.b(f4552a, "loadBksCA: exception : " + e.getMessage());
                    context = inputStreamOpen;
                } catch (RuntimeException e2) {
                    e = e2;
                    g.b(f4552a, "loadBksCA: exception : " + e.getMessage());
                    context = inputStreamOpen;
                } catch (KeyStoreException e3) {
                    e = e3;
                    g.b(f4552a, "loadBksCA: exception : " + e.getMessage());
                    context = inputStreamOpen;
                } catch (NoSuchAlgorithmException e4) {
                    e = e4;
                    g.b(f4552a, "loadBksCA: exception : " + e.getMessage());
                    context = inputStreamOpen;
                } catch (CertificateException e5) {
                    e = e5;
                    g.b(f4552a, "loadBksCA: exception : " + e.getMessage());
                    context = inputStreamOpen;
                }
            } catch (Throwable th) {
                th = th;
                r1 = context;
                f.a((InputStream) r1);
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            inputStreamOpen = null;
            g.b(f4552a, "loadBksCA: exception : " + e.getMessage());
            context = inputStreamOpen;
            f.a((InputStream) context);
            return x509Certificate;
        } catch (RuntimeException e7) {
            e = e7;
            inputStreamOpen = null;
            g.b(f4552a, "loadBksCA: exception : " + e.getMessage());
            context = inputStreamOpen;
            f.a((InputStream) context);
            return x509Certificate;
        } catch (KeyStoreException e8) {
            e = e8;
            inputStreamOpen = null;
            g.b(f4552a, "loadBksCA: exception : " + e.getMessage());
            context = inputStreamOpen;
            f.a((InputStream) context);
            return x509Certificate;
        } catch (NoSuchAlgorithmException e9) {
            e = e9;
            inputStreamOpen = null;
            g.b(f4552a, "loadBksCA: exception : " + e.getMessage());
            context = inputStreamOpen;
            f.a((InputStream) context);
            return x509Certificate;
        } catch (CertificateException e10) {
            e = e10;
            inputStreamOpen = null;
            g.b(f4552a, "loadBksCA: exception : " + e.getMessage());
            context = inputStreamOpen;
            f.a((InputStream) context);
            return x509Certificate;
        } catch (Throwable th2) {
            th = th2;
            f.a((InputStream) r1);
            throw th;
        }
        f.a((InputStream) context);
        return x509Certificate;
    }
}
