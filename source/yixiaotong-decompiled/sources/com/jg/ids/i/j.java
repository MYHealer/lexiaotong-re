package com.jg.ids.i;

import android.content.Context;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
public class j implements com.jg.ids.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4609a;
    private com.jg.ids.m.a b;
    private com.jg.ids.m.a c;
    private com.jg.ids.m.a d = null;

    public static boolean d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.oplus.stdid", 0) != null;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public j(Context context) {
        this.f4609a = context;
        this.b = new com.jg.ids.j(context);
        this.c = new g(context);
    }

    @Override // com.jg.ids.i
    public String a(Context context) {
        return null;
    }

    @Override // com.jg.ids.i
    public String b(Context context) {
        return this.d.b();
    }

    @Override // com.jg.ids.i
    public String c(Context context) {
        return null;
    }

    @Override // com.jg.ids.i
    public boolean d() {
        if (this.f4609a == null) {
            return false;
        }
        if (this.b.a()) {
            this.d = this.b;
        }
        if (this.c.a()) {
            this.d = this.c;
        }
        return this.d != null;
    }
}
