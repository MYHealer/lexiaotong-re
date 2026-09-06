package com.ubix.ssp.ad.e.a0.c0;

import android.content.Context;
import android.text.TextUtils;
import com.ubix.ssp.ad.e.a0.c0.h.l;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8634a;
    private String b;

    /* JADX INFO: renamed from: com.ubix.ssp.ad.e.a0.c0.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C1063a {
    }

    private a() {
    }

    /* synthetic */ a(C1063a c1063a) {
        this();
    }

    public static void a(Context context, c cVar) {
        l.a(context).a(cVar);
    }

    @Override // com.ubix.ssp.ad.e.a0.c0.c
    public void a(Exception exc) {
        f.a("Client id is " + this.f8634a);
    }

    @Override // com.ubix.ssp.ad.e.a0.c0.c
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            a(new e("OAID is empty"));
            return;
        }
        this.f8634a = str;
        this.b = str;
        f.a("Client id is OAID/AAID: " + this.f8634a);
    }

    @Override // com.ubix.ssp.ad.e.a0.c0.c
    public boolean a() {
        return false;
    }
}
