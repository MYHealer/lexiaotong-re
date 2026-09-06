package com.miui.zeus.mimo.sdk;

import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class s {
    public static volatile s c;
    public static boolean d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q f5588a;
    public HashMap<String, o> b = new HashMap<>();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f5589a;

        public a(String str) {
            this.f5589a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            s.this.f5588a.a(this.f5589a, (String) null);
        }
    }

    public s() {
        b();
    }

    public static s a() {
        if (c == null) {
            synchronized (s.class) {
                if (c == null) {
                    c = new s();
                }
            }
        }
        return c;
    }

    public void a(String str, int i) {
        o oVar = this.b.get(str);
        if (oVar == null) {
            oVar = new o(i, 0);
        } else {
            oVar.b = i;
        }
        this.b.put(str, oVar);
    }

    public boolean a(String str) {
        d = false;
        x8.j.execute(new a(str));
        return true;
    }

    public o b(String str) {
        return this.b.get(str);
    }

    public void b() {
        this.f5588a = new q(y8.f5752a);
    }
}
