package com.umeng.analytics.pro;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.stub.StubApp;

/* JADX INFO: compiled from: UMDBCreater.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class f extends SQLiteOpenHelper {
    private static Context b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9156a;

    /* JADX INFO: renamed from: com.umeng.analytics.pro.f$1, reason: invalid class name */
    /* JADX INFO: compiled from: UMDBCreater.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* synthetic */ f(Context context, String str, String str2, SQLiteDatabase.CursorFactory cursorFactory, int i, AnonymousClass1 anonymousClass1) {
        this(context, str, str2, cursorFactory, i);
    }

    /* JADX INFO: compiled from: UMDBCreater.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final f f9157a = new f(f.b, h.b(f.b), e.b, null, 2, null);

        private a() {
        }
    }

    public static f a(Context context) {
        if (b == null) {
            b = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        return a.f9157a;
    }

    private f(Context context, String str, String str2, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        this(new c(context, str), str2, cursorFactory, i);
    }

    private f(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, TextUtils.isEmpty(str) ? e.b : str, cursorFactory, i);
        this.f9156a = null;
        a();
    }

    public void a() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (!h.a(e.d.f9153a, writableDatabase)) {
                c(writableDatabase);
            }
            if (!h.a(e.c.f9150a, writableDatabase)) {
                d(writableDatabase);
            }
            if (!h.a(e.b.f9147a, writableDatabase)) {
                b(writableDatabase);
            }
            if (h.a(e.a.f9144a, writableDatabase)) {
                return;
            }
            a(writableDatabase);
        } catch (Exception unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            try {
                sQLiteDatabase.beginTransaction();
                c(sQLiteDatabase);
                d(sQLiteDatabase);
                b(sQLiteDatabase);
                a(sQLiteDatabase);
                sQLiteDatabase.setTransactionSuccessful();
                if (sQLiteDatabase == null) {
                }
            } finally {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            h.a(b);
        } catch (Throwable unused3) {
            if (sQLiteDatabase == null) {
            }
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f9156a = "create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f9156a = "create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f9156a = "create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f9156a = "create table if not exists __is(id INTEGER primary key autoincrement, __ii TEXT unique, __e TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __is(id INTEGER primary key autoincrement, __ii TEXT unique, __e TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i2 <= i || i != 1) {
            return;
        }
        try {
            try {
                e(sQLiteDatabase);
            } catch (Exception unused) {
                f(sQLiteDatabase);
            }
        } catch (Exception unused2) {
            e(sQLiteDatabase);
        }
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        if (!h.a(sQLiteDatabase, e.d.f9153a, "__av")) {
            h.a(sQLiteDatabase, e.d.f9153a, "__sp", "TEXT");
            h.a(sQLiteDatabase, e.d.f9153a, "__pp", "TEXT");
            h.a(sQLiteDatabase, e.d.f9153a, "__av", "TEXT");
            h.a(sQLiteDatabase, e.d.f9153a, "__vc", "TEXT");
        }
        if (!h.a(sQLiteDatabase, e.b.f9147a, "__av")) {
            h.a(sQLiteDatabase, e.b.f9147a, "__av", "TEXT");
            h.a(sQLiteDatabase, e.b.f9147a, "__vc", "TEXT");
        }
        if (h.a(sQLiteDatabase, e.a.f9144a, "__av")) {
            return;
        }
        h.a(sQLiteDatabase, e.a.f9144a, "__av", "TEXT");
        h.a(sQLiteDatabase, e.a.f9144a, "__vc", "TEXT");
    }

    private void f(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, e.d.f9153a);
        a(sQLiteDatabase, e.b.f9147a);
        a(sQLiteDatabase, e.a.f9144a);
        a();
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        } catch (SQLException unused) {
        }
    }
}
