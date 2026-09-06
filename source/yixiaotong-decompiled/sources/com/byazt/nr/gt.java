package com.byazt.nr;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.byazt.hv.TTDownloadField;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.stub.StubApp;
import com.yfanads.android.qapp.Val;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO})
public class gt {
    public static String c;

    public static boolean c(Context context) {
        if (context == null || StubApp.getOrigApplicationContext(context.getApplicationContext()) == null) {
            return false;
        }
        return TextUtils.equals(StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName(), tt(context));
    }

    public static String tt(Context context) {
        if (!TextUtils.isEmpty(c)) {
            return c;
        }
        String strC = c();
        c = strC;
        if (!TextUtils.isEmpty(strC)) {
            return c;
        }
        String strTt = tt();
        c = strTt;
        if (!TextUtils.isEmpty(strTt)) {
            return c;
        }
        String strVe = ve(context);
        c = strVe;
        return strVe;
    }

    private static String c() {
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        try {
            return Application.getProcessName();
        } catch (Exception e) {
            m.c(e);
            return null;
        }
    }

    private static String tt() {
        try {
            Method declaredMethod = Class.forName(Val.AT, false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
            return null;
        } catch (Throwable th) {
            m.c(th);
            return null;
        }
    }

    private static String ve(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return null;
        }
        int iMyPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == iMyPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return null;
    }
}
