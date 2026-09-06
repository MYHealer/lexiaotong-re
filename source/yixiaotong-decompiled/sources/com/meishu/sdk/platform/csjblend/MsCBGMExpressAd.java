package com.meishu.sdk.platform.csjblend;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeAd;
import com.meishu.sdk.core.ad.recycler.RecyclerAdData;
import com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MsCBGMExpressAd extends MediationCustomNativeAd {
    private RecyclerAdData adData;
    private boolean calledExposure = false;
    private Context context;
    private RelativeLayout mExpressView;

    public MsCBGMExpressAd(Context context, RecyclerAdData recyclerAdData) {
        this.context = context;
        this.adData = recyclerAdData;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeAd, com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public View getExpressView() {
        return this.mExpressView;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeAd, com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public MediationConstant.AdIsReadyStatus isReadyCondition() {
        RecyclerAdData recyclerAdData = this.adData;
        return (recyclerAdData == null || !recyclerAdData.isAdValid()) ? MediationConstant.AdIsReadyStatus.AD_IS_EXPIRED : MediationConstant.AdIsReadyStatus.AD_IS_READY;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeAd, com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void render() {
        super.render();
        try {
            if (this.adData != null) {
                this.mExpressView = new RelativeLayout(this.context);
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.mExpressView);
                this.adData.bindAdToView(this.context, this.mExpressView, arrayList, new RecylcerAdInteractionListener() { // from class: com.meishu.sdk.platform.csjblend.MsCBGMExpressAd.1
                    @Override // com.meishu.sdk.core.loader.InteractionListener
                    public void onAdClicked() {
                        MsCBGMExpressAd.this.callAdClick();
                    }

                    @Override // com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener, com.meishu.sdk.core.loader.InteractionListener
                    public void onAdClosed() {
                        MsCBGMExpressAd.this.callDislikeSelected(-1, "模板关闭");
                    }

                    @Override // com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener, com.meishu.sdk.core.loader.InteractionListener
                    public void onAdExposure() {
                        if (MsCBGMExpressAd.this.calledExposure) {
                            return;
                        }
                        MsCBGMExpressAd.this.calledExposure = true;
                        MsCBGMExpressAd.this.callAdShow();
                    }

                    @Override // com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener
                    public void onAdRenderFailed() {
                        MsCBGMExpressAd msCBGMExpressAd = MsCBGMExpressAd.this;
                        msCBGMExpressAd.callRenderFail(msCBGMExpressAd.mExpressView, -2, "渲染失败");
                    }
                });
                callRenderSuccess(-1.0f, -2.0f);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
