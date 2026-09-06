package com.meishu.sdk.meishu_ad;

import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.ad.BaseAdSlot;
import com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener;
import com.meishu.sdk.meishu_ad.nativ.NormalMediaView;
import com.meishu.sdk.meishu_ad.splash.SplashSkipView;

/* JADX INFO: compiled from: AdNative.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d implements RecyclerAdMediaListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NormalMediaView f5007a;
    public final /* synthetic */ SplashSkipView b;
    public final /* synthetic */ e c;

    public d(e eVar, NormalMediaView normalMediaView, SplashSkipView splashSkipView) {
        this.c = eVar;
        this.f5007a = normalMediaView;
        this.b = splashSkipView;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
    public void onProgressUpdate(long j, long j2) {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
    public void onVideoCompleted() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
    public void onVideoError() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
    public void onVideoLoaded() {
        e eVar = this.c;
        v.a(eVar.f, (byte[]) null, eVar.d, false, (BaseAdSlot) eVar.b, eVar.c, eVar.f5010a, this.f5007a);
        e eVar2 = this.c;
        com.meishu.sdk.meishu_ad.splash.c cVar = eVar2.c;
        NormalMediaView normalMediaView = this.f5007a;
        cVar.d = normalMediaView;
        if (eVar2.f5010a != null) {
            cVar.setWidth(Integer.valueOf(normalMediaView.getMeishuVideoView().getMediaPlayer().getVideoWidth()));
            this.c.c.setHeight(Integer.valueOf(this.f5007a.getMeishuVideoView().getMediaPlayer().getVideoHeight()));
        }
        long jMin = Math.min(this.f5007a.getDuration(), AdSdk.adConfig().getSplashShowTime());
        if (this.c.b.H != 1) {
            this.b.setTotalTime((int) jMin);
        }
        if (this.c.f.j) {
            try {
                this.f5007a.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
    public void onVideoPause() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
    public void onVideoResume() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
    public void onVideoStart() {
    }
}
