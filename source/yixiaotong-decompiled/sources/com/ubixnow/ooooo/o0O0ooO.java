package com.ubixnow.ooooo;

import android.text.TextUtils;
import com.ubixnow.core.api.UMNAdConfig;
import com.ubixnow.core.api.UMNConfigUserInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o0O0ooO {
    public static String OooO00o = "";
    public static String OooO0O0 = "";
    public static UMNConfigUserInfo OooO0o0;
    public static List<String> OooO0OO = new ArrayList();
    public static List<String> OooO0Oo = new ArrayList();
    public static String OooO0o = "";
    public static String OooO0oO = "";

    public static void OooO00o(UMNAdConfig uMNAdConfig) {
        try {
            String str = uMNAdConfig.appId;
            if (str != null) {
                OooO00o = str;
            }
            if (TextUtils.isEmpty(OooO0O0)) {
                OooO0O0 = UUID.randomUUID().toString().replace(com.huawei.openalliance.ad.constant.x.A, "");
            }
            UMNConfigUserInfo uMNConfigUserInfo = uMNAdConfig.configUserInfo;
            if (uMNConfigUserInfo != null) {
                OooO0o0 = uMNConfigUserInfo;
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0O0("---pub_init_parameter", "\nsetUserId:" + OooO0o0.getUserId() + "\nsetChannel:" + OooO0o0.getChannel() + "\nsetSubChannel:" + OooO0o0.getSubChannel() + "\nisSubScriber:" + OooO0o0.getSubScriber() + "\nsetPubSegmentId:" + OooO0o0.getPubSegmentId() + "\nsetCustomUserInfo:" + OooO0o0.getCustomUserInfo());
                }
            }
            HashMap<String, String> map = uMNAdConfig.extraMap;
            if (map != null) {
                if (!TextUtils.isEmpty(map.get(com.alipay.sdk.cons.b.b))) {
                    OooO0o = uMNAdConfig.extraMap.get(com.alipay.sdk.cons.b.b);
                }
                if (!TextUtils.isEmpty(uMNAdConfig.extraMap.get("sensor_enabled"))) {
                    OooO0oO = uMNAdConfig.extraMap.get("sensor_enabled");
                }
            }
            if (ooooO000.OooO00o) {
                ooooO000.OooO0O0("---pub_init_parameter", "setDebug:" + uMNAdConfig.isDebug);
                ooooO000.OooO0O0("---pub_init_parameter", "setExtraMap:" + uMNAdConfig.extraMap);
            }
            oOO00O.OooO0O0();
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }
}
