package com.umeng.analytics.pro;

import com.huawei.openalliance.ad.views.PPSLabelView;

/* JADX INFO: compiled from: ShortStack.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class at {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private short[] f9106a;
    private int b = -1;

    public void c() {
        this.b = -1;
    }

    public at(int i) {
        this.f9106a = new short[i];
    }

    public short a() {
        short[] sArr = this.f9106a;
        int i = this.b;
        this.b = i - 1;
        return sArr[i];
    }

    public void a(short s) {
        if (this.f9106a.length == this.b + 1) {
            d();
        }
        short[] sArr = this.f9106a;
        int i = this.b + 1;
        this.b = i;
        sArr[i] = s;
    }

    private void d() {
        short[] sArr = this.f9106a;
        short[] sArr2 = new short[sArr.length * 2];
        System.arraycopy(sArr, 0, sArr2, 0, sArr.length);
        this.f9106a = sArr2;
    }

    public short b() {
        return this.f9106a[this.b];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("<ShortStack vector:[");
        for (int i = 0; i < this.f9106a.length; i++) {
            if (i != 0) {
                sb.append(PPSLabelView.Code);
            }
            if (i == this.b) {
                sb.append(">>");
            }
            sb.append((int) this.f9106a[i]);
            if (i == this.b) {
                sb.append("<<");
            }
        }
        sb.append("]>");
        return sb.toString();
    }
}
