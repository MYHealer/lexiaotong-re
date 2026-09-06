package com.yfanads.android.adx.components.rewardvideo;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.android.exoplayer2.ExoPlayer;
import com.loopj.android.http.AsyncHttpClient;
import com.stub.StubApp;
import com.yfanads.ads.chanel.adx.AdxInterstitialAdapter$$ExternalSyntheticLambda8;
import com.yfanads.android.YFAdsConfig;
import com.yfanads.android.YFAdsManager;
import com.yfanads.android.adx.R;
import com.yfanads.android.adx.api.AdVideoPlayConfig;
import com.yfanads.android.adx.components.base.BaseAppActivity;
import com.yfanads.android.adx.components.base.e;
import com.yfanads.android.adx.components.base.i;
import com.yfanads.android.adx.components.template.AdxRewardVideoTemplateData;
import com.yfanads.android.adx.core.impl.AbstractNativeAd;
import com.yfanads.android.adx.core.model.AdxImage;
import com.yfanads.android.adx.core.model.AdxNativeAd;
import com.yfanads.android.adx.model.SerializableMap;
import com.yfanads.android.adx.player.yfplayer.IPlayVideo;
import com.yfanads.android.custom.view.CustomDialog;
import com.yfanads.android.custom.view.OnFeedClickListener;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.libs.net.UrlHttpUtil;
import com.yfanads.android.libs.thirdpart.gson.Gson;
import com.yfanads.android.libs.thirdpart.gson.GsonBuilder;
import com.yfanads.android.libs.thirdpart.lottie.LottieAnimationView;
import com.yfanads.android.libs.utils.Util;
import com.yfanads.android.libs.utils.YFOptional;
import com.yfanads.android.lifecycle.BFLifecycleListener;
import com.yfanads.android.lifecycle.LifecycleObserver;
import com.yfanads.android.model.FeedCom;
import com.yfanads.android.model.TemplateConf;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class AdxRewardVideoActivity extends BaseAppActivity implements AdxNativeAd.AdInteractionListener, BFLifecycleListener {
    public static final /* synthetic */ int w = 0;
    public com.yfanads.android.adx.components.viewholder.b b;
    public AbstractNativeAd c;
    public b d;
    public c e;
    public com.yfanads.android.adx.components.rewardvideo.c f;
    public int g;
    public int h;
    public boolean i;
    public int j;
    public IPlayVideo k;
    public boolean l;
    public boolean m;
    public AdxRewardVideoTemplateData n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public Map<String, Object> u;
    public Gson v;

    public class a implements OnFeedClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TemplateConf f9578a;
        public final /* synthetic */ FeedCom b;

        public a(TemplateConf templateConf, FeedCom feedCom) {
            this.f9578a = templateConf;
            this.b = feedCom;
        }

        @Override // com.yfanads.android.custom.view.OnFeedClickListener
        public final void onDismiss() {
        }

        @Override // com.yfanads.android.custom.view.OnFeedClickListener
        public final void onTraceFeed() {
            AbstractNativeAd abstractNativeAd = AdxRewardVideoActivity.this.c;
            if (abstractNativeAd != null) {
                abstractNativeAd.traceData(this.f9578a, this.b, true);
            }
        }
    }

    public class b extends CountDownTimer {
        public b(long j) {
            super(j, 1000L);
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long j) {
            AdxRewardVideoActivity.this.g = (int) (j / 1000);
            com.yfanads.android.adx.utils.a.a("AdxRewardVideoActivity startShowCloseTimer onTick showCloseTime=" + AdxRewardVideoActivity.this.g);
            AdxRewardVideoActivity adxRewardVideoActivity = AdxRewardVideoActivity.this;
            if (adxRewardVideoActivity.g == 0) {
                adxRewardVideoActivity.e();
                AdxRewardVideoActivity.this.b.a();
            }
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            AdxRewardVideoActivity adxRewardVideoActivity = AdxRewardVideoActivity.this;
            if (adxRewardVideoActivity.g != 0) {
                adxRewardVideoActivity.e();
                AdxRewardVideoActivity.this.b.a();
            }
        }
    }

    public class c extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f9580a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(long j, String str) {
            super(j, 1000L);
            this.f9580a = str;
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            com.yfanads.android.adx.utils.a.a("AdxRewardVideoActivity CountDown finish " + AdxRewardVideoActivity.this.h);
            AdxRewardVideoActivity adxRewardVideoActivity = AdxRewardVideoActivity.this;
            if (adxRewardVideoActivity.h != 0) {
                adxRewardVideoActivity.i();
            }
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long j) {
            AdxRewardVideoActivity adxRewardVideoActivity = AdxRewardVideoActivity.this;
            int i = (int) (j / 1000);
            adxRewardVideoActivity.h = i;
            com.yfanads.android.adx.components.viewholder.b bVar = adxRewardVideoActivity.b;
            String str = String.format(this.f9580a, Integer.valueOf(i));
            bVar.s.setVisibility(0);
            bVar.t.setText(str);
            com.yfanads.android.adx.utils.a.a("AdxRewardVideoActivity CountDown time " + AdxRewardVideoActivity.this.h);
            AdxRewardVideoActivity adxRewardVideoActivity2 = AdxRewardVideoActivity.this;
            if (adxRewardVideoActivity2.h == 0) {
                adxRewardVideoActivity2.i();
            }
        }
    }

    static {
        StubApp.interface11(55969);
    }

    public static /* synthetic */ void a(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        this.b.v.setVisibility(0);
    }

    @Override // com.yfanads.android.adx.components.base.BaseAppActivity
    public final void a() {
    }

    public final void a(final TemplateConf templateConf, final FeedCom feedCom) {
        this.b.g.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.android.adx.components.rewardvideo.AdxRewardVideoActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.c(view);
            }
        });
        this.b.p.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.android.adx.components.rewardvideo.AdxRewardVideoActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.a(templateConf, feedCom, view);
            }
        });
    }

    @Override // com.yfanads.android.adx.components.base.BaseAppActivity
    public final void b() {
        AdxImage adxImage;
        int i;
        ImageView imageView;
        Intent intent = getIntent();
        AbstractNativeAd abstractNativeAd = (AbstractNativeAd) intent.getParcelableExtra("nativeAds");
        this.c = abstractNativeAd;
        if (abstractNativeAd == null) {
            com.yfanads.android.adx.utils.a.b("AdxRewardVideoActivity initView nativeAds == null ");
            return;
        }
        TemplateConf templateConf = (TemplateConf) intent.getParcelableExtra("templateConf");
        FeedCom feedCom = (FeedCom) intent.getParcelableExtra("feedCom");
        SerializableMap serializableMap = (SerializableMap) getIntent().getParcelableExtra("data");
        if (serializableMap != null) {
            this.u = serializableMap.f9610a;
        }
        AdxRewardVideoTemplateData adxRewardVideoTemplateData = new AdxRewardVideoTemplateData();
        this.n = adxRewardVideoTemplateData;
        adxRewardVideoTemplateData.setConf(templateConf);
        boolean z = this.c.getMaterialType() == 1;
        AdxRewardVideoTemplateData adxRewardVideoTemplateData2 = this.n;
        this.s = adxRewardVideoTemplateData2.isActionOne();
        this.t = adxRewardVideoTemplateData2.isShake() || adxRewardVideoTemplateData2.isTwist();
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.item_adx_reward_video, (ViewGroup) this.f9564a, true);
        getApplicationContext();
        com.yfanads.android.adx.components.viewholder.b bVar = new com.yfanads.android.adx.components.viewholder.b(viewInflate);
        this.b = bVar;
        AbstractNativeAd abstractNativeAd2 = this.c;
        AdxRewardVideoTemplateData adxRewardVideoTemplateData3 = this.n;
        adxRewardVideoTemplateData3.getClass();
        int iDip2px = ScreenUtil.dip2px(this, 22.0f);
        TemplateConf templateConf2 = adxRewardVideoTemplateData3.conf;
        if (templateConf2 != null) {
            int i2 = templateConf2.cbs;
            if (i2 == 1) {
                iDip2px = ScreenUtil.dip2px(this, 11.0f);
            } else if (i2 == 2) {
                iDip2px = ScreenUtil.dip2px(this, 17.0f);
            } else if (i2 == 4) {
                iDip2px = ScreenUtil.dip2px(this, 28.0f);
            } else if (i2 == 5) {
                iDip2px = ScreenUtil.dip2px(this, 33.0f);
            }
        }
        TemplateConf templateConf3 = adxRewardVideoTemplateData3.conf;
        int i3 = templateConf3 != null ? templateConf3.cbp : 2;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.g.getLayoutParams();
        layoutParams.width = iDip2px;
        layoutParams.height = iDip2px;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.s.getLayoutParams();
        if (i3 == 1) {
            layoutParams.addRule(20);
            layoutParams2.addRule(21);
        } else {
            layoutParams.addRule(21);
            layoutParams2.addRule(20);
        }
        bVar.g.setLayoutParams(layoutParams);
        bVar.s.setLayoutParams(layoutParams2);
        float clickRatio = adxRewardVideoTemplateData3.getClickRatio();
        int screenWidth = (int) (ScreenUtil.getScreenWidth(this) * clickRatio);
        int screenHeight = (int) (ScreenUtil.getScreenHeight(this) * clickRatio);
        com.yfanads.android.adx.utils.a.a("updateClickSize width = " + screenWidth + " , height = " + screenHeight + " , clickRatio " + clickRatio);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(screenWidth, screenHeight);
        layoutParams3.addRule(13);
        bVar.f.setLayoutParams(layoutParams3);
        bVar.u.setVisibility(z ? 8 : 0);
        bVar.v.setVisibility(z ? 8 : 0);
        bVar.c.setVisibility(z ? 0 : 8);
        bVar.a(abstractNativeAd2);
        adxRewardVideoTemplateData3.setAdx(true);
        adxRewardVideoTemplateData3.updAdLog(R.mipmap.yf_ad_logo);
        int i4 = adxRewardVideoTemplateData3.adLogo;
        if (i4 > 0 && (imageView = bVar.i) != null) {
            imageView.setImageResource(i4);
        }
        bVar.a(this, abstractNativeAd2);
        bVar.a(this, adxRewardVideoTemplateData3);
        bVar.n.setVisibility(adxRewardVideoTemplateData3.isShowBtn() ? 0 : 8);
        if (z) {
            if (this.c.getVideoCoverImage() == null || TextUtils.isEmpty(this.c.getVideoCoverImage().getImageUrl())) {
                ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, this.b.b);
            } else {
                ViewUtils.loadBlurImage(this.c.getVideoCoverImage().getImageUrl(), this.b.b, 0);
            }
        } else if (YFListUtils.isEmpty(this.c.getImageList()) || (adxImage = this.c.getImageList().get(0)) == null || !adxImage.isValid() || TextUtils.isEmpty(adxImage.getImageUrl())) {
            ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, this.b.b);
        } else {
            this.b.v.setVisibility(4);
            ViewUtils.loadBlurImage(adxImage.getImageUrl(), this.b.b, 20);
            ViewUtils.loadImage(adxImage.getImageUrl(), this.b.u, new ViewUtils.ViewImageCallback() { // from class: com.yfanads.android.adx.components.rewardvideo.AdxRewardVideoActivity$$ExternalSyntheticLambda2
                @Override // com.yfanads.android.utils.ViewUtils.ViewImageCallback
                public final void onResourceReady() {
                    this.f$0.h();
                }
            });
        }
        a(templateConf, feedCom);
        a(z, this.b, this.n);
        AdxRewardVideoTemplateData adxRewardVideoTemplateData4 = this.n;
        try {
            int videoKeepTime = this.c.getVideoKeepTime();
            int videoDuration = this.c.getVideoDuration();
            if (videoKeepTime > 0) {
                i = videoKeepTime;
            } else {
                i = videoDuration > 0 ? videoDuration : 5;
            }
            int iMin = Math.min(i, 30);
            this.h = iMin;
            TemplateConf templateConf4 = adxRewardVideoTemplateData4.conf;
            int i5 = templateConf4 != null ? templateConf4.cbst : 0;
            this.g = i5;
            if (i5 > iMin) {
                this.l = true;
            }
            com.yfanads.android.adx.utils.a.a("AdxRewardVideoActivity processTimeLogic receiveRewardTime=" + this.h + " ,showCloseTime=" + this.g);
        } catch (Exception e) {
            e.a(e, new StringBuilder("processTimeLogic "));
        }
        b(this.g);
        a(this.h);
        try {
            AbstractNativeAd abstractNativeAd3 = this.c;
            if (abstractNativeAd3 != null) {
                abstractNativeAd3.reStartInteraction();
            }
        } catch (Exception e2) {
            e.a(e2, new StringBuilder("reStartTwistOrShake "));
        }
        f();
    }

    public final void f() {
        com.yfanads.android.adx.components.viewholder.b bVar = this.b;
        AbstractNativeAd abstractNativeAd = this.c;
        AdxRewardVideoTemplateData adxRewardVideoTemplateData = this.n;
        bVar.getClass();
        if (com.yfanads.android.adx.components.viewholder.b.a(abstractNativeAd, adxRewardVideoTemplateData)) {
            com.yfanads.android.adx.utils.b.b.postDelayed(new Runnable() { // from class: com.yfanads.android.adx.components.rewardvideo.AdxRewardVideoActivity$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.g();
                }
            }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public final boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
        return false;
    }

    public final void i() {
        String string;
        TemplateConf templateConf;
        AdxNativeAd.AdInteractionListener2 adInteractionListener2A = com.yfanads.android.adx.service.d.a.f9620a.a(com.yfanads.android.adx.service.a.REWARD);
        if (adInteractionListener2A instanceof AdxNativeAd.RewardAdInteractionListener) {
            AdxRewardVideoTemplateData adxRewardVideoTemplateData = this.n;
            boolean z = (adxRewardVideoTemplateData == null || (templateConf = adxRewardVideoTemplateData.conf) == null || templateConf.sv != 1) ? false : true;
            com.yfanads.android.adx.utils.a.a("AdxRewardVideoActivity startReceiveRewardTimer onRewardVerify" + z);
            YFAdsConfig yFAdsConfig = YFAdsManager.getInstance().getYFAdsConfig();
            if (z) {
                if (this.v == null) {
                    this.v = new GsonBuilder().create();
                }
                HashMap map = new HashMap();
                String strA = a("adID");
                String strA2 = a("adnAppID");
                String strA3 = a("adnAdID");
                String strA4 = a("adnID");
                map.put("userExtra", this.v.toJson(this.u));
                map.put(YFAdsConst.REPORT_APPID, yFAdsConfig.getAppId());
                map.put("adID", strA);
                map.put("adnAppID", strA2);
                map.put("adnAdID", strA3);
                map.put("adnID", strA4);
                String strA5 = a(YFAdsConst.USER_KEY);
                long jCurrentTimeMillis = System.currentTimeMillis();
                try {
                    byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest((strA5 + "_" + strA + "_" + (jCurrentTimeMillis / 1000)).getBytes(StandardCharsets.UTF_8));
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : bArrDigest) {
                        String hexString = Integer.toHexString(b2 & 255);
                        if (hexString.length() == 1) {
                            sb.append('0');
                        }
                        sb.append(hexString);
                    }
                    string = sb.toString();
                } catch (Exception e) {
                    e.a(e, new StringBuilder("generateHash: "));
                    string = "";
                }
                HashMap map2 = new HashMap();
                map2.put("userID", strA5);
                map2.put(com.alipay.sdk.tid.b.f, Long.valueOf(jCurrentTimeMillis));
                map2.put("transID", string);
                map2.put("extra", map);
                String strEncryptRSA = Util.encryptRSA(this.v.toJson(map2), UrlConst.getRsaKey());
                String rewardDomain = UrlConst.getRewardDomain("/api/reward");
                HashMap map3 = new HashMap();
                map3.put("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
                UrlHttpUtil.postJson(rewardDomain, strEncryptRSA, map3, new com.yfanads.android.adx.components.rewardvideo.b(this, adInteractionListener2A));
            } else {
                ((AdxNativeAd.RewardAdInteractionListener) adInteractionListener2A).onRewardVerify(true, "success");
            }
        }
        String string2 = StubApp.getOrigApplicationContext(getApplicationContext()).getString(R.string.adx_received_rewards);
        com.yfanads.android.adx.components.viewholder.b bVar = this.b;
        bVar.s.setVisibility(0);
        bVar.t.setText(string2);
        com.yfanads.android.adx.utils.a.a("AdxRewardVideoActivity onFinishAction isGreaterThanReceiveRewardTime=" + this.l);
        if (this.l) {
            e();
            d();
            this.g = 0;
            this.b.a();
        }
        com.yfanads.android.adx.components.viewholder.b bVar2 = this.b;
        bVar2.getClass();
        YFLog.debug("AdxRewardVideoViewHolder hideRewardDialogView");
        FrameLayout frameLayout = bVar2.w;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    public final void l() {
        this.n.resetActivityStyle(BaseTemplateData.InteractiveStyle.CLICK_NOT_HAS_FINGER.getValue());
        AdxRewardVideoTemplateData adxRewardVideoTemplateData = this.n;
        this.s = adxRewardVideoTemplateData.isActionOne();
        this.t = adxRewardVideoTemplateData.isShake() || adxRewardVideoTemplateData.isTwist();
        com.yfanads.android.adx.components.viewholder.b bVar = this.b;
        if (bVar != null) {
            bVar.a(this, this.n);
            LottieAnimationView lottieAnimationView = this.b.n;
            if (lottieAnimationView != null) {
                lottieAnimationView.setEnabled(true);
            }
        }
        YFOptional.ofNullable(this.c).ifPresentRun(new AdxInterstitialAdapter$$ExternalSyntheticLambda8());
    }

    @Override // android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.yfanads.android.adx.utils.a.a("AdxRewardVideoActivity onActivityResult requestCode=" + i + " ,  resultCode=" + i2);
        if (i == 101 && i2 == 101) {
            try {
                AbstractNativeAd abstractNativeAd = this.c;
                if (abstractNativeAd != null) {
                    abstractNativeAd.reStartInteraction();
                }
            } catch (Exception e) {
                e.a(e, new StringBuilder("reStartTwistOrShake "));
            }
            b(this.g);
            a(this.h);
            IPlayVideo iPlayVideo = this.k;
            if (iPlayVideo != null) {
                iPlayVideo.reStart();
            }
        }
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public final void onAdClickedSuccess(boolean z, boolean z2, boolean z3) {
        YFLog.debug("AdxRewardVideoActivity onAdClickedSuccess" + z2);
        this.o = true;
        if (!z2) {
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
            return;
        }
        d();
        e();
        j();
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public final void onAdHide() {
        d();
        e();
        j();
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public final void onAdShow() {
        com.yfanads.android.adx.utils.a.a("AdxRewardVideoActivity onAdShow ");
        if (this.m) {
            j();
            return;
        }
        com.yfanads.android.adx.components.viewholder.b bVar = this.b;
        if (bVar == null) {
            com.yfanads.android.adx.utils.a.a(" adxRewardHolder == null ");
            return;
        }
        CustomDialog customDialog = bVar.q;
        if (customDialog != null) {
            bVar.r = customDialog.isVisible();
        } else {
            bVar.r = false;
        }
        if (bVar.r) {
            j();
            return;
        }
        try {
            AbstractNativeAd abstractNativeAd = this.c;
            if (abstractNativeAd != null) {
                abstractNativeAd.reStartInteraction();
            }
        } catch (Exception e) {
            e.a(e, new StringBuilder("reStartTwistOrShake "));
        }
        b(this.g);
        a(this.h);
        IPlayVideo iPlayVideo = this.k;
        if (iPlayVideo != null) {
            iPlayVideo.reStart();
        }
        IPlayVideo iPlayVideo2 = this.k;
        if (iPlayVideo2 != null) {
            iPlayVideo2.reStart();
        }
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
    }

    @Override // com.yfanads.android.adx.components.base.BaseAppActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public final void onDestroy() {
        k();
        LifecycleObserver.getInstance().unRegisterLifecycleListener(this);
        c();
        super.onDestroy();
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public final void onExposure(boolean z) {
        AdxNativeAd.AdInteractionListener2 adInteractionListener2A = com.yfanads.android.adx.service.d.a.f9620a.a(com.yfanads.android.adx.service.a.REWARD);
        if (adInteractionListener2A != null) {
            adInteractionListener2A.onExposure(z);
        }
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public final void onHandleClick(boolean z) {
        YFLog.debug("AdxRewardVideoActivity onHandleClick");
        AdxNativeAd.AdInteractionListener2 adInteractionListener2A = com.yfanads.android.adx.service.d.a.f9620a.a(com.yfanads.android.adx.service.a.REWARD);
        if (adInteractionListener2A != null) {
            adInteractionListener2A.onHandleClick(z);
        }
    }

    public final void c() {
        if (this.f != null) {
            com.yfanads.android.adx.utils.a.a("AdxRewardVideoActivity cancelAfterClickTimer");
            this.f.cancel();
            this.f = null;
        }
    }

    public final void d() {
        c cVar = this.e;
        if (cVar != null) {
            cVar.cancel();
            this.e = null;
        }
    }

    public final void e() {
        b bVar = this.d;
        if (bVar != null) {
            bVar.cancel();
            this.d = null;
        }
    }

    public final void j() {
        IPlayVideo iPlayVideo = this.k;
        if (iPlayVideo != null) {
            iPlayVideo.pause();
        }
    }

    public final void k() {
        AdxNativeAd.AdInteractionListener2 adInteractionListener2A;
        if (!this.i && (adInteractionListener2A = com.yfanads.android.adx.service.d.a.f9620a.a(com.yfanads.android.adx.service.a.REWARD)) != null) {
            adInteractionListener2A.onAdClose(null);
        }
        this.i = true;
        AbstractNativeAd abstractNativeAd = this.c;
        if (abstractNativeAd != null) {
            abstractNativeAd.destroy(com.yfanads.android.adx.service.a.REWARD);
            this.c = null;
        }
        d();
        e();
        finish();
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public final void onAdShakeCancel() {
        if (this.t && this.s) {
            l();
        }
    }

    @Override // com.yfanads.android.lifecycle.AbsLifecycleListener
    public final void onBackToForeground() {
        this.q = false;
        com.yfanads.android.adx.utils.a.a("AdxRewardVideoActivity onBackToForeground canShowExperienceDialog " + this.r);
        c();
        if (this.r) {
            this.b.b();
        }
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public final void onDownloadTipsDismiss() {
        this.m = false;
        com.yfanads.android.adx.utils.a.a("AdxRewardVideoActivity onDownloadTipsDismiss showCloseTime=" + this.g);
        com.yfanads.android.adx.utils.a.a("AdxRewardVideoActivity onDownloadTipsDismiss receiveRewardTime=" + this.h);
        try {
            AbstractNativeAd abstractNativeAd = this.c;
            if (abstractNativeAd != null) {
                abstractNativeAd.reStartInteraction();
            }
        } catch (Exception e) {
            e.a(e, new StringBuilder("reStartTwistOrShake "));
        }
        b(this.g);
        a(this.h);
        IPlayVideo iPlayVideo = this.k;
        if (iPlayVideo != null) {
            iPlayVideo.reStart();
        }
        IPlayVideo iPlayVideo2 = this.k;
        if (iPlayVideo2 != null) {
            iPlayVideo2.reStart();
        }
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public final void onDownloadTipsShow() {
        this.m = true;
        com.yfanads.android.adx.utils.a.a("AdxRewardVideoActivity onDownloadTipsShow ");
        e();
        d();
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(TemplateConf templateConf, FeedCom feedCom, View view) {
        this.b.a(getFragmentManager(), new a(templateConf, feedCom));
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public final void onAdShakeSuccess(boolean z, boolean z2, boolean z3) {
        this.o = true;
        boolean z4 = this.t && this.s;
        YFLog.debug("AdxRewardVideoActivity onAdShakeSuccess = " + z4);
        if (z4) {
            l();
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
        } else {
            if (z3) {
                return;
            }
            d();
            e();
            j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        try {
            if (!this.o) {
                this.b.b();
                this.r = false;
            } else if (this.p) {
                d();
                c();
                i();
            } else {
                this.r = true;
                if (this.q) {
                    return;
                }
                c();
                this.b.b();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(boolean z, com.yfanads.android.adx.components.viewholder.b bVar, AdxRewardVideoTemplateData adxRewardVideoTemplateData) {
        int i;
        if (bVar == null || adxRewardVideoTemplateData == null) {
            return;
        }
        try {
            HashMap map = new HashMap();
            BaseTemplateData.InteractiveStyle activeStyle = adxRewardVideoTemplateData.getActiveStyle();
            if (activeStyle == BaseTemplateData.InteractiveStyle.SHAKE || activeStyle == BaseTemplateData.InteractiveStyle.CLICK_SHAKE) {
                i = 1;
            } else if (activeStyle == BaseTemplateData.InteractiveStyle.TWIST || activeStyle == BaseTemplateData.InteractiveStyle.CLICK_TWIST) {
                i = 2;
            } else {
                i = (activeStyle == BaseTemplateData.InteractiveStyle.SLIDE || activeStyle == BaseTemplateData.InteractiveStyle.CLICK_SLIDE) ? 3 : 0;
            }
            this.j = i;
            BaseTemplateData.InteractiveStyle activeStyle2 = adxRewardVideoTemplateData.getActiveStyle();
            if (activeStyle2 != BaseTemplateData.InteractiveStyle.CLICK && activeStyle2 != BaseTemplateData.InteractiveStyle.CLICK_SHAKE && activeStyle2 != BaseTemplateData.InteractiveStyle.CLICK_TWIST && activeStyle2 != BaseTemplateData.InteractiveStyle.CLICK_NOT_HAS_FINGER) {
                BaseTemplateData.InteractiveStyle interactiveStyle = BaseTemplateData.InteractiveStyle.CLICK_SLIDE;
            }
            map.put(bVar.f, 4);
            if (adxRewardVideoTemplateData.isWholeClick()) {
                FrameLayout frameLayout = bVar.w;
                if (frameLayout != null) {
                    map.put(frameLayout, 4);
                }
            } else {
                FrameLayout frameLayout2 = bVar.w;
                if (frameLayout2 != null) {
                    frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.android.adx.components.rewardvideo.AdxRewardVideoActivity$$ExternalSyntheticLambda6
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            AdxRewardVideoActivity.a(view);
                        }
                    });
                }
                ImageView imageView = bVar.y;
                if (imageView != null) {
                    map.put(imageView, 4);
                }
            }
            map.put(bVar.o, Integer.valueOf(this.j));
            map.put(bVar.m, Integer.valueOf(this.j));
            map.put(bVar.n, 5);
            boolean zIsActionClickType = adxRewardVideoTemplateData.isActionClickType();
            LottieAnimationView lottieAnimationView = bVar.n;
            if (lottieAnimationView != null) {
                lottieAnimationView.setEnabled(zIsActionClickType);
            }
            if (z) {
                bVar.e.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.android.adx.components.rewardvideo.AdxRewardVideoActivity$$ExternalSyntheticLambda7
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        com.yfanads.android.adx.utils.a.a("AdxRewardVideoActivity onClickView ");
                    }
                });
                a((i) bVar, this.c, map, adxRewardVideoTemplateData);
            } else {
                a(bVar, this.c, map, adxRewardVideoTemplateData);
            }
        } catch (Exception e) {
            e.a(e, new StringBuilder("registerViewForInteraction "));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view) {
        if (com.yfanads.android.adx.utils.b.b()) {
            com.yfanads.android.adx.components.viewholder.b bVar = this.b;
            if (bVar != null) {
                CustomDialog customDialog = bVar.q;
                if (customDialog != null) {
                    bVar.r = customDialog.isVisible();
                } else {
                    bVar.r = false;
                }
                if (!bVar.r) {
                    com.yfanads.android.adx.utils.a.a("AdxRewardVideoActivity onClose receiveRewardTime=" + this.h);
                    int i = this.h;
                    if (i > 0) {
                        this.b.a(this, i, new d(this));
                        try {
                            AbstractNativeAd abstractNativeAd = this.c;
                            if (abstractNativeAd != null) {
                                abstractNativeAd.stopInteraction();
                            }
                        } catch (Exception e) {
                            e.a(e, new StringBuilder("stopTwistOrShake "));
                        }
                        e();
                        d();
                        IPlayVideo iPlayVideo = this.k;
                        if (iPlayVideo != null) {
                            iPlayVideo.pause();
                            return;
                        }
                        return;
                    }
                    k();
                    return;
                }
            }
            com.yfanads.android.adx.utils.a.a("AdxRewardVideoActivity adxRewardHolder == null or showDialog");
        }
    }

    @Override // com.yfanads.android.lifecycle.AbsLifecycleListener
    public final void onBackToBackground() {
        AbstractNativeAd abstractNativeAd;
        AdxRewardVideoTemplateData adxRewardVideoTemplateData;
        this.q = true;
        if (this.o && !this.p && this.b != null && (abstractNativeAd = this.c) != null && (adxRewardVideoTemplateData = this.n) != null && com.yfanads.android.adx.components.viewholder.b.a(abstractNativeAd, adxRewardVideoTemplateData)) {
            com.yfanads.android.adx.utils.a.a("AdxRewardVideoActivity onBackToBackground isClicked & needShowRewardDialogView");
            com.yfanads.android.adx.components.viewholder.b bVar = this.b;
            AbstractNativeAd abstractNativeAd2 = this.c;
            AdxRewardVideoTemplateData adxRewardVideoTemplateData2 = this.n;
            bVar.getClass();
            if (com.yfanads.android.adx.components.viewholder.b.a(abstractNativeAd2, adxRewardVideoTemplateData2)) {
                com.yfanads.android.adx.utils.a.a("AdxRewardVideoActivity startAfterClickTimer time=5");
                c();
                if (this.b == null) {
                    com.yfanads.android.adx.utils.a.a("AdxRewardVideoActivity adxRewardHolder == null ,return");
                    return;
                }
                if (this.f == null) {
                    com.yfanads.android.adx.utils.a.a("AdxRewardVideoActivity startAfterClickTimer - ");
                    com.yfanads.android.adx.components.rewardvideo.c cVar = new com.yfanads.android.adx.components.rewardvideo.c(this, 5000L, new int[1]);
                    this.f = cVar;
                    cVar.start();
                    com.yfanads.android.adx.utils.a.a("AdxRewardVideoActivity startAfterClickTimer start");
                    return;
                }
                return;
            }
            return;
        }
        com.yfanads.android.adx.utils.a.a("AdxRewardVideoActivity onBackToBackground  click " + this.o + " isCompleteExperience " + this.p);
    }

    public final void a(final com.yfanads.android.adx.components.viewholder.b bVar, final AbstractNativeAd abstractNativeAd, HashMap map, AdxRewardVideoTemplateData adxRewardVideoTemplateData) {
        abstractNativeAd.registerViewForInteraction(this, com.yfanads.android.adx.service.a.REWARD, bVar.f9572a, map, new AdxNativeAd.InteractionConf(adxRewardVideoTemplateData.isAutoClick(), adxRewardVideoTemplateData), this);
        bVar.u.post(new Runnable() { // from class: com.yfanads.android.adx.components.rewardvideo.AdxRewardVideoActivity$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                AdxRewardVideoActivity.a(abstractNativeAd, bVar);
            }
        });
    }

    public static /* synthetic */ void a(AdxNativeAd adxNativeAd, com.yfanads.android.adx.components.viewholder.b bVar) {
        int videoWidth = adxNativeAd.getVideoWidth();
        int videoHeight = adxNativeAd.getVideoHeight();
        int width = bVar.u.getWidth();
        int height = bVar.u.getHeight();
        YFLog.info("AdxRewardVideoActivity w" + width + "|h" + height + "|vw" + videoWidth + "|vh" + videoHeight);
        i.a(bVar.u, width, height, videoWidth, videoHeight);
    }

    public final void a(i iVar, AbstractNativeAd abstractNativeAd, HashMap map, AdxRewardVideoTemplateData adxRewardVideoTemplateData) {
        if (abstractNativeAd != null) {
            abstractNativeAd.registerViewForInteraction(this, com.yfanads.android.adx.service.a.REWARD, iVar.f9572a, map, new AdxNativeAd.InteractionConf(adxRewardVideoTemplateData.isAutoClick(), adxRewardVideoTemplateData), this);
            com.yfanads.android.adx.components.viewholder.b bVar = this.b;
            AdxImage videoCoverImage = abstractNativeAd.getVideoCoverImage();
            bVar.getClass();
            if (videoCoverImage != null && !TextUtils.isEmpty(videoCoverImage.getImageUrl())) {
                bVar.d.setVisibility(0);
                ViewUtils.loadImage(videoCoverImage.getImageUrl(), bVar.d);
            }
            IPlayVideo videoView2 = abstractNativeAd.getVideoView2(this, new AdVideoPlayConfig.Builder().videoAutoPlayType(1).videoSoundEnable(!adxRewardVideoTemplateData.isMute()).build());
            this.k = videoView2;
            if (videoView2 == null) {
                com.yfanads.android.adx.utils.a.a("AdxRewardVideoActivityplayVideo == null");
            } else {
                abstractNativeAd.setVideoPlayListener(new com.yfanads.android.adx.components.rewardvideo.a(this, iVar, abstractNativeAd, videoView2.getView()));
            }
        }
    }

    public final void a(AbstractNativeAd abstractNativeAd) {
        com.yfanads.android.adx.components.viewholder.b bVar = this.b;
        if (bVar != null) {
            bVar.d.setVisibility(0);
            int width = this.b.c.getWidth();
            int height = this.b.c.getHeight();
            YFLog.high("RewardVideo onVideoPlayComplete width " + width + " , height = " + height);
            if (abstractNativeAd != null) {
                if (abstractNativeAd.getEndVideoCoverImage() != null && !TextUtils.isEmpty(abstractNativeAd.getEndVideoCoverImage().getImageUrl())) {
                    ViewUtils.loadImage(abstractNativeAd.getEndVideoCoverImage().getImageUrl(), this.b.d);
                } else {
                    final ImageView imageView = this.b.d;
                    Objects.requireNonNull(imageView);
                    abstractNativeAd.getEndVideoBitmap(new AdxNativeAd.AdEndBitmap() { // from class: com.yfanads.android.adx.components.rewardvideo.AdxRewardVideoActivity$$ExternalSyntheticLambda0
                        @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdEndBitmap
                        public final void onGetData(Bitmap bitmap) {
                            imageView.setImageBitmap(bitmap);
                        }
                    }, width, height);
                }
            }
            this.b.a();
            e();
            this.g = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbstractNativeAd abstractNativeAd, i iVar, View view) {
        int width;
        int videoWidth = abstractNativeAd.getVideoWidth();
        int videoHeight = abstractNativeAd.getVideoHeight();
        if (videoWidth > 0 && videoHeight > 0) {
            if (iVar.c.getWidth() == 0) {
                width = com.yfanads.android.adx.service.c.a.f9618a.c;
            } else {
                width = iVar.c.getWidth();
            }
            ViewUtils.setViewSize(this.b.c, width, (int) (((double) width) / (((double) videoWidth) / ((double) videoHeight))));
            YFLog.debug("AdxRewardVideoActivity onVideoPlayStart width " + width + " , videoHeight = " + videoHeight + " , videoWidth = " + videoWidth);
        }
        if (view == null || view.getParent() != null) {
            return;
        }
        this.b.c.removeAllViews();
        this.b.c.addView(view);
    }

    public final void a(long j) {
        String string;
        AbstractNativeAd abstractNativeAd;
        com.yfanads.android.adx.utils.a.a("AdxRewardVideoActivity startReceiveRewardTimer time=" + j);
        d();
        if (this.b == null) {
            com.yfanads.android.adx.utils.a.a("AdxRewardVideoActivity adxRewardHolder == null");
            return;
        }
        if (j > 0 && this.e == null) {
            AdxRewardVideoTemplateData adxRewardVideoTemplateData = this.n;
            if (adxRewardVideoTemplateData != null && (abstractNativeAd = this.c) != null && com.yfanads.android.adx.components.viewholder.b.a(abstractNativeAd, adxRewardVideoTemplateData)) {
                string = StubApp.getOrigApplicationContext(getApplicationContext()).getString(R.string.adx_jump_experience_reward_tips);
                com.yfanads.android.adx.components.viewholder.b bVar = this.b;
                String str = String.format(string, Long.valueOf(j));
                bVar.s.setVisibility(0);
                bVar.t.setText(str);
            } else {
                string = StubApp.getOrigApplicationContext(getApplicationContext()).getString(R.string.adx_jump_receive_reward_tips);
                com.yfanads.android.adx.components.viewholder.b bVar2 = this.b;
                String str2 = String.format(string, Long.valueOf(j));
                bVar2.s.setVisibility(0);
                bVar2.t.setText(str2);
            }
            com.yfanads.android.adx.utils.a.a("AdxRewardVideoActivity startReceiveRewardTimer time=" + j);
            c cVar = new c(j * 1000, string);
            this.e = cVar;
            cVar.start();
            return;
        }
        String string2 = StubApp.getOrigApplicationContext(getApplicationContext()).getString(R.string.adx_received_rewards);
        com.yfanads.android.adx.components.viewholder.b bVar3 = this.b;
        bVar3.s.setVisibility(0);
        bVar3.t.setText(string2);
    }

    public final String a(String str) {
        try {
            Map<String, Object> map = this.u;
            if (map != null && !map.isEmpty()) {
                Object objRemove = this.u.remove(str);
                if (objRemove instanceof String) {
                    return (String) objRemove;
                }
                return "";
            }
            return "";
        } catch (Exception e) {
            e.a(e, new StringBuilder("getValue "));
        }
    }

    public final void b(final AbstractNativeAd abstractNativeAd, final i iVar, final View view) {
        com.yfanads.android.adx.components.viewholder.b bVar = this.b;
        if (bVar != null) {
            bVar.d.setVisibility(8);
            iVar.c.post(new Runnable() { // from class: com.yfanads.android.adx.components.rewardvideo.AdxRewardVideoActivity$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(abstractNativeAd, iVar, view);
                }
            });
        }
    }

    public final void b(long j) {
        com.yfanads.android.adx.utils.a.a("AdxRewardVideoActivity startShowCloseTimer time=" + j);
        e();
        com.yfanads.android.adx.components.viewholder.b bVar = this.b;
        if (bVar == null) {
            com.yfanads.android.adx.utils.a.a("AdxRewardVideoActivity adxRewardHolder == null");
            return;
        }
        if (j > 0 && this.d == null) {
            b bVar2 = new b(j * 1000);
            this.d = bVar2;
            bVar2.start();
            return;
        }
        bVar.a();
    }
}
