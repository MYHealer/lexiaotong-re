package com.adprof.sdk;

import android.database.sqlite.SQLiteDatabase;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class l7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l7 f1280a = new l7();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ThreadPoolExecutor f437a = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new ArrayBlockingQueue(10), new y3());

    public void a(SQLiteDatabase sQLiteDatabase, String str, String str2, rk rkVar) {
        try {
            this.f437a.submit(new k7(this, sQLiteDatabase, str, str2, rkVar));
        } catch (Throwable th) {
            pk.b("DBOperator delete error: ", th);
            rkVar.a(new Error(th.getMessage()));
        }
    }
}
