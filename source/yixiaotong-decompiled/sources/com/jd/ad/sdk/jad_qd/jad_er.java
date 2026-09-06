package com.jd.ad.sdk.jad_qd;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import com.jd.ad.sdk.logger.Logger;
import org.json.JSONObject;

/* JADX INFO: compiled from: JADDeviceInfoUtils.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_er {
    public static int jad_an(Context context) {
        if (!jad_fs.jad_an.jad_an.jad_an("plugged")) {
            return -1;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), null, null);
            int intExtra = intentRegisterReceiver.getIntExtra("level", -1);
            int intExtra2 = intentRegisterReceiver.getIntExtra("plugged", -1);
            int intExtra3 = intentRegisterReceiver.getIntExtra("status", -1);
            jSONObject.put("level", intExtra);
            jSONObject.put("plugged", intExtra2);
            jSONObject.put("status", intExtra3);
        } catch (Exception e) {
            Logger.d(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while getBatteryInfo: ").append(Log.getStackTraceString(e)).toString());
        }
        return jSONObject.optInt("plugged");
    }

    public static String jad_bo() {
        String str = "";
        try {
            if (!jad_fs.jad_an.jad_an.jad_an("hwModel")) {
                return "";
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("hwModel", true)) {
                return jad_anVar.jad_dq("hwModel");
            }
            str = Build.DEVICE;
            jad_anVar.jad_bo("hwModel", str);
            return str;
        } catch (Exception unused) {
        }
    }

    public static String jad_cp() throws Throwable {
        String strJad_an = "";
        try {
            if (!jad_fs.jad_an.jad_an.jad_an("sysMemory")) {
                return "";
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("sysMemory", true)) {
                return jad_anVar.jad_dq("sysMemory");
            }
            strJad_an = com.jd.ad.sdk.jad_fq.jad_er.jad_an();
            jad_anVar.jad_bo("sysMemory", strJad_an);
            return strJad_an;
        } catch (Exception unused) {
        }
    }

    public static String jad_an() {
        String str = "";
        try {
            if (!jad_fs.jad_an.jad_an.jad_an("board")) {
                return "";
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("board", true)) {
                return (String) jad_anVar.jad_bo("board");
            }
            str = Build.BOARD;
            jad_anVar.jad_bo("board", str);
            return str;
        } catch (Exception unused) {
        }
    }

    public static String jad_bo(Context context) {
        String strValueOf = "";
        try {
            if (!jad_fs.jad_an.jad_an.jad_an("sysDiskSize")) {
                return "";
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("sysDiskSize", true)) {
                strValueOf = jad_anVar.jad_dq("sysDiskSize");
            } else if (context != null) {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                strValueOf = String.valueOf(((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize()));
                jad_anVar.jad_bo("sysDiskSize", strValueOf);
            }
        } catch (Exception unused) {
        }
        return strValueOf;
    }
}
