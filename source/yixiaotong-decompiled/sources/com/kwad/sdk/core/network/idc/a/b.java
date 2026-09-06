package com.kwad.sdk.core.network.idc.a;

import android.text.TextUtils;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ac;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b implements com.kwad.sdk.core.b {
    private final Map<String, List<String>> aUt = new ConcurrentHashMap();

    private Map<String, List<String>> Mu() {
        return this.aUt;
    }

    public final void a(b bVar) {
        this.aUt.clear();
        if (bVar != null) {
            this.aUt.putAll(bVar.Mu());
        }
    }

    public final boolean isEmpty() {
        return this.aUt.isEmpty();
    }

    public final Set<String> Mv() {
        return this.aUt.keySet();
    }

    public final List<String> eR(String str) {
        Map<String, List<String>> map = this.aUt;
        if (map == null) {
            return Collections.emptyList();
        }
        List<String> list = map.get(str);
        return list == null ? Collections.emptyList() : list;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next)) {
                map.put(next, ac.h(jSONObject.optJSONArray(next)));
            }
        }
        this.aUt.clear();
        this.aUt.putAll(map);
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        Map<String, List<String>> map = this.aUt;
        JSONObject jSONObject = new JSONObject();
        for (String str : map.keySet()) {
            ac.putValue(jSONObject, str, ac.Y(map.get(str)));
        }
        return jSONObject;
    }

    public static b eS(String str) {
        b bVar = new b();
        if (str != null && !str.isEmpty()) {
            try {
                bVar.parseJson(new JSONObject(str));
            } catch (JSONException e) {
                c.printStackTraceOnly(e);
            }
        }
        return bVar;
    }
}
