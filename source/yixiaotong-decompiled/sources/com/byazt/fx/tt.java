package com.byazt.fx;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.openalliance.ad.constant.bf;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 839, 13})
public class tt {
    public int c;
    public float n;
    public int tt;
    public float uj;
    public long ve;

    public int c() {
        return this.c;
    }

    public void c(long j) {
        this.ve = j;
    }

    public int getType() {
        return this.tt;
    }

    public long tt() {
        return this.ve;
    }

    public float uj() {
        return this.n;
    }

    public float ve() {
        return this.uj;
    }

    public tt(JSONObject jSONObject) {
        this.c = 0;
        this.tt = 0;
        this.ve = 0L;
        this.uj = 0.1f;
        this.n = 0.1f;
        if (jSONObject == null) {
            return;
        }
        this.c = jSONObject.optInt(CrashHianalyticsData.TIME);
        this.tt = jSONObject.optInt("type");
        this.ve = jSONObject.optLong("duration");
        this.uj = (float) jSONObject.optDouble("intensity");
        this.n = (float) jSONObject.optDouble(bf.ar);
        if (this.tt == 1 || this.ve < 100) {
            c(100L);
        }
    }
}
