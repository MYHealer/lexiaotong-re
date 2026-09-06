package com.byazt.th;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.byazt.bog.a;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.MethodUtils;
import com.huawei.openalliance.ad.constant.x;
import com.yfanads.android.qapp.Val;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 78, 15})
public class uj {
    public static String c;
    public static List<String> tt = new CopyOnWriteArrayList();

    private static String c() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int i = bufferedReader.read();
                    if (i <= 0) {
                        break;
                    }
                    sb.append((char) i);
                }
                if (ZeusLogger.isDebug()) {
                    ZeusLogger.d("Process", "get processName = " + sb.toString());
                }
                String string = sb.toString();
                try {
                    bufferedReader.close();
                } catch (Exception unused) {
                }
                return string;
            } catch (Throwable unused2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused3) {
                    }
                }
                return null;
            }
        } catch (Throwable unused4) {
            bufferedReader = null;
        }
    }

    public static String c(Context context) {
        if (!TextUtils.isEmpty(c)) {
            return c;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            String processName = Application.getProcessName();
            if (!TextUtils.isEmpty(processName)) {
                c = processName;
            }
            return c;
        }
        try {
            Object objInvokeStaticMethod = MethodUtils.invokeStaticMethod(Class.forName(Val.AT), "currentProcessName", new Object[0]);
            if (!TextUtils.isEmpty((String) objInvokeStaticMethod)) {
                c = (String) objInvokeStaticMethod;
            }
            return c;
        } catch (Exception e) {
            a.c(e);
            String strC = c();
            c = strC;
            return strC;
        }
    }

    public static boolean tt(Context context) {
        String strC = c(context);
        return (strC == null || !strC.contains(x.bQ)) && strC != null && strC.equals(context.getPackageName());
    }

    public static String c(String str) {
        return (TextUtils.isEmpty(str) || !str.contains(x.bQ)) ? "main" : str.split(x.bQ)[1];
    }
}
