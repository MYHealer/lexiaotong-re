package com.hihonor.adsdk.base.g.j.g;

import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.bean.BaseAdInfo;
import com.hihonor.adsdk.base.bean.EventAdImpl;
import com.hihonor.adsdk.base.bean.InstallNotifyBean;
import com.hihonor.adsdk.base.bean.RewardBean;
import com.hihonor.adsdk.base.download.g;
import com.hihonor.adsdk.base.i.d;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
class a {
    a() {
    }

    static com.hihonor.adsdk.base.g.j.d.h1.a.C0436a hnadsa(String str) {
        return new com.hihonor.adsdk.base.g.j.d.h1.a.C0436a().hnadsh(str);
    }

    static com.hihonor.adsdk.base.g.j.d.h1.a hnadsa(com.hihonor.adsdk.base.g.j.d.h1.a.C0436a c0436a, String str, String str2, int i, int i2) {
        return c0436a.hnadsf(str).hnadsg(str2).hnadsa(Integer.valueOf(i)).hnadsb(Integer.valueOf(i2)).hnadsa();
    }

    static com.hihonor.adsdk.base.g.j.d.h1.a hnadsa(com.hihonor.adsdk.base.g.j.d.h1.a.C0436a c0436a, String str, String str2, int i, int i2, String str3, String str4) {
        return c0436a.hnadsf(str).hnadsg(str2).hnadsa(Integer.valueOf(i)).hnadsb(Integer.valueOf(i2)).hnadsk(str3).hnadsd(str4).hnadsa();
    }

    static com.hihonor.adsdk.base.g.j.d.h1.a hnadsa(com.hihonor.adsdk.base.g.j.d.h1.a.C0436a c0436a, int i, String str, String str2, int i2, int i3, int i4) {
        return c0436a.hnadsa(Integer.valueOf(i)).hnadsg(str).hnadsa(str2).hnadsc(Integer.valueOf(i2)).hnadsd(Integer.valueOf(i3)).hnadsb(Integer.valueOf(i4)).hnadsa();
    }

    static com.hihonor.adsdk.base.g.j.d.h1.a hnadsa(com.hihonor.adsdk.base.g.j.d.h1.a.C0436a c0436a, RewardBean rewardBean) {
        if (Objects.isNull(rewardBean)) {
            return c0436a.hnadsa();
        }
        return c0436a.hnadsa(Integer.valueOf(rewardBean.getAdType())).hnadsg(rewardBean.getAdRequestId()).hnadsa(rewardBean.getAdId()).hnadsb(Integer.valueOf(rewardBean.getDataType())).hnadsb(rewardBean.getAppPackage()).hnadse(rewardBean.getChannelInfo()).hnadsc(rewardBean.getAppVersion()).hnadsi(rewardBean.getTemplateId()).hnadsa();
    }

    static com.hihonor.adsdk.base.g.j.d.h1.a hnadsa(com.hihonor.adsdk.base.g.j.d.h1.a.C0436a c0436a, InstallNotifyBean installNotifyBean) {
        if (Objects.isNull(installNotifyBean)) {
            return c0436a.hnadsa();
        }
        return c0436a.hnadsa(Integer.valueOf(installNotifyBean.getAdType())).hnadsg(installNotifyBean.getRequestId()).hnadsa(installNotifyBean.getAdId()).hnadsc(Integer.valueOf(installNotifyBean.getPkgType())).hnadsd(Integer.valueOf(installNotifyBean.getPromotionPurpose())).hnadsb(Integer.valueOf(installNotifyBean.getDataType())).hnadsb(installNotifyBean.getAppPackage()).hnadsc(installNotifyBean.getAppVersion()).hnadse(installNotifyBean.getChannelInfo()).hnadsi(installNotifyBean.getTemplateId()).hnadsa();
    }

    static com.hihonor.adsdk.base.g.j.d.h1.a hnadsa(com.hihonor.adsdk.base.g.j.d.h1.a.C0436a c0436a, d dVar) {
        if (Objects.isNull(dVar)) {
            return c0436a.hnadsa();
        }
        return c0436a.hnadsa(Integer.valueOf(dVar.hnadsb())).hnadsg(dVar.hnadso()).hnadsa(dVar.hnadsa()).hnadsc(Integer.valueOf(dVar.hnadsm())).hnadsd(Integer.valueOf(dVar.hnadsn())).hnadsb(Integer.valueOf(dVar.hnadsf())).hnadsb(dVar.hnadsl()).hnadsc(dVar.hnadsd()).hnadsi(dVar.hnadsp()).hnadsa();
    }

    static com.hihonor.adsdk.base.g.j.d.h1.a hnadsa(com.hihonor.adsdk.base.g.j.d.h1.a.C0436a c0436a, g gVar) {
        if (Objects.isNull(gVar)) {
            return c0436a.hnadsa();
        }
        return c0436a.hnadsa(Integer.valueOf(gVar.hnadsb())).hnadsg(gVar.g()).hnadsa(gVar.hnadsa()).hnadsc(Integer.valueOf(gVar.d())).hnadsb(Integer.valueOf(gVar.hnadsk())).hnadsb(gVar.hnadsd()).hnadsc(gVar.hnadse()).hnadse(gVar.hnadsg()).hnadsi(gVar.n()).hnadsa();
    }

    static com.hihonor.adsdk.base.g.j.d.h1.a hnadsa(com.hihonor.adsdk.base.g.j.d.h1.a.C0436a c0436a, com.hihonor.adsdk.base.bean.b bVar, String str) {
        if (Objects.isNull(bVar)) {
            return c0436a.hnadsa();
        }
        return c0436a.hnadsa(Integer.valueOf(bVar.hnadsa())).hnadsf(bVar.hnadsg()).hnadsg(str).hnadsb(Integer.valueOf(bVar.hnadsb())).hnadsa();
    }

    static com.hihonor.adsdk.base.g.j.d.h1.a hnadsa(com.hihonor.adsdk.base.g.j.d.h1.a.C0436a c0436a, EventAdImpl eventAdImpl) {
        if (Objects.isNull(eventAdImpl)) {
            return c0436a.hnadsa();
        }
        return c0436a.hnadsa(Integer.valueOf(eventAdImpl.getAdType())).hnadsg(eventAdImpl.getRequestId()).hnadsa(eventAdImpl.getAdId()).hnadsc(Integer.valueOf(eventAdImpl.getPkgType())).hnadsd(Integer.valueOf(eventAdImpl.getPromotionPurpose())).hnadsb(Integer.valueOf(eventAdImpl.getDataType())).hnadsb(eventAdImpl.getAppPackage()).hnadsc(eventAdImpl.getAppVersion()).hnadse(eventAdImpl.getChannelInfo()).hnadsi(eventAdImpl.getTemplateId()).hnadsa();
    }

    static com.hihonor.adsdk.base.g.j.d.h1.a hnadsa(com.hihonor.adsdk.base.g.j.d.h1.a.C0436a c0436a, com.hihonor.adsdk.base.g.j.d.c cVar) {
        if (Objects.isNull(cVar)) {
            return c0436a.hnadsa();
        }
        return c0436a.hnadsa(Integer.valueOf(cVar.hnadsk())).hnadsg(cVar.f()).hnadsa(cVar.hnadsb()).hnadsf(cVar.hnadsx()).hnadsc(Integer.valueOf(cVar.a())).hnadsd(Integer.valueOf(cVar.d())).hnadsj(cVar.n()).hnadsk(cVar.hnadsm()).hnadsd(cVar.hnadso()).hnadsb(cVar.hnadsz()).hnadsc(cVar.hnadsn()).hnadse(cVar.hnadsp()).hnadsa();
    }

    static com.hihonor.adsdk.base.g.j.d.h1.a hnadsa(com.hihonor.adsdk.base.g.j.d.h1.a.C0436a c0436a, BaseAd baseAd) {
        if (Objects.isNull(baseAd)) {
            return c0436a.hnadsa();
        }
        return c0436a.hnadsa(Integer.valueOf(baseAd.getAdType())).hnadsg(baseAd.getRequestId()).hnadsa(baseAd.getAdId()).hnadsc(Integer.valueOf(baseAd.getPkgType())).hnadsd(Integer.valueOf(baseAd.getPromotionPurpose())).hnadsb(Integer.valueOf(baseAd.getDataType())).hnadsb(baseAd.getAppPackage()).hnadsc(baseAd.getAppVersion()).hnadse(baseAd.getChannelInfo()).hnadsi(baseAd.getTemplateId()).hnadsa();
    }

    static com.hihonor.adsdk.base.g.j.d.h1.a hnadsa(com.hihonor.adsdk.base.g.j.d.h1.a.C0436a c0436a, BaseAdInfo baseAdInfo) {
        if (Objects.isNull(baseAdInfo)) {
            return c0436a.hnadsa();
        }
        return c0436a.hnadsa(Integer.valueOf(baseAdInfo.getAdType())).hnadsg(baseAdInfo.getAdRequestId()).hnadsa(baseAdInfo.getAdId()).hnadsc(Integer.valueOf(baseAdInfo.getPkgType())).hnadsd(Integer.valueOf(baseAdInfo.getPromotionPurpose())).hnadsb(Integer.valueOf(baseAdInfo.getDataType())).hnadsb(baseAdInfo.getAppPackage()).hnadsc(baseAdInfo.getAppVersion()).hnadse(baseAdInfo.getChannelInfo()).hnadsi(baseAdInfo.getTemplateId()).hnadsa();
    }
}
