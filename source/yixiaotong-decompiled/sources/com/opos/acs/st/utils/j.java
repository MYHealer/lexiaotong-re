package com.opos.acs.st.utils;

import com.kuaishou.weapon.p0.bg;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile j f5867a;
    private final ConcurrentHashMap<Integer, c> c = new ConcurrentHashMap<>();
    private final b b = new a(null);

    /* JADX INFO: renamed from: com.opos.acs.st.utils.j$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long[] f5868a;

        private a() {
            this.f5868a = new long[]{120000, 900000, bg.s, 10800000, 36000000};
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.opos.acs.st.utils.j.b
        public long a(int i) {
            int length = i - 1;
            long[] jArr = this.f5868a;
            if (length >= jArr.length) {
                length = jArr.length - 1;
            } else if (length < 0) {
                length = 0;
            }
            return jArr[length];
        }
    }

    interface b {
        long a(int i);
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicInteger f5869a = new AtomicInteger(0);
        private long b = System.currentTimeMillis();

        public int a() {
            return this.f5869a.get();
        }

        public void b() {
            this.f5869a.incrementAndGet();
            this.b = System.currentTimeMillis();
        }

        public long c() {
            return this.b;
        }

        public String toString() {
            return "RetryValue{mFailTimes=" + this.f5869a + ", mLastReportTime=" + this.b + '}';
        }
    }

    private j() {
    }

    public static j a() {
        if (f5867a == null) {
            synchronized (j.class) {
                if (f5867a == null) {
                    f5867a = new j();
                }
            }
        }
        return f5867a;
    }

    public void a(String str, String str2) {
        int iHash = Objects.hash(str, str2);
        c cVar = this.c.get(Integer.valueOf(iHash));
        if (cVar == null) {
            cVar = new c();
            this.c.put(Integer.valueOf(iHash), cVar);
        }
        cVar.b();
        com.opos.cmn.an.f.a.a("TimerRetryManager", "addRetry,value=" + cVar + ",size=" + this.c.size() + ",dataType=" + str + ",url" + str2);
    }

    public boolean a(String str) {
        try {
            int iIntValue = Integer.valueOf(str).intValue();
            return iIntValue == 403 || iIntValue == 408 || iIntValue == 413 || iIntValue == 429 || iIntValue == 500 || iIntValue == 502 || iIntValue == 503 || iIntValue == 504;
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.d("TimerRetryManager", "isRetryCode error", th);
            return false;
        }
    }

    public void b(String str, String str2) {
        com.opos.cmn.an.f.a.b("TimerRetryManager", "removeRetry,value=" + this.c.remove(Integer.valueOf(Objects.hash(str, str2))) + ",dataType=" + str + ",url" + str2);
    }

    public boolean c(String str, String str2) {
        return this.c.get(Integer.valueOf(Objects.hash(str, str2))) != null;
    }

    public boolean d(String str, String str2) {
        c cVar = this.c.get(Integer.valueOf(Objects.hash(str, str2)));
        if (cVar == null) {
            return false;
        }
        int iA = cVar.a();
        long jC = cVar.c();
        long jA = this.b.a(iA);
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z = jCurrentTimeMillis - jC < jA;
        com.opos.cmn.an.f.a.a("TimerRetryManager", "needLimitRetry=" + z + ",dataType=" + str + ",url=" + str2 + ",nextPeriod=" + jA + ",lastReportTime=" + jC + ",curTime=" + jCurrentTimeMillis);
        return z;
    }
}
