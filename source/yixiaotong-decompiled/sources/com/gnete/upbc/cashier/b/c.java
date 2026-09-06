package com.gnete.upbc.cashier.b;

import android.text.TextUtils;
import com.gnete.upbc.cashier.GneteEnv;
import com.gnete.upbc.cashier.GnetePayChannel;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: ConfigData.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class c implements Serializable {
    private static final GneteEnv i = GneteEnv.PRO;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IWXAPI f3272a;
    private GneteEnv b;
    private final Set<GnetePayChannel> c = new HashSet();
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private String g;
    private String h;

    public String a() {
        return this.h;
    }

    public void a(GneteEnv gneteEnv) {
        this.b = gneteEnv;
    }

    public void a(IWXAPI iwxapi) {
        this.f3272a = iwxapi;
    }

    public void a(String str) {
        this.h = str;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public GneteEnv b() {
        GneteEnv gneteEnv = this.b;
        return gneteEnv == null ? i : gneteEnv;
    }

    public void b(String str) {
        this.g = str;
    }

    public void b(boolean z) {
        this.f = z;
    }

    public IWXAPI c() {
        return this.f3272a;
    }

    public void c(boolean z) {
        this.e = z;
    }

    public Set<GnetePayChannel> d() {
        return this.c;
    }

    public String e() {
        return "4.1.1";
    }

    public String f() {
        return TextUtils.isEmpty(this.g) ? "pages/pay/index" : this.g;
    }

    public boolean g() {
        return this.d;
    }

    public boolean h() {
        return this.f;
    }

    public boolean i() {
        return this.e;
    }
}
