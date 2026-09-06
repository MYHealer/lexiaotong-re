package com.kwad.components.core.innerEc.live.a;

import android.content.Context;
import com.kwad.components.core.webview.tachikoma.b.w;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class m extends w {
    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerDoubleClickEvent";
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w
    public final void a(com.kwad.sdk.core.b bVar) {
        super.a(bVar);
        com.kwad.sdk.core.d.c.d("JsHandlerRegisterDoubleClickEvent", "jky setData callback: " + this.atX);
        com.kwad.sdk.core.d.c.d("JsHandlerRegisterDoubleClickEvent", "jky setData " + bVar.toJson().toString());
    }

    public static a a(Context context, float f, float f2) {
        return new a(com.kwad.sdk.c.a.a.px2dip(context, f), com.kwad.sdk.c.a.a.px2dip(context, f2));
    }

    public static class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public double x;
        public double y;

        public a(double d, double d2) {
            this.x = d;
            this.y = d2;
        }
    }
}
