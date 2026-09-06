package com.umeng.analytics.pro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.stub.StubApp;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: UMDBManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class g {
    private static SQLiteOpenHelper b;
    private static Context d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicInteger f9158a;
    private SQLiteDatabase c;

    /* JADX INFO: renamed from: com.umeng.analytics.pro.g$1, reason: invalid class name */
    /* JADX INFO: compiled from: UMDBManager.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* synthetic */ g(AnonymousClass1 anonymousClass1) {
        this();
    }

    private g() {
        this.f9158a = new AtomicInteger();
    }

    /* JADX INFO: compiled from: UMDBManager.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final g f9159a = new g(null);

        private a() {
        }
    }

    public static g a(Context context) {
        if (d == null && context != null) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            d = origApplicationContext;
            b = f.a(origApplicationContext);
        }
        return a.f9159a;
    }

    public synchronized SQLiteDatabase a() {
        if (this.f9158a.incrementAndGet() == 1) {
            this.c = b.getWritableDatabase();
        }
        return this.c;
    }

    public synchronized void b() {
        try {
            if (this.f9158a.decrementAndGet() == 0) {
                this.c.close();
            }
        } catch (Throwable unused) {
        }
    }
}
