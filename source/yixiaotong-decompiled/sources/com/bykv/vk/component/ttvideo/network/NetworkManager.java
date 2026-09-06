package com.bykv.vk.component.ttvideo.network;

import com.bykv.vk.component.ttvideo.INetworkClient;
import com.bykv.vk.component.ttvideo.log.LiveError;
import com.huawei.hms.ads.ld;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
final class NetworkManager {

    interface OnCompletionListener {
        void onCompletion(JSONObject jSONObject);

        void onError(LiveError liveError);
    }

    private NetworkManager() {
    }

    static void doRequest(INetworkClient iNetworkClient, String str, String str2, OnCompletionListener onCompletionListener) {
        LiveError liveError;
        if (str2 == null) {
            return;
        }
        INetworkClient.Result resultDoRequest = iNetworkClient.doRequest(str, str2);
        if (resultDoRequest == null) {
            onCompletionListener.onError(new LiveError(LiveError.EMPTY, "result is null", null));
            return;
        }
        Exception exc = resultDoRequest.e;
        if (exc == null && resultDoRequest.response != null) {
            onCompletionListener.onCompletion(resultDoRequest.response);
            return;
        }
        HashMap map = new HashMap();
        if (resultDoRequest.response != null) {
            map.put("rawResp", resultDoRequest.response);
        }
        if (exc instanceof IOException) {
            map.put(ld.L, "network IO exception");
            liveError = new LiveError(LiveError.NETWORK_IO_ERROR, exc.toString(), map);
        } else if (exc instanceof JSONException) {
            map.put(ld.L, "parse JSON failure");
            if (resultDoRequest.body != null) {
                map.put("rowBody", resultDoRequest.body);
            }
            if (resultDoRequest.header != null) {
                map.put("responseHeader", resultDoRequest.header);
            }
            liveError = new LiveError(LiveError.PARSE_JSON, exc.getMessage(), map);
        } else {
            map.put(ld.L, "response not successful");
            liveError = new LiveError(-100004, exc.getMessage(), map);
        }
        onCompletionListener.onError(liveError);
    }
}
