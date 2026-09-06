package com.ubixnow.adtype.nativead.api;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd;
import com.ubixnow.core.bean.UMNEcpmInfo;
import com.ubixnow.core.bean.UMNNativeExtraInfo;
import com.ubixnow.ooooo.o00O0;
import com.ubixnow.ooooo.o00OOO00;
import com.ubixnow.ooooo.oo000o;
import com.ubixnow.ooooo.oo00o;
import com.ubixnow.ooooo.oo0o0Oo;
import com.ubixnow.ooooo.ooooO000;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UMNNativeAdBean {
    private static final String TAG = "----UMNNativeAdBean";
    private UMNEcpmInfo ecpmInfo;
    private o00O0 mAd;
    public UMNCustomNativeAd mBaseNativeAd;
    private oo000o mInnerNativeInfo;
    private boolean mIsDestroyed;
    public UMNNativeAdView mNativeView;
    private boolean mWrong;
    private ViewGroup.LayoutParams params;
    public int renderType;
    public HashMap<String, String> extraMap = new HashMap<>();
    private HashMap<String, Object> extraInfo = new HashMap<>();
    public oo0o0Oo exportEventCallBack = new oo0o0Oo();
    private boolean isRegister = false;
    public View.OnClickListener mDefaultCloseViewListener = new View.OnClickListener() { // from class: com.ubixnow.adtype.nativead.api.UMNNativeAdBean.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UMNCustomNativeAd uMNCustomNativeAd = UMNNativeAdBean.this.mBaseNativeAd;
            if (uMNCustomNativeAd != null) {
                uMNCustomNativeAd.notifyAdDislikeClick();
            }
        }
    };

    public UMNNativeAdBean(o00O0 o00o0, oo000o oo000oVar) {
        this.mBaseNativeAd = oo000oVar.OooO00o.get(0);
        this.renderType = oo000oVar.renderType;
        this.mAd = o00o0;
        this.mInnerNativeInfo = oo000oVar;
    }

    private void bindListener(UMNNativeExtraInfo uMNNativeExtraInfo) {
        View closeView;
        if (this.mBaseNativeAd.checkHasCloseViewListener() || uMNNativeExtraInfo == null || (closeView = uMNNativeExtraInfo.getCloseView()) == null) {
            return;
        }
        closeView.setOnClickListener(this.mDefaultCloseViewListener);
    }

    private void bindToWindow(UMNNativeAdView uMNNativeAdView) {
        ViewGroup customAdContainer = this.mBaseNativeAd.getCustomAdContainer();
        if (customAdContainer != null) {
            View childAt = uMNNativeAdView.getChildAt(0);
            if (childAt instanceof ViewGroup) {
                uMNNativeAdView.removeAllViews();
                customAdContainer.addView(childAt);
                uMNNativeAdView.addView(customAdContainer);
            }
        }
        this.mBaseNativeAd.setNativeStatusListener(new UMNNativeStatusListener() { // from class: com.ubixnow.adtype.nativead.api.UMNNativeAdBean.3
            @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
            public void onAdClicked() {
                UMNNativeAdBean.this.reportFeedbackEvent(true);
                UMNNativeAdBean uMNNativeAdBean = UMNNativeAdBean.this;
                uMNNativeAdBean.exportEventCallBack.OooO00o(uMNNativeAdBean.mAd, UMNNativeAdBean.this.mInnerNativeInfo);
            }

            @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
            public void onAdClose() {
                UMNNativeAdBean uMNNativeAdBean = UMNNativeAdBean.this;
                uMNNativeAdBean.exportEventCallBack.OooO0O0(uMNNativeAdBean.mAd, UMNNativeAdBean.this.mInnerNativeInfo);
            }

            @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
            public void onAdExposure() {
                UMNNativeAdBean.this.reportFeedbackEvent(false);
                UMNNativeAdBean uMNNativeAdBean = UMNNativeAdBean.this;
                uMNNativeAdBean.exportEventCallBack.OooO0OO(uMNNativeAdBean.mAd, UMNNativeAdBean.this.mInnerNativeInfo);
            }

            @Override // com.ubixnow.adtype.nativead.api.UMNNativeStatusListener
            public void onAdStatusChanged() {
                UMNNativeAdBean uMNNativeAdBean = UMNNativeAdBean.this;
                uMNNativeAdBean.exportEventCallBack.OooO0Oo(uMNNativeAdBean.mAd, UMNNativeAdBean.this.mInnerNativeInfo);
            }
        });
        this.mBaseNativeAd.setNativeMediaListener(new UMNNativeMediaListener() { // from class: com.ubixnow.adtype.nativead.api.UMNNativeAdBean.4
            @Override // com.ubixnow.adtype.nativead.api.UMNNativeMediaListener
            public void onVideoEnd() {
                UMNNativeAdBean uMNNativeAdBean = UMNNativeAdBean.this;
                uMNNativeAdBean.exportEventCallBack.OooO0o0(uMNNativeAdBean.mAd, UMNNativeAdBean.this.mInnerNativeInfo);
            }

            @Override // com.ubixnow.adtype.nativead.api.UMNNativeMediaListener
            public void onVideoError() {
                UMNNativeAdBean uMNNativeAdBean = UMNNativeAdBean.this;
                uMNNativeAdBean.exportEventCallBack.OooO0o(uMNNativeAdBean.mAd, UMNNativeAdBean.this.mInnerNativeInfo);
            }

            @Override // com.ubixnow.adtype.nativead.api.UMNNativeMediaListener
            public void onVideoStart() {
                UMNNativeAdBean uMNNativeAdBean = UMNNativeAdBean.this;
                uMNNativeAdBean.exportEventCallBack.OooO0oO(uMNNativeAdBean.mAd, UMNNativeAdBean.this.mInnerNativeInfo);
            }
        });
        ooooO000.OooO0O0("-----renderViewToWindow", " mNativeView " + (customAdContainer == null));
    }

    private void renderViewToWindow(View view) {
        ViewGroup customAdContainer = this.mBaseNativeAd.getCustomAdContainer();
        if (customAdContainer != null) {
            customAdContainer.addView(view);
        }
        this.mBaseNativeAd.setNativeStatusListener(new UMNNativeStatusListener() { // from class: com.ubixnow.adtype.nativead.api.UMNNativeAdBean.1
            @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
            public void onAdClicked() {
                UMNNativeAdBean.this.reportFeedbackEvent(true);
                UMNNativeAdBean uMNNativeAdBean = UMNNativeAdBean.this;
                uMNNativeAdBean.exportEventCallBack.OooO00o(uMNNativeAdBean.mAd, UMNNativeAdBean.this.mInnerNativeInfo);
            }

            @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
            public void onAdClose() {
                UMNNativeAdBean uMNNativeAdBean = UMNNativeAdBean.this;
                uMNNativeAdBean.exportEventCallBack.OooO0O0(uMNNativeAdBean.mAd, UMNNativeAdBean.this.mInnerNativeInfo);
            }

            @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
            public void onAdExposure() {
                UMNNativeAdBean.this.reportFeedbackEvent(false);
                UMNNativeAdBean uMNNativeAdBean = UMNNativeAdBean.this;
                uMNNativeAdBean.exportEventCallBack.OooO0OO(uMNNativeAdBean.mAd, UMNNativeAdBean.this.mInnerNativeInfo);
            }

            @Override // com.ubixnow.adtype.nativead.api.UMNNativeStatusListener
            public void onAdStatusChanged() {
                UMNNativeAdBean uMNNativeAdBean = UMNNativeAdBean.this;
                uMNNativeAdBean.exportEventCallBack.OooO0Oo(uMNNativeAdBean.mAd, UMNNativeAdBean.this.mInnerNativeInfo);
            }
        });
        this.mBaseNativeAd.setNativeMediaListener(new UMNNativeMediaListener() { // from class: com.ubixnow.adtype.nativead.api.UMNNativeAdBean.2
            @Override // com.ubixnow.adtype.nativead.api.UMNNativeMediaListener
            public void onVideoEnd() {
                UMNNativeAdBean uMNNativeAdBean = UMNNativeAdBean.this;
                uMNNativeAdBean.exportEventCallBack.OooO0o0(uMNNativeAdBean.mAd, UMNNativeAdBean.this.mInnerNativeInfo);
            }

            @Override // com.ubixnow.adtype.nativead.api.UMNNativeMediaListener
            public void onVideoError() {
                UMNNativeAdBean uMNNativeAdBean = UMNNativeAdBean.this;
                uMNNativeAdBean.exportEventCallBack.OooO0o(uMNNativeAdBean.mAd, UMNNativeAdBean.this.mInnerNativeInfo);
            }

            @Override // com.ubixnow.adtype.nativead.api.UMNNativeMediaListener
            public void onVideoStart() {
                UMNNativeAdBean uMNNativeAdBean = UMNNativeAdBean.this;
                uMNNativeAdBean.exportEventCallBack.OooO0oO(uMNNativeAdBean.mAd, UMNNativeAdBean.this.mInnerNativeInfo);
            }
        });
        ooooO000.OooO0O0("-----renderViewToWindow", " mNativeView " + (customAdContainer == null));
        if (customAdContainer != null) {
            view = customAdContainer;
        }
        if (this.mNativeView != null) {
            if (this.mInnerNativeInfo.getBaseAdConfig().OooO00o.OooOOoo == null || !this.mInnerNativeInfo.getBaseAdConfig().OooO00o.OooOOoo.OooO0OO) {
                this.mNativeView.renderView(view, this.mInnerNativeInfo, null, this.params);
            } else {
                UMNNativeAdView uMNNativeAdView = this.mNativeView;
                uMNNativeAdView.renderView(view, this.mInnerNativeInfo, this.mBaseNativeAd.getShakeView(uMNNativeAdView), this.params);
            }
        }
    }

    private void renderViewToWindowForGdt(View view, ViewGroup viewGroup) {
        ViewGroup customAdContainer;
        UMNCustomNativeAd uMNCustomNativeAd = this.mBaseNativeAd;
        if (viewGroup != null) {
            uMNCustomNativeAd.transferContainer(viewGroup);
            customAdContainer = null;
        } else {
            customAdContainer = uMNCustomNativeAd.getCustomAdContainer();
            if (customAdContainer != null) {
                customAdContainer.addView(view);
            }
        }
        this.mBaseNativeAd.setNativeStatusListener(new UMNNativeStatusListener() { // from class: com.ubixnow.adtype.nativead.api.UMNNativeAdBean.5
            @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
            public void onAdClicked() {
                UMNNativeAdBean.this.reportFeedbackEvent(true);
                UMNNativeAdBean uMNNativeAdBean = UMNNativeAdBean.this;
                uMNNativeAdBean.exportEventCallBack.OooO00o(uMNNativeAdBean.mAd, UMNNativeAdBean.this.mInnerNativeInfo);
            }

            @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
            public void onAdClose() {
                UMNNativeAdBean uMNNativeAdBean = UMNNativeAdBean.this;
                uMNNativeAdBean.exportEventCallBack.OooO0O0(uMNNativeAdBean.mAd, UMNNativeAdBean.this.mInnerNativeInfo);
            }

            @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
            public void onAdExposure() {
                UMNNativeAdBean.this.reportFeedbackEvent(false);
                UMNNativeAdBean uMNNativeAdBean = UMNNativeAdBean.this;
                uMNNativeAdBean.exportEventCallBack.OooO0OO(uMNNativeAdBean.mAd, UMNNativeAdBean.this.mInnerNativeInfo);
            }

            @Override // com.ubixnow.adtype.nativead.api.UMNNativeStatusListener
            public void onAdStatusChanged() {
                UMNNativeAdBean uMNNativeAdBean = UMNNativeAdBean.this;
                uMNNativeAdBean.exportEventCallBack.OooO0Oo(uMNNativeAdBean.mAd, UMNNativeAdBean.this.mInnerNativeInfo);
            }
        });
        if (customAdContainer != null) {
            view = customAdContainer;
        }
        if (this.mNativeView != null) {
            ooooO000.OooO0O0("-----renderViewToWindow", " mNativeView ");
            if (this.mInnerNativeInfo.getBaseAdConfig().OooO00o.OooOOoo == null || !this.mInnerNativeInfo.getBaseAdConfig().OooO00o.OooOOoo.OooO0OO) {
                this.mNativeView.renderGdtView(view, this.mInnerNativeInfo, viewGroup, null);
            } else {
                UMNNativeAdView uMNNativeAdView = this.mNativeView;
                uMNNativeAdView.renderGdtView(view, this.mInnerNativeInfo, viewGroup, this.mBaseNativeAd.getShakeView(uMNNativeAdView));
            }
        }
    }

    public synchronized void bindAdToView(UMNNativeAdView uMNNativeAdView, UMNNativeExtraInfo uMNNativeExtraInfo) {
        try {
            ooooO000.OooO0O0(TAG, " bindAdToView");
            this.mNativeView = uMNNativeAdView;
            if (this.renderType == 1) {
                oo0o0Oo oo0o0oo = this.exportEventCallBack;
                if (oo0o0oo != null && !this.isRegister) {
                    this.isRegister = true;
                    oo0o0oo.OooO0O0(this.mAd.OooOOo0, this.mInnerNativeInfo);
                    this.exportEventCallBack.OooO00o(this.mAd.OooOOo0, (oo00o) this.mInnerNativeInfo, true);
                }
                bindToWindow(uMNNativeAdView);
                if (uMNNativeExtraInfo == null) {
                    uMNNativeExtraInfo = new UMNNativeExtraInfo();
                    uMNNativeExtraInfo.setClickViewList(new ArrayList());
                }
                this.mBaseNativeAd.regist(uMNNativeAdView, uMNNativeExtraInfo);
                bindListener(uMNNativeExtraInfo);
            } else {
                this.mWrong = true;
                Log.e(ooooO000.OooO0O0, "请确认渲染方式");
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    public synchronized void clear(UMNNativeAdView uMNNativeAdView) {
        if (this.mIsDestroyed) {
            return;
        }
        if (this.mNativeView != null) {
            this.mNativeView = null;
        }
        this.mBaseNativeAd.clear(uMNNativeAdView);
    }

    public synchronized void destory() {
        if (this.mIsDestroyed) {
            return;
        }
        clear(this.mNativeView);
        this.mIsDestroyed = true;
        this.mDefaultCloseViewListener = null;
        this.mNativeView = null;
        UMNCustomNativeAd uMNCustomNativeAd = this.mBaseNativeAd;
        if (uMNCustomNativeAd != null) {
            uMNCustomNativeAd.destroy();
        }
    }

    public int getDownloadAppStatus() {
        UMNCustomNativeAd uMNCustomNativeAd = this.mBaseNativeAd;
        if (uMNCustomNativeAd != null) {
            return uMNCustomNativeAd.getDownloadAppStatus();
        }
        return 0;
    }

    public UMNEcpmInfo getEcpmInfo() {
        return this.ecpmInfo;
    }

    public UMNNativeMaterial getMaterial() {
        return this.mBaseNativeAd.getMaterial();
    }

    public String getNativeExpressType() {
        UMNCustomNativeAd uMNCustomNativeAd = this.mBaseNativeAd;
        return uMNCustomNativeAd != null ? uMNCustomNativeAd.getNativeExpressType() : "0";
    }

    public String getRewardTaskAction() {
        UMNCustomNativeAd uMNCustomNativeAd = this.mBaseNativeAd;
        return uMNCustomNativeAd != null ? uMNCustomNativeAd.getRewardTaskAction() : "0";
    }

    public Object getValue(String str) {
        return this.extraInfo.get(str);
    }

    public boolean isNativeExpress() {
        return this.renderType == 2;
    }

    public boolean isValid() {
        UMNCustomNativeAd uMNCustomNativeAd = this.mBaseNativeAd;
        if (uMNCustomNativeAd != null) {
            return uMNCustomNativeAd.isValid();
        }
        return false;
    }

    public void onPause() {
        UMNCustomNativeAd uMNCustomNativeAd;
        if (this.mIsDestroyed || (uMNCustomNativeAd = this.mBaseNativeAd) == null) {
            return;
        }
        uMNCustomNativeAd.onPause();
    }

    public void onResume() {
        UMNCustomNativeAd uMNCustomNativeAd;
        if (this.mIsDestroyed || (uMNCustomNativeAd = this.mBaseNativeAd) == null) {
            return;
        }
        uMNCustomNativeAd.onResume();
    }

    public void pauseVideo() {
        UMNCustomNativeAd uMNCustomNativeAd = this.mBaseNativeAd;
        if (uMNCustomNativeAd == null || this.mIsDestroyed) {
            return;
        }
        uMNCustomNativeAd.pauseVideo();
    }

    public void register(UMNNativeAdView uMNNativeAdView, UMNNativeExtraInfo uMNNativeExtraInfo) {
        try {
            ooooO000.OooO0O0(TAG, "register");
            oo0o0Oo oo0o0oo = this.exportEventCallBack;
            if (oo0o0oo != null && !this.isRegister) {
                this.isRegister = true;
                oo0o0oo.OooO0O0(this.mAd.OooOOo0, this.mInnerNativeInfo);
                this.exportEventCallBack.OooO00o(this.mAd.OooOOo0, (oo00o) this.mInnerNativeInfo, true);
            }
            if (this.mWrong) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(uMNNativeAdView);
            if (uMNNativeAdView != null) {
                if (uMNNativeExtraInfo != null) {
                    if (uMNNativeExtraInfo.getClickViewList() == null) {
                    }
                    this.mBaseNativeAd.regist(uMNNativeAdView, uMNNativeExtraInfo);
                    bindListener(uMNNativeExtraInfo);
                }
                uMNNativeExtraInfo = new UMNNativeExtraInfo();
                uMNNativeExtraInfo.setClickViewList(arrayList);
                this.mBaseNativeAd.regist(uMNNativeAdView, uMNNativeExtraInfo);
                bindListener(uMNNativeExtraInfo);
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    public synchronized void renderView(UMNNativeAdView uMNNativeAdView, View view) {
        ooooO000.OooO0O0(TAG, "renderView ");
        this.mNativeView = uMNNativeAdView;
        uMNNativeAdView.removeAllViews();
        if (this.renderType == 2) {
            view = this.mBaseNativeAd.getAdMediaView(this.mNativeView);
        } else {
            this.mBaseNativeAd.setRootView((ViewGroup) view);
        }
        if (view != null) {
            renderViewToWindow(view);
        } else {
            this.mWrong = true;
            Log.e(ooooO000.OooO0O0, "请确定渲染方式后，检验是否设置了View");
        }
    }

    public synchronized void renderView(UMNNativeAdView uMNNativeAdView, View view, ViewGroup.LayoutParams layoutParams) {
        this.params = layoutParams;
        renderView(uMNNativeAdView, view);
    }

    public synchronized void renderView(UMNNativeAdView uMNNativeAdView, View view, ViewGroup viewGroup) {
        this.mNativeView = uMNNativeAdView;
        if (this.renderType == 2) {
            view = this.mBaseNativeAd.getAdMediaView(uMNNativeAdView);
        } else {
            this.mBaseNativeAd.setRootView(viewGroup);
        }
        if (view != null) {
            renderViewToWindowForGdt(view, viewGroup);
        } else {
            this.mWrong = true;
            Log.e(ooooO000.OooO0O0, "请确定渲染方式后，检验是否设置了View");
        }
    }

    public void reportFeedbackEvent(boolean z) {
        try {
            o00O0 o00o0 = this.mAd;
            if (o00o0 != null) {
                for (o00OOO00 o00ooo00 : o00o0.OooOOoo) {
                    if (z) {
                        o00ooo00.OooO0O0(this.mAd.OooO00o);
                    } else {
                        o00ooo00.OooO00o(this.mAd.OooO00o);
                    }
                }
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    public void resumeVideo() {
        UMNCustomNativeAd uMNCustomNativeAd = this.mBaseNativeAd;
        if (uMNCustomNativeAd == null || this.mIsDestroyed) {
            return;
        }
        uMNCustomNativeAd.resumeVideo();
    }

    public void setEcpmInfo(UMNEcpmInfo uMNEcpmInfo) {
        this.ecpmInfo = uMNEcpmInfo;
    }

    public void setExtraInfo(HashMap<String, Object> map) {
        this.extraInfo = map;
    }

    public void setNativeEventListener(UMNNativeEventListener uMNNativeEventListener) {
        this.exportEventCallBack.OooOOO0 = uMNNativeEventListener;
    }

    public void setNativeMediaListener(UMNNativeMediaListener uMNNativeMediaListener) {
        this.exportEventCallBack.OooOOO = uMNNativeMediaListener;
    }

    public void setNativeStatusListener(UMNNativeEventListener uMNNativeEventListener) {
        this.exportEventCallBack.OooOOO0 = uMNNativeEventListener;
    }

    public void setVideoMute(boolean z) {
        UMNCustomNativeAd uMNCustomNativeAd = this.mBaseNativeAd;
        if (uMNCustomNativeAd == null || this.mIsDestroyed) {
            return;
        }
        uMNCustomNativeAd.setVideoMute(z);
    }

    public void startVideo() {
        UMNCustomNativeAd uMNCustomNativeAd = this.mBaseNativeAd;
        if (uMNCustomNativeAd == null || this.mIsDestroyed) {
            return;
        }
        uMNCustomNativeAd.startVideo();
    }

    public void stopVideo() {
        UMNCustomNativeAd uMNCustomNativeAd = this.mBaseNativeAd;
        if (uMNCustomNativeAd == null || this.mIsDestroyed) {
            return;
        }
        uMNCustomNativeAd.stopVideo();
    }
}
