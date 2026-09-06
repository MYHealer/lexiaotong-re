package com.kwai.adclient.kscommerciallogger.snapshot;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d {
    private final String bvj;
    private final LinkedHashMap<String, String> bvk = new LinkedHashMap<>();
    private final long time = System.nanoTime();

    d(String str) {
        this.bvj = str;
    }

    synchronized JSONObject Yr() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : this.bvk.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            jSONObject.put(CrashHianalyticsData.TIME, this.time);
            jSONObject.put("span_name", this.bvj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
