package com.meishu.sdk.platform.huawei.paster;

import com.huawei.hms.ads.instreamad.InstreamView;
import com.meishu.sdk.core.ad.a;
import com.meishu.sdk.core.ad.paster.PasterAd;
import com.meishu.sdk.core.loader.d;
import com.meishu.sdk.core.utils.o1;
import com.meishu.sdk.meishu_ad.nativ.NormalMediaView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class HWPasterAd extends a implements PasterAd {
    private d adWrapper;
    private InstreamView instreamView;

    public HWPasterAd(d dVar, InstreamView instreamView) {
        super(dVar, "HW");
        this.adWrapper = dVar;
        this.instreamView = instreamView;
    }

    @Override // com.meishu.sdk.core.ad.paster.PasterAd
    public long getCurrentPosition() {
        return 0L;
    }

    @Override // com.meishu.sdk.core.ad.paster.PasterAd
    public long getDuration() {
        return 0L;
    }

    @Override // com.meishu.sdk.core.ad.paster.PasterAd
    public void setOnPreparedListener(NormalMediaView.d dVar) {
    }

    @Override // com.meishu.sdk.core.ad.paster.PasterAd
    public void start() {
        try {
            o1.b(this.adWrapper.getSdkAdInfo().getEventUrl());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        InstreamView instreamView = this.instreamView;
        if (instreamView != null) {
            instreamView.play();
        }
    }

    @Override // com.meishu.sdk.core.ad.paster.PasterAd
    public void destroy() {
        InstreamView instreamView = this.instreamView;
        if (instreamView != null) {
            instreamView.destroy();
        }
    }

    @Override // com.meishu.sdk.core.ad.paster.PasterAd
    public void mute() {
        InstreamView instreamView = this.instreamView;
        if (instreamView != null) {
            instreamView.mute();
        }
    }

    @Override // com.meishu.sdk.core.ad.paster.PasterAd
    public void onPause() {
        InstreamView instreamView = this.instreamView;
        if (instreamView != null) {
            instreamView.pause();
        }
    }

    @Override // com.meishu.sdk.core.ad.paster.PasterAd
    public void onResume() {
        InstreamView instreamView = this.instreamView;
        if (instreamView != null) {
            instreamView.play();
        }
    }

    @Override // com.meishu.sdk.core.ad.paster.PasterAd
    public void pause() {
        InstreamView instreamView = this.instreamView;
        if (instreamView != null) {
            instreamView.pause();
        }
    }

    @Override // com.meishu.sdk.core.ad.paster.PasterAd
    public void replay() {
        InstreamView instreamView = this.instreamView;
        if (instreamView != null) {
            instreamView.play();
        }
    }

    @Override // com.meishu.sdk.core.ad.paster.PasterAd
    public void resume() {
        InstreamView instreamView = this.instreamView;
        if (instreamView != null) {
            instreamView.play();
        }
    }

    @Override // com.meishu.sdk.core.ad.paster.PasterAd
    public void unmute() {
        InstreamView instreamView = this.instreamView;
        if (instreamView != null) {
            instreamView.unmute();
        }
    }
}
