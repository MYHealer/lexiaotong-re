package com.jd.ad.sdk.jad_ny;

import com.jd.ad.sdk.jad_ny.jad_mz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_hu<K extends jad_mz, V> {
    public final jad_an<K, V> jad_an = new jad_an<>();
    public final Map<K, jad_an<K, V>> jad_bo = new HashMap();

    public static class jad_an<K, V> {
        public final K jad_an;
        public List<V> jad_bo;
        public jad_an<K, V> jad_cp;
        public jad_an<K, V> jad_dq;

        public jad_an() {
            this(null);
        }

        public jad_an(K k) {
            this.jad_dq = this;
            this.jad_cp = this;
            this.jad_an = k;
        }

        public V jad_an() {
            List<V> list = this.jad_bo;
            int size = list != null ? list.size() : 0;
            if (size > 0) {
                return this.jad_bo.remove(size - 1);
            }
            return null;
        }
    }

    public V jad_an(K k) {
        jad_an<K, V> jad_anVar = this.jad_bo.get(k);
        if (jad_anVar == null) {
            jad_anVar = new jad_an<>(k);
            this.jad_bo.put(k, jad_anVar);
        } else {
            k.jad_an();
        }
        jad_an<K, V> jad_anVar2 = jad_anVar.jad_dq;
        jad_anVar2.jad_cp = jad_anVar.jad_cp;
        jad_anVar.jad_cp.jad_dq = jad_anVar2;
        jad_an<K, V> jad_anVar3 = this.jad_an;
        jad_anVar.jad_dq = jad_anVar3;
        jad_an<K, V> jad_anVar4 = jad_anVar3.jad_cp;
        jad_anVar.jad_cp = jad_anVar4;
        jad_anVar4.jad_dq = jad_anVar;
        jad_anVar.jad_dq.jad_cp = jad_anVar;
        return jad_anVar.jad_an();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        jad_an jad_anVar = this.jad_an.jad_cp;
        boolean z = false;
        while (!jad_anVar.equals(this.jad_an)) {
            StringBuilder sbAppend = sb.append('{').append(jad_anVar.jad_an).append(':');
            List<V> list = jad_anVar.jad_bo;
            sbAppend.append(list != null ? list.size() : 0).append("}, ");
            jad_anVar = jad_anVar.jad_cp;
            z = true;
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        return sb.append(" )").toString();
    }

    public void jad_an(K k, V v) {
        jad_an<K, V> jad_anVar = this.jad_bo.get(k);
        if (jad_anVar == null) {
            jad_anVar = new jad_an<>(k);
            jad_an<K, V> jad_anVar2 = jad_anVar.jad_dq;
            jad_anVar2.jad_cp = jad_anVar.jad_cp;
            jad_anVar.jad_cp.jad_dq = jad_anVar2;
            jad_an<K, V> jad_anVar3 = this.jad_an;
            jad_anVar.jad_dq = jad_anVar3.jad_dq;
            jad_anVar.jad_cp = jad_anVar3;
            jad_anVar3.jad_dq = jad_anVar;
            jad_anVar.jad_dq.jad_cp = jad_anVar;
            this.jad_bo.put(k, jad_anVar);
        } else {
            k.jad_an();
        }
        if (jad_anVar.jad_bo == null) {
            jad_anVar.jad_bo = new ArrayList();
        }
        jad_anVar.jad_bo.add(v);
    }

    public V jad_an() {
        for (jad_an jad_anVar = this.jad_an.jad_dq; !jad_anVar.equals(this.jad_an); jad_anVar = jad_anVar.jad_dq) {
            V v = (V) jad_anVar.jad_an();
            if (v != null) {
                return v;
            }
            jad_an<K, V> jad_anVar2 = jad_anVar.jad_dq;
            jad_anVar2.jad_cp = jad_anVar.jad_cp;
            jad_anVar.jad_cp.jad_dq = jad_anVar2;
            this.jad_bo.remove(jad_anVar.jad_an);
            ((jad_mz) jad_anVar.jad_an).jad_an();
        }
        return null;
    }
}
