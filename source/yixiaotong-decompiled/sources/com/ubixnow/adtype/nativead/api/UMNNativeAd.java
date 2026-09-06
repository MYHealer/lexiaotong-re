package com.ubixnow.adtype.nativead.api;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import com.ubixnow.adtype.nativead.custom.UMNCustomNativeAdapter;
import com.ubixnow.core.api.UMNError;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00O00OO;
import com.ubixnow.ooooo.o0O0O00;
import com.ubixnow.ooooo.o0OO000;
import com.ubixnow.ooooo.o0OO000o;
import com.ubixnow.ooooo.o0OO00O;
import com.ubixnow.ooooo.o0ooOOo;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.oo00o;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UMNNativeAd extends o00O00OO {
    public static final String TAG = "----ubixnative_in";
    private o0OO00O exportCallBack = new o0OO00O();
    private o0ooOOo manager;
    private UMNNativeParams nativeParams;

    public UMNNativeAd(Context context, UMNNativeParams uMNNativeParams, UMNNativeListener uMNNativeListener) {
        ooooO000.OooO0OO(TAG, "pub_height:" + uMNNativeParams.height + "pub_width:" + uMNNativeParams.width + " slotId: " + uMNNativeParams.slotId);
        this.exportCallBack.OooOOO0 = uMNNativeListener;
        this.nativeParams = uMNNativeParams;
        this.devConfig = uMNNativeParams;
        if (context != null && BaseUtils.getContext() == null) {
            BaseUtils.init(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        }
        if (context == null || !(context instanceof Activity)) {
            o0ooOOo o0ooooo = new o0ooOOo(BaseUtils.getContext(), uMNNativeParams);
            this.manager = o0ooooo;
        } else {
            this.manager = new o0ooOOo(context, uMNNativeParams);
        }
        this.ad = this.manager.OooO00o(getEcpmInfo());
        this.baseAdManager = this.manager;
    }

    public void destroy() {
        ooooO000.OooO0OO(TAG, "NativeAd 开发者调用destroy方法");
        o0ooOOo o0ooooo = this.manager;
        if (o0ooooo != null) {
            o0ooooo.OooO0OO();
        }
    }

    public boolean isValid() {
        ooooO000.OooO0OO(TAG, "NativeAd 开发者调用isValid方法");
        o0ooOOo o0ooooo = this.manager;
        if (o0ooooo != null) {
            return o0ooooo.OooO0oO();
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
        ooooO000.OooO0Oo("开始请求信息流广告 slot_id:" + this.nativeParams.slotId);
        o0O0O00 o0o0o00 = new o0O0O00() { // from class: com.ubixnow.adtype.nativead.api.UMNNativeAd.1
            @Override // com.ubixnow.ooooo.o00O00o0
            public void onAdCacheSuccess(oo00o oo00oVar) {
                oo00oVar.renderType = UMNNativeAd.this.nativeParams.adStyle;
                ooooO000.OooO0Oo("NativeAd onAdCacheSuccess");
                UMNNativeAd.this.exportCallBack.OooO0O0(UMNNativeAd.this.manager.OooO00o(), oo00oVar);
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onAdDataLoaded(oo00o oo00oVar) {
                ooooO000.OooO0OO(UMNNativeAd.TAG, "NativeAd onAdDataLoaded:");
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onAdRenderFail(ErrorInfo errorInfo) {
                ooooO000.OooO0O0(UMNNativeAd.TAG, "NativeAd onAdRenderFail");
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onNoAdError(ErrorInfo errorInfo) {
                if (errorInfo != null) {
                    ooooO000.OooO0Oo("NativeAd onNoAdError code:" + errorInfo.code + " msg:" + errorInfo.msg);
                }
                UMNNativeAd.this.exportCallBack.OooO00o(UMNNativeAd.this.manager.OooO00o(), errorInfo);
            }

            @Override // com.ubixnow.ooooo.o00O00o0
            public void onTimeout() {
                ooooO000.OooO0O0(UMNNativeAd.TAG, "总超时时间到 达到检测条件");
                UMNNativeAd.this.manager.OooO0o0();
                oo00o oo00oVarOooO00o = UMNNativeAd.this.manager.OooO00o(new ErrorInfo(o0OO000o.o0000OOo, oOO00O0.ubix_request_timeout_msg));
                if (oo00oVarOooO00o == null) {
                    UMNNativeAd.this.exportCallBack.OooO00o(UMNNativeAd.this.manager.OooO00o(), new ErrorInfo(o0OO000o.o0000OOo, oOO00O0.ubix_request_timeout_msg));
                    return;
                }
                try {
                    ((UMNCustomNativeAdapter) oo00oVarOooO00o.getAbsBaseAdapter()).nativeInfo.renderType = UMNNativeAd.this.nativeParams.adStyle;
                    UMNNativeAd.this.exportCallBack.OooO0O0(UMNNativeAd.this.manager.OooO00o(), ((UMNCustomNativeAdapter) oo00oVarOooO00o.getAbsBaseAdapter()).nativeInfo);
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                    UMNNativeAd.this.exportCallBack.OooO00o(UMNNativeAd.this.manager.OooO00o(), new ErrorInfo(o0OO000o.o0000Oo, oOO00O0.ubix_return_error_msg));
                }
            }
        };
        if (strArrIsCanLoadAd != null) {
            o0o0o00.onNoAdError(new ErrorInfo(strArrIsCanLoadAd[0], strArrIsCanLoadAd[1]));
            return;
        }
        UMNNativeParams uMNNativeParams = this.nativeParams;
        int i = uMNNativeParams.adStyle;
        if (i == 2 || i == 1) {
            this.manager.OooO00o(o0o0o00, uMNNativeParams);
            return;
        }
        HashMap map = new HashMap();
        map.put(o0OO000o.o000o0oo, o0OO000o.OooOoO0);
        map.put(o0OO000o.o000o00, this.manager.OooO0o0.OooO0oO);
        map.put(o0OO000o.o000OooO, this.manager.OooO0o0.OooO00o);
        if (!TextUtils.isEmpty(this.manager.OooO0o0.OooOo0)) {
            map.put(o0OO000o.o0oOO, this.manager.OooO0o0.OooOo0 + "");
        }
        if (!TextUtils.isEmpty(this.manager.OooO0o0.OooOo0O)) {
            map.put(o0OO000o.o00Oo, this.manager.OooO0o0.OooOo0O + "");
        }
        map.put("ad_type", this.manager.OooO0o0.OooO0O0);
        String str = "渲染方式不存在,设置的渲染方式为：" + this.nativeParams.adStyle;
        map.put(o0OO000o.o000oo0o, str);
        o0OO000.OooO00o(o0OO000o.OooOOO, map, new Object[0]);
        o0o0o00.onNoAdError(new ErrorInfo(o0OO000o.OooOoO0, str));
    }
}
