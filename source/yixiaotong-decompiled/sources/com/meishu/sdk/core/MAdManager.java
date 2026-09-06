package com.meishu.sdk.core;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.meishu.sdk.core.utils.PckIdBean;
import com.meishu.sdk.core.utils.f1;
import com.meishu.sdk.core.utils.o;
import com.meishu.sdk.core.utils.q;
import com.meishu.sdk.core.utils.q0;
import com.meishu.sdk.core.utils.x0;
import com.ubixnow.ooooo.o0OO000o;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MAdManager implements IAdManager {
    private static final String TAG = "MsAdManager";

    @Override // com.meishu.sdk.core.IAdManager
    public String getBuyerId(Map<String, Object> map) {
        try {
            if (AdSdk.getContext() == null) {
                Log.d("MeiShuSdk_MsAdManager", "Sdk is not initialized. Please initialize the SDK first.");
                return "";
            }
            HashMap map2 = new HashMap();
            if (map != null) {
                map2.put(o0OO000o.o00O0O0O, map);
            }
            map2.put(Constant.MAP_KEY_UUID, MSAdConfig.initUUID());
            map2.put("msec", String.valueOf(System.currentTimeMillis()));
            map2.put("code", Long.toString(2051303L));
            String str = x0.f4955a;
            map2.put("ver", "20251125");
            map2.put("rext", 1);
            return o.a(map2);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0038  */
    @Override // com.meishu.sdk.core.IAdManager
    public String getSDKInfo(String str) {
        String localOaid;
        try {
            if (AdSdk.getContext() == null) {
                Log.d("MeiShuSdk_MsAdManager", "Sdk is not initialized. Please initialize the SDK first.");
                return "";
            }
            Context context = AdSdk.getContext();
            try {
                if (q.a().a("oaid_e")) {
                    String strA = q.a().a("oaid_e", (String) null);
                    if (TextUtils.isEmpty(strA)) {
                        localOaid = null;
                    } else {
                        localOaid = f1.b(strA);
                    }
                } else {
                    localOaid = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (TextUtils.isEmpty(localOaid)) {
                localOaid = q.a().a("oaid") ? q.a().a("oaid", (String) null) : AdSdk.getSharedPreferences().getString("oaid", null);
            }
            if (TextUtils.isEmpty(localOaid) && Build.MANUFACTURER.equalsIgnoreCase("honor")) {
                localOaid = q.a().a("honor_oaid", (String) null);
            }
            if (TextUtils.isEmpty(localOaid)) {
                localOaid = AdSdk.getLocalOaid();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msec", String.valueOf(System.currentTimeMillis()));
            linkedHashMap.put("pid", str);
            if (!TextUtils.isEmpty(localOaid)) {
                linkedHashMap.put("oaid", localOaid);
            }
            linkedHashMap.put("anid", x0.a(context));
            if (!TextUtils.isEmpty(x0.i(context))) {
                linkedHashMap.put("imsi", x0.i(context));
            }
            if (!TextUtils.isEmpty(x0.h(context))) {
                linkedHashMap.put("hmscore", x0.h(context));
            }
            if (!TextUtils.isEmpty(x0.d(context))) {
                linkedHashMap.put("appstore_ver", x0.d(context));
            }
            if (!TextUtils.isEmpty(x0.b())) {
                linkedHashMap.put("boot_mark", x0.b());
            }
            if (!TextUtils.isEmpty(x0.k())) {
                linkedHashMap.put("update_mark", x0.k());
            }
            PckIdBean pckIdBean = q0.b;
            if (pckIdBean != null) {
                String app_y = pckIdBean.getApp_y();
                String app_n = q0.b.getApp_n();
                if (!TextUtils.isEmpty(app_y)) {
                    if (app_y.startsWith(".")) {
                        app_y = app_y.substring(1);
                    }
                    linkedHashMap.put("app_y", app_y);
                }
                if (!TextUtils.isEmpty(app_n)) {
                    if (app_n.startsWith(".")) {
                        app_n = app_n.substring(1);
                    }
                    linkedHashMap.put("app_n", app_n);
                }
            }
            if (!TextUtils.isEmpty(x0.n(context))) {
                linkedHashMap.put("ua", x0.n(context));
            }
            return o.a(linkedHashMap);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
