package com.heytap.msp.mobad.api.ad;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.heytap.msp.mobad.api.listener.IRewardVideoAdListener;
import com.heytap.msp.mobad.api.params.RewardVideoAdParams;
import com.opos.mobad.ad.e.b;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class RewardVideoAd implements IBidding {
    public static final int REWARD_SCENE_AD_CLICK = 5;
    public static final int REWARD_SCENE_INSTALL_COMPLETE = 2;
    public static final int REWARD_SCENE_LAUNCH_APP = 3;
    public static final int REWARD_SCENE_NO = 0;
    public static final int REWARD_SCENE_PLAY_COMPLETE = 1;
    public static final int REWARD_SCENE_PLAY_INTERACTION = 4;
    private static final String TAG = "RewardVideoAd";
    private Context mContext;
    private a mListener;
    private String mPosId;
    private volatile com.opos.mobad.ad.e.a mRewardVideoAdImpl;

    static class a implements b {
        private IRewardVideoAdListener b;

        public a(IRewardVideoAdListener iRewardVideoAdListener) {
            this.b = iRewardVideoAdListener;
        }

        @Override // com.opos.mobad.ad.b.a
        public void a() {
            this.b.onAdSuccess();
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i, String str) {
            this.b.onAdFailed("code=" + i + ",msg=" + (str != null ? str : ""));
            this.b.onAdFailed(i, str);
        }

        @Override // com.opos.mobad.ad.e.b, com.opos.mobad.ad.l.b
        public void a(long j) {
            this.b.onAdClick(j);
        }

        @Override // com.opos.mobad.ad.l.b
        public void a(String str) {
        }

        @Override // com.opos.mobad.ad.j
        public void a(Object... objArr) {
            this.b.onReward(objArr);
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
        }

        @Override // com.opos.mobad.ad.e.b
        public void b(long j) {
            this.b.onVideoPlayClose(j);
        }

        @Override // com.opos.mobad.ad.e.b
        public void b(String str) {
            this.b.onVideoPlayError(str);
        }

        @Override // com.opos.mobad.ad.e.b
        public void c() {
            this.b.onVideoPlayStart();
        }

        @Override // com.opos.mobad.ad.e.b
        public void d() {
            this.b.onVideoPlayComplete();
        }

        @Override // com.opos.mobad.ad.e.b
        public void e() {
            this.b.onLandingPageOpen();
        }

        @Override // com.opos.mobad.ad.e.b
        public void f() {
            this.b.onLandingPageClose();
        }
    }

    public RewardVideoAd(Context context, String str, IRewardVideoAdListener iRewardVideoAdListener) {
        if (context == null || TextUtils.isEmpty(str) || iRewardVideoAdListener == null) {
            Log.e(TAG, "RewardVideoAd Constructor param context and posId and iRewardVideoAdListener can't be null.");
            return;
        }
        this.mContext = context;
        this.mPosId = str;
        this.mListener = getListenerWrapper(iRewardVideoAdListener);
        initImplIfNeed();
    }

    private boolean initImplIfNeed() {
        if (this.mRewardVideoAdImpl != null) {
            return true;
        }
        if (this.mContext == null || TextUtils.isEmpty(this.mPosId)) {
            return false;
        }
        synchronized (this) {
            if (this.mRewardVideoAdImpl != null) {
                return true;
            }
            this.mRewardVideoAdImpl = com.heytap.msp.mobad.api.a.a().a(this.mContext, this.mPosId, this.mListener);
            return this.mRewardVideoAdImpl != null;
        }
    }

    private void loadInter(RewardVideoAdParams rewardVideoAdParams, List<String> list) {
        if (!initImplIfNeed()) {
            a aVar = this.mListener;
            if (aVar != null) {
                aVar.a(-1, "inter ad create fail");
                return;
            }
            return;
        }
        if (rewardVideoAdParams != null) {
            if (list == null) {
                this.mRewardVideoAdImpl.a((int) rewardVideoAdParams.fetchTimeout);
                return;
            } else {
                this.mRewardVideoAdImpl.a((int) rewardVideoAdParams.fetchTimeout, list);
                return;
            }
        }
        com.opos.mobad.ad.e.a aVar2 = this.mRewardVideoAdImpl;
        if (list == null) {
            aVar2.a();
        } else {
            aVar2.a(list);
        }
    }

    public void destroyAd() {
        if (this.mRewardVideoAdImpl != null) {
            this.mRewardVideoAdImpl.b();
        }
        this.mContext = null;
        this.mPosId = null;
    }

    protected void doNotifyReward() {
        if (this.mRewardVideoAdImpl != null) {
            this.mRewardVideoAdImpl.g();
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public int getECPM() {
        if (this.mRewardVideoAdImpl != null) {
            return this.mRewardVideoAdImpl.f();
        }
        return 0;
    }

    a getListenerWrapper(IRewardVideoAdListener iRewardVideoAdListener) {
        return new a(iRewardVideoAdListener);
    }

    @Deprecated
    public int getRewardScene() {
        return 1;
    }

    public boolean isReady() {
        if (this.mRewardVideoAdImpl != null) {
            return this.mRewardVideoAdImpl.d();
        }
        return false;
    }

    public void loadAd() {
        loadAd(null);
    }

    public void loadAd(RewardVideoAdParams rewardVideoAdParams) {
        loadInter(rewardVideoAdParams, (List<String>) null);
    }

    public void loadAd(RewardVideoAdParams rewardVideoAdParams, String str) {
        if (!TextUtils.isEmpty(str)) {
            loadInter(rewardVideoAdParams, Arrays.asList(str));
            return;
        }
        a aVar = this.mListener;
        if (aVar != null) {
            aVar.a(10701, "load error, please check you bidIds");
        }
    }

    public void loadAdWithData(RewardVideoAdParams rewardVideoAdParams, String str) {
        loadInter(rewardVideoAdParams, str);
    }

    protected void loadInter(RewardVideoAdParams rewardVideoAdParams, String str) {
        if (initImplIfNeed()) {
            if (rewardVideoAdParams != null) {
                this.mRewardVideoAdImpl.a((int) rewardVideoAdParams.fetchTimeout, str);
                return;
            } else {
                this.mRewardVideoAdImpl.a(str);
                return;
            }
        }
        a aVar = this.mListener;
        if (aVar != null) {
            aVar.a(-1, "inter ad create fail");
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void notifyRankLoss(int i, String str, int i2) {
        if (this.mRewardVideoAdImpl != null) {
            this.mRewardVideoAdImpl.a(i, str, i2);
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void notifyRankWin(int i) {
        if (this.mRewardVideoAdImpl != null) {
            this.mRewardVideoAdImpl.b(i);
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void setBidECPM(int i) {
        if (this.mRewardVideoAdImpl != null) {
            this.mRewardVideoAdImpl.c(i);
        }
    }

    public void showAd() {
        showAd(false);
    }

    public void showAd(boolean z) {
        if (initImplIfNeed()) {
            this.mRewardVideoAdImpl.a(z);
            return;
        }
        a aVar = this.mListener;
        if (aVar != null) {
            aVar.a(-1, "inter ad create fail");
        }
    }
}
