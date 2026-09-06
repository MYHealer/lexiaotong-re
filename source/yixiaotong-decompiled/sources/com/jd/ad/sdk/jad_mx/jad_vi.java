package com.jd.ad.sdk.jad_mx;

import androidx.core.util.Pools;
import com.alipay.sdk.util.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_vi<Data, ResourceType, Transcode> {
    public final Pools.Pool<List<Throwable>> jad_an;
    public final List<? extends jad_kx<Data, ResourceType, Transcode>> jad_bo;
    public final String jad_cp;

    public jad_vi(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<jad_kx<Data, ResourceType, Transcode>> list, Pools.Pool<List<Throwable>> pool) {
        this.jad_an = pool;
        this.jad_bo = (List) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(list);
        this.jad_cp = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Failed LoadPath{").append(cls.getSimpleName()).append("->").append(cls2.getSimpleName()).append("->").append(cls3.getSimpleName()).append(i.d).toString();
    }

    public jad_xk<Transcode> jad_an(com.jd.ad.sdk.jad_kv.jad_er<Data> jad_erVar, com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar, int i, int i2, jad_kx.jad_an<ResourceType> jad_anVar) {
        List<Throwable> list = (List) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(this.jad_an.acquire());
        try {
            int size = this.jad_bo.size();
            jad_xk<Transcode> jad_xkVarJad_an = null;
            for (int i3 = 0; i3 < size; i3++) {
                try {
                    jad_xkVarJad_an = this.jad_bo.get(i3).jad_an(jad_erVar, i, i2, jad_jwVar, jad_anVar);
                } catch (jad_sf e) {
                    list.add(e);
                }
                if (jad_xkVarJad_an != null) {
                    break;
                }
            }
            if (jad_xkVarJad_an == null) {
                throw new jad_sf(this.jad_cp, new ArrayList(list));
            }
            this.jad_an.release(list);
            return jad_xkVarJad_an;
        } catch (Throwable th) {
            this.jad_an.release(list);
            throw th;
        }
    }

    public String toString() {
        return com.jd.ad.sdk.jad_gr.jad_ly.jad_an("LoadPath{decodePaths=").append(Arrays.toString(this.jad_bo.toArray())).append('}').toString();
    }
}
