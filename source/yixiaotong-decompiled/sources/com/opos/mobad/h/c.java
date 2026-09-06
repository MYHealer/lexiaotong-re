package com.opos.mobad.h;

import android.app.Activity;
import android.os.Bundle;
import com.opos.mobad.model.utils.AdHelper;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c {
    public static final a a(Activity activity, com.opos.mobad.b bVar, String str, com.opos.mobad.ad.c.e.b bVar2, com.opos.mobad.video.player.b.c cVar, com.opos.mobad.video.player.d dVar, com.opos.mobad.cmn.func.adhandler.a aVar, AdHelper.AdHelperData adHelperData, int i) {
        if (adHelperData == null) {
            com.opos.cmn.an.f.a.b("InterstitialCarrierFactory", "createInterstitial()===>do show as null");
            return null;
        }
        Bundle bundle = new Bundle();
        if (bVar2 != null) {
            bundle.putInt("interstitial_scene", bVar2.ordinal());
        }
        if (adHelperData.c.W() == 1 && dVar.a(activity)) {
            com.opos.cmn.an.f.a.b("InterstitialCarrierFactory", "createInterstitial()===>do show as activity");
            return new e(bVar.c(), str, dVar, aVar, cVar, adHelperData, i, bundle);
        }
        com.opos.cmn.an.f.a.b("InterstitialCarrierFactory", "createInterstitial()===>do show as dialog");
        return new d(activity, bVar, str, aVar, new com.opos.mobad.h.a.b(), cVar, adHelperData, i, bundle);
    }
}
