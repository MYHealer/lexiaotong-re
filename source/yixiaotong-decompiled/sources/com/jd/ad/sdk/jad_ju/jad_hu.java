package com.jd.ad.sdk.jad_ju;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface jad_hu {
    public static final Charset jad_an = Charset.forName("UTF-8");

    boolean equals(Object obj);

    int hashCode();

    void jad_an(MessageDigest messageDigest);
}
