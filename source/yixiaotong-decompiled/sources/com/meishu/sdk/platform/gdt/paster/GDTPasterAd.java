package com.meishu.sdk.platform.gdt.paster;

import android.view.View;
import com.meishu.sdk.core.MSAdConfig;
import com.meishu.sdk.core.ad.TouchData;
import com.meishu.sdk.core.ad.a;
import com.meishu.sdk.core.ad.paster.PasterAd;
import com.meishu.sdk.core.loader.InteractionListener;
import com.meishu.sdk.meishu_ad.nativ.NormalMediaView;
import com.qq.e.ads.nativ.NativeUnifiedADData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class GDTPasterAd extends a implements PasterAd {
    private InteractionListener interactionListener;
    private NativeUnifiedADData nativeUnifiedADData;

    public GDTPasterAd(NativeUnifiedADData nativeUnifiedADData) {
        super(null, MSAdConfig.PLATFORM_GDT);
        this.nativeUnifiedADData = nativeUnifiedADData;
    }

    @Override // com.meishu.sdk.core.ad.paster.PasterAd
    public void destroy() {
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.ad.IAd
    public View getAdView() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.paster.PasterAd
    public long getCurrentPosition() {
        return 0L;
    }

    @Override // com.meishu.sdk.core.ad.paster.PasterAd
    public long getDuration() {
        return this.nativeUnifiedADData.getVideoDuration();
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.ad.IAd
    public InteractionListener getInteractionListener() {
        return this.interactionListener;
    }

    @Override // com.meishu.sdk.core.ad.a
    public Object getSdkAd() {
        return this.nativeUnifiedADData;
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.ad.IAd
    public TouchData getTouchData() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.paster.PasterAd
    public void mute() {
    }

    @Override // com.meishu.sdk.core.ad.paster.PasterAd
    public void onPause() {
    }

    @Override // com.meishu.sdk.core.ad.paster.PasterAd
    public void onResume() {
        this.nativeUnifiedADData.resume();
    }

    @Override // com.meishu.sdk.core.ad.paster.PasterAd
    public void pause() {
        this.nativeUnifiedADData.pauseVideo();
    }

    @Override // com.meishu.sdk.core.ad.paster.PasterAd
    public void replay() {
        this.nativeUnifiedADData.startVideo();
    }

    @Override // com.meishu.sdk.core.ad.paster.PasterAd
    public void resume() {
        this.nativeUnifiedADData.resumeVideo();
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.ad.IAd
    public void setAdView(View view) {
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.ad.IAd
    public void setInteractionListener(InteractionListener interactionListener) {
        this.interactionListener = interactionListener;
    }

    @Override // com.meishu.sdk.core.ad.paster.PasterAd
    public void setOnPreparedListener(NormalMediaView.d dVar) {
    }

    @Override // com.meishu.sdk.core.ad.paster.PasterAd
    public void start() {
        this.nativeUnifiedADData.startVideo();
    }

    @Override // com.meishu.sdk.core.ad.paster.PasterAd
    public void unmute() {
    }
}
