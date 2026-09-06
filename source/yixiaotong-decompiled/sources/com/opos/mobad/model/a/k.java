package com.opos.mobad.model.a;

import android.content.Context;
import com.opos.mobad.b.a.ab;
import com.stub.StubApp;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class k implements com.opos.mobad.model.b.e<com.opos.mobad.b.a.b> {
    @Override // com.opos.mobad.model.b.e
    public void a(com.opos.mobad.b bVar, com.opos.mobad.b.a.b bVar2, int i) {
        Context origApplicationContext;
        if (bVar == null || (origApplicationContext = StubApp.getOrigApplicationContext(bVar.b().getApplicationContext())) == null || !com.opos.cmn.an.h.c.a.e(bVar.b())) {
            return;
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        b.a(bVar, bVar2, (Set<com.opos.mobad.model.c.e>) hashSet, false, (com.opos.mobad.model.e.m) null);
        b.a(bVar, bVar2.aj, (Set<com.opos.mobad.model.c.e>) hashSet, false, (com.opos.mobad.model.e.m) null);
        b.a(bVar, bVar2.ai, (Set<com.opos.mobad.model.c.e>) hashSet, false, (com.opos.mobad.model.e.m) null);
        if (bVar2.D != null && bVar2.D.size() >= 0 && bVar2.D.get(0) != null) {
            b.a(bVar, bVar2.D.get(0), hashSet, hashSet2, false, null);
            ab abVar = bVar2.D.get(0);
            if (i == 5 && b.a(abVar)) {
                com.opos.mobad.model.utils.d.a(origApplicationContext, abVar);
            }
        }
        com.opos.cmn.an.f.a.b("resLoader", "fm:" + hashSet.size() + ",om:" + hashSet2.size());
        if (hashSet.size() > 0) {
            com.opos.cmn.an.f.a.b("resLoader", "resource result:" + new com.opos.mobad.model.e.e(origApplicationContext).a(hashSet, null));
        }
    }
}
