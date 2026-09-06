package com.meishu.sdk.meishu_ad;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import com.meishu.sdk.R;
import com.meishu.sdk.core.domain.HttpResponse;
import com.meishu.sdk.core.exception.ErrorCodeUtil;
import com.meishu.sdk.core.view.gif.GifImageView;
import com.meishu.sdk.meishu_ad.banner.MeishuBannerRootView;
import java.io.IOException;

/* JADX INFO: compiled from: AdNative.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a implements com.meishu.sdk.core.utils.x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.meishu.sdk.meishu_ad.banner.b f4994a;
    public final /* synthetic */ com.meishu.sdk.meishu_ad.banner.a b;
    public final /* synthetic */ MeishuBannerRootView c;
    public final /* synthetic */ GifImageView d;
    public final /* synthetic */ com.meishu.sdk.core.bquery.i e;
    public final /* synthetic */ v f;

    /* JADX INFO: renamed from: com.meishu.sdk.meishu_ad.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AdNative.java */
    public class C0824a extends com.meishu.sdk.core.safe.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.meishu.sdk.platform.ms.banner.c f4995a;

        public C0824a(com.meishu.sdk.platform.ms.banner.c cVar) {
            this.f4995a = cVar;
        }

        @Override // com.meishu.sdk.core.safe.o
        public void safeOnClick(View view) {
            if (a.this.c.getParent() != null) {
                ((ViewGroup) a.this.c.getParent()).removeView(a.this.c);
            }
            com.meishu.sdk.meishu_ad.banner.b bVar = a.this.f4994a;
            if (bVar != null) {
                ((com.meishu.sdk.platform.ms.banner.a) bVar).f5161a.onAdClosed();
            }
            if (this.f4995a.getInteractionListener() != null) {
                this.f4995a.getInteractionListener().onAdClosed();
            }
        }
    }

    /* JADX INFO: compiled from: AdNative.java */
    public class b extends com.meishu.sdk.core.safe.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.meishu.sdk.platform.ms.banner.c f4996a;

        public b(com.meishu.sdk.platform.ms.banner.c cVar) {
            this.f4996a = cVar;
        }

        @Override // com.meishu.sdk.core.safe.o
        public void safeOnClick(View view) {
            if (this.f4996a.getInteractionListener() != null && a.this.b.getCbc() == 0) {
                this.f4996a.getInteractionListener().onAdClicked();
            }
            a.this.b.setClkActType(1);
            com.meishu.sdk.core.utils.f.a((com.meishu.sdk.platform.ms.c) this.f4996a, true);
        }
    }

    public a(v vVar, com.meishu.sdk.meishu_ad.banner.b bVar, com.meishu.sdk.meishu_ad.banner.a aVar, MeishuBannerRootView meishuBannerRootView, GifImageView gifImageView, com.meishu.sdk.core.bquery.i iVar) {
        this.f = vVar;
        this.f4994a = bVar;
        this.b = aVar;
        this.c = meishuBannerRootView;
        this.d = gifImageView;
        this.e = iVar;
    }

    @Override // com.meishu.sdk.core.utils.x
    public void onFailure(IOException iOException) {
        this.f.a(this.f4994a, "图片资源加载错误", ErrorCodeUtil.RES_LOAD_ERROR);
    }

    @Override // com.meishu.sdk.core.utils.x
    public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
        try {
            if (!httpResponse.isSuccessful()) {
                this.f.a(this.f4994a, "图片资源加载错误", ErrorCodeUtil.RES_LOAD_ERROR);
                return;
            }
            byte[] responseBody = httpResponse.getResponseBody();
            if (responseBody == null || responseBody.length <= 0) {
                this.f.a(this.f4994a, "图片资源加载错误", ErrorCodeUtil.RES_LOAD_ERROR);
                return;
            }
            if (responseBody.length >= com.meishu.sdk.core.utils.i0.a()) {
                this.f.a(this.f4994a, "图片资源加载错误", ErrorCodeUtil.RES_LOAD_ERROR);
                return;
            }
            this.f.p = System.currentTimeMillis();
            com.meishu.sdk.meishu_ad.banner.a aVar = this.b;
            aVar.setMonitorUrl(com.meishu.sdk.core.utils.h0.b(aVar.getMonitorUrl(), this.f.a()));
            com.meishu.sdk.platform.ms.banner.c cVar = new com.meishu.sdk.platform.ms.banner.c(this.b);
            this.c.setBannerAd(cVar);
            if (this.f4994a != null) {
                cVar.setAdView(this.c);
                ((com.meishu.sdk.platform.ms.banner.a) this.f4994a).onADLoaded(cVar);
            }
            if (com.meishu.sdk.core.utils.e0.a(responseBody)) {
                GifImageView gifImageView = this.d;
                if (gifImageView != null) {
                    gifImageView.setBytes(responseBody);
                    this.d.startAnimation();
                }
            } else {
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                if (bitmapDecodeByteArray == null) {
                    this.f.a(this.f4994a, "图片资源加载错误", ErrorCodeUtil.RES_LOAD_ERROR);
                    return;
                }
                this.d.setImageBitmap(bitmapDecodeByteArray);
            }
            com.meishu.sdk.core.bquery.i iVarB = this.e.b(R.id.ms_banner_close_button);
            C0824a c0824a = new C0824a(cVar);
            View view = iVarB.d;
            if (view != null) {
                view.setOnClickListener(c0824a);
            }
            com.meishu.sdk.core.bquery.i iVarB2 = this.e.b(R.id.ms_banner_image);
            b bVar = new b(cVar);
            View view2 = iVarB2.d;
            if (view2 != null) {
                view2.setOnClickListener(bVar);
            }
        } catch (Throwable unused) {
            this.f.a(this.f4994a, "图片资源加载错误", ErrorCodeUtil.RES_LOAD_ERROR);
        }
    }
}
