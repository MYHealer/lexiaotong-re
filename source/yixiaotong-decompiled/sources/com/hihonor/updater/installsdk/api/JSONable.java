package com.hihonor.updater.installsdk.api;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface JSONable {
    void readFromJSON(String str) throws JSONException;

    JSONObject writeToJSON() throws JSONException;
}
