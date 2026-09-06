package com.byazt.e;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 443, 20})
public class c {
    public String c;
    public String n;
    public String tt;
    public String uj;
    public String ve;

    public c(C0140c c0140c) {
        this.tt = "";
        this.c = c0140c.c;
        this.tt = c0140c.tt;
        this.ve = c0140c.ve;
        this.uj = c0140c.uj;
        this.n = c0140c.n;
    }

    /* JADX INFO: renamed from: com.byazt.e.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 443, 44})
    public static class C0140c {
        public String c;
        public String n;
        public String tt;
        public String uj;
        public String ve;

        public C0140c c(String str) {
            this.c = str;
            return this;
        }

        public C0140c tt(String str) {
            this.tt = str;
            return this;
        }

        public C0140c uj(String str) {
            this.n = str;
            return this;
        }

        public C0140c ve(String str) {
            this.uj = str;
            return this;
        }

        public c c() {
            return new c(this);
        }
    }
}
