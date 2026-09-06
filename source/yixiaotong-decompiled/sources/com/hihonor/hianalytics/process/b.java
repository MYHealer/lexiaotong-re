package com.hihonor.hianalytics.process;

import android.text.TextUtils;
import com.hihonor.hianalytics.hnha.j;
import com.hihonor.hianalytics.hnha.j2;
import com.hihonor.hianalytics.hnha.k;
import com.hihonor.hianalytics.hnha.p2;
import com.hihonor.hianalytics.util.g;
import com.hihonor.hianalytics.util.h;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f3709a;

    public static void a() {
        a.c().a();
        int iC = k.a().c();
        j2.c("HiAnalyticsEventManager", "clearCachedData num=" + iC + ",nowTotalNum=" + h.a(iC));
    }

    public static void a(String str) {
        a.c().a(str);
        int iA = k.a().a(str);
        j2.c("HiAnalyticsEventManager", "clearData tag=" + str + ",num=" + iA + ",nowTotalNum=" + h.a(iA));
    }

    public static void a(String str, int i) {
        j2.a("HiAnalyticsEventManager", "notifyIdAttrsChange tag=" + str + "type=" + i + ",newMode=true");
        j.b(str, i);
    }

    public static void a(String str, int i, int i2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strA = g.a(i);
        boolean zIsEmpty = TextUtils.isEmpty(str);
        long jG = zIsEmpty ? 0L : com.hihonor.hianalytics.hnha.h.g(str, strA);
        long j = jCurrentTimeMillis - jG;
        long jB = b(str);
        if (!zIsEmpty && jG != 0 && j <= jB && j >= -300000) {
            int i3 = f3709a + 1;
            f3709a = i3;
            j2.a(i3 > 2 ? 3 : 5, "HiAnalyticsEventManager", "autoReport timeoutWithTag=" + str + ",type=" + i + ",intervalTime=" + j + ",reportType=" + i2 + ",failCount=" + i3);
            p2.g().a(str, i, i2, 40100);
            return;
        }
        j2.c("HiAnalyticsEventManager", "autoReport beginCallOnReportWithTag=" + str + ",type=" + i + ",intervalTime=" + j + ",reportType=" + i2 + ",failCount=" + f3709a);
        f3709a = 0;
        if (!zIsEmpty) {
            if (TextUtils.isEmpty(str) || !str.equals("_default_config_tag")) {
                com.hihonor.hianalytics.hnha.h.a(jCurrentTimeMillis, str, strA);
            } else {
                com.hihonor.hianalytics.hnha.h.a(jCurrentTimeMillis);
            }
        }
        p2.c().a(str, i, i2);
    }

    private static long b(String str) {
        long jD = p2.b().d(str);
        if (jD == -1) {
            return 30000L;
        }
        return jD;
    }

    public static void c(String str) {
        j2.a("HiAnalyticsEventManager", "notifyIdAttrsChange tag=" + str + ",newMode=true");
        j.b(str);
    }
}
