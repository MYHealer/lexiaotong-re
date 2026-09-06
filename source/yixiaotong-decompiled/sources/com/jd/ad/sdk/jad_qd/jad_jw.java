package com.jd.ad.sdk.jad_qd;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.byazt.hv.TTDownloadField;
import com.jd.ad.sdk.bl.initsdk.JADYunSdk;
import com.umeng.analytics.pro.am;
import java.util.List;

/* JADX INFO: compiled from: JADUserInfoUtils.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_jw {
    public static boolean jad_dq(Context context) {
        try {
            if (!jad_fs.jad_an.jad_an.jad_an("processName") || !JADYunSdk.isSupportMultiProcess()) {
                return true;
            }
            String strJad_cp = jad_cp(context);
            String strJad_an = jad_an(context);
            if (TextUtils.isEmpty(strJad_an)) {
                strJad_an = context.getPackageName();
            }
            if (!TextUtils.isEmpty(strJad_an) && !TextUtils.isEmpty(strJad_cp) && !strJad_an.equals(strJad_cp)) {
                return false;
            }
        } catch (Exception unused) {
        }
        return true;
    }

    public static String jad_an(Context context) {
        String packageName = "";
        try {
            if (!jad_fs.jad_an.jad_an.jad_an("bundle")) {
                return "";
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("bundle", true)) {
                packageName = jad_anVar.jad_dq("bundle");
            } else if (context != null) {
                packageName = context.getPackageName();
                jad_anVar.jad_bo("bundle", packageName);
            }
        } catch (Exception unused) {
        }
        return packageName;
    }

    public static String jad_bo(Context context) {
        String strJad_an = "";
        try {
            if (!jad_fs.jad_an.jad_an.jad_an(am.P)) {
                return "";
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an(am.P, true)) {
                strJad_an = (String) jad_anVar.jad_bo(am.P);
            } else if (context != null) {
                strJad_an = com.jd.ad.sdk.jad_fq.jad_hu.jad_an(context);
                jad_anVar.jad_bo(am.P, strJad_an);
            }
        } catch (Exception unused) {
        }
        return strJad_an;
    }

    public static String jad_cp(Context context) {
        String str = "";
        try {
            if (!jad_fs.jad_an.jad_an.jad_an("processName")) {
                return "jad_process_default";
            }
            if (!JADYunSdk.isSupportMultiProcess()) {
                return jad_an(context);
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("processName", true)) {
                return jad_anVar.jad_dq("processName");
            }
            if (context == null) {
                return "";
            }
            try {
                int iMyPid = Process.myPid();
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo != null && runningAppProcessInfo.pid == iMyPid) {
                            str = runningAppProcessInfo.processName;
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an.jad_bo("processName", str);
            return str;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002c  */
    /* JADX WARN: Code duplicated, block: B:18:? A[RETURN, SYNTHETIC] */
    public static String jad_an() {
        String str;
        String str2;
        try {
            jad_fs jad_fsVar = jad_fs.jad_an.jad_an;
            if (!TextUtils.isEmpty(jad_fsVar.jad_bo)) {
                str2 = jad_fsVar.jad_bo;
            } else {
                str = (String) com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an.jad_an("didCustom", String.class);
                if (TextUtils.isEmpty(str)) {
                    str2 = "";
                } else {
                    jad_fsVar.jad_bo = str;
                }
                if (TextUtils.isEmpty(str)) {
                    return "";
                }
                return str;
            }
            str = str2;
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String jad_bo() {
        try {
            jad_fs jad_fsVar = jad_fs.jad_an.jad_an;
            if (!jad_fsVar.jad_an("oidCustom")) {
                return "";
            }
            String strJad_bo = jad_fsVar.jad_bo();
            try {
                if (TextUtils.isEmpty(strJad_bo)) {
                    return "";
                }
            } catch (Exception unused) {
            }
            return strJad_bo;
        } catch (Exception unused2) {
            return "";
        }
    }
}
