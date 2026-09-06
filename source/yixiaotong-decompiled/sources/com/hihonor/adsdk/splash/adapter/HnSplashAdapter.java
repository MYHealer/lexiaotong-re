package com.hihonor.adsdk.splash.adapter;

import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.api.splash.SplashAdLoadListener;
import com.hihonor.adsdk.base.api.splash.SplashExpressAd;
import com.hihonor.adsdk.base.mediation.comm.adevent.ADEvent;
import com.hihonor.adsdk.base.mediation.core.imp.AdapterConstructorBean;
import com.hihonor.adsdk.base.mediation.interfaces.HnBaseAdapter;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class HnSplashAdapter extends HnBaseAdapter<SplashExpressAd> {
    private static final String TAG = "HnSplashAdapter";

    static /* synthetic */ class a {
    }

    private class b implements SplashAdLoadListener {
        private b() {
        }

        @Override // com.hihonor.adsdk.base.callback.BaseListener
        public void onFailed(String str, String str2) {
            com.hihonor.adsdk.common.b.b.hnadsc(HnSplashAdapter.TAG, "onFailed code=" + str + " errorMsg=" + str2, new Object[0]);
            com.hihonor.adsdk.base.g.b.hnadsa(((HnBaseAdapter) HnSplashAdapter.this).mAdEventListener, 107, HnSplashAdapter.this.getReportBuilder().hnadsj(str).hnadsk(str2).hnadsa());
        }

        @Override // com.hihonor.adsdk.base.api.splash.SplashAdLoadListener
        public void onLoadSuccess(SplashExpressAd splashExpressAd) {
            com.hihonor.adsdk.common.b.b.hnadsc(HnSplashAdapter.TAG, "onLoadSuccess", new Object[0]);
            if (((HnBaseAdapter) HnSplashAdapter.this).mAdEventListener == null) {
                com.hihonor.adsdk.common.b.b.hnadsc(HnSplashAdapter.TAG, "hn load ad success, but mListener is null.", new Object[0]);
                com.hihonor.adsdk.base.g.b.hnadsa(107, HnSplashAdapter.this.getReportBuilder().hnadsj(String.valueOf(ErrorCode.AD_LOADED_LISTENER_IS_NULL)).hnadsk("hn load ad success, but mListener is null.").hnadsa());
                return;
            }
            if (splashExpressAd == null) {
                com.hihonor.adsdk.base.g.b.hnadsa(((HnBaseAdapter) HnSplashAdapter.this).mAdEventListener, 107, HnSplashAdapter.this.getReportBuilder().hnadsj(String.valueOf(ErrorCode.RESPONSE_DATA_EMPTY)).hnadsk("load success but, list is null").hnadsa());
                return;
            }
            ArrayList arrayList = new ArrayList();
            HnSplashDataAd hnSplashDataAd = new HnSplashDataAd(splashExpressAd);
            hnSplashDataAd.hnadsc(((HnBaseAdapter) HnSplashAdapter.this).mPosId);
            hnSplashDataAd.hnadsb(((HnBaseAdapter) HnSplashAdapter.this).mMediaRequestId);
            hnSplashDataAd.hnadsa(String.valueOf(((HnBaseAdapter) HnSplashAdapter.this).mLoadType));
            arrayList.add(hnSplashDataAd);
            ((HnBaseAdapter) HnSplashAdapter.this).mAdId = splashExpressAd.getAdId();
            ((HnBaseAdapter) HnSplashAdapter.this).mRequestId = splashExpressAd.getRequestId();
            if (((HnBaseAdapter) HnSplashAdapter.this).mAdEventListener != null) {
                ((HnBaseAdapter) HnSplashAdapter.this).mAdEventListener.hnadsa(new ADEvent(100, arrayList, HnSplashAdapter.this.getReportBuilder().hnadsa()));
            }
        }

        /* synthetic */ b(HnSplashAdapter hnSplashAdapter, a aVar) {
            this();
        }
    }

    public HnSplashAdapter(AdapterConstructorBean adapterConstructorBean) {
        super(adapterConstructorBean);
    }

    @Override // com.hihonor.adsdk.base.mediation.interfaces.BaseAdapter
    public void fetchAdOnly() {
        com.hihonor.adsdk.common.b.b.hnadsc(TAG, "fetchAdOnly: " + this.mLoadType, new Object[0]);
        AdSlot.Builder loadType = new AdSlot.Builder().setSlotId(this.mPosId).setLoadType(this.mLoadType);
        long j = this.mTimeOutMillis;
        if (j > 0) {
            loadType.setTimeOutMillis(j);
        }
        String str = this.mAdContext;
        if (str != null && str.trim().length() != 0) {
            loadType.setAdContext(this.mAdContext);
        }
        com.hihonor.adsdk.splash.c.b bVar = new com.hihonor.adsdk.splash.c.b();
        bVar.setAdLoadListener(new b(this, null));
        bVar.setAdSlot(loadType.build());
        bVar.loadAd();
    }

    @Override // com.hihonor.adsdk.base.mediation.interfaces.BaseAdapter
    public int getAdType() {
        return 3;
    }

    @Override // com.hihonor.adsdk.base.mediation.interfaces.BaseAdapter
    public boolean isValid() {
        return false;
    }

    @Override // com.hihonor.adsdk.base.mediation.interfaces.BaseAdapter
    public void setFetchDelay(int i) {
    }
}
