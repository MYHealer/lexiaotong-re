package com.hihonor.adsdk.base.g.j;

import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.common.f.a0;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b {
    private final String hnadsa = "HiAnalyticsImpl";
    private CopyOnWriteArrayList<com.hihonor.adsdk.base.g.j.f.b> hnadsb = new CopyOnWriteArrayList<>();

    class a implements Runnable {
        final /* synthetic */ LinkedHashMap hnadsd;
        final /* synthetic */ String hnadse;
        final /* synthetic */ boolean hnadsf;
        final /* synthetic */ int hnadsg;
        final /* synthetic */ int hnadsh;

        a(LinkedHashMap linkedHashMap, String str, boolean z, int i, int i2) {
            this.hnadsd = linkedHashMap;
            this.hnadse = str;
            this.hnadsf = z;
            this.hnadsg = i;
            this.hnadsh = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!HnAds.get().isInitialized()) {
                com.hihonor.adsdk.common.b.b.hnadsc("HiAnalyticsImpl", "sdk has not init,no upload onEvent", new Object[0]);
                return;
            }
            LinkedHashMap<String, String> linkedHashMapHnadsa = this.hnadsd;
            if (!com.hihonor.adsdk.base.g.j.a.hnadsa().hnadsc()) {
                com.hihonor.adsdk.common.b.b.hnadsc("HiAnalyticsImpl", "HA onEvent, but ha is not init,do it", new Object[0]);
                b.this.hnadsb();
            }
            for (com.hihonor.adsdk.base.g.j.f.b bVar : b.this.hnadsb) {
                if (bVar != null) {
                    linkedHashMapHnadsa = bVar.hnadsa(HnAds.get().getContext(), this.hnadse, linkedHashMapHnadsa, this.hnadsf);
                }
            }
            if (!com.hihonor.adsdk.base.g.j.a.hnadsa().hnadsc()) {
                com.hihonor.adsdk.common.b.b.hnadsc("HiAnalyticsImpl", "HA onEvent, but ha is not init. to temp", new Object[0]);
                com.hihonor.adsdk.base.g.j.a.hnadsa().hnadsa(this.hnadsg, this.hnadse, linkedHashMapHnadsa);
                return;
            }
            if (this.hnadsg == 1) {
                com.hihonor.adsdk.base.g.j.a.hnadsa().hnadsb(this.hnadse, linkedHashMapHnadsa);
            } else {
                com.hihonor.adsdk.base.g.j.a.hnadsa().hnadsa(this.hnadse, linkedHashMapHnadsa);
            }
            if (this.hnadsh == 1) {
                com.hihonor.adsdk.base.g.j.a.hnadsa().hnadsd();
            }
            com.hihonor.adsdk.base.g.j.a.hnadsa().hnadsf();
            com.hihonor.adsdk.common.b.b.hnadsa("HiAnalyticsImpl", "dataFilter=%s ,eventId=%s, reportChannel=%s, mapValue=%s", Integer.valueOf(b.this.hnadsb.size()), this.hnadse, Integer.valueOf(this.hnadsg), linkedHashMapHnadsa);
        }
    }

    /* JADX INFO: renamed from: com.hihonor.adsdk.base.g.j.b$b, reason: collision with other inner class name */
    private static class C0435b {
        private static final b hnadsa = new b();

        private C0435b() {
        }
    }

    public synchronized void hnadsb() {
        hnadsa(false);
    }

    public static b hnadsa() {
        return C0435b.hnadsa;
    }

    public void hnadsb(com.hihonor.adsdk.base.g.j.f.b bVar) {
        this.hnadsb.remove(bVar);
    }

    public synchronized void hnadsa(boolean z) {
        boolean zHnadsc = com.hihonor.adsdk.base.g.j.a.hnadsa().hnadsc();
        com.hihonor.adsdk.common.b.b.hnadsa("HiAnalyticsImpl", (Object) ("HA init status: " + zHnadsc));
        if (!zHnadsc) {
            hnadsa(new com.hihonor.adsdk.base.g.j.f.a());
            com.hihonor.adsdk.base.g.j.a.hnadsa().hnadsb(HnAds.get().getContext());
        } else if (z) {
            com.hihonor.adsdk.base.g.j.a.hnadsa().hnadsg();
        }
    }

    public synchronized void hnadsa(com.hihonor.adsdk.base.g.j.f.b bVar) {
        com.hihonor.adsdk.common.b.b.hnadsa("HiAnalyticsImpl", (Object) ("HA init addDataFilter." + this.hnadsb.size()));
        if (!this.hnadsb.contains(bVar)) {
            this.hnadsb.add(bVar);
        }
    }

    public void hnadsa(int i, int i2, String str, LinkedHashMap<String, String> linkedHashMap, boolean z) {
        a0.hnadse(new a(linkedHashMap, str, z, i2, i));
    }
}
