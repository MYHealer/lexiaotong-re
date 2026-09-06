package com.huawei.hms.activity.internal;

import android.content.Intent;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class BusResponseResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Intent f3792a;
    private int b;

    public int getCode() {
        return this.b;
    }

    public Intent getIntent() {
        return this.f3792a;
    }

    public void setCode(int i) {
        this.b = i;
    }

    public void setIntent(Intent intent) {
        this.f3792a = intent;
    }
}
