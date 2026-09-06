package com.byazt.qcl;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 578, 20})
public class c {
    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "key_tt_csj_node_line_";
        }
        if ("ad_show".equals(str)) {
            return "key_tt_csj_node_line_" + str + "_";
        }
        return "key_tt_csj_other_node_line_" + str + "_";
    }
}
