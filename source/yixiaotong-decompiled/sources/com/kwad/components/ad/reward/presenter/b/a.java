package com.kwad.components.ad.reward.presenter.b;

import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveHandleClickListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b {
    private AdLiveHandleClickListener er = new AdLiveHandleClickListener() { // from class: com.kwad.components.ad.reward.presenter.b.a.1
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveHandleClickListener
        public final void handleAdLiveClick(int i) {
            if (i == 1) {
                a.this.uj.a(1, a.this.getContext(), 115, 1);
            } else if (i == 2) {
                a.this.uj.a(1, a.this.getContext(), AppTypeIdUtil.Drink4GCostControl_1, 1);
            }
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        if (this.uj.dU != null) {
            this.uj.dU.registerClickListener(this.er);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (this.uj.dU != null) {
            this.uj.dU.unRegisterClickListener(this.er);
        }
    }
}
