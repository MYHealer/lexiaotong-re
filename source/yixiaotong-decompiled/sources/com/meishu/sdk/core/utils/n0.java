package com.meishu.sdk.core.utils;

import android.app.Activity;

/* JADX INFO: compiled from: OpenDeepLinkUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class n0 extends com.meishu.sdk.core.service.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f4923a;

    public n0(boolean z) {
        this.f4923a = z;
    }

    @Override // com.meishu.sdk.core.service.a, com.meishu.sdk.core.service.e
    public void onActivityPause(Activity activity) {
    }

    @Override // com.meishu.sdk.core.service.a, com.meishu.sdk.core.service.e
    public void onActivityResume(Activity activity) {
        o0.a(this.f4923a);
        com.meishu.sdk.core.service.d.b(this);
    }

    @Override // com.meishu.sdk.core.service.e
    public boolean onAppStateUpdate(boolean z) {
        return true;
    }
}
