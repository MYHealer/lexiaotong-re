package com.opos.mobad.ad;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface g {
    public static final g c = new g() { // from class: com.opos.mobad.ad.g.1
        @Override // com.opos.mobad.ad.g
        public void a() {
            com.opos.cmn.an.f.a.b("IInitListener", "init success.");
        }

        @Override // com.opos.mobad.ad.g
        public void a(String str) {
            StringBuilder sb = new StringBuilder("init failed.reason=");
            if (str == null) {
                str = "";
            }
            com.opos.cmn.an.f.a.c("IInitListener", sb.append(str).toString());
        }
    };

    void a();

    void a(String str);
}
