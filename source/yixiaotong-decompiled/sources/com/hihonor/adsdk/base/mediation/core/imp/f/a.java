package com.hihonor.adsdk.base.mediation.core.imp.f;

import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.api.reward.RewardAdLoadListener;
import com.hihonor.adsdk.base.mediation.core.imp.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {
    private static final String hnadsb = "RewardAdManager";
    private Map<String, c> hnadsa;

    /* JADX INFO: renamed from: com.hihonor.adsdk.base.mediation.core.imp.f.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0444a {
    }

    private static final class b {
        private static final a hnadsa = new a(null);

        private b() {
        }
    }

    /* synthetic */ a(C0444a c0444a) {
        this();
    }

    public static a hnadsa() {
        return b.hnadsa;
    }

    private a() {
        this.hnadsa = new HashMap();
    }

    public void hnadsa(AdSlot adSlot, RewardAdLoadListener rewardAdLoadListener) {
        List<com.hihonor.adsdk.base.mediation.core.imp.a> listHnadsa = d.hnadsa().hnadsa(adSlot, 4);
        if (listHnadsa == null || listHnadsa.size() <= 0) {
            rewardAdLoadListener.onFailed(String.valueOf(ErrorCode.RESPONSE_DATA_EMPTY), adSlot.getSlotId() + "no config data");
            return;
        }
        c cVar = new c(rewardAdLoadListener);
        ArrayList arrayList = new ArrayList();
        for (com.hihonor.adsdk.base.mediation.core.imp.a aVar : listHnadsa) {
            aVar.hnadsh(cVar.hnadsf());
            arrayList.add(new com.hihonor.adsdk.base.mediation.core.imp.f.b(aVar));
        }
        cVar.hnadsa(adSlot);
        cVar.hnadsc(arrayList);
        cVar.hnadsj();
        this.hnadsa.put(adSlot.getSlotId(), cVar);
    }

    public void hnadsa(String str) {
        c cVarRemove = this.hnadsa.remove(str);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "remove adapter, remove is null " + (cVarRemove == null), new Object[0]);
        if (cVarRemove != null) {
            cVarRemove.hnadsc();
        }
    }
}
