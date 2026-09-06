package com.gnete.upbc.cashier.b;

import android.text.TextUtils;
import com.gnete.upbc.cashier.GnetePayChannel;
import com.gnete.upbc.cashier.R;

/* JADX INFO: compiled from: MerPayType.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public enum f implements d {
    WXPAY("wxpay-APP", "微信支付", R.drawable.gnete_icon_wxpay, GnetePayChannel.WXPAY, 1),
    ALIPAY("alipay-APP", "支付宝支付", R.drawable.gnete_icon_alipay, GnetePayChannel.ALIPAY, 2),
    CUPPAY("cuppay-APP", "银联支付", R.drawable.gnete_icon_cuppay, GnetePayChannel.CUPPAY, 3);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3275a;
    private final String b;
    private final int c;
    private final GnetePayChannel d;
    private int e;

    f(String str, String str2, int i2, GnetePayChannel gnetePayChannel, int i3) {
        this.f3275a = str;
        this.b = str2;
        this.c = i2;
        this.d = gnetePayChannel;
        this.e = i3;
    }

    @Override // com.gnete.upbc.cashier.b.d
    public int a() {
        return this.c;
    }

    public void a(int i2) {
        this.e = i2;
    }

    @Override // com.gnete.upbc.cashier.b.d
    public String b() {
        return this.b;
    }

    public int c() {
        return this.e;
    }

    public GnetePayChannel d() {
        return this.d;
    }

    public String e() {
        return this.f3275a;
    }

    public static f a(String str) {
        for (f fVar : values()) {
            if (TextUtils.equals(fVar.f3275a, str)) {
                return fVar;
            }
        }
        return null;
    }

    public static f a(GnetePayChannel gnetePayChannel) {
        for (f fVar : values()) {
            if (fVar.d() == gnetePayChannel) {
                return fVar;
            }
        }
        return null;
    }
}
