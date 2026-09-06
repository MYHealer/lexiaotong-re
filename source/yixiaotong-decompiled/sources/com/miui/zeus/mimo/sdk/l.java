package com.miui.zeus.mimo.sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f5514a;

    public l(Context context) {
        this.f5514a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context = this.f5514a;
        if (context == null) {
            return;
        }
        try {
            int iMyPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService(ijiami_1011.s.s.s.d(new byte[]{83, 2, 17, 94, Ascii.DC2, 95, Ascii.NAK, Ascii.GS}, "2ae7d6"));
            if (activityManager != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == iMyPid) {
                        if (!TextUtils.isEmpty(runningAppProcessInfo.processName)) {
                            if (!TextUtils.equals(runningAppProcessInfo.processName, context.getPackageName())) {
                                m.c(runningAppProcessInfo.processName, ijiami_1011.s.s.s.d(new byte[]{91}, "ac7433"));
                                break;
                            }
                            break;
                        }
                        String.valueOf(runningAppProcessInfo.pid);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            m.b(ijiami_1011.s.s.s.d(new byte[]{124, 46, 86, 81}, "1b96c9"), ijiami_1011.s.s.s.d(new byte[]{84, 81, 66, 117, Ascii.DC4, 65, 19, 1, 8, Ascii.SYN, 97, Ascii.ETB, 92, 87, 83, 69, Ascii.DC2, 125, 0, 9, 3, 39, 73, 6, 86, 68, 66, 95, 14, 93}, "3466a3"), e);
        }
    }
}
