package com.kwad.components.ad.draw.presenter.livecard;

import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveHandleClickListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class a extends com.kwad.components.ad.draw.b.a {
    private AdLiveHandleClickListener er = new AdLiveHandleClickListener() { // from class: com.kwad.components.ad.draw.presenter.livecard.a.1
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveHandleClickListener
        public final void handleAdLiveClick(int i) {
            if (i == 1) {
                a.this.dQ.a(1, a.this.getContext(), 115, 1);
            } else if (i == 2) {
                a.this.dQ.a(1, a.this.getContext(), AppTypeIdUtil.Drink4GCostControl_1, 2);
            }
        }
    };

    @Override // com.kwad.components.ad.draw.b.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        if (this.dQ.dU != null) {
            this.dQ.dU.registerClickListener(this.er);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (this.dQ.dU != null) {
            this.dQ.dU.unRegisterClickListener(this.er);
        }
    }
}
