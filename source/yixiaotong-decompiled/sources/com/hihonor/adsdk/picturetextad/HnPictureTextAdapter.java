package com.hihonor.adsdk.picturetextad;

import android.text.TextUtils;
import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.api.feed.PictureTextAdLoadListener;
import com.hihonor.adsdk.base.api.feed.PictureTextExpressAd;
import com.hihonor.adsdk.base.mediation.comm.adevent.ADEvent;
import com.hihonor.adsdk.base.mediation.core.imp.AdapterConstructorBean;
import com.hihonor.adsdk.base.mediation.interfaces.HnBaseAdapter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
class HnPictureTextAdapter extends HnBaseAdapter<PictureTextExpressAd> {
    private static final String TAG = "HnPictureTextAdapter";
    private boolean mIsValid;
    private String mRequestId;

    static /* synthetic */ class a {
    }

    private class b implements PictureTextAdLoadListener {
        private b() {
        }

        @Override // com.hihonor.adsdk.base.api.feed.PictureTextAdLoadListener
        public void onAdLoaded(List<PictureTextExpressAd> list) {
            com.hihonor.adsdk.common.b.b.hnadsc(HnPictureTextAdapter.TAG, "onLoadSuccess", new Object[0]);
            HnPictureTextAdapter.this.mIsValid = true;
            if (((HnBaseAdapter) HnPictureTextAdapter.this).mAdEventListener == null) {
                com.hihonor.adsdk.common.b.b.hnadsc(HnPictureTextAdapter.TAG, "hn load ad success, but mListener is null.", new Object[0]);
                com.hihonor.adsdk.base.g.b.hnadsa(107, HnPictureTextAdapter.this.getReportBuilder().hnadsj(String.valueOf(ErrorCode.AD_LOADED_LISTENER_IS_NULL)).hnadsk("hn load ad success, but mListener is null.").hnadsa());
                return;
            }
            if (list == null) {
                com.hihonor.adsdk.base.g.b.hnadsa(((HnBaseAdapter) HnPictureTextAdapter.this).mAdEventListener, 107, HnPictureTextAdapter.this.getReportBuilder().hnadsj(String.valueOf(ErrorCode.RESPONSE_DATA_EMPTY)).hnadsk("load success but, list is null").hnadsa());
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (PictureTextExpressAd pictureTextExpressAd : list) {
                if (TextUtils.isEmpty(HnPictureTextAdapter.this.mRequestId)) {
                    HnPictureTextAdapter.this.mRequestId = pictureTextExpressAd.getRequestId();
                }
                HnPictureTextDataAd hnPictureTextDataAd = new HnPictureTextDataAd(pictureTextExpressAd);
                hnPictureTextDataAd.hnadsc(((HnBaseAdapter) HnPictureTextAdapter.this).mPosId);
                hnPictureTextDataAd.hnadsb(((HnBaseAdapter) HnPictureTextAdapter.this).mMediaRequestId);
                hnPictureTextDataAd.hnadsa(String.valueOf(((HnBaseAdapter) HnPictureTextAdapter.this).mLoadType));
                arrayList.add(hnPictureTextDataAd);
            }
            if (((HnBaseAdapter) HnPictureTextAdapter.this).mAdEventListener != null) {
                ((HnBaseAdapter) HnPictureTextAdapter.this).mAdEventListener.hnadsa(new ADEvent(100, arrayList, HnPictureTextAdapter.this.getReportBuilder().hnadsa()));
            }
        }

        @Override // com.hihonor.adsdk.base.callback.BaseListener
        public void onFailed(String str, String str2) {
            com.hihonor.adsdk.common.b.b.hnadsc(HnPictureTextAdapter.TAG, "onFailed code=" + str + " errorMsg=" + str2, new Object[0]);
            HnPictureTextAdapter.this.mIsValid = false;
            com.hihonor.adsdk.base.g.b.hnadsa(((HnBaseAdapter) HnPictureTextAdapter.this).mAdEventListener, 107, HnPictureTextAdapter.this.getReportBuilder().hnadsj(str).hnadsk(str2).hnadsa());
        }

        /* synthetic */ b(HnPictureTextAdapter hnPictureTextAdapter, a aVar) {
            this();
        }
    }

    public HnPictureTextAdapter(AdapterConstructorBean adapterConstructorBean) {
        super(adapterConstructorBean);
        this.mIsValid = false;
    }

    @Override // com.hihonor.adsdk.base.mediation.interfaces.BaseAdapter
    public void fetchAdOnly() {
        AdSlot.Builder adContext = new AdSlot.Builder().setSlotId(this.mPosId).setAdContext(this.mAdContext);
        long j = this.mTimeOutMillis;
        if (j > 0) {
            adContext.setTimeOutMillis(j);
        }
        String str = this.mAdContext;
        if (str != null && str.trim().length() != 0) {
            adContext.setAdContext(this.mAdContext);
        }
        e eVar = new e();
        eVar.setAdSlot(adContext.build());
        eVar.setAdLoadListener(new b(this, null));
        eVar.loadAd();
    }

    @Override // com.hihonor.adsdk.base.mediation.interfaces.BaseAdapter
    public int getAdType() {
        return 2;
    }

    @Override // com.hihonor.adsdk.base.mediation.interfaces.BaseAdapter
    public boolean isValid() {
        return this.mIsValid;
    }

    @Override // com.hihonor.adsdk.base.mediation.interfaces.BaseAdapter
    public void setFetchDelay(int i) {
    }
}
