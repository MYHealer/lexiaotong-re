package com.byazt.cv;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 597, 67})
public class u extends com.byazt.nc.t {
    public String c;
    public int tt;
    public int ve;

    @Override // com.byazt.nc.t
    public double getDuration() {
        return 0.0d;
    }

    @Override // com.byazt.nc.t
    public int getHeight() {
        return this.ve;
    }

    @Override // com.byazt.nc.t
    public int getWidth() {
        return this.tt;
    }

    public u(String str) {
        this.c = str;
    }

    public u(String str, int i, int i2) {
        this.c = str;
        this.tt = i;
        this.ve = i2;
    }

    @Override // com.byazt.nc.t
    public String getImageUrl() {
        return !TextUtils.isEmpty(this.c) ? this.c : "";
    }

    @Override // com.byazt.nc.t
    public boolean isValid() {
        return !TextUtils.isEmpty(this.c);
    }
}
