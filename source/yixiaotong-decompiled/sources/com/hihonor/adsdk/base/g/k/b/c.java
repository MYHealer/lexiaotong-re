package com.hihonor.adsdk.base.g.k.b;

import com.hihonor.adsdk.base.dp.entity.AdTrack;
import com.hihonor.adsdk.common.f.f;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c extends a {
    private void hnadsa(JSONArray jSONArray, String str) {
        try {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsb(), "mergeSubBody enter. ", new Object[0]);
            JSONArray jSONArray2 = new JSONArray(str);
            if (jSONArray2.length() <= 0) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsb(), "mergeSubBody parse trackBody json array length is 0. ", new Object[0]);
                return;
            }
            for (int i = 0; i < jSONArray2.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray2.optJSONObject(i);
                if (jSONObjectOptJSONObject == null) {
                    com.hihonor.adsdk.common.b.b.hnadsc(hnadsb(), "mergeSubBody subJsonObj is null continue. ", new Object[0]);
                } else {
                    jSONArray.put(jSONObjectOptJSONObject);
                }
            }
        } catch (JSONException e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsb(), "parse trackBody json array error. " + e.getMessage(), new Object[0]);
        }
    }

    private String hnadsg(List<AdTrack> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<AdTrack> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().getRecordId());
        }
        return jSONArray.toString();
    }

    private JSONArray hnadsh(List<AdTrack> list) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb(), "mergeAnyBody enter.", new Object[0]);
        JSONArray jSONArray = new JSONArray();
        Iterator<AdTrack> it = list.iterator();
        while (it.hasNext()) {
            hnadsa(jSONArray, it.next().getBody());
        }
        return jSONArray;
    }

    @Override // com.hihonor.adsdk.base.g.k.b.a
    protected int hnadsa() {
        return 1;
    }

    @Override // com.hihonor.adsdk.base.g.k.b.a
    protected String hnadsb() {
        return "AdWorkFlowAdapter";
    }

    @Override // com.hihonor.adsdk.base.g.k.b.a
    protected List<AdTrack> hnadsb(List<AdTrack> list) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb(), "AdWorkFlowAdapter# merge enter. adTrackList.size = " + f.hnadsb((Collection<?>) list), new Object[0]);
        if (f.hnadsa((Collection<?>) list)) {
            return null;
        }
        JSONArray jSONArrayHnadsh = hnadsh(list);
        if (jSONArrayHnadsh.length() <= 0) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsb(), "AdWorkFlowAdapter# merge mergeJsonArray length is 0. ", new Object[0]);
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        AdTrack adTrack = new AdTrack();
        adTrack.setBody(jSONArrayHnadsh.toString());
        adTrack.setTrackUrl(com.hihonor.adsdk.base.net.p.a.hnadsa() + com.hihonor.adsdk.base.c.h2.hnadsd);
        adTrack.setTime(jCurrentTimeMillis);
        adTrack.setRecordIds(hnadsg(list));
        adTrack.setReportState(0);
        adTrack.setReportTime(jCurrentTimeMillis);
        adTrack.setReportCnt(0);
        adTrack.setUrlType(1);
        adTrack.setMethod("POST");
        return Collections.singletonList(adTrack);
    }

    @Override // com.hihonor.adsdk.base.g.k.b.a
    protected void hnadsd(List<AdTrack> list) {
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsb(), (Object) "Will be have adTrack repay report fail count more than max count.");
    }
}
