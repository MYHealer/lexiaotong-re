package com.kwad.components.core.webview.tachikoma.b;

import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class x implements com.kwad.sdk.core.webview.c.a {
    private OfflineOnAudioConflictListener CH = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.core.webview.tachikoma.b.x.1
        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeOccupied() {
            x.this.cj(2);
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeReleased() {
            x.this.cj(3);
        }
    };
    private com.kwad.sdk.core.webview.c.c aqe;

    public static class a extends com.kwad.sdk.core.response.a.a {
        public boolean auc;
        public int aud;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerAudioFocusListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.aqe = cVar;
        com.kwad.components.core.t.a.aO(ServiceProvider.getContext()).a(this.CH);
        cj(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cj(int i) {
        a aVar = new a();
        aVar.auc = com.kwad.components.core.t.a.aO(ServiceProvider.getContext()).wD();
        aVar.aud = i;
        com.kwad.sdk.core.webview.c.c cVar = this.aqe;
        if (cVar != null) {
            cVar.b(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.components.core.t.a.aO(ServiceProvider.getContext()).b(this.CH);
        this.aqe = null;
    }
}
