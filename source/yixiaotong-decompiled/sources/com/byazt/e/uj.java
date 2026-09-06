package com.byazt.e;

import client.android.yixiaotong.v3.comman.AppTypeIdUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 443, 15})
public class uj {
    public String c;
    public String tt;

    public String c() {
        return this.c;
    }

    public uj(c cVar) {
        this.c = cVar.c;
        this.tt = cVar.tt;
    }

    @com.byazt.zqa.c(c = {0, 1, 443, AppTypeIdUtil.NewDevice4GBathOTA})
    public static class c {
        public String c;
        public String tt;

        public c c(String str) {
            this.c = str;
            return this;
        }

        public c tt(String str) {
            this.tt = str;
            return this;
        }

        public uj c() {
            return new uj(this);
        }
    }
}
