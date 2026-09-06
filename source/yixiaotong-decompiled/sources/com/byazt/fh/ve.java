package com.byazt.fh;

import android.text.TextUtils;
import com.byazt.omf.gt;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 505, 54})
public class ve {
    public static String c(String str) {
        String strMd = gt.tt().md();
        if (TextUtils.isEmpty(strMd)) {
            return "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/".concat(String.valueOf(str));
        }
        return strMd + str;
    }
}
