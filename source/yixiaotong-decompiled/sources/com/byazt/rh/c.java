package com.byazt.rh;

import com.byazt.nr.m;
import com.huawei.openalliance.ad.constant.ba;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 115, 20})
public class c {
    public long c;
    public long n;
    public String tt;
    public long uj;
    public String ve;

    public String c() {
        return this.tt;
    }

    public String tt() {
        return this.ve;
    }

    public long ve() {
        return this.uj;
    }

    public c(JSONObject jSONObject) {
        this.c = jSONObject.optLong(ba.D);
        this.tt = jSONObject.optString("url");
        this.ve = jSONObject.optString("file_hash");
        this.uj = jSONObject.optLong("effective_time");
        this.n = jSONObject.optLong("expiration_time");
    }

    public boolean uj() {
        return System.currentTimeMillis() >= this.n;
    }

    public long c(String str) {
        File file = new File(str, this.ve);
        if (file.exists()) {
            return file.lastModified();
        }
        return System.currentTimeMillis();
    }

    public JSONObject n() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ba.D, this.c);
            jSONObject.put("url", this.tt);
            jSONObject.put("file_hash", this.ve);
            jSONObject.put("effective_time", this.uj);
            jSONObject.put("expiration_time", this.n);
        } catch (Exception e) {
            m.tt("BrandVideo", e.getMessage());
        }
        return jSONObject;
    }

    public boolean tt(String str) {
        File file = new File(str, this.ve);
        if (!file.exists()) {
            return false;
        }
        try {
            return file.delete();
        } catch (Exception unused) {
            return false;
        }
    }
}
