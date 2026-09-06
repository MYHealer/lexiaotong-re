package com.hihonor.adsdk.base.init;

import android.text.TextUtils;
import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.net.resp.AdUnitInfo;
import com.hihonor.adsdk.base.net.resp.InitResp;
import com.hihonor.adsdk.base.net.resp.ThirdPlatform;
import com.hihonor.adsdk.common.f.t;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class i {
    private static final String hnadsa = "SdkInitInfoSave";
    private static InitResp hnadsb;
    private static Map<String, AdUnitInfo> hnadsc = new com.hihonor.adsdk.common.safe.a();

    public static boolean hnadsa(InitResp initResp, String str) {
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) "isInitRequest");
        if (initResp == null) {
            com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) "isInitRequest#resp is null");
            return false;
        }
        InitResp.Media media = initResp.media;
        if (media == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsa, "isInitRequest#resp.media is null", new Object[0]);
            return false;
        }
        if (!TextUtils.equals(str, media.mediaId)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "isInitRequest#mediaId is not equals to resp.media.mediaId", new Object[0]);
            return false;
        }
        try {
            long jHnadsf = t.hnadsc().hnadsf(com.hihonor.adsdk.base.c.x1.hnadsc);
            long millis = TimeUnit.MINUTES.toMillis(initResp.media.expire);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (millis > jCurrentTimeMillis - jHnadsf && jCurrentTimeMillis > jHnadsf) {
                com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) "isInitRequest#Local cache has expired");
                return true;
            }
        } catch (AbstractMethodError e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "isInitRequest#error = " + e.getMessage(), new Object[0]);
        }
        return false;
    }

    public static int hnadsc() {
        InitResp.Media media;
        InitResp initResp = hnadsb;
        if (initResp == null || (media = initResp.media) == null) {
            return 0;
        }
        return media.mediaSrc;
    }

    private static void hnadsd() {
        t.hnadsc().hnadsb(com.hihonor.adsdk.base.c.x1.hnadsc, System.currentTimeMillis());
    }

    public static InitResp hnadsb() {
        if (hnadsb == null) {
            synchronized (i.class) {
                if (hnadsb == null) {
                    String strHnadsg = t.hnadsc().hnadsg(com.hihonor.adsdk.base.c.x1.hnadsb);
                    if (!TextUtils.isEmpty(strHnadsg)) {
                        hnadsb = (InitResp) com.hihonor.adsdk.base.j.g.hnadsa(strHnadsg, InitResp.class);
                    }
                }
            }
        }
        return hnadsb;
    }

    public static ThirdPlatform hnadsb(String str) {
        InitResp initRespHnadsb = hnadsb();
        if (initRespHnadsb == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "getThirdMediaId: resp is null", new Object[0]);
            return null;
        }
        List<ThirdPlatform> list = initRespHnadsb.thirdPlatforms;
        if (list == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "getThirdMediaId: resp.thirdPlatforms is null", new Object[0]);
            return null;
        }
        for (ThirdPlatform thirdPlatform : list) {
            if (thirdPlatform.thirdPlatformId.equals(str)) {
                return thirdPlatform;
            }
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "getThirdMediaId: not found", new Object[0]);
        return null;
    }

    public static void hnadsa(InitResp initResp) {
        synchronized (i.class) {
            hnadsb = initResp;
        }
        t.hnadsc().hnadsb(com.hihonor.adsdk.base.c.x1.hnadsb, com.hihonor.adsdk.base.j.g.hnadsa(initResp));
        hnadsd();
        hnadsc.clear();
    }

    public static AdUnitInfo hnadsa(String str) {
        InitResp initRespHnadsb = hnadsb();
        if (initRespHnadsb == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "getAdUnitInfo: resp is null", new Object[0]);
            return null;
        }
        if (hnadsc.containsKey(str)) {
            return hnadsc.get(str);
        }
        List<AdUnitInfo> list = initRespHnadsb.adUnitInfos;
        if (list == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "getAdUnitInfo: resp.adUnitInfos is null", new Object[0]);
            return null;
        }
        if (str == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "getAdUnitInfo: adUnitId is null", new Object[0]);
            return null;
        }
        for (AdUnitInfo adUnitInfo : list) {
            if (adUnitInfo != null && str.equals(adUnitInfo.adUnitId)) {
                hnadsc.put(str, adUnitInfo);
                return adUnitInfo;
            }
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "getAdUnitInfo: not found", new Object[0]);
        return null;
    }

    public static boolean hnadsa(AdSlot adSlot) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "isPolymerizationAdLoad adSlot getRenderType = " + adSlot.getRenderType(), new Object[0]);
        if (adSlot.getRenderType() == 1) {
            return false;
        }
        if (hnadsb() == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "isPolymerizationAdLoad initResp is null", new Object[0]);
            return false;
        }
        AdUnitInfo adUnitInfoHnadsa = hnadsa(adSlot.getSlotId());
        if (adUnitInfoHnadsa == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "isPolymerizationAdLoad adUnitInfo is null", new Object[0]);
            return false;
        }
        List<AdUnitInfo.ThirdAdUnitInfo> list = adUnitInfoHnadsa.thirdAdUnitInfos;
        if (list != null && list.size() != 0) {
            Iterator<AdUnitInfo.ThirdAdUnitInfo> it = adUnitInfoHnadsa.thirdAdUnitInfos.iterator();
            while (it.hasNext()) {
                if (!Objects.equals(it.next().thirdPlatformId, "0")) {
                    com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "isPolymerizationAdLoad thirdAdUnitInfo.thirdPlatformId is not TYPE_HN", new Object[0]);
                    return true;
                }
            }
            return false;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "isPolymerizationAdLoad thirdAdUnitInfos is empty", new Object[0]);
        return false;
    }

    public static int hnadsa() {
        InitResp initResp = hnadsb;
        if (initResp != null && initResp.media != null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "getDpMethod = " + hnadsb.media.dpMethod, new Object[0]);
            return hnadsb.media.dpMethod;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "mInitResp is null getDpMethod = -1", new Object[0]);
        return -1;
    }
}
