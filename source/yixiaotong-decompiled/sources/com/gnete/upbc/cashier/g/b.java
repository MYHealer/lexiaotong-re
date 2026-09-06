package com.gnete.upbc.cashier.g;

import android.content.Context;
import android.text.TextUtils;
import com.gnete.upbc.cashier.GnetePayChannel;
import com.gnete.upbc.cashier.GnetePayListener;
import com.gnete.upbc.cashier.GnetePayResult;
import com.gnete.upbc.cashier.b.e;
import com.gnete.upbc.cashier.b.g;

/* JADX INFO: compiled from: PayResultUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class b {
    public static void a(GnetePayChannel gnetePayChannel, GnetePayListener gnetePayListener) {
        a(gnetePayChannel, GnetePayResult.SUCCESS, null, gnetePayListener);
    }

    public static void a(Context context, com.gnete.upbc.cashier.b.b bVar, GnetePayListener gnetePayListener) {
        g gVar = g.LOG;
        GnetePayResult gnetePayResult = GnetePayResult.CANCEL;
        a(context, bVar, gVar, gnetePayResult.getMsg(), (Throwable) null);
        a(bVar.f(), gnetePayResult, null, gnetePayListener);
    }

    public static void a(Context context, com.gnete.upbc.cashier.b.b bVar, String str, Throwable th, GnetePayListener gnetePayListener) {
        a(context, bVar, g.NORMAL, str, th);
        a(bVar.f(), GnetePayResult.FAILURE, str, gnetePayListener);
    }

    private static void a(GnetePayChannel gnetePayChannel, GnetePayResult gnetePayResult, String str, GnetePayListener gnetePayListener) {
        if (com.gnete.upbc.cashier.a.i()) {
            com.gnete.upbc.cashier.c.a.a().b();
        }
        if (gnetePayListener == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = gnetePayResult.getMsg();
        }
        gnetePayListener.onGnetePayResult(gnetePayChannel, gnetePayResult, str);
    }

    private static void a(Context context, com.gnete.upbc.cashier.b.b bVar, g gVar, String str, Throwable th) {
        com.gnete.upbc.cashier.a.g.c(bVar.a(new e.a(context).a(gVar).a(bVar.f()).a(str).a(th).a())).a(null);
    }
}
