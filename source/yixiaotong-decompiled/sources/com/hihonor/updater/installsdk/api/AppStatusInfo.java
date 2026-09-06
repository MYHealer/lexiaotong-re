package com.hihonor.updater.installsdk.api;

import com.hihonor.updater.installsdk.c.c;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.yfanads.android.adx.thirdpart.filedownload.model.ConnectionModel;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class AppStatusInfo implements JSONable {
    private int code;
    private long currentOffset;
    private String extra;
    private String message;
    private String packageName;
    private int progress;
    private int status = -1;
    private long totalLength;

    public int getCode() {
        return this.code;
    }

    public long getCurrentOffset() {
        return this.currentOffset;
    }

    public String getExtra() {
        return this.extra;
    }

    public String getMessage() {
        return this.message;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int getProgress() {
        return this.progress;
    }

    public int getStatus() {
        return this.status;
    }

    public long getTotalLength() {
        return this.totalLength;
    }

    @Override // com.hihonor.updater.installsdk.api.JSONable
    public void readFromJSON(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.packageName = c.d(jSONObject, "packageName");
            this.status = c.b(jSONObject, "status");
            this.currentOffset = c.c(jSONObject, ConnectionModel.CURRENT_OFFSET);
            this.totalLength = c.c(jSONObject, "totalLength");
            this.progress = c.b(jSONObject, "progress");
            this.code = c.b(jSONObject, "code");
            this.message = c.d(jSONObject, CrashHianalyticsData.MESSAGE);
            this.extra = c.d(jSONObject, "extra");
        } catch (JSONException unused) {
        }
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setCurrentOffset(long j) {
        this.currentOffset = j;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setProgress(int i) {
        this.progress = i;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setTotalLength(long j) {
        this.totalLength = j;
    }

    @Override // com.hihonor.updater.installsdk.api.JSONable
    public JSONObject writeToJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = this.packageName;
            if (str == null) {
                str = "";
            }
            jSONObject.put("packageName", str);
            jSONObject.put("status", this.status);
            jSONObject.put(ConnectionModel.CURRENT_OFFSET, this.currentOffset);
            jSONObject.put("totalLength", this.totalLength);
            jSONObject.put("progress", this.progress);
            jSONObject.put("code", this.code);
            jSONObject.put(CrashHianalyticsData.MESSAGE, this.message);
            jSONObject.put("extra", this.extra);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
