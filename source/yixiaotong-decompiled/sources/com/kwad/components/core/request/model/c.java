package com.kwad.components.core.request.model;

import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.ac;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class c implements com.kwad.sdk.core.b {
    public long authorId;
    public long photoId;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        ac.putValue(jSONObject, "photoId", this.photoId);
        ac.putValue(jSONObject, URLPackage.KEY_AUTHOR_ID, this.authorId);
        return jSONObject;
    }
}
