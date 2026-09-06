package com.kwad.sdk.core.response.helper;

import android.text.TextUtils;
import com.kwad.sdk.api.model.KsLiveInfo;
import com.kwad.sdk.api.model.liveModel.KsCouponInfo;
import com.kwad.sdk.api.model.liveModel.KsLiveBaseInfo;
import com.kwad.sdk.api.model.liveModel.KsLiveShopInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.service.ServiceProvider;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class e {
    private static g Ny() {
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        if (fVar != null) {
            return fVar.Ai();
        }
        return null;
    }

    public static boolean eG(AdTemplate adTemplate) {
        return (adTemplate.realShowType != 2 || adTemplate.adInfoList.isEmpty() || adTemplate.adInfoList.get(0) == null) ? false : true;
    }

    public static long eH(AdTemplate adTemplate) {
        return adTemplate.posId;
    }

    public static int eI(AdTemplate adTemplate) {
        return adTemplate.adStyle;
    }

    @Deprecated
    public static int eJ(AdTemplate adTemplate) {
        if (adTemplate != null) {
            return (adTemplate.mAdScene == null || adTemplate.mAdScene.adStyle == 0) ? eI(adTemplate) : adTemplate.mAdScene.getAdStyle();
        }
        return 0;
    }

    public static int eK(AdTemplate adTemplate) {
        return adTemplate.contentType;
    }

    public static long eL(AdTemplate adTemplate) {
        return adTemplate.llsid;
    }

    public static String eM(AdTemplate adTemplate) {
        return adTemplate.extra;
    }

    public static String eN(AdTemplate adTemplate) {
        return adTemplate.impAdExtra;
    }

    public static AdInfo eO(AdTemplate adTemplate) {
        AdInfo adInfo = adTemplate.adInfoList.size() > 0 ? adTemplate.adInfoList.get(0) : null;
        if (adInfo != null) {
            return adInfo;
        }
        com.kwad.sdk.core.d.c.e("AdTemplateHelper", "adInfo in null");
        return new AdInfo();
    }

    public static PhotoInfo eP(AdTemplate adTemplate) {
        return adTemplate.photoInfo;
    }

    public static String eQ(AdTemplate adTemplate) {
        if (eG(adTemplate)) {
            return a.M(eO(adTemplate));
        }
        return h.a(eP(adTemplate));
    }

    public static String eR(AdTemplate adTemplate) {
        return eO(adTemplate).adConversionInfo.appDownloadUrl;
    }

    public static String eS(AdTemplate adTemplate) {
        g gVarNy = Ny();
        String strND = gVarNy == null ? "" : gVarNy.ND();
        return TextUtils.isEmpty(strND) ? strND : a.ab(eO(adTemplate));
    }

    public static String eT(AdTemplate adTemplate) {
        if (eG(adTemplate)) {
            return a.cv(eO(adTemplate));
        }
        g gVarNy = Ny();
        return gVarNy == null ? "" : gVarNy.NE();
    }

    public static long eU(AdTemplate adTemplate) {
        if (eG(adTemplate)) {
            return a.ae(eO(adTemplate));
        }
        g gVarNy = Ny();
        return gVarNy == null ? adTemplate.hashCode() : gVarNy.NF();
    }

    public static int eV(AdTemplate adTemplate) {
        g gVarNy = Ny();
        if (gVarNy == null) {
            return 0;
        }
        return gVarNy.NG();
    }

    public static boolean n(AdTemplate adTemplate, boolean z) {
        if (adTemplate == null) {
            return false;
        }
        AdInfo adInfoEO = eO(adTemplate);
        return a.aL(adInfoEO) && !a.de(adInfoEO) && !z && eW(adTemplate) == 2;
    }

    public static boolean S(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return false;
        }
        AdInfo adInfoEO = eO(adTemplate);
        return (a.aL(adInfoEO) || a.de(adInfoEO) || eW(adTemplate) != 3) ? false : true;
    }

    public static int eW(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return -1;
        }
        return eO(adTemplate).adBaseInfo.taskType;
    }

    public static String eX(AdTemplate adTemplate) {
        if (eG(adTemplate)) {
            return a.cP(eO(adTemplate));
        }
        return h.c(eP(adTemplate));
    }

    public static long eY(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return 0L;
        }
        return eO(adTemplate).adBaseInfo.creativeId;
    }

    public static boolean eZ(AdTemplate adTemplate) {
        return eO(adTemplate).adConversionInfo.blockCallbackIfSpam && adTemplate.mCheatingFlow;
    }

    public static boolean fa(AdTemplate adTemplate) {
        int iO = o(adTemplate, true);
        return iO == 1 || iO == 2;
    }

    public static boolean fb(AdTemplate adTemplate) {
        int iO = o(adTemplate, false);
        return iO == 1 || iO == 2;
    }

    public static int o(AdTemplate adTemplate, boolean z) {
        int i;
        AdInfo adInfoEO = eO(adTemplate);
        if (!fi(adTemplate)) {
            return adInfoEO.adBaseInfo.mABParams.playableStyle;
        }
        if (z) {
            i = adInfoEO.adMatrixInfo.adDataV2.actionBarInfo.cardType;
        } else {
            i = adInfoEO.adMatrixInfo.adDataV2.endCardInfo.cardType;
        }
        if (i == 5) {
            return 1;
        }
        return i == 6 ? 2 : -1;
    }

    public static AdTemplate a(List<AdTemplate> list, long j, int i) {
        if (j >= 0 && list != null) {
            for (AdTemplate adTemplate : list) {
                if (b(adTemplate, j, i)) {
                    return adTemplate;
                }
            }
        }
        return null;
    }

    public static boolean b(List<AdTemplate> list, long j, int i) {
        AdTemplate adTemplateA = a(list, j, i);
        if (adTemplateA == null) {
            return false;
        }
        long jEY = eY(adTemplateA);
        int iEI = eI(adTemplateA);
        if (i > 0) {
            if (jEY != j || iEI != i) {
                return false;
            }
        } else if (jEY != j) {
            return false;
        }
        return true;
    }

    public static boolean b(AdTemplate adTemplate, long j, int i) {
        long jEY = eY(adTemplate);
        int iEI = eI(adTemplate);
        if (i > 0) {
            if (jEY == j && iEI == i) {
                return true;
            }
        } else if (jEY == j) {
            return true;
        }
        return false;
    }

    public static int fc(AdTemplate adTemplate) {
        return eO(adTemplate).adBaseInfo.ecpm;
    }

    public static boolean fd(AdTemplate adTemplate) {
        AdInfo adInfoEO = eO(adTemplate);
        return adInfoEO.adStyleConfInfo.adPushDownloadJumpType == 0 && eI(adTemplate) == 17 && a.aL(adInfoEO);
    }

    public static int fe(AdTemplate adTemplate) {
        if (adTemplate.adVideoPreCacheConfig == null) {
            com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
            if (hVar != null) {
                return hVar.Ga();
            }
            return 800;
        }
        return adTemplate.adVideoPreCacheConfig.adVideoPreCacheSize;
    }

    public static KsLiveInfo ff(AdTemplate adTemplate) {
        AdInfo adInfoEO = eO(adTemplate);
        if (adInfoEO.adBaseInfo.roiType == 0) {
            return null;
        }
        KsLiveInfo ksLiveInfo = new KsLiveInfo();
        ksLiveInfo.setRoiType(adInfoEO.adBaseInfo.roiType);
        KsLiveBaseInfo ksLiveBaseInfo = ksLiveInfo.getKsLiveBaseInfo();
        if (adInfoEO.advertiserInfo.userName != null) {
            ksLiveBaseInfo.setUserName(adInfoEO.advertiserInfo.userName);
        }
        if (adInfoEO.advertiserInfo.portraitUrl != null) {
            ksLiveBaseInfo.setPortraitUrl(adInfoEO.advertiserInfo.portraitUrl);
        }
        if (adInfoEO.adBaseInfo.liveDisplayWatchingCount > 0) {
            ksLiveBaseInfo.setLiveDisplayWatchingCount(adInfoEO.adBaseInfo.liveDisplayWatchingCount);
        }
        KsLiveShopInfo ksLiveShopInfo = new KsLiveShopInfo();
        AdProductInfo adProductInfo = adInfoEO.adProductInfo;
        ksLiveShopInfo.setIcon(adProductInfo.icon);
        ksLiveShopInfo.setName(adProductInfo.name);
        ksLiveShopInfo.setPrice(adProductInfo.price);
        ksLiveShopInfo.setOriginPrice(adProductInfo.originPrice);
        ksLiveShopInfo.setVolume(adProductInfo.volume);
        if (adProductInfo.couponList != null && adProductInfo.couponList.size() > 0) {
            ksLiveShopInfo.setHaveCoupon(true);
        }
        ksLiveInfo.getKsLiveShopInfo().add(ksLiveShopInfo);
        KsCouponInfo ksCouponInfo = new KsCouponInfo();
        CouponInfo firstCouponList = adProductInfo.getFirstCouponList();
        if (firstCouponList != null) {
            ksCouponInfo.setDisplayBase(firstCouponList.displayBase);
            ksCouponInfo.setDisplayType(firstCouponList.displayType);
            ksCouponInfo.setDisplayValue(firstCouponList.displayValue);
            ksCouponInfo.setEndFetchTime(firstCouponList.endFetchTime);
            ksCouponInfo.setStartFetchTime(firstCouponList.startFetchTime);
            ksLiveInfo.getKsCouponInfo().add(ksCouponInfo);
        }
        return ksLiveInfo;
    }

    public static int fg(AdTemplate adTemplate) {
        return eO(adTemplate).adBaseInfo.adRolloutSize;
    }

    public static boolean fh(AdTemplate adTemplate) {
        int iEI = eI(adTemplate);
        if (iEI == 13) {
            return true;
        }
        return iEI == 23 && fg(adTemplate) == 2;
    }

    public static boolean fi(AdTemplate adTemplate) {
        int iEI = eI(adTemplate);
        if (iEI == 3) {
            return true;
        }
        return iEI == 23 && fg(adTemplate) == 1;
    }

    public static int fj(AdTemplate adTemplate) {
        return adTemplate.type;
    }

    public static int fk(AdTemplate adTemplate) {
        return adTemplate.defaultType;
    }

    public static long fl(AdTemplate adTemplate) {
        return eO(adTemplate).adProductInfo.itemId;
    }

    public static boolean fm(AdTemplate adTemplate) {
        return (adTemplate == null || adTemplate.liveInfo == null || adTemplate.liveInfo.playInfo == null) ? false : true;
    }
}
