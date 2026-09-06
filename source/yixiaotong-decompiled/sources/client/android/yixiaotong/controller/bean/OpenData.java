package client.android.yixiaotong.controller.bean;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class OpenData {
    public String AuthorizedData;
    public String Random;
    public String SerialNumber;

    public OpenData(JSONObject jSONObject) {
        this.AuthorizedData = jSONObject.optString("authorizeddata");
        this.Random = jSONObject.optString("random");
        this.SerialNumber = jSONObject.optString("serialnumber");
    }
}
