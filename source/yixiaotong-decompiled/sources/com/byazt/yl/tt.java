package com.byazt.yl;

import android.text.TextUtils;
import com.byazt.vx.eo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 509, 13})
public class tt {
    public static final String c = eo.uj();
    public static boolean tt = true;

    public static int c() {
        return Integer.parseInt(tt().replace(".", ""));
    }

    public static String tt() {
        return com.byazt.tjo.tt.ve();
    }

    public static String ve() {
        if (TextUtils.isEmpty(tt())) {
            return "";
        }
        String[] strArrSplit = tt().split("\\.");
        if (strArrSplit.length < 4) {
            return "";
        }
        return strArrSplit[0] + "." + strArrSplit[1] + "." + strArrSplit[2];
    }

    public static String uj() {
        return com.byazt.tjo.tt.uj();
    }
}
