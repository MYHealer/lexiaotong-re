package com.hihonor.secure.android.common.ssl;

import android.content.Context;
import com.hihonor.secure.android.common.ssl.util.BksUtil;
import com.hihonor.secure.android.common.ssl.util.f;
import com.hihonor.secure.android.common.ssl.util.g;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class SecureX509TrustManager implements X509TrustManager {
    public static final String A = "rootcas.bks";
    private static final String B = "";
    private static final String C = "X509";
    private static final String D = "bks";
    private static final String E = "AndroidCAStore";
    private static final String TAG = "SecureX509TrustManager";
    protected List<X509TrustManager> F;
    private X509Certificate[] G;

    public X509Certificate[] getChain() {
        return this.G;
    }

    public List<X509TrustManager> getX509TrustManagers() {
        return this.F;
    }

    public void setChain(X509Certificate[] x509CertificateArr) {
        this.G = x509CertificateArr;
    }

    public void setX509TrustManagers(List<X509TrustManager> list) {
        this.F = list;
    }

    public SecureX509TrustManager(Context context) throws NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, IllegalArgumentException {
        this(context, false);
    }

    public SecureX509TrustManager(Context context, boolean z) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException, IllegalArgumentException {
        this.F = new ArrayList();
        if (context == null) {
            throw new IllegalArgumentException("context is null");
        }
        com.hihonor.secure.android.common.ssl.util.c.setContext(context);
        if (z) {
            a();
        }
        a(context);
        if (this.F.isEmpty()) {
            throw new CertificateException("X509TrustManager is empty");
        }
    }

    public SecureX509TrustManager(InputStream inputStream, String str) throws IllegalArgumentException {
        this.F = new ArrayList();
        a(inputStream, str);
    }

    public SecureX509TrustManager(String str) throws IllegalArgumentException, FileNotFoundException {
        this(str, false);
    }

    public SecureX509TrustManager(String str, boolean z) throws Throwable {
        this.F = new ArrayList();
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                a(fileInputStream2, "");
                f.c(fileInputStream2);
                if (z) {
                    a();
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                f.c(fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public SecureX509TrustManager(InputStream inputStream, String str, boolean z) throws IllegalArgumentException {
        this.F = new ArrayList();
        a(inputStream, str);
        if (z) {
            a();
        }
    }

    private void a() {
        g.c(TAG, "loadSystemCA");
        try {
            KeyStore keyStore = KeyStore.getInstance(E);
            keyStore.load(null, null);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(C);
            trustManagerFactory.init(keyStore);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            for (byte b = 0; b < trustManagers.length; b = (byte) (b + 1)) {
                TrustManager trustManager = trustManagers[b];
                if (trustManager instanceof X509TrustManager) {
                    this.F.add((X509TrustManager) trustManager);
                }
            }
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
            g.e(TAG, "loadSystemCA: exception : " + e.getMessage());
        }
    }

    private void a(Context context) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        String str = TAG;
        g.c(str, "loadBksCA");
        InputStream filesBksIS = BksUtil.getFilesBksIS(context);
        if (filesBksIS != null) {
            try {
                g.c(str, " get bks not from assets");
                a(filesBksIS);
            } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
                g.e(TAG, "loadBksCA: exception : " + e.getMessage());
            }
        }
        if (filesBksIS != null) {
            return;
        }
        g.c(TAG, " get bks from assets ");
        a(context.getAssets().open(A));
    }

    private void a(InputStream inputStream) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(C);
            KeyStore keyStore = KeyStore.getInstance("bks");
            keyStore.load(inputStream, "".toCharArray());
            trustManagerFactory.init(keyStore);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            for (byte b = 0; b < trustManagers.length; b = (byte) (b + 1)) {
                TrustManager trustManager = trustManagers[b];
                if (trustManager instanceof X509TrustManager) {
                    this.F.add((X509TrustManager) trustManager);
                }
            }
            f.c(inputStream);
        } catch (Throwable th) {
            f.c(inputStream);
            throw th;
        }
    }

    private void a(InputStream inputStream, String str) {
        if (inputStream != null) {
            try {
                if (str != null) {
                    try {
                        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(C);
                        KeyStore keyStore = KeyStore.getInstance("bks");
                        keyStore.load(inputStream, str.toCharArray());
                        trustManagerFactory.init(keyStore);
                        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                        for (byte b = 0; b < trustManagers.length; b = (byte) (b + 1)) {
                            TrustManager trustManager = trustManagers[b];
                            if (trustManager instanceof X509TrustManager) {
                                this.F.add((X509TrustManager) trustManager);
                            }
                        }
                    } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
                        g.e(TAG, "loadInputStream: exception : " + e.getMessage());
                    }
                    return;
                }
            } finally {
                f.c(inputStream);
            }
        }
        throw new IllegalArgumentException("inputstream or trustPwd is null");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        g.c(TAG, "checkClientTrusted: ");
        Iterator<X509TrustManager> it = this.F.iterator();
        while (it.hasNext()) {
            try {
                it.next().checkServerTrusted(x509CertificateArr, str);
                return;
            } catch (CertificateException e) {
                g.e(TAG, "checkServerTrusted CertificateException" + e.getMessage());
            }
        }
        throw new CertificateException("checkServerTrusted CertificateException");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        setChain(x509CertificateArr);
        g.c(TAG, "checkServerTrusted begin ,server ca chain size is : " + x509CertificateArr.length + " ,auth type is : " + str);
        for (X509Certificate x509Certificate : x509CertificateArr) {
            String str2 = TAG;
            g.b(str2, "server ca chain: getSubjectDN is :" + x509Certificate.getSubjectDN() + " , getIssuerDN :" + x509Certificate.getIssuerDN());
            g.b(str2, "server ca chain is :" + x509Certificate);
        }
        int size = this.F.size();
        for (byte b = 0; b < size; b = (byte) (b + 1)) {
            try {
                String str3 = TAG;
                g.c(str3, "check server i : " + ((int) b));
                X509TrustManager x509TrustManager = this.F.get(b);
                X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
                if (acceptedIssuers != null) {
                    g.c(str3, "client root ca size is : " + acceptedIssuers.length);
                    for (byte b2 = 0; b2 < acceptedIssuers.length; b2 = (byte) (b2 + 1)) {
                        g.b(TAG, "client root ca getIssuerDN :" + acceptedIssuers[b2].getIssuerDN());
                    }
                }
                x509TrustManager.checkServerTrusted(x509CertificateArr, str);
                g.c(TAG, "checkServerTrusted succeed ,root ca issuer is : " + x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN());
                return;
            } catch (CertificateException e) {
                String str4 = TAG;
                g.e(str4, "checkServerTrusted error :" + e.getMessage() + " , time : " + ((int) b));
                if (b == size - 1) {
                    if (x509CertificateArr != null && x509CertificateArr.length > 0) {
                        g.e(str4, "root ca issuer : " + x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN());
                    }
                    throw e;
                }
            }
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<X509TrustManager> it = this.F.iterator();
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
