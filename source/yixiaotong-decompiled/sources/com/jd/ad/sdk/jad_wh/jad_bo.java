package com.jd.ad.sdk.jad_wh;

import com.jd.ad.sdk.jad_mx.jad_xk;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_bo implements jad_xk<File> {
    public final File jad_an;

    public jad_bo(File file) {
        if (file == null) {
            throw new NullPointerException("Argument must not be null");
        }
        this.jad_an = file;
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_xk
    public final File get() {
        return this.jad_an;
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_xk
    public final /* bridge */ /* synthetic */ int jad_bo() {
        return 1;
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_xk
    public Class<File> jad_cp() {
        return this.jad_an.getClass();
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_xk
    public /* bridge */ /* synthetic */ void jad_dq() {
    }
}
