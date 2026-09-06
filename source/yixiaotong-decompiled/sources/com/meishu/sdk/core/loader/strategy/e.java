package com.meishu.sdk.core.loader.strategy;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.google.gson.Gson;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.MSAdConfig;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.loader.AdPlatformError;
import com.meishu.sdk.core.loader.cache.CacheManager;
import com.meishu.sdk.core.loader.concurrent.g;
import com.meishu.sdk.core.loader.serverbidding.S2sbResultBean;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.SdkHandler;
import com.meishu.sdk.core.utils.g0;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.o1;
import com.meishu.sdk.core.utils.t0;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;
import com.meishu.sdk.platform.bd.banner.BDBannerAdLoader;
import com.qq.e.comm.pi.IBidding;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: PriceFirstStrategy.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class e implements com.meishu.sdk.core.loader.strategy.a {
    public List<Integer> A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.meishu.sdk.core.loader.c f4818a;
    public MeishuAdInfo b;
    public List<com.meishu.sdk.core.loader.loadbean.a> g;
    public Map<String, Object> i;
    public volatile boolean j;
    public g k;
    public long m;
    public List<com.meishu.sdk.core.loader.loadbean.a> q;
    public boolean r;
    public long s;
    public List<com.meishu.sdk.core.loader.d> t;
    public volatile boolean u;
    public volatile boolean v;
    public boolean w;
    public volatile boolean x;
    public int y;
    public List<Integer> z;
    public List<com.meishu.sdk.core.loader.cache.a> c = new LinkedList();
    public List<com.meishu.sdk.core.loader.d> d = Collections.synchronizedList(new ArrayList());
    public List<SdkAdInfo> e = Collections.synchronizedList(new ArrayList());
    public List<com.meishu.sdk.core.loader.loadbean.a> f = new ArrayList();
    public LinkedList<com.meishu.sdk.core.loader.loadbean.a> h = new LinkedList<>();
    public Handler l = new Handler();
    public List<com.meishu.sdk.core.loader.loadbean.a> n = Collections.synchronizedList(new ArrayList());
    public List<com.meishu.sdk.core.loader.loadbean.a> o = Collections.synchronizedList(new ArrayList());
    public List<com.meishu.sdk.core.loader.loadbean.a> p = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: compiled from: PriceFirstStrategy.java */
    public class a implements Comparator<com.meishu.sdk.core.loader.loadbean.a> {
        public a(e eVar) {
        }

        @Override // java.util.Comparator
        public int compare(com.meishu.sdk.core.loader.loadbean.a aVar, com.meishu.sdk.core.loader.loadbean.a aVar2) {
            return aVar2.a() - aVar.a();
        }
    }

    /* JADX INFO: compiled from: PriceFirstStrategy.java */
    public class b extends l {
        public b() {
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            g gVar = e.this.k;
            if (gVar != null) {
                com.meishu.sdk.core.loader.concurrent.e eVar = (com.meishu.sdk.core.loader.concurrent.e) gVar;
                if (eVar.g) {
                    return;
                }
                eVar.g = true;
                eVar.a(false);
            }
        }
    }

    /* JADX INFO: compiled from: PriceFirstStrategy.java */
    public class c implements Comparator<Integer> {
        public c(e eVar) {
        }

        @Override // java.util.Comparator
        public int compare(Integer num, Integer num2) {
            return num2.intValue() - num.intValue();
        }
    }

    /* JADX INFO: compiled from: PriceFirstStrategy.java */
    public class d implements Comparator<Integer> {
        public d(e eVar) {
        }

        @Override // java.util.Comparator
        public int compare(Integer num, Integer num2) {
            return num2.intValue() - num.intValue();
        }
    }

    /* JADX INFO: renamed from: com.meishu.sdk.core.loader.strategy.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PriceFirstStrategy.java */
    public class C0797e implements Comparator<com.meishu.sdk.core.loader.loadbean.a> {
        public C0797e(e eVar) {
        }

        @Override // java.util.Comparator
        public int compare(com.meishu.sdk.core.loader.loadbean.a aVar, com.meishu.sdk.core.loader.loadbean.a aVar2) {
            return aVar2.a() - aVar.a();
        }
    }

    public e(com.meishu.sdk.core.loader.c cVar, MeishuAdInfo meishuAdInfo) {
        Collections.synchronizedList(new ArrayList());
        this.q = Collections.synchronizedList(new ArrayList());
        this.s = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
        this.t = Collections.synchronizedList(new ArrayList());
        this.y = 1;
        this.z = new ArrayList();
        this.A = new ArrayList();
        this.f4818a = cVar;
        this.b = meishuAdInfo;
    }

    public static void a(e eVar, com.meishu.sdk.core.loader.loadbean.a aVar) {
        long j;
        long all_timeout;
        eVar.getClass();
        long jMin = 0;
        long once_timeout = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
        try {
            all_timeout = eVar.b.getAll_timeout() > 0 ? eVar.b.getAll_timeout() : 10000L;
            try {
                if (eVar.b.getOnce_timeout() > 0) {
                    once_timeout = eVar.b.getOnce_timeout();
                }
            } catch (Exception e) {
                long j2 = all_timeout;
                e = e;
                j = j2;
                e.printStackTrace();
                all_timeout = j;
            }
        } catch (Exception e2) {
            e = e2;
            j = 10000;
        }
        try {
            long jUptimeMillis = all_timeout - (SystemClock.uptimeMillis() - eVar.m);
            if (jUptimeMillis > 0) {
                jMin = Math.min(jUptimeMillis, once_timeout);
            }
            eVar.l.postDelayed(new com.meishu.sdk.core.loader.strategy.c(eVar, aVar), jMin);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static void b(e eVar, com.meishu.sdk.core.loader.loadbean.a aVar) {
        eVar.getClass();
        try {
            SdkAdInfo sdkAdInfo = aVar.f4815a;
            com.meishu.sdk.core.loader.cache.a aVar2 = new com.meishu.sdk.core.loader.cache.a();
            aVar2.d = aVar.b;
            aVar2.h = eVar.b;
            sdkAdInfo.setCache(true);
            aVar2.b = sdkAdInfo;
            aVar2.f4807a = eVar.b.getCacheKey();
            aVar2.c = aVar.a();
            eVar.c.add(aVar2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0038 A[Catch: all -> 0x004b, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x000a, B:7:0x0012, B:10:0x0026, B:12:0x002d, B:15:0x0038), top: B:24:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x0049 A[DONT_GENERATE] */
    public static boolean c(e eVar, com.meishu.sdk.core.loader.loadbean.a aVar) {
        synchronized (eVar) {
            if (eVar.b.getCache() <= 0 && eVar.n.size() > 0) {
                eVar.a(eVar.n);
                com.meishu.sdk.core.loader.loadbean.a aVar2 = eVar.n.get(0);
                if (aVar2.e <= aVar.e && (aVar.a() == -1 || aVar2.a() < aVar.a())) {
                    if (!"".equals(aVar.f4815a.getS2sb())) {
                        return false;
                    }
                }
            } else if (!"".equals(aVar.f4815a.getS2sb())) {
                return false;
            }
            return true;
        }
    }

    public final List<com.meishu.sdk.core.loader.loadbean.a> d() {
        List<WeakReference<com.meishu.sdk.core.loader.cache.a>> cacheListByKey;
        ArrayList arrayList = new ArrayList();
        try {
            String cacheKey = this.b.getCacheKey();
            if (this.b.getCache() > 0 && (cacheListByKey = CacheManager.INSTANCE.getCacheListByKey(cacheKey)) != null && cacheListByKey.size() > 0) {
                Iterator<WeakReference<com.meishu.sdk.core.loader.cache.a>> it = cacheListByKey.iterator();
                while (it.hasNext()) {
                    com.meishu.sdk.core.loader.cache.a aVar = it.next().get();
                    if (aVar != null && aVar.a()) {
                        com.meishu.sdk.core.loader.loadbean.a aVar2 = new com.meishu.sdk.core.loader.loadbean.a();
                        aVar2.f4815a = aVar.b;
                        aVar2.b = aVar.d;
                        aVar2.f = aVar.c;
                        synchronized (aVar2) {
                            aVar2.c = 2;
                        }
                        aVar2.g = aVar.e;
                        aVar2.h = true;
                        arrayList.add(aVar2);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return arrayList;
    }

    public final synchronized void e() {
        SdkHandler.runOnMainThread(new b());
    }

    public final void f() {
        if (this.q.size() == 0 && this.n.size() == 0) {
            LogUtil.d("PriceFirstStrategy", "handleFinish loadFinish=true");
            this.j = true;
            this.p.clear();
            e();
            return;
        }
        i();
        if (!this.j) {
            this.q.addAll(this.n);
            a(this.q);
        }
        g();
        c();
    }

    public final void i() {
        try {
            Iterator it = new ArrayList(this.n).iterator();
            while (it.hasNext()) {
                com.meishu.sdk.core.loader.loadbean.a aVar = (com.meishu.sdk.core.loader.loadbean.a) it.next();
                if (!this.j && c(aVar)) {
                    b(aVar);
                    it.remove();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: compiled from: PriceFirstStrategy.java */
    public class f extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.meishu.sdk.core.loader.loadbean.a f4820a;

        public f(com.meishu.sdk.core.loader.loadbean.a aVar) {
            this.f4820a = aVar;
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            try {
                com.meishu.sdk.core.loader.loadbean.a aVar = this.f4820a;
                if (aVar == null) {
                    return;
                }
                e.a(e.this, aVar);
                SdkAdInfo sdkAdInfo = this.f4820a.f4815a;
                if (sdkAdInfo == null) {
                    return;
                }
                AdSdk.initSdkIfNot(e.this.f4818a.getContext(), sdkAdInfo);
                e eVar = e.this;
                com.meishu.sdk.core.loader.d dVarCreateDelegate = eVar.f4818a.createDelegate(sdkAdInfo, eVar.b);
                if (dVarCreateDelegate != null) {
                    if (e.c(e.this, this.f4820a)) {
                        e.a(e.this, dVarCreateDelegate, this.f4820a, (AdPlatformError) null);
                        return;
                    }
                    dVarCreateDelegate.setLocalParams(e.this.i);
                    e.this.getClass();
                    dVarCreateDelegate.setGroupIndex(0);
                    dVarCreateDelegate.setConCurrentLoadListener(new a(dVarCreateDelegate));
                    if (dVarCreateDelegate instanceof BDBannerAdLoader) {
                        return;
                    }
                    sdkAdInfo.setLoadTime(SystemClock.uptimeMillis());
                    sdkAdInfo.setAlreadyLoaded(true);
                    com.meishu.sdk.core.loader.loadbean.a aVar2 = this.f4820a;
                    synchronized (aVar2) {
                        aVar2.c = 4;
                    }
                    dVarCreateDelegate.loadAd();
                    e.this.t.add(dVarCreateDelegate);
                    return;
                }
                e.a(e.this, dVarCreateDelegate, this.f4820a, (AdPlatformError) null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* JADX INFO: compiled from: PriceFirstStrategy.java */
        public class a implements com.meishu.sdk.core.loader.concurrent.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.meishu.sdk.core.loader.d f4821a;

            public a(com.meishu.sdk.core.loader.d dVar) {
                this.f4821a = dVar;
            }

            @Override // com.meishu.sdk.core.loader.concurrent.f
            public void a(AdPlatformError adPlatformError, int i) {
                LogUtil.e("PriceFirstStrategy", com.meishu.sdk.activity.a.a("onAdError: ").append(adPlatformError.getPlatform()).append("  ").append(adPlatformError.getMessage()).toString());
                try {
                    f fVar = f.this;
                    e.a(e.this, this.f4821a, fVar.f4820a, adPlatformError);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.meishu.sdk.core.loader.concurrent.f
            public void b(Object obj, int i) {
                try {
                    f fVar = f.this;
                    e.a(e.this, this.f4821a, fVar.f4820a, obj);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.meishu.sdk.core.loader.concurrent.f
            public void onAdExposure() {
                g gVar = e.this.k;
                if (gVar != null) {
                    gVar.getClass();
                }
            }

            @Override // com.meishu.sdk.core.loader.concurrent.f
            public void a(Object obj, int i) {
                try {
                    f fVar = f.this;
                    e eVar = e.this;
                    com.meishu.sdk.core.loader.loadbean.a aVar = fVar.f4820a;
                    synchronized (eVar) {
                        eVar.o.add(aVar);
                        eVar.a();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.meishu.sdk.core.loader.concurrent.f
            public void a(String str, int i, int i2) {
                LogUtil.e("PriceFirstStrategy", "onRenderFail :" + str);
                try {
                    f fVar = f.this;
                    e.a(e.this, this.f4821a, fVar.f4820a, i, str);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public final synchronized void g() {
        if (!this.u) {
            if (this.q.size() > 0) {
                com.meishu.sdk.core.loader.loadbean.a aVar = this.q.get(0);
                if ((this.b.getCache() <= 0 || (this.b.getCache() > 0 && !this.r)) && this.k != null) {
                    if (!aVar.g || this.j) {
                        if (this.b.getCache() <= 0) {
                            LogUtil.e("PriceFirstStrategy", "handleReturnAd, loadFinished=true");
                            this.j = true;
                            this.p.clear();
                        }
                        this.u = true;
                        a(aVar.f4815a);
                        this.h.clear();
                        g gVar = this.k;
                        Object obj = aVar.b;
                        SdkAdInfo sdkAdInfo = aVar.f4815a;
                        com.meishu.sdk.core.loader.concurrent.e eVar = (com.meishu.sdk.core.loader.concurrent.e) gVar;
                        MeishuAdInfo meishuAdInfo = eVar.b;
                        String accept_id = sdkAdInfo.getAccept_id();
                        int i = h0.f4908a;
                        if (meishuAdInfo != null) {
                            try {
                                meishuAdInfo.setEventUrl(h0.a(meishuAdInfo.getSourceEventUrl(), accept_id));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        if (!eVar.g) {
                            eVar.g = true;
                            com.meishu.sdk.core.loader.a.a(eVar.e.getContext(), h0.a(h0.a(sdkAdInfo.getFinalRsp().replace("__TIMEOUT__", String.valueOf(0)), System.currentTimeMillis() - eVar.e.startLoadTime)));
                            if (eVar.e.getLoaderListener() != null) {
                                LogUtil.d("ConCurrentManager", com.meishu.sdk.activity.a.a("onFinalAdLoaded: ").append(sdkAdInfo.getSdk()).append(",group：").append(sdkAdInfo.getGroup()).toString());
                                eVar.e.getLoaderListener().onAdLoaded(obj);
                            }
                        }
                        a();
                    } else if (this.k != null) {
                        a(aVar.f4815a);
                        this.u = true;
                        e();
                    }
                }
            } else if (this.k != null) {
                this.u = true;
                LogUtil.e("PriceFirstStrategy", "无广告返回，onAllError");
                e();
            }
        }
    }

    public final synchronized void h() {
        if (!this.j) {
            try {
                if (this.x) {
                    f();
                    return;
                }
                LinkedList<com.meishu.sdk.core.loader.loadbean.a> linkedList = this.h;
                if (linkedList != null && linkedList.size() > 0) {
                    com.meishu.sdk.core.loader.loadbean.a aVarRemoveFirst = this.h.removeFirst();
                    this.p.add(aVarRemoveFirst);
                    ExecutorService executorService = g0.f4905a;
                    g0.b.f4906a.a(new f(aVarRemoveFirst));
                } else if (this.p.size() == 0) {
                    f();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void b() {
        com.meishu.sdk.core.loader.loadbean.a aVar = new com.meishu.sdk.core.loader.loadbean.a();
        aVar.e = (1000 - this.b.getPriority()) * 1000000;
        aVar.f = this.b.getCacheScore();
        synchronized (aVar) {
            aVar.c = 2;
        }
        aVar.g = true;
        this.g.add(aVar);
    }

    public final void c() {
        if (this.w) {
            return;
        }
        this.w = true;
        this.j = true;
        synchronized (this) {
            try {
                ArrayList arrayList = (ArrayList) d();
                if (arrayList.size() > 0) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        com.meishu.sdk.core.loader.loadbean.a aVar = (com.meishu.sdk.core.loader.loadbean.a) arrayList.get(i);
                        SdkAdInfo sdkAdInfo = aVar.f4815a;
                        int ecpm = sdkAdInfo.getEcpm();
                        if ("bidding".equals(sdkAdInfo.getOtype()) && ecpm > 0 && MSAdConfig.PLATFORM_GDT.equals(sdkAdInfo.getSdk())) {
                            this.f.add(aVar);
                        }
                        if (MSAdConfig.PLATFORM_GDT.equals(sdkAdInfo.getSdk()) && !TextUtils.isEmpty(sdkAdInfo.getS2sb())) {
                            this.f.add(aVar);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ExecutorService executorService = g0.f4905a;
        g0.b.f4906a.a(new com.meishu.sdk.core.loader.strategy.f(this));
        try {
            List<com.meishu.sdk.core.loader.d> list = this.d;
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < this.d.size(); i2++) {
                    com.meishu.sdk.core.loader.d dVar = this.d.get(i2);
                    SdkAdInfo sdkAdInfo2 = dVar.getSdkAdInfo();
                    a(sdkAdInfo2.getEcpm(), sdkAdInfo2.getPrice(), sdkAdInfo2.getOtype());
                    if (this.z.size() > 0) {
                        try {
                            ((BasePlatformLoader) dVar).sendGdtWinResult(false, this.z.get(0).intValue());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            }
            List<SdkAdInfo> list2 = this.e;
            if (list2 == null || list2.size() <= 0) {
                return;
            }
            for (int i3 = 0; i3 < this.e.size(); i3++) {
                SdkAdInfo sdkAdInfo3 = this.e.get(i3);
                a(sdkAdInfo3.getEcpm(), sdkAdInfo3.getPrice(), sdkAdInfo3.getOtype());
                if (this.z.size() > 0) {
                    a(sdkAdInfo3, this.z.get(0).intValue());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void b(com.meishu.sdk.core.loader.loadbean.a aVar) {
        try {
            if (this.b.getCache() > 0 && this.r) {
                if (this.q.size() >= (this.b.getCache() <= 0 ? 1 : this.b.getCache()) && !this.j) {
                    this.j = true;
                    this.p.clear();
                    c();
                    return;
                } else {
                    this.g.remove(aVar);
                    this.n.remove(aVar);
                    if (!this.q.contains(aVar)) {
                        this.q.add(aVar);
                    }
                    Collections.sort(this.q, new a(this));
                    return;
                }
            }
            if (!this.q.contains(aVar)) {
                this.q.add(aVar);
            }
            this.g.remove(aVar);
            this.n.remove(aVar);
            g();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(e eVar, com.meishu.sdk.core.loader.d dVar, com.meishu.sdk.core.loader.loadbean.a aVar, int i, String str) {
        g gVar;
        SdkAdInfo sdkAdInfo;
        synchronized (eVar) {
            synchronized (eVar) {
                eVar.g.remove(aVar);
                if (aVar != null && (sdkAdInfo = aVar.f4815a) != null) {
                    o1.b(sdkAdInfo.getEventUrl(), i, str);
                    String strReplace = aVar.f4815a.getErr().replace("__MS_ERRNO__", "1026").replace("__ERROR_CODE__", String.valueOf(i)).replace("__TIMEOUT__", String.valueOf(aVar.d));
                    if (!TextUtils.isEmpty(strReplace)) {
                        z.a(StubApp.getOrigApplicationContext(eVar.f4818a.getContext().getApplicationContext()), h0.a(strReplace), new i());
                    }
                }
                if (eVar.j && eVar.q.size() > 0 && aVar.equals(eVar.q.get(0)) && ((eVar.b.getCache() <= 0 || (eVar.b.getCache() > 0 && !eVar.r)) && (gVar = eVar.k) != null)) {
                    com.meishu.sdk.core.loader.concurrent.e eVar2 = (com.meishu.sdk.core.loader.concurrent.e) gVar;
                    if (eVar2.e.getLoaderListener() != null && !eVar2.j) {
                        LogUtil.d("ConCurrentManager", "onRenderFail");
                        eVar2.e.getLoaderListener().onAdRenderFail(str, -1);
                    }
                }
            }
        }
    }

    public static void a(e eVar) {
        eVar.getClass();
        try {
            if (eVar.f.size() > 0) {
                List<com.meishu.sdk.core.loader.loadbean.a> listD = eVar.d();
                for (com.meishu.sdk.core.loader.loadbean.a aVar : eVar.f) {
                    SdkAdInfo sdkAdInfo = aVar.f4815a;
                    try {
                        ArrayList arrayList = (ArrayList) listD;
                        if (arrayList.size() > 0) {
                            int i = 0;
                            while (true) {
                                if (i < arrayList.size()) {
                                    if (((com.meishu.sdk.core.loader.loadbean.a) arrayList.get(i)).f4815a.getReq_uid() != aVar.f4815a.getReq_uid()) {
                                        i++;
                                    }
                                }
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    Object obj = aVar.b;
                    if (obj instanceof com.meishu.sdk.core.ad.a) {
                        Object sdkAd = ((com.meishu.sdk.core.ad.a) obj).getSdkAd();
                        if (sdkAd instanceof IBidding) {
                            eVar.a(sdkAdInfo.getEcpm(), sdkAdInfo.getPrice(), sdkAdInfo.getOtype());
                            if (eVar.z.size() > 0) {
                                HashMap map = new HashMap();
                                map.put("winPrice", eVar.z.get(0));
                                map.put("lossReason", 1);
                                map.put("adnId", "2");
                                ((IBidding) sdkAd).sendLossNotification(map);
                            }
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final boolean c(com.meishu.sdk.core.loader.loadbean.a aVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.g);
        arrayList.addAll(this.n);
        if (arrayList.size() <= 0) {
            return true;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            com.meishu.sdk.core.loader.loadbean.a aVar2 = (com.meishu.sdk.core.loader.loadbean.a) it.next();
            if (!aVar2.equals(aVar) && aVar2.c == 2 && !this.n.contains(aVar2)) {
                this.n.add(aVar2);
                it.remove();
            }
            int i = aVar2.e;
            int i2 = aVar.e;
            if (i > i2) {
                return false;
            }
            if (i == i2 && ((!aVar2.g && "bidding".equals(aVar2.f4815a.getOtype()) && aVar2.a() == -1) || aVar2.a() > aVar.a())) {
                return false;
            }
        }
        return true;
    }

    public final void b(SdkAdInfo sdkAdInfo, int i) {
        S2sbResultBean s2sbResultBean;
        try {
            if (TextUtils.isEmpty(sdkAdInfo.getS2sb()) || (s2sbResultBean = (S2sbResultBean) new Gson().fromJson(sdkAdInfo.getS2sb(), S2sbResultBean.class)) == null) {
                return;
            }
            z.a(this.f4818a.getContext(), s2sbResultBean.getNurl().replace("AUCTION_PRICE", String.valueOf(sdkAdInfo.getPrice())).replace("HIGHEST_LOSS_PRICE", String.valueOf(Math.min(i, sdkAdInfo.getPrice()))), new i());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void b(int i, int i2, String str) {
        try {
            this.A.clear();
            this.A.addAll(b(this.n, i));
            this.A.addAll(b(this.g, i));
            this.A.addAll(b(d(), i));
            if (i2 > 0 && "bidding".equals(str)) {
                this.A.add(Integer.valueOf(i2));
            }
            Collections.sort(this.A, new d(this));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(e eVar, com.meishu.sdk.core.loader.d dVar, com.meishu.sdk.core.loader.loadbean.a aVar, AdPlatformError adPlatformError) {
        synchronized (eVar) {
            g gVar = eVar.k;
            synchronized (aVar) {
                aVar.c = 3;
            }
            aVar.f4815a.replaceErrorPst(adPlatformError);
            eVar.g.remove(aVar);
            eVar.i();
            eVar.p.remove(aVar);
            eVar.h();
        }
    }

    /* JADX WARN: Code duplicated, block: B:104:0x01bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:107:0x01b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:25:0x00b2 A[Catch: all -> 0x0250, TryCatch #0 {, blocks: (B:23:0x008c, B:25:0x00b2, B:27:0x00b8, B:28:0x00c4, B:29:0x00cc, B:32:0x00d0, B:33:0x00d1, B:35:0x00dc, B:36:0x00dd, B:37:0x00de, B:39:0x00e4, B:41:0x00f1, B:43:0x00f8, B:45:0x0101, B:47:0x0105, B:49:0x0118, B:51:0x0146, B:44:0x00fd, B:52:0x0161, B:54:0x0165, B:55:0x0169, B:56:0x016b, B:58:0x016f, B:60:0x0173, B:61:0x0177, B:65:0x019a, B:67:0x01a7, B:68:0x01ac, B:70:0x01b0, B:72:0x01b3, B:73:0x01b4, B:75:0x01ba, B:86:0x01e5, B:88:0x01ea, B:89:0x01eb, B:64:0x0197, B:90:0x01ec, B:92:0x01f0, B:94:0x0203, B:96:0x0231, B:97:0x024b, B:22:0x0089, B:77:0x01bf, B:79:0x01c7, B:80:0x01cc, B:83:0x01d6, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:71:0x01b1, B:31:0x00ce), top: B:103:0x0001, inners: #1, #2, #3, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x00b8 A[Catch: all -> 0x0250, TryCatch #0 {, blocks: (B:23:0x008c, B:25:0x00b2, B:27:0x00b8, B:28:0x00c4, B:29:0x00cc, B:32:0x00d0, B:33:0x00d1, B:35:0x00dc, B:36:0x00dd, B:37:0x00de, B:39:0x00e4, B:41:0x00f1, B:43:0x00f8, B:45:0x0101, B:47:0x0105, B:49:0x0118, B:51:0x0146, B:44:0x00fd, B:52:0x0161, B:54:0x0165, B:55:0x0169, B:56:0x016b, B:58:0x016f, B:60:0x0173, B:61:0x0177, B:65:0x019a, B:67:0x01a7, B:68:0x01ac, B:70:0x01b0, B:72:0x01b3, B:73:0x01b4, B:75:0x01ba, B:86:0x01e5, B:88:0x01ea, B:89:0x01eb, B:64:0x0197, B:90:0x01ec, B:92:0x01f0, B:94:0x0203, B:96:0x0231, B:97:0x024b, B:22:0x0089, B:77:0x01bf, B:79:0x01c7, B:80:0x01cc, B:83:0x01d6, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:71:0x01b1, B:31:0x00ce), top: B:103:0x0001, inners: #1, #2, #3, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x00c4 A[Catch: all -> 0x0250, TryCatch #0 {, blocks: (B:23:0x008c, B:25:0x00b2, B:27:0x00b8, B:28:0x00c4, B:29:0x00cc, B:32:0x00d0, B:33:0x00d1, B:35:0x00dc, B:36:0x00dd, B:37:0x00de, B:39:0x00e4, B:41:0x00f1, B:43:0x00f8, B:45:0x0101, B:47:0x0105, B:49:0x0118, B:51:0x0146, B:44:0x00fd, B:52:0x0161, B:54:0x0165, B:55:0x0169, B:56:0x016b, B:58:0x016f, B:60:0x0173, B:61:0x0177, B:65:0x019a, B:67:0x01a7, B:68:0x01ac, B:70:0x01b0, B:72:0x01b3, B:73:0x01b4, B:75:0x01ba, B:86:0x01e5, B:88:0x01ea, B:89:0x01eb, B:64:0x0197, B:90:0x01ec, B:92:0x01f0, B:94:0x0203, B:96:0x0231, B:97:0x024b, B:22:0x0089, B:77:0x01bf, B:79:0x01c7, B:80:0x01cc, B:83:0x01d6, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:71:0x01b1, B:31:0x00ce), top: B:103:0x0001, inners: #1, #2, #3, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:39:0x00e4 A[Catch: all -> 0x0250, TryCatch #0 {, blocks: (B:23:0x008c, B:25:0x00b2, B:27:0x00b8, B:28:0x00c4, B:29:0x00cc, B:32:0x00d0, B:33:0x00d1, B:35:0x00dc, B:36:0x00dd, B:37:0x00de, B:39:0x00e4, B:41:0x00f1, B:43:0x00f8, B:45:0x0101, B:47:0x0105, B:49:0x0118, B:51:0x0146, B:44:0x00fd, B:52:0x0161, B:54:0x0165, B:55:0x0169, B:56:0x016b, B:58:0x016f, B:60:0x0173, B:61:0x0177, B:65:0x019a, B:67:0x01a7, B:68:0x01ac, B:70:0x01b0, B:72:0x01b3, B:73:0x01b4, B:75:0x01ba, B:86:0x01e5, B:88:0x01ea, B:89:0x01eb, B:64:0x0197, B:90:0x01ec, B:92:0x01f0, B:94:0x0203, B:96:0x0231, B:97:0x024b, B:22:0x0089, B:77:0x01bf, B:79:0x01c7, B:80:0x01cc, B:83:0x01d6, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:71:0x01b1, B:31:0x00ce), top: B:103:0x0001, inners: #1, #2, #3, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00f1 A[Catch: all -> 0x0250, TryCatch #0 {, blocks: (B:23:0x008c, B:25:0x00b2, B:27:0x00b8, B:28:0x00c4, B:29:0x00cc, B:32:0x00d0, B:33:0x00d1, B:35:0x00dc, B:36:0x00dd, B:37:0x00de, B:39:0x00e4, B:41:0x00f1, B:43:0x00f8, B:45:0x0101, B:47:0x0105, B:49:0x0118, B:51:0x0146, B:44:0x00fd, B:52:0x0161, B:54:0x0165, B:55:0x0169, B:56:0x016b, B:58:0x016f, B:60:0x0173, B:61:0x0177, B:65:0x019a, B:67:0x01a7, B:68:0x01ac, B:70:0x01b0, B:72:0x01b3, B:73:0x01b4, B:75:0x01ba, B:86:0x01e5, B:88:0x01ea, B:89:0x01eb, B:64:0x0197, B:90:0x01ec, B:92:0x01f0, B:94:0x0203, B:96:0x0231, B:97:0x024b, B:22:0x0089, B:77:0x01bf, B:79:0x01c7, B:80:0x01cc, B:83:0x01d6, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:71:0x01b1, B:31:0x00ce), top: B:103:0x0001, inners: #1, #2, #3, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00f8 A[Catch: all -> 0x0250, TryCatch #0 {, blocks: (B:23:0x008c, B:25:0x00b2, B:27:0x00b8, B:28:0x00c4, B:29:0x00cc, B:32:0x00d0, B:33:0x00d1, B:35:0x00dc, B:36:0x00dd, B:37:0x00de, B:39:0x00e4, B:41:0x00f1, B:43:0x00f8, B:45:0x0101, B:47:0x0105, B:49:0x0118, B:51:0x0146, B:44:0x00fd, B:52:0x0161, B:54:0x0165, B:55:0x0169, B:56:0x016b, B:58:0x016f, B:60:0x0173, B:61:0x0177, B:65:0x019a, B:67:0x01a7, B:68:0x01ac, B:70:0x01b0, B:72:0x01b3, B:73:0x01b4, B:75:0x01ba, B:86:0x01e5, B:88:0x01ea, B:89:0x01eb, B:64:0x0197, B:90:0x01ec, B:92:0x01f0, B:94:0x0203, B:96:0x0231, B:97:0x024b, B:22:0x0089, B:77:0x01bf, B:79:0x01c7, B:80:0x01cc, B:83:0x01d6, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:71:0x01b1, B:31:0x00ce), top: B:103:0x0001, inners: #1, #2, #3, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00fd A[Catch: all -> 0x0250, TryCatch #0 {, blocks: (B:23:0x008c, B:25:0x00b2, B:27:0x00b8, B:28:0x00c4, B:29:0x00cc, B:32:0x00d0, B:33:0x00d1, B:35:0x00dc, B:36:0x00dd, B:37:0x00de, B:39:0x00e4, B:41:0x00f1, B:43:0x00f8, B:45:0x0101, B:47:0x0105, B:49:0x0118, B:51:0x0146, B:44:0x00fd, B:52:0x0161, B:54:0x0165, B:55:0x0169, B:56:0x016b, B:58:0x016f, B:60:0x0173, B:61:0x0177, B:65:0x019a, B:67:0x01a7, B:68:0x01ac, B:70:0x01b0, B:72:0x01b3, B:73:0x01b4, B:75:0x01ba, B:86:0x01e5, B:88:0x01ea, B:89:0x01eb, B:64:0x0197, B:90:0x01ec, B:92:0x01f0, B:94:0x0203, B:96:0x0231, B:97:0x024b, B:22:0x0089, B:77:0x01bf, B:79:0x01c7, B:80:0x01cc, B:83:0x01d6, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:71:0x01b1, B:31:0x00ce), top: B:103:0x0001, inners: #1, #2, #3, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x0105 A[Catch: all -> 0x0250, TryCatch #0 {, blocks: (B:23:0x008c, B:25:0x00b2, B:27:0x00b8, B:28:0x00c4, B:29:0x00cc, B:32:0x00d0, B:33:0x00d1, B:35:0x00dc, B:36:0x00dd, B:37:0x00de, B:39:0x00e4, B:41:0x00f1, B:43:0x00f8, B:45:0x0101, B:47:0x0105, B:49:0x0118, B:51:0x0146, B:44:0x00fd, B:52:0x0161, B:54:0x0165, B:55:0x0169, B:56:0x016b, B:58:0x016f, B:60:0x0173, B:61:0x0177, B:65:0x019a, B:67:0x01a7, B:68:0x01ac, B:70:0x01b0, B:72:0x01b3, B:73:0x01b4, B:75:0x01ba, B:86:0x01e5, B:88:0x01ea, B:89:0x01eb, B:64:0x0197, B:90:0x01ec, B:92:0x01f0, B:94:0x0203, B:96:0x0231, B:97:0x024b, B:22:0x0089, B:77:0x01bf, B:79:0x01c7, B:80:0x01cc, B:83:0x01d6, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:71:0x01b1, B:31:0x00ce), top: B:103:0x0001, inners: #1, #2, #3, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x0118 A[Catch: all -> 0x0250, TryCatch #0 {, blocks: (B:23:0x008c, B:25:0x00b2, B:27:0x00b8, B:28:0x00c4, B:29:0x00cc, B:32:0x00d0, B:33:0x00d1, B:35:0x00dc, B:36:0x00dd, B:37:0x00de, B:39:0x00e4, B:41:0x00f1, B:43:0x00f8, B:45:0x0101, B:47:0x0105, B:49:0x0118, B:51:0x0146, B:44:0x00fd, B:52:0x0161, B:54:0x0165, B:55:0x0169, B:56:0x016b, B:58:0x016f, B:60:0x0173, B:61:0x0177, B:65:0x019a, B:67:0x01a7, B:68:0x01ac, B:70:0x01b0, B:72:0x01b3, B:73:0x01b4, B:75:0x01ba, B:86:0x01e5, B:88:0x01ea, B:89:0x01eb, B:64:0x0197, B:90:0x01ec, B:92:0x01f0, B:94:0x0203, B:96:0x0231, B:97:0x024b, B:22:0x0089, B:77:0x01bf, B:79:0x01c7, B:80:0x01cc, B:83:0x01d6, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:71:0x01b1, B:31:0x00ce), top: B:103:0x0001, inners: #1, #2, #3, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x0146 A[Catch: all -> 0x0250, TryCatch #0 {, blocks: (B:23:0x008c, B:25:0x00b2, B:27:0x00b8, B:28:0x00c4, B:29:0x00cc, B:32:0x00d0, B:33:0x00d1, B:35:0x00dc, B:36:0x00dd, B:37:0x00de, B:39:0x00e4, B:41:0x00f1, B:43:0x00f8, B:45:0x0101, B:47:0x0105, B:49:0x0118, B:51:0x0146, B:44:0x00fd, B:52:0x0161, B:54:0x0165, B:55:0x0169, B:56:0x016b, B:58:0x016f, B:60:0x0173, B:61:0x0177, B:65:0x019a, B:67:0x01a7, B:68:0x01ac, B:70:0x01b0, B:72:0x01b3, B:73:0x01b4, B:75:0x01ba, B:86:0x01e5, B:88:0x01ea, B:89:0x01eb, B:64:0x0197, B:90:0x01ec, B:92:0x01f0, B:94:0x0203, B:96:0x0231, B:97:0x024b, B:22:0x0089, B:77:0x01bf, B:79:0x01c7, B:80:0x01cc, B:83:0x01d6, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:71:0x01b1, B:31:0x00ce), top: B:103:0x0001, inners: #1, #2, #3, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x0161 A[Catch: all -> 0x0250, TryCatch #0 {, blocks: (B:23:0x008c, B:25:0x00b2, B:27:0x00b8, B:28:0x00c4, B:29:0x00cc, B:32:0x00d0, B:33:0x00d1, B:35:0x00dc, B:36:0x00dd, B:37:0x00de, B:39:0x00e4, B:41:0x00f1, B:43:0x00f8, B:45:0x0101, B:47:0x0105, B:49:0x0118, B:51:0x0146, B:44:0x00fd, B:52:0x0161, B:54:0x0165, B:55:0x0169, B:56:0x016b, B:58:0x016f, B:60:0x0173, B:61:0x0177, B:65:0x019a, B:67:0x01a7, B:68:0x01ac, B:70:0x01b0, B:72:0x01b3, B:73:0x01b4, B:75:0x01ba, B:86:0x01e5, B:88:0x01ea, B:89:0x01eb, B:64:0x0197, B:90:0x01ec, B:92:0x01f0, B:94:0x0203, B:96:0x0231, B:97:0x024b, B:22:0x0089, B:77:0x01bf, B:79:0x01c7, B:80:0x01cc, B:83:0x01d6, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:71:0x01b1, B:31:0x00ce), top: B:103:0x0001, inners: #1, #2, #3, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0165 A[Catch: all -> 0x0250, TryCatch #0 {, blocks: (B:23:0x008c, B:25:0x00b2, B:27:0x00b8, B:28:0x00c4, B:29:0x00cc, B:32:0x00d0, B:33:0x00d1, B:35:0x00dc, B:36:0x00dd, B:37:0x00de, B:39:0x00e4, B:41:0x00f1, B:43:0x00f8, B:45:0x0101, B:47:0x0105, B:49:0x0118, B:51:0x0146, B:44:0x00fd, B:52:0x0161, B:54:0x0165, B:55:0x0169, B:56:0x016b, B:58:0x016f, B:60:0x0173, B:61:0x0177, B:65:0x019a, B:67:0x01a7, B:68:0x01ac, B:70:0x01b0, B:72:0x01b3, B:73:0x01b4, B:75:0x01ba, B:86:0x01e5, B:88:0x01ea, B:89:0x01eb, B:64:0x0197, B:90:0x01ec, B:92:0x01f0, B:94:0x0203, B:96:0x0231, B:97:0x024b, B:22:0x0089, B:77:0x01bf, B:79:0x01c7, B:80:0x01cc, B:83:0x01d6, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:71:0x01b1, B:31:0x00ce), top: B:103:0x0001, inners: #1, #2, #3, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x0169 A[Catch: all -> 0x0250, TryCatch #0 {, blocks: (B:23:0x008c, B:25:0x00b2, B:27:0x00b8, B:28:0x00c4, B:29:0x00cc, B:32:0x00d0, B:33:0x00d1, B:35:0x00dc, B:36:0x00dd, B:37:0x00de, B:39:0x00e4, B:41:0x00f1, B:43:0x00f8, B:45:0x0101, B:47:0x0105, B:49:0x0118, B:51:0x0146, B:44:0x00fd, B:52:0x0161, B:54:0x0165, B:55:0x0169, B:56:0x016b, B:58:0x016f, B:60:0x0173, B:61:0x0177, B:65:0x019a, B:67:0x01a7, B:68:0x01ac, B:70:0x01b0, B:72:0x01b3, B:73:0x01b4, B:75:0x01ba, B:86:0x01e5, B:88:0x01ea, B:89:0x01eb, B:64:0x0197, B:90:0x01ec, B:92:0x01f0, B:94:0x0203, B:96:0x0231, B:97:0x024b, B:22:0x0089, B:77:0x01bf, B:79:0x01c7, B:80:0x01cc, B:83:0x01d6, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:71:0x01b1, B:31:0x00ce), top: B:103:0x0001, inners: #1, #2, #3, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x016f A[Catch: all -> 0x0250, TryCatch #0 {, blocks: (B:23:0x008c, B:25:0x00b2, B:27:0x00b8, B:28:0x00c4, B:29:0x00cc, B:32:0x00d0, B:33:0x00d1, B:35:0x00dc, B:36:0x00dd, B:37:0x00de, B:39:0x00e4, B:41:0x00f1, B:43:0x00f8, B:45:0x0101, B:47:0x0105, B:49:0x0118, B:51:0x0146, B:44:0x00fd, B:52:0x0161, B:54:0x0165, B:55:0x0169, B:56:0x016b, B:58:0x016f, B:60:0x0173, B:61:0x0177, B:65:0x019a, B:67:0x01a7, B:68:0x01ac, B:70:0x01b0, B:72:0x01b3, B:73:0x01b4, B:75:0x01ba, B:86:0x01e5, B:88:0x01ea, B:89:0x01eb, B:64:0x0197, B:90:0x01ec, B:92:0x01f0, B:94:0x0203, B:96:0x0231, B:97:0x024b, B:22:0x0089, B:77:0x01bf, B:79:0x01c7, B:80:0x01cc, B:83:0x01d6, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:71:0x01b1, B:31:0x00ce), top: B:103:0x0001, inners: #1, #2, #3, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0173 A[Catch: all -> 0x0250, TRY_LEAVE, TryCatch #0 {, blocks: (B:23:0x008c, B:25:0x00b2, B:27:0x00b8, B:28:0x00c4, B:29:0x00cc, B:32:0x00d0, B:33:0x00d1, B:35:0x00dc, B:36:0x00dd, B:37:0x00de, B:39:0x00e4, B:41:0x00f1, B:43:0x00f8, B:45:0x0101, B:47:0x0105, B:49:0x0118, B:51:0x0146, B:44:0x00fd, B:52:0x0161, B:54:0x0165, B:55:0x0169, B:56:0x016b, B:58:0x016f, B:60:0x0173, B:61:0x0177, B:65:0x019a, B:67:0x01a7, B:68:0x01ac, B:70:0x01b0, B:72:0x01b3, B:73:0x01b4, B:75:0x01ba, B:86:0x01e5, B:88:0x01ea, B:89:0x01eb, B:64:0x0197, B:90:0x01ec, B:92:0x01f0, B:94:0x0203, B:96:0x0231, B:97:0x024b, B:22:0x0089, B:77:0x01bf, B:79:0x01c7, B:80:0x01cc, B:83:0x01d6, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:71:0x01b1, B:31:0x00ce), top: B:103:0x0001, inners: #1, #2, #3, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x01a7 A[Catch: all -> 0x0250, TryCatch #0 {, blocks: (B:23:0x008c, B:25:0x00b2, B:27:0x00b8, B:28:0x00c4, B:29:0x00cc, B:32:0x00d0, B:33:0x00d1, B:35:0x00dc, B:36:0x00dd, B:37:0x00de, B:39:0x00e4, B:41:0x00f1, B:43:0x00f8, B:45:0x0101, B:47:0x0105, B:49:0x0118, B:51:0x0146, B:44:0x00fd, B:52:0x0161, B:54:0x0165, B:55:0x0169, B:56:0x016b, B:58:0x016f, B:60:0x0173, B:61:0x0177, B:65:0x019a, B:67:0x01a7, B:68:0x01ac, B:70:0x01b0, B:72:0x01b3, B:73:0x01b4, B:75:0x01ba, B:86:0x01e5, B:88:0x01ea, B:89:0x01eb, B:64:0x0197, B:90:0x01ec, B:92:0x01f0, B:94:0x0203, B:96:0x0231, B:97:0x024b, B:22:0x0089, B:77:0x01bf, B:79:0x01c7, B:80:0x01cc, B:83:0x01d6, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:71:0x01b1, B:31:0x00ce), top: B:103:0x0001, inners: #1, #2, #3, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x01b0 A[Catch: all -> 0x0250, TRY_LEAVE, TryCatch #0 {, blocks: (B:23:0x008c, B:25:0x00b2, B:27:0x00b8, B:28:0x00c4, B:29:0x00cc, B:32:0x00d0, B:33:0x00d1, B:35:0x00dc, B:36:0x00dd, B:37:0x00de, B:39:0x00e4, B:41:0x00f1, B:43:0x00f8, B:45:0x0101, B:47:0x0105, B:49:0x0118, B:51:0x0146, B:44:0x00fd, B:52:0x0161, B:54:0x0165, B:55:0x0169, B:56:0x016b, B:58:0x016f, B:60:0x0173, B:61:0x0177, B:65:0x019a, B:67:0x01a7, B:68:0x01ac, B:70:0x01b0, B:72:0x01b3, B:73:0x01b4, B:75:0x01ba, B:86:0x01e5, B:88:0x01ea, B:89:0x01eb, B:64:0x0197, B:90:0x01ec, B:92:0x01f0, B:94:0x0203, B:96:0x0231, B:97:0x024b, B:22:0x0089, B:77:0x01bf, B:79:0x01c7, B:80:0x01cc, B:83:0x01d6, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:71:0x01b1, B:31:0x00ce), top: B:103:0x0001, inners: #1, #2, #3, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x01ba A[Catch: all -> 0x0250, TRY_LEAVE, TryCatch #0 {, blocks: (B:23:0x008c, B:25:0x00b2, B:27:0x00b8, B:28:0x00c4, B:29:0x00cc, B:32:0x00d0, B:33:0x00d1, B:35:0x00dc, B:36:0x00dd, B:37:0x00de, B:39:0x00e4, B:41:0x00f1, B:43:0x00f8, B:45:0x0101, B:47:0x0105, B:49:0x0118, B:51:0x0146, B:44:0x00fd, B:52:0x0161, B:54:0x0165, B:55:0x0169, B:56:0x016b, B:58:0x016f, B:60:0x0173, B:61:0x0177, B:65:0x019a, B:67:0x01a7, B:68:0x01ac, B:70:0x01b0, B:72:0x01b3, B:73:0x01b4, B:75:0x01ba, B:86:0x01e5, B:88:0x01ea, B:89:0x01eb, B:64:0x0197, B:90:0x01ec, B:92:0x01f0, B:94:0x0203, B:96:0x0231, B:97:0x024b, B:22:0x0089, B:77:0x01bf, B:79:0x01c7, B:80:0x01cc, B:83:0x01d6, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:71:0x01b1, B:31:0x00ce), top: B:103:0x0001, inners: #1, #2, #3, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x01c7 A[Catch: all -> 0x01e4, TryCatch #1 {all -> 0x01e4, blocks: (B:77:0x01bf, B:79:0x01c7, B:80:0x01cc, B:83:0x01d6), top: B:104:0x01bf, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:83:0x01d6 A[Catch: all -> 0x01e4, TRY_LEAVE, TryCatch #1 {all -> 0x01e4, blocks: (B:77:0x01bf, B:79:0x01c7, B:80:0x01cc, B:83:0x01d6), top: B:104:0x01bf, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x01ec A[Catch: all -> 0x0250, TryCatch #0 {, blocks: (B:23:0x008c, B:25:0x00b2, B:27:0x00b8, B:28:0x00c4, B:29:0x00cc, B:32:0x00d0, B:33:0x00d1, B:35:0x00dc, B:36:0x00dd, B:37:0x00de, B:39:0x00e4, B:41:0x00f1, B:43:0x00f8, B:45:0x0101, B:47:0x0105, B:49:0x0118, B:51:0x0146, B:44:0x00fd, B:52:0x0161, B:54:0x0165, B:55:0x0169, B:56:0x016b, B:58:0x016f, B:60:0x0173, B:61:0x0177, B:65:0x019a, B:67:0x01a7, B:68:0x01ac, B:70:0x01b0, B:72:0x01b3, B:73:0x01b4, B:75:0x01ba, B:86:0x01e5, B:88:0x01ea, B:89:0x01eb, B:64:0x0197, B:90:0x01ec, B:92:0x01f0, B:94:0x0203, B:96:0x0231, B:97:0x024b, B:22:0x0089, B:77:0x01bf, B:79:0x01c7, B:80:0x01cc, B:83:0x01d6, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:71:0x01b1, B:31:0x00ce), top: B:103:0x0001, inners: #1, #2, #3, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x01f0 A[Catch: all -> 0x0250, TryCatch #0 {, blocks: (B:23:0x008c, B:25:0x00b2, B:27:0x00b8, B:28:0x00c4, B:29:0x00cc, B:32:0x00d0, B:33:0x00d1, B:35:0x00dc, B:36:0x00dd, B:37:0x00de, B:39:0x00e4, B:41:0x00f1, B:43:0x00f8, B:45:0x0101, B:47:0x0105, B:49:0x0118, B:51:0x0146, B:44:0x00fd, B:52:0x0161, B:54:0x0165, B:55:0x0169, B:56:0x016b, B:58:0x016f, B:60:0x0173, B:61:0x0177, B:65:0x019a, B:67:0x01a7, B:68:0x01ac, B:70:0x01b0, B:72:0x01b3, B:73:0x01b4, B:75:0x01ba, B:86:0x01e5, B:88:0x01ea, B:89:0x01eb, B:64:0x0197, B:90:0x01ec, B:92:0x01f0, B:94:0x0203, B:96:0x0231, B:97:0x024b, B:22:0x0089, B:77:0x01bf, B:79:0x01c7, B:80:0x01cc, B:83:0x01d6, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:71:0x01b1, B:31:0x00ce), top: B:103:0x0001, inners: #1, #2, #3, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0203 A[Catch: all -> 0x0250, TryCatch #0 {, blocks: (B:23:0x008c, B:25:0x00b2, B:27:0x00b8, B:28:0x00c4, B:29:0x00cc, B:32:0x00d0, B:33:0x00d1, B:35:0x00dc, B:36:0x00dd, B:37:0x00de, B:39:0x00e4, B:41:0x00f1, B:43:0x00f8, B:45:0x0101, B:47:0x0105, B:49:0x0118, B:51:0x0146, B:44:0x00fd, B:52:0x0161, B:54:0x0165, B:55:0x0169, B:56:0x016b, B:58:0x016f, B:60:0x0173, B:61:0x0177, B:65:0x019a, B:67:0x01a7, B:68:0x01ac, B:70:0x01b0, B:72:0x01b3, B:73:0x01b4, B:75:0x01ba, B:86:0x01e5, B:88:0x01ea, B:89:0x01eb, B:64:0x0197, B:90:0x01ec, B:92:0x01f0, B:94:0x0203, B:96:0x0231, B:97:0x024b, B:22:0x0089, B:77:0x01bf, B:79:0x01c7, B:80:0x01cc, B:83:0x01d6, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:71:0x01b1, B:31:0x00ce), top: B:103:0x0001, inners: #1, #2, #3, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x0231 A[Catch: all -> 0x0250, TryCatch #0 {, blocks: (B:23:0x008c, B:25:0x00b2, B:27:0x00b8, B:28:0x00c4, B:29:0x00cc, B:32:0x00d0, B:33:0x00d1, B:35:0x00dc, B:36:0x00dd, B:37:0x00de, B:39:0x00e4, B:41:0x00f1, B:43:0x00f8, B:45:0x0101, B:47:0x0105, B:49:0x0118, B:51:0x0146, B:44:0x00fd, B:52:0x0161, B:54:0x0165, B:55:0x0169, B:56:0x016b, B:58:0x016f, B:60:0x0173, B:61:0x0177, B:65:0x019a, B:67:0x01a7, B:68:0x01ac, B:70:0x01b0, B:72:0x01b3, B:73:0x01b4, B:75:0x01ba, B:86:0x01e5, B:88:0x01ea, B:89:0x01eb, B:64:0x0197, B:90:0x01ec, B:92:0x01f0, B:94:0x0203, B:96:0x0231, B:97:0x024b, B:22:0x0089, B:77:0x01bf, B:79:0x01c7, B:80:0x01cc, B:83:0x01d6, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:71:0x01b1, B:31:0x00ce), top: B:103:0x0001, inners: #1, #2, #3, #4, #5 }] */
    public static void a(e eVar, com.meishu.sdk.core.loader.d dVar, com.meishu.sdk.core.loader.loadbean.a aVar, Object obj) {
        String err;
        String strReplace;
        String err2;
        String strReplace2;
        synchronized (eVar) {
            try {
                int ecpm = dVar.getSdkAdInfo().getEcpm();
                if ("bidding".equals(dVar.getSdkAdInfo().getOtype()) && ecpm > 0 && (MSAdConfig.PLATFORM_GDT.equals(dVar.getSdkAdInfo().getSdk()) || "KS".equals(dVar.getSdkAdInfo().getSdk()) || MSAdConfig.PLATFORM_BD.equals(dVar.getSdkAdInfo().getSdk()) || "SGM".equals(dVar.getSdkAdInfo().getSdk()))) {
                    eVar.d.add(dVar);
                }
                if (MSAdConfig.PLATFORM_GDT.equals(dVar.getSdkAdInfo().getSdk()) && !TextUtils.isEmpty(dVar.getSdkAdInfo().getS2sb())) {
                    eVar.e.add(dVar.getSdkAdInfo());
                    eVar.p.remove(aVar);
                    aVar.getClass();
                    aVar.f4815a.setLoadedTime(SystemClock.uptimeMillis());
                    aVar.f4815a.replace();
                    aVar.b = obj;
                    if ("bidding".equals(aVar.f4815a.getOtype())) {
                        if (!eVar.a(aVar)) {
                            aVar.f = aVar.f4815a.getEcpm() + aVar.e;
                        } else {
                            eVar.g.remove(aVar);
                            eVar.i();
                            synchronized (aVar) {
                                aVar.c = 3;
                                eVar.p.remove(aVar);
                                eVar.h();
                            }
                        }
                    }
                    if (eVar.j) {
                        if (SystemClock.uptimeMillis() - eVar.m > eVar.s) {
                            eVar.x = true;
                            if (aVar.d == 2) {
                                aVar.d = 10;
                            } else {
                                aVar.d = 8;
                            }
                            if (aVar.f4815a != null) {
                                eVar.g.remove(aVar);
                                err2 = aVar.f4815a.getErr();
                                if (err2.contains("__MS_ERRNO__")) {
                                    strReplace2 = err2.replace("__MS_ERRNO__", "1025").replace("__TIMEOUT__", aVar.d + "");
                                    aVar.f4815a.setErr(strReplace2);
                                    if (!TextUtils.isEmpty(strReplace2)) {
                                        z.a(StubApp.getOrigApplicationContext(eVar.f4818a.getContext().getApplicationContext()), h0.a(strReplace2), new i());
                                    }
                                }
                            }
                        } else if (aVar.d == 2) {
                            aVar.d = 6;
                        } else {
                            aVar.d = 4;
                        }
                    }
                    if (!eVar.x) {
                        if (!eVar.j) {
                            z.a(dVar.getContext(), h0.a(aVar.f4815a.getRsp().replace("__TIMEOUT__", String.valueOf(aVar.d))), new i());
                            eVar.g.remove(aVar);
                            if (!eVar.n.contains(aVar)) {
                                eVar.n.add(aVar);
                            }
                            if (aVar.c == 4) {
                                synchronized (aVar) {
                                    aVar.c = 2;
                                    if (eVar.c(aVar)) {
                                        eVar.b(aVar);
                                    } else {
                                        if (!eVar.n.contains(aVar)) {
                                            eVar.n.add(aVar);
                                        }
                                        eVar.g.remove(aVar);
                                        if (eVar.j) {
                                            Collections.sort(eVar.n, new com.meishu.sdk.core.loader.strategy.d(eVar));
                                            eVar.i();
                                        }
                                    }
                                }
                            }
                        } else if (aVar.f4815a != null) {
                            eVar.g.remove(aVar);
                            err = aVar.f4815a.getErr();
                            if (err.contains("__MS_ERRNO__")) {
                                strReplace = err.replace("__MS_ERRNO__", "1025").replace("__TIMEOUT__", aVar.d + "");
                                aVar.f4815a.setErr(strReplace);
                                if (!TextUtils.isEmpty(strReplace)) {
                                    z.a(StubApp.getOrigApplicationContext(eVar.f4818a.getContext().getApplicationContext()), h0.a(strReplace), new i());
                                }
                            }
                        }
                    }
                    eVar.h();
                } else {
                    eVar.p.remove(aVar);
                    aVar.getClass();
                    aVar.f4815a.setLoadedTime(SystemClock.uptimeMillis());
                    aVar.f4815a.replace();
                    aVar.b = obj;
                    if ("bidding".equals(aVar.f4815a.getOtype())) {
                        if (!eVar.a(aVar)) {
                            aVar.f = aVar.f4815a.getEcpm() + aVar.e;
                        } else {
                            eVar.g.remove(aVar);
                            eVar.i();
                            synchronized (aVar) {
                                aVar.c = 3;
                            }
                            eVar.p.remove(aVar);
                            eVar.h();
                        }
                    }
                    if (eVar.j) {
                        if (SystemClock.uptimeMillis() - eVar.m > eVar.s) {
                            eVar.x = true;
                            if (aVar.d == 2) {
                                aVar.d = 10;
                            } else {
                                aVar.d = 8;
                            }
                            if (aVar.f4815a != null) {
                                eVar.g.remove(aVar);
                                err2 = aVar.f4815a.getErr();
                                if (err2.contains("__MS_ERRNO__")) {
                                    strReplace2 = err2.replace("__MS_ERRNO__", "1025").replace("__TIMEOUT__", aVar.d + "");
                                    aVar.f4815a.setErr(strReplace2);
                                    if (!TextUtils.isEmpty(strReplace2)) {
                                        z.a(StubApp.getOrigApplicationContext(eVar.f4818a.getContext().getApplicationContext()), h0.a(strReplace2), new i());
                                    }
                                }
                            }
                        } else if (aVar.d == 2) {
                            aVar.d = 6;
                        } else {
                            aVar.d = 4;
                        }
                    }
                    if (!eVar.x) {
                        if (!eVar.j) {
                            try {
                                z.a(dVar.getContext(), h0.a(aVar.f4815a.getRsp().replace("__TIMEOUT__", String.valueOf(aVar.d))), new i());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            eVar.g.remove(aVar);
                            if (!eVar.n.contains(aVar)) {
                                eVar.n.add(aVar);
                            }
                            if (aVar.c == 4) {
                                synchronized (aVar) {
                                    aVar.c = 2;
                                }
                                if (eVar.c(aVar)) {
                                    eVar.b(aVar);
                                } else {
                                    try {
                                        if (!eVar.n.contains(aVar)) {
                                            eVar.n.add(aVar);
                                        }
                                        eVar.g.remove(aVar);
                                        if (eVar.j) {
                                            Collections.sort(eVar.n, new com.meishu.sdk.core.loader.strategy.d(eVar));
                                            eVar.i();
                                        }
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                    }
                                }
                            }
                        } else if (aVar.f4815a != null) {
                            eVar.g.remove(aVar);
                            err = aVar.f4815a.getErr();
                            if (err.contains("__MS_ERRNO__")) {
                                strReplace = err.replace("__MS_ERRNO__", "1025").replace("__TIMEOUT__", aVar.d + "");
                                aVar.f4815a.setErr(strReplace);
                                if (!TextUtils.isEmpty(strReplace)) {
                                    z.a(StubApp.getOrigApplicationContext(eVar.f4818a.getContext().getApplicationContext()), h0.a(strReplace), new i());
                                }
                            }
                        }
                    }
                    eVar.h();
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            throw th;
        }
    }

    public final List<Integer> b(List<com.meishu.sdk.core.loader.loadbean.a> list, int i) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            try {
                com.meishu.sdk.core.loader.loadbean.a aVar = list.get(i2);
                SdkAdInfo sdkAdInfo = aVar.f4815a;
                if (sdkAdInfo != null) {
                    int ecpm = sdkAdInfo.getEcpm();
                    if (ecpm < i && ecpm > 0 && aVar.f4815a.getOriginEcpm() >= ecpm) {
                        arrayList.add(Integer.valueOf(aVar.f4815a.getOriginEcpm()));
                    }
                    int codPrice = aVar.f4815a.getCodPrice();
                    if (codPrice < i && codPrice > 0 && aVar.f4815a.getPrice() >= codPrice) {
                        arrayList.add(Integer.valueOf(aVar.f4815a.getPrice()));
                    }
                } else if (aVar.g && this.b.getEcpm() > 0 && this.b.getEcpm() < i) {
                    arrayList.add(Integer.valueOf(this.b.getEcpm()));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public final synchronized boolean a(com.meishu.sdk.core.loader.loadbean.a aVar) {
        boolean z;
        z = false;
        try {
            SdkAdInfo sdkAdInfo = aVar.f4815a;
            int ecpm = sdkAdInfo.getEcpm();
            if ("bidding".equals(sdkAdInfo.getOtype()) && sdkAdInfo.getCodPrice() > ecpm) {
                try {
                    SdkAdInfo sdkAdInfo2 = aVar.f4815a;
                    if (sdkAdInfo2 != null && sdkAdInfo2.getErr().contains("__MS_ERRNO__")) {
                        String strReplace = aVar.f4815a.getErr().replace("__MS_ERRNO__", "1027").replace("__ERROR_CODE__", String.valueOf(0)).replace("__TIMEOUT__", String.valueOf(aVar.d)).replace("__P__", String.valueOf(sdkAdInfo.getPrice())).replace("__S__", String.valueOf(ecpm));
                        if (!TextUtils.isEmpty(strReplace)) {
                            z.a(StubApp.getOrigApplicationContext(this.f4818a.getContext().getApplicationContext()), h0.a(strReplace), new i());
                        }
                    }
                    z = true;
                } catch (Exception e) {
                    e = e;
                    z = true;
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e = e2;
        }
        return z;
    }

    public final synchronized void a() {
        if (this.v) {
            return;
        }
        if (this.q.size() > 0) {
            com.meishu.sdk.core.loader.loadbean.a aVar = this.q.get(0);
            if (!this.o.contains(aVar)) {
                return;
            }
            if ((this.b.getCache() <= 0 || (this.b.getCache() > 0 && !this.r)) && this.k != null) {
                this.v = true;
                LogUtil.e("PriceFirstStrategy", com.meishu.sdk.activity.a.a("回调adReady,成功的平台为：").append(aVar.f4815a.getSdk()).append(", readyAd=").append(aVar.b).toString());
                g gVar = this.k;
                Object obj = aVar.b;
                com.meishu.sdk.core.loader.concurrent.e eVar = (com.meishu.sdk.core.loader.concurrent.e) gVar;
                if (eVar.e.getLoaderListener() != null && !eVar.j) {
                    LogUtil.d("ConCurrentManager", "onAdReady");
                    eVar.e.getLoaderListener().onAdReady(obj);
                    if (!eVar.j) {
                        eVar.i.post(new com.meishu.sdk.core.loader.concurrent.d(eVar, obj));
                    }
                }
            }
            if (this.b.getCache() > 0) {
                try {
                    Iterator<com.meishu.sdk.core.loader.loadbean.a> it = this.q.iterator();
                    while (it.hasNext()) {
                        com.meishu.sdk.core.loader.loadbean.a next = it.next();
                        if (next != null && next.equals(aVar)) {
                            it.remove();
                        }
                    }
                    Iterator<com.meishu.sdk.core.loader.loadbean.a> it2 = this.n.iterator();
                    while (it2.hasNext()) {
                        com.meishu.sdk.core.loader.loadbean.a next2 = it2.next();
                        if (next2 != null && next2.equals(aVar)) {
                            it2.remove();
                        }
                    }
                    Iterator<com.meishu.sdk.core.loader.loadbean.a> it3 = this.g.iterator();
                    while (it3.hasNext()) {
                        com.meishu.sdk.core.loader.loadbean.a next3 = it3.next();
                        if (next3 != null && next3.equals(aVar)) {
                            it3.remove();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final void a(SdkAdInfo sdkAdInfo) {
        int iIntValue;
        try {
            List<com.meishu.sdk.core.loader.d> list = this.d;
            if (list != null && list.size() > 0) {
                Iterator<com.meishu.sdk.core.loader.d> it = this.d.iterator();
                while (it.hasNext()) {
                    com.meishu.sdk.core.loader.d next = it.next();
                    if (next.getSdkAdInfo().getReq_uid() == sdkAdInfo.getReq_uid()) {
                        try {
                            a(sdkAdInfo.getEcpm(), sdkAdInfo.getPrice(), sdkAdInfo.getOtype());
                            iIntValue = this.z.size() > 0 ? this.z.get(0).intValue() : 0;
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        b(sdkAdInfo.getEcpm(), sdkAdInfo.getPrice(), sdkAdInfo.getOtype());
                        if (this.A.size() == 0) {
                            this.A.add(0);
                        }
                        if (this.A.size() > 0) {
                            int iIntValue2 = this.A.get(0).intValue();
                            try {
                                int iA = t0.a(iIntValue, iIntValue2, sdkAdInfo.getAt_rate(), sdkAdInfo.getPrice());
                                String finalRsp = sdkAdInfo.getFinalRsp();
                                if (!TextUtils.isEmpty(finalRsp)) {
                                    sdkAdInfo.setFinalRsp(finalRsp.replace("__S2__", String.valueOf(iA)));
                                }
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                            try {
                                ((BasePlatformLoader) next).sendGdtWinResult(true, iIntValue2);
                            } catch (Throwable th3) {
                                th3.printStackTrace();
                            }
                            it.remove();
                            return;
                        }
                    }
                }
            }
            List<SdkAdInfo> list2 = this.e;
            if (list2 == null || list2.size() <= 0) {
                return;
            }
            Iterator<SdkAdInfo> it2 = this.e.iterator();
            while (it2.hasNext()) {
                SdkAdInfo next2 = it2.next();
                if (next2.getReq_uid() == next2.getReq_uid()) {
                    b(sdkAdInfo.getCodPrice(), 0, sdkAdInfo.getOtype());
                    if (this.A.size() > 0) {
                        b(sdkAdInfo, this.A.get(0).intValue());
                        it2.remove();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(SdkAdInfo sdkAdInfo, int i) {
        S2sbResultBean s2sbResultBean;
        try {
            if (TextUtils.isEmpty(sdkAdInfo.getS2sb()) || (s2sbResultBean = (S2sbResultBean) new Gson().fromJson(sdkAdInfo.getS2sb(), S2sbResultBean.class)) == null) {
                return;
            }
            z.a(this.f4818a.getContext(), s2sbResultBean.getLurl().replace("AUCTION_PRICE", String.valueOf(i)).replace("AUCTION_SEAT_ID", String.valueOf(2)).replace("AUCTION_LOSS", String.valueOf(1)), new i());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(int i, int i2, String str) {
        try {
            this.z.clear();
            this.z.addAll(a(this.n, i));
            this.z.addAll(a(this.q, i));
            this.z.addAll(a(this.g, i));
            this.z.addAll(a(d(), i));
            if (i2 > 0 && "bidding".equals(str)) {
                this.z.add(Integer.valueOf(i2));
            }
            Collections.sort(this.z, new c(this));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final List<Integer> a(List<com.meishu.sdk.core.loader.loadbean.a> list, int i) {
        ArrayList arrayList = new ArrayList();
        try {
            if (list.size() > 0) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    com.meishu.sdk.core.loader.loadbean.a aVar = list.get(i2);
                    SdkAdInfo sdkAdInfo = aVar.f4815a;
                    if (sdkAdInfo != null) {
                        if (sdkAdInfo.getEcpm() > 0 && sdkAdInfo.getEcpm() >= i && sdkAdInfo.getOriginEcpm() >= sdkAdInfo.getEcpm()) {
                            arrayList.add(Integer.valueOf(sdkAdInfo.getOriginEcpm()));
                        }
                        if (sdkAdInfo.getCodPrice() > 0 && sdkAdInfo.getCodPrice() >= i && sdkAdInfo.getPrice() >= sdkAdInfo.getCodPrice()) {
                            arrayList.add(Integer.valueOf(sdkAdInfo.getPrice()));
                        }
                    } else if (aVar.g && this.b.getEcpm() > 0 && this.b.getEcpm() >= i) {
                        arrayList.add(Integer.valueOf(this.b.getEcpm()));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public final void a(List<com.meishu.sdk.core.loader.loadbean.a> list) {
        try {
            Collections.sort(list, new C0797e(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
