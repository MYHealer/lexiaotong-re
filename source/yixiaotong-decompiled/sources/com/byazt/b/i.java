package com.byazt.b;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 223, 42})
public class i implements com.byazt.zz.sl {
    @Override // com.byazt.zz.sl
    public int c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0;
        }
        String strN = com.byazt.w.a.n(String.format("%s_%s", str, str2));
        if (TextUtils.isEmpty(strN)) {
            return 0;
        }
        return strN.hashCode();
    }
}
