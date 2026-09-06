package com.hihonor.adsdk.base.player;

import android.content.Context;
import android.util.AttributeSet;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class HnRewardPlayerView extends HnBasePlayerView {
    private static final String LOG_TAG = "HnRewardPlayerView";

    public HnRewardPlayerView(Context context) {
        super(context);
    }

    @Override // com.hihonor.adsdk.base.player.HnBasePlayerView
    protected String getLogTag() {
        return LOG_TAG + hashCode();
    }

    @Override // com.hihonor.adsdk.base.player.HnBasePlayerView
    protected boolean isKeepScreenOn() {
        return true;
    }

    @Override // com.hihonor.adsdk.base.player.HnBasePlayerView
    protected boolean isSupportCorner() {
        return false;
    }

    @Override // com.hihonor.adsdk.base.player.HnBasePlayerView
    protected boolean isSupportLoading() {
        return true;
    }

    @Override // com.hihonor.adsdk.base.player.HnBasePlayerView
    protected boolean isSupportReplay() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        resume();
    }

    @Override // com.hihonor.adsdk.base.player.HnBasePlayerView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            resume();
        } else {
            pause();
        }
    }

    public void play() {
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "play", new Object[0]);
        if (hasAdapter()) {
            com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "play  status：" + getPlayState(), new Object[0]);
            if (getPlayState() == 0 || getPlayState() == -1) {
                com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "play--->start", new Object[0]);
                start(this.mVideoUrl, true);
            } else if (getPlayState() == 7 || getPlayState() == 5) {
                com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "play--->resume", new Object[0]);
                resume();
            }
        }
    }

    public HnRewardPlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HnRewardPlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
