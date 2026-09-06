package com.jd.ad.sdk.jad_hk;

import java.io.InputStream;
import java.util.logging.Logger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_er {
    static {
        Logger.getLogger(jad_er.class.getName());
    }

    public static jad_mz jad_an(InputStream inputStream) {
        jad_na jad_naVar = new jad_na();
        if (inputStream != null) {
            return new jad_dq(jad_naVar, inputStream);
        }
        throw new IllegalArgumentException("in == null");
    }
}
