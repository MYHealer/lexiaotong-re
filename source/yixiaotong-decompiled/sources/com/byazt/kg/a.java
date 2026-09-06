package com.byazt.kg;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 428, 34})
public class a {
    public static volatile a c;
    public final ve tt;

    public static a c(Context context) {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a(context);
                }
            }
        }
        return c;
    }

    private a(Context context) {
        this.tt = new ve(context);
    }

    public void c() {
        this.tt.c();
    }
}
