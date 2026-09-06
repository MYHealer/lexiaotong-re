package com.opos.mobad.g.a.c;

import android.content.Context;
import com.opos.cmn.i.g;
import com.opos.mobad.c.a.d;
import com.opos.mobad.c.b;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f6960a;

    /* JADX INFO: renamed from: com.opos.mobad.g.a.c.a$a, reason: collision with other inner class name */
    public static final class C0966a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f6961a;
        public final int b;
        public final String c;

        public C0966a(int i, String str) {
            this.f6961a = i == 0;
            this.b = i;
            this.c = str;
        }
    }

    public a(Context context) {
        this.f6960a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    private boolean b(int i) {
        if (!com.opos.mobad.service.e.a.a(b.k().j()) || !c(i)) {
            return false;
        }
        com.opos.cmn.an.f.a.b("", "checkChannel is child " + i);
        return true;
    }

    private boolean c(int i) {
        return i == d.a.b || i == d.a.d || i == d.a.f || i == d.a.g || i == d.a.h || i == d.a.i || i == d.a.j || i == d.a.k || i == d.a.l;
    }

    public C0966a a(int i) {
        if (b.a().a(i)) {
            return b(i) ? new C0966a(-8, "") : new C0966a(0, "");
        }
        return new C0966a(-5, "");
    }

    public C0966a a(int i, boolean z) {
        if (z && c(i)) {
            return new C0966a(-10, "");
        }
        return (c(i) && g.a(this.f6960a)) ? new C0966a(-11, "inter error keyguard") : a(i);
    }

    public C0966a a(String str) {
        if (b.l()) {
            return !b.b().a(str) ? new C0966a(1035, "inter error request") : new C0966a(0, "");
        }
        return new C0966a(-4, "SDK not initialized");
    }

    public C0966a a(String str, int i) {
        if (b.b().a(str)) {
            return b(i) ? new C0966a(-8, "inter error request") : new C0966a(0, "");
        }
        return new C0966a(1035, "inter error request");
    }

    public C0966a a(String str, int i, boolean z) {
        if (z && c(i)) {
            return new C0966a(-10, "inter error request server bidding");
        }
        return (c(i) && g.a(this.f6960a)) ? new C0966a(-11, "inter error keyguard") : a(str, i);
    }
}
