package com.byazt.lr;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.byazt.gq.t;
import com.byazt.hs.i;
import com.byazt.hu.u;
import com.byazt.nr.m;
import java.io.BufferedInputStream;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 155, 15})
public class uj extends com.byazt.w.x<Long, Bitmap> {
    public final Map<Long, SoftReference<c>> c;

    public interface c {
        void c(Bitmap bitmap);
    }

    @com.byazt.zqa.c(c = {0, 1, 155, 153})
    private static class tt {
        public static uj c = new uj();
    }

    public static uj c() {
        return tt.c;
    }

    private uj() {
        super(8, 8);
        this.c = new HashMap();
    }

    public void c(long j, c cVar) {
        if (get(Long.valueOf(j)) != null) {
            cVar.c((Bitmap) get(Long.valueOf(j)));
        } else {
            this.c.put(Long.valueOf(j), new SoftReference<>(cVar));
        }
    }

    public void c(final long j, final long j2, final String str) {
        if (get(Long.valueOf(j)) != null) {
            SoftReference<c> softReferenceRemove = this.c.remove(Long.valueOf(j));
            if (softReferenceRemove == null || softReferenceRemove.get() == null) {
                return;
            }
            softReferenceRemove.get().c((Bitmap) get(Long.valueOf(j)));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            sp.c(12, j2);
        } else {
            com.byazt.hu.ve.c((com.byazt.hu.ve.c<Object, R>) new com.byazt.hu.ve.c<Object, Object>() { // from class: com.byazt.lr.uj.2
                @Override // com.byazt.hu.ve.c
                public Object c(Object obj) throws Throwable {
                    BufferedInputStream bufferedInputStream;
                    Throwable th;
                    try {
                        i iVarC = com.byazt.zz.ve.c(true, 0, str, null);
                        if (iVarC != null) {
                            bufferedInputStream = new BufferedInputStream(iVarC.c());
                            try {
                                try {
                                    bufferedInputStream.mark(bufferedInputStream.available());
                                    BitmapFactory.Options options = new BitmapFactory.Options();
                                    options.inJustDecodeBounds = true;
                                    BitmapFactory.decodeStream(bufferedInputStream, null, options);
                                    int i = options.outWidth;
                                    int i2 = options.outHeight;
                                    int iC = u.c(t.getContext(), 60.0f);
                                    options.inSampleSize = uj.tt(iC, iC, options);
                                    options.inJustDecodeBounds = false;
                                    bufferedInputStream.reset();
                                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, options);
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.putOpt("ttdownloader_type", "load_bitmap");
                                        jSONObject.putOpt("bm_original_w", Integer.valueOf(i));
                                        jSONObject.putOpt("bm_original_h", Integer.valueOf(i2));
                                        jSONObject.putOpt("bm_bytes", Integer.valueOf(bitmapDecodeStream == null ? -1 : bitmapDecodeStream.getByteCount()));
                                    } catch (Exception e) {
                                        m.c(e);
                                    }
                                    com.byazt.zn.c.c().c("ttd_pref_monitor", jSONObject, j2);
                                    uj.this.put(Long.valueOf(j), bitmapDecodeStream);
                                    com.byazt.w.a.c(bufferedInputStream);
                                } catch (Exception e2) {
                                    e = e2;
                                    com.byazt.dm.ve.c().c(e, "BitmapCache loadBitmap");
                                    com.byazt.w.a.c(bufferedInputStream);
                                }
                                return null;
                            } catch (Throwable th2) {
                                th = th2;
                                com.byazt.w.a.c(bufferedInputStream);
                                throw th;
                            }
                        }
                        com.byazt.w.a.c(null);
                        return null;
                    } catch (Exception e3) {
                        e = e3;
                        bufferedInputStream = null;
                    } catch (Throwable th3) {
                        bufferedInputStream = null;
                        th = th3;
                        com.byazt.w.a.c(bufferedInputStream);
                        throw th;
                    }
                    com.byazt.dm.ve.c().c(e, "BitmapCache loadBitmap");
                    com.byazt.w.a.c(bufferedInputStream);
                    return null;
                }
            }, (Object) null).c(new com.byazt.hu.ve.c<Object, Object>() { // from class: com.byazt.lr.uj.1
                @Override // com.byazt.hu.ve.c
                public Object c(Object obj) {
                    SoftReference softReference = (SoftReference) uj.this.c.remove(Long.valueOf(j));
                    if (softReference == null || softReference.get() == null) {
                        return null;
                    }
                    ((c) softReference.get()).c((Bitmap) uj.this.get(Long.valueOf(j)));
                    return null;
                }
            }).c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int tt(int i, int i2, BitmapFactory.Options options) {
        if (options.outWidth > i || options.outHeight > i2) {
            return Math.min(Math.round(options.outWidth / i), Math.round(options.outHeight / i2));
        }
        return 1;
    }
}
