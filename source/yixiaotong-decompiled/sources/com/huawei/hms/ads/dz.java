package com.huawei.hms.ads;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
class dz {
    int Code;
    int I;
    Bitmap V;

    dz() {
    }

    dz(int i, Bitmap bitmap, int i2) {
        this.Code = i;
        this.V = bitmap;
        this.I = i2;
    }

    dz Code() {
        dz dzVar = new dz();
        dzVar.Code = this.Code;
        dzVar.I = this.I;
        return dzVar;
    }

    public String toString() {
        return "GifFrame{frameIndex=" + this.Code + ", delay=" + this.I + '}';
    }
}
