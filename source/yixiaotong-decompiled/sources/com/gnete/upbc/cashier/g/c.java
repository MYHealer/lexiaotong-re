package com.gnete.upbc.cashier.g;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;

/* JADX INFO: compiled from: ToastUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Toast f3303a;

    /* JADX INFO: compiled from: ToastUtil.java */
    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f3304a;
        final /* synthetic */ String b;

        a(Context context, String str) {
            this.f3304a = context;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.b(this.f3304a, this.b);
        }
    }

    public static void c(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b(context, str);
        } else if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(new a(context, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str) {
        Toast toast = f3303a;
        if (toast != null) {
            toast.cancel();
        }
        Toast toastMakeText = Toast.makeText(context, str, 1);
        f3303a = toastMakeText;
        toastMakeText.show();
    }
}
