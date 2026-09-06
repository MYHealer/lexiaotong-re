package com.jd.ad.sdk.jad_hu;

import android.content.Context;
import com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView;
import com.jd.ad.sdk.bl.dynamicrender.ShakeListener;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.logger.Logger;

/* JADX INFO: compiled from: DynamicRenderView.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_jw extends ShakeListener {
    public final /* synthetic */ DynamicRenderView jad_na;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jad_jw(DynamicRenderView dynamicRenderView, Context context, float f, float f2, float f3) {
        super(context, f, f2, f3);
        this.jad_na = dynamicRenderView;
    }

    @Override // com.jd.ad.sdk.bl.dynamicrender.ShakeListener
    public void onShake() {
        DynamicRenderView dynamicRenderView = this.jad_na;
        boolean zJad_an = DynamicRenderView.jad_an(dynamicRenderView, dynamicRenderView.jad_sf);
        Logger.d("==== 摇一摇: " + zJad_an);
        if (zJad_an) {
            DynamicRenderView dynamicRenderView2 = this.jad_na;
            jad_an jad_anVar = dynamicRenderView2.jad_wj.get(dynamicRenderView2.jad_xk);
            if (jad_anVar != null) {
                DynamicRenderView dynamicRenderView3 = this.jad_na;
                float f = dynamicRenderView3.jad_kv;
                float f2 = dynamicRenderView3.jad_mx;
                float f3 = dynamicRenderView3.jad_ny;
                CommonConstants.AdTriggerSourceType adTriggerSourceType = CommonConstants.AdTriggerSourceType.SHAKE;
                int iOrdinal = adTriggerSourceType.ordinal();
                if (f3 > 0.0f) {
                    if (f > 0.0f && f2 > 0.0f) {
                        iOrdinal = CommonConstants.AdTriggerSourceType.SHAKE_ALL.ordinal();
                    } else if (f > 0.0f) {
                        iOrdinal = CommonConstants.AdTriggerSourceType.SHAKE_ACCELERATION_TIME.ordinal();
                    } else if (f2 > 0.0f) {
                        iOrdinal = CommonConstants.AdTriggerSourceType.SHAKE_ANGLE_TIME.ordinal();
                    }
                } else if (f > 0.0f && f2 > 0.0f) {
                    iOrdinal = CommonConstants.AdTriggerSourceType.SHAKE_ACCELERATION_ANGLE.ordinal();
                } else if (f > 0.0f) {
                    iOrdinal = adTriggerSourceType.ordinal();
                } else if (f2 > 0.0f) {
                    iOrdinal = CommonConstants.AdTriggerSourceType.SHAKE_ANGLE.ordinal();
                }
                jad_anVar.jad_dq = iOrdinal;
                jad_anVar.jad_an(this.jad_na.jad_sf);
            }
        }
    }
}
