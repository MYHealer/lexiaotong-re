package client.android.yixiaotong.controller.bean;

import com.google.gson.JsonObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class OpenDataBean extends SuccessBean {
    public JsonObject Records;
    private OpenData mOpenData;

    public OpenData getmOpenData() {
        return this.mOpenData;
    }

    public void setmOpenData(JSONObject jSONObject) {
        this.mOpenData = new OpenData(jSONObject);
    }
}
