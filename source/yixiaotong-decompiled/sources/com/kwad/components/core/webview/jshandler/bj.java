package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class bj implements com.kwad.sdk.core.webview.c.a {
    private static Handler arT;
    private com.kwad.components.core.e.d.d QS;
    private com.kwad.sdk.core.webview.b arS;
    private b arU;

    public static class a extends com.kwad.sdk.core.response.a.a {
        public int nm;
    }

    public interface b {
        void ao(int i);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "playableConvert";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public bj(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.d dVar, b bVar2) {
        this.arS = bVar;
        this.QS = dVar;
        this.arU = bVar2;
        if (arT == null) {
            arT = new Handler(Looper.getMainLooper());
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            final int i = aVar.nm;
            arT.post(new com.kwad.sdk.utils.bi() { // from class: com.kwad.components.core.webview.jshandler.bj.1
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    if (bj.this.arU != null) {
                        bj.this.arU.ao(i);
                    }
                }
            });
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }
}
