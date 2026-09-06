package com.jd.ad.sdk.jad_hk;

import android.support.v4.media.session.PlaybackStateCompat;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_kx {
    public static jad_jw jad_an;
    public static long jad_bo;

    public static jad_jw jad_an() {
        synchronized (jad_kx.class) {
            jad_jw jad_jwVar = jad_an;
            if (jad_jwVar == null) {
                return new jad_jw();
            }
            jad_an = jad_jwVar.jad_fs;
            jad_jwVar.jad_fs = null;
            jad_bo -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            return jad_jwVar;
        }
    }

    public static void jad_an(jad_jw jad_jwVar) {
        if (jad_jwVar.jad_fs != null || jad_jwVar.jad_jt != null) {
            throw new IllegalArgumentException();
        }
        if (jad_jwVar.jad_dq) {
            return;
        }
        synchronized (jad_kx.class) {
            long j = jad_bo + PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            if (j > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                return;
            }
            jad_bo = j;
            jad_jwVar.jad_fs = jad_an;
            jad_jwVar.jad_cp = 0;
            jad_jwVar.jad_bo = 0;
            jad_an = jad_jwVar;
        }
    }
}
