package com.kwad.components.ad.reward.retryReward;

import com.kwad.sdk.api.manager.RewardRetryTaskManager;
import com.kwad.sdk.o;
import com.kwad.sdk.utils.bz;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class a {
    public static void register() {
        try {
            if (bz.aE(o.Gs().getApiVersion(), "4.9.20.1")) {
                com.kwad.sdk.service.c.a(RewardRetryTaskManager.class, RewardRetryTaskManagerImpl.class);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }
}
