package com.hihonor.adsdk.base.player;

import android.content.Context;
import android.util.AttributeSet;
import com.hihonor.adsdk.base.widget.RadiusFrameLayout;
import com.hihonor.adsdk.common.video.OnVideoSwitchListener;
import com.hihonor.adsdk.common.video.c;
import com.hihonor.adsdk.common.video.d;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class HnWebPlayerView extends HnBasePlayerView {
    private static final String LOG_TAG = "HnWebPlayerView";
    private a onDisConnectListener;

    public interface a {
        void disConnect();
    }

    public HnWebPlayerView(Context context) {
        super(context);
    }

    private boolean hasDefaultPlayerView() {
        c cVarHnadsa = d.hnadsa(this.mVideoAdapterId);
        this.mPlayerAdapter = cVarHnadsa;
        return (cVarHnadsa == null || cVarHnadsa.hnadsd() == null) ? false : true;
    }

    @Override // com.hihonor.adsdk.base.player.HnBasePlayerView
    protected String getLogTag() {
        return LOG_TAG + hashCode();
    }

    @Override // com.hihonor.adsdk.base.player.HnBasePlayerView
    protected void initPlayerAdapter() {
        resetAdapter();
        removeProxyVideoListener();
        addProxyVideoListener();
        addTextureView();
        c cVar = this.mPlayerAdapter;
        if (cVar != null) {
            cVar.hnadsb(this);
            if (this.mPlayerAdapter.hnadsd() != null) {
                this.mPlayerAdapter.hnadsd().disConnect();
            }
        }
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
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "onDetachedFromWindow", new Object[0]);
        RadiusFrameLayout radiusFrameLayout = this.mAdPlayerContentView;
        if (radiusFrameLayout == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "onDetachedFromWindow mAdPlayerContentView is null", new Object[0]);
        } else {
            radiusFrameLayout.removeAllViews();
        }
    }

    @Override // com.hihonor.adsdk.base.player.HnBasePlayerView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        com.hihonor.adsdk.common.b.b.hnadse(getLogTag(), "onWindowFocusChanged hasWindowFocus: " + z, new Object[0]);
        if (!z) {
            pause();
            return;
        }
        connect();
        c cVar = this.mPlayerAdapter;
        if (cVar != null && cVar.hnadsd() != null) {
            this.mPlayerAdapter.hnadsd().disConnect();
        }
        resume();
    }

    public void play() {
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "play", new Object[0]);
        if (hasAdapter()) {
            setAdKeepScreenOn(true);
            com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "play  status：" + getPlayState(), new Object[0]);
            if (getPlayState() == 8) {
                replay();
                return;
            }
            if (getPlayState() == 0 || getPlayState() == -1) {
                com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "play--->start", new Object[0]);
                start(this.mVideoUrl, true);
            } else if (getPlayState() == 7 || getPlayState() == 5) {
                com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "play--->resume", new Object[0]);
                resume();
            }
        }
    }

    public void releaseOrRemove() {
        if (!hasDefaultPlayerView()) {
            com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "not hasDefaultPlayerView", new Object[0]);
            releaseAdapter();
        } else {
            com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "hasDefaultPlayerView", new Object[0]);
            removeDetailPlayerView();
            removeProxyVideoListener();
            removeAdapter();
        }
    }

    public void removeDetailPlayerView() {
        this.mPlayerAdapter = d.hnadsa(this.mVideoAdapterId);
        if (hasAdapter()) {
            this.mPlayerAdapter.hnadsb((OnVideoSwitchListener) null);
        }
    }

    public void setOnDisConnectListener(a aVar) {
        this.onDisConnectListener = aVar;
    }

    public HnWebPlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.hihonor.adsdk.base.player.HnBasePlayerView, com.hihonor.adsdk.common.video.OnVideoSwitchListener
    public void finish() {
        a aVar = this.onDisConnectListener;
        if (aVar != null) {
            aVar.disConnect();
        }
    }

    public HnWebPlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
