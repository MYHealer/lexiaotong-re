package com.meishu.sdk.meishu_ad.interstitial;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.meishu.sdk.R;
import com.meishu.sdk.activity.SdkInterstitialActivity;
import com.meishu.sdk.core.ad.AdType;
import com.meishu.sdk.core.ad.interstitial.InterstitialAdLoader;
import com.meishu.sdk.core.exception.ErrorCodeUtil;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.g0;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.u0;
import com.meishu.sdk.core.utils.z;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: NativeInterstitialAd.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c extends com.meishu.sdk.core.ad.a implements com.meishu.sdk.platform.ms.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.meishu.sdk.platform.ms.interstitial.b f5023a;
    public com.meishu.sdk.meishu_ad.interstitial.a b;
    public boolean c;
    public int d;
    public int e;
    public int f;
    public long g;
    public long h;
    public long i;

    /* JADX INFO: compiled from: NativeInterstitialAd.java */
    public class a implements z.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f5024a;

        public a(Activity activity) {
            this.f5024a = activity;
        }

        @Override // com.meishu.sdk.core.utils.z.i
        public void a() {
            LogUtil.d("NativeInterstitialAd", "videoLinkValid=false");
            c.this.h = System.currentTimeMillis();
            try {
                if (!TextUtils.isEmpty(c.this.a().getVideo_cover())) {
                    c.this.a().setAdPatternType(1);
                    c.this.a().getImageUrls()[0] = c.this.a().getVideo_cover();
                    h0.b(c.this.a().getMonitorUrl());
                    c cVar = c.this;
                    Activity activity = this.f5024a;
                    String video_cover = cVar.a().getVideo_cover();
                    cVar.getClass();
                    com.meishu.sdk.core.cache.a.a(video_cover, new e(cVar, activity), true);
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            com.meishu.sdk.meishu_ad.interstitial.a aVar = c.this.b;
            if (aVar != null) {
                ((com.meishu.sdk.platform.ms.interstitial.a) aVar).onAdRenderFail("插屏视频渲染失败", ErrorCodeUtil.RES_LOAD_ERROR.intValue());
            }
        }

        @Override // com.meishu.sdk.core.utils.z.i
        public void success() {
            LogUtil.d("NativeInterstitialAd", "videoLinkValid=true");
            c cVar = c.this;
            Activity activity = this.f5024a;
            cVar.getClass();
            ExecutorService executorService = g0.f4905a;
            g0.b.f4906a.a(new d(cVar, activity));
        }
    }

    public c(com.meishu.sdk.platform.ms.interstitial.b bVar, com.meishu.sdk.meishu_ad.interstitial.a aVar) {
        super(null, "MS");
        this.d = 1;
        this.f5023a = bVar;
        this.b = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(c cVar, Context context, int i) {
        cVar.getClass();
        LogUtil.d("NativeInterstitialAd", "actType=" + cVar.a().getAct_type());
        SdkInterstitialActivity.setSdkAd(cVar);
        SdkInterstitialActivity.setAdWrapper(cVar.f5023a);
        SdkInterstitialActivity.setMsAd(cVar);
        Intent intent = new Intent(context, (Class<?>) SdkInterstitialActivity.class);
        intent.putExtra("isVideoAutoPlay", ((InterstitialAdLoader) cVar.f5023a.getAdLoader()).getIsVideoAutoPlay());
        intent.putExtra("isClickToClose", ((InterstitialAdLoader) cVar.f5023a.getAdLoader()).getIsClickToClose());
        intent.putExtra("act_type", cVar.a().getAct_type());
        intent.putExtra("layout_type", cVar.d);
        intent.putExtra("layout_width", cVar.f);
        intent.putExtra("layout_height", cVar.e);
        context.startActivity(intent);
    }

    public void c() {
        com.meishu.sdk.platform.ms.interstitial.b bVar = this.f5023a;
        if (bVar == null || bVar.getLoaderListener() == 0 || this.c) {
            return;
        }
        this.c = true;
        u0.a(((b) this.f5023a.f5177a).getPosId(), 3);
        a().getMonitorUrl();
        String[] strArrB = h0.b(a().getMonitorUrl(), this.g + "." + this.h + "." + this.i);
        try {
            h0.a(strArrB, this.adView.findViewById(R.id.ms_activity_sdk_interstitial_mediaContainer), (View) null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (strArrB != null) {
            for (String str : strArrB) {
                if (!TextUtils.isEmpty(str)) {
                    int act_type = a().getAct_type();
                    if ((act_type & 2) == 2) {
                        act_type = (act_type - 2) | 1;
                    }
                    com.meishu.sdk.core.loader.a.a(this.f5023a.getContext(), h0.a(h0.a(str, act_type, AdType.INTERSTITIAL)));
                }
            }
        }
        try {
            this.f5023a.getConCurrentListener().onAdExposure();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (getInteractionListener() != null) {
            getInteractionListener().onAdExposure();
        }
    }

    @Override // com.meishu.sdk.platform.ms.c
    public AdType getAdType() {
        return AdType.INTERSTITIAL;
    }

    @Override // com.meishu.sdk.platform.ms.c
    public Context getContext() {
        if (getAdView() != null) {
            getAdView().getContext();
        }
        return this.f5023a.getContext();
    }

    @Override // com.meishu.sdk.platform.ms.c
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public b a() {
        return (b) this.f5023a.f5177a;
    }

    @Override // com.meishu.sdk.platform.ms.c
    public int getInteractionType() {
        return ((b) this.f5023a.f5177a).getInteractionType();
    }

    public final void a(Activity activity) {
        if (this.f5023a == null || activity == null) {
            return;
        }
        if (a().getAdPatternType() != 2) {
            com.meishu.sdk.core.cache.a.a(a().getImageUrls()[0], new e(this, activity), true);
        } else {
            this.g = System.currentTimeMillis();
            z.a(a().getImageUrls()[0], new a(activity));
        }
    }
}
