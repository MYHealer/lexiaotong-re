package com.opos.mobad.cmn.service.a;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.f.f;
import com.stub.StubApp;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f6844a;
    private static final byte[] b = new byte[0];
    private Context c;
    private final int d = 100;
    private Map<Integer, C0953a> e = new ConcurrentHashMap();

    /* JADX INFO: renamed from: com.opos.mobad.cmn.service.a.a$a, reason: collision with other inner class name */
    class C0953a implements f {
        private c b;

        public C0953a(c cVar) {
            this.b = cVar;
        }

        @Override // com.opos.mobad.f.f
        public void a(int i, int i2, String str, String str2) {
            c cVar = this.b;
            if (cVar != null) {
                cVar.a(i, i2, str, str2);
            }
        }

        @Override // com.opos.mobad.f.f
        public void a(int i, int i2, String str, String str2, String str3) {
            c cVar = this.b;
            if (cVar != null) {
                cVar.a(i, i2, str, str2, str3);
            }
        }

        @Override // com.opos.mobad.f.f
        public void b(int i, int i2, String str, String str2) {
            c cVar = this.b;
            if (cVar != null) {
                cVar.b(i, i2, str, str2);
            }
        }

        @Override // com.opos.mobad.f.f
        public void c(int i, int i2, String str, String str2) {
            c cVar = this.b;
            if (cVar != null) {
                cVar.c(i, i2, str, str2);
            }
        }

        @Override // com.opos.mobad.f.f
        public void d(int i, int i2, String str, String str2) {
            c cVar = this.b;
            if (cVar != null) {
                cVar.d(i, i2, str, str2);
            }
        }

        @Override // com.opos.mobad.f.f
        public void e(int i, int i2, String str, String str2) {
            c cVar = this.b;
            if (cVar != null) {
                cVar.e(i, i2, str, str2);
                a.this.e.remove(Integer.valueOf(this.b.hashCode()));
            }
        }

        @Override // com.opos.mobad.f.f
        public void f(int i, int i2, String str, String str2) {
            c cVar = this.b;
            if (cVar != null) {
                cVar.f(i, i2, str, str2);
            }
        }
    }

    private a(Context context) {
        this.c = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public static a a(Context context) {
        a aVar = f6844a;
        if (aVar == null) {
            synchronized (b) {
                aVar = f6844a;
                if (aVar == null) {
                    aVar = new a(context);
                    f6844a = aVar;
                }
            }
        }
        return aVar;
    }

    public b a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (com.opos.cmn.an.e.b.a.a(com.opos.cmn.d.a.a(this.c, str))) {
            return new b(105, 100);
        }
        int[] iArrA = com.opos.mobad.f.c.a(this.c).a(str, str2);
        return new b(iArrA[0], iArrA[1]);
    }

    public void a() {
        com.opos.mobad.f.c.a(this.c).a();
    }

    public void a(int i, boolean z) {
        com.opos.mobad.f.c.a(this.c).a(i, z, new d());
    }

    public void a(c cVar) {
        if (cVar == null) {
            return;
        }
        com.opos.mobad.f.c.a(this.c).a(this.e.remove(Integer.valueOf(cVar.hashCode())));
    }

    public void a(String str) {
        com.opos.mobad.f.c.a(this.c).a(str);
    }

    public void a(String str, String str2, String str3, String str4, c cVar) {
        C0953a c0953a;
        if (cVar != null) {
            c0953a = new C0953a(cVar);
            this.e.put(Integer.valueOf(cVar.hashCode()), c0953a);
        } else {
            c0953a = null;
        }
        com.opos.mobad.f.c.a(this.c).a(str, str2, str3, str4, c0953a);
    }

    public void b(String str) {
        com.opos.mobad.f.c.a(this.c).b(str);
    }

    public void c(String str) {
        com.opos.mobad.f.c.a(this.c).c(str);
    }
}
