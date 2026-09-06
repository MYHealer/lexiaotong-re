package com.meishu.sdk.core.utils;

/* JADX INFO: compiled from: OpenAppDialogStateChecker.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class m0 extends com.meishu.sdk.core.safe.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l0 f4920a;

    public m0(l0 l0Var) {
        this.f4920a = l0Var;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        super.safeRun();
        if (com.meishu.sdk.core.service.d.a()) {
            LogUtil.dev("OpenAppDialogStateChecker", "dialog state 3");
            this.f4920a.f = Boolean.FALSE;
        } else {
            LogUtil.dev("OpenAppDialogStateChecker", "dialog state 5");
            this.f4920a.f = Boolean.TRUE;
        }
        l0 l0Var = this.f4920a;
        l0.a(l0Var, l0Var.f.booleanValue());
    }
}
