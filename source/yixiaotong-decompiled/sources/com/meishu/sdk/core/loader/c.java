package com.meishu.sdk.core.loader;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.cdo.oaps.ad.OapsKey;
import com.google.gson.Gson;
import com.huawei.hms.ads.ez;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.MSAdConfig;
import com.meishu.sdk.core.ad.AdType;
import com.meishu.sdk.core.ad.banner.BannerAdLoader;
import com.meishu.sdk.core.ad.draw.DrawAdLoader;
import com.meishu.sdk.core.ad.fullscreenvideo.FullScreenVideoAdLoader;
import com.meishu.sdk.core.ad.interstitial.InterstitialAdLoader;
import com.meishu.sdk.core.ad.paster.PasterAdLoader;
import com.meishu.sdk.core.ad.recycler.RecyclerMixAdLoader;
import com.meishu.sdk.core.ad.reward.RewardVideoLoader;
import com.meishu.sdk.core.ad.splash.SplashAdLoader;
import com.meishu.sdk.core.domain.ClickIdResponse;
import com.meishu.sdk.core.domain.HttpResponse;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.exception.ErrorCodeUtil;
import com.meishu.sdk.core.loader.IAdLoadListener;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.PackageBean;
import com.meishu.sdk.core.utils.SdkHandler;
import com.meishu.sdk.core.utils.c1;
import com.meishu.sdk.core.utils.e0;
import com.meishu.sdk.core.utils.f1;
import com.meishu.sdk.core.utils.g0;
import com.meishu.sdk.core.utils.g1;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.j;
import com.meishu.sdk.core.utils.j0;
import com.meishu.sdk.core.utils.l1;
import com.meishu.sdk.core.utils.p0;
import com.meishu.sdk.core.utils.q;
import com.meishu.sdk.core.utils.q0;
import com.meishu.sdk.core.utils.t;
import com.meishu.sdk.core.utils.u;
import com.meishu.sdk.core.utils.u0;
import com.meishu.sdk.core.utils.x;
import com.meishu.sdk.core.utils.x0;
import com.meishu.sdk.core.utils.y;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.ADPlatformHelper;
import cz.msebera.android.httpclient.client.utils.URLEncodedUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONObject;

/* JADX INFO: compiled from: AdLoader.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class c<T extends IAdLoadListener> implements IAdLoader {
    public static final String KEY_TOKEN = "KEY_TOKEN";
    private static final String TAG = "AdLoader";
    private static final AtomicLong adCounter;
    private static final Map<AdType, AtomicLong> adTypeCounter;
    private static String checkSupport;
    private static Cipher cryptCipher;
    private static byte[] cryptKey;
    private static String cryptKeyStr;
    private static final Map<String, String> hashParams;
    private static final String[] queryParams;
    private long T1;
    private long T10;
    private long T2;
    private long T3;
    private long T8;
    private long T9;
    public Integer accept_ad_height;
    public Integer accept_ad_width;
    public String channel;
    public Context context;
    private volatile boolean isLoadSucc;
    private volatile boolean isLoadTimeout;
    public T loaderListener;
    private com.meishu.sdk.core.loader.concurrent.e loaderManager;
    public String posId;
    public long startLoadTime;

    /* JADX INFO: compiled from: AdLoader.java */
    public class a implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f4799a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ Map d;

        public a(Map map, Map map2, Map map3, Map map4) {
            this.f4799a = map;
            this.b = map2;
            this.c = map3;
            this.d = map4;
        }

        @Override // com.meishu.sdk.core.utils.x
        public void onFailure(IOException iOException) {
            LogUtil.e(c.TAG, "onFailure: " + iOException);
            if (c.this.isLoadTimeout) {
                return;
            }
            c.this.isLoadSucc = true;
            try {
                if (iOException.getMessage().contains("CLEARTEXT")) {
                    c cVar = c.this;
                    cVar.retryNet(cVar.getRequestBody("https://sdk.1rtb.net/sdk/req_ad", this.f4799a, this.b, this.c), this.d);
                    return;
                }
            } catch (Throwable th) {
                LogUtil.e(c.TAG, "load ad error..", th);
            }
            c.this.handleNoAd(iOException.toString());
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0047  */
        @Override // com.meishu.sdk.core.utils.x
        public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
            String strDecode;
            if (c.this.isLoadTimeout) {
                return;
            }
            c.this.isLoadSucc = true;
            c.this.T9 = System.currentTimeMillis();
            if (httpResponse.getErrorCode() == 200) {
                c.this.onLoadSuccess(httpResponse.getResponseBody(), this.d);
                return;
            }
            Headers header = httpResponse.getHeader();
            if (header != null) {
                String str = header.get("Err_msg");
                if (TextUtils.isEmpty(str)) {
                    strDecode = "";
                } else {
                    strDecode = URLDecoder.decode(str, "UTF-8");
                }
            } else {
                strDecode = "";
            }
            LogUtil.d(c.TAG, com.meishu.sdk.activity.a.a("http code: ").append(httpResponse.getErrorCode()).append(",errMsg=").append(strDecode).toString());
            c.this.handleNoAd(com.meishu.sdk.activity.a.a("错误码为：").append(httpResponse.getErrorCode()).append(",msg=").append(strDecode).toString());
            String[] strArr = ErrorCodeUtil.ERROR_REPORT_URL;
            if (strArr == null || strArr.length <= 0) {
                return;
            }
            z.a(strArr[0], Integer.valueOf(httpResponse.getErrorCode()), httpResponse.getErrorDescription());
        }
    }

    /* JADX INFO: compiled from: AdLoader.java */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (c.this.isLoadSucc) {
                    return;
                }
                c.this.isLoadTimeout = true;
                c.this.handleNoAd("load ad timeout");
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: renamed from: com.meishu.sdk.core.loader.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AdLoader.java */
    public class C0796c implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f4801a;

        public C0796c(Map map) {
            this.f4801a = map;
        }

        @Override // com.meishu.sdk.core.utils.x
        public void onFailure(IOException iOException) {
            LogUtil.e(c.TAG, "onFailure: " + iOException);
            c.this.handleNoAd(iOException.toString());
        }

        /* JADX WARN: Code duplicated, block: B:10:0x002f  */
        @Override // com.meishu.sdk.core.utils.x
        public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
            String strDecode;
            if (httpResponse.getErrorCode() == 200) {
                c.this.onLoadSuccess(httpResponse.getResponseBody(), this.f4801a);
                return;
            }
            Headers header = httpResponse.getHeader();
            if (header != null) {
                String str = header.get("Err_msg");
                if (TextUtils.isEmpty(str)) {
                    strDecode = "";
                } else {
                    strDecode = URLDecoder.decode(str, "UTF-8");
                }
            } else {
                strDecode = "";
            }
            LogUtil.d(c.TAG, com.meishu.sdk.activity.a.a("http code: ").append(httpResponse.getErrorCode()).append(",errMsg=").append(strDecode).toString());
            c.this.handleNoAd(com.meishu.sdk.activity.a.a("错误码为：").append(httpResponse.getErrorCode()).append(",msg=").append(strDecode).toString());
            String[] strArr = ErrorCodeUtil.ERROR_REPORT_URL;
            if (strArr == null || strArr.length <= 0) {
                return;
            }
            z.a(strArr[0], Integer.valueOf(httpResponse.getErrorCode()), httpResponse.getErrorDescription());
        }
    }

    /* JADX INFO: compiled from: AdLoader.java */
    public class d extends l {
        public d(c cVar) {
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            try {
                List<InetAddress> listAsList = Arrays.asList(InetAddress.getAllByName("sdk.1rtb.net"));
                synchronized (t.class) {
                    t.f4947a = listAsList;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: AdLoader.java */
    public class e extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f4802a;

        public e(c cVar, String str) {
            this.f4802a = str;
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            u0.a(this.f4802a, 1);
        }
    }

    /* JADX INFO: compiled from: AdLoader.java */
    public class f implements y<p0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MeishuAdInfo f4803a;
        public final /* synthetic */ Map b;

        public f(MeishuAdInfo meishuAdInfo, Map map) {
            this.f4803a = meishuAdInfo;
            this.b = map;
        }

        @Override // com.meishu.sdk.core.utils.y
        public void a(p0 p0Var) throws IOException {
            p0 p0Var2 = p0Var;
            try {
                if (!p0Var2.f4930a) {
                    LogUtil.d(c.TAG, "onResponse: 从dUrl请求clickId失败");
                    c.this.handleNoAd("onResponse: 从dUrl请求clickId失败");
                    return;
                }
                ClickIdResponse clickIdResponse = (ClickIdResponse) u.f4948a.fromJson(p0Var2.c, ClickIdResponse.class);
                if (clickIdResponse != null) {
                    this.f4803a.setClickid(clickIdResponse.getData().getClickid());
                    this.f4803a.setdUrl(new String[]{clickIdResponse.getData().getDstlink()});
                }
                c.this.loadAd(this.f4803a, this.b);
            } catch (Exception e) {
                LogUtil.e(c.TAG, "onResponse: ", e);
                c.this.handleNoAd(e.toString());
            }
        }

        @Override // com.meishu.sdk.core.utils.y
        public void onFailure(IOException iOException) {
            LogUtil.e(c.TAG, "onFailure: " + iOException);
            c.this.handleNoAd(iOException.toString());
        }
    }

    /* JADX INFO: compiled from: AdLoader.java */
    public class g extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MeishuAdInfo f4804a;
        public final /* synthetic */ Map b;

        /* JADX INFO: compiled from: AdLoader.java */
        public class a extends l {
            public a() {
            }

            @Override // com.meishu.sdk.core.safe.l
            public void safeRun() {
                e0.a(g.this.f4804a.getDefImage(), false, null);
                c1.b(g.this.f4804a.getReward_tmp_url());
                c1.b(g.this.f4804a.getWebTempUrl());
            }
        }

        public g(MeishuAdInfo meishuAdInfo, Map map) {
            this.f4804a = meishuAdInfo;
            this.b = map;
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            boolean z;
            u0.a(c.this.posId, 2);
            String[] rstUrl = this.f4804a.getRstUrl();
            if (rstUrl != null) {
                for (String str : rstUrl) {
                    z.a(c.this.getContext(), h0.a(str.replace("__MS_STAT__", c.this.T8 + "." + c.this.T9 + "." + c.this.T10)), new i());
                }
            }
            if (this.f4804a.getMonitorUrl() == null || this.f4804a.getMonitorUrl().length <= 0 || !ADPlatformHelper.checkTypeSupport(c.this, "MS")) {
                z = false;
            } else {
                z = true;
                this.f4804a.setHasMeishuAd(true);
            }
            c.this.handleDynamicClick(this.f4804a);
            c.this.handleCsj(this.f4804a);
            ExecutorService executorService = g0.f4905a;
            g0.b.f4906a.a(new a());
            SdkAdInfo[] sdkAdInfoArrFilterValidSdk = ADPlatformHelper.filterValidSdk(c.this.getContext(), this.f4804a.getSdk(), c.this);
            c cVar = c.this;
            cVar.loaderManager = new com.meishu.sdk.core.loader.concurrent.e(cVar.getContext(), c.this, this.f4804a, this.b);
            if (z) {
                if (this.f4804a.getLayout() != null) {
                    com.meishu.sdk.core.utils.c cVar2 = com.meishu.sdk.core.utils.c.a.f4888a;
                    Context context = c.this.context;
                    cVar2.f4887a = this.f4804a.getLayout();
                    try {
                        String json = new Gson().toJson(cVar2.f4887a);
                        File file = new File(context.getExternalCacheDir(), "ms_cache");
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(file.getAbsolutePath(), "ms_temp.json")));
                        bufferedWriter.write(json);
                        bufferedWriter.flush();
                        bufferedWriter.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                MeishuAdInfo meishuAdInfo = this.f4804a;
                String from_id = meishuAdInfo.getFrom_id();
                int i = h0.f4908a;
                try {
                    meishuAdInfo.setEventUrl(h0.a(meishuAdInfo.getSourceEventUrl(), from_id));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                c cVar3 = c.this;
                c.this.loaderManager.f = cVar3.createMeishuAdDelegate(cVar3.context, this.f4804a);
            }
            if (sdkAdInfoArrFilterValidSdk != null && sdkAdInfoArrFilterValidSdk.length > 0) {
                c.this.loaderManager.a(sdkAdInfoArrFilterValidSdk, this.f4804a);
                return;
            }
            if (!z) {
                c.this.handleNoAd("加载平台为空");
                return;
            }
            com.meishu.sdk.core.loader.concurrent.e eVar = c.this.loaderManager;
            if (eVar.b(null, eVar.b)) {
                return;
            }
            eVar.a(false);
        }
    }

    /* JADX INFO: compiled from: AdLoader.java */
    public class h extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f4806a;

        public h(String str) {
            this.f4806a = str;
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            new com.meishu.sdk.platform.ms.d(this.f4806a, ErrorCodeUtil.AD_LOAD_ERROR).post(c.this.loaderListener);
        }
    }

    static {
        HashMap map = new HashMap();
        hashParams = map;
        map.put("device_imei", "");
        adCounter = new AtomicLong();
        adTypeCounter = new HashMap();
        for (AdType adType : AdType.values()) {
            adTypeCounter.put(adType, new AtomicLong());
        }
        queryParams = new String[]{"app_id", "pid", "accept_ad_type", "sdk_version", com.hihonor.adsdk.base.g.j.e.a.hnadsy, "device_os"};
        try {
            cryptKey = new byte[16];
            new SecureRandom().nextBytes(cryptKey);
            cryptKeyStr = l1.a(cryptKey).toLowerCase();
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cryptCipher = cipher;
            cipher.init(2, new SecretKeySpec(cryptKey, "AES"), new IvParameterSpec(MessageDigest.getInstance("MD5").digest((cryptKeyStr + MSAdConfig.initUUID()).getBytes())));
        } catch (Exception e2) {
            cryptKeyStr = null;
            cryptCipher = null;
            e2.printStackTrace();
        }
    }

    private void asynGetDns() {
        ExecutorService executorService = g0.f4905a;
        g0.b.f4906a.a(new d(this));
    }

    private Map<String, String> generateParams(Map<String, String> map) {
        Integer num = this.accept_ad_width;
        if (num != null && num.intValue() >= 0) {
            map.put("accept_ad_width", String.valueOf(this.accept_ad_width));
        }
        Integer num2 = this.accept_ad_height;
        if (num2 != null && num2.intValue() >= 0) {
            map.put("accept_ad_height", String.valueOf(this.accept_ad_height));
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Request getRequestBody(String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
        StringBuilder sb = new StringBuilder("message=");
        sb.append(map2.get(CrashHianalyticsData.MESSAGE)).append("&nonce=").append(map2.get("nonce")).append("&signature=").append(map2.get("signature")).append("&enc=").append(map2.get("enc")).append("&s0=").append(this.T1).append(".").append(this.T2).append(".").append(this.T3).append("&s1=").append(q.e).append(".").append(q.f).append(".").append(z.d).append(".").append(z.e);
        String string = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if ("app_id".equals(key)) {
                    value = URLEncoder.encode(value);
                }
                if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                    if (sb2.toString().contains("?")) {
                        sb2.append("&").append(key).append("=").append(value);
                    } else {
                        sb2.append("?").append(key).append("=").append(value);
                    }
                }
            }
        }
        Request.Builder builderUrl = new Request.Builder().url(sb2.toString());
        builderUrl.post(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded; charset=utf-8"), string));
        if (map3 != null) {
            Headers.Builder builder = new Headers.Builder();
            for (Map.Entry<String, String> entry2 : map3.entrySet()) {
                builder.add(entry2.getKey(), entry2.getValue());
            }
            builderUrl.headers(builder.build());
        }
        return builderUrl.build();
    }

    private g1 getUrlFromToken(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (g1) new Gson().fromJson(new String(f1.a(str.split("\\|")[1])), g1.class);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCsj(MeishuAdInfo meishuAdInfo) {
        SdkAdInfo[] sdk = meishuAdInfo.getSdk();
        if (sdk != null) {
            for (SdkAdInfo sdkAdInfo : sdk) {
                if ("CSJ-GM".equals(sdkAdInfo.getSdk())) {
                    sdkAdInfo.setCsjGM(true);
                    j0.b = true;
                    sdkAdInfo.setSdk(MSAdConfig.PLATFORM_CSJ);
                    if ("bidding".equals(sdkAdInfo.getOtype())) {
                        sdkAdInfo.setOtype(OapsKey.KEY_PRICE);
                        sdkAdInfo.setCsjGMBidding(true);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDynamicClick(MeishuAdInfo meishuAdInfo) {
        LogUtil.d(TAG, com.meishu.sdk.activity.a.a("act_type=").append(meishuAdInfo.getAct_type()).toString());
        MeishuAdInfo.DClickData dclk = meishuAdInfo.getDclk();
        if (dclk != null) {
            int power = dclk.getPower();
            if (dclk.getPtime() <= 0 || power >= meishuAdInfo.getPower_index()) {
                return;
            }
            HashMap<String, u0.a> map = u0.f4949a;
            u0.a(meishuAdInfo.getPid(), 6);
        }
    }

    public static String isSupportTurn() {
        if ((TextUtils.isEmpty(checkSupport) || ez.V.equalsIgnoreCase(checkSupport)) && AdSdk.getContext() != null) {
            if (com.meishu.sdk.core.utils.h.e(q.a().a("shake_act_type", 0))) {
                checkSupport = ez.Code;
            } else {
                checkSupport = ez.V;
            }
        }
        return checkSupport;
    }

    private void loadGDTAD(MeishuAdInfo meishuAdInfo, Map<String, Object> map) {
        z.a(meishuAdInfo.getdUrl()[0], (Map<String, String>) null, new f(meishuAdInfo, map));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoadSuccess(byte[] bArr, Map<String, Object> map) {
        try {
            MeishuAdInfo meishuAdInfoFromJson = MeishuAdInfo.fromJson(decryptBody(bArr), getAdType());
            this.T10 = System.currentTimeMillis();
            if (meishuAdInfoFromJson == null) {
                handleNoAd("meishuAdInfo is null");
                return;
            }
            meishuAdInfoFromJson.setPid(this.posId);
            meishuAdInfoFromJson.setLoadedTime(SystemClock.uptimeMillis());
            saveWxAppid(meishuAdInfoFromJson.getWx_appid());
            if (meishuAdInfoFromJson.getTarget_type() == 1 && MSAdConfig.PLATFORM_GDT.equalsIgnoreCase(meishuAdInfoFromJson.getFrom())) {
                loadGDTAD(meishuAdInfoFromJson, map);
            } else {
                loadAd(meishuAdInfoFromJson, map);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            handleNoAd(e2.toString());
        }
    }

    private void preLoadVideo(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            getUrlFromToken(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryNet(Request request, Map<String, Object> map) {
        z.a(request, new C0796c(map));
    }

    private void saveLoadRecord(String str, int i) {
        ExecutorService executorService = g0.f4905a;
        g0.b.f4906a.a(new e(this, str));
    }

    private void saveWxAppid(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AdSdk.getSharedPreferences().edit().putString("wx_appid", str).apply();
    }

    private Map<String, String> wrapParams(Map<String, String> map) {
        try {
            try {
                Map<String, String> mapWrapParams = AdParallelLoader.wrapParams(map);
                this.T3 = System.currentTimeMillis();
                if (mapWrapParams != null) {
                    return mapWrapParams;
                }
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        } catch (Exception unused) {
            String hexString = Long.toHexString(((System.currentTimeMillis() / 3) * 3) + 1);
            JSONObject jSONObject = new JSONObject();
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String value = entry.getValue();
                if (hashParams.containsKey(entry.getKey())) {
                    try {
                        value = l1.a(MessageDigest.getInstance("MD5").digest(value.getBytes())).toLowerCase();
                    } catch (Exception unused2) {
                    }
                }
                if (!"pid".equals(entry.getKey())) {
                    jSONObject.put(entry.getKey(), value);
                    arrayList.add(entry.getKey() + "=" + value);
                }
            }
            arrayList.add("5317f4377245bfb8efdc42c45d71bd43");
            arrayList.add(hexString);
            Collections.sort(arrayList);
            HashMap map2 = new HashMap();
            map2.put(CrashHianalyticsData.MESSAGE, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            map2.put("nonce", hexString);
            map2.put("signature", Base64.encodeToString(MessageDigest.getInstance("SHA-256").digest(TextUtils.join("&", arrayList).getBytes()), 2));
            return map2;
        }
    }

    public void clearErrorState() {
    }

    public abstract com.meishu.sdk.core.loader.d createDelegate(SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo);

    public abstract com.meishu.sdk.core.loader.d createMeishuAdDelegate(Context context, MeishuAdInfo meishuAdInfo);

    public Integer getAccept_ad_height() {
        return this.accept_ad_height;
    }

    public Integer getAccept_ad_width() {
        return this.accept_ad_width;
    }

    public AdType getAdType() {
        if (this instanceof RecyclerMixAdLoader) {
            return AdType.FEED_MIX;
        }
        if (this instanceof BannerAdLoader) {
            return AdType.BANNER;
        }
        if (this instanceof SplashAdLoader) {
            return AdType.SPLASH;
        }
        if (this instanceof InterstitialAdLoader) {
            return AdType.INTERSTITIAL;
        }
        if (this instanceof PasterAdLoader) {
            return AdType.PASTER;
        }
        if (this instanceof RewardVideoLoader) {
            return AdType.REWARD;
        }
        if (this instanceof DrawAdLoader) {
            return AdType.DRAW;
        }
        if (this instanceof FullScreenVideoAdLoader) {
            return AdType.FULL_SCREEN_VIDEO;
        }
        return null;
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public Context getContext() {
        return this.context;
    }

    public int getFetchDelay() {
        return 0;
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public T getLoaderListener() {
        return this.loaderListener;
    }

    public String getPosId() {
        return this.posId;
    }

    public long getT1() {
        return this.T1;
    }

    public void init(Context context, String str, T t) {
        this.context = context;
        this.posId = str;
        this.loaderListener = t;
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        loadAd(new HashMap());
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void destroy() {
        com.meishu.sdk.core.loader.strategy.a aVar;
        com.meishu.sdk.core.loader.concurrent.e eVar = this.loaderManager;
        if (eVar == null || (aVar = eVar.d) == null) {
            return;
        }
        com.meishu.sdk.core.loader.strategy.e eVar2 = (com.meishu.sdk.core.loader.strategy.e) aVar;
        Handler handler = eVar2.l;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        try {
            List<com.meishu.sdk.core.loader.d> list = eVar2.t;
            if (list == null || list.size() <= 0) {
                return;
            }
            for (com.meishu.sdk.core.loader.d dVar : eVar2.t) {
                if (dVar != null) {
                    try {
                        dVar.destroy();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
            eVar2.t.clear();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void handleNoAd(String str) {
        try {
            if (this.loaderListener != null) {
                SdkHandler.getInstance().runOnUiThread(new h(str));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void loadAd(Map<String, Object> map) {
        try {
            if (AdSdk.adConfig() == null) {
                Log.e("meishusdk", "SDK IS NOT INITED ！");
                handleNoAd("SDK IS NOT INITED！");
                return;
            }
            this.startLoadTime = System.currentTimeMillis();
            asynGetDns();
            boolean z = j.b;
            j.b(AdSdk.getContext());
            if (TextUtils.isEmpty(this.posId)) {
                LogUtil.e(TAG, "pid不能为空！");
                handleNoAd("pid不能为空！");
                return;
            }
            AdType adType = getAdType();
            if (adType == null) {
                LogUtil.e(TAG, "AdType is null！");
                handleNoAd("AdType is null！");
                return;
            }
            handleTimeout();
            clearErrorState();
            this.T1 = System.currentTimeMillis();
            Map<String, String> mapGenerateParams = generateParams(x0.b(this.context, this.posId, adType, adCounter.incrementAndGet(), adTypeCounter.get(adType).incrementAndGet()));
            mapGenerateParams.put("msec", this.startLoadTime + "");
            try {
                if (map.containsKey(KEY_TOKEN)) {
                    String str = (String) map.get(KEY_TOKEN);
                    mapGenerateParams.put(OapsKey.KEY_TOKEN, str);
                    preLoadVideo(str);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            boolean z2 = false;
            if (z) {
                int i = com.meishu.sdk.core.utils.d.n;
                com.meishu.sdk.core.utils.d.b.f4894a.a(true, false);
            }
            if (!TextUtils.isEmpty(this.channel)) {
                mapGenerateParams.put("channel", this.channel);
            }
            if (AdSdk.adConfig().getCanUseSdkPersonalRecommend()) {
                mapGenerateParams.put("impersonal", "0");
            } else {
                mapGenerateParams.put("impersonal", "1");
            }
            this.T2 = System.currentTimeMillis();
            if (cryptCipher != null) {
                mapGenerateParams.put("gzip_crypt_key", cryptKeyStr);
            }
            HashMap map2 = new HashMap();
            map2.put("MS-SDK-Version", "Android-" + mapGenerateParams.get("sdk_version"));
            map2.put("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            Map<String, String> mapWrapParams = wrapParams(mapGenerateParams);
            HashMap map3 = new HashMap();
            for (String str2 : queryParams) {
                String str3 = mapGenerateParams.get(str2);
                if (!TextUtils.isEmpty(str3)) {
                    map3.put(str2, str3);
                }
            }
            saveLoadRecord(this.posId, 1);
            Request requestBody = getRequestBody((AdSdk.adConfig().secure() == 1 || q0.l == 1) ? "https://sdk.1rtb.net/sdk/req_ad" : "http://sdk.1rtb.net/sdk/req_ad", map3, mapWrapParams, map2);
            this.T8 = System.currentTimeMillis();
            z.a(requestBody, new a(map3, mapWrapParams, map2, map));
            if (q0.s == 0) {
                Context context = AdSdk.getContext();
                if (AdSdk.adConfig() != null && AdSdk.adConfig().isTest()) {
                    z2 = true;
                }
                if (com.meishu.sdk.core.exception.a.b) {
                    Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
                    if (defaultUncaughtExceptionHandler instanceof com.meishu.sdk.core.exception.a.b) {
                        return;
                    }
                    Thread.setDefaultUncaughtExceptionHandler(new com.meishu.sdk.core.exception.a.b(context, z2, defaultUncaughtExceptionHandler));
                }
            }
        } catch (Throwable th2) {
            LogUtil.e(TAG, "load ad error.", th2);
            handleNoAd(th2.toString());
        }
    }

    private void handleTimeout() {
        int to;
        this.isLoadTimeout = false;
        this.isLoadSucc = false;
        if (getAdType() != AdType.SPLASH || getFetchDelay() <= 0) {
            return;
        }
        int i = 500;
        try {
            PackageBean.AdBean adBean = q0.m;
            if (adBean != null && adBean.getSplash() != null && (to = q0.m.getSplash().getTo()) >= 0) {
                i = to;
            }
        } catch (Throwable unused) {
        }
        SdkHandler.getInstance().postDelay(new b(), getFetchDelay() + i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r1v18, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:82:0x007d
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    private synchronized java.lang.String decryptBody(byte[] r10) {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meishu.sdk.core.loader.c.decryptBody(byte[]):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(MeishuAdInfo meishuAdInfo, Map<String, Object> map) {
        SdkHandler.runOnMainThread(new g(meishuAdInfo, map));
    }
}
