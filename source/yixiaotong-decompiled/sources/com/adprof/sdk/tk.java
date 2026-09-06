package com.adprof.sdk;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class tk extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile tk f1443a;

    public tk(Context context) {
        super(context, "af_tk.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    /* JADX WARN: Code duplicated, block: B:64:? A[RETURN, SYNTHETIC] */
    public static void a(SQLiteDatabase sQLiteDatabase, qk qkVar, l2 l2Var) {
        boolean z;
        if (sQLiteDatabase == null) {
            l2Var.a(new Throwable("SQLiteDatabase is null"));
            return;
        }
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
                pk.b("SQL Track insert error2: ", th);
                l2Var.a(th);
                if (!z) {
                    return;
                }
            }
            l2Var.a();
        } catch (Throwable th2) {
            try {
                pk.b("SQL Track insert error1: ", th2);
                l2Var.a(th2);
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable th3) {
                    th = th3;
                    z = false;
                    pk.b("SQL Track insert error2: ", th);
                    l2Var.a(th);
                    if (!z) {
                        return;
                    }
                    l2Var.a();
                }
            } catch (Throwable th4) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable th5) {
                    pk.b("SQL Track insert error2: ", th5);
                    l2Var.a(th5);
                }
                throw th4;
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE tracks ( id integer primary key AUTOINCREMENT ,retryNum integer   ,source text   ,event text   ,request_id text   ,url text   ,timestamp integer, extInfo text, messageType integer,option_1 text, option_2 text,option_3 text,option_4 text );\n");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Log.w(tk.class.getName(), "Downgrading database from version " + i + " to " + i2 + ", which will destroy all old data");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tracks");
        sQLiteDatabase.execSQL("CREATE TABLE tracks ( id integer primary key AUTOINCREMENT ,retryNum integer   ,source text   ,event text   ,request_id text   ,url text   ,timestamp integer, extInfo text, messageType integer,option_1 text, option_2 text,option_3 text,option_4 text );\n");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        setWriteAheadLoggingEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        pk.e("SQLiteTrackHelper  onUpgrade  oldVersion = " + i + "    newVersion = " + i2);
    }
}
