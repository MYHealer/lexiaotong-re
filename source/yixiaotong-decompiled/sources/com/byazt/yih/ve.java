package com.byazt.yih;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 730, 54})
public class ve {
    public JSONObject c;

    public ve(JSONObject jSONObject) {
        this.c = jSONObject;
    }

    public boolean c() {
        JSONObject jSONObject = this.c;
        return jSONObject == null || jSONObject.optInt("enable_install_notification", 1) == 1;
    }

    public boolean tt() {
        JSONObject jSONObject = this.c;
        return jSONObject == null || jSONObject.optInt("enable_active_notification", 1) == 1;
    }

    public boolean ve() {
        JSONObject jSONObject = this.c;
        return jSONObject != null && jSONObject.optInt("enable_install_interface", 0) == 1;
    }

    public long uj() {
        JSONObject jSONObject = this.c;
        if (jSONObject == null) {
            return 300L;
        }
        return jSONObject.optLong("uninstall_delay", 300L);
    }

    public long n() {
        JSONObject jSONObject = this.c;
        if (jSONObject == null) {
            return 1800L;
        }
        return jSONObject.optLong("notification_internal", 1800L);
    }

    public int a() {
        JSONObject jSONObject = this.c;
        if (jSONObject == null) {
            return 1;
        }
        return jSONObject.optInt("max_notification", 1);
    }

    public int sp() {
        JSONObject jSONObject = this.c;
        if (jSONObject == null) {
            return 1;
        }
        return jSONObject.optInt("max_interface", 1);
    }
}
