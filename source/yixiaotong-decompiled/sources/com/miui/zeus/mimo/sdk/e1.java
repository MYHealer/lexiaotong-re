package com.miui.zeus.mimo.sdk;

import com.google.common.base.Ascii;
import com.miui.zeus.mimo.sdk.ad.nativead.NativeAdImpl;
import com.miui.zeus.mimo.sdk.ad.nativead.NativeAdViewBinder;
import com.miui.zeus.mimo.sdk.ad.nativead.view.NativeAdView;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class e1 implements NativeAdData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MimoAdInfo f5410a;
    public NativeAdImpl b = null;

    public class a implements NativeAd.NativeAdInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NativeCustomAd.NativeCustomMultiAdsInteractionListener f5411a;

        public a(NativeCustomAd.NativeCustomMultiAdsInteractionListener nativeCustomMultiAdsInteractionListener) {
            this.f5411a = nativeCustomMultiAdsInteractionListener;
        }

        @Override // com.miui.zeus.mimo.sdk.NativeAd.NativeAdInteractionListener
        public void onAdClick() {
            NativeCustomAd.NativeCustomMultiAdsInteractionListener nativeCustomMultiAdsInteractionListener = this.f5411a;
            if (nativeCustomMultiAdsInteractionListener != null) {
                nativeCustomMultiAdsInteractionListener.onAdClick(e1.this);
            }
        }

        @Override // com.miui.zeus.mimo.sdk.NativeAd.NativeAdInteractionListener
        public void onAdClosed() {
            NativeCustomAd.NativeCustomMultiAdsInteractionListener nativeCustomMultiAdsInteractionListener = this.f5411a;
            if (nativeCustomMultiAdsInteractionListener != null) {
                nativeCustomMultiAdsInteractionListener.onAdClosed(e1.this);
            }
        }

        @Override // com.miui.zeus.mimo.sdk.NativeAd.NativeAdInteractionListener
        public void onAdShow() {
            NativeCustomAd.NativeCustomMultiAdsInteractionListener nativeCustomMultiAdsInteractionListener = this.f5411a;
            if (nativeCustomMultiAdsInteractionListener != null) {
                nativeCustomMultiAdsInteractionListener.onAdShow(e1.this);
            }
        }

        @Override // com.miui.zeus.mimo.sdk.NativeAd.NativeAdInteractionListener
        public void onRenderFail(int i, String str) {
            NativeCustomAd.NativeCustomMultiAdsInteractionListener nativeCustomMultiAdsInteractionListener = this.f5411a;
            if (nativeCustomMultiAdsInteractionListener != null) {
                nativeCustomMultiAdsInteractionListener.onRenderFail(e1.this, i, str);
            }
        }
    }

    @Override // com.miui.zeus.mimo.sdk.NativeAdData
    public void destroy() {
        NativeAdImpl nativeAdImpl = this.b;
        if (nativeAdImpl != null) {
            nativeAdImpl.b();
        }
    }

    @Override // com.miui.zeus.mimo.sdk.NativeAdData
    public String getAdMark() {
        MimoAdInfo mimoAdInfo = this.f5410a;
        if (mimoAdInfo != null) {
            return mimoAdInfo.h;
        }
        return null;
    }

    @Override // com.miui.zeus.mimo.sdk.NativeAdData
    public int getAdStyle() {
        MimoAdInfo mimoAdInfo = this.f5410a;
        if (mimoAdInfo != null) {
            return mimoAdInfo.s;
        }
        return 0;
    }

    @Override // com.miui.zeus.mimo.sdk.NativeAdData
    public int getAdType() {
        MimoAdInfo mimoAdInfo = this.f5410a;
        if (mimoAdInfo != null) {
            return mimoAdInfo.t;
        }
        return 0;
    }

    @Override // com.miui.zeus.mimo.sdk.NativeAdData
    public String getAppDeveloper() {
        MimoAdInfo mimoAdInfo = this.f5410a;
        if (mimoAdInfo != null) {
            return mimoAdInfo.k;
        }
        return null;
    }

    @Override // com.miui.zeus.mimo.sdk.NativeAdData
    public String getAppIntroduction() {
        MimoAdInfo mimoAdInfo = this.f5410a;
        if (mimoAdInfo != null) {
            return mimoAdInfo.n;
        }
        return null;
    }

    @Override // com.miui.zeus.mimo.sdk.NativeAdData
    public String getAppName() {
        MimoAdInfo mimoAdInfo = this.f5410a;
        if (mimoAdInfo != null) {
            return mimoAdInfo.i;
        }
        return null;
    }

    @Override // com.miui.zeus.mimo.sdk.NativeAdData
    public String getAppPermission() {
        MimoAdInfo mimoAdInfo = this.f5410a;
        if (mimoAdInfo != null) {
            return mimoAdInfo.l;
        }
        return null;
    }

    @Override // com.miui.zeus.mimo.sdk.NativeAdData
    public String getAppPrivacy() {
        MimoAdInfo mimoAdInfo = this.f5410a;
        if (mimoAdInfo != null) {
            return mimoAdInfo.m;
        }
        return null;
    }

    @Override // com.miui.zeus.mimo.sdk.NativeAdData
    public String getAppVersion() {
        MimoAdInfo mimoAdInfo = this.f5410a;
        if (mimoAdInfo != null) {
            return mimoAdInfo.e();
        }
        return null;
    }

    @Override // com.miui.zeus.mimo.sdk.NativeAdData
    public int getAssetHeight() {
        MimoAdInfo mimoAdInfo = this.f5410a;
        if (mimoAdInfo != null) {
            return mimoAdInfo.H;
        }
        return 0;
    }

    @Override // com.miui.zeus.mimo.sdk.NativeAdData
    public String getAssetOrientation() {
        MimoAdInfo mimoAdInfo = this.f5410a;
        return mimoAdInfo != null ? mimoAdInfo.I : ijiami_1011.s.s.s.d(new byte[]{Ascii.ETB, 87, 66, 70, 8, 87, 0, 8}, "a202a4");
    }

    @Override // com.miui.zeus.mimo.sdk.NativeAdData
    public int getAssetWidth() {
        MimoAdInfo mimoAdInfo = this.f5410a;
        if (mimoAdInfo != null) {
            return mimoAdInfo.G;
        }
        return 0;
    }

    @Override // com.miui.zeus.mimo.sdk.NativeAdData
    public String getButtonText() {
        MimoAdInfo mimoAdInfo = this.f5410a;
        if (mimoAdInfo != null) {
            return mimoAdInfo.g();
        }
        return null;
    }

    @Override // com.miui.zeus.mimo.sdk.NativeAdData
    public String getDesc() {
        MimoAdInfo mimoAdInfo = this.f5410a;
        if (mimoAdInfo != null) {
            return mimoAdInfo.p();
        }
        return null;
    }

    @Override // com.miui.zeus.mimo.sdk.NativeAdData
    public long getDuration() {
        MimoAdInfo mimoAdInfo = this.f5410a;
        if (mimoAdInfo != null) {
            return mimoAdInfo.m0;
        }
        return 0L;
    }

    @Override // com.miui.zeus.mimo.sdk.NativeAdData
    public String getIconUrl() {
        MimoAdInfo mimoAdInfo = this.f5410a;
        if (mimoAdInfo != null) {
            return mimoAdInfo.A;
        }
        return null;
    }

    @Override // com.miui.zeus.mimo.sdk.NativeAdData
    public long getId() {
        MimoAdInfo mimoAdInfo = this.f5410a;
        if (mimoAdInfo != null) {
            return mimoAdInfo.d;
        }
        return 0L;
    }

    @Override // com.miui.zeus.mimo.sdk.NativeAdData
    public List<String> getImageList() {
        MimoAdInfo mimoAdInfo = this.f5410a;
        if (mimoAdInfo != null) {
            return mimoAdInfo.j();
        }
        return null;
    }

    @Override // com.miui.zeus.mimo.sdk.NativeAdData
    public int getMaterialType() {
        MimoAdInfo mimoAdInfo = this.f5410a;
        if (mimoAdInfo != null) {
            return mimoAdInfo.E;
        }
        return 0;
    }

    @Override // com.miui.zeus.mimo.sdk.NativeAdData
    public Map<String, Object> getMediaExtraInfo() {
        MimoAdInfo mimoAdInfo = this.f5410a;
        return mimoAdInfo != null ? mimoAdInfo.j0 : new HashMap();
    }

    @Override // com.miui.zeus.mimo.sdk.NativeAdData
    public String getPackageName() {
        MimoAdInfo mimoAdInfo = this.f5410a;
        if (mimoAdInfo != null) {
            return mimoAdInfo.C;
        }
        return null;
    }

    @Override // com.miui.zeus.mimo.sdk.NativeAdData
    public String getTitle() {
        MimoAdInfo mimoAdInfo = this.f5410a;
        if (mimoAdInfo != null) {
            return mimoAdInfo.e;
        }
        return null;
    }

    @Override // com.miui.zeus.mimo.sdk.NativeAdData
    public String getVideoUrl() {
        MimoAdInfo mimoAdInfo = this.f5410a;
        if (mimoAdInfo != null) {
            return mimoAdInfo.B;
        }
        return null;
    }

    @Override // com.miui.zeus.mimo.sdk.NativeAdData
    public void registerAdView(NativeAdView nativeAdView, NativeAdViewBinder nativeAdViewBinder, NativeCustomAd.NativeCustomMultiAdsInteractionListener nativeCustomMultiAdsInteractionListener) {
        if (this.b == null) {
            this.b = new NativeAdImpl();
        }
        NativeAdImpl nativeAdImpl = this.b;
        nativeAdImpl.f5377a = this.f5410a;
        nativeAdImpl.a(nativeAdView, nativeAdViewBinder, new a(nativeCustomMultiAdsInteractionListener));
    }
}
