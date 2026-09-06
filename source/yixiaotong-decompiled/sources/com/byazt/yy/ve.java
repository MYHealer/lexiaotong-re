package com.byazt.yy;

import android.content.Context;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 122, 54})
public class ve {
    public static volatile Context c;

    public static Context getContext() {
        return c;
    }

    public static void c(Context context) {
        if (c == null && context != null) {
            c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }
}
