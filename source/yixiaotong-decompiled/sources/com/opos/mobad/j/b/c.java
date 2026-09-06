package com.opos.mobad.j.b;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static AtomicBoolean f7049a = new AtomicBoolean(false);

    public static final com.opos.mobad.d.d.a a(Context context, int i, com.opos.mobad.d.d.b bVar) {
        return 1 == i ? new com.opos.mobad.j.c.b(context, bVar) : new com.opos.mobad.j.c.a(context, bVar);
    }

    public static final com.opos.mobad.d.d.a a(Context context, com.opos.mobad.d.d.b bVar) {
        return a(context, b(), bVar);
    }

    public static com.opos.mobad.template.l.a a(int i) {
        return 1 == i ? new b() : new a();
    }

    public static void a(boolean z) {
        f7049a.set(z);
    }

    public static boolean a() {
        return f7049a.get();
    }

    public static int b() {
        return 2;
    }
}
