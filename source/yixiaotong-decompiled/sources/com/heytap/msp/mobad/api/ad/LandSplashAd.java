package com.heytap.msp.mobad.api.ad;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.heytap.msp.mobad.api.listener.ISplashAdListener;
import com.heytap.msp.mobad.api.params.SplashAdParams;
import com.opos.mobad.ad.f.b;
import com.opos.mobad.ad.f.c;
import com.opos.mobad.ad.f.f;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class LandSplashAd {
    private static final String TAG = "SplashAd";
    private Activity mActivity;
    private volatile b mLandSplashAdImpl;
    private a mListener;
    private String mPosId;
    private SplashAdParams mSplashAdParams;

    private static class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ISplashAdListener f3431a;

        public a(ISplashAdListener iSplashAdListener) {
            this.f3431a = iSplashAdListener;
        }

        @Override // com.opos.mobad.ad.b.a
        public void a() {
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i, String str) {
            this.f3431a.onAdFailed("code=" + i + ",msg=" + (str != null ? str : ""));
            this.f3431a.onAdFailed(i, str);
        }

        @Override // com.opos.mobad.ad.l.b
        public void a(long j) {
            this.f3431a.onAdClick();
        }

        @Override // com.opos.mobad.ad.l.b
        public void a(String str) {
            this.f3431a.onAdShow(str);
            this.f3431a.onAdShow();
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
            this.f3431a.onAdDismissed();
        }
    }

    public LandSplashAd(Activity activity, String str, ISplashAdListener iSplashAdListener, SplashAdParams splashAdParams) throws NullPointerException {
        this(activity, str, null, iSplashAdListener, splashAdParams);
    }

    public LandSplashAd(Activity activity, String str, String str2, ISplashAdListener iSplashAdListener, SplashAdParams splashAdParams) throws NullPointerException {
        if (activity == null || TextUtils.isEmpty(str) || iSplashAdListener == null || splashAdParams == null) {
            Log.e(TAG, "SplashAd Constructor param activity or posId or iSplashAdListener or splashAdParams is null.");
            return;
        }
        this.mActivity = activity;
        this.mPosId = str;
        if (splashAdParams != null) {
            this.mSplashAdParams = splashAdParams;
        } else {
            this.mSplashAdParams = new SplashAdParams.Builder().build();
        }
        this.mListener = new a(iSplashAdListener);
        if (!initImplIfNeed()) {
            this.mListener.a(-1, "inter ad create fail");
        } else if (TextUtils.isEmpty(str2)) {
            this.mLandSplashAdImpl.a((int) this.mSplashAdParams.fetchTimeout);
        } else {
            this.mLandSplashAdImpl.a((int) this.mSplashAdParams.fetchTimeout, str2);
        }
    }

    private boolean initImplIfNeed() {
        if (this.mLandSplashAdImpl != null) {
            return true;
        }
        if (this.mActivity == null || TextUtils.isEmpty(this.mPosId)) {
            return false;
        }
        synchronized (this) {
            if (this.mLandSplashAdImpl != null) {
                return true;
            }
            this.mLandSplashAdImpl = com.heytap.msp.mobad.api.a.a().a(this.mActivity, this.mPosId, (c) this.mListener, new f.a(this.mActivity).b(this.mSplashAdParams.desc).a(this.mSplashAdParams.fetchTimeout).a(this.mSplashAdParams.showPreLoadPage).b(this.mSplashAdParams.isUseSurfaceView).a(this.mSplashAdParams.title).c(false).a());
            return this.mLandSplashAdImpl != null;
        }
    }

    public void destroyAd() {
        if (this.mLandSplashAdImpl != null) {
            this.mLandSplashAdImpl.b();
        }
        this.mActivity = null;
        this.mPosId = null;
        this.mSplashAdParams = null;
    }
}
