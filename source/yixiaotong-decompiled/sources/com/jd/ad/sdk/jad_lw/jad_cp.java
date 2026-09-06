package com.jd.ad.sdk.jad_lw;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import com.jd.ad.sdk.jad_gr.jad_jt;
import com.jd.ad.sdk.logger.Logger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_cp implements com.jd.ad.sdk.jad_kv.jad_dq<InputStream> {
    public final Uri jad_an;
    public final jad_er jad_bo;
    public InputStream jad_cp;

    public static class jad_an implements jad_dq {
        public static final String[] jad_bo = {"_data"};
        public final ContentResolver jad_an;

        public jad_an(ContentResolver contentResolver) {
            this.jad_an = contentResolver;
        }

        @Override // com.jd.ad.sdk.jad_lw.jad_dq
        public Cursor jad_an(Uri uri) {
            return this.jad_an.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, jad_bo, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    public static class jad_bo implements jad_dq {
        public static final String[] jad_bo = {"_data"};
        public final ContentResolver jad_an;

        public jad_bo(ContentResolver contentResolver) {
            this.jad_an = contentResolver;
        }

        @Override // com.jd.ad.sdk.jad_lw.jad_dq
        public Cursor jad_an(Uri uri) {
            return this.jad_an.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, jad_bo, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    public jad_cp(Uri uri, jad_er jad_erVar) {
        this.jad_an = uri;
        this.jad_bo = jad_erVar;
    }

    public static jad_cp jad_an(Context context, Uri uri, jad_dq jad_dqVar) {
        com.jd.ad.sdk.jad_ny.jad_bo jad_boVar = com.jd.ad.sdk.jad_gr.jad_cp.jad_an(context).jad_er;
        return new jad_cp(uri, new jad_er(com.jd.ad.sdk.jad_gr.jad_cp.jad_an(context).jad_dq.jad_an(), jad_er.jad_er, jad_dqVar, jad_boVar, context.getContentResolver()));
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    public Class<InputStream> jad_an() {
        return InputStream.class;
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    public void jad_an(jad_jt jad_jtVar, com.jd.ad.sdk.jad_kv.jad_dq.jad_an<? super InputStream> jad_anVar) throws Throwable {
        try {
            InputStream inputStreamJad_er = jad_er();
            this.jad_cp = inputStreamJad_er;
            jad_anVar.jad_an(inputStreamJad_er);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Logger.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e);
            }
            jad_anVar.jad_an((Exception) e);
        }
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    public void jad_bo() {
        InputStream inputStream = this.jad_cp;
        if (inputStream != null) {
            try {
                inputStream.close();
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

    /* JADX WARN: Code duplicated, block: B:23:0x0054 A[PHI: r10
  0x0054: PHI (r10v3 android.database.Cursor) = (r10v2 android.database.Cursor), (r10v8 android.database.Cursor) binds: [B:22:0x0052, B:13:0x002e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:28:0x005f  */
    /* JADX WARN: Code duplicated, block: B:38:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:41:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:60:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:62:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:65:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:76:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:84:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0029: MOVE (r9 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]), block:B:10:0x0029 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v2 */
    public final InputStream jad_er() throws Throwable {
        Cursor cursorJad_an;
        ?? r10;
        String string;
        InputStream inputStreamOpenInputStream;
        int iJad_an;
        Uri uri;
        File file;
        jad_er jad_erVar = this.jad_bo;
        Uri uri2 = this.jad_an;
        jad_erVar.getClass();
        ?? r9 = 0;
        InputStream inputStreamOpenInputStream2 = null;
        try {
            try {
                cursorJad_an = jad_erVar.jad_an.jad_an(uri2);
                if (cursorJad_an != null) {
                    try {
                        if (cursorJad_an.moveToFirst()) {
                            string = cursorJad_an.getString(0);
                            cursorJad_an.close();
                        }
                    } catch (SecurityException e) {
                        e = e;
                        if (Log.isLoggable("ThumbStreamOpener", 3)) {
                            Logger.d("ThumbStreamOpener", "Failed to query for thumbnail for Uri: " + uri2, e);
                        }
                        if (cursorJad_an != null) {
                            cursorJad_an.close();
                        }
                    }
                    if (TextUtils.isEmpty(string)) {
                        inputStreamOpenInputStream = null;
                    } else {
                        file = new File(string);
                        if (file.exists() || 0 >= file.length()) {
                            inputStreamOpenInputStream = null;
                        } else {
                            Uri uriFromFile = Uri.fromFile(file);
                            try {
                                inputStreamOpenInputStream = jad_erVar.jad_cp.openInputStream(uriFromFile);
                            } catch (NullPointerException e2) {
                                throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri2 + " -> " + uriFromFile).initCause(e2));
                            }
                        }
                    }
                    if (inputStreamOpenInputStream != null) {
                        jad_er jad_erVar2 = this.jad_bo;
                        uri = this.jad_an;
                        jad_erVar2.getClass();
                        try {
                            try {
                                inputStreamOpenInputStream2 = jad_erVar2.jad_cp.openInputStream(uri);
                                iJad_an = com.jd.ad.sdk.jad_ju.jad_jt.jad_an(jad_erVar2.jad_dq, inputStreamOpenInputStream2, jad_erVar2.jad_bo);
                                if (inputStreamOpenInputStream2 != null) {
                                    try {
                                        inputStreamOpenInputStream2.close();
                                    } catch (IOException unused) {
                                    }
                                }
                            } catch (Throwable th) {
                                if (0 != 0) {
                                    try {
                                        r9.close();
                                    } catch (IOException unused2) {
                                    }
                                }
                                throw th;
                            }
                        } catch (IOException | NullPointerException e3) {
                            if (Log.isLoggable("ThumbStreamOpener", 3)) {
                                Logger.d("ThumbStreamOpener", "Failed to open uri: " + uri, e3);
                            }
                            if (inputStreamOpenInputStream2 != null) {
                                try {
                                    inputStreamOpenInputStream2.close();
                                } catch (IOException unused3) {
                                }
                            }
                            iJad_an = -1;
                        }
                    } else {
                        iJad_an = -1;
                    }
                    if (iJad_an != -1) {
                        return new com.jd.ad.sdk.jad_kv.jad_jt(inputStreamOpenInputStream, iJad_an);
                    }
                    return inputStreamOpenInputStream;
                }
                if (cursorJad_an != null) {
                    cursorJad_an.close();
                }
            } catch (Throwable th2) {
                th = th2;
                r9 = r10;
                if (r9 != 0) {
                    r9.close();
                }
                throw th;
            }
        } catch (SecurityException e4) {
            e = e4;
            cursorJad_an = null;
        } catch (Throwable th3) {
            th = th3;
            if (r9 != 0) {
                r9.close();
            }
            throw th;
        }
        string = null;
        if (TextUtils.isEmpty(string)) {
            inputStreamOpenInputStream = null;
        } else {
            file = new File(string);
            if (file.exists()) {
                inputStreamOpenInputStream = null;
            } else {
                inputStreamOpenInputStream = null;
            }
        }
        if (inputStreamOpenInputStream != null) {
            jad_er jad_erVar3 = this.jad_bo;
            uri = this.jad_an;
            jad_erVar3.getClass();
            inputStreamOpenInputStream2 = jad_erVar3.jad_cp.openInputStream(uri);
            iJad_an = com.jd.ad.sdk.jad_ju.jad_jt.jad_an(jad_erVar3.jad_dq, inputStreamOpenInputStream2, jad_erVar3.jad_bo);
            if (inputStreamOpenInputStream2 != null) {
                inputStreamOpenInputStream2.close();
            }
        } else {
            iJad_an = -1;
        }
        if (iJad_an != -1) {
            return new com.jd.ad.sdk.jad_kv.jad_jt(inputStreamOpenInputStream, iJad_an);
        }
        return inputStreamOpenInputStream;
    }
}
