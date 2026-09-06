package com.hihonor.adsdk.base.callback.filter;

import android.text.TextUtils;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.bean.BaseAdInfo;
import com.hihonor.adsdk.base.bean.EventAdImpl;
import com.hihonor.adsdk.base.bean.Video;
import com.hihonor.adsdk.base.download.d;
import com.hihonor.adsdk.base.g.j.d.s0;
import com.hihonor.adsdk.base.g.k.c.t;
import com.hihonor.adsdk.common.b.b;
import com.hihonor.adsdk.common.f.f;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a extends com.hihonor.adsdk.base.callback.a {
    private static final String hnadsa = "AdPackNameFilterHandler";

    private void hnadsb(int i, BaseAdInfo baseAdInfo, ResFilterBean resFilterBean, Iterator<BaseAdInfo> it) {
        b.hnadsc(hnadsa, "【Check filter Direct or MiniApp】 , filterDirectByUnInstall start.", new Object[0]);
        String appPackage = baseAdInfo.getAppPackage();
        boolean zHnadsa = com.hihonor.adsdk.base.j.b.hnadsa(HnAds.get().getContext(), appPackage);
        b.hnadsc(hnadsa, "【Check filter Direct or MiniApp】 AD target is unInstall. isInstall=" + zHnadsa + " packName=" + appPackage + ", promotionPurpose=" + i, new Object[0]);
        EventAdImpl eventAdImpl = new EventAdImpl(baseAdInfo);
        if (!zHnadsa) {
            new t(ErrorCode.AD_PACK_UN_INSTALLED, ErrorCode.STR_AD_PACK_UN_INSTALLED).hnadsa(eventAdImpl, eventAdImpl.getTrackUrl().getCommons());
            new s0(ErrorCode.AD_PACK_UN_INSTALLED, ErrorCode.STR_AD_PACK_UN_INSTALLED, eventAdImpl.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(eventAdImpl)).hnadse();
            AdFilteringLog.info(AdFilteringLog.FILTER_TYPE_HN, "【Check filter Direct or MiniApp】The AD target is unInstall", "AdId:" + baseAdInfo.getAdId(), "AdRequestId:" + baseAdInfo.getAdRequestId(), "PromotionPurpose:" + baseAdInfo.getPromotionPurpose(), "ErrCode:30066", "PackName:" + baseAdInfo.getAppPackage());
            resFilterBean.addListResultsData(new FilterAd(ErrorCode.AD_PACK_UN_INSTALLED, baseAdInfo.getAdId(), appPackage, i));
            it.remove();
        }
        b.hnadsc(hnadsa, "【Check filter Direct or MiniApp】 filterDirectByUnInstall end.", new Object[0]);
    }

    private void hnadsc(int i, BaseAdInfo baseAdInfo, ResFilterBean resFilterBean, Iterator<BaseAdInfo> it) {
        b.hnadsc(hnadsa, "filterInstallByPackName filter check start.", new Object[0]);
        String appPackage = baseAdInfo.getAppPackage();
        boolean zHnadsa = com.hihonor.adsdk.base.j.b.hnadsa(HnAds.get().getContext(), appPackage);
        b.hnadsc(hnadsa, "PackageName filter check .packName=" + appPackage + ", isInstall=" + zHnadsa, new Object[0]);
        EventAdImpl eventAdImpl = new EventAdImpl(baseAdInfo);
        com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(eventAdImpl);
        if (zHnadsa) {
            new t(ErrorCode.HI_AD_PACK_INSTALLED, ErrorCode.REPORT_AD_PACK_HI_AD_PACK_INSTALLED).hnadsa(eventAdImpl, eventAdImpl.getTrackUrl().getCommons());
            new s0(ErrorCode.HI_AD_PACK_INSTALLED, "", eventAdImpl.getAdUnitId(), aVarHnadsa).hnadse();
            AdFilteringLog.info(AdFilteringLog.FILTER_TYPE_HN, "PackageName filter check AD package is install. ", "AdId:" + baseAdInfo.getAdId(), "AdRequestId:" + baseAdInfo.getAdRequestId(), "PromotionPurpose:" + baseAdInfo.getPromotionPurpose(), "ErrCode:30011", "PackName:" + baseAdInfo.getAppPackage());
            resFilterBean.addListResultsData(new FilterAd(ErrorCode.HI_AD_PACK_INSTALLED, baseAdInfo.getAdId(), appPackage, i));
            it.remove();
            return;
        }
        if (baseAdInfo.getInstallPkgType() != 0 || d.hnadsa().hnadsb(baseAdInfo.getPkgType())) {
            return;
        }
        int iHnadsa = hnadsa(baseAdInfo.getPkgType());
        new t(iHnadsa, ErrorCode.c.hnadsj).hnadsa(eventAdImpl, eventAdImpl.getTrackUrl().getCommons());
        new s0(iHnadsa, "", eventAdImpl.getAdUnitId(), aVarHnadsa).hnadse();
        AdFilteringLog.info(AdFilteringLog.FILTER_TYPE_HN, "PackageName filter check AD package uninstall but DownloadInstallClient or MarketDownLoadDIClient is false. ", "AD packName is NON_PRE_INSTALLED. ", "AdId:" + baseAdInfo.getAdId(), "AdRequestId:" + baseAdInfo.getAdRequestId(), "PromotionPurpose:" + baseAdInfo.getPromotionPurpose(), "pkgType:" + baseAdInfo.getPkgType(), "ErrCode:" + iHnadsa, "PackName:" + baseAdInfo.getAppPackage());
        resFilterBean.addListResultsData(new FilterAd(iHnadsa, baseAdInfo.getAdId(), appPackage, i));
        it.remove();
    }

    @Override // com.hihonor.adsdk.base.callback.a
    public void hnadsa(ResFilterBean resFilterBean) {
        b.hnadsc(hnadsa, "AdPackNameFilterHandler , filterData start.", new Object[0]);
        if (Objects.isNull(resFilterBean) || f.hnadsa((Collection<?>) resFilterBean.getListSourceData())) {
            b.hnadse(hnadsa, "filterData, resFilterBean is null: " + (resFilterBean == null) + "or getListSourceData is isEmpty", new Object[0]);
            return;
        }
        Iterator<BaseAdInfo> it = resFilterBean.getListSourceData().iterator();
        while (it.hasNext()) {
            BaseAdInfo next = it.next();
            if (Objects.isNull(next)) {
                b.hnadse(hnadsa, "filterData, baseAdInfo is null", new Object[0]);
            } else if (!hnadsa(next.getSubType(), next, resFilterBean, it)) {
                int promotionPurpose = next.getPromotionPurpose();
                if ((2 == promotionPurpose && next.getUninstalleFilter() != 2) || 3 == promotionPurpose) {
                    hnadsb(promotionPurpose, next, resFilterBean, it);
                } else if (promotionPurpose == 0 || 4 == promotionPurpose) {
                    hnadsc(promotionPurpose, next, resFilterBean, it);
                }
            }
        }
    }

    private boolean hnadsa(int i, BaseAdInfo baseAdInfo, ResFilterBean resFilterBean, Iterator<BaseAdInfo> it) {
        Video video;
        b.hnadsc(hnadsa, "AdTypeVideoFilterHandler, filter sta.", new Object[0]);
        if ((i != 13 && i != 11 && i != 12 && i != 14) || ((video = baseAdInfo.getVideo()) != null && !TextUtils.isEmpty(video.getVideoUrl()) && video.getVideoWidth() != 0 && video.getVideoHeight() != 0)) {
            b.hnadsc(hnadsa, "AdTypeVideoFilterHandler, filter end.", new Object[0]);
            return false;
        }
        resFilterBean.addListResultsData(new FilterAd(ErrorCode.HI_AD_VIDEO_INVALID, baseAdInfo.getAdId(), baseAdInfo.getAppPackage(), baseAdInfo.getPromotionPurpose()));
        AdFilteringLog.info(AdFilteringLog.FILTER_TYPE_HN, "AD video is null. ", "AdId:" + baseAdInfo.getAdId(), "AdRequestId:" + baseAdInfo.getAdRequestId(), "PromotionPurpose:" + baseAdInfo.getPromotionPurpose(), "ErrCode:30071", "PackName:" + baseAdInfo.getAppPackage());
        it.remove();
        EventAdImpl eventAdImpl = new EventAdImpl(baseAdInfo);
        new t(ErrorCode.HI_AD_VIDEO_INVALID, ErrorCode.REPORT_AD_VIDEO_INVALID).hnadsa(eventAdImpl, eventAdImpl.getTrackUrl().getCommons());
        new s0(ErrorCode.HI_AD_VIDEO_INVALID, "", eventAdImpl.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(eventAdImpl)).hnadse();
        return true;
    }

    private int hnadsa(int i) {
        b.hnadsc(hnadsa, "AdPackNameFilterHandler getErrorCode pkgType = %d", Integer.valueOf(i));
        return i == 2 ? ErrorCode.AD_DOWN_LOAD_MARKET_VERSION_SUPPORT_NO : ErrorCode.c.hnadsi;
    }
}
