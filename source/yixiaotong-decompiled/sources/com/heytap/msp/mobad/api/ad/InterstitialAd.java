package com.heytap.msp.mobad.api.ad;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.heytap.msp.mobad.api.listener.IInterstitialAdListener;
import com.heytap.msp.mobad.api.params.InterstitialParams;
import com.opos.mobad.ad.c.b;
import com.opos.mobad.ad.c.e;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class InterstitialAd implements IBidding {
    private static final String TAG = "InterstitialAd";
    private Activity mActivity;
    private volatile com.opos.mobad.ad.c.a mInterstitialAdImpl;
    private a mListenerWrapper;
    protected InterstitialParams mParams;
    protected String mPosId;

    static class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private IInterstitialAdListener f3429a;

        public a(IInterstitialAdListener iInterstitialAdListener) {
            this.f3429a = iInterstitialAdListener;
        }

        @Override // com.opos.mobad.ad.b.a
        public void a() {
            IInterstitialAdListener iInterstitialAdListener = this.f3429a;
            if (iInterstitialAdListener != null) {
                iInterstitialAdListener.onAdReady();
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i, String str) {
            IInterstitialAdListener iInterstitialAdListener = this.f3429a;
            if (iInterstitialAdListener != null) {
                iInterstitialAdListener.onAdFailed("code=" + i + ",msg=" + (str != null ? str : ""));
            }
            IInterstitialAdListener iInterstitialAdListener2 = this.f3429a;
            if (iInterstitialAdListener2 != null) {
                iInterstitialAdListener2.onAdFailed(i, str);
            }
        }

        @Override // com.opos.mobad.ad.l.b
        public void a(long j) {
            IInterstitialAdListener iInterstitialAdListener = this.f3429a;
            if (iInterstitialAdListener != null) {
                iInterstitialAdListener.onAdClick();
            }
        }

        @Override // com.opos.mobad.ad.l.b
        public void a(String str) {
            IInterstitialAdListener iInterstitialAdListener = this.f3429a;
            if (iInterstitialAdListener != null) {
                iInterstitialAdListener.onAdShow();
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
            IInterstitialAdListener iInterstitialAdListener = this.f3429a;
            if (iInterstitialAdListener != null) {
                iInterstitialAdListener.onAdClose();
            }
        }
    }

    public InterstitialAd(Activity activity, String str) {
        this(activity, str, null);
    }

    protected InterstitialAd(Activity activity, String str, InterstitialParams interstitialParams) {
        this.mListenerWrapper = getListenerWrapper();
        if (activity == null || TextUtils.isEmpty(str)) {
            Log.e(TAG, "InterstitialAd Constructor param activity and posId can't be null.");
            return;
        }
        this.mActivity = activity;
        this.mPosId = str;
        this.mParams = interstitialParams;
        initImplIfNeed();
    }

    private boolean initImplIfNeed() {
        if (this.mInterstitialAdImpl != null) {
            return true;
        }
        if (this.mActivity == null || TextUtils.isEmpty(this.mPosId)) {
            return false;
        }
        synchronized (this) {
            if (this.mInterstitialAdImpl != null) {
                return true;
            }
            e.b bVar = e.b.NORMAL;
            InterstitialParams interstitialParams = this.mParams;
            if (interstitialParams != null && interstitialParams.interstitialScene == InterstitialParams.InterstitialScene.INSTANT_EXIT) {
                bVar = e.b.INSTANT_EXIT;
            }
            this.mInterstitialAdImpl = com.heytap.msp.mobad.api.a.a().a(this.mActivity, this.mPosId, new e.a().a(bVar).a(), this.mListenerWrapper);
            return this.mInterstitialAdImpl != null;
        }
    }

    private void loadInter(List<String> list) {
        if (!initImplIfNeed()) {
            this.mListenerWrapper.a(-1, "inter ad create fail");
        } else if (list == null) {
            this.mInterstitialAdImpl.a();
        } else {
            this.mInterstitialAdImpl.a(list);
        }
    }

    public void closePopupWindow() {
    }

    public void destroyAd() {
        if (this.mInterstitialAdImpl != null) {
            this.mInterstitialAdImpl.b();
        }
        this.mActivity = null;
        this.mPosId = null;
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public int getECPM() {
        if (this.mInterstitialAdImpl != null) {
            return this.mInterstitialAdImpl.f();
        }
        return 0;
    }

    a getListenerWrapper() {
        return new a(null);
    }

    public void loadAd() {
        loadInter((List<String>) null);
    }

    public void loadAd(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mListenerWrapper.a(10701, "load error, please check you bidIds");
        } else {
            loadInter(Arrays.asList(str));
        }
    }

    public void loadAdWithData(String str) {
        loadInter(str);
    }

    protected void loadInter(String str) {
        if (initImplIfNeed()) {
            this.mInterstitialAdImpl.a(str);
        } else {
            this.mListenerWrapper.a(-1, "inter ad create fail");
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void notifyRankLoss(int i, String str, int i2) {
        if (this.mInterstitialAdImpl != null) {
            this.mInterstitialAdImpl.a(i, str, i2);
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void notifyRankWin(int i) {
        if (this.mInterstitialAdImpl != null) {
            this.mInterstitialAdImpl.b(i);
        }
    }

    public void setAdListener(IInterstitialAdListener iInterstitialAdListener) {
        if (iInterstitialAdListener == null) {
            this.mListenerWrapper.f3429a = null;
        } else {
            this.mListenerWrapper.f3429a = iInterstitialAdListener;
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void setBidECPM(int i) {
        if (this.mInterstitialAdImpl != null) {
            this.mInterstitialAdImpl.c(i);
        }
    }

    public void showAd() {
        if (initImplIfNeed()) {
            this.mInterstitialAdImpl.a(this.mActivity);
        } else {
            this.mListenerWrapper.a(-1, "inter ad create fail");
        }
    }

    public void showAsPopupWindow() {
    }
}
