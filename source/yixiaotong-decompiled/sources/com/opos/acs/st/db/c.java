package com.opos.acs.st.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.opos.acs.st.STManager;
import com.opos.acs.st.utils.ErrorContants;
import com.opos.acs.st.utils.e;
import com.opos.acs.st.utils.f;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ReentrantReadWriteLock f5854a = new ReentrantReadWriteLock();

    public static int a(Context context) {
        Cursor cursorRawQuery = null;
        try {
            SQLiteDatabase sQLiteDatabaseA = a.a(context);
            f5854a.readLock().lock();
            cursorRawQuery = sQLiteDatabaseA.rawQuery("select count(*) from t_biz_entity", null);
            cursorRawQuery.moveToFirst();
            return cursorRawQuery.getInt(0);
        } catch (Exception e) {
            f.c("StBizUtils", "queryCount", e);
            return 0;
        } finally {
            f5854a.readLock().unlock();
            if (cursorRawQuery != null && !cursorRawQuery.isClosed()) {
                cursorRawQuery.close();
            }
        }
    }

    private static com.opos.acs.st.entity.b a(Context context, Cursor cursor) {
        com.opos.acs.st.entity.b bVar = new com.opos.acs.st.entity.b();
        bVar.f5855a = cursor.getInt(cursor.getColumnIndex(STManager.REGION_OF_ID));
        bVar.b = e.b(context, cursor.getString(cursor.getColumnIndex("BIZ_DATA")), ErrorContants.LOCAL_BIZ_DE_ERROR);
        bVar.c = cursor.getLong(cursor.getColumnIndex("EVENT_TIME"));
        bVar.d = cursor.getLong(cursor.getColumnIndex("UPDATE_TIME"));
        return bVar;
    }

    public static List<com.opos.acs.st.entity.b> a(Context context, long j, int i) throws Throwable {
        ArrayList arrayList;
        Cursor cursor = null;
        arrayList = null;
        arrayList = null;
        ArrayList arrayList2 = null;
        cursor = null;
        if (context == null) {
            return null;
        }
        try {
            try {
                SQLiteDatabase sQLiteDatabaseA = a.a(context);
                f5854a.readLock().lock();
                Cursor cursorQuery = sQLiteDatabaseA.query("t_biz_entity", null, "EVENT_TIME>?", new String[]{String.valueOf(j)}, null, null, "UPDATE_TIME", String.valueOf(i));
                if (cursorQuery != null) {
                    try {
                        try {
                            if (cursorQuery.getCount() > 0 && cursorQuery.moveToFirst()) {
                                arrayList = new ArrayList();
                                do {
                                    try {
                                        arrayList.add(a(context, cursorQuery));
                                    } catch (Exception e) {
                                        e = e;
                                        cursor = cursorQuery;
                                        f.c("StBizUtils", "query all StBizEntity", e);
                                        f5854a.readLock().unlock();
                                        if (cursor != null && !cursor.isClosed()) {
                                            cursor.close();
                                        }
                                        return arrayList;
                                    }
                                } while (cursorQuery.moveToNext());
                                arrayList2 = arrayList;
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor = cursorQuery;
                            f5854a.readLock().unlock();
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        arrayList = null;
                    }
                }
                f5854a.readLock().unlock();
                if (cursorQuery == null || cursorQuery.isClosed()) {
                    return arrayList2;
                }
                cursorQuery.close();
                return arrayList2;
            } catch (Exception e3) {
                e = e3;
                arrayList = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void a(Context context, long j) {
        if (context != null || j > 0) {
            try {
                try {
                    f5854a.writeLock().lock();
                    a.a(context).delete("t_biz_entity", "EVENT_TIME < " + j, null);
                    f.a("StBizUtils", "delete expired data from db!");
                } catch (Exception e) {
                    f.c("StBizUtils", "delete expired failed", e);
                }
            } finally {
                f5854a.writeLock().unlock();
            }
        }
    }

    public static void a(Context context, com.opos.acs.st.entity.b bVar) {
        try {
            if (context == null) {
                return;
            }
            try {
                ContentValues contentValuesD = d(context, bVar);
                SQLiteDatabase sQLiteDatabaseA = a.a(context);
                f5854a.writeLock().lock();
                sQLiteDatabaseA.insert("t_biz_entity", null, contentValuesD);
                f.a("StBizUtils", "saved business data to db!");
            } catch (Exception e) {
                f.c("StBizUtils", "insert StBizEntity failed", e);
            }
        } finally {
            f5854a.writeLock().unlock();
        }
    }

    public static void b(Context context, com.opos.acs.st.entity.b bVar) {
        if (context != null) {
            try {
                if (bVar == null) {
                    return;
                }
                try {
                    bVar.d = System.currentTimeMillis();
                    String[] strArr = {String.valueOf(bVar.f5855a)};
                    ContentValues contentValuesD = d(context, bVar);
                    SQLiteDatabase sQLiteDatabaseA = a.a(context);
                    f5854a.writeLock().lock();
                    sQLiteDatabaseA.update("t_biz_entity", contentValuesD, "ID = ? ", strArr);
                } catch (Exception e) {
                    f.c("StBizUtils", "update StBizEntity failed", e);
                }
            } finally {
                f5854a.writeLock().unlock();
            }
        }
    }

    public static void c(Context context, com.opos.acs.st.entity.b bVar) {
        if (context == null) {
            return;
        }
        try {
            try {
                SQLiteDatabase sQLiteDatabaseA = a.a(context);
                String[] strArr = {String.valueOf(bVar.f5855a)};
                f5854a.writeLock().lock();
                sQLiteDatabaseA.delete("t_biz_entity", "ID = ? ", strArr);
                f.a("StBizUtils", "delete business data from db!");
            } catch (Exception e) {
                f.c("StBizUtils", "delete business failed", e);
            }
        } finally {
            f5854a.writeLock().unlock();
        }
    }

    public static ContentValues d(Context context, com.opos.acs.st.entity.b bVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("BIZ_DATA", e.a(context, bVar.b, ErrorContants.LOCAL_BIZ_EN_ERROR));
        contentValues.put("EVENT_TIME", Long.valueOf(bVar.c));
        contentValues.put("UPDATE_TIME", Long.valueOf(bVar.d));
        return contentValues;
    }
}
