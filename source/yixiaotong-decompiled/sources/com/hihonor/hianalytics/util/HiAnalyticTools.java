package com.hihonor.hianalytics.util;

import android.content.Context;
import com.hihonor.hianalytics.hnha.j2;
import com.hihonor.hianalytics.hnha.p2;
import com.hihonor.hianalytics.process.HiAnalyticsManager;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class HiAnalyticTools {
    public static void addExcludeReportAppId(Context context, List<String> list) {
        addExcludeReportAppId(context, list, 1);
    }

    public static void addExcludeReportAppId(Context context, List<String> list, int i) {
        SystemUtils.a(context);
        p2.d().a(list, i, true);
    }

    public static void addReportExcludeTags(Context context, List<String> list, int i) {
        SystemUtils.a(context);
        p2.d().a(list, i, false);
    }

    public static void enableLog(Context context) {
        enableLog(context, 4);
    }

    public static void enableLog(Context context, int i) {
        SystemUtils.a(context);
        j2.a(i, "HaSdk");
    }

    public static void enableNewMode() {
        HiAnalyticsManager.enableGlobalNewMode();
    }

    public static void enableOwnDataReport(boolean z) {
        p2.d().b(z);
    }

    public static void enableReport(Context context, boolean z) {
        SystemUtils.a(context);
        p2.d().a(z);
    }

    public static void enableReport(boolean z) {
        enableReport(null, z);
    }

    public static boolean isEnableOwnDataReport() {
        return p2.d().i();
    }

    public static boolean isEnableReportData() {
        return p2.d().h();
    }

    public static boolean isNewStoreMode() {
        return true;
    }

    public static void removeExcludeReportAppId(Context context, List<String> list) {
        SystemUtils.a(context);
        p2.d().b(list, true);
    }

    public static void removeReportExcludeTags(Context context, List<String> list) {
        SystemUtils.a(context);
        p2.d().b(list, false);
    }
}
