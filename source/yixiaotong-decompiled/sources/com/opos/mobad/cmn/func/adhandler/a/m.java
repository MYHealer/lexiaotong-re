package com.opos.mobad.cmn.func.adhandler.a;

import android.text.TextUtils;
import com.opos.mobad.model.data.AdItemData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class m implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6778a;
    public String b;
    public String c;

    public m(String str, String str2, String str3) {
        this.f6778a = str;
        this.b = str2;
        this.c = str3;
    }

    public static m a(AdItemData adItemData) {
        return new m(adItemData.ad(), "nativeOpenAdCanvas", adItemData.ah());
    }

    public boolean a() {
        return (TextUtils.isEmpty(this.f6778a) || TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c)) ? false : true;
    }

    @Override // com.opos.mobad.cmn.func.adhandler.a.e
    public int b() {
        return 19;
    }
}
