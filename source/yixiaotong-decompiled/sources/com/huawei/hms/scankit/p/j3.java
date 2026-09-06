package com.huawei.hms.scankit.p;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.C;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hms.hatool.HmsHiAnalyticsUtils;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: HiAnalyticsLogExecutor.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class j3 {
    private static volatile j3 h = new j3();
    private static String[] i = {"AD", "AL", "AN", "AT", "AU", "AX", "BA", "BE", "BG", "BQ", "CA", "CH", "CW", "CY", "CZ", "DE", "DK", "EE", "ES", "FI", "FO", "FR", "GB", "GG", "GI", "GL", "GR", "HR", "HU", "IE", "IL", "IM", "IS", "IT", "JE", "LI", "LT", "LU", "LV", "MC", "MD", "ME", "MF", "MK", "MT", "NL", "NO", "NZ", "PL", "PM", "PT", "RO", "RS", "SE", "SI", "SJ", "SK", "SM", "SX", "TR", "UA", "UM", "US", "VA", "VC", "XK", "YK"};
    private volatile boolean c;
    private volatile long d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Timer f4283a = new Timer();
    private volatile boolean b = true;
    private volatile boolean e = false;
    private final Lock f = new ReentrantLock();
    private List<b> g = new ArrayList(5);

    /* JADX INFO: compiled from: HiAnalyticsLogExecutor.java */
    class a extends Thread {
        a(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            j3.this.d();
        }
    }

    /* JADX INFO: compiled from: HiAnalyticsLogExecutor.java */
    private class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f4285a;
        private LinkedHashMap<String, String> b;

        /* synthetic */ b(j3 j3Var, String str, LinkedHashMap linkedHashMap, a aVar) {
            this(str, linkedHashMap);
        }

        private b(String str, LinkedHashMap<String, String> linkedHashMap) {
            this.f4285a = str;
            this.b = linkedHashMap;
        }
    }

    /* JADX INFO: compiled from: HiAnalyticsLogExecutor.java */
    private class c extends TimerTask {
        private c() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                j3.this.b = true;
                HmsHiAnalyticsUtils.onReport();
            } catch (Exception e) {
                x3.b("ScanHiAnalytics", e.getMessage());
            }
        }

        /* synthetic */ c(j3 j3Var, a aVar) {
            this();
        }
    }

    private j3() {
    }

    public static j3 b() {
        return h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (!this.f.tryLock() || this.c) {
            return;
        }
        try {
            Context context = DynamicModuleInitializer.getContext();
            if (context == null) {
                return;
            }
            String strA = a(context);
            if (strA != null && !strA.isEmpty()) {
                HmsHiAnalyticsUtils.init(context, false, false, false, strA, context.getPackageName());
                HmsHiAnalyticsUtils.enableLog();
                a();
            }
        } finally {
            this.f.unlock();
        }
    }

    private void c(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (!this.e) {
            HmsHiAnalyticsUtils.onEvent(0, str, linkedHashMap);
            HmsHiAnalyticsUtils.onEvent(1, str, linkedHashMap);
        }
        if (this.b) {
            this.b = false;
            this.f4283a.schedule(new c(this, null), C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        }
        x3.c("ScanHiAnalytics", str + PPSLabelView.Code + linkedHashMap.toString());
    }

    public void b(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (this.c) {
            c(str, linkedHashMap);
        } else {
            a(str, linkedHashMap);
            c();
        }
    }

    private synchronized void a(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (this.c) {
            c(str, linkedHashMap);
        } else {
            if (this.g.size() >= 100) {
                return;
            }
            this.g.add(new b(this, str, linkedHashMap, null));
        }
    }

    private void c() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.d > 6000) {
            this.d = jCurrentTimeMillis;
            new a("ScanHiAnalytics").start();
        }
    }

    private synchronized void a() {
        this.c = true;
        for (b bVar : this.g) {
            c(bVar.f4285a, bVar.b);
        }
        this.g = null;
    }

    private String a(Context context) {
        try {
            GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
            String strA = new w0(context, false).a();
            Log.i("ScanHiAnalytics", "getCollectURL:localCountryCode " + strA);
            if (strA != null && !strA.isEmpty() && !"UNKNOWN".equals(strA)) {
                grsBaseInfo.setSerCountry(strA.toUpperCase(Locale.ENGLISH));
            }
            if (Arrays.asList(i).contains(strA)) {
                this.e = true;
            }
            GrsClient grsClient = new GrsClient(context, grsBaseInfo);
            String strSynGetGrsUrl = grsClient.synGetGrsUrl("com.huawei.cloud.mlkithianalytics", "ROOTNEW");
            if (TextUtils.isEmpty(strSynGetGrsUrl)) {
                strSynGetGrsUrl = grsClient.synGetGrsUrl("com.huawei.cloud.mlkithianalytics", "ROOT");
            }
            Log.i("ScanHiAnalytics", "grs get url success: " + strSynGetGrsUrl + "  countryCode = " + grsBaseInfo.getSerCountry());
            return strSynGetGrsUrl;
        } catch (RuntimeException | Exception unused) {
            return null;
        }
    }
}
