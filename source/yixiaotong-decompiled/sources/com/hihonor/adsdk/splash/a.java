package com.hihonor.adsdk.splash;

import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.bean.Video;
import com.hihonor.adsdk.base.bean.VideoReportBean;
import com.hihonor.adsdk.base.player.HnSplashPlayerView;
import com.hihonor.adsdk.common.video.OnVideoPlayListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {
    private static final String c = "SplashVideoManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HnSplashPlayerView f3579a;
    private final OnVideoPlayListener b = new C0472a();

    /* JADX INFO: renamed from: com.hihonor.adsdk.splash.a$a, reason: collision with other inner class name */
    class C0472a extends OnVideoPlayListener {
        C0472a() {
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onProgressUpdate(long j, long j2, long j3) {
            com.hihonor.adsdk.common.b.b.hnadsa(a.c, (Object) ("reward===>onProgressUpdate,position: " + j + ",bufferPosition:" + j2 + ",duration:" + j3));
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onVideoBuffering(boolean z) {
            com.hihonor.adsdk.common.b.b.hnadsc(a.c, "reward--->onVideoBuffering,isBuffering:" + z, new Object[0]);
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onVideoEnd() {
            com.hihonor.adsdk.common.b.b.hnadsc(a.c, "reward===>onVideoEnd", new Object[0]);
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onVideoError(int i, String str) {
            com.hihonor.adsdk.common.b.b.hnadsc(a.c, "reward--->onVideoError,errorCode: " + i + ",message: " + str, new Object[0]);
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onVideoMute(boolean z) {
            com.hihonor.adsdk.common.b.b.hnadsc(a.c, "reward--->onVideoMute,isMute: " + z, new Object[0]);
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onVideoPause() {
            com.hihonor.adsdk.common.b.b.hnadsc(a.c, "reward--->onVideoPause", new Object[0]);
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onVideoResume() {
            com.hihonor.adsdk.common.b.b.hnadsc(a.c, "reward===>onVideoResume", new Object[0]);
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onVideoStart() {
            com.hihonor.adsdk.common.b.b.hnadsc(a.c, "reward--->onVideoStart,mVideoPlayFirstTime: ", new Object[0]);
        }
    }

    public a(HnSplashPlayerView hnSplashPlayerView) {
        this.f3579a = hnSplashPlayerView;
    }

    public void a(BaseAd baseAd) {
        if (baseAd == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(c, "setVideoView: baseAd is null", new Object[0]);
            return;
        }
        Video video = baseAd.getVideo();
        if (video == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(c, "setVideoView: video is null", new Object[0]);
            return;
        }
        this.f3579a.bindAd(baseAd);
        VideoReportBean videoReportBean = new VideoReportBean();
        videoReportBean.setHasVoice(String.valueOf(video.getMute()));
        videoReportBean.setScene(String.valueOf(1));
        videoReportBean.setVideoType(String.valueOf(3));
        this.f3579a.setVideoReportBean(videoReportBean);
        this.f3579a.setVideoListener(this.b);
        this.f3579a.setMuted(true);
    }

    public void a() {
        HnSplashPlayerView hnSplashPlayerView = this.f3579a;
        if (hnSplashPlayerView != null) {
            hnSplashPlayerView.release();
        }
    }
}
