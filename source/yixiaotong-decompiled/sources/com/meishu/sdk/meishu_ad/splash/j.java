package com.meishu.sdk.meishu_ad.splash;

import android.app.Activity;
import com.meishu.sdk.core.webview.s;
import com.meishu.sdk.meishu_ad.view.ViewContainer;

/* JADX INFO: compiled from: SplashTempUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class j extends com.meishu.sdk.core.service.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f5090a;

    public j(l lVar) {
        this.f5090a = lVar;
    }

    @Override // com.meishu.sdk.core.service.e
    public boolean onAppStateUpdate(boolean z) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a() {
        ViewContainer viewContainer = this.f5090a.f5092a;
        if (viewContainer != null) {
            viewContainer.setVisibility(0);
        }
    }

    @Override // com.meishu.sdk.core.service.a, com.meishu.sdk.core.service.e
    public void onActivityPause(Activity activity) {
        ViewContainer viewContainer;
        l lVar = this.f5090a;
        if (activity != lVar.d || (viewContainer = lVar.f5092a) == null) {
            return;
        }
        viewContainer.setVisibility(4);
    }

    @Override // com.meishu.sdk.core.service.a, com.meishu.sdk.core.service.e
    public void onActivityResume(Activity activity) {
        s sVar;
        l lVar = this.f5090a;
        if (activity != lVar.d || lVar.f5092a == null || (sVar = lVar.b) == null) {
            return;
        }
        try {
            sVar.f4993a.post(new Runnable() { // from class: com.meishu.sdk.meishu_ad.splash.j$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
