package com.byazt.uq;

import android.text.TextUtils;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1759, 54})
public class ve {
    public static String[] c(File file) {
        String[] strArrC = com.byazt.xai.tt.c(file);
        return TextUtils.isEmpty(strArrC[0]) ? com.byazt.xai.c.c(file) : strArrC;
    }
}
