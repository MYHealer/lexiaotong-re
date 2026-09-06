package com.meishu.sdk.platform.ms.reward;

import android.text.TextUtils;
import com.meishu.sdk.activity.MeishuRewardVideoPlayerActivity;
import com.meishu.sdk.core.ad.AdSlot;
import com.meishu.sdk.core.ad.AdType;
import com.meishu.sdk.core.loader.IAdLoadListener;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.u0;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.meishu_ad.nativ.f;
import com.meishu.sdk.platform.ms.d;
import com.meishu.sdk.platform.ms.g;
import java.util.List;

/* JADX INFO: compiled from: AdListenerAdapter.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class a implements com.meishu.sdk.meishu_ad.nativ.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IAdLoadListener f5232a;
    public g b;
    public f c;
    public boolean d;
    public Boolean e;
    public com.meishu.sdk.platform.ms.a f;

    public a(g gVar, IAdLoadListener iAdLoadListener, f fVar) {
        this.b = gVar;
        this.f5232a = iAdLoadListener;
        this.c = fVar;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.meishu.sdk.core.loader.c] */
    @Override // com.meishu.sdk.meishu_ad.m0
    public void onADExposure() {
        try {
            if (com.meishu.sdk.core.utils.a.a((AdSlot) this.c)) {
                LogUtil.dev("AdListenerAdapter", "has exp. return");
                return;
            }
            if (this.d) {
                return;
            }
            this.d = true;
            this.c.setHasExposed(true);
            u0.a(this.b.getAdLoader().getPosId(), 3);
            String[] monitorUrl = this.b.f5177a.getMonitorUrl();
            h0.a(monitorUrl);
            if (monitorUrl != null) {
                LogUtil.d("AdListenerAdapter", "send onAdExposure");
                for (String str : monitorUrl) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(this.b.getContext(), h0.a(h0.a(str, this.c.getAct_type(), this.b instanceof b ? AdType.REWARD : AdType.FULL_SCREEN_VIDEO)), new i());
                    }
                }
            }
            IAdLoadListener iAdLoadListener = this.f5232a;
            if (iAdLoadListener != null) {
                iAdLoadListener.onAdExposure();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.meishu_ad.m0
    public void onADLoaded(List<com.meishu.sdk.meishu_ad.nativ.b> list) {
        List<com.meishu.sdk.meishu_ad.nativ.b> list2 = list;
        try {
            if (this.f5232a == null || list2 == null || list2.isEmpty()) {
                return;
            }
            com.meishu.sdk.platform.ms.a aVar = new com.meishu.sdk.platform.ms.a(this.b, list2.get(0), this.c, this);
            this.f = aVar;
            this.f5232a.onAdReady(aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.meishu_ad.m0
    public void onAdRenderFail(String str, int i) {
        try {
            this.e = Boolean.TRUE;
            if (this.b.f5177a.getErrorUrl() != null) {
                z.a(this.b.f5177a.getErrorUrl()[0], Integer.valueOf(i), str);
            }
            com.meishu.sdk.platform.ms.a aVar = this.f;
            if (aVar != null) {
                MeishuRewardVideoPlayerActivity.clearRewardMediaView();
                aVar.f5157a = null;
            }
            try {
                MeishuRewardVideoPlayerActivity.clearRewardMediaView();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            IAdLoadListener iAdLoadListener = this.f5232a;
            if (iAdLoadListener != null) {
                iAdLoadListener.onAdPlatformError(new d(str, Integer.valueOf(i)));
                this.f5232a.onAdRenderFail(str, i);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
