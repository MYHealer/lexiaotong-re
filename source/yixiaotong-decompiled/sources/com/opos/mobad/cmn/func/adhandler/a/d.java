package com.opos.mobad.cmn.func.adhandler.a;

import android.text.TextUtils;
import com.opos.mobad.model.data.MaterialData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6770a;

    public static class a extends d {
        public a(String str) {
            super(str);
        }

        @Override // com.opos.mobad.cmn.func.adhandler.a.d, com.opos.mobad.cmn.func.adhandler.a.e
        public int b() {
            return 10;
        }
    }

    public d(String str) {
        this.f6770a = str;
    }

    public static d a(MaterialData materialData) {
        return new d(materialData.i());
    }

    public static a b(MaterialData materialData) {
        return new a(materialData.i());
    }

    public boolean a() {
        return !TextUtils.isEmpty(this.f6770a);
    }

    @Override // com.opos.mobad.cmn.func.adhandler.a.e
    public int b() {
        return 4;
    }
}
