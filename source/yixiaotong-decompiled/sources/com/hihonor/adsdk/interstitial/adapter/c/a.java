package com.hihonor.adsdk.interstitial.adapter.c;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.bean.Video;
import com.hihonor.adsdk.base.bean.VideoReportBean;
import com.hihonor.adsdk.base.g.j.d.h;
import com.hihonor.adsdk.base.g.j.d.x;
import com.hihonor.adsdk.base.g.k.c.u;
import com.hihonor.adsdk.base.player.HnInterstitialPlayerView;
import com.hihonor.adsdk.common.f.k;
import com.hihonor.adsdk.common.f.q;
import com.hihonor.adsdk.common.video.AdVideoSize;
import com.hihonor.adsdk.common.video.OnVideoPlayListener;
import com.hihonor.adsdk.interstitial.R;
import com.huawei.openalliance.ad.constant.ba;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a extends com.hihonor.adsdk.interstitial.adapter.a {
    protected static final int B = 12;
    private static final String C = "InterstitialVideoBaseAdapter";
    private static final int D = 1003;
    private static final long E = 5000;
    protected HnInterstitialPlayerView h;
    protected Video i;
    private Handler j;
    private int k;
    private int l;
    private TextView m;
    private View n;
    private TextView o;
    private ImageView p;
    private ImageView q;
    private ImageView r;
    private LinearLayout s;
    private boolean v;
    private TextView w;
    private ConstraintLayout x;
    private LinearLayout y;
    private View z;
    private final int t = 0;
    private final int u = -1;
    private final OnVideoPlayListener A = new b();

    /* JADX INFO: renamed from: com.hihonor.adsdk.interstitial.adapter.c.a$a, reason: collision with other inner class name */
    class HandlerC0467a extends Handler {
        HandlerC0467a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1003) {
                com.hihonor.adsdk.common.b.b.hnadsc(a.C, "msg is KEY_COUNT_DOWN, mBaseAd: " + ((com.hihonor.adsdk.interstitial.adapter.a) a.this).f3528a, new Object[0]);
                if (((com.hihonor.adsdk.interstitial.adapter.a) a.this).f3528a != null) {
                    new x(((com.hihonor.adsdk.interstitial.adapter.a) a.this).f3528a.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(((com.hihonor.adsdk.interstitial.adapter.a) a.this).f3528a), ErrorCode.AD_INTERSTITIAL_VIDEO_TIME_OUT, "interstitial ad, video play time out, times is :5000").hnadse();
                }
                a.this.x();
            }
        }
    }

    class b extends OnVideoPlayListener {
        b() {
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onProgressUpdate(long j, long j2, long j3) {
            com.hihonor.adsdk.common.b.b.hnadsa(a.C, (Object) ("interstitial--->onProgressUpdate,position: " + j + ",bufferPosition:" + j2 + ",duration:" + j3));
            a.this.a(j, j2, j3);
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onVideoBuffering(boolean z) {
            com.hihonor.adsdk.common.b.b.hnadsc(a.C, "interstitial--->onVideoBuffering,isBuffering:" + z, new Object[0]);
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onVideoEnd() {
            com.hihonor.adsdk.common.b.b.hnadsc(a.C, "interstitial--->onVideoEnd", new Object[0]);
            a.this.x();
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onVideoError(int i, String str) {
            com.hihonor.adsdk.common.b.b.hnadsc(a.C, "interstitial--->onVideoError,errorCode: " + i + ",message: " + str, new Object[0]);
            a.this.x();
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onVideoMute(boolean z) {
            super.onVideoMute(z);
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onVideoPause() {
            com.hihonor.adsdk.common.b.b.hnadsc(a.C, "interstitial--->onVideoPause", new Object[0]);
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onVideoResume() {
            super.onVideoResume();
            com.hihonor.adsdk.common.b.b.hnadsc(a.C, "interstitial--->onVideoResume", new Object[0]);
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onVideoStart() {
            a.this.k();
            a.this.q.setVisibility(0);
        }
    }

    private void o() {
        this.h.bindAd(this.f3528a);
        VideoReportBean videoReportBean = new VideoReportBean();
        videoReportBean.setAuStart(String.valueOf(this.i.getAutoPlay()));
        videoReportBean.setHasVoice(String.valueOf(this.i.getMute()));
        videoReportBean.setScene(String.valueOf(1));
        videoReportBean.setVideoType(String.valueOf(2));
        this.h.setVideoReportBean(videoReportBean);
        this.h.start(this.i.getVideoUrl(), true);
        y();
        this.h.setVideoListener(this.A);
        p();
        s();
        n();
    }

    private void p() {
        this.q.setVisibility(0);
        int mute = this.i.getMute();
        com.hihonor.adsdk.common.b.b.hnadsc(C, "initMuted,mute: " + mute, new Object[0]);
        this.h.setMuted(mute == 0);
        a(mute == 0);
        this.q.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.interstitial.adapter.c.a$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.e(view);
            }
        });
    }

    public void a(long j, long j2, long j3) {
    }

    @Override // com.hihonor.adsdk.interstitial.adapter.a
    public void f() {
        super.f();
        n();
    }

    @Override // com.hihonor.adsdk.interstitial.adapter.a
    public void g() {
        super.g();
        com.hihonor.adsdk.common.b.b.hnadsc(C, "release", new Object[0]);
        if (Objects.nonNull(this.h)) {
            this.h.release();
        }
        if (Objects.nonNull(this.j)) {
            this.j.removeMessages(1003);
        }
    }

    @Override // com.hihonor.adsdk.interstitial.adapter.a
    public void h() {
        com.hihonor.adsdk.common.b.b.hnadsc(C, ba.ag, new Object[0]);
        HnInterstitialPlayerView hnInterstitialPlayerView = this.h;
        if (hnInterstitialPlayerView != null) {
            hnInterstitialPlayerView.resume();
        }
    }

    protected void i() {
    }

    public void j() {
        if (Objects.isNull(this.z)) {
            com.hihonor.adsdk.common.b.b.hnadsc(C, "handleAdRewardVideoContainerView adRewardVideoContainer is null", new Object[0]);
            return;
        }
        if (Objects.isNull(this.i)) {
            com.hihonor.adsdk.common.b.b.hnadsc(C, "handleAdRewardVideoContainerView mVideo is null", new Object[0]);
            return;
        }
        if (this.z.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.z.getLayoutParams();
            if (this.i.getVideoHeight() >= this.i.getVideoWidth()) {
                layoutParams.width = c(0);
            } else {
                layoutParams.height = c(-1);
            }
            this.z.setLayoutParams(layoutParams);
        }
    }

    public void k() {
    }

    protected void l() {
        if (Objects.isNull(this.r)) {
            com.hihonor.adsdk.common.b.b.hnadsc(C, "initTwo mCloseImageView is null", new Object[0]);
            return;
        }
        if (Objects.isNull(this.y)) {
            com.hihonor.adsdk.common.b.b.hnadsc(C, "initTwo adCloseLayout is null", new Object[0]);
        }
        if (Objects.isNull(this.f3528a)) {
            com.hihonor.adsdk.common.b.b.hnadsc(C, "initTwo mBaseAd is null", new Object[0]);
        } else {
            this.y.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.interstitial.adapter.c.a$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a.a(view);
                }
            });
            this.r.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.interstitial.adapter.c.a$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.b(view);
                }
            });
        }
    }

    protected void m() {
        if (Objects.nonNull(this.o)) {
            this.o.setVisibility(0);
        }
        if (Objects.nonNull(this.p)) {
            this.p.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.interstitial.adapter.c.a$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.c(view);
                }
            });
        }
        this.b.findViewById(R.id.ad_close_view).setVisibility(this.f3528a.getCloseFlag() == 0 ? 4 : 0);
        if (Objects.nonNull(this.m)) {
            this.m.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.interstitial.adapter.c.a$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.d(view);
                }
            });
        }
    }

    protected void n() {
    }

    public void q() {
        if (Objects.nonNull(this.j)) {
            this.j.removeMessages(1003);
        }
        if (Objects.nonNull(this.o)) {
            this.o.setVisibility(0);
        }
        if (Objects.nonNull(this.m)) {
            this.m.setVisibility(8);
        }
        if (Objects.nonNull(this.p)) {
            this.p.setVisibility(8);
        }
        if (Objects.nonNull(this.n)) {
            this.n.setVisibility(8);
        }
    }

    public void r() {
        if (Objects.nonNull(this.w)) {
            this.w.setVisibility(0);
        }
        if (Objects.nonNull(this.x)) {
            this.x.setVisibility(0);
        }
    }

    public void s() {
    }

    public void t() {
        int iMin = Math.min(this.i.getVideoDuration(), this.f3528a.getForwardInterval());
        this.k = iMin;
        if (iMin == this.i.getVideoDuration()) {
            this.k = -1;
        }
    }

    protected void u() {
        this.j = new HandlerC0467a(Looper.getMainLooper());
    }

    protected void v() {
        if (Objects.nonNull(this.w)) {
            this.w.setVisibility(8);
        }
        if (Objects.nonNull(this.x)) {
            this.x.setVisibility(8);
        }
        if (Objects.nonNull(this.q)) {
            this.q.setVisibility(8);
        }
    }

    protected void w() {
        if (Objects.nonNull(this.j)) {
            this.j.removeMessages(1003);
        }
        if (Objects.nonNull(this.o)) {
            this.o.setVisibility(8);
        }
        if (Objects.nonNull(this.m)) {
            this.m.setVisibility(8);
        }
        if (Objects.nonNull(this.s)) {
            this.s.setBackgroundResource(R.drawable.shape_honor_ads_close_bg);
        }
        if (Objects.nonNull(this.p)) {
            this.p.setVisibility(0);
        }
        if (Objects.nonNull(this.n)) {
            this.n.setVisibility(8);
        }
        if (Objects.nonNull(this.q)) {
            this.q.setVisibility(8);
        }
    }

    protected void x() {
    }

    protected void y() {
    }

    public void z() {
        this.j.sendEmptyMessageDelayed(1003, 5000L);
    }

    private void a(boolean z) {
        if (Objects.isNull(this.b)) {
            com.hihonor.adsdk.common.b.b.hnadsc(C, "setVolumeDrawable mContext is null", new Object[0]);
        } else if (z) {
            this.q.setImageDrawable(k.hnadsa(this.b, R.drawable.ic_honor_ads_volume_off));
        } else {
            this.q.setImageDrawable(k.hnadsa(this.b, R.drawable.ic_honor_ads_volume_on));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        com.hihonor.adsdk.common.b.b.hnadsc(C, "displayPictureTextView adCloseLayout setOnClickListener", new Object[0]);
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        com.hihonor.adsdk.common.b.b.hnadsc(C, "displayPictureTextView adCloseImage setOnClickListener", new Object[0]);
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        BaseAd baseAd = this.f3528a;
        if (baseAd != null) {
            com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(baseAd);
            BaseAd baseAd2 = this.f3528a;
            new h(baseAd2, baseAd2.getAdUnitId(), aVarHnadsa, String.valueOf(2), "jump and close Ad").hnadse();
            u uVar = new u(this.l);
            BaseAd baseAd3 = this.f3528a;
            uVar.hnadsa(baseAd3, baseAd3.getTrackUrl().getCommons());
        }
        if (Objects.nonNull(this.b)) {
            this.b.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        boolean z = !this.h.isMuted();
        this.h.setMuted(z);
        a(z);
    }

    public void b(long j, long j2, long j3) {
        com.hihonor.adsdk.common.b.b.hnadsa(C, (Object) ("interstitial--->onProgressUpdate,position: " + j + ",bufferPosition:" + j2 + ",duration:" + j3));
        String strHnadsb = com.hihonor.adsdk.base.player.b.hnadsb(j, j3);
        if (!this.v) {
            com.hihonor.adsdk.common.b.b.hnadsc(C, "setBackgroundResourceInClose", new Object[0]);
            this.s.setBackgroundResource(R.drawable.shape_honor_ads_video_countdown_bg_land);
            this.v = true;
        }
        int i = this.k;
        if (i > 0) {
            this.o.setText(String.valueOf(i));
            this.o.append("s");
            this.k--;
        } else {
            this.m.setVisibility(0);
            this.n.setVisibility(0);
            int iHnadsa = q.hnadsa(strHnadsb, 0);
            if (iHnadsa > 0) {
                this.l = iHnadsa;
                this.o.setText(strHnadsb);
            } else {
                this.l = iHnadsa;
                this.o.setText(String.valueOf(iHnadsa));
            }
            this.o.append("s");
        }
        com.hihonor.adsdk.common.b.b.hnadsa(C, (Object) ("reward===>onProgressUpdate,timeText: " + strHnadsb));
    }

    public int c(int i) {
        if (Objects.isNull(this.h)) {
            com.hihonor.adsdk.common.b.b.hnadsc(C, "getVideoViewSize adPlayerView is null", new Object[0]);
            return 0;
        }
        AdVideoSize finalPlayerSize = this.h.getFinalPlayerSize();
        if (!Objects.isNull(finalPlayerSize)) {
            return i == 0 ? finalPlayerSize.getWidth() : finalPlayerSize.getHeight();
        }
        x();
        this.h.release();
        new x("", com.hihonor.adsdk.base.g.j.g.b.hnadsb(), ErrorCode.EX_VIDEO_ABNORMAL, "has exceptionally.,getFinalPlayerSize is null ").hnadse();
        return 0;
    }

    @Override // com.hihonor.adsdk.interstitial.adapter.a
    public void e() {
        com.hihonor.adsdk.common.b.b.hnadsc(C, "pause", new Object[0]);
        HnInterstitialPlayerView hnInterstitialPlayerView = this.h;
        if (hnInterstitialPlayerView != null) {
            hnInterstitialPlayerView.pause();
        }
    }

    @Override // com.hihonor.adsdk.interstitial.adapter.a
    public void a(BaseAd baseAd, Activity activity) {
        super.a(baseAd, activity);
        if (Objects.isNull(this.b)) {
            com.hihonor.adsdk.common.b.b.hnadsc(C, "init mContext is null", new Object[0]);
            return;
        }
        i();
        this.q = (ImageView) this.b.findViewById(R.id.ad_video_volume);
        this.h = (HnInterstitialPlayerView) this.b.findViewById(R.id.ad_video_player);
        this.o = (TextView) this.b.findViewById(R.id.ad_countdown);
        this.m = (TextView) this.b.findViewById(R.id.ad_Skip);
        this.s = (LinearLayout) this.b.findViewById(R.id.ad_view_interstitial_close);
        this.p = (ImageView) this.b.findViewById(R.id.ad_close);
        this.n = this.b.findViewById(R.id.ad_view_close_divider);
        this.w = (TextView) this.b.findViewById(R.id.ad_video_time);
        this.x = (ConstraintLayout) this.b.findViewById(R.id.ad_video_volume_time_layout);
        this.y = (LinearLayout) this.b.findViewById(R.id.ad_flag_close_view);
        this.z = this.b.findViewById(R.id.ad_video_inter_container);
        this.r = (ImageView) this.b.findViewById(R.id.ad_close);
        this.i = this.f3528a.getVideo();
        this.h.setDefaultDrawableColorId(R.color.honor_ads_magic_card_bg);
        o();
    }

    public void c(long j, long j2, long j3) {
        com.hihonor.adsdk.common.b.b.hnadsa(C, (Object) ("interstitial--->onProgressUpdate,position: " + j + ",bufferPosition:" + j2 + ",duration:" + j3));
        String strA = com.hihonor.adsdk.interstitial.e.a(j, j3);
        this.w.setText(strA);
        com.hihonor.adsdk.common.b.b.hnadsa(C, (Object) ("reward===>onProgressUpdate,timeText: " + strA));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(View view) {
        com.hihonor.adsdk.common.b.b.hnadsc(C, "initCloseViewTwo closeFlagClose onClick", new Object[0]);
    }
}
