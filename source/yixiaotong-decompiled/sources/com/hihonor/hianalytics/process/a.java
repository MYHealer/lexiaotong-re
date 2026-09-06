package com.hihonor.hianalytics.process;

import android.content.Context;
import android.text.TextUtils;
import com.hihonor.hianalytics.hnha.g;
import com.hihonor.hianalytics.hnha.j2;
import com.hihonor.hianalytics.hnha.x0;
import com.hihonor.hianalytics.util.SystemUtils;
import com.hihonor.hianalytics.util.m;
import com.hihonor.hianalytics.util.o;
import com.hihonor.hianalytics.util.p;
import com.yfanads.android.utils.YFAdsConst;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class a {
    private static final String[] c = {"ABTesting", "_default_config_tag"};
    private static a d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, d> f3708a = new ConcurrentHashMap<>();
    private c b = null;

    private a() {
    }

    public static a c() {
        if (d == null) {
            g();
        }
        return d;
    }

    private static synchronized void g() {
        if (d == null) {
            d = new a();
        }
    }

    public d a(String str, d dVar) {
        d dVarPutIfAbsent = this.f3708a.putIfAbsent(str, dVar);
        try {
            x0.c().a(str, this.f3708a.get(str).b);
        } catch (Throwable th) {
            j2.e("HiAnalyticsDataManager", "registerInstance tag=" + str + " failE=" + SystemUtils.getDesensitizedException(th));
        }
        return dVarPutIfAbsent;
    }

    public void a() {
        if (SystemUtils.getContext() == null) {
            j2.e("HiAnalyticsDataManager", "clearCachedData sdk is not init");
            return;
        }
        j2.c("HiAnalyticsDataManager", "clearCachedData is execute.");
        p.a("", true);
        try {
            m.a("", true);
        } catch (Throwable th) {
            j2.a("HiAnalyticsDataManager", "clearCachedData no mmkv mode withException=" + SystemUtils.getDesensitizedException(th));
        }
    }

    public void a(int i) {
        if (SystemUtils.getContext() == null) {
            j2.e("HiAnalyticsDataManager", "setAutoReportNum must before init withValue=" + i);
            return;
        }
        int iA = o.a(i, 1000, 30);
        j2.c("HiAnalyticsDataManager", "setReportInterval autoReportNum=" + i + ",newAutoNum=" + iA);
        g.a(iA);
    }

    public void a(c cVar) {
        this.b = cVar;
        x0.c().a("_instance_ex_tag", cVar.b);
    }

    public void a(String str) {
        if (SystemUtils.getContext() == null) {
            j2.e("HiAnalyticsDataManager", "clearDataByTag sdk is not init with tag=" + str);
            return;
        }
        j2.c("HiAnalyticsDataManager", "clearDataByTag execute with tag=" + str);
        p.b(str);
        try {
            m.a(str);
        } catch (Throwable th) {
            j2.a("HiAnalyticsDataManager", "clearDataByTag no mmkv mode withException=" + SystemUtils.getDesensitizedException(th));
        }
    }

    public void a(boolean z) {
        if (SystemUtils.getContext() == null) {
            j2.e("HiAnalyticsDataManager", "setBackToReportOpera must before init withValue=" + z);
        } else {
            j2.c("HiAnalyticsDataManager", "setBackToReportOpera isBackToReportOpera=" + z);
            g.b(z);
        }
    }

    public List<String> b() {
        return new ArrayList(this.f3708a.keySet());
    }

    public void b(int i) {
        if (SystemUtils.getContext() == null) {
            j2.e("HiAnalyticsDataManager", "setReportInterval must before init withValue=" + i);
            return;
        }
        int iA = o.a(i, 14400, 60);
        j2.c("HiAnalyticsDataManager", "setReportInterval reportInterval=" + i + ",newInterval=" + iA);
        g.c(iA);
    }

    public void b(boolean z) {
        if (SystemUtils.getContext() == null) {
            j2.e("HiAnalyticsDataManager", "setOpenAegisRandom must before init withValue=" + z);
        } else {
            j2.c("HiAnalyticsDataManager", "setOpenAegisRandom isOpen=" + z);
            g.d(z);
        }
    }

    public boolean b(String str) {
        if (str == null) {
            j2.e("HiAnalyticsDataManager", "registerInstance tag Can't be null");
            return false;
        }
        j2.a("HiAnalyticsDataManager", "getInitFlag tag=" + str);
        if ("_instance_ex_tag".equals(str)) {
            return this.b != null;
        }
        return this.f3708a.containsKey(str);
    }

    public d c(String str) {
        if (str == null) {
            j2.e("HiAnalyticsDataManager", "getInstanceByTag tag Can't be null");
            return null;
        }
        d dVar = this.f3708a.get(str);
        j2.a("HiAnalyticsDataManager", "getInstanceByTag: TAG: " + str + (dVar == null ? " not found." : " found."));
        return dVar;
    }

    public void c(int i) {
        if (SystemUtils.getContext() == null) {
            j2.e("HiAnalyticsDataManager", "setSPCacheSize not init withSize=" + i);
            return;
        }
        int iA = o.a(i, Integer.MAX_VALUE, 5);
        j2.c("HiAnalyticsDataManager", "setSPCacheSize withSize=" + i + ",newValue=" + iA);
        g.b(iA);
    }

    public void c(boolean z) {
        j2.c("HiAnalyticsDataManager", "setUnusualDataIgnored isUnusualDataIgnored=" + z);
        g.e(z);
    }

    public c d() {
        return this.b;
    }

    public boolean d(String str) {
        for (String str2 : c) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public int e() {
        return this.f3708a.size();
    }

    public void e(String str) throws IllegalAccessException, InvocationTargetException {
        Context context = SystemUtils.getContext();
        if (context == null) {
            j2.e("HiAnalyticsDataManager", "setAppid not init withValue=" + str);
            return;
        }
        String strA = o.a(YFAdsConst.REPORT_APPID, str, "[a-zA-Z0-9_][a-zA-Z0-9. _-]{0,255}", context.getPackageName());
        j2.c("HiAnalyticsDataManager", "setAppid oldValue=" + str + ",newValue=" + strA);
        g.c(strA);
    }

    public int f() {
        int i = 0;
        for (String str : c) {
            if (this.f3708a.containsKey(str)) {
                i++;
            }
        }
        return i;
    }

    public void f(String str) {
        if (SystemUtils.getContext() == null) {
            j2.e("HiAnalyticsDataManager", "setCustomPkgName must before init withValue=" + str);
        } else if (TextUtils.isEmpty(str) || str.length() > 256) {
            j2.g("HiAnalyticsDataManager", "setCustomPkgName illegalValue=" + str);
        } else {
            j2.c("HiAnalyticsDataManager", "setCustomPkgName value=" + str);
            g.d(str);
        }
    }
}
