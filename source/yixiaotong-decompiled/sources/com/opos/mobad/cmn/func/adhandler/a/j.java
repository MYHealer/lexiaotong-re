package com.opos.mobad.cmn.func.adhandler.a;

import android.text.TextUtils;
import com.opos.mobad.model.data.MaterialData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class j implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6775a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    public j(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f6775a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
    }

    public static j a(MaterialData materialData, String str) {
        return new j(materialData.i(), materialData.r(), materialData.o(), materialData.O(), materialData.P(), str);
    }

    public boolean a() {
        return !TextUtils.isEmpty(this.f6775a);
    }

    @Override // com.opos.mobad.cmn.func.adhandler.a.e
    public int b() {
        return 1;
    }
}
