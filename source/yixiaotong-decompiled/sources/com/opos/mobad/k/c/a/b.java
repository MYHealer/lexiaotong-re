package com.opos.mobad.k.c.a;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.opos.mobad.model.data.AdItemData;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.k.d.a.a f7108a;
    private com.opos.mobad.k.a.a b;

    public b(Context context, com.opos.mobad.k.a.a aVar, FrameLayout frameLayout) {
        this.f7108a = new com.opos.mobad.k.d.a.b(context, this, frameLayout);
        this.b = aVar;
    }

    @Override // com.opos.mobad.k.c.a.a
    public void a() {
        this.f7108a.b();
    }

    @Override // com.opos.mobad.k.c.a.a
    public void a(View view, AdItemData adItemData) {
        this.b.a(view, adItemData);
    }

    @Override // com.opos.mobad.k.c.a.a
    public void a(View view, AdItemData adItemData, long j) {
        this.b.a(view, adItemData, j);
    }

    @Override // com.opos.mobad.k.c.a.a
    public void a(View view, int[] iArr, long j, com.opos.mobad.cmn.func.b.a aVar) {
        this.b.a(view, iArr, j, aVar);
    }

    @Override // com.opos.mobad.k.c.a.a
    public void a(AdItemData adItemData) {
        this.f7108a.a(adItemData);
    }

    @Override // com.opos.mobad.k.c.a.a
    public void a(AdItemData adItemData, String str) {
        this.f7108a.a(adItemData, str);
    }

    @Override // com.opos.mobad.k.c.a.a
    public void a(Map<String, String> map) {
        this.b.a(map);
    }

    @Override // com.opos.mobad.k.c.a.a
    public void b() {
        this.f7108a.c();
    }

    @Override // com.opos.mobad.k.c.a.a
    public void b(View view, AdItemData adItemData) {
        this.b.b(view, adItemData);
    }

    @Override // com.opos.mobad.k.c.a.a
    public void b(View view, AdItemData adItemData, long j) {
        com.opos.mobad.k.a.a aVar = this.b;
        if (aVar != null) {
            aVar.b(view, adItemData, j);
        }
    }

    @Override // com.opos.mobad.k.c.a.a
    public void b(AdItemData adItemData, String str) {
        this.f7108a.b(adItemData, str);
    }

    @Override // com.opos.mobad.k.c.a.a
    public void c(View view, AdItemData adItemData, long j) {
        this.b.c(view, adItemData, j);
    }
}
