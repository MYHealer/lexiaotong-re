package com.opos.cmn.an.h.a;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Process;
import com.byazt.hv.TTDownloadField;
import com.stub.StubApp;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ActivityManager f5930a = null;
    private static volatile String b = "";

    public static ActivityManager a(Context context) {
        if (f5930a == null && context != null) {
            f5930a = (ActivityManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService(TTDownloadField.TT_ACTIVITY);
        }
        return f5930a;
    }

    public static boolean a(Context context, String str) {
        ComponentName componentName;
        try {
            ActivityManager activityManagerA = a(context);
            if (activityManagerA == null || com.opos.cmn.an.d.a.a(str)) {
                return false;
            }
            List<ActivityManager.RunningTaskInfo> runningTasks = activityManagerA.getRunningTasks(1);
            return (runningTasks.isEmpty() || (componentName = runningTasks.get(0).topActivity) == null || !componentName.getPackageName().equals(str)) ? false : true;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ActMgrTool", "", e);
            return false;
        }
    }

    public static boolean b(Context context) {
        try {
            return a(context, context.getPackageName()) && c(context);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ActMgrTool", "", e);
            return false;
        }
    }

    public static boolean c(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        boolean z = false;
        try {
            ActivityManager activityManagerA = a(context);
            if (activityManagerA != null && (runningAppProcesses = activityManagerA.getRunningAppProcesses()) != null && runningAppProcesses.size() > 0) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.pid == Process.myPid()) {
                        z = true;
                    }
                }
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ActMgrTool", "", e);
        }
        return z;
    }
}
