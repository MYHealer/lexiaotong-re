package com.ubixnow.adtype.reward.api;

import android.app.Activity;
import android.content.Context;
import com.stub.StubApp;
import com.ubixnow.adtype.reward.custom.UMNCustomRewardAdapter;
import com.ubixnow.core.api.UMNError;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00000;
import com.ubixnow.ooooo.o00000O;
import com.ubixnow.ooooo.o00000O0;
import com.ubixnow.ooooo.o00O00OO;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o0OO000o;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.oo00o;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UMNRewardAd extends o00O00OO {
    public static final String TAG = "----ubixreward_dev";
    private UMNRewardParams adParams;
    private final o00000O0 exportCallBack;
    private WeakReference<Context> mActivityWeakRef;
    private o00000O manager;

    public UMNRewardAd(Context context, UMNRewardParams uMNRewardParams, UMNRewardListener uMNRewardListener) {
        o00000O0 o00000o0 = new o00000O0();
        this.exportCallBack = o00000o0;
        if (context != null) {
            this.mActivityWeakRef = new WeakReference<>(context);
            if (BaseUtils.getContext() == null) {
                BaseUtils.init(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            }
        }
        this.adParams = uMNRewardParams;
        this.devConfig = uMNRewardParams;
        o00000o0.OooOOO0 = uMNRewardListener;
        WeakReference<Context> weakReference = this.mActivityWeakRef;
        if (weakReference != null) {
            this.manager = new o00000O(weakReference.get(), uMNRewardParams);
        } else {
            this.manager = new o00000O(context, uMNRewardParams);
        }
        this.ad = this.manager.OooO00o(getEcpmInfo());
        this.baseAdManager = this.manager;
    }

    public void destroy() {
        ooooO000.OooO0OO(TAG, "开发者调用destroy方法");
        o00000O o00000o = this.manager;
        if (o00000o != null) {
            o00000o.OooO0o();
        }
    }

    public boolean isValid() {
        ooooO000.OooO0OO(TAG, "开发者调用isValid方法");
        o00000O o00000o = this.manager;
        if (o00000o != null) {
            return o00000o.OooO0oO();
        }
        return false;
    }

    public void loadAd() {
        if (BaseUtils.getContext() == null) {
            ooooO000.OooO0O0("加载广告前请,请先确认context 状态");
            this.exportCallBack.OooOOO0.onError(new UMNError(o0OO000o.OooOOOO, o0OO000o.OooOOOo));
            return;
        }
        ooooO000.OooO0Oo("开始请求激励视频广告 slot_id:" + this.adParams.slotId);
        String[] strArrIsCanLoadAd = isCanLoadAd(this.manager.OooO0o0);
        o00O00o0 o00o00o0 = new o00O00o0() { // from class: com.ubixnow.adtype.reward.api.UMNRewardAd.1
            @Override // com.ubixnow.ooooo.o00O00o0
            public void onAdCacheSuccess(oo00o oo00oVar) {
                ooooO000.OooO0Oo("onAdCacheSuccess");
                UMNRewardAd.this.exportCallBack.OooO0O0(UMNRewardAd.this.manager.OooO00o(), oo00oVar);
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onAdDataLoaded(oo00o oo00oVar) {
                ooooO000.OooO0OO(UMNRewardAd.TAG, "onAdLoaded");
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onAdRenderFail(ErrorInfo errorInfo) {
                ooooO000.OooO0OO(UMNRewardAd.TAG, "onAdRenderFail");
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onNoAdError(ErrorInfo errorInfo) {
                if (errorInfo != null) {
                    ooooO000.OooO0Oo("onNoAdError code:" + errorInfo.code + " msg:" + errorInfo.msg);
                }
                UMNRewardAd.this.exportCallBack.OooO00o(UMNRewardAd.this.manager.OooO00o(), errorInfo);
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onTimeout() {
                ooooO000.OooO0O0(UMNRewardAd.TAG, "总超时时间到 达到检测条件");
                UMNRewardAd.this.manager.OooO0o0();
                oo00o oo00oVarOooO00o = UMNRewardAd.this.manager.OooO00o(new ErrorInfo(o0OO000o.o0000OOo, oOO00O0.ubix_request_timeout_msg));
                if (oo00oVarOooO00o == null) {
                    UMNRewardAd.this.exportCallBack.OooO00o(UMNRewardAd.this.manager.OooO00o(), new ErrorInfo(o0OO000o.o0000OOo, oOO00O0.ubix_request_timeout_msg));
                    return;
                }
                try {
                    UMNRewardAd.this.exportCallBack.OooO0O0(UMNRewardAd.this.manager.OooO00o(), ((UMNCustomRewardAdapter) oo00oVarOooO00o.getAbsBaseAdapter()).absUbixInfo);
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                    UMNRewardAd.this.exportCallBack.OooO00o(UMNRewardAd.this.manager.OooO00o(), new ErrorInfo(o0OO000o.o0000Oo, oOO00O0.ubix_return_error_msg));
                }
            }
        };
        if (strArrIsCanLoadAd != null) {
            o00o00o0.onNoAdError(new ErrorInfo(strArrIsCanLoadAd[0], strArrIsCanLoadAd[1]));
        } else {
            this.manager.OooO00o(o00o00o0);
        }
    }

    public void show(Activity activity) {
        try {
            ooooO000.OooO0Oo("RewardAd 调用show方法");
            o00000O0 o00000o0 = this.exportCallBack;
            o00000O o00000o = this.manager;
            o00000o0.OooO0O0(o00000o.OooO0o0, o00000o.OooO00o().OooOO0);
            if (this.exportCallBack.OooO00o(1)) {
                boolean z = (activity == null || activity.isFinishing() || !isValid()) ? false : true;
                o00000O0 o00000o1 = this.exportCallBack;
                o00000O o00000o2 = this.manager;
                o00000o1.OooO00o(o00000o2.OooO0o0, o00000o2.OooO00o().OooOO0, z);
            }
            if (this.exportCallBack.OooO00o(1) && !this.isShow) {
                this.isShow = true;
                this.manager.OooO00o(activity, new o00000() { // from class: com.ubixnow.adtype.reward.api.UMNRewardAd.2
                    @Override // com.ubixnow.ooooo.o00000
                    public void onAdClick(oo00o oo00oVar) {
                        ooooO000.OooO0OO(UMNRewardAd.TAG, "RewardAd onAdClick");
                        UMNRewardAd.this.manager.OooO00o(true);
                        UMNRewardAd.this.exportCallBack.OooO0o0(UMNRewardAd.this.manager.OooO00o(), oo00oVar);
                    }

                    @Override // com.ubixnow.ooooo.o00000
                    public void onAdDismiss(oo00o oo00oVar) {
                        ooooO000.OooO0OO(UMNRewardAd.TAG, "RewardAd onAdDismiss");
                        UMNRewardAd.this.exportCallBack.OooO0o(UMNRewardAd.this.manager.OooO00o(), oo00oVar);
                    }

                    @Override // com.ubixnow.ooooo.o00000
                    public void onAdShow(oo00o oo00oVar) {
                        ooooO000.OooO0OO(UMNRewardAd.TAG, "RewardAd onAdShow");
                        UMNRewardAd.this.manager.OooO00o(false);
                        UMNRewardAd.this.exportCallBack.OooO0oO(UMNRewardAd.this.manager.OooO00o(), oo00oVar);
                    }

                    @Override // com.ubixnow.ooooo.o00000
                    public void onRewardVerify(oo00o oo00oVar) {
                        ooooO000.OooO0OO(UMNRewardAd.TAG, "RewardAd onRewardVerify");
                        UMNRewardAd.this.exportCallBack.OooO0oo(UMNRewardAd.this.manager.OooO00o(), oo00oVar);
                    }

                    @Override // com.ubixnow.ooooo.o00000
                    public void onShowError(ErrorInfo errorInfo) {
                        ooooO000.OooO0OO(UMNRewardAd.TAG, "RewardAd onShowError");
                        UMNRewardAd.this.exportCallBack.OooO0O0(UMNRewardAd.this.manager.OooO00o(), errorInfo);
                    }

                    @Override // com.ubixnow.ooooo.o00000
                    public void onVideoPlayComplete(oo00o oo00oVar) {
                        ooooO000.OooO0OO(UMNRewardAd.TAG, "RewardAd onVideoPlayComplete");
                        UMNRewardAd.this.exportCallBack.OooO(UMNRewardAd.this.manager.OooO00o(), oo00oVar);
                    }

                    @Override // com.ubixnow.ooooo.o00000
                    public void onVideoPlayStart(oo00o oo00oVar) {
                        ooooO000.OooO0OO(UMNRewardAd.TAG, "RewardAd onVideoPlayStart");
                        UMNRewardAd.this.exportCallBack.OooOO0(UMNRewardAd.this.manager.OooO00o(), oo00oVar);
                    }

                    @Override // com.ubixnow.ooooo.o00000
                    public void onVideoSkip(oo00o oo00oVar) {
                        ooooO000.OooO0OO(UMNRewardAd.TAG, "RewardAd onVideoSkip");
                        UMNRewardAd.this.exportCallBack.OooOO0O(UMNRewardAd.this.manager.OooO00o(), oo00oVar);
                    }
                });
                return;
            }
            ooooO000.OooO0O0("广告暂未加载成功");
            oOO00O0.OooO00o oooO00o = oOO00O0.OooO00o.SHOW_ERROR;
            ErrorInfo errorInfo = new ErrorInfo(oooO00o.OooO00o(), oooO00o.OooO0O0());
            errorInfo.object = this.manager.OooO00o().OooOO0;
            this.exportCallBack.OooO0O0(this.manager.OooO00o(), errorInfo);
        } catch (Exception e) {
            ooooO000.OooO0O0(TAG, "RewardAd show异常 " + e.getMessage());
        }
    }
}
