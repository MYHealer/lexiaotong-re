package com.opos.mobad.ad;

import android.app.Activity;
import android.content.Context;
import com.opos.mobad.ad.d.n;
import com.opos.mobad.ad.d.o;
import com.opos.mobad.ad.d.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface c {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f6642a;
        public final String b;

        public a(boolean z, String str) {
            this.f6642a = z;
            this.b = str;
        }
    }

    public static abstract class b implements c {
        @Override // com.opos.mobad.ad.c
        public String a(String str, int i) {
            return null;
        }
    }

    com.opos.mobad.ad.a.b a(Activity activity, String str, String str2, boolean z, com.opos.mobad.ad.a.a aVar, com.opos.mobad.ad.a.c cVar);

    a a(Context context);

    com.opos.mobad.ad.c.a a(Activity activity, String str, String str2, com.opos.mobad.ad.c.e eVar, com.opos.mobad.ad.c.b bVar);

    com.opos.mobad.ad.c.c a(Activity activity, String str, String str2, boolean z, com.opos.mobad.ad.c.d dVar);

    com.opos.mobad.ad.d.c a(Context context, String str, String str2, com.opos.mobad.ad.d.f fVar);

    com.opos.mobad.ad.d.g a(Context context, String str, String str2, int i, int i2, com.opos.mobad.ad.d.j jVar, com.opos.mobad.ad.privacy.a aVar);

    n a(Context context, s sVar, String str, String str2, o oVar);

    com.opos.mobad.ad.e.a a(Context context, String str, String str2, boolean z, com.opos.mobad.ad.e.b bVar);

    com.opos.mobad.ad.f.a a(Context context, String str, String str2, com.opos.mobad.ad.f.f fVar, com.opos.mobad.ad.f.c cVar);

    com.opos.mobad.ad.f.b a(Activity activity, String str, String str2, com.opos.mobad.ad.f.f fVar, com.opos.mobad.ad.f.c cVar);

    String a(String str, int i);

    void a(Context context, String str, String str2, String str3, boolean z, g gVar);

    void b();
}
