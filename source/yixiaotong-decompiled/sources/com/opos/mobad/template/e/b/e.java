package com.opos.mobad.template.e.b;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e extends a {
    public final int k;
    public final int l;

    public e(com.opos.mobad.template.d.b bVar) {
        super(bVar);
        if (bVar == null) {
            this.k = -1;
            this.l = -1;
            return;
        }
        int iMax = Math.max(bVar.D, e);
        this.k = iMax;
        int iMax2 = Math.max(bVar.E, f);
        this.l = iMax2;
        com.opos.cmn.an.f.a.b("ShakeInteractiveInfo", "shakeTime: " + iMax + ",shakeDiff: " + iMax2);
    }
}
