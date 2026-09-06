package com.meishu.sdk.platform;

import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.MSAdConfig;
import com.meishu.sdk.core.e;
import com.meishu.sdk.platform.bd.BDSdkPlatform;
import com.meishu.sdk.platform.csj.CSJSdkPlatform;
import com.meishu.sdk.platform.custom.CustomSdkPlatform;
import com.meishu.sdk.platform.gdt.GDTSdkPlatform;
import com.meishu.sdk.platform.huawei.HWSdkPlatform;
import com.meishu.sdk.platform.jd.JDSdkPlatform;
import com.meishu.sdk.platform.ks.KSSdkPlatform;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class PlatformFactory {
    public static Set<String> ploatforms;

    public static Map<String, e> createAll() {
        HashMap map = new HashMap();
        if (AdSdk.adConfig() != null && AdSdk.adConfig().isUseMediation()) {
            if (AdSdk.getGDTVersionName() != null) {
                map.put(MSAdConfig.PLATFORM_GDT, new GDTSdkPlatform());
            }
            if (AdSdk.getCSJVersionName() != null) {
                map.put(MSAdConfig.PLATFORM_CSJ, new CSJSdkPlatform());
            }
            if (AdSdk.getBDVersionName() != null) {
                map.put(MSAdConfig.PLATFORM_BD, new BDSdkPlatform());
            }
            if (AdSdk.getKSVersionName() != null) {
                map.put("KS", new KSSdkPlatform());
            }
            if (AdSdk.getJDVersionName() != null) {
                map.put("JD", new JDSdkPlatform());
            }
            if (AdSdk.getHWVersionName() != null) {
                map.put("HW", new HWSdkPlatform());
            }
        }
        map.put("CUSTOM", new CustomSdkPlatform());
        map.put("MS", new com.meishu.sdk.platform.ms.e());
        ploatforms = map.keySet();
        return map;
    }
}
