package com.kwad.components.core.webview.jshandler.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class d implements com.kwad.sdk.core.webview.c.a {
    private final WeakReference<Context> arZ;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "openWechatQRScan";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public d(Context context) {
        this.arZ = new WeakReference<>(context);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        if (this.arZ.get() != null) {
            boolean zAT = aT(this.arZ.get());
            if (cVar != null) {
                if (zAT) {
                    cVar.b(null);
                } else {
                    cVar.onError(-1, "wechat launch error");
                }
            }
        }
    }

    private static boolean aT(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI"));
            intent.putExtra("LauncherUI.From.Scaner.Shortcut", true);
            intent.setFlags(335544320);
            intent.setAction("android.intent.action.VIEW");
            context.startActivity(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
