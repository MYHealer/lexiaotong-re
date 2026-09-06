package com.hihonor.adsdk.base.player;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.ViewGroup;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.bean.Video;
import com.hihonor.adsdk.base.net.glide.GlideLoadBuild;
import com.hihonor.adsdk.common.f.u;
import com.hihonor.adsdk.common.video.AdVideoSize;
import com.hihonor.adsdk.common.video.f;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class HnSplashPlayerView extends HnBasePlayerView {
    private static final String LOG_TAG = "HnSplashPlayerView";
    private boolean isVideoCut;

    public HnSplashPlayerView(Context context) {
        super(context);
        this.isVideoCut = true;
    }

    @Override // com.hihonor.adsdk.base.player.HnBasePlayerView
    protected String getLogTag() {
        return LOG_TAG + hashCode();
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
        Video video = this.mVideo;
        if (video != null) {
            start(video.getVideoUrl(), true);
            resume();
        }
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

    public void setVideoCut(boolean z) {
        this.isVideoCut = z;
    }

    @Override // com.hihonor.adsdk.base.player.HnBasePlayerView
    public void setVideoViewSize(AdVideoSize adVideoSize, int i, int i2) {
        if (this.mTextureView == null) {
            com.hihonor.adsdk.common.b.b.hnadse(LOG_TAG, "mTextureView is null.", new Object[0]);
            return;
        }
        if (!this.isVideoCut) {
            super.setVideoViewSize(adVideoSize, i, i2);
            return;
        }
        if (adVideoSize == null) {
            if (hasAdapter()) {
                this.mPlayerAdapter.hnadsa(null, i, i2);
            }
            com.hihonor.adsdk.common.b.b.hnadse(LOG_TAG, "sourceSize is null.", new Object[0]);
            return;
        }
        AdVideoSize adVideoSizeHnadsa = f.hnadsa(adVideoSize, i, i2);
        this.calSize = adVideoSizeHnadsa;
        if (adVideoSizeHnadsa == null) {
            com.hihonor.adsdk.common.b.b.hnadse(LOG_TAG, "calSize is null.", new Object[0]);
            return;
        }
        this.adaptSizeBaseMode = i;
        this.baseSize = i2;
        int iHnadsg = u.hnadsg();
        int iHnadsd = u.hnadsd();
        int width = adVideoSize.getWidth();
        int height = adVideoSize.getHeight();
        float f = iHnadsg;
        float f2 = width;
        float f3 = f / f2;
        float f4 = iHnadsd;
        float f5 = height;
        float f6 = f4 / f5;
        com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, "setVideoViewSize----------->sx:" + f3 + ",sy:" + f6, new Object[0]);
        Matrix matrix = new Matrix();
        float fMax = Math.max(f3, f6);
        matrix.preTranslate((iHnadsg - width) / 2.0f, (iHnadsd - height) / 2.0f);
        matrix.preScale(f2 / f, f5 / f4);
        matrix.postScale(fMax, fMax, f / 2.0f, f4 / 2.0f);
        ((TextureView) this.mTextureView).setTransform(matrix);
        ((TextureView) this.mTextureView).postInvalidate();
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

    @Override // com.hihonor.adsdk.base.player.HnBasePlayerView
    protected void showVideoImageCover(int i, int i2) {
        if (!this.isVideoCut) {
            super.showVideoImageCover(i, i2);
            return;
        }
        BaseAd baseAd = this.mBaseAd;
        if (baseAd == null || baseAd.getVideo() == null) {
            return;
        }
        GlideLoadBuild.Builder imageView = new GlideLoadBuild.Builder().setContext(this.mContext).setNeedReport(true).setUrl(this.mBaseAd.getVideo().getCoverUrl()).setImageView(this.adVideoCover);
        imageView.setCornerRadius(0);
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

    public HnSplashPlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isVideoCut = true;
    }

    public HnSplashPlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isVideoCut = true;
    }
}
