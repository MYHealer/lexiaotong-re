package com.jd.ad.sdk.jad_qb;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_kx implements jad_na<Uri, File> {
    public final Context jad_an;

    public static final class jad_an implements jad_ob<Uri, File> {
        public final Context jad_an;

        public jad_an(Context context) {
            this.jad_an = context;
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        public jad_na<Uri, File> jad_an(jad_re jad_reVar) {
            return new jad_kx(this.jad_an);
        }
    }

    public static class jad_bo implements com.jd.ad.sdk.jad_kv.jad_dq<File> {
        public static final String[] jad_cp = {"_data"};
        public final Context jad_an;
        public final Uri jad_bo;

        public jad_bo(Context context, Uri uri) {
            this.jad_an = context;
            this.jad_bo = uri;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public Class<File> jad_an() {
            return File.class;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public void jad_an(com.jd.ad.sdk.jad_gr.jad_jt jad_jtVar, com.jd.ad.sdk.jad_kv.jad_dq.jad_an<? super File> jad_anVar) {
            Cursor cursorQuery = this.jad_an.getContentResolver().query(this.jad_bo, jad_cp, null, null, null);
            String string = null;
            if (cursorQuery != null) {
                try {
                    string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data")) : null;
                    cursorQuery.close();
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            }
            if (TextUtils.isEmpty(string)) {
                jad_anVar.jad_an((Exception) new FileNotFoundException(com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Failed to find file path for: ").append(this.jad_bo).toString()));
            } else {
                jad_anVar.jad_an(new File(string));
            }
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public void jad_bo() {
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public void jad_cp() {
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public com.jd.ad.sdk.jad_ju.jad_an jad_dq() {
            return com.jd.ad.sdk.jad_ju.jad_an.LOCAL;
        }
    }

    public jad_kx(Context context) {
        this.jad_an = context;
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public jad_na.jad_an<File> jad_an(Uri uri, int i, int i2, com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        Uri uri2 = uri;
        return new jad_na.jad_an<>(new com.jd.ad.sdk.jad_hq.jad_bo(uri2), Collections.emptyList(), new jad_bo(this.jad_an, uri2));
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public boolean jad_an(Uri uri) {
        return com.jd.ad.sdk.jad_lw.jad_bo.jad_an(uri);
    }
}
