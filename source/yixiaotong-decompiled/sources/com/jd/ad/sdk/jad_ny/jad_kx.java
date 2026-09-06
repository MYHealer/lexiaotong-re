package com.jd.ad.sdk.jad_ny;

import android.graphics.Bitmap;
import android.util.Log;
import com.jd.ad.sdk.logger.Logger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_kx implements jad_er {
    public static final Bitmap.Config jad_jw = Bitmap.Config.ARGB_8888;
    public final jad_ly jad_an;
    public final Set<Bitmap.Config> jad_bo;
    public final jad_an jad_cp = new jad_bo();
    public long jad_dq;
    public long jad_er;
    public int jad_fs;
    public int jad_hu;
    public int jad_iv;
    public int jad_jt;

    public interface jad_an {
    }

    public static final class jad_bo implements jad_an {
    }

    public jad_kx(long j, jad_ly jad_lyVar, Set<Bitmap.Config> set) {
        this.jad_dq = j;
        this.jad_an = jad_lyVar;
        this.jad_bo = set;
    }

    public static Set<Bitmap.Config> jad_dq() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        hashSet.add(null);
        hashSet.remove(Bitmap.Config.HARDWARE);
        return Collections.unmodifiableSet(hashSet);
    }

    public static jad_ly jad_er() {
        return new jad_na();
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_er
    public Bitmap jad_an(int i, int i2, Bitmap.Config config) {
        Bitmap bitmapJad_cp = jad_cp(i, i2, config);
        if (bitmapJad_cp != null) {
            bitmapJad_cp.eraseColor(0);
            return bitmapJad_cp;
        }
        if (config == null) {
            config = jad_jw;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_er
    public void jad_an() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Logger.d("LruBitmapPool", "clearMemory");
        }
        jad_an(0L);
    }

    public final synchronized void jad_an(long j) {
        while (this.jad_er > j) {
            Bitmap bitmapJad_an = this.jad_an.jad_an();
            if (bitmapJad_an == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Logger.w("LruBitmapPool", "Size mismatch, resetting");
                    jad_cp();
                }
                this.jad_er = 0L;
                return;
            }
            this.jad_cp.getClass();
            this.jad_er -= (long) this.jad_an.jad_cp(bitmapJad_an);
            this.jad_iv++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Logger.d("LruBitmapPool", com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Evicting bitmap=").append(this.jad_an.jad_bo(bitmapJad_an)).toString());
            }
            jad_bo();
            bitmapJad_an.recycle();
        }
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_er
    public Bitmap jad_bo(int i, int i2, Bitmap.Config config) {
        Bitmap bitmapJad_cp = jad_cp(i, i2, config);
        if (bitmapJad_cp != null) {
            return bitmapJad_cp;
        }
        if (config == null) {
            config = jad_jw;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    public final void jad_bo() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            jad_cp();
        }
    }

    public final synchronized Bitmap jad_cp(int i, int i2, Bitmap.Config config) {
        Bitmap bitmapJad_an;
        if (config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
        bitmapJad_an = this.jad_an.jad_an(i, i2, config != null ? config : jad_jw);
        if (bitmapJad_an == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Logger.d("LruBitmapPool", com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Missing bitmap=").append(this.jad_an.jad_bo(i, i2, config)).toString());
            }
            this.jad_jt++;
        } else {
            this.jad_fs++;
            this.jad_er -= (long) this.jad_an.jad_cp(bitmapJad_an);
            this.jad_cp.getClass();
            bitmapJad_an.setHasAlpha(true);
            bitmapJad_an.setPremultiplied(true);
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Logger.v("LruBitmapPool", com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Get bitmap=").append(this.jad_an.jad_bo(i, i2, config)).toString());
        }
        jad_bo();
        return bitmapJad_an;
    }

    public final void jad_cp() {
        Logger.v("LruBitmapPool", com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Hits=").append(this.jad_fs).append(", misses=").append(this.jad_jt).append(", puts=").append(this.jad_hu).append(", evictions=").append(this.jad_iv).append(", currentSize=").append(this.jad_er).append(", maxSize=").append(this.jad_dq).append("\nStrategy=").append(this.jad_an).toString());
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_er
    public synchronized void jad_an(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            if (bitmap.isMutable() && this.jad_an.jad_cp(bitmap) <= this.jad_dq && this.jad_bo.contains(bitmap.getConfig())) {
                int iJad_cp = this.jad_an.jad_cp(bitmap);
                this.jad_an.jad_an(bitmap);
                this.jad_cp.getClass();
                this.jad_hu++;
                this.jad_er += (long) iJad_cp;
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    Logger.v("LruBitmapPool", com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Put bitmap in pool=").append(this.jad_an.jad_bo(bitmap)).toString());
                }
                jad_bo();
                jad_an(this.jad_dq);
                return;
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Logger.v("LruBitmapPool", com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Reject bitmap from pool, bitmap: ").append(this.jad_an.jad_bo(bitmap)).append(", is mutable: ").append(bitmap.isMutable()).append(", is allowed config: ").append(this.jad_bo.contains(bitmap.getConfig())).toString());
            }
            bitmap.recycle();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_er
    public void jad_an(int i) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Logger.d("LruBitmapPool", "trimMemory, level=" + i);
        }
        if (i >= 40 || i >= 20) {
            jad_an();
        } else if (i >= 20 || i == 15) {
            jad_an(this.jad_dq / 2);
        }
    }
}
