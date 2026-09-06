package com.hihonor.adsdk.base.j;

import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.init.HnAdConfig;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class i {
    private static final String hnadsa = "PermissionCheck";

    public static boolean hnadsa() {
        if (hnadsc()) {
            return HnAds.get().getCfg().getCustomController().isCanGetAllPackages();
        }
        return false;
    }

    public static boolean hnadsb() {
        if (hnadsc()) {
            return HnAds.get().getCfg().getCustomController().isCanUseLocation();
        }
        return false;
    }

    public static boolean hnadsc() {
        HnAdConfig cfg = HnAds.get().getCfg();
        if (cfg == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "isConfigValidate() config is null ;return false", new Object[0]);
            return false;
        }
        if (cfg.getCustomController() != null) {
            return true;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "isConfigValidate() customController is null ;return false", new Object[0]);
        return false;
    }
}
