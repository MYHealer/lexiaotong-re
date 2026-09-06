package com.kwad.components.ad.reward.i;

import android.content.Context;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.bk;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class b extends bk implements bk.a {
    private PlayableSource wu;

    public b(Context context, AdTemplate adTemplate, PlayableSource playableSource) {
        super(context, adTemplate);
        this.wu = playableSource;
        a(this);
    }

    @Override // com.kwad.components.core.webview.jshandler.bk.a
    public final boolean eT() {
        com.kwad.components.ad.reward.a.gs().c(this.wu, new a(this.mContext));
        return false;
    }
}
