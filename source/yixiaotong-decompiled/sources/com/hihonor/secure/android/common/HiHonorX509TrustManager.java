package com.hihonor.secure.android.common;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
@Deprecated
public class HiHonorX509TrustManager extends com.hihonor.secure.android.common.ssl.SecureX509TrustManager {
    @Deprecated
    public HiHonorX509TrustManager(InputStream inputStream, String str) throws NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException {
        super(inputStream, str);
    }
}
