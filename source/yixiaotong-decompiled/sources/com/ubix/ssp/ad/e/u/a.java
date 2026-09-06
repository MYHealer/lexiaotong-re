package com.ubix.ssp.ad.e.u;

import android.content.ContentValues;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.stub.StubApp;
import com.ubix.ssp.ad.e.a0.p;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.ad.e.a0.v;
import com.ubix.ssp.ad.e.w.f;
import com.ubix.ssp.ad.e.x.d;
import com.ubix.ssp.ad.e.y.a.g;
import com.ubix.ssp.open.AdError;
import com.ubix.ssp.open.AdLoadCallbackListener;
import com.ubix.ssp.open.UBiXAdSetting;
import com.ubix.ssp.open.UBiXInitManger;
import com.ubix.ssp.open.manager.InitManager;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a extends UBiXInitManger implements InitManager {
    protected static boolean c = false;
    public static final String d = "a";
    private Context e;

    /* JADX INFO: renamed from: com.ubix.ssp.ad.e.u.a$a, reason: collision with other inner class name */
    class RunnableC1095a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8869a;
        final /* synthetic */ AdLoadCallbackListener b;
        final /* synthetic */ long c;
        final /* synthetic */ long d;

        RunnableC1095a(String str, AdLoadCallbackListener adLoadCallbackListener, long j, long j2) {
            this.f8869a = str;
            this.b = adLoadCallbackListener;
            this.c = j;
            this.d = j2;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            a aVar = a.this;
            aVar.a(aVar.e, this.f8869a);
            a.this.c();
            com.ubix.ssp.ad.e.a0.c.j(StubApp.getOrigApplicationContext(a.this.e.getApplicationContext()));
            a aVar2 = a.this;
            aVar2.a(aVar2.e);
            a.this.a(this.f8869a, this.b);
            f.a(a.this.e).b(this.c);
            f.a(a.this.e).a(SystemClock.elapsedRealtime() - this.d);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f8870a;

        b(Context context) {
            this.f8870a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (TextUtils.isEmpty(com.ubix.ssp.ad.d.b.e)) {
                    return;
                }
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                String[][] strArrA = p.a(this.f8870a);
                HashMap<String, Object> map = new HashMap<>();
                HashMap map2 = new HashMap();
                map2.put("ubix_tx_tag_installed_list", Arrays.toString(strArrA[0]));
                map2.put("ubix_tx_oaid", com.ubix.ssp.ad.d.b.e);
                map.put("EVENT_ATTRS", map2);
                long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                if (jElapsedRealtime2 <= 0) {
                    jElapsedRealtime2 = 0;
                }
                map.put("EVENT_DURATION", Long.valueOf(jElapsedRealtime2));
                f.a(a.this.e).c(map);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class c extends com.ubix.ssp.ad.e.x.a.f {
        final /* synthetic */ String b;
        final /* synthetic */ AdLoadCallbackListener c;

        /* JADX INFO: renamed from: com.ubix.ssp.ad.e.u.a$c$a, reason: collision with other inner class name */
        class RunnableC1096a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ g f8871a;

            /* JADX INFO: renamed from: com.ubix.ssp.ad.e.u.a$c$a$a, reason: collision with other inner class name */
            class RunnableC1097a implements Runnable {
                RunnableC1097a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (com.ubix.ssp.ad.d.b.i != 2) {
                        c.this.c.onSuccess();
                    } else {
                        c.this.c.onError(com.ubix.ssp.ad.e.a0.a0.a.e(9, "SDK功能已经关闭"));
                    }
                }
            }

            RunnableC1096a(g gVar) {
                this.f8871a = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.a(this.f8871a, false);
                    p.b(a.this.e);
                    try {
                        com.ubix.ssp.ad.e.w.q.a.a(a.this.e).a(c.this.b, new String(Base64.encode(com.ubix.ssp.ad.e.y.c.f.a(this.f8871a), 10)));
                    } catch (Exception e) {
                        e.printStackTrace();
                        u.d("缓存没成功，不影响后续流程");
                    }
                    if (c.this.c != null) {
                        com.ubix.ssp.ad.e.a0.b.b(new RunnableC1097a());
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    AdError adErrorF = com.ubix.ssp.ad.e.a0.a0.a.f(6, "空广告体");
                    f.a(a.this.e).a(adErrorF.getErrorCode(), adErrorF.getErrorMessage());
                    AdLoadCallbackListener adLoadCallbackListener = c.this.c;
                    if (adLoadCallbackListener != null) {
                        adLoadCallbackListener.onError(adErrorF);
                    }
                }
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ d f8873a;

            b(d dVar) {
                this.f8873a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                AdError adErrorF;
                String strA;
                int i;
                try {
                    d dVar = this.f8873a;
                    if (dVar != null) {
                        if (dVar.c != 200) {
                            strA = "响应异常，请根据返回码检查问题" + this.f8873a.c;
                            i = 5;
                        } else {
                            Exception exc = dVar.e;
                            if (exc != null) {
                                strA = exc.toString();
                            } else {
                                InputStream inputStream = dVar.b;
                                if (inputStream != null) {
                                    strA = com.ubix.ssp.ad.e.x.a.a(inputStream);
                                } else {
                                    adErrorF = com.ubix.ssp.ad.e.a0.a0.a.f(1, "网络连接异常，请检查网络");
                                }
                            }
                            i = 1;
                        }
                        adErrorF = com.ubix.ssp.ad.e.a0.a0.a.f(i, strA);
                    } else {
                        adErrorF = com.ubix.ssp.ad.e.a0.a0.a.f(2, "请求参数异常，请检查传入的广告参数是否正确");
                    }
                    f.a(a.this.e).a(adErrorF.getErrorCode(), adErrorF.getErrorMessage());
                    AdLoadCallbackListener adLoadCallbackListener = c.this.c;
                    if (adLoadCallbackListener != null) {
                        adLoadCallbackListener.onError(adErrorF);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        c(String str, AdLoadCallbackListener adLoadCallbackListener) {
            this.b = str;
            this.c = adLoadCallbackListener;
        }

        @Override // com.ubix.ssp.ad.e.x.a
        public void a(g gVar) {
            if (gVar != null) {
                com.ubix.ssp.ad.e.a0.c.y();
                com.ubix.ssp.ad.e.a0.c.d.execute(new RunnableC1096a(gVar));
            }
        }

        @Override // com.ubix.ssp.ad.e.x.a
        public void b(d dVar) {
            com.ubix.ssp.ad.e.a0.b.b(new b(dVar));
        }
    }

    public a(Context context) {
        this.e = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        com.ubix.ssp.ad.e.a0.c.y();
        com.ubix.ssp.ad.e.a0.c.d.execute(new b(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str) throws Throwable {
        try {
            String androidId = "";
            com.ubix.ssp.ad.d.b.e = TextUtils.isEmpty(com.ubix.ssp.ad.d.b.a().getOaid()) ? "" : com.ubix.ssp.ad.d.b.a().getOaid();
            if (TextUtils.isEmpty(com.ubix.ssp.ad.d.b.e)) {
                com.ubix.ssp.ad.d.b.e = com.ubix.ssp.ad.e.a0.c0.b.b(context);
            }
            if (!TextUtils.isEmpty(com.ubix.ssp.ad.d.b.a().getAndroidId())) {
                androidId = com.ubix.ssp.ad.d.b.a().getAndroidId();
            }
            com.ubix.ssp.ad.d.b.f = androidId;
            if (TextUtils.isEmpty(com.ubix.ssp.ad.d.b.f)) {
                com.ubix.ssp.ad.d.b.f = com.ubix.ssp.ad.e.a0.c0.b.a(context);
            }
            b(StubApp.getOrigApplicationContext(context.getApplicationContext()), str);
            f.a(this.e).a();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar, boolean z) {
        long j;
        g.b bVar;
        String[] strArr;
        com.ubix.ssp.ad.d.b.i = gVar.b;
        int i = gVar.g;
        if ((i << 1) == 0) {
            i = com.ubix.ssp.ad.d.b.r;
        }
        com.ubix.ssp.ad.d.b.r = i;
        int i2 = gVar.q;
        com.ubix.ssp.ad.d.b.s = i2 > 0 ? ((long) (i2 * 60)) * 1000 : com.ubix.ssp.ad.d.b.s;
        com.ubix.ssp.ad.d.b.t = gVar.i;
        String str = gVar.r;
        if (!TextUtils.isEmpty(str)) {
            v.b(this.e, "ubix_sp_named_wx", "wxid", str);
        }
        com.ubix.ssp.ad.d.b.v = gVar.s;
        com.ubix.ssp.ad.d.b.w = gVar.u;
        com.ubix.ssp.ad.d.b.x = gVar.t;
        com.ubix.ssp.ad.d.b.y = gVar.v;
        com.ubix.ssp.ad.d.b.z = gVar.w;
        if (gVar.z && (strArr = gVar.A) != null && strArr.length > 0) {
            com.ubix.ssp.ad.d.b.j = strArr;
            com.ubix.ssp.ad.d.b.k = gVar.J == 1;
            com.ubix.ssp.ad.d.b.l = gVar.M == 1;
        }
        int i3 = gVar.C;
        if (i3 < 0) {
            i3 = 10;
        }
        com.ubix.ssp.ad.d.b.A = i3;
        com.ubix.ssp.ad.e.b.f8753a = gVar.D;
        int i4 = gVar.G;
        if (i4 == 0) {
            i4 = 2;
        }
        com.ubix.ssp.ad.d.b.C = i4;
        com.ubix.ssp.ad.d.b.D = gVar.H * 1000;
        if (!TextUtils.isEmpty(gVar.E)) {
            try {
                JSONObject jSONObject = new JSONObject(gVar.E);
                if (jSONObject.has("viewRemove")) {
                    com.ubix.ssp.ad.d.b.J = jSONObject.getBoolean("viewRemove");
                }
                if (jSONObject.has("imageMaxCache")) {
                    com.ubix.ssp.ad.d.b.K = jSONObject.getInt("imageMaxCache");
                }
                if (jSONObject.has("gifMaxCache")) {
                    com.ubix.ssp.ad.d.b.L = jSONObject.getInt("gifMaxCache");
                }
                if (jSONObject.has("splashCountDownType")) {
                    com.ubix.ssp.ad.d.b.h = jSONObject.getInt("splashCountDownType");
                }
                if (jSONObject.has("detectWithAdv")) {
                    com.ubix.ssp.ad.d.b.m = jSONObject.getBoolean("detectWithAdv");
                }
            } catch (Throwable unused) {
            }
        }
        com.ubix.ssp.ad.d.b.E = gVar.I;
        com.ubix.ssp.ad.d.b.G = gVar.N;
        int i5 = gVar.O;
        com.ubix.ssp.ad.d.b.H = i5 <= 0 ? com.ubix.ssp.ad.d.b.H : i5 * 60000;
        int i6 = gVar.P;
        com.ubix.ssp.ad.d.b.I = i6 <= 0 ? com.ubix.ssp.ad.d.b.I : i6 * 60000;
        p.c = gVar.n;
        p.d = gVar.p;
        p.e = ((long) gVar.h) * 1000;
        g.c[] cVarArr = gVar.o;
        if (cVarArr != null) {
            p.g = Arrays.asList(cVarArr);
        }
        p.i = ((long) gVar.m) * 1000;
        p.f = gVar.k;
        g.c[] cVarArr2 = gVar.l;
        if (cVarArr2 != null) {
            p.h = Arrays.asList(cVarArr2);
            v.a(this.e, "ubix_sp_castle", "analysis_detect_insert_list", Boolean.TRUE);
        }
        int i7 = gVar.U;
        if (i7 > 0) {
            j = ((long) (i7 * 60)) * 1000;
        } else {
            j = i7 < 0 ? 0L : 2592000000L;
        }
        com.ubix.ssp.ad.d.b.o = j;
        if (!z && (bVar = gVar.d) != null) {
            String str2 = bVar.b;
            if (!TextUtils.isEmpty(str2) && str2.startsWith("http")) {
                v.b(this.e, "ubix_sp_tower1", "request_server_replace_url", str2);
            }
            String str3 = gVar.d.c;
            if (!TextUtils.isEmpty(str3) && str3.startsWith("http")) {
                v.b(this.e, "ubix_sp_tower1", "init_server_replace_url", str3);
            }
        }
        g.a aVar = gVar.e;
        if (aVar != null) {
            f.d = aVar.f;
            if (!z) {
                String str4 = aVar.d;
                if (!TextUtils.isEmpty(str4) && (str4.startsWith("http://") || str4.startsWith("https://"))) {
                    v.b(this.e, "ubix_sp_tower1", "collection_server_url", str4);
                }
            }
            g.a.C1111a c1111a = gVar.e.c;
            if (c1111a != null) {
                f.b = c1111a.c;
                f.c = c1111a.b;
            }
        }
        if (z || gVar.K != 1) {
            return;
        }
        com.ubix.ssp.ad.e.a0.y.d.c.a().a(com.ubix.ssp.ad.e.a0.c.f8631a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, AdLoadCallbackListener adLoadCallbackListener) {
        com.ubix.ssp.ad.e.x.b.a(this.e).a(str, new c(str, adLoadCallbackListener));
    }

    private boolean a() {
        return false;
    }

    private String b() {
        String strD = v.d(this.e, "ubix_sp_beacon", com.alipay.sdk.cons.b.b);
        if (!TextUtils.isEmpty(strD)) {
            if (com.ubix.ssp.ad.e.b.a(com.alipay.sdk.cons.b.b)) {
                com.ubix.ssp.ad.e.a0.c.u();
            }
            return strD;
        }
        if (!com.ubix.ssp.ad.d.b.f8605a.getExtra().containsKey("UserAgent")) {
            return com.ubix.ssp.ad.e.b.a(com.alipay.sdk.cons.b.b) ? com.ubix.ssp.ad.e.a0.c.t() : "";
        }
        String str = com.ubix.ssp.ad.d.b.f8605a.getExtra().get("UserAgent");
        if (TextUtils.isEmpty(str) || !str.startsWith("Mozilla")) {
            return com.ubix.ssp.ad.e.b.a(com.alipay.sdk.cons.b.b) ? com.ubix.ssp.ad.e.a0.c.t() : "";
        }
        if (com.ubix.ssp.ad.e.b.a(com.alipay.sdk.cons.b.b)) {
            com.ubix.ssp.ad.e.a0.c.u();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            if (c || com.ubix.ssp.ad.d.b.u) {
                return;
            }
            com.ubix.ssp.ad.e.w.q.a aVarA = com.ubix.ssp.ad.e.w.q.a.a(com.ubix.ssp.ad.e.a0.c.e());
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Integer) 0);
            aVarA.a();
            aVarA.a(contentValues, String.format("%s=?", "status"), new String[]{String.valueOf(1)});
            c = true;
        } catch (Exception unused) {
        }
    }

    public void b(Context context, String str) throws Throwable {
        com.ubix.ssp.ad.d.b.q = str;
        if (v.c(context, "ubix_sp_world", "first_time") <= 0) {
            v.a(context, "ubix_sp_world", "first_time", System.currentTimeMillis());
        }
        int iA = v.a(context, "ubix_sp_world", "open_times", 0);
        v.a(context, "ubix_sp_world", "last_time", System.currentTimeMillis());
        v.b(context, "ubix_sp_world", "open_times", iA);
        try {
            String strB = com.ubix.ssp.ad.e.w.q.a.a(context).b(str);
            if (!TextUtils.isEmpty(strB)) {
                a(g.a(Base64.decode(strB, 10)), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.ubix.ssp.ad.d.b.p = b();
    }

    @Override // com.ubix.ssp.open.UBiXInitManger, com.ubix.ssp.open.manager.InitManager
    @Deprecated
    public String getSdkVersion() {
        return "2.10.2.11";
    }

    @Override // com.ubix.ssp.open.manager.InitManager
    public void launchSDK(String str) {
        launchSDK(str, new UBiXAdSetting.Builder().build(), null);
    }

    @Override // com.ubix.ssp.open.manager.InitManager
    public void launchSDK(String str, UBiXAdSetting uBiXAdSetting) {
        String str2;
        if (uBiXAdSetting == null) {
            uBiXAdSetting = new UBiXAdSetting.Builder().build();
        }
        launchSDK(str, uBiXAdSetting, null);
        String str3 = d;
        u.e(str3, "launchSDK appId:" + str);
        if (!u.a() || uBiXAdSetting == null) {
            return;
        }
        u.e(str3, "launchSDK UserConfig: \n     getUserId：" + uBiXAdSetting.getUserId() + "\n     getPublisherId：" + uBiXAdSetting.getPublisherId() + "\n     getExtra：" + uBiXAdSetting.getExtra() + "\n     isUseTextureView：" + uBiXAdSetting.isUseTextureView());
        if (uBiXAdSetting.getPrivacyManager() != null) {
            str2 = "launchSDK privacyManager: \n     开关类：\n     isCanUsePhoneState：" + uBiXAdSetting.getPrivacyManager().isCanUsePhoneState() + "\n     isCanUseAndroidId：" + uBiXAdSetting.getPrivacyManager().isCanUseAndroidId() + "\n     isCanUseOaid：" + uBiXAdSetting.getPrivacyManager().isCanUseOaid() + "\n     isTrustOaid：" + uBiXAdSetting.getPrivacyManager().isTrustOaid() + "\n     isCanGetAppList：" + uBiXAdSetting.getPrivacyManager().isCanGetAppList() + "\n     isCanUseLocation：" + uBiXAdSetting.getPrivacyManager().isCanUseLocation() + "\n     isCanUseMacAddress：" + uBiXAdSetting.getPrivacyManager().isCanUseMacAddress() + "\n     isCanUseWifiStatus：" + uBiXAdSetting.getPrivacyManager().isCanUseWifiStatus() + "\n     isCanUseWriteExternal：" + uBiXAdSetting.getPrivacyManager().isCanUseWriteExternal() + "\n     传入类：\n     getAndroidId：" + uBiXAdSetting.getPrivacyManager().getAndroidId() + "\n     getOaid：" + uBiXAdSetting.getPrivacyManager().getOaid() + "\n     getLocation：" + (uBiXAdSetting.getPrivacyManager() == null ? "" : Arrays.toString(uBiXAdSetting.getPrivacyManager().getLocation())) + "\n     getMacAddr：" + uBiXAdSetting.getPrivacyManager().getMacAddr() + "\n     getImei：" + uBiXAdSetting.getPrivacyManager().getImei() + "\n     getPersonalizedState：" + uBiXAdSetting.getPrivacyManager().getPersonalizedState() + "\n     getProgrammaticRecommendState：" + uBiXAdSetting.getPrivacyManager().getProgrammaticRecommendState() + "\n     用户信息：\n     getUserId：" + uBiXAdSetting.getUserId() + "\n     getPublisherId：" + uBiXAdSetting.getPublisherId() + "\n     getExtra：" + uBiXAdSetting.getExtra() + "\n     isUseTextureView：" + uBiXAdSetting.isUseTextureView();
        } else {
            str2 = "launchSDK privacyManager is null";
        }
        u.e(str3, str2);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0030  */
    /* JADX WARN: Code duplicated, block: B:13:0x004b  */
    @Override // com.ubix.ssp.open.manager.InitManager
    public void launchSDK(String str, UBiXAdSetting uBiXAdSetting, AdLoadCallbackListener adLoadCallbackListener) {
        AdError adErrorE;
        int i;
        String str2;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.ubix.ssp.ad.e.a0.c.k(this.e);
        u.b();
        com.ubix.ssp.ad.d.b.q = str;
        com.ubix.ssp.ad.d.b.f8605a = uBiXAdSetting;
        if (!a()) {
            if (TextUtils.isEmpty(str)) {
                i = 1;
                str2 = "APP_ID为空";
            } else {
                adErrorE = null;
            }
            if (adErrorE != null) {
                f.a(this.e).b(jCurrentTimeMillis);
                f.a(this.e).b(adErrorE.getErrorCode(), adErrorE.getErrorMessage());
            } else {
                com.ubix.ssp.ad.e.a0.c.y();
                com.ubix.ssp.ad.e.a0.c.d.execute(new RunnableC1095a(str, adLoadCallbackListener, jCurrentTimeMillis, jElapsedRealtime));
            }
        }
        i = 11;
        str2 = "系统版本过低，无法返回广告";
        adErrorE = com.ubix.ssp.ad.e.a0.a0.a.e(i, str2);
        if (adErrorE != null) {
            f.a(this.e).b(jCurrentTimeMillis);
            f.a(this.e).b(adErrorE.getErrorCode(), adErrorE.getErrorMessage());
        } else {
            com.ubix.ssp.ad.e.a0.c.y();
            com.ubix.ssp.ad.e.a0.c.d.execute(new RunnableC1095a(str, adLoadCallbackListener, jCurrentTimeMillis, jElapsedRealtime));
        }
    }

    @Override // com.ubix.ssp.open.manager.InitManager
    public void setDebugLog(boolean z) {
        u.f8731a = z;
    }
}
