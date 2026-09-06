package com.adprof.sdk;

import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class w6 {
    public static void a(View view, d dVar, v6 v6Var) {
        if (view == null || dVar == null) {
            return;
        }
        view.post(new u6(view, dVar, v6Var));
    }
}
