package com.opos.acs.st.utils;

import android.content.Context;
import com.opos.cmn.biz.requeststatistic.InitParams;
import com.opos.cmn.biz.requeststatistic.RequestStatisticManager;
import com.opos.cmn.biz.requeststatistic.StatisticEvent;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class g {
    private static volatile g b;
    private static byte[] c = new byte[1];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f5862a;

    private g(Context context) {
        if (context != null) {
            this.f5862a = context;
            b();
        }
    }

    public static g a(Context context) {
        if (b == null) {
            synchronized (c) {
                if (b == null) {
                    b = new g(context);
                }
            }
        }
        return b;
    }

    private void a(StatisticEvent statisticEvent) {
        try {
            RequestStatisticManager.getInstance().report(statisticEvent);
        } catch (Exception e) {
            f.c("ReportErrorEngine", "report error Exception", e);
        }
    }

    private void b() {
        RequestStatisticManager.getInstance().init(this.f5862a, new InitParams.Builder().build());
    }

    private boolean c() {
        boolean z = !"WIFI".equalsIgnoreCase(k.b(this.f5862a));
        com.opos.cmn.an.f.a.b("ReportErrorEngine", "isWifi:" + z);
        return z;
    }

    public void a() {
        try {
            if (c()) {
                RequestStatisticManager.getInstance().reportCacheIfNeed();
            }
        } catch (Exception e) {
            f.c("ReportErrorEngine", "report all error Exception", e);
        }
    }

    public void a(Map map) {
        try {
            f.a("ReportErrorEngine", "errorMap=" + (map != null ? map : "null"));
            StatisticEvent statisticEventA = com.opos.acs.st.entity.a.a(map);
            if (statisticEventA != null) {
                a(statisticEventA);
            }
        } catch (Exception e) {
            f.c("ReportErrorEngine", "reportOneRecord error Exception", e);
        }
    }
}
