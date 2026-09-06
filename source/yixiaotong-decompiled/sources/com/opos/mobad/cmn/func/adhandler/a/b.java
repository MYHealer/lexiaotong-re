package com.opos.mobad.cmn.func.adhandler.a;

import android.text.TextUtils;
import com.opos.mobad.model.data.MaterialData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6768a;

    public static class a extends b {
        public a(String str) {
            super(str);
        }

        @Override // com.opos.mobad.cmn.func.adhandler.a.e
        public int b() {
            return 11;
        }
    }

    /* JADX INFO: renamed from: com.opos.mobad.cmn.func.adhandler.a.b$b, reason: collision with other inner class name */
    public static class C0948b extends b {
        public C0948b(String str) {
            super(str);
        }

        @Override // com.opos.mobad.cmn.func.adhandler.a.e
        public int b() {
            return 9;
        }
    }

    public static class c extends b {
        public c(String str) {
            super(str);
        }

        @Override // com.opos.mobad.cmn.func.adhandler.a.e
        public int b() {
            return 18;
        }
    }

    public static class d extends b {
        public d(String str) {
            super(str);
        }

        @Override // com.opos.mobad.cmn.func.adhandler.a.e
        public int b() {
            return 5;
        }
    }

    protected b(String str) {
        this.f6768a = str;
    }

    public static com.opos.mobad.cmn.func.adhandler.a.a.a a(MaterialData materialData) {
        return new com.opos.mobad.cmn.func.adhandler.a.a.a(materialData != null ? materialData.q() : "", materialData != null ? materialData.ag() : "");
    }

    public static d a(String str) {
        return new d(str);
    }

    public static C0948b b(String str) {
        return new C0948b(str);
    }

    public static a c(String str) {
        return new a(str);
    }

    public boolean a() {
        return !TextUtils.isEmpty(this.f6768a);
    }
}
