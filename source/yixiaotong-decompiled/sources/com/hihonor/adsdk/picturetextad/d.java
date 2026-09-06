package com.hihonor.adsdk.picturetextad;

import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.api.feed.PictureTextAdLoadListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
final class d {
    private static final String b = "NativeAdManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, com.hihonor.adsdk.picturetextad.b> f3542a;

    static /* synthetic */ class a {
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f3543a = new d(null);

        private b() {
        }
    }

    /* synthetic */ d(a aVar) {
        this();
    }

    public static d a() {
        return b.f3543a;
    }

    private d() {
        this.f3542a = new HashMap();
    }

    public void a(AdSlot adSlot, PictureTextAdLoadListener pictureTextAdLoadListener) {
        List<com.hihonor.adsdk.base.mediation.core.imp.a> listHnadsa = com.hihonor.adsdk.base.mediation.core.imp.d.hnadsa().hnadsa(adSlot, 2);
        if (listHnadsa == null || listHnadsa.isEmpty()) {
            pictureTextAdLoadListener.onFailed(String.valueOf(ErrorCode.RESPONSE_DATA_EMPTY), adSlot.getSlotId() + "no config data");
            return;
        }
        com.hihonor.adsdk.picturetextad.b bVar = new com.hihonor.adsdk.picturetextad.b(pictureTextAdLoadListener);
        ArrayList arrayList = new ArrayList();
        for (com.hihonor.adsdk.base.mediation.core.imp.a aVar : listHnadsa) {
            if (aVar != null) {
                aVar.hnadsh(bVar.hnadsf());
                arrayList.add(new com.hihonor.adsdk.picturetextad.a(aVar));
            }
        }
        bVar.hnadsa(adSlot);
        bVar.hnadsc(arrayList);
        bVar.hnadsj();
        this.f3542a.put(adSlot.getSlotId(), bVar);
    }

    public void a(String str) {
        com.hihonor.adsdk.picturetextad.b bVarRemove = this.f3542a.remove(str);
        com.hihonor.adsdk.common.b.b.hnadsc(b, "remove adapter, remove is null " + (bVarRemove == null), new Object[0]);
        if (bVarRemove != null) {
            bVarRemove.hnadsc();
        }
    }
}
