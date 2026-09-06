package com.hihonor.adsdk.common.e.c.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
class b extends a {
    private static final String hnadsq = "b";
    private static final int hnadsr = 2;
    private static final float hnadss = 0.5f;
    private int hnadsn;
    private int hnadso;
    private int hnadsp;

    b() {
    }

    @Override // com.hihonor.adsdk.common.e.c.a.a
    public final int hnadsa() {
        return this.hnadsn;
    }

    @Override // com.hihonor.adsdk.common.e.c.a.a
    public int hnadsb() {
        return this.hnadso;
    }

    @Override // com.hihonor.adsdk.common.e.c.a.a
    public int hnadsc() {
        return this.hnadsn;
    }

    @Override // com.hihonor.adsdk.common.e.c.a.a
    public void hnadsd() {
        int i = this.hnadsi;
        if (i == 0) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsq, "total column is 0", new Object[0]);
            return;
        }
        this.hnadsj = ((this.hnadsa - (this.hnadse * 2)) - (this.hnadsf * (i - 1))) / (i * 1.0f);
        int iHnadsa = (int) (hnadsa(i) + 0.5f);
        this.hnadsp = iHnadsa;
        int i2 = this.hnadsg;
        if (i2 == -2) {
            this.hnadsn = iHnadsa + (this.hnadse * 2);
        } else {
            this.hnadsn = (int) (hnadsa(i2) + 0.5f);
        }
        int i3 = this.hnadsh;
        if (i3 == -2) {
            this.hnadso = this.hnadsp + (this.hnadse * 2);
        } else {
            this.hnadso = (int) (hnadsa(i3) + 0.5f);
        }
        if (this.hnadsk == 15) {
            int i4 = this.hnadsl;
            int i5 = this.hnadsn + i4;
            int i6 = this.hnadsm;
            this.hnadsn = i5 + i6;
            this.hnadso = i4 + this.hnadso + i6;
        }
        String str = hnadsq;
        com.hihonor.adsdk.common.b.b.hnadsc(str, "mWidth:" + this.hnadsa + "mDensity:" + this.hnadsc + "mMargin:" + this.hnadse + "mGutter:" + this.hnadsf + "mColumnCount:" + this.hnadsg + "mMaxColumnCount" + this.hnadsh + "mTotalColumn:" + this.hnadsi + "mColumnWidth:" + this.hnadsj, new Object[0]);
        com.hihonor.adsdk.common.b.b.hnadsa(str, (Object) ("mWidth:" + this.hnadsa + "mDensity:" + this.hnadsc + "mMargin:" + this.hnadse + "mGutter:" + this.hnadsf + "mColumnCount:" + this.hnadsg + "mMaxColumnCount" + this.hnadsh + "mTotalColumn:" + this.hnadsi + "mColumnWidth:" + this.hnadsj));
    }

    public int hnadse() {
        return this.hnadsp;
    }

    @Override // com.hihonor.adsdk.common.e.c.a.a
    public final float hnadsa(int i) {
        return (i * this.hnadsj) + ((i - 1) * this.hnadsf);
    }
}
