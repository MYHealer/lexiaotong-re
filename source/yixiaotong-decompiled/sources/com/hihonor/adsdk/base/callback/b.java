package com.hihonor.adsdk.base.callback;

import android.content.Context;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.bean.BaseAdInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b {
    private static final String hnadsa = "AdSimplePackNameFilterHandler";

    public static List<BaseAdInfo> hnadsa(List<BaseAdInfo> list) {
        Context context = HnAds.get().getContext();
        if (Objects.isNull(context)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "adDirectDataFilteredByPackName context is null", new Object[0]);
            return new ArrayList();
        }
        if (com.hihonor.adsdk.common.f.f.hnadsa((Collection<?>) list)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "adDirectDataFilteredByPackName adCacheList is empty", new Object[0]);
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        hnadsa(context, arrayList);
        return arrayList;
    }

    private static boolean hnadsb(Context context, BaseAdInfo baseAdInfo) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "filterInstallByPackName filter check start.", new Object[0]);
        if (Objects.isNull(baseAdInfo)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "filterInstallByPackName ad is null.", new Object[0]);
            return false;
        }
        int promotionPurpose = baseAdInfo.getPromotionPurpose();
        if (promotionPurpose != 0 && 4 != promotionPurpose) {
            com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) "PackageName filter check. The ad promotionPurpose is not install, check next ad");
            return false;
        }
        String appPackage = baseAdInfo.getAppPackage();
        boolean zHnadsa = com.hihonor.adsdk.base.j.b.hnadsa(context, appPackage);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "PackageName filter check .packName=" + appPackage + ", isInstall=" + zHnadsa, new Object[0]);
        if (zHnadsa) {
            return true;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "PackageName filter check end.", new Object[0]);
        return false;
    }

    private static void hnadsa(Context context, List<BaseAdInfo> list) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "【Check filter Direct or MiniApp】 , filterDirectByUnInstall start.", new Object[0]);
        if (com.hihonor.adsdk.common.f.f.hnadsa((Collection<?>) list)) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsa, "adDirectDataFilteredByPackName but Ad info list is empty", new Object[0]);
            return;
        }
        Iterator<BaseAdInfo> it = list.iterator();
        while (it.hasNext()) {
            BaseAdInfo next = it.next();
            if (hnadsa(context, next)) {
                it.remove();
            } else if (hnadsb(context, next)) {
                it.remove();
            }
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "【Check filter Direct or MiniApp】 filterDirectByUnInstall end.", new Object[0]);
    }

    private static boolean hnadsa(Context context, BaseAdInfo baseAdInfo) {
        int promotionPurpose = baseAdInfo.getPromotionPurpose();
        if (2 != promotionPurpose && 3 != promotionPurpose) {
            com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("【Check filter Direct or MiniApp】The ad promotionPurpose is not APP_DIRECT, check next ad promotionPurpose=" + promotionPurpose));
            return false;
        }
        String appPackage = baseAdInfo.getAppPackage();
        boolean zHnadsa = com.hihonor.adsdk.base.j.b.hnadsa(context, appPackage);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "【Check filter not Direct and not MiniApp】 AD target is unInstall. isInstall=" + zHnadsa + " packName=" + appPackage + ", promotionPurpose=" + promotionPurpose, new Object[0]);
        if (!zHnadsa) {
            return true;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "【Check filter Direct or MiniApp】 filterDirectByUnInstall end.", new Object[0]);
        return false;
    }
}
