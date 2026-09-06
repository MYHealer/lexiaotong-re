package com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.bytedance.msdk.adapter.gdt.GdtAdapterConfiguration;
import com.bytedance.msdk.adapter.gdt.base.config.MediationInitConfig;
import com.bytedance.msdk.adapter.gdt.base.utils.MediationApiLog;
import com.qq.e.ads.dfa.GDTAppDialogClickListener;
import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.managers.status.SDKStatus;
import com.ubixnow.ooooo.o0OO000o;
import com.umeng.analytics.pro.o;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f3225a;
    private MediationInitConfig b;

    private Map<String, Object> b(final Map map) {
        try {
            Map<String, Object> map2 = (Map) n.a(new Callable<Map<String, Object>>() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.i.7
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Map<String, Object> call() {
                    return i.this.c(map);
                }
            }).get(1000L, TimeUnit.MILLISECONDS);
            if (map2 != null) {
                return map2;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, GdtAdapterConfiguration gdtAdapterConfiguration, MediationInitConfig mediationInitConfig) {
        if (mediationInitConfig == null) {
            gdtAdapterConfiguration.notifyFail("gdt init fail");
        }
        if (!c(context, gdtAdapterConfiguration, mediationInitConfig)) {
            gdtAdapterConfiguration.notifyFail("gdt init fail");
        } else {
            gdtAdapterConfiguration.setInitSuccess(true);
            gdtAdapterConfiguration.notifySuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> c(Map map) {
        if (map != null) {
            try {
                HashMap map2 = new HashMap();
                String str = (String) map.get("slot_id");
                String buyerId = GDTAdSdk.getGDTAdManger().getBuyerId(null);
                String sDKInfo = GDTAdSdk.getGDTAdManger().getSDKInfo(str);
                map2.put("buyerId", buyerId);
                map2.put("sdkInfo", sDKInfo);
                return map2;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    private boolean c(Context context, final GdtAdapterConfiguration gdtAdapterConfiguration, MediationInitConfig mediationInitConfig) {
        if (context != null && mediationInitConfig != null) {
            try {
                if (!TextUtils.isEmpty(mediationInitConfig.getAppId())) {
                    final long jCurrentTimeMillis = System.currentTimeMillis();
                    GDTAdSdk.initWithoutStart(context, mediationInitConfig.getAppId());
                    GDTAdSdk.start(new GDTAdSdk.OnStartListener() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.i.2
                        @Override // com.qq.e.comm.managers.GDTAdSdk.OnStartListener
                        public void onStartFailed(Exception exc) {
                            gdtAdapterConfiguration.notifyInitTime(0, jCurrentTimeMillis, System.currentTimeMillis());
                        }

                        @Override // com.qq.e.comm.managers.GDTAdSdk.OnStartListener
                        public void onStartSuccess() {
                            gdtAdapterConfiguration.notifyInitTime(1, jCurrentTimeMillis, System.currentTimeMillis());
                        }
                    });
                    b(mediationInitConfig);
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d() {
        try {
            return GDTAdSdk.getGDTAdManger().showOpenOrInstallAppDialog(new GDTAppDialogClickListener() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.i.4
                @Override // com.qq.e.ads.dfa.GDTAppDialogClickListener
                public void onButtonClick(int i) {
                    if (i.this.b == null || i.this.b.getInitCallback() == null) {
                        return;
                    }
                    SparseArray<Object> sparseArray = new SparseArray<>();
                    sparseArray.put(-99999987, Integer.valueOf(o.a.B));
                    sparseArray.put(-99999985, Void.class);
                    sparseArray.put(8095, Integer.valueOf(i));
                    i.this.b.getInitCallback().apply(sparseArray);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    private int e() {
        try {
            Integer num = (Integer) n.a(new Callable<Integer>() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.i.5
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Integer call() {
                    return Integer.valueOf(i.this.d());
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            if (num != null) {
                return num.intValue();
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String f() {
        return SDKStatus.getIntegrationSDKVersion();
    }

    public int a() {
        return (this.f3225a || this.b == null) ? e() : d();
    }

    public Map<String, Object> a(Map map) {
        return (this.f3225a || this.b == null) ? b(map) : c(map);
    }

    public void a(final Context context, final GdtAdapterConfiguration gdtAdapterConfiguration, final MediationInitConfig mediationInitConfig) {
        this.b = mediationInitConfig;
        boolean zB = a.b(mediationInitConfig);
        this.f3225a = zB;
        if (zB) {
            n.a(new Runnable() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.i.1
                @Override // java.lang.Runnable
                public void run() {
                    i.this.b(context, gdtAdapterConfiguration, mediationInitConfig);
                }
            });
        } else {
            b(context, gdtAdapterConfiguration, mediationInitConfig);
        }
    }

    public void a(final MediationInitConfig mediationInitConfig) {
        if (this.f3225a) {
            n.a(new Runnable() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.i.3
                @Override // java.lang.Runnable
                public void run() {
                    i.this.b(mediationInitConfig);
                }
            });
        } else {
            b(mediationInitConfig);
        }
    }

    public String b() {
        return (this.f3225a || this.b == null) ? c() : f();
    }

    public void b(MediationInitConfig mediationInitConfig) {
        if (mediationInitConfig == null) {
            return;
        }
        a.a(mediationInitConfig);
        boolean zIsLimitPersonalAds = mediationInitConfig.isLimitPersonalAds();
        boolean zIsCanUseMacAddress = mediationInitConfig.isCanUseMacAddress();
        boolean zIsCanUsePhoneState = mediationInitConfig.isCanUsePhoneState();
        boolean zIsCanUseAndroidId = mediationInitConfig.isCanUseAndroidId();
        boolean zIsCanUseLocation = mediationInitConfig.isCanUseLocation();
        boolean zA = a.a(mediationInitConfig, "netop", true);
        boolean zA2 = a.a(mediationInitConfig, "mipaddr", true);
        boolean zA3 = a.a(mediationInitConfig, "wipaddr", true);
        HashMap map = new HashMap();
        map.put(o0OO000o.o00OoOo, Boolean.valueOf(zIsCanUseMacAddress));
        map.put("android_id", Boolean.valueOf(zIsCanUseAndroidId));
        map.put("device_id", Boolean.valueOf(zIsCanUsePhoneState));
        map.put("cell_id", Boolean.valueOf(zIsCanUseLocation));
        map.put("netop", Boolean.valueOf(zA));
        map.put("mipaddr", Boolean.valueOf(zA2));
        map.put("wipaddr", Boolean.valueOf(zA3));
        map.put("ssid", Boolean.valueOf(mediationInitConfig.isCanUseWifiState()));
        map.put("bssid", Boolean.valueOf(mediationInitConfig.isCanUseWifiState()));
        map.put("oaid", Boolean.valueOf(mediationInitConfig.isCanUseOaid()));
        map.put("taid", Boolean.valueOf(a.a(mediationInitConfig, "taid", true)));
        MediationApiLog.i("gdt setAgreeReadPrivacyInfo=" + map);
        GlobalSetting.setAgreeReadPrivacyInfo(map);
        GlobalSetting.setEnableCollectAppInstallStatus(mediationInitConfig.appList());
        GlobalSetting.setPersonalizedState(zIsLimitPersonalAds ? 1 : 0);
        boolean zA4 = a.a(mediationInitConfig, "motion_info", true);
        HashMap map2 = new HashMap();
        map2.put("sensor_ts", zA4 ? "1" : "0");
        GlobalSetting.setExtraUserData(map2);
        boolean zA5 = a.a(mediationInitConfig, "installUninstallListen", true);
        boolean zA6 = a.a(mediationInitConfig, "soate", true);
        HashMap map3 = new HashMap();
        map3.put("hieib", Boolean.valueOf(zA5));
        map3.put("soate", Boolean.valueOf(zA6));
        GlobalSetting.setConvOptimizeInfo(map3);
        Log.i("Tme", "gdt c:" + zIsCanUseLocation + " n:" + zA + " m:" + zA2 + " w:" + zA3 + " s&b:" + mediationInitConfig.isCanUseWifiState() + " h:" + zA5 + " a:" + mediationInitConfig.appList() + "  s:" + zA4 + " ic:" + this.f3225a + " soate:" + zA6);
    }

    public String c() {
        try {
            String str = (String) n.a(new Callable<String>() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.i.6
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public String call() {
                    return i.this.f();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            return str != null ? str : "0.0";
        } catch (Exception e) {
            e.printStackTrace();
            return "0.0";
        }
    }
}
