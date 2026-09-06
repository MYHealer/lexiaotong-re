package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Debug;
import android.os.Process;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.io.BufferedReader;
import java.io.FileReader;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ab {
    public static String a() throws Throwable {
        String line;
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/status"));
            while (true) {
                try {
                    line = bufferedReader2.readLine();
                    if (!line.contains("TracerPid")) {
                        if (line == null) {
                            line = "";
                            break;
                        }
                    } else {
                        break;
                    }
                } catch (Exception unused) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused2) {
                        }
                    }
                    return "";
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            }
            String strReplace = line.replace("\t", PPSLabelView.Code);
            try {
                bufferedReader2.close();
            } catch (Exception unused4) {
            }
            return strReplace;
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean b() {
        try {
            return Boolean.valueOf(Debug.isDebuggerConnected()).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(Context context) {
        try {
            return (context.getPackageManager().getApplicationInfo(context.getPackageName(), 8192).flags & 2) == 1;
        } catch (Throwable unused) {
        }
    }

    public static boolean b(Context context) {
        try {
            return (context.getPackageManager().getApplicationInfo(context.getPackageName(), 8192).flags & 2) == 1;
        } catch (Throwable unused) {
        }
    }
}
