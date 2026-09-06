package com.umeng.commonsdk;

import android.app.Application;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.stub.StubApp;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.aa;
import com.umeng.analytics.pro.am;
import com.umeng.analytics.pro.aq;
import com.umeng.analytics.pro.l;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMLogCommon;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.b;
import com.umeng.commonsdk.listener.OnGetOaidListener;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.TagHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UMConfigure {
    public static final int DEVICE_TYPE_BOX = 2;
    public static final int DEVICE_TYPE_PHONE = 1;
    private static final String KEY_FILE_NAME_APPKEY = "APPKEY";
    private static final String KEY_FILE_NAME_LOG = "LOG";
    private static final String KEY_METHOD_NAME_PUSH_SETCHANNEL = "setMessageChannel";
    private static final String KEY_METHOD_NAME_PUSH_SET_SECRET = "setSecret";
    private static final String KEY_METHOD_NAME_SETAPPKEY = "setAppkey";
    private static final String KEY_METHOD_NAME_SETCHANNEL = "setChannel";
    private static final String KEY_METHOD_NAME_SETDEBUGMODE = "setDebugMode";
    private static final String TAG = "UMConfigure";
    private static final String WRAPER_TYPE_COCOS2DX_X = "Cocos2d-x";
    private static final String WRAPER_TYPE_COCOS2DX_XLUA = "Cocos2d-x_lua";
    private static final String WRAPER_TYPE_FLUTTER = "flutter";
    private static final String WRAPER_TYPE_HYBRID = "hybrid";
    private static final String WRAPER_TYPE_NATIVE = "native";
    private static final String WRAPER_TYPE_PHONEGAP = "phonegap";
    private static final String WRAPER_TYPE_REACTNATIVE = "react-native";
    private static final String WRAPER_TYPE_UNITY = "Unity";
    private static final String WRAPER_TYPE_WEEX = "weex";
    private static boolean debugLog;
    private static OnGetOaidListener mOnGetOaidListener;
    public static UMLog umDebugLog = new UMLog();
    private static boolean preInitComplete = false;
    private static Object PreInitLock = new Object();
    public static String sAppkey = "";
    public static String sChannel = "";
    public static boolean isInit = false;
    private static Object lock = new Object();
    private static int preInitInvokedFlag = 0;
    private static int policyGrantInvokedFlag = 0;
    private static int policyGrantResult = 0;
    private static boolean shouldCheckShareSdk = true;
    public static MobclickAgent.PageMode AUTO_ACTIVITY_PAGE_COLLECTION = MobclickAgent.PageMode.AUTO;
    private static final String[] BUSINESS_TYPE = {"apm", "push", "share", "ulink", "uverify", "usms", "urec", "abtest", "game", am.al};
    private static boolean isFinish = false;
    private static Object lockObject = new Object();

    public enum BS_TYPE {
        APM,
        PUSH,
        SHARE,
        ULINK,
        UVERIFY,
        USMS,
        UREC,
        ABTEST,
        GAME,
        ZID
    }

    private static void ignoreSdkCheck(Context context) {
        shouldCheckShareSdk = false;
    }

    public static boolean isDebugLog() {
        return debugLog;
    }

    private static Class<?> getClass(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private static Object getDecInstanceObject(Class<?> cls) {
        Constructor<?> declaredConstructor;
        if (cls == null) {
            return null;
        }
        try {
            declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        } catch (NoSuchMethodException unused) {
            declaredConstructor = null;
        }
        if (declaredConstructor == null) {
            return null;
        }
        declaredConstructor.setAccessible(true);
        try {
            return declaredConstructor.newInstance(new Object[0]);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException unused2) {
            return null;
        }
    }

    private static Method getDecMethod(Class<?> cls, String str, Class<?>[] clsArr) {
        Method declaredMethod = null;
        if (cls != null) {
            try {
                declaredMethod = cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
            }
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
            }
        }
        return declaredMethod;
    }

    private static void invoke(Method method, Object obj, Object[] objArr) {
        if (method == null || obj == null) {
            return;
        }
        try {
            method.invoke(obj, objArr);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
        }
    }

    private static void invoke(Method method, Object[] objArr) {
        if (method != null) {
            try {
                method.invoke(null, objArr);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
    }

    private static void setFile(Class<?> cls, String str, String str2) {
        if (cls != null) {
            try {
                cls.getField(str).set(str, str2);
            } catch (Exception unused) {
            }
        }
    }

    private static void setFile(Class<?> cls, String str, boolean z) {
        if (cls != null) {
            try {
                cls.getField(str).set(str, Boolean.valueOf(z));
            } catch (Exception unused) {
            }
        }
    }

    public static boolean getInitStatus() {
        boolean z;
        synchronized (lockObject) {
            z = isFinish;
        }
        return z;
    }

    private static boolean checkShareSdk(Class<?> cls) {
        try {
            return cls.getDeclaredField("isZyb") != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void init(Context context, int i, String str) {
        init(context, null, null, i, str);
    }

    private static boolean isPreInit() {
        boolean z;
        synchronized (PreInitLock) {
            z = preInitComplete;
        }
        return z;
    }

    public static void preInit(Context context, String str, String str2) {
        synchronized (lock) {
            preInitInvokedFlag = 1;
        }
        preInitInternal(context, str, str2);
    }

    public static void submitPolicyGrantResult(Context context, boolean z) {
        UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.B, b.a(context).a(), null);
        synchronized (lock) {
            policyGrantInvokedFlag = 1;
            if (z) {
                policyGrantResult = 1;
            } else {
                policyGrantResult = 2;
            }
        }
        UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.z, b.a(context).a(), Integer.valueOf(policyGrantResult));
    }

    private static void preInitInternal(Context context, String str, String str2) {
        if (context == null) {
            if (debugLog) {
                Log.e(TAG, "preInit: context is null, pls check!");
                return;
            }
            return;
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (TextUtils.isEmpty(str)) {
            str = UMUtils.getAppkeyByXML(origApplicationContext);
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = UMUtils.getChannelByXML(origApplicationContext);
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "Unknown";
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        sAppkey = str;
        sChannel = str2;
        UMGlobalContext.getInstance(origApplicationContext);
        l.a(origApplicationContext);
        if (!needSendZcfgEnv(origApplicationContext)) {
            FieldManager.a().a(origApplicationContext);
        }
        synchronized (PreInitLock) {
            preInitComplete = true;
        }
    }

    private static void enterRTDModeIfNeeded(Context context) {
        long jLongValue;
        long jLongValue2;
        if (context == null) {
            return;
        }
        String strA = com.umeng.common.b.a(context, AnalyticsConfig.RTD_SP_FILE, AnalyticsConfig.DEBUG_KEY);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        String strA2 = com.umeng.common.b.a(context, AnalyticsConfig.RTD_SP_FILE, "startTime");
        String strA3 = com.umeng.common.b.a(context, AnalyticsConfig.RTD_SP_FILE, "period");
        if (TextUtils.isEmpty(strA2)) {
            jLongValue = 0;
        } else {
            try {
                jLongValue = Long.valueOf(strA2).longValue();
            } catch (Throwable unused) {
                jLongValue = 0;
            }
        }
        if (TextUtils.isEmpty(strA3)) {
            jLongValue2 = 0;
        } else {
            try {
                jLongValue2 = Long.valueOf(strA3).longValue();
            } catch (Throwable unused2) {
                jLongValue2 = 0;
            }
        }
        if (jLongValue == 0 || jLongValue2 == 0) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [RTD]本地缓存startTime或者duration值无效，清除缓存数据");
            com.umeng.common.b.a(context, AnalyticsConfig.RTD_SP_FILE);
            return;
        }
        if (System.currentTimeMillis() - jLongValue > jLongValue2 * 60000) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [RTD]本地缓存dk值已经超时，清除缓存数据。");
            com.umeng.common.b.a(context, AnalyticsConfig.RTD_SP_FILE);
            if (AnalyticsConfig.isRealTimeDebugMode()) {
                AnalyticsConfig.turnOffRealTimeDebug();
                return;
            }
            return;
        }
        HashMap map = new HashMap();
        map.put(AnalyticsConfig.DEBUG_KEY, strA);
        if (AnalyticsConfig.isRealTimeDebugMode()) {
            return;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [RTD]本地缓存dk值在有效期内，切换到埋点验证模式。");
        AnalyticsConfig.turnOnRealTimeDebug(map);
    }

    /* JADX WARN: Type inference failed for: r6v14, types: [com.umeng.commonsdk.UMConfigure$2] */
    /* JADX WARN: Type inference failed for: r6v18, types: [com.umeng.commonsdk.UMConfigure$1] */
    /* JADX WARN: Type inference failed for: r6v8, types: [com.umeng.commonsdk.UMConfigure$3] */
    public static void init(Context context, String str, String str2, int i, String str3) {
        Method declaredMethod;
        Object objInvoke;
        Method declaredMethod2;
        Method declaredMethod3;
        Method declaredMethod4;
        Method declaredMethod5;
        Method declaredMethod6;
        Object objInvoke2;
        Class<?> cls;
        Method declaredMethod7;
        Method declaredMethod8;
        try {
            try {
                if (debugLog) {
                    Log.i(TAG, "common version is 9.4.7");
                    Log.i(TAG, "common type is " + SdkVersion.SDK_TYPE);
                }
                if (context == null) {
                    if (debugLog) {
                        Log.e(TAG, "context is null !!!");
                        return;
                    }
                    return;
                }
                if (isInit) {
                    if (debugLog) {
                        Log.e(TAG, "has inited !!!");
                        return;
                    }
                    return;
                }
                final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                if (getClass("com.umeng.umzid.ZIDManager") == null) {
                    Log.e(TAG, "--->>> SDK 初始化失败，请检查是否集成umeng-asms-1.2.x.aar库。<<<--- ");
                    new Thread() { // from class: com.umeng.commonsdk.UMConfigure.1
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            try {
                                Looper.prepare();
                                Toast.makeText(origApplicationContext, "SDK 初始化失败，请检查是否集成umeng-asms-1.2.X.aar库。", 1).show();
                                Looper.loop();
                            } catch (Throwable unused) {
                            }
                        }
                    }.start();
                    return;
                }
                try {
                    Class<?> cls2 = getClass("com.umeng.message.PushAgent");
                    if (cls2 != null && !checkShareSdk(cls2)) {
                        Log.e("UMLog", UMLogCommon.SC_10015);
                        if (shouldCheckShareSdk) {
                            new Thread() { // from class: com.umeng.commonsdk.UMConfigure.2
                                @Override // java.lang.Thread, java.lang.Runnable
                                public void run() {
                                    try {
                                        Looper.prepare();
                                        Toast.makeText(origApplicationContext, UMLogCommon.SC_10015, 1).show();
                                        Looper.loop();
                                    } catch (Throwable unused) {
                                    }
                                }
                            }.start();
                        }
                    }
                } catch (Throwable unused) {
                }
                try {
                    Class<?> cls3 = getClass("com.umeng.socialize.UMShareAPI");
                    if (cls3 != null && !checkShareSdk(cls3)) {
                        Log.e("UMLog", UMLogCommon.SC_10015);
                        if (shouldCheckShareSdk) {
                            new Thread() { // from class: com.umeng.commonsdk.UMConfigure.3
                                @Override // java.lang.Thread, java.lang.Runnable
                                public void run() {
                                    try {
                                        Looper.prepare();
                                        Toast.makeText(origApplicationContext, UMLogCommon.SC_10015, 1).show();
                                        Looper.loop();
                                    } catch (Throwable unused2) {
                                    }
                                }
                            }.start();
                        }
                    }
                } catch (Throwable unused2) {
                }
                if (!isPreInit()) {
                    preInitInternal(origApplicationContext, str, str2);
                    if (!isPreInit()) {
                        return;
                    }
                }
                UMUtils.setAppkey(origApplicationContext, sAppkey);
                String lastAppkey = UMUtils.getLastAppkey(origApplicationContext);
                if (!TextUtils.isEmpty(sAppkey) && !sAppkey.equals(lastAppkey)) {
                    if (!TextUtils.isEmpty(lastAppkey) && debugLog) {
                        UMLog.mutlInfo(UMLogCommon.SC_10008, 2, "");
                    }
                    UMUtils.setLastAppkey(origApplicationContext, sAppkey);
                }
                if (debugLog) {
                    Log.i(TAG, "current appkey is " + sAppkey + ", last appkey is " + lastAppkey);
                }
                if (debugLog) {
                    String appkeyByXML = UMUtils.getAppkeyByXML(origApplicationContext);
                    if (!TextUtils.isEmpty(sAppkey) && !TextUtils.isEmpty(appkeyByXML) && !sAppkey.equals(appkeyByXML)) {
                        UMLog.mutlInfo(UMLogCommon.SC_10011, 3, "", new String[]{"@", "#"}, new String[]{sAppkey, appkeyByXML});
                    }
                }
                UMUtils.setChannel(origApplicationContext, sChannel);
                if (debugLog) {
                    Log.i(TAG, "channel is " + sChannel);
                }
                try {
                    Class<?> cls4 = Class.forName("com.umeng.analytics.MobclickAgent");
                    if (cls4 != null) {
                        Method declaredMethod9 = cls4.getDeclaredMethod("init", Context.class);
                        if (declaredMethod9 != null) {
                            declaredMethod9.setAccessible(true);
                            declaredMethod9.invoke(cls4, origApplicationContext);
                            if (FieldManager.allow(com.umeng.commonsdk.utils.b.F)) {
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> FirstResumeTrigger enabled.");
                                l.a(origApplicationContext).b(origApplicationContext);
                            } else {
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> FirstResumeTrigger disabled.");
                            }
                            if (debugLog) {
                                UMLog.mutlInfo(UMLogCommon.SC_10003, 2, "");
                            }
                        }
                        if (Class.forName("com.umeng.analytics.game.UMGameAgent") != null && (declaredMethod8 = cls4.getDeclaredMethod("setGameScenarioType", Context.class)) != null) {
                            declaredMethod8.setAccessible(true);
                            declaredMethod8.invoke(cls4, origApplicationContext);
                        }
                    }
                    if (com.umeng.commonsdk.statistics.b.f9250a.indexOf("e") >= 0 && (cls = Class.forName("com.umeng.analytics.MobclickAgent")) != null && (declaredMethod7 = cls.getDeclaredMethod("disableExceptionCatch", new Class[0])) != null) {
                        declaredMethod7.setAccessible(true);
                        declaredMethod7.invoke(cls, new Object[0]);
                    }
                } catch (Throwable unused3) {
                }
                try {
                    Class<?> cls5 = Class.forName("com.umeng.message.MessageSharedPrefs");
                    if (cls5 != null && (declaredMethod6 = cls5.getDeclaredMethod("getInstance", Context.class)) != null && (objInvoke2 = declaredMethod6.invoke(cls5, origApplicationContext)) != null) {
                        Method declaredMethod10 = cls5.getDeclaredMethod("setMessageAppKey", String.class);
                        if (declaredMethod10 != null) {
                            declaredMethod10.setAccessible(true);
                            declaredMethod10.invoke(objInvoke2, sAppkey);
                            if (debugLog) {
                                UMLog.mutlInfo(UMLogCommon.SC_10004, 2, "");
                            }
                        }
                        Method declaredMethod11 = cls5.getDeclaredMethod(KEY_METHOD_NAME_PUSH_SETCHANNEL, String.class);
                        if (declaredMethod11 != null) {
                            declaredMethod11.setAccessible(true);
                            declaredMethod11.invoke(objInvoke2, sChannel);
                            if (debugLog) {
                                UMLog.mutlInfo(UMLogCommon.SC_10005, 2, "");
                            }
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            if (debugLog) {
                                Log.i(TAG, "push secret is " + str3);
                            }
                            Method declaredMethod12 = cls5.getDeclaredMethod("setMessageAppSecret", String.class);
                            if (declaredMethod12 != null) {
                                declaredMethod12.setAccessible(true);
                                declaredMethod12.invoke(objInvoke2, str3);
                                if (debugLog) {
                                    UMLog.mutlInfo(UMLogCommon.SC_10009, 2, "");
                                }
                            }
                        }
                    }
                } catch (Exception unused4) {
                }
                try {
                    Class<?> cls6 = getClass("com.umeng.socialize.UMShareAPI");
                    setFile(cls6, KEY_FILE_NAME_APPKEY, sAppkey);
                    if (cls6 != null && (declaredMethod5 = cls6.getDeclaredMethod("init", Context.class, String.class)) != null) {
                        declaredMethod5.setAccessible(true);
                        declaredMethod5.invoke(cls6, origApplicationContext, sAppkey);
                        if (debugLog) {
                            UMLog.mutlInfo(UMLogCommon.SC_10006, 2, "");
                        }
                    }
                } catch (Throwable unused5) {
                }
                AnalyticsConstants.setDeviceType(i);
                try {
                    Class<?> cls7 = Class.forName("com.umeng.error.UMError");
                    if (cls7 != null && (declaredMethod4 = cls7.getDeclaredMethod("init", Context.class)) != null) {
                        declaredMethod4.setAccessible(true);
                        declaredMethod4.invoke(cls7, origApplicationContext);
                        if (debugLog) {
                            UMLog.mutlInfo(UMLogCommon.SC_10010, 2, "");
                        }
                    }
                } catch (Throwable unused6) {
                }
                try {
                    Class<?> cls8 = Class.forName("com.umeng.umcrash.UMCrash");
                    if (cls8 != null) {
                        if (SdkVersion.SDK_TYPE == 1 && (declaredMethod3 = cls8.getDeclaredMethod("useIntlServices", Boolean.TYPE)) != null) {
                            declaredMethod3.setAccessible(true);
                            declaredMethod3.invoke(cls8, true);
                        }
                        Method declaredMethod13 = cls8.getDeclaredMethod("init", Context.class, String.class, String.class);
                        if (declaredMethod13 != null) {
                            declaredMethod13.setAccessible(true);
                            declaredMethod13.invoke(cls8, origApplicationContext, sAppkey, sChannel);
                            if (debugLog) {
                                UMLog.mutlInfo(UMLogCommon.SC_10014, 2, "");
                            }
                        }
                    }
                } catch (Throwable unused7) {
                }
                try {
                    Method declaredMethod14 = Class.forName("com.umeng.vt.facade.EventFacade").getDeclaredMethod("init", Application.class, String.class, String.class, Integer.TYPE, String.class);
                    if (declaredMethod14 != null) {
                        declaredMethod14.invoke(null, origApplicationContext, sAppkey, sChannel, Integer.valueOf(i), str3);
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>初始化 EventFacade 成功.");
                    }
                } catch (Throwable unused8) {
                }
                try {
                    Method declaredMethod15 = Class.forName("com.umeng.vt.common.VTTracker").getDeclaredMethod("init", Application.class, String.class);
                    if (declaredMethod15 != null) {
                        declaredMethod15.invoke(null, origApplicationContext, sAppkey);
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>初始化 VTTracker 成功.");
                    }
                } catch (Throwable unused9) {
                }
                synchronized (lockObject) {
                    isFinish = true;
                }
                if (needCheckPolicyResult(origApplicationContext)) {
                    synchronized (lock) {
                        if (preInitInvokedFlag == 0) {
                            Log.e(TAG, UMLogCommon.SC_10026);
                        }
                        if (policyGrantResult == 0) {
                            Log.e(TAG, UMLogCommon.SC_10028);
                        }
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(com.umeng.commonsdk.internal.a.G, preInitInvokedFlag);
                            jSONObject.put(com.umeng.commonsdk.internal.a.H, policyGrantInvokedFlag);
                            jSONObject.put("policyGrantResult", policyGrantResult);
                            UMWorkDispatch.sendEvent(origApplicationContext, com.umeng.commonsdk.internal.a.A, b.a(origApplicationContext).a(), jSONObject);
                        } catch (Throwable unused10) {
                        }
                    }
                }
                if (needSendZcfgEnv(origApplicationContext)) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 走零号报文发送逻辑");
                    UMWorkDispatch.sendEvent(origApplicationContext, com.umeng.commonsdk.internal.a.p, b.a(origApplicationContext).a(), null);
                } else {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 走正常逻辑.");
                    if (FieldManager.b()) {
                        UMWorkDispatch.sendEvent(origApplicationContext, com.umeng.commonsdk.internal.a.y, b.a(origApplicationContext).a(), null);
                    }
                }
                if (isDebugLog()) {
                    UMConfigureInternation.doSelfCheck(origApplicationContext);
                }
                try {
                    Context origApplicationContext2 = StubApp.getOrigApplicationContext(context.getApplicationContext());
                    Class<?> cls9 = Class.forName("com.umeng.cconfig.UMRemoteConfig");
                    if (cls9 != null && (declaredMethod = cls9.getDeclaredMethod("getInstance", new Class[0])) != null && (objInvoke = declaredMethod.invoke(cls9, new Object[0])) != null && (declaredMethod2 = cls9.getDeclaredMethod("init", Context.class)) != null) {
                        declaredMethod2.setAccessible(true);
                        declaredMethod2.invoke(objInvoke, origApplicationContext2);
                    }
                } catch (Exception unused11) {
                }
                enterRTDModeIfNeeded(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                if (isInit) {
                    return;
                }
                isInit = true;
            } catch (Exception e) {
                if (debugLog) {
                    Log.e(TAG, "init e is " + e);
                }
            }
        } catch (Throwable th) {
            if (debugLog) {
                Log.e(TAG, "init e is " + th);
            }
        }
    }

    public static boolean needSendZcfgEnv(Context context) {
        return !new File(new StringBuilder().append(context.getFilesDir().getAbsolutePath()).append(File.separator).append(aq.l).toString()).exists();
    }

    private static boolean needCheckPolicyResult(Context context) {
        return !new File(new StringBuilder().append(context.getFilesDir().getAbsolutePath()).append(File.separator).append(aq.m).toString()).exists();
    }

    public static void setLogEnabled(boolean z) {
        try {
            debugLog = z;
            MLog.DEBUG = z;
            Class<?> cls = getClass("com.umeng.message.PushAgent");
            invoke(getDecMethod(cls, KEY_METHOD_NAME_SETDEBUGMODE, new Class[]{Boolean.TYPE}), getDecInstanceObject(cls), new Object[]{Boolean.valueOf(z)});
            setFile(getClass("com.umeng.socialize.Config"), "DEBUG", z);
            invoke(getDecMethod(getClass("com.umeng.umcrash.UMCrash"), "setDebug", new Class[]{Boolean.TYPE}), new Object[]{Boolean.valueOf(z)});
        } catch (Exception e) {
            if (debugLog) {
                Log.e(TAG, "set log enabled e is " + e);
            }
        } catch (Throwable th) {
            if (debugLog) {
                Log.e(TAG, "set log enabled e is " + th);
            }
        }
    }

    public static void setEncryptEnabled(boolean z) {
        com.umeng.commonsdk.statistics.b.a(z);
    }

    public static String getUMIDString(Context context) {
        if (context != null) {
            return UMUtils.getUMId(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        }
        return null;
    }

    public static String getUmengZID(Context context) {
        if (context != null) {
            return UMUtils.getZid(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        }
        return null;
    }

    public static void setProcessEvent(boolean z) {
        AnalyticsConstants.SUB_PROCESS_EVENT = z;
    }

    private static void setLatencyWindow(long j) {
        com.umeng.commonsdk.statistics.a.c = ((int) j) * 1000;
    }

    private static void setModuleTag(BS_TYPE bs_type, String str, String str2) {
        try {
            if (bs_type == null) {
                Log.e("UMLog", UMLogCommon.SC_10024);
                return;
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (str.trim().getBytes().length > 64) {
                    Log.e("UMLog", UMLogCommon.SC_10017);
                    return;
                }
                if (str2.trim().getBytes().length > 128) {
                    Log.e("UMLog", UMLogCommon.SC_10018);
                    return;
                }
                int iOrdinal = bs_type.ordinal();
                String[] strArr = BUSINESS_TYPE;
                String str3 = iOrdinal < strArr.length ? strArr[iOrdinal] : "";
                if (TextUtils.isEmpty(str3)) {
                    Log.e("UMLog", UMLogCommon.SC_10019);
                    return;
                } else {
                    TagHelper.setModuleTag(str3 + "_" + str, str2);
                    return;
                }
            }
            Log.e("UMLog", UMLogCommon.SC_10016);
        } catch (Throwable unused) {
        }
    }

    private static void deleteModuleTag(BS_TYPE bs_type, String str) {
        if (bs_type == null) {
            Log.e("UMLog", UMLogCommon.SC_10025);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.e("UMLog", UMLogCommon.SC_10020);
            return;
        }
        try {
            if (str.trim().getBytes().length > 64) {
                Log.e("UMLog", UMLogCommon.SC_10021);
                return;
            }
            int iOrdinal = bs_type.ordinal();
            String[] strArr = BUSINESS_TYPE;
            String str2 = iOrdinal < strArr.length ? strArr[iOrdinal] : "";
            if (TextUtils.isEmpty(str2)) {
                Log.e("UMLog", UMLogCommon.SC_10022);
            } else {
                TagHelper.deleteModuleTag(str2 + "_" + str);
            }
        } catch (Throwable unused) {
        }
    }

    private static Map<String, String> getModuleTags() {
        try {
            return TagHelper.getModuleTags();
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void setCheckDevice(boolean z) {
        AnalyticsConstants.CHECK_DEVICE = z;
    }

    private static void setWraperType(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (str.equals(WRAPER_TYPE_NATIVE)) {
                com.umeng.commonsdk.stateless.a.f9243a = WRAPER_TYPE_NATIVE;
                com.umeng.commonsdk.statistics.a.f9249a = WRAPER_TYPE_NATIVE;
            } else if (str.equals(WRAPER_TYPE_COCOS2DX_X)) {
                com.umeng.commonsdk.stateless.a.f9243a = WRAPER_TYPE_COCOS2DX_X;
                com.umeng.commonsdk.statistics.a.f9249a = WRAPER_TYPE_COCOS2DX_X;
            } else if (str.equals(WRAPER_TYPE_COCOS2DX_XLUA)) {
                com.umeng.commonsdk.stateless.a.f9243a = WRAPER_TYPE_COCOS2DX_XLUA;
                com.umeng.commonsdk.statistics.a.f9249a = WRAPER_TYPE_COCOS2DX_XLUA;
            } else if (str.equals(WRAPER_TYPE_UNITY)) {
                com.umeng.commonsdk.stateless.a.f9243a = WRAPER_TYPE_UNITY;
                com.umeng.commonsdk.statistics.a.f9249a = WRAPER_TYPE_UNITY;
            } else if (str.equals(WRAPER_TYPE_REACTNATIVE)) {
                com.umeng.commonsdk.stateless.a.f9243a = WRAPER_TYPE_REACTNATIVE;
                com.umeng.commonsdk.statistics.a.f9249a = WRAPER_TYPE_REACTNATIVE;
            } else if (str.equals(WRAPER_TYPE_PHONEGAP)) {
                com.umeng.commonsdk.stateless.a.f9243a = WRAPER_TYPE_PHONEGAP;
                com.umeng.commonsdk.statistics.a.f9249a = WRAPER_TYPE_PHONEGAP;
            } else if (str.equals(WRAPER_TYPE_WEEX)) {
                com.umeng.commonsdk.stateless.a.f9243a = WRAPER_TYPE_WEEX;
                com.umeng.commonsdk.statistics.a.f9249a = WRAPER_TYPE_WEEX;
            } else if (str.equals("hybrid")) {
                com.umeng.commonsdk.stateless.a.f9243a = "hybrid";
                com.umeng.commonsdk.statistics.a.f9249a = "hybrid";
            } else if (str.equals(WRAPER_TYPE_FLUTTER)) {
                com.umeng.commonsdk.stateless.a.f9243a = WRAPER_TYPE_FLUTTER;
                com.umeng.commonsdk.statistics.a.f9249a = WRAPER_TYPE_FLUTTER;
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        com.umeng.commonsdk.stateless.a.b = str2;
        com.umeng.commonsdk.statistics.a.b = str2;
    }

    public static String[] getTestDeviceInfo(Context context) {
        String[] strArr = new String[2];
        if (context != null) {
            try {
                strArr[0] = DeviceConfig.getDeviceIdForGeneral(context);
                strArr[1] = DeviceConfig.getMac(context);
            } catch (Exception unused) {
            }
        }
        return strArr;
    }

    public static void getOaid(Context context, OnGetOaidListener onGetOaidListener) {
        if (context == null) {
            if (debugLog) {
                Log.e(TAG, "context is null !!!");
            }
        } else {
            final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            mOnGetOaidListener = onGetOaidListener;
            new Thread(new Runnable() { // from class: com.umeng.commonsdk.UMConfigure.4
                @Override // java.lang.Runnable
                public void run() {
                    String strA = aa.a(origApplicationContext);
                    if (UMConfigure.mOnGetOaidListener != null) {
                        UMConfigure.mOnGetOaidListener.onGetOaid(strA);
                    }
                }
            }).start();
        }
    }
}
