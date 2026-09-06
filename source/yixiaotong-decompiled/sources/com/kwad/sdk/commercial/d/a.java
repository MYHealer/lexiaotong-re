package com.kwad.sdk.commercial.d;

import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.ba;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.commercial.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.by;
import com.yfanads.ads.chanel.ks.utils.KSUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a {
    private static void c(AdTemplate adTemplate, String str, String str2) {
        com.kwad.sdk.commercial.c.d(d.In().m983do(ILoggerReporter.Category.ERROR_LOG).g(0.01d).b(e.bA(adTemplate)).Q("ad_sdk_ad_data_performance", "error_name").A(b.Ir().dw(str).dx(str2).setAdTemplate(adTemplate)));
    }

    public static void a(int i, AdTemplate adTemplate, String str, String str2) {
        com.kwad.sdk.commercial.c.d(d.In().m983do(ILoggerReporter.Category.ERROR_LOG).g(0.01d).b(e.ds(i)).Q("ad_sdk_ad_data_performance", "error_name").A(b.Ir().dw(str).dx(str2).setAdTemplate(adTemplate)));
    }

    public static void a(SceneImpl sceneImpl, long j, String str) {
        if (sceneImpl == null) {
            return;
        }
        try {
            com.kwad.sdk.commercial.c.d(d.In().m983do(ILoggerReporter.Category.ERROR_LOG).g(0.01d).b(e.ds(sceneImpl.getAdStyle())).Q("ad_sdk_ad_parse_performance", "default").A(c.Is().dy(str).setPosId(sceneImpl.posId).setLlsid(j)));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(SceneImpl sceneImpl, long j, String str, String str2) {
        if (sceneImpl == null) {
            return;
        }
        try {
            com.kwad.sdk.commercial.c.d(d.In().m983do(ILoggerReporter.Category.ERROR_LOG).g(0.01d).b(e.ds(sceneImpl.getAdStyle())).Q("ad_sdk_ad_parse_performance", "default").A(c.Is().dy(str).dz(str2).setErrorCode(100013).setPosId(sceneImpl.posId).setLlsid(j)));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void ci(AdTemplate adTemplate) {
        try {
            if (adTemplate.llsid == 0) {
                c(adTemplate, KSUtil.REQUEST_ID, "");
            }
            if (com.kwad.sdk.core.response.helper.e.eY(adTemplate) == 0) {
                c(adTemplate, "create_id", "");
            }
            AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
            int i = adInfoEO.adBaseInfo.adOperationType;
            if (i == 1) {
                String strDb = com.kwad.sdk.core.response.helper.a.db(adInfoEO);
                if (by.ir(strDb)) {
                    c(adTemplate, "download_url", strDb);
                }
            } else if (i == 2) {
                String strAY = com.kwad.sdk.core.response.helper.a.aY(adInfoEO);
                if (by.ir(strAY)) {
                    c(adTemplate, ba.Z, strAY);
                }
            }
            AdInfo.AdMaterialInfo.MaterialFeature materialFeatureP = com.kwad.sdk.core.response.helper.a.P(adInfoEO);
            int i2 = materialFeatureP.featureType;
            String str = materialFeatureP.materialUrl;
            if (i2 == 1) {
                if (by.ir(str)) {
                    c(adTemplate, "video_url", str);
                    return;
                }
                return;
            }
            if (i2 == 2) {
                if (by.ir(str)) {
                    c(adTemplate, "image_url", str);
                }
            } else if (i2 == 3) {
                long jCw = com.kwad.sdk.core.response.helper.a.cw(adInfoEO);
                String strBn = com.kwad.sdk.core.response.helper.a.bn(adInfoEO);
                if (jCw == 0) {
                    c(adTemplate, "live_author_id", "");
                } else if (TextUtils.isEmpty(strBn)) {
                    c(adTemplate, "live_stream_id", strBn);
                }
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void n(AdTemplate adTemplate, String str) {
        c(adTemplate, "tk_template_id", str);
    }
}
