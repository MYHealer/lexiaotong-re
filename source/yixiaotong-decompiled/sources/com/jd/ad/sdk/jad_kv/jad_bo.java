package com.jd.ad.sdk.jad_kv;

import android.content.res.AssetManager;
import android.util.Log;
import com.jd.ad.sdk.logger.Logger;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class jad_bo<T> implements jad_dq<T> {
    public final String jad_an;
    public final AssetManager jad_bo;
    public T jad_cp;

    public jad_bo(AssetManager assetManager, String str) {
        this.jad_bo = assetManager;
        this.jad_an = str;
    }

    public abstract T jad_an(AssetManager assetManager, String str);

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    public void jad_an(com.jd.ad.sdk.jad_gr.jad_jt jad_jtVar, jad_dq.jad_an<? super T> jad_anVar) {
        try {
            T tJad_an = jad_an(this.jad_bo, this.jad_an);
            this.jad_cp = tJad_an;
            jad_anVar.jad_an(tJad_an);
        } catch (IOException e) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Logger.d("AssetPathFetcher", "Failed to load data from asset manager", e);
            }
            jad_anVar.jad_an((Exception) e);
        }
    }

    public abstract void jad_an(T t);

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    public void jad_bo() {
        T t = this.jad_cp;
        if (t == null) {
            return;
        }
        try {
            jad_an(t);
        } catch (IOException unused) {
        }
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    public void jad_cp() {
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    public com.jd.ad.sdk.jad_ju.jad_an jad_dq() {
        return com.jd.ad.sdk.jad_ju.jad_an.LOCAL;
    }
}
