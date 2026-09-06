package com.hihonor.adsdk.base.mediation.adn;

import android.content.Context;
import android.util.ArrayMap;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.api.feed.PictureTextExpressAd;
import com.hihonor.adsdk.base.api.interstitial.InterstitialExpressAd;
import com.hihonor.adsdk.base.api.reward.RewardExpressAd;
import com.hihonor.adsdk.base.api.splash.SplashExpressAd;
import com.hihonor.adsdk.base.g.j.d.c;
import com.hihonor.adsdk.base.g.j.d.x;
import com.hihonor.adsdk.base.mediation.core.imp.AdapterConstructorBean;
import com.hihonor.adsdk.base.mediation.interfaces.BaseAdapter;
import com.hihonor.adsdk.base.mediation.interfaces.BaseBannerAd;
import com.hihonor.adsdk.common.b.b;
import com.ubixnow.ooooo.o0OO000o;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class AdnAdapter {
    private static final String TAG = "AdnAdapter";
    private static ArrayMap<String, String> splashPathMap = new ArrayMap<>();
    private static ArrayMap<String, String> nativePathMap = new ArrayMap<>();
    private static ArrayMap<String, String> interstitialPathMap = new ArrayMap<>();
    private static ArrayMap<String, String> rewardPathMap = new ArrayMap<>();

    static {
        splashPathMap.put("0", AdnConfig.d.hnadsa);
        splashPathMap.put("1", AdnConfig.c.hnadsd);
        nativePathMap.put("0", AdnConfig.d.hnadsb);
        nativePathMap.put("1", AdnConfig.c.hnadsb);
        rewardPathMap.put("0", AdnConfig.d.hnadsc);
        rewardPathMap.put("1", AdnConfig.c.hnadsc);
        interstitialPathMap.put("0", AdnConfig.d.hnadsd);
        interstitialPathMap.put("1", AdnConfig.c.hnadse);
    }

    protected static <T> T createAdapter(Class<T> cls, String str, Map<String, Object> map) {
        Exception exc;
        String str2;
        String str3;
        String str4;
        String str5;
        T t;
        int i;
        String str6;
        String str7 = "";
        try {
            Context context = (Context) map.get("context");
            str4 = (String) getParamsAgreement(map, "appId", "");
            try {
                str5 = (String) getParamsAgreement(map, "posId", "");
                try {
                    String str8 = (String) getParamsAgreement(map, o0OO000o.o00O0O0O, "");
                    int iIntValue = ((Integer) getParamsAgreement(map, "adCount", 0)).intValue();
                    String str9 = (String) getParamsAgreement(map, "adContext", "");
                    int iIntValue2 = ((Integer) getParamsAgreement(map, "adWidth", 0)).intValue();
                    int iIntValue3 = ((Integer) getParamsAgreement(map, "adHeight", 0)).intValue();
                    long jLongValue = ((Long) getParamsAgreement(map, "timeOutMillis", 0)).longValue();
                    String str10 = (String) getParamsAgreement(map, "mediaRequestId", "");
                    try {
                        String strValueOf = String.valueOf(getParamsAgreement(map, "brandType", ""));
                        try {
                            String strValueOf2 = String.valueOf(getParamsAgreement(map, "adnType", ""));
                            try {
                                int iIntValue4 = ((Integer) getParamsAgreement(map, "adType", 0)).intValue();
                                try {
                                    int iIntValue5 = ((Integer) getParamsAgreement(map, "loadType", -1)).intValue();
                                    String str11 = (String) getParamsAgreement(map, "rewardName", "");
                                    double dDoubleValue = ((Double) getParamsAgreement(map, "rewardAmount", 0)).doubleValue();
                                    Class<? extends U> clsAsSubclass = Class.forName(str).asSubclass(cls);
                                    str6 = str10;
                                    try {
                                        AdapterConstructorBean adapterConstructorBean = new AdapterConstructorBean();
                                        adapterConstructorBean.setContext(context);
                                        adapterConstructorBean.setAppId(str4);
                                        adapterConstructorBean.setPosId(str5);
                                        adapterConstructorBean.setExt(str8);
                                        adapterConstructorBean.setRewardName(str11);
                                        adapterConstructorBean.setRewardAmount(dDoubleValue);
                                        Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(adapterConstructorBean.getClass());
                                        declaredConstructor.setAccessible(true);
                                        t = (T) declaredConstructor.newInstance(adapterConstructorBean);
                                        try {
                                            Object[] objArr = {Integer.valueOf(iIntValue)};
                                            Class cls2 = Integer.TYPE;
                                            invoke("setAdCount", cls, t, objArr, cls2);
                                            invoke("setAdContext", cls, t, new Object[]{str9}, String.class);
                                            invoke("setAdWidth", cls, t, new Object[]{Integer.valueOf(iIntValue2)}, cls2);
                                            invoke("setAdHeight", cls, t, new Object[]{Integer.valueOf(iIntValue3)}, cls2);
                                            invoke("setTimeOutMillis", cls, t, new Object[]{Long.valueOf(jLongValue)}, Long.TYPE);
                                            invoke("setMediaRequestId", cls, t, new Object[]{str6}, String.class);
                                            invoke("setLoadType", cls, t, new Object[]{Integer.valueOf(iIntValue5)}, cls2);
                                        } catch (Exception e) {
                                            exc = e;
                                            str2 = strValueOf;
                                            str3 = strValueOf2;
                                            i = iIntValue4;
                                            str7 = str6;
                                            b.hnadsb(TAG, "createAdapter, error:" + exc.getMessage(), new Object[0]);
                                            c cVarHnadsa = new c.a().hnadsm(str7).hnadsc(str5).hnadsj(String.valueOf(ErrorCode.AD_CREATE_ADAPTER_ERROR)).hnadsk("createAdapter error:" + exc.getMessage()).hnadsw(str4).hnadsb(i).hnadsf(str2).hnadsd(str3).hnadsa();
                                            new x(cVarHnadsa, cVarHnadsa.hnadsl(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(cVarHnadsa)).hnadse();
                                        }
                                    } catch (Exception e2) {
                                        e = e2;
                                        exc = e;
                                        str2 = strValueOf;
                                        str3 = strValueOf2;
                                        i = iIntValue4;
                                        str7 = str6;
                                        t = (T) null;
                                        b.hnadsb(TAG, "createAdapter, error:" + exc.getMessage(), new Object[0]);
                                        c cVarHnadsa2 = new c.a().hnadsm(str7).hnadsc(str5).hnadsj(String.valueOf(ErrorCode.AD_CREATE_ADAPTER_ERROR)).hnadsk("createAdapter error:" + exc.getMessage()).hnadsw(str4).hnadsb(i).hnadsf(str2).hnadsd(str3).hnadsa();
                                        new x(cVarHnadsa2, cVarHnadsa2.hnadsl(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(cVarHnadsa2)).hnadse();
                                        return t;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    str6 = str10;
                                }
                            } catch (Exception e4) {
                                exc = e4;
                                str2 = strValueOf;
                                str3 = strValueOf2;
                                str7 = str10;
                                t = null;
                                i = 0;
                                b.hnadsb(TAG, "createAdapter, error:" + exc.getMessage(), new Object[0]);
                                c cVarHnadsa3 = new c.a().hnadsm(str7).hnadsc(str5).hnadsj(String.valueOf(ErrorCode.AD_CREATE_ADAPTER_ERROR)).hnadsk("createAdapter error:" + exc.getMessage()).hnadsw(str4).hnadsb(i).hnadsf(str2).hnadsd(str3).hnadsa();
                                new x(cVarHnadsa3, cVarHnadsa3.hnadsl(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(cVarHnadsa3)).hnadse();
                                return t;
                            }
                        } catch (Exception e5) {
                            exc = e5;
                            str3 = "";
                            str2 = strValueOf;
                        }
                    } catch (Exception e6) {
                        exc = e6;
                        str2 = "";
                        str3 = str2;
                    }
                } catch (Exception e7) {
                    exc = e7;
                    str2 = "";
                    str3 = str2;
                }
            } catch (Exception e8) {
                exc = e8;
                str2 = "";
                str3 = str2;
                str5 = str3;
            }
        } catch (Exception e9) {
            exc = e9;
            str2 = "";
            str3 = str2;
            str4 = str3;
            str5 = str4;
        }
        return t;
    }

    private static String getAdnKey(String str, String str2) {
        return str + "_" + str2;
    }

    public static BaseBannerAd getBannerAd(Map<String, Object> map) {
        return (BaseBannerAd) createAdapter(BaseBannerAd.class, AdnConfig.c.hnadsa, map);
    }

    public static BaseAdapter<InterstitialExpressAd> getInterstitialAd(String str, Map<String, Object> map) {
        return (BaseAdapter) createAdapter(BaseAdapter.class, interstitialPathMap.get(str), map);
    }

    public static BaseAdapter<PictureTextExpressAd> getNativeAd(String str, Map<String, Object> map) {
        return (BaseAdapter) createAdapter(BaseAdapter.class, nativePathMap.get(str), map);
    }

    private static Object getParamsAgreement(Map<String, Object> map, String str, Object obj) {
        Object obj2 = map.get(str);
        return obj2 == null ? obj : obj2;
    }

    public static BaseAdapter<RewardExpressAd> getRewardAd(String str, Map<String, Object> map) {
        return (BaseAdapter) createAdapter(BaseAdapter.class, rewardPathMap.get(str), map);
    }

    public static BaseAdapter<SplashExpressAd> getSplashAd(String str, Map<String, Object> map) {
        return (BaseAdapter) createAdapter(BaseAdapter.class, splashPathMap.get(str), map);
    }

    public static void initCJS(Context context, String str) {
        try {
            Class.forName(AdnConfig.c.hnadsf).getMethod("init", Context.class, String.class).invoke(null, context, str);
        } catch (Exception e) {
            b.hnadsb(TAG, "initCJS, init cjs error, Exception: " + e.getMessage(), new Object[0]);
        }
    }

    private static <T> void invoke(String str, Class<? extends T> cls, T t, Object[] objArr, Class<?>... clsArr) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(t, objArr);
    }
}
