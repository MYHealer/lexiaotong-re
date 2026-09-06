package com.opos.mobad.cmn.func.adhandler.a;

import android.text.TextUtils;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6771a;
    public final String b;
    public final String c;
    public final String d;

    public f(String str, String str2, String str3, String str4) {
        this.f6771a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    public static f a(AdItemData adItemData, MaterialData materialData) {
        return new f(adItemData.d(), adItemData.e(), materialData.q(), materialData.o());
    }

    public boolean a() {
        return !TextUtils.isEmpty(this.c);
    }

    @Override // com.opos.mobad.cmn.func.adhandler.a.e
    public int b() {
        return 6;
    }
}
