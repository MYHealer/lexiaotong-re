package com.gnete.upbc.cashier.e;

import android.app.Activity;
import com.gnete.upbc.cashier.GnetePayChannel;
import com.gnete.upbc.cashier.GnetePayListener;
import com.gnete.upbc.cashier.GnetePayRequest;

/* JADX INFO: compiled from: PayHandlerFactory.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class f {

    /* JADX INFO: compiled from: PayHandlerFactory.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3295a;

        static {
            int[] iArr = new int[GnetePayChannel.values().length];
            f3295a = iArr;
            try {
                iArr[GnetePayChannel.WXPAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3295a[GnetePayChannel.ALIPAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3295a[GnetePayChannel.CUPPAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3295a[GnetePayChannel.CASHIER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static e a(Activity activity, GnetePayRequest gnetePayRequest, GnetePayListener gnetePayListener) {
        e gVar;
        int i = a.f3295a[gnetePayRequest.payChannel.ordinal()];
        if (i == 1) {
            gVar = new g(activity, gnetePayRequest, gnetePayListener);
        } else if (i == 2) {
            gVar = new com.gnete.upbc.cashier.e.a(activity, gnetePayRequest, gnetePayListener);
        } else if (i == 3) {
            gVar = new d(activity, gnetePayRequest, gnetePayListener);
        } else {
            if (i != 4) {
                return null;
            }
            gVar = new c(activity, gnetePayRequest, gnetePayListener);
        }
        return gVar;
    }

    public static b a(Activity activity, com.gnete.upbc.cashier.b.b bVar, GnetePayListener gnetePayListener) {
        b gVar;
        int i = a.f3295a[bVar.f().ordinal()];
        if (i == 1) {
            gVar = new g(activity, bVar, gnetePayListener);
        } else if (i == 2) {
            gVar = new com.gnete.upbc.cashier.e.a(activity, bVar, gnetePayListener);
        } else {
            if (i != 3) {
                return null;
            }
            gVar = new d(activity, bVar, gnetePayListener);
        }
        return gVar;
    }
}
