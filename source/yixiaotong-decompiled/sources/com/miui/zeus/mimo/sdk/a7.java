package com.miui.zeus.mimo.sdk;

import com.miui.zeus.mimo.sdk.server.http.Error;
import com.miui.zeus.mimo.sdk.utils.error.MimoAdError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5282a;
    public String b;

    public a7() {
        this.f5282a = -1;
        this.b = "";
    }

    public a7(int i, String str) {
        this.f5282a = i;
        this.b = str;
    }

    public a7(Error error) {
        this.f5282a = -1;
        this.b = "";
        this.f5282a = error.value();
    }

    public a7(MimoAdError mimoAdError) {
        this.f5282a = -1;
        this.b = "";
        this.f5282a = mimoAdError.ERROR_CODE;
        this.b = mimoAdError.ERROR_MSG;
    }
}
