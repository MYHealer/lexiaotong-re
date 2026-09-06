package com.opos.exoplayer.core.c.f;

import android.util.SparseArray;
import com.google.android.exoplayer2.util.MimeTypes;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.drm.DrmInitData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class e implements u.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f6338a;
    private final List<Format> b;

    public e() {
        this(0);
    }

    public e(int i) {
        this(i, Collections.emptyList());
    }

    public e(int i, List<Format> list) {
        this.f6338a = i;
        if (!a(32) && list.isEmpty()) {
            list = Collections.singletonList(Format.a(null, MimeTypes.APPLICATION_CEA608, 0, null));
        }
        this.b = list;
    }

    private w a(u.b bVar) {
        int i;
        String str;
        if (a(32)) {
            return new w(this.b);
        }
        com.opos.exoplayer.core.i.p pVar = new com.opos.exoplayer.core.i.p(bVar.d);
        List<Format> arrayList = this.b;
        while (pVar.b() > 0) {
            int iG = pVar.g();
            int iD = pVar.d() + pVar.g();
            if (iG == 134) {
                arrayList = new ArrayList<>();
                int iG2 = pVar.g() & 31;
                for (int i2 = 0; i2 < iG2; i2++) {
                    String strE = pVar.e(3);
                    int iG3 = pVar.g();
                    if ((iG3 & 128) != 0) {
                        i = iG3 & 63;
                        str = MimeTypes.APPLICATION_CEA708;
                    } else {
                        i = 1;
                        str = MimeTypes.APPLICATION_CEA608;
                    }
                    arrayList.add(Format.a((String) null, str, (String) null, -1, 0, strE, i, (DrmInitData) null));
                    pVar.d(2);
                }
            }
            pVar.c(iD);
        }
        return new w(arrayList);
    }

    private boolean a(int i) {
        return (i & this.f6338a) != 0;
    }

    @Override // com.opos.exoplayer.core.c.f.u.c
    public SparseArray<u> a() {
        return new SparseArray<>();
    }

    @Override // com.opos.exoplayer.core.c.f.u.c
    public u a(int i, u.b bVar) {
        if (i == 2) {
            return new o(new i());
        }
        if (i == 3 || i == 4) {
            return new o(new n(bVar.b));
        }
        if (i == 15) {
            if (a(2)) {
                return null;
            }
            return new o(new d(false, bVar.b));
        }
        if (i == 17) {
            if (a(2)) {
                return null;
            }
            return new o(new m(bVar.b));
        }
        if (i == 21) {
            return new o(new l());
        }
        if (i == 27) {
            if (a(4)) {
                return null;
            }
            return new o(new j(a(bVar), a(1), a(8)));
        }
        if (i == 36) {
            return new o(new k(a(bVar)));
        }
        if (i == 89) {
            return new o(new g(bVar.c));
        }
        if (i != 138) {
            if (i != 129) {
                if (i != 130) {
                    if (i == 134) {
                        if (a(16)) {
                            return null;
                        }
                        return new r(new s());
                    }
                    if (i != 135) {
                        return null;
                    }
                }
            }
            return new o(new b(bVar.b));
        }
        return new o(new f(bVar.b));
    }
}
