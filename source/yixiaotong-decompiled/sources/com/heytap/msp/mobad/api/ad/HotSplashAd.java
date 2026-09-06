package com.heytap.msp.mobad.api.ad;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.heytap.msp.mobad.api.listener.IHotSplashListener;
import com.heytap.msp.mobad.api.listener.IZoomOutSplashAdListener;
import com.heytap.msp.mobad.api.params.SplashAdParams;
import com.opos.mobad.ad.f.c;
import com.opos.mobad.ad.f.d;
import com.opos.mobad.ad.f.e;
import com.opos.mobad.ad.f.f;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class HotSplashAd implements IBidding {
    private static final int INIT_DELAY_TIME = 50;
    private Context mContext;
    private boolean mHadShowed;
    private volatile boolean mHasDestroyed;
    private boolean mIsReady;
    private final c mListener;
    private String mPosId;
    private com.opos.mobad.ad.f.a mSplashAdImpl;
    private final SplashAdParams mSplashAdParams;

    static class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private IHotSplashListener f3428a;
        private HotSplashAd b;

        public a(IHotSplashListener iHotSplashListener, HotSplashAd hotSplashAd) {
            this.f3428a = iHotSplashListener;
            this.b = hotSplashAd;
        }

        @Override // com.opos.mobad.ad.b.a
        public void a() {
            this.b.mIsReady = true;
            IHotSplashListener iHotSplashListener = this.f3428a;
            if (iHotSplashListener != null) {
                iHotSplashListener.onAdReady();
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i, String str) {
            IHotSplashListener iHotSplashListener = this.f3428a;
            if (iHotSplashListener != null) {
                iHotSplashListener.onAdFailed(i, str);
            }
        }

        @Override // com.opos.mobad.ad.l.b
        public void a(long j) {
            IHotSplashListener iHotSplashListener = this.f3428a;
            if (iHotSplashListener != null) {
                iHotSplashListener.onAdClick();
            }
        }

        @Override // com.opos.mobad.ad.l.b
        public void a(String str) {
            this.b.mHadShowed = true;
            IHotSplashListener iHotSplashListener = this.f3428a;
            if (iHotSplashListener != null) {
                iHotSplashListener.onAdShow(str);
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
            IHotSplashListener iHotSplashListener = this.f3428a;
            if (iHotSplashListener != null) {
                iHotSplashListener.onAdDismissed();
            }
        }
    }

    public HotSplashAd(Activity activity, String str, IZoomOutSplashAdListener iZoomOutSplashAdListener, SplashAdParams splashAdParams) throws NullPointerException {
        this((Context) activity, str, (IHotSplashListener) iZoomOutSplashAdListener, splashAdParams);
    }

    public HotSplashAd(Context context, String str, IHotSplashListener iHotSplashListener, SplashAdParams splashAdParams) throws NullPointerException {
        this.mIsReady = false;
        this.mHadShowed = false;
        this.mHasDestroyed = false;
        if (context == null || TextUtils.isEmpty(str) || iHotSplashListener == null || splashAdParams == null) {
            throw new NullPointerException("SplashAd Constructor param context or posId or iSplashAdListener or splashAdParams is null.");
        }
        this.mListener = getListenerWrapper(iHotSplashListener);
        this.mSplashAdParams = splashAdParams;
        initAndLoad(context, str, splashAdParams, new Runnable() { // from class: com.heytap.msp.mobad.api.ad.HotSplashAd.1
            @Override // java.lang.Runnable
            public void run() {
                HotSplashAd.this.loadAdInter(null);
            }
        });
    }

    public HotSplashAd(Context context, String str, IHotSplashListener iHotSplashListener, SplashAdParams splashAdParams, final String str2) throws NullPointerException {
        this.mIsReady = false;
        this.mHadShowed = false;
        this.mHasDestroyed = false;
        if (context == null || TextUtils.isEmpty(str) || iHotSplashListener == null || splashAdParams == null || TextUtils.isEmpty(str2)) {
            throw new NullPointerException("SplashAd Constructor param context or posId or iSplashAdListener or splashAdParams is null.");
        }
        this.mListener = getListenerWrapper(iHotSplashListener);
        this.mSplashAdParams = splashAdParams;
        initAndLoad(context, str, splashAdParams, new Runnable() { // from class: com.heytap.msp.mobad.api.ad.HotSplashAd.3
            @Override // java.lang.Runnable
            public void run() {
                HotSplashAd.this.loadAdInter(str2);
            }
        });
    }

    public HotSplashAd(Context context, String str, final String str2, IHotSplashListener iHotSplashListener, SplashAdParams splashAdParams) throws NullPointerException {
        this.mIsReady = false;
        this.mHadShowed = false;
        this.mHasDestroyed = false;
        if (context == null || TextUtils.isEmpty(str) || iHotSplashListener == null || splashAdParams == null) {
            throw new NullPointerException("SplashAd Constructor param context or posId or iSplashAdListener or splashAdParams is null.");
        }
        this.mListener = getListenerWrapper(iHotSplashListener);
        this.mSplashAdParams = splashAdParams;
        initAndLoad(context, str, splashAdParams, new Runnable() { // from class: com.heytap.msp.mobad.api.ad.HotSplashAd.2
            @Override // java.lang.Runnable
            public void run() {
                HotSplashAd.this.loadAdTransport(str2);
            }
        });
    }

    private e getISkipView() {
        if (this.mSplashAdParams.splashSkipView == null || this.mSplashAdParams.clickViews == null || this.mSplashAdParams.clickViews.size() <= 0) {
            return null;
        }
        return new e() { // from class: com.heytap.msp.mobad.api.ad.HotSplashAd.6
            @Override // com.opos.mobad.ad.f.e
            public View a() {
                return HotSplashAd.this.mSplashAdParams.splashSkipView;
            }

            @Override // com.opos.mobad.ad.f.e
            public void a(int i) {
                HotSplashAd.this.mSplashAdParams.splashSkipView.onSkipCountDown(i);
            }

            @Override // com.opos.mobad.ad.f.e
            public List<View> b() {
                return HotSplashAd.this.mSplashAdParams.clickViews;
            }
        };
    }

    private d getISplashBottomArea(final View view) {
        if (view != null) {
            return new d() { // from class: com.heytap.msp.mobad.api.ad.HotSplashAd.5
                @Override // com.opos.mobad.ad.f.d
                public View a() {
                    return view;
                }
            };
        }
        return null;
    }

    private void initAndLoad(Context context, String str, SplashAdParams splashAdParams, final Runnable runnable) {
        this.mContext = context;
        this.mPosId = str;
        if (splashAdParams.bottomArea != null && splashAdParams.bottomArea.getParent() != null) {
            this.mListener.a(10502, "The bottomArea view already has a parent..please not attachToRoot");
        } else if (initImplIfNeed()) {
            runnable.run();
        } else {
            new Handler(context.getMainLooper()).postDelayed(new Runnable() { // from class: com.heytap.msp.mobad.api.ad.HotSplashAd.4
                @Override // java.lang.Runnable
                public void run() {
                    if (HotSplashAd.this.mHasDestroyed) {
                        return;
                    }
                    if (HotSplashAd.this.initImplIfNeed()) {
                        runnable.run();
                    } else {
                        HotSplashAd.this.mListener.a(-1, "inter ad create fail");
                    }
                }
            }, 50L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean initImplIfNeed() {
        if (this.mSplashAdImpl != null) {
            return true;
        }
        if (this.mContext == null || TextUtils.isEmpty(this.mPosId)) {
            return false;
        }
        synchronized (this) {
            if (this.mSplashAdImpl != null) {
                return true;
            }
            com.opos.mobad.ad.f.a aVarA = com.heytap.msp.mobad.api.a.a().a(this.mContext, this.mPosId, this.mListener, new f.a(this.mContext).a(getISplashBottomArea(this.mSplashAdParams.bottomArea)).b(this.mSplashAdParams.desc).a(this.mSplashAdParams.fetchTimeout).a(this.mSplashAdParams.showPreLoadPage).b(this.mSplashAdParams.isUseSurfaceView).a(this.mSplashAdParams.title).c(true).a(getISkipView()).d(false).a());
            this.mSplashAdImpl = aVarA;
            return aVarA != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAdInter(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mSplashAdImpl.a((int) this.mSplashAdParams.fetchTimeout);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        this.mSplashAdImpl.a((int) this.mSplashAdParams.fetchTimeout, arrayList);
    }

    public void destroyAd() {
        com.opos.mobad.ad.f.a aVar = this.mSplashAdImpl;
        if (aVar != null) {
            aVar.b();
        }
        this.mHasDestroyed = true;
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public int getECPM() {
        com.opos.mobad.ad.f.a aVar = this.mSplashAdImpl;
        return aVar != null ? aVar.f() : IBidding.ECPM_STATUS_NULL_AD_IMPL;
    }

    a getListenerWrapper(IHotSplashListener iHotSplashListener) {
        return new a(iHotSplashListener, this);
    }

    public View getZoomOutView() {
        com.opos.mobad.ad.f.a aVar = this.mSplashAdImpl;
        if (aVar != null) {
            return aVar.j();
        }
        return null;
    }

    public boolean isSupportZoomOut() {
        com.opos.mobad.ad.f.a aVar = this.mSplashAdImpl;
        if (aVar != null) {
            return aVar.k();
        }
        return false;
    }

    protected void loadAdTransport(String str) {
        this.mSplashAdImpl.a((int) this.mSplashAdParams.fetchTimeout, str);
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void notifyRankLoss(int i, String str, int i2) {
        com.opos.mobad.ad.f.a aVar = this.mSplashAdImpl;
        if (aVar != null) {
            aVar.a(i, str, i2);
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void notifyRankWin(int i) {
        com.opos.mobad.ad.f.a aVar = this.mSplashAdImpl;
        if (aVar != null) {
            aVar.b(i);
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void setBidECPM(int i) {
        com.opos.mobad.ad.f.a aVar = this.mSplashAdImpl;
        if (aVar != null) {
            aVar.c(i);
        }
    }

    public void showAd(Activity activity) {
        c cVar;
        String str;
        com.opos.mobad.ad.f.a aVar = this.mSplashAdImpl;
        if (aVar == null) {
            cVar = this.mListener;
            str = "inter ad create fail";
        } else if (!this.mIsReady) {
            cVar = this.mListener;
            str = "ad had not ready";
        } else if (!this.mHadShowed) {
            aVar.a(activity);
            return;
        } else {
            cVar = this.mListener;
            str = "splash had showed";
        }
        cVar.a(-1, str);
    }

    public void zoomOutAnimationFinish() {
        com.opos.mobad.ad.f.a aVar = this.mSplashAdImpl;
        if (aVar != null) {
            aVar.i();
        }
    }

    public void zoomOutAnimationStart() {
        com.opos.mobad.ad.f.a aVar = this.mSplashAdImpl;
        if (aVar != null) {
            aVar.h();
        }
    }
}
