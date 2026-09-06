package com.opos.exoplayer.core.g;

import com.opos.exoplayer.core.e.m;
import com.opos.exoplayer.core.i.y;
import com.opos.exoplayer.core.v;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f6476a;
    public final boolean[] b;
    public final g c;
    public final Object d;
    public final v[] e;

    public i(m mVar, boolean[] zArr, g gVar, Object obj, v[] vVarArr) {
        this.f6476a = mVar;
        this.b = zArr;
        this.c = gVar;
        this.d = obj;
        this.e = vVarArr;
    }

    public boolean a(i iVar) {
        if (iVar == null || iVar.c.f6474a != this.c.f6474a) {
            return false;
        }
        for (int i = 0; i < this.c.f6474a; i++) {
            if (!a(iVar, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean a(i iVar, int i) {
        return iVar != null && this.b[i] == iVar.b[i] && y.a(this.c.a(i), iVar.c.a(i)) && y.a(this.e[i], iVar.e[i]);
    }
}
