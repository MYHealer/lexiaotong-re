package com.hihonor.adsdk.base.g;

import android.text.TextUtils;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.dp.AdDatabase;
import com.hihonor.adsdk.base.dp.entity.AdTrack;
import com.hihonor.adsdk.base.g.j.d.a1;
import com.hihonor.adsdk.base.g.j.d.b1;
import com.hihonor.adsdk.base.g.j.d.c1;
import com.hihonor.adsdk.base.g.j.d.x;
import com.hihonor.adsdk.base.net.m;
import com.hihonor.adsdk.common.f.a0;
import com.hihonor.adsdk.common.f.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class d {

    class a implements c {
        a() {
        }

        @Override // com.hihonor.adsdk.base.g.d.c
        public void hnadsa(List<AdTrack> list) {
            d.this.hnadsb(list);
        }
    }

    class b implements c {
        final /* synthetic */ int hnadsa;
        final /* synthetic */ String hnadsb;

        b(int i, String str) {
            this.hnadsa = i;
            this.hnadsb = str;
        }

        @Override // com.hihonor.adsdk.base.g.d.c
        public void hnadsa(List<AdTrack> list) {
            d.this.hnadsa(list, this.hnadsa, this.hnadsb);
            d.this.hnadsd(list);
        }
    }

    protected interface c {
        void hnadsa(List<AdTrack> list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsb(AdTrack adTrack, String str, String str2, com.hihonor.adsdk.base.bean.c cVar) {
        hnadsa(adTrack, 100001, "responseCode:" + str + ", errorCode:report fail. " + str2);
        hnadsa(adTrack, (com.hihonor.adsdk.base.bean.c<AdTrack>) cVar);
    }

    protected abstract String hnadsa();

    protected abstract void hnadsa(AdTrack adTrack, com.hihonor.adsdk.base.api.a aVar, com.hihonor.adsdk.base.bean.c<AdTrack> cVar);

    protected void hnadsc(List<AdTrack> list) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "reportUrlReqSucceed adTrack is null? " + com.hihonor.adsdk.common.f.f.hnadsa((Collection<?>) list), new Object[0]);
        if (com.hihonor.adsdk.common.f.f.hnadsa((Collection<?>) list)) {
            return;
        }
        for (AdTrack adTrack : list) {
            new c1(adTrack.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(adTrack), adTrack.getTrackUrl(), adTrack.getTrackingType(), adTrack.getRecordId()).hnadse();
        }
    }

    protected boolean hnadsc(AdTrack adTrack, com.hihonor.adsdk.base.bean.c<AdTrack> cVar) {
        return true;
    }

    public void hnadsd(AdTrack adTrack, com.hihonor.adsdk.base.bean.c<AdTrack> cVar) {
        try {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "report enter.", new Object[0]);
            if (!hnadsb(adTrack, cVar)) {
                com.hihonor.adsdk.common.b.b.hnadse(hnadsa(), "Non compliant", new Object[0]);
                return;
            }
            hnadsa(adTrack);
            com.hihonor.adsdk.common.b.b.hnadsa(hnadsa(), (Object) ("[Start_Report_Tracking_Url] >>> url: " + adTrack.getTrackUrl() + " , body: " + adTrack.getBody()));
            hnadsa(adTrack, m.hnadsb().hnadsc(), cVar);
        } catch (Exception e) {
            String str = "report error :" + e.getMessage();
            hnadsa(adTrack, ErrorCode.d.hnadsc, str);
            com.hihonor.adsdk.common.b.b.hnadse(hnadsa(), str, new Object[0]);
            hnadsd(Collections.singletonList(adTrack));
            hnadsa(adTrack, cVar);
        }
    }

    protected void hnadsa(AdTrack adTrack, boolean z, String str, String str2, com.hihonor.adsdk.base.bean.c<AdTrack> cVar) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "========>INFO-END onResponse#>>> Report response code is %s", str);
        if (Objects.isNull(adTrack)) {
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa(), "========>DEBUG-END onResponse#>>>> Report response Code is %s, body:%s, Url:%s", str, adTrack.getBody(), adTrack.getTrackUrl());
        if (z) {
            hnadsb(adTrack);
        } else {
            hnadsa(adTrack, 100001, z.hnadsa(str, str2));
        }
        hnadsa(adTrack, cVar);
    }

    protected boolean hnadsb(AdTrack adTrack, com.hihonor.adsdk.base.bean.c<AdTrack> cVar) {
        try {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "canReport enter.", new Object[0]);
            if (adTrack == null) {
                com.hihonor.adsdk.common.b.b.hnadse(hnadsa(), "reportTrackerUrl#entity is empty", new Object[0]);
                hnadsa((AdTrack) null, cVar);
                return false;
            }
            if (!com.hihonor.adsdk.base.net.i.hnadsc()) {
                com.hihonor.adsdk.common.b.b.hnadse(hnadsa(), "reportTrackerUrl#Network Unavailable", new Object[0]);
                hnadsa(adTrack, ErrorCode.d.hnadsc, "reportTrackerUrl#Network Unavailable");
                hnadsa(adTrack, cVar);
                return false;
            }
            com.hihonor.adsdk.common.b.b.hnadsa(hnadsa(), (Object) ("========>START reportTrackerUrl#trackUrl=" + adTrack.getTrackUrl()));
            if (TextUtils.isEmpty(adTrack.getTrackUrl())) {
                com.hihonor.adsdk.common.b.b.hnadse(hnadsa(), "reportTrackerUrl#trackUrl is empty", new Object[0]);
                hnadsa(Collections.singletonList(adTrack));
                hnadsa(adTrack, ErrorCode.d.hnadse, "reportTrackerUrl#trackUrl is empty");
                hnadsa(adTrack, cVar);
                return false;
            }
            return hnadsc(adTrack, cVar);
        } catch (Exception e) {
            String str = "canReport, check report condition error :" + e.getMessage();
            hnadsa(adTrack, ErrorCode.d.hnadsc, str);
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa(), str, new Object[0]);
            hnadsa(adTrack, cVar);
            return false;
        }
    }

    protected void hnadsd(List<AdTrack> list) {
        try {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "updateFailCount enter. entity is null? " + com.hihonor.adsdk.common.f.f.hnadsa((Collection<?>) list), new Object[0]);
            if (com.hihonor.adsdk.common.f.f.hnadsa((Collection<?>) list)) {
                return;
            }
            if (AdDatabase.hnadsa(HnAds.get().getContext()) == null) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "updateFailCount#update db fail,cause by database is null.", new Object[0]);
                hnadsa("updateFailCount#update db fail,cause by database is null.", list, ErrorCode.AD_CODE_UPDATE_FAIL_COUNT_BUT_DAO_IS_NULL);
                return;
            }
            for (AdTrack adTrack : list) {
                int reportCnt = adTrack.getReportCnt() + 1;
                if (!com.hihonor.adsdk.base.net.i.hnadsc()) {
                    com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "updateFailCount#dbReportCount not plus.But is not net work", new Object[0]);
                    reportCnt = adTrack.getReportCnt();
                }
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "updateFailCount#dbReportCount=" + adTrack.getReportCnt() + ",addReportCnt=" + reportCnt + ",record=" + adTrack.getRecordId(), new Object[0]);
                adTrack.setReportState(1);
                adTrack.setReportTime(System.currentTimeMillis());
                adTrack.setReportCnt(reportCnt);
            }
            int iHnadsc = AdDatabase.hnadsa(HnAds.get().getContext()).hnadsa().hnadsc(list);
            i.hnadsa("reportFailDB", 60000L);
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "updateFailCount#UPDATE DB COUNT RESULT = " + iHnadsc, new Object[0]);
        } catch (Exception e) {
            String str = "reportFailDB, update db error=" + e.getMessage();
            com.hihonor.adsdk.common.b.b.hnadse(hnadsa(), str, new Object[0]);
            hnadsa(str, list, ErrorCode.AD_CODE_UPDATE_FAIL_COUNT_ERROR);
        }
    }

    protected void hnadsa(final AdTrack adTrack, final String str, final String str2, final com.hihonor.adsdk.base.bean.c<AdTrack> cVar) {
        com.hihonor.adsdk.common.b.b.hnadsb(hnadsa(), "========>INFO-END onFailure# response fail, message is errorCode: %s ,msg: %s", str, str2);
        if (Objects.isNull(adTrack)) {
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa(), "========>DEBUG-END onFailure#>>>> Report error Code is %s, TrackUrl:%s, body:%s", 100001, adTrack.getTrackUrl(), adTrack.getBody());
        a0.hnadse(new Runnable() { // from class: com.hihonor.adsdk.base.g.d$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.hnadsb(adTrack, str, str2, cVar);
            }
        });
    }

    protected void hnadsa(AdTrack adTrack, com.hihonor.adsdk.base.bean.c<AdTrack> cVar) {
        if (cVar != null) {
            cVar.hnadsa(adTrack);
        }
    }

    protected void hnadsa(List<AdTrack> list) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "deleteAdTrack#enter.", new Object[0]);
        try {
            if (AdDatabase.hnadsa(HnAds.get().getContext()) != null) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "[ReportSuccessDB Delete Record]#DELETE db result=" + AdDatabase.hnadsa(HnAds.get().getContext()).hnadsa().hnadsb(list) + ", adTrackList : " + com.hihonor.adsdk.common.f.f.hnadsb((Collection<?>) list), new Object[0]);
            } else {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "delete db fail,cause by database is null.", new Object[0]);
                hnadsa("delete db fail,cause by database is null.", list, ErrorCode.AD_CODE_DELETE_TRACK_BUT_DAO_IS_NULL);
            }
        } catch (Exception e) {
            String str = "reportSuccessDB, delete db error=" + e.getMessage();
            com.hihonor.adsdk.common.b.b.hnadse(hnadsa(), str, new Object[0]);
            hnadsa(str, list, ErrorCode.AD_CODE_DELETE_TRACK_ERROR);
        }
    }

    protected void hnadsb(AdTrack adTrack) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "Report tracking success.", new Object[0]);
        hnadsa("reportSuccess", adTrack, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hnadsb(List<AdTrack> list) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "reportSuccessInternal enter.", new Object[0]);
        if (com.hihonor.adsdk.common.f.f.hnadsa((Collection<?>) list)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "reportSuccessInternal#Unable to report tracking success.Cause by entity is null.", new Object[0]);
        } else {
            hnadsc(list);
            hnadsa(list);
        }
    }

    protected void hnadsa(AdTrack adTrack, int i, String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "reportFail#code:" + i + ",msg:" + str, new Object[0]);
        hnadsa("reportFail", adTrack, new b(i, str));
    }

    protected void hnadsa(String str, List<AdTrack> list, int i) {
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa(), (Object) ("reportModifyDBFail message=" + str));
        if (com.hihonor.adsdk.common.f.f.hnadsa((Collection<?>) list)) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa(), "unable to report modify DBFail.cause by adTrackEntity is null.", new Object[0]);
            return;
        }
        for (AdTrack adTrack : list) {
            String str2 = ErrorCode.STR_AD_TRACK_DB_ERR + com.hihonor.adsdk.base.j.g.hnadsa(adTrack) + ",Exception msg : " + str;
            com.hihonor.adsdk.common.b.b.hnadsa(hnadsa(), (Object) str2);
            new x(adTrack.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa("", adTrack.getRequestId(), -1, 0), ErrorCode.AD_TRACK_DB_ERR, str2).hnadsa("code", String.valueOf(i)).hnadse();
        }
    }

    protected void hnadsa(List<AdTrack> list, int i, String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "reportTrackingReqFail ,errorCode:" + i + ",errorMsg:" + str + ",adTrack is null? " + com.hihonor.adsdk.common.f.f.hnadsa((Collection<?>) list), new Object[0]);
        if (com.hihonor.adsdk.common.f.f.hnadsa((Collection<?>) list)) {
            return;
        }
        for (AdTrack adTrack : list) {
            new a1(adTrack.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(adTrack), adTrack.getTrackUrl(), adTrack.getTrackingType(), i, str, adTrack.getRecordId()).hnadse();
        }
    }

    protected void hnadsa(String str, AdTrack adTrack, c cVar) {
        JSONArray jSONArray;
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "batchProcess " + str, new Object[0]);
        if (cVar == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "batchProcess# onBatchCallback is null.", new Object[0]);
            return;
        }
        if (Objects.isNull(adTrack)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "batchProcess# entity is null.", new Object[0]);
            return;
        }
        String recordIds = adTrack.getRecordIds();
        if (TextUtils.isEmpty(recordIds)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "batchProcess# recordIds is null.", new Object[0]);
            cVar.hnadsa(Collections.singletonList(adTrack));
            return;
        }
        try {
            jSONArray = new JSONArray(recordIds);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa(), str + " parse json exception. " + e.getMessage(), new Object[0]);
            jSONArray = null;
        }
        JSONArray jSONArray2 = jSONArray;
        if (jSONArray2 == null) {
            cVar.hnadsa(Collections.singletonList(adTrack));
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "batchProcess# mergeReqIdArray is null.", new Object[0]);
            return;
        }
        int length = jSONArray2.length();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), str + " batchProcess length:" + length, new Object[0]);
        if (length <= 0) {
            cVar.hnadsa(Collections.singletonList(adTrack));
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "batchProcess# length is 0.", new Object[0]);
            return;
        }
        com.hihonor.adsdk.base.dp.b.a aVarHnadsa = AdDatabase.hnadsa(HnAds.get().getContext()).hnadsa();
        if (Objects.isNull(aVarHnadsa)) {
            cVar.hnadsa(Collections.singletonList(adTrack));
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "adTrackDao is null.", new Object[0]);
        } else {
            com.hihonor.adsdk.common.b.b.hnadsa(hnadsa(), (Object) ">>>>>>>>>>>  call queryRecordListTrack [Single] . ");
            hnadsa(jSONArray2, aVarHnadsa, str, adTrack, cVar);
        }
    }

    private void hnadsa(JSONArray jSONArray, com.hihonor.adsdk.base.dp.b.a aVar, String str, AdTrack adTrack, c cVar) {
        AdTrack adTrackHnadsa;
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                adTrackHnadsa = aVar.hnadsa(jSONArray.optString(i));
                try {
                    arrayList.add(adTrackHnadsa);
                } catch (Exception unused) {
                    String str2 = "[Query Single] batchProcess queryTrack error: " + str + " report fail , query db fail.";
                    com.hihonor.adsdk.common.b.b.hnadsb(hnadsa(), str2, new Object[0]);
                    hnadsa(str2, Collections.singletonList(adTrack), ErrorCode.AD_CODE_QUERY_BATCH_TRACK_ERROR);
                }
            } catch (Exception unused2) {
                adTrackHnadsa = null;
            }
            if (adTrackHnadsa == null) {
                com.hihonor.adsdk.common.b.b.hnadsb(hnadsa(), str + " [Query Single] query track is null. next track", new Object[0]);
            } else {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), str + " [Query Single] batchProcess report success " + adTrackHnadsa.getRecordId(), new Object[0]);
            }
        }
        cVar.hnadsa(arrayList);
    }

    private void hnadsa(AdTrack adTrack) {
        new b1(adTrack.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(adTrack), adTrack.getTrackUrl(), adTrack.getTrackingType(), adTrack.getRecordId()).hnadse();
    }
}
