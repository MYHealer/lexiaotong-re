package com.huawei.hms.mlkit.common.ha;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import com.huawei.hms.framework.common.SystemPropUtils;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.framework.network.grs.GrsApi;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.ml.camera.CountryCodeBean;
import com.huawei.hms.mlkit.common.ha.event.BaseInfoGatherEvent;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class HianalyticsLogProvider {
    public static volatile Map<String, Long> h = new HashMap();
    public static Map<String, Timer> i = new HashMap();
    public static volatile HianalyticsLogProvider j = new HianalyticsLogProvider();
    public Context d;
    public a e;
    public GrsBaseInfo f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f4149a = false;
    public volatile boolean b = true;
    public String c = null;
    public Map<String, Map<String, Long>> g = new HashMap();

    public static HianalyticsLogProvider getInstance() {
        return j;
    }

    public final boolean a(Context context) {
        if (a() || this.f4149a) {
            return true;
        }
        b.a("HaLogProvider", "initlizeHaSdk APK mode,BUILD_MODE=APK");
        if (this.f == null) {
            this.f = new GrsBaseInfo();
            String str = this.e.f;
            b.b("HaLogProvider", "initGrsBaseInfo CountryCode = " + str);
            if (str != null && !str.isEmpty() && !"UNKNOWN".equals(str)) {
                this.f.setSerCountry(str.toUpperCase(Locale.ENGLISH));
            }
        }
        GrsApi.grsSdkInit(context, this.f);
        String strSynGetGrsUrl = GrsApi.synGetGrsUrl("com.huawei.cloud.mlkithianalytics", "ROOT");
        b.a("HaLogProvider", "GrsApi.synGetGrsUrl=" + strSynGetGrsUrl + ",BuildConfig.HIA_MODE=com.huawei.cloud.mlkithianalytics");
        this.f4149a = true;
        if (strSynGetGrsUrl == null || strSynGetGrsUrl.isEmpty()) {
            b.a("HaLogProvider", "grs get url is empty, countryCode=" + this.f.getSerCountry());
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(strSynGetGrsUrl);
        return c.f4152a.a(context, arrayList);
    }

    public final boolean b(Context context) {
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(new Intent("com.huawei.hms.core.aidlservice"), 128);
        Pair pair = null;
        if (listQueryIntentServices.size() != 0) {
            Iterator<ResolveInfo> it = listQueryIntentServices.iterator();
            if (it.hasNext()) {
                ResolveInfo next = it.next();
                pair = new Pair(next.serviceInfo.applicationInfo.packageName, next);
            }
        }
        if (pair == null) {
            return false;
        }
        try {
            return (context.getPackageManager().getPackageInfo((String) pair.first, 0).applicationInfo.flags & 1) != 0;
        } catch (Exception e) {
            b.c("HaLogProvider", "isPackageInternal Exception e: " + e);
            return false;
        }
    }

    public String getTransId() {
        String str = this.c;
        return str == null ? "" : str;
    }

    public HianalyticsLog logBegin(Context context, Bundle bundle) {
        this.d = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.e = d.a(context, bundle);
        HianalyticsLog hianalyticsLog = new HianalyticsLog();
        if (a() || !a(context)) {
            return hianalyticsLog;
        }
        hianalyticsLog.d(String.valueOf(System.currentTimeMillis()));
        return hianalyticsLog;
    }

    public void logEnd(HianalyticsLog hianalyticsLog) {
        try {
            if (a()) {
                b.b("HaLogProvider", "in logEnd, HA is forbiddenHiLog");
                return;
            }
            if (hianalyticsLog == null) {
                b.a("HaLogProvider", "in logEnd, haLog is null");
                return;
            }
            if (hianalyticsLog.f() == null) {
                b.b("HaLogProvider", "in logEnd, initlizeHaSdk is not well, so HA is forbiddenHiLog");
                return;
            }
            a(hianalyticsLog);
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strL = hianalyticsLog.l();
            if (h != null) {
                Long l = h.get(strL);
                if (l == null) {
                    l = 0L;
                    h.put(strL, l);
                }
                if (this.b || jCurrentTimeMillis - l.longValue() > 1000) {
                    a(hianalyticsLog, jCurrentTimeMillis - Long.parseLong(hianalyticsLog.f()));
                    LinkedHashMap<String, String> linkedHashMapA = d.a(hianalyticsLog);
                    a(strL, linkedHashMapA);
                    c.f4152a.a(this.d, 1, "60001", linkedHashMapA);
                    c.f4152a.a(this.d, 0, "60001", linkedHashMapA);
                    this.b = false;
                    b.a("HaLogProvider", linkedHashMapA.toString());
                    h.put(strL, Long.valueOf(jCurrentTimeMillis));
                    if (this.g.containsKey(strL)) {
                        this.g.remove(strL);
                    }
                }
            }
            Log.i("HaLogProvider", "success HA logEnd, module name is: " + strL);
        } catch (Exception unused) {
            Log.e("HaLogProvider", "logEnd: GetNullException");
        }
    }

    public void postEvent(Context context, int i2, BaseInfoGatherEvent baseInfoGatherEvent) {
        this.d = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (this.c == null) {
            this.c = UUID.randomUUID().toString();
        }
        if (baseInfoGatherEvent == null) {
            return;
        }
        this.e = d.a(context, baseInfoGatherEvent.getAppInfo());
        if (a()) {
            b.b("HaLogProvider", "HA is forbidden!");
            return;
        }
        if (!a(context)) {
            b.a("HaLogProvider", "HA initializ fail!");
            return;
        }
        if ((i2 & 1) == 1) {
            c.f4152a.a(context, 1, baseInfoGatherEvent.getEventId(), baseInfoGatherEvent.getEventData(context));
        }
        if ((i2 & 2) == 2) {
            c.f4152a.a(context, 0, baseInfoGatherEvent.getEventId(), baseInfoGatherEvent.getEventData(context));
        }
        if ((i2 & 4) == 4) {
            c.f4152a.a(context, 2, baseInfoGatherEvent.getEventId(), baseInfoGatherEvent.getEventData(context));
        }
    }

    public void reportAndCancelTimer() {
    }

    public boolean sdkForbiddenHiLog(Context context) {
        if (!b(context) || this.e == null) {
            Log.i("HaLogProvider", "hms core do not exist or appInfo is null, sdkForbiddenHiLog");
            return false;
        }
        b.a("HaLogProvider", "forbiddenHiLog openHa = " + this.e.e);
        return b();
    }

    public void initTimer(String str) {
        if (this.c == null) {
            this.c = UUID.randomUUID().toString();
        }
        if (i.get(str) == null) {
            Timer timer = new Timer();
            timer.schedule(new e(), 0L, 5000L);
            i.put(str, timer);
            b.b("HaLogProvider", "init timer, timer=" + timer + ",moduleName=" + str);
        }
        if (this.g.containsKey(str)) {
            this.g.remove(str);
        }
    }

    public void reportAndCancelTimer(String str) {
        if (this.c != null) {
            this.c = null;
        }
        this.b = true;
        h.clear();
        Timer timer = i.get(str);
        if (timer != null) {
            if (!a()) {
                c.f4152a.a();
            }
            b.b("HaLogProvider", "cancel timer, timer=" + timer + ",moduleName=" + str);
            timer.cancel();
            i.remove(str);
        }
    }

    public final boolean b() {
        String property;
        String str = "UNKNOWN";
        if ("HONOR".equals(Build.BRAND)) {
            property = SystemPropUtils.getProperty("get", "msc.sys.country", CountryCodeBean.ANDRIOD_SYSTEMPROP, "UNKNOWN");
        } else {
            property = SystemPropUtils.getProperty("get", "ro.hw.country", CountryCodeBean.ANDRIOD_SYSTEMPROP, "UNKNOWN");
        }
        if (!CountryCodeBean.SPECIAL_COUNTRYCODE_EU.equalsIgnoreCase(property) && !CountryCodeBean.SPECIAL_COUNTRYCODE_LA.equalsIgnoreCase(property)) {
            str = property;
        }
        b.a("HaLogProvider", "forbiddenHiLog.getVenderCountry=" + str);
        if ("CN".equalsIgnoreCase(str)) {
            Log.i("HaLogProvider", "no HaForbidden, ha data up directly");
            return false;
        }
        if (this.e != null) {
            b.a("HaLogProvider", "forbiddenHiLog openHa = " + this.e.e);
            return !this.e.e;
        }
        b.a("HaLogProvider", "forbiddenHiLog openHa is empty, appInfo is null");
        return true;
    }

    public final boolean a() {
        Log.i("HaLogProvider", "in common ha, BUILD_MODE is: APK");
        return b();
    }

    public final void a(HianalyticsLog hianalyticsLog, long j2) {
        hianalyticsLog.e(String.valueOf(j2));
        hianalyticsLog.m(this.e.f4150a);
        hianalyticsLog.c(this.e.b);
        hianalyticsLog.p(this.e.c);
        hianalyticsLog.b(this.e.d);
        hianalyticsLog.l(d.b(this.d));
        hianalyticsLog.h(Build.MODEL);
        hianalyticsLog.i(d.a());
        hianalyticsLog.a(Build.VERSION.RELEASE);
        hianalyticsLog.g("");
        hianalyticsLog.n("MLKit");
        hianalyticsLog.f(this.e.f);
        hianalyticsLog.j("");
        hianalyticsLog.o(this.c);
        hianalyticsLog.k(d.a(this.d));
    }

    public final void a(HianalyticsLog hianalyticsLog) {
        String strL = hianalyticsLog.l();
        Map<String, Long> map = this.g.get(strL);
        if (map == null) {
            map = new HashMap<>();
            map.put("allCnt", 0L);
            map.put("costTimeAll", 0L);
            this.g.put(strL, map);
        }
        map.put("allCnt", Long.valueOf((map.get("allCnt") == null ? 0L : map.get("allCnt").longValue()) + 1));
        long jLongValue = map.get("failCnt") == null ? 0L : map.get("failCnt").longValue();
        if (!hianalyticsLog.u()) {
            map.put("failCnt", Long.valueOf(jLongValue + 1));
        }
        map.put("costTimeAll", Long.valueOf((map.get("costTimeAll") != null ? map.get("costTimeAll").longValue() : 0L) + (System.currentTimeMillis() - Long.parseLong(hianalyticsLog.f()))));
        this.g.put(strL, map);
    }

    public final void a(String str, LinkedHashMap<String, String> linkedHashMap) {
        Map<String, Long> map = this.g.get(str);
        if (map != null) {
            long jLongValue = map.get("allCnt") == null ? 0L : map.get("allCnt").longValue();
            linkedHashMap.put("allCnt", String.valueOf(jLongValue));
            long jLongValue2 = map.get("failCnt") == null ? 0L : map.get("failCnt").longValue();
            linkedHashMap.put("failCnt", String.valueOf(jLongValue2));
            linkedHashMap.put(WiseOpenHianalyticsData.UNION_COSTTIME, String.valueOf(jLongValue != 0 ? (map.get("costTimeAll") == null ? 0L : map.get("costTimeAll").longValue()) / jLongValue : 0L));
            linkedHashMap.put("lastCallTime", String.valueOf(System.currentTimeMillis()));
            linkedHashMap.put("result", String.format("{0:%s}", String.valueOf(jLongValue - jLongValue2)));
        }
    }
}
