package com.baidu.mobads.sdk.api;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.baidu.mobads.sdk.internal.a;
import com.baidu.mobads.sdk.internal.az;
import com.baidu.mobads.sdk.internal.ct;
import com.baidu.mobads.sdk.internal.df;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ExpressInterstitialAd {
    private InterstitialAdDislikeListener mAdDislikeListener;
    private String mAdPlaceId;
    private String mAppsid;
    private int mBidFloor;
    private Context mContext;
    private ExpressInterstitialListener mExpressInterstitialListener;
    private int mHeight;
    private InterAdDownloadWindowListener mInterAdDownloadWindowListener;
    private long mLoadTime;
    private df mNativeInterstitialAdProd;
    private RequestParameters mRequestParameters;
    private boolean mUseDialogContainer;
    private boolean mUseDialogFrame;
    private int mWidth;
    private boolean onlyFetchAd;

    public interface InterAdDownloadWindowListener {
        void adDownloadWindowClose();

        void adDownloadWindowShow();

        void onADPermissionClose();

        void onADPermissionShow();

        void onADPrivacyClick();

        void onADPrivacyClose();
    }

    public interface InterstitialAdDislikeListener {
        void interstitialAdDislikeClick();
    }

    public void setAdDislikeListener(InterstitialAdDislikeListener interstitialAdDislikeListener) {
        this.mAdDislikeListener = interstitialAdDislikeListener;
    }

    public void setAppSid(String str) {
        this.mAppsid = str;
    }

    public void setBidFloor(int i) {
        this.mBidFloor = i;
    }

    public void setDialogFrame(boolean z) {
        this.mUseDialogFrame = z;
    }

    public void setDownloadListener(InterAdDownloadWindowListener interAdDownloadWindowListener) {
        this.mInterAdDownloadWindowListener = interAdDownloadWindowListener;
    }

    public void setRequestParameters(RequestParameters requestParameters) {
        this.mRequestParameters = requestParameters;
    }

    public void useUseDialogContainer(boolean z) {
        this.mUseDialogContainer = z;
    }

    public ExpressInterstitialAd(Context context, String str) {
        this(context, str, 500, 600);
    }

    public ExpressInterstitialAd(Context context, String str, int i, int i2) {
        this.mUseDialogFrame = false;
        this.mBidFloor = -1;
        this.mUseDialogContainer = false;
        this.mContext = context;
        this.mAdPlaceId = str;
        this.mWidth = i;
        this.mHeight = i2;
    }

    public void setLoadListener(ExpressInterstitialListener expressInterstitialListener) {
        this.mExpressInterstitialListener = expressInterstitialListener;
        df dfVar = this.mNativeInterstitialAdProd;
        if (dfVar != null) {
            dfVar.a(expressInterstitialListener);
        }
    }

    public void load() {
        this.mLoadTime = System.currentTimeMillis();
        if (this.mContext == null) {
            az.c().e("ExpressInterstitialAd", "请传一个非空的context再进行load");
        } else {
            this.onlyFetchAd = true;
            reallyLoad();
        }
    }

    public void show() {
        df dfVar = this.mNativeInterstitialAdProd;
        if (dfVar == null) {
            return;
        }
        if (dfVar.f()) {
            this.mNativeInterstitialAdProd.g();
        } else {
            this.mNativeInterstitialAdProd.f((IOAdEvent) null);
        }
    }

    public void show(Activity activity) {
        df dfVar = this.mNativeInterstitialAdProd;
        if (dfVar == null) {
            return;
        }
        dfVar.a(activity);
        show();
    }

    public void destroy() {
        df dfVar = this.mNativeInterstitialAdProd;
        if (dfVar == null) {
            return;
        }
        dfVar.p();
    }

    private void reallyLoad() {
        initNativeInterstitialAdProd();
        this.mNativeInterstitialAdProd.a();
    }

    private void initNativeInterstitialAdProd() {
        System.currentTimeMillis();
        ct ctVar = new ct(this.mContext);
        ctVar.a(new ct.a() { // from class: com.baidu.mobads.sdk.api.ExpressInterstitialAd.1
            @Override // com.baidu.mobads.sdk.internal.ct.a
            public void onAttachedToWindow() {
            }

            @Override // com.baidu.mobads.sdk.internal.ct.a
            public boolean onKeyDown(int i, KeyEvent keyEvent) {
                return i == 4;
            }

            @Override // com.baidu.mobads.sdk.internal.ct.a
            public void onLayoutComplete(int i, int i2) {
            }

            @Override // com.baidu.mobads.sdk.internal.ct.a
            public void onWindowFocusChanged(boolean z) {
            }

            @Override // com.baidu.mobads.sdk.internal.ct.a
            public void onWindowVisibilityChanged(int i) {
            }

            @Override // com.baidu.mobads.sdk.internal.ct.a
            public void dispatchTouchEvent(MotionEvent motionEvent) {
                ExpressInterstitialAd.this.mNativeInterstitialAdProd.a(motionEvent);
            }

            @Override // com.baidu.mobads.sdk.internal.ct.a
            public void onDetachedFromWindow() {
                if (ExpressInterstitialAd.this.mNativeInterstitialAdProd != null) {
                    ExpressInterstitialAd.this.mNativeInterstitialAdProd.o();
                }
            }
        });
        this.mNativeInterstitialAdProd = new df(this.mContext, ctVar, this.mAdPlaceId);
        if (!TextUtils.isEmpty(this.mAppsid)) {
            this.mNativeInterstitialAdProd.q = this.mAppsid;
        }
        this.mNativeInterstitialAdProd.r = this.mBidFloor;
        this.mNativeInterstitialAdProd.t = this.onlyFetchAd;
        this.mNativeInterstitialAdProd.a(this.mExpressInterstitialListener);
        this.mNativeInterstitialAdProd.a(this.mInterAdDownloadWindowListener);
        this.mNativeInterstitialAdProd.a(this.mAdDislikeListener);
        this.mNativeInterstitialAdProd.b(this.mUseDialogFrame);
        this.mNativeInterstitialAdProd.c(this.mUseDialogContainer);
        RequestParameters requestParameters = this.mRequestParameters;
        if (requestParameters != null) {
            this.mNativeInterstitialAdProd.a(requestParameters);
        }
    }

    public String getECPMLevel() {
        a aVarX;
        df dfVar = this.mNativeInterstitialAdProd;
        return (dfVar == null || (aVarX = dfVar.x()) == null) ? "" : aVarX.A();
    }

    public String getPECPM() {
        a aVarX;
        df dfVar = this.mNativeInterstitialAdProd;
        return (dfVar == null || (aVarX = dfVar.x()) == null) ? "" : aVarX.B();
    }

    public boolean isReady() {
        df dfVar = this.mNativeInterstitialAdProd;
        if (dfVar == null || dfVar.m == null) {
            return false;
        }
        return this.mNativeInterstitialAdProd.m.isAdReady();
    }

    public void biddingSuccess(LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        df dfVar = this.mNativeInterstitialAdProd;
        if (dfVar != null) {
            dfVar.a(true, linkedHashMap, biddingListener);
        }
    }

    public void biddingFail(LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        df dfVar = this.mNativeInterstitialAdProd;
        if (dfVar != null) {
            dfVar.a(false, linkedHashMap, biddingListener);
        }
    }

    public String getBiddingToken() {
        this.onlyFetchAd = true;
        initNativeInterstitialAdProd();
        return this.mNativeInterstitialAdProd.l();
    }

    public void loadBiddingAd(String str) {
        df dfVar = this.mNativeInterstitialAdProd;
        if (dfVar != null) {
            dfVar.c(str);
        }
    }

    @Deprecated
    public void setBiddingData(String str) {
        df dfVar = this.mNativeInterstitialAdProd;
        if (dfVar != null) {
            dfVar.b(str);
        }
    }

    public Object getAdDataForKey(String str) {
        df dfVar = this.mNativeInterstitialAdProd;
        if (dfVar != null) {
            return dfVar.a(str);
        }
        return null;
    }
}
