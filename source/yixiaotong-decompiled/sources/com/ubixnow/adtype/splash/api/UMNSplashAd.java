package com.ubixnow.adtype.splash.api;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import android.view.ViewGroup;
import com.stub.StubApp;
import com.ubixnow.adtype.splash.custom.UMNCustomSplashAdapter;
import com.ubixnow.core.api.UMNError;
import com.ubixnow.core.api.UbixDefaultConstants;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o000O;
import com.ubixnow.ooooo.o000O0;
import com.ubixnow.ooooo.o000O00;
import com.ubixnow.ooooo.o000O00O;
import com.ubixnow.ooooo.o000O0O0;
import com.ubixnow.ooooo.o000OO00;
import com.ubixnow.ooooo.o00O0;
import com.ubixnow.ooooo.o00O00OO;
import com.ubixnow.ooooo.o0OO000o;
import com.ubixnow.ooooo.oO0000O;
import com.ubixnow.ooooo.oOO00000;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.oo00o;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;
import com.ubixnow.utils.monitor.data.UbixDataContentProvider;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UMNSplashAd extends o00O00OO {
    public static final String TAG = "----ubixsplash_dev";
    private String dismissSetting;
    private o000O00 dsCallBack;
    private final o000O exportCallBack;
    private WeakReference<Activity> mActivityWeakRef;
    private o000O0 manager;

    public UMNSplashAd(Activity activity, UMNSplashParams uMNSplashParams, UMNSplashListener uMNSplashListener) {
        this.dismissSetting = "1";
        o000O o000o = new o000O();
        this.exportCallBack = o000o;
        this.dsCallBack = new o000O00() { // from class: com.ubixnow.adtype.splash.api.UMNSplashAd.2
            @Override // com.ubixnow.ooooo.o000O00
            public void onAdClick() {
                if (UMNSplashAd.this.manager.OooO0oO() != null) {
                    UMNSplashAd.this.exportCallBack.OooO0OO(UMNSplashAd.this.manager.OooO00o(), UMNSplashAd.this.manager.OooO0oO());
                }
            }

            @Override // com.ubixnow.ooooo.o000O00
            public void onAdShow() {
                if (UMNSplashAd.this.manager.OooO0oO() != null) {
                    UMNSplashAd.this.exportCallBack.OooO0Oo(UMNSplashAd.this.manager.OooO00o(), UMNSplashAd.this.manager.OooO0oO());
                }
            }

            @Override // com.ubixnow.ooooo.o000O00
            public void onDismiss() {
                if (UMNSplashAd.this.manager.OooO0oO() != null) {
                    UMNSplashAd.this.exportCallBack.OooO00o(UMNSplashAd.this.manager.OooO00o(), UMNSplashAd.this.manager.OooO0oO());
                    UMNSplashAd.this.manager.OooO();
                }
            }
        };
        if (activity != null) {
            this.mActivityWeakRef = new WeakReference<>(activity);
            if (BaseUtils.getContext() == null) {
                BaseUtils.init(StubApp.getOrigApplicationContext(activity.getApplicationContext()));
            }
        }
        if (BaseUtils.getContext() == null && uMNSplashListener != null) {
            Log.e(TAG, oOO00O0.need_init_code_msg);
            uMNSplashListener.onError(new UMNError(oOO00O0.need_init_code, oOO00O0.need_init_code_msg));
            return;
        }
        this.devConfig = uMNSplashParams;
        ooooO000.OooO0OO(TAG, "pub_height:" + uMNSplashParams.height + " RealScreenHeight " + oOO00000.OooO0O0(oOO00000.OooO0OO(BaseUtils.getContext())) + " slotId: " + uMNSplashParams.slotId);
        o000o.OooOOO0 = uMNSplashListener;
        fixParams(BaseUtils.getContext(), uMNSplashParams);
        this.manager = this.mActivityWeakRef != null ? new o000O0(this.mActivityWeakRef.get(), uMNSplashParams) : new o000O0(BaseUtils.getContext(), uMNSplashParams);
        Map<String, Object> map = uMNSplashParams.map;
        if (map != null && map.get("dismiss_setting") != null) {
            this.dismissSetting = uMNSplashParams.map.get("dismiss_setting").toString();
        }
        o00O0 o00o0OooO00o = this.manager.OooO00o(getEcpmInfo());
        this.ad = o00o0OooO00o;
        if (uMNSplashParams.skipTime >= UbixDefaultConstants.splashSkipTime) {
            o00o0OooO00o.OooOOo0.OooOo0o = uMNSplashParams.skipTime + "";
        }
        this.baseAdManager = this.manager;
    }

    private void fixParams(Context context, UMNSplashParams uMNSplashParams) {
        if (uMNSplashParams.width == 0) {
            uMNSplashParams.width = oO0000O.OooO00o(oOO00000.OooO0o(context));
        }
        if (uMNSplashParams.height == 0) {
            uMNSplashParams.height = oO0000O.OooO00o(oOO00000.OooO0OO(context));
        }
    }

    public void destroy() {
        ooooO000.OooO0OO(TAG, "开发者调用destroy方法");
        o000O0 o000o0 = this.manager;
        if (o000o0 != null) {
            o000o0.OooO();
            this.manager.OooOO0();
            this.dsCallBack = null;
        }
    }

    public boolean isValid() {
        ooooO000.OooO0OO(TAG, "开发者调用isValid方法");
        o000O0 o000o0 = this.manager;
        if (o000o0 != null) {
            return o000o0.OooOO0O();
        }
        return false;
    }

    public void loadAd() {
        if (BaseUtils.getContext() == null) {
            ooooO000.OooO0O0("加载广告前请,请先确认context 状态");
            UMNSplashListener uMNSplashListener = this.exportCallBack.OooOOO0;
            if (uMNSplashListener != null) {
                uMNSplashListener.onError(new UMNError(o0OO000o.OooOOOO, o0OO000o.OooOOOo));
                return;
            }
            return;
        }
        if (this.manager.OooO0o0.OooOOoo == 0) {
            if (SystemClock.elapsedRealtime() - UbixDataContentProvider.OooO0O0 > 6000) {
                this.manager.OooO0o0.OooOOoo = 1;
            } else {
                this.manager.OooO0o0.OooOOoo = 2;
            }
        }
        String[] strArrIsCanLoadAd = isCanLoadAd(this.manager.OooO0o0);
        ooooO000.OooO0Oo("开始请求开屏广告");
        o000OO00 o000oo00 = new o000OO00() { // from class: com.ubixnow.adtype.splash.api.UMNSplashAd.1
            @Override // com.ubixnow.ooooo.o00O00o0
            public void onAdCacheSuccess(oo00o oo00oVar) {
                ooooO000.OooO0Oo("onAdCacheSuccess");
                UMNSplashAd.this.exportCallBack.OooO0O0(UMNSplashAd.this.manager.OooO00o(), oo00oVar);
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onAdDataLoaded(oo00o oo00oVar) {
                ooooO000.OooO0OO(UMNSplashAd.TAG, "onAdDataLoaded:");
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onAdRenderFail(ErrorInfo errorInfo) {
                ooooO000.OooO0OO(UMNSplashAd.TAG, "onAdRenderFail");
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onMoreAdSucc(oo00o oo00oVar) {
                ooooO000.OooO0OO(UMNSplashAd.TAG, "onMoreAdSucc");
                UMNSplashAd.this.manager.OooO00o(oo00oVar);
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onNoAdError(ErrorInfo errorInfo) {
                if (errorInfo != null) {
                    ooooO000.OooO0Oo("onNoAdError:code:" + errorInfo.code + " msg:" + errorInfo.msg);
                }
                UMNSplashAd.this.exportCallBack.OooO00o(UMNSplashAd.this.manager.OooO00o(), errorInfo);
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onTimeout() {
                ooooO000.OooO0O0(UMNSplashAd.TAG, "总超时时间到 达到检测条件");
                UMNSplashAd.this.manager.OooO0o0();
                oo00o oo00oVarOooO00o = UMNSplashAd.this.manager.OooO00o(new ErrorInfo(o0OO000o.o0000OOo, oOO00O0.ubix_request_timeout_msg));
                if (oo00oVarOooO00o == null) {
                    UMNSplashAd.this.exportCallBack.OooO00o(UMNSplashAd.this.manager.OooO00o(), new ErrorInfo(o0OO000o.o0000OOo, oOO00O0.ubix_request_timeout_msg));
                    return;
                }
                try {
                    UMNSplashAd.this.exportCallBack.OooO0O0(UMNSplashAd.this.manager.OooO00o(), (oo00o) ((UMNCustomSplashAdapter) oo00oVarOooO00o.getAbsBaseAdapter()).splashInfo);
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                    UMNSplashAd.this.exportCallBack.OooO00o(UMNSplashAd.this.manager.OooO00o(), new ErrorInfo(o0OO000o.o0000Oo, oOO00O0.ubix_return_error_msg));
                }
            }
        };
        if (strArrIsCanLoadAd != null) {
            o000oo00.onNoAdError(new ErrorInfo(strArrIsCanLoadAd[0], strArrIsCanLoadAd[1]));
        } else {
            this.manager.OooO00o(o000oo00);
        }
    }

    public void release() {
        this.exportCallBack.OooOOO0 = null;
    }

    public void show(ViewGroup viewGroup) {
        try {
            ooooO000.OooO0Oo("SplashAd调用show方法");
            o000O o000o = this.exportCallBack;
            o000O0 o000o0 = this.manager;
            o000o.OooO0O0(o000o0.OooO0o0, o000o0.OooO00o().OooOO0);
            boolean z = true;
            if (this.exportCallBack.OooO00o(1)) {
                boolean z2 = viewGroup != null && viewGroup.isShown() && isValid();
                WeakReference<Activity> weakReference = this.mActivityWeakRef;
                boolean zIsDestroyed = (weakReference == null || weakReference.get() == null) ? false : this.mActivityWeakRef.get().isDestroyed();
                o000O o000o2 = this.exportCallBack;
                o000O0 o000o1 = this.manager;
                o000o2.OooO00o(o000o1.OooO0o0, o000o1.OooO00o().OooOO0, z2, zIsDestroyed);
            }
            if (viewGroup != null && this.manager != null) {
                if (this.exportCallBack.OooO00o(1) && !this.isShow) {
                    this.isShow = true;
                    this.manager.OooO00o(viewGroup, new o000O0O0() { // from class: com.ubixnow.adtype.splash.api.UMNSplashAd.3
                        @Override // com.ubixnow.ooooo.o000O0O0
                        public void onAdClick(o000O00O o000o00o) {
                            ooooO000.OooO0OO(UMNSplashAd.TAG, "SplashAd onAdClick:");
                            UMNSplashAd.this.manager.OooOO0o = true;
                            o000o00o.getBaseAdConfig().OooOOO0.OooOoO0 = false;
                            UMNSplashAd.this.manager.OooO00o(true);
                            UMNSplashAd.this.exportCallBack.OooO00o(UMNSplashAd.this.manager.OooO00o(), UMNSplashAd.this.dismissSetting, o000o00o);
                        }

                        @Override // com.ubixnow.ooooo.o000O0O0
                        public void onAdDismiss(o000O00O o000o00o) {
                            ooooO000.OooO0OO(UMNSplashAd.TAG, "SplashAd onAdDismiss: " + (UMNSplashAd.this.manager != null));
                            if (UMNSplashAd.this.manager != null) {
                                UMNSplashAd.this.manager.OooO0O0(false);
                                if (UMNSplashAd.this.manager.OooOO0o) {
                                    UMNSplashAd.this.exportCallBack.OooO00o(UMNSplashAd.this.manager.OooO00o(), o000o00o);
                                    return;
                                }
                                UMNSplashAd.this.manager.OooOO0o = true;
                                if (!UMNSplashAd.this.manager.OooO0o()) {
                                    UMNSplashAd.this.manager.OooO();
                                    UMNSplashAd.this.exportCallBack.OooO00o(UMNSplashAd.this.manager.OooO00o(), o000o00o);
                                } else {
                                    ooooO000.OooO0OO(UMNSplashAd.TAG, "Start DsAd");
                                    o000o00o.getBaseAdConfig().OooOOO0.OooOoO0 = false;
                                    UMNSplashAd.this.manager.OooO00o(UMNSplashAd.this.dsCallBack);
                                }
                            }
                        }

                        @Override // com.ubixnow.ooooo.o000O0O0
                        public void onAdShow(o000O00O o000o00o) {
                            ooooO000.OooO0OO(UMNSplashAd.TAG, "SplashAd onAdShow:");
                            if (UMNSplashAd.this.manager != null) {
                                UMNSplashAd.this.manager.OooO0O0(true);
                                UMNSplashAd.this.manager.OooO00o(false);
                                UMNSplashAd.this.manager.OooO0oo();
                                UMNSplashAd.this.exportCallBack.OooO0O0(UMNSplashAd.this.manager.OooO00o(), o000o00o);
                            }
                        }

                        @Override // com.ubixnow.ooooo.o000O0O0
                        public void onShowError(ErrorInfo errorInfo) {
                            ooooO000.OooO0OO(UMNSplashAd.TAG, "SplashAd onShowError:");
                            if (UMNSplashAd.this.manager != null) {
                                UMNSplashAd.this.manager.OooO0O0(false);
                                UMNSplashAd.this.exportCallBack.OooO0O0(UMNSplashAd.this.manager.OooO00o(), errorInfo);
                            }
                        }
                    });
                    return;
                }
                StringBuilder sb = new StringBuilder("广告暂未加载成功 ");
                if (this.manager.OooO00o().OooOO0 != null) {
                    z = false;
                }
                ooooO000.OooO0O0(sb.append(z).toString());
                oOO00O0.OooO00o oooO00o = oOO00O0.OooO00o.SHOW_ERROR;
                ErrorInfo errorInfo = new ErrorInfo(oooO00o.OooO00o(), oooO00o.OooO0O0());
                errorInfo.object = this.manager.OooO00o().OooOO0;
                this.exportCallBack.OooO0O0(this.manager.OooO00o(), errorInfo);
                return;
            }
            ooooO000.OooO0O0("Splash Activity is null or manager is null");
        } catch (Exception e) {
            ooooO000.OooO0O0("SplashAd show异常 " + e.getMessage());
        }
    }
}
