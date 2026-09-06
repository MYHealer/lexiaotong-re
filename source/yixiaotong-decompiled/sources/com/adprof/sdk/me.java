package com.adprof.sdk;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class me {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleDateFormat f1306a = new SimpleDateFormat("yyyyMMdd", Locale.US);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m683a() {
        int i;
        int i2;
        String strOptString;
        try {
            JSONObject jSONObject = d1.f1121a.a().f210a;
            String str = "";
            if (jSONObject != null && (strOptString = jSONObject.optString("mc_limit", "")) != null) {
                str = strOptString;
            }
            pk.d(" server mc limit = " + str);
            i = !TextUtils.isEmpty(str) ? Integer.parseInt(str.trim()) : -1;
        } catch (Exception e) {
            pk.c("getMcLimitPerDay parse error: ", e);
        }
        if (i < 0) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        String str2 = f1306a.format(new Date());
        if (str2.equals(sl.a("mc_limit_date"))) {
            i2 = sl.a().getInt("mc_limit_count", 0);
        } else {
            sl.a("mc_limit_date", str2);
            SharedPreferences.Editor editorEdit = sl.a().edit();
            editorEdit.putInt("mc_limit_count", 0);
            editorEdit.commit();
            i2 = 0;
        }
        return i2 < i;
    }

    public static int a() {
        String str = f1306a.format(new Date());
        int i = 0;
        if (str.equals(sl.a("mc_limit_date"))) {
            i = sl.a().getInt("mc_limit_count", 0);
        } else {
            sl.a("mc_limit_date", str);
        }
        int i2 = i + 1;
        SharedPreferences.Editor editorEdit = sl.a().edit();
        editorEdit.putInt("mc_limit_count", i2);
        editorEdit.commit();
        return i2;
    }
}
