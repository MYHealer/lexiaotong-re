package com.opos.mobad.service.h;

import com.huawei.openalliance.ad.constant.x;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private StringBuilder f7387a = new StringBuilder();

    public int a() {
        return this.f7387a.length();
    }

    public d a(String str, String str2) {
        if (this.f7387a.length() > 0) {
            this.f7387a.append(";");
        }
        this.f7387a.append(str);
        this.f7387a.append(x.bQ);
        this.f7387a.append(str2);
        return this;
    }

    public String b() {
        return this.f7387a.toString();
    }
}
