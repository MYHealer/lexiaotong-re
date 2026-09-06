package com.byazt.pp;

import android.content.Context;
import android.widget.Toast;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1434, 15})
public final class uj {
    public static Toast c;

    public static void c(Context context, String str) {
        c(context, str, 0);
    }

    public static void c(Context context, String str, int i) {
        Toast toastC = c(context);
        if (toastC != null) {
            toastC.setDuration(i);
            toastC.setText(String.valueOf(str));
            toastC.show();
            return;
        }
        com.byazt.eu.tt.tt("TToast", "toast msg: ".concat(String.valueOf(str)));
    }

    private static Toast c(Context context) {
        if (context == null) {
            return c;
        }
        Toast toastMakeText = Toast.makeText(StubApp.getOrigApplicationContext(context.getApplicationContext()), "", 0);
        c = toastMakeText;
        return toastMakeText;
    }
}
