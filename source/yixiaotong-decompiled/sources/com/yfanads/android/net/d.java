package com.yfanads.android.net;

import android.text.TextUtils;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.yfanads.android.libs.net.BaseRequest;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.utils.YFLog;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: DomainMgr.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class d {
    public static final String[] j = {"api", "api0", "api1", "api2", "api3", "api4"};
    public static final String[] k = {UrlConst.TRACKER, "tracker0", "tracker1", "tracker2", "tracker3", "tracker4"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9653a = 1;
    public final AtomicInteger b = new AtomicInteger(0);
    public int c = 1;
    public final AtomicInteger d = new AtomicInteger(0);
    public final ScheduledExecutorService e = Executors.newScheduledThreadPool(4);
    public ScheduledFuture<?> f;
    public ScheduledFuture<?> g;
    public ScheduledFuture<?> h;
    public ScheduledFuture<?> i;

    /* JADX INFO: compiled from: DomainMgr.java */
    public interface a {
        void a();

        void b();
    }

    /* JADX INFO: compiled from: DomainMgr.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f9654a = new d();
    }

    public final void a(com.yfanads.android.net.a aVar, boolean z) {
        int i;
        com.yfanads.android.net.a aVar2 = com.yfanads.android.net.a.API;
        if (aVar == aVar2) {
            if (this.f9653a != 2) {
                if (z) {
                    return;
                }
                String apiDomain = UrlConst.getApiDomain("/health");
                this.f9653a = 2;
                this.b.set(0);
                i = UrlConst.isTestEnv() ? 10000 : 300000;
                YFLog.high("Domain startApiProcess " + aVar2 + " , " + (UrlConst.isTestEnv() ? apiDomain : "") + PPSLabelView.Code + i);
                a(apiDomain, aVar2, i, new com.yfanads.android.net.b(this, apiDomain));
                return;
            }
            if (z) {
                YFLog.high("Domain isApiNetAvailability isSuccess ");
                this.f9653a = 3;
                this.b.set(0);
                ScheduledFuture<?> scheduledFuture = this.f;
                if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
                    this.f.cancel(false);
                    YFLog.high("Domain cancelApiRetrySchedule");
                }
                ScheduledFuture<?> scheduledFuture2 = this.h;
                if (scheduledFuture2 == null || scheduledFuture2.isCancelled()) {
                    return;
                }
                this.h.cancel(false);
                YFLog.high("Domain cancelApiQuerySchedule success");
                return;
            }
            return;
        }
        if (this.c != 2) {
            if (z) {
                return;
            }
            String updDomain = UrlConst.getUpdDomain("/health");
            this.c = 2;
            this.d.set(0);
            i = UrlConst.isTestEnv() ? 10000 : 300000;
            YFLog.high("Domain startTrackerProcess " + (UrlConst.isTestEnv() ? updDomain : "") + PPSLabelView.Code + i);
            a(updDomain, com.yfanads.android.net.a.TRACKER, i, new c(this, updDomain));
            return;
        }
        if (z) {
            YFLog.high("Domain isTrackerNetAvailability success");
            this.c = 3;
            this.d.set(0);
            ScheduledFuture<?> scheduledFuture3 = this.g;
            if (scheduledFuture3 != null && !scheduledFuture3.isCancelled()) {
                this.g.cancel(false);
                YFLog.high("Domain cancelTrackerRetrySchedule");
            }
            ScheduledFuture<?> scheduledFuture4 = this.i;
            if (scheduledFuture4 == null || scheduledFuture4.isCancelled()) {
                return;
            }
            this.i.cancel(false);
            YFLog.high("Domain cancelTrackerQuerySchedule");
        }
    }

    public final void b(final com.yfanads.android.net.a aVar, final String str) {
        int i = UrlConst.isTestEnv() ? KSImageLoader.InnerImageLoadingListener.MAX_DURATION : 180000;
        YFLog.high("Domain queryDomain " + aVar + " , " + (UrlConst.isTestEnv() ? str : "") + " , " + i);
        long j2 = i;
        ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay = this.e.scheduleWithFixedDelay(new Runnable() { // from class: com.yfanads.android.net.d$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(aVar, str);
            }
        }, j2, j2, TimeUnit.MILLISECONDS);
        if (aVar == com.yfanads.android.net.a.API) {
            this.h = scheduledFutureScheduleWithFixedDelay;
        } else {
            this.i = scheduledFutureScheduleWithFixedDelay;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.yfanads.android.net.a aVar, String str) {
        int iIndexOf;
        if (a(aVar)) {
            YFLog.high("Domain queryDomain but update success, return " + aVar);
            return;
        }
        for (int i = 0; i < 6; i++) {
            if (TextUtils.isEmpty(str)) {
                str = "";
                break;
            }
            String[] strArr = aVar == com.yfanads.android.net.a.API ? j : k;
            int length = strArr.length;
            int length2 = strArr.length;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= length2) {
                    str = "";
                    break;
                }
                String str2 = strArr[i2];
                if (str.contains(UrlConst.TEST_KEY)) {
                    iIndexOf = str.indexOf(UrlConst.TEST_KEY) + 7;
                } else {
                    iIndexOf = str.indexOf(UrlConst.PRD_KEY) + 2;
                }
                i3++;
                if (str2.equals(str.substring(iIndexOf, str.indexOf(UrlConst.DOMAIN_KEY)))) {
                    if (i3 >= length) {
                        i3 = 0;
                    }
                    String str3 = strArr[i3];
                    YFLog.high("Domain getNext " + aVar + " , " + str3);
                    str = str.replace(str2, str3);
                    break;
                }
                i2++;
            }
            YFLog.high("Domain queryDomain nextUrl " + (UrlConst.isTestEnv() ? str : "") + " , " + aVar);
            if (!TextUtils.isEmpty(str)) {
                HashMap map = new HashMap();
                map.put("Connection", "close");
                if (new BaseRequest().isNetAvailability(str, map)) {
                    try {
                        if (!TextUtils.isEmpty(str) && !a(aVar)) {
                            String str4 = str.split("/health")[0];
                            YFLog.high("Domain updateDomain domain " + aVar + " , " + str4);
                            if (!TextUtils.isEmpty(str4)) {
                                com.yfanads.android.db.imp.b bVar = new com.yfanads.android.db.imp.b();
                                if (aVar == com.yfanads.android.net.a.API) {
                                    UrlConst.setAdsDomain(str4);
                                    bVar.a("api", str4);
                                    this.f9653a = 3;
                                    this.b.set(0);
                                    ScheduledFuture<?> scheduledFuture = this.f;
                                    if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
                                        this.f.cancel(false);
                                        YFLog.high("Domain cancelApiRetrySchedule");
                                    }
                                    ScheduledFuture<?> scheduledFuture2 = this.h;
                                    if (scheduledFuture2 != null && !scheduledFuture2.isCancelled()) {
                                        this.h.cancel(false);
                                        YFLog.high("Domain cancelApiQuerySchedule success");
                                    }
                                } else {
                                    UrlConst.setUpdDomain(str4);
                                    bVar.a(UrlConst.TRACKER, str4);
                                    this.c = 3;
                                    this.d.set(0);
                                    ScheduledFuture<?> scheduledFuture3 = this.g;
                                    if (scheduledFuture3 != null && !scheduledFuture3.isCancelled()) {
                                        this.g.cancel(false);
                                        YFLog.high("Domain cancelTrackerRetrySchedule");
                                    }
                                    ScheduledFuture<?> scheduledFuture4 = this.i;
                                    if (scheduledFuture4 != null && !scheduledFuture4.isCancelled()) {
                                        this.i.cancel(false);
                                        YFLog.high("Domain cancelTrackerQuerySchedule");
                                    }
                                }
                            }
                        } else {
                            YFLog.high("Domain updateDomain but update success, return " + aVar);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    YFLog.high("Domain queryDomain success, return " + aVar);
                    return;
                }
            }
        }
        YFLog.high("Domain queryDomain fail, next query " + aVar);
    }

    public final void a(final String str, final com.yfanads.android.net.a aVar, int i, final a aVar2) {
        long j2 = i;
        ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay = this.e.scheduleWithFixedDelay(new Runnable() { // from class: com.yfanads.android.net.d$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(aVar, str, aVar2);
            }
        }, j2, j2, TimeUnit.MILLISECONDS);
        if (aVar == com.yfanads.android.net.a.API) {
            this.f = scheduledFutureScheduleWithFixedDelay;
        } else {
            this.g = scheduledFutureScheduleWithFixedDelay;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.yfanads.android.net.a aVar, String str, a aVar2) {
        int iIncrementAndGet;
        if (a(aVar)) {
            YFLog.high("Domain netProcess " + aVar + " cancel process, return.");
            return;
        }
        if (aVar == com.yfanads.android.net.a.API) {
            iIncrementAndGet = this.b.incrementAndGet();
        } else {
            iIncrementAndGet = this.d.incrementAndGet();
        }
        YFLog.high("Domain netProcess " + aVar + " count " + iIncrementAndGet);
        HashMap map = new HashMap();
        map.put("Connection", "close");
        if (new BaseRequest().isNetAvailability(str, map)) {
            aVar2.a();
            return;
        }
        if (a(aVar)) {
            YFLog.high("Domain netProcess onFailure " + aVar + " cancel process, return.");
        } else if (iIncrementAndGet >= 3) {
            aVar2.b();
        } else {
            YFLog.high("Domain fail, next retry " + aVar);
        }
    }

    public final boolean a(com.yfanads.android.net.a aVar) {
        if (aVar == com.yfanads.android.net.a.API && this.f9653a == 3) {
            return true;
        }
        return aVar == com.yfanads.android.net.a.TRACKER && this.c == 3;
    }
}
