package com.opos.mobad.model.a;

import com.opos.mobad.b.a.aa;
import com.opos.mobad.b.a.ab;
import com.opos.mobad.model.data.AdData;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c extends a {
    private com.opos.mobad.b d;
    private String e;
    private String f;
    private com.opos.mobad.model.c.d g;

    public c(com.opos.mobad.b bVar, String str, String str2, com.opos.mobad.model.c.c cVar, boolean z, com.opos.mobad.model.e.g.a aVar) {
        super(bVar, str, cVar, z, new g(str, str2, true), aVar);
        this.d = bVar;
        this.e = str;
        this.f = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.opos.mobad.model.c.d a(com.opos.mobad.model.c.d dVar, i iVar) {
        com.opos.cmn.func.a.a.e eVarA = null;
        try {
            List<com.opos.mobad.b.a.b> listH = dVar.h();
            if (listH != null && listH.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (com.opos.mobad.b.a.b bVar : listH) {
                    if (bVar.D != null && bVar.D.size() > 0) {
                        ab abVar = bVar.D.get(0);
                        if (b.a(this.d.b(), abVar, iVar)) {
                            if (b.a(abVar)) {
                                List<aa> list = abVar.ar;
                                if (list == null || list.size() <= 0) {
                                    iVar.d(abVar);
                                } else if (!b.a(this.d, bVar, list)) {
                                    iVar.e(abVar);
                                    com.opos.mobad.model.utils.d.a(this.d.b(), abVar);
                                }
                            }
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("adId", bVar.A);
                            jSONObject.put("adSource", bVar.U);
                            jSONObject.put("bizTraceId", abVar.aV);
                            jSONObject.put("posId", bVar.B);
                            jSONArray.put(jSONObject);
                        }
                    }
                }
                com.opos.cmn.an.f.a.b("cAdLoader", "data size:" + jSONArray.length());
                if (jSONArray.length() <= 0) {
                    return new com.opos.mobad.model.c.b(10004, "adItemList is null.");
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("adReqInfoList", jSONArray);
                this.f7146a.a();
                HashMap map = new HashMap();
                map.put("Content-Type", "application/json");
                map.put("Route-Data", com.opos.cmn.biz.a.e.a(this.d.b()));
                eVarA = com.opos.cmn.func.a.a.b.a().a(this.d.b(), new com.opos.cmn.func.a.a.d.a().a(jSONObject2.toString().getBytes()).a(map).a("POST").b("https://uapi.ads.heytapmobi.com/union/ads/advert/aol").a());
                com.opos.cmn.an.f.a.b("cAdLoader", "check code:" + eVarA.f6077a);
                if (eVarA == null || 200 != eVarA.f6077a) {
                    this.g = dVar;
                    if (eVarA != null) {
                    }
                    return new com.opos.mobad.model.c.b(-1, "unknown error.");
                }
                BufferedInputStream bufferedInputStream = new BufferedInputStream(eVarA.c);
                try {
                    byte[] bArr = new byte[1024];
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        int i = bufferedInputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        if (i > 0) {
                            byteArrayOutputStream.write(bArr, 0, i);
                        }
                    }
                    String str = new String(byteArrayOutputStream.toByteArray(), Charset.forName("UTF-8"));
                    com.opos.cmn.an.f.a.b("cAdLoader", "check result:" + str);
                    JSONObject jSONObject3 = new JSONObject(str);
                    if (jSONObject3.getInt("code") != 0) {
                        com.opos.mobad.model.c.b bVar2 = new com.opos.mobad.model.c.b(-1, "unknown error.");
                        bufferedInputStream.close();
                        if (eVarA != null) {
                            eVarA.a();
                        }
                        return bVar2;
                    }
                    JSONArray jSONArrayOptJSONArray = jSONObject3.optJSONArray("traceIdList");
                    if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                        HashSet hashSet = new HashSet(jSONArrayOptJSONArray.length());
                        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                            hashSet.add(jSONArrayOptJSONArray.getString(i2));
                        }
                        ArrayList arrayList = new ArrayList();
                        for (com.opos.mobad.b.a.b bVar3 : listH) {
                            if (bVar3.D != null && bVar3.D.size() > 0) {
                                ab abVar2 = bVar3.D.get(0);
                                if (hashSet.contains(abVar2.aV)) {
                                    iVar.i(abVar2);
                                    arrayList.add(bVar3);
                                } else {
                                    iVar.h(abVar2);
                                }
                            }
                        }
                        com.opos.cmn.an.f.a.a("cAdLoader", "enable size:" + arrayList.size());
                        if (arrayList.size() <= 0) {
                            com.opos.mobad.model.c.b bVar4 = new com.opos.mobad.model.c.b(10004, "adItemList is null.");
                            bufferedInputStream.close();
                            if (eVarA != null) {
                                eVarA.a();
                            }
                            return bVar4;
                        }
                        com.opos.mobad.model.c.d dVar2 = new com.opos.mobad.model.c.d(dVar.c(), arrayList, dVar.i());
                        bufferedInputStream.close();
                        if (eVarA != null) {
                            eVarA.a();
                        }
                        return dVar2;
                    }
                    com.opos.mobad.model.c.b bVar5 = new com.opos.mobad.model.c.b(10004, "adItemList is null.");
                    bufferedInputStream.close();
                    if (eVarA != null) {
                        eVarA.a();
                    }
                    return bVar5;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            bufferedInputStream.close();
                            throw th2;
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                            throw th2;
                        }
                    }
                }
            }
            return new com.opos.mobad.model.c.b(10004, "adItemList is null.");
        } catch (Throwable th4) {
            try {
                com.opos.cmn.an.f.a.b("cAdLoader", "check fail", th4);
            } finally {
                if (eVarA != null) {
                    eVarA.a();
                }
            }
        }
    }

    private void a(final String str, String str2, final com.opos.mobad.model.c.c cVar) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (!c.this.d.p().a()) {
                    com.opos.cmn.an.f.a.b("cAdLoader", "cache disable");
                    c.this.b(new AdData(10001, "net response is null."));
                    return;
                }
                com.opos.mobad.model.c.c cVar2 = cVar;
                if (cVar2 != null && (com.opos.mobad.service.e.a.a(cVar2.i()) || cVar.l() != null)) {
                    com.opos.cmn.an.f.a.b("cAdLoader", "cache but in childMode", cVar.l());
                    c.this.b(new AdData(10001, "net response is null."));
                    return;
                }
                try {
                    com.opos.mobad.model.c.d dVarA = c.this.d.k().a(str, cVar.e());
                    if (dVarA == null) {
                        com.opos.cmn.an.f.a.b("cAdLoader", "cache null");
                        c.this.b(new AdData(10001, "net response is null."));
                        return;
                    }
                    if (System.currentTimeMillis() >= dVarA.i()) {
                        c.this.a(new com.opos.mobad.model.c.b(10003, "now time over ad expire time."));
                        return;
                    }
                    com.opos.cmn.an.f.a.b("cAdLoader", "cache data:", dVarA);
                    if (dVarA == null || dVarA.h() == null || dVarA.h().size() <= 0) {
                        c.this.a(new com.opos.mobad.model.c.b(10004, "adItemList is null."));
                        return;
                    }
                    c cVar3 = c.this;
                    c.this.a(cVar3.a(dVarA, cVar3.f7146a));
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("cAdLoader", "fail cache", e);
                    c.this.a(new com.opos.mobad.model.c.b(-1, "unknown error."));
                }
            }
        });
    }

    @Override // com.opos.mobad.model.a.a
    public void a(com.opos.mobad.model.c.c cVar) {
        a(this.e, this.f, cVar);
    }

    @Override // com.opos.mobad.model.a.a
    public void a(boolean z) {
        super.a(z);
    }

    @Override // com.opos.mobad.model.a.a
    protected void b(ab abVar) {
    }

    public void f() {
        if (j() != 4 || this.g == null) {
            return;
        }
        com.opos.cmn.an.f.a.b("cAdLoader", "cache origin cache");
        com.opos.mobad.model.e.b bVarK = this.d.k();
        com.opos.mobad.b bVar = this.d;
        String str = this.e;
        com.opos.mobad.model.c.d dVar = this.g;
        bVarK.a(bVar, str, dVar, dVar.h(), this.c.e(), this.b);
    }
}
