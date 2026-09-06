package com.opos.mobad.service.b;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f7331a;
    private Context b;
    private d c;
    private a d;

    public static b a() {
        b bVar;
        b bVar2 = f7331a;
        if (bVar2 != null) {
            return bVar2;
        }
        synchronized (b.class) {
            bVar = f7331a;
            if (bVar == null) {
                bVar = new b();
                f7331a = bVar;
            }
        }
        return bVar;
    }

    private void b() {
        if (!com.opos.mobad.service.b.a.a.a()) {
            com.opos.cmn.an.f.a.a("Dynamic-Controller", "unsupport Dynamic Template no need to load");
            return;
        }
        com.opos.cmn.an.f.a.a("Dynamic-Controller", "start to pre load mat");
        if (this.d.a()) {
            this.c.a(this.d.b());
        } else {
            com.opos.cmn.an.f.a.a("Dynamic-Controller", "preload dynamic material but null map");
        }
    }

    private boolean c(int i) {
        a aVar = this.d;
        if (aVar == null) {
            return false;
        }
        return aVar.a(i);
    }

    public void a(int i) {
        if (com.opos.mobad.service.b.a.a.a() && this.d != null) {
            com.opos.cmn.an.f.a.b("Dynamic-Controller", "loadMaterial template id = " + i);
            if (!this.d.a() || !this.d.a(i)) {
                com.opos.cmn.an.f.a.b("Dynamic-Controller", "no need load template id = " + i);
                return;
            }
            String strB = this.d.b(i);
            if (TextUtils.isEmpty(strB)) {
                com.opos.cmn.an.f.a.b("Dynamic-Controller", "loadMaterial template id = " + i + ", but null url");
            } else {
                this.c.a(i, strB);
            }
        }
    }

    public void a(int i, String str) {
        a aVar = this.d;
        if (aVar == null) {
            return;
        }
        aVar.a(i, str);
    }

    public void a(Context context) {
        this.b = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.c = new d(this.b);
        this.d = new a();
    }

    public void a(d.a aVar) {
        d dVar = this.c;
        if (dVar != null) {
            dVar.a(aVar);
        }
    }

    public void a(Map<Integer, String> map, boolean z) {
        a aVar = this.d;
        if (aVar == null) {
            return;
        }
        aVar.a(map, z);
        b();
    }

    public int b(int i) {
        com.opos.cmn.an.f.a.b("Dynamic-Controller", "checkDyTemplateState = " + i);
        if (this.d == null || !c(i)) {
            return 1;
        }
        String strB = this.d.b(i);
        if (TextUtils.isEmpty(strB)) {
            com.opos.cmn.an.f.a.b("Dynamic-Controller", "checkDyTemplateFileExist = " + i + ", but null url");
            return 2;
        }
        if (!this.c.a(strB)) {
            return 3;
        }
        com.opos.cmn.an.f.a.b("Dynamic-Controller", "check select template = " + i);
        return 0;
    }

    public void b(int i, String str) {
        a aVar = this.d;
        if (aVar == null) {
            return;
        }
        aVar.b(i, str);
    }

    public void b(Context context) {
        if (com.opos.mobad.service.b.a.a.a()) {
            d.a(context);
        }
    }
}
