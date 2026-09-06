package com.opos.cmn.an.g;

import android.content.Context;
import com.stub.StubApp;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static e f5929a;
    private static final byte[] b = new byte[0];
    private static AtomicLong c = new AtomicLong(0);

    public static long a() {
        return c.getAndIncrement();
    }

    public static g a(Context context, long j, f fVar) {
        b bVar;
        Context origApplicationContext;
        b();
        if (context != null && fVar != null) {
            try {
                int i = fVar.f5925a;
                if (i == 0) {
                    bVar = f5929a.f5923a;
                    origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                } else {
                    if (i == 1) {
                        return f5929a.b.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), j, fVar);
                    }
                    if (i == 2) {
                        return f5929a.c.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), j, fVar);
                    }
                    if (i == 3) {
                        return f5929a.d.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), j, fVar);
                    }
                    bVar = f5929a.f5923a;
                    origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                }
                return bVar.a(origApplicationContext, j, fVar);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("NetTool", "execute", e);
            }
        }
        return null;
    }

    public static void a(long j) {
        try {
            f5929a.f5923a.a(j);
            f5929a.b.a(j);
            f5929a.c.a(j);
            f5929a.d.a(j);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("NetTool", "shutDown", e);
        }
    }

    private static void b() {
        if (f5929a == null) {
            synchronized (b) {
                if (f5929a == null) {
                    f5929a = new e.a().a(new com.opos.cmn.an.g.a.c.a()).a(new com.opos.cmn.an.g.a.b.a()).a(new com.opos.cmn.an.g.a.d.a()).a(new com.opos.cmn.an.g.a.e.a()).a();
                }
            }
        }
    }
}
