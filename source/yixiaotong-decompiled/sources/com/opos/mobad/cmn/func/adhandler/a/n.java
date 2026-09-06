package com.opos.mobad.cmn.func.adhandler.a;

import android.text.TextUtils;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class n implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6779a;
    public final String b;
    public final String c;
    public com.opos.mobad.t.a d;
    public com.opos.mobad.t.c e;
    public final String f;
    public final long g;

    /* JADX INFO: renamed from: com.opos.mobad.cmn.func.adhandler.a.n$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class a extends n {
        public a(AdItemData adItemData, MaterialData materialData, com.opos.mobad.t.a aVar, com.opos.mobad.t.c cVar, String str) {
            super(adItemData, materialData, aVar, cVar, str, null);
        }

        @Override // com.opos.mobad.cmn.func.adhandler.a.n, com.opos.mobad.cmn.func.adhandler.a.e
        public int b() {
            return 2;
        }
    }

    public static class b extends n {
        public b(AdItemData adItemData, MaterialData materialData, com.opos.mobad.t.a aVar, com.opos.mobad.t.c cVar, String str) {
            super(adItemData, materialData, aVar, cVar, str, null);
        }

        @Override // com.opos.mobad.cmn.func.adhandler.a.n, com.opos.mobad.cmn.func.adhandler.a.e
        public int b() {
            return 12;
        }
    }

    public static class c extends n {
        public c(AdItemData adItemData, MaterialData materialData, com.opos.mobad.t.a aVar, com.opos.mobad.t.c cVar, String str) {
            super(adItemData, materialData, aVar, cVar, str, null);
        }

        @Override // com.opos.mobad.cmn.func.adhandler.a.n, com.opos.mobad.cmn.func.adhandler.a.e
        public int b() {
            return 13;
        }
    }

    private n(AdItemData adItemData, MaterialData materialData, com.opos.mobad.t.a aVar, com.opos.mobad.t.c cVar, String str) {
        this.b = adItemData.f();
        this.c = materialData.c();
        this.f6779a = materialData.k();
        this.d = aVar;
        this.e = cVar;
        this.f = str;
        this.g = -1L;
    }

    /* synthetic */ n(AdItemData adItemData, MaterialData materialData, com.opos.mobad.t.a aVar, com.opos.mobad.t.c cVar, String str, AnonymousClass1 anonymousClass1) {
        this(adItemData, materialData, aVar, cVar, str);
    }

    public static n a(AdItemData adItemData, MaterialData materialData, com.opos.mobad.t.a aVar, com.opos.mobad.t.c cVar, String str) {
        return materialData.B() == 1 ? new a(adItemData, materialData, aVar, cVar, str) : new n(adItemData, materialData, aVar, cVar, str);
    }

    public static n b(AdItemData adItemData, MaterialData materialData, com.opos.mobad.t.a aVar, com.opos.mobad.t.c cVar, String str) {
        return materialData.B() == 1 ? new b(adItemData, materialData, aVar, cVar, str) : new c(adItemData, materialData, aVar, cVar, str);
    }

    public boolean a() {
        return !TextUtils.isEmpty(this.f6779a);
    }

    @Override // com.opos.mobad.cmn.func.adhandler.a.e
    public int b() {
        return 3;
    }
}
