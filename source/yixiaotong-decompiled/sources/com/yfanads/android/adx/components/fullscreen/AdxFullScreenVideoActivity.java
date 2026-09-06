package com.yfanads.android.adx.components.fullscreen;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.openalliance.ad.constant.ai;
import com.stub.StubApp;
import com.yfanads.ads.chanel.adx.AdxInterstitialAdapter$$ExternalSyntheticLambda8;
import com.yfanads.android.adx.R;
import com.yfanads.android.adx.api.AdVideoPlayConfig;
import com.yfanads.android.adx.components.base.BaseAppActivity;
import com.yfanads.android.adx.components.base.e;
import com.yfanads.android.adx.components.base.i;
import com.yfanads.android.adx.components.template.AdxFullScreenVideoTemplateData;
import com.yfanads.android.adx.core.impl.AbstractNativeAd;
import com.yfanads.android.adx.core.model.AdxImage;
import com.yfanads.android.adx.core.model.AdxNativeAd;
import com.yfanads.android.adx.player.yfplayer.IPlayVideo;
import com.yfanads.android.adx.service.d;
import com.yfanads.android.custom.view.OnFeedClickListener;
import com.yfanads.android.libs.thirdpart.lottie.LottieAnimationView;
import com.yfanads.android.libs.utils.YFOptional;
import com.yfanads.android.model.FeedCom;
import com.yfanads.android.model.TemplateConf;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class AdxFullScreenVideoActivity extends BaseAppActivity implements AdxNativeAd.AdInteractionListener {
    public static final /* synthetic */ int q = 0;
    public com.yfanads.android.adx.components.viewholder.a b;
    public AbstractNativeAd c;
    public b d;
    public boolean e;
    public boolean f;
    public int g;
    public boolean h;
    public boolean i;
    public boolean j;
    public int k;
    public IPlayVideo l;
    public boolean m;
    public AdxFullScreenVideoTemplateData n;
    public boolean o;
    public boolean p;

    public class a implements OnFeedClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TemplateConf f9573a;
        public final /* synthetic */ FeedCom b;

        public a(TemplateConf templateConf, FeedCom feedCom) {
            this.f9573a = templateConf;
            this.b = feedCom;
        }

        @Override // com.yfanads.android.custom.view.OnFeedClickListener
        public final void onDismiss() {
        }

        @Override // com.yfanads.android.custom.view.OnFeedClickListener
        public final void onTraceFeed() {
            AbstractNativeAd abstractNativeAd = AdxFullScreenVideoActivity.this.c;
            if (abstractNativeAd != null) {
                abstractNativeAd.traceData(this.f9573a, this.b, true);
            }
        }
    }

    public class b extends CountDownTimer {
        public b(long j) {
            super(j, 1000L);
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long j) {
            AdxFullScreenVideoActivity.this.g = (int) (j / 1000);
            com.yfanads.android.adx.utils.a.a("AdxFullScreenVideoActivity startShowCloseTimer onTick showCloseTime=" + AdxFullScreenVideoActivity.this.g);
            AdxFullScreenVideoActivity adxFullScreenVideoActivity = AdxFullScreenVideoActivity.this;
            if (adxFullScreenVideoActivity.g == 0) {
                adxFullScreenVideoActivity.c();
                AdxFullScreenVideoActivity adxFullScreenVideoActivity2 = AdxFullScreenVideoActivity.this;
                adxFullScreenVideoActivity2.e = adxFullScreenVideoActivity2.f;
                adxFullScreenVideoActivity2.b.a();
            }
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            AdxFullScreenVideoActivity adxFullScreenVideoActivity = AdxFullScreenVideoActivity.this;
            if (adxFullScreenVideoActivity.g != 0) {
                adxFullScreenVideoActivity.c();
                AdxFullScreenVideoActivity adxFullScreenVideoActivity2 = AdxFullScreenVideoActivity.this;
                adxFullScreenVideoActivity2.e = adxFullScreenVideoActivity2.f;
                adxFullScreenVideoActivity2.b.a();
            }
        }
    }

    static {
        StubApp.interface11(55952);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(TemplateConf templateConf, FeedCom feedCom, View view) {
        this.b.a(getFragmentManager(), new a(templateConf, feedCom));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        this.b.s.setVisibility(0);
    }

    @Override // com.yfanads.android.adx.components.base.BaseAppActivity
    public final void a() {
    }

    @Override // com.yfanads.android.adx.components.base.BaseAppActivity
    public final void b() {
        AdxImage adxImage;
        ImageView imageView;
        Intent intent = getIntent();
        this.c = (AbstractNativeAd) intent.getParcelableExtra("nativeAds");
        final TemplateConf templateConf = (TemplateConf) intent.getParcelableExtra("templateConf");
        final FeedCom feedCom = (FeedCom) intent.getParcelableExtra("feedCom");
        AdxFullScreenVideoTemplateData adxFullScreenVideoTemplateData = new AdxFullScreenVideoTemplateData();
        this.n = adxFullScreenVideoTemplateData;
        adxFullScreenVideoTemplateData.setConf(templateConf);
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.item_adx_full_screen_video, (ViewGroup) this.f9564a, true);
        AbstractNativeAd abstractNativeAd = this.c;
        boolean z = abstractNativeAd != null && abstractNativeAd.getMaterialType() == 1;
        getApplicationContext();
        this.b = new com.yfanads.android.adx.components.viewholder.a(viewInflate);
        this.n.setAdx(true);
        this.n.updAdLog(R.mipmap.yf_ad_logo);
        com.yfanads.android.adx.components.viewholder.a aVar = this.b;
        AdxFullScreenVideoTemplateData adxFullScreenVideoTemplateData2 = this.n;
        aVar.getClass();
        int i = adxFullScreenVideoTemplateData2.adLogo;
        if (i > 0 && (imageView = aVar.i) != null) {
            imageView.setImageResource(i);
        }
        com.yfanads.android.adx.components.viewholder.a aVar2 = this.b;
        Context origApplicationContext = StubApp.getOrigApplicationContext(getApplicationContext());
        AdxFullScreenVideoTemplateData adxFullScreenVideoTemplateData3 = this.n;
        aVar2.getClass();
        adxFullScreenVideoTemplateData3.getClass();
        int iDip2px = ScreenUtil.dip2px(origApplicationContext, 22.0f);
        TemplateConf templateConf2 = adxFullScreenVideoTemplateData3.conf;
        if (templateConf2 != null) {
            int i2 = templateConf2.cbs;
            if (i2 == 1) {
                iDip2px = ScreenUtil.dip2px(origApplicationContext, 11.0f);
            } else if (i2 == 2) {
                iDip2px = ScreenUtil.dip2px(origApplicationContext, 17.0f);
            } else if (i2 == 4) {
                iDip2px = ScreenUtil.dip2px(origApplicationContext, 28.0f);
            } else if (i2 == 5) {
                iDip2px = ScreenUtil.dip2px(origApplicationContext, 33.0f);
            }
        }
        TemplateConf templateConf3 = adxFullScreenVideoTemplateData3.conf;
        int i3 = templateConf3 != null ? templateConf3.cbp : 2;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) aVar2.g.getLayoutParams();
        layoutParams.width = iDip2px;
        layoutParams.height = iDip2px;
        if (i3 == 1) {
            layoutParams.addRule(20);
        } else {
            layoutParams.addRule(21);
        }
        aVar2.g.setLayoutParams(layoutParams);
        float clickRatio = adxFullScreenVideoTemplateData3.getClickRatio();
        int screenWidth = (int) (ScreenUtil.getScreenWidth(origApplicationContext) * clickRatio);
        int screenHeight = (int) (ScreenUtil.getScreenHeight(origApplicationContext) * clickRatio);
        com.yfanads.android.adx.utils.a.a("updateClickSize width = " + screenWidth + " , height = " + screenHeight + " , clickRatio " + clickRatio);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(screenWidth, screenHeight);
        layoutParams2.addRule(13);
        aVar2.f.setLayoutParams(layoutParams2);
        aVar2.a(origApplicationContext, adxFullScreenVideoTemplateData3);
        this.b.a(this.c);
        this.b.a(this, this.c);
        AdxFullScreenVideoTemplateData adxFullScreenVideoTemplateData4 = this.n;
        this.o = adxFullScreenVideoTemplateData4.isActionOne();
        this.p = adxFullScreenVideoTemplateData4.isShake() || adxFullScreenVideoTemplateData4.isTwist();
        if (z) {
            AbstractNativeAd abstractNativeAd2 = this.c;
            if (abstractNativeAd2 == null || abstractNativeAd2.getVideoCoverImage() == null || TextUtils.isEmpty(this.c.getVideoCoverImage().getImageUrl())) {
                ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, this.b.b);
            } else {
                ViewUtils.loadBlurImage(this.c.getVideoCoverImage().getImageUrl(), this.b.b, 20);
            }
        } else if (YFListUtils.isEmpty(this.c.getImageList()) || (adxImage = this.c.getImageList().get(0)) == null || !adxImage.isValid() || TextUtils.isEmpty(adxImage.getImageUrl())) {
            ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, this.b.b);
        } else {
            this.b.s.setVisibility(4);
            ViewUtils.loadBlurImage(adxImage.getImageUrl(), this.b.b, 20);
            ViewUtils.loadImage(adxImage.getImageUrl(), this.b.t, new ViewUtils.ViewImageCallback() { // from class: com.yfanads.android.adx.components.fullscreen.AdxFullScreenVideoActivity$$ExternalSyntheticLambda3
                @Override // com.yfanads.android.utils.ViewUtils.ViewImageCallback
                public final void onResourceReady() {
                    this.f$0.d();
                }
            });
        }
        this.b.g.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.android.adx.components.fullscreen.AdxFullScreenVideoActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.a(view);
            }
        });
        this.b.p.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.android.adx.components.fullscreen.AdxFullScreenVideoActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.a(templateConf, feedCom, view);
            }
        });
        this.b.i.setImageResource(this.c.getAdSourceLogoUrl(1));
        AdxFullScreenVideoTemplateData adxFullScreenVideoTemplateData5 = this.n;
        TemplateConf templateConf4 = adxFullScreenVideoTemplateData5.conf;
        this.h = templateConf4 != null && templateConf4.jc == 1;
        a(z, this.b, adxFullScreenVideoTemplateData5);
        a(this.g);
    }

    public final void f() {
        this.n.resetActivityStyle(BaseTemplateData.InteractiveStyle.CLICK_NOT_HAS_FINGER.getValue());
        AdxFullScreenVideoTemplateData adxFullScreenVideoTemplateData = this.n;
        this.o = adxFullScreenVideoTemplateData.isActionOne();
        this.p = adxFullScreenVideoTemplateData.isShake() || adxFullScreenVideoTemplateData.isTwist();
        com.yfanads.android.adx.components.viewholder.a aVar = this.b;
        if (aVar != null) {
            aVar.a(this, this.n);
            LottieAnimationView lottieAnimationView = this.b.n;
            if (lottieAnimationView != null) {
                lottieAnimationView.setEnabled(true);
            }
        }
        YFOptional.ofNullable(this.c).ifPresentRun(new AdxInterstitialAdapter$$ExternalSyntheticLambda8());
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public final boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
        return false;
    }

    @Override // android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.yfanads.android.adx.utils.a.a("AdxFullScreenVideoActivity onActivityResult requestCode=" + i + " ,  resultCode=" + i2);
        if (i == 101 && i2 == 101) {
            if (this.h && this.i) {
                e();
                return;
            }
            a(this.g);
            IPlayVideo iPlayVideo = this.l;
            if (iPlayVideo != null) {
                iPlayVideo.reStart();
            }
        }
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public final void onAdClickedSuccess(boolean z, boolean z2, boolean z3) {
        YFLog.debug("AdxFullScreenVideoActivity onAdClickedSuccess" + z2);
        this.i = true;
        if (!z2 && !z3) {
            try {
                AbstractNativeAd abstractNativeAd = this.c;
                if (abstractNativeAd != null) {
                    abstractNativeAd.stopInteraction();
                }
            } catch (Exception e) {
                e.a(e, new StringBuilder("stopTwistOrShake "));
            }
        }
        if (this.m) {
            return;
        }
        if (z2) {
            BaseAppActivity.a(this);
        } else if (!z3) {
            c();
            IPlayVideo iPlayVideo = this.l;
            if (iPlayVideo != null) {
                iPlayVideo.pause();
            }
        }
        a(z2 ? ai.af : 200);
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public final void onAdHide() {
        c();
        IPlayVideo iPlayVideo = this.l;
        if (iPlayVideo != null) {
            iPlayVideo.pause();
        }
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public final void onAdShow() {
        com.yfanads.android.adx.utils.a.a("AdxFullScreenVideoActivity onAdShow ");
        if (this.m) {
            IPlayVideo iPlayVideo = this.l;
            if (iPlayVideo != null) {
                iPlayVideo.pause();
                return;
            }
            return;
        }
        if (this.h && this.i) {
            e();
            return;
        }
        a(this.g);
        IPlayVideo iPlayVideo2 = this.l;
        if (iPlayVideo2 != null) {
            iPlayVideo2.reStart();
        }
    }

    @Override // com.yfanads.android.adx.components.base.BaseAppActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public final void onDownloadTipsDismiss() {
        com.yfanads.android.adx.utils.a.a("AdxFullScreenVideoActivity onDownloadTipsDismiss ");
        this.m = false;
        if (this.h && this.i) {
            e();
            return;
        }
        a(this.g);
        IPlayVideo iPlayVideo = this.l;
        if (iPlayVideo != null) {
            iPlayVideo.reStart();
        }
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public final void onExposure(boolean z) {
        AdxNativeAd.AdInteractionListener2 adInteractionListener2A = d.a.f9620a.a(com.yfanads.android.adx.service.a.FULL_VIDEO);
        if (adInteractionListener2A != null) {
            adInteractionListener2A.onExposure(z);
        }
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public final void onHandleClick(boolean z) {
        YFLog.debug("AdxFullScreenVideoActivity onHandleClick");
        AdxNativeAd.AdInteractionListener2 adInteractionListener2A = d.a.f9620a.a(com.yfanads.android.adx.service.a.FULL_VIDEO);
        if (adInteractionListener2A != null) {
            adInteractionListener2A.onHandleClick(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        if (com.yfanads.android.adx.utils.b.b()) {
            if (this.b == null) {
                com.yfanads.android.adx.utils.a.a("AdxFullScreenVideoActivity adxViewHolder == null");
            } else {
                e();
            }
        }
    }

    public final void c() {
        b bVar = this.d;
        if (bVar != null) {
            bVar.cancel();
            this.d = null;
        }
    }

    public final void e() {
        AdxNativeAd.AdInteractionListener2 adInteractionListener2A;
        if (!this.j && (adInteractionListener2A = d.a.f9620a.a(com.yfanads.android.adx.service.a.FULL_VIDEO)) != null) {
            adInteractionListener2A.onAdClose(null);
        }
        this.j = true;
        com.yfanads.android.adx.components.viewholder.a aVar = this.b;
        if (aVar != null) {
            aVar.getClass();
            com.yfanads.android.adx.utils.a.a("stopCountDown");
            aVar.n.cancelAnimation();
            aVar.m.cancelAnimation();
            this.b = null;
        }
        AbstractNativeAd abstractNativeAd = this.c;
        if (abstractNativeAd != null) {
            abstractNativeAd.destroy(com.yfanads.android.adx.service.a.FULL_VIDEO);
            this.c = null;
        }
        c();
        finish();
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public final void onAdShakeCancel() {
        if (this.p && this.o) {
            f();
        }
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public final void onAdShakeSuccess(boolean z, boolean z2, boolean z3) {
        boolean z4 = this.p && this.o;
        YFLog.debug("AdxFullScreenVideoActivity onAdShakeSuccess " + z4);
        this.i = true;
        if (z4) {
            f();
        }
        if (z4 || (!z2 && !z3)) {
            try {
                AbstractNativeAd abstractNativeAd = this.c;
                if (abstractNativeAd != null) {
                    abstractNativeAd.stopInteraction();
                }
            } catch (Exception e) {
                e.a(e, new StringBuilder("stopTwistOrShake "));
            }
        }
        if (this.m) {
            return;
        }
        if (z2) {
            BaseAppActivity.a(this);
        } else if (!z3) {
            c();
            IPlayVideo iPlayVideo = this.l;
            if (iPlayVideo != null) {
                iPlayVideo.pause();
            }
        }
        a(z2 ? ai.af : 200);
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        if (this.e) {
            e();
            super.onBackPressed();
        }
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public final void onDownloadTipsShow() {
        this.m = true;
        c();
        IPlayVideo iPlayVideo = this.l;
        if (iPlayVideo != null) {
            iPlayVideo.pause();
        }
    }

    public final void a(boolean z, com.yfanads.android.adx.components.viewholder.a aVar, AdxFullScreenVideoTemplateData adxFullScreenVideoTemplateData) {
        int i;
        int i2;
        if (aVar == null || adxFullScreenVideoTemplateData == null) {
            return;
        }
        HashMap map = new HashMap();
        BaseTemplateData.InteractiveStyle activeStyle = adxFullScreenVideoTemplateData.getActiveStyle();
        if (activeStyle == BaseTemplateData.InteractiveStyle.SHAKE || activeStyle == BaseTemplateData.InteractiveStyle.CLICK_SHAKE) {
            i = 1;
        } else if (activeStyle == BaseTemplateData.InteractiveStyle.TWIST || activeStyle == BaseTemplateData.InteractiveStyle.CLICK_TWIST) {
            i = 2;
        } else {
            i = (activeStyle == BaseTemplateData.InteractiveStyle.SLIDE || activeStyle == BaseTemplateData.InteractiveStyle.CLICK_SLIDE) ? 3 : 0;
        }
        this.k = i;
        TemplateConf templateConf = adxFullScreenVideoTemplateData.conf;
        if (templateConf == null || templateConf.cbst >= 0) {
            i2 = templateConf != null ? templateConf.cbst : 0;
        } else {
            i2 = 5;
        }
        this.g = i2;
        this.f = templateConf != null && templateConf.pkb == 1;
        map.put(aVar.f, 4);
        map.put(aVar.o, Integer.valueOf(this.k));
        map.put(aVar.n, 5);
        boolean zIsActionClickType = adxFullScreenVideoTemplateData.isActionClickType();
        LottieAnimationView lottieAnimationView = aVar.n;
        if (lottieAnimationView != null) {
            lottieAnimationView.setEnabled(zIsActionClickType);
        }
        if (z) {
            aVar.e.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.android.adx.components.fullscreen.AdxFullScreenVideoActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.yfanads.android.adx.utils.a.a("AdxFullScreenVideoActivity onClickView ");
                }
            });
            AbstractNativeAd abstractNativeAd = this.c;
            if (abstractNativeAd != null) {
                com.yfanads.android.adx.components.viewholder.a aVar2 = this.b;
                AdxImage videoCoverImage = abstractNativeAd.getVideoCoverImage();
                aVar2.getClass();
                if (videoCoverImage != null && !TextUtils.isEmpty(videoCoverImage.getImageUrl())) {
                    aVar2.d.setVisibility(0);
                    ViewUtils.loadImage(videoCoverImage.getImageUrl(), aVar2.d);
                }
            }
            AbstractNativeAd abstractNativeAd2 = this.c;
            if (abstractNativeAd2 != null) {
                abstractNativeAd2.registerViewForInteraction(this, com.yfanads.android.adx.service.a.FULL_VIDEO, aVar.f9572a, map, new AdxNativeAd.InteractionConf(adxFullScreenVideoTemplateData.isAutoClick(), adxFullScreenVideoTemplateData), this);
                IPlayVideo videoView2 = abstractNativeAd2.getVideoView2(this, new AdVideoPlayConfig.Builder().videoAutoPlayType(1).videoSoundEnable(!adxFullScreenVideoTemplateData.isMute()).build());
                this.l = videoView2;
                if (videoView2 == null) {
                    com.yfanads.android.adx.utils.a.a("AdxFullScreenVideoActivityplayVideo == null");
                    return;
                } else {
                    abstractNativeAd2.setVideoPlayListener(new com.yfanads.android.adx.components.fullscreen.a(this, aVar, abstractNativeAd2, videoView2.getView()));
                    return;
                }
            }
            return;
        }
        a(aVar, this.c, map, adxFullScreenVideoTemplateData);
    }

    public final void a(final com.yfanads.android.adx.components.viewholder.a aVar, final AbstractNativeAd abstractNativeAd, HashMap map, AdxFullScreenVideoTemplateData adxFullScreenVideoTemplateData) {
        if (abstractNativeAd == null || adxFullScreenVideoTemplateData == null) {
            return;
        }
        abstractNativeAd.registerViewForInteraction(this, com.yfanads.android.adx.service.a.FULL_VIDEO, aVar.f9572a, map, new AdxNativeAd.InteractionConf(adxFullScreenVideoTemplateData.isAutoClick(), adxFullScreenVideoTemplateData), this);
        aVar.t.post(new Runnable() { // from class: com.yfanads.android.adx.components.fullscreen.AdxFullScreenVideoActivity$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                AdxFullScreenVideoActivity.a(abstractNativeAd, aVar);
            }
        });
        this.e = this.f;
    }

    public static /* synthetic */ void a(AdxNativeAd adxNativeAd, com.yfanads.android.adx.components.viewholder.a aVar) {
        int videoWidth = adxNativeAd.getVideoWidth();
        int videoHeight = adxNativeAd.getVideoHeight();
        int width = aVar.t.getWidth();
        int height = aVar.t.getHeight();
        YFLog.info("AdxFullScreenVideoActivity w" + width + "|h" + height + "|vw" + videoWidth + "|vh" + videoHeight);
        i.a(aVar.t, width, height, videoWidth, videoHeight);
    }

    public final void a(AbstractNativeAd abstractNativeAd) {
        com.yfanads.android.adx.components.viewholder.a aVar = this.b;
        if (aVar != null) {
            aVar.d.setVisibility(0);
            int width = this.b.c.getWidth();
            int height = this.b.c.getHeight();
            YFLog.high("FullScreenVideo onVideoPlayComplete width " + width + " , height = " + height);
            if (abstractNativeAd != null) {
                if (abstractNativeAd.getEndVideoCoverImage() != null && !TextUtils.isEmpty(abstractNativeAd.getEndVideoCoverImage().getImageUrl())) {
                    ViewUtils.loadImage(abstractNativeAd.getEndVideoCoverImage().getImageUrl(), this.b.d);
                } else {
                    final ImageView imageView = this.b.d;
                    Objects.requireNonNull(imageView);
                    abstractNativeAd.getEndVideoBitmap(new AdxNativeAd.AdEndBitmap() { // from class: com.yfanads.android.adx.components.fullscreen.AdxFullScreenVideoActivity$$ExternalSyntheticLambda1
                        @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdEndBitmap
                        public final void onGetData(Bitmap bitmap) {
                            imageView.setImageBitmap(bitmap);
                        }
                    }, width, height);
                }
            }
            this.b.a();
            c();
            this.g = 0;
            this.e = this.f;
        }
    }

    public final void a(final AbstractNativeAd abstractNativeAd, i iVar, final View view) {
        com.yfanads.android.adx.components.viewholder.a aVar = this.b;
        if (aVar != null) {
            aVar.d.setVisibility(8);
            iVar.c.post(new Runnable() { // from class: com.yfanads.android.adx.components.fullscreen.AdxFullScreenVideoActivity$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(abstractNativeAd, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AbstractNativeAd abstractNativeAd, View view) {
        int width = this.b.c.getWidth();
        ViewUtils.setViewSize(this.b.c, width, (int) (((double) width) / (((double) abstractNativeAd.getVideoWidth()) / ((double) abstractNativeAd.getVideoHeight()))));
        if (view == null || view.getParent() != null) {
            return;
        }
        this.b.c.removeAllViews();
        this.b.c.addView(view);
    }

    public final void a(long j) {
        com.yfanads.android.adx.utils.a.a("AdxFullScreenVideoActivity startShowCloseTimer time=" + j);
        c();
        com.yfanads.android.adx.components.viewholder.a aVar = this.b;
        if (aVar == null) {
            com.yfanads.android.adx.utils.a.a("AdxFullScreenVideoActivity adxViewHolder == null");
            return;
        }
        if (j <= 0) {
            aVar.a();
            this.e = this.f;
        } else if (this.d == null) {
            b bVar = new b(j * 1000);
            this.d = bVar;
            bVar.start();
        }
    }

    public final void a(int i) {
        if (this.h && this.i) {
            YFUtil.MAIN_HANDLER.postDelayed(new Runnable() { // from class: com.yfanads.android.adx.components.fullscreen.AdxFullScreenVideoActivity$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.e();
                }
            }, i);
        }
    }
}
