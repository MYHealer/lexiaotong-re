package com.heytap.msp.mobad.api.ad;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.heytap.msp.mobad.api.listener.IHotSplashListener;
import com.heytap.msp.mobad.api.params.SplashAdParams;
import com.opos.mobad.ad.f.c;
import com.opos.mobad.ad.f.d;
import com.opos.mobad.ad.f.e;
import com.opos.mobad.ad.f.f;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class CustomSplashAd implements IBidding {
    private static final int INIT_DELAY_TIME = 50;
    private Context mContext;
    private volatile boolean mHasDestroyed = false;
    private final c mListener;
    private String mPosId;
    private com.opos.mobad.ad.f.a mSplashAdImpl;
    private final SplashAdParams mSplashAdParams;

    private class a implements c {
        private IHotSplashListener b;

        public a(IHotSplashListener iHotSplashListener) {
            this.b = iHotSplashListener;
        }

        @Override // com.opos.mobad.ad.b.a
        public void a() {
            IHotSplashListener iHotSplashListener = this.b;
            if (iHotSplashListener != null) {
                iHotSplashListener.onAdReady();
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i, String str) {
            IHotSplashListener iHotSplashListener = this.b;
            if (iHotSplashListener != null) {
                iHotSplashListener.onAdFailed(i, str);
            }
        }

        @Override // com.opos.mobad.ad.l.b
        public void a(long j) {
            IHotSplashListener iHotSplashListener = this.b;
            if (iHotSplashListener != null) {
                iHotSplashListener.onAdClick();
            }
        }

        @Override // com.opos.mobad.ad.l.b
        public void a(String str) {
            IHotSplashListener iHotSplashListener = this.b;
            if (iHotSplashListener != null) {
                iHotSplashListener.onAdShow(str);
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
            IHotSplashListener iHotSplashListener = this.b;
            if (iHotSplashListener != null) {
                iHotSplashListener.onAdDismissed();
            }
        }
    }

    public CustomSplashAd(Context context, String str, IHotSplashListener iHotSplashListener, SplashAdParams splashAdParams) throws NullPointerException {
        if (context == null || TextUtils.isEmpty(str) || iHotSplashListener == null || splashAdParams == null) {
            throw new NullPointerException("SplashAd Constructor param context or posId or iSplashAdListener or splashAdParams is null.");
        }
        this.mListener = new a(iHotSplashListener);
        this.mSplashAdParams = splashAdParams;
        initAndLoad(context, str, splashAdParams, null);
    }

    public CustomSplashAd(Context context, String str, IHotSplashListener iHotSplashListener, SplashAdParams splashAdParams, String str2) throws NullPointerException {
        if (context == null || TextUtils.isEmpty(str) || iHotSplashListener == null || splashAdParams == null || TextUtils.isEmpty(str2)) {
            throw new NullPointerException("SplashAd Constructor param context or posId or iSplashAdListener or splashAdParams or token is null.");
        }
        this.mListener = new a(iHotSplashListener);
        this.mSplashAdParams = splashAdParams;
        initAndLoad(context, str, splashAdParams, str2);
    }

    private e getISkipView() {
        if (this.mSplashAdParams.splashSkipView == null || this.mSplashAdParams.clickViews == null || this.mSplashAdParams.clickViews.size() <= 0) {
            return null;
        }
        return new e() { // from class: com.heytap.msp.mobad.api.ad.CustomSplashAd.3
            @Override // com.opos.mobad.ad.f.e
            public View a() {
                return CustomSplashAd.this.mSplashAdParams.splashSkipView;
            }

            @Override // com.opos.mobad.ad.f.e
            public void a(int i) {
                CustomSplashAd.this.mSplashAdParams.splashSkipView.onSkipCountDown(i);
            }

            @Override // com.opos.mobad.ad.f.e
            public List<View> b() {
                return CustomSplashAd.this.mSplashAdParams.clickViews;
            }
        };
    }

    private d getISplashBottomArea(final View view) {
        if (view != null) {
            return new d() { // from class: com.heytap.msp.mobad.api.ad.CustomSplashAd.2
                @Override // com.opos.mobad.ad.f.d
                public View a() {
                    return view;
                }
            };
        }
        return null;
    }

    private void initAndLoad(Context context, String str, SplashAdParams splashAdParams, final String str2) {
        this.mContext = context;
        this.mPosId = str;
        if (splashAdParams.bottomArea != null && splashAdParams.bottomArea.getParent() != null) {
            this.mListener.a(10502, "The bottomArea view already has a parent..please not attachToRoot");
        } else if (initImplIfNeed()) {
            loadAdInter(str2);
        } else {
            new Handler(context.getMainLooper()).postDelayed(new Runnable() { // from class: com.heytap.msp.mobad.api.ad.CustomSplashAd.1
                @Override // java.lang.Runnable
                public void run() {
                    if (CustomSplashAd.this.mHasDestroyed) {
                        return;
                    }
                    if (CustomSplashAd.this.initImplIfNeed()) {
                        CustomSplashAd.this.loadAdInter(str2);
                    } else {
                        CustomSplashAd.this.mListener.a(-1, "inter ad create fail");
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
        if (aVar != null) {
            return aVar.f();
        }
        return 0;
    }

    public View getSplashView() {
        com.opos.mobad.ad.f.a aVar = this.mSplashAdImpl;
        if (aVar == null) {
            return null;
        }
        return aVar.g();
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
}
