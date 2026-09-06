package com.masget.base.volley;

import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class JsonObjectRequestCBL extends JsonObjectRequest {
    public JsonObjectRequestCBL(int i, String str, String str2, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(i, str, str2, listener, errorListener);
    }

    public JsonObjectRequestCBL(String str, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(str, listener, errorListener);
    }

    public JsonObjectRequestCBL(int i, String str, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(i, str, listener, errorListener);
    }

    public JsonObjectRequestCBL(int i, String str, JSONObject jSONObject, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(i, str, jSONObject, listener, errorListener);
    }

    public JsonObjectRequestCBL(String str, JSONObject jSONObject, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(str, jSONObject, listener, errorListener);
    }
}
