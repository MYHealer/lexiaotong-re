package com.kwad.components.ad.reward.c;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class e implements com.kwad.sdk.core.webview.c.a {
    private String TAG;
    private com.kwad.sdk.core.webview.c.c re;

    public static class a extends com.kwad.sdk.core.response.a.a {
        public String vk;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerExtraDialogListener";
    }

    public e() {
        String str = "ExtraDialogListener" + hashCode();
        this.TAG = str;
        com.kwad.sdk.core.d.c.d(str, "create: ");
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.sdk.core.d.c.d(this.TAG, "handleJsCall: " + cVar);
        this.re = cVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.sdk.core.d.c.d(this.TAG, "onDestroy: ");
        this.re = null;
    }

    public final void im() {
        com.kwad.sdk.core.d.c.d(this.TAG, "notifyDialogClose: ");
        M("close");
    }

    private void M(String str) {
        if (TextUtils.isEmpty(str) || this.re == null) {
            return;
        }
        a aVar = new a();
        aVar.vk = str;
        this.re.b(aVar);
    }
}
