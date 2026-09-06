package com.meishu.sdk.meishu_ad.splash;

import android.app.Activity;
import com.meishu.sdk.core.utils.o1;
import com.meishu.sdk.core.utils.v;

/* JADX INFO: compiled from: SplashPasterMonitor.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class f extends com.meishu.sdk.core.service.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f5086a;
    public final /* synthetic */ v b;

    public f(c cVar, v vVar) {
        this.f5086a = cVar;
        this.b = vVar;
    }

    @Override // com.meishu.sdk.core.service.a, com.meishu.sdk.core.service.e
    public void onActivityResume(Activity activity) {
    }

    @Override // com.meishu.sdk.core.service.e
    public boolean onAppStateUpdate(boolean z) {
        return false;
    }

    @Override // com.meishu.sdk.core.service.a, com.meishu.sdk.core.service.e
    public void onActivityPause(Activity activity) {
        try {
            d dVar = this.f5086a.b;
            v vVar = this.b;
            boolean z = vVar.c;
            boolean z2 = vVar.d;
            if (!dVar.getAppendInfo().getHasClicked().b && !dVar.getAppendInfo().isHasClickedSkip() && !dVar.getAppendInfo().isHasTimeOver() && !z && !z2) {
                o1.a(dVar.getEventUrl(), 25, 0, "");
            }
        } catch (Exception unused) {
        }
    }
}
