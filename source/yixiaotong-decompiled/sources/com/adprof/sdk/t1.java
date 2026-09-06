package com.adprof.sdk;

import android.database.DatabaseUtils;
import com.cdo.oaps.ad.OapsKey;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class t1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w1 f1432a;

    public t1(w1 w1Var) {
        this.f1432a = w1Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        w1 w1Var = this.f1432a;
        w1Var.getClass();
        try {
            w1Var.f787a.execSQL("delete from point where item is null");
        } catch (Throwable th) {
            pk.b("clearLogDB fail", th);
        }
        w1 w1Var2 = this.f1432a;
        w1Var2.getClass();
        try {
            long jQueryNumEntries = DatabaseUtils.queryNumEntries(w1Var2.f787a, OapsKey.KEY_POINT);
            if (jQueryNumEntries <= 500000) {
                return;
            }
            w1Var2.a(jQueryNumEntries - 500000);
        } catch (Throwable th2) {
            pk.b("clearLogDB fail", th2);
        }
    }
}
