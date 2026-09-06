package com.opos.mobad.k;

import android.view.View;
import com.opos.mobad.cmn.func.b.g;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class a implements com.opos.mobad.model.d.a {
    private static final String h = com.opos.cmn.an.b.b.a("b3Bwb191bmlvbl90b2tlbj0=");
    private static Map<String, Long> j = new ConcurrentHashMap();
    private static Map<String, Long> k = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.opos.mobad.b f7076a;
    protected String b;
    protected boolean c;
    protected com.opos.mobad.cmn.func.adhandler.a f;
    protected com.opos.mobad.cmn.func.adhandler.a.c g;
    private long i = 1500;
    protected long d = 0;
    protected long e = 0;

    public a(com.opos.mobad.b bVar, String str, com.opos.mobad.cmn.func.a aVar, com.opos.mobad.cmn.func.adhandler.f fVar) {
        this.f7076a = bVar;
        this.b = str;
        this.f = new com.opos.mobad.cmn.func.adhandler.a(this.f7076a, str, aVar, fVar);
        com.opos.mobad.cmn.func.adhandler.a.c cVarA = g.a(bVar.b(), (View) null);
        this.g = cVarA;
        this.f.a(cVarA);
    }

    protected int a(int i) {
        return 0;
    }

    public void a(View view, AdItemData adItemData, boolean z, Map<String, String> map) {
        if (adItemData != null) {
            try {
                MaterialData materialData = adItemData.i().get(0);
                if (materialData != null) {
                    this.f.a(adItemData);
                    com.opos.mobad.cmn.func.b.e.a(this.f7076a, view, this.b, adItemData, materialData, z, map);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("InterBaseAd", "", (Throwable) e);
            }
        }
    }

    public void a(AdItemData adItemData) {
        if (adItemData != null) {
            try {
                MaterialData materialData = adItemData.i().get(0);
                if (materialData == null || materialData.l() == null || materialData.l().size() <= 0) {
                    return;
                }
                com.opos.mobad.service.f.c.a(this.f7076a.b(), materialData.l());
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("InterBaseAd", "", (Throwable) e);
            }
        }
    }

    protected String b(int i) {
        if (i == 10008) {
            return "ad has showed, please reload ad";
        }
        if (i == 11001) {
            return "ad has destroyed.";
        }
        if (i != 11003) {
            return i != 11005 ? "" : "ads must display on android version after19";
        }
        return "you request ad too often.";
    }
}
