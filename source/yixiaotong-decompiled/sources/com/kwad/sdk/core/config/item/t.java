package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ar;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class t extends b<List<String>> {
    public t(String str, List<String> list) {
        super(str, list);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void l(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject != null && (jSONArrayOptJSONArray = jSONObject.optJSONArray(getKey())) != null && jSONArrayOptJSONArray.length() > 0) {
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                String strOptString = jSONArrayOptJSONArray.optString(i);
                if (strOptString != null && !strOptString.isEmpty()) {
                    copyOnWriteArrayList.add(strOptString);
                }
            }
            if (copyOnWriteArrayList.size() > 0) {
                setValue(copyOnWriteArrayList);
                return;
            }
        }
        setValue(Lc());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        if (ar.Z(getValue())) {
            editor.putString(getKey(), ej(ac.toJsonArray(getValue()).toString()));
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        List listHL = ac.hL(getDecodeString(sharedPreferences.getString(getKey(), "")));
        if (ar.Z(listHL)) {
            setValue(listHL);
        } else {
            setValue(Lc());
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    /* JADX INFO: renamed from: Lk, reason: merged with bridge method [inline-methods] */
    public final List<String> getValue() {
        List<String> list = (List) super.getValue();
        return list == null ? new ArrayList() : list;
    }
}
