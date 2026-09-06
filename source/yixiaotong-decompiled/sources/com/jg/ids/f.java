package com.jg.ids;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
public abstract class f implements i {
    private static String b = "";
    private static String c = "";
    private static String d = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f4599a;

    public f(Context context) {
        this.f4599a = null;
        this.f4599a = context;
        try {
            b = k.a().b();
            c = k.a().c();
            d = k.a().d();
        } catch (Throwable th) {
        }
    }

    public final void a(String str) {
        try {
            b = str;
            k.a().a(b);
        } catch (Throwable th) {
        }
    }

    public final void b(String str) {
        try {
            c = str;
            k.a().b(c);
        } catch (Throwable th) {
        }
    }

    public final void c(String str) {
        try {
            d = str;
            k.a().c(d);
        } catch (Throwable th) {
        }
    }

    @Override // com.jg.ids.i
    public String a(Context context) {
        return c;
    }

    @Override // com.jg.ids.i
    public String b(Context context) {
        return d;
    }

    @Override // com.jg.ids.i
    public String c(Context context) {
        return b;
    }

    protected boolean c() {
        return TextUtils.isEmpty(b) || TextUtils.isEmpty(c) || TextUtils.isEmpty(d);
    }

    @Override // com.jg.ids.i
    public boolean d() {
        return true;
    }
}
