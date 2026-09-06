package com.umeng.analytics.process;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: UMProcessDBManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f9195a;
    private ConcurrentHashMap<String, a> b = new ConcurrentHashMap<>();
    private Context c;

    private c() {
    }

    static c a(Context context) {
        if (f9195a == null) {
            synchronized (c.class) {
                if (f9195a == null) {
                    f9195a = new c();
                }
            }
        }
        c cVar = f9195a;
        cVar.c = context;
        return cVar;
    }

    synchronized SQLiteDatabase a(String str) {
        return c(str).a();
    }

    synchronized void b(String str) {
        c(str).b();
    }

    private a c(String str) {
        if (this.b.get(str) == null) {
            a aVarA = a.a(this.c, str);
            this.b.put(str, aVarA);
            return aVarA;
        }
        return this.b.get(str);
    }

    /* JADX INFO: compiled from: UMProcessDBManager.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private AtomicInteger f9196a = new AtomicInteger();
        private SQLiteOpenHelper b;
        private SQLiteDatabase c;

        private a() {
        }

        static a a(Context context, String str) {
            Context appContext = UMGlobalContext.getAppContext(context);
            a aVar = new a();
            aVar.b = b.a(appContext, str);
            return aVar;
        }

        synchronized SQLiteDatabase a() {
            if (this.f9196a.incrementAndGet() == 1) {
                this.c = this.b.getWritableDatabase();
            }
            return this.c;
        }

        synchronized void b() {
            try {
                if (this.f9196a.decrementAndGet() == 0) {
                    this.c.close();
                }
            } catch (Throwable unused) {
            }
        }
    }
}
