package com.hihonor.adsdk.common.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.gson.Gson;
import com.hihonor.adsdk.common.BuildConfig;
import com.hihonor.adsdk.common.f.a0;
import com.hihonor.adsdk.common.f.e0.c;
import com.hihonor.adsdk.common.f.f;
import com.hihonor.adsdk.common.f.t;
import com.hihonor.hm.remoteconfig.RemoteConfigManager;
import com.hihonor.hm.remoteconfig.entity.ConfigItem;
import com.hihonor.hm.remoteconfig.entity.FailureInfo;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.io.encoding.Base64;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b {
    public static final String hnadsa = "SettingConfigHelper";
    private static RemoteConfigManager hnadsd = null;
    private static final String hnadse = "20240813";
    private static final String hnadsf = "com.hihonor.adsdk";
    private static volatile com.hihonor.adsdk.common.safe.a<String, ConfigItem> hnadsj;
    public static Gson hnadso;
    private static final AtomicBoolean hnadsb = new AtomicBoolean(false);
    private static Long hnadsc = 0L;
    private static String hnadsg = "";
    private static String hnadsh = "";
    private static String hnadsi = "";
    private static boolean hnadsk = false;
    private static final byte[] hnadsl = {6, Ascii.FS, 13, Ascii.US, 42, 99, 39, 62, Ascii.EM, 127, 44, 103, 33, 112, 123, 12, 17, Ascii.CAN, 11, 43, 39, 123, 33, Ascii.EM, 0, 121, 6, 1, 5, 49, Ascii.GS, Ascii.DC2, 62, 12, 10, 57, 33, 125, 36, 6, 99, 99, 112, 117};
    private static final byte[] hnadsm = {43, 12, 36, 6, Ascii.US, 6, 46, 39, 9, 44, Ascii.ESC, 5, 34, 59, 4, Ascii.EM, 13, Ascii.DC2, Ascii.CAN};
    private static final byte[] hnadsn = {99, Ascii.ESC, 15, 99, Base64.padSymbol, 15, 3, 39, Base64.padSymbol, 120, 123, 47, Ascii.DC2, 122, 12, 10, Ascii.ESC, Ascii.ESC, 16, 12, 12, 126, Ascii.ESC, 59, 117};

    private static void hnadsb(RemoteConfigManager remoteConfigManager) {
        remoteConfigManager.addCustomAttribute(com.hihonor.adsdk.base.download.marketdownload.a.hnadse, hnadsg);
        remoteConfigManager.addCustomAttribute("sdk_version", BuildConfig.SDK_VERSION);
        remoteConfigManager.addCustomAttribute("app_id", hnadsh);
        remoteConfigManager.addCustomAttribute("oaid", hnadsi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void hnadsc() {
        hnadsa(hnadsd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void hnadsd() {
        hnadsa(hnadsd);
    }

    public static void hnadse() {
        a0.hnadsf(new Runnable() { // from class: com.hihonor.adsdk.common.c.b$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                b.hnadsd();
            }
        });
    }

    public static void hnadsa(Context context, String str, String str2, boolean z) {
        hnadsh = str;
        hnadsi = str2;
        hnadsk = z;
        hnadsa(context, new Random().nextInt(Math.max(a.hnadsi.hnadsb().intValue(), 0)));
    }

    private static synchronized void hnadsb(List<ConfigItem> list) {
        com.hihonor.adsdk.common.safe.a<String, ConfigItem> aVar = new com.hihonor.adsdk.common.safe.a<>();
        for (ConfigItem configItem : list) {
            aVar.put(configItem.getKey(), configItem);
        }
        hnadsj = aVar;
    }

    public static void hnadsa(Context context, int i) {
        hnadsg = context.getPackageName();
        if (hnadsk) {
            hnadsd = RemoteConfigManager.setEnvType(RemoteConfigManager.EnvType.UAT).getInstance(context, hnadse, BuildConfig.SDK_VERSION_CODE, c.hnadsa(hnadsl), hnadsf);
        } else {
            hnadsd = RemoteConfigManager.getInstance(context, hnadse, BuildConfig.SDK_VERSION_CODE, c.hnadsa(hnadsm) + c.hnadsa(hnadsn), hnadsf);
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "is test remote env:" + hnadsk + ",fetch delay:" + i, new Object[0]);
        a0.hnadsb(new Runnable() { // from class: com.hihonor.adsdk.common.c.b$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                b.hnadsc();
            }
        }, i);
        hnadsa((List<ConfigItem>) hnadsd.getAll(), false);
    }

    public static synchronized Gson hnadsb() {
        if (hnadso == null) {
            hnadso = new Gson();
        }
        return hnadso;
    }

    private static boolean hnadsa() {
        hnadsc = Long.valueOf(hnadsc.longValue() > 0 ? hnadsc.longValue() : t.hnadse().hnadsa("LAST_REQUEST_TS", 0L));
        long jCurrentTimeMillis = System.currentTimeMillis() - hnadsc.longValue();
        Integer numHnadsb = a.hnadsj.hnadsb();
        int iIntValue = numHnadsb == null ? 0 : numHnadsb.intValue();
        if (!hnadsk) {
            iIntValue = Math.max(iIntValue, 10);
        }
        long j = ((long) iIntValue) * 1000;
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "duration:" + jCurrentTimeMillis + ",cache valid:" + j, new Object[0]);
        return jCurrentTimeMillis > j;
    }

    public static void hnadsa(RemoteConfigManager remoteConfigManager) {
        if (hnadsa()) {
            if (remoteConfigManager == null) {
                com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "config is null", new Object[0]);
                return;
            }
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "start fetch", new Object[0]);
            hnadsb(remoteConfigManager);
            hnadsc = Long.valueOf(System.currentTimeMillis());
            remoteConfigManager.fetch().addOnSuccessListener(new Function1() { // from class: com.hihonor.adsdk.common.c.b$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return b.hnadsa((List) obj);
                }
            }).addOnFailureListener(new Function1() { // from class: com.hihonor.adsdk.common.c.b$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return b.hnadsa((FailureInfo) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit hnadsa(List list) {
        hnadsb.set(true);
        hnadsa((List<ConfigItem>) list, true);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit hnadsa(FailureInfo failureInfo) {
        com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "fetch fail: " + (failureInfo == null ? "" : failureInfo.getMessage()), new Object[0]);
        return null;
    }

    private static synchronized void hnadsa(List<ConfigItem> list, boolean z) {
        a aVar;
        if (f.hnadsa((Collection<?>) list)) {
            return;
        }
        if (z || !hnadsb.get()) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "onConfigItemProcess: " + list.size() + " isFromServer:" + z, new Object[0]);
            SharedPreferences.Editor editorHnadsb = t.hnadse().hnadsb();
            hnadsb(list);
            for (ConfigItem configItem : list) {
                String key = configItem.getKey();
                String value = configItem.getValue();
                if (!TextUtils.isEmpty(key) && (aVar = a.hnadsh.get(key)) != null) {
                    hnadsa(aVar, configItem);
                    if (aVar.hnadsd() && z && editorHnadsb != null) {
                        editorHnadsb.putString(key, value);
                    }
                }
            }
            if (editorHnadsb != null && z) {
                editorHnadsb.putLong("LAST_REQUEST_TS", System.currentTimeMillis());
                editorHnadsb.apply();
            }
        }
    }

    public static void hnadsa(a aVar, ConfigItem configItem) {
        aVar.hnadsd = configItem.getGroupName();
        if (aVar.hnadsc()) {
            aVar.hnadsa(hnadsb(), configItem.getValue());
        } else {
            aVar.hnadsa(configItem.getValue());
        }
    }

    public static void hnadsa(a aVar) {
        ConfigItem configItem;
        com.hihonor.adsdk.common.safe.a<String, ConfigItem> aVar2 = hnadsj;
        if (aVar2 == null || aVar2.isEmpty()) {
            return;
        }
        String str = aVar.hnadsa;
        if (TextUtils.isEmpty(str) || (configItem = aVar2.get(str)) == null) {
            return;
        }
        hnadsa(aVar, configItem);
    }
}
