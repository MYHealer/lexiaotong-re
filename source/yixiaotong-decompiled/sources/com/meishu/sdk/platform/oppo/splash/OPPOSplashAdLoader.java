package com.meishu.sdk.platform.oppo.splash;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.heytap.msp.mobad.api.ad.SplashAd;
import com.heytap.msp.mobad.api.listener.ISplashAdListener;
import com.heytap.msp.mobad.api.params.SplashAdParams;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.meishu.sdk.core.ad.splash.SplashAdLoader;
import com.meishu.sdk.core.ad.splash.d;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.loader.a;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class OPPOSplashAdLoader extends BasePlatformLoader<SplashAdLoader, d> {
    private static final String TAG = "OPPOSplashAdLoader";
    private ArrayList<OPPOSplashAd> oppoSplashAdList;

    public class MyISplashAdListener implements ISplashAdListener {
        private OPPOSplashAd oppoSplashAd;
        private SplashAd splashAd;

        public MyISplashAdListener() {
        }

        @Override // com.heytap.msp.mobad.api.listener.IBaseAdListener
        public void onAdClick() {
            if (OPPOSplashAdLoader.this.getSdkAdInfo() != null && !TextUtils.isEmpty(OPPOSplashAdLoader.this.getSdkAdInfo().getClk())) {
                LogUtil.d(OPPOSplashAdLoader.TAG, "send onAdClick");
                a.a(OPPOSplashAdLoader.this.getContext(), f.a(OPPOSplashAdLoader.this.getSdkAdInfo().getClk(), this.oppoSplashAd));
            }
            if (this.oppoSplashAd.getInteractionListener() != null) {
                this.oppoSplashAd.getInteractionListener().onAdClicked();
            }
        }

        @Override // com.heytap.msp.mobad.api.listener.ISplashAdListener
        public void onAdDismissed() {
            if (OPPOSplashAdLoader.this.getLoaderListener() != null) {
                OPPOSplashAdLoader.this.getLoaderListener().onAdClosed();
            }
        }

        @Override // com.heytap.msp.mobad.api.listener.IBaseAdListener
        @Deprecated
        public void onAdFailed(String str) {
            this.splashAd.destroyAd();
        }

        @Override // com.heytap.msp.mobad.api.listener.IBaseAdListener
        public void onAdShow() {
            if (OPPOSplashAdLoader.this.getLoaderListener() != null) {
                OPPOSplashAdLoader.this.getLoaderListener().onAdLoaded(this.oppoSplashAd);
                OPPOSplashAdLoader.this.getLoaderListener().onAdPresent(this.oppoSplashAd);
                OPPOSplashAdLoader.this.getLoaderListener().onAdExposure();
            }
        }

        public void setOPPOSplashAd(OPPOSplashAd oPPOSplashAd) {
            this.oppoSplashAd = oPPOSplashAd;
        }

        public void setSplashAd(SplashAd splashAd) {
            this.splashAd = splashAd;
        }

        @Override // com.heytap.msp.mobad.api.listener.IBaseAdListener
        public void onAdFailed(int i, String str) {
            LogUtil.e(OPPOSplashAdLoader.TAG, str + PPSLabelView.Code + i);
            z.a(OPPOSplashAdLoader.this.getSdkAdInfo().getErr(), Integer.valueOf(i), str);
            if (OPPOSplashAdLoader.this.getLoaderListener() != null) {
                OPPOSplashAdLoader.this.getLoaderListener().onAdError();
            }
        }
    }

    public OPPOSplashAdLoader(SplashAdLoader splashAdLoader, SdkAdInfo sdkAdInfo) {
        super(splashAdLoader, sdkAdInfo);
        this.oppoSplashAdList = new ArrayList<>();
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader, com.meishu.sdk.core.loader.IAdLoader
    public void destroy() {
        super.destroy();
        Iterator<OPPOSplashAd> it = this.oppoSplashAdList.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
        this.oppoSplashAdList.clear();
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        z.a(getContext(), h0.a(getSdkAdInfo().getReq()), new i());
        Object obj = getLocalParams().get(SplashAdLoader.KEY_SKIP_BUTTON);
        if (!((Boolean) getLocalParams().get(SplashAdLoader.KEY_AUTO_SHOW)).booleanValue() && getLoaderListener() != null) {
            getLoaderListener().onAdError();
            return;
        }
        SplashAdParams.Builder builder = new SplashAdParams.Builder();
        if (obj != null && (obj instanceof View)) {
            ((View) obj).setVisibility(4);
        }
        ImageView imageView = new ImageView(getContext());
        imageView.setImageAlpha(0);
        imageView.setImageDrawable(new ColorDrawable(0));
        imageView.setBackground(new ColorDrawable(0));
        SplashAdParams splashAdParamsBuild = builder.setShowPreLoadPage(false).setFetchTimeout(getAdLoader().getFetchDelay()).build();
        OPPOSplashAd oPPOSplashAd = new OPPOSplashAd(this);
        MyISplashAdListener myISplashAdListener = new MyISplashAdListener();
        myISplashAdListener.setOPPOSplashAd(oPPOSplashAd);
        SplashAd splashAd = new SplashAd((Activity) getContext(), this.sdkAdInfo.getPid(), myISplashAdListener, splashAdParamsBuild);
        oPPOSplashAd.setOPPOSplashAd(splashAd);
        myISplashAdListener.setSplashAd(splashAd);
        this.oppoSplashAdList.add(oPPOSplashAd);
    }
}
