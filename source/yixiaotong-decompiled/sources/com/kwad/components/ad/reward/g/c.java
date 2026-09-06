package com.kwad.components.ad.reward.g;

import android.os.SystemClock;
import com.kwad.components.ad.reward.monitor.RewardLoadCallbackType;
import com.kwad.components.ad.reward.monitor.RewardMonitorInfo;
import com.kwad.components.ad.reward.monitor.d;
import com.kwad.components.core.t.f;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class c {
    private long jP;
    private KsLoadManager.RewardVideoAdListener vK;

    public c(long j, KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        this.jP = j;
        this.vK = rewardVideoAdListener;
    }

    public final void onError(int i, String str) {
        KsLoadManager.RewardVideoAdListener rewardVideoAdListener = this.vK;
        if (rewardVideoAdListener != null) {
            rewardVideoAdListener.onError(i, str);
        }
        d.a(true, (AdTemplate) null, (com.kwad.components.ad.reward.monitor.a) RewardLoadCallbackType.LOAD_ERROR, this.jP, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    public final void b(AdTemplate adTemplate, List<KsRewardVideoAd> list) {
        d.a(true, adTemplate, (com.kwad.components.ad.reward.monitor.a) RewardLoadCallbackType.LOAD_SUCCESS_BEFORE, this.jP, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace != null && stackTrace.length > 3 && adTemplate != null) {
            adTemplate.mDataLoadTraceElement = f.a(stackTrace[2]);
        }
        KsLoadManager.RewardVideoAdListener rewardVideoAdListener = this.vK;
        if (rewardVideoAdListener != null) {
            rewardVideoAdListener.onRewardVideoResult(list);
        }
        d.a(true, adTemplate, (com.kwad.components.ad.reward.monitor.a) RewardLoadCallbackType.LOAD_SUCCESS, this.jP, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    public final void b(AdTemplate adTemplate, List<KsRewardVideoAd> list, long j) {
        d.a(true, adTemplate, (com.kwad.components.ad.reward.monitor.a) RewardLoadCallbackType.LOAD_CACHE_SUCCESS_BEFORE, this.jP, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace != null && stackTrace.length > 3 && adTemplate != null) {
            adTemplate.mDataCacheTraceElement = f.a(stackTrace[2]);
        }
        if (adTemplate != null) {
            try {
                com.kwad.sdk.commercial.convert.d.a(e.eI(adTemplate), SystemClock.elapsedRealtime() - j, 2);
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
        KsLoadManager.RewardVideoAdListener rewardVideoAdListener = this.vK;
        if (rewardVideoAdListener != null) {
            rewardVideoAdListener.onRewardVideoAdLoad(list);
        }
        d.a(true, adTemplate, (com.kwad.components.ad.reward.monitor.a) RewardLoadCallbackType.LOAD_CACHE_SUCCESS, this.jP, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }
}
