package com.hihonor.adsdk.base.g.j.g;

import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.bean.InstallNotifyBean;
import com.hihonor.adsdk.base.bean.RewardBean;
import com.hihonor.adsdk.base.download.g;
import com.hihonor.adsdk.base.i.d;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c {
    public static LinkedHashMap<String, String> hnadsa(g gVar) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(com.hihonor.adsdk.base.g.j.e.a.hnadsm, String.valueOf(gVar.i()));
        linkedHashMap.put(com.hihonor.adsdk.base.g.j.e.a.hnadsn, gVar.hnadsd());
        linkedHashMap.put("app_version", gVar.hnadse());
        linkedHashMap.put(com.hihonor.adsdk.base.g.j.e.a.L0, String.valueOf(gVar.hnadsu()));
        linkedHashMap.put(com.hihonor.adsdk.base.g.j.e.a.D0, String.valueOf(gVar.hnadsy()));
        return linkedHashMap;
    }

    public static LinkedHashMap<String, String> hnadsa(InstallNotifyBean installNotifyBean) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(com.hihonor.adsdk.base.g.j.e.a.hnadsm, String.valueOf(installNotifyBean.getSequence()));
        linkedHashMap.put(com.hihonor.adsdk.base.g.j.e.a.hnadsn, installNotifyBean.getAppPackage());
        linkedHashMap.put("app_version", installNotifyBean.getAppVersion());
        return linkedHashMap;
    }

    public static LinkedHashMap<String, String> hnadsa(d dVar) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(com.hihonor.adsdk.base.g.j.e.a.hnadsm, String.valueOf(dVar.hnadsj()));
        linkedHashMap.put(com.hihonor.adsdk.base.g.j.e.a.hnadsn, dVar.hnadsl());
        linkedHashMap.put("app_version", dVar.hnadsd());
        linkedHashMap.put(com.hihonor.adsdk.base.g.j.e.a.L0, String.valueOf(dVar.hnadsi()));
        return linkedHashMap;
    }

    public static LinkedHashMap<String, String> hnadsa(RewardBean rewardBean) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(com.hihonor.adsdk.base.g.j.e.a.hnadsm, String.valueOf(rewardBean.getSequence()));
        linkedHashMap.put(com.hihonor.adsdk.base.g.j.e.a.hnadsn, rewardBean.getAppPackage());
        linkedHashMap.put("app_version", rewardBean.getAppVersion());
        return linkedHashMap;
    }

    public static LinkedHashMap<String, String> hnadsa(BaseAd baseAd) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(com.hihonor.adsdk.base.g.j.e.a.hnadsm, String.valueOf(baseAd.getSequence()));
        linkedHashMap.put(com.hihonor.adsdk.base.g.j.e.a.hnadse, baseAd.getAdUnitId());
        linkedHashMap.put("ad_type", baseAd.getAdType() + "");
        linkedHashMap.put("request_id", baseAd.getRequestId());
        linkedHashMap.put("ad_id", baseAd.getAdId());
        linkedHashMap.put(com.hihonor.adsdk.base.g.j.e.a.hnadsn, baseAd.getAppPackage());
        linkedHashMap.put("app_version", baseAd.getAppVersion());
        linkedHashMap.put("dataType", String.valueOf(baseAd.getDataType()));
        return linkedHashMap;
    }
}
