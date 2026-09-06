package com.yfanads.android.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import com.huawei.openalliance.ad.constant.x;
import com.yfanads.android.core.f;
import com.yfanads.android.model.AdsInitBean;
import com.yfanads.android.model.InitBean;
import com.yfanads.android.upload.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class ReflectionUtils {
    private static Method sForNameMethod;
    private static Method sGetDeclaredMethod;
    private static Method sGetFieldMethod;

    static {
        try {
            sForNameMethod = Class.class.getDeclaredMethod("forName", String.class);
            sGetDeclaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            sGetFieldMethod = Class.class.getDeclaredMethod("getDeclaredField", String.class);
        } catch (Throwable th) {
            YFLog.error("static not " + th.getMessage());
        }
    }

    private ReflectionUtils() {
    }

    private static boolean canReflection() {
        return (sForNameMethod == null || sGetDeclaredMethod == null || sGetFieldMethod == null) ? false : true;
    }

    public static boolean checkActivityConfigChangesUsingReflection(Activity activity) {
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ActivityInfo activityInfo = (ActivityInfo) declaredField.get(activity);
            return (activityInfo == null || (activityInfo.configChanges & 128) == 0) ? false : true;
        } catch (Exception e) {
            f.a(e, new StringBuilder("checkActivityConfigChangesUsingReflection "));
            return false;
        }
    }

    public static void checkImp(YFAdsConst.AdSource adSource, Map<Integer, YFAdsConst.AdSource> map, Map<Integer, String> map2) {
        try {
            Class.forName(adSource.className);
            String versionName = getVersionName(adSource.channel, adSource.verName);
            YFLog.high("ads source " + adSource.name + x.bQ + versionName);
            Class.forName(adSource.adapterName);
            YFLog.high("ads adapter " + adSource.name + x.bQ + reflectionField(adSource.adapterVerName, "VERSION_NAME"));
            if (map != null) {
                map.put(Integer.valueOf(adSource.channel), adSource);
            }
            if (map2 != null) {
                map2.put(Integer.valueOf(adSource.channel), versionName);
            }
        } catch (Exception e) {
            f.a(e, new StringBuilder("not has ").append(adSource).append("|"));
        }
    }

    public static void checkImpInit(Context context, YFAdsConst.AdSource adSource, Map<Integer, YFAdsConst.AdSource> map, Map<Integer, String> map2, AdsInitBean adsInitBean, String str) {
        try {
            Class.forName(adSource.className);
            String versionName = getVersionName(adSource.channel, adSource.verName);
            YFLog.high("ads source " + adSource.name + x.bQ + versionName);
            Class.forName(adSource.adapterName);
            YFLog.high("ads adapter " + adSource.name + x.bQ + reflectionField(adSource.adapterVerName, "VERSION_NAME"));
            if (map != null) {
                map.put(Integer.valueOf(adSource.channel), adSource);
            }
            if (map2 != null) {
                map2.put(Integer.valueOf(adSource.channel), versionName);
            }
            if (adsInitBean != null) {
                init(context, adsInitBean, str);
            }
        } catch (Exception e) {
            if (adSource == YFAdsConst.AdSource.AY || adSource == YFAdsConst.AdSource.XU || adSource == YFAdsConst.AdSource.GE || adSource == YFAdsConst.AdSource.CJ || adSource == YFAdsConst.AdSource.NAL || adSource == YFAdsConst.AdSource.IN || adSource == YFAdsConst.AdSource.JC || adSource == YFAdsConst.AdSource.NC || adSource == YFAdsConst.AdSource.UW || adSource == YFAdsConst.AdSource.KF || adSource == YFAdsConst.AdSource.KY || adSource == YFAdsConst.AdSource.ZD) {
                YFLog.error("not has " + adSource.channel);
            } else {
                f.a(e, new StringBuilder("not has ").append(adSource).append("|"));
            }
        }
    }

    public static boolean clearCache(String str, String str2) {
        try {
            Class.forName(str).getMethod(str2, new Class[0]).invoke(null, new Object[0]);
            return true;
        } catch (Exception e) {
            f.a(e, new StringBuilder("clearCache"));
            return false;
        }
    }

    public static Method getMethod(String str, String str2, Class<?>[] clsArr) {
        Method method = null;
        if (!canReflection()) {
            return null;
        }
        try {
            Method method2 = (Method) sGetDeclaredMethod.invoke((Class) sForNameMethod.invoke(null, str), str2, clsArr);
            if (method2 != null) {
                try {
                    method2.setAccessible(true);
                } catch (Throwable th) {
                    th = th;
                    method = method2;
                    YFLog.error("getMethod" + th.getMessage());
                    return method;
                }
            }
            return method2;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static Object getSDKAdapter(int i, String str, Class<?> cls, Object... objArr) {
        Object objNewInstance = null;
        try {
            Class<?> cls2 = Class.forName(str);
            if (objArr.length <= 0) {
                return null;
            }
            objNewInstance = cls2.getConstructor(cls).newInstance(objArr[0]);
            YFLog.high("getSDKAdapter success ");
            return objNewInstance;
        } catch (Exception e) {
            if (i == 15 || i == 16 || i == 17 || i == 18 || i == 19 || i == 20 || i == 21 || i == 22 || i == 23 || i == 25 || i == 24 || i == 26) {
                YFLog.error("getSDKAdapter not " + i);
                return objNewInstance;
            }
            f.a(e, new StringBuilder("getSDKAdapter not "));
            return objNewInstance;
        }
    }

    public static boolean hasMethod(String str) {
        try {
            Class.forName(str);
            YFLog.debug("hasMethod " + str);
            return true;
        } catch (Exception e) {
            f.a(e, new StringBuilder("hasMethod not "));
            return false;
        }
    }

    private static void init(Context context, final AdsInitBean adsInitBean, final String str) {
        try {
            YFLog.traceDebug("sdk pre source " + adsInitBean + " req:" + str);
            boolean z = b.e;
            b.a.f9685a.a(YFAdsConst.ReportETypeValue.ADS_SDK_START.getValue(), adsInitBean.adnId, str, adsInitBean.appId);
            initSdk("InitAdsSdk", context, adsInitBean, new InitUtils.InitListener() { // from class: com.yfanads.android.utils.ReflectionUtils.1
                @Override // com.yfanads.android.utils.InitUtils.InitListener
                public void fail(String str2, String str3) {
                    boolean z2 = b.e;
                    b bVar = b.a.f9685a;
                    String str4 = str;
                    int value = YFAdsConst.ReportETypeValue.ADS_SDK_FAIL.getValue();
                    AdsInitBean adsInitBean2 = adsInitBean;
                    bVar.a(value, adsInitBean2.adnId, str4, adsInitBean2.appId);
                }

                @Override // com.yfanads.android.utils.InitUtils.InitListener
                public void success() {
                    boolean z2 = b.e;
                    b bVar = b.a.f9685a;
                    String str2 = str;
                    int value = YFAdsConst.ReportETypeValue.ADS_SDK_SUCCESS.getValue();
                    AdsInitBean adsInitBean2 = adsInitBean;
                    bVar.a(value, adsInitBean2.adnId, str2, adsInitBean2.appId);
                }
            });
        } catch (Exception e) {
            f.a(e, new StringBuilder("init "));
        }
    }

    public static void initSdk(String str, Context context, AdsInitBean adsInitBean, InitUtils.InitListener initListener) {
        try {
            Method declaredMethod = Class.forName(adsInitBean.clasName).getDeclaredMethod(adsInitBean.methodName, String.class, Context.class, InitBean.class, InitUtils.InitListener.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, str, context, adsInitBean, initListener);
        } catch (Exception e) {
            f.a(e, new StringBuilder("initSdk init "));
        }
    }

    public static Object invokeMethod(Object obj, String str, String str2, Class<?>[] clsArr, Object... objArr) {
        try {
            Method method = getMethod(str, str2, clsArr);
            if (method != null) {
                return method.invoke(obj, objArr);
            }
        } catch (Throwable th) {
            YFLog.error("invokeMethod" + th.getMessage());
        }
        return null;
    }

    public static String oppoVersion(String str, String... strArr) {
        if (strArr != null) {
            try {
                if (strArr.length >= 2) {
                    Class<?> cls = Class.forName(str);
                    Object objInvoke = cls.getMethod(strArr[1], new Class[0]).invoke(cls.getMethod(strArr[0], new Class[0]).invoke(null, new Object[0]), new Object[0]);
                    return objInvoke != null ? objInvoke.toString() : "";
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                YFLog.error("oppoVersion" + e.getMessage());
            }
        }
        return "";
    }

    private static String reflectionField(String str, String str2) {
        if (str != null) {
            try {
                if (!str.isEmpty() && str2 != null && !str2.isEmpty()) {
                    Class<?> cls = Class.forName(str);
                    Constructor<?> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
                    declaredConstructor.setAccessible(true);
                    Object objNewInstance = declaredConstructor.newInstance(new Object[0]);
                    Field declaredField = cls.getDeclaredField(str2);
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(objNewInstance);
                    return obj != null ? obj.toString() : "";
                }
            } catch (Exception e) {
                f.a(e, new StringBuilder("reflectionField"));
                return "";
            }
        }
        YFLog.error("className or valueName is null or empty.");
        return "";
    }

    public static String staticMethodVersion(String str, String str2) {
        try {
            Class<?> cls = Class.forName(str);
            Object objInvoke = cls.getDeclaredMethod(str2, new Class[0]).invoke(cls.newInstance(), new Object[0]);
            return objInvoke != null ? objInvoke.toString() : "";
        } catch (Exception e) {
            f.a(e, new StringBuilder("staticMethodVersion"));
            return "";
        }
    }

    public static String staticValueVersion(String str, String str2) {
        try {
            Object obj = Class.forName(str).getDeclaredField(str2).get(null);
            return obj != null ? obj.toString() : "";
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            YFLog.error("staticValueVersion" + e.getMessage());
            return "";
        }
    }

    public static String getVersionName(int i, String str) {
        try {
            switch (i) {
                case 1:
                case 11:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                    return staticMethodVersion(str, "getSdkVersion");
                case 2:
                    return staticMethodVersion(str, "getIntegrationSDKVersion");
                case 3:
                    return staticMethodVersion(str, "getSDKVersion");
                case 4:
                case 7:
                case 9:
                case 10:
                case 12:
                    return reflectionField(str, "VERSION_NAME");
                case 5:
                default:
                    return "";
                case 6:
                case 21:
                    return staticValueVersion(str, "VERSION_NAME");
                case 8:
                    return oppoVersion(str, "getInstance", "getSdkVerName");
                case 13:
                    return reflectionField(str, "SDK_VERSION");
                case 20:
                    return staticMethodVersion(str, "getYouTuiADNSDKVersion");
            }
        } catch (Exception e) {
            f.a(e, new StringBuilder("reflectionField"));
            return "";
        }
    }
}
