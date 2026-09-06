package com.byazt.cjm;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1243, 54})
public class ve {
    public String c;
    public int tt;

    public String c() {
        return this.c;
    }

    public void c(int i) {
        this.tt = i;
    }

    public void c(String str) {
        this.c = str;
    }

    public int tt() {
        return this.tt;
    }

    public boolean ve() {
        return !TextUtils.isEmpty(this.c);
    }
}
