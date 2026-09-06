package com.huawei.hms.support.api.client;

import android.os.Bundle;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class BundleResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4397a;
    private Bundle b;

    public BundleResult(int i, Bundle bundle) {
        this.f4397a = i;
        this.b = bundle;
    }

    public int getResultCode() {
        return this.f4397a;
    }

    public Bundle getRspBody() {
        return this.b;
    }

    public void setResultCode(int i) {
        this.f4397a = i;
    }

    public void setRspBody(Bundle bundle) {
        this.b = bundle;
    }
}
