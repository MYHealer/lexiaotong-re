package com.kwad.components.ad.reward.g;

import android.content.Context;
import com.kwad.components.ad.b.h;
import com.kwad.components.ad.reward.retryReward.d;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.network.e;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class a extends com.kwad.components.ad.c implements h {
    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
        d.kF().kG();
    }

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return h.class;
    }

    @Override // com.kwad.components.ad.b.h
    public final void loadRewardVideoAd(final KsScene ksScene, final KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        a(new com.kwad.sdk.g.a<Boolean>() { // from class: com.kwad.components.ad.reward.g.a.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(Boolean bool) {
                if (bool.booleanValue()) {
                    b.a(ksScene, new c(ksScene.getPosId(), rewardVideoAdListener));
                } else {
                    rewardVideoAdListener.onError(e.aTn.errorCode, e.aTn.msg);
                }
            }
        });
    }

    @Override // com.kwad.components.ad.b.h
    public final void notifyRewardVerify() {
        com.kwad.components.ad.reward.b.gw().notifyRewardVerify();
    }
}
