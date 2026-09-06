package com.heytap.msp.mobad.api.ad;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.heytap.msp.mobad.api.listener.IBannerAdListener;
import com.opos.mobad.ad.a.b;
import com.opos.mobad.ad.a.c;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class BannerAd implements IBidding {
    private static final String TAG = "BannerAd";
    private Activity mActivity;
    private b mBannerAdImpl;
    private a mListenerWrapper;
    private String mPosId;

    static class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private IBannerAdListener f3417a;

        public a(IBannerAdListener iBannerAdListener) {
            this.f3417a = iBannerAdListener;
        }

        @Override // com.opos.mobad.ad.b.a
        public void a() {
            IBannerAdListener iBannerAdListener = this.f3417a;
            if (iBannerAdListener != null) {
                iBannerAdListener.onAdReady();
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i, String str) {
            IBannerAdListener iBannerAdListener = this.f3417a;
            if (iBannerAdListener != null) {
                iBannerAdListener.onAdFailed("code=" + i + ",msg=" + (str != null ? str : ""));
            }
            IBannerAdListener iBannerAdListener2 = this.f3417a;
            if (iBannerAdListener2 != null) {
                iBannerAdListener2.onAdFailed(i, str);
            }
        }

        @Override // com.opos.mobad.ad.l.b
        public void a(long j) {
            IBannerAdListener iBannerAdListener = this.f3417a;
            if (iBannerAdListener != null) {
                iBannerAdListener.onAdClick();
            }
        }

        @Override // com.opos.mobad.ad.l.b
        public void a(String str) {
            IBannerAdListener iBannerAdListener = this.f3417a;
            if (iBannerAdListener != null) {
                iBannerAdListener.onAdShow();
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
            IBannerAdListener iBannerAdListener = this.f3417a;
            if (iBannerAdListener != null) {
                iBannerAdListener.onAdClose();
            }
        }
    }

    public BannerAd(Activity activity, String str) {
        if (activity == null || TextUtils.isEmpty(str)) {
            Log.e(TAG, "BannerAd Constructor param activity and posId can't be null.");
            return;
        }
        this.mListenerWrapper = getListenerWrapper();
        this.mActivity = activity;
        this.mPosId = str;
        initImplIfNeed();
    }

    private boolean initImplIfNeed() {
        if (this.mBannerAdImpl != null) {
            return true;
        }
        if (this.mActivity == null || TextUtils.isEmpty(this.mPosId)) {
            return false;
        }
        b bVarA = com.heytap.msp.mobad.api.a.a().a(this.mActivity, this.mPosId, this.mListenerWrapper);
        this.mBannerAdImpl = bVarA;
        return bVarA != null;
    }

    private void loadAdInter(List<String> list) {
        if (initImplIfNeed()) {
            if (list == null) {
                this.mBannerAdImpl.a();
                return;
            } else {
                this.mBannerAdImpl.a(list);
                return;
            }
        }
        a aVar = this.mListenerWrapper;
        if (aVar != null) {
            aVar.a(-1, "inter ad create fail");
        }
    }

    public void destroyAd() {
        b bVar = this.mBannerAdImpl;
        if (bVar != null) {
            bVar.b();
        }
        this.mBannerAdImpl = null;
        this.mActivity = null;
        this.mPosId = null;
    }

    protected void doBannerSizeChange(int i, int i2) {
        b bVar = this.mBannerAdImpl;
        if (bVar != null) {
            bVar.a(i, i2);
        }
    }

    public View getAdView() {
        if (initImplIfNeed()) {
            return this.mBannerAdImpl.g();
        }
        a aVar = this.mListenerWrapper;
        if (aVar == null) {
            return null;
        }
        aVar.a(-1, "inter ad create fail");
        return null;
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public int getECPM() {
        b bVar = this.mBannerAdImpl;
        if (bVar != null) {
            return bVar.f();
        }
        return 0;
    }

    a getListenerWrapper() {
        return new a(null);
    }

    public void loadAd() {
        loadAdInter((List<String>) null);
    }

    public void loadAd(String str) {
        if (!TextUtils.isEmpty(str)) {
            loadAdInter(Arrays.asList(str));
            return;
        }
        a aVar = this.mListenerWrapper;
        if (aVar != null) {
            aVar.a(10701, "load error, please check you bidIds");
        }
    }

    protected void loadAdInter(String str) {
        if (initImplIfNeed()) {
            this.mBannerAdImpl.a(str);
            return;
        }
        a aVar = this.mListenerWrapper;
        if (aVar != null) {
            aVar.a(-1, "inter ad create fail");
        }
    }

    public void loadAdWithData(String str) {
        loadAdInter(str);
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void notifyRankLoss(int i, String str, int i2) {
        b bVar = this.mBannerAdImpl;
        if (bVar != null) {
            bVar.a(i, str, i2);
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void notifyRankWin(int i) {
        b bVar = this.mBannerAdImpl;
        if (bVar != null) {
            bVar.b(i);
        }
    }

    public void setAdListener(IBannerAdListener iBannerAdListener) {
        a aVar = this.mListenerWrapper;
        if (aVar != null) {
            aVar.f3417a = iBannerAdListener;
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void setBidECPM(int i) {
        b bVar = this.mBannerAdImpl;
        if (bVar != null) {
            bVar.c(i);
        }
    }
}
