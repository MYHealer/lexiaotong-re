package com.hihonor.adsdk.reward.adapter;

import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.api.reward.RewardAdLoadListener;
import com.hihonor.adsdk.base.api.reward.RewardExpressAd;
import com.hihonor.adsdk.base.mediation.comm.adevent.ADEvent;
import com.hihonor.adsdk.base.mediation.core.imp.AdapterConstructorBean;
import com.hihonor.adsdk.base.mediation.interfaces.HnBaseAdapter;
import com.hihonor.adsdk.common.b.b;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class HnRewardAdapter extends HnBaseAdapter<RewardExpressAd> {
    private static final String TAG = "HnRewardAdapter";
    private double mRewardAmount;
    private String mRewardName;
    private RewardAdLoadListener rewardAdLoadListener;

    class a implements RewardAdLoadListener {
        a() {
        }

        @Override // com.hihonor.adsdk.base.callback.BaseListener
        public void onFailed(String str, String str2) {
            b.hnadsc(HnRewardAdapter.TAG, "onFailed code=" + str + " errorMsg=" + str2, new Object[0]);
            com.hihonor.adsdk.base.g.b.hnadsa(((HnBaseAdapter) HnRewardAdapter.this).mAdEventListener, 107, HnRewardAdapter.this.getReportBuilder().hnadsj(str).hnadsk(str2).hnadsa());
        }

        @Override // com.hihonor.adsdk.base.api.reward.RewardAdLoadListener
        public void onLoadSuccess(RewardExpressAd rewardExpressAd) {
            b.hnadsc(HnRewardAdapter.TAG, "onLoadSuccess", new Object[0]);
            if (((HnBaseAdapter) HnRewardAdapter.this).mAdEventListener == null) {
                b.hnadsc(HnRewardAdapter.TAG, "hn load ad success, but mListener is null.", new Object[0]);
                com.hihonor.adsdk.base.g.b.hnadsa(107, HnRewardAdapter.this.getReportBuilder().hnadsj(String.valueOf(ErrorCode.AD_LOADED_LISTENER_IS_NULL)).hnadsk("hn load ad success, but mListener is null.").hnadsa());
                return;
            }
            if (rewardExpressAd == null) {
                com.hihonor.adsdk.base.g.b.hnadsa(((HnBaseAdapter) HnRewardAdapter.this).mAdEventListener, 107, HnRewardAdapter.this.getReportBuilder().hnadsj(String.valueOf(ErrorCode.RESPONSE_DATA_EMPTY)).hnadsk("load success but, rewardExpressAd is null").hnadsa());
                return;
            }
            HnRewardDataAd hnRewardDataAd = new HnRewardDataAd(rewardExpressAd);
            hnRewardDataAd.hnadsc(((HnBaseAdapter) HnRewardAdapter.this).mPosId);
            hnRewardDataAd.hnadsb(((HnBaseAdapter) HnRewardAdapter.this).mMediaRequestId);
            hnRewardDataAd.hnadsa(String.valueOf(((HnBaseAdapter) HnRewardAdapter.this).mLoadType));
            ArrayList arrayList = new ArrayList();
            arrayList.add(hnRewardDataAd);
            if (((HnBaseAdapter) HnRewardAdapter.this).mAdEventListener != null) {
                ((HnBaseAdapter) HnRewardAdapter.this).mAdEventListener.hnadsa(new ADEvent(100, arrayList, HnRewardAdapter.this.getReportBuilder().hnadsa()));
            }
        }
    }

    public HnRewardAdapter(AdapterConstructorBean adapterConstructorBean) {
        super(adapterConstructorBean);
        this.rewardAdLoadListener = new a();
        this.mRewardName = adapterConstructorBean.getRewardName();
        this.mRewardAmount = adapterConstructorBean.getRewardAmount();
    }

    private void obtainAd() {
        AdSlot.Builder rewardAmount = new AdSlot.Builder().setSlotId(this.mPosId).setAdCount(this.mAdCount).setAdContext(this.mAdContext).setRewardName(this.mRewardName).setRewardAmount(this.mRewardAmount);
        long j = this.mTimeOutMillis;
        if (j > 0) {
            rewardAmount.setTimeOutMillis(j);
        }
        String str = this.mAdContext;
        if (str != null && str.trim().length() != 0) {
            rewardAmount.setAdContext(this.mAdContext);
        }
        com.hihonor.adsdk.reward.d.a aVar = new com.hihonor.adsdk.reward.d.a();
        aVar.setAdLoadListener(this.rewardAdLoadListener);
        aVar.setAdSlot(rewardAmount.build());
        aVar.loadAd();
    }

    @Override // com.hihonor.adsdk.base.mediation.interfaces.BaseAdapter
    public void fetchAdOnly() {
        obtainAd();
    }

    @Override // com.hihonor.adsdk.base.mediation.interfaces.BaseAdapter
    public int getAdType() {
        return 4;
    }

    @Override // com.hihonor.adsdk.base.mediation.interfaces.BaseAdapter
    public boolean isValid() {
        return false;
    }

    @Override // com.hihonor.adsdk.base.mediation.interfaces.BaseAdapter
    public void setFetchDelay(int i) {
    }
}
