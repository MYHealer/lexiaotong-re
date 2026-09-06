package com.kwad.components.ad.splashscreen.e;

import android.os.Message;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.kwad.sdk.core.config.e;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class d extends com.kwad.components.core.widget.a.c {
    public d(View view, int i) {
        super(view, i);
    }

    @Override // com.kwad.components.core.widget.a.a, com.kwad.sdk.utils.cc.a
    public final void a(Message message) {
        long jKL = e.KL();
        if (message.what == 666) {
            zZ();
            this.ca.sendEmptyMessageDelayed(TTAdConstant.STYLE_SIZE_RADIO_2_3, jKL);
        }
    }

    @Override // com.kwad.components.core.widget.a.c, com.kwad.components.core.widget.a.a
    public final boolean ah() {
        com.kwad.sdk.core.c.b.LW();
        if (com.kwad.sdk.core.c.b.isEnable()) {
            com.kwad.sdk.core.c.b.LW();
            return com.kwad.sdk.core.c.b.isAppOnForeground() && super.ah();
        }
        return super.ah();
    }
}
