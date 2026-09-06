package com.byazt.vx;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 962, 15})
public class uj {

    public interface c {
    }

    public static void c(Context context, Intent intent, c cVar) {
        if (context == null || intent == null) {
            return;
        }
        try {
            context.startActivity(intent);
        } catch (Throwable unused) {
        }
    }
}
