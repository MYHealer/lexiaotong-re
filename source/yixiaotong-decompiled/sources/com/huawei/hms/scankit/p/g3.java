package com.huawei.hms.scankit.p;

import android.os.Bundle;
import android.util.SparseArray;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.hmsscankit.DetailRect;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.utils.FileUtil;
import com.stub.StubApp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: HaLog60001.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class g3 extends e3 {
    private volatile String h;
    private volatile String i;
    private boolean j;
    private volatile long k;
    public d l;

    /* JADX INFO: compiled from: HaLog60001.java */
    class a extends SimpleDateFormat {
        a(String str) {
            super(str);
            setTimeZone(TimeZone.getTimeZone("UTC"));
        }
    }

    /* JADX INFO: compiled from: HaLog60001.java */
    class b extends SimpleDateFormat {
        b(String str) {
            super(str);
            setTimeZone(TimeZone.getTimeZone("UTC"));
        }
    }

    /* JADX INFO: compiled from: HaLog60001.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f4255a;
        private String b;
        private String c;
        private long d;
        private long e;
        private String f;
        private String g;
        private boolean h;
        private int i;
        private boolean j;

        /* synthetic */ c(long j, String str, String str2, boolean z, int i, int i2, a aVar) {
            this(j, str, str2, z, i, i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public c a(long j) {
            this.e = j;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public c a(String str) {
            this.f = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public c a(boolean z) {
            this.j = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public c b(String str) {
            this.g = str;
            return this;
        }

        public c a(int i) {
            this.f4255a = i;
            return this;
        }

        private c(long j, String str, String str2, boolean z, int i, int i2) {
            this.d = j;
            this.b = str;
            this.c = str2;
            this.h = z;
            this.i = i;
            this.f4255a = i2;
        }
    }

    /* JADX INFO: compiled from: HaLog60001.java */
    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f4256a = d.class.getSimpleName();
        public Timer b = new Timer();
        private volatile boolean c = true;
        private List<c> d = new ArrayList(10);
        private List<c> e = new ArrayList(10);

        /* JADX INFO: compiled from: HaLog60001.java */
        class a extends TimerTask {
            a() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                try {
                    d.this.c = true;
                    d.this.a();
                } catch (Exception unused) {
                    x3.b(d.this.f4256a, "onLog Exception");
                }
            }
        }

        /* JADX INFO: compiled from: HaLog60001.java */
        private class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private StringBuilder f4258a;
            private AtomicInteger[] b;
            private String[] c;
            private long[] d;

            private b() {
                this.f4258a = new StringBuilder(100);
                this.b = new AtomicInteger[]{new AtomicInteger(), new AtomicInteger(), new AtomicInteger(), new AtomicInteger(), new AtomicInteger(), new AtomicInteger(), new AtomicInteger()};
                this.c = new String[]{"lt10K:", "lt100K:", "lt1M:", "lt3M:", "lt10M:", "lt40M:", "gt40M:"};
                this.d = new long[]{FileUtil.LOCAL_REPORT_FILE_MAX_SIZE, 102400, 1048576, 3145728, 10485760, 41943040, Long.MAX_VALUE};
            }

            /* JADX INFO: Access modifiers changed from: private */
            public String a() {
                StringBuilder sb = this.f4258a;
                sb.delete(0, sb.length());
                this.f4258a.append("{");
                for (int i = 0; i < this.b.length; i++) {
                    this.f4258a.append(this.c[i]);
                    this.f4258a.append(this.b[i]);
                    this.f4258a.append(",");
                }
                StringBuilder sb2 = this.f4258a;
                sb2.replace(sb2.length() - 1, this.f4258a.length(), com.alipay.sdk.util.i.d);
                return this.f4258a.toString();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a(int i) {
                int i2 = 0;
                while (true) {
                    AtomicInteger[] atomicIntegerArr = this.b;
                    if (i2 >= atomicIntegerArr.length) {
                        return;
                    }
                    if (i <= this.d[i2]) {
                        atomicIntegerArr[i2].addAndGet(1);
                        return;
                    }
                    i2++;
                }
            }

            /* synthetic */ b(d dVar, a aVar) {
                this();
            }
        }

        /* JADX INFO: compiled from: HaLog60001.java */
        private class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private StringBuilder f4259a;
            private SparseArray<AtomicInteger> b;

            /* JADX INFO: compiled from: HaLog60001.java */
            class a extends SparseArray<AtomicInteger> {
                a() {
                    put(0, new AtomicInteger());
                }
            }

            /* JADX INFO: compiled from: HaLog60001.java */
            class b extends AtomicInteger {
                b() {
                    addAndGet(1);
                }
            }

            private c() {
                this.f4259a = new StringBuilder(60);
                this.b = new a();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a(int i) {
                if (this.b.get(i) == null) {
                    this.b.put(i, new b());
                } else {
                    this.b.get(i).addAndGet(1);
                }
            }

            /* synthetic */ c(d dVar, a aVar) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public String a() {
                StringBuilder sb = this.f4259a;
                sb.delete(0, sb.length());
                this.f4259a.append("{");
                for (int i = 0; i < this.b.size(); i++) {
                    this.f4259a.append(this.b.keyAt(i));
                    this.f4259a.append(com.huawei.openalliance.ad.constant.x.bQ);
                    this.f4259a.append(this.b.valueAt(i));
                    this.f4259a.append(",");
                }
                StringBuilder sb2 = this.f4259a;
                sb2.replace(sb2.length() - 1, this.f4259a.length(), com.alipay.sdk.util.i.d);
                return this.f4259a.toString();
            }
        }

        public d() {
        }

        public void b() {
            Timer timer = this.b;
            if (timer != null) {
                timer.cancel();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar) {
            if (this.d.size() > 100) {
                return;
            }
            synchronized (this) {
                this.d.add(cVar);
                if (this.c) {
                    this.c = false;
                    this.b.schedule(new a(), 1000L);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            if (this.d.size() > 0) {
                synchronized (this) {
                    List<c> list = this.d;
                    List<c> list2 = this.e;
                    this.d = list2;
                    this.e = list;
                    list2.clear();
                }
                a(this.e);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void a(List<c> list) {
            HashSet<String> hashSet = new HashSet();
            Iterator<c> it = list.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().c);
            }
            for (String str : hashSet) {
                Boolean bool = null;
                c cVar = new c(this, 0 == true ? 1 : 0);
                b bVar = new b(this, 0 == true ? 1 : 0);
                String str2 = "";
                long j = Long.MIN_VALUE;
                long j2 = 0;
                long j3 = 0;
                long j4 = 0;
                long j5 = 0;
                long j6 = Long.MAX_VALUE;
                String str3 = "";
                String str4 = str3;
                for (c cVar2 : list) {
                    str2 = cVar2.b;
                    str3 = cVar2.f;
                    str4 = cVar2.g;
                    Boolean boolValueOf = Boolean.valueOf(cVar2.h);
                    j3 += cVar2.e - cVar2.d;
                    cVar.a(cVar2.f4255a);
                    bVar.a(cVar2.i);
                    j2++;
                    if (cVar2.j) {
                        j5++;
                    }
                    if (cVar2.f4255a != 0) {
                        j4++;
                    }
                    if (cVar2.e - cVar2.d < j6) {
                        j6 = cVar2.e - cVar2.d;
                    }
                    if (cVar2.e - cVar2.d > j) {
                        j = cVar2.e - cVar2.d;
                    }
                    bool = boolValueOf;
                }
                LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
                g3.this.g();
                linkedHashMap.putAll(g3.this.b);
                linkedHashMap.put("result", cVar.a());
                linkedHashMap.put("imgSizeHistogram", bVar.a());
                linkedHashMap.put("callTime", str2);
                linkedHashMap.put("transId", str);
                if (j2 != 0) {
                    j3 /= j2;
                }
                linkedHashMap.put(WiseOpenHianalyticsData.UNION_COSTTIME, String.valueOf(j3));
                linkedHashMap.put("allCnt", String.valueOf(j2));
                linkedHashMap.put("failCnt", String.valueOf(j4));
                linkedHashMap.put("codeCnt", String.valueOf(j5));
                linkedHashMap.put("scanType", str3);
                linkedHashMap.put("sceneType", str4);
                linkedHashMap.put("min", String.valueOf(j6));
                linkedHashMap.put("max", String.valueOf(j));
                linkedHashMap.put("algPhotoMode", String.valueOf(bool));
                j3.b().b("60001", linkedHashMap);
            }
        }
    }

    public g3(Bundle bundle, String str) {
        super(bundle, StubApp.getOrigApplicationContext(DynamicModuleInitializer.getContext().getApplicationContext()));
        this.j = false;
        this.l = new d();
        this.b.put("apiName", str);
        if (DetailRect.PHOTO_MODE.equals(str)) {
            this.j = true;
        }
    }

    public void a(String str) {
        this.b.put("algapi", str);
    }

    public c a(boolean z, int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            if (this.j) {
                return new c(jCurrentTimeMillis, new a("yyyyMMddHHmmss.SSS").format(Long.valueOf(jCurrentTimeMillis)), UUID.randomUUID().toString(), z, i, 0, null);
            }
            if (jCurrentTimeMillis - this.k > 1500) {
                String str = new b("yyyyMMddHHmmss.SSS").format(Long.valueOf(jCurrentTimeMillis));
                String string = UUID.randomUUID().toString();
                if (jCurrentTimeMillis - this.k > 1500) {
                    this.h = str;
                    this.i = string;
                    this.k = jCurrentTimeMillis;
                }
            }
            return new c(jCurrentTimeMillis, this.h, this.i, z, i, 0, null);
        } catch (Exception unused) {
            x3.b("HaLog6001", "exception happens");
            return new c(jCurrentTimeMillis, this.h, this.i, z, i, 0, null);
        }
    }

    public void a(HmsScan[] hmsScanArr, c cVar) {
        try {
            String str = e3.d;
            String strB = e3.e;
            if (a()) {
                boolean z = false;
                int i = 0;
                z = false;
                if (hmsScanArr != null && hmsScanArr.length > 0) {
                    int length = hmsScanArr.length;
                    while (i < length) {
                        HmsScan hmsScan = hmsScanArr[i];
                        String strA = e3.a(hmsScan.scanType);
                        i++;
                        strB = e3.b(hmsScan.scanTypeForm);
                        str = strA;
                    }
                    z = true;
                }
                this.l.a(cVar.a(System.currentTimeMillis()).a(z).a(str).b(strB));
                this.k = cVar.e;
            }
        } catch (NullPointerException unused) {
            x3.b("HaLog60001", "nullPoint");
        } catch (Exception unused2) {
            x3.b("HaLog60001", "logEnd Exception");
        }
    }
}
