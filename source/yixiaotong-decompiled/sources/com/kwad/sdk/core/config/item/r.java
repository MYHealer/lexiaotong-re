package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class r extends b<a> {
    private String aRg;

    public r() {
        super("sdkPackInfo", null);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void l(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("sdkPackInfo");
        if (jSONObjectOptJSONObject == null) {
            return;
        }
        this.aRg = jSONObjectOptJSONObject.toString();
        a aVar = new a();
        aVar.parseJson(jSONObjectOptJSONObject);
        setValue(aVar);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        editor.putString("sdkPackInfo", ej(this.aRg));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        String decodeString = getDecodeString(sharedPreferences.getString("sdkPackInfo", null));
        this.aRg = decodeString;
        try {
            if (TextUtils.isEmpty(decodeString)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(this.aRg);
            a aVar = new a();
            aVar.parseJson(jSONObject);
            setValue(aVar);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static final class a implements com.kwad.sdk.core.b {
        public Map<Integer, String> aRh = new HashMap();
        public List<String> aRi = new ArrayList();
        public List<String> aRj = new ArrayList();
        public List<String> aRk = new ArrayList();
        public int aRl;
        private JSONObject aRm;

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            return this.aRm;
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.aRm = jSONObject;
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("platformInfo");
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    this.aRh.put(Integer.valueOf(next), jSONObjectOptJSONObject.optString(next));
                }
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("keyStacks");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    this.aRi.add(jSONArrayOptJSONArray.optString(i));
                }
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("extendClassNames");
            if (jSONArrayOptJSONArray2 != null) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    this.aRj.add(jSONArrayOptJSONArray2.optString(i2));
                }
            }
            JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("keyNames");
            if (jSONArrayOptJSONArray3 != null) {
                for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                    this.aRk.add(jSONArrayOptJSONArray3.optString(i3));
                }
            }
            this.aRl = jSONObject.optInt("handleType");
        }
    }
}
