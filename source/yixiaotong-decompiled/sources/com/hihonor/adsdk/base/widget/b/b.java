package com.hihonor.adsdk.base.widget.b;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b {
    private static final String hnadsb = "ReserveStateManager";
    private static final com.hihonor.adsdk.common.safe.a<String, Boolean> hnadsc = new com.hihonor.adsdk.common.safe.a<>();
    private final List<c> hnadsa;

    static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: com.hihonor.adsdk.base.widget.b.b$b, reason: collision with other inner class name */
    private static class C0450b {
        private static final b hnadsa = new b(null);

        private C0450b() {
        }
    }

    /* synthetic */ b(a aVar) {
        this();
    }

    public static b hnadsa() {
        return C0450b.hnadsa;
    }

    public List<c> hnadsb() {
        return this.hnadsa;
    }

    private b() {
        this.hnadsa = Collections.synchronizedList(new ArrayList());
    }

    public void hnadsa(String str, Boolean bool) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "putAppPackageName#appPackageName: " + str + ",isReversed: " + bool, new Object[0]);
        com.hihonor.adsdk.common.safe.a<String, Boolean> aVar = hnadsc;
        if (aVar.containsKey(str)) {
            return;
        }
        aVar.put(str, bool);
    }

    public Boolean hnadsb(String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "getReversed#appPackageName: " + str, new Object[0]);
        if (TextUtils.isEmpty(str)) {
            return Boolean.FALSE;
        }
        com.hihonor.adsdk.common.safe.a<String, Boolean> aVar = hnadsc;
        if (aVar.isEmpty()) {
            return Boolean.FALSE;
        }
        Boolean bool = aVar.get(str);
        return bool == null ? Boolean.FALSE : bool;
    }

    public void hnadsa(String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "clearReservedMap#appPackageName: " + str, new Object[0]);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        hnadsc.remove(str);
    }

    public void hnadsa(c cVar) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "addListener#listener size: " + this.hnadsa.size(), new Object[0]);
        if (cVar == null || this.hnadsa.contains(cVar)) {
            return;
        }
        this.hnadsa.add(cVar);
    }

    public void hnadsb(c cVar) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "removeListener#listener size: " + this.hnadsa.size(), new Object[0]);
        this.hnadsa.remove(cVar);
    }
}
