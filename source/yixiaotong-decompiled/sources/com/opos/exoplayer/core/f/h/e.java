package com.opos.exoplayer.core.f.h;

import android.text.TextUtils;
import com.opos.exoplayer.core.i.p;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class e extends com.opos.exoplayer.core.f.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f6458a;
    private final p b;
    private final c.a c;
    private final g d;
    private final List<b> e;

    public e() {
        super("WebvttDecoder");
        this.f6458a = new d();
        this.b = new p();
        this.c = new c.a();
        this.d = new g();
        this.e = new ArrayList();
    }

    private static int a(p pVar) {
        int i = -1;
        int iD = 0;
        while (i == -1) {
            iD = pVar.d();
            String strZ = pVar.z();
            if (strZ == null) {
                i = 0;
            } else if ("STYLE".equals(strZ)) {
                i = 2;
            } else {
                i = "NOTE".startsWith(strZ) ? 1 : 3;
            }
        }
        pVar.c(iD);
        return i;
    }

    private static void b(p pVar) {
        while (!TextUtils.isEmpty(pVar.z())) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.exoplayer.core.f.c
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public i a(byte[] bArr, int i, boolean z) throws com.opos.exoplayer.core.f.f {
        this.b.a(bArr, i);
        this.c.a();
        this.e.clear();
        f.a(this.b);
        while (!TextUtils.isEmpty(this.b.z())) {
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            int iA = a(this.b);
            if (iA == 0) {
                return new i(arrayList);
            }
            if (iA == 1) {
                b(this.b);
            } else if (iA == 2) {
                if (!arrayList.isEmpty()) {
                    throw new com.opos.exoplayer.core.f.f("A style block was found after the first cue.");
                }
                this.b.z();
                b bVarC = this.d.c(this.b);
                if (bVarC != null) {
                    this.e.add(bVarC);
                }
            } else if (iA == 3 && this.f6458a.a(this.b, this.c, this.e)) {
                arrayList.add(this.c.b());
                this.c.a();
            }
        }
    }
}
