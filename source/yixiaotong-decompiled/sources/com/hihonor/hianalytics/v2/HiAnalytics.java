package com.hihonor.hianalytics.v2;

import android.content.Context;
import com.hihonor.hianalytics.hnha.a2;
import com.hihonor.hianalytics.process.HiAnalyticsInstance;
import com.hihonor.hianalytics.process.HiAnalyticsManager;
import com.hihonor.hianalytics.util.SystemUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
@Deprecated
public abstract class HiAnalytics {
    private static HiAnalyticsInstance defaultInstance;

    public static void clearCachedData() {
        HiAnalyticsManager.clearCachedData();
    }

    public static void clearDefaultData() {
        if (getDefaultInstance() != null) {
            defaultInstance.clearData();
        }
    }

    private static synchronized HiAnalyticsInstance getDefaultInstance() {
        if (defaultInstance == null) {
            defaultInstance = HiAnalyticsManager.getInstanceByTag("_default_config_tag");
        }
        return defaultInstance;
    }

    public static boolean getInitFlag() {
        return HiAnalyticsManager.getInitFlag("_default_config_tag");
    }

    public static void handleV1Cache() throws IllegalAccessException, InvocationTargetException {
        if (SystemUtils.a()) {
            a2.a("_default_config_tag");
        }
    }

    public static void newInstanceUUID() {
        if (getDefaultInstance() != null) {
            defaultInstance.newInstanceUUID();
        }
    }

    public static void onBackground(long j) {
        if (getDefaultInstance() != null) {
            defaultInstance.onBackground(j);
        }
    }

    public static void onEvent(int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (getDefaultInstance() == null || !SystemUtils.a()) {
            return;
        }
        defaultInstance.onEvent(i, str, linkedHashMap);
    }

    @Deprecated
    public static void onEvent(Context context, String str, String str2) {
        if (getDefaultInstance() == null || !SystemUtils.a()) {
            return;
        }
        defaultInstance.onEvent(context, str, str2);
    }

    public static void onEvent(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (getDefaultInstance() == null || !SystemUtils.a()) {
            return;
        }
        defaultInstance.onEvent(0, str, linkedHashMap);
    }

    public static void onEventNew(int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (getDefaultInstance() == null || !SystemUtils.a()) {
            return;
        }
        defaultInstance.onEventNew(i, str, linkedHashMap);
    }

    public static void onForeground(long j) {
        if (getDefaultInstance() != null) {
            defaultInstance.onForeground(j);
        }
    }

    public static void onPause(Context context) {
        if (getDefaultInstance() == null || !SystemUtils.a()) {
            return;
        }
        defaultInstance.onPause(context);
    }

    public static void onPause(Context context, LinkedHashMap<String, String> linkedHashMap) {
        if (getDefaultInstance() == null || !SystemUtils.a()) {
            return;
        }
        defaultInstance.onPause(context, linkedHashMap);
    }

    public static void onPause(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (getDefaultInstance() == null || !SystemUtils.a()) {
            return;
        }
        defaultInstance.onPause(str, linkedHashMap);
    }

    public static void onReport() {
        if (getDefaultInstance() == null || !SystemUtils.a()) {
            return;
        }
        defaultInstance.onReport(-1);
    }

    @Deprecated
    public static void onReport(Context context) {
        if (getDefaultInstance() == null || !SystemUtils.a()) {
            return;
        }
        defaultInstance.onReport(context, -1);
    }

    public static void onReportNew() {
        if (getDefaultInstance() == null || !SystemUtils.a()) {
            return;
        }
        defaultInstance.onReportNew(-1);
    }

    public static void onResume(Context context) {
        if (getDefaultInstance() == null || !SystemUtils.a()) {
            return;
        }
        defaultInstance.onResume(context);
    }

    public static void onResume(Context context, LinkedHashMap<String, String> linkedHashMap) {
        if (getDefaultInstance() == null || !SystemUtils.a()) {
            return;
        }
        defaultInstance.onResume(context, linkedHashMap);
    }

    public static void onResume(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (getDefaultInstance() == null || !SystemUtils.a()) {
            return;
        }
        defaultInstance.onResume(str, linkedHashMap);
    }

    public static void onStreamEvent(int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (getDefaultInstance() == null || !SystemUtils.a()) {
            return;
        }
        defaultInstance.onStreamEvent(i, str, linkedHashMap);
    }

    public static void setIsOaidTracking(boolean z) {
        if (getDefaultInstance() != null) {
            defaultInstance.setOAIDTrackingFlag(1, z);
            defaultInstance.setOAIDTrackingFlag(0, z);
            defaultInstance.setOAIDTrackingFlag(3, z);
            defaultInstance.setOAIDTrackingFlag(2, z);
        }
    }

    public static void setOAID(String str) {
        if (getDefaultInstance() != null) {
            defaultInstance.setOAID(1, str);
            defaultInstance.setOAID(0, str);
            defaultInstance.setOAID(3, str);
            defaultInstance.setOAID(2, str);
        }
    }

    public static void setUPID(String str) {
        if (getDefaultInstance() != null) {
            defaultInstance.setUpid(1, str);
            defaultInstance.setUpid(0, str);
            defaultInstance.setUpid(3, str);
            defaultInstance.setUpid(2, str);
        }
    }
}
