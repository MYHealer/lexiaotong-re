package com.meishu.sdk.platform.ms.draw;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.meishu.sdk.R;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.ad.AdSlot;
import com.meishu.sdk.core.ad.AdType;
import com.meishu.sdk.core.ad.BaseAdSlot;
import com.meishu.sdk.core.ad.draw.DrawAdLoader;
import com.meishu.sdk.core.ad.draw.IDrawAd;
import com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener;
import com.meishu.sdk.core.bquery.i;
import com.meishu.sdk.core.domain.HttpResponse;
import com.meishu.sdk.core.exception.ErrorCodeUtil;
import com.meishu.sdk.core.loader.AdPlatformError;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.safe.o;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.o1;
import com.meishu.sdk.core.utils.u0;
import com.meishu.sdk.core.utils.x;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.core.view.TouchAdContainer;
import com.meishu.sdk.core.view.TouchPositionListener;
import com.meishu.sdk.core.view.gif.GifImageView;
import com.meishu.sdk.meishu_ad.draw.MeishuDrawRootView;
import com.meishu.sdk.meishu_ad.v;
import java.io.IOException;
import java.math.BigInteger;

/* JADX INFO: compiled from: MeishuDrawAdWrapper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class g extends com.meishu.sdk.platform.ms.g<com.meishu.sdk.meishu_ad.nativ.f, DrawAdLoader, com.meishu.sdk.core.ad.draw.a> {
    public v b;
    public boolean c;
    public boolean d;
    public com.meishu.sdk.platform.ms.draw.a e;
    public long f;
    public long g;
    public RecyclerAdMediaListener h;

    /* JADX INFO: compiled from: MeishuDrawAdWrapper.java */
    public class a implements com.meishu.sdk.core.ad.draw.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MeishuDrawRootView f5170a;

        /* JADX INFO: renamed from: com.meishu.sdk.platform.ms.draw.g$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: MeishuDrawAdWrapper.java */
        public class C0848a extends l {
            public C0848a() {
            }

            @Override // com.meishu.sdk.core.safe.l
            public void safeRun() {
                u0.a(((com.meishu.sdk.meishu_ad.nativ.f) g.this.f5177a).getPosId(), 3);
                String[] strArrB = h0.b(((com.meishu.sdk.meishu_ad.nativ.f) g.this.f5177a).getMonitorUrl(), g.this.b());
                h0.a(strArrB, g.this.e.getAdView(), (View) null);
                if (strArrB != null) {
                    LogUtil.d("MeishuDrawAdWrapper", "send onAdExposure");
                    for (String str : strArrB) {
                        if (!TextUtils.isEmpty(str)) {
                            com.meishu.sdk.core.loader.a.a(g.this.getContext(), h0.a(h0.a(str, ((com.meishu.sdk.meishu_ad.nativ.f) g.this.f5177a).getAct_type(), AdType.DRAW)));
                        }
                    }
                }
                com.meishu.sdk.platform.ms.draw.a aVar = g.this.e;
                if (aVar != null && aVar.getInteractionListener() != null) {
                    g.this.e.getInteractionListener().onAdExposure();
                }
                if (g.this.getLoaderListener() != 0) {
                    ((com.meishu.sdk.core.ad.draw.a) g.this.getLoaderListener()).onAdExposure();
                }
                g.this.c = true;
            }
        }

        public a(MeishuDrawRootView meishuDrawRootView) {
            this.f5170a = meishuDrawRootView;
        }

        @Override // com.meishu.sdk.core.loader.IAdLoadListener
        public void onAdClosed() {
        }

        @Override // com.meishu.sdk.core.loader.IAdLoadListener
        public /* bridge */ /* synthetic */ void onAdLoaded(IDrawAd iDrawAd) {
        }

        @Override // com.meishu.sdk.core.loader.IAdLoadListener
        public void onAdPlatformError(AdPlatformError adPlatformError) {
        }

        @Override // com.meishu.sdk.core.loader.IAdLoadListener
        public /* bridge */ /* synthetic */ void onAdReady(IDrawAd iDrawAd) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.meishu.sdk.core.loader.IAdLoadListener
        public void onAdError() {
            if (((com.meishu.sdk.meishu_ad.nativ.f) g.this.f5177a).getErrorUrl() != null) {
                z.a(((com.meishu.sdk.meishu_ad.nativ.f) g.this.f5177a).getErrorUrl()[0], (Integer) (-1), "图片加载失败");
            }
            new com.meishu.sdk.platform.ms.d("图片加载失败", -1).post(((DrawAdLoader) g.this.getAdLoader()).getLoaderListener());
        }

        @Override // com.meishu.sdk.core.loader.IAdLoadListener
        public void onAdExposure() {
            MeishuDrawRootView meishuDrawRootView;
            if (g.this.c || (meishuDrawRootView = this.f5170a) == null) {
                return;
            }
            meishuDrawRootView.post(new C0848a());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.meishu.sdk.core.loader.IAdLoadListener
        public void onAdRenderFail(String str, int i) {
            if (((com.meishu.sdk.meishu_ad.nativ.f) g.this.f5177a).getErrorUrl() != null) {
                z.a(((com.meishu.sdk.meishu_ad.nativ.f) g.this.f5177a).getErrorUrl()[0], Integer.valueOf(i), str);
            }
            new com.meishu.sdk.platform.ms.d(str, Integer.valueOf(i)).post(((DrawAdLoader) g.this.getAdLoader()).getLoaderListener());
        }
    }

    /* JADX INFO: compiled from: MeishuDrawAdWrapper.java */
    public class b extends o {
        public b() {
        }

        @Override // com.meishu.sdk.core.safe.o
        public void safeOnClick(View view) {
            if (g.this.e.getInteractionListener() != null) {
                g.this.e.getInteractionListener().onAdClosed();
            }
        }
    }

    /* JADX INFO: compiled from: MeishuDrawAdWrapper.java */
    public class c implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GifImageView f5173a;
        public final /* synthetic */ MeishuDrawRootView b;

        public c(GifImageView gifImageView, MeishuDrawRootView meishuDrawRootView) {
            this.f5173a = gifImageView;
            this.b = meishuDrawRootView;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.meishu.sdk.core.utils.x
        public void onFailure(IOException iOException) {
            new com.meishu.sdk.platform.ms.d("图片资源加载错误", ErrorCodeUtil.RES_LOAD_ERROR).post(((DrawAdLoader) g.this.getAdLoader()).getLoaderListener());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.meishu.sdk.core.utils.x
        public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
            try {
                if (!httpResponse.isSuccessful()) {
                    if (((com.meishu.sdk.meishu_ad.nativ.f) g.this.f5177a).getErrorUrl() != null) {
                        o1.b(((com.meishu.sdk.meishu_ad.nativ.f) g.this.f5177a).getEventUrl(), ErrorCodeUtil.RES_LOAD_ERROR.intValue(), "图片资源加载错误");
                    }
                    new com.meishu.sdk.platform.ms.d("图片资源加载错误", ErrorCodeUtil.RES_LOAD_ERROR).post(((DrawAdLoader) g.this.getAdLoader()).getLoaderListener());
                    return;
                }
                byte[] responseBody = httpResponse.getResponseBody();
                if (responseBody == null || responseBody.length <= 0) {
                    if (((com.meishu.sdk.meishu_ad.nativ.f) g.this.f5177a).getErrorUrl() != null) {
                        o1.b(((com.meishu.sdk.meishu_ad.nativ.f) g.this.f5177a).getEventUrl(), ErrorCodeUtil.RES_LOAD_ERROR.intValue(), "图片资源加载错误");
                    }
                    new com.meishu.sdk.platform.ms.d("图片资源加载错误", ErrorCodeUtil.RES_LOAD_ERROR).post(((DrawAdLoader) g.this.getAdLoader()).getLoaderListener());
                    return;
                }
                g.this.getClass();
                byte[] bArr = new byte[4];
                System.arraycopy(responseBody, 0, bArr, 0, 4);
                if (new BigInteger(1, bArr).toString(16).startsWith(com.huawei.openalliance.ad.constant.x.aw)) {
                    GifImageView gifImageView = this.f5173a;
                    if (gifImageView != null) {
                        gifImageView.setBytes(responseBody);
                        this.f5173a.startAnimation();
                    }
                } else {
                    Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                    if (bitmapDecodeByteArray == null) {
                        if (((com.meishu.sdk.meishu_ad.nativ.f) g.this.f5177a).getErrorUrl() != null) {
                            o1.b(((com.meishu.sdk.meishu_ad.nativ.f) g.this.f5177a).getEventUrl(), ErrorCodeUtil.RES_LOAD_ERROR.intValue(), "图片资源加载错误");
                        }
                        new com.meishu.sdk.platform.ms.d("图片资源加载错误", ErrorCodeUtil.RES_LOAD_ERROR).post(((DrawAdLoader) g.this.getAdLoader()).getLoaderListener());
                        return;
                    }
                    this.f5173a.setImageBitmap(bitmapDecodeByteArray);
                }
                g.this.g = System.currentTimeMillis();
                if (g.this.getLoaderListener() != 0) {
                    TouchAdContainer touchAdContainer = new TouchAdContainer(g.this.context);
                    touchAdContainer.setTouchPositionListener(new TouchPositionListener(g.this.e));
                    touchAdContainer.addView(this.b);
                    g.this.e.setAdView(touchAdContainer);
                    ((com.meishu.sdk.core.ad.draw.a) g.this.getLoaderListener()).onAdLoaded(g.this.e);
                    ((com.meishu.sdk.core.ad.draw.a) g.this.getLoaderListener()).onAdReady(g.this.e);
                }
            } catch (Throwable th) {
                if (((com.meishu.sdk.meishu_ad.nativ.f) g.this.f5177a).getErrorUrl() != null) {
                    o1.b(((com.meishu.sdk.meishu_ad.nativ.f) g.this.f5177a).getEventUrl(), ErrorCodeUtil.RES_LOAD_ERROR.intValue(), "图片资源加载错误");
                }
                new com.meishu.sdk.platform.ms.d("图片资源加载错误", ErrorCodeUtil.RES_LOAD_ERROR).post(((DrawAdLoader) g.this.getAdLoader()).getLoaderListener());
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: MeishuDrawAdWrapper.java */
    public class d extends o {
        public d() {
        }

        @Override // com.meishu.sdk.core.safe.o
        public void safeOnClick(View view) {
            g gVar = g.this;
            if (gVar.c) {
                T t = gVar.f5177a;
                if (t != 0 && ((com.meishu.sdk.meishu_ad.nativ.f) t).getCbc() == 0 && g.this.e.getInteractionListener() != null) {
                    g.this.e.getInteractionListener().onAdClicked();
                }
                AdSlot adSlot = g.this.e.f5163a;
                if (adSlot instanceof BaseAdSlot) {
                    ((BaseAdSlot) adSlot).setClkActType(2);
                }
                com.meishu.sdk.core.utils.f.a((com.meishu.sdk.platform.ms.c) g.this.e, true);
            }
        }
    }

    /* JADX INFO: compiled from: MeishuDrawAdWrapper.java */
    public class e extends o {
        public e() {
        }

        @Override // com.meishu.sdk.core.safe.o
        public void safeOnClick(View view) {
            g gVar = g.this;
            if (gVar.c) {
                T t = gVar.f5177a;
                if (t != 0 && ((com.meishu.sdk.meishu_ad.nativ.f) t).getCbc() == 0 && g.this.e.getInteractionListener() != null) {
                    g.this.e.getInteractionListener().onAdClicked();
                }
                AdSlot adSlot = g.this.e.f5163a;
                if (adSlot instanceof BaseAdSlot) {
                    ((BaseAdSlot) adSlot).setClkActType(1);
                }
                com.meishu.sdk.core.utils.f.a((com.meishu.sdk.platform.ms.c) g.this.e, true);
            }
        }
    }

    /* JADX INFO: compiled from: MeishuDrawAdWrapper.java */
    public class f implements RecyclerAdMediaListener {
        public f() {
        }

        @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
        public void onProgressUpdate(long j, long j2) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
        public void onVideoError() {
            if (((DrawAdLoader) g.this.getAdLoader()).getLoaderListener() != null) {
                ((DrawAdLoader) g.this.getAdLoader()).getLoaderListener().onAdRenderFail("视频加载失败", -1);
            }
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

        @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
        public void onVideoCompleted() {
            com.meishu.sdk.platform.ms.draw.a aVar = g.this.e;
            if (aVar == null || aVar.getInteractionListener() == null) {
                return;
            }
            g.this.e.getDrawVideoListener().playCompletion();
        }

        @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
        public void onVideoLoaded() {
            g gVar = g.this;
            if (gVar.d) {
                return;
            }
            gVar.d = true;
        }
    }

    public g(DrawAdLoader drawAdLoader, com.meishu.sdk.meishu_ad.nativ.f fVar) {
        super(drawAdLoader, fVar);
        this.c = false;
        this.d = false;
        this.h = new f();
        this.b = new v(drawAdLoader.getContext());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c() {
        MeishuDrawRootView meishuDrawRootView = (MeishuDrawRootView) LayoutInflater.from(this.context).inflate(R.layout.ms_draw_ad_layout, (ViewGroup) null).findViewById(R.id.ms_draw_rootView);
        meishuDrawRootView.setAdListener(new a(meishuDrawRootView));
        i iVar = new i(meishuDrawRootView);
        this.e = new com.meishu.sdk.platform.ms.draw.a(this.f5177a, null);
        GifImageView gifImageView = (GifImageView) meishuDrawRootView.findViewById(R.id.ms_draw_ad_image);
        TextView textView = (TextView) meishuDrawRootView.findViewById(R.id.draw_ad_detail_title);
        TextView textView2 = (TextView) meishuDrawRootView.findViewById(R.id.ms_draw_ad_detail_desc);
        ImageView imageView = (ImageView) meishuDrawRootView.findViewById(R.id.ms_draw_close_button);
        textView.setText(((com.meishu.sdk.meishu_ad.nativ.f) this.f5177a).title);
        textView2.setText(((com.meishu.sdk.meishu_ad.nativ.f) this.f5177a).c);
        imageView.setOnClickListener(new b());
        if (((com.meishu.sdk.meishu_ad.nativ.f) this.f5177a).getImageUrls() == null || ((com.meishu.sdk.meishu_ad.nativ.f) this.f5177a).getImageUrls().length == 0) {
            LogUtil.i("MeishuDrawAdWrapper", "empty srcUrls");
            new com.meishu.sdk.platform.ms.d("empty srcUrls", ErrorCodeUtil.EMPTY_SRC_URL).post(((DrawAdLoader) getAdLoader()).getLoaderListener());
            return;
        }
        if (((com.meishu.sdk.meishu_ad.nativ.f) this.f5177a).getAdPatternType() != 1 && ((com.meishu.sdk.meishu_ad.nativ.f) this.f5177a).getAdPatternType() != 12) {
            LogUtil.i("MeishuDrawAdWrapper", com.meishu.sdk.activity.a.a("unsupported type: ").append(((com.meishu.sdk.meishu_ad.nativ.f) this.f5177a).getAdPatternType()).toString());
            if (((com.meishu.sdk.meishu_ad.nativ.f) this.f5177a).getErrorUrl() != null) {
                o1.b(((com.meishu.sdk.meishu_ad.nativ.f) this.f5177a).getEventUrl(), ErrorCodeUtil.RES_LOAD_ERROR.intValue(), "图片资源加载错误");
            }
            new com.meishu.sdk.platform.ms.d("unsupported type", ErrorCodeUtil.UNSUPPORTED_TYPE).post(((DrawAdLoader) getAdLoader()).getLoaderListener());
            return;
        }
        if (!AdSdk.adConfig().showLogo()) {
            iVar.b(R.id.ms_img_meishu_ad_tag).d(8);
        } else if (!TextUtils.isEmpty(((com.meishu.sdk.meishu_ad.nativ.f) this.f5177a).getFromLogo())) {
            iVar.b(R.id.ms_img_meishu_ad_tag).a(((com.meishu.sdk.meishu_ad.nativ.f) this.f5177a).getFromLogo(), false);
        }
        com.meishu.sdk.core.cache.a.a(((com.meishu.sdk.meishu_ad.nativ.f) this.f5177a).getImageUrls()[0], new c(gifImageView, meishuDrawRootView), true);
        TextView textView3 = (TextView) meishuDrawRootView.findViewById(R.id.ms_draw_ad_detail_btn);
        boolean z = (((com.meishu.sdk.meishu_ad.nativ.f) this.f5177a).getAct_type() & 1) == 1;
        if (!z && (((com.meishu.sdk.meishu_ad.nativ.f) this.f5177a).getAct_type() & 2) == 2) {
            textView3.setOnClickListener(new d());
        }
        if (z) {
            meishuDrawRootView.setOnClickListener(new e());
        }
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f = jCurrentTimeMillis;
            T t = this.f5177a;
            ((com.meishu.sdk.meishu_ad.nativ.f) t).C = jCurrentTimeMillis;
            int act_type = ((com.meishu.sdk.meishu_ad.nativ.f) t).getAct_type();
            if ((act_type & 1) != 1 && (act_type & 2) != 2) {
                ((com.meishu.sdk.meishu_ad.nativ.f) this.f5177a).setAct_type(act_type | 1);
            }
            if (((com.meishu.sdk.meishu_ad.nativ.f) this.f5177a).getAdPatternType() == 2) {
                z.a(((com.meishu.sdk.meishu_ad.nativ.f) this.f5177a).getImageUrls()[0], new com.meishu.sdk.platform.ms.draw.f(this));
            } else {
                c();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String b() {
        return this.f + ".0." + this.g;
    }
}
