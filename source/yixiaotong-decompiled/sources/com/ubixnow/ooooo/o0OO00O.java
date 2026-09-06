package com.ubixnow.ooooo;

import android.text.TextUtils;
import com.ubixnow.adtype.nativead.api.UMNNativeAd;
import com.ubixnow.adtype.nativead.api.UMNNativeAdBean;
import com.ubixnow.adtype.nativead.api.UMNNativeListener;
import com.ubixnow.adtype.nativead.api.UMNNativeMaterial;
import com.ubixnow.core.api.UMNError;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.utils.BaseUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o0OO00O extends o00O0O0 {
    public UMNNativeListener OooOOO0;

    public class OooO00o implements Runnable {
        public final /* synthetic */ o00O0 OooO00o;
        public final /* synthetic */ oo00o OooO0O0;

        public OooO00o(o00O0 o00o0, oo00o oo00oVar) {
            this.OooO00o = o00o0;
            this.OooO0O0 = oo00oVar;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x00dd  */
        /* JADX WARN: Code duplicated, block: B:17:0x0225  */
        /* JADX WARN: Code duplicated, block: B:19:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:20:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        public void run() {
            o0OO00O o0oo00o;
            o00O0 o00o0;
            ErrorInfo errorInfo;
            UMNNativeMaterial.DownloadAppinfo downloadAppinfo;
            o0OO00O.this.OooOO0O.add(1);
            o0OO00O.this.OooO0Oo(this.OooO00o, this.OooO0O0);
            oo000o oo000oVar = (oo000o) this.OooO0O0;
            UMNNativeAdBean uMNNativeAdBean = new UMNNativeAdBean(this.OooO00o, oo000oVar);
            uMNNativeAdBean.setEcpmInfo(this.OooO00o.OooOOo);
            uMNNativeAdBean.extraMap = o0OO00O.this.OooO00o(oo000oVar.getBaseAdConfig().OooO00o.OooO0o0, oO00000o.o0O0O00.OooO00o(oo000oVar.getBaseAdConfig().OooO00o.OooO0OO));
            uMNNativeAdBean.setExtraInfo(o0OO00O.this.OooO00o(this.OooO0O0.material));
            if (!o0OO00O.this.OooO00o(this.OooO00o)) {
                if (oO00000o.o00O0O.OooO00o != 0) {
                    o0oo00o = o0OO00O.this;
                    o00o0 = this.OooO00o;
                    errorInfo = new ErrorInfo(o0OO000o.o0000o0o, o0OO000o.o0000o);
                } else {
                    if (ooooO000.OooO00o) {
                        ooooO000.OooO0O0(UMNNativeAd.TAG, "回调开发者：onAdLoadSuccess： " + this.OooO0O0.getBaseAdConfig().OooO00o.OooO + " SlotId:" + this.OooO0O0.getBaseAdConfig().OooO00o.OooO0o0 + " PlatformId:" + this.OooO0O0.getBaseAdConfig().OooO00o.OooO0OO);
                    }
                    o0OO00O.this.OooO00o(this.OooO00o.OooOOo0, this.OooO0O0);
                    o0OO00O.this.OooOOO0.onLoaded(uMNNativeAdBean);
                }
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0Oo("------NativeExportCallBack_返回的内容:\ngetNativeAdInteractionType:" + uMNNativeAdBean.getMaterial().getNativeAdInteractionType() + "\n getAdType:" + uMNNativeAdBean.getMaterial().getAdType() + "\n getMainImageUrl:" + uMNNativeAdBean.getMaterial().getMainImageUrl() + "\n getAdFrom:" + uMNNativeAdBean.getMaterial().getAdFrom() + "\n getTitle:" + uMNNativeAdBean.getMaterial().getTitle() + "\n getAdSource:" + uMNNativeAdBean.getMaterial().getAdSource() + "\n getDescriptionText:" + uMNNativeAdBean.getMaterial().getDescriptionText() + "\n getIconImageUrl:" + uMNNativeAdBean.getMaterial().getIconImageUrl() + "\n getVideoUrl:" + uMNNativeAdBean.getMaterial().getVideoUrl() + "\nMainImageUrl:" + uMNNativeAdBean.getMaterial().getMainImageUrl() + "\nMainImageWidth:" + uMNNativeAdBean.getMaterial().getMainImageWidth() + "\nMainImageHeight:" + uMNNativeAdBean.getMaterial().getMainImageHeight() + "\nvideoWidth:" + uMNNativeAdBean.getMaterial().getVideoWidth() + "\nvideoHeight:" + uMNNativeAdBean.getMaterial().getVideoHeight() + "\ncta text:" + uMNNativeAdBean.getMaterial().getActionDescription() + "\n getImageUrlList:" + uMNNativeAdBean.getMaterial().getImageUrlList().toString() + "\n getVideoDuration:" + uMNNativeAdBean.getMaterial().getVideoDuration());
                    downloadAppinfo = uMNNativeAdBean.getMaterial().getDownloadAppinfo();
                    if (downloadAppinfo != null) {
                        ooooO000.OooO0Oo("------NativeExportCallBack_六要素:\n APP开发者_getAppPublisher:" + downloadAppinfo.getAppPublisher() + "\n APP名称_getAppName:" + downloadAppinfo.getAppName() + "\n APP版本号_getAppVersionName:" + downloadAppinfo.getAppVersionName() + "\n APP权限协议_getPermissionUrl:" + downloadAppinfo.getPermissionUrl() + "\n APP隐私协议_getPrivacyAgreementUrl:" + downloadAppinfo.getPrivacyAgreementUrl() + "\n APP功能介绍_getFunctionUrl:" + downloadAppinfo.getFunctionUrl() + "\nAPP大小_getAppSize:" + downloadAppinfo.getAppSize());
                    }
                }
            }
            o0oo00o = o0OO00O.this;
            o00o0 = this.OooO00o;
            errorInfo = new ErrorInfo(o0OO000o.o0000o0, o0OO000o.o0000o0O);
            o0oo00o.OooO00o(o00o0, errorInfo);
            if (ooooO000.OooO00o) {
                ooooO000.OooO0Oo("------NativeExportCallBack_返回的内容:\ngetNativeAdInteractionType:" + uMNNativeAdBean.getMaterial().getNativeAdInteractionType() + "\n getAdType:" + uMNNativeAdBean.getMaterial().getAdType() + "\n getMainImageUrl:" + uMNNativeAdBean.getMaterial().getMainImageUrl() + "\n getAdFrom:" + uMNNativeAdBean.getMaterial().getAdFrom() + "\n getTitle:" + uMNNativeAdBean.getMaterial().getTitle() + "\n getAdSource:" + uMNNativeAdBean.getMaterial().getAdSource() + "\n getDescriptionText:" + uMNNativeAdBean.getMaterial().getDescriptionText() + "\n getIconImageUrl:" + uMNNativeAdBean.getMaterial().getIconImageUrl() + "\n getVideoUrl:" + uMNNativeAdBean.getMaterial().getVideoUrl() + "\nMainImageUrl:" + uMNNativeAdBean.getMaterial().getMainImageUrl() + "\nMainImageWidth:" + uMNNativeAdBean.getMaterial().getMainImageWidth() + "\nMainImageHeight:" + uMNNativeAdBean.getMaterial().getMainImageHeight() + "\nvideoWidth:" + uMNNativeAdBean.getMaterial().getVideoWidth() + "\nvideoHeight:" + uMNNativeAdBean.getMaterial().getVideoHeight() + "\ncta text:" + uMNNativeAdBean.getMaterial().getActionDescription() + "\n getImageUrlList:" + uMNNativeAdBean.getMaterial().getImageUrlList().toString() + "\n getVideoDuration:" + uMNNativeAdBean.getMaterial().getVideoDuration());
                downloadAppinfo = uMNNativeAdBean.getMaterial().getDownloadAppinfo();
                if (downloadAppinfo != null) {
                    ooooO000.OooO0Oo("------NativeExportCallBack_六要素:\n APP开发者_getAppPublisher:" + downloadAppinfo.getAppPublisher() + "\n APP名称_getAppName:" + downloadAppinfo.getAppName() + "\n APP版本号_getAppVersionName:" + downloadAppinfo.getAppVersionName() + "\n APP权限协议_getPermissionUrl:" + downloadAppinfo.getPermissionUrl() + "\n APP隐私协议_getPrivacyAgreementUrl:" + downloadAppinfo.getPrivacyAgreementUrl() + "\n APP功能介绍_getFunctionUrl:" + downloadAppinfo.getFunctionUrl() + "\nAPP大小_getAppSize:" + downloadAppinfo.getAppSize());
                }
            }
        }
    }

    public class OooO0O0 implements Runnable {
        public final /* synthetic */ o00O0 OooO00o;
        public final /* synthetic */ ErrorInfo OooO0O0;

        public OooO0O0(o00O0 o00o0, ErrorInfo errorInfo) {
            this.OooO00o = o00o0;
            this.OooO0O0 = errorInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            o0OO00O.this.OooOO0O.add(5);
            o0OO00O.this.OooO00o(this.OooO00o.OooOOo0, this.OooO0O0);
            ErrorInfo errorInfo = this.OooO0O0;
            UMNError uMNError = new UMNError(errorInfo.code, errorInfo.msg);
            if (!TextUtils.isEmpty(this.OooO0O0.platFormCode)) {
                uMNError.platFormCode = this.OooO0O0.platFormCode;
            }
            if (!TextUtils.isEmpty(this.OooO0O0.platFormMsg)) {
                uMNError.platFormMsg = this.OooO0O0.platFormMsg;
            }
            o0OO00O.this.OooOOO0.onError(uMNError);
        }
    }

    @Override // com.ubixnow.ooooo.o00O0O0
    public void OooO00o(o00O0 o00o0, ErrorInfo errorInfo) {
        if (OooO00o(5) || this.OooOOO0 == null) {
            return;
        }
        ooooO000.OooO0O0(UMNNativeAd.TAG, "回调开发者：onError：" + errorInfo.toString());
        BaseUtils.runInMainThread(new OooO0O0(o00o0, errorInfo));
    }

    @Override // com.ubixnow.ooooo.o00O0O0
    public void OooO0O0(o00O0 o00o0, oo00o oo00oVar) {
        try {
            if (OooO00o(1) || this.OooOOO0 == null) {
                return;
            }
            BaseUtils.runInMainThread(new OooO00o(o00o0, oo00oVar));
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }
}
