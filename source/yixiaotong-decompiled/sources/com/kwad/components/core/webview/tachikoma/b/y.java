package com.kwad.components.core.webview.tachikoma.b;

import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.utils.by;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class y implements com.kwad.sdk.core.webview.c.a {
    private a aue;

    public interface a {
        void a(TKAdLiveShopItemInfo tKAdLiveShopItemInfo);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "updateLiveCurrentShopInfo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public y(a aVar) {
        this.aue = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        try {
            com.kwad.sdk.core.d.c.d("UpdateLiveCurrentShopInfoHandler", "handleJsCall: " + str);
            final TKAdLiveShopItemInfo tKAdLiveShopItemInfo = new TKAdLiveShopItemInfo();
            tKAdLiveShopItemInfo.parseJson(new JSONObject(str));
            by.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.b.y.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (y.this.aue != null) {
                        y.this.aue.a(tKAdLiveShopItemInfo);
                    }
                }
            });
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }
}
