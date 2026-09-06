package com.hihonor.adsdk.interstitial.adapter;

import android.os.SystemClock;
import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.api.interstitial.InterstitialAdLoadListener;
import com.hihonor.adsdk.base.api.interstitial.InterstitialExpressAd;
import com.hihonor.adsdk.base.api.splash.SplashExpressAd;
import com.hihonor.adsdk.base.mediation.comm.adevent.ADEvent;
import com.hihonor.adsdk.base.mediation.core.imp.AdapterConstructorBean;
import com.hihonor.adsdk.base.mediation.interfaces.HnBaseAdapter;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class HnInterstitialAdapter extends HnBaseAdapter<SplashExpressAd> {
    private static final String TAG = "HnInterstitialAdapter";
    private long mExpireTimestamp;

    static /* synthetic */ class a {
    }

    private class b implements InterstitialAdLoadListener {
        private b() {
        }

        @Override // com.hihonor.adsdk.base.api.interstitial.InterstitialAdLoadListener
        public void onAdLoaded(InterstitialExpressAd interstitialExpressAd) {
            com.hihonor.adsdk.common.b.b.hnadsc(HnInterstitialAdapter.TAG, "onAdLoaded", new Object[0]);
            if (((HnBaseAdapter) HnInterstitialAdapter.this).mAdEventListener == null) {
                com.hihonor.adsdk.common.b.b.hnadsc(HnInterstitialAdapter.TAG, "hn load ad success, but mListener is null.", new Object[0]);
                com.hihonor.adsdk.base.g.b.hnadsa(107, HnInterstitialAdapter.this.getReportBuilder().hnadsj(String.valueOf(ErrorCode.AD_LOADED_LISTENER_IS_NULL)).hnadsk("hn load ad success, but mListener is null.").hnadsa());
                return;
            }
            if (interstitialExpressAd == null) {
                com.hihonor.adsdk.base.g.b.hnadsa(((HnBaseAdapter) HnInterstitialAdapter.this).mAdEventListener, 107, HnInterstitialAdapter.this.getReportBuilder().hnadsj(String.valueOf(ErrorCode.RESPONSE_DATA_EMPTY)).hnadsk("load success， but ad is null").hnadsa());
                return;
            }
            HnInterstitialDataAd hnInterstitialDataAd = new HnInterstitialDataAd(interstitialExpressAd);
            hnInterstitialDataAd.hnadsc(((HnBaseAdapter) HnInterstitialAdapter.this).mPosId);
            hnInterstitialDataAd.hnadsb(((HnBaseAdapter) HnInterstitialAdapter.this).mMediaRequestId);
            hnInterstitialDataAd.hnadsa(String.valueOf(((HnBaseAdapter) HnInterstitialAdapter.this).mLoadType));
            HnInterstitialAdapter.this.mExpireTimestamp = SystemClock.elapsedRealtime() + 1800000;
            ArrayList arrayList = new ArrayList();
            arrayList.add(hnInterstitialDataAd);
            ((HnBaseAdapter) HnInterstitialAdapter.this).mAdEventListener.hnadsa(new ADEvent(100, arrayList, HnInterstitialAdapter.this.getReportBuilder().hnadsa()));
        }

        @Override // com.hihonor.adsdk.base.callback.BaseListener
        public void onFailed(String str, String str2) {
            com.hihonor.adsdk.common.b.b.hnadsc(HnInterstitialAdapter.TAG, "onFailed code=" + str + " errorMsg=" + str2, new Object[0]);
            com.hihonor.adsdk.base.g.b.hnadsa(((HnBaseAdapter) HnInterstitialAdapter.this).mAdEventListener, 107, HnInterstitialAdapter.this.getReportBuilder().hnadsj(str).hnadsk(str2).hnadsa());
            HnInterstitialAdapter.this.release();
        }

        /* synthetic */ b(HnInterstitialAdapter hnInterstitialAdapter, a aVar) {
            this();
        }
    }

    public HnInterstitialAdapter(AdapterConstructorBean adapterConstructorBean) {
        super(adapterConstructorBean);
    }

    @Override // com.hihonor.adsdk.base.mediation.interfaces.BaseAdapter
    public void fetchAdOnly() {
        com.hihonor.adsdk.common.b.b.hnadsc(TAG, "fetchAdOnly", new Object[0]);
        AdSlot.Builder slotId = new AdSlot.Builder().setSlotId(this.mPosId);
        long j = this.mTimeOutMillis;
        if (j > 0) {
            slotId.setTimeOutMillis(j);
        }
        String str = this.mAdContext;
        if (str != null && str.trim().length() != 0) {
            slotId.setAdContext(this.mAdContext);
        }
        com.hihonor.adsdk.interstitial.f.a aVar = new com.hihonor.adsdk.interstitial.f.a();
        aVar.setAdLoadListener(new b(this, null));
        aVar.setAdSlot(slotId.build());
        aVar.loadAd();
    }

    @Override // com.hihonor.adsdk.base.mediation.interfaces.BaseAdapter
    public int getAdType() {
        return 5;
    }

    @Override // com.hihonor.adsdk.base.mediation.interfaces.BaseAdapter
    public boolean isValid() {
        return SystemClock.elapsedRealtime() <= this.mExpireTimestamp;
    }

    @Override // com.hihonor.adsdk.base.mediation.interfaces.BaseAdapter
    public void setFetchDelay(int i) {
    }
}
