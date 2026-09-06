package com.bytedance.msdk.adapter.ks;

import android.content.Context;
import com.bytedance.msdk.adapter.ks.base.MediationAdLoaderBaseFunction;
import com.bytedance.msdk.adapter.ks.base.config.MediationAdSlotValueSet;
import com.h7brb.h7brb.h7brb.h7brb.h7brb.i;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class KsFullVideoLoader extends MediationAdLoaderBaseFunction {
    @Override // com.bytedance.msdk.adapter.ks.base.MediationAdLoaderBaseFunction
    public void realLoader(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        if (context != null) {
            new i(this).a(context, mediationAdSlotValueSet);
        }
    }
}
