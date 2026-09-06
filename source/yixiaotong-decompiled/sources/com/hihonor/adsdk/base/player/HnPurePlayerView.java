package com.hihonor.adsdk.base.player;

import android.content.Context;
import android.util.AttributeSet;
import com.hihonor.adsdk.base.api.BaseAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class HnPurePlayerView extends HnBasePlayerView {
    private static final String LOG_TAG = "HnPurePlayerView";

    public HnPurePlayerView(Context context) {
        super(context);
    }

    @Override // com.hihonor.adsdk.base.player.HnBasePlayerView
    public void bindAd(BaseAd baseAd, int i) {
        super.bindAd(baseAd, i);
        this.mAdPlayerContentView.setRadius(this.cornerRadius);
    }

    @Override // com.hihonor.adsdk.base.player.HnBasePlayerView
    protected String getLogTag() {
        return LOG_TAG + hashCode();
    }

    @Override // com.hihonor.adsdk.base.player.HnBasePlayerView
    protected boolean isSupportCorner() {
        return true;
    }

    @Override // com.hihonor.adsdk.base.player.HnBasePlayerView
    protected boolean isSupportLoading() {
        return false;
    }

    @Override // com.hihonor.adsdk.base.player.HnBasePlayerView
    protected boolean isSupportReplay() {
        return true;
    }

    @Override // com.hihonor.adsdk.base.player.HnBasePlayerView
    protected void reportTriggerStart(int i) {
        if (i == 1) {
            this.mPlayerReport.hnadsj();
        }
    }

    public HnPurePlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HnPurePlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
