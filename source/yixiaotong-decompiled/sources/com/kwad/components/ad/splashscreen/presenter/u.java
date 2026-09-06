package com.kwad.components.ad.splashscreen.presenter;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.components.ad.splashscreen.widget.SkipView;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.bi;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class u extends e implements com.kwad.sdk.core.j.c {
    private SkipView Jw;
    private ImageView kE;
    private AdInfo mAdInfo;
    private volatile boolean Jt = false;
    private boolean Ju = false;
    private boolean Jv = false;
    private com.kwad.sdk.utils.j.a kF = new com.kwad.sdk.utils.j.a() { // from class: com.kwad.components.ad.splashscreen.presenter.u.1
        @Override // com.kwad.sdk.utils.j.a
        public final void onAudioBeReleased() {
        }

        @Override // com.kwad.sdk.utils.j.a
        public final void onAudioBeOccupied() {
            u.this.Jt = false;
            if (u.this.kE != null) {
                u.this.kE.post(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.u.1.1
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        if (u.this.HC.GN != null) {
                            u.this.HC.GN.setAudioEnabled(u.this.Jt, false);
                        }
                        if (u.this.HC != null) {
                            AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(u.this.HC.mAdTemplate);
                            String str = u.this.Jt ? adInfoEO.adSplashInfo.speakerIconUrl : adInfoEO.adSplashInfo.speakerMuteIconUrl;
                            if (!TextUtils.isEmpty(str)) {
                                KSImageLoader.loadImage(u.this.kE, str, u.this.HC.mAdTemplate);
                            } else {
                                u.this.kE.setImageDrawable(u.this.getContext().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                            }
                            u.this.kE.setSelected(false);
                        }
                    }
                });
            }
        }
    };
    private com.kwad.components.core.video.l Jx = new com.kwad.components.core.video.m() { // from class: com.kwad.components.ad.splashscreen.presenter.u.2
        private boolean JA = false;
        private String JB = com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.Hk);

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayPaused() {
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.l
        public final void onVideoPlayBufferingPaused() {
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.l
        public final void onVideoPlayBufferingPlaying() {
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, final long j2) {
            u.this.HC.ax(((int) j2) / 1000);
            final int iMin = Math.min(u.this.mAdInfo.adSplashInfo.videoDisplaySecond, ((int) j) / 1000);
            final String str = this.JB;
            u uVar = u.this;
            if (u.a(uVar, uVar.mAdInfo)) {
                u.this.Jw.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.u.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        int i = (int) ((((long) (iMin * 1000)) - j2) / 1000);
                        if (i <= 0) {
                            i = 1;
                        }
                        u.this.Jw.ag(str + i);
                    }
                });
            }
            float f = j2 / 1000.0f;
            if (iMin <= 0 || ((double) f) + 0.5d <= iMin - 1 || this.JA) {
                return;
            }
            u uVar2 = u.this;
            if (u.a(uVar2, uVar2.mAdInfo)) {
                u.this.HC.mm();
                this.JA = true;
            }
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayStart() {
            if (u.this.HC.GN != null) {
                u.this.HC.GN.setAudioEnabled(u.this.Jt, false);
            }
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlaying() {
            if (u.this.Ju) {
                return;
            }
            u.this.HC.ag(false);
            if (u.this.HC.GN != null) {
                u.this.HC.GN.ah(true);
                u.this.HC.GN.setAudioEnabled(u.this.Jt, true);
            }
            u.b(u.this, true);
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayCompleted() {
            if (this.JA) {
                return;
            }
            u.this.HC.mm();
            this.JA = true;
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayError(int i, int i2) {
            if (u.this.HC != null && u.this.HC.GN != null) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                com.kwad.components.ad.splashscreen.monitor.b.mv();
                com.kwad.components.ad.splashscreen.monitor.b.b(u.this.HC.mAdTemplate, 1, u.this.HC.GN.HI, 2, jElapsedRealtime - u.this.HC.GN.KO, jElapsedRealtime - u.this.HC.mAdTemplate.showTime);
            }
            if (u.this.Jv || u.this.HC == null) {
                return;
            }
            u.this.HC.c(0, "onMediaPlayError");
        }
    };

    @Override // com.kwad.sdk.core.j.c
    public final void bz() {
    }

    static /* synthetic */ boolean a(u uVar, AdInfo adInfo) {
        return v(adInfo);
    }

    static /* synthetic */ boolean b(u uVar, boolean z) {
        uVar.Ju = true;
        return true;
    }

    private void a(final DetailVideoView detailVideoView) {
        final View viewFindViewById = findViewById(R.id.splash_play_card_view);
        viewFindViewById.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.u.3
            @Override // java.lang.Runnable
            public final void run() {
                float width = viewFindViewById.getWidth();
                float height = viewFindViewById.getHeight();
                if (width <= 0.0f || height <= 0.0f) {
                    return;
                }
                AdInfo.AdMaterialInfo.MaterialFeature materialFeatureBb = com.kwad.sdk.core.response.helper.a.bb(u.this.mAdInfo);
                if (materialFeatureBb.videoWidth > 0) {
                    com.kwad.sdk.c.a.a.b(detailVideoView, materialFeatureBb.width, materialFeatureBb.height);
                }
            }
        });
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        int i;
        super.ay();
        this.mAdInfo = com.kwad.sdk.core.response.helper.e.eO(this.HC.mAdTemplate);
        DetailVideoView detailVideoView = (DetailVideoView) this.HC.mRootContainer.findViewById(R.id.ksad_splash_video_player);
        detailVideoView.setVisibility(0);
        if (com.kwad.sdk.core.response.helper.a.dv(this.mAdInfo)) {
            a(detailVideoView);
        }
        if (this.HC.GN != null) {
            this.HC.GN.b(this.Jx);
        }
        this.HC.GP.a(this);
        AdBaseFrameLayout adBaseFrameLayout = this.HC.mRootContainer;
        if (com.kwad.components.ad.splashscreen.e.c.A(this.mAdInfo)) {
            i = R.id.ksad_splash_skip_right_view;
        } else {
            i = R.id.ksad_splash_skip_left_view;
        }
        this.Jw = (SkipView) adBaseFrameLayout.findViewById(i);
        if (v(this.mAdInfo)) {
            a(this.Jw, this.mAdInfo);
        }
        int i2 = this.mAdInfo.adSplashInfo.mute;
        if (i2 == 2) {
            this.Jt = true;
        } else if (i2 != 3) {
            this.Jt = false;
        } else {
            this.Jt = com.kwad.sdk.utils.n.dc(this.HC.mRootContainer.getContext()) > 0;
        }
        if (com.kwad.components.core.t.a.aO(getContext()).wD()) {
            this.Jt = false;
        }
        if (this.HC.GN != null) {
            this.HC.GN.setAudioEnabled(this.Jt, false);
            this.HC.GN.a(this.kF);
        }
        this.kE = (ImageView) this.HC.mRootContainer.findViewById(R.id.ksad_splash_sound);
        if (com.kwad.components.ad.splashscreen.e.c.A(this.mAdInfo)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.kE.getLayoutParams();
            layoutParams.gravity = 51;
            this.kE.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.kE.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams.topMargin = com.kwad.sdk.c.a.a.a(this.kE.getContext(), 32.0f);
                marginLayoutParams.leftMargin = com.kwad.sdk.c.a.a.a(this.kE.getContext(), 16.0f);
            }
        }
        this.kE.setVisibility(0);
        String str = this.Jt ? this.mAdInfo.adSplashInfo.speakerIconUrl : this.mAdInfo.adSplashInfo.speakerMuteIconUrl;
        if (!TextUtils.isEmpty(str)) {
            KSImageLoader.loadImage(this.kE, str, this.HC.mAdTemplate);
        } else {
            this.kE.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
        }
        this.kE.setSelected(this.Jt);
        this.kE.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.presenter.u.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u uVar = u.this;
                uVar.Jt = !uVar.Jt;
                String str2 = u.this.Jt ? u.this.mAdInfo.adSplashInfo.speakerIconUrl : u.this.mAdInfo.adSplashInfo.speakerMuteIconUrl;
                if (!TextUtils.isEmpty(str2)) {
                    KSImageLoader.loadImage(u.this.kE, str2, u.this.HC.mAdTemplate);
                } else {
                    u.this.kE.setImageDrawable(u.this.getContext().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                }
                u.this.kE.setSelected(u.this.Jt);
                u.this.HC.GN.setAudioEnabled(u.this.Jt, true);
            }
        });
    }

    private static boolean v(AdInfo adInfo) {
        return !com.kwad.sdk.core.response.helper.a.cI(adInfo);
    }

    private static void a(SkipView skipView, AdInfo adInfo) {
        skipView.setTimerBtnVisible(com.kwad.sdk.core.response.helper.a.cL(adInfo));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (this.HC.GN != null) {
            this.HC.GN.a(this.Jx);
            this.HC.GN.b(this.kF);
        }
        if (this.Jw.getHandler() != null) {
            this.Jw.getHandler().removeCallbacksAndMessages(null);
        }
        this.HC.GP.b(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.Jv = true;
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bA() {
        if (this.HC.GN != null) {
            this.HC.GN.pause();
        }
    }
}
