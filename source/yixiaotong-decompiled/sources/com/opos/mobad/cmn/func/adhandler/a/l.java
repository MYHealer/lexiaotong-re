package com.opos.mobad.cmn.func.adhandler.a;

import android.text.TextUtils;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class l implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6777a;
    public final String b;
    public final String c;
    public final String d;

    private l(AdItemData adItemData, MaterialData materialData) {
        this.f6777a = adItemData.d();
        this.b = adItemData.e();
        this.c = materialData.q();
        this.d = materialData.o();
    }

    public static l a(AdItemData adItemData, MaterialData materialData) {
        return new l(adItemData, materialData);
    }

    public boolean a() {
        return !TextUtils.isEmpty(this.c);
    }

    @Override // com.opos.mobad.cmn.func.adhandler.a.e
    public int b() {
        return 14;
    }
}
