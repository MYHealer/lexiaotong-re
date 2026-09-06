package com.bytedance.msdk.adapter.gdt;

import android.app.Activity;
import android.content.Context;
import com.X2bigomM7HG.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.b;
import com.X2bigomM7HG.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.g;
import com.bytedance.msdk.adapter.gdt.base.MediationAdLoaderBaseFunction;
import com.bytedance.msdk.adapter.gdt.base.config.MediationAdSlotValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.f;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class GdtBannerLoader extends MediationAdLoaderBaseFunction {
    @Override // com.bytedance.msdk.adapter.gdt.base.MediationAdLoaderBaseFunction
    public void realLoader(final Context context, final MediationAdSlotValueSet mediationAdSlotValueSet) {
        if (context instanceof Activity) {
            g.a(context, mediationAdSlotValueSet, this.mGmAdLoader, new b(), new g.a() { // from class: com.bytedance.msdk.adapter.gdt.GdtBannerLoader.1
                @Override // com.X2bigomM7HG.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.g.a
                public void useOriginLoader() {
                    new f(GdtBannerLoader.this).a(context, mediationAdSlotValueSet);
                }
            });
        } else {
            notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_CONTEXT, "context type error, context need activity");
        }
    }
}
