package com.gnete.upbc.cashier;

import android.app.Activity;
import android.content.Context;
import com.gnete.upbc.cashier.e.f;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class GnetePayPlugin {
    private GnetePayPlugin() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void sendPayRequest(Activity activity, GnetePayRequest gnetePayRequest) {
        sendPayRequest(activity, gnetePayRequest, activity instanceof GnetePayListener ? (GnetePayListener) activity : null);
    }

    public static void uploadLog(Context context) {
        com.gnete.upbc.cashier.c.a.a().b(context);
    }

    public static void sendPayRequest(Activity activity, GnetePayRequest gnetePayRequest, GnetePayListener gnetePayListener) {
        f.a(activity, gnetePayRequest, gnetePayListener).a();
    }
}
