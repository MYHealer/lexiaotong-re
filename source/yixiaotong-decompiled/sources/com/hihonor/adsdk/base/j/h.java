package com.hihonor.adsdk.base.j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.HnAds;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class h {
    private static final String hnadsa = "JumpUtils";

    public static com.hihonor.adsdk.base.bean.f hnadsa(Class<?> cls) {
        return hnadsa(cls, null);
    }

    public static com.hihonor.adsdk.base.bean.f hnadsa(Class<?> cls, Bundle bundle) {
        return hnadsa(null, cls, bundle);
    }

    public static com.hihonor.adsdk.base.bean.f hnadsa(Context context, Class<?> cls, Bundle bundle) {
        return hnadsa(context, cls, bundle, true);
    }

    public static com.hihonor.adsdk.base.bean.f hnadsa(Context context, Class<?> cls, Bundle bundle, boolean z) {
        if (z) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "startActivity,finishActivity", new Object[0]);
            com.hihonor.adsdk.base.a.hnadsa().hnadsa(cls.getName());
        }
        Context contextHnadsa = hnadsa(context);
        if (contextHnadsa == null) {
            String str = cls.getName() + "start failed,context is null";
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, str, new Object[0]);
            return new com.hihonor.adsdk.base.bean.f(ErrorCode.AD_CODE_START_ACTIVITY_CONTEXT_NULL, str);
        }
        Intent intent = new Intent(contextHnadsa, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (!(contextHnadsa instanceof Activity)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "startActivity, addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);", new Object[0]);
            intent.addFlags(268435456);
        }
        try {
            contextHnadsa.startActivity(intent);
            return new com.hihonor.adsdk.base.bean.f(0, "success");
        } catch (Exception e) {
            String str2 = cls.getName() + "start failed,exception:" + e.getMessage();
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, str2, new Object[0]);
            return new com.hihonor.adsdk.base.bean.f(ErrorCode.AD_CODE_START_ACTIVITY_EXCEPTION, str2);
        }
    }

    private static Context hnadsa(Context context) {
        if (context != null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "startActivity,use context param", new Object[0]);
            return context;
        }
        if (com.hihonor.adsdk.base.a.hnadsa().hnadsb() != null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "startActivity, use getResumeActivity", new Object[0]);
            return com.hihonor.adsdk.base.a.hnadsa().hnadsb();
        }
        if (HnAds.get().getContext() == null) {
            return null;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "startActivity, use getContext", new Object[0]);
        return HnAds.get().getContext();
    }
}
