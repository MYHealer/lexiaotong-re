package com.jd.ad.sdk.jad_zm;

import com.jd.ad.sdk.logger.Logger;
import java.net.URL;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class jad_dq {
    public jad_ly jad_an;
    public jad_an jad_bo;

    public jad_dq(jad_ly jad_lyVar) {
        try {
            this.jad_an = jad_lyVar;
            String protocol = new URL(jad_lyVar.jad_an()).getProtocol();
            if (!jad_bo(protocol)) {
                throw new IllegalArgumentException("Invalid protocol: " + protocol);
            }
            this.jad_bo = jad_an(protocol);
        } catch (Throwable th) {
            Logger.w("Exception while creating base task", th.getMessage());
            throw new com.jd.ad.sdk.jad_do.jad_an(th);
        }
    }

    public final jad_an jad_an(String str) {
        if ("http".equalsIgnoreCase(str)) {
            return new jad_jt();
        }
        if ("https".equalsIgnoreCase(str)) {
            return new jad_iv();
        }
        throw new IllegalArgumentException("Unsupported protocol: " + str);
    }

    public final boolean jad_bo(String str) {
        return "http".equalsIgnoreCase(str) || "https".equalsIgnoreCase(str);
    }
}
