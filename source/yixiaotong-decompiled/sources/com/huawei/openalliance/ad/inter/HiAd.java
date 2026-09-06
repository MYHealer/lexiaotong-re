package com.huawei.openalliance.ad.inter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.ads.InformationController;
import com.huawei.hms.ads.ReportUrlListener;
import com.huawei.hms.ads.RequestOptions;
import com.huawei.hms.ads.consent.inter.Consent;
import com.huawei.hms.ads.dd;
import com.huawei.hms.ads.de;
import com.huawei.hms.ads.ej;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.je;
import com.huawei.openalliance.ad.constant.ai;
import com.huawei.openalliance.ad.constant.bf;
import com.huawei.openalliance.ad.constant.s;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.listeners.AppDownloadListener;
import com.huawei.openalliance.ad.inter.listeners.ExtensionActionListener;
import com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.media.IMultiMediaPlayingManager;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.aj;
import com.huawei.openalliance.ad.utils.al;
import com.huawei.openalliance.ad.utils.au;
import com.huawei.openalliance.ad.utils.az;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.bg;
import com.huawei.openalliance.ad.utils.bj;
import com.huawei.openalliance.ad.utils.u;
import com.huawei.openalliance.ad.utils.z;
import com.stub.StubApp;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class HiAd implements IHiAd {
    private static final byte[] B = new byte[0];
    private static final String I = "hw_sc.build.os.enable";
    private static final String V = "HiAd";
    private static HiAd Z;
    private Context C;
    private IMultiMediaPlayingManager D;
    private AppDownloadListener L;
    private ej S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IAppDownloadManager f4459a;
    private ExtensionActionListener b;
    private Integer d;
    private boolean e;
    private Boolean f;
    private ReportUrlListener g;
    private boolean h;
    private Map<BroadcastReceiver, IntentFilter> F = new HashMap();
    private int c = -1;
    private BroadcastReceiver i = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.inter.HiAd.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                try {
                    if (intent.getExtras() != null) {
                        if (intent.getExtras().getBoolean(x.bs)) {
                            HiAd.this.e = true;
                            je.Code();
                        } else {
                            HiAd.this.e = false;
                        }
                    }
                } catch (Throwable th) {
                    fh.I(HiAd.V, "onReceive error:" + th.getClass().getSimpleName());
                }
            }
        }
    };
    private BroadcastReceiver j = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.inter.HiAd.9
        @Override // android.content.BroadcastReceiver
        public void onReceive(final Context context, final Intent intent) {
            if (intent == null) {
                return;
            }
            bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.9.1
                @Override // java.lang.Runnable
                public void run() {
                    String action = intent.getAction();
                    for (Map.Entry entry : HiAd.this.F.entrySet()) {
                        BroadcastReceiver broadcastReceiver = (BroadcastReceiver) entry.getKey();
                        IntentFilter intentFilter = (IntentFilter) entry.getValue();
                        if (intentFilter != null && intentFilter.matchAction(action)) {
                            broadcastReceiver.onReceive(context, intent);
                        }
                    }
                }
            });
        }
    };
    RequestOptions Code = new RequestOptions.Builder().build();

    private static class a implements SensorEventListener {
        private a() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
        }
    }

    private static class b implements RemoteCallResultCallback<String> {
        private b() {
        }

        @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
        public void onRemoteCallResult(String str, CallResult<String> callResult) {
            if (callResult.getCode() == 200) {
                fh.Code(HiAd.V, "success: set install permission in hms, %s", str);
            } else {
                fh.I(HiAd.V, "error: set install permission in hms, %s", str);
            }
        }
    }

    private static class c implements Runnable {
        private final AppDownloadListener Code;

        c(AppDownloadListener appDownloadListener) {
            this.Code = appDownloadListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.huawei.openalliance.ad.download.a.Code().Code(this.Code);
        }
    }

    private HiAd(Context context) {
        this.h = false;
        this.C = StubApp.getOrigApplicationContext(context.getApplicationContext());
        L();
        a();
        this.S = ej.Code(this.C);
        b();
        ba.Code(this.C);
        S();
        if (isEnableUserInfo()) {
            if (!this.h) {
                I(context);
                this.h = true;
            }
            D();
        }
        F();
    }

    public static boolean C() {
        String strCode = bg.Code(I);
        if (fh.Code()) {
            fh.Code(V, "hmftype: %s", strCode);
        }
        return Boolean.parseBoolean(strCode);
    }

    public static HiAd Code(Context context) {
        return V(context);
    }

    public static IHiAd Code() {
        return Z;
    }

    private static <T> void Code(final Context context, final AdContentData adContentData, final String str, final ReportUrlListener reportUrlListener, final boolean z) {
        fh.Code(V, "reportMediaBackBiddingResult");
        com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(bf.at, ad.V(adContentData));
                    jSONObject.put("url", str);
                    jSONObject.put(bf.aW, z);
                    if (fh.Code()) {
                        fh.Code(HiAd.V, "Media pkgName is %s,url is %s", context.getPackageName(), str);
                    }
                    com.huawei.openalliance.ad.ipc.g.V(context).Code(s.P, jSONObject.toString(), new RemoteCallResultCallback<T>() { // from class: com.huawei.openalliance.ad.inter.HiAd.4.1
                        @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                        public void onRemoteCallResult(String str2, CallResult<T> callResult) {
                            String str3;
                            if (callResult.getCode() == 200) {
                                if (reportUrlListener != null) {
                                    reportUrlListener.reportSuccess();
                                }
                                str3 = "report media bidding result to server is success";
                            } else {
                                if (reportUrlListener != null) {
                                    reportUrlListener.reportFailed(str, callResult.getCode());
                                }
                                str3 = "report media bidding result to server is fail";
                            }
                            fh.V(HiAd.V, str3);
                        }
                    }, null);
                } catch (JSONException e) {
                    fh.I(HiAd.V, "reportMediaBackBiddingResult err: %s", e.getClass().getSimpleName());
                }
            }
        });
    }

    private void Code(final String str) {
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.10
            @Override // java.lang.Runnable
            public void run() {
                Object objCode;
                Class clsCode = au.Code("com.huawei.openalliance.ad.inter.p");
                if (clsCode == null || (objCode = au.Code(null, clsCode, "getInstance", new Class[]{Context.class}, new Object[]{HiAd.this.C})) == null) {
                    return;
                }
                au.Code(objCode, clsCode, str, null, null);
            }
        });
    }

    private void D() {
        com.huawei.openalliance.ad.utils.i.V(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.7
            @Override // java.lang.Runnable
            public void run() {
                int iAf = HiAd.this.S.af();
                boolean zV = com.huawei.openalliance.ad.utils.q.V(HiAd.this.C);
                fh.V(HiAd.V, "preRequest, type: %s, isTv: %s", Integer.valueOf(iAf), Boolean.valueOf(zV));
                if (iAf != 0 || zV) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(bf.ag, iAf);
                        jSONObject.put(bf.ah, zV);
                        com.huawei.openalliance.ad.ipc.g.V(StubApp.getOrigApplicationContext(HiAd.this.C.getApplicationContext())).Code("preRequest", jSONObject.toString(), null, null);
                    } catch (JSONException unused) {
                        fh.I(HiAd.V, "preRequest error.");
                    }
                }
            }
        });
    }

    private void F() {
        com.huawei.openalliance.ad.utils.i.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.6
            @Override // java.lang.Runnable
            public void run() {
                de.Code(HiAd.this.C);
                com.huawei.hms.ads.h.Code(HiAd.this.C);
                com.huawei.openalliance.ad.utils.d.e(HiAd.this.C);
            }
        });
    }

    private void I(Context context) {
        try {
            SensorManager sensorManager = (SensorManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("sensor");
            Sensor defaultSensor = sensorManager.getDefaultSensor(1);
            Object[] objArr = new Object[1];
            objArr[0] = defaultSensor == null ? "null" : "not null";
            fh.Code(V, "registerAccSensor, sensor is %s.", objArr);
            if (defaultSensor != null) {
                a aVar = new a();
                fh.Code(V, "registerAccSensor, register sm");
                sensorManager.registerListener(aVar, defaultSensor, 3);
                sensorManager.unregisterListener(aVar);
            }
        } catch (Throwable th) {
            fh.I(V, "registerAccSensor, err: %s", th.getClass().getSimpleName());
        }
    }

    private void L() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        z.Code(this.C, this.j, intentFilter);
    }

    private void S() {
        if (z.C()) {
            com.huawei.openalliance.ad.utils.i.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.5
                @Override // java.lang.Runnable
                public void run() {
                    Consent.getInstance(HiAd.this.C).getNpaAccordingToServerConsent();
                }
            });
        }
    }

    private static HiAd V(Context context) {
        HiAd hiAd;
        synchronized (B) {
            if (Z == null) {
                Z = new HiAd(context);
            }
            hiAd = Z;
        }
        return hiAd;
    }

    private void Z(Context context) {
        boolean zA = bg.a(context);
        fh.Code(V, "has install permission is: %s", Boolean.valueOf(zA));
        com.huawei.openalliance.ad.download.app.c.V(StubApp.getOrigApplicationContext(context.getApplicationContext()), zA, new b(), String.class);
    }

    private void a() {
        fh.Code(V, "registerUSBObserver");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(x.br);
        z.Code(this.C, this.i, intentFilter);
    }

    private void b() {
        com.huawei.openalliance.ad.download.app.g.Code(this.C);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        d();
        e();
    }

    private void d() {
        String str = az.Z(this.C) + File.separator + x.k + File.separator;
        if (bc.Code(str)) {
            return;
        }
        u.Code(str);
    }

    public static void disableUserInfo(Context context) {
        Log.i(V, "disableUserInfo, context ".concat(context == null ? "is null" : "not null"));
        if (context == null) {
            return;
        }
        ej.Code(context).Code(false);
        getInstance(context).enableUserInfo(false);
    }

    private void e() {
        String str = az.B(this.C) + File.separator + x.k + File.separator;
        if (bc.Code(str)) {
            return;
        }
        u.Code(str);
    }

    private ReportUrlListener f() {
        return this.g;
    }

    public static IHiAd getInstance(Context context) {
        return V(context);
    }

    public boolean B() {
        return this.e;
    }

    public void Code(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver == null) {
            return;
        }
        this.F.remove(broadcastReceiver);
    }

    public void Code(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (broadcastReceiver == null) {
            return;
        }
        this.F.put(broadcastReceiver, intentFilter);
    }

    public IMultiMediaPlayingManager I() {
        IMultiMediaPlayingManager iMultiMediaPlayingManager = this.D;
        return iMultiMediaPlayingManager != null ? iMultiMediaPlayingManager : com.huawei.openalliance.ad.media.c.Code(this.C);
    }

    public AppDownloadListener V() {
        return this.L;
    }

    public Integer Z() {
        return this.d;
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void enableSharePd(boolean z) {
        if (z.Code(this.C)) {
            this.S.V(z);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void enableUserInfo(boolean z) {
        if (z.Code(this.C)) {
            this.S.Code(z);
            if (!z) {
                com.huawei.openalliance.ad.utils.i.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.8
                    @Override // java.lang.Runnable
                    public void run() {
                        HiAd.this.c();
                    }
                });
            } else {
                if (this.h) {
                    return;
                }
                I(this.C);
                this.h = true;
            }
        }
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public int getAppActivateStyle() {
        return ej.Code(this.C).ab();
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public IAppDownloadManager getAppDownloadManager() {
        if (this.f4459a == null) {
            this.f4459a = (IAppDownloadManager) au.V(x.am);
        }
        return this.f4459a;
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public ExtensionActionListener getExtensionActionListener() {
        return this.b;
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public RequestOptions getRequestConfiguration() {
        return this.Code;
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void informReady() {
        e.Code(this.C).V();
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void initGrs(String str) {
        try {
            fh.V(V, "initGrs, appName: %s", str);
            Class<?> cls = Class.forName("com.huawei.openalliance.ad.ppskit.utils.ServerConfig");
            au.Code(null, cls, "setGrsAppName", new Class[]{String.class}, new Object[]{str});
            au.Code(null, cls, "init", new Class[]{Context.class}, new Object[]{this.C});
        } catch (Throwable unused) {
            fh.I(V, "fail to find ServerConfig in adscore");
        }
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void initGrs(String str, String str2) {
        initGrs(str);
        try {
            fh.V(V, "initGrs, appName: %s, countryCode: %s", str, str2);
            au.Code(null, Class.forName("com.huawei.openalliance.ad.ppskit.utils.ServerConfig"), "setRouterCountryCode", new Class[]{String.class}, new Object[]{str2});
            this.S.Z(str2);
        } catch (Throwable unused) {
            fh.I(V, "fail to find ServerConfig in adscore");
        }
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void initLog(boolean z, int i) {
        initLog(z, i, null);
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void initLog(boolean z, int i, String str) {
        if (z.Code(this.C) && z) {
            aj.Code(this.C, i, str);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public boolean isAppAutoOpenForbidden() {
        return ej.Code(this.C).ae();
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public boolean isAppInstalledNotify() {
        return ej.Code(this.C).aa();
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public boolean isEnableUserInfo() {
        if (z.Code(this.C)) {
            return this.S.g();
        }
        return false;
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public boolean isNewProcess() {
        boolean z = this.c != Process.myPid();
        if (z) {
            this.c = Process.myPid();
        }
        fh.V(V, "isNewProcess:" + z);
        return z;
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public Boolean isOpenWebPageByBrowser() {
        return this.f;
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void onBackground() {
        Code("stopTimer");
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void onForeground() {
        Code("startTimer");
        Context context = this.C;
        if (context != null) {
            Z(context);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void reportSetVideoConfigMedia(AdContentData adContentData, boolean z, boolean z2, int i) {
        dd.Code(this.C, adContentData, z, z2, i);
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void sendBiddingInfo(Map<String, Object> map, AdContentData adContentData, String str, boolean z) {
        if (adContentData == null || al.Code(map) || TextUtils.isEmpty(str)) {
            fh.V(V, "adContentData or biddingUrlInfo or url is null");
        }
        String strCode = new com.huawei.hms.ads.c().Code(map, str);
        ReportUrlListener reportUrlListenerF = f();
        fh.Code(V, "formatUrl is %s", strCode);
        if (z.j(this.C) || !z.B(this.C)) {
            Code(this.C, adContentData, strCode, reportUrlListenerF, z);
            return;
        }
        dd.Code(this.C, adContentData, strCode, z, false);
        if (reportUrlListenerF != null) {
            reportUrlListenerF.reportFailed(strCode, ai.ak);
        }
        fh.V(V, "KIT Version is Low, Report Fail");
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setAppActivateStyle(final int i) {
        com.huawei.openalliance.ad.download.app.c.Code(this.C, isAppInstalledNotify(), i, bf.X, new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.inter.HiAd.2
            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                if (callResult.getCode() == 200) {
                    ej.Code(HiAd.this.C).F(i);
                }
            }
        }, String.class);
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setAppAutoOpenForbidden(final boolean z) {
        fh.V(V, "set app AutoOpenForbidden: " + z);
        com.huawei.openalliance.ad.download.app.c.Code(this.C, z, new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.inter.HiAd.3
            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                if (callResult.getCode() == 200) {
                    fh.V(HiAd.V, "set app AutoOpenForbidden: " + z);
                    ej.Code(HiAd.this.C).Z(z);
                }
            }
        }, String.class);
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setAppDownloadListener(AppDownloadListener appDownloadListener) {
        this.L = appDownloadListener;
        bj.Code(new c(appDownloadListener));
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setAppInstalledNotify(final boolean z) {
        fh.Code(V, "set app installed notify: " + z);
        com.huawei.openalliance.ad.download.app.c.Code(this.C, z, getAppActivateStyle(), "full_screen_notify", new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.inter.HiAd.12
            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                if (callResult.getCode() == 200) {
                    ej.Code(HiAd.this.C).I(z);
                }
            }
        }, String.class);
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setAppMuted(boolean z) {
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setAppVolume(float f) {
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setApplicationCode(String str) {
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setBrand(int i) {
        this.d = Integer.valueOf(i);
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setConsent(final String str) {
        fh.V(V, "set TCF consent string");
        com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.11
            @Override // java.lang.Runnable
            public void run() {
                com.huawei.openalliance.ad.ipc.d.Code(HiAd.this.C).Code(s.o, str, null, null);
            }
        });
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setCountryCode(String str) {
        this.S.Code(str);
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setExtensionActionListener(ExtensionActionListener extensionActionListener) {
        this.b = extensionActionListener;
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setInfoController(InformationController informationController) {
        if (informationController == null) {
            fh.V(V, "param err");
        } else if (informationController.I() == null && informationController.V() == null && informationController.Code() == null) {
            fh.V(V, "no valid value");
        } else {
            com.huawei.openalliance.ad.ipc.b.Code(this.C).Code(s.H, ad.V(informationController), null);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setMultiMediaPlayingManager(IMultiMediaPlayingManager iMultiMediaPlayingManager) {
        this.D = iMultiMediaPlayingManager;
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setOpenWebPageByBrowser(boolean z) {
        this.f = Boolean.valueOf(z);
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setReportUrlListener(ReportUrlListener reportUrlListener) {
        this.g = reportUrlListener;
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setRequestConfiguration(RequestOptions requestOptions) {
        this.Code = requestOptions;
    }
}
