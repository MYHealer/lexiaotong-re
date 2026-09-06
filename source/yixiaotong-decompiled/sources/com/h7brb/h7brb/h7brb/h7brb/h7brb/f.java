package com.h7brb.h7brb.h7brb.h7brb.h7brb;

import com.bytedance.msdk.adapter.ks.base.config.MediationAdSlotValueSet;
import com.bytedance.msdk.adapter.ks.base.utils.MediationApiLog;
import com.kwad.sdk.api.KsScene;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class f {
    public static void a(KsScene.Builder builder, MediationAdSlotValueSet mediationAdSlotValueSet, String str) {
        Object obj;
        if (builder == null || mediationAdSlotValueSet == null) {
            return;
        }
        try {
            Map<String, Object> extraObject = mediationAdSlotValueSet.getExtraObject();
            if (extraObject == null || (obj = extraObject.get("gm_query_info")) == null) {
                return;
            }
            String strValueOf = String.valueOf(obj);
            if (!p.a("5.3.20.1")) {
                MediationApiLog.i("setQueryInfo skipped, KS SDK version < 5.3.20.1, adType: " + str);
            } else {
                builder.setQueryInfo(strValueOf);
                MediationApiLog.i("setQueryInfo success, queryInfo: " + strValueOf + ", adType: " + str);
            }
        } catch (Throwable th) {
            MediationApiLog.e("setQueryInfo error, adType: " + str + ", error: " + th.getMessage());
        }
    }
}
