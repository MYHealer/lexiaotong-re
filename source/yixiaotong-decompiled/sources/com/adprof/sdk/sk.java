package com.adprof.sdk;

import android.content.Context;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;
import com.stub.StubApp;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class sk extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile sk f1425a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f725a;

    public sk(Context context) {
        super(context, "af_sts.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.f725a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0085  */
    /* JADX WARN: Code duplicated, block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:? A[RETURN, SYNTHETIC] */
    public static void a(SQLiteDatabase sQLiteDatabase, qk qkVar, lh lhVar) {
        boolean z;
        lh lhVar2;
        sQLiteDatabase.beginTransaction();
        try {
            SQLiteStatement sQLiteStatementCompileStatement = sQLiteDatabase.compileStatement(qkVar.f1388a);
            z = true;
            for (int i = 1; i <= qkVar.f681a.size(); i++) {
                Object obj = qkVar.f682a.get((String) qkVar.f681a.get(i - 1));
                if (obj != null) {
                    if (obj instanceof String) {
                        sQLiteStatementCompileStatement.bindString(i, (String) obj);
                    } else if (obj instanceof Double) {
                        sQLiteStatementCompileStatement.bindDouble(i, ((Double) obj).doubleValue());
                    } else if (obj instanceof Number) {
                        sQLiteStatementCompileStatement.bindLong(i, ((Number) obj).longValue());
                    } else if (obj instanceof byte[]) {
                        sQLiteStatementCompileStatement.bindBlob(i, (byte[]) obj);
                    }
                }
                sQLiteStatementCompileStatement.bindNull(i);
            }
            sQLiteStatementCompileStatement.execute();
            sQLiteDatabase.setTransactionSuccessful();
            try {
                sQLiteDatabase.endTransaction();
            } catch (Throwable th) {
                th = th;
                pk.b("SQL MTA insert error2: ", th);
                lhVar.a(th);
                if (!z) {
                    return;
                }
            }
            lhVar2 = lhVar.f1288a;
            if (lhVar2 != null) {
                lhVar2.a();
            }
        } catch (Throwable th2) {
            try {
                pk.b("SQL MTA insert error1: ", th2);
                lhVar.a(th2);
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable th3) {
                    th = th3;
                    z = false;
                    pk.b("SQL MTA insert error2: ", th);
                    lhVar.a(th);
                    if (!z) {
                        return;
                    }
                    lhVar2 = lhVar.f1288a;
                    if (lhVar2 != null) {
                        lhVar2.a();
                    }
                }
            } catch (Throwable th4) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable th5) {
                    pk.b("SQL MTA insert error2: ", th5);
                    lhVar.a(th5);
                }
                throw th4;
            }
        }
    }

    public SQLiteDatabase a() {
        String str;
        File parentFile;
        try {
            Context context = this.f725a;
            if (context == null || (parentFile = context.getDatabasePath("af_sts.db").getParentFile()) == null || parentFile.exists() || parentFile.mkdirs() || parentFile.exists()) {
                return getWritableDatabase();
            }
            pk.b("SQLiteMTAHelper: Failed to create database directory: " + parentFile.getAbsolutePath());
            return null;
        } catch (SQLiteCantOpenDatabaseException e) {
            pk.b("SQLiteMTAHelper: Cannot open database", e);
            try {
                Context context2 = this.f725a;
                if (context2 != null) {
                    File databasePath = context2.getDatabasePath("af_sts.db");
                    if (databasePath.exists()) {
                        pk.a("SQLiteMTAHelper: Deleted corrupted database file: " + databasePath.delete());
                    }
                    return getWritableDatabase();
                }
            } catch (Throwable th) {
                pk.b("SQLiteMTAHelper: Retry failed", th);
            }
            return null;
        } catch (SQLiteException e2) {
            e = e2;
            str = "SQLiteMTAHelper: SQLite exception";
            pk.b(str, e);
            return null;
        } catch (Throwable th2) {
            e = th2;
            str = "SQLiteMTAHelper: Unexpected error";
            pk.b(str, e);
            return null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE point ( point_id integer  primary key  ,item text , encryption int, option_1 text, option_2 text,option_3 text,option_4 text);\n");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Log.w(sk.class.getName(), "Downgrading database from version " + i + " to " + i2 + ", which will destroy all old data");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS point");
        sQLiteDatabase.execSQL("CREATE TABLE point ( point_id integer  primary key  ,item text , encryption int, option_1 text, option_2 text,option_3 text,option_4 text);\n");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        setWriteAheadLoggingEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        pk.e("SQLiteMTAHelper  onUpgrade  oldVersion = " + i + "    newVersion = " + i2);
    }
}
