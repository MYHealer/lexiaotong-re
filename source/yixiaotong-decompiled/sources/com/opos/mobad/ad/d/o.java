package com.opos.mobad.ad.d;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface o extends a<p> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f6646a = new o() { // from class: com.opos.mobad.ad.d.o.1
        @Override // com.opos.mobad.ad.d.a
        public void a(int i, String str) {
            com.opos.cmn.an.f.a.b("INativeTempletAdListener", "onAdFailed ret=" + i + ",msg=" + str);
        }

        @Override // com.opos.mobad.ad.d.o
        public void a(q qVar, p pVar) {
            StringBuilder sbAppend = new StringBuilder("onRenderFailed nativeAdError=").append(qVar != null ? qVar.toString() : "null").append("iNativeTempletAdView=");
            Object obj = pVar;
            if (pVar == null) {
                obj = "null";
            }
            com.opos.cmn.an.f.a.b("INativeTempletAdListener", sbAppend.append(obj).toString());
        }

        @Override // com.opos.mobad.ad.d.a
        public void a(List<p> list) {
            com.opos.cmn.an.f.a.b("INativeTempletAdListener", "onAdReady iNativeTempletAdViewList=", list);
        }

        @Override // com.opos.mobad.ad.d.o
        public void b(p pVar) {
            StringBuilder sb = new StringBuilder("onAdClick iNativeTempletAdView=");
            Object obj = pVar;
            if (pVar == null) {
                obj = "null";
            }
            com.opos.cmn.an.f.a.b("INativeTempletAdListener", sb.append(obj).toString());
        }

        @Override // com.opos.mobad.ad.d.o
        public void c(p pVar) {
            StringBuilder sb = new StringBuilder("onAdShow iNativeTempletAdView=");
            Object obj = pVar;
            if (pVar == null) {
                obj = "null";
            }
            com.opos.cmn.an.f.a.b("INativeTempletAdListener", sb.append(obj).toString());
        }

        @Override // com.opos.mobad.ad.d.o
        public void d(p pVar) {
            StringBuilder sb = new StringBuilder("onAdClose iNativeTempletAdView=");
            Object obj = pVar;
            if (pVar == null) {
                obj = "null";
            }
            com.opos.cmn.an.f.a.b("INativeTempletAdListener", sb.append(obj).toString());
        }

        @Override // com.opos.mobad.ad.d.o
        public void e(p pVar) {
            StringBuilder sb = new StringBuilder("onRenderSuccess iNativeTempletAdView=");
            Object obj = pVar;
            if (pVar == null) {
                obj = "null";
            }
            com.opos.cmn.an.f.a.b("INativeTempletAdListener", sb.append(obj).toString());
        }
    };

    void a(q qVar, p pVar);

    void b(p pVar);

    void c(p pVar);

    void d(p pVar);

    void e(p pVar);
}
