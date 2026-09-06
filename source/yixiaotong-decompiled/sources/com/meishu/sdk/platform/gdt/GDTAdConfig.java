package com.meishu.sdk.platform.gdt;

import android.content.Context;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.b;
import com.meishu.sdk.core.utils.LogUtil;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.stub.StubApp;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class GDTAdConfig extends b {
    static /* synthetic */ Object lambda$onInit$0(Object obj, Method method, Object[] objArr) throws Throwable {
        LogUtil.d("GDTAdConfig", "gdt init succ");
        return null;
    }

    @Override // com.meishu.sdk.core.b
    public void onInit(Context context, String str, String str2) {
        if (AdSdk.adConfig().getCanUseSdkPersonalRecommend()) {
            GlobalSetting.setPersonalizedState(0);
        } else {
            GlobalSetting.setPersonalizedState(1);
        }
        if (AdSdk.adConfig().customController() != null) {
            GlobalSetting.setAgreePrivacyStrategy(AdSdk.adConfig().customController().isCanUsePhoneState());
            GlobalSetting.setEnableCollectAppInstallStatus(AdSdk.adConfig().customController().canReadInstalledPackages());
        }
        try {
            if (!AdSdk.adConfig().enableInstallBroadcast()) {
                HashMap map = new HashMap();
                map.put("hieib", Boolean.FALSE);
                GlobalSetting.setConvOptimizeInfo(map);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            Class<?> cls = Class.forName("com.qq.e.comm.managers.GDTAdSdk");
            try {
                cls.getDeclaredMethod("initWithoutStart", Context.class, String.class).invoke(null, StubApp.getOrigApplicationContext(context.getApplicationContext()), str);
                Class<?> cls2 = Class.forName("com.qq.e.comm.managers.GDTAdSdk$OnStartListener");
                cls.getDeclaredMethod("start", cls2).invoke(null, Proxy.newProxyInstance(GDTAdConfig.class.getClassLoader(), new Class[]{cls2}, new InvocationHandler() { // from class: com.meishu.sdk.platform.gdt.GDTAdConfig$$ExternalSyntheticLambda0
                    @Override // java.lang.reflect.InvocationHandler
                    public final Object invoke(Object obj, Method method, Object[] objArr) {
                        return GDTAdConfig.lambda$onInit$0(obj, method, objArr);
                    }
                }));
            } catch (Throwable unused) {
                cls.getDeclaredMethod("init", Context.class, String.class).invoke(null, StubApp.getOrigApplicationContext(context.getApplicationContext()), str);
            }
        } catch (Exception unused2) {
        }
        try {
            Class<?> cls3 = Class.forName("com.qq.e.comm.util.GDTLogger");
            Object objNewInstance = cls3.newInstance();
            Field declaredField = cls3.getDeclaredField("DEBUG_ENABLE");
            declaredField.setAccessible(true);
            declaredField.setBoolean(objNewInstance, true);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
