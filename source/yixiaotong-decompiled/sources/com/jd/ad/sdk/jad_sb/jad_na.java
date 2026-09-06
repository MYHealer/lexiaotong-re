package com.jd.ad.sdk.jad_sb;

import android.graphics.PointF;
import com.jd.ad.sdk.jad_lu.jad_zm;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_na {
    public final List<com.jd.ad.sdk.jad_qz.jad_an> jad_an;
    public PointF jad_bo;
    public boolean jad_cp;

    public jad_na() {
        this.jad_an = new ArrayList();
    }

    public jad_na(PointF pointF, boolean z, List<com.jd.ad.sdk.jad_qz.jad_an> list) {
        this.jad_bo = pointF;
        this.jad_cp = z;
        this.jad_an = new ArrayList(list);
    }

    public String toString() {
        return jad_zm.jad_an("ShapeData{numCurves=").append(this.jad_an.size()).append("closed=").append(this.jad_cp).append('}').toString();
    }
}
