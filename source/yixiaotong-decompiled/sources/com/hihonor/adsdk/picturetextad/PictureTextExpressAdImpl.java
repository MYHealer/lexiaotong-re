package com.hihonor.adsdk.picturetextad;

import android.view.View;
import android.widget.ImageView;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.api.AdVideo;
import com.hihonor.adsdk.base.api.BaseExpressAdImpl;
import com.hihonor.adsdk.base.api.CustomVideo;
import com.hihonor.adsdk.base.api.feed.AdDislike;
import com.hihonor.adsdk.base.api.feed.PictureTextExpressAd;
import com.hihonor.adsdk.base.bean.BaseAdInfo;
import com.hihonor.adsdk.base.bean.Video;
import com.hihonor.adsdk.base.bean.VideoReportBean;
import com.hihonor.adsdk.base.download.OnDownloadStatusChangedListener;
import com.hihonor.adsdk.base.player.HnBasePlayerView;
import com.hihonor.adsdk.base.widget.base.BaseAdView;
import com.hihonor.adsdk.common.video.AdVideoSize;
import com.hihonor.adsdk.common.video.OnVideoPlayListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class PictureTextExpressAdImpl extends BaseExpressAdImpl implements PictureTextExpressAd, AdVideo {
    private static final String TAG_LOG = "PictureTextExpressAdImpl";
    private boolean isMediaUseCustomVideo;
    private AdDislike mAdDislike;
    private HnBasePlayerView mAdPlayerView;
    private final CustomVideo mCustomVideo;
    private com.hihonor.adsdk.base.player.a mPlayerReport;

    class a implements CustomVideo {
        a() {
        }

        @Override // com.hihonor.adsdk.base.api.CustomVideo
        public String getVideoUrl() {
            Video video = PictureTextExpressAdImpl.this.getVideo();
            return video == null ? "" : video.getVideoUrl();
        }

        @Override // com.hihonor.adsdk.base.api.CustomVideo
        public void reportVideoEnd() {
            if (PictureTextExpressAdImpl.this.mPlayerReport != null) {
                PictureTextExpressAdImpl.this.mPlayerReport.hnadsb(1);
                PictureTextExpressAdImpl.this.mPlayerReport.hnadsd();
            }
        }

        @Override // com.hihonor.adsdk.base.api.CustomVideo
        public void reportVideoError(int i, String str) {
            if (PictureTextExpressAdImpl.this.mPlayerReport != null) {
                PictureTextExpressAdImpl.this.mPlayerReport.hnadsb(1);
                PictureTextExpressAdImpl.this.mPlayerReport.hnadsa(i, str, 0);
            }
        }

        @Override // com.hihonor.adsdk.base.api.CustomVideo
        public void reportVideoPause() {
            if (PictureTextExpressAdImpl.this.mPlayerReport != null) {
                PictureTextExpressAdImpl.this.mPlayerReport.hnadsb(1);
                PictureTextExpressAdImpl.this.mPlayerReport.hnadse();
            }
        }

        @Override // com.hihonor.adsdk.base.api.CustomVideo
        public void reportVideoResume() {
            if (PictureTextExpressAdImpl.this.mPlayerReport != null) {
                PictureTextExpressAdImpl.this.mPlayerReport.hnadsb(1);
                PictureTextExpressAdImpl.this.mPlayerReport.hnadsi();
            }
        }

        @Override // com.hihonor.adsdk.base.api.CustomVideo
        public void reportVideoStart() {
            if (PictureTextExpressAdImpl.this.mPlayerReport != null) {
                PictureTextExpressAdImpl.this.mPlayerReport.hnadsb(1);
                PictureTextExpressAdImpl.this.mPlayerReport.hnadsf();
            }
        }
    }

    public PictureTextExpressAdImpl(BaseAdInfo baseAdInfo) {
        this(null, baseAdInfo);
    }

    @Override // com.hihonor.adsdk.base.api.feed.PictureTextExpressAd
    public AdVideo getAdVideo() {
        return this;
    }

    @Override // com.hihonor.adsdk.base.api.AdVideo
    public int getAutoPlay() {
        Video video = getVideo();
        if (video != null) {
            return video.getAutoPlay();
        }
        return 3;
    }

    @Override // com.hihonor.adsdk.base.api.feed.PictureTextExpressAd
    public String getCoverUrl() {
        Video video = getVideo();
        return video != null ? video.getCoverUrl() : "";
    }

    @Override // com.hihonor.adsdk.base.api.feed.PictureTextExpressAd
    public CustomVideo getCustomVideo() {
        this.isMediaUseCustomVideo = true;
        return this.mCustomVideo;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAdImpl, com.hihonor.adsdk.base.api.BaseExpressAd
    public View getExpressAdView() {
        if (this.hnadsg == null && this.hnadsl == 0) {
            this.hnadsg = f.a(HnAds.get().getContext(), this);
        }
        return super.getExpressAdView();
    }

    @Override // com.hihonor.adsdk.base.api.AdVideo
    public View getPureVideoView() {
        return getPureVideoView(null);
    }

    @Override // com.hihonor.adsdk.base.api.feed.PictureTextExpressAd
    public long getVideoDuration() {
        Video video = getVideo();
        if (video != null) {
            return video.getVideoDuration();
        }
        return 0L;
    }

    @Override // com.hihonor.adsdk.base.api.feed.PictureTextExpressAd
    public int getVideoHeight() {
        Video video = getVideo();
        if (video != null) {
            return video.getVideoHeight();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.AdVideo
    public View getVideoView() {
        return getVideoView(null);
    }

    @Override // com.hihonor.adsdk.base.api.feed.PictureTextExpressAd
    public int getVideoWidth() {
        Video video = getVideo();
        if (video != null) {
            return video.getVideoWidth();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.feed.PictureTextExpressAd
    public boolean hasVideo() {
        return getVideo() != null;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAdImpl, com.hihonor.adsdk.base.api.BaseAdImpl, com.hihonor.adsdk.base.api.BaseAd
    public boolean isMediaUseCustomVideo() {
        return this.isMediaUseCustomVideo;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAdImpl, com.hihonor.adsdk.base.api.BaseExpressAd
    public void release() {
        super.release();
        com.hihonor.adsdk.base.download.d.hnadsa().hnadsb(a());
        if (this.mAdPlayerView != null) {
            com.hihonor.adsdk.common.b.b.hnadsc(TAG_LOG, "playerView#release", new Object[0]);
            this.mAdPlayerView.release();
        }
        if (this.mAdDislike != null) {
            this.mAdDislike = null;
        }
    }

    @Override // com.hihonor.adsdk.base.api.feed.PictureTextExpressAd
    public void setDownloadStatusChange(OnDownloadStatusChangedListener onDownloadStatusChangedListener) {
        com.hihonor.adsdk.base.download.d.hnadsa().hnadsa(a(), onDownloadStatusChangedListener);
    }

    @Override // com.hihonor.adsdk.base.api.AdVideo
    public void setVideoListener(OnVideoPlayListener onVideoPlayListener) {
        com.hihonor.adsdk.common.b.b.hnadsc(TAG_LOG, "#setVideoListener#mAdPlayerView --------- " + this.mAdPlayerView, new Object[0]);
        HnBasePlayerView hnBasePlayerView = this.mAdPlayerView;
        if (hnBasePlayerView != null) {
            hnBasePlayerView.setVideoListener(onVideoPlayListener);
        }
    }

    @Override // com.hihonor.adsdk.base.api.AdVideo
    public void start(boolean z) {
        Video video = getVideo();
        String videoUrl = video != null ? video.getVideoUrl() : "";
        HnBasePlayerView hnBasePlayerView = this.mAdPlayerView;
        if (hnBasePlayerView != null) {
            hnBasePlayerView.start(videoUrl, z, 1);
        }
    }

    public PictureTextExpressAdImpl(BaseAdView baseAdView, BaseAdInfo baseAdInfo) {
        super(baseAdView, baseAdInfo);
        this.isMediaUseCustomVideo = false;
        this.mCustomVideo = new a();
        Video video = getVideo();
        if (hasVideo()) {
            VideoReportBean videoReportBean = new VideoReportBean();
            videoReportBean.setAuStart(String.valueOf(video.getAutoPlay()));
            videoReportBean.setHasVoice(String.valueOf(video.getMute()));
            videoReportBean.setScene(String.valueOf(1));
            videoReportBean.setVideoType(String.valueOf(0));
            com.hihonor.adsdk.base.player.a aVar = new com.hihonor.adsdk.base.player.a();
            this.mPlayerReport = aVar;
            aVar.hnadsa(videoReportBean, this);
        }
    }

    private View a(AdVideoSize adVideoSize, int i) {
        if (this.hnadsg != null || !hasVideo()) {
            return null;
        }
        HnBasePlayerView hnBasePlayerView = this.mAdPlayerView;
        if (hnBasePlayerView == null || hnBasePlayerView.isReleased()) {
            this.mAdPlayerView = com.hihonor.adsdk.base.player.b.hnadsa(HnAds.get().getContext(), this, adVideoSize, i);
        } else {
            a(adVideoSize);
        }
        return this.mAdPlayerView;
    }

    @Override // com.hihonor.adsdk.base.api.feed.PictureTextExpressAd
    public AdDislike getAdDislike() {
        if (this.mAdDislike == null) {
            this.mAdDislike = new com.hihonor.adsdk.base.api.feed.a(this);
        }
        return this.mAdDislike;
    }

    @Override // com.hihonor.adsdk.base.api.AdVideo
    public int getPlayerState() {
        HnBasePlayerView hnBasePlayerView = this.mAdPlayerView;
        if (hnBasePlayerView != null) {
            return hnBasePlayerView.getPlayState();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.AdVideo
    public View getPureVideoView(AdVideoSize adVideoSize) {
        return a(adVideoSize, 1);
    }

    @Override // com.hihonor.adsdk.base.api.AdVideo
    public View getVideoView(AdVideoSize adVideoSize) {
        return a(adVideoSize, 0);
    }

    @Override // com.hihonor.adsdk.base.api.AdVideo
    public boolean isMuted() {
        HnBasePlayerView hnBasePlayerView = this.mAdPlayerView;
        if (hnBasePlayerView != null) {
            return hnBasePlayerView.isMuted();
        }
        return false;
    }

    @Override // com.hihonor.adsdk.base.api.AdVideo
    public void pause() {
        HnBasePlayerView hnBasePlayerView = this.mAdPlayerView;
        if (hnBasePlayerView != null) {
            hnBasePlayerView.pause();
        }
    }

    @Override // com.hihonor.adsdk.base.api.AdVideo
    public void releasePlayer() {
        HnBasePlayerView hnBasePlayerView = this.mAdPlayerView;
        if (hnBasePlayerView != null) {
            hnBasePlayerView.release();
        }
    }

    @Override // com.hihonor.adsdk.base.api.AdVideo
    public void replay() {
        HnBasePlayerView hnBasePlayerView = this.mAdPlayerView;
        if (hnBasePlayerView != null) {
            hnBasePlayerView.replay();
        }
    }

    @Override // com.hihonor.adsdk.base.api.AdVideo
    public void resume() {
        HnBasePlayerView hnBasePlayerView = this.mAdPlayerView;
        if (hnBasePlayerView != null) {
            hnBasePlayerView.resume();
        }
    }

    @Override // com.hihonor.adsdk.base.api.AdVideo
    public void setMuted(boolean z) {
        HnBasePlayerView hnBasePlayerView = this.mAdPlayerView;
        if (hnBasePlayerView != null) {
            hnBasePlayerView.setMuted(z);
        }
    }

    @Override // com.hihonor.adsdk.base.api.AdVideo
    public void setVideoCoverScaleType(ImageView.ScaleType scaleType) {
        HnBasePlayerView hnBasePlayerView = this.mAdPlayerView;
        if (hnBasePlayerView != null) {
            hnBasePlayerView.setVideoCoverScaleType(scaleType);
        }
    }

    @Override // com.hihonor.adsdk.base.api.AdVideo
    public void start() {
        start(false);
    }

    public void a(AdVideoSize adVideoSize) {
        if (adVideoSize == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(TAG_LOG, "#setVideoSize#mediaVideoSize is null.", new Object[0]);
            return;
        }
        Video video = getVideo();
        if (video == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(TAG_LOG, "#setVideoSize#video is null.", new Object[0]);
            return;
        }
        AdVideoSize adVideoSize2 = new AdVideoSize(video.getVideoWidth(), video.getVideoHeight());
        if (video.getVideoWidth() >= video.getVideoHeight()) {
            this.mAdPlayerView.setVideoViewSize(adVideoSize2, 1, adVideoSize.getWidth());
        } else {
            this.mAdPlayerView.setVideoViewSize(adVideoSize2, 2, adVideoSize.getHeight());
        }
    }

    private String a() {
        return getAppPackage();
    }
}
