package com.opos.mobad.model.b.a;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.SplashAd;
import com.huawei.hms.mlplugin.card.bcr.MLBcrCaptureConfig;
import com.loopj.android.http.AsyncHttpClient;
import com.opos.cmn.biz.a.e;
import com.opos.mobad.model.b.c;
import com.opos.mobad.model.c.d;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a implements com.opos.mobad.model.b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.b f7173a;
    private c b;

    public a(com.opos.mobad.b bVar, c cVar) {
        this.f7173a = bVar.c();
        this.b = cVar;
    }

    private String a(List<String> list) {
        return list == null ? com.opos.mobad.model.utils.c.a() : com.opos.mobad.model.utils.c.b();
    }

    private byte[] a(com.opos.mobad.model.c.c cVar) {
        byte[] bArrA;
        c cVar2;
        com.opos.cmn.an.f.a.b("FetchAdEngine", "prepareReqData parser:", this.b, "request:", cVar);
        com.opos.mobad.b bVar = this.f7173a;
        if (bVar == null || (cVar2 = this.b) == null || cVar == null) {
            bArrA = null;
        } else {
            try {
                bArrA = cVar2.a(bVar, cVar);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("FetchAdEngine", "", (Throwable) e);
                bArrA = null;
            }
        }
        com.opos.cmn.an.f.a.b("FetchAdEngine", "prepareReqData result:", bArrA);
        return bArrA;
    }

    private d b(String str, com.opos.mobad.model.c.c cVar, com.opos.mobad.model.e.d dVar) {
        d bVar;
        String strA;
        d bVar2 = new com.opos.mobad.model.c.b(-1, "unknown error.");
        try {
            String strA2 = a(cVar.l());
            if (TextUtils.isEmpty(strA2)) {
                com.opos.cmn.an.f.a.b("FetchAdEngine", "error null req url");
                return bVar2;
            }
            byte[] bArrA = a(cVar);
            if (dVar != null) {
                dVar.a();
            }
            com.opos.cmn.an.f.a.b("FetchAdEngine", "data.size:" + bArrA.length);
            if (bArrA == null) {
                return bVar2;
            }
            HashMap map = new HashMap();
            map.put("Content-Type", "application/x-protobuf");
            map.put("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
            map.put("Accept", "application/x-protobuf");
            map.put("Route-Data", e.a(this.f7173a.b()));
            map.put("Sdk-Vc", "" + com.opos.mobad.service.e.d.a().m());
            if (bArrA.length >= 1024) {
                com.opos.cmn.an.f.a.b("FetchAdEngine", "data.length >= 1024 ,need gzip compress.");
                bArrA = com.opos.cmn.b.c.a.a(bArrA);
                map.put("Content-Encoding", AsyncHttpClient.ENCODING_GZIP);
            }
            com.opos.cmn.func.a.a.d dVarA = new com.opos.cmn.func.a.a.d.a().a("POST").b(strA2).a(bArrA).a(map).a();
            com.opos.cmn.an.f.a.a("FetchAdEngine", "netRequest: " + dVarA);
            com.opos.cmn.func.a.a.e eVarA = null;
            try {
                eVarA = this.f7173a.o().a(dVarA);
                if (eVarA == null) {
                    eVarA = com.opos.cmn.func.a.a.b.a().a(this.f7173a.b(), dVarA);
                }
                if (eVarA != null) {
                    boolean zEqualsIgnoreCase = false;
                    com.opos.cmn.an.f.a.b("FetchAdEngine", "fetchAd netResponse=", eVarA);
                    if (200 == eVarA.f6077a) {
                        com.opos.cmn.func.a.a.a aVar = eVarA.f;
                        if (aVar != null && (strA = aVar.a("Content-Encoding")) != null) {
                            zEqualsIgnoreCase = AsyncHttpClient.ENCODING_GZIP.equalsIgnoreCase(strA);
                        }
                        if (eVarA.c != null) {
                            byte[] bArrA2 = com.opos.cmn.an.e.b.a.a(eVarA.c);
                            com.opos.cmn.an.f.a.b("FetchAdEngine", "needUnCompress=" + zEqualsIgnoreCase);
                            if (zEqualsIgnoreCase) {
                                bArrA2 = com.opos.cmn.b.c.a.b(bArrA2);
                            }
                            if (bArrA2 != null && bArrA2.length > 0) {
                                try {
                                    c cVar2 = this.b;
                                    if (cVar2 != null && (bVar = cVar2.a(bArrA2)) != null) {
                                        bVar2 = bVar;
                                    }
                                } catch (Exception e) {
                                    com.opos.cmn.an.f.a.a("FetchAdEngine", "", (Throwable) e);
                                    bVar = new com.opos.mobad.model.c.b(10102, "parse ad response exception.");
                                }
                            }
                        }
                    } else {
                        String str2 = eVarA.b != null ? eVarA.b : "null";
                        com.opos.cmn.an.f.a.c("FetchAdEngine", "http code=" + eVarA.f6077a + ",msg=" + str2);
                        bVar2 = new com.opos.mobad.model.c.b(eVarA.f6077a, str2);
                    }
                }
                if (eVarA == null) {
                    return bVar2;
                }
                eVarA.a();
                return bVar2;
            } catch (Throwable th) {
                try {
                    com.opos.cmn.an.f.a.a("FetchAdEngine", "", th);
                    com.opos.mobad.model.c.b bVar3 = new com.opos.mobad.model.c.b(MLBcrCaptureConfig.ERROR_CODE_INIT_CAMERA_FAILED, "execute net request exception.");
                    if (eVarA != null) {
                        try {
                            eVarA.a();
                        } catch (Exception e2) {
                            bVar2 = bVar3;
                            e = e2;
                            com.opos.cmn.an.f.a.a("FetchAdEngine", "", (Throwable) e);
                            return bVar2;
                        }
                    }
                    return bVar3;
                } catch (Throwable th2) {
                    if (eVarA != null) {
                        eVarA.a();
                    }
                    throw th2;
                }
            }
        } catch (Exception e3) {
            e = e3;
            com.opos.cmn.an.f.a.a("FetchAdEngine", "", (Throwable) e);
            return bVar2;
        }
    }

    @Override // com.opos.mobad.model.b.b
    public d a(String str, com.opos.mobad.model.c.c cVar, com.opos.mobad.model.e.d dVar) {
        d bVar;
        com.opos.cmn.an.f.a.b("FetchAdEngine", "fetchAd start=" + System.currentTimeMillis());
        d bVar2 = new com.opos.mobad.model.c.b(-1, "unknown error.");
        if (!com.opos.cmn.an.d.a.a(str) && cVar != null) {
            try {
                if (com.opos.cmn.an.h.c.a.d(this.f7173a.b())) {
                    bVar = b(str, cVar, dVar);
                    try {
                        com.opos.cmn.an.f.a.a("FetchAdEngine", "fetchAd fetchAdResponse=", bVar);
                    } catch (Exception e) {
                        e = e;
                        bVar2 = bVar;
                        com.opos.cmn.an.f.a.c("FetchAdEngine", SplashAd.KEY_FETCHAD, e);
                    }
                } else {
                    bVar = new com.opos.mobad.model.c.b(10100, "no net.");
                }
                bVar2 = bVar;
            } catch (Exception e2) {
                e = e2;
            }
        }
        com.opos.cmn.an.f.a.b("FetchAdEngine", "fetchAd end=" + System.currentTimeMillis());
        return bVar2;
    }
}
