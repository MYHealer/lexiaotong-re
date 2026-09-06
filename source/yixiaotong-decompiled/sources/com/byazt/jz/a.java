package com.byazt.jz;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 232, 34})
public class a {
    public final int c;
    public String tt;
    public JSONObject ve;

    public boolean c() {
        return this.c == 0;
    }

    public a(int i) {
        this.c = i;
    }

    public a(int i, Throwable th) {
        this.c = i;
        if (th != null) {
            this.tt = th.getMessage();
        }
    }

    public a(int i, String str) {
        this.c = i;
        this.tt = str;
    }

    public a(int i, JSONObject jSONObject) {
        this.c = i;
        this.ve = jSONObject;
    }
}
