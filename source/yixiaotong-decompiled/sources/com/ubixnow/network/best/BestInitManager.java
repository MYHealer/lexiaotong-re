package com.ubixnow.network.best;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.my.adpoymer.interfaces.MyInitListener;
import com.my.adpoymer.manager.MyAdEntrance;
import com.my.adpoymer.manager.MyCustomControl;
import com.opos.acs.st.STManager;
import com.stub.StubApp;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.j1;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O0O0O;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.oOo00o00;
import com.ubixnow.ooooo.ooooO000;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class BestInitManager extends o00O0O0O {
    private static String OooO0o = "";
    private static BestInitManager OooO0o0;
    private static Map<o00O0OO0, o00O000> OooO0oO = new HashMap();

    private void OooO00o(Context context) {
        try {
            String strOooO0o0 = j1.OooOOOO;
            if (TextUtils.isEmpty(strOooO0o0)) {
                strOooO0o0 = oOo00o00.OooO0o0("oaid");
            }
            MyCustomControl.Builder androidid = new MyCustomControl.Builder(StubApp.getOrigApplicationContext(context.getApplicationContext())).setUseLocation(j1.OooO00o).setUseAndroidId(j1.OooO0OO).setUseWifiState(j1.OooO0oO).setUseWriteExternal(j1.OooO0o).setCanUsePhoneState(j1.OooO0O0).setCanUseOaid(j1.OooO0Oo).setCanUseMacAddress(j1.OooO0o0).setPersonalizedState(!j1.OooO ? 1 : 0).setProgrammaticRecommendState(j1.OooOO0).setMacAddress(j1.OooOOO0).setDevImei(j1.OooOO0o).setAndroidid(j1.OooOOO);
            if (strOooO0o0 == null) {
                strOooO0o0 = "";
            }
            MyCustomControl.Builder canUseApplist = androidid.setOaid(strOooO0o0).setCanUseApplist(j1.OooO0oo);
            try {
                canUseApplist.setCanDevImei(j1.OooO0O0).setCanPersonalizedState(j1.OooO).setCanAppHieib(true).setCanGdtUnionUseAppList(j1.OooO0oo).setCanCSJUnionUseAppList(j1.OooO0oo).setCanKuaiShouUseAppList(j1.OooO0oo);
            } catch (Throwable th) {
                ooooO000.OooO00o(th);
            }
            canUseApplist.build();
        } catch (Throwable th2) {
            ooooO000.OooO00o(th2);
        }
    }

    private void OooO00o(o00O000 o00o000, Context context, String str, o00O0OO0 o00o0oo0) {
        OooO00o(context);
        try {
            MyAdEntrance.class.getDeclaredMethod("init", Application.class, String.class).invoke(MyAdEntrance.class.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]), (Application) StubApp.getOrigApplicationContext(context.getApplicationContext()), str);
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
            trackingAdsInitFail(o00o000, "500041", oOO00O0.ubix_initError_msg);
            onError(new Exception(oOO00O0.ubix_initError_msg));
        }
    }

    public static ErrorInfo getErrorInfo(String str) {
        return new ErrorInfo("500041", getInstance().getName() + oOO00O0.ubix_initError_msg + str);
    }

    public static synchronized BestInitManager getInstance() {
        if (OooO0o0 == null) {
            OooO0o0 = new BestInitManager();
        }
        return OooO0o0;
    }

    public String getName() {
        return STManager.REGION_OF_MY;
    }

    @Override // com.ubixnow.ooooo.o00O0O0O
    public String getVersion() {
        try {
            ooooO000.OooO0O0("-----MYInit", "getVersion " + OooO0o);
            if (!TextUtils.isEmpty(OooO0o)) {
                return OooO0o;
            }
            String sdkv = MyAdEntrance.getInstance().getSdkv();
            OooO0o = sdkv;
            return sdkv;
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
            return "";
        }
    }

    @Override // com.ubixnow.ooooo.o00O0O0O
    public synchronized void initSDK(Context context, o00O000 o00o000) {
        super.initSDK(context, o00o000);
        initSDK(context, o00o000, null);
    }

    @Override // com.ubixnow.ooooo.o00O0O0O
    public synchronized void initSDK(Context context, final o00O000 o00o000, o00O0OO0 o00o0oo0) {
        try {
            super.initSDK(context, o00o000, o00o0oo0);
            String str = o00o000.OooO00o.OooO0Oo;
            ooooO000.OooO0O0("-----MYInit", "init " + str);
            OooO0oO.put(o00o0oo0, o00o000);
            if (isNeedInit(o00o000)) {
                trackSdkInitStart(o00o000);
                MyAdEntrance.getInstance().setMyInitListener(new MyInitListener() { // from class: com.ubixnow.network.best.BestInitManager.1
                    public void onInitFail() {
                        BestInitManager.this.trackingAdsInitFail(o00o000, "500041", oOO00O0.ubix_initError_msg);
                        BestInitManager.this.onError(new Exception(oOO00O0.ubix_initError_msg));
                    }

                    public void onInitSuccess() {
                        BestInitManager.this.OooO0O0 = true;
                        BestInitManager.this.trackingAdsInitSucc(o00o000);
                        BestInitManager.this.onSuccess();
                    }
                });
                OooO00o(o00o000, context, str, o00o0oo0);
            } else {
                onSuccess();
            }
        } catch (Throwable th) {
            trackingAdsInitFail(o00o000, "-1", th.getMessage());
            ooooO000.OooO00o(th);
            onError(th);
        }
    }

    public synchronized void onError(Throwable th) {
        try {
            Iterator<Map.Entry<o00O0OO0, o00O000>> it = OooO0oO.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<o00O0OO0, o00O000> next = it.next();
                ooooO000.OooO0O0("---MYInit", "init fail");
                next.getKey().onError(th);
                it.remove();
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    public synchronized void onSuccess() {
        try {
            Iterator<Map.Entry<o00O0OO0, o00O000>> it = OooO0oO.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<o00O0OO0, o00O000> next = it.next();
                ooooO000.OooO0O0("---MYInit", "init succ");
                trackRedirectStart(next.getValue());
                next.getKey().onSuccess();
                it.remove();
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }
}
