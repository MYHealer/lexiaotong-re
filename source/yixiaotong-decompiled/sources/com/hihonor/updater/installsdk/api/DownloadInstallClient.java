package com.hihonor.updater.installsdk.api;

import android.content.Context;
import com.hihonor.updater.installsdk.c;
import com.hihonor.updater.installsdk.exception.GetSettingValueException;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class DownloadInstallClient {
    public static void cancel(Context context, DIInfo dIInfo, ResultCallback resultCallback) {
        c.b().a(context, dIInfo, resultCallback);
    }

    public static void checkCallSupport(Context context, ResultCallback resultCallback) {
        checkCallSupport(context, false, resultCallback);
    }

    public static void checkCallSupport(Context context, boolean z, ResultCallback resultCallback) {
        c.b().a(context, z, resultCallback);
    }

    public static boolean checkVersionSupport(Context context) {
        return c.b().b(context);
    }

    public static void getAppStatus(Context context, List<String> list, AppStatusCallback appStatusCallback) {
        getAppStatus(context, false, list, appStatusCallback);
    }

    public static void getAppStatus(Context context, boolean z, List<String> list, AppStatusCallback appStatusCallback) {
        c.b().a(context, z, list, appStatusCallback);
    }

    public static boolean isDownloadInstallEnable(Context context) throws GetSettingValueException {
        return c.b().a(context);
    }

    public static boolean isSwitchLimitVersion(Context context) {
        return c.b().d(context);
    }

    public static boolean isSwitchOn(Context context) throws GetSettingValueException {
        return c.b().c(context);
    }

    public static void pause(Context context, DIInfo dIInfo, ResultCallback resultCallback) {
        c.b().b(context, dIInfo, resultCallback);
    }

    public static void registerListener(DownloadInstallListener downloadInstallListener) {
        c.b().b(downloadInstallListener);
    }

    public static void start(Context context, DIInfo dIInfo, ResultCallback resultCallback) {
        c.b().c(context, dIInfo, resultCallback);
    }

    public static void unRegisterListener(DownloadInstallListener downloadInstallListener) {
        c.b().a(downloadInstallListener);
    }
}
