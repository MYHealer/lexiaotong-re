package com.kwad.sdk.core.network;

import com.kwad.sdk.internal.api.SceneImpl;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface f {
    JSONObject getBody();

    Map<String, String> getBodyMap();

    Map<String, String> getHeader();

    SceneImpl getScene();

    String getUrl();
}
