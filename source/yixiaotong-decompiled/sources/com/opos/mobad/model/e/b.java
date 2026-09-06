package com.opos.mobad.model.e;

import android.content.Context;
import com.opos.mobad.provider.ad.AdEntity;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f7202a;
    private Context b;
    private com.opos.mobad.provider.ad.a c;
    private com.opos.mobad.model.b.a d = new com.opos.mobad.model.a.d();
    private com.opos.mobad.model.b.e e = new com.opos.mobad.model.a.k();

    private b(Context context) {
        this.b = context;
        this.c = new com.opos.mobad.provider.ad.a(context);
    }

    public static final b a(Context context) {
        b bVar;
        b bVar2 = f7202a;
        if (bVar2 != null) {
            return bVar2;
        }
        synchronized (b.class) {
            bVar = f7202a;
            if (bVar == null) {
                bVar = new b(context);
                f7202a = bVar;
            }
        }
        return bVar;
    }

    public com.opos.mobad.model.c.d a(String str, int i) throws Exception {
        StringBuilder sbAppend;
        AdEntity adEntityA = this.c.a(str);
        if (adEntityA == null) {
            sbAppend = new StringBuilder("getCache null:");
        } else {
            if (-1 == adEntityA.d || adEntityA.d == i) {
                return this.d.a(adEntityA);
            }
            sbAppend = new StringBuilder("get cache but diff posType:").append(adEntityA.d).append(",").append(i).append(",");
        }
        com.opos.cmn.an.f.a.b("acManager", sbAppend.append(str).toString());
        return null;
    }

    public void a(final com.opos.mobad.b bVar, final String str, final com.opos.mobad.model.c.d dVar, final List<T> list, final int i, final boolean z) {
        com.opos.cmn.an.f.a.b("acManager", "cache list num:" + (list != null ? list.size() : 0));
        if (list == null || list.size() <= 0) {
            return;
        }
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.e.b.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    b.this.c.a(str, b.this.d.a(list, dVar, i));
                    if (z) {
                        b.this.e.a(bVar, list.get(0), i);
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("acManager", "cache fail", (Throwable) e);
                }
            }
        });
    }
}
