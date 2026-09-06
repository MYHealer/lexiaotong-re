package com.jd.ad.sdk.jad_fq;

import android.app.Application;
import com.jd.ad.sdk.logger.Logger;
import com.yfanads.android.qapp.Val;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_cp {
    public static Application jad_an;

    public static Application jad_an() {
        Application application = jad_an;
        if (application != null) {
            return application;
        }
        try {
            return (Application) Class.forName(Val.AT).getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
            Logger.w("get application error: ", e.getMessage());
            try {
                return (Application) Class.forName("android.app.AppGlobals").getMethod("getInitialApplication", new Class[0]).invoke(null, new Object[0]);
            } catch (Exception e2) {
                Logger.w("get application error: ", e2.getMessage());
                return null;
            }
        }
    }
}
