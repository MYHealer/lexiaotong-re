package com.opos.mobad.s;

import android.app.ActivityManager;
import android.content.Context;
import com.byazt.hv.TTDownloadField;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d {
    private static int a() {
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        int i = 0;
        if (allStackTraces != null && allStackTraces.size() > 0) {
            for (Thread thread : allStackTraces.keySet()) {
                if (thread.getName().startsWith("single_thread") || thread.getName().startsWith("comp_thread") || thread.getName().startsWith("io_thread") || thread.getName().startsWith("scheduled_thread")) {
                    i++;
                }
            }
        }
        return i;
    }

    public static String a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            long jMaxMemory = Runtime.getRuntime().maxMemory();
            long j = Runtime.getRuntime().totalMemory();
            jSONObject.put("dmm", jMaxMemory);
            jSONObject.put("dtm", j);
        } catch (Throwable unused) {
        }
        if (context != null) {
            try {
                ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                long j2 = memoryInfo.totalMem;
                long j3 = memoryInfo.availMem;
                jSONObject.put("mm", j2);
                jSONObject.put("am", j3);
            } catch (Throwable unused2) {
            }
        }
        try {
            jSONObject.put("limits", a("/proc/self/limits"));
        } catch (Throwable unused3) {
        }
        try {
            jSONObject.put("status", a("/proc/self/status"));
        } catch (Throwable unused4) {
        }
        try {
            jSONObject.put("oposThreads", a());
        } catch (Throwable unused5) {
        }
        try {
            jSONObject.put("pfd", b("/proc/self/fd"));
        } catch (Throwable unused6) {
        }
        return jSONObject.toString();
    }

    private static String a(String str) {
        return a(str, 50);
    }

    private static String a(String str, int i) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
            int i2 = 0;
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    String strTrim = line.trim();
                    if (strTrim.length() > 0) {
                        i2++;
                        if (i == 0 || i2 <= i) {
                            sb.append("  ").append(strTrim).append(IOUtils.LINE_SEPARATOR_UNIX);
                        }
                    }
                    return sb.toString();
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
                com.opos.cmn.an.f.a.b("sysContext", "get info fail", th);
            }
            if (i > 0 && i2 > i) {
                sb.append("  ......\n").append("  (number of records: ").append(i2).append(")\n");
            }
            bufferedReader.close();
        } catch (Throwable th4) {
            com.opos.cmn.an.f.a.b("sysContext", "get info fail", th4);
        }
        return sb.toString();
    }

    private static int b(String str) {
        try {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                return file.list().length;
            }
            return 0;
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.b("sysContext", "get proc dir fail", th);
            return 0;
        }
    }
}
