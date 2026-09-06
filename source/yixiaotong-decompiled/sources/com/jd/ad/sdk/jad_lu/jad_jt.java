package com.jd.ad.sdk.jad_lu;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_jt {
    public Map<String, List<com.jd.ad.sdk.jad_tc.jad_er>> jad_cp;
    public Map<String, jad_na> jad_dq;
    public Map<String, com.jd.ad.sdk.jad_qz.jad_cp> jad_er;
    public List<com.jd.ad.sdk.jad_qz.jad_hu> jad_fs;
    public LongSparseArray<com.jd.ad.sdk.jad_tc.jad_er> jad_hu;
    public List<com.jd.ad.sdk.jad_tc.jad_er> jad_iv;
    public SparseArrayCompat<com.jd.ad.sdk.jad_qz.jad_dq> jad_jt;
    public Rect jad_jw;
    public float jad_kx;
    public float jad_ly;
    public float jad_mz;
    public boolean jad_na;
    public final jad_vi jad_an = new jad_vi();
    public final HashSet<String> jad_bo = new HashSet<>();
    public int jad_ob = 0;

    public float jad_an() {
        return (long) ((jad_bo() / this.jad_mz) * 1000.0f);
    }

    public com.jd.ad.sdk.jad_tc.jad_er jad_an(long j) {
        return this.jad_hu.get(j);
    }

    public void jad_an(String str) {
        com.jd.ad.sdk.jad_xg.jad_dq.jad_an(str);
        this.jad_bo.add(str);
    }

    public float jad_bo() {
        return this.jad_ly - this.jad_kx;
    }

    public com.jd.ad.sdk.jad_qz.jad_hu jad_bo(String str) {
        int size = this.jad_fs.size();
        for (int i = 0; i < size; i++) {
            com.jd.ad.sdk.jad_qz.jad_hu jad_huVar = this.jad_fs.get(i);
            if (!jad_huVar.jad_an.equalsIgnoreCase(str)) {
                if (jad_huVar.jad_an.endsWith("\r")) {
                    String str2 = jad_huVar.jad_an;
                    if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                    }
                }
            }
            return jad_huVar;
        }
        return null;
    }

    public List<com.jd.ad.sdk.jad_tc.jad_er> jad_cp() {
        return this.jad_iv;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator<com.jd.ad.sdk.jad_tc.jad_er> it = this.jad_iv.iterator();
        while (it.hasNext()) {
            sb.append(it.next().jad_an("\t"));
        }
        return sb.toString();
    }
}
