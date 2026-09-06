package com.adprof.sdk;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.os.Looper;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import com.adprof.sdk.api.AdError;
import com.adprof.sdk.api.AdprofSdkConfig;
import com.adprof.sdk.api.InitCallback;
import com.adprof.sdk.xb.a;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AdprofSdk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile AdprofSdk f1018a;
    public static final AtomicBoolean sInitResult = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f0a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AdprofSdkConfig f1a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3a = true;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f2a = BuildConfig.buildTs;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f1019a;

        public a(long j) {
            this.f1019a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                AdprofSdk adprofSdk = AdprofSdk.this;
                long j = this.f1019a;
                AdprofSdk adprofSdk2 = AdprofSdk.f1018a;
                adprofSdk.a(j);
            } catch (Throwable th) {
                AdprofSdk adprofSdk3 = AdprofSdk.this;
                AdprofSdk adprofSdk4 = AdprofSdk.f1018a;
                adprofSdk3.a(th);
            }
        }
    }

    public static AdprofSdk getInstance() {
        if (f1018a == null) {
            synchronized (AdprofSdk.class) {
                if (f1018a == null) {
                    f1018a = new AdprofSdk();
                }
            }
        }
        return f1018a;
    }

    public static String getNetworkName() {
        return "Adprof";
    }

    public static String getVersionName() {
        return BuildConfig.VERSION_NAME;
    }

    public final void a() {
        pk.a("initSuccBack " + this.f1a.initCallback);
        InitCallback initCallback = this.f1a.initCallback;
        if (initCallback != null) {
            initCallback.onSuccess();
        }
    }

    public final void a(long j) {
        boolean zIsCleartextTrafficPermitted;
        if (!TextUtils.isEmpty(this.f1a.userId)) {
            String str = this.f1a.userId;
            AtomicInteger atomicInteger = he.f346a;
            TextUtils.isEmpty(str);
        }
        Handler handler = nn.f1329a;
        new mn("ThreadPoolHelper.scheduleHandler").start();
        Context context = this.f0a;
        File cacheDir = context.getCacheDir();
        File externalCacheDir = context.getExternalCacheDir();
        File file = new File(cacheDir, "afs");
        if (!file.exists()) {
            file.mkdirs();
        }
        k1.f415a = file.getAbsolutePath();
        File file2 = new File(externalCacheDir, "afs");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        k1.b = file2.getAbsolutePath();
        String strReplace = "\n initSDKCacheFolder cachePath = " + k1.f415a + "   deviceuid    = " + c8.a().m587a() + "    \n";
        if (pk.b() && strReplace != null && !strReplace.isEmpty()) {
            if (strReplace.length() > 3072) {
                while (strReplace.length() > 3072) {
                    String strSubstring = strReplace.substring(0, 3072);
                    strReplace = strReplace.replace(strSubstring, "");
                    Log.d("adprofsdk", strSubstring);
                }
            }
            Log.d("adprofsdk", strReplace);
        }
        Context context2 = this.f0a;
        HashSet hashSet = ig.f383a;
        hashSet.add("https://sdkconf.buluken.com/sdk_config/v3/config");
        hashSet.add(z1.a().m734a());
        ig.f385c = sl.a().getString("user-agent-cache", ig.f382a);
        ig.a(context2);
        if (ig.c == null) {
            synchronized (ig.class) {
                if (ig.c == null) {
                    ig.c = new a3(new c6(new oi(i7.a(10000))), 1, 2);
                }
            }
        }
        if (ig.b == null) {
            synchronized (ig.class) {
                if (ig.b == null) {
                    ig.b = new a3(new c9(new oi(i7.a(10000)), new p6(4096)), 1, 6);
                }
            }
        }
        if (ig.e == null) {
            synchronized (ig.class) {
                if (ig.e == null) {
                    ig.e = new a3(new c6(new oi(i7.a(10000))), 2, Integer.MAX_VALUE, new v8(new Handler(Looper.getMainLooper())));
                }
            }
        }
        if (ig.d == null) {
            synchronized (ig.class) {
                if (ig.d == null) {
                    ig.d = new a3(new c6(new oi(i7.a(10000))), 2, 10);
                }
            }
        }
        if (ig.f380a == null) {
            synchronized (ig.class) {
                if (ig.f380a == null) {
                    ig.f380a = new ae(ig.b, context2, new hg(new gg(g8.a(context2))));
                }
            }
        }
        if (ig.f == null) {
            synchronized (ig.class) {
                if (ig.f == null) {
                    c6 c6Var = new c6(new oi(i7.a(10000)));
                    if (ig.f381a == null && ig.f381a == null) {
                        ig.f381a = new jg();
                    }
                    ig.f = new a3(c6Var, 1, 10);
                }
            }
        }
        if (ig.f1231a == null) {
            synchronized (ig.class) {
                if (ig.f1231a == null) {
                    ig.f1231a = new a3(new c6(new oi(i7.a(10000))), 2, 5);
                }
            }
        }
        try {
            zIsCleartextTrafficPermitted = NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
        } catch (Exception unused) {
            zIsCleartextTrafficPermitted = true;
        }
        bg.f1092a = zIsCleartextTrafficPermitted;
        pk.a("sCleartextTrafficPermitted = " + bg.f1092a);
        he.m644a().a(this.f0a);
        if (l.f1274a == null) {
            synchronized (l.class) {
                if (l.f1274a == null) {
                    l.f1274a = new l();
                }
            }
        }
        sh shVarA = sh.a();
        boolean zIsPersonalizedAdvertisingOn = getInstance().isPersonalizedAdvertisingOn();
        if (shVarA.f722a == null) {
            shVarA.f722a = Boolean.valueOf(zIsPersonalizedAdvertisingOn);
        }
        z1 z1VarA = z1.a();
        Handler handler2 = z1VarA.f889a;
        if (handler2 != null) {
            handler2.removeCallbacks(z1VarA.f890a);
        }
        Handler handler3 = z1VarA.f889a;
        if (handler3 != null) {
            handler3.post(z1VarA.f890a);
        }
        try {
            il.a("download_service", true);
        } catch (Throwable th) {
            pk.b("initDownloadService fail", th);
        }
        try {
            il.a("appinstall_service", true);
        } catch (Throwable th2) {
            pk.b("initAppInstallService fail", th2);
        }
        AdprofSdkConfig sdkConfig = getInstance().getSdkConfig();
        if (sdkConfig == null || sdkConfig.collectCrashInfo) {
            fc.b();
        }
        xn xnVar = xn.f1525a;
        xnVar.f845a = new dc();
        xnVar.b();
        in.a().a(new ec());
        sInitResult.set(true);
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        fh fhVar = new fh();
        ((mh) fhVar).f468b = "100";
        fhVar.a("init");
        fhVar.f294a = jCurrentTimeMillis;
        HashMap map = new HashMap();
        try {
            Map<String, Object> customData = getInstance().getCustomData();
            if (customData != null && !customData.isEmpty()) {
                String[] strArr = ld.f443a;
                String strA = ld.a(customData, new HashMap(), null, false, false);
                if (!TextUtils.isEmpty(strA)) {
                    map.put("c_data", strA);
                    ((mh) fhVar).f467a = map;
                }
            }
        } catch (Throwable th3) {
            pk.b("trackInitEvent", th3);
            oh.b(th3);
        }
        map.put("is_p", getInstance().isPersonalizedAdvertisingOn() ? "0" : "1");
        z1.a().getClass();
        map.put("is_new", "0");
        ((mh) fhVar).f467a = map;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("app_label", getInstance().getContext().getApplicationInfo().loadLabel(getInstance().getContext().getPackageManager()).toString());
            if (!bg.f1092a) {
                jSONObject.put("https", 1);
            }
            ((mh) fhVar).f469c = jSONObject.toString();
        } catch (Exception e) {
            pk.b("trackInitEvent", e);
            oh.b(e);
        }
        oh.a(fhVar);
        fhVar.mo685a();
        a();
    }

    public final void a(Throwable th) {
        AdprofSdkConfig adprofSdkConfig = this.f1a;
        if (adprofSdkConfig != null && adprofSdkConfig.initCallback != null) {
            pk.a("invoke init callback failed");
            this.f1a.initCallback.onFail(AdError.ERROR_AD_INIT_FAIL.getErrorCode(), th.getMessage());
        }
        pk.b("init exception", th);
        oh.b(th);
    }

    public void finalize() throws Throwable {
        super.finalize();
        try {
            if (f1018a == null || f1018a.f0a == null) {
                return;
            }
            Context context = f1018a.f0a;
            if (g8.f308a != null && g8.f314a) {
                try {
                    ConnectivityManager connectivityManagerM634a = g8.m634a(context);
                    if (connectivityManagerM634a != null) {
                        connectivityManagerM634a.unregisterNetworkCallback(g8.f308a);
                    }
                    g8.f314a = false;
                    g8.f308a = null;
                    pk.a("Network callback unregistered successfully");
                } catch (Throwable th) {
                    pk.b("Failed to unregister network callback: ", th);
                }
            }
            pk.a("AdprofSdk cleanup completed");
        } catch (Throwable th2) {
            pk.b("AdprofSdk cleanup error: ", th2);
        }
    }

    public String getAppId() {
        AdprofSdkConfig adprofSdkConfig = this.f1a;
        return adprofSdkConfig != null ? adprofSdkConfig.appId : "";
    }

    public String getAppSecret() {
        AdprofSdkConfig adprofSdkConfig = this.f1a;
        return adprofSdkConfig != null ? adprofSdkConfig.appSecret : "";
    }

    public Context getContext() {
        Context context = this.f0a;
        if (context != null) {
            return StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        return null;
    }

    public Map<String, Object> getCustomData() {
        AdprofSdkConfig adprofSdkConfig = this.f1a;
        if (adprofSdkConfig != null) {
            return adprofSdkConfig.customData;
        }
        return null;
    }

    public HashMap<String, Object> getInfo() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("oaid", he.m644a().i());
        if (!TextUtils.isEmpty(he.m644a().m647a())) {
            map.put("aid", he.m644a().m647a());
        }
        if (!TextUtils.isEmpty(he.m644a().f())) {
            map.put("imei", he.m644a().f());
        }
        return map;
    }

    public AdprofSdkConfig getSdkConfig() {
        return this.f1a;
    }

    public synchronized void init(Context context, AdprofSdkConfig adprofSdkConfig) {
        StringBuilder sbAppend = new StringBuilder("---sdk init  ").append(this.f2a).append("  ");
        AtomicBoolean atomicBoolean = sInitResult;
        pk.a("Adprof SDK", sbAppend.append(atomicBoolean).append(PPSLabelView.Code).append(adprofSdkConfig).toString());
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            if (context == null || adprofSdkConfig == null) {
                throw new RuntimeException("init context or config is null");
            }
            this.f1a = adprofSdkConfig;
            this.f0a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (atomicBoolean.get()) {
                a();
                return;
            }
            pk.a("==== enter AdprofSdk init method ====== ");
            if (!TextUtils.isEmpty(this.f1a.appId) && !TextUtils.isEmpty(this.f1a.appSecret)) {
                pk.a(" app_id =  " + this.f1a.appId + "  app_secret = " + this.f1a.appSecret);
                if (this.f1a.initOnWorkerThread) {
                    new Thread(new a(jCurrentTimeMillis)).start();
                    return;
                } else {
                    a(jCurrentTimeMillis);
                    return;
                }
            }
            InitCallback initCallback = this.f1a.initCallback;
            if (initCallback != null) {
                initCallback.onFail(AdError.ERROR_AD_INIT_FAIL.getErrorCode(), "appId appSecret 都不能为空");
            }
        } catch (Throwable th) {
            a(th);
        }
    }

    public boolean isInit() {
        return sInitResult.get();
    }

    public boolean isPersonalizedAdvertisingOn() {
        return this.f3a;
    }

    public void loadImage(String str, ImageView imageView) {
        try {
            if (isInit() && !TextUtils.isEmpty(str) && imageView != null) {
                xb xbVarA = xb.a(getInstance().getContext());
                xbVarA.getClass();
                xbVarA.new a(str).a(imageView);
            }
        } catch (Throwable th) {
            pk.b("AdprofSdk: loadImage error", th);
            oh.b(th);
        }
    }

    public void report(Throwable th) {
        if (isInit()) {
            oh.b(th);
        }
    }

    public void setPersonalRecommend(boolean z) {
        boolean z2 = this.f3a != z;
        this.f3a = z;
        if (sInitResult.get() && z2) {
            sh shVarA = sh.a();
            if (shVarA.f722a == null) {
                shVarA.f722a = Boolean.valueOf(z);
            }
        }
    }
}
