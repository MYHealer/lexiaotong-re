package com.hihonor.hianalytics.hnha;

import android.util.Pair;
import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.kuaishou.weapon.p0.bg;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private w f3682a;
    private y b;
    private x c;
    private long d = 0;
    private long e = 0;
    private long f;

    public t() {
        this.f = 0L;
        this.f = com.hihonor.hianalytics.util.b.a(0, 1800);
    }

    private boolean b() {
        int iG = p2.b().g();
        if (iG == -1 || iG == 0) {
            return false;
        }
        if (iG == 1) {
            return g().a("statNetSends", "_netCode", new int[]{200});
        }
        if (iG == 2) {
            boolean zA = g().a("statEvents", "_statType", new int[]{10000, 20000, KSImageLoader.InnerImageLoadingListener.MAX_DURATION});
            return !zA ? g().a("statReports", "_statType", new int[]{MpegAudioUtil.MAX_RATE_BYTES_PER_SECOND}) : zA;
        }
        if (iG != 3) {
            return false;
        }
        boolean zA2 = g().a("statEvents", "_statType", new int[]{10000, 20000, KSImageLoader.InnerImageLoadingListener.MAX_DURATION});
        if (!zA2) {
            zA2 = g().a("statReports", "_statType", new int[]{MpegAudioUtil.MAX_RATE_BYTES_PER_SECOND});
        }
        boolean z = zA2;
        return !z ? g().a("statNetSends", "_netCode", new int[]{200}) : z;
    }

    private w e() {
        w wVar = this.f3682a;
        if (wVar != null) {
            return wVar;
        }
        synchronized (this) {
            w wVar2 = this.f3682a;
            if (wVar2 != null) {
                return wVar2;
            }
            w wVarC = w.c();
            this.f3682a = wVarC;
            return wVarC;
        }
    }

    private x f() {
        x xVar = this.c;
        if (xVar != null) {
            return xVar;
        }
        synchronized (this) {
            x xVar2 = this.c;
            if (xVar2 != null) {
                return xVar2;
            }
            x xVarB = x.b();
            this.c = xVarB;
            return xVarB;
        }
    }

    private y g() {
        y yVar = this.b;
        if (yVar != null) {
            return yVar;
        }
        synchronized (this) {
            y yVar2 = this.b;
            if (yVar2 != null) {
                return yVar2;
            }
            y yVarB = y.b();
            this.b = yVarB;
            return yVarB;
        }
    }

    public int a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.e;
        if (j < 0) {
            this.e = jCurrentTimeMillis;
            return 0;
        }
        if (j < 1800000) {
            return 0;
        }
        int iE = e().e();
        this.e = jCurrentTimeMillis;
        return iE;
    }

    public int a(p0 p0Var) {
        return a(Collections.singletonList(p0Var), false).a(p0Var);
    }

    public int a(String str) {
        return e().a(str);
    }

    public int a(List<n0> list) {
        return e().a(list);
    }

    public Pair<Boolean, Map<String, List<h3>>> a(long j, long j2, long j3) {
        long j4;
        long j5;
        long jD = com.hihonor.hianalytics.util.r.d();
        long j6 = 0;
        if (j <= 0 && j2 <= 0 && j3 <= 0) {
            boolean zB = b();
            long j7 = this.f;
            if (zB) {
                if (j7 > 300) {
                    this.f = com.hihonor.hianalytics.util.b.a(0, 300);
                }
                j4 = this.f * 1000;
                j5 = bg.s;
            } else {
                j4 = j7 * 1000;
                j5 = 28800000;
            }
            j6 = j5 + j4;
        }
        if (f().a(j6) != 0) {
            return Pair.create(Boolean.FALSE, Collections.emptyMap());
        }
        g().a(com.hihonor.hianalytics.util.r.b() - (((long) p2.d().e()) * 86400000));
        Pair<Boolean, Map<String, List<h3>>> pairA = g().a(jD, j, 6000, j2, 2000, j3, 2000);
        if (((Map) pairA.second).isEmpty()) {
            f().a(true);
        }
        return pairA;
    }

    public Pair<Boolean, Map<String, String>> a(String str, List<String> list) {
        return f().a(str, list);
    }

    public Pair<Boolean, Map<String, String>> a(String str, Map<String, String> map) {
        return f().a(str, map);
    }

    public l0 a(k0 k0Var) {
        return e().a(k0Var);
    }

    public m0 a(List<p0> list, boolean z) {
        return e().a(list, z);
    }

    public String a(String str, String str2, boolean z, String str3) {
        return f().a(str, str2, z, str3);
    }

    public List<n0> a(long j) {
        return e().a(j);
    }

    public boolean a(String str, String str2) {
        return f().a(str, str2);
    }

    public int b(List<n0> list, boolean z) {
        int size = list == null ? 0 : list.size();
        if (size == 0) {
            j2.g("DataAccessor", "notifySendResult illegal eventSize=" + size);
            return 0;
        }
        w wVarE = e();
        int iA = z ? wVarE.a(list) : wVarE.a(list, 2, true);
        j2.a("DataAccessor", "notifySendResult isSuccess=" + z + ",eventSize=" + size + ",operateNum=" + iA);
        return iA;
    }

    public Pair<Boolean, Throwable> b(List<n0> list) {
        return e().b(list, true);
    }

    public List<String> b(String str) {
        return f().a(str);
    }

    public int c() {
        return e().b();
    }

    public int c(List<h3> list, boolean z) {
        int size = list == null ? 0 : list.size();
        if (size == 0) {
            j2.g("DataAccessor", "notifyStatSendResult illegal statSize=" + size);
            return 0;
        }
        y yVarG = g();
        int iA = z ? yVarG.a(list) : yVarG.a(list, 2, true);
        boolean zA = f().a(z);
        if (zA && z) {
            this.f = com.hihonor.hianalytics.util.b.a(0, 1800);
        }
        j2.a("DataAccessor", "notifyStatSendResult isSuccess=" + z + ",isMarkSuccess=" + zA + ",eventSize=" + size + ",operateNum=" + iA);
        return iA;
    }

    public Map<String, String> c(String str) {
        return f().b(str);
    }

    public boolean c(List<h3> list) {
        return g().a(list, true);
    }

    public int d(List<n0> list) {
        int size = list == null ? 0 : list.size();
        if (size == 0) {
            j2.a("DataAccessor", "updateEventsRequestId illegal eventSize=" + size);
            return 0;
        }
        int iC = e().c(list, true);
        j2.a("DataAccessor", "updateEventsRequestId ,eventSize=" + size + ",operateNum=" + iC);
        return iC;
    }

    public String d(String str) {
        return f().c(str);
    }

    public List<p0> d() {
        return e().d();
    }

    public int e(List<h3> list) {
        int size = list == null ? 0 : list.size();
        if (size == 0) {
            j2.g("DataAccessor", "updateStatRequestId illegal statSize=" + size);
            return 0;
        }
        int iB = g().b(list, true);
        j2.a("DataAccessor", "updateStatRequestId eventSize=" + size + ",operateNum=" + iB);
        return iB;
    }

    public j0 h() {
        j0 j0VarB = e().b(0L);
        if (j0VarB != null) {
            j0VarB.a();
        }
        return j0VarB;
    }

    public int i() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.d < 180000) {
            return 0;
        }
        int iF = e().f();
        this.d = jCurrentTimeMillis;
        return iF;
    }

    public int j() {
        int iG = e().g();
        this.d = System.currentTimeMillis();
        return iG;
    }

    public boolean k() {
        g().c();
        return f().c();
    }
}
