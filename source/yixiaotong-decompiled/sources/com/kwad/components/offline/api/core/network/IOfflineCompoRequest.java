package com.kwad.components.offline.api.core.network;

import com.kwad.sdk.api.KsScene;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface IOfflineCompoRequest {
    boolean encryptDisable();

    JSONObject getBody();

    Map<String, String> getBodyMap();

    Map<String, String> getHeader();

    String getMethod();

    String getRequestHost();

    KsScene getScene();

    String getUrl();
}
