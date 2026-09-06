package com.ubixnow.adtype.banner.api;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.stub.StubApp;
import com.ubixnow.adtype.banner.custom.UMNCustomBannerAdapter;
import com.ubixnow.core.api.UMNError;
import com.ubixnow.core.common.BaseDevConfig;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.OooO;
import com.ubixnow.ooooo.OooO0o;
import com.ubixnow.ooooo.OooOO0;
import com.ubixnow.ooooo.o00O00OO;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o0OO000o;
import com.ubixnow.ooooo.oOO00;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.oo00o;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UMNBannerAd extends o00O00OO {
    public static final String TAG = "----ubixBanner_DEV";
    public int adPosition;
    private final OooO exportCallBack;
    public boolean isUsedOriginViewGroup;
    private WeakReference<Context> mActivityWeakRef;
    private OooOO0 manager;

    public UMNBannerAd(Context context, UMNBannerParams uMNBannerParams, UMNBannerListener uMNBannerListener) {
        OooO oooO = new OooO();
        this.exportCallBack = oooO;
        this.isUsedOriginViewGroup = true;
        this.adPosition = 0;
        ooooO000.OooO0OO(TAG, "pub_height:" + uMNBannerParams.height + "pub_width:" + uMNBannerParams.width + " slotId: " + uMNBannerParams.slotId);
        if (context != null) {
            this.mActivityWeakRef = new WeakReference<>(context);
            if (BaseUtils.getContext() == null) {
                BaseUtils.init(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            }
        }
        this.devConfig = uMNBannerParams;
        oooO.OooOOO0 = uMNBannerListener;
        WeakReference<Context> weakReference = this.mActivityWeakRef;
        if (weakReference != null) {
            this.manager = new OooOO0(weakReference.get(), uMNBannerParams);
        } else {
            this.manager = new OooOO0(context, uMNBannerParams);
        }
        this.ad = this.manager.OooO00o(getEcpmInfo());
        this.baseAdManager = this.manager;
    }

    public void destroy() {
        ooooO000.OooO0O0(TAG, "----destroy: " + (this.manager != null));
        OooOO0 oooOO0 = this.manager;
        if (oooOO0 != null) {
            oooOO0.OooO0o();
        }
    }

    public View getBannerView() {
        ooooO000.OooO0O0(TAG, "----getBannerView: " + (this.manager != null));
        OooOO0 oooOO0 = this.manager;
        if (oooOO0 != null) {
            return oooOO0.OooO0oO();
        }
        return null;
    }

    public boolean isValid() {
        ooooO000.OooO0O0(TAG, "----isValid: " + (this.manager != null));
        OooOO0 oooOO0 = this.manager;
        if (oooOO0 != null) {
            return oooOO0.OooO0oo();
        }
        return false;
    }

    public void loadAd() {
        if (BaseUtils.getContext() == null) {
            ooooO000.OooO0O0("加载广告前,请先确认context 状态");
            this.exportCallBack.OooOOO0.onError(new UMNError(o0OO000o.OooOOOO, o0OO000o.OooOOOo));
            return;
        }
        BaseDevConfig baseDevConfig = this.devConfig;
        if ((baseDevConfig instanceof UMNBannerParams) && ((UMNBannerParams) baseDevConfig).width < 1) {
            ooooO000.OooO0O0("加载广告前,请先确认宽应大于0");
            if (this.exportCallBack.OooOOO0 != null) {
                BaseUtils.runInMainThread(new Runnable() { // from class: com.ubixnow.adtype.banner.api.UMNBannerAd.1
                    @Override // java.lang.Runnable
                    public void run() {
                        UMNBannerAd.this.exportCallBack.OooOOO0.onError(new UMNError(o0OO000o.OooOoO, o0OO000o.OooOoOO));
                    }
                });
                return;
            }
            return;
        }
        String[] strArrIsCanLoadAd = isCanLoadAd(this.manager.OooO0o0);
        ooooO000.OooO0Oo("开始请求横幅广告 slot_id:" + this.devConfig.slotId);
        o00O00o0 o00o00o0 = new o00O00o0() { // from class: com.ubixnow.adtype.banner.api.UMNBannerAd.2
            @Override // com.ubixnow.ooooo.o00O00o0
            public void onAdCacheSuccess(oo00o oo00oVar) {
                ooooO000.OooO0Oo("onAdCacheSuccess");
                UMNBannerAd.this.exportCallBack.OooO0O0(UMNBannerAd.this.manager.OooO00o(), oo00oVar);
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onAdDataLoaded(oo00o oo00oVar) {
                ooooO000.OooO0OO(UMNBannerAd.TAG, "onAdLoaded");
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onAdRenderFail(ErrorInfo errorInfo) {
                ooooO000.OooO0OO(UMNBannerAd.TAG, "onAdRenderFail");
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onNoAdError(ErrorInfo errorInfo) {
                if (errorInfo != null) {
                    ooooO000.OooO0Oo("onNoAdError code:" + errorInfo.code + " msg:" + errorInfo.msg);
                }
                UMNBannerAd.this.exportCallBack.OooO00o(UMNBannerAd.this.manager.OooO00o(), errorInfo);
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onTimeout() {
                ooooO000.OooO0O0(UMNBannerAd.TAG, "总超时时间到 达到检测条件");
                UMNBannerAd.this.manager.OooO0o0();
                oo00o oo00oVarOooO00o = UMNBannerAd.this.manager.OooO00o(new ErrorInfo(o0OO000o.o0000OOo, oOO00O0.ubix_request_timeout_msg));
                if (oo00oVarOooO00o == null) {
                    UMNBannerAd.this.exportCallBack.OooO00o(UMNBannerAd.this.manager.OooO00o(), new ErrorInfo(o0OO000o.o0000OOo, oOO00O0.ubix_request_timeout_msg));
                    return;
                }
                try {
                    UMNBannerAd.this.exportCallBack.OooO0O0(UMNBannerAd.this.manager.OooO00o(), ((UMNCustomBannerAdapter) oo00oVarOooO00o.getAbsBaseAdapter()).absUbixInfo);
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                    UMNBannerAd.this.exportCallBack.OooO00o(UMNBannerAd.this.manager.OooO00o(), new ErrorInfo(o0OO000o.o0000Oo, oOO00O0.ubix_return_error_msg));
                }
            }
        };
        if (strArrIsCanLoadAd != null) {
            o00o00o0.onNoAdError(new ErrorInfo(strArrIsCanLoadAd[0], strArrIsCanLoadAd[1]));
        } else {
            this.manager.OooO00o(o00o00o0);
        }
    }

    public void show(final ViewGroup viewGroup) {
        ooooO000.OooO0O0("Banner 广告 调用show方法 ");
        BaseUtils.runInMainThread(new Runnable() { // from class: com.ubixnow.adtype.banner.api.UMNBannerAd.3
            /* JADX WARN: Code duplicated, block: B:28:0x00a0 A[Catch: Exception -> 0x00eb, TryCatch #1 {Exception -> 0x00eb, blocks: (B:14:0x005c, B:16:0x0060, B:19:0x006a, B:21:0x0081, B:23:0x0087, B:25:0x0093, B:27:0x0097, B:29:0x00d5, B:31:0x00db, B:33:0x00df, B:34:0x00e1, B:28:0x00a0, B:35:0x00e5), top: B:43:0x005c }] */
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup viewGroup2;
                ViewGroup viewGroup3;
                try {
                    UMNBannerAd.this.exportCallBack.OooO0O0(UMNBannerAd.this.manager.OooO0o0, UMNBannerAd.this.manager.OooO00o().OooOO0);
                    if (UMNBannerAd.this.exportCallBack.OooO00o(1)) {
                        UMNBannerAd.this.exportCallBack.OooO00o(UMNBannerAd.this.manager.OooO0o0, UMNBannerAd.this.manager.OooO00o().OooOO0, UMNBannerAd.this.isValid() && (viewGroup3 = viewGroup) != null && viewGroup3.getVisibility() == 0);
                    }
                } catch (Exception unused) {
                }
                try {
                    if (viewGroup != null && UMNBannerAd.this.manager != null) {
                        final FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
                        if (UMNBannerAd.this.exportCallBack.OooO00o(1)) {
                            UMNBannerAd uMNBannerAd = UMNBannerAd.this;
                            if (uMNBannerAd.isShow) {
                                ooooO000.OooO0O0("广告暂未加载成功");
                                oOO00O0.OooO00o oooO00o = oOO00O0.OooO00o.SHOW_ERROR;
                                ErrorInfo errorInfo = new ErrorInfo(oooO00o.OooO00o(), oooO00o.OooO0O0());
                                errorInfo.object = UMNBannerAd.this.manager.OooO00o().OooOO0;
                                UMNBannerAd.this.exportCallBack.OooO0O0(UMNBannerAd.this.manager.OooO00o(), errorInfo);
                            } else {
                                uMNBannerAd.isShow = true;
                                uMNBannerAd.manager.OooO00o(UMNBannerAd.this.isUsedOriginViewGroup ? viewGroup : frameLayout, new OooO0o() { // from class: com.ubixnow.adtype.banner.api.UMNBannerAd.3.1
                                    @Override // com.ubixnow.ooooo.OooO0o
                                    public void onAdClick(oo00o oo00oVar) {
                                        ooooO000.OooO0OO(UMNBannerAd.TAG, "Banner广告 onAdClick");
                                        UMNBannerAd.this.manager.OooO00o(true);
                                        UMNBannerAd.this.exportCallBack.OooO0o0(UMNBannerAd.this.manager.OooO00o(), oo00oVar);
                                    }

                                    @Override // com.ubixnow.ooooo.OooO0o
                                    public void onAdDismiss(oo00o oo00oVar) {
                                        ooooO000.OooO0OO(UMNBannerAd.TAG, "Banner广告 onAdDismiss");
                                        UMNBannerAd.this.exportCallBack.OooO0o(UMNBannerAd.this.manager.OooO00o(), oo00oVar);
                                        for (int i = 0; i < viewGroup.getChildCount(); i++) {
                                            try {
                                                if ((viewGroup.getChildAt(i) instanceof TextView) && "UBIX".equals(((TextView) viewGroup.getChildAt(i)).getText().toString())) {
                                                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                                    if (!UMNBannerAd.this.isUsedOriginViewGroup) {
                                                        frameLayout.removeView(viewGroup.getChildAt(i));
                                                        return;
                                                    } else {
                                                        ViewGroup viewGroup4 = viewGroup;
                                                        viewGroup4.removeView(viewGroup4.getChildAt(i));
                                                        return;
                                                    }
                                                }
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                    }

                                    @Override // com.ubixnow.ooooo.OooO0o
                                    public void onAdShow(oo00o oo00oVar) {
                                        ooooO000.OooO0OO(UMNBannerAd.TAG, "Banner广告 onAdShow");
                                        UMNBannerAd.this.manager.OooO00o(false);
                                        UMNBannerAd.this.exportCallBack.OooO0oO(UMNBannerAd.this.manager.OooO00o(), oo00oVar);
                                    }

                                    @Override // com.ubixnow.ooooo.OooO0o
                                    public void onShowError(ErrorInfo errorInfo2) {
                                        ooooO000.OooO0OO(UMNBannerAd.TAG, "Banner广告 onShowError");
                                        UMNBannerAd.this.exportCallBack.OooO0O0(UMNBannerAd.this.manager.OooO00o(), errorInfo2);
                                    }
                                });
                            }
                        } else {
                            ooooO000.OooO0O0("广告暂未加载成功");
                            oOO00O0.OooO00o oooO00o2 = oOO00O0.OooO00o.SHOW_ERROR;
                            ErrorInfo errorInfo2 = new ErrorInfo(oooO00o2.OooO00o(), oooO00o2.OooO0O0());
                            errorInfo2.object = UMNBannerAd.this.manager.OooO00o().OooOO0;
                            UMNBannerAd.this.exportCallBack.OooO0O0(UMNBannerAd.this.manager.OooO00o(), errorInfo2);
                        }
                        UMNBannerAd uMNBannerAd2 = UMNBannerAd.this;
                        int i = uMNBannerAd2.adPosition;
                        if (i != 0) {
                            if (uMNBannerAd2.isUsedOriginViewGroup) {
                                viewGroup2 = frameLayout;
                                viewGroup2 = viewGroup;
                            }
                            viewGroup2 = frameLayout;
                            oOO00.OooO00o(viewGroup2, i);
                            return;
                        }
                        return;
                    }
                    ooooO000.OooO0O0("Banner container is null or manager is null");
                } catch (Exception e) {
                    Log.e("-----", "显示异常 " + e.getMessage());
                }
            }
        });
    }
}
