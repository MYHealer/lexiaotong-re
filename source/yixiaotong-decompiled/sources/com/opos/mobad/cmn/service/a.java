package com.opos.mobad.cmn.service;

import android.content.Context;
import com.opos.mobad.ui.c.b;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f6843a;
    private volatile com.opos.mobad.cmn.func.a b;
    private volatile com.opos.mobad.activity.webview.a c;

    public static final a a() {
        a aVar;
        a aVar2 = f6843a;
        if (aVar2 != null) {
            return aVar2;
        }
        synchronized (a.class) {
            aVar = f6843a;
            if (aVar == null) {
                aVar = new a();
                f6843a = aVar;
            }
        }
        return aVar;
    }

    public void a(Context context, b.a aVar) {
        b.a().a(aVar);
    }

    public void a(com.opos.mobad.cmn.func.a aVar, com.opos.mobad.activity.webview.a aVar2) {
        this.b = aVar;
        this.c = aVar2;
    }

    public com.opos.mobad.cmn.func.a b() {
        return this.b;
    }

    public com.opos.mobad.activity.webview.a c() {
        return this.c;
    }

    public void d() {
        this.b = null;
        this.c = null;
    }
}
