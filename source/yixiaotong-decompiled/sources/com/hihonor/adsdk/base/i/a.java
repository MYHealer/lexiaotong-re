package com.hihonor.adsdk.base.i;

import android.content.Intent;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.common.f.a0;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class a implements b {
    protected d hnadsa;

    public a(d dVar) {
        this.hnadsa = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsb(c cVar) {
        d dVar = this.hnadsa;
        boolean z = dVar != null && dVar.hnadsr();
        d dVar2 = this.hnadsa;
        boolean z2 = dVar2 != null && dVar2.hnadss();
        new com.hihonor.adsdk.base.i.i.b.a().hnadsa(-1).hnadsa("Default").hnadsc(0).hnadsa();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "check remote isAdsKitStart=" + z + ", isRemoteStart = " + z2, new Object[0]);
        if (!hnadsa(z, z2)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "=====> Call Remote Fail. isRemote false, Start Default.", new Object[0]);
            hnadsa(hnadsa(true), cVar, true);
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "=====> Call Remote start.", new Object[0]);
        com.hihonor.adsdk.base.i.i.b bVarHnadsb = hnadsb();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "=====> Call Remote end. code= " + bVarHnadsb.hnadsa() + ", msg= " + bVarHnadsb.hnadsc(), new Object[0]);
        int iHnadsa = bVarHnadsb.hnadsa();
        hnadsa(bVarHnadsb, cVar, bVarHnadsb.hnadsa() == 0);
        if (iHnadsa != 0) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "Remote call fail, Start default, code: " + iHnadsa + ", msg: " + bVarHnadsb.hnadsc(), new Object[0]);
            new com.hihonor.adsdk.base.g.j.d.b(this.hnadsa.hnadsj(), this.hnadsa.hnadsc(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.hnadsa)).hnadsb(com.hihonor.adsdk.base.j.f.hnadsa(this.hnadsa.hnadsn(), this.hnadsa.hnadsk())).hnadsa(0).hnadsa(this.hnadsa.hnadsg()).hnadse();
            hnadsa(hnadsa(false), cVar, true);
        }
    }

    protected abstract com.hihonor.adsdk.base.i.i.b hnadsa(boolean z);

    protected abstract String hnadsa();

    @Override // com.hihonor.adsdk.base.i.b
    public void hnadsa(final c cVar) {
        a0.hnadsb(new Runnable() { // from class: com.hihonor.adsdk.base.i.a$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.hnadsb(cVar);
            }
        });
    }

    protected abstract com.hihonor.adsdk.base.i.i.b hnadsb();

    protected void hnadsa(com.hihonor.adsdk.base.i.i.b bVar, c cVar, boolean z) {
        bVar.hnadsa(z);
        if (cVar != null) {
            cVar.hnadsa(bVar);
        }
    }

    protected com.hihonor.adsdk.base.i.i.b hnadsa(Intent intent, boolean z, int i) {
        try {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "Start Default. isDefault:" + z, new Object[0]);
            HnAds.get().getContext().startActivity(intent);
            return new com.hihonor.adsdk.base.i.i.b.a().hnadsa(0).hnadsa("start Activity SUCCESS").hnadsc(0).hnadsa();
        } catch (Throwable th) {
            String str = "start Activity  Exception: " + th.getMessage();
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa(), str, new Object[0]);
            if (z) {
                i = 1003;
            }
            return new com.hihonor.adsdk.base.i.i.b.a().hnadsa(i).hnadsa(str).hnadsc(0).hnadsa();
        }
    }

    protected boolean hnadsa(boolean z, boolean z2) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "Call isRemote isAdsKitStart=" + z + ",isRemoteStart=" + z2, new Object[0]);
        return z && z2;
    }
}
