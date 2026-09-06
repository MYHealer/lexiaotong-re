package com.heytap.msp.mobad.api.ad;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.heytap.msp.mobad.api.listener.IInterstitialVideoAdListener;
import com.opos.mobad.ad.c.c;
import com.opos.mobad.ad.c.d;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class InterstitialVideoAd implements IBidding {
    private static final String TAG = "InterstitialVideoAd";
    private Activity mActivity;
    private volatile c mInstance;
    private a mListener;
    private String mPosId;

    public static class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private IInterstitialVideoAdListener f3430a;

        public a(IInterstitialVideoAdListener iInterstitialVideoAdListener) {
            this.f3430a = iInterstitialVideoAdListener;
        }

        @Override // com.opos.mobad.ad.b.a
        public void a() {
            IInterstitialVideoAdListener iInterstitialVideoAdListener = this.f3430a;
            if (iInterstitialVideoAdListener != null) {
                iInterstitialVideoAdListener.onAdReady();
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i, String str) {
            IInterstitialVideoAdListener iInterstitialVideoAdListener = this.f3430a;
            if (iInterstitialVideoAdListener != null) {
                iInterstitialVideoAdListener.onAdFailed("code=" + i + ",msg=" + (str != null ? str : ""));
                this.f3430a.onAdFailed(i, str);
            }
        }

        @Override // com.opos.mobad.ad.l.b
        public void a(long j) {
            IInterstitialVideoAdListener iInterstitialVideoAdListener = this.f3430a;
            if (iInterstitialVideoAdListener != null) {
                iInterstitialVideoAdListener.onAdClick();
            }
        }

        @Override // com.opos.mobad.ad.l.b
        public void a(String str) {
            IInterstitialVideoAdListener iInterstitialVideoAdListener = this.f3430a;
            if (iInterstitialVideoAdListener != null) {
                iInterstitialVideoAdListener.onAdShow();
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
            IInterstitialVideoAdListener iInterstitialVideoAdListener = this.f3430a;
            if (iInterstitialVideoAdListener != null) {
                iInterstitialVideoAdListener.onAdClose();
            }
        }

        @Override // com.opos.mobad.ad.c.d
        public void c() {
            IInterstitialVideoAdListener iInterstitialVideoAdListener = this.f3430a;
            if (iInterstitialVideoAdListener != null) {
                iInterstitialVideoAdListener.onVideoPlayComplete();
            }
        }
    }

    public InterstitialVideoAd(Activity activity, String str, IInterstitialVideoAdListener iInterstitialVideoAdListener) {
        if (activity == null || TextUtils.isEmpty(str)) {
            Log.e(TAG, "InterstitialAd Constructor param activity and posId can't be null.");
            return;
        }
        this.mActivity = activity;
        this.mPosId = str;
        this.mListener = new a(iInterstitialVideoAdListener);
        initImplIfNeed();
    }

    private boolean initImplIfNeed() {
        if (this.mInstance != null) {
            return true;
        }
        if (this.mActivity == null || TextUtils.isEmpty(this.mPosId)) {
            return false;
        }
        synchronized (this) {
            if (this.mInstance != null) {
                return true;
            }
            this.mInstance = com.heytap.msp.mobad.api.a.a().a(this.mActivity, this.mPosId, this.mListener);
            return this.mInstance != null;
        }
    }

    public void destroyAd() {
        if (this.mInstance != null) {
            this.mInstance.b();
        }
        this.mActivity = null;
        this.mPosId = null;
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public int getECPM() {
        if (this.mInstance != null) {
            return this.mInstance.f();
        }
        return 0;
    }

    public void loadAd() {
        if (initImplIfNeed()) {
            this.mInstance.a();
            return;
        }
        a aVar = this.mListener;
        if (aVar != null) {
            aVar.a(-1, "inter ad create fail");
        }
    }

    public void loadAdWithData(String str) {
        if (initImplIfNeed()) {
            this.mInstance.a(str);
        } else {
            this.mListener.a(-1, "inter ad create fail");
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void notifyRankLoss(int i, String str, int i2) {
        if (this.mInstance != null) {
            this.mInstance.a(i, str, i2);
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void notifyRankWin(int i) {
        if (this.mInstance != null) {
            this.mInstance.b(i);
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void setBidECPM(int i) {
        if (this.mInstance != null) {
            this.mInstance.c(i);
        }
    }

    public void showAd() {
        if (initImplIfNeed()) {
            this.mInstance.a(this.mActivity);
            return;
        }
        a aVar = this.mListener;
        if (aVar != null) {
            aVar.a(-1, "inter ad create fail");
        }
    }
}
