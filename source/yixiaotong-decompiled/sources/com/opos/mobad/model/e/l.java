package com.opos.mobad.model.e;

import com.huawei.openalliance.ad.constant.x;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private StringBuilder f7211a = new StringBuilder();

    public l a(String str, int i) {
        this.f7211a.append(str);
        this.f7211a.append(x.bQ);
        this.f7211a.append(i);
        this.f7211a.append(";");
        return this;
    }

    public l a(String str, String str2) {
        this.f7211a.append(str);
        this.f7211a.append(x.bQ);
        this.f7211a.append(str2);
        this.f7211a.append(";");
        return this;
    }

    public String a() {
        return this.f7211a.toString();
    }
}
