package com.hihonor.adsdk.base.player;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.bean.Style;
import com.hihonor.adsdk.base.bean.Video;
import com.hihonor.adsdk.base.bean.VideoReportBean;
import com.hihonor.adsdk.base.g.j.d.x;
import com.hihonor.adsdk.base.net.glide.GlideLoadBuild;
import com.hihonor.adsdk.base.widget.RadiusFrameLayout;
import com.hihonor.adsdk.base.widget.RoundImageView;
import com.hihonor.adsdk.common.f.j;
import com.hihonor.adsdk.common.uikit.phone.hwprogressbar.widget.HwProgressBar;
import com.hihonor.adsdk.common.video.AdVideoSize;
import com.hihonor.adsdk.common.video.OnVideoPlayListener;
import com.hihonor.adsdk.common.video.OnVideoStatusChangeListener;
import com.hihonor.adsdk.common.video.OnVideoSwitchListener;
import com.hihonor.adsdk.common.video.c;
import com.hihonor.adsdk.common.video.d;
import com.hihonor.adsdk.common.video.f;
import com.hihonor.adsdk.common.video.g.e;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class HnBasePlayerView extends FrameLayout implements OnVideoStatusChangeListener, OnVideoSwitchListener {
    private static final long TIME_LOADING_DISMISS = 300;
    protected RoundImageView adVideoCover;
    protected int adaptSizeBaseMode;
    protected int baseSize;
    protected AdVideoSize calSize;
    protected float cornerRadius;
    private AlphaAnimation coverAlpha;
    private AlphaAnimation loadAlpha;
    protected RadiusFrameLayout mAdPlayerContentView;
    protected BaseAd mBaseAd;
    protected e mCacheManager;
    protected Context mContext;
    protected int mDefaultDrawableColorId;
    protected boolean mIsCompleted;
    protected boolean mIsMute;
    protected boolean mIsReleased;
    private HwProgressBar mLoadingImage;
    protected OnVideoPlayListener mOnVideoPlayListener;
    protected Boolean[] mPartCornerRadius;
    protected c mPlayerAdapter;
    protected final a mPlayerReport;
    protected int mScene;
    protected String mSceneKey;
    protected View mTextureView;
    protected Video mVideo;
    protected String mVideoAdapterId;
    protected VideoReportBean mVideoReportBean;
    protected String mVideoUrl;
    private long startPlayTime;

    public HnBasePlayerView(Context context) {
        this(context, null);
    }

    private void finishDetailPlayerView() {
        this.mPlayerAdapter = d.hnadsa(this.mVideoAdapterId);
        if (!hasAdapter() || this.mPlayerAdapter.hnadse() == null) {
            return;
        }
        this.mPlayerAdapter.hnadse().finish();
    }

    private ImageView.ScaleType getVideoCoverScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return ImageView.ScaleType.FIT_XY;
        }
        return scaleType != ImageView.ScaleType.CENTER_CROP ? ImageView.ScaleType.FIT_XY : scaleType;
    }

    private void initCornerRadius() {
        this.cornerRadius = this.mContext.getResources().getDimension(R.dimen.honor_ads_magic_corner_radius_small);
        Style style = this.mBaseAd.getStyle();
        if (style == null || style.getBorderRadius() < 0) {
            return;
        }
        this.cornerRadius = j.hnadsa(this.mContext, style.getBorderRadius());
    }

    private void setSceneKey(String str) {
        this.mSceneKey = this.mVideoAdapterId + ":scene:" + str;
    }

    protected void addProxyVideoListener() {
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "addProxyVideoListener:" + hasAdapter(), new Object[0]);
        if (hasAdapter()) {
            this.mPlayerAdapter.hnadsa(this.mSceneKey, this);
        }
    }

    protected void addTextureView() {
        com.hihonor.adsdk.common.b.b.hnadse(getLogTag(), "addTextureView", new Object[0]);
        if (!hasAdapter()) {
            com.hihonor.adsdk.common.b.b.hnadse(getLogTag(), "Player adapter is null.", new Object[0]);
            return;
        }
        View viewHnadsk = this.mPlayerAdapter.hnadsk();
        this.mTextureView = viewHnadsk;
        if (viewHnadsk == null) {
            com.hihonor.adsdk.common.b.b.hnadse(getLogTag(), "Texture is null.", new Object[0]);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) viewHnadsk.getParent();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        ViewGroup.LayoutParams layoutParams = this.mTextureView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = -1;
            layoutParams.height = -1;
        } else {
            layoutParams = new FrameLayout.LayoutParams(-1, -1);
        }
        this.mAdPlayerContentView.addView(this.mTextureView, layoutParams);
        AdVideoSize adVideoSize = this.calSize;
        if (adVideoSize != null) {
            setVideoViewSize(adVideoSize, this.adaptSizeBaseMode, this.baseSize);
            return;
        }
        Video video = this.mVideo;
        if (video != null) {
            setVideoViewSize(new AdVideoSize(video.getVideoWidth(), this.mVideo.getVideoHeight()), this.adaptSizeBaseMode, this.baseSize);
        } else {
            com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "calSize&&mVideo is null ", new Object[0]);
        }
    }

    public void bindAd(BaseAd baseAd) {
        bindAd(baseAd, 1);
    }

    @Override // com.hihonor.adsdk.common.video.OnVideoSwitchListener
    public void connect() {
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "connect", new Object[0]);
        resetAdapter();
        addTextureView();
        setMuted(this.mIsMute);
    }

    @Override // com.hihonor.adsdk.common.video.OnVideoSwitchListener
    public void disConnect() {
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "disConnect", new Object[0]);
        removeAdapter();
    }

    @Override // com.hihonor.adsdk.common.video.OnVideoSwitchListener
    public void finish() {
    }

    public AdVideoSize getFinalPlayerSize() {
        return this.calSize;
    }

    protected abstract String getLogTag();

    public int getPlayState() {
        if (hasAdapter()) {
            com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "#getPlayState-----------" + this.mPlayerAdapter.hnadsg(), new Object[0]);
            return this.mPlayerAdapter.hnadsg();
        }
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "#getPlayState----------- adapter is null", new Object[0]);
        return 0;
    }

    protected boolean hasAdapter() {
        return this.mPlayerAdapter != null;
    }

    protected void initPlayerAdapter() {
        resetAdapter();
        removeProxyVideoListener();
        addProxyVideoListener();
        addTextureView();
        setMuted(this.mIsMute);
        c cVar = this.mPlayerAdapter;
        if (cVar != null) {
            cVar.hnadsa(this);
        }
    }

    protected void initView(Context context) {
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "initView", new Object[0]);
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.honor_ads_base_player_layout, this);
        this.mAdPlayerContentView = (RadiusFrameLayout) findViewById(R.id.ad_player_content_view);
        this.adVideoCover = (RoundImageView) findViewById(R.id.ad_video_cover);
        this.mLoadingImage = (HwProgressBar) findViewById(R.id.ad_video_loading);
        setTag(R.id.ad_common_click_type_tag, 5);
    }

    protected boolean isKeepScreenOn() {
        return false;
    }

    public boolean isMuted() {
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "isMuted", new Object[0]);
        return hasAdapter() ? this.mPlayerAdapter.hnadsh() : this.mIsMute;
    }

    protected boolean isPlaying() {
        if (hasAdapter()) {
            return this.mPlayerAdapter.hnadsi();
        }
        return false;
    }

    public boolean isReleased() {
        return this.mIsReleased;
    }

    protected abstract boolean isSupportCorner();

    protected abstract boolean isSupportLoading();

    protected abstract boolean isSupportReplay();

    @Override // com.hihonor.adsdk.common.video.OnVideoStatusChangeListener
    public void onProgressUpdate(long j, long j2, long j3) {
        if (hasAdapter()) {
            this.mVideoReportBean.setRemainingTime(j3 - j);
        }
        OnVideoPlayListener onVideoPlayListener = this.mOnVideoPlayListener;
        if (onVideoPlayListener != null) {
            onVideoPlayListener.onProgressUpdate(j, j2, j3);
        }
    }

    @Override // com.hihonor.adsdk.common.video.OnVideoStatusChangeListener
    public void onVideoBuffering(boolean z) {
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "player--->onVideoBuffering,isBuffering:" + z, new Object[0]);
        if (hasAdapter()) {
            this.mPlayerReport.hnadsg();
        }
        showLoadingImage(z);
        OnVideoPlayListener onVideoPlayListener = this.mOnVideoPlayListener;
        if (onVideoPlayListener != null) {
            onVideoPlayListener.onVideoBuffering(z);
        }
    }

    @Override // com.hihonor.adsdk.common.video.OnVideoStatusChangeListener
    public void onVideoEnd() {
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "player--->onVideoEnd", new Object[0]);
        this.mIsCompleted = true;
        setAdKeepScreenOn(false);
        if (hasAdapter()) {
            this.mVideoReportBean.setCompleted(true);
            this.mPlayerReport.hnadsd();
        }
        setVideoCoverImageVisibility(true);
        showLoadingImage(false);
        OnVideoPlayListener onVideoPlayListener = this.mOnVideoPlayListener;
        if (onVideoPlayListener != null) {
            onVideoPlayListener.onVideoEnd();
        }
    }

    @Override // com.hihonor.adsdk.common.video.OnVideoStatusChangeListener
    public void onVideoError(int i, String str, int i2) {
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "player--->onVideoError,errorCode: " + i + ",message: " + str, new Object[0]);
        setAdKeepScreenOn(false);
        if (hasAdapter()) {
            this.mPlayerReport.hnadsa(i, str + ", url:" + this.mVideoUrl, i2);
        }
        setVideoCoverImageVisibility(true);
        showLoadingImage(false);
        OnVideoPlayListener onVideoPlayListener = this.mOnVideoPlayListener;
        if (onVideoPlayListener != null) {
            onVideoPlayListener.onVideoError(i, str);
        }
    }

    @Override // com.hihonor.adsdk.common.video.OnVideoStatusChangeListener
    public void onVideoMute(boolean z) {
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "player--->onVideoMute,isMute: " + z, new Object[0]);
        OnVideoPlayListener onVideoPlayListener = this.mOnVideoPlayListener;
        if (onVideoPlayListener != null) {
            onVideoPlayListener.onVideoMute(z);
        }
    }

    @Override // com.hihonor.adsdk.common.video.OnVideoStatusChangeListener
    public void onVideoPause() {
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "player--->onVideoPause", new Object[0]);
        setAdKeepScreenOn(false);
        if (hasAdapter()) {
            recordVideoDuration();
            this.mPlayerReport.hnadse();
        }
        OnVideoPlayListener onVideoPlayListener = this.mOnVideoPlayListener;
        if (onVideoPlayListener != null) {
            onVideoPlayListener.onVideoPause();
        }
    }

    @Override // com.hihonor.adsdk.common.video.OnVideoStatusChangeListener
    public void onVideoPrepare() {
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "player--->onVideoPrepare", new Object[0]);
        showLoadingImage(true);
        OnVideoPlayListener onVideoPlayListener = this.mOnVideoPlayListener;
        if (onVideoPlayListener != null) {
            onVideoPlayListener.onVideoPrepare();
        }
    }

    @Override // com.hihonor.adsdk.common.video.OnVideoStatusChangeListener
    public void onVideoPrepared(long j, long j2) {
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "player--->onVideoPrepared,prepareTime=%d,totalStartTime=%d", Long.valueOf(j), Long.valueOf(j2));
        showLoadingImage(false);
        if (hasAdapter()) {
            this.mVideoReportBean.setPrepareTime(j);
            this.mVideoReportBean.setTotalStartTime(j2);
            this.mPlayerReport.hnadsh();
        }
        OnVideoPlayListener onVideoPlayListener = this.mOnVideoPlayListener;
        if (onVideoPlayListener != null) {
            onVideoPlayListener.onVideoPrepared();
        }
    }

    @Override // com.hihonor.adsdk.common.video.OnVideoStatusChangeListener
    public void onVideoResume() {
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "player--->onVideoResume", new Object[0]);
        setAdKeepScreenOn(true);
        if (hasAdapter()) {
            this.mPlayerReport.hnadsi();
        }
        setVideoCoverImageVisibility(false);
        OnVideoPlayListener onVideoPlayListener = this.mOnVideoPlayListener;
        if (onVideoPlayListener != null) {
            onVideoPlayListener.onVideoResume();
        }
    }

    @Override // com.hihonor.adsdk.common.video.OnVideoStatusChangeListener
    public void onVideoSizeChange(AdVideoSize adVideoSize) {
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "player--->onVideoSizeChange", new Object[0]);
    }

    @Override // com.hihonor.adsdk.common.video.OnVideoStatusChangeListener
    public void onVideoStart() {
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "player--->onVideoStart", new Object[0]);
        setAdKeepScreenOn(true);
        if (hasAdapter()) {
            this.mPlayerReport.hnadsf();
        }
        setVideoCoverImageVisibility(false);
        OnVideoPlayListener onVideoPlayListener = this.mOnVideoPlayListener;
        if (onVideoPlayListener != null) {
            onVideoPlayListener.onVideoStart();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.hihonor.adsdk.common.b.b.hnadse(getLogTag(), "onWindowFocusChanged hasWindowFocus: " + z, new Object[0]);
        if (!z || this.mBaseAd == null) {
            return;
        }
        connect();
        c cVar = this.mPlayerAdapter;
        if (cVar == null || cVar.hnadse() == null) {
            return;
        }
        this.mPlayerAdapter.hnadse().disConnect();
    }

    public void pause() {
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "#pause#basePlayerView#Call#pause：" + hasAdapter(), new Object[0]);
        if (hasAdapter()) {
            this.mPlayerAdapter.hnadsl();
        }
    }

    protected void refreshCoverImageVisibility() {
        int playState = getPlayState();
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "state----> " + playState, new Object[0]);
        setVideoCoverImageVisibility(playState < 3 || playState == 8);
    }

    public void release() {
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "#release-----------" + hasAdapter(), new Object[0]);
        finishDetailPlayerView();
        releaseAdapter();
        this.mOnVideoPlayListener = null;
        this.mIsReleased = true;
        releaseAnimation();
    }

    protected void releaseAdapter() {
        showLoadingImage(false);
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "releaseAdapter", new Object[0]);
        setAdKeepScreenOn(false);
        if (this.mIsReleased) {
            return;
        }
        this.mPlayerAdapter = d.hnadsa(this.mVideoAdapterId);
        if (hasAdapter()) {
            checkBufferResult();
            this.mPlayerAdapter.hnadsm();
            this.mPlayerAdapter.hnadsn();
            removeAdapter();
            com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "#release-----------adapter success.", new Object[0]);
        }
        d.hnadsc(this.mVideoAdapterId);
    }

    public void removeAdapter() {
        this.mPlayerAdapter = null;
        this.mTextureView = null;
    }

    public void removeProxyVideoListener() {
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "removeProxyVideoListener:" + hasAdapter(), new Object[0]);
        if (hasAdapter()) {
            this.mPlayerAdapter.hnadsa(this.mSceneKey);
        }
    }

    public void replay() {
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "replay", new Object[0]);
        if (8 != getPlayState()) {
            start(this.mVideoUrl, true, 1);
            return;
        }
        this.mVideoReportBean.setPlayAction(1);
        reportTriggerStart(1);
        this.mPlayerAdapter.hnadso();
    }

    protected void reportTriggerStart(int i) {
        this.mPlayerReport.hnadsj();
    }

    protected void resetAdapter() {
        if (hasAdapter()) {
            return;
        }
        if (d.hnadsb(this.mVideoAdapterId)) {
            com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "resetAdapter getAdapter", new Object[0]);
            this.mPlayerAdapter = d.hnadsa(this.mVideoAdapterId);
        } else {
            com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "resetAdapter createAdapter", new Object[0]);
            this.mPlayerAdapter = d.hnadsa(this.mContext, this.mVideoAdapterId);
        }
    }

    public void resume() {
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "---resume---", new Object[0]);
        if (hasAdapter()) {
            this.mPlayerAdapter.hnadsp();
        }
    }

    protected void setAdKeepScreenOn(boolean z) {
        if (isKeepScreenOn()) {
            if (Objects.isNull(this.mPlayerAdapter)) {
                com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "setAdKeepScreenOn screen mPlayerAdapter is null", new Object[0]);
                return;
            }
            com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "setAdKeepScreenOn isKeepScreenOn = " + z, new Object[0]);
            if (getKeepScreenOn() == z) {
                com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "setAdKeepScreenOn screen already set", new Object[0]);
                return;
            }
            try {
                setKeepScreenOn(z);
            } catch (Exception e) {
                com.hihonor.adsdk.common.b.b.hnadsb(getLogTag(), "setAdKeepScreenOn fail e = " + e.getMessage(), new Object[0]);
            }
        }
    }

    public void setDefaultDrawableColorId(int i) {
        this.mDefaultDrawableColorId = i;
    }

    public void setMuted(boolean z) {
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "setMute:" + z, new Object[0]);
        if (hasAdapter()) {
            this.mPlayerAdapter.hnadsc(z);
        }
        this.mIsMute = z;
    }

    protected void setVideoCoverImageVisibility(boolean z) {
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "setVideoCoverImageVisibility visible:" + z + "; mIsCompleted:" + this.mIsCompleted, new Object[0]);
        if (this.mIsCompleted && !isSupportReplay()) {
            this.adVideoCover.setVisibility(0);
            return;
        }
        RoundImageView roundImageView = this.adVideoCover;
        if (roundImageView != null) {
            int visibility = roundImageView.getVisibility();
            if (z && visibility != 0) {
                this.adVideoCover.clearAnimation();
                this.adVideoCover.setVisibility(0);
            } else if (z || visibility == 8) {
                com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "visible equal visbility", new Object[0]);
            } else {
                this.adVideoCover.setVisibility(8);
                this.coverAlpha = com.hihonor.adsdk.common.f.b.hnadsa(this.adVideoCover, TIME_LOADING_DISMISS, (com.hihonor.adsdk.common.f.b.c) null);
            }
        }
    }

    public void setVideoListener(OnVideoPlayListener onVideoPlayListener) {
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "setVideoListener", new Object[0]);
        this.mOnVideoPlayListener = onVideoPlayListener;
    }

    public void setVideoViewSize(AdVideoSize adVideoSize, int i, int i2) {
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "baseSize:" + i2, new Object[0]);
        if (adVideoSize == null) {
            if (hasAdapter()) {
                this.mPlayerAdapter.hnadsa(null, i, i2);
            }
            com.hihonor.adsdk.common.b.b.hnadse(getLogTag(), "sourceSize is null.", new Object[0]);
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "sourceSize width:" + adVideoSize.getWidth() + "; sourceSize height:" + adVideoSize.getHeight(), new Object[0]);
        AdVideoSize adVideoSizeHnadsa = f.hnadsa(adVideoSize, i, i2);
        this.calSize = adVideoSizeHnadsa;
        if (adVideoSizeHnadsa == null) {
            com.hihonor.adsdk.common.b.b.hnadse(getLogTag(), "calSize is null.", new Object[0]);
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "calSize width:" + this.calSize.getWidth() + "; height:" + this.calSize.getHeight(), new Object[0]);
        this.adaptSizeBaseMode = i;
        this.baseSize = i2;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.calSize.getWidth(), this.calSize.getHeight());
        } else {
            layoutParams.width = this.calSize.getWidth();
            layoutParams.height = this.calSize.getHeight();
        }
        setLayoutParams(layoutParams);
        showVideoImageCover(this.calSize.getWidth(), this.calSize.getHeight());
        this.mVideoReportBean.setMeasuredHeight(this.calSize.getHeight());
        this.mVideoReportBean.setMeasuredWidth(this.calSize.getWidth());
    }

    protected void showLoadingImage(boolean z) {
        HwProgressBar hwProgressBar;
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "showLoadingImage: " + z, new Object[0]);
        if (!isSupportLoading() || (hwProgressBar = this.mLoadingImage) == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "!mIsNeedShowLoading || mLoadingImage == null", new Object[0]);
            return;
        }
        if (z) {
            hwProgressBar.setVisibility(0);
            this.mLoadingImage.clearAnimation();
        } else {
            if (hwProgressBar.getVisibility() == 4) {
                return;
            }
            this.mLoadingImage.setVisibility(4);
            this.loadAlpha = com.hihonor.adsdk.common.f.b.hnadsa(this.mLoadingImage, TIME_LOADING_DISMISS, (com.hihonor.adsdk.common.f.b.c) null);
        }
    }

    protected void showVideoImageCover(int i, int i2) {
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "showVideoImageCover width:" + i + "; height:" + i2, new Object[0]);
        BaseAd baseAd = this.mBaseAd;
        if (baseAd == null || baseAd.getVideo() == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.adVideoCover.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.adVideoCover.setLayoutParams(layoutParams);
        GlideLoadBuild.Builder imageView = new GlideLoadBuild.Builder().setContext(this.mContext).setNeedReport(true).setUrl(this.mBaseAd.getVideo().getCoverUrl()).setImageView(this.adVideoCover);
        imageView.setBaseEventBean(com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.mBaseAd)).setAdUnitId(this.mBaseAd.getAdUnitId());
        if (isSupportCorner()) {
            float f = this.cornerRadius;
            if (f > 0.0f) {
                if (this.mPartCornerRadius == null) {
                    this.adVideoCover.setRadius(f);
                } else {
                    imageView.setCornerRadius((int) f);
                    imageView.setPartCornerRadiuss(this.mPartCornerRadius);
                }
            }
        }
        int i3 = this.mDefaultDrawableColorId;
        if (i3 != -1) {
            imageView.setDefaultDrawableColorId(i3);
        }
        if (this.mBaseAd.getTrackUrl() != null) {
            imageView.setCommonTrackUrls(this.mBaseAd.getTrackUrl().getCommons());
        }
        imageView.build().loadImage();
        refreshCoverImageVisibility();
    }

    public void start(String str, boolean z) {
        start(str, z, 0);
    }

    public HnBasePlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    private void checkBufferResult() {
        if (this.mPlayerAdapter != null) {
            com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "checkBufferResult state = " + this.mPlayerAdapter.hnadsg(), new Object[0]);
            if (this.mPlayerAdapter.hnadsg() == 1) {
                long jElapsedRealtime = this.startPlayTime;
                if (jElapsedRealtime != 0) {
                    jElapsedRealtime = SystemClock.elapsedRealtime() - this.startPlayTime;
                }
                long jHnadsb = this.mPlayerAdapter.hnadsb();
                int iHnadsa = this.mPlayerAdapter.hnadsa();
                com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "checkBufferResult bufferedPosition = " + jHnadsb + " bufferedPercentage = " + iHnadsa + " playTime = " + jElapsedRealtime, new Object[0]);
                VideoReportBean videoReportBean = this.mVideoReportBean;
                if (videoReportBean != null) {
                    videoReportBean.setBufferPercent(iHnadsa);
                    this.mVideoReportBean.setBufferPosition(jHnadsb);
                    this.mVideoReportBean.setStartToReleaseTime(jElapsedRealtime);
                }
                this.mPlayerReport.hnadsa(ErrorCode.AD_VIDEO_RELEASE_BEFORE_PLAY, ErrorCode.MSG_VIDEO_RELEASE_BEFORE_PLAY, 2);
            }
            this.startPlayTime = 0L;
        }
    }

    private void recordVideoDuration() {
        c cVar = this.mPlayerAdapter;
        if (cVar != null) {
            long jHnadsc = cVar.hnadsc();
            long jHnadsf = this.mPlayerAdapter.hnadsf();
            this.mVideoReportBean.setCurrentSecond(jHnadsc / 1000);
            if (jHnadsf != 0) {
                this.mVideoReportBean.setCurrentPercent((int) (((jHnadsc * 1.0f) / (jHnadsf * 1.0f)) * 100.0f));
            }
        }
    }

    private void releaseAnimation() {
        AlphaAnimation alphaAnimation = this.loadAlpha;
        if (alphaAnimation != null) {
            alphaAnimation.cancel();
            this.loadAlpha = null;
        }
        AlphaAnimation alphaAnimation2 = this.coverAlpha;
        if (alphaAnimation2 != null) {
            alphaAnimation2.cancel();
            this.coverAlpha = null;
        }
    }

    public void bindAd(BaseAd baseAd, int i) {
        com.hihonor.adsdk.common.b.b.hnadse(getLogTag(), "bindAd scene：" + i, new Object[0]);
        this.mBaseAd = baseAd;
        if (baseAd.getVideo() == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "bindAd but mBaseAd or getVideo is null.", new Object[0]);
            return;
        }
        initCornerRadius();
        this.mVideoAdapterId = this.mBaseAd.getRequestId() + this.mBaseAd.getAdId();
        this.mScene = i;
        Video video = this.mBaseAd.getVideo();
        this.mVideo = video;
        if (video != null) {
            this.mIsMute = video.getMute() == 0;
            this.mVideoUrl = this.mVideo.getVideoUrl();
        }
        setSceneKey(String.valueOf(i));
        initPlayerAdapter();
        this.mCacheManager = com.hihonor.adsdk.common.video.g.b.hnadsa().hnadsb();
        refreshCoverImageVisibility();
    }

    public void setVideoCoverScaleType(ImageView.ScaleType scaleType) {
        if (this.adVideoCover != null) {
            this.adVideoCover.setScaleType(getVideoCoverScaleType(scaleType));
        }
    }

    public void setVideoImageCoverHeight(int i) {
        RoundImageView roundImageView = this.adVideoCover;
        if (roundImageView != null) {
            ViewGroup.LayoutParams layoutParams = roundImageView.getLayoutParams();
            layoutParams.height = i;
            this.adVideoCover.setLayoutParams(layoutParams);
            this.adVideoCover.setVisibility(4);
        }
    }

    public HnBasePlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPlayerReport = new a();
        this.mVideoReportBean = new VideoReportBean();
        this.mDefaultDrawableColorId = -1;
        this.mIsReleased = false;
        this.mSceneKey = String.valueOf(1);
        initView(context);
    }

    public void setVideoReportBean(VideoReportBean videoReportBean) {
        this.mVideoReportBean = videoReportBean;
        AdVideoSize adVideoSize = this.calSize;
        if (adVideoSize != null) {
            videoReportBean.setMeasuredHeight(adVideoSize.getHeight());
            this.mVideoReportBean.setMeasuredWidth(this.calSize.getWidth());
        }
        this.mPlayerReport.hnadsa(this.mVideoReportBean, this.mBaseAd);
    }

    public void start(String str, boolean z, int i) {
        VideoReportBean videoReportBean = this.mVideoReportBean;
        if (videoReportBean != null) {
            videoReportBean.setPlayAction(i);
        }
        if (this.startPlayTime == 0) {
            this.startPlayTime = SystemClock.elapsedRealtime();
        }
        reportTriggerStart(i);
        com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "#start#Call player view start method#useCache:" + z, new Object[0]);
        if (getPlayState() == 0 || -1 == getPlayState() || 8 == getPlayState()) {
            if (TextUtils.isEmpty(str)) {
                String strHnadsa = com.hihonor.adsdk.common.video.e.a.hnadsa(com.hihonor.adsdk.common.video.e.hnadsb);
                com.hihonor.adsdk.common.b.b.hnadse(getLogTag(), "#start#Video start fail! Cause by %s", strHnadsa);
                onVideoError(com.hihonor.adsdk.common.video.e.hnadsb, strHnadsa, 0);
                return;
            }
            if (hasAdapter()) {
                this.mPlayerAdapter.hnadsb(z);
                if (z) {
                    if (!this.mCacheManager.hnadsa(this.mContext)) {
                        com.hihonor.adsdk.common.b.b.hnadse(getLogTag(), "start,mCacheProxy is null,online play", new Object[0]);
                        this.mPlayerAdapter.hnadsb(str);
                        this.mVideoReportBean.setSource(String.valueOf(3));
                        return;
                    }
                    startProxyUrl(str);
                    return;
                }
                this.mPlayerAdapter.hnadsb(str);
                this.mVideoReportBean.setSource(String.valueOf(3));
                return;
            }
            com.hihonor.adsdk.common.b.b.hnadse(getLogTag(), "start,none adapter!!!", new Object[0]);
            new x("", com.hihonor.adsdk.base.g.j.g.b.hnadsb(), ErrorCode.EX_VIDEO_ADAPTER_NULL, ErrorCode.STR_EX_VIDEO_ADAPTER_NULL).hnadse();
        }
    }

    private void startProxyUrl(String str) {
        String strValueOf;
        try {
            if (this.mPlayerAdapter == null) {
                return;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            boolean zHnadsa = this.mCacheManager.hnadsa(this.mContext, str);
            com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "isCached use Time :" + (SystemClock.elapsedRealtime() - jElapsedRealtime), new Object[0]);
            String strHnadsc = this.mCacheManager.hnadsc(this.mContext, str);
            com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "getCacheUrl use Time:" + (SystemClock.elapsedRealtime() - jElapsedRealtime), new Object[0]);
            this.mPlayerAdapter.hnadsb(strHnadsc);
            if (this.mCacheManager.hnadsa(this.mContext, str, strHnadsc)) {
                this.mVideoReportBean.setSource(String.valueOf(3));
                return;
            }
            VideoReportBean videoReportBean = this.mVideoReportBean;
            if (zHnadsa) {
                strValueOf = String.valueOf(1);
            } else {
                strValueOf = String.valueOf(0);
            }
            videoReportBean.setSource(strValueOf);
        } catch (Exception unused) {
            com.hihonor.adsdk.common.b.b.hnadsc(getLogTag(), "exception", new Object[0]);
        }
    }
}
