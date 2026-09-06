package com.hihonor.secure.android.common.ssl;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class HiHonorX509TrustManager extends SecureX509TrustManager {
    public HiHonorX509TrustManager(InputStream inputStream, String str) throws NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, IllegalArgumentException {
        super(inputStream, str);
    }
}
