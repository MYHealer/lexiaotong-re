package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ax implements com.kwad.sdk.core.webview.c.a {
    private a arq;
    private b arr;

    public interface a {
        void c(com.kwad.components.core.webview.tachikoma.f.d dVar);

        void d(com.kwad.components.core.webview.tachikoma.f.d dVar);

        void e(com.kwad.components.core.webview.tachikoma.f.d dVar);
    }

    public interface b {
        void a(com.kwad.components.core.webview.tachikoma.f.d dVar, AdMatrixInfo.ShakeInfo shakeInfo, AdMatrixInfo.RotateInfo rotateInfo);

        void b(com.kwad.components.core.webview.tachikoma.f.d dVar, AdMatrixInfo.RotateInfo rotateInfo);

        void b(com.kwad.components.core.webview.tachikoma.f.d dVar, AdMatrixInfo.ShakeInfo shakeInfo);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerFeedMotionListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public ax(a aVar) {
        this.arq = aVar;
    }

    public ax(b bVar) {
        this.arr = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, final com.kwad.sdk.core.webview.c.c cVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final com.kwad.components.core.webview.tachikoma.c.i iVar = new com.kwad.components.core.webview.tachikoma.c.i();
        try {
            iVar.parseJson(new JSONObject(str));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        com.kwad.components.core.webview.tachikoma.f.d dVar = new com.kwad.components.core.webview.tachikoma.f.d() { // from class: com.kwad.components.core.webview.jshandler.ax.1
            @Override // com.kwad.components.core.webview.tachikoma.f.d
            public final void u(int i, String str2) {
                iVar.auo = str2;
                iVar.convertType = i;
                cVar.b(iVar);
            }
        };
        if (this.arq != null) {
            int i = iVar.aun;
            if (i == 1) {
                this.arq.d(dVar);
            } else if (i == 2) {
                this.arq.c(dVar);
            } else if (i == 3) {
                this.arq.e(dVar);
            }
        }
        if (this.arr != null) {
            int i2 = iVar.aun;
            if (i2 == 1) {
                this.arr.b(dVar, iVar.interactionInfo.rotateInfo);
            } else if (i2 == 2) {
                this.arr.b(dVar, iVar.interactionInfo.shakeInfo);
            } else {
                if (i2 != 3) {
                    return;
                }
                this.arr.a(dVar, iVar.interactionInfo.shakeInfo, iVar.interactionInfo.rotateInfo);
            }
        }
    }
}
