package com.adprof.sdk;

import com.adprof.sdk.api.AdError;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class pn implements wn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f1369a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ wn f595a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f596a;

    public pn(wn wnVar, d dVar, String str) {
        this.f595a = wnVar;
        this.f1369a = dVar;
        this.f596a = str;
    }

    @Override // com.adprof.sdk.wn
    public void a(o2 o2Var, fg fgVar) {
        wn wnVar = this.f595a;
        if (wnVar != null) {
            wnVar.a(o2Var, fgVar);
        }
    }

    @Override // com.adprof.sdk.wn
    public void a(o2 o2Var, jp jpVar) {
        try {
            wn wnVar = this.f595a;
            if (wnVar != null) {
                wnVar.a(o2Var, jpVar);
            }
            d dVar = this.f1369a;
            if (dVar == null || jpVar == null || dVar.f190a == null) {
                return;
            }
            AdError adError = AdError.ERROR_MACRO;
            adError.setMessage(jpVar.getMessage());
            wd wdVar = this.f1369a.f190a;
            if (wdVar.f796a == null) {
                wdVar.f796a = new HashMap();
            }
            this.f1369a.f190a.f796a.put("macUrl", this.f596a);
            d dVar2 = this.f1369a;
            oh.a("Macro_Replacement", adError, dVar2.f190a, dVar2);
        } catch (Exception unused) {
        }
    }
}
