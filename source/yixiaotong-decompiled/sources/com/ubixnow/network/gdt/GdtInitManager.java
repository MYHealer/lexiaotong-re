package com.ubixnow.network.gdt;

import android.content.Context;
import com.meishu.sdk.core.MSAdConfig;
import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.managers.status.SDKStatus;
import com.stub.StubApp;
import com.ubixnow.ooooo.j1;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O0O0O;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.o0OO000o;
import com.ubixnow.ooooo.oO00000o;
import com.ubixnow.ooooo.ooooO000;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class GdtInitManager extends o00O0O0O {
    private static GdtInitManager OooO0o0;

    private void OooO00o() {
        try {
            GlobalSetting.setEnableCollectAppInstallStatus(j1.OooO0oo);
            GlobalSetting.setAgreeReadAndroidId(j1.OooO0OO);
            GlobalSetting.setAgreeReadDeviceId(j1.OooO0O0);
            HashMap map = new HashMap();
            if (!j1.OooO0o0) {
                map.put(o0OO000o.o00OoOo, Boolean.FALSE);
            }
            if (!j1.OooO00o) {
                map.put("cell_id", Boolean.FALSE);
            }
            GlobalSetting.setAgreeReadPrivacyInfo(map);
            HashMap map2 = new HashMap();
            map2.put("hieib", Boolean.FALSE);
            GlobalSetting.setConvOptimizeInfo(map2);
            HashMap map3 = new HashMap();
            map3.put("sensor_ts", oO00000o.o00O0O.OooOOOo ? "1" : "0");
            GlobalSetting.setExtraUserData(map3);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static synchronized GdtInitManager getInstance() {
        if (OooO0o0 == null) {
            OooO0o0 = new GdtInitManager();
        }
        return OooO0o0;
    }

    public String getName() {
        return MSAdConfig.PLATFORM_GDT;
    }

    @Override // com.ubixnow.ooooo.o00O0O0O
    public String getVersion() {
        try {
            return SDKStatus.getSDKVersion();
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

    /* JADX WARN: Code duplicated, block: B:23:0x0080 A[Catch: all -> 0x0088, TRY_LEAVE, TryCatch #1 {all -> 0x0088, blocks: (B:5:0x0008, B:7:0x0022, B:21:0x007a, B:23:0x0080, B:15:0x0055, B:17:0x006e, B:20:0x0077, B:19:0x0074, B:12:0x002e), top: B:36:0x0008, outer: #2, inners: #0 }] */
    @Override // com.ubixnow.ooooo.o00O0O0O
    public synchronized void initSDK(Context context, final o00O000 o00o000, final o00O0OO0 o00o0oo0) {
        super.initSDK(context, o00o000, o00o0oo0);
        try {
            ooooO000.OooO0O0("-----Gdt----init", "appid: " + o00o000.OooO00o.OooO0Oo);
            if (isNeedInit(o00o000)) {
                trackSdkInitStart(o00o000);
                OooO00o();
                try {
                    GDTAdSdk.class.getDeclaredMethod("initWithoutStart", Context.class, String.class);
                    GDTAdSdk.initWithoutStart(StubApp.getOrigApplicationContext(context.getApplicationContext()), o00o000.OooO00o.OooO0Oo);
                    GDTAdSdk.start(new GDTAdSdk.OnStartListener() { // from class: com.ubixnow.network.gdt.GdtInitManager.1
                        @Override // com.qq.e.comm.managers.GDTAdSdk.OnStartListener
                        public void onStartFailed(Exception exc) {
                            GdtInitManager.this.trackingAdsInitFail(o00o000, "500041", exc.getMessage());
                            o00O0OO0 o00o0oo1 = o00o0oo0;
                            if (o00o0oo1 != null) {
                                o00o0oo1.onError(exc);
                            }
                        }

                        @Override // com.qq.e.comm.managers.GDTAdSdk.OnStartListener
                        public void onStartSuccess() {
                            GdtInitManager.this.OooO0O0 = true;
                            GdtInitManager.this.trackingAdsInitSucc(o00o000);
                            if (o00o0oo0 != null) {
                                GdtInitManager.this.trackRedirectStart(o00o000);
                                o00o0oo0.onSuccess();
                            }
                        }
                    });
                } catch (Throwable th) {
                    ooooO000.OooO00o(th);
                    GDTAdSdk.init(StubApp.getOrigApplicationContext(context.getApplicationContext()), o00o000.OooO00o.OooO0Oo);
                    this.OooO0O0 = true;
                    trackingAdsInitSucc(o00o000);
                    if (o00o0oo0 != null) {
                        trackRedirectStart(o00o000);
                        o00o0oo0.onSuccess();
                    }
                }
                if (j1.OooOOo0 != this.OooO0OO) {
                    OooO00o();
                    this.OooO0OO = j1.OooOOo0;
                }
            } else if (o00o0oo0 != null) {
                trackRedirectStart();
                o00o0oo0.onSuccess();
                if (j1.OooOOo0 != this.OooO0OO) {
                    OooO00o();
                    this.OooO0OO = j1.OooOOo0;
                }
            } else if (j1.OooOOo0 != this.OooO0OO) {
                OooO00o();
                this.OooO0OO = j1.OooOOo0;
            }
        } catch (Throwable th2) {
            trackingAdsInitFail(o00o000, "-1", th2.getMessage());
            th2.printStackTrace();
            if (o00o0oo0 != null) {
                o00o0oo0.onError(th2);
            }
        }
    }
}
