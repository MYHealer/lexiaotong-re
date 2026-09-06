package com.adprof.sdk;

import android.location.Location;
import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class u7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v7 f1455a;

    public u7(v7 v7Var) {
        this.f1455a = v7Var;
    }

    public Location a() {
        if (v7.a(this.f1455a) == null || !v7.a(this.f1455a).canReadLocation()) {
            return null;
        }
        return he.m644a().m645a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m719a() {
        return (v7.a(this.f1455a) == null || !v7.a(this.f1455a).canUseAndroidId()) ? "" : he.m644a().m647a();
    }

    public String b() {
        return (v7.a(this.f1455a) == null || TextUtils.isEmpty(v7.a(this.f1455a).getOaid())) ? he.m644a().i() : v7.a(this.f1455a).getOaid();
    }
}
