package com.jg.ids.k;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
final class b extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4613a;
    private int b;
    private /* synthetic */ a c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, Handler handler, String str, int i) {
        super(null);
        this.c = aVar;
        this.f4613a = str;
        this.b = i;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        super.onChange(z);
        this.c.b(this.b, this.f4613a);
    }
}
