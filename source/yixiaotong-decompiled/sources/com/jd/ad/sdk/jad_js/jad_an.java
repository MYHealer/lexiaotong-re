package com.jd.ad.sdk.jad_js;

import android.util.Log;
import androidx.core.util.Pools;
import com.jd.ad.sdk.jad_gr.jad_ly;
import com.jd.ad.sdk.logger.Logger;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_an {
    public static final jad_er<Object> jad_an = new C0557jad_an();

    /* JADX INFO: renamed from: com.jd.ad.sdk.jad_js.jad_an$jad_an, reason: collision with other inner class name */
    public class C0557jad_an implements jad_er<Object> {
        @Override // com.jd.ad.sdk.jad_js.jad_an.jad_er
        public void jad_an(Object obj) {
        }
    }

    public interface jad_bo<T> {
        T jad_an();
    }

    public static final class jad_cp<T> implements Pools.Pool<T> {
        public final jad_bo<T> jad_an;
        public final jad_er<T> jad_bo;
        public final Pools.Pool<T> jad_cp;

        public jad_cp(Pools.Pool<T> pool, jad_bo<T> jad_boVar, jad_er<T> jad_erVar) {
            this.jad_cp = pool;
            this.jad_an = jad_boVar;
            this.jad_bo = jad_erVar;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            T tAcquire = this.jad_cp.acquire();
            if (tAcquire == null) {
                tAcquire = this.jad_an.jad_an();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Logger.v("FactoryPools", jad_ly.jad_an("Created new ").append(tAcquire.getClass()).toString());
                }
            }
            if (tAcquire instanceof jad_dq) {
                ((com.jd.ad.sdk.jad_js.jad_dq.jad_bo) ((jad_dq) tAcquire).jad_an()).jad_an = false;
            }
            return tAcquire;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(T t) {
            if (t instanceof jad_dq) {
                ((com.jd.ad.sdk.jad_js.jad_dq.jad_bo) ((jad_dq) t).jad_an()).jad_an = true;
            }
            this.jad_bo.jad_an(t);
            return this.jad_cp.release(t);
        }
    }

    public interface jad_dq {
        com.jd.ad.sdk.jad_js.jad_dq jad_an();
    }

    public interface jad_er<T> {
        void jad_an(T t);
    }

    public static <T extends jad_dq> Pools.Pool<T> jad_an(int i, jad_bo<T> jad_boVar) {
        return new jad_cp(new Pools.SynchronizedPool(i), jad_boVar, jad_an);
    }

    public static <T> Pools.Pool<List<T>> jad_an() {
        return new jad_cp(new Pools.SynchronizedPool(20), new com.jd.ad.sdk.jad_js.jad_bo(), new com.jd.ad.sdk.jad_js.jad_cp());
    }
}
