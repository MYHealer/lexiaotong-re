package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class k extends b<a> {

    public static class a extends com.kwad.sdk.core.response.a.a {
        public int aRb = 180000;
        public int aRc = 90000;
    }

    public k(String str) {
        super(str, new a());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void l(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject != null && (jSONObjectOptJSONObject = jSONObject.optJSONObject(getKey())) != null) {
            a aVar = new a();
            aVar.parseJson(jSONObjectOptJSONObject);
            setValue(aVar);
            return;
        }
        setValue(Lc());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        if (getValue() != null && getValue().toJson() != null) {
            editor.putString(getKey(), getValue().toJson().toString());
        } else {
            editor.putString(getKey(), "");
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        JSONObject jSONObject;
        a value = getValue();
        if (value == null) {
            value = new a();
        }
        try {
            jSONObject = new JSONObject(sharedPreferences.getString(getKey(), ""));
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            jSONObject = null;
        }
        if (jSONObject != null) {
            value.parseJson(jSONObject);
        }
        setValue(value);
    }
}
