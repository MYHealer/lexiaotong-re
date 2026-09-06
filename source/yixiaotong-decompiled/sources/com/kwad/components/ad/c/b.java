package com.kwad.components.ad.c;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsBannerAd;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class b extends com.kwad.sdk.mvp.a {
    public FrameLayout bQ;
    public a bR;
    public KsAdVideoPlayConfig bS;
    public List<AdTemplate> bT;
    public long bU;
    private KsBannerAd.BannerAdInteractionListener bV;
    private d bW;
    public StyleTemplate bX;
    public boolean bY = false;
    public AdResultData mAdResultData;
    public SceneImpl mAdScene;
    public Context mContext;

    public interface a {
        void ad();
    }

    public final void a(a aVar) {
        this.bR = aVar;
    }

    public final void a(KsBannerAd.BannerAdInteractionListener bannerAdInteractionListener) {
        this.bV = bannerAdInteractionListener;
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
    }

    public final void setBannerUpdateAdResultDataListener(d dVar) {
        this.bW = dVar;
    }

    public final void a(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.helper.c.r(adResultData);
    }

    public static boolean a(AdTemplate adTemplate) {
        AdMatrixInfo.AdBannerTKInfo adBannerTKInfoDZ;
        return com.kwad.sdk.core.config.e.JM() && (adBannerTKInfoDZ = com.kwad.sdk.core.response.helper.b.dZ(adTemplate)) != null && !TextUtils.isEmpty(adBannerTKInfoDZ.templateId) && adBannerTKInfoDZ.renderType == 1;
    }

    public final void aa() {
        this.mAdTemplate.converted = true;
        KsBannerAd.BannerAdInteractionListener bannerAdInteractionListener = this.bV;
        if (bannerAdInteractionListener != null) {
            bannerAdInteractionListener.onAdShow();
        }
    }

    public final void ab() {
        this.mAdTemplate.converted = true;
        KsBannerAd.BannerAdInteractionListener bannerAdInteractionListener = this.bV;
        if (bannerAdInteractionListener != null) {
            bannerAdInteractionListener.onAdClicked();
        }
    }

    public final void ac() {
        KsBannerAd.BannerAdInteractionListener bannerAdInteractionListener = this.bV;
        if (bannerAdInteractionListener != null) {
            bannerAdInteractionListener.onAdClose();
        }
    }

    public final void c(int i, String str) {
        KsBannerAd.BannerAdInteractionListener bannerAdInteractionListener = this.bV;
        if (bannerAdInteractionListener != null) {
            bannerAdInteractionListener.onAdShowError(0, str);
        }
    }

    public final void b(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        this.bW.b(this.mAdTemplate);
    }
}
