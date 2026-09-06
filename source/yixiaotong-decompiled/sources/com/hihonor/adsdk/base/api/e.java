package com.hihonor.adsdk.base.api;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.bean.BaseAdInfo;
import com.hihonor.adsdk.base.bean.RewardBean;
import com.hihonor.adsdk.base.g.j.d.o0;
import com.hihonor.adsdk.base.init.HnAdConfig;
import com.hihonor.adsdk.base.init.HnRewardListener;
import com.hihonor.adsdk.common.f.f;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class e {
    public static final int hnadsd = 0;
    public static final int hnadse = 1;
    public static final int hnadsf = 1;
    public static final int hnadsg = 2;
    public static final int hnadsh = 3;
    public static final int hnadsi = 4;
    public static final int hnadsj = 5;
    public static final int hnadsk = 6;
    private static final String hnadsl = "RewardCenter";
    private static volatile e hnadsm;
    private final Map<String, RewardBean> hnadsa = new HashMap();
    private final Map<String, Boolean> hnadsb = new HashMap();
    private final Map<String, Long> hnadsc = new HashMap();

    public void hnadsb(String str, int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "publishDownloadReward  packageName:" + str + ";action:" + i, new Object[0]);
        if (TextUtils.isEmpty(str)) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsl, "publishDownloadReward packageName == null", new Object[0]);
            return;
        }
        if (!hnadsa(str, i)) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsl, "checkClickTimeValidate invalidate ", new Object[0]);
            return;
        }
        RewardBean rewardBean = this.hnadsa.get(str);
        if (rewardBean == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "publishDownloadReward rewardBean == null", new Object[0]);
            return;
        }
        List<Integer> incentivePoints = rewardBean.getIncentivePoints();
        if (f.hnadsa((Collection<?>) incentivePoints)) {
            this.hnadsa.remove(str);
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "publishDownloadReward All rewards for the corresponding ads have been completed, or there is no corresponding reward list.", new Object[0]);
            return;
        }
        if (!incentivePoints.contains(Integer.valueOf(i))) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "publishDownloadReward There is an incentive list, but there is no incentive point mentioned above.", new Object[0]);
            return;
        }
        HnRewardListener hnRewardListenerHnadsb = hnadsb();
        LinkedHashMap<String, String> linkedHashMapHnadsa = com.hihonor.adsdk.base.g.j.g.c.hnadsa(rewardBean);
        com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(rewardBean);
        if (hnRewardListenerHnadsb == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsl, "publishDownloadReward no hnRewardListener", new Object[0]);
            new o0(linkedHashMapHnadsa, i, ErrorCode.AD_REWARD_PUBLISH_FAIL, ErrorCode.AD_REWARD_DOWNLOAD_PUBLISH_FAIL_MSG, rewardBean.getAdUnitId(), aVarHnadsa).hnadse();
            return;
        }
        new o0(linkedHashMapHnadsa, i, 0, "success", rewardBean.getAdUnitId(), aVarHnadsa).hnadse();
        int iIndexOf = incentivePoints.indexOf(Integer.valueOf(i));
        if (iIndexOf >= 0) {
            incentivePoints.remove(iIndexOf);
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "publishDownloadReward Remaining incentivePoints:" + incentivePoints, new Object[0]);
        if (f.hnadsa((Collection<?>) incentivePoints)) {
            this.hnadsa.remove(str);
            this.hnadsc.remove(str);
        }
        hnRewardListenerHnadsb.onReward(hnadsa(i, rewardBean.getAdUnitId(), rewardBean.getAdRequestId(), rewardBean.getAdId(), rewardBean.getAppPackage()));
    }

    public static e hnadsa() {
        if (hnadsm == null) {
            synchronized (e.class) {
                if (hnadsm == null) {
                    hnadsm = new e();
                }
            }
        }
        return hnadsm;
    }

    public void hnadsa(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "recordClickTime pkgName = " + str, new Object[0]);
        this.hnadsc.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
    }

    private boolean hnadsa(String str, int i) {
        if (i == 1 || i == 6) {
            return true;
        }
        Long l = this.hnadsc.get(str);
        if (l == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, " checkClickTimeValidate clickTimeObj is null " + str, new Object[0]);
            return false;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jLongValue = jElapsedRealtime - l.longValue();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, " checkClickTimeValidate clickTime = " + l + " curTime = " + jElapsedRealtime + "  gapTime = " + jLongValue + "  validateTime=1800000", new Object[0]);
        if (jLongValue <= 1800000) {
            return true;
        }
        this.hnadsc.remove(str);
        return false;
    }

    public void hnadsa(BaseAd baseAd) {
        if (baseAd == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsl, "publishClickAction baseAd ==null", new Object[0]);
            return;
        }
        String str = baseAd.getRequestId() + baseAd.getAdId();
        Boolean bool = this.hnadsb.get(str);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "publishClickAction actionStatus:" + bool, new Object[0]);
        if (bool != null) {
            Boolean bool2 = Boolean.TRUE;
            if (!bool2.equals(bool)) {
                HnRewardListener hnRewardListenerHnadsb = hnadsb();
                LinkedHashMap<String, String> linkedHashMapHnadsa = com.hihonor.adsdk.base.g.j.g.c.hnadsa(baseAd);
                com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(baseAd);
                if (hnRewardListenerHnadsb == null) {
                    com.hihonor.adsdk.common.b.b.hnadse(hnadsl, "publishClickAction no hnRewardListener", new Object[0]);
                    new o0(linkedHashMapHnadsa, 1, ErrorCode.AD_REWARD_PUBLISH_FAIL, ErrorCode.AD_REWARD_CLICK_PUBLISH_FAIL_MSG, baseAd.getAdUnitId(), aVarHnadsa).hnadse();
                    return;
                } else {
                    new o0(linkedHashMapHnadsa, 1, 0, "success", baseAd.getAdUnitId(), aVarHnadsa).hnadse();
                    this.hnadsb.put(str, bool2);
                    hnRewardListenerHnadsb.onReward(hnadsa(1, baseAd.getAdUnitId(), baseAd.getRequestId(), baseAd.getAdId(), baseAd.getAppPackage()));
                    return;
                }
            }
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "publishClickAction No registration incentive or already incentivized", new Object[0]);
    }

    private HnRewardListener hnadsb() {
        HnAdConfig cfg = HnAds.get().getCfg();
        if (cfg == null) {
            return null;
        }
        return cfg.getHnRewardListener();
    }

    private void hnadsb(RewardBean rewardBean) {
        String appPackage = rewardBean.getAppPackage();
        if (f.hnadsa((Collection<?>) rewardBean.getIncentivePoints()) || TextUtils.isEmpty(appPackage)) {
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsl, (Object) "saveDownLoadReward ");
        this.hnadsa.put(appPackage, rewardBean);
    }

    private static Bundle hnadsa(int i, String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        bundle.putInt(com.hihonor.adsdk.base.g.j.e.a.B0, i);
        bundle.putString(com.hihonor.adsdk.base.g.j.e.a.hnadse, str);
        bundle.putString("request_id", str2);
        bundle.putString("ad_id", str3);
        bundle.putString(com.hihonor.adsdk.base.g.j.e.a.hnadsn, str4);
        return bundle;
    }

    public void hnadsa(BaseAdInfo baseAdInfo) {
        if (baseAdInfo == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsl, "registerReward failed because baseAdInfo is null", new Object[0]);
            return;
        }
        this.hnadsa.remove(baseAdInfo.getAppPackage());
        if (baseAdInfo.getIncentiveFlag() != 1) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "registerReward failed because incentiveFlag：" + baseAdInfo.getIncentiveFlag() + ", AdId: " + baseAdInfo.getAdId() + ", AdType: " + baseAdInfo.getAdType(), new Object[0]);
            return;
        }
        RewardBean rewardBean = new RewardBean(baseAdInfo);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "save click or download reward IncentivePoints: :" + f.hnadsb((Collection<?>) rewardBean.getIncentivePoints()) + ", appPackage: " + rewardBean.getAppPackage() + ", isClickReward: " + rewardBean.isClickReward() + ", adReqId: " + rewardBean.getAdRequestId() + ", adId: " + rewardBean.getAdId(), new Object[0]);
        hnadsb(rewardBean);
        hnadsa(rewardBean);
    }

    private void hnadsa(RewardBean rewardBean) {
        String str = rewardBean.getAdRequestId() + rewardBean.getAdId();
        if (!rewardBean.isClickReward() || TextUtils.isEmpty(str)) {
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsl, (Object) ("saveClickReward key:" + str));
        this.hnadsb.put(str, Boolean.FALSE);
    }
}
