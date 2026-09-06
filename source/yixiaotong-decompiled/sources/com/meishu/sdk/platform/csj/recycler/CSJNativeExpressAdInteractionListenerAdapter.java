package com.meishu.sdk.platform.csj.recycler;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class CSJNativeExpressAdInteractionListenerAdapter implements TTNativeExpressAd.ExpressAdInteractionListener {
    private static final String TAG = "CSJNativeExpressAdInteractionListenerAdapter";
    private CSJNativeExpressAdDataAdapter adData;
    private TTNativeExpressAd ttNativeExpressAd;

    public CSJNativeExpressAdInteractionListenerAdapter(CSJNativeExpressAdDataAdapter cSJNativeExpressAdDataAdapter, TTNativeExpressAd tTNativeExpressAd) {
        this.ttNativeExpressAd = tTNativeExpressAd;
        this.adData = cSJNativeExpressAdDataAdapter;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i) {
        try {
            if (this.adData.getAdWrapper() != null && !TextUtils.isEmpty(this.adData.getAdWrapper().getSdkAdInfo().getClk())) {
                LogUtil.d(TAG, "send onAdClicked");
                z.a(AdSdk.getContext(), f.a(this.adData.getAdWrapper().getSdkAdInfo().getClk(), this.adData), new i());
            }
            if (this.adData.getRecylcerAdInteractionListener() != null) {
                this.adData.getRecylcerAdInteractionListener().onAdClicked();
            }
            if (this.adData.getAdWrapper() != null) {
                this.adData.getAdWrapper().getSdkAdInfo().getMsLoadedTime();
                this.adData.getAdWrapper().getAdLoader().getPosId();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i) {
        try {
            if (this.adData.getAdWrapper() != null) {
                h0.a(this.adData.getAdWrapper().getSdkAdInfo(), view);
            }
            if (this.adData.getAdListener() == null || this.adData.isHasExposed()) {
                return;
            }
            this.adData.setHasExposed(true);
            this.adData.getAdListener().onAdExposure();
            if (this.adData.getRecylcerAdInteractionListener() != null) {
                this.adData.getRecylcerAdInteractionListener().onAdExposure();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i) {
        try {
            LogUtil.e(TAG, "onRenderFail: " + str + PPSLabelView.Code + i);
            if (this.adData.getAdListener() != null) {
                this.adData.getAdListener().onAdError();
                this.adData.getAdListener().onAdRenderFail(str, i);
            }
            if (this.adData.getRecylcerAdInteractionListener() != null) {
                this.adData.getRecylcerAdInteractionListener().onAdRenderFailed();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f, float f2) {
        try {
            LogUtil.e(TAG, "onRenderSuccess");
            if (this.adData.getAdListener() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.adData);
                this.adData.getAdListener().onAdReady(arrayList);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
