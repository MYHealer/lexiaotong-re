package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ak implements com.kwad.sdk.core.webview.c.a {
    private final Handler aqd = new Handler(Looper.getMainLooper());
    private com.kwad.sdk.core.webview.c.c aqe;
    private b fn;

    public static class a extends com.kwad.sdk.core.response.a.a {
        public int aqL = -1;
        public int type;
    }

    public interface b {
        void a(a aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "hide";
    }

    public ak(b bVar) {
        this.fn = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        try {
            this.aqe = cVar;
            final a aVar = new a();
            if (!TextUtils.isEmpty(str)) {
                aVar.parseJson(new JSONObject(str));
            }
            this.aqd.post(new com.kwad.sdk.utils.bi() { // from class: com.kwad.components.core.webview.jshandler.ak.1
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    if (ak.this.aqe != null) {
                        ak.this.aqe.b(null);
                    }
                    ak.this.b(aVar);
                }
            });
        } catch (Exception e) {
            this.aqe.onError(-1, e.getMessage());
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.fn = null;
        this.aqe = null;
        this.aqd.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        b bVar = this.fn;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }
}
