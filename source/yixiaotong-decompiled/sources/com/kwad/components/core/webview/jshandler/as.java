package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class as implements com.kwad.sdk.core.webview.c.a {
    private Handler aqd = new Handler(Looper.getMainLooper());
    private com.kwad.sdk.core.webview.c.c aqe;
    private b fo;
    private String mUrl;

    public static final class a extends com.kwad.sdk.core.response.a.a {
        public String errorMsg;
        public int status;

        public final boolean isSuccess() {
            return this.status == 1;
        }
    }

    public interface b {
        void a(a aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "pageStatus";
    }

    @Deprecated
    public as(b bVar) {
        this.fo = bVar;
    }

    public as(b bVar, String str) {
        this.fo = bVar;
        this.mUrl = str;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.aqe = cVar;
        try {
            final a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            this.aqd.post(new com.kwad.sdk.utils.bi() { // from class: com.kwad.components.core.webview.jshandler.as.1
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    as.this.b(aVar);
                    if (as.this.aqe != null) {
                        as.this.aqe.b(null);
                    }
                }
            });
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.e("WebCardPageStatusHandler", "handleJsCall error: " + e);
            com.kwad.sdk.core.webview.b.c.b.aj(this.mUrl, e.getMessage());
            cVar.onError(-1, e.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.fo = null;
        this.aqe = null;
        this.aqd.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        b bVar = this.fo;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }
}
