package com.opos.mobad.service.c;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.LruCache;
import com.opos.cmn.an.j.b;
import com.opos.mobad.b.a.ah;
import com.opos.mobad.b.a.ai;
import java.io.IOException;
import okio.BufferedSource;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7340a;
    private ah.a b;
    private LruCache<String, C0989a> c = new LruCache<>(100);

    /* JADX INFO: renamed from: com.opos.mobad.service.c.a$a, reason: collision with other inner class name */
    private static class C0989a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f7343a;
        private final long b;

        public C0989a(boolean z, long j) {
            this.f7343a = z;
            this.b = j;
        }
    }

    private void a(String str, C0989a c0989a) {
        if (c0989a == null || a(c0989a)) {
            b(str);
        }
    }

    private boolean a(C0989a c0989a) {
        return c0989a == null || SystemClock.elapsedRealtime() >= c0989a.b;
    }

    private void b(final String str) {
        if (this.b == null || TextUtils.isEmpty("https://adx.ads.heytapmobi.com/show/frequency/req/check")) {
            return;
        }
        b.b(new Runnable() { // from class: com.opos.mobad.service.c.a.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                a aVar;
                String str2;
                int iIntValue;
                boolean z;
                com.opos.mobad.service.g.b.C0996b c0996bA = com.opos.mobad.service.g.b.a(a.this.f7340a, "https://adx.ads.heytapmobi.com/show/frequency/req/check", a.this.b.a(com.opos.mobad.service.g.a.a(a.this.f7340a)).a(com.opos.mobad.service.g.a.a()).a(com.opos.mobad.service.g.a.b()).a(com.opos.mobad.service.g.a.b(a.this.f7340a)).c(str).b().b(), new com.opos.mobad.service.g.b.a<ai>() { // from class: com.opos.mobad.service.c.a.1.1
                    @Override // com.opos.mobad.service.g.b.a
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public ai b(BufferedSource bufferedSource) throws IOException {
                        return ai.c.a(bufferedSource);
                    }
                });
                com.opos.cmn.an.f.a.b("StateManager", "refresh:" + c0996bA.f7380a + "," + c0996bA.c);
                if (c0996bA.f7380a != 200 || c0996bA.c == 0) {
                    return;
                }
                if (((ai) c0996bA.c).f.intValue() == 0) {
                    aVar = a.this;
                    str2 = str;
                    iIntValue = ((ai) c0996bA.c).g.intValue();
                    z = true;
                } else {
                    if (((ai) c0996bA.c).f.intValue() != 1035) {
                        return;
                    }
                    aVar = a.this;
                    str2 = str;
                    iIntValue = ((ai) c0996bA.c).g.intValue();
                    z = false;
                }
                aVar.b(str2, z, iIntValue);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, boolean z, int i) {
        com.opos.cmn.an.f.a.b("StateManager", "update, " + str + ", " + z + "," + i);
        this.c.put(str, new C0989a(z, SystemClock.elapsedRealtime() + ((long) i)));
    }

    public synchronized void a(Context context, String str, String str2, int i, int i2) {
        if (context != null) {
            if (!TextUtils.isEmpty(str)) {
                if (this.f7340a != null) {
                    return;
                }
                this.f7340a = context;
                this.b = new ah.a().a(str).b(str2).a(Integer.valueOf(i)).b(Integer.valueOf(i2)).d(context.getPackageName());
            }
        }
    }

    public void a(String str, boolean z, int i) {
        b(str, z, i);
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        C0989a c0989a = this.c.get(str);
        if (c0989a == null) {
            b(str);
            return true;
        }
        if (c0989a.f7343a) {
            a(str, c0989a);
            return true;
        }
        if (!a(c0989a)) {
            return false;
        }
        b(str);
        return true;
    }
}
