package com.adprof.sdk;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class v1 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w1 f1469a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ boolean f762a;

    public v1(w1 w1Var, boolean z) {
        this.f1469a = w1Var;
        this.f762a = z;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        if (!((Boolean) obj).booleanValue()) {
            this.f1469a.f791a = false;
            this.f1469a.f789a = null;
        } else if (this.f762a) {
            in.a().a(new u1(this));
        }
        return null;
    }
}
