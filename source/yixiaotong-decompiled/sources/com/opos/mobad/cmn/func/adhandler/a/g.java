package com.opos.mobad.cmn.func.adhandler.a;

import android.text.TextUtils;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class g implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6772a;
    public final String b;
    public final String c;
    public final com.opos.mobad.t.a d;

    private g(AdItemData adItemData, MaterialData materialData, com.opos.mobad.t.a aVar) {
        this.b = adItemData.f();
        this.c = materialData.c();
        this.f6772a = materialData.u();
        this.d = aVar;
    }

    public static g a(AdItemData adItemData, MaterialData materialData, com.opos.mobad.t.a aVar) {
        return new g(adItemData, materialData, aVar);
    }

    public boolean a() {
        return !TextUtils.isEmpty(this.f6772a);
    }

    @Override // com.opos.mobad.cmn.func.adhandler.a.e
    public int b() {
        return 15;
    }
}
