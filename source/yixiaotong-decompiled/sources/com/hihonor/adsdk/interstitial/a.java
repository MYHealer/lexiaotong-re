package com.hihonor.adsdk.interstitial;

import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.api.interstitial.InterstitialAdLoadListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {
    private static final String b = "InterstitialAdManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, d> f3525a = new HashMap();

    /* JADX INFO: renamed from: com.hihonor.adsdk.interstitial.a$a, reason: collision with other inner class name */
    private static final class C0466a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f3526a = new a();

        private C0466a() {
        }
    }

    public static a a() {
        return C0466a.f3526a;
    }

    public void a(AdSlot adSlot, InterstitialAdLoadListener interstitialAdLoadListener) {
        List<com.hihonor.adsdk.base.mediation.core.imp.a> listHnadsa = com.hihonor.adsdk.base.mediation.core.imp.d.hnadsa().hnadsa(adSlot, 5);
        if (listHnadsa == null || listHnadsa.isEmpty()) {
            interstitialAdLoadListener.onFailed(String.valueOf(ErrorCode.RESPONSE_DATA_EMPTY), adSlot.getSlotId() + "no config data");
            return;
        }
        d dVar = new d(interstitialAdLoadListener);
        ArrayList arrayList = new ArrayList();
        for (com.hihonor.adsdk.base.mediation.core.imp.a aVar : listHnadsa) {
            if (aVar != null) {
                aVar.hnadsh(dVar.hnadsf());
                arrayList.add(new c(aVar));
            }
        }
        dVar.hnadsa(adSlot);
        dVar.hnadsc(arrayList);
        dVar.hnadsj();
        this.f3525a.put(adSlot.getSlotId(), dVar);
    }

    public void a(String str) {
        d dVarRemove = this.f3525a.remove(str);
        com.hihonor.adsdk.common.b.b.hnadsc(b, "remove adapter, remove is null " + (dVarRemove == null), new Object[0]);
        if (dVarRemove != null) {
            dVarRemove.hnadsc();
        }
    }
}
