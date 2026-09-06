package com.huawei.hms.stats;

import android.content.Context;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hms.utils.HMSBIInitializer;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: HiAnalyticsOfCpUtils.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HiAnalyticsInstance f4389a;

    public static HiAnalyticsInstance a(Context context) {
        HiAnalyticsInstance analyticsInstance = HMSBIInitializer.getInstance(context).getAnalyticsInstance();
        f4389a = analyticsInstance;
        return analyticsInstance;
    }

    public static void b(Context context, int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (a(context) != null) {
            f4389a.onStreamEvent(i, str, linkedHashMap);
        }
    }

    public static void a(Context context, String str, String str2) {
        if (a(context) != null) {
            f4389a.onEvent(context, str, str2);
        }
    }

    public static void a(Context context, int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (a(context) != null) {
            f4389a.onEvent(i, str, linkedHashMap);
        }
    }

    public static void a(Context context, int i) {
        if (a(context) != null) {
            f4389a.onReport(i);
        }
    }
}
