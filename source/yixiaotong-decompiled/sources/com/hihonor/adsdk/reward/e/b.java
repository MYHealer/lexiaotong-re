package com.hihonor.adsdk.reward.e;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.bean.Video;
import com.hihonor.adsdk.base.bean.VideoReportBean;
import com.hihonor.adsdk.base.callback.AdListener;
import com.hihonor.adsdk.base.player.HnRewardPlayerView;
import com.hihonor.adsdk.common.video.AdVideoSize;
import com.hihonor.adsdk.common.video.OnVideoPlayListener;
import com.hihonor.adsdk.reward.R;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b extends c {
    private static final String V = "BaseRewardVideoViewHolder";
    protected final RelativeLayout A;
    protected final TextView B;
    protected final View C;
    protected final TextView D;
    protected final ImageView E;
    protected final View F;
    protected final ImageView G;
    protected final View H;
    protected final HnRewardPlayerView I;
    protected final TextView J;
    protected Video K;
    protected boolean L;
    protected boolean M;
    protected boolean N;
    protected int O;
    protected AdVideoSize P;
    protected int Q;
    protected int R;
    protected o S;
    private final OnVideoPlayListener T;
    private final Handler U;

    class a extends OnVideoPlayListener {
        a() {
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onProgressUpdate(long j, long j2, long j3) {
            com.hihonor.adsdk.common.b.b.hnadsa(b.V, (Object) ("reward===>onProgressUpdate,position: " + j + ",bufferPosition:" + j2 + ",duration:" + j3));
            String strA = com.hihonor.adsdk.reward.c.a(j, j3);
            com.hihonor.adsdk.common.b.b.hnadsa(b.V, (Object) ("reward===>onProgressUpdate,timeText: " + strA));
            TextView textView = b.this.J;
            if (textView != null) {
                textView.setText(strA);
            }
            b.this.a(j, j3);
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onVideoBuffering(boolean z) {
            com.hihonor.adsdk.common.b.b.hnadsc(b.V, "reward--->onVideoBuffering,isBuffering:" + z, new Object[0]);
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onVideoEnd() {
            com.hihonor.adsdk.common.b.b.hnadsc(b.V, "reward===>onVideoEnd", new Object[0]);
            b bVar = b.this;
            bVar.a(((long) bVar.K.getVideoDuration()) * 1000, ((long) b.this.K.getVideoDuration()) * 1000);
            RelativeLayout relativeLayout = b.this.A;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(4);
            }
            TextView textView = b.this.J;
            if (textView != null) {
                textView.setVisibility(4);
            }
            x xVar = b.this.e;
            if (xVar != null) {
                xVar.c();
            }
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onVideoError(int i, String str) {
            com.hihonor.adsdk.common.b.b.hnadsc(b.V, "reward--->onVideoError,errorCode: " + i + ",message: " + str, new Object[0]);
            b.this.S.a(i);
            b.this.S.a(str);
            if (Objects.nonNull(b.this.c)) {
                com.hihonor.adsdk.reward.a.a().hnadsa(b.this.c.getAdId(), i);
            }
            b bVar = b.this;
            if (!bVar.L || bVar.M) {
                com.hihonor.adsdk.common.b.b.hnadsc(b.V, "onVideoError,video not start play or has start count down by error", new Object[0]);
            } else {
                com.hihonor.adsdk.common.b.b.hnadsc(b.V, "doCountWhenPlayError,onVideoError", new Object[0]);
                b.this.U.sendEmptyMessageDelayed(1, 1000L);
            }
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onVideoMute(boolean z) {
            com.hihonor.adsdk.common.b.b.hnadsc(b.V, "reward--->onVideoMute,isMute: " + z, new Object[0]);
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onVideoPause() {
            com.hihonor.adsdk.common.b.b.hnadsc(b.V, "reward--->onVideoPause", new Object[0]);
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onVideoResume() {
            com.hihonor.adsdk.common.b.b.hnadsc(b.V, "reward===>onVideoResume", new Object[0]);
        }

        @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
        public void onVideoStart() {
            com.hihonor.adsdk.common.b.b.hnadsc(b.V, "reward--->onVideoStart,mVideoHasStarted: " + b.this.L, new Object[0]);
            if (Objects.nonNull(b.this.c)) {
                com.hihonor.adsdk.reward.a.a().hnadsa(b.this.c.getAdId());
            }
            b bVar = b.this;
            AdListener adListener = bVar.d;
            if (adListener != null && !bVar.L) {
                adListener.onAdImpression();
            }
            b bVar2 = b.this;
            bVar2.L = true;
            x xVar = bVar2.e;
            if (xVar != null) {
                xVar.b();
            }
        }
    }

    /* JADX INFO: renamed from: com.hihonor.adsdk.reward.e.b$b, reason: collision with other inner class name */
    class C0471b implements Handler.Callback {
        C0471b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (b.this.S.f() || b.this.S.c() <= 0) {
                com.hihonor.adsdk.common.b.b.hnadsa(b.V, (Object) "doCountWhenPlayError,return");
                return false;
            }
            if (!b.this.N) {
                com.hihonor.adsdk.common.b.b.hnadsc(b.V, "doCountWhenPlayError,not focus,return", new Object[0]);
                return false;
            }
            com.hihonor.adsdk.common.b.b.hnadsc(b.V, "doCountWhenPlayError,start count,leftCount: " + b.this.S.c(), new Object[0]);
            b bVar = b.this;
            bVar.M = true;
            o oVar = bVar.S;
            oVar.a(oVar.c() - 1);
            b.this.u();
            b.this.U.sendEmptyMessageDelayed(1, 1000L);
            return false;
        }
    }

    public b(View view, Context context) {
        super(view, context);
        this.O = -1;
        this.T = new a();
        this.U = new Handler(new C0471b());
        this.H = b(R.id.ad_reward_root);
        this.I = (HnRewardPlayerView) b(R.id.ad_reward_video_player);
        this.J = (TextView) b(R.id.ad_reward_video_time);
        this.A = (RelativeLayout) b(R.id.ad_reward_label_count_volume_close);
        this.B = (TextView) b(R.id.ad_reward_label);
        this.C = b(R.id.ad_reward_label_count_divider);
        this.D = (TextView) b(R.id.ad_reward_countdown);
        this.E = (ImageView) b(R.id.ad_reward_video_volume);
        this.F = b(R.id.ad_reward_volume_close_divider);
        this.G = (ImageView) b(R.id.ad_reward_video_close);
    }

    private void p() {
        BaseAd baseAd = this.c;
        if (baseAd == null) {
            new com.hihonor.adsdk.base.g.j.d.j1.b(ErrorCode.AD_BIND_VIEW_ERR, "ad is null.AD bind to view，but has err.", "", com.hihonor.adsdk.base.g.j.g.b.hnadsb()).hnadse();
            com.hihonor.adsdk.common.b.b.hnadsc(V, "mBaseAd#mBaseAd is null.", new Object[0]);
        } else {
            new com.hihonor.adsdk.base.g.j.d.j1.b(0, ErrorCode.STR_AD_BIND_VIEW, this.c.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(baseAd)).hnadse();
        }
    }

    private void s() {
        this.I.bindAd(this.c);
        VideoReportBean videoReportBean = new VideoReportBean();
        videoReportBean.setHasVoice(String.valueOf(this.K.getMute()));
        videoReportBean.setScene(String.valueOf(1));
        videoReportBean.setVideoType(String.valueOf(1));
        r();
        this.I.setVideoReportBean(videoReportBean);
        this.I.play();
        p();
        this.I.setVideoListener(this.T);
        t();
        this.J.setText(com.hihonor.adsdk.reward.c.a(0L, ((long) this.K.getVideoDuration()) * 1000));
    }

    private void t() {
        com.hihonor.adsdk.common.b.b.hnadsc(V, "initVolume,mute: " + this.O, new Object[0]);
        if (this.O == -1) {
            this.O = this.K.getMute();
        }
        c(this.O == 0);
        this.E.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.reward.e.b$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.b(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (this.S.f()) {
            this.D.setText(this.g.getResources().getString(com.hihonor.adsdk.base.R.string.ads_rewarded));
            return;
        }
        if (this.S.c() > 0) {
            this.D.setText(this.g.getString(R.string.ads_reward_video_count_other, Long.valueOf(this.S.c())));
            return;
        }
        this.S.a(true);
        this.D.setText(this.g.getResources().getString(com.hihonor.adsdk.base.R.string.ads_rewarded));
        com.hihonor.adsdk.common.b.b.hnadsc(V, "onRewarded===>", new Object[0]);
        if (Objects.nonNull(this.c)) {
            new com.hihonor.adsdk.base.g.j.d.j1.f(this.c, this.S.d(), this.c.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.c)).hnadsa(com.hihonor.adsdk.base.g.j.e.a.Y0, this.S.e()).hnadse();
            com.hihonor.adsdk.reward.a.a().hnadsa(this.c.getAdId(), this.S.d());
        }
    }

    @Override // com.hihonor.adsdk.reward.e.a.b
    public void c() {
        super.c();
        this.I.resume();
    }

    @Override // com.hihonor.adsdk.reward.e.c
    protected void h() {
        super.h();
        if (Objects.nonNull(this.I)) {
            this.I.setOnTouchListener(this.r);
            HnRewardPlayerView hnRewardPlayerView = this.I;
            BaseAd baseAd = this.c;
            com.hihonor.adsdk.base.widget.base.e eVar = this.f;
            w wVar = this.r;
            com.hihonor.adsdk.reward.c.a(hnRewardPlayerView, baseAd, eVar, 5, wVar.f3578a, wVar.b, this.d, wVar.c);
        }
        if (Objects.nonNull(this.G)) {
            this.G.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.reward.e.b$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.a(view);
                }
            });
        }
    }

    protected void v() {
    }

    protected void w() {
        this.I.setVideoViewSize(this.P, 2, this.Q);
    }

    @Override // com.hihonor.adsdk.reward.e.a.b
    public void b() {
        super.b();
        this.I.pause();
    }

    private void c(boolean z) {
        com.hihonor.adsdk.common.b.b.hnadsc(V, "RewardActivity#setVolumeAndDrawable,mute:" + this.O, new Object[0]);
        HnRewardPlayerView hnRewardPlayerView = this.I;
        if (hnRewardPlayerView != null) {
            hnRewardPlayerView.setMuted(z);
        }
        if (z) {
            this.E.setImageDrawable(com.hihonor.adsdk.common.f.k.hnadsa(this.g, R.drawable.ic_honor_ads_volume_off));
        } else {
            this.E.setImageDrawable(com.hihonor.adsdk.common.f.k.hnadsa(this.g, R.drawable.ic_honor_ads_volume_on));
        }
    }

    private void q() {
        RelativeLayout relativeLayout = this.A;
        if (relativeLayout != null) {
            ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).topMargin = com.hihonor.adsdk.common.f.u.hnadsh();
            } else {
                com.hihonor.adsdk.common.b.b.hnadse(V, "initAdLabelRewardVolumeCloseLayout,adLabelCountVolumeCloseLayoutParams topMargin error!!!", new Object[0]);
            }
        }
    }

    @Override // com.hihonor.adsdk.reward.e.c
    public void a(BaseAd baseAd, AdListener adListener, o oVar, x xVar) {
        super.a(baseAd, adListener, oVar, xVar);
        if (!Objects.isNull(this.c) && !Objects.isNull(this.c.getVideo())) {
            this.K = this.c.getVideo();
            this.S = oVar;
            if (this.c.getAdFlag() == 0) {
                this.B.setVisibility(8);
                this.C.setVisibility(8);
            }
            if (this.c.getCloseFlag() == 0) {
                this.G.setVisibility(8);
                this.F.setVisibility(8);
            }
            q();
            u();
            s();
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadse(V, "bindData baseAd or video is null", new Object[0]);
    }

    protected void r() {
        Video video = this.K;
        if (video != null && this.I != null) {
            this.P = new AdVideoSize(video.getVideoWidth(), this.K.getVideoHeight());
            final View viewA = a(android.R.id.content);
            final int iHnadsf = com.hihonor.adsdk.common.f.u.hnadsf();
            final int iHnadse = com.hihonor.adsdk.common.f.u.hnadse();
            com.hihonor.adsdk.common.b.b.hnadsc(V, "initVideoLayout,realWidth: " + iHnadsf + ",realHeight:" + iHnadse, new Object[0]);
            if (viewA != null) {
                viewA.post(new Runnable() { // from class: com.hihonor.adsdk.reward.e.b$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(viewA, iHnadsf, iHnadse);
                    }
                });
                return;
            }
            com.hihonor.adsdk.common.b.b.hnadse(V, "initVideoLayout,decorView is null", new Object[0]);
            this.Q = Math.min(iHnadsf, iHnadse);
            this.R = Math.max(iHnadsf, iHnadse);
            v();
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadse(V, "initVideoLayout,mVideo or adPlayerView is null,return", new Object[0]);
    }

    @Override // com.hihonor.adsdk.reward.e.a.b
    public void b(boolean z) {
        this.N = z;
        if (this.M && z) {
            this.U.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        boolean zIsMuted = this.I.isMuted();
        c(!zIsMuted);
        this.O = zIsMuted ? 1 : 0;
    }

    @Override // com.hihonor.adsdk.reward.e.a.b
    public void a(boolean z) {
        super.a(z);
        if (Objects.nonNull(this.d)) {
            this.d = null;
        }
        if (this.e != null) {
            this.e = null;
        }
        if (z && Objects.nonNull(this.I)) {
            this.I.release();
        }
        this.U.removeCallbacksAndMessages(null);
        if (Objects.nonNull(this.c)) {
            this.c.setAdListener(null);
            this.c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        com.hihonor.adsdk.common.b.b.hnadsc(V, "adVideoClose.setOnClickListener", new Object[0]);
        if (Objects.nonNull(this.c)) {
            com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.c);
            BaseAd baseAd = this.c;
            new com.hihonor.adsdk.base.g.j.d.h(baseAd, baseAd.getAdUnitId(), aVarHnadsa).hnadse();
        }
        x xVar = this.e;
        if (xVar != null) {
            xVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view, int i, int i2) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (view.getMeasuredWidth() <= 0 || measuredHeight <= 0) {
            com.hihonor.adsdk.common.b.b.hnadsc(V, "initVideoLayout,get screen real width and height", new Object[0]);
        } else {
            i = measuredWidth;
            i2 = measuredHeight;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(V, "initVideoLayout,screenWidth: " + i + ",screenHeight:" + i2, new Object[0]);
        this.Q = Math.min(i, i2);
        this.R = Math.max(i, i2);
        v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2) {
        com.hihonor.adsdk.common.b.b.hnadsa(V, (Object) ("reward===>mHasStartCountAfterError: " + this.M));
        if (this.M) {
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsa(V, (Object) ("reward===>" + this.S.f() + " position: " + j + ",duration: " + j2));
        if (!this.S.f()) {
            if ((this.K.getVideoDuration() >= this.K.getRewardingDuration() && j >= ((long) this.K.getRewardingDuration()) * 1000) || (this.K.getVideoDuration() < this.K.getVideoDuration() && j == j2)) {
                this.S.a(0L);
            } else {
                long jMin = Math.min(j2, ((long) this.K.getRewardingDuration()) * 1000);
                this.S.a((jMin - j) / 1000);
                com.hihonor.adsdk.common.b.b.hnadsa(V, (Object) ("reward===>totalCountTime:" + jMin + ",left:" + this.S.c()));
            }
        }
        u();
    }
}
