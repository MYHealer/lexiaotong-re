package com.fancy;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _aw {
    public ArrayList _a = new ArrayList();
    public String _b;
    public String _c;

    public final _aw _a(JSONObject jSONObject) {
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(TypedValues.AttributesType.S_TARGET);
            this._a.clear();
            if (jSONArrayOptJSONArray != null) {
                int length = jSONArrayOptJSONArray.length();
                for (int i = 0; i < length; i++) {
                    String string = jSONArrayOptJSONArray.getString(i);
                    if (string != null) {
                        this._a.add(string);
                    }
                }
            }
            this._b = jSONObject.optString("targetHash");
            this._c = jSONObject.optString("rule");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public final boolean _a() {
        return (this._a.isEmpty() || this._c.isEmpty()) ? false : true;
    }
}
