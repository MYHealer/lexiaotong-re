package com.meishu.sdk.meishu_ad.splash;

import android.app.Activity;
import com.meishu.sdk.R;
import com.meishu.sdk.core.webview.q;
import com.meishu.sdk.core.webview.s;
import com.meishu.sdk.meishu_ad.view.ViewContainer;

/* JADX INFO: compiled from: SplashTempUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class l {
    public static final /* synthetic */ int f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewContainer f5092a;
    public s b;
    public MeishuSplashRootView c;
    public Activity d;
    public com.meishu.sdk.core.service.e e;

    /* JADX INFO: compiled from: SplashTempUtil.java */
    public interface a {
        void a(boolean z);
    }

    /* JADX INFO: compiled from: SplashTempUtil.java */
    public interface b {
    }

    public static void a(l lVar, MeishuSplashRootView meishuSplashRootView) {
        lVar.getClass();
        com.meishu.sdk.core.bquery.i iVar = new com.meishu.sdk.core.bquery.i(meishuSplashRootView);
        iVar.b(R.id.ms_img_meishu_ad_tag).d(8);
        iVar.b(R.id.ms_download_layer_textview).d(8);
        iVar.b(R.id.ms_shakeRoot).d(8);
    }

    public void a(final a aVar) {
        com.meishu.sdk.core.webview.b bVar;
        try {
            s sVar = this.b;
            if (sVar != null && (bVar = sVar.d) != null) {
                bVar.a(new com.meishu.sdk.core.webview.b.InterfaceC0822b() { // from class: com.meishu.sdk.meishu_ad.splash.l$$ExternalSyntheticLambda0
                    @Override // com.meishu.sdk.core.webview.b.InterfaceC0822b
                    public final void a(boolean z, int i) {
                        this.f$0.a(aVar, z, i);
                    }
                });
                return;
            }
            if (aVar != null) {
                aVar.a(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (aVar != null) {
                aVar.a(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(a aVar, boolean z, int i) {
        if (!z) {
            a();
        }
        if (aVar != null) {
            aVar.a(z);
        }
    }

    public final void a() {
        try {
            com.meishu.sdk.core.service.e eVar = this.e;
            if (eVar != null) {
                com.meishu.sdk.core.service.d.b(eVar);
                this.e = null;
                this.d = null;
            }
            s sVar = this.b;
            if (sVar != null) {
                q.a(sVar.f4993a);
                this.b = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
