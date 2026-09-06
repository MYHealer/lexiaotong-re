package com.ubixnow.network.kuaishou;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd;
import com.ubixnow.core.bean.UMNNativeExtraInfo;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oo000o;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class KsNativeExpressAd extends UMNCustomNativeAd {
    public final String OooO00o = "----KsNativeExpressAd";
    private WeakReference<Context> OooO0O0;
    private KsFeedAd OooO0OO;
    public boolean OooO0Oo;
    private AdExposureFailedReason OooO0o0;

    public KsNativeExpressAd(Context context, KsFeedAd ksFeedAd, oo000o oo000oVar) {
        this.OooO0Oo = true;
        this.OooO0O0 = new WeakReference<>(context);
        this.OooO0OO = ksFeedAd;
        this.configInfo = oo000oVar;
        if (oo000oVar != null && oo000oVar.getBaseAdConfig() != null && this.configInfo.getBaseAdConfig().OooOOO0 != null) {
            this.OooO0Oo = this.configInfo.getBaseAdConfig().OooOOO0.Oooo0OO;
            showLog("----KsNativeExpressAd", "---mute " + this.OooO0Oo);
            ksFeedAd.setVideoSoundEnable(!this.OooO0Oo);
        }
        oo000oVar.material = KsUtils.getMaterialInfo(ksFeedAd);
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00oOoo
    public void destroy() {
        KsFeedAd ksFeedAd = this.OooO0OO;
        if (ksFeedAd != null) {
            ksFeedAd.setAdInteractionListener(null);
        }
        this.OooO0O0.clear();
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public View getAdMediaView(Object... objArr) {
        try {
            WeakReference<Context> weakReference = this.OooO0O0;
            if (weakReference != null && weakReference.get() != null) {
                return this.OooO0OO.getFeedView(this.OooO0O0.get());
            }
            showLog(this.OooO00o, "---getFeedView");
            return this.OooO0OO.getFeedView(BaseUtils.getContext());
        } catch (Exception e) {
            ooooO000.OooO00o(e);
            return null;
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd
    public String getNativeExpressType() {
        try {
            KsFeedAd ksFeedAd = this.OooO0OO;
            if (ksFeedAd != null && (ksFeedAd.getMaterialType() == 1 || this.OooO0OO.getMaterialType() == 8)) {
                return "1";
            }
            KsFeedAd ksFeedAd2 = this.OooO0OO;
            return (ksFeedAd2 == null || ksFeedAd2.getMaterialType() != 0) ? "2" : "0";
        } catch (Exception e) {
            ooooO000.OooO00o(e);
            return "0";
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public boolean isNativeExpress() {
        return true;
    }

    @Override // com.ubixnow.ooooo.o00oOoo
    public void notifyClick() {
        try {
            KsBiddingUtils.notifyClick(this.configInfo.getBaseAdConfig().OooO00o.OooO0o0, this.OooO0o0, this.OooO0OO);
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00oOoo
    public void notifyLoss(o00OO0OO o00oo0oo) {
        try {
            this.OooO0o0 = KsBiddingUtils.notifyLoss(this.configInfo.getBaseAdConfig().OooO00o.OooO0o0, o00oo0oo, this.OooO0OO);
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00oOoo
    public void notifyShow() {
        try {
            KsBiddingUtils.notifyShow(this.configInfo.getBaseAdConfig().OooO00o.OooO0o0, this.OooO0o0, this.OooO0OO);
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00oOoo
    public void notifyWin(o00OO0OO o00oo0oo) {
        try {
            KsBiddingUtils.notifyWin(o00oo0oo, this.OooO0OO);
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void regist(ViewGroup viewGroup, UMNNativeExtraInfo uMNNativeExtraInfo) {
        this.OooO0OO.setAdInteractionListener(new KsFeedAd.AdInteractionListener() { // from class: com.ubixnow.network.kuaishou.KsNativeExpressAd.1
            @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
            public void onAdClicked() {
                KsNativeExpressAd ksNativeExpressAd = KsNativeExpressAd.this;
                ksNativeExpressAd.showLog(ksNativeExpressAd.OooO00o, "onAdClicked");
                KsNativeExpressAd.this.notifyAdClicked();
            }

            @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
            public void onAdShow() {
                KsNativeExpressAd ksNativeExpressAd = KsNativeExpressAd.this;
                ksNativeExpressAd.showLog(ksNativeExpressAd.OooO00o, "onAdShow");
                KsNativeExpressAd.this.notifyAdExposure();
            }

            @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
            public void onDislikeClicked() {
                KsNativeExpressAd ksNativeExpressAd = KsNativeExpressAd.this;
                ksNativeExpressAd.showLog(ksNativeExpressAd.OooO00o, "onDislikeClicked");
                KsNativeExpressAd.this.notifyAdDislikeClick();
            }

            @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
            public void onDownloadTipsDialogDismiss() {
                KsNativeExpressAd ksNativeExpressAd = KsNativeExpressAd.this;
                ksNativeExpressAd.showLog(ksNativeExpressAd.OooO00o, "onDownloadTipsDialogDismiss");
            }

            @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
            public void onDownloadTipsDialogShow() {
                KsNativeExpressAd ksNativeExpressAd = KsNativeExpressAd.this;
                ksNativeExpressAd.showLog(ksNativeExpressAd.OooO00o, "onDownloadTipsDialogShow");
            }
        });
    }
}
