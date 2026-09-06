package com.byazt.ks;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 2154, 54})
public class ve implements com.byazt.rk.c {
    @Override // com.byazt.rk.c
    public Object c(Class cls, String str) {
        if (TextUtils.isEmpty(str)) {
            return ' ';
        }
        return Character.valueOf(str.charAt(0));
    }
}
