package com.hihonor.adsdk.base.mediation.core.imp;

import android.content.Context;
import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.init.i;
import com.hihonor.adsdk.base.mediation.adn.AdnConfig;
import com.hihonor.adsdk.base.net.resp.AdUnitInfo;
import com.hihonor.adsdk.base.net.resp.ThirdPlatform;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class d {
    private static final String hnadsa = "HandleInitInfoManager";

    private static final class a {
        private static final d hnadsa = new d();

        private a() {
        }
    }

    public static d hnadsa() {
        return a.hnadsa;
    }

    private String hnadsb() {
        Context context = HnAds.get().getContext();
        String packageName = context != null ? context.getPackageName() : "";
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("packageName = " + packageName));
        return packageName;
    }

    public List<com.hihonor.adsdk.base.mediation.core.imp.a> hnadsa(AdSlot adSlot, int i) {
        AdUnitInfo adUnitInfoHnadsa = i.hnadsa(adSlot.getSlotId());
        if (adUnitInfoHnadsa == null) {
            com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) "adUnitInfo is null");
            return null;
        }
        List<AdUnitInfo.ThirdAdUnitInfo> list = adUnitInfoHnadsa.thirdAdUnitInfos;
        if (list != null) {
            return hnadsa(adSlot, list, i);
        }
        return null;
    }

    private List<com.hihonor.adsdk.base.mediation.core.imp.a> hnadsa(AdSlot adSlot, List<AdUnitInfo.ThirdAdUnitInfo> list, int i) {
        ArrayList arrayList = new ArrayList();
        for (AdUnitInfo.ThirdAdUnitInfo thirdAdUnitInfo : list) {
            String str = thirdAdUnitInfo.thirdPlatformId;
            ThirdPlatform thirdPlatformHnadsb = i.hnadsb(str);
            String str2 = thirdPlatformHnadsb != null ? thirdPlatformHnadsb.thirdMediaId : "";
            String str3 = thirdAdUnitInfo.thirdAdUnitId;
            int i2 = thirdAdUnitInfo.level;
            com.hihonor.adsdk.base.mediation.core.imp.a aVar = new com.hihonor.adsdk.base.mediation.core.imp.a();
            aVar.hnadse(str);
            aVar.hnadsc(str2);
            aVar.hnadsd(hnadsa(str));
            aVar.hnadsf(hnadsb());
            aVar.hnadsg("");
            aVar.hnadsb(str3);
            aVar.hnadse(i2);
            aVar.hnadsc(i);
            aVar.hnadsa(adSlot.getAdContext());
            aVar.hnadsa(adSlot.getAdCount());
            aVar.hnadsd(adSlot.getWidth());
            aVar.hnadsb(adSlot.getHeight());
            aVar.hnadsa(adSlot.getTimeOutMillis());
            aVar.hnadsf(adSlot.getLoadType());
            aVar.hnadsj(adSlot.getSlotId());
            aVar.hnadsa(adSlot.getRewardAmount());
            aVar.hnadsi(adSlot.getRewardName());
            arrayList.add(aVar);
        }
        return arrayList;
    }

    private String hnadsa(String str) {
        if (str.equals("1")) {
            return AdnConfig.a.hnadsb;
        }
        if (str.equals("0")) {
            return AdnConfig.a.hnadsa;
        }
        return str.equals("2") ? AdnConfig.a.hnadsc : "";
    }
}
