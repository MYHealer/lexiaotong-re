package com.hihonor.adsdk.base.g.k;

import com.hihonor.adsdk.base.bean.c;
import com.hihonor.adsdk.base.dp.entity.AdTrack;
import com.hihonor.adsdk.base.g.i;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {
    private static final int hnadsd = 3;
    private final String hnadsa;
    private final Deque<AdTrack> hnadsb;
    private final Deque<AdTrack> hnadsc;

    /* JADX INFO: renamed from: com.hihonor.adsdk.base.g.k.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0438a {
    }

    private static final class b {
        private static final a hnadsa = new a(null);

        private b() {
        }
    }

    /* synthetic */ a(C0438a c0438a) {
        this();
    }

    public static a hnadsa() {
        return b.hnadsa;
    }

    private void hnadsb(AdTrack adTrack, boolean z) {
        Iterator<AdTrack> it = this.hnadsb.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == adTrack.getId()) {
                com.hihonor.adsdk.common.b.b.hnadsb("TrackReportDispatcher", "queueNotReport is existed!! trackUrl=" + adTrack.getTrackUrl(), new Object[0]);
                return;
            }
        }
        Iterator<AdTrack> it2 = this.hnadsc.iterator();
        while (it2.hasNext()) {
            if (it2.next().getId() == adTrack.getId()) {
                com.hihonor.adsdk.common.b.b.hnadsb("TrackReportDispatcher", "queueReporting is existed!! trackUrl=" + adTrack.getTrackUrl(), new Object[0]);
                return;
            }
        }
        if (z) {
            this.hnadsb.addFirst(adTrack);
        } else {
            this.hnadsb.add(adTrack);
        }
        com.hihonor.adsdk.common.b.b.hnadsc("TrackReportDispatcher", "add#track id=" + adTrack.getId() + ",type=" + adTrack.getTrackingType(), new Object[0]);
    }

    public void hnadsc(AdTrack adTrack) {
        if (Objects.isNull(adTrack)) {
            com.hihonor.adsdk.common.b.b.hnadsc("TrackReportDispatcher", "remove#entity is null.", new Object[0]);
            return;
        }
        synchronized (a.class) {
            this.hnadsc.remove(adTrack);
        }
        com.hihonor.adsdk.common.b.b.hnadsc("TrackReportDispatcher", "remove#track id=" + adTrack.getId() + ",type=" + adTrack.getTrackingType(), new Object[0]);
    }

    private a() {
        this.hnadsa = "TrackReportDispatcher";
        this.hnadsb = new ArrayDeque();
        this.hnadsc = new ArrayDeque();
    }

    public void hnadsa(AdTrack adTrack) {
        hnadsa(adTrack, false);
    }

    public void hnadsa(List<AdTrack> list, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        synchronized (a.class) {
            Iterator<AdTrack> it = list.iterator();
            while (it.hasNext()) {
                hnadsb(it.next(), z);
            }
        }
        hnadsb();
    }

    public void hnadsa(AdTrack adTrack, boolean z) {
        if (adTrack == null) {
            return;
        }
        synchronized (a.class) {
            hnadsb(adTrack, z);
        }
        hnadsb();
    }

    private void hnadsb() {
        int i;
        ArrayList arrayList = new ArrayList();
        synchronized (a.class) {
            com.hihonor.adsdk.common.b.b.hnadsc("TrackReportDispatcher", "promoteAndExecute#readyAdTracks size = " + this.hnadsb.size(), new Object[0]);
            Iterator<AdTrack> it = this.hnadsb.iterator();
            while (it.hasNext()) {
                AdTrack next = it.next();
                if (this.hnadsc.size() >= 3) {
                    com.hihonor.adsdk.common.b.b.hnadsc("TrackReportDispatcher", "promoteAndExecute#run track is full!!", new Object[0]);
                    break;
                } else {
                    it.remove();
                    arrayList.add(next);
                    this.hnadsc.add(next);
                }
            }
            com.hihonor.adsdk.common.b.b.hnadsc("TrackReportDispatcher", "promoteAndExecute#runningAdTracks size = " + this.hnadsc.size(), new Object[0]);
        }
        int size = arrayList.size();
        for (i = 0; i < size; i++) {
            i.hnadsb((AdTrack) arrayList.get(i), new c() { // from class: com.hihonor.adsdk.base.g.k.a$$ExternalSyntheticLambda0
                @Override // com.hihonor.adsdk.base.bean.c
                public final void hnadsa(Object obj) {
                    this.f$0.hnadsb((AdTrack) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsb(AdTrack adTrack) {
        hnadsc(adTrack);
        hnadsb();
    }
}
