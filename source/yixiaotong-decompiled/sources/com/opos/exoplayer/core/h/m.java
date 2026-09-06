package com.opos.exoplayer.core.h;

import android.content.Context;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class m implements g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f6488a;
    private final t<? super g> b;
    private final g.a c;

    public m(Context context, t<? super g> tVar, g.a aVar) {
        this.f6488a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.b = tVar;
        this.c = aVar;
    }

    public m(Context context, String str) {
        this(context, str, (t<? super g>) null);
    }

    public m(Context context, String str, t<? super g> tVar) {
        this(context, tVar, new o(str, tVar));
    }

    @Override // com.opos.exoplayer.core.h.g.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public l a() {
        return new l(this.f6488a, this.b, this.c.a());
    }
}
