package com.ubixnow.adtype.interstital.api;

import android.app.Activity;
import android.content.Context;
import com.stub.StubApp;
import com.ubixnow.adtype.interstital.custom.UMNCustomInterstitalAdapter;
import com.ubixnow.core.api.UMNError;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.OooOo;
import com.ubixnow.ooooo.Oooo0;
import com.ubixnow.ooooo.Oooo000;
import com.ubixnow.ooooo.o00O00OO;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o0OO000o;
import com.ubixnow.ooooo.o0oO0O0o;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.oo00o;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UMNInterstitalAd extends o00O00OO {
    public static final String TAG = "----ubixinterstital_dev";
    private final Oooo000 exportCallBack;
    private WeakReference<Context> mActivityWeakRef;
    private Oooo0 manager;

    public UMNInterstitalAd(Context context, UMNInterstitalParams uMNInterstitalParams, UMNInterstitalListener uMNInterstitalListener) {
        Oooo000 oooo000 = new Oooo000();
        this.exportCallBack = oooo000;
        ooooO000.OooO0OO(TAG, "pub_height:" + uMNInterstitalParams.height + "pub_width:" + uMNInterstitalParams.width + " slotId: " + uMNInterstitalParams.slotId);
        if (context != null) {
            this.mActivityWeakRef = new WeakReference<>(context);
            if (BaseUtils.getContext() == null) {
                BaseUtils.init(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            }
        }
        this.devConfig = uMNInterstitalParams;
        oooo000.OooOOO0 = uMNInterstitalListener;
        WeakReference<Context> weakReference = this.mActivityWeakRef;
        if (weakReference != null) {
            this.manager = new Oooo0(weakReference.get(), uMNInterstitalParams);
        } else {
            this.manager = new Oooo0(context, uMNInterstitalParams);
        }
        this.ad = this.manager.OooO00o(getEcpmInfo());
        this.baseAdManager = this.manager;
    }

    public void destroy() {
        ooooO000.OooO0OO(TAG, "销毁插屏广告");
        Oooo0 oooo0 = this.manager;
        if (oooo0 != null) {
            oooo0.OooO0o();
        }
    }

    public boolean isValid() {
        ooooO000.OooO0OO(TAG, "插屏广告是否有效");
        Oooo0 oooo0 = this.manager;
        if (oooo0 != null) {
            return oooo0.OooO0oO();
        }
        return false;
    }

    public void loadAd() {
        if (BaseUtils.getContext() == null) {
            ooooO000.OooO0O0("加载广告前请,请先确认context 状态");
            this.exportCallBack.OooOOO0.onError(new UMNError(o0OO000o.OooOOOO, o0OO000o.OooOOOo));
            return;
        }
        String[] strArrIsCanLoadAd = isCanLoadAd(this.manager.OooO0o0);
        ooooO000.OooO0Oo("开始请求插屏广告 slot_id:" + this.devConfig.slotId);
        o00O00o0 o00o00o0 = new o00O00o0() { // from class: com.ubixnow.adtype.interstital.api.UMNInterstitalAd.1
            @Override // com.ubixnow.ooooo.o00O00o0
            public void onAdCacheSuccess(oo00o oo00oVar) {
                ooooO000.OooO0Oo("onAdCacheSuccess");
                UMNInterstitalAd.this.exportCallBack.OooO0O0(UMNInterstitalAd.this.manager.OooO00o(), oo00oVar);
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onAdDataLoaded(oo00o oo00oVar) {
                ooooO000.OooO0OO(UMNInterstitalAd.TAG, "onAdDataLoaded");
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onAdRenderFail(ErrorInfo errorInfo) {
                ooooO000.OooO0OO(UMNInterstitalAd.TAG, "onAdRenderFail");
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onNoAdError(ErrorInfo errorInfo) {
                if (errorInfo != null) {
                    ooooO000.OooO0Oo("onNoAdError:code:" + errorInfo.code + " msg:" + errorInfo.msg);
                }
                UMNInterstitalAd.this.exportCallBack.OooO00o(UMNInterstitalAd.this.manager.OooO00o(), errorInfo);
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onTimeout() {
                ooooO000.OooO0O0(UMNInterstitalAd.TAG, "总超时时间到 达到检测条件");
                UMNInterstitalAd.this.manager.OooO0o0();
                oo00o oo00oVarOooO00o = UMNInterstitalAd.this.manager.OooO00o(new ErrorInfo(o0OO000o.o0000OOo, oOO00O0.ubix_request_timeout_msg));
                if (oo00oVarOooO00o == null) {
                    UMNInterstitalAd.this.exportCallBack.OooO00o(UMNInterstitalAd.this.manager.OooO00o(), new ErrorInfo(o0OO000o.o0000OOo, oOO00O0.ubix_request_timeout_msg));
                    return;
                }
                try {
                    UMNInterstitalAd.this.exportCallBack.OooO0O0(UMNInterstitalAd.this.manager.OooO00o(), ((UMNCustomInterstitalAdapter) oo00oVarOooO00o.getAbsBaseAdapter()).absUbixInfo);
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                    UMNInterstitalAd.this.exportCallBack.OooO00o(UMNInterstitalAd.this.manager.OooO00o(), new ErrorInfo(o0OO000o.o0000Oo, oOO00O0.ubix_return_error_msg));
                }
            }
        };
        if (strArrIsCanLoadAd != null) {
            o00o00o0.onNoAdError(new ErrorInfo(strArrIsCanLoadAd[0], strArrIsCanLoadAd[1]));
        } else {
            this.manager.OooO00o(o00o00o0);
        }
    }

    public void show(final Activity activity) {
        try {
            Oooo000 oooo000 = this.exportCallBack;
            Oooo0 oooo0 = this.manager;
            oooo000.OooO0O0(oooo0.OooO0o0, oooo0.OooO00o().OooOO0);
            if (this.exportCallBack.OooO00o(1)) {
                boolean z = (activity == null || activity.isFinishing() || !isValid()) ? false : true;
                Oooo000 oooo001 = this.exportCallBack;
                Oooo0 oooo1 = this.manager;
                oooo001.OooO00o(oooo1.OooO0o0, oooo1.OooO00o().OooOO0, z);
            }
            if (this.exportCallBack.OooO00o(1) && !this.isShow) {
                ooooO000.OooO0Oo("插屏广告 调用show方法");
                this.isShow = true;
                this.manager.OooO00o(activity, new OooOo() { // from class: com.ubixnow.adtype.interstital.api.UMNInterstitalAd.2
                    @Override // com.ubixnow.ooooo.OooOo
                    public void onAdClick(oo00o oo00oVar) {
                        UMNInterstitalAd.this.manager.OooO00o(true);
                        UMNInterstitalAd.this.exportCallBack.OooO0o0(UMNInterstitalAd.this.manager.OooO00o(), oo00oVar);
                        ooooO000.OooO0OO(UMNInterstitalAd.TAG, "插屏广告 onAdClick");
                    }

                    @Override // com.ubixnow.ooooo.OooOo
                    public void onAdDismiss(oo00o oo00oVar) {
                        UMNInterstitalAd.this.exportCallBack.OooO0o(UMNInterstitalAd.this.manager.OooO00o(), oo00oVar);
                        ooooO000.OooO0OO(UMNInterstitalAd.TAG, "插屏广告 onAdDismiss");
                    }

                    @Override // com.ubixnow.ooooo.OooOo
                    public void onAdShow(final oo00o oo00oVar) {
                        UMNInterstitalAd.this.manager.OooO00o(false);
                        UMNInterstitalAd.this.exportCallBack.OooO0oO(UMNInterstitalAd.this.manager.OooO00o(), oo00oVar);
                        BaseUtils.postDelayed(new Runnable() { // from class: com.ubixnow.adtype.interstital.api.UMNInterstitalAd.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                o0oO0O0o.OooO00o(activity, oo00oVar);
                            }
                        }, 500L);
                        ooooO000.OooO0OO(UMNInterstitalAd.TAG, "插屏广告 onAdShow");
                    }

                    @Override // com.ubixnow.ooooo.OooOo
                    public void onShowError(ErrorInfo errorInfo) {
                        UMNInterstitalAd.this.exportCallBack.OooO0O0(UMNInterstitalAd.this.manager.OooO00o(), errorInfo);
                        ooooO000.OooO0OO(UMNInterstitalAd.TAG, "插屏广告 onShowError");
                    }
                });
            } else {
                ooooO000.OooO0O0("广告暂未加载成功");
                oOO00O0.OooO00o oooO00o = oOO00O0.OooO00o.SHOW_ERROR;
                ErrorInfo errorInfo = new ErrorInfo(oooO00o.OooO00o(), oooO00o.OooO0O0());
                errorInfo.object = this.manager.OooO00o().OooOO0;
                this.exportCallBack.OooO0O0(this.manager.OooO00o(), errorInfo);
            }
        } catch (Exception e) {
            ooooO000.OooO0O0("插屏广告展示异常：" + e.getMessage());
        }
    }
}
