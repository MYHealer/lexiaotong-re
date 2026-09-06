package com.opos.mobad.cmn.func.adhandler.a;

import android.text.TextUtils;
import com.opos.mobad.model.data.MaterialData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class h implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f6773a;
    public final String b;

    public h(MaterialData materialData) {
        this.f6773a = materialData.I() == 3;
        this.b = materialData.J();
    }

    public static h a(MaterialData materialData) {
        if (TextUtils.isEmpty(materialData.J())) {
            return null;
        }
        return new h(materialData);
    }

    public boolean a() {
        return !TextUtils.isEmpty(this.b);
    }

    @Override // com.opos.mobad.cmn.func.adhandler.a.e
    public int b() {
        return 1;
    }
}
