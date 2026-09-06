package com.opos.mobad.template;

import android.content.Context;
import com.opos.mobad.template.c.j;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.d.a f7585a;
    private j b;

    public f(j jVar, com.opos.mobad.d.a aVar) {
        this.f7585a = aVar;
        this.b = jVar;
    }

    public final a a(Context context, int i, com.opos.mobad.template.l.a aVar, a.InterfaceC1003a interfaceC1003a) {
        com.opos.mobad.d.a aVar2;
        j jVar = this.b;
        if (jVar == null || (aVar2 = this.f7585a) == null) {
            return null;
        }
        return jVar.a(context, i, aVar, interfaceC1003a, aVar2);
    }
}
