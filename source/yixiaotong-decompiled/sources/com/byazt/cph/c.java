package com.byazt.cph;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1059, 20})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f2053a;
    public String c;
    public int n;
    public JSONObject sp;
    public String tt;
    public int uj;
    public String ve;

    public long a() {
        return this.f2053a;
    }

    public String c() {
        return this.c;
    }

    public int n() {
        return this.n;
    }

    public JSONObject sp() {
        return this.sp;
    }

    public String tt() {
        return this.tt;
    }

    public int uj() {
        return this.uj;
    }

    public String ve() {
        return this.ve;
    }

    /* JADX INFO: renamed from: com.byazt.cph.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 1059, 44})
    public static class C0125c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f2054a;
        public String c;
        public int n;
        public JSONObject sp;
        public String tt;
        public int uj;
        public String ve;

        public C0125c c(int i) {
            this.uj = i;
            return this;
        }

        public C0125c c(long j) {
            this.f2054a = j;
            return this;
        }

        public C0125c c(String str) {
            this.c = str;
            return this;
        }

        public C0125c c(JSONObject jSONObject) {
            this.sp = jSONObject;
            return this;
        }

        public C0125c tt(int i) {
            this.n = i;
            return this;
        }

        public C0125c tt(String str) {
            this.tt = str;
            return this;
        }

        public C0125c ve(String str) {
            this.ve = str;
            return this;
        }

        public c c() {
            c cVar = new c();
            cVar.c = this.c;
            cVar.tt = this.tt;
            cVar.ve = this.ve;
            cVar.uj = this.uj;
            cVar.n = this.n;
            cVar.f2053a = this.f2054a;
            cVar.sp = this.sp;
            return cVar;
        }
    }
}
