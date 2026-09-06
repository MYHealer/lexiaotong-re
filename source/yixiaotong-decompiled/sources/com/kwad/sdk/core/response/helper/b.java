package com.kwad.sdk.core.response.helper;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.FeedSlideConf;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.br;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b {
    private static Random aXC = new Random();

    public static AdMatrixInfo cO(AdTemplate adTemplate) {
        if (e.eG(adTemplate)) {
            return e.eO(adTemplate).adMatrixInfo;
        }
        return new AdMatrixInfo();
    }

    public static List<AdMatrixInfo.MatrixTemplate> cP(AdTemplate adTemplate) {
        return cO(adTemplate).styles.templateList;
    }

    public static AdMatrixInfo.AdDataV2 cQ(AdTemplate adTemplate) {
        return e.eO(adTemplate).adMatrixInfo.adDataV2;
    }

    public static AdMatrixInfo.MatrixTemplate t(AdTemplate adTemplate, String str) {
        for (AdMatrixInfo.MatrixTemplate matrixTemplate : cO(adTemplate).styles.templateList) {
            if (br.isEquals(str, matrixTemplate.templateId)) {
                return matrixTemplate;
            }
        }
        return null;
    }

    private static AdMatrixInfo.TemplateData u(AdTemplate adTemplate, String str) {
        for (AdMatrixInfo.TemplateData templateData : cO(adTemplate).adDataV2.templateDataList) {
            if (br.isEquals(str, templateData.templateId)) {
                return templateData;
            }
        }
        return null;
    }

    private static long v(AdTemplate adTemplate, String str) {
        AdMatrixInfo.TemplateData templateDataU = u(adTemplate, str);
        if (templateDataU != null) {
            return templateDataU.templateDelayTime;
        }
        return 0L;
    }

    public static FeedSlideConf cR(AdTemplate adTemplate) {
        JSONArray jSONArrayOptJSONArray;
        AdMatrixInfo.TemplateData templateDataU = u(adTemplate, m985do(adTemplate).templateId);
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(templateDataU != null ? templateDataU.data : "").optJSONObject("slideInfo");
            if (jSONObjectOptJSONObject != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("angle")) != null && jSONArrayOptJSONArray.length() > 1) {
                FeedSlideConf feedSlideConf = new FeedSlideConf();
                feedSlideConf.minRange = ((Integer) jSONArrayOptJSONArray.get(0)).intValue();
                feedSlideConf.maxRange = ((Integer) jSONArrayOptJSONArray.get(1)).intValue();
                return feedSlideConf;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static AdMatrixInfo.InterstitialCardInfo cS(AdTemplate adTemplate) {
        return cO(adTemplate).adDataV2.interstitialCardInfo;
    }

    public static String cT(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateT = t(adTemplate, cO(adTemplate).adDataV2.splashActionBarInfo.templateId);
        return matrixTemplateT != null ? matrixTemplateT.templateUrl : "";
    }

    private static AdMatrixInfo.ActionBarInfoNew cU(AdTemplate adTemplate) {
        return cO(adTemplate).adDataV2.actionBarInfo;
    }

    public static String cV(AdTemplate adTemplate) {
        AdInfo adInfoEO = e.eO(adTemplate);
        boolean z = e.fi(adTemplate) || e.eI(adTemplate) == 2;
        if (a.cY(adInfoEO)) {
            return "";
        }
        if (z && a.cN(adTemplate)) {
            AdMatrixInfo.MatrixTemplate matrixTemplateT = t(adTemplate, dU(adTemplate).templateId);
            return matrixTemplateT != null ? matrixTemplateT.templateUrl : "";
        }
        AdMatrixInfo.MatrixTemplate matrixTemplateT2 = t(adTemplate, cU(adTemplate).templateId);
        return matrixTemplateT2 != null ? matrixTemplateT2.templateUrl : "";
    }

    public static boolean fm(String str) {
        try {
            return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).cP(str);
        } catch (Exception unused) {
            return false;
        }
    }

    public static long cW(AdTemplate adTemplate) {
        return cU(adTemplate).maxTimeOut;
    }

    public static boolean cX(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(cV(adTemplate));
    }

    private static AdMatrixInfo.AggregationCardInfo cY(AdTemplate adTemplate) {
        return cO(adTemplate).adDataV2.aggregationCardInfo;
    }

    public static String cZ(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateT = t(adTemplate, cY(adTemplate).templateId);
        return matrixTemplateT != null ? matrixTemplateT.templateUrl : "";
    }

    public static long da(AdTemplate adTemplate) {
        return v(adTemplate, cY(adTemplate).templateId);
    }

    public static long db(AdTemplate adTemplate) {
        return ((long) cY(adTemplate).changeTime) * 1000;
    }

    public static int dc(AdTemplate adTemplate) {
        return cY(adTemplate).maxTimesPerDay;
    }

    public static long dd(AdTemplate adTemplate) {
        return cY(adTemplate).intervalTime;
    }

    public static boolean de(AdTemplate adTemplate) {
        AdInfo adInfoEO = e.eO(adTemplate);
        return !a.aL(adInfoEO) && a.az(adInfoEO);
    }

    public static boolean df(AdTemplate adTemplate) {
        if (!TextUtils.isEmpty(cZ(adTemplate)) && da(adTemplate) > 0) {
            return as.isOrientationPortrait();
        }
        return false;
    }

    private static AdMatrixInfo.BaseMatrixTemplate dg(AdTemplate adTemplate) {
        return cO(adTemplate).adDataV2.halfCardInfo;
    }

    public static String dh(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateT = t(adTemplate, dg(adTemplate).templateId);
        return matrixTemplateT != null ? matrixTemplateT.templateUrl : "";
    }

    private static AdMatrixInfo.EndCardInfo di(AdTemplate adTemplate) {
        return cO(adTemplate).adDataV2.endCardInfo;
    }

    public static String dj(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateT = t(adTemplate, di(adTemplate).templateId);
        return matrixTemplateT != null ? matrixTemplateT.templateUrl : "";
    }

    public static boolean dk(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(dj(adTemplate));
    }

    private static String dl(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateT = t(adTemplate, e.eO(adTemplate).adMatrixInfo.adDataV2.activityMiddlePageInfo.templateId);
        return matrixTemplateT != null ? matrixTemplateT.templateUrl : "";
    }

    public static String dm(AdTemplate adTemplate) {
        if (dn(adTemplate)) {
            return dl(adTemplate);
        }
        return a.aY(e.eO(adTemplate));
    }

    private static boolean dn(AdTemplate adTemplate) {
        return (adTemplate.mIsForceJumpLandingPage || a.cL(adTemplate) || !dQ(e.eO(adTemplate))) ? false : true;
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    private static AdMatrixInfo.FeedInfo m985do(AdTemplate adTemplate) {
        if (dq(adTemplate)) {
            return cO(adTemplate).adDataV2.adUnionFeedLiveTemplateInfo;
        }
        return cO(adTemplate).adDataV2.feedInfo;
    }

    private static AdMatrixInfo.NativeMatrixAdInfo dp(AdTemplate adTemplate) {
        return cO(adTemplate).adDataV2.nativeAdInfo;
    }

    private static boolean dq(AdTemplate adTemplate) {
        return a.cY(e.eO(adTemplate));
    }

    private static AdMatrixInfo.FeedInfo dr(AdTemplate adTemplate) {
        return cO(adTemplate).adDataV2.adUnionFeedLiveMediaInfo;
    }

    public static String ds(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateT = t(adTemplate, m985do(adTemplate).templateId);
        return matrixTemplateT != null ? matrixTemplateT.templateUrl : "";
    }

    private static AdMatrixInfo.FeedTKInfo dt(AdTemplate adTemplate) {
        return cO(adTemplate).adDataV2.feedTKCardInfo;
    }

    public static AdMatrixInfo.NativeTKInfo du(AdTemplate adTemplate) {
        return cO(adTemplate).adDataV2.nativeTKCardInfo;
    }

    public static String dv(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateT = t(adTemplate, dr(adTemplate).templateId);
        return matrixTemplateT != null ? matrixTemplateT.templateUrl : "";
    }

    public static boolean dw(AdTemplate adTemplate) {
        return m985do(adTemplate).interactionInfo.interactiveStyle == 2;
    }

    public static boolean dx(AdTemplate adTemplate) {
        return m985do(adTemplate).interactionInfo.shakeInfo.clickDisabled;
    }

    public static int dy(AdTemplate adTemplate) {
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = m985do(adTemplate).interactionInfo;
        if (adInteractionInfo == null || adInteractionInfo.shakeInfo == null) {
            return 0;
        }
        return adInteractionInfo.shakeInfo.acceleration;
    }

    public static boolean dI(AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.feedInfo.interactionInfo.shakeInfo.enable;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return false;
        }
    }

    public static boolean dJ(AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.feedInfo.interactionInfo.shakeInfo.bidirectionalSwitch;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return false;
        }
    }

    public static boolean dz(AdTemplate adTemplate) {
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = dp(adTemplate).interactionInfo;
        if (adInteractionInfo == null || adInteractionInfo.shakeInfo == null) {
            return false;
        }
        return adInteractionInfo.shakeInfo.enable;
    }

    public static int dA(AdTemplate adTemplate) {
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = dp(adTemplate).interactionInfo;
        if (adInteractionInfo == null || adInteractionInfo.shakeInfo == null) {
            return 0;
        }
        return adInteractionInfo.shakeInfo.acceleration;
    }

    public static boolean dK(AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.nativeAdInfo.interactionInfo.shakeInfo.bidirectionalSwitch;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            try {
                return adInfo.adStyleConfInfo.nativeAdInfo.shakeInfo.bidirectionalSwitch;
            } catch (Exception e2) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e2);
                return false;
            }
        }
    }

    public static double dB(AdTemplate adTemplate) {
        return e.eO(adTemplate).adStyleInfo.feedAdInfo.heightRatio;
    }

    public static boolean dL(AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.templateId);
    }

    public static boolean dM(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardFullScreenClick;
    }

    public static boolean dN(AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.topFloorTKInfo.templateId);
    }

    public static boolean dO(AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.splashPlayCardTKInfo.templateId);
    }

    public static boolean dP(AdInfo adInfo) {
        if (dQ(adInfo)) {
            return adInfo.adMatrixInfo.adDataV2.activityMiddlePageInfo.showHeaderBar;
        }
        return true;
    }

    public static boolean dQ(AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.activityMiddlePageInfo.templateId);
    }

    public static String dR(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo.title;
    }

    public static String dS(AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.subtitle;
        } catch (Exception unused) {
            return "摇一摇";
        }
    }

    public static long dT(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.tkDefaultTimeout;
    }

    public static String dU(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo.subTitle;
    }

    public static String dV(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.splashActionBarInfo.title;
    }

    public static boolean dC(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(ds(adTemplate));
    }

    public static boolean dD(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(dt(adTemplate).templateId);
    }

    public static boolean dE(AdTemplate adTemplate) {
        AdMatrixInfo.NativeTKInfo nativeTKInfoDu = du(adTemplate);
        return (nativeTKInfoDu == null || TextUtils.isEmpty(nativeTKInfoDu.templateId) || nativeTKInfoDu.renderType != 1) ? false : true;
    }

    public static boolean dF(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(ex(adTemplate));
    }

    public static String dG(AdTemplate adTemplate) {
        AdMatrixInfo.FeedTKInfo feedTKInfoDt = dt(adTemplate);
        return TextUtils.isEmpty(feedTKInfoDt.templateId) ? "ksad-feed-card" : feedTKInfoDt.templateId;
    }

    public static boolean dH(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(dv(adTemplate));
    }

    public static boolean dW(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.interactionInfo.interactiveStyle == 2;
    }

    public static float dI(AdTemplate adTemplate) {
        int i;
        try {
            i = e.eO(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            i = 7;
        }
        if (i > 0) {
            return i;
        }
        return 7.0f;
    }

    public static boolean dX(AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.interactionInfo.shakeInfo.enable;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return false;
        }
    }

    public static boolean dY(AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.interactionInfo.shakeInfo.bidirectionalSwitch;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return false;
        }
    }

    public static boolean dJ(AdTemplate adTemplate) {
        try {
            return e.eO(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.renderType == 1;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return false;
        }
    }

    public static float dK(AdTemplate adTemplate) {
        int i;
        try {
            i = e.eO(adTemplate).adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            i = 7;
        }
        return i;
    }

    public static boolean dZ(AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.enable;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return false;
        }
    }

    public static boolean ea(AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.bidirectionalSwitch;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return false;
        }
    }

    public static AdMatrixInfo.RotateInfo dL(AdTemplate adTemplate) {
        try {
            return e.eO(adTemplate).adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    public static AdMatrixInfo.RotateInfo dM(AdTemplate adTemplate) {
        try {
            AdMatrixInfo.AdInteractionInfo adInteractionInfo = m985do(adTemplate).interactionInfo;
            if (adInteractionInfo != null) {
                return adInteractionInfo.rotateInfo;
            }
            return null;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    public static AdMatrixInfo.RotateInfo dN(AdTemplate adTemplate) {
        try {
            AdMatrixInfo.AdInteractionInfo adInteractionInfo = dp(adTemplate).interactionInfo;
            if (adInteractionInfo != null) {
                return adInteractionInfo.rotateInfo;
            }
            return null;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    public static int eb(AdInfo adInfo) {
        try {
            int i = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.componentIndex;
            if (i != 2) {
                return 1;
            }
            return i;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return 1;
        }
    }

    public static boolean ec(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.isMediaDisable && adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 4;
    }

    public static boolean ed(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 2;
    }

    public static int ee(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle;
    }

    public static int ef(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle;
    }

    public static boolean eg(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 2;
    }

    public static boolean eh(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 1;
    }

    public static boolean ei(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 1;
    }

    public static boolean ej(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 3;
    }

    public static boolean ek(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 10;
    }

    public static boolean el(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 3;
    }

    public static boolean em(AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 10;
        } catch (Exception unused) {
        }
    }

    public static boolean en(AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 9;
        } catch (Exception unused) {
        }
    }

    public static boolean eo(AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 12;
        } catch (Exception unused) {
        }
    }

    public static boolean ep(AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 14;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return false;
        }
    }

    public static boolean eq(AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 4 || adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 9;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean er(AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 4;
        } catch (Exception unused) {
        }
    }

    public static boolean es(AdInfo adInfo) {
        try {
            return !adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.clickDisabled;
        } catch (Exception unused) {
        }
    }

    public static long et(AdInfo adInfo) {
        try {
            long j = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.switchDefaultTime;
            if (j <= 0) {
                return 1500L;
            }
            return j;
        } catch (Exception unused) {
            return 1500L;
        }
    }

    public static boolean eu(AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.enable;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean ev(AdInfo adInfo) {
        try {
            return !adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.clickDisabled;
        } catch (Exception unused) {
        }
    }

    public static boolean g(AdInfo adInfo) {
        return (!adInfo.adRewardInfo.recommendAggregateSwitch || a.de(adInfo) || a.bQ(adInfo)) ? false : true;
    }

    private static AdMatrixInfo.BaseMatrixTemplate dO(AdTemplate adTemplate) {
        return cO(adTemplate).adDataV2.complianceCardInfo;
    }

    public static String dP(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateT = t(adTemplate, dO(adTemplate).templateId);
        return matrixTemplateT != null ? matrixTemplateT.templateUrl : "";
    }

    public static boolean dQ(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(dP(adTemplate));
    }

    private static AdMatrixInfo.BaseMatrixTemplate dR(AdTemplate adTemplate) {
        return cO(adTemplate).adDataV2.downloadConfirmCardInfo;
    }

    public static String dS(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateT = t(adTemplate, dR(adTemplate).templateId);
        return matrixTemplateT != null ? matrixTemplateT.templateUrl : "";
    }

    public static boolean dT(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(dS(adTemplate));
    }

    public static AdMatrixInfo.MerchantLiveReservationInfo dU(AdTemplate adTemplate) {
        return cO(adTemplate).adDataV2.merchantLiveReservationInfo;
    }

    public static AdMatrixInfo.FullScreenInfo dV(AdTemplate adTemplate) {
        return cO(adTemplate).adDataV2.fullScreenInfo;
    }

    public static AdMatrixInfo.SplashPlayCardTKInfo dW(AdTemplate adTemplate) {
        return cO(adTemplate).adDataV2.splashPlayCardTKInfo;
    }

    public static long dX(AdTemplate adTemplate) {
        return cO(adTemplate).adDataV2.splashPlayCardTKInfo.tkTimeout;
    }

    public static int dY(AdTemplate adTemplate) {
        return cO(adTemplate).adDataV2.splashPlayCardTKInfo.renderType;
    }

    public static AdMatrixInfo.AdBannerTKInfo dZ(AdTemplate adTemplate) {
        return cO(adTemplate).adDataV2.bannerTKInfo;
    }

    public static boolean ea(AdTemplate adTemplate) {
        AdInfo adInfoEO = e.eO(adTemplate);
        return (g(adInfoEO) || e.fa(adTemplate) || cU(adTemplate).cardType == 4 || e.eO(adTemplate).adStyleInfo2.playDetailInfo.detailCommonInfo.rewardInteractionType > 0 || adInfoEO.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.interactiveStyle != 2) ? false : true;
    }

    public static boolean eb(AdTemplate adTemplate) {
        AdInfo adInfoEO = e.eO(adTemplate);
        return (g(adInfoEO) || e.fa(adTemplate) || cU(adTemplate).cardType == 4 || e.eO(adTemplate).adStyleInfo2.playDetailInfo.detailWebCardInfo.cardType == 4 || adInfoEO.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.interactiveStyle != 2) ? false : true;
    }

    public static float ew(AdInfo adInfo) {
        int i;
        try {
            i = adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            i = 7;
        }
        return i;
    }

    public static boolean ex(AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.enable;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return false;
        }
    }

    public static boolean ey(AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.bidirectionalSwitch;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return false;
        }
    }

    public static float ez(AdInfo adInfo) {
        int i;
        try {
            i = adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            i = 7;
        }
        return i;
    }

    public static boolean eA(AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.bidirectionalSwitch;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return false;
        }
    }

    public static String eB(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.title;
    }

    public static String eC(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.title;
    }

    public static String eD(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.subtitle;
    }

    public static String eE(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.subtitle;
    }

    public static AdMatrixInfo.DownloadTexts eF(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.splashActionBarInfo.downloadTexts;
    }

    public static AdMatrixInfo.DownloadTexts eG(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.splashActionBarInfo.downloadTexts;
    }

    public static boolean eH(AdInfo adInfo) {
        for (AdMatrixInfo.MatrixTag matrixTag : adInfo.adMatrixInfo.tag) {
            if ("playEndClose".equals(matrixTag.type)) {
                return matrixTag.isHide;
            }
        }
        return false;
    }

    public static boolean eI(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoTKInfo.renderType == 1;
    }

    public static int a(boolean z, AdInfo adInfo) {
        if (z) {
            return adInfo.adMatrixInfo.adDataV2.neoTKInfo.renderType;
        }
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.renderType;
    }

    public static boolean eJ(AdInfo adInfo) {
        return (a.bQ(adInfo) || TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.preLandingPageTKInfo.templateId)) ? false : true;
    }

    public static int eK(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.preLandingPageTKInfo.preLandingPageShowType;
    }

    public static String eL(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.videoLiveTKInfo.templateId;
    }

    public static AdMatrixInfo.PreLandingPageTKInfo ec(AdTemplate adTemplate) {
        return e.eO(adTemplate).adMatrixInfo.adDataV2.preLandingPageTKInfo;
    }

    public static boolean ed(AdTemplate adTemplate) {
        return cQ(adTemplate).installedActivateInfo.cardSwitch;
    }

    public static long ee(AdTemplate adTemplate) {
        long j = cQ(adTemplate).installedActivateInfo.showTime;
        if (j > 0) {
            return j;
        }
        return 0L;
    }

    public static boolean eM(AdInfo adInfo) {
        return a.bj(adInfo) && !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.videoImageTKInfo.templateId);
    }

    public static String ef(AdTemplate adTemplate) {
        return cQ(adTemplate).topFloorTKInfo.templateId;
    }

    public static String eg(AdTemplate adTemplate) {
        return cQ(adTemplate).neoTKInfo.templateId;
    }

    public static String eh(AdTemplate adTemplate) {
        return cQ(adTemplate).videoLiveTKInfo.templateId;
    }

    public static String ei(AdTemplate adTemplate) {
        return cQ(adTemplate).innerEcLiveTKInfo.templateId;
    }

    public static String ej(AdTemplate adTemplate) {
        return cQ(adTemplate).videoImageTKInfo.templateId;
    }

    public static String ek(AdTemplate adTemplate) {
        return cQ(adTemplate).fullScreenInfo.templateId;
    }

    public static String el(AdTemplate adTemplate) {
        return cQ(adTemplate).rewardVideoTaskInfo.templateId;
    }

    public static String em(AdTemplate adTemplate) {
        return cQ(adTemplate).splashPlayCardTKInfo.templateId;
    }

    public static String en(AdTemplate adTemplate) {
        return cQ(adTemplate).splashEndCardTKInfo.templateId;
    }

    public static String eo(AdTemplate adTemplate) {
        return cQ(adTemplate).bannerTKInfo.templateId;
    }

    public static String ep(AdTemplate adTemplate) {
        return cQ(adTemplate).interstitialCardInfo.templateId;
    }

    public static String eq(AdTemplate adTemplate) {
        return cQ(adTemplate).confirmTKInfo.templateId;
    }

    public static String er(AdTemplate adTemplate) {
        return cQ(adTemplate).activityTKInfo.templateId;
    }

    public static String es(AdTemplate adTemplate) {
        return cQ(adTemplate).rewardWebTaskCloseInfo.templateId;
    }

    public static String et(AdTemplate adTemplate) {
        return cQ(adTemplate).rewardVideoInteractInfo.templateId;
    }

    public static String eu(AdTemplate adTemplate) {
        return cQ(adTemplate).pushTKInfo.templateId;
    }

    public static String ev(AdTemplate adTemplate) {
        return cQ(adTemplate).preLandingPageTKInfo.templateId;
    }

    public static String ew(AdTemplate adTemplate) {
        return cQ(adTemplate).feedTKCardInfo.templateId;
    }

    public static String ex(AdTemplate adTemplate) {
        return cQ(adTemplate).drawTKCardInfo.templateId;
    }

    public static int ey(AdTemplate adTemplate) {
        return cQ(adTemplate).innerEcAuthInfo.cancelClosureAuthTime;
    }
}
