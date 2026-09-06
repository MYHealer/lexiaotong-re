package com.byazt.wi;

import android.content.ContentValues;
import android.text.TextUtils;
import com.byazt.bwm.sp;
import com.byazt.ete.x;
import com.ubixnow.ooooo.o0OO000o;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 983, 34})
public class a {
    public static final a c = new a();
    public static final c tt;
    public static volatile c uj;
    public static volatile long ve;
    public final Map<String, tt> n = new ConcurrentHashMap();

    interface c {
        void c(long j);

        void c(ContentValues contentValues);
    }

    public static a c() {
        return c;
    }

    static {
        c cVar = new c() { // from class: com.byazt.wi.a.1
            @Override // com.byazt.wi.a.c
            public void c(ContentValues contentValues) {
                n.c(contentValues);
            }

            @Override // com.byazt.wi.a.c
            public void c(long j) {
                n.c(j);
            }
        };
        tt = cVar;
        ve = -1L;
        uj = cVar;
    }

    public boolean c(int i) {
        x.ve veVarC = x.c(i);
        if (veVarC == null || veVarC.nu() == null) {
            return false;
        }
        return veVarC.nu().tt();
    }

    public void c(String str, int i, String str2, long j) {
        tt ttVarPutIfAbsent;
        if (!c(i) || TextUtils.isEmpty(str)) {
            return;
        }
        tt ttVar = this.n.get(str);
        if (ttVar == null && (ttVarPutIfAbsent = this.n.putIfAbsent(str, (ttVar = new tt()))) != null) {
            ttVar = ttVarPutIfAbsent;
        }
        synchronized (ttVar) {
            if (j <= 0) {
                j = System.currentTimeMillis();
                ttVar.c = j;
                ttVar.tt = i;
                ttVar.ve = str2;
                ttVar.uj = 0L;
                ttVar.n = 0L;
                ttVar.f2845a = 0L;
                ttVar.sp = false;
                ttVar.x = false;
            } else {
                ttVar.c = j;
                ttVar.tt = i;
                ttVar.ve = str2;
                ttVar.uj = 0L;
                ttVar.n = 0L;
                ttVar.f2845a = 0L;
                ttVar.sp = false;
                ttVar.x = false;
            }
            throw th;
        }
    }

    public void c(String str, long j) {
        tt ttVar;
        if (TextUtils.isEmpty(str) || (ttVar = this.n.get(str)) == null) {
            return;
        }
        if (j <= 0) {
            j = System.currentTimeMillis();
        }
        synchronized (ttVar) {
            if (ttVar.c <= 0) {
                ttVar.c = j;
            }
            if (ttVar.uj <= 0) {
                ttVar.uj = Math.max(0L, j - ttVar.c);
            }
            ttVar.x = true;
        }
    }

    public void tt(final String str, final long j) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.bzd.x.c(new sp("tmax_record_on_cached") { // from class: com.byazt.wi.a.2
            @Override // java.lang.Runnable
            public void run() {
                tt ttVar = (tt) a.this.n.get(str);
                if (ttVar == null) {
                    return;
                }
                long jCurrentTimeMillis = j;
                if (jCurrentTimeMillis <= 0) {
                    jCurrentTimeMillis = System.currentTimeMillis();
                }
                synchronized (ttVar) {
                    if (ttVar.c <= 0) {
                        return;
                    }
                    if (ttVar.n <= 0) {
                        ttVar.n = Math.max(0L, jCurrentTimeMillis - ttVar.c);
                    }
                }
            }
        });
    }

    public void ve(String str, long j) {
        tt ttVar;
        if (TextUtils.isEmpty(str) || (ttVar = this.n.get(str)) == null) {
            return;
        }
        if (j <= 0) {
            j = System.currentTimeMillis();
        }
        synchronized (ttVar) {
            if (ttVar.sp) {
                return;
            }
            ttVar.sp = true;
            if (ttVar.c <= 0) {
                ttVar.c = j;
            }
            ttVar.f2845a = Math.max(0L, j - ttVar.c);
        }
    }

    public void uj(String str, long j) {
        tt ttVar;
        if (TextUtils.isEmpty(str) || (ttVar = this.n.get(str)) == null) {
            return;
        }
        if (j <= 0) {
            j = System.currentTimeMillis();
        }
        synchronized (ttVar) {
            if (ttVar.x) {
                if (ttVar.c <= 0) {
                    ttVar.c = j;
                }
                ContentValues contentValuesC = c(str, ttVar, j);
                this.n.remove(str);
                c(contentValuesC);
            }
        }
    }

    private ContentValues c(String str, tt ttVar, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("load_id", str);
        contentValues.put("ad_slot_type", Integer.valueOf(ttVar.tt));
        contentValues.put(o0OO000o.o000OooO, ttVar.ve);
        contentValues.put("loaded_duration", Long.valueOf(ttVar.uj));
        contentValues.put("cached_duration", Long.valueOf(ttVar.n));
        contentValues.put("shown_duration", Long.valueOf(ttVar.f2845a));
        contentValues.put("is_shown", Integer.valueOf(ttVar.sp ? 1 : 0));
        contentValues.put("record_time", Long.valueOf(j));
        return contentValues;
    }

    private void c(ContentValues contentValues) {
        uj.c(contentValues);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - ve > 86400000) {
            ve = jCurrentTimeMillis;
            final long j = jCurrentTimeMillis - 604800000;
            if (j > 0) {
                com.byazt.bzd.x.c(new sp("tmax_record_cleanup") { // from class: com.byazt.wi.a.3
                    @Override // java.lang.Runnable
                    public void run() {
                        a.uj.c(j);
                    }
                });
            }
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 983, 480})
    private static class tt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f2845a;
        public long c;
        public long n;
        public boolean sp;
        public int tt;
        public long uj;
        public String ve;
        public boolean x;

        private tt() {
        }
    }
}
