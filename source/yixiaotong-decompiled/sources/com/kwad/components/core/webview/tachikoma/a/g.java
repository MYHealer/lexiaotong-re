package com.kwad.components.core.webview.tachikoma.a;

import com.kwad.components.core.webview.tachikoma.c.y;
import com.kwad.sdk.components.m;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class g implements m {
    protected abstract void a(y yVar);

    protected abstract void bV();

    protected abstract void bW();

    protected abstract void bX();

    protected abstract void bY();

    @Override // com.kwad.sdk.components.m
    public final Object call(Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            try {
                final y yVar = new y();
                if (objArr[0] instanceof String) {
                    yVar.parseJson(new JSONObject((String) objArr[0]));
                    by.runOnUiThread(new bi() { // from class: com.kwad.components.core.webview.tachikoma.a.g.1
                        @Override // com.kwad.sdk.utils.bi
                        public final void doTask() {
                            if (yVar.zr()) {
                                g.this.bY();
                                return;
                            }
                            if (yVar.zt()) {
                                return;
                            }
                            if (yVar.zu()) {
                                g.this.bW();
                                return;
                            }
                            if (yVar.zv()) {
                                g.this.bV();
                            } else if (yVar.zs()) {
                                g.this.bX();
                            } else if (yVar.isFailed()) {
                                g.this.a(yVar);
                            }
                        }
                    });
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
