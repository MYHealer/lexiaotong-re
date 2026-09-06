package com.hihonor.hianalytics.hnha;

import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteBindOrColumnIndexOutOfRangeException;
import android.database.sqlite.SQLiteBlobTooBigException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteDatatypeMismatchException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteDoneException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteMisuseException;
import android.database.sqlite.SQLiteOutOfMemoryException;
import android.database.sqlite.SQLiteReadOnlyDatabaseException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.hihonor.hianalytics.support.HaHelpUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class a3 implements r3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f3623a = false;
    private final Map<Integer, List<n0>> b = new HashMap();
    private final List<n0> c = new LinkedList();
    private final List<n0> d = new LinkedList();
    private List<n0> e = Collections.emptyList();
    private n0 f = null;
    private n0 g = null;
    private boolean h = false;
    private int i = 20003;
    private final Set<p0> j = new HashSet();

    private int a(Throwable th) {
        if (th instanceof NullPointerException) {
            return 23000;
        }
        if (th instanceof IllegalStateException) {
            String message = th.getMessage();
            if (TextUtils.isEmpty(message)) {
                return 23010;
            }
            if (message.contains("associated info not ready")) {
                return 23013;
            }
            if (message.contains("not open")) {
                return 23011;
            }
            return message.contains("closed") ? 23012 : 23010;
        }
        if (th instanceof CursorIndexOutOfBoundsException) {
            return 23020;
        }
        if (th instanceof SQLiteReadOnlyDatabaseException) {
            return 23030;
        }
        if (th instanceof SQLiteDatabaseLockedException) {
            return 23040;
        }
        if (th instanceof SQLiteConstraintException) {
            return 23050;
        }
        if (th instanceof SQLiteBindOrColumnIndexOutOfRangeException) {
            return 23060;
        }
        if (th instanceof SQLiteOutOfMemoryException) {
            return 23070;
        }
        if (th instanceof SQLiteTableLockedException) {
            return 23080;
        }
        if (th instanceof SQLiteMisuseException) {
            return 23090;
        }
        if (th instanceof SQLiteBlobTooBigException) {
            return 23100;
        }
        if (th instanceof SQLiteAccessPermException) {
            return 23110;
        }
        if (th instanceof SQLiteDoneException) {
            return 23120;
        }
        if (th instanceof SQLiteCantOpenDatabaseException) {
            return 23130;
        }
        if (th instanceof SQLiteDatatypeMismatchException) {
            return 23140;
        }
        if (th instanceof SQLiteDatabaseCorruptException) {
            return 23150;
        }
        if (th instanceof SQLiteAbortException) {
            return 23160;
        }
        if (th instanceof SQLiteFullException) {
            return 23170;
        }
        if (!(th instanceof SQLiteDiskIOException)) {
            return th instanceof SQLiteException ? 23300 : 20003;
        }
        String message2 = th.getMessage();
        if (TextUtils.isEmpty(message2)) {
            return 23200;
        }
        if (message2.contains("full")) {
            return 23201;
        }
        if (message2.contains("locked")) {
            return 23203;
        }
        if (message2.contains("write")) {
            return 23204;
        }
        return message2.contains("I/O") ? 23202 : 23200;
    }

    private synchronized void a() {
        if (this.f3623a) {
            return;
        }
        this.f3623a = true;
        this.b.put(20004, this.e);
        this.b.put(Integer.valueOf(this.h ? 20000 : this.i), this.c);
        p2.g().a(this.b, (Throwable) null);
    }

    private void a(int i, n0 n0Var) {
        List<n0> linkedList = this.b.get(Integer.valueOf(i));
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.b.put(Integer.valueOf(i), linkedList);
        }
        linkedList.add(n0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(n0 n0Var) {
        n0Var.c().z();
    }

    private void a(StringBuilder sb) {
        boolean z;
        long jMin;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int i = 0;
        do {
            try {
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                int iU = g.u();
                z = true;
                i++;
                if (jElapsedRealtime2 - jElapsedRealtime > iU || i > 50) {
                    z = false;
                }
                List<n0> listA = p2.c().a(!z);
                if (listA.isEmpty()) {
                    jMin = Math.min(20, iU);
                } else {
                    sb.append(listA.size()).append(",");
                    this.c.addAll(listA);
                    for (final n0 n0Var : listA) {
                        t3.d(new r3() { // from class: com.hihonor.hianalytics.hnha.a3$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                a3.a(n0Var);
                            }
                        });
                    }
                    jMin = ((long) Math.min(20, iU)) - (SystemClock.elapsedRealtime() - jElapsedRealtime2);
                }
                if (z) {
                    if (jMin <= 0) {
                        jMin = 1;
                    }
                    com.hihonor.hianalytics.util.k.a(jMin);
                }
            } catch (Throwable th) {
                j2.g("NewEventRecordTask", "readCacheEvent failE=" + HaHelpUtils.getDesensitizedException(th));
                return;
            }
        } while (z);
        sb.append(")");
    }

    private String b() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(this.h).append(",").append(this.c.size()).append(",").append(this.d.size()).append(",").append(this.e.size());
        if (!this.h) {
            sb.append(",failStatType=").append(this.i);
        }
        sb.append(",eventRegion=").append(com.hihonor.hianalytics.util.g.a(this.c));
        if (!this.e.isEmpty()) {
            sb.append(",delRegion=").append(com.hihonor.hianalytics.util.g.a(this.e));
        }
        if (this.g != null) {
            sb.append(",").append(this.g.a()).append("&").append(this.g.i()).append("&").append(this.g.d()).append("&").append(com.hihonor.hianalytics.util.r.a(this.g.m()));
        }
        n0 n0Var = this.f;
        if (n0Var != null && n0Var != this.g) {
            sb.append(",").append(this.f.a()).append("&").append(this.f.i()).append("&").append(this.f.d()).append("&").append(com.hihonor.hianalytics.util.r.a(this.f.m()));
        }
        return sb.append(")").toString();
    }

    private void b(n0 n0Var) {
        n0 n0Var2 = this.f;
        if (n0Var2 == null || n0Var2.m() < n0Var.m()) {
            this.f = n0Var;
        }
        n0 n0Var3 = this.g;
        if (n0Var3 == null || n0Var3.m() > n0Var.m()) {
            this.g = n0Var;
        }
        this.j.add(n0Var.x());
    }

    private void c() {
        try {
            com.hihonor.hianalytics.util.h.e();
            com.hihonor.hianalytics.util.h.a();
            if (this.c.isEmpty()) {
                if (this.d.isEmpty()) {
                    return;
                }
                com.hihonor.hianalytics.util.h.d();
                com.hihonor.hianalytics.util.h.b(this.d.size());
                return;
            }
            Pair<Boolean, Throwable> pairB = k.a().b(this.c);
            boolean zBooleanValue = ((Boolean) pairB.first).booleanValue();
            this.h = zBooleanValue;
            if (!zBooleanValue) {
                this.i = a((Throwable) pairB.second);
            }
            com.hihonor.hianalytics.util.h.e(this.h ? this.c.size() : 0);
        } catch (Throwable th) {
            j2.g("NewEventRecordTask", "handleEvent failE=" + HaHelpUtils.getDesensitizedException(th));
        }
    }

    private void d() {
        try {
            int size = this.c.size();
            com.hihonor.hianalytics.util.h.c(size);
            for (int i = size - 1; i >= 0; i--) {
                n0 n0Var = this.c.get(i);
                int iR = n0Var.c().z().r();
                if (iR != 0) {
                    j2.g("NewEventRecordTask", "preDealEvent illegal legalState=" + iR + ",event=" + n0Var);
                    this.c.remove(i);
                    this.d.add(n0Var);
                    a(com.hihonor.hianalytics.util.q.e(iR), n0Var);
                } else {
                    b(n0Var);
                }
            }
        } catch (Throwable th) {
            j2.g("NewEventRecordTask", "preDealEvent failE=" + HaHelpUtils.getDesensitizedException(th));
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        int i;
        String str2 = "NewEventRecordTask";
        try {
            long jA = com.hihonor.hianalytics.util.r.a();
            StringBuilder sbAppend = new StringBuilder().append("(");
            a(sbAppend);
            long jA2 = com.hihonor.hianalytics.util.r.a() - jA;
            d();
            long jA3 = (com.hihonor.hianalytics.util.r.a() - jA) - jA2;
            c();
            if (this.c.isEmpty()) {
                a();
                j2.g("NewEventRecordTask", "recordEvent haFailTime=(" + com.hihonor.hianalytics.util.r.b(jA2) + "," + com.hihonor.hianalytics.util.r.b(jA3) + "," + com.hihonor.hianalytics.util.r.b(((com.hihonor.hianalytics.util.r.a() - jA) - jA2) - jA3) + "),getEventDesc=" + ((Object) sbAppend) + ",eventDesc=" + b() + ",tagTypeInfoSize=" + this.j.size());
                return;
            }
            try {
                m0 m0VarA = k.a().a((List<p0>) new ArrayList(this.j), true);
                int iE = g.e();
                long jF = g.f();
                long jA4 = m0VarA.a();
                long j = 1048576 * jF;
                if (jA4 >= j) {
                    try {
                        List<n0> listA = k.a().a(jA4 - j);
                        this.e = listA;
                        com.hihonor.hianalytics.util.h.b(listA.size());
                        a();
                        j2.c("NewEventRecordTask", "recordEvent haOverTime=(" + com.hihonor.hianalytics.util.r.b(jA2) + "," + com.hihonor.hianalytics.util.r.b(jA3) + "," + com.hihonor.hianalytics.util.r.b(((com.hihonor.hianalytics.util.r.a() - jA) - jA2) - jA3) + "),getEventDesc=" + ((Object) sbAppend) + ",eventDesc=" + b() + ",tagTypeInfoSize=" + this.j.size() + ",limitSize=" + jF + ",limitNum=" + iE + ",storeState=" + m0VarA);
                        com.hihonor.hianalytics.process.b.a("", 0, 7);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        str2 = "NewEventRecordTask";
                    }
                } else {
                    try {
                        com.hihonor.hianalytics.util.h.b();
                        a();
                        boolean zB = p2.e().b(false);
                        int iC = com.hihonor.hianalytics.util.r.c();
                        int iF = u.f();
                        int iR = g.r();
                        if (iF <= 0 || (i = iC - iF) <= 0) {
                            u.a(iC);
                            i = 0;
                        }
                        if (!zB || i <= iR || iR <= 0) {
                            try {
                                str = "NewEventRecordTask";
                                try {
                                    j2.c(str, "recordEvent haNormalTime=(" + com.hihonor.hianalytics.util.r.b(jA2) + "," + com.hihonor.hianalytics.util.r.b(jA3) + "," + com.hihonor.hianalytics.util.r.b(((com.hihonor.hianalytics.util.r.a() - jA) - jA2) - jA3) + "),getEventDesc=" + ((Object) sbAppend) + ",eventDesc=" + b() + ",tagTypeInfoSize=" + this.j.size() + ",limitSize=" + jF + ",limitNum=" + iE + ",isNetworkOK=" + zB + ",interval=" + i + ",reportInterval=" + iR + ",storeState=" + m0VarA);
                                    for (p0 p0Var : this.j) {
                                        int iA = m0VarA.a(p0Var);
                                        long jB = m0VarA.b(p0Var);
                                        long jE = h.e(p0Var.b, p0Var.c);
                                        int iH = h.h(p0Var.b);
                                        if (jB >= jE * 1024) {
                                            com.hihonor.hianalytics.process.b.a(p0Var.b, p0Var.c, 4);
                                        } else if (iA >= iH) {
                                            com.hihonor.hianalytics.process.b.a(p0Var.b, p0Var.c, 3);
                                        }
                                    }
                                    return;
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                str = "NewEventRecordTask";
                            }
                        } else {
                            try {
                                j2.c("NewEventRecordTask", "recordEvent haPeriodTime=(" + com.hihonor.hianalytics.util.r.b(jA2) + "," + com.hihonor.hianalytics.util.r.b(jA3) + "," + com.hihonor.hianalytics.util.r.b(((com.hihonor.hianalytics.util.r.a() - jA) - jA2) - jA3) + "),getEventDesc=" + ((Object) sbAppend) + ",eventDesc=" + b() + ",tagTypeInfoSize=" + this.j.size() + ",limitSize=" + jF + ",limitNum=" + iE + ",interval=" + i + ",reportInterval=" + iR + ",storeState=" + m0VarA);
                                u.a(iC);
                                com.hihonor.hianalytics.process.b.a("", 0, 6);
                                g.z();
                                return;
                            } catch (Throwable th4) {
                                th = th4;
                                str2 = "NewEventRecordTask";
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        str = "NewEventRecordTask";
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                str = "NewEventRecordTask";
            }
            str = str2;
            j2.e(str, "recordEvent failE=" + HaHelpUtils.getDesensitizedException(th));
            a();
        } catch (Throwable th7) {
            th = th7;
        }
    }
}
