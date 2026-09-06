package com.byazt.bp;

import android.text.TextUtils;
import com.byazt.vx.d;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 896, 54})
public class ve {
    public static String c;
    public static String tt;

    public static String c() {
        return d.c(n() + "/api/ad/union/mediation/config/");
    }

    public static String tt() {
        return d.c("https://" + tt.tt().z());
    }

    public static String ve() {
        return d.c(n() + "/api/ad/union/mediation/exchange/");
    }

    public static String uj() {
        return d.c(n() + "/api/ad/union/mediation/reward_video/reward/");
    }

    private static String n() {
        String strA = a();
        return !TextUtils.isEmpty(strA) ? strA : "https://gromore.pangolin-sdk-toutiao.com";
    }

    private static String a() {
        String string = com.byazt.rq.c.c().getString("server_dist_host", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        if (TextUtils.equals(string, c) && !TextUtils.isEmpty(tt)) {
            return tt;
        }
        c = string;
        tt = null;
        if (!TextUtils.isEmpty(string)) {
            tt = com.byazt.vx.c.tt(c, com.byazt.vx.tt.c());
        }
        if (TextUtils.isEmpty(tt)) {
            return null;
        }
        String str = "https://" + tt;
        tt = str;
        return str;
    }
}
