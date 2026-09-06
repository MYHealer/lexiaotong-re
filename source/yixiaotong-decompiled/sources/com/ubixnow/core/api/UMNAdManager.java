package com.ubixnow.core.api;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.stub.StubApp;
import com.ubixnow.ooooo.g1;
import com.ubixnow.ooooo.i1;
import com.ubixnow.ooooo.j1;
import com.ubixnow.ooooo.o00O0000;
import com.ubixnow.ooooo.o0O;
import com.ubixnow.ooooo.o0O0O0O;
import com.ubixnow.ooooo.o0O0ooO;
import com.ubixnow.ooooo.o0OO000;
import com.ubixnow.ooooo.o0OO000o;
import com.ubixnow.ooooo.o0OOO0;
import com.ubixnow.ooooo.o0OOO0OO;
import com.ubixnow.ooooo.oO00000o;
import com.ubixnow.ooooo.oO0Ooooo;
import com.ubixnow.ooooo.oOO0OO0O;
import com.ubixnow.ooooo.oOo00o00;
import com.ubixnow.ooooo.oo0oOO0;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.ooooo.ooooO0O0;
import com.ubixnow.utils.BaseUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UMNAdManager {
    public static boolean isInit = false;
    public static String localStrategyPath = "ubix_now_strategy";
    private static UMNAdManager manger;
    private UMNAdConfig adConfig;
    private Context mApplicationContext;
    public UMNAdConfig mConfig;

    public static UMNAdManager getInstance() {
        if (manger == null) {
            synchronized (UMNAdManager.class) {
                if (manger == null) {
                    manger = new UMNAdManager();
                }
            }
        }
        return manger;
    }

    public static String getSdkVersion() {
        return o00O0000.OooO0O0;
    }

    private void initDebugTool(Context context) {
        try {
            Class<?> cls = Class.forName("com.ubixnow.debugtool.DebugTool");
            cls.getDeclaredMethod("init", Context.class).invoke(cls, context);
            Log.e("----ubix", "广告调试工具已开启");
        } catch (Throwable unused) {
        }
    }

    private void initDefaultConfig() {
        if (oOo00o00.OooO00o(oO00000o.o00000O0.OooO0OO).booleanValue()) {
            oOo00o00.OooO00o(oO00000o.o00000O0.OooO0O0);
            oOo00o00.OooO0O0(oO00000o.o00000O0.OooOoO0);
            oOo00o00.OooO00o(oO00000o.o00000O0.OooO0OO, Boolean.FALSE);
        }
        int iOooO00o = oOo00o00.OooO00o(oO00000o.o00000O0.OooOoOO, 20);
        UbixDefaultConstants.cacheLimitCount = iOooO00o != -1 ? iOooO00o : 20;
        int iOooO00o2 = oOo00o00.OooO00o(oO00000o.o00000O0.OooOoo0, 30);
        UbixDefaultConstants.cacheLimitTime = iOooO00o2 != -1 ? iOooO00o2 : 30;
        int iOooO00o3 = oOo00o00.OooO00o(oO00000o.o00000O0.OooOoo, 0);
        UbixDefaultConstants.strategyCacheExpireTime = iOooO00o3 == -1 ? 0L : iOooO00o3;
        int iOooO00o4 = oOo00o00.OooO00o(oO00000o.o00000O0.OooOooO, 0);
        int iOooO00o5 = oOo00o00.OooO00o(oO00000o.o00000O0.OooOooo, 0);
        UbixDefaultConstants.s2sStrategyInterval = iOooO00o5 == -1 ? 0L : iOooO00o5;
        UbixDefaultConstants.requestStrategyInterval = iOooO00o4 != -1 ? iOooO00o4 : 0L;
    }

    private boolean initSDK(UMNAdConfig uMNAdConfig) {
        ooooO000.OooO00o(uMNAdConfig.isDebug);
        j1.OooO00o();
        j1.OooO00o(uMNAdConfig.privacyConfig, false);
        o0O0ooO.OooO00o(this.mConfig);
        i1.OooO00o(BaseUtils.getContext());
        oO00000o.o00O0O.OooO0o0 = oOo00o00.OooO0o0(oO00000o.o00000O0.OooOOOo).equals("") ? TtmlNode.COMBINE_ALL : oOo00o00.OooO0o0(oO00000o.o00000O0.OooOOOo);
        initTracking();
        oO0Ooooo.OooO00o();
        initDefaultConfig();
        o0OO000.OooO00o(o0OO000o.OooO00o, o0OO000.OooO00o(o0OO000o.OooO0O0), new Object[0]);
        if (TextUtils.isEmpty(uMNAdConfig.appId)) {
            Log.e(ooooO000.OooO0O0, "初始化失败-AppID为空");
            o0OO000.OooO00o(o0OO000o.OooO0o0, o0OO000.OooO00o(o0OO000o.OooO0o, "AppID为空", ""), new Object[0]);
            return false;
        }
        o0O.OooO00o();
        new o0OOO0OO(1).OooO0O0();
        o0OOO0.OooO00o(this.mConfig.appId);
        return true;
    }

    private void initTracking() {
        oOO0OO0O ooo0oo0o = new oOO0OO0O(oO00000o.OooO00o.OooO0OO + oO00000o.OooO00o.OooOO0o);
        ooo0oo0o.OooO0Oo();
        ooo0oo0o.OooO0O0(false);
        ooo0oo0o.OooO00o(oOo00o00.OooO00o(oO00000o.o00000O0.OooOO0O, 5));
        ooo0oo0o.OooO0O0(oOo00o00.OooO00o(oO00000o.o00000O0.OooOO0o, 15000));
        ooooO0O0.OooO0O0(BaseUtils.getContext(), ooo0oo0o);
    }

    private void initWM(Context context) {
        o0O0O0O.OooO00o((Application) StubApp.getOrigApplicationContext(context.getApplicationContext()));
    }

    public static void setLocalStrategyAssetPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        localStrategyPath = str;
    }

    public static void updatePrivacyConfig(UMNPrivacyConfig uMNPrivacyConfig) {
        j1.OooO00o(uMNPrivacyConfig, true);
    }

    public void asyncInit(Context context, UMNAdConfig uMNAdConfig) {
        this.mApplicationContext = context;
        this.adConfig = uMNAdConfig;
    }

    public String getAppId() {
        UMNAdConfig uMNAdConfig = this.mConfig;
        return uMNAdConfig != null ? uMNAdConfig.appId : "";
    }

    public UMNAdConfig getConfig() {
        return this.mConfig;
    }

    public synchronized void init(Context context, UMNAdConfig uMNAdConfig) {
        if (isInit) {
            Log.e(ooooO000.OooO0O0, "已完成初始化，多次初始化以第一次初始化成功为准");
            return;
        }
        if (context == null || uMNAdConfig == null || TextUtils.isEmpty(uMNAdConfig.appId)) {
            Log.e(ooooO000.OooO0O0, "初始化失败，请检查参数是否为空");
        } else {
            long jCurrentTimeMillis = System.currentTimeMillis();
            BaseUtils.init(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            this.mConfig = uMNAdConfig;
            Log.e("---pub_init_parameter", "setAppId: " + this.mConfig.appId);
            boolean zInitSDK = initSDK(uMNAdConfig);
            try {
                initWM(context);
            } catch (Exception unused) {
            }
            if (zInitSDK) {
                isInit = true;
                o0OO000.OooO00o(o0OO000o.OooO0OO, o0OO000.OooO00o(o0OO000o.OooO0Oo, System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
            }
        }
    }

    public void start(UMNInitCallBack uMNInitCallBack) {
        int i;
        String str;
        UMNAdConfig uMNAdConfig;
        final oo0oOO0 oo0ooo0 = new oo0oOO0(uMNInitCallBack);
        if (isInit) {
            oo0ooo0.OooO00o();
            return;
        }
        if (this.mApplicationContext == null || (uMNAdConfig = this.adConfig) == null) {
            i = -1;
            str = "初始化失败，请检查参数是否为空";
        } else if (!TextUtils.isEmpty(uMNAdConfig.appId)) {
            g1.OooO00o("init_thread").OooO0OO(new Runnable() { // from class: com.ubixnow.core.api.UMNAdManager.1
                @Override // java.lang.Runnable
                public void run() {
                    UMNAdManager uMNAdManager = UMNAdManager.this;
                    uMNAdManager.init(uMNAdManager.mApplicationContext, UMNAdManager.this.adConfig);
                    if (UMNAdManager.isInit) {
                        oo0ooo0.OooO00o();
                    } else {
                        oo0ooo0.OooO00o(-3, "初始化失败，请检查参数");
                    }
                }
            });
            return;
        } else {
            i = -2;
            str = "初始化失败-AppID为空";
        }
        oo0ooo0.OooO00o(i, str);
    }
}
