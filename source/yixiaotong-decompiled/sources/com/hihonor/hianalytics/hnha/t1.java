package com.hihonor.hianalytics.hnha;

import android.content.SharedPreferences;
import android.os.SystemClock;
import com.hihonor.hianalytics.util.SystemUtils;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class t1 {
    private static final t1 b = new t1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.hihonor.hianalytics.util.a f3684a = com.hihonor.hianalytics.util.g.a();

    private t1() {
        a();
    }

    private void a() {
        long jC;
        boolean zA = false;
        if (com.hihonor.hianalytics.util.g.c().a("isBackUpNewProcessMode", false)) {
            j2.a("BackupFileManager", "checkToMoveSp alreadyNewMode");
            return;
        }
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            SharedPreferences sharedPreferencesC = com.hihonor.hianalytics.util.p.c("backup_event");
            if (sharedPreferencesC != null) {
                jC = com.hihonor.hianalytics.util.p.c(SystemUtils.getContext(), "backup_event");
                zA = this.f3684a.a(sharedPreferencesC.getAll(), true);
            } else {
                jC = 0;
            }
            j2.a("BackupFileManager", "checkToMoveSp isSuccess=" + zA + ",initSize=" + jC + ",nowSize=" + this.f3684a.d() + ",spendTime=" + (SystemClock.elapsedRealtime() - jElapsedRealtime));
        } catch (Throwable th) {
            try {
                j2.g("BackupFileManager", "checkToMoveSp fail=" + SystemUtils.getDesensitizedException(th));
            } finally {
                com.hihonor.hianalytics.util.g.c().c("isBackUpNewProcessMode", true);
            }
        }
    }

    public static t1 d() {
        return b;
    }

    public synchronized boolean b() {
        return this.f3684a.a();
    }

    public Map<String, ?> c() {
        return this.f3684a.b();
    }

    public long e() {
        return this.f3684a.d();
    }
}
