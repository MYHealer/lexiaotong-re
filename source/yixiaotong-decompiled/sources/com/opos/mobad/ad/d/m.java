package com.opos.mobad.ad.d;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface m extends f, com.opos.mobad.ad.h, com.opos.mobad.ad.j {
    public static final m c = new m() { // from class: com.opos.mobad.ad.d.m.1
        @Override // com.opos.mobad.ad.d.f
        public void a(q qVar) {
            com.opos.cmn.an.f.a.b("INativeRewardAdListener", "onAdFailed=", qVar);
        }

        @Override // com.opos.mobad.ad.d.f
        public void a(q qVar, d dVar) {
            com.opos.cmn.an.f.a.b("INativeRewardAdListener", "onAdError nativeAdError=", qVar, "iNativeAdData=", dVar);
        }

        @Override // com.opos.mobad.ad.h
        public void a(String str) {
            com.opos.cmn.an.f.a.b("INativeRewardAdListener", "onInstallCompleted pkgName=" + str);
        }

        @Override // com.opos.mobad.ad.d.f
        public void a(List<d> list) {
            com.opos.cmn.an.f.a.b("INativeRewardAdListener", "onAdReady =", list);
        }

        @Override // com.opos.mobad.ad.j
        public void a(Object... objArr) {
            StringBuilder sb = new StringBuilder("onReward objects=");
            Object obj = objArr;
            if (objArr == null) {
                obj = "null";
            }
            com.opos.cmn.an.f.a.b("INativeRewardAdListener", sb.append(obj).toString());
        }

        @Override // com.opos.mobad.ad.d.m
        public void b(Object... objArr) {
            StringBuilder sb = new StringBuilder("onRewardFail objects=");
            Object obj = objArr;
            if (objArr == null) {
                obj = "null";
            }
            com.opos.cmn.an.f.a.b("INativeRewardAdListener", sb.append(obj).toString());
        }
    };

    void b(Object... objArr);
}
