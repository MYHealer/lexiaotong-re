package com.kwai.adclient.kscommerciallogger;

import com.kwai.adclient.kscommerciallogger.model.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a {
    private com.kwai.adclient.kscommerciallogger.a.a buk;
    private com.kwai.adclient.kscommerciallogger.a.b bul;
    private JSONObject bum;
    private boolean bun;
    private boolean isDebug;

    public final JSONObject Yg() {
        return this.bum;
    }

    public final boolean Yh() {
        return this.bun;
    }

    public final void a(com.kwai.adclient.kscommerciallogger.a.a aVar, com.kwai.adclient.kscommerciallogger.a.b bVar, JSONObject jSONObject, boolean z, boolean z2) {
        this.buk = aVar;
        this.bul = bVar;
        this.bum = jSONObject;
        this.isDebug = z;
        this.bun = z2;
    }

    public final boolean isDebug() {
        return this.isDebug;
    }

    /* synthetic */ a(byte b) {
        this();
    }

    private a() {
        this.isDebug = false;
        this.bun = false;
    }

    public static a Yf() {
        return C0773a.Yf();
    }

    public final void a(c cVar) {
        if (cVar == null) {
            return;
        }
        b(cVar);
        com.kwai.adclient.kscommerciallogger.a.b bVar = this.bul;
        if (bVar != null) {
            bVar.O(cVar.Yi(), cVar.toString());
        }
    }

    private void b(c cVar) {
        if (this.buk != null) {
            Object[] objArr = new Object[5];
            if (cVar.Yj() != null) {
                String str = cVar.Yj().value;
            }
            if (cVar.Yk() != null) {
                cVar.Yk().getValue();
            }
            cVar.Yn();
            b.A(cVar.Yl());
            b.A(cVar.Ym());
        }
    }

    /* JADX INFO: renamed from: com.kwai.adclient.kscommerciallogger.a$a, reason: collision with other inner class name */
    static final class C0773a {
        private static a buo;

        public static a Yf() {
            if (buo == null) {
                buo = new a((byte) 0);
            }
            return buo;
        }
    }
}
