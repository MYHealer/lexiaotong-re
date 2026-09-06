package com.jd.ad.sdk.jad_kn;

import android.content.Context;
import android.os.Process;
import com.cdo.oaps.ad.Launcher;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.kuaishou.weapon.p0.an;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_cp {
    public static long jad_an;

    public static Boolean jad_an() {
        String line;
        HashSet<String> hashSet = new HashSet();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("/proc/").append(Process.myPid()).append("/maps").toString()));
            do {
                line = bufferedReader.readLine();
                if (line == null) {
                    for (String str : hashSet) {
                        if (!str.contains("com.saurik.substrate") && !str.contains("XposedBridge.jar")) {
                        }
                        return Boolean.TRUE;
                    }
                    bufferedReader.close();
                    return Boolean.FALSE;
                }
                if (line.endsWith(".jar") || line.endsWith(".so")) {
                    hashSet.add(line.substring(line.lastIndexOf(PPSLabelView.Code) + 1));
                }
            } while (!line.toLowerCase().contains("frida"));
            return Boolean.TRUE;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Boolean jad_an(Context context) {
        try {
            throw new Exception("Deteck hook");
        } catch (Exception e) {
            int i = 0;
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                if (("com.saurik.substrate.MS$2".equals(stackTraceElement.getClassName()) && Launcher.Method.INVOKE_CALLBACK.equals(stackTraceElement.getMethodName())) || ((an.b.equals(stackTraceElement.getClassName()) && "main".equals(stackTraceElement.getMethodName())) || (an.b.equals(stackTraceElement.getClassName()) && "handleHookedMethod".equals(stackTraceElement.getMethodName())))) {
                    return Boolean.TRUE;
                }
                if ("com.android.internal.os.ZygoteInit".equals(stackTraceElement.getClassName()) && (i = i + 1) == 2) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        }
    }
}
