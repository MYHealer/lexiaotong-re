package com.kwad.components.core.webview.jshandler.a;

import android.content.Context;
import com.kwad.sdk.utils.p;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class f implements com.kwad.sdk.core.webview.c.a {
    private final WeakReference<Context> arZ;

    public static class a extends com.kwad.sdk.core.response.a.a {
        public String text;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "setClipBoard";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public f(Context context) {
        this.arZ = new WeakReference<>(context);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        try {
            Context context = this.arZ.get() != null ? this.arZ.get() : null;
            if (context != null) {
                a aVar = new a();
                aVar.parseJson(new JSONObject(str));
                if (p.a(context, "ksad_landing_page", aVar.text)) {
                    cVar.b(null);
                } else {
                    cVar.onError(-1, "写入错误");
                }
            }
        } catch (Throwable unused) {
        }
    }
}
