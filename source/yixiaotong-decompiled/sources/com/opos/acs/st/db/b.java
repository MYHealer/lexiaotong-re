package com.opos.acs.st.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.opos.acs.st.STManager;
import com.opos.acs.st.entity.d;
import com.opos.acs.st.utils.ErrorContants;
import com.opos.acs.st.utils.e;
import com.opos.acs.st.utils.f;
import com.opos.acs.st.utils.k;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ReentrantReadWriteLock f5853a = new ReentrantReadWriteLock();
    private static final ReentrantReadWriteLock b = new ReentrantReadWriteLock();

    public static int a(Context context, String str, long j) {
        ReentrantReadWriteLock.WriteLock writeLock;
        int iDelete = -1;
        if (context == null && j <= 0 && k.a(str)) {
            return -1;
        }
        String str2 = "EVENT_ID in (" + str + ") AND EVENT_TIME < " + j;
        try {
            SQLiteDatabase sQLiteDatabaseA = a.a(context);
            try {
                ReentrantReadWriteLock reentrantReadWriteLock = f5853a;
                reentrantReadWriteLock.writeLock().lock();
                iDelete = sQLiteDatabaseA.delete("t_acs_st_db_cache", str2, null);
                writeLock = reentrantReadWriteLock.writeLock();
            } catch (Exception unused) {
                writeLock = f5853a.writeLock();
            } catch (Throwable th) {
                f5853a.writeLock().unlock();
                throw th;
            }
            writeLock.unlock();
        } catch (Exception e) {
            f.c("STDBUtils", "DeleteStatItemEntityByEventTime", e);
        }
        return iDelete;
    }

    private static ContentValues a(com.opos.acs.st.entity.c cVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("BATCH_ID", cVar.b);
        contentValues.put("ACS_POS_IDS", cVar.c);
        contentValues.put("EFFECTIVE_TAG", Integer.valueOf(cVar.d));
        return contentValues;
    }

    private static d a(Context context, Cursor cursor) {
        d dVar = new d();
        dVar.f5857a = cursor.getInt(cursor.getColumnIndex(STManager.REGION_OF_ID));
        dVar.b = cursor.getString(cursor.getColumnIndex("EVENT_ID"));
        dVar.c = cursor.getString(cursor.getColumnIndex("ACS_ID"));
        dVar.d = cursor.getString(cursor.getColumnIndex("URL"));
        dVar.h = cursor.getString(cursor.getColumnIndex("BATCH_ID"));
        dVar.i = cursor.getLong(cursor.getColumnIndex("EVENT_TIME"));
        dVar.e = e.b(context, cursor.getString(cursor.getColumnIndex("HEAD_JSON_STRING")), ErrorContants.LOCAL_DE_ERROR);
        dVar.f = e.b(context, cursor.getString(cursor.getColumnIndex("BODY_JSON_STRING")), ErrorContants.LOCAL_DE_ERROR);
        dVar.g = e.b(context, cursor.getString(cursor.getColumnIndex("EVENT_JSON_STRING")), ErrorContants.LOCAL_DE_ERROR);
        dVar.j = cursor.getInt(cursor.getColumnIndex("UPLOAD_TYPE"));
        if (dVar.j == 1) {
            try {
                dVar.k = new JSONObject(dVar.e);
                dVar.l = new JSONObject(dVar.f);
            } catch (JSONException unused) {
                f.c("STDBUtils", "getStatItemEntityFromCursor error!");
            }
        }
        return dVar;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x005f  */
    public static d a(Context context, String str, String str2, String str3) throws Throwable {
        Cursor cursorRawQuery;
        d dVarA = null;
        dVarA = null;
        dVarA = null;
        dVarA = null;
        dVarA = null;
        dVarA = null;
        Cursor cursor = null;
        dVarA = null;
        dVarA = null;
        dVarA = null;
        if (context != null && str != null && str2 != null && str3 != null) {
            String[] strArr = {str, str3, str2};
            try {
                SQLiteDatabase sQLiteDatabaseA = a.a(context);
                try {
                    ReentrantReadWriteLock reentrantReadWriteLock = f5853a;
                    reentrantReadWriteLock.readLock().lock();
                    cursorRawQuery = sQLiteDatabaseA.rawQuery("select * from t_acs_st_db_cache where EVENT_ID = ? and URL = ? and ACS_ID = ? ", strArr);
                    try {
                        try {
                            reentrantReadWriteLock.readLock().unlock();
                            if (cursorRawQuery != null && cursorRawQuery.getCount() > 0 && cursorRawQuery.moveToFirst()) {
                                dVarA = a(context, cursorRawQuery);
                            }
                            if (cursorRawQuery != null) {
                                a(cursorRawQuery);
                            }
                        } catch (Exception e) {
                            e = e;
                            f.c("STDBUtils", "queryStatItemEntity", e);
                            if (cursorRawQuery != null) {
                            }
                            return dVarA;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursorRawQuery;
                        if (cursor != null) {
                            a(cursor);
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    f5853a.readLock().unlock();
                    throw th2;
                }
            } catch (Exception e2) {
                e = e2;
                cursorRawQuery = null;
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    a(cursor);
                }
                throw th;
            }
        }
        return dVarA;
    }

    public static Integer a(Context context, String str) {
        String str2 = "select count(*) from t_acs_st_db_cache where EVENT_ID = '" + str + "'";
        Cursor cursorRawQuery = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseA = a.a(context);
                ReentrantReadWriteLock reentrantReadWriteLock = f5853a;
                reentrantReadWriteLock.writeLock().lock();
                cursorRawQuery = sQLiteDatabaseA.rawQuery(str2, null);
                cursorRawQuery.moveToFirst();
                Integer numValueOf = Integer.valueOf(cursorRawQuery.getInt(0));
                reentrantReadWriteLock.writeLock().unlock();
                a(cursorRawQuery);
                return numValueOf;
            } catch (Exception e) {
                f.c("STDBUtils", "queryAllStatItemEntityCount", e);
                f5853a.writeLock().unlock();
                a(cursorRawQuery);
                return 0;
            }
        } catch (Throwable th) {
            f5853a.writeLock().unlock();
            a(cursorRawQuery);
            throw th;
        }
    }

    private static String a(List<String> list) {
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            sb.append("(");
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                if (i != list.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append(")");
        }
        return sb.toString();
    }

    private static String a(Integer[] numArr) {
        StringBuilder sb = new StringBuilder();
        if (numArr != null) {
            sb.append("(");
            for (int i = 0; i < numArr.length; i++) {
                sb.append(numArr[i]);
                if (i != numArr.length - 1) {
                    sb.append(",");
                }
            }
            sb.append(")");
        }
        return sb.toString();
    }

    public static List<String> a(Context context) throws Throwable {
        Throwable th;
        Cursor cursorRawQuery;
        ArrayList arrayList;
        Exception e;
        ArrayList arrayList2 = null;
        if (context == null) {
            return null;
        }
        try {
            SQLiteDatabase sQLiteDatabaseA = a.a(context);
            try {
                ReentrantReadWriteLock reentrantReadWriteLock = f5853a;
                reentrantReadWriteLock.readLock().lock();
                cursorRawQuery = sQLiteDatabaseA.rawQuery("select distinct URL from t_acs_st_db_cache", null);
                try {
                    try {
                        reentrantReadWriteLock.readLock().unlock();
                        if (cursorRawQuery != null && cursorRawQuery.getCount() > 0 && cursorRawQuery.moveToFirst()) {
                            arrayList = new ArrayList();
                            do {
                                try {
                                    arrayList.add(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("URL")));
                                } catch (Exception e2) {
                                    e = e2;
                                    f.c("STDBUtils", "queryAllStatItemEntity", e);
                                    if (cursorRawQuery != null) {
                                        a(cursorRawQuery);
                                    }
                                    return arrayList;
                                }
                            } while (cursorRawQuery.moveToNext());
                            arrayList2 = arrayList;
                        }
                        if (cursorRawQuery == null) {
                            return arrayList2;
                        }
                        a(cursorRawQuery);
                        return arrayList2;
                    } catch (Exception e3) {
                        arrayList = null;
                        e = e3;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursorRawQuery != null) {
                        a(cursorRawQuery);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                f5853a.readLock().unlock();
                throw th3;
            }
        } catch (Exception e4) {
            arrayList = null;
            e = e4;
            cursorRawQuery = null;
        } catch (Throwable th4) {
            th = th4;
            cursorRawQuery = null;
        }
    }

    public static List<d> a(Context context, String str, String str2) throws Throwable {
        ArrayList arrayList;
        Cursor cursor = null;
        arrayList = null;
        arrayList = null;
        ArrayList arrayList2 = null;
        Cursor cursor2 = null;
        if (context == null || str == null || str2 == null) {
            return null;
        }
        String[] strArr = {str, str2};
        try {
            try {
                SQLiteDatabase sQLiteDatabaseA = a.a(context);
                try {
                    ReentrantReadWriteLock reentrantReadWriteLock = f5853a;
                    reentrantReadWriteLock.readLock().lock();
                    Cursor cursorRawQuery = sQLiteDatabaseA.rawQuery("select * from t_acs_st_db_cache where EVENT_ID = ? AND URL = ? ", strArr);
                    try {
                        try {
                            reentrantReadWriteLock.readLock().unlock();
                            if (cursorRawQuery != null && cursorRawQuery.getCount() > 0 && cursorRawQuery.moveToFirst()) {
                                arrayList = new ArrayList();
                                do {
                                    try {
                                        arrayList.add(a(context, cursorRawQuery));
                                    } catch (Exception e) {
                                        e = e;
                                        cursor = cursorRawQuery;
                                        f.c("STDBUtils", "queryAllStatItemEntity", e);
                                        if (cursor != null) {
                                            a(cursor);
                                        }
                                        return arrayList;
                                    }
                                } while (cursorRawQuery.moveToNext());
                                arrayList2 = arrayList;
                            }
                            if (cursorRawQuery == null) {
                                return arrayList2;
                            }
                            a(cursorRawQuery);
                            return arrayList2;
                        } catch (Exception e2) {
                            e = e2;
                            arrayList = null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursorRawQuery;
                        if (cursor2 != null) {
                            a(cursor2);
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    f5853a.readLock().unlock();
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e3) {
            e = e3;
            arrayList = null;
        }
    }

    private static void a(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return;
        }
        cursor.close();
    }

    public static boolean a(Context context, com.opos.acs.st.entity.c cVar) {
        boolean z = false;
        if (context != null && cVar != null) {
            ContentValues contentValuesA = a(cVar);
            try {
                SQLiteDatabase sQLiteDatabaseA = a.a(context);
                try {
                    b.writeLock().lock();
                    z = -1 != sQLiteDatabaseA.insert("t_stat_batch_entity", null, contentValuesA);
                } finally {
                    b.writeLock().unlock();
                }
            } catch (Exception e) {
                f.c("STDBUtils", "insertStatBatchEntity", e);
            }
        }
        return z;
    }

    public static boolean a(Context context, d dVar) {
        boolean z = false;
        if (context != null && dVar != null) {
            ContentValues contentValuesC = c(context, dVar);
            try {
                SQLiteDatabase sQLiteDatabaseA = a.a(context);
                try {
                    f5853a.writeLock().lock();
                    z = -1 != sQLiteDatabaseA.insert("t_acs_st_db_cache", null, contentValuesC);
                } finally {
                    f5853a.writeLock().unlock();
                }
            } catch (Exception e) {
                f.c("STDBUtils", "insertStatItemEntity", e);
            }
        }
        return z;
    }

    public static boolean a(Context context, List<String> list) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        String str = (list == null || list.size() == 0) ? "delete from t_stat_batch_entity" : "delete from t_stat_batch_entity where BATCH_ID in " + a(list);
        try {
            SQLiteDatabase sQLiteDatabaseA = a.a(context);
            try {
                ReentrantReadWriteLock reentrantReadWriteLock = b;
                reentrantReadWriteLock.writeLock().lock();
                sQLiteDatabaseA.execSQL(str);
                try {
                    reentrantReadWriteLock.writeLock().unlock();
                    return true;
                } catch (Exception e) {
                    e = e;
                    z = true;
                    f.c("STDBUtils", "deleteStatBatchEntitysByBatchIds", e);
                    return z;
                }
            } catch (Exception unused) {
                b.writeLock().unlock();
                return false;
            } catch (Throwable th) {
                b.writeLock().unlock();
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static boolean a(Context context, Integer[] numArr) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        String str = (numArr == null || numArr.length == 0) ? "delete from t_acs_st_db_cache" : "delete from t_acs_st_db_cache where ID in " + a(numArr);
        try {
            SQLiteDatabase sQLiteDatabaseA = a.a(context);
            try {
                ReentrantReadWriteLock reentrantReadWriteLock = f5853a;
                reentrantReadWriteLock.writeLock().lock();
                sQLiteDatabaseA.execSQL(str);
                try {
                    reentrantReadWriteLock.writeLock().unlock();
                    return true;
                } catch (Exception e) {
                    e = e;
                    z = true;
                    f.c("STDBUtils", "deleteStatItemEntityByIds", e);
                    return z;
                }
            } catch (Exception unused) {
                f5853a.writeLock().unlock();
                return false;
            } catch (Throwable th) {
                f5853a.writeLock().unlock();
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x005b  */
    public static com.opos.acs.st.entity.c b(Context context, String str) throws Throwable {
        Cursor cursorRawQuery;
        com.opos.acs.st.entity.c cVarB = null;
        cVarB = null;
        cVarB = null;
        cVarB = null;
        cVarB = null;
        cVarB = null;
        Cursor cursor = null;
        cVarB = null;
        if (context != null && str != null) {
            String[] strArr = {str};
            try {
                SQLiteDatabase sQLiteDatabaseA = a.a(context);
                try {
                    ReentrantReadWriteLock reentrantReadWriteLock = b;
                    reentrantReadWriteLock.readLock().lock();
                    cursorRawQuery = sQLiteDatabaseA.rawQuery("select * from t_stat_batch_entity where BATCH_ID = ? ", strArr);
                    try {
                        try {
                            reentrantReadWriteLock.readLock().unlock();
                            if (cursorRawQuery != null && cursorRawQuery.getCount() > 0 && cursorRawQuery.moveToFirst()) {
                                cVarB = b(cursorRawQuery);
                            }
                            if (cursorRawQuery != null) {
                                a(cursorRawQuery);
                            }
                        } catch (Exception e) {
                            e = e;
                            f.c("STDBUtils", "queryStatBatchEntity", e);
                            if (cursorRawQuery != null) {
                            }
                            return cVarB;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursorRawQuery;
                        if (cursor != null) {
                            a(cursor);
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    b.readLock().unlock();
                    throw th2;
                }
            } catch (Exception e2) {
                e = e2;
                cursorRawQuery = null;
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    a(cursor);
                }
                throw th;
            }
        }
        return cVarB;
    }

    private static com.opos.acs.st.entity.c b(Cursor cursor) {
        com.opos.acs.st.entity.c cVar = new com.opos.acs.st.entity.c();
        cVar.f5856a = cursor.getInt(cursor.getColumnIndex(STManager.REGION_OF_ID));
        cVar.b = cursor.getString(cursor.getColumnIndex("BATCH_ID"));
        cVar.c = cursor.getString(cursor.getColumnIndex("ACS_POS_IDS"));
        cVar.d = cursor.getInt(cursor.getColumnIndex("EFFECTIVE_TAG"));
        return cVar;
    }

    public static boolean b(Context context, com.opos.acs.st.entity.c cVar) {
        boolean z = false;
        if (context != null && cVar != null) {
            String[] strArr = {String.valueOf(cVar.f5856a)};
            ContentValues contentValuesA = a(cVar);
            try {
                SQLiteDatabase sQLiteDatabaseA = a.a(context);
                try {
                    b.writeLock().lock();
                    sQLiteDatabaseA.update("t_stat_batch_entity", contentValuesA, "ID = ? ", strArr);
                    z = true;
                } finally {
                    b.writeLock().unlock();
                }
            } catch (Exception e) {
                f.c("STDBUtils", "updateStatBatchEntity", e);
            }
        }
        return z;
    }

    public static boolean b(Context context, d dVar) {
        boolean z = false;
        if (context != null && dVar != null) {
            String[] strArr = {String.valueOf(dVar.f5857a)};
            ContentValues contentValuesC = c(context, dVar);
            try {
                SQLiteDatabase sQLiteDatabaseA = a.a(context);
                try {
                    f5853a.writeLock().lock();
                    sQLiteDatabaseA.update("t_acs_st_db_cache", contentValuesC, "ID = ? ", strArr);
                    z = true;
                } finally {
                    f5853a.writeLock().unlock();
                }
            } catch (Exception e) {
                f.c("STDBUtils", "updateStatItemEntity", e);
            }
        }
        return z;
    }

    private static ContentValues c(Context context, d dVar) {
        if (dVar.j == 1) {
            if (dVar.k != null) {
                dVar.e = dVar.k.toString();
            }
            if (dVar.l != null) {
                dVar.f = dVar.l.toString();
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("EVENT_ID", dVar.b);
        contentValues.put("ACS_ID", dVar.c);
        contentValues.put("URL", dVar.d);
        contentValues.put("BATCH_ID", dVar.h);
        contentValues.put("EVENT_TIME", Long.valueOf(dVar.i));
        contentValues.put("HEAD_JSON_STRING", e.a(context, dVar.e, ErrorContants.LOCAL_EN_ERROR));
        contentValues.put("BODY_JSON_STRING", e.a(context, dVar.f, ErrorContants.LOCAL_EN_ERROR));
        contentValues.put("EVENT_JSON_STRING", e.a(context, dVar.g, ErrorContants.LOCAL_EN_ERROR));
        contentValues.put("UPLOAD_TYPE", Integer.valueOf(dVar.j));
        return contentValues;
    }
}
