package com.meishu.sdk.meishu_ad.splash;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.kuaishou.weapon.p0.t;
import com.meishu.sdk.R;
import com.meishu.sdk.core.ad.BaseAdSlot;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.meishu_ad.view.ViewContainer;
import java.util.Map;

/* JADX INFO: compiled from: SplashTempUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class i extends com.meishu.sdk.core.safe.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f5089a;
    public final /* synthetic */ l b;

    public i(l lVar, c cVar) {
        this.b = lVar;
        this.f5089a = cVar;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        try {
            l lVar = this.b;
            MeishuSplashRootView meishuSplashRootView = lVar.c;
            lVar.f5092a = meishuSplashRootView != null ? (ViewContainer) meishuSplashRootView.findViewById(R.id.ms_webview_container) : null;
            l lVar2 = this.b;
            ViewContainer viewContainer = lVar2.f5092a;
            if (viewContainer == null) {
                lVar2.a();
                return;
            }
            if (Boolean.FALSE.equals(viewContainer.b)) {
                int i = l.f;
                LogUtil.dev(t.d, "View has been removed");
                this.b.a();
                return;
            }
            l lVar3 = this.b;
            lVar3.f5092a.addView(lVar3.b.f4993a, new ViewGroup.LayoutParams(-1, -1));
            this.b.f5092a.setVisibility(0);
            c cVar = this.f5089a;
            Map<Integer, Integer> map = com.meishu.sdk.core.utils.h.f4907a;
            if (cVar != null) {
                try {
                    if (cVar.a() != null) {
                        BaseAdSlot baseAdSlot = cVar.a() instanceof BaseAdSlot ? (BaseAdSlot) cVar.a() : null;
                        if (baseAdSlot != null) {
                            baseAdSlot.getAppendInfo().getClickExtInfo().setWebTempId(baseAdSlot.getWebTempId(), true);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            l lVar4 = this.b;
            ViewContainer viewContainer2 = lVar4.f5092a;
            if (viewContainer2 != null) {
                viewContainer2.setWindowEventListener(new k(lVar4));
            }
            l lVar5 = this.b;
            l.a(lVar5, lVar5.c);
            l lVar6 = this.b;
            Context context = lVar6.f5092a.getContext();
            lVar6.getClass();
            if (context instanceof Activity) {
                lVar6.d = (Activity) context;
                j jVar = new j(lVar6);
                lVar6.e = jVar;
                com.meishu.sdk.core.service.d.a(jVar);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
