package com.hihonor.adsdk.base.f;

import com.hihonor.adsdk.base.api.BaseAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class d extends a {
    public d(BaseAd baseAd) {
        super(baseAd);
    }

    @Override // com.hihonor.adsdk.base.f.a
    protected void hnadsa(final a.b bVar) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "start base dp internal.", new Object[0]);
        if (hnadsc()) {
            com.hihonor.adsdk.base.i.e.hnadsa(this.hnadsa).hnadsa(hnadsf()).hnadsb().hnadsa(new com.hihonor.adsdk.base.i.c() { // from class: com.hihonor.adsdk.base.f.d$$ExternalSyntheticLambda0
                @Override // com.hihonor.adsdk.base.i.c
                public final void hnadsa(com.hihonor.adsdk.base.i.i.b bVar2) {
                    this.f$0.hnadsa(bVar, bVar2);
                }
            }).start();
        } else {
            hnadsa(false, 1008, com.hihonor.adsdk.base.init.i.hnadsa(), "BaseDpHandler baseAd is null", bVar);
        }
    }

    @Override // com.hihonor.adsdk.base.f.a
    protected boolean hnadsd() {
        return true;
    }

    protected abstract boolean hnadsf();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsa(a.b bVar, com.hihonor.adsdk.base.i.i.b bVar2) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "start base dp internal remoteResult code=" + bVar2.hnadsa() + ", msg= " + bVar2.hnadsc(), new Object[0]);
        hnadsa(bVar2.hnadsa() == 0, bVar2.hnadsa(), bVar2.hnadsd(), bVar2.hnadsc(), bVar);
    }
}
