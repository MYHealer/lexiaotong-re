package com.hihonor.adsdk.base.api;

import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.init.i;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class d {
    private static final String hnadsa = "LoadStrategy";

    public static IAdLoad hnadsa(AdSlot adSlot, IAdLoad iAdLoad, IAdLoad iAdLoad2) {
        boolean zHnadsa = i.hnadsa(adSlot);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "isPolymerizationAdLoad = " + zHnadsa, new Object[0]);
        return zHnadsa ? iAdLoad2 : iAdLoad;
    }
}
