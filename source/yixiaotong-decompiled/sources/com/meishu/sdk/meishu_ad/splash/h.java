package com.meishu.sdk.meishu_ad.splash;

import android.content.Context;
import com.kuaishou.weapon.p0.t;
import com.meishu.sdk.R;
import com.meishu.sdk.core.ad.AdType;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.SdkHandler;
import com.meishu.sdk.core.utils.m;
import com.meishu.sdk.core.utils.u;
import com.meishu.sdk.core.utils.x0;
import com.meishu.sdk.core.view.TouchPositionListener;
import com.meishu.sdk.core.webview.jsbridge.bean.ClickTempParam;
import com.meishu.sdk.core.webview.jsbridge.bean.GetDeviceInfoResBean;
import com.meishu.sdk.core.webview.s;
import com.meishu.sdk.meishu_ad.g0;
import com.meishu.sdk.meishu_ad.v;
import java.sql.Timestamp;

/* JADX INFO: compiled from: SplashTempUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class h extends com.meishu.sdk.core.webview.listener.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f5088a;
    public final /* synthetic */ d b;
    public final /* synthetic */ MeishuSplashRootView c;
    public final /* synthetic */ c d;
    public final /* synthetic */ l.b e;
    public final /* synthetic */ l f;

    public h(l lVar, Context context, d dVar, MeishuSplashRootView meishuSplashRootView, c cVar, l.b bVar) {
        this.f = lVar;
        this.f5088a = context;
        this.b = dVar;
        this.c = meishuSplashRootView;
        this.d = cVar;
        this.e = bVar;
    }

    @Override // com.meishu.sdk.core.webview.listener.b, com.meishu.sdk.core.webview.listener.d
    public void onWebClicked(ClickTempParam clickTempParam) {
        try {
            TouchPositionListener.TouchPosition touchPosition = this.d.getTouchData().getTouchPosition();
            if (touchPosition == null) {
                touchPosition = new TouchPositionListener.TouchPosition();
                this.d.getTouchData().setTouchPosition(touchPosition);
            }
            touchPosition.setDownTime(new Timestamp(clickTempParam.getMsec()));
            touchPosition.setDownX((int) m.a(this.f5088a, clickTempParam.getDown_x()));
            touchPosition.setDownY((int) m.a(this.f5088a, clickTempParam.getDown_y()));
            touchPosition.setUpTime(new Timestamp(clickTempParam.getUp_msec()));
            touchPosition.setUpX((int) m.a(this.f5088a, clickTempParam.getUp_x()));
            touchPosition.setUpY((int) m.a(this.f5088a, clickTempParam.getUp_y()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        l.b bVar = this.e;
        if (bVar != null) {
            int act_type = clickTempParam.getAct_type();
            g0 g0Var = (g0) bVar;
            g0Var.getClass();
            try {
                if (((com.meishu.sdk.platform.ms.splash.g) g0Var.f5015a).e) {
                    if (g0Var.b.getInteractionListener() != null && g0Var.b.b.getCbc() == 0) {
                        g0Var.b.getInteractionListener().onAdClicked();
                    }
                    a aVar = g0Var.f5015a;
                    if (aVar != null) {
                        ((com.meishu.sdk.platform.ms.splash.g) aVar).h = true;
                    }
                    g0Var.b.b.setClkActType(act_type);
                    com.meishu.sdk.core.utils.f.a((com.meishu.sdk.platform.ms.c) g0Var.b, true);
                    v vVar = g0Var.c;
                    MeishuSplashRootView meishuSplashRootView = vVar.q;
                    v.a(vVar, meishuSplashRootView != null ? (SplashSkipView) meishuSplashRootView.findViewById(R.id.ms_skipView) : null);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.meishu.sdk.core.webview.listener.b, com.meishu.sdk.core.webview.listener.d
    public void onWebReady(boolean z) {
        com.meishu.sdk.core.webview.b bVar;
        int i = l.f;
        LogUtil.dev(t.d, "onWebReady:" + z);
        s sVar = this.f.b;
        if (sVar != null && (bVar = sVar.d) != null && bVar.f == 3) {
            LogUtil.dev(t.d, "onWebReady timeOut return");
            this.f.a();
        } else {
            if (!z) {
                this.f.a();
                return;
            }
            l lVar = this.f;
            c cVar = this.d;
            lVar.getClass();
            SdkHandler.runOnMainThread(new i(lVar, cVar));
        }
    }

    @Override // com.meishu.sdk.core.webview.listener.b, com.meishu.sdk.core.webview.listener.d
    public boolean clickAppDownloadInfo(String str) {
        l.b bVar = this.e;
        if (bVar == null) {
            return false;
        }
        g0 g0Var = (g0) bVar;
        g0Var.getClass();
        try {
            return !((com.meishu.sdk.platform.ms.splash.g) g0Var.f5015a).e;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.meishu.sdk.core.webview.listener.b, com.meishu.sdk.core.webview.listener.d
    public String getDeviceInfo() {
        int iB;
        Context context = this.f5088a;
        int iB2 = context == null ? 12 : (int) (e.b(context) / context.getResources().getDisplayMetrics().density);
        int iA = this.b.getSkipBtnLocation() == 2 ? e.a(this.c) + 5 + iB2 : iB2;
        Context context2 = this.f5088a;
        GetDeviceInfoResBean.AdConfig adConfigMakeAdConfig = GetDeviceInfoResBean.makeAdConfig(iA, iB2, context2 != null ? (int) (e.a(context2) / context2.getResources().getDisplayMetrics().density) : 12);
        try {
            Context context3 = this.f5088a;
            iB = (int) m.b(context3, x0.m(context3));
        } catch (Exception unused) {
            iB = 0;
        }
        AdType adType = AdType.SPLASH;
        adType.value();
        com.meishu.sdk.core.utils.h.a();
        int iA2 = com.meishu.sdk.core.utils.h.a(this.d.b.getAct_type(), adType.value());
        return u.f4948a.toJson(GetDeviceInfoResBean.make(iB, com.meishu.sdk.core.utils.h.d(iA2), com.meishu.sdk.core.utils.h.e(iA2), adConfigMakeAdConfig));
    }
}
