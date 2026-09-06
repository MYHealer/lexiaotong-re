package com.huawei.hms.ads.dynamicloader;

import android.os.Bundle;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class j extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Bundle f3843a;

    public j(String str) {
        super(str);
    }

    public j(String str, Bundle bundle) {
        super(str);
        this.f3843a = bundle;
    }

    private Bundle a() {
        return this.f3843a;
    }
}
