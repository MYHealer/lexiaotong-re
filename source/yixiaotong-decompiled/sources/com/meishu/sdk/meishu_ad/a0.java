package com.meishu.sdk.meishu_ad;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.gson.Gson;
import com.meishu.sdk.R;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener;
import com.meishu.sdk.core.exception.ErrorCodeUtil;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.SdkHandler;
import com.meishu.sdk.core.utils.k1;
import com.meishu.sdk.core.utils.o1;
import com.meishu.sdk.meishu_ad.nativ.NormalMediaView;
import com.meishu.sdk.meishu_ad.splash.MeishuSplashRootView;
import com.meishu.sdk.meishu_ad.splash.SplashSkipView;
import com.meishu.sdk.meishu_ad.view.MeishuVideoCahceTextureView;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: AdNative.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a0 implements com.meishu.sdk.core.bquery.h<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.c f4997a;
    public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.d b;
    public final /* synthetic */ MeishuSplashRootView c;
    public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.a d;
    public final /* synthetic */ View e;
    public final /* synthetic */ int f;
    public final /* synthetic */ int g;
    public final /* synthetic */ boolean h;
    public final /* synthetic */ AtomicBoolean i;
    public final /* synthetic */ ImageView j;
    public final /* synthetic */ com.meishu.sdk.core.bquery.i k;
    public final /* synthetic */ v l;

    /* JADX INFO: compiled from: AdNative.java */
    public class a implements com.meishu.sdk.meishu_ad.nativ.a {
        public a(a0 a0Var) {
        }

        @Override // com.meishu.sdk.meishu_ad.m0
        public void onADExposure() {
        }

        @Override // com.meishu.sdk.meishu_ad.m0
        public /* bridge */ /* synthetic */ void onADLoaded(List<com.meishu.sdk.meishu_ad.nativ.b> list) {
        }

        @Override // com.meishu.sdk.meishu_ad.m0
        public void onAdRenderFail(String str, int i) {
        }
    }

    /* JADX INFO: compiled from: AdNative.java */
    public class b implements RecyclerAdMediaListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NormalMediaView f4998a;

        /* JADX INFO: compiled from: AdNative.java */
        public class a extends com.meishu.sdk.core.safe.l {
            public a() {
            }

            @Override // com.meishu.sdk.core.safe.l
            public void safeRun() {
                b.this.f4998a.d();
                View adView = a0.this.f4997a.getAdView();
                if (adView != null) {
                    ViewParent parent = adView.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(adView);
                    }
                }
            }
        }

        public b(NormalMediaView normalMediaView) {
            this.f4998a = normalMediaView;
        }

        @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
        public void onProgressUpdate(long j, long j2) {
        }

        @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
        public void onVideoCompleted() {
            a0 a0Var = a0.this;
            com.meishu.sdk.meishu_ad.splash.c cVar = a0Var.f4997a;
            cVar.g = true;
            if (a0Var.b.H == 1 && cVar.h) {
                new Handler(Looper.getMainLooper()).postDelayed(new a(), 4000L);
            }
        }

        @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
        public void onVideoError() {
        }

        @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
        public void onVideoLoaded() {
            a0.this.i.get();
        }

        @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
        public void onVideoPause() {
        }

        @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
        public void onVideoResume() {
        }

        @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
        public void onVideoStart() {
        }
    }

    /* JADX INFO: compiled from: AdNative.java */
    public class c extends com.meishu.sdk.core.safe.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f5000a;
        public final /* synthetic */ String b;
        public final /* synthetic */ CountDownLatch c;
        public final /* synthetic */ NormalMediaView d;

        public c(Object obj, String str, CountDownLatch countDownLatch, NormalMediaView normalMediaView) {
            this.f5000a = obj;
            this.b = str;
            this.c = countDownLatch;
            this.d = normalMediaView;
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            Bitmap videoThumb = null;
            if (this.f5000a instanceof MediaPlayer) {
                String str = this.b;
                if (!TextUtils.isEmpty(str)) {
                    try {
                        File fileA = com.meishu.sdk.core.bquery.g.a(str, (String) null);
                        File fileA2 = com.meishu.sdk.core.bquery.g.a(str, "temp");
                        File fileA3 = com.meishu.sdk.core.bquery.g.a(str, "last_meta_temp");
                        if (fileA.exists()) {
                            videoThumb = com.meishu.sdk.core.utils.e0.b(fileA.getAbsolutePath());
                            LogUtil.d("CacheMediaPlayerHelper", "getFirstFramePicture :" + (videoThumb != null));
                        }
                        if (videoThumb == null && com.meishu.sdk.meishu_ad.view.player.c.a(fileA2) > 0 && com.meishu.sdk.meishu_ad.view.player.c.a(fileA3) == 0) {
                            videoThumb = com.meishu.sdk.core.utils.e0.b(fileA2.getAbsolutePath());
                            LogUtil.d("CacheMediaPlayerHelper", "getFirstFramePicture temp :" + (videoThumb != null));
                        }
                        if (videoThumb == null && com.meishu.sdk.meishu_ad.view.player.c.a(fileA2) > 0 && com.meishu.sdk.meishu_ad.view.player.c.a(fileA3) > 0) {
                            videoThumb = com.meishu.sdk.core.utils.e0.b(str);
                            LogUtil.d("CacheMediaPlayerHelper", "getFirstFramePicture temp2 :" + (videoThumb != null));
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                if (videoThumb == null && !TextUtils.isEmpty(a0.this.b.getVideo_cover())) {
                    a0.this.k.b(R.id.ms_splash_image_bg).a(a0.this.b.getVideo_cover(), true);
                    this.c.countDown();
                    return;
                }
            }
            if (videoThumb == null) {
                videoThumb = this.d.getVideoThumb();
            }
            a0 a0Var = a0.this;
            CountDownLatch countDownLatch = this.c;
            a0Var.getClass();
            if (videoThumb != null) {
                SdkHandler.getInstance().runOnUiThread(new b0(a0Var, videoThumb, countDownLatch));
            } else {
                countDownLatch.countDown();
            }
        }
    }

    public a0(v vVar, com.meishu.sdk.meishu_ad.splash.c cVar, com.meishu.sdk.meishu_ad.splash.d dVar, MeishuSplashRootView meishuSplashRootView, com.meishu.sdk.meishu_ad.splash.a aVar, View view, int i, int i2, boolean z, AtomicBoolean atomicBoolean, ImageView imageView, com.meishu.sdk.core.bquery.i iVar) {
        this.l = vVar;
        this.f4997a = cVar;
        this.b = dVar;
        this.c = meishuSplashRootView;
        this.d = aVar;
        this.e = view;
        this.f = i;
        this.g = i2;
        this.h = z;
        this.i = atomicBoolean;
        this.j = imageView;
        this.k = iVar;
    }

    @Override // com.meishu.sdk.core.bquery.h
    public void a(String str, Object obj, boolean z) {
        boolean z2 = obj instanceof MediaPlayer;
        if (!z2 && !(obj instanceof File)) {
            try {
                o1.b(this.f4997a.b.getEventUrl(), ErrorCodeUtil.RENDER_AD_RESULT, "加载失败");
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                o1.c(this.f4997a.b.getEventUrl(), ErrorCodeUtil.RENDER_AD_RESULT, "加载失败 cid:" + this.b.getCid());
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                return;
            }
        }
        File file = obj instanceof File ? (File) obj : null;
        if (file != null && file.length() >= com.meishu.sdk.core.utils.i0.a()) {
            try {
                o1.b(this.f4997a.b.getEventUrl(), ErrorCodeUtil.RENDER_AD_RESULT, "加载失败");
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
            try {
                o1.c(this.f4997a.b.getEventUrl(), ErrorCodeUtil.RENDER_AD_RESULT, "加载失败 cid:" + this.b.getCid());
            } catch (Throwable th4) {
                th4.printStackTrace();
            }
            this.l.u = 2;
            return;
        }
        try {
            o1.c(this.f4997a.b.getEventUrl(), 200, "加载成功");
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        if (this.l.k) {
            return;
        }
        this.l.p = System.currentTimeMillis();
        this.l.u = 1;
        SplashSkipView splashSkipViewA = this.l.a(this.f4997a, this.c, this.d, this.e, true);
        NormalMediaView normalMediaView = new NormalMediaView(this.l.f5096a, z2);
        if (z2) {
            if (!(normalMediaView.getMeishuVideoView() instanceof MeishuVideoCahceTextureView)) {
                LogUtil.e("AdNative", "update MediaPlayer error.");
                this.l.a(this.d, "splash video load error", ErrorCodeUtil.RES_LOAD_ERROR);
                return;
            } else {
                normalMediaView.setVideoPath(str);
                ((MeishuVideoCahceTextureView) normalMediaView.getMeishuVideoView()).setMediaPlayer((MediaPlayer) obj);
            }
        }
        k1.a(this.b, 1, z);
        normalMediaView.setConfigWidth(this.b.f5047a);
        normalMediaView.setConfigHeight(this.b.b);
        normalMediaView.setContainerWidth(this.f);
        normalMediaView.setContainerHeight(this.g);
        normalMediaView.setPlayOnce(true);
        normalMediaView.g();
        if (!this.h) {
            normalMediaView.j();
        }
        normalMediaView.setIsEyes(this.b.H);
        normalMediaView.setUseTransform(false);
        if (AdSdk.adConfig().showLogo()) {
            normalMediaView.setFromLogo(this.b.getFromLogo());
            normalMediaView.setFromLogoVisibility(0);
        } else {
            normalMediaView.setFromLogoVisibility(8);
            normalMediaView.setFromLogo(null);
        }
        normalMediaView.setAdListener(new a(this));
        RelativeLayout relativeLayout = (RelativeLayout) this.c.findViewById(R.id.ms_splash_video);
        relativeLayout.setVisibility(0);
        int scale_type = this.b.getScale_type();
        if (scale_type != -1 && scale_type == 9) {
            normalMediaView.setDisplayMode(2);
            relativeLayout.addView(normalMediaView, -1, -1);
        } else {
            normalMediaView.setDisplayMode(1);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(13, -1);
            relativeLayout.addView(normalMediaView, layoutParams);
        }
        this.f4997a.d = normalMediaView;
        long jMin = Math.min(normalMediaView.getDuration(), AdSdk.adConfig().getSplashShowTime());
        if (this.b.H != 1) {
            splashSkipViewA.setTotalTime((int) jMin);
        }
        Context context = this.l.f5096a;
        normalMediaView.setNativeAdMediaListener(new com.meishu.sdk.platform.ms.recycler.b(this.b, new b(normalMediaView)));
        if ((file != null && file.getAbsolutePath().endsWith("m3u8")) || str.contains("m3u8")) {
            normalMediaView.setVideoPath(str);
        } else if (file != null) {
            normalMediaView.setVideoPath(file.getAbsolutePath());
        }
        try {
            Gson gson = new Gson();
            HashMap map = new HashMap();
            map.put("stepNum", 3);
            map.put("msg", "video succ");
            map.put("creativeType", Integer.valueOf(this.b.getAdPatternType()));
            o1.a(this.f4997a.b.getErrorUrl(), gson.toJson(map));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.j.setVisibility(0);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ExecutorService executorService = com.meishu.sdk.core.utils.g0.f4905a;
        com.meishu.sdk.core.utils.g0.b.f4906a.a(new c(obj, str, countDownLatch, normalMediaView));
        if (z2) {
            try {
                countDownLatch.await(400L, TimeUnit.MILLISECONDS);
            } catch (Throwable th6) {
                th6.printStackTrace();
            }
        }
        v.a(this.l.A != 1, this.d, this.f4997a);
        this.l.h = true;
        v.a(this.b);
        v vVar = this.l;
        if (vVar.f != 1 || vVar.g) {
            normalMediaView.start();
            this.l.a(this.f4997a, this.d);
        }
    }

    @Override // com.meishu.sdk.core.bquery.h
    public void onFail(int i, String str) {
        this.l.u = 2;
        LogUtil.d("AdNative", "loadVideo onFail. errCode:" + i + ",errMsg:" + str);
        try {
            o1.b(this.f4997a.b.getEventUrl(), ErrorCodeUtil.RENDER_AD_RESULT, "video 加载失败");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            o1.c(this.f4997a.b.getEventUrl(), ErrorCodeUtil.RENDER_AD_RESULT, "video 加载失败 cid:" + this.b.getCid());
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        if (this.l.v == 2 && this.l.w == 2) {
            this.l.a(this.d, "video error", ErrorCodeUtil.RES_LOAD_ERROR);
        } else {
            if (this.l.k) {
                return;
            }
            v.a(this.l, this.f4997a, this.b, this.f, this.g, this.d, this.e);
        }
    }
}
