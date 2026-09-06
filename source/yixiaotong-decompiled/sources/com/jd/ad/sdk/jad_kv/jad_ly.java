package com.jd.ad.sdk.jad_kv;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.jd.ad.sdk.logger.Logger;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class jad_ly<T> implements jad_dq<T> {
    public final Uri jad_an;
    public final ContentResolver jad_bo;
    public T jad_cp;

    public jad_ly(ContentResolver contentResolver, Uri uri) {
        this.jad_bo = contentResolver;
        this.jad_an = uri;
    }

    public abstract T jad_an(Uri uri, ContentResolver contentResolver);

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    public final void jad_an(com.jd.ad.sdk.jad_gr.jad_jt jad_jtVar, jad_dq.jad_an<? super T> jad_anVar) {
        try {
            T tJad_an = jad_an(this.jad_an, this.jad_bo);
            this.jad_cp = tJad_an;
            jad_anVar.jad_an(tJad_an);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Logger.d("LocalUriFetcher", "Failed to open Uri", e);
            }
            jad_anVar.jad_an((Exception) e);
        }
    }

    public abstract void jad_an(T t);

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    public void jad_bo() {
        T t = this.jad_cp;
        if (t != null) {
            try {
                jad_an(t);
            } catch (IOException unused) {
            }
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
