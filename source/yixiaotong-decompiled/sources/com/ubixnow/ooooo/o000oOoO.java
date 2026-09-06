package com.ubixnow.ooooo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ubixnow.adtype.interstital.api.UMNInterstitalParams;
import com.ubixnow.adtype.interstital.custom.UMNCustomInterstitalAdapter;
import com.ubixnow.adtype.nativead.api.UMNNativeEventListener;
import com.ubixnow.adtype.nativead.api.UMNNativeParams;
import com.ubixnow.adtype.nativead.api.UMNNativeTemplateAdView;
import com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd;
import com.ubixnow.core.api.UMNImageInfo;
import com.ubixnow.core.bean.UMNNativeExtraInfo;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.utils.BaseUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class o000oOoO extends UMNCustomInterstitalAdapter {
    public UMNInterstitalParams OooO00o;
    public Bitmap OooO0O0;
    public boolean OooO0OO;
    public UMNCustomNativeAd OooO0oO;
    private o0OoOo0 OooO0oo;
    public final List<View> OooO0Oo = new ArrayList();
    public final UMNNativeExtraInfo OooO0o0 = new UMNNativeExtraInfo();
    public final oo000o<o000oOoO> OooO0o = new oo000o<>();
    public final View.OnClickListener OooO = new OooO00o();
    public final UMNNativeEventListener OooOO0 = new OooO0O0();
    public final o0O0O00 OooOO0O = new OooO0OO();

    public class OooO00o implements View.OnClickListener {
        public OooO00o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            o000oOoO.this.destory();
            UMNCustomNativeAd uMNCustomNativeAd = o000oOoO.this.OooO0oO;
            if (uMNCustomNativeAd != null) {
                uMNCustomNativeAd.notifyAdDislikeClick();
            }
        }
    }

    public class OooO0O0 implements UMNNativeEventListener {
        public OooO0O0() {
        }

        @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
        public void onAdClicked() {
            o000oOoO.this.showLog(o00OO0O0.TAG, "onAdClicked");
            if (o000oOoO.this.OooO0oo != null) {
                o000oOoO.this.OooO0oo.OooO00o();
            }
            if (o000oOoO.this.eventListener != null) {
                o000oOoO.this.eventListener.onAdClick(o000oOoO.this.absUbixInfo);
            }
            o000oOoO o000oooo = o000oOoO.this;
            if (o000oooo.OooO00o.closeAfterClick) {
                o000oooo.OooO0OO = true;
                o000oooo.destory();
                o000oOoO.this.showLog(o00OO0O0.TAG, "closeAfterClick");
                if (o000oOoO.this.eventListener != null) {
                    o000oOoO.this.eventListener.onAdDismiss(o000oOoO.this.absUbixInfo);
                }
            }
        }

        @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
        public void onAdClose() {
            o000oOoO o000oooo = o000oOoO.this;
            if (o000oooo.OooO0OO) {
                return;
            }
            o000oooo.destory();
            o000oOoO.this.showLog(o00OO0O0.TAG, "onAdClose");
            if (o000oOoO.this.eventListener != null) {
                o000oOoO.this.eventListener.onAdDismiss(o000oOoO.this.absUbixInfo);
            }
        }

        @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
        public void onAdExposure() {
            o000oOoO.this.showLog(o00OO0O0.TAG, "onAdExposure");
            if (o000oOoO.this.eventListener != null) {
                o000oOoO.this.eventListener.onAdShow(o000oOoO.this.absUbixInfo);
            }
        }
    }

    public class OooO0OO extends o0O0O00 {
        public OooO0OO() {
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdCacheSuccess(oo00o oo00oVar) {
            o000oOoO.this.showLog(o00OO0O0.TAG, "onAdCacheSuccess");
            o000oOoO.this.callAdCacheSuccess(oo00oVar);
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdDataLoaded(oo00o oo00oVar) {
            o000oOoO.this.showLog(o00OO0O0.TAG, "onAdDataLoaded");
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdRenderFail(ErrorInfo errorInfo) {
            o000oOoO.this.showLog(o00OO0O0.TAG, "onAdRenderFail");
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onNoAdError(ErrorInfo errorInfo) {
            o000oOoO.this.showLog(o00OO0O0.TAG, "onAdFailed: " + errorInfo.toString());
            o000oOoO.this.callNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, errorInfo.platFormCode, errorInfo.platFormMsg).setInfo((Object) o000oOoO.this.absUbixInfo));
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onTimeout() {
            o000oOoO.this.showLog(o00OO0O0.TAG, "onTimeout");
        }
    }

    public class OooO0o implements oO0000Oo.OooO0o {
        public final /* synthetic */ boolean OooO00o;
        public final /* synthetic */ oo00o OooO0O0;

        public OooO0o(boolean z, oo00o oo00oVar) {
            this.OooO00o = z;
            this.OooO0O0 = oo00oVar;
        }

        @Override // com.ubixnow.ooooo.oO0000Oo.OooO0o
        public void OooO00o(Bitmap bitmap, byte[] bArr, String str, String str2) {
            o000oOoO o000oooo = o000oOoO.this;
            o000oooo.OooO0O0 = bitmap;
            if (bitmap == null || str2 == null) {
                o000oooo.showLog(o00OO0O0.TAG, " img download error ");
                if (this.OooO00o) {
                    this.OooO0O0.checkMaterialStatus = 11;
                }
            }
            if (this.OooO00o) {
                o000oOoO.this.loadListener.onAdCacheSuccess(this.OooO0O0);
            }
        }
    }

    private void OooO00o(UMNNativeExtraInfo uMNNativeExtraInfo) {
        View closeView;
        if (uMNNativeExtraInfo == null || uMNNativeExtraInfo.getCloseView() == null || (closeView = uMNNativeExtraInfo.getCloseView()) == null) {
            return;
        }
        closeView.setOnClickListener(this.OooO);
    }

    public void callAdCacheSuccess(oo00o oo00oVar) {
        this.OooO0oO = ((oo000o) oo00oVar).OooO00o.get(0);
        if (this.mBaseAdConfig.OooO00o.OooOO0O == 1) {
            showLog(o00OO0O0.TAG, "price:" + oo00oVar.getBiddingEcpm());
            this.absUbixInfo.setBiddingEcpm(oo00oVar.getBiddingEcpm());
        }
        oo00o<UMNCustomInterstitalAdapter> oo00oVar2 = this.absUbixInfo;
        oo00oVar2.material = oo00oVar.material;
        oo00oVar2.materialStatus = oo00oVar.materialStatus;
        int i = oo00oVar.checkMaterialStatus;
        oo00oVar2.checkMaterialStatus = i;
        if (i > 0) {
            this.loadListener.onAdCacheSuccess(oo00oVar);
            return;
        }
        if (isVideo()) {
            loadImg(getVideoCoverUrl(), this.absUbixInfo, false);
            o00O00o0 o00o00o0 = this.loadListener;
            if (o00o00o0 != null) {
                o00o00o0.onAdCacheSuccess(oo00oVar);
            }
        } else {
            loadImg(getMainImageUrl(), this.absUbixInfo);
        }
        UMNCustomNativeAd uMNCustomNativeAd = this.OooO0oO;
        if (uMNCustomNativeAd != null) {
            uMNCustomNativeAd.setNativeEventListener(this.OooOO0);
        }
    }

    public void callNoAdError(ErrorInfo errorInfo) {
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onNoAdError(errorInfo);
        }
    }

    @Override // com.ubixnow.adtype.interstital.custom.UMNCustomInterstitalAdapter
    public void createADInfo(o00O000 o00o000) {
        int iOooO0o;
        int iOooO00o;
        o00OO0O0.TAG = "------" + getClass().getSimpleName();
        super.createADInfo(o00o000);
        this.OooO0o.setAbsBaseAdapter(this);
        this.OooO0o.setBaseAdConfig(o00o000);
        oo000o<o000oOoO> oo000oVar = this.OooO0o;
        oo000oVar.isMuteIndependent = true;
        oo000oVar.isAutoPlayIndependent = true;
        oo000oVar.adType = "10";
        if (oOO00000.OooO0o(BaseUtils.getContext()) * 800 >= oOO00000.OooO0o0(BaseUtils.getContext()) * MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL) {
            iOooO00o = (oOO00000.OooO0o0(BaseUtils.getContext()) * 574) / 800;
            iOooO0o = (iOooO00o * 9) / 16;
        } else {
            iOooO0o = (oOO00000.OooO0o(BaseUtils.getContext()) * MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL) / MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
            iOooO00o = (iOooO0o * 16) / 9;
        }
        if (iOooO0o < 1) {
            iOooO0o = oOO00000.OooO00o(360.0f);
        }
        if (iOooO00o < 1) {
            iOooO00o = oOO00000.OooO00o(800.0f);
        }
        UMNInterstitalParams uMNInterstitalParams = (UMNInterstitalParams) o00o000.OooO0o0;
        this.OooO00o = uMNInterstitalParams;
        uMNInterstitalParams.width = oOO00000.OooO0O0(iOooO0o);
        this.OooO00o.height = oOO00000.OooO0O0(iOooO00o);
    }

    @Override // com.ubixnow.ooooo.o00O
    public void destory() {
        try {
            o0OoOo0 o0oooo0 = this.OooO0oo;
            if (o0oooo0 != null) {
                o0oooo0.dismiss();
            }
            UMNCustomNativeAd uMNCustomNativeAd = this.OooO0oO;
            if (uMNCustomNativeAd != null) {
                uMNCustomNativeAd.destroy();
            }
            Bitmap bitmap = this.OooO0O0;
            if (bitmap != null) {
                bitmap.recycle();
                this.OooO0O0 = null;
            }
        } catch (Exception e) {
            showLog(o00OO0O0.TAG, "  destroy  e " + e.getMessage());
        }
    }

    public ViewGroup getCustomView() {
        UMNCustomNativeAd uMNCustomNativeAd = this.OooO0oO;
        if (uMNCustomNativeAd != null) {
            return uMNCustomNativeAd.getCustomAdContainer();
        }
        return null;
    }

    public abstract String getLogoText();

    public String getMainImageUrl() {
        List<UMNImageInfo> imageUrlList;
        UMNCustomNativeAd uMNCustomNativeAd = this.OooO0oO;
        if (uMNCustomNativeAd == null) {
            return "";
        }
        String mainImageUrl = uMNCustomNativeAd.getMainImageUrl();
        return (!TextUtils.isEmpty(mainImageUrl) || (imageUrlList = this.OooO0oO.getImageUrlList()) == null || imageUrlList.isEmpty()) ? mainImageUrl : imageUrlList.get(0).url;
    }

    public View getMaterialView() {
        UMNCustomNativeAd uMNCustomNativeAd = this.OooO0oO;
        if (uMNCustomNativeAd != null) {
            return uMNCustomNativeAd.getAdMediaView(new Object[0]);
        }
        return null;
    }

    public View getShakeView(FrameLayout frameLayout) {
        UMNCustomNativeAd uMNCustomNativeAd = this.OooO0oO;
        if (uMNCustomNativeAd != null) {
            return uMNCustomNativeAd.getShakeView(frameLayout);
        }
        return null;
    }

    public UMNNativeParams getUMNNativeParams() {
        return new UMNNativeParams.Builder().setSlotId(this.mBaseAdConfig.OooO00o.OooO0o0).setHeight(oOO00000.OooO00o(this.OooO00o.height)).setWidth(oOO00000.OooO00o(this.OooO00o.width)).build();
    }

    public String getVideoCoverUrl() {
        UMNCustomNativeAd uMNCustomNativeAd = this.OooO0oO;
        return uMNCustomNativeAd == null ? "" : uMNCustomNativeAd.getVideoCoverUrl();
    }

    public boolean isCanGetShakeView() {
        return this.absUbixInfo.getBaseAdConfig().OooO00o.OooOOoo != null && this.absUbixInfo.getBaseAdConfig().OooO00o.OooOOoo.OooO0OO;
    }

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        UMNCustomNativeAd uMNCustomNativeAd = this.OooO0oO;
        if (uMNCustomNativeAd != null) {
            return uMNCustomNativeAd.isValid();
        }
        return false;
    }

    public boolean isVideo() {
        UMNCustomNativeAd uMNCustomNativeAd = this.OooO0oO;
        return uMNCustomNativeAd != null && "1".equals(uMNCustomNativeAd.getAdType());
    }

    public void loadImg(String str, oo00o oo00oVar) {
        loadImg(str, oo00oVar, true);
    }

    public void loadImg(String str, oo00o oo00oVar, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                this.loadListener.onAdDataLoaded(oo00oVar);
            }
            oO0000Oo.OooO00o(BaseUtils.getContext()).OooO00o(str, 10, new OooO0o(z, oo00oVar));
        } else if (z) {
            oo00oVar.checkMaterialStatus = 11;
            this.loadListener.onAdCacheSuccess(oo00oVar);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyLoss(o00OO0OO o00oo0oo) {
        try {
            UMNCustomNativeAd uMNCustomNativeAd = this.OooO0oO;
            if (uMNCustomNativeAd != null) {
                uMNCustomNativeAd.notifyLoss(o00oo0oo);
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyWin(o00OO0OO o00oo0oo) {
        try {
            UMNCustomNativeAd uMNCustomNativeAd = this.OooO0oO;
            if (uMNCustomNativeAd != null) {
                uMNCustomNativeAd.notifyWin(o00oo0oo);
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    public void regist(ViewGroup viewGroup) {
        this.OooO0Oo.addAll(this.OooO0oo.OooO0O0);
        this.OooO0o0.setCloseView(this.OooO0oo.OooO0OO);
        this.OooO0o0.setClickViewList(this.OooO0Oo);
        OooO00o(this.OooO0o0);
        UMNCustomNativeAd uMNCustomNativeAd = this.OooO0oO;
        if (uMNCustomNativeAd != null) {
            uMNCustomNativeAd.regist(viewGroup, this.OooO0o0);
        }
    }

    @Override // com.ubixnow.adtype.interstital.custom.UMNCustomInterstitalAdapter
    public void show(Activity activity) {
        if (activity == null) {
            OooOo oooOo = this.eventListener;
            if (oooOo != null) {
                oooOo.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, "展示失败: activity is null").setInfo((Object) this.absUbixInfo));
                return;
            }
            return;
        }
        try {
            UMNNativeTemplateAdView uMNNativeTemplateAdView = new UMNNativeTemplateAdView(activity);
            o0OoOo0 o0oooo0 = new o0OoOo0(activity, getLogoText(), getCustomView(), this.OooO0o, this.absUbixInfo, isCanGetShakeView() ? getShakeView(uMNNativeTemplateAdView) : null, uMNNativeTemplateAdView, this.OooO0O0, getMaterialView(), oOO00000.OooO00o(this.OooO00o.width), oOO00000.OooO00o(this.OooO00o.height));
            this.OooO0oo = o0oooo0;
            o0oooo0.show();
            regist(this.OooO0oo.OooO0Oo);
        } catch (Exception e) {
            OooOo oooOo2 = this.eventListener;
            if (oooOo2 != null) {
                oooOo2.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, "展示失败: " + e.getMessage()).setInfo((Object) this.absUbixInfo));
            }
        }
    }
}
