package com.opos.mobad.model.b.a;

import android.content.Context;
import com.opos.mobad.l.c;
import com.opos.mobad.model.b.d;
import com.opos.mobad.model.c.f;
import com.opos.mobad.model.c.g;
import com.stub.StubApp;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7174a;

    public b(Context context) {
        this.f7174a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    private void a(final g gVar, final CountDownLatch countDownLatch, final String str, final com.opos.mobad.l.a aVar) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.b.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        gVar.a(str, c.a(b.this.f7174a, aVar));
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.a("FetchMaterialEngine", "", (Throwable) e);
                    }
                } finally {
                    countDownLatch.countDown();
                }
            }
        });
    }

    @Override // com.opos.mobad.model.b.d
    public g a(f fVar) {
        g gVar = null;
        if (fVar == null) {
            return null;
        }
        try {
            ConcurrentHashMap<String, com.opos.mobad.l.a> concurrentHashMapA = fVar.a();
            if (concurrentHashMapA == null || concurrentHashMapA.size() <= 0) {
                return null;
            }
            g gVar2 = new g();
            try {
                CountDownLatch countDownLatch = new CountDownLatch(concurrentHashMapA.size());
                for (Map.Entry<String, com.opos.mobad.l.a> entry : concurrentHashMapA.entrySet()) {
                    if (entry != null) {
                        a(gVar2, countDownLatch, entry.getKey(), entry.getValue());
                    } else {
                        countDownLatch.countDown();
                    }
                }
                countDownLatch.await(30L, TimeUnit.MINUTES);
                return gVar2;
            } catch (Exception e) {
                e = e;
                gVar = gVar2;
            }
        } catch (Exception e2) {
            e = e2;
        }
        com.opos.cmn.an.f.a.c("FetchMaterialEngine", "fetchMaterial", e);
        return gVar;
    }
}
