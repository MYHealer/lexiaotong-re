package com.hihonor.adsdk.base.mediation.core.imp.g;

import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.api.splash.SplashAdLoadListener;
import com.hihonor.adsdk.base.mediation.core.imp.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c {
    private static final String hnadsb = "SplashAdManager";
    private Map<String, com.hihonor.adsdk.base.mediation.core.imp.g.b> hnadsa;

    static /* synthetic */ class a {
    }

    private static final class b {
        private static final c hnadsa = new c(null);

        private b() {
        }
    }

    /* synthetic */ c(a aVar) {
        this();
    }

    public static c hnadsa() {
        return b.hnadsa;
    }

    private c() {
        this.hnadsa = new HashMap();
    }

    public void hnadsa(AdSlot adSlot, SplashAdLoadListener splashAdLoadListener) {
        List<com.hihonor.adsdk.base.mediation.core.imp.a> listHnadsa = d.hnadsa().hnadsa(adSlot, 3);
        if (listHnadsa == null || listHnadsa.size() <= 0) {
            splashAdLoadListener.onFailed(String.valueOf(ErrorCode.RESPONSE_DATA_EMPTY), adSlot.getSlotId() + "no config data");
            return;
        }
        ArrayList arrayList = new ArrayList();
        com.hihonor.adsdk.base.mediation.core.imp.g.b bVar = new com.hihonor.adsdk.base.mediation.core.imp.g.b(splashAdLoadListener);
        for (com.hihonor.adsdk.base.mediation.core.imp.a aVar : listHnadsa) {
            aVar.hnadsh(bVar.hnadsf());
            arrayList.add(new com.hihonor.adsdk.base.mediation.core.imp.g.a(aVar));
        }
        bVar.hnadsa(adSlot);
        bVar.hnadsc(arrayList);
        bVar.hnadsj();
        this.hnadsa.put(adSlot.getSlotId(), bVar);
    }

    public void hnadsa(String str) {
        com.hihonor.adsdk.base.mediation.core.imp.g.b bVarRemove = this.hnadsa.remove(str);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "remove adapter, remove is null " + (bVarRemove == null), new Object[0]);
        if (bVarRemove != null) {
            bVarRemove.hnadsc();
        }
    }
}
