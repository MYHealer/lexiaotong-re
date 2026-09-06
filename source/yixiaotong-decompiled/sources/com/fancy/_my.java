package com.fancy;

import com.kuaishou.weapon.p0.bg;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _my {
    public static String[] _a = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};

    public static boolean _a() {
        Process processExec;
        try {
            processExec = Runtime.getRuntime().exec(new String[]{"/system/xbin/which", bg.y});
            try {
                String line = new BufferedReader(new InputStreamReader(processExec.getInputStream())).readLine();
                processExec.destroy();
                return line != null;
            } catch (Throwable unused) {
                if (processExec != null) {
                    processExec.destroy();
                }
                return false;
            }
        } catch (Throwable unused2) {
            processExec = null;
        }
    }
}
