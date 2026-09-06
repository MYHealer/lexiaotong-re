package com.qq.e.comm.managers.plugin;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.byazt.hv.TTDownloadField;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile String f8511a;

    public static synchronized String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = f8511a;
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        return str + (str2.endsWith("_") ? "" : "_") + d.a(str2);
    }

    public static synchronized String a(Context context) {
        if (!TextUtils.isEmpty(f8511a)) {
            return f8511a;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            f8511a = Application.getProcessName();
            return f8511a;
        }
        int iMyPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (it.hasNext()) {
                try {
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == iMyPid) {
                        f8511a = next.processName;
                        return f8511a;
                    }
                    continue;
                } catch (Exception unused) {
                }
            }
        }
        return null;
    }
}
