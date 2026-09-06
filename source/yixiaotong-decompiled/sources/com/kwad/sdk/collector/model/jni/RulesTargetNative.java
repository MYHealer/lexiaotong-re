package com.kwad.sdk.collector.model.jni;

import com.kwad.sdk.collector.AppStatusNative;
import com.kwad.sdk.collector.model.d;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ac;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class RulesTargetNative extends NativeObject implements d {
    private static final long serialVersionUID = -4726982809581153390L;

    public RulesTargetNative() {
        this.mPtr = AppStatusNative.nativeCreateRulesTarget();
    }

    public RulesTargetNative(long j) {
        this.mPtr = j;
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            AppStatusNative.rulesTargetSetPackageName(this, jSONObject.optString("packageName"));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("paths");
            if (jSONArrayOptJSONArray != null) {
                int length = jSONArrayOptJSONArray.length();
                String[] strArr = new String[length];
                for (int i = 0; i < length; i++) {
                    strArr[i] = jSONArrayOptJSONArray.getString(i);
                }
                AppStatusNative.rulesTargetSetPaths(this, strArr);
            }
        } catch (Exception e) {
            com.kwad.sdk.service.d.gatherException(e);
            c.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        ac.putValue(jSONObject, "packageName", AppStatusNative.rulesTargetGetPackageName(this));
        ac.putValue(jSONObject, "paths", (List<?>) Arrays.asList(AppStatusNative.rulesTargetGetPaths(this)));
        return jSONObject;
    }

    @Override // com.kwad.sdk.collector.model.jni.NativeObject
    public void destroy() {
        if (this.mPtr != 0) {
            AppStatusNative.nativeDeleteRulesTarget(this.mPtr);
            this.mPtr = 0L;
        }
    }
}
