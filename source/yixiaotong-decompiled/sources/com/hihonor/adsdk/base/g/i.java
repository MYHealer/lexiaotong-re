package com.hihonor.adsdk.base.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.dp.AdDatabase;
import com.hihonor.adsdk.base.dp.entity.AdTrack;
import com.hihonor.adsdk.base.g.j.d.a1;
import com.hihonor.adsdk.common.f.a0;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class i {
    private static final String hnadsa = "TrackReportManager";
    public static final long hnadsb = 60000;
    private static final int hnadsc = 50;
    private static final int hnadsd = 3;
    private static final long hnadse = 600000;
    private static final int hnadsf = 1;
    private static final long hnadsg = 2000;
    private static Handler hnadsh;
    private static final Map<Integer, f<? extends d>> hnadsi;

    private static class a implements Runnable {
        private long hnadsd;

        public a(long j) {
            this.hnadsd = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AdDatabase.hnadsa(HnAds.get().getContext()) == null) {
                com.hihonor.adsdk.common.b.b.hnadsc(i.hnadsa, "updateReportState#AdDatabase is null.", new Object[0]);
                return;
            }
            try {
                com.hihonor.adsdk.common.b.b.hnadsa(i.hnadsa, (Object) "updateReportState#execute track url update state.");
                if (this.hnadsd <= 0) {
                    this.hnadsd = 2000L;
                }
                if (AdDatabase.hnadsa(HnAds.get().getContext()).hnadsa().hnadsa() == 0) {
                    com.hihonor.adsdk.common.b.b.hnadsc(i.hnadsa, ">>>>> updateReportState#report cache fail. cause by database is null.", new Object[0]);
                } else {
                    AdDatabase.hnadsa(HnAds.get().getContext()).hnadsa().hnadsa(0, 1);
                    i.hnadsa("updateReportState#init startReportPoll", this.hnadsd);
                }
            } catch (Exception e) {
                com.hihonor.adsdk.common.b.b.hnadsa(i.hnadsa, (Object) ("updateReportState#startReportPoll, execute track url update state.error: " + e.getMessage()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            com.hihonor.adsdk.common.b.b.hnadsc(i.hnadsa, "TrackReportHandler handle message.", new Object[0]);
            if (message.what != 1) {
                com.hihonor.adsdk.common.b.b.hnadsc(i.hnadsa, "startReportPoll has report cache message.", new Object[0]);
            } else if (com.hihonor.adsdk.base.net.i.hnadsc()) {
                a0.hnadsg(new Runnable() { // from class: com.hihonor.adsdk.base.g.i$b$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        i.hnadsa();
                    }
                });
            } else {
                com.hihonor.adsdk.common.b.b.hnadsc(i.hnadsa, "startReportPoll but network not enable.", new Object[0]);
            }
        }
    }

    static {
        HashMap map = new HashMap(2);
        hnadsi = map;
        map.put(0, new com.hihonor.adsdk.base.g.k.d.a());
        map.put(1, new com.hihonor.adsdk.base.g.k.d.b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void hnadsa() {
        hnadsb();
    }

    public static void hnadsb(AdTrack adTrack, com.hihonor.adsdk.base.bean.c<AdTrack> cVar) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "report enter entity is null? " + Objects.isNull(adTrack), new Object[0]);
        if (Objects.isNull(adTrack)) {
            hnadsa((AdTrack) null, cVar);
            return;
        }
        f<? extends d> fVar = hnadsi.get(Integer.valueOf(adTrack.getUrlType()));
        if (fVar == null) {
            hnadsa(adTrack, cVar);
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "report iReportFactory is null", new Object[0]);
            return;
        }
        d dVarHnadsa = fVar.hnadsa();
        if (dVarHnadsa != null) {
            dVarHnadsa.hnadsd(adTrack, cVar);
        } else {
            hnadsa(adTrack, cVar);
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "report trackReport is null", new Object[0]);
        }
    }

    public static void hnadsc() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "startReportPoll enter", new Object[0]);
        hnadsa(2000L);
    }

    private static void hnadsa(AdTrack adTrack, com.hihonor.adsdk.base.bean.c<AdTrack> cVar) {
        if (Objects.nonNull(cVar)) {
            cVar.hnadsa(adTrack);
        }
    }

    private static void hnadsc(com.hihonor.adsdk.base.dp.b.a aVar) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "reportCache#updateReportState 600000 REPORTING to REPORT_FAIL", new Object[0]);
        aVar.hnadsa(0, System.currentTimeMillis() - 600000, 1);
    }

    public static void hnadsa(long j) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "startReportPoll enter delayTime= " + j, new Object[0]);
        if (hnadsh == null) {
            hnadsh = new b(Looper.getMainLooper());
        }
        a0.hnadsg(new a(j));
    }

    private static void hnadsa(com.hihonor.adsdk.base.dp.b.a aVar) {
        List<AdTrack> listHnadsb;
        try {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "checkMaxFailCount  enter.", new Object[0]);
            listHnadsb = aVar.hnadsb(3, 1);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "check mack fail count query error. exception is " + e.getMessage(), new Object[0]);
            listHnadsb = null;
        }
        if (com.hihonor.adsdk.common.f.f.hnadsa((Collection<?>) listHnadsb)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "checkMaxFailCount  adFailTrackList is empty.", new Object[0]);
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "checkMaxFailCount#More than max fail count=" + com.hihonor.adsdk.common.f.f.hnadsb((Collection<?>) listHnadsb), new Object[0]);
        for (AdTrack adTrack : listHnadsb) {
            if (adTrack == null) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "checkMaxFailCount entity == null continue", new Object[0]);
            } else {
                new a1(adTrack.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(adTrack), adTrack.getTrackUrl(), adTrack.getTrackingType(), ErrorCode.REPORT_URL_FAIL_MAX_COUNT, ErrorCode.MSG_REPORT_URL_FAIL_MAX_COUNT, adTrack.getRecordId()).hnadse();
            }
        }
        try {
            com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("DELETE Track List deleteCount= " + aVar.hnadsb(listHnadsb)));
            h.hnadsa(listHnadsb);
        } catch (Exception e2) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "check mack fail count delete error. exception is " + e2.getMessage(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hnadsb() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "reportCache#reportCache start", new Object[0]);
        try {
            if (AdDatabase.hnadsa(HnAds.get().getContext()) == null) {
                com.hihonor.adsdk.common.b.b.hnadse(hnadsa, "data base is null", new Object[0]);
                return;
            }
            com.hihonor.adsdk.base.dp.b.a aVarHnadsa = AdDatabase.hnadsa(HnAds.get().getContext()).hnadsa();
            hnadsa(aVarHnadsa);
            hnadsc(aVarHnadsa);
            hnadsb(aVarHnadsa);
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "reportCache#reportCache end", new Object[0]);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "reportCache, report error= " + e.getMessage(), new Object[0]);
        }
    }

    private static void hnadsb(com.hihonor.adsdk.base.dp.b.a aVar) {
        List<AdTrack> listHnadsc;
        try {
            listHnadsc = aVar.hnadsc(1, 50);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "start report cache, queryLimit fail,exception is " + e.getMessage(), new Object[0]);
            listHnadsc = null;
        }
        if (com.hihonor.adsdk.common.f.f.hnadsa((Collection<?>) listHnadsc)) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsa, "reportCache#Track database is empty", new Object[0]);
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "reportCache#Track database count=" + listHnadsc.size(), new Object[0]);
        for (AdTrack adTrack : listHnadsc) {
            if (adTrack == null) {
                com.hihonor.adsdk.common.b.b.hnadse(hnadsa, "reportCache#startReportCache entity is null", new Object[0]);
            } else {
                adTrack.setReportState(0);
                com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("============>REPAY-TRACK-START trackUrl: " + adTrack.getTrackUrl() + ", reqMarker：" + adTrack.getRecordId() + ", body: " + adTrack.getBody()));
            }
        }
        try {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "reportCache#TrackReportManager update time updateCount = " + aVar.hnadsc(listHnadsc), new Object[0]);
        } catch (Exception e2) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "start report cache, update list to db fail,exception is " + e2.getMessage(), new Object[0]);
        }
        try {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "reportCache#TrackReportManager add", new Object[0]);
            h.hnadsb(listHnadsc);
        } catch (Exception e3) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "start report cache, enqueue entity fail,exception is " + e3.getMessage(), new Object[0]);
        }
    }

    public static void hnadsa(String str, long j) {
        boolean z = hnadsh == null;
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "startNextReport reason:" + str + ",report handler is null? " + z + ",delayTime=" + j, new Object[0]);
        if (z) {
            return;
        }
        if (j == 0 && hnadsh.hasMessages(1)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "startNextReport delayTime == 0， hasMessages HANDLER_REPORT_CACHE", new Object[0]);
        } else {
            hnadsh.removeMessages(1);
            hnadsh.sendEmptyMessageDelayed(1, j);
        }
    }
}
