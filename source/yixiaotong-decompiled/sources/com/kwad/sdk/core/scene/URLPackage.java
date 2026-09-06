package com.kwad.sdk.core.scene;

import android.text.TextUtils;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.a.a;
import com.kwad.sdk.utils.ad;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class URLPackage extends a implements Serializable {
    public static final String KEY_AUTHOR_ID = "authorId";
    public static final String KEY_CHANNEL_ID = "channelId";
    private static final long serialVersionUID = -7365796297335816787L;
    public String identity;
    public transient JSONObject mJsonObjectParams;
    public int page;

    public URLPackage() {
    }

    public URLPackage(String str, int i) {
        this.page = i;
        this.identity = str;
    }

    public URLPackage(int i) {
        this.page = i;
        this.identity = String.valueOf(hashCode());
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterParseJson(JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("params");
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        try {
            this.mJsonObjectParams = new JSONObject(strOptString);
        } catch (JSONException e) {
            c.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        JSONObject jSONObject2 = this.mJsonObjectParams;
        if (jSONObject2 != null) {
            ad.putValue(jSONObject, "params", jSONObject2.toString());
        }
    }

    public void putParams(String str, long j) {
        if (this.mJsonObjectParams == null) {
            this.mJsonObjectParams = new JSONObject();
        }
        ad.putValue(this.mJsonObjectParams, str, j);
    }
}
