package com.meishu.sdk.core.utils;

/* JADX INFO: compiled from: ThreadSerialManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class m1 extends com.meishu.sdk.core.safe.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n1 f4921a;

    public m1(n1 n1Var) {
        this.f4921a = n1Var;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        while (true) {
            try {
                if (this.f4921a.f4924a.isEmpty()) {
                    this.f4921a.d = false;
                    return;
                }
                this.f4921a.a();
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    return;
                } finally {
                    this.f4921a.d = false;
                }
            }
        }
    }
}
