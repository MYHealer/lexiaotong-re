package com.meishu.sdk.platform.ms.draw;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.meishu.sdk.R;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.ad.AdType;
import com.meishu.sdk.core.ad.BaseAdSlot;
import com.meishu.sdk.core.ad.draw.DrawAdLoader;
import com.meishu.sdk.core.bquery.i;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.m;
import com.meishu.sdk.core.utils.u0;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.core.view.DownloadView;
import com.meishu.sdk.core.view.TouchAdContainer;
import com.meishu.sdk.core.view.TouchPositionListener;
import com.meishu.sdk.meishu_ad.draw.MeishuDrawRootView;
import com.meishu.sdk.meishu_ad.nativ.NormalMediaView;
import java.util.List;

/* JADX INFO: compiled from: MeishuDrawAdWrapper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class f implements z.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f5168a;

    /* JADX INFO: compiled from: MeishuDrawAdWrapper.java */
    public class a implements com.meishu.sdk.meishu_ad.nativ.a {
        public a() {
        }

        @Override // com.meishu.sdk.meishu_ad.m0
        public void onADExposure() {
            g gVar = f.this.f5168a;
            if (gVar.c) {
                return;
            }
            u0.a(((com.meishu.sdk.meishu_ad.nativ.f) gVar.f5177a).getPosId(), 3);
            String[] strArrB = h0.b(((com.meishu.sdk.meishu_ad.nativ.f) f.this.f5168a.f5177a).getMonitorUrl(), f.this.f5168a.b());
            h0.a(strArrB, f.this.f5168a.e.getAdView(), (View) null);
            if (strArrB != null) {
                LogUtil.d("MeishuDrawAdWrapper", "send onADExposure");
                for (String str : strArrB) {
                    if (!TextUtils.isEmpty(str)) {
                        com.meishu.sdk.core.loader.a.a(f.this.f5168a.getContext(), h0.a(h0.a(str, ((com.meishu.sdk.meishu_ad.nativ.f) f.this.f5168a.f5177a).getAct_type(), AdType.DRAW)));
                    }
                }
            }
            com.meishu.sdk.platform.ms.draw.a aVar = f.this.f5168a.e;
            if (aVar != null && aVar.getInteractionListener() != null) {
                f.this.f5168a.e.getInteractionListener().onAdExposure();
            }
            if (f.this.f5168a.getLoaderListener() != 0) {
                ((com.meishu.sdk.core.ad.draw.a) f.this.f5168a.getLoaderListener()).onAdExposure();
            }
            f.this.f5168a.c = true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.meishu.sdk.meishu_ad.m0
        public void onADLoaded(List<com.meishu.sdk.meishu_ad.nativ.b> list) {
            List<com.meishu.sdk.meishu_ad.nativ.b> list2 = list;
            if ((list2 == null || list2.isEmpty()) && ((DrawAdLoader) f.this.f5168a.getAdLoader()).getLoaderListener() != null) {
                ((DrawAdLoader) f.this.f5168a.getAdLoader()).getLoaderListener().onAdError();
            }
            com.meishu.sdk.meishu_ad.nativ.b bVar = list2.get(0);
            if (!(bVar.getMediaView() instanceof NormalMediaView) && ((DrawAdLoader) f.this.f5168a.getAdLoader()).getLoaderListener() != null) {
                ((DrawAdLoader) f.this.f5168a.getAdLoader()).getLoaderListener().onAdError();
            }
            f.this.f5168a.g = System.currentTimeMillis();
            View adView = bVar.getAdView();
            MeishuDrawRootView meishuDrawRootView = (MeishuDrawRootView) LayoutInflater.from(f.this.f5168a.context).inflate(R.layout.ms_draw_ad_layout, (ViewGroup) null).findViewById(R.id.ms_draw_rootView);
            new DownloadView().handleDownloadView(meishuDrawRootView, (BaseAdSlot) f.this.f5168a.f5177a);
            FrameLayout frameLayout = (FrameLayout) meishuDrawRootView.findViewById(R.id.ms_draw_ad_video);
            i iVar = new i(meishuDrawRootView);
            TextView textView = (TextView) meishuDrawRootView.findViewById(R.id.draw_ad_detail_title);
            TextView textView2 = (TextView) meishuDrawRootView.findViewById(R.id.ms_draw_ad_detail_desc);
            TextView textView3 = (TextView) meishuDrawRootView.findViewById(R.id.ms_draw_ad_detail_btn);
            ImageView imageView = (ImageView) meishuDrawRootView.findViewById(R.id.ms_draw_close_button);
            if (!TextUtils.isEmpty(((com.meishu.sdk.meishu_ad.nativ.f) f.this.f5168a.f5177a).getVideo_cover())) {
                iVar.b(R.id.ms_draw_ad_detail_logo).a(((com.meishu.sdk.meishu_ad.nativ.f) f.this.f5168a.f5177a).iconUrl, false);
            }
            if (AdSdk.adConfig() != null && !AdSdk.adConfig().showLogo()) {
                iVar.b(R.id.ms_img_meishu_ad_tag).d(8);
            } else if (!TextUtils.isEmpty(((com.meishu.sdk.meishu_ad.nativ.f) f.this.f5168a.f5177a).getFromLogo())) {
                iVar.b(R.id.ms_img_meishu_ad_tag).a(((com.meishu.sdk.meishu_ad.nativ.f) f.this.f5168a.f5177a).getFromLogo(), false);
            }
            textView.setText(((com.meishu.sdk.meishu_ad.nativ.f) f.this.f5168a.f5177a).title);
            textView2.setText(((com.meishu.sdk.meishu_ad.nativ.f) f.this.f5168a.f5177a).c);
            g gVar = f.this.f5168a;
            gVar.e = new com.meishu.sdk.platform.ms.draw.a(gVar.f5177a, adView);
            TouchAdContainer touchAdContainer = new TouchAdContainer(f.this.f5168a.context);
            touchAdContainer.setTouchPositionListener(new TouchPositionListener(bVar));
            touchAdContainer.addView(meishuDrawRootView);
            if (adView != null) {
                f.this.f5168a.getContext();
                g gVar2 = f.this.f5168a;
                bVar.a(frameLayout, null, new com.meishu.sdk.platform.ms.recycler.b((com.meishu.sdk.meishu_ad.nativ.f) gVar2.f5177a, gVar2.h));
                if (adView instanceof NormalMediaView) {
                    f.this.f5168a.getContext().getResources().getDisplayMetrics();
                    ((NormalMediaView) adView).setRecycler(true);
                }
                meishuDrawRootView.setOnVisibilityChangeListener(new b(this, adView));
                f.this.f5168a.e.setAdView(touchAdContainer);
                imageView.setOnClickListener(new c(this));
                boolean z = (((com.meishu.sdk.meishu_ad.nativ.f) f.this.f5168a.f5177a).getAct_type() & 1) == 1;
                if (!z && (((com.meishu.sdk.meishu_ad.nativ.f) f.this.f5168a.f5177a).getAct_type() & 2) == 2) {
                    textView3.setOnClickListener(new d(this, bVar));
                }
                if (z) {
                    meishuDrawRootView.setOnClickListener(new e(this, bVar));
                }
            }
            if (f.this.f5168a.getLoaderListener() != 0) {
                ((com.meishu.sdk.core.ad.draw.a) f.this.f5168a.getLoaderListener()).onAdLoaded(f.this.f5168a.e);
                ((com.meishu.sdk.core.ad.draw.a) f.this.f5168a.getLoaderListener()).onAdReady(f.this.f5168a.e);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.meishu.sdk.meishu_ad.m0
        public void onAdRenderFail(String str, int i) {
            if (((com.meishu.sdk.meishu_ad.nativ.f) f.this.f5168a.f5177a).getErrorUrl() != null) {
                z.a(((com.meishu.sdk.meishu_ad.nativ.f) f.this.f5168a.f5177a).getErrorUrl()[0], Integer.valueOf(i), str);
            }
            new com.meishu.sdk.platform.ms.d(str, Integer.valueOf(i)).post(((DrawAdLoader) f.this.f5168a.getAdLoader()).getLoaderListener());
        }
    }

    public f(g gVar) {
        this.f5168a = gVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.meishu.sdk.core.utils.z.i
    public void a() {
        if (((com.meishu.sdk.meishu_ad.nativ.f) this.f5168a.f5177a).getErrorUrl() != null) {
            z.a(((com.meishu.sdk.meishu_ad.nativ.f) this.f5168a.f5177a).getErrorUrl()[0], (Integer) (-1), "图片加载失败");
        }
        new com.meishu.sdk.platform.ms.d("图片加载失败", -1).post(((DrawAdLoader) this.f5168a.getAdLoader()).getLoaderListener());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.meishu.sdk.core.utils.z.i
    public void success() {
        g gVar = this.f5168a;
        gVar.b.a((com.meishu.sdk.meishu_ad.nativ.f) gVar.f5177a, (com.meishu.sdk.meishu_ad.nativ.a) new a(), false, false, false, m.b(gVar.getContext(), ((DrawAdLoader) this.f5168a.getAdLoader()).getAccept_ad_width().intValue()), m.b(this.f5168a.getContext(), ((DrawAdLoader) this.f5168a.getAdLoader()).getAccept_ad_height().intValue()));
    }
}
