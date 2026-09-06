package com.meishu.sdk.core.utils;

import java.io.IOException;

/* JADX INFO: compiled from: SplashLoadImageUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class h1 extends com.meishu.sdk.core.safe.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j1 f4909a;

    /* JADX INFO: compiled from: SplashLoadImageUtil.java */
    public class a extends com.meishu.sdk.core.safe.l {
        public a() {
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            j1.a(h1.this.f4909a, new IOException("timer timeout"));
        }
    }

    public h1(j1 j1Var) {
        this.f4909a = j1Var;
    }

    @Override // com.meishu.sdk.core.safe.n
    public void a() {
        cancel();
        SdkHandler.getInstance().runOnUiThread(new a());
    }
}
