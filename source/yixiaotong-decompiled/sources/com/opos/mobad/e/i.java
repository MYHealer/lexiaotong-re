package com.opos.mobad.e;

import com.opos.mobad.u;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class i implements u {
    i() {
    }

    @Override // com.opos.mobad.u
    public void a() {
        com.opos.mobad.c.b.f().c();
    }

    @Override // com.opos.mobad.u
    public void a(int i, String str, int i2) {
        com.opos.mobad.c.b.f().d().a(i, str, i2);
    }

    @Override // com.opos.mobad.u
    public void a(int i, String str, String str2) {
        com.opos.mobad.c.b.f().d().a(i, str, str2);
    }

    @Override // com.opos.mobad.u
    public void a(String str) {
        com.opos.mobad.c.b.f().d().e(str);
    }

    @Override // com.opos.mobad.u
    public void a(String str, String str2, long j, long j2) {
        com.opos.mobad.c.b.f().d().a(str, str2, j, j2);
    }

    @Override // com.opos.mobad.u
    public void a(Map<String, String> map) {
        com.opos.mobad.c.b.f().d().a(map);
    }

    @Override // com.opos.mobad.u
    public void b(String str) {
        com.opos.mobad.c.b.f().d().g(str);
    }

    @Override // com.opos.mobad.u
    public void b(Map<String, String> map) {
        try {
            com.opos.mobad.c.b.f().a(map);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("MobStatisticManager", "reportAdShow()", e);
        }
    }
}
