package com.hihonor.adsdk.base.player;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import com.hihonor.adsdk.base.bean.Video;
import com.hihonor.adsdk.base.net.i;
import com.hihonor.adsdk.common.f.a0;
import com.hihonor.adsdk.common.f.c0;
import com.hihonor.adsdk.common.video.OnVideoSwitchListener;
import com.hihonor.adsdk.common.video.c;
import com.hihonor.adsdk.common.video.d;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class HnPictureTextPlayerView extends HnBasePlayerView {
    private static final String LOG_TAG = "HnPictureTextPlayerView";
    private boolean isSupportCorners;
    private boolean mFirstFlag;
    private final i.a mNetWorkChangeListener;
    private ViewTreeObserver.OnScrollChangedListener mOnScrollChangedListener;
    private final c0 mViewMonitor;

    class a implements i.a {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void hnadsb() {
            if (HnPictureTextPlayerView.this.mViewMonitor.hnadsd() && HnPictureTextPlayerView.this.hasAdapter() && HnPictureTextPlayerView.this.mPlayerAdapter.hnadsg() == 0) {
                com.hihonor.adsdk.common.b.b.hnadsc(HnPictureTextPlayerView.this.getLogTag(), "onNetWorkChange--->play", new Object[0]);
                HnPictureTextPlayerView hnPictureTextPlayerView = HnPictureTextPlayerView.this;
                hnPictureTextPlayerView.autoStart(hnPictureTextPlayerView.mVideoUrl, true);
            }
        }

        @Override // com.hihonor.adsdk.base.net.i.a
        public void hnadsa() {
            a0.hnadsc(new Runnable() { // from class: com.hihonor.adsdk.base.player.HnPictureTextPlayerView$a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.hnadsb();
                }
            });
        }
    }

    class b extends c0 {
        b(View view, int i) {
            super(view, i);
        }

        @Override // com.hihonor.adsdk.common.f.c0
        protected void hnadsa(long j, int i) {
            super.hnadsa(j, i);
            com.hihonor.adsdk.common.b.b.hnadsa(HnPictureTextPlayerView.this.getLogTag(), "onViewHide#showDuration %s, showPercent %s", Long.valueOf(j), Integer.valueOf(i));
        }

        @Override // com.hihonor.adsdk.common.f.c0
        protected void hnadsj() {
            super.hnadsj();
            com.hihonor.adsdk.common.b.b.hnadsc(HnPictureTextPlayerView.this.getLogTag(), "onViewStartShow", new Object[0]);
            HnPictureTextPlayerView.this.judgeAutoPlay();
        }
    }

    public HnPictureTextPlayerView(Context context) {
        super(context);
        this.isSupportCorners = false;
        this.mNetWorkChangeListener = new a();
        this.mViewMonitor = new b(this, 74);
        this.mOnScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.hihonor.adsdk.base.player.HnPictureTextPlayerView$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                this.f$0.m895x35268960();
            }
        };
    }

    private boolean hasDetailPlayView() {
        c cVarHnadsa = d.hnadsa(this.mVideoAdapterId);
        this.mPlayerAdapter = cVarHnadsa;
        return (cVarHnadsa == null || cVarHnadsa.hnadse() == null) ? false : true;
    }

    protected void autoStart(String str, boolean z) {
        if (getPlayState() != 0 || canAutoPlay()) {
            start(str, z);
        } else {
            com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "首次播放，网络不满足自动播放的条件", new Object[0]);
        }
    }

    public boolean canAutoPlay() {
        Video video = this.mVideo;
        int autoPlay = video == null ? 3 : video.getAutoPlay();
        boolean zHnadsc = i.hnadsc();
        boolean zHnadsd = i.hnadsd();
        boolean z = true;
        if ((autoPlay != 1 || !zHnadsc) && (autoPlay != 2 || !zHnadsd)) {
            z = false;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "autoPlay:" + autoPlay + ",networkEnable:" + zHnadsc + ",isWifi:" + zHnadsd + ",enableAutoPlay:" + z, new Object[0]);
        return z;
    }

    @Override // com.hihonor.adsdk.base.player.HnBasePlayerView
    protected String getLogTag() {
        return LOG_TAG + hashCode();
    }

    protected boolean isReady() {
        boolean zHasWindowFocus = hasWindowFocus();
        boolean zHnadsd = this.mViewMonitor.hnadsd();
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "isReady hasWindowFocus:" + zHasWindowFocus + "; isValidVisibleArea:" + zHnadsd, new Object[0]);
        return zHasWindowFocus && zHnadsd;
    }

    @Override // com.hihonor.adsdk.base.player.HnBasePlayerView
    protected boolean isSupportCorner() {
        return this.isSupportCorners;
    }

    @Override // com.hihonor.adsdk.base.player.HnBasePlayerView
    protected boolean isSupportLoading() {
        return true;
    }

    @Override // com.hihonor.adsdk.base.player.HnBasePlayerView
    protected boolean isSupportReplay() {
        return true;
    }

    public void judgeAutoPlay() {
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "judgeAutoPlay", new Object[0]);
        if (!isReady()) {
            pause();
            return;
        }
        if (this.mFirstFlag && canAutoPlay()) {
            com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, "report trigger", new Object[0]);
            this.mPlayerReport.hnadsj();
            this.mFirstFlag = false;
        }
        resume();
    }

    /* JADX INFO: renamed from: lambda$new$0$com-hihonor-adsdk-base-player-HnPictureTextPlayerView, reason: not valid java name */
    /* synthetic */ void m895x35268960() {
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "#TestScroll#isValidVisibleArea", new Object[0]);
        judgeAutoPlay();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "attach mIsReleased:" + this.mIsReleased, new Object[0]);
        if (this.mIsReleased) {
            return;
        }
        if (!hasAdapter()) {
            initPlayerAdapter();
        }
        this.mFirstFlag = true;
        autoStart(this.mVideoUrl, true);
        getViewTreeObserver().addOnScrollChangedListener(this.mOnScrollChangedListener);
        this.mViewMonitor.hnadsg();
        i.hnadsa(this.mNetWorkChangeListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "detach mIsReleased:" + this.mIsReleased, new Object[0]);
        removeScrollChangeListener();
        this.mViewMonitor.hnadsf();
        i.hnadsb(this.mNetWorkChangeListener);
        if (!hasDetailPlayView()) {
            com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, "not hasDetailPlayView", new Object[0]);
            releaseAdapter();
        } else {
            com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, "hasDetailPlayView", new Object[0]);
            removeDefaultPlayerView();
            removeProxyVideoListener();
            removeAdapter();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.hihonor.adsdk.common.b.b.hnadsa(getLogTag(), (Object) ("onSizeChanged w" + i + "  h:" + i2 + "  oldw:" + i3 + "  oldh:" + i2));
        judgeAutoPlay();
    }

    @Override // com.hihonor.adsdk.base.player.HnBasePlayerView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "#TestWindowFocus", new Object[0]);
        judgeAutoPlay();
    }

    @Override // com.hihonor.adsdk.base.player.HnBasePlayerView
    public void release() {
        super.release();
        removeScrollChangeListener();
    }

    public void removeDefaultPlayerView() {
        this.mPlayerAdapter = d.hnadsa(this.mVideoAdapterId);
        if (hasAdapter()) {
            this.mPlayerAdapter.hnadsa((OnVideoSwitchListener) null);
        }
    }

    public void removeScrollChangeListener() {
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "#removeScrollChangeListener-----------" + hasAdapter(), new Object[0]);
        getViewTreeObserver().removeOnScrollChangedListener(this.mOnScrollChangedListener);
    }

    @Override // com.hihonor.adsdk.base.player.HnBasePlayerView
    protected void reportTriggerStart(int i) {
        if (i == 1) {
            this.mPlayerReport.hnadsj();
        }
    }

    public void setPlayerViewCorners() {
        float f = this.cornerRadius;
        if (f > 0.0f) {
            this.mAdPlayerContentView.setRadius(f);
            this.isSupportCorners = true;
        }
    }

    public HnPictureTextPlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isSupportCorners = false;
        this.mNetWorkChangeListener = new a();
        this.mViewMonitor = new b(this, 74);
        this.mOnScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.hihonor.adsdk.base.player.HnPictureTextPlayerView$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                this.f$0.m895x35268960();
            }
        };
    }

    public HnPictureTextPlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isSupportCorners = false;
        this.mNetWorkChangeListener = new a();
        this.mViewMonitor = new b(this, 74);
        this.mOnScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.hihonor.adsdk.base.player.HnPictureTextPlayerView$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                this.f$0.m895x35268960();
            }
        };
    }
}
