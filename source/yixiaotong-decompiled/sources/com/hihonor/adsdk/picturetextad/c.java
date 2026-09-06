package com.hihonor.adsdk.picturetextad;

import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.api.IAdLoad;
import com.hihonor.adsdk.base.api.feed.PictureTextAdLoadListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
class c implements IAdLoad<PictureTextAdLoadListener> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected AdSlot f3541a;
    protected PictureTextAdLoadListener b;

    c() {
    }

    @Override // com.hihonor.adsdk.base.api.IAdLoad
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void setAdLoadListener(PictureTextAdLoadListener pictureTextAdLoadListener) {
        this.b = pictureTextAdLoadListener;
    }

    @Override // com.hihonor.adsdk.base.api.IAdLoad
    public void loadAd() {
        d.a().a(this.f3541a, this.b);
    }

    @Override // com.hihonor.adsdk.base.api.IAdLoad
    public void setAdSlot(AdSlot adSlot) {
        this.f3541a = adSlot;
    }
}
