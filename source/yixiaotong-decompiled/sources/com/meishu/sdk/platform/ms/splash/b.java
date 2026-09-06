package com.meishu.sdk.platform.ms.splash;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.google.gson.Gson;
import com.meishu.sdk.R;
import com.meishu.sdk.core.ad.BaseAdSlot;
import com.meishu.sdk.core.exception.ErrorCodeUtil;
import com.meishu.sdk.core.loader.InteractionListener;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.safe.o;
import com.meishu.sdk.core.utils.ResultBean;
import com.meishu.sdk.core.utils.o1;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.core.view.gif.GifImageView;
import com.meishu.sdk.meishu_ad.nativ.NormalMediaView;
import com.meishu.sdk.meishu_ad.splash.MeishuSplashRootView;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: MeishuSplashAd.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b extends com.meishu.sdk.core.ad.splash.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.meishu.sdk.platform.ms.splash.a f5237a;
    public com.meishu.sdk.meishu_ad.splash.b b;
    public boolean c;

    /* JADX INFO: compiled from: MeishuSplashAd.java */
    public class a extends o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.c f5238a;

        public a(com.meishu.sdk.meishu_ad.splash.c cVar) {
            this.f5238a = cVar;
        }

        @Override // com.meishu.sdk.core.safe.o
        public void safeOnClick(View view) {
            b.a(b.this, this.f5238a, true);
        }
    }

    /* JADX INFO: renamed from: com.meishu.sdk.platform.ms.splash.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MeishuSplashAd.java */
    public class C0854b extends o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.c f5239a;

        public C0854b(com.meishu.sdk.meishu_ad.splash.c cVar) {
            this.f5239a = cVar;
        }

        @Override // com.meishu.sdk.core.safe.o
        public void safeOnClick(View view) {
            b.a(b.this, this.f5239a, true);
            if (this.f5239a.getInteractionListener() != null && this.f5239a.b.getCbc() == 0) {
                this.f5239a.getInteractionListener().onAdClicked();
            }
            this.f5239a.b.setClkActType(1);
            com.meishu.sdk.core.utils.f.a((com.meishu.sdk.platform.ms.c) this.f5239a, false);
        }
    }

    /* JADX INFO: compiled from: MeishuSplashAd.java */
    public class c extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.c f5240a;

        public c(com.meishu.sdk.meishu_ad.splash.c cVar) {
            this.f5240a = cVar;
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            b.a(b.this, this.f5240a, false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(com.meishu.sdk.meishu_ad.splash.b bVar, com.meishu.sdk.platform.ms.splash.a aVar, g gVar, boolean z) {
        super(null, "MS");
        this.b = bVar;
        this.f5237a = aVar;
        if (bVar instanceof com.meishu.sdk.core.ad.splash.c) {
            com.meishu.sdk.core.ad.splash.c cVar = (com.meishu.sdk.core.ad.splash.c) bVar;
            setWidth(cVar.getWidth());
            setHeight(cVar.getHeight());
        }
    }

    public static void a(b bVar, com.meishu.sdk.meishu_ad.splash.c cVar, boolean z) {
        bVar.getClass();
        try {
            if (cVar.b.getAdPatternType() != 1 && cVar.b.getAdPatternType() != 12) {
                if (cVar.b.getAdPatternType() == 2) {
                    if (cVar.g || z) {
                        NormalMediaView normalMediaView = cVar.d;
                        if (normalMediaView != null) {
                            normalMediaView.d();
                        }
                        bVar.b();
                        return;
                    }
                    return;
                }
                return;
            }
            bVar.b();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void b() {
        try {
            View view = this.adView;
            if (view != null) {
                try {
                    if (view instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view;
                        for (int i = 0; i < viewGroup.getChildCount(); i++) {
                            View childAt = viewGroup.getChildAt(i);
                            if (childAt instanceof MeishuSplashRootView) {
                                for (int i2 = 0; i2 < ((MeishuSplashRootView) childAt).getChildCount(); i2++) {
                                    View childAt2 = ((MeishuSplashRootView) childAt).getChildAt(i);
                                    if (childAt2 instanceof GifImageView) {
                                        ((GifImageView) childAt2).clear();
                                        break;
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ViewParent parent = this.adView.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.adView);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.ad.IAd
    public ResultBean getData() {
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setCid(((com.meishu.sdk.meishu_ad.splash.d) this.f5237a.f5177a).getCid());
            resultBean.setCat(((com.meishu.sdk.meishu_ad.splash.d) this.f5237a.f5177a).getCat());
            resultBean.setAderId(((com.meishu.sdk.meishu_ad.splash.d) this.f5237a.f5177a).getAder_id());
            resultBean.setFromId(((com.meishu.sdk.meishu_ad.splash.d) this.f5237a.f5177a).getFromId());
            resultBean.setDrawing(((com.meishu.sdk.meishu_ad.splash.d) this.f5237a.f5177a).getDrawing());
            resultBean.setPid(((com.meishu.sdk.meishu_ad.splash.d) this.f5237a.f5177a).getPosId());
            resultBean.setInteractionType(((com.meishu.sdk.meishu_ad.splash.d) this.f5237a.f5177a).getInteractionType());
            resultBean.setReqId(((com.meishu.sdk.meishu_ad.splash.d) this.f5237a.f5177a).getReq_id());
            resultBean.setPrice(((com.meishu.sdk.meishu_ad.splash.d) this.f5237a.f5177a).getEcpm());
            resultBean.setEcpm(((com.meishu.sdk.meishu_ad.splash.d) this.f5237a.f5177a).getEcpm() + "");
            resultBean.setS_ext(((com.meishu.sdk.meishu_ad.splash.d) this.f5237a.f5177a).getS_ext());
            resultBean.setS_code(((com.meishu.sdk.meishu_ad.splash.d) this.f5237a.f5177a).getS_code());
            resultBean.setAdInfo(com.meishu.sdk.core.utils.a.a((BaseAdSlot) this.f5237a.f5177a));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        resultBean.setSdkName("MS");
        return resultBean;
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.s2s.ISBidding
    public void sendLossNotification(Map map) {
        z.a(this.f5237a.getContext(), ((com.meishu.sdk.meishu_ad.splash.d) this.b.a()).getLossUrl(), (Map<String, Object>) map);
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.s2s.ISBidding
    public void sendWinNotification(Map map) {
        z.b(this.f5237a.getContext(), ((com.meishu.sdk.meishu_ad.splash.d) this.b.a()).getWinUrl(), map);
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.ad.IAd
    public void setInteractionListener(InteractionListener interactionListener) {
        super.setInteractionListener(interactionListener);
        this.b.setInteractionListener(interactionListener);
    }

    @Override // com.meishu.sdk.core.ad.splash.c, com.meishu.sdk.core.ad.splash.ISplashAd
    public void setSplashFinishingTouchListener(com.meishu.sdk.core.ad.splash.b bVar) {
        super.setSplashFinishingTouchListener(bVar);
        View view = this.adView;
        if (view != null) {
            try {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int i = 0; i < viewGroup.getChildCount(); i++) {
                        View childAt = viewGroup.getChildAt(i);
                        if (childAt instanceof MeishuSplashRootView) {
                            for (int i2 = 0; i2 < ((MeishuSplashRootView) childAt).getChildCount(); i2++) {
                                View childAt2 = ((MeishuSplashRootView) childAt).getChildAt(i);
                                if (childAt2 instanceof GifImageView) {
                                    ((GifImageView) childAt2).setCanClear(false);
                                    break;
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.meishu.sdk.core.ad.splash.c, com.meishu.sdk.core.ad.splash.ISplashAd
    public void showAd(ViewGroup viewGroup) {
        try {
            try {
                if (viewGroup == null) {
                    try {
                        o1.b(((BaseAdSlot) this.b.a()).getEventUrl(), ErrorCodeUtil.RENDER_AD_INTERRUPTED, "adContainer 为空");
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
                try {
                    Gson gson = new Gson();
                    HashMap map = new HashMap();
                    map.put("stepNum", 1);
                    map.put("msg", "showAd invoke");
                    if (this.b.a() instanceof com.meishu.sdk.meishu_ad.splash.d) {
                        map.put("creativeType", Integer.valueOf(((com.meishu.sdk.meishu_ad.splash.d) this.b.a()).getAdPatternType()));
                    }
                    o1.a(((BaseAdSlot) this.b.a()).getEventUrl(), gson.toJson(map));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (this.c) {
                    try {
                        o1.b(((BaseAdSlot) this.b.a()).getEventUrl(), ErrorCodeUtil.RENDER_AD_INTERRUPTED, "重复调用showAd");
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
                com.meishu.sdk.meishu_ad.splash.b bVar = this.b;
                if (!(bVar instanceof com.meishu.sdk.meishu_ad.splash.c)) {
                    try {
                        o1.b(((BaseAdSlot) bVar.a()).getEventUrl(), ErrorCodeUtil.RENDER_AD_INTERRUPTED, "nativeAd 不是SplashAdImpl实例");
                        return;
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        return;
                    }
                }
                viewGroup.removeAllViews();
                ((com.meishu.sdk.meishu_ad.splash.c) this.b).showAd(viewGroup);
                o1.b(((com.meishu.sdk.meishu_ad.splash.c) this.b).b.getEventUrl());
                o1.a(viewGroup, ((com.meishu.sdk.meishu_ad.splash.c) this.b).b.getPosId(), ((com.meishu.sdk.meishu_ad.splash.c) this.b).b.getLoadedTime());
                this.c = true;
                return;
            } catch (Throwable th) {
                o1.b(((BaseAdSlot) this.b.a()).getEventUrl(), ErrorCodeUtil.RENDER_AD_EXCEPTION, th.getMessage());
                th.printStackTrace();
            }
            o1.b(((BaseAdSlot) this.b.a()).getEventUrl(), ErrorCodeUtil.RENDER_AD_EXCEPTION, th.getMessage());
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        th.printStackTrace();
    }

    @Override // com.meishu.sdk.core.ad.splash.c, com.meishu.sdk.core.ad.splash.ISplashAd
    public void splashAnimationFinish() {
        try {
            com.meishu.sdk.meishu_ad.splash.b bVar = this.b;
            if (bVar == null || !(bVar instanceof com.meishu.sdk.meishu_ad.splash.c)) {
                return;
            }
            com.meishu.sdk.meishu_ad.splash.c cVar = (com.meishu.sdk.meishu_ad.splash.c) bVar;
            cVar.h = true;
            MeishuSplashRootView meishuSplashRootView = cVar.e;
            ImageView imageView = (ImageView) meishuSplashRootView.findViewById(R.id.ms_click_eye_close);
            meishuSplashRootView.findViewById(R.id.ms_skipView).setVisibility(8);
            imageView.setVisibility(0);
            imageView.setOnClickListener(new a(cVar));
            meishuSplashRootView.setOnClickListener(new C0854b(cVar));
            new Handler(Looper.getMainLooper()).postDelayed(new c(cVar), 5000L);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.ad.IAd
    public boolean isAdValid() {
        try {
            int expire_timestamp = ((com.meishu.sdk.meishu_ad.splash.d) this.f5237a.f5177a).getExpire_timestamp();
            return SystemClock.uptimeMillis() - ((com.meishu.sdk.meishu_ad.splash.d) this.f5237a.f5177a).getLoadedTime() < (expire_timestamp <= 0 ? 1740000L : (long) (expire_timestamp * 1000));
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }
}
