package com.umeng.commonsdk.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodInfo;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.byazt.hv.TTDownloadField;
import com.hihonor.adsdk.base.mediation.adn.AdnConfig;
import com.stub.StubApp;
import com.umeng.analytics.pro.am;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.internal.utils.i;
import com.umeng.commonsdk.internal.utils.j;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: UMInternalManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d {
    public static void a(Context context) {
        try {
            ULog.i("walle", "[internal] workEvent send envelope");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(am.aM, a.e);
            JSONObject jSONObjectBuildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, d(context), UMServerURL.PATH_ANALYTICS, "i", a.e);
            if (jSONObjectBuildEnvelopeWithExtHeader == null || jSONObjectBuildEnvelopeWithExtHeader.has("exception")) {
                return;
            }
            ULog.i("walle", "[internal] workEvent send envelope back, result is ok");
        } catch (Exception e) {
            UMCrashManager.reportCrash(context, e);
        }
    }

    public static void b(Context context) {
        ULog.i("walle", "[internal] begin by stateful--->>>");
        if (context != null) {
            j(context);
        }
    }

    public static void c(Context context) {
        ULog.i("walle", "[internal] begin by stateful--->>>");
        if (context == null || !UMEnvelopeBuild.getTransmissionSendFlag()) {
            return;
        }
        j(context);
    }

    private static void j(Context context) {
        try {
            if (UMEnvelopeBuild.isReadyBuild(context, UMLogDataProtocol.UMBusinessType.U_INTERNAL)) {
                UMWorkDispatch.sendEvent(context, a.f, b.a(context).a(), null);
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 冷启动：5秒后触发2号数据仓遗留信封检查动作。");
            UMWorkDispatch.sendEvent(context, a.v, b.a(context).a(), null, 5000L);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    public static JSONObject d(Context context) {
        JSONObject jSONObjectB;
        JSONArray jSONArrayH;
        JSONObject jSONObjectA;
        JSONArray jSONArrayL;
        JSONArray jSONArrayK;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (context != null) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.b.J) && (jSONArrayK = k(origApplicationContext)) != null && jSONArrayK.length() > 0) {
                    jSONObject2.put("rs", jSONArrayK);
                }
            } catch (Exception e) {
                UMCrashManager.reportCrash(origApplicationContext, e);
            }
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.b.ao) && (jSONArrayL = l(origApplicationContext)) != null && jSONArrayL.length() > 0) {
                    jSONObject2.put("by", jSONArrayL);
                }
            } catch (Exception e2) {
                UMCrashManager.reportCrash(origApplicationContext, e2);
            }
            try {
                a(origApplicationContext, jSONObject2);
            } catch (Exception e3) {
                UMCrashManager.reportCrash(origApplicationContext, e3);
            }
            try {
                b(origApplicationContext, jSONObject2);
            } catch (Exception e4) {
                UMCrashManager.reportCrash(origApplicationContext, e4);
            }
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.b.ap) && (jSONObjectA = a()) != null && jSONObjectA.length() > 0) {
                    jSONObject2.put("build", jSONObjectA);
                }
            } catch (Exception e5) {
                UMCrashManager.reportCrash(origApplicationContext, e5);
            }
            try {
                JSONObject jSONObjectE = e(origApplicationContext);
                if (jSONObjectE != null && jSONObjectE.length() > 0) {
                    jSONObject2.put("scr", jSONObjectE);
                }
            } catch (Exception e6) {
                UMCrashManager.reportCrash(origApplicationContext, e6);
            }
            try {
                JSONObject jSONObjectF = f(origApplicationContext);
                if (jSONObjectF != null && jSONObjectF.length() > 0) {
                    jSONObject2.put("sinfo", jSONObjectF);
                }
            } catch (Exception e7) {
                UMCrashManager.reportCrash(origApplicationContext, e7);
            }
            try {
                JSONArray jSONArrayG = g(origApplicationContext);
                if (jSONArrayG != null && jSONArrayG.length() > 0) {
                    jSONObject2.put("input", jSONArrayG);
                }
            } catch (Exception e8) {
                UMCrashManager.reportCrash(origApplicationContext, e8);
            }
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.b.ag) && (jSONArrayH = h(origApplicationContext)) != null && jSONArrayH.length() > 0) {
                    jSONObject2.put("appls", jSONArrayH);
                }
            } catch (Exception e9) {
                UMCrashManager.reportCrash(origApplicationContext, e9);
            }
            try {
                JSONObject jSONObjectI = i(origApplicationContext);
                if (jSONObjectI != null && jSONObjectI.length() > 0) {
                    jSONObject2.put("mem", jSONObjectI);
                }
            } catch (Exception e10) {
                UMCrashManager.reportCrash(origApplicationContext, e10);
            }
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.b.aq) && (jSONObjectB = b()) != null && jSONObjectB.length() > 0) {
                    jSONObject2.put("cpu", jSONObjectB);
                }
            } catch (Exception unused) {
            }
            try {
                jSONObject.put(am.au, jSONObject2);
            } catch (JSONException e11) {
                UMCrashManager.reportCrash(origApplicationContext, e11);
            }
        }
        return jSONObject;
    }

    private static JSONObject b() throws Throwable {
        try {
            com.umeng.commonsdk.internal.utils.c.a aVarA = com.umeng.commonsdk.internal.utils.c.a();
            if (aVarA == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("pro", aVarA.f9235a);
                jSONObject.put("pla", aVarA.b);
                jSONObject.put("cpus", aVarA.c);
                jSONObject.put("fea", aVarA.d);
                jSONObject.put("imp", aVarA.e);
                jSONObject.put("arc", aVarA.f);
                jSONObject.put("var", aVarA.g);
                jSONObject.put("par", aVarA.h);
                jSONObject.put("rev", aVarA.i);
                jSONObject.put("har", aVarA.j);
                jSONObject.put("rev", aVarA.k);
                jSONObject.put("ser", aVarA.l);
                jSONObject.put("cur_cpu", com.umeng.commonsdk.internal.utils.c.d());
                jSONObject.put("max_cpu", com.umeng.commonsdk.internal.utils.c.b());
                jSONObject.put("min_cpu", com.umeng.commonsdk.internal.utils.c.c());
                jSONObject.put("ts", System.currentTimeMillis());
            } catch (Exception unused) {
            }
            return jSONObject;
        } catch (Exception unused2) {
            return null;
        }
    }

    private static JSONArray k(Context context) {
        List<ActivityManager.RunningServiceInfo> runningServices;
        JSONArray jSONArray = null;
        jSONArray = null;
        if (context == null) {
            return null;
        }
        try {
            ActivityManager activityManager = (ActivityManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager == null || (runningServices = activityManager.getRunningServices(Integer.MAX_VALUE)) == null || runningServices.isEmpty()) {
                return null;
            }
            int i = 0;
            while (i < runningServices.size()) {
                if (runningServices.get(i) != null && runningServices.get(i).service != null && runningServices.get(i).service.getClassName() != null && runningServices.get(i).service.getPackageName() != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("sn", runningServices.get(i).service.getClassName().toString());
                        jSONObject.put("pn", runningServices.get(i).service.getPackageName().toString());
                        jSONArray = jSONArray;
                        if (jSONArray == null) {
                            jSONArray = new JSONArray();
                        }
                        jSONArray.put(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                i++;
                jSONArray = jSONArray;
            }
            if (jSONArray == null) {
                return jSONArray;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("ts", System.currentTimeMillis());
                jSONObject2.put("ls", jSONArray);
            } catch (JSONException unused2) {
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("sers", jSONObject2);
            } catch (JSONException unused3) {
            }
            JSONArray jSONArray2 = new JSONArray();
            try {
                jSONArray2.put(jSONObject3);
                return jSONArray2;
            } catch (Throwable th) {
                th = th;
                jSONArray = jSONArray2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        UMCrashManager.reportCrash(context, th);
        return jSONArray;
    }

    private static JSONArray l(Context context) {
        JSONArray jSONArray = new JSONArray();
        String strA = i.a(context);
        if (!TextUtils.isEmpty(strA)) {
            try {
                jSONArray.put(new JSONObject(strA));
            } catch (Exception unused) {
            }
        }
        return jSONArray;
    }

    private static void a(Context context, JSONObject jSONObject) {
        PackageManager packageManager;
        if (context == null || (packageManager = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager()) == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        a(jSONObject, "gp", packageManager.hasSystemFeature("android.hardware.location.gps"));
        a(jSONObject, TypedValues.TransitionType.S_TO, packageManager.hasSystemFeature("android.hardware.touchscreen"));
        a(jSONObject, "mo", packageManager.hasSystemFeature("android.hardware.telephony"));
        a(jSONObject, "ca", packageManager.hasSystemFeature("android.hardware.camera"));
        a(jSONObject, "fl", packageManager.hasSystemFeature("android.hardware.camera.flash"));
    }

    private static void a(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (z) {
                jSONObject.put(str, 1);
            } else {
                jSONObject.put(str, 0);
            }
        } catch (Exception unused) {
        }
    }

    private static void b(Context context, JSONObject jSONObject) {
        if (context != null) {
            String strA = j.a(context);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(strA);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                if (jSONObject2.has(j.d)) {
                    jSONObject.put(j.d, jSONObject2.opt(j.d));
                }
                if (jSONObject2.has(j.c)) {
                    jSONObject.put(j.c, jSONObject2.opt(j.c));
                }
                if (jSONObject2.has(j.b)) {
                    jSONObject.put(j.b, jSONObject2.opt(j.b));
                }
            } catch (Exception unused) {
            }
        }
    }

    public static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("a_pr", Build.PRODUCT);
            jSONObject.put("a_bl", Build.BOOTLOADER);
            jSONObject.put("a_rv", Build.getRadioVersion());
            jSONObject.put("a_fp", Build.FINGERPRINT);
            jSONObject.put("a_hw", Build.HARDWARE);
            jSONObject.put("a_host", Build.HOST);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < Build.SUPPORTED_32_BIT_ABIS.length; i++) {
                jSONArray.put(Build.SUPPORTED_32_BIT_ABIS[i]);
            }
            if (jSONArray.length() > 0) {
                jSONObject.put("a_s32", jSONArray);
            }
            JSONArray jSONArray2 = new JSONArray();
            for (int i2 = 0; i2 < Build.SUPPORTED_64_BIT_ABIS.length; i2++) {
                jSONArray2.put(Build.SUPPORTED_64_BIT_ABIS[i2]);
            }
            if (jSONArray2.length() > 0) {
                jSONObject.put("a_s64", jSONArray2);
            }
            JSONArray jSONArray3 = new JSONArray();
            for (int i3 = 0; i3 < Build.SUPPORTED_ABIS.length; i3++) {
                jSONArray3.put(Build.SUPPORTED_ABIS[i3]);
            }
            if (jSONArray3.length() > 0) {
                jSONObject.put("a_sa", jSONArray3);
            }
            jSONObject.put("a_ta", Build.TAGS);
            jSONObject.put("a_uk", "unknown");
            jSONObject.put("a_user", Build.USER);
            jSONObject.put("a_cpu1", Build.CPU_ABI);
            jSONObject.put("a_cpu2", Build.CPU_ABI2);
            jSONObject.put("a_ra", Build.RADIO);
            jSONObject.put("a_bos", Build.VERSION.BASE_OS);
            jSONObject.put("a_pre", Build.VERSION.PREVIEW_SDK_INT);
            jSONObject.put("a_sp", Build.VERSION.SECURITY_PATCH);
            jSONObject.put("a_cn", Build.VERSION.CODENAME);
            jSONObject.put("a_intl", Build.VERSION.INCREMENTAL);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static JSONObject e(Context context) {
        DisplayMetrics displayMetrics;
        JSONObject jSONObject = new JSONObject();
        if (context != null) {
            try {
                jSONObject.put("a_st_h", com.umeng.commonsdk.internal.utils.a.c(context));
                jSONObject.put("a_nav_h", com.umeng.commonsdk.internal.utils.a.d(context));
                if (context.getResources() != null && (displayMetrics = context.getResources().getDisplayMetrics()) != null) {
                    jSONObject.put("a_den", displayMetrics.density);
                    jSONObject.put("a_dpi", displayMetrics.densityDpi);
                }
            } catch (Exception e) {
                UMCrashManager.reportCrash(context, e);
            }
        }
        return jSONObject;
    }

    public static JSONObject f(Context context) {
        JSONObject jSONObject = new JSONObject();
        if (context != null) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            String packageName = origApplicationContext.getPackageName();
            try {
                jSONObject.put("a_fit", com.umeng.commonsdk.internal.utils.a.a(origApplicationContext, packageName));
                jSONObject.put("a_alut", com.umeng.commonsdk.internal.utils.a.b(origApplicationContext, packageName));
                jSONObject.put("a_c", com.umeng.commonsdk.internal.utils.a.c(origApplicationContext, packageName));
                jSONObject.put("a_uid", com.umeng.commonsdk.internal.utils.a.d(origApplicationContext, packageName));
                if (com.umeng.commonsdk.internal.utils.a.a()) {
                    jSONObject.put("a_root", 1);
                } else {
                    jSONObject.put("a_root", 0);
                }
                jSONObject.put("tf", com.umeng.commonsdk.internal.utils.a.b());
                jSONObject.put("s_fs", com.umeng.commonsdk.internal.utils.a.a(origApplicationContext));
                jSONObject.put("a_meid", DeviceConfig.getMeid(origApplicationContext));
                jSONObject.put("a_imsi", DeviceConfig.getImsi(origApplicationContext));
                jSONObject.put("st", com.umeng.commonsdk.internal.utils.a.c());
                String simICCID = DeviceConfig.getSimICCID(origApplicationContext);
                if (!TextUtils.isEmpty(simICCID)) {
                    try {
                        jSONObject.put("a_iccid", simICCID);
                    } catch (Exception unused) {
                    }
                }
                String secondSimIMEi = DeviceConfig.getSecondSimIMEi(origApplicationContext);
                if (!TextUtils.isEmpty(secondSimIMEi)) {
                    try {
                        jSONObject.put("a_simei", secondSimIMEi);
                    } catch (Exception unused2) {
                    }
                }
                jSONObject.put(AdnConfig.a.hnadsa, com.umeng.commonsdk.internal.utils.a.d());
                jSONObject.put("ts", System.currentTimeMillis());
            } catch (Exception e) {
                UMCrashManager.reportCrash(origApplicationContext, e);
            }
        }
        return jSONObject;
    }

    public static JSONArray g(Context context) {
        Context origApplicationContext;
        List<InputMethodInfo> listF;
        JSONArray jSONArray = new JSONArray();
        if (context != null && (listF = com.umeng.commonsdk.internal.utils.a.f((origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext())))) != null) {
            for (InputMethodInfo inputMethodInfo : listF) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("a_id", inputMethodInfo.getId());
                    jSONObject.put("a_pn", inputMethodInfo.getPackageName());
                    jSONObject.put("ts", System.currentTimeMillis());
                    jSONArray.put(jSONObject);
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(origApplicationContext, th);
                }
            }
        }
        return jSONArray;
    }

    public static JSONArray h(Context context) {
        Context origApplicationContext;
        List<com.umeng.commonsdk.internal.utils.a.C1151a> listG;
        JSONArray jSONArray = new JSONArray();
        if (context != null && (listG = com.umeng.commonsdk.internal.utils.a.g((origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext())))) != null && !listG.isEmpty()) {
            for (com.umeng.commonsdk.internal.utils.a.C1151a c1151a : listG) {
                if (c1151a != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("a_pn", c1151a.f9231a);
                        jSONObject.put("a_la", c1151a.b);
                        jSONObject.put("ts", System.currentTimeMillis());
                        jSONArray.put(jSONObject);
                    } catch (Exception e) {
                        UMCrashManager.reportCrash(origApplicationContext, e);
                    }
                }
            }
        }
        return jSONArray;
    }

    public static JSONObject i(Context context) {
        Context origApplicationContext;
        ActivityManager.MemoryInfo memoryInfoH;
        JSONObject jSONObject = new JSONObject();
        if (context != null && (memoryInfoH = com.umeng.commonsdk.internal.utils.a.h((origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext())))) != null) {
            try {
                jSONObject.put("t", memoryInfoH.totalMem);
                jSONObject.put("f", memoryInfoH.availMem);
                jSONObject.put("ts", System.currentTimeMillis());
            } catch (Exception e) {
                UMCrashManager.reportCrash(origApplicationContext, e);
            }
        }
        return jSONObject;
    }
}
