package com.hihonor.adsdk.base.g;

import com.hihonor.adsdk.base.dp.entity.AdTrack;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class h {
    private static final String hnadsa = "TrackHandler";
    private static final List<com.hihonor.adsdk.base.g.k.b.a> hnadsb;

    static {
        ArrayList arrayList = new ArrayList(2);
        hnadsb = arrayList;
        arrayList.add(new com.hihonor.adsdk.base.g.k.b.b());
        arrayList.add(new com.hihonor.adsdk.base.g.k.b.c());
    }

    public static void hnadsa(List<AdTrack> list) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "deleteMaxFailNotification enter.", new Object[0]);
        if (com.hihonor.adsdk.common.f.f.hnadsa((Collection<?>) list)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "deleteMaxFailNotification enter but adTrackList is null", new Object[0]);
            return;
        }
        Iterator<com.hihonor.adsdk.base.g.k.b.a> it = hnadsb.iterator();
        while (it.hasNext()) {
            it.next().hnadsc(list);
        }
    }

    public static void hnadsb(List<AdTrack> list) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "report enter.", new Object[0]);
        if (com.hihonor.adsdk.common.f.f.hnadsa((Collection<?>) list)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "report enter but adTrackList is null", new Object[0]);
            return;
        }
        Iterator<com.hihonor.adsdk.base.g.k.b.a> it = hnadsb.iterator();
        while (it.hasNext()) {
            it.next().hnadse(list);
        }
    }
}
