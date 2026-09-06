package com.kwad.sdk.collector;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class g {
    public static int PERMISSION_DENIED = 2;
    public static int PERMISSION_GRANTED = 1;
    public static int aJf;
    private String aJe;
    private int state;

    public static JSONArray C(List<g> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null) {
            return jSONArray;
        }
        Iterator<g> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().toJson());
        }
        return jSONArray;
    }

    public g(String str, int i) {
        this.aJe = str;
        this.state = i;
    }

    private JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", Ib());
            jSONObject.put("state", this.state);
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
        return jSONObject;
    }

    private String Ib() {
        int iLastIndexOf;
        String str = this.aJe;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return ((str.startsWith("com.android.") || str.startsWith("android.permission")) && (iLastIndexOf = str.lastIndexOf(".")) < str.length() + (-1)) ? str.substring(iLastIndexOf + 1) : str;
    }
}
