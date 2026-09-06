package com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad;

import android.util.SparseArray;
import com.byazt.zqa.c;
import com.bytedance.sdk.openadsdk.mediation.ad.MApiIMediationViewBinderReversal;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationViewBinder;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@c(c = {0, 80, 81, 82, 83, 265, 266, 1469, 1470})
public class BridgeUtil {
    public static MediationViewBinder buildViewBinder(Function<SparseArray<Object>, Object> function) {
        if (function == null) {
            return null;
        }
        MApiIMediationViewBinderReversal mApiIMediationViewBinderReversal = new MApiIMediationViewBinderReversal(function);
        return new MediationViewBinder.Builder(mApiIMediationViewBinderReversal.getLayoutId()).callToActionId(mApiIMediationViewBinderReversal.getCallToActionId()).addExtras(mApiIMediationViewBinderReversal.getExtras()).descriptionTextId(mApiIMediationViewBinderReversal.getDecriptionTextId()).groupImage1Id(mApiIMediationViewBinderReversal.getGroupImage1Id()).groupImage1Id(mApiIMediationViewBinderReversal.getGroupImage2Id()).groupImage1Id(mApiIMediationViewBinderReversal.getGroupImage3Id()).iconImageId(mApiIMediationViewBinderReversal.getIconImageId()).mainImageId(mApiIMediationViewBinderReversal.getMainImageId()).mediaViewIdId(mApiIMediationViewBinderReversal.getMediaViewId()).logoLayoutId(mApiIMediationViewBinderReversal.getLogoLayoutId()).shakeViewContainerId(mApiIMediationViewBinderReversal.getShakeViewContainerId()).titleId(mApiIMediationViewBinderReversal.getTitleId()).sourceId(mApiIMediationViewBinderReversal.getSourceId()).build();
    }
}
