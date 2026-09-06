package com.jd.ad.sdk.jad_qz;

import androidx.core.util.Pair;
import com.alipay.sdk.util.i;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.jd.ad.sdk.jad_lu.jad_zm;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_iv<T> {
    public T jad_an;
    public T jad_bo;

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        F f = pair.first;
        Object obj2 = this.jad_an;
        if (f != obj2 && (f == 0 || !f.equals(obj2))) {
            return false;
        }
        S s = pair.second;
        Object obj3 = this.jad_bo;
        return s == obj3 || (s != 0 && s.equals(obj3));
    }

    public int hashCode() {
        T t = this.jad_an;
        int iHashCode = t == null ? 0 : t.hashCode();
        T t2 = this.jad_bo;
        return iHashCode ^ (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        return jad_zm.jad_an("Pair{").append(this.jad_an).append(PPSLabelView.Code).append(this.jad_bo).append(i.d).toString();
    }
}
