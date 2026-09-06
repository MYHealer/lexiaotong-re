package com.hihonor.hianalytics.util;

import android.content.Context;
import android.text.TextUtils;
import com.hihonor.hianalytics.hnha.j2;
import com.huawei.openalliance.ad.constant.x;
import com.tencent.mmkv.MMKV;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class m {
    public static String a(Context context, String str) {
        StringBuilder sb = new StringBuilder("hianalytics_");
        sb.append(str).append("_mmkv_");
        String strH = com.hihonor.hianalytics.hnha.g.h();
        if (strH != null && strH.trim().length() > 0) {
            sb.append(strH.trim()).append("_");
        }
        String processName = SystemUtils.getProcessName();
        sb.append(processName.trim().length() > 0 ? processName.replace(x.bQ, "_") : context.getPackageName());
        return sb.toString();
    }

    public static String a(String str, String str2, String str3) throws IllegalAccessException, InvocationTargetException {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            j2.b("MMKVUtils", "getString illegal spKey=" + str2 + ",spName=" + str);
            return str3;
        }
        MMKV mmkvB = b(str);
        return mmkvB != null ? mmkvB.getString(str2, str3) : str3;
    }

    public static Set<String> a(MMKV mmkv) {
        String[] strArrAllKeys = mmkv.allKeys();
        return (strArrAllKeys == null || strArrAllKeys.length == 0) ? new HashSet() : new HashSet(Arrays.asList(strArrAllKeys));
    }

    private static void a(MMKV mmkv, Set<String> set, Map<String, String> map) {
        for (String str : set) {
            map.put(str, mmkv.getString(str, ""));
        }
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            j2.g("MMKVUtils", "clearTypeDataByTag emptyTag=" + str);
            return;
        }
        if (!"_default_config_tag".equals(str)) {
            String str2 = str + "-oper";
            String str3 = str + "-maint";
            str = str + "-diffprivacy";
            a(str2, false);
            a(str3, false);
        }
        a(str, false);
    }

    public static synchronized void a(String str, boolean z) {
        j2.a("MMKVUtils", "clearDataFile tag=" + str + ",isClearAll=" + z);
        MMKV mmkvB = b("stat_v2_1");
        if (mmkvB != null) {
            long jActualSize = mmkvB.actualSize();
            if (z) {
                mmkvB.clearAll();
                mmkvB.trim();
                mmkvB.clearMemoryCache();
                mmkvB.close();
            } else {
                mmkvB.remove(str);
                mmkvB.trim();
            }
            j2.a("MMKVUtils", "clearDataFile stat_v2_1 data preSize=" + jActualSize + ",nowSize=" + mmkvB.actualSize());
        }
        MMKV mmkvB2 = b("cached_v2_1");
        if (mmkvB2 != null) {
            long jActualSize2 = mmkvB2.actualSize();
            if (z) {
                mmkvB2.clearAll();
                mmkvB2.trim();
                mmkvB2.clearMemoryCache();
                mmkvB2.close();
            } else {
                mmkvB2.remove(str);
                mmkvB2.trim();
            }
            j2.a("MMKVUtils", "clearDataFile cached_v2_1 data preSize=" + jActualSize2 + ",nowSize=" + mmkvB2.actualSize());
        }
        MMKV mmkvB3 = b("common_nc");
        if (mmkvB3 != null) {
            long jActualSize3 = mmkvB3.actualSize();
            if (z) {
                mmkvB3.clearAll();
                mmkvB3.trim();
                mmkvB3.clearMemoryCache();
                mmkvB3.close();
            }
            j2.a("MMKVUtils", "clearDataFile common_nc data preSize=" + jActualSize3 + ",nowSize=" + mmkvB3.actualSize());
        }
    }

    public static MMKV b(String str) throws IllegalAccessException, InvocationTargetException {
        Context context = SystemUtils.getContext();
        if (context != null) {
            return MMKV.mmkvWithID(a(context, str), 2);
        }
        j2.b("MMKVUtils", "getSPName context is null");
        return null;
    }

    public static Map<String, String> b(MMKV mmkv) {
        Set<String> setA = a(mmkv);
        HashMap map = new HashMap(setA.size());
        a(mmkv, setA, map);
        return map;
    }
}
