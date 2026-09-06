package com.jd.ad.sdk.jad_jw;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;
import com.jd.ad.sdk.jad_xk.jad_fs;
import com.jd.ad.sdk.logger.Logger;

/* JADX INFO: compiled from: OaidHelper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_an {
    public static String jad_an = "";

    /* JADX INFO: renamed from: com.jd.ad.sdk.jad_jw.jad_an$jad_an, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OaidHelper.java */
    public class C0560jad_an implements IIdentifierListener {
        public void OnSupport(boolean z, IdSupplier idSupplier) {
            if (z && idSupplier != null && idSupplier.isSupported()) {
                String oaid = idSupplier.getOAID();
                jad_an.jad_an = oaid;
                if (TextUtils.isEmpty(oaid)) {
                    return;
                }
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
                jad_anVar.jad_an("refo", jad_an.jad_an);
                jad_anVar.jad_an("refot", Long.valueOf(System.currentTimeMillis()));
            }
        }

        public void onSupport(IdSupplier idSupplier) {
            if (idSupplier == null || !idSupplier.isSupported()) {
                return;
            }
            String oaid = idSupplier.getOAID();
            jad_an.jad_an = oaid;
            if (TextUtils.isEmpty(oaid)) {
                return;
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            jad_anVar.jad_an("refo", jad_an.jad_an);
            jad_anVar.jad_an("refot", Long.valueOf(System.currentTimeMillis()));
        }
    }

    public static void jad_an(Context context) {
        Class<?> cls;
        Class<?> cls2;
        Class<?> cls3;
        Throwable th;
        Class<?> cls4;
        if (context == null) {
            return;
        }
        try {
            cls = Class.forName("com.bun.miitmdid.core.MdidSdkHelper");
        } catch (Error e) {
            Logger.d(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("init oaid reflect MdidSdkHelper class exception: ").append(Log.getStackTraceString(e)).toString());
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.UTILS_OADI_REFLECT_MDIDSDKHELPER_ERROR;
            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
            cls = null;
        } catch (Exception e2) {
            Logger.d(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("init oaid reflect exception: ").append(Log.getStackTraceString(e2)).toString());
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.UTILS_OADI_REFLECT_MDIDSDKHELPER_ERROR;
            jad_fs.jad_an("", jad_anVar2.jad_an, jad_anVar2.jad_an(e2.getMessage()));
            cls = null;
        }
        if (cls == null) {
            return;
        }
        try {
            cls2 = Class.forName("com.bun.miitmdid.interfaces.IIdentifierListener");
        } catch (Error e3) {
            Logger.d(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("init oaid reflect IIdentifierListener class error: ").append(Log.getStackTraceString(e3)).toString());
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar3 = com.jd.ad.sdk.jad_wj.jad_an.UTILS_OADI_REFLECT_IIDENTIFIERLISTENER_ERROR;
            jad_fs.jad_an("", jad_anVar3.jad_an, jad_anVar3.jad_an(e3.getMessage()));
            cls2 = null;
        } catch (Exception e4) {
            Logger.d(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("init oaid reflect IIdentifierListener class exception: ").append(Log.getStackTraceString(e4)).toString());
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar4 = com.jd.ad.sdk.jad_wj.jad_an.UTILS_OADI_REFLECT_IIDENTIFIERLISTENER_ERROR;
            jad_fs.jad_an("", jad_anVar4.jad_an, jad_anVar4.jad_an(e4.getMessage()));
            cls2 = null;
        }
        if (cls2 != null) {
            try {
                MdidSdkHelper.InitSdk(context, true, new C0560jad_an());
                return;
            } catch (Error e5) {
                Logger.d(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("init oaid reflect error: ").append(Log.getStackTraceString(e5)).toString());
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar5 = com.jd.ad.sdk.jad_wj.jad_an.UTILS_OADI_REFLECT_ERROR;
                jad_fs.jad_an("", jad_anVar5.jad_an, jad_anVar5.jad_an(e5.getMessage()));
                return;
            } catch (Exception e6) {
                Logger.d(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("init oaid reflect error: ").append(Log.getStackTraceString(e6)).toString());
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar6 = com.jd.ad.sdk.jad_wj.jad_an.UTILS_OADI_REFLECT_ERROR;
                jad_fs.jad_an("", jad_anVar6.jad_an, jad_anVar6.jad_an(e6.getMessage()));
                return;
            }
        }
        try {
            cls4 = Class.forName("com.bun.miitmdid.core.IIdentifierListener");
            try {
                cls3 = Class.forName("com.bun.miitmdid.core.JLibrary");
                try {
                    cls3.getMethod("InitEntry", Context.class).invoke(null, context);
                } catch (Throwable th2) {
                    th = th2;
                    Logger.d(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("init oaid reflect InitEntry method error: ").append(Log.getStackTraceString(th)).toString());
                    com.jd.ad.sdk.jad_wj.jad_an jad_anVar7 = com.jd.ad.sdk.jad_wj.jad_an.UTILS_OADI_REFLECT_INITENTRY_ERROR;
                    jad_fs.jad_an("", jad_anVar7.jad_an, jad_anVar7.jad_an(th.getMessage()));
                }
            } catch (Throwable th3) {
                cls3 = null;
                th = th3;
            }
        } catch (Throwable th4) {
            cls3 = null;
            th = th4;
            cls4 = null;
        }
        if (cls4 == null || cls3 == null) {
            return;
        }
        try {
            MdidSdkHelper.InitSdk(context, true, new jad_bo());
        } catch (Throwable th5) {
            Logger.d(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("init oaid reflect error: ").append(Log.getStackTraceString(th5)).toString());
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar8 = com.jd.ad.sdk.jad_wj.jad_an.UTILS_OADI_REFLECT_ERROR;
            jad_fs.jad_an("", jad_anVar8.jad_an, jad_anVar8.jad_an(th5.getMessage()));
        }
    }

    /* JADX INFO: compiled from: OaidHelper.java */
    public class jad_bo implements com.bun.miitmdid.core.IIdentifierListener {
        public void OnSupport(boolean z, com.bun.miitmdid.supplier.IdSupplier idSupplier) {
            if (z && idSupplier != null && idSupplier.isSupported()) {
                String oaid = idSupplier.getOAID();
                jad_an.jad_an = oaid;
                if (TextUtils.isEmpty(oaid)) {
                    return;
                }
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
                jad_anVar.jad_an("refo", jad_an.jad_an);
                jad_anVar.jad_an("refot", Long.valueOf(System.currentTimeMillis()));
            }
        }

        public void OnSupport(com.bun.miitmdid.supplier.IdSupplier idSupplier) {
            if (idSupplier == null || !idSupplier.isSupported()) {
                return;
            }
            String oaid = idSupplier.getOAID();
            jad_an.jad_an = oaid;
            if (TextUtils.isEmpty(oaid)) {
                return;
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            jad_anVar.jad_an("refo", jad_an.jad_an);
            jad_anVar.jad_an("refot", Long.valueOf(System.currentTimeMillis()));
        }
    }
}
