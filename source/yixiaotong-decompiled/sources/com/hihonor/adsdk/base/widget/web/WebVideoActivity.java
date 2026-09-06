package com.hihonor.adsdk.base.widget.web;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.bean.Video;
import com.hihonor.adsdk.base.bean.VideoReportBean;
import com.hihonor.adsdk.base.bean.f;
import com.hihonor.adsdk.base.g.j.d.x;
import com.hihonor.adsdk.base.j.h;
import com.hihonor.adsdk.base.j.j;
import com.hihonor.adsdk.base.player.HnWebPlayerView;
import com.hihonor.adsdk.base.widget.RadiusFrameLayout;
import com.hihonor.adsdk.base.widget.download.HnDownloadButton;
import com.hihonor.adsdk.common.f.k;
import com.hihonor.adsdk.common.f.u;
import com.hihonor.adsdk.common.safe.SafeIntent;
import com.hihonor.adsdk.common.video.AdVideoSize;
import com.hihonor.adsdk.common.video.OnVideoPlayListener;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class WebVideoActivity extends WebCommonActivity {
    protected static final String x = "WebVideoActivity";
    private static final String y = "scene_source";
    protected static final String z = "is_media_use_custom_video";
    private HnWebPlayerView l;
    private View m;
    private View n;
    private TextView o;
    private View p;
    private Video q;
    private ImageView r;
    private View s;
    private RadiusFrameLayout u;
    private boolean v;
    private boolean t = false;
    private final OnVideoPlayListener w = new a();

    class a extends OnVideoPlayListener {
        a() {
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onProgressUpdate(long j, long j2, long j3) {
            String strHnadsa = com.hihonor.adsdk.base.player.b.hnadsa(j, j3);
            if (WebVideoActivity.this.o != null) {
                WebVideoActivity.this.o.setText(strHnadsa);
            }
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onVideoBuffering(boolean z) {
            com.hihonor.adsdk.common.b.b.hnadsc(WebVideoActivity.x, "web--->onVideoBuffering,isBuffering:" + z, new Object[0]);
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onVideoEnd() {
            com.hihonor.adsdk.common.b.b.hnadsc(WebVideoActivity.x, "web--->onVideoEnd", new Object[0]);
            WebVideoActivity.this.hnadsa(true);
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onVideoError(int i, String str) {
            com.hihonor.adsdk.common.b.b.hnadsc(WebVideoActivity.x, "web--->onVideoError,errorCode: " + i + ",message: " + str, new Object[0]);
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onVideoMute(boolean z) {
            com.hihonor.adsdk.common.b.b.hnadsc(WebVideoActivity.x, "web--->onVideoMute,isMute: " + z, new Object[0]);
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onVideoPause() {
            com.hihonor.adsdk.common.b.b.hnadsc(WebVideoActivity.x, "web--->onVideoPause", new Object[0]);
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onVideoResume() {
            com.hihonor.adsdk.common.b.b.hnadsc(WebVideoActivity.x, "web--->onVideoResume", new Object[0]);
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onVideoStart() {
            WebVideoActivity.this.hnadsa(false);
            com.hihonor.adsdk.common.b.b.hnadsc(WebVideoActivity.x, "web--->onVideoStart", new Object[0]);
        }
    }

    class b implements Runnable {
        final /* synthetic */ int hnadsd;

        b(int i) {
            this.hnadsd = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            WebVideoActivity webVideoActivity = WebVideoActivity.this;
            webVideoActivity.hnadse(this.hnadsd + webVideoActivity.l.getHeight());
        }
    }

    private int b() {
        return R.layout.honor_ads_web_video_landingpage_bottom;
    }

    private void c() {
        int iHnadsg = u.hnadsg();
        int iHnadsd = u.hnadsd();
        com.hihonor.adsdk.common.b.b.hnadsc(x, "initVideoLayout,screenWidth: " + iHnadsg + "screenHeight:" + iHnadsd, new Object[0]);
        Video video = this.q;
        if (video == null || this.l == null) {
            com.hihonor.adsdk.common.b.b.hnadse(x, "initVideoLayout,mVideo or adPlayerView is null,return", new Object[0]);
            return;
        }
        AdVideoSize adVideoSize = new AdVideoSize(video.getVideoWidth(), this.q.getVideoHeight());
        if (this.q.getVideoWidth() < this.q.getVideoHeight() || j.hnadsl()) {
            this.l.setVideoViewSize(adVideoSize, 2, u.hnadsa(202.0f));
        } else {
            this.l.setVideoViewSize(adVideoSize, 1, Math.min(iHnadsg, iHnadsd));
        }
        f();
        hnadsa(this.l.getPlayState() == 8);
    }

    private void d() {
        try {
            View viewInflate = ((ViewStub) findViewById(R.id.ad_web_video_stub)).inflate();
            this.s = viewInflate;
            if (viewInflate == null) {
                com.hihonor.adsdk.common.b.b.hnadse(x, "initVideoPlayerView,mVideoStubView is null,return", new Object[0]);
                return;
            }
            this.l = (HnWebPlayerView) viewInflate.findViewById(R.id.ad_player_view);
            this.m = this.s.findViewById(R.id.ad_video_volume_time_layout);
            this.n = this.s.findViewById(R.id.ad_video_volume);
            this.r = (ImageView) findViewById(R.id.ad_video_volume_view);
            this.o = (TextView) this.s.findViewById(R.id.ad_video_time);
            HnWebPlayerView hnWebPlayerView = this.l;
            if (hnWebPlayerView != null) {
                hnWebPlayerView.setOnDisConnectListener(new HnWebPlayerView.a() { // from class: com.hihonor.adsdk.base.widget.web.WebVideoActivity$$ExternalSyntheticLambda0
                    @Override // com.hihonor.adsdk.base.player.HnWebPlayerView.a
                    public final void disConnect() {
                        this.f$0.finish();
                    }
                });
                this.l.bindAd((BaseAd) this.hnadsg, 0);
                c();
                VideoReportBean videoReportBean = new VideoReportBean();
                videoReportBean.setHasVoice(String.valueOf(1));
                videoReportBean.setScene(String.valueOf(0));
                int adType = ((BaseAd) this.hnadsg).getAdType();
                if (adType == 2) {
                    videoReportBean.setVideoType(String.valueOf(0));
                } else if (adType == 4) {
                    videoReportBean.setVideoType(String.valueOf(1));
                }
                this.l.setVideoReportBean(videoReportBean);
                this.l.setVideoListener(this.w);
                this.l.play();
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
            layoutParams.addRule(3, R.id.ad_web_video_container);
            this.c.setLayoutParams(layoutParams);
            e();
            if (this.o != null) {
                this.o.setText(com.hihonor.adsdk.base.player.b.hnadsa(0L, ((long) this.q.getVideoDuration()) * 1000));
            }
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(x, "initVideoPlayerView, exception: " + e.getMessage(), new Object[0]);
        }
    }

    @Override // com.hihonor.adsdk.base.widget.web.WebCommonActivity, com.hihonor.adsdk.base.widget.base.c
    protected void hnadsv() {
        super.hnadsv();
        this.t = new SafeIntent(getIntent()).getBooleanExtra(z, false);
        T t = this.hnadsg;
        if (t == 0 || ((BaseAd) t).getVideo() == null) {
            return;
        }
        Video video = ((BaseAd) this.hnadsg).getVideo();
        this.q = video;
        boolean z2 = video.getLandingPagePlay() == 1;
        this.v = z2;
        if (z2) {
            setRequestedOrientation(1);
            d();
        }
    }

    @Override // com.hihonor.adsdk.base.widget.web.WebCommonActivity
    protected int hnadsx() {
        return R.drawable.honor_ads_bg_shadow_top_video;
    }

    @Override // com.hihonor.adsdk.base.widget.web.WebCommonActivity
    protected View hnadsy() {
        return com.hihonor.adsdk.base.player.b.hnadsa((Context) this, (BaseAd) this.hnadsg, true, b());
    }

    @Override // com.hihonor.adsdk.base.widget.base.f, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.hihonor.adsdk.common.b.b.hnadsc(x, "onDestroy", new Object[0]);
        if (this.l != null) {
            com.hihonor.adsdk.common.b.b.hnadsc(x, "web---------------->onDestroy: isMediaUseCustomVideo " + this.t, new Object[0]);
            if (this.t) {
                this.l.release();
            } else {
                this.l.releaseOrRemove();
            }
        }
    }

    private void e() {
        HnWebPlayerView hnWebPlayerView = this.l;
        if (hnWebPlayerView != null) {
            hnWebPlayerView.setMuted(false);
        }
        hnadsb(false);
        View view = this.n;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.base.widget.web.WebVideoActivity$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.hnadse(view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadse(View view) {
        HnWebPlayerView hnWebPlayerView = this.l;
        if (hnWebPlayerView != null) {
            boolean zIsMuted = hnWebPlayerView.isMuted();
            com.hihonor.adsdk.common.b.b.hnadsc(x, "onClick,muted: " + zIsMuted, new Object[0]);
            boolean z2 = !zIsMuted;
            this.l.setMuted(z2);
            hnadsb(z2);
        }
    }

    @Override // com.hihonor.adsdk.base.widget.web.WebCommonActivity
    protected void hnadsf(int i) {
        HnWebPlayerView hnWebPlayerView = this.l;
        if (hnWebPlayerView != null) {
            hnWebPlayerView.post(new b(i));
        } else {
            hnadse(i);
        }
    }

    public static void hnadsa(BaseAd baseAd, int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(x, "startWebTargetPage", new Object[0]);
        Bundle bundle = new Bundle();
        bundle.putParcelable("info", baseAd);
        bundle.putInt(y, i);
        bundle.putBoolean(z, baseAd.isMediaUseCustomVideo());
        f fVarHnadsa = h.hnadsa(WebVideoActivity.class, bundle);
        if (fVarHnadsa.hnadsa() != 0) {
            new x(Objects.nonNull(baseAd) ? baseAd.getAdUnitId() : "", com.hihonor.adsdk.base.g.j.g.b.hnadsb(), ErrorCode.AD_CODE_START_ACTIVITY_FAILED, fVarHnadsa.hnadsb()).hnadsa("code", String.valueOf(fVarHnadsa.hnadsa())).hnadse();
        }
    }

    private void hnadsb(boolean z2) {
        ImageView imageView = this.r;
        if (imageView == null) {
            com.hihonor.adsdk.common.b.b.hnadse(x, "setVolumeDrawable,adVideoVolumeView is null,return", new Object[0]);
        } else if (z2) {
            imageView.setImageDrawable(k.hnadsa(this, R.drawable.ic_honor_ads_volume_off));
        } else {
            imageView.setImageDrawable(k.hnadsa(this, R.drawable.ic_honor_ads_volume_on));
        }
    }

    private void f() {
        View view = this.s;
        if (view != null && this.l != null) {
            View viewFindViewById = view.findViewById(R.id.ad_web_video_container);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewFindViewById.getLayoutParams();
            layoutParams.addRule(3, R.id.ad_common_web_title_layout);
            AdVideoSize finalPlayerSize = this.l.getFinalPlayerSize();
            int iHnadsg = u.hnadsg();
            int iHnadsd = u.hnadsd();
            com.hihonor.adsdk.common.b.b.hnadsc(x, "initVolumeAndTimeLayout,screenWidth: " + iHnadsg + "screenHeight:" + iHnadsd, new Object[0]);
            layoutParams.width = Math.min(iHnadsg, iHnadsd);
            if (finalPlayerSize != null) {
                layoutParams.height = finalPlayerSize.getHeight();
            }
            viewFindViewById.setLayoutParams(layoutParams);
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadse(x, "initVolumeAndTimeLayout,mVideoStubView is null,return", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsf(View view) {
        com.hihonor.adsdk.common.b.b.hnadsc(x, "webVideo replay--->start", new Object[0]);
        HnWebPlayerView hnWebPlayerView = this.l;
        if (hnWebPlayerView != null) {
            hnWebPlayerView.replay();
        }
    }

    @Override // com.hihonor.adsdk.base.widget.web.WebCommonActivity
    protected void hnadsa(Configuration configuration) {
        com.hihonor.adsdk.common.b.b.hnadsc(x, "onChildConfigurationChanged#web video page orientation: " + configuration.orientation, new Object[0]);
        if (this.q == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(x, "onChildConfigurationChanged#video is null.", new Object[0]);
        } else {
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hnadsa(boolean z2) {
        com.hihonor.adsdk.common.b.b.hnadsc(x, "setPlayFinishLayout,visible: " + z2, new Object[0]);
        View view = this.m;
        if (view != null) {
            view.setVisibility(z2 ? 8 : 0);
        }
        if (z2 && this.p == null) {
            try {
                View viewInflate = ((ViewStub) findViewById(R.id.ad_end_stub)).inflate();
                this.p = viewInflate;
                if (viewInflate == null) {
                    com.hihonor.adsdk.common.b.b.hnadse(x, "mEndStubView is null,return", new Object[0]);
                    return;
                }
                RadiusFrameLayout radiusFrameLayout = (RadiusFrameLayout) viewInflate.findViewById(R.id.ad_video_end_root);
                this.u = radiusFrameLayout;
                radiusFrameLayout.setBackgroundColor(getResources().getColor(R.color.honor_ads_magic_mask_regular_dark));
                View viewFindViewById = this.p.findViewById(R.id.ad_video_replay);
                if (viewFindViewById != null) {
                    viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.base.widget.web.WebVideoActivity$$ExternalSyntheticLambda2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            this.f$0.hnadsf(view2);
                        }
                    });
                }
                HnDownloadButton hnDownloadButton = (HnDownloadButton) findViewById(R.id.ad_download);
                if (hnDownloadButton != null) {
                    if (((BaseAd) this.hnadsg).getPromotionPurpose() != 0 && ((BaseAd) this.hnadsg).getPromotionPurpose() != 4) {
                        hnDownloadButton.setVisibility(8);
                    } else {
                        hnDownloadButton.setBaseAd(this.hnadsg, 0);
                        hnDownloadButton.setTag(R.id.ad_common_click_type_tag, 1);
                    }
                }
            } catch (Exception e) {
                com.hihonor.adsdk.common.b.b.hnadsb(x, "setPlayFinishLayout, exception: " + e.getMessage(), new Object[0]);
            }
        }
        RadiusFrameLayout radiusFrameLayout2 = this.u;
        if (radiusFrameLayout2 != null && this.l != null) {
            ViewGroup.LayoutParams layoutParams = radiusFrameLayout2.getLayoutParams();
            AdVideoSize finalPlayerSize = this.l.getFinalPlayerSize();
            int iHnadsg = u.hnadsg();
            int iHnadsd = u.hnadsd();
            com.hihonor.adsdk.common.b.b.hnadsc(x, "setPlayFinishLayout,screenWidth: " + iHnadsg + "screenHeight:" + iHnadsd, new Object[0]);
            int iMin = Math.min(iHnadsg, iHnadsd);
            layoutParams.width = iMin;
            com.hihonor.adsdk.common.b.b.hnadsc(x, "setPlayFinishLayout width--->" + iMin, new Object[0]);
            if (finalPlayerSize != null) {
                layoutParams.height = finalPlayerSize.getHeight();
            }
            this.u.setLayoutParams(layoutParams);
        }
        View view2 = this.p;
        if (view2 != null) {
            view2.setVisibility(z2 ? 0 : 8);
        }
    }
}
