package com.opos.acs.st.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.opos.acs.st.utils.f;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SQLiteDatabase f5852a;

    private a(Context context) {
        super(context, "acs_st.db", (SQLiteDatabase.CursorFactory) null, 8);
    }

    public static synchronized SQLiteDatabase a(Context context) {
        String str;
        String str2;
        SQLiteDatabase sQLiteDatabase = f5852a;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            try {
                f5852a = new a(context).getWritableDatabase();
            } catch (SQLiteException e) {
                e = e;
                str = "SQLiteHelper";
                str2 = "getInstance SQLiteException";
                f.c(str, str2, e);
            } catch (Exception e2) {
                e = e2;
                str = "SQLiteHelper";
                str2 = "getInstance Exception";
                f.c(str, str2, e);
            }
        }
        return f5852a;
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            sQLiteDatabase.beginTransaction();
            try {
                try {
                    sQLiteDatabase.execSQL("create table\tt_acs_st_db_cache\t(ID\tinteger primary key autoincrement,EVENT_ID\ttext,ACS_ID\ttext,URL\ttext,HEAD_JSON_STRING\ttext,BODY_JSON_STRING\ttext,EVENT_JSON_STRING\ttext,BATCH_ID\ttext,EVENT_TIME\tlong,UPLOAD_TYPE\tinteger);");
                    sQLiteDatabase.execSQL("create table\tt_stat_batch_entity\t(ID\tinteger primary key autoincrement,BATCH_ID\ttext,ACS_POS_IDS\ttext,EFFECTIVE_TAG\tinteger);");
                    sQLiteDatabase.execSQL("create table\tt_biz_entity\t(ID\tinteger primary key autoincrement,BIZ_DATA\ttext,EVENT_TIME\tlong,UPDATE_TIME\tlong);");
                    sQLiteDatabase.setTransactionSuccessful();
                    f.b("SQLiteHelper", "createTable success!");
                } catch (Exception e) {
                    f.c("SQLiteHelper", e.getMessage(), e);
                }
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase, int i) {
        if (sQLiteDatabase != null) {
            sQLiteDatabase.beginTransaction();
            try {
                if (i < 6) {
                    try {
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS t_acs_st_db_cache");
                        sQLiteDatabase.execSQL("create table\tt_acs_st_db_cache\t(ID\tinteger primary key autoincrement,EVENT_ID\ttext,ACS_ID\ttext,URL\ttext,HEAD_JSON_STRING\ttext,BODY_JSON_STRING\ttext,EVENT_JSON_STRING\ttext,BATCH_ID\ttext,EVENT_TIME\tlong,UPLOAD_TYPE\tinteger);");
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS t_stat_batch_entity");
                        sQLiteDatabase.execSQL("create table\tt_stat_batch_entity\t(ID\tinteger primary key autoincrement,BATCH_ID\ttext,ACS_POS_IDS\ttext,EFFECTIVE_TAG\tinteger);");
                        i = 6;
                    } catch (Exception e) {
                        f.b("SQLiteHelper", "database update exception!", e);
                        try {
                            a(sQLiteDatabase, "t_acs_st_db_cache");
                            sQLiteDatabase.execSQL("create table\tt_acs_st_db_cache\t(ID\tinteger primary key autoincrement,EVENT_ID\ttext,ACS_ID\ttext,URL\ttext,HEAD_JSON_STRING\ttext,BODY_JSON_STRING\ttext,EVENT_JSON_STRING\ttext,BATCH_ID\ttext,EVENT_TIME\tlong,UPLOAD_TYPE\tinteger);");
                            a(sQLiteDatabase, "t_stat_batch_entity");
                            sQLiteDatabase.execSQL("create table\tt_stat_batch_entity\t(ID\tinteger primary key autoincrement,BATCH_ID\ttext,ACS_POS_IDS\ttext,EFFECTIVE_TAG\tinteger);");
                            a(sQLiteDatabase, "t_biz_entity");
                            sQLiteDatabase.execSQL("create table\tt_biz_entity\t(ID\tinteger primary key autoincrement,BIZ_DATA\ttext,EVENT_TIME\tlong,UPDATE_TIME\tlong);");
                            sQLiteDatabase.setTransactionSuccessful();
                            f.b("SQLiteHelper", "deal update exception success!");
                        } catch (Exception e2) {
                            f.b("SQLiteHelper", e2.getMessage(), e2);
                        }
                    }
                }
                if (i >= 7) {
                    if (i < 8) {
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    f.b("SQLiteHelper", "updateTable success!");
                }
                sQLiteDatabase.execSQL("create table\tt_biz_entity\t(ID\tinteger primary key autoincrement,BIZ_DATA\ttext,EVENT_TIME\tlong,UPDATE_TIME\tlong);");
                if (!a(sQLiteDatabase, "t_acs_st_db_cache", "UPLOAD_TYPE")) {
                    sQLiteDatabase.execSQL("ALTER TABLE t_acs_st_db_cache ADD COLUMN UPLOAD_TYPE integer");
                }
                sQLiteDatabase.setTransactionSuccessful();
                f.b("SQLiteHelper", "updateTable success!");
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0054  */
    /* JADX WARN: Code duplicated, block: B:35:0x0058  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v6 */
    public static boolean a(SQLiteDatabase sQLiteDatabase, String str, String str2) throws Throwable {
        boolean z;
        Cursor cursorRawQuery;
        if (sQLiteDatabase == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            z = false;
        } else {
            ?? r1 = 0;
            string = null;
            string = null;
            string = null;
            String string = null;
            try {
                try {
                    cursorRawQuery = sQLiteDatabase.rawQuery(String.format("select sql from sqlite_master where type = 'table' and name = '%s'", str), null);
                    if (cursorRawQuery != null) {
                        try {
                            if (cursorRawQuery.moveToFirst()) {
                                string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("sql"));
                            }
                        } catch (Exception e) {
                            e = e;
                            f.b("SQLiteHelper", "isDBTableFieldExist", e);
                            if (cursorRawQuery != null) {
                            }
                            if (string == null) {
                                z = false;
                            } else {
                                z = false;
                            }
                            f.a("SQLiteHelper", "isDBTableFieldExist tableName:" + str + " fieldName:" + str2 + " result:" + z);
                            return z;
                        }
                    }
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    r1 = sQLiteDatabase;
                    if (r1 != 0) {
                        r1.close();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                cursorRawQuery = null;
            } catch (Throwable th2) {
                th = th2;
                if (r1 != 0) {
                    r1.close();
                }
                throw th;
            }
            if (string == null && string.contains(str2)) {
                z = true;
            } else {
                z = false;
            }
        }
        f.a("SQLiteHelper", "isDBTableFieldExist tableName:" + str + " fieldName:" + str2 + " result:" + z);
        return z;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            f.b("SQLiteHelper", "create table:");
            a(sQLiteDatabase);
        } catch (Exception e) {
            f.c("SQLiteHelper", e.getMessage());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        f.b("SQLiteHelper", "onDowngrade db old version code=" + i + "\tnew version code=" + i2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        f.b("SQLiteHelper", "upgrade db old version code=" + i + "\tnew version code=" + i2);
        if (i2 > i) {
            a(sQLiteDatabase, i);
        }
    }
}
