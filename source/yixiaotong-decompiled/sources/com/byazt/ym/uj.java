package com.byazt.ym;

import com.byazt.vb.n;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 799, 15})
public class uj {
    public static String c = "com.bytedance.openadsdk";
    public static String tt = "content://" + c + ".TTMultiProvider";

    public static String c(n nVar) {
        if (nVar.getContext() != null) {
            c = nVar.getContext().getPackageName();
            tt = "content://" + c + ".TTMultiProvider";
        }
        return tt;
    }
}
