package com.hihonor.adsdk.base.player;

import android.content.Context;
import android.util.AttributeSet;
import com.hihonor.adsdk.common.f.j;
import com.hihonor.adsdk.common.f.u;
import com.hihonor.adsdk.common.video.c;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class HnInterstitialPlayerView extends HnBasePlayerView {
    private static final String LOG_TAG = "HnInterstitialPlayerView";

    public HnInterstitialPlayerView(Context context) {
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
        return true;
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
        com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, "onWindowFocusChanged hasWindowFocus: " + z, new Object[0]);
        if (z) {
            if (!hasAdapter()) {
                connect();
            }
            c cVar = this.mPlayerAdapter;
            if (cVar == null || cVar.hnadse() == null) {
                return;
            }
            this.mPlayerAdapter.hnadse().disConnect();
        }
    }

    public void setPartCornerRadius(Boolean[] boolArr) {
        this.mPartCornerRadius = boolArr;
    }

    public void setPlayerViewCornersByLand(int i) {
        if (i > 0) {
            float fHnadsa = j.hnadsa(this.mContext, i);
            this.cornerRadius = fHnadsa;
            if (u.hnadsk()) {
                this.mAdPlayerContentView.setRightRadius(fHnadsa);
            } else {
                this.mAdPlayerContentView.setLeftRadius(fHnadsa);
            }
        }
    }

    public void setPlayerViewCornersByPortrait(int i) {
        if (i > 0) {
            float fHnadsa = j.hnadsa(this.mContext, i);
            this.cornerRadius = fHnadsa;
            this.mAdPlayerContentView.setTopRadius(fHnadsa);
        }
    }

    public HnInterstitialPlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HnInterstitialPlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
