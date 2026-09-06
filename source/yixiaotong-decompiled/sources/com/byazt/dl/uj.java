package com.byazt.dl;

import android.text.TextUtils;
import com.byazt.omf.gt;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 465, 15})
public class uj {
    public static boolean c(String str) {
        int iPx;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String str2 = com.byazt.vif.uj.c(com.byazt.vxy.c.uj(), "fsswiper_freq").get(str, "");
            return !TextUtils.isEmpty(str2) && (iPx = gt.tt().px()) > 0 && new JSONObject(str2).optInt(c(), 0) >= iPx;
        } catch (Exception unused) {
        }
    }

    public static void tt(String str) {
        ve(str);
    }

    private static void ve(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.it.ve veVarC = com.byazt.vif.uj.c(com.byazt.vxy.c.uj(), "fsswiper_freq");
        try {
            String str2 = veVarC.get(str, "");
            if (TextUtils.isEmpty(str2)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str2);
            }
            String strC = c();
            int iOptInt = jSONObject.optInt(strC, 0);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(strC, iOptInt + 1);
            veVarC.put(str, jSONObject2.toString());
        } catch (Exception unused) {
        }
    }

    private static String c() {
        try {
            return new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
        } catch (Exception unused) {
            return null;
        }
    }
}
