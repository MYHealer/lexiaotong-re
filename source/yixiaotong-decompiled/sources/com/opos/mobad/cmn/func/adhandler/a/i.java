package com.opos.mobad.cmn.func.adhandler.a;

import android.text.TextUtils;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class i implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6774a;
    public final String b;
    public final String c;

    public i(String str, String str2, String str3) {
        this.f6774a = str;
        this.b = str2;
        this.c = str3;
    }

    public static i a(AdItemData adItemData, MaterialData materialData) {
        return new i(materialData.ab(), materialData.ac(), adItemData.ad());
    }

    public boolean a() {
        return (TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.f6774a)) ? false : true;
    }

    @Override // com.opos.mobad.cmn.func.adhandler.a.e
    public int b() {
        return 8;
    }
}
