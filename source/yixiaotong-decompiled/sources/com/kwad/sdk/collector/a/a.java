package com.kwad.sdk.collector.a;

import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.i;
import com.kwad.sdk.utils.ac;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a extends d {
    private C0728a aJh;

    public a(List<String> list) {
        C0728a c0728a = new C0728a(list);
        this.aJh = c0728a;
        putBody("targetAppInfo", c0728a.toJson());
        putBody("sdkVersion", BuildConfig.VERSION_NAME);
        putBody("sdkVersionCode", BuildConfig.VERSION_CODE);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return i.EU();
    }

    /* JADX INFO: renamed from: com.kwad.sdk.collector.a.a$a, reason: collision with other inner class name */
    static class C0728a {
        private List<String> aJi;

        public C0728a(List<String> list) {
            this.aJi = list;
        }

        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            ac.putValue(jSONObject, "packageName", this.aJi);
            return jSONObject;
        }
    }
}
