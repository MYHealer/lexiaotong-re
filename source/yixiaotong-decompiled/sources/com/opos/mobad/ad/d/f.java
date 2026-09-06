package com.opos.mobad.ad.d;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface f {
    public static final f b = new f() { // from class: com.opos.mobad.ad.d.f.1
        @Override // com.opos.mobad.ad.d.f
        public void a(q qVar) {
            com.opos.cmn.an.f.a.b("INativeAdListener", "onAdFailed=", qVar);
        }

        @Override // com.opos.mobad.ad.d.f
        public void a(q qVar, d dVar) {
            com.opos.cmn.an.f.a.b("INativeAdListener", "onAdError nativeAdError=", qVar, "iNativeAdData=", dVar);
        }

        @Override // com.opos.mobad.ad.d.f
        public void a(List<d> list) {
            com.opos.cmn.an.f.a.b("INativeAdListener", "onAdReady =", list);
        }
    };

    void a(q qVar);

    void a(q qVar, d dVar);

    void a(List<d> list);
}
