package com.meishu.sdk.meishu_ad.splash;

import android.view.View;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.v;

/* JADX INFO: compiled from: SplashPasterMonitor.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class g implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.meishu.sdk.core.service.e f5087a;
    public final /* synthetic */ v b;

    public g(com.meishu.sdk.core.service.e eVar, v vVar) {
        this.f5087a = eVar;
        this.b = vVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        LogUtil.dev("SPM", "adRoot detached");
        com.meishu.sdk.core.service.d.b(this.f5087a);
        v vVar = this.b;
        vVar.getClass();
        try {
            if (vVar.e) {
                AdSdk.getContext().unregisterReceiver(vVar.b);
            }
        } catch (Throwable th) {
            LogUtil.dev("HW", th);
        }
    }
}
