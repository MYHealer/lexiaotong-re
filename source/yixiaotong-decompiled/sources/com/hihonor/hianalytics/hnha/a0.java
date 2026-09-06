package com.hihonor.hianalytics.hnha;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Pair;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.io.Closeable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public final class a0 extends w implements e0.a {
    private final ContentValues b = new ContentValues();
    private long c = -1;
    private final s3 d = new s3(new Runnable() { // from class: com.hihonor.hianalytics.hnha.a0$$ExternalSyntheticLambda2
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.i();
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e0 f3617a = new e0(this);

    private int a(SQLiteDatabase sQLiteDatabase, List<n0> list) {
        ContentValues contentValuesB = v.b(1);
        int iUpdateWithOnConflict = 0;
        for (Pair<String, String[]> pair : v.d(list)) {
            iUpdateWithOnConflict += sQLiteDatabase.updateWithOnConflict("events", contentValuesB, (String) pair.first, (String[]) pair.second, 5);
        }
        return iUpdateWithOnConflict;
    }

    private Pair<Boolean, Long> a(SQLiteDatabase sQLiteDatabase, List<p0> list, long j, long j2) {
        Pair<String, String[]> pairC = v.c(list, j);
        try {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery((String) pairC.first, (String[]) pairC.second);
            int columnIndexOrThrow = cursorRawQuery.getColumnIndexOrThrow("evtId");
            int columnIndexOrThrow2 = cursorRawQuery.getColumnIndexOrThrow("_size");
            if (!cursorRawQuery.moveToFirst()) {
                Pair<Boolean, Long> pairCreate = Pair.create(Boolean.FALSE, -1L);
                com.hihonor.hianalytics.util.k.a(cursorRawQuery);
                return pairCreate;
            }
            long j3 = 0;
            do {
                long j4 = cursorRawQuery.getLong(columnIndexOrThrow);
                j3 += (long) cursorRawQuery.getInt(columnIndexOrThrow2);
                if (j3 > j2) {
                    Pair<Boolean, Long> pairCreate2 = Pair.create(Boolean.TRUE, Long.valueOf(j));
                    com.hihonor.hianalytics.util.k.a(cursorRawQuery);
                    return pairCreate2;
                }
                if (j4 > j) {
                    j = j4;
                }
                if (j3 == j2) {
                    Pair<Boolean, Long> pairCreate3 = Pair.create(Boolean.valueOf(!cursorRawQuery.isLast()), Long.valueOf(j));
                    com.hihonor.hianalytics.util.k.a(cursorRawQuery);
                    return pairCreate3;
                }
            } while (cursorRawQuery.moveToNext());
            Pair<Boolean, Long> pairCreate4 = Pair.create(Boolean.FALSE, Long.valueOf(j));
            com.hihonor.hianalytics.util.k.a(cursorRawQuery);
            return pairCreate4;
        } catch (Throwable th) {
            com.hihonor.hianalytics.util.k.a((Closeable) null);
            throw th;
        }
    }

    private j0 a(Cursor cursor) {
        long j = cursor.getLong(cursor.getColumnIndexOrThrow("_id"));
        long j2 = cursor.getLong(cursor.getColumnIndexOrThrow("_cTime"));
        return new j0(j, "com.hihonor.hianalytics", cursor.getString(cursor.getColumnIndexOrThrow("_url")), j2, cursor.getInt(cursor.getColumnIndexOrThrow("_priority")), cursor.getString(cursor.getColumnIndexOrThrow("_idsInfo")), new p0("hianalytics_sdk_tag", 0), cursor.getString(cursor.getColumnIndexOrThrow("_crMd")), cursor.getString(cursor.getColumnIndexOrThrow("_kMd")), cursor.getString(cursor.getColumnIndexOrThrow("_ksMd")));
    }

    private l0 a(int i, List<String> list, k0 k0Var, SQLiteDatabase sQLiteDatabase) throws Throwable {
        long jA = com.hihonor.hianalytics.util.r.a();
        List<p0> list2 = k0Var.f3652a;
        Pair<String, String[]> pairA = v.a(list2, list);
        List<n0> listA = a(sQLiteDatabase, (String) pairA.first, (String[]) pairA.second, list2, "failRetry");
        int size = listA == null ? 0 : listA.size();
        if (size == 0) {
            j2.a("EventSqliteHandler", "doGetToSendEventByReqId spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",tagTypeSize=" + list2.size() + ",queryNum=" + i + ",size=" + size + ",nowSize=" + k0Var.b() + ",reqIdSize=" + list.size() + ",reqIdList=" + list);
            return i > 8 ? new l0(true, Collections.emptyList(), k0Var.e) : a(i + 1, false, k0Var, sQLiteDatabase);
        }
        int iA = a(sQLiteDatabase, listA);
        sQLiteDatabase.setTransactionSuccessful();
        j2.a(iA == size ? 3 : 5, "EventSqliteHandler", "doGetToSendEventByReqId spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",tagTypeSize=" + list2.size() + ",queryNum=" + i + ",size=" + size + ",num=" + iA + ",nowSize=" + k0Var.b() + ",reqIdSize=" + list.size() + ",reqIdList=" + list);
        return new l0(true, listA, k0Var.e);
    }

    private l0 a(int i, boolean z, k0 k0Var, SQLiteDatabase sQLiteDatabase) {
        if (z) {
            b(k0Var, sQLiteDatabase);
            return a(i + 1, false, k0Var, sQLiteDatabase);
        }
        List<String> listA = k0Var.a();
        return !listA.isEmpty() ? a(i, listA, k0Var, sQLiteDatabase) : a(k0Var, sQLiteDatabase);
    }

    private l0 a(k0 k0Var, SQLiteDatabase sQLiteDatabase) {
        long jA = com.hihonor.hianalytics.util.r.a();
        List<p0> list = k0Var.f3652a;
        long j = k0Var.b;
        long j2 = k0Var.d;
        Pair<Boolean, Long> pairA = a(sQLiteDatabase, list, j, j2);
        boolean zBooleanValue = ((Boolean) pairA.first).booleanValue();
        if (((Long) pairA.second).longValue() <= j) {
            j2.a("EventSqliteHandler", "doGetToSendEventByNoReqId spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",tagTypeSize=" + list.size() + ",startId=" + j + ",maxId=" + pairA.second + ",hasNext=" + zBooleanValue + ",limitSize=" + j2);
            return new l0(false, Collections.emptyList());
        }
        List<n0> listB = b(sQLiteDatabase, list, j, ((Long) pairA.second).longValue() + 1);
        int size = listB == null ? 0 : listB.size();
        if (size == 0) {
            j2.a("EventSqliteHandler", "doGetToSendEventByNoReqId spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",tagTypeSize=" + list.size() + ",size=" + size + ",startId=" + j + ",maxId=" + pairA.second + ",hasNext=" + zBooleanValue + ",limitSize=" + j2);
            return new l0(false, Collections.emptyList());
        }
        int iA = a(sQLiteDatabase, listB);
        sQLiteDatabase.setTransactionSuccessful();
        j2.a(iA == size ? 3 : 5, "EventSqliteHandler", "doGetToSendEventByNoReqId spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",tagTypeSize=" + list.size() + ",size=" + size + ",num=" + iA + ",startId=" + j + ",maxId=" + pairA.second + ",hasNext=" + zBooleanValue + ",limitSize=" + j2);
        return new l0(zBooleanValue, listB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ m0 a(boolean z, List list) {
        long jA = com.hihonor.hianalytics.util.r.a();
        m0 m0Var = new m0();
        SQLiteDatabase sQLiteDatabaseA = this.f3617a.a(false);
        Cursor cursorRawQuery = null;
        if (z) {
            try {
                try {
                    cursorRawQuery = sQLiteDatabaseA.rawQuery("SELECT COUNT(*) as totalCount,SUM(_size) as totalSize FROM events WHERE _dataState != 1", null);
                    cursorRawQuery.moveToFirst();
                    m0Var.a(cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("totalCount")));
                    m0Var.a(cursorRawQuery.getLong(cursorRawQuery.getColumnIndexOrThrow("totalSize")));
                    com.hihonor.hianalytics.util.k.a(cursorRawQuery);
                } catch (Throwable th) {
                    com.hihonor.hianalytics.util.k.a(cursorRawQuery);
                    throw th;
                }
            } catch (Throwable th2) {
                this.f3617a.b();
                throw th2;
            }
        }
        if (list.isEmpty()) {
            this.f3617a.b();
            return m0Var;
        }
        if (!c((List<p0>) list)) {
            j2.g("EventSqliteHandler", "getEventStoreState checkTagTypeInfoList fail");
            this.f3617a.b();
            return m0Var;
        }
        Pair<String, String[]> pairC = v.c((List<p0>) list);
        try {
            cursorRawQuery = sQLiteDatabaseA.rawQuery((String) pairC.first, (String[]) pairC.second);
            int columnIndexOrThrow = cursorRawQuery.getColumnIndexOrThrow("_eTtId");
            int columnIndexOrThrow2 = cursorRawQuery.getColumnIndexOrThrow("totalCount");
            int columnIndexOrThrow3 = cursorRawQuery.getColumnIndexOrThrow("totalSize");
            while (cursorRawQuery.moveToNext()) {
                long j = cursorRawQuery.getLong(columnIndexOrThrow);
                p0 p0VarB = v.b(list, j);
                if (p0VarB == null) {
                    j2.g("EventSqliteHandler", "getEventStoreState failById=" + j);
                } else {
                    m0Var.a(p0VarB, cursorRawQuery.getLong(columnIndexOrThrow3), cursorRawQuery.getInt(columnIndexOrThrow2));
                }
            }
            com.hihonor.hianalytics.util.k.a(cursorRawQuery);
            this.f3617a.b();
            j2.a("EventSqliteHandler", "getTotalEventNum spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",storeState=" + m0Var);
            return m0Var;
        } catch (Throwable th3) {
            com.hihonor.hianalytics.util.k.a(cursorRawQuery);
            throw th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean a(List list, int i, boolean z, int i2) {
        long jA = com.hihonor.hianalytics.util.r.a();
        SQLiteDatabase sQLiteDatabaseA = this.f3617a.a(true);
        sQLiteDatabaseA.beginTransaction();
        try {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                n0 n0Var = (n0) it.next();
                n0Var.a(sQLiteDatabaseA.insertWithOnConflict("events", null, n0Var.a(this.b), i));
            }
            sQLiteDatabaseA.setTransactionSuccessful();
            sQLiteDatabaseA.endTransaction();
            this.f3617a.b();
            j2.a("EventSqliteHandler", "insertEvents spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",isConflictReplace=" + z + ",size=" + i2);
            return Boolean.TRUE;
        } catch (Throwable th) {
            sQLiteDatabaseA.endTransaction();
            this.f3617a.b();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean a(Set set, Set set2, List list) {
        long jA = com.hihonor.hianalytics.util.r.a();
        SQLiteDatabase sQLiteDatabaseA = this.f3617a.a(true);
        sQLiteDatabaseA.beginTransaction();
        try {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (!a(sQLiteDatabaseA, (o0) it.next())) {
                    Boolean bool = Boolean.FALSE;
                    sQLiteDatabaseA.endTransaction();
                    this.f3617a.b();
                    return bool;
                }
            }
            Iterator it2 = set2.iterator();
            while (it2.hasNext()) {
                if (!a(sQLiteDatabaseA, (p0) it2.next())) {
                    Boolean bool2 = Boolean.FALSE;
                    sQLiteDatabaseA.endTransaction();
                    this.f3617a.b();
                    return bool2;
                }
            }
            sQLiteDatabaseA.setTransactionSuccessful();
            sQLiteDatabaseA.endTransaction();
            this.f3617a.b();
            j2.a("EventSqliteHandler", "checkTagTypeInfoList spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",processSize=" + set.size() + ",tagTypeInfoSize=" + set2.size() + ",tagTypeSize=" + list.size());
            return Boolean.TRUE;
        } catch (Throwable th) {
            sQLiteDatabaseA.endTransaction();
            this.f3617a.b();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean a(Set set, Set set2, Set set3, List list) {
        long jA = com.hihonor.hianalytics.util.r.a();
        SQLiteDatabase sQLiteDatabaseA = this.f3617a.a(true);
        sQLiteDatabaseA.beginTransaction();
        try {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                o0 o0Var = (o0) it.next();
                if (!a(sQLiteDatabaseA, o0Var)) {
                    j2.g("EventSqliteHandler", "checkEvents failByProcessInfo=" + o0Var);
                    Boolean bool = Boolean.FALSE;
                    sQLiteDatabaseA.endTransaction();
                    this.f3617a.b();
                    return bool;
                }
            }
            Iterator it2 = set2.iterator();
            while (it2.hasNext()) {
                p0 p0Var = (p0) it2.next();
                if (!a(sQLiteDatabaseA, p0Var)) {
                    j2.g("EventSqliteHandler", "checkEvents failByTagTypeInfo=" + p0Var);
                    Boolean bool2 = Boolean.FALSE;
                    sQLiteDatabaseA.endTransaction();
                    this.f3617a.b();
                    return bool2;
                }
            }
            Iterator it3 = set3.iterator();
            while (it3.hasNext()) {
                j0 j0Var = (j0) it3.next();
                if (!a(sQLiteDatabaseA, j0Var)) {
                    j2.g("EventSqliteHandler", "checkEvents failByIdAttrs=" + j0Var);
                    Boolean bool3 = Boolean.FALSE;
                    sQLiteDatabaseA.endTransaction();
                    this.f3617a.b();
                    return bool3;
                }
            }
            sQLiteDatabaseA.setTransactionSuccessful();
            sQLiteDatabaseA.endTransaction();
            this.f3617a.b();
            j2.a("EventSqliteHandler", "checkEvents spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",processSize=" + set.size() + ",tagTypeInfoSize=" + set2.size() + ",idAttrsSize=" + set3.size() + ",eventSize=" + list.size());
            return Boolean.TRUE;
        } catch (Throwable th) {
            sQLiteDatabaseA.endTransaction();
            this.f3617a.b();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer a(ContentValues contentValues) {
        long jA = com.hihonor.hianalytics.util.r.a();
        SQLiteDatabase sQLiteDatabaseA = this.f3617a.a(true);
        sQLiteDatabaseA.beginTransaction();
        try {
            int iUpdate = sQLiteDatabaseA.update("events", contentValues, null, null);
            sQLiteDatabaseA.setTransactionSuccessful();
            j2.c("EventSqliteHandler", "clearEvents spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",num=" + iUpdate);
            return Integer.valueOf(iUpdate);
        } finally {
            sQLiteDatabaseA.endTransaction();
            this.f3617a.b();
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer a(ContentValues contentValues, Pair pair) {
        long jA = com.hihonor.hianalytics.util.r.a();
        SQLiteDatabase sQLiteDatabaseA = this.f3617a.a(true);
        sQLiteDatabaseA.beginTransaction();
        try {
            int iUpdateWithOnConflict = sQLiteDatabaseA.updateWithOnConflict("events", contentValues, (String) pair.first, (String[]) pair.second, 5);
            sQLiteDatabaseA.setTransactionSuccessful();
            j2.a(iUpdateWithOnConflict > 0 ? 5 : 3, "EventSqliteHandler", "updateSendingMarkByMonitor spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",num=" + iUpdateWithOnConflict);
            return Integer.valueOf(iUpdateWithOnConflict);
        } finally {
            sQLiteDatabaseA.endTransaction();
            this.f3617a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer a(ContentValues contentValues, Pair pair, String str) {
        long jA = com.hihonor.hianalytics.util.r.a();
        SQLiteDatabase sQLiteDatabaseA = this.f3617a.a(true);
        sQLiteDatabaseA.beginTransaction();
        try {
            int iUpdate = sQLiteDatabaseA.update("events", contentValues, (String) pair.first, (String[]) pair.second);
            sQLiteDatabaseA.setTransactionSuccessful();
            j2.c("EventSqliteHandler", "delEventsByTag spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",num=" + iUpdate + ",tag=" + str);
            return Integer.valueOf(iUpdate);
        } finally {
            sQLiteDatabaseA.endTransaction();
            this.f3617a.b();
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer a(List list, ContentValues contentValues, int i) {
        long jA = com.hihonor.hianalytics.util.r.a();
        SQLiteDatabase sQLiteDatabaseA = this.f3617a.a(true);
        sQLiteDatabaseA.beginTransaction();
        try {
            Iterator it = list.iterator();
            int iUpdate = 0;
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                iUpdate += sQLiteDatabaseA.update("events", contentValues, (String) pair.first, (String[]) pair.second);
            }
            sQLiteDatabaseA.setTransactionSuccessful();
            j2.a(iUpdate == i ? 4 : 5, "EventSqliteHandler", "delEvents spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",num=" + iUpdate + ",size=" + i);
            return Integer.valueOf(iUpdate);
        } finally {
            sQLiteDatabaseA.endTransaction();
            this.f3617a.b();
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer a(List list, ContentValues contentValues, int i, int i2, boolean z) {
        long jA = com.hihonor.hianalytics.util.r.a();
        SQLiteDatabase sQLiteDatabaseA = this.f3617a.a(true);
        sQLiteDatabaseA.beginTransaction();
        try {
            Iterator it = list.iterator();
            int iUpdateWithOnConflict = 0;
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                iUpdateWithOnConflict += sQLiteDatabaseA.updateWithOnConflict("events", contentValues, (String) pair.first, (String[]) pair.second, i);
            }
            sQLiteDatabaseA.setTransactionSuccessful();
            j2.a(iUpdateWithOnConflict != i2 ? 5 : 3, "EventSqliteHandler", "updateEventsSendMark spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",isConflictReplace=" + z + ",num=" + iUpdateWithOnConflict + ",size=" + i2);
            return Integer.valueOf(iUpdateWithOnConflict);
        } finally {
            sQLiteDatabaseA.endTransaction();
            this.f3617a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer a(Map map, ContentValues contentValues, int i, int i2, boolean z) {
        long jA = com.hihonor.hianalytics.util.r.a();
        SQLiteDatabase sQLiteDatabaseA = this.f3617a.a(true);
        sQLiteDatabaseA.beginTransaction();
        try {
            int i3 = 0;
            for (Map.Entry entry : map.entrySet()) {
                List list = (List) entry.getValue();
                if (list != null && list.size() > 0) {
                    List<Pair<String, String[]>> listD = v.d(list);
                    if ("requestIdMapDefault".equals(entry.getKey())) {
                        contentValues.remove("_reqId");
                    } else {
                        contentValues.put("_reqId", (String) entry.getKey());
                    }
                    int iUpdateWithOnConflict = i3;
                    for (Pair<String, String[]> pair : listD) {
                        iUpdateWithOnConflict += sQLiteDatabaseA.updateWithOnConflict("events", contentValues, (String) pair.first, (String[]) pair.second, i);
                    }
                    i3 = iUpdateWithOnConflict;
                } else {
                    j2.a("EventSqliteHandler", "updateEventsSendMark eventListByReqIdSize empty");
                }
            }
            sQLiteDatabaseA.setTransactionSuccessful();
            j2.a(i3 != i2 ? 5 : 3, "EventSqliteHandler", "updateEventsRequestIdSql spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",isConflictReplace=" + z + ",num=" + i3 + ",size=" + i2);
            return Integer.valueOf(i3);
        } finally {
            sQLiteDatabaseA.endTransaction();
            this.f3617a.b();
        }
    }

    private Integer a(final Map<String, List<n0>> map, final boolean z, final int i, final ContentValues contentValues) {
        final int i2 = z ? 5 : 4;
        return (Integer) u3.a(3, 0, new q3() { // from class: com.hihonor.hianalytics.hnha.a0$$ExternalSyntheticLambda17
            @Override // com.hihonor.hianalytics.hnha.q3
            public final Object a() {
                return this.f$0.a(map, contentValues, i2, i, z);
            }
        });
    }

    private List<n0> a(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, List<p0> list, String str2) throws Throwable {
        Cursor cursorRawQuery;
        int i;
        LinkedList linkedList;
        long j;
        p0 p0VarB;
        boolean z;
        int i2;
        p0 p0Var;
        HashMap map;
        n0 n0Var;
        LinkedList linkedList2;
        LinkedList linkedList3 = new LinkedList();
        try {
            cursorRawQuery = sQLiteDatabase.rawQuery(str, strArr);
            try {
                int columnIndexOrThrow = cursorRawQuery.getColumnIndexOrThrow("idsId");
                int columnIndexOrThrow2 = cursorRawQuery.getColumnIndexOrThrow("idsTime");
                int columnIndexOrThrow3 = cursorRawQuery.getColumnIndexOrThrow("_appId");
                int columnIndexOrThrow4 = cursorRawQuery.getColumnIndexOrThrow("_iiTtId");
                int columnIndexOrThrow5 = cursorRawQuery.getColumnIndexOrThrow("_url");
                int columnIndexOrThrow6 = cursorRawQuery.getColumnIndexOrThrow("_idsInfo");
                int columnIndexOrThrow7 = cursorRawQuery.getColumnIndexOrThrow("idsCMd");
                int columnIndexOrThrow8 = cursorRawQuery.getColumnIndexOrThrow("idsKMd");
                int columnIndexOrThrow9 = cursorRawQuery.getColumnIndexOrThrow("idsKsMd");
                int columnIndexOrThrow10 = cursorRawQuery.getColumnIndexOrThrow("evtId");
                int columnIndexOrThrow11 = cursorRawQuery.getColumnIndexOrThrow("evtCTime");
                int columnIndexOrThrow12 = cursorRawQuery.getColumnIndexOrThrow("_cTimeZone");
                LinkedList linkedList4 = linkedList3;
                int columnIndexOrThrow13 = cursorRawQuery.getColumnIndexOrThrow("_uTime");
                int columnIndexOrThrow14 = cursorRawQuery.getColumnIndexOrThrow("_evtId");
                int columnIndexOrThrow15 = cursorRawQuery.getColumnIndexOrThrow("_sourceType");
                int i3 = columnIndexOrThrow13;
                int columnIndexOrThrow16 = cursorRawQuery.getColumnIndexOrThrow("_cnt");
                int columnIndexOrThrow17 = cursorRawQuery.getColumnIndexOrThrow("_state");
                int columnIndexOrThrow18 = cursorRawQuery.getColumnIndexOrThrow("_sId");
                int columnIndexOrThrow19 = cursorRawQuery.getColumnIndexOrThrow("_sState");
                int columnIndexOrThrow20 = cursorRawQuery.getColumnIndexOrThrow("_reqId");
                int columnIndexOrThrow21 = cursorRawQuery.getColumnIndexOrThrow("_eTtId");
                int columnIndexOrThrow22 = cursorRawQuery.getColumnIndexOrThrow("_evtAppId");
                int columnIndexOrThrow23 = cursorRawQuery.getColumnIndexOrThrow("evtCMd");
                int columnIndexOrThrow24 = cursorRawQuery.getColumnIndexOrThrow("evtKMd");
                int columnIndexOrThrow25 = cursorRawQuery.getColumnIndexOrThrow("evtKsMd");
                HashMap map2 = new HashMap();
                LinkedList linkedList5 = new LinkedList();
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    i = i4;
                    if (!cursorRawQuery.moveToNext()) {
                        break;
                    }
                    int i6 = columnIndexOrThrow11;
                    int i7 = columnIndexOrThrow12;
                    long j2 = cursorRawQuery.getLong(columnIndexOrThrow4);
                    long j3 = cursorRawQuery.getLong(columnIndexOrThrow);
                    int i8 = columnIndexOrThrow;
                    String string = cursorRawQuery.getString(columnIndexOrThrow3);
                    String string2 = cursorRawQuery.getString(columnIndexOrThrow5);
                    long j4 = cursorRawQuery.getLong(columnIndexOrThrow2);
                    String string3 = cursorRawQuery.getString(columnIndexOrThrow6);
                    String string4 = cursorRawQuery.getString(columnIndexOrThrow7);
                    String string5 = cursorRawQuery.getString(columnIndexOrThrow8);
                    String string6 = cursorRawQuery.getString(columnIndexOrThrow9);
                    int i9 = columnIndexOrThrow2;
                    int i10 = columnIndexOrThrow3;
                    long j5 = cursorRawQuery.getLong(columnIndexOrThrow10);
                    int i11 = columnIndexOrThrow4;
                    String string7 = cursorRawQuery.getString(columnIndexOrThrow14);
                    int i12 = cursorRawQuery.getInt(columnIndexOrThrow15);
                    int i13 = columnIndexOrThrow15;
                    long j6 = cursorRawQuery.getLong(i6);
                    int i14 = columnIndexOrThrow14;
                    String string8 = cursorRawQuery.getString(i7);
                    int i15 = i3;
                    long j7 = cursorRawQuery.getLong(i15);
                    i3 = i15;
                    int i16 = columnIndexOrThrow17;
                    int i17 = columnIndexOrThrow5;
                    int i18 = cursorRawQuery.getInt(i16);
                    int i19 = columnIndexOrThrow16;
                    String string9 = cursorRawQuery.getString(i19);
                    columnIndexOrThrow16 = i19;
                    int i20 = columnIndexOrThrow18;
                    String string10 = cursorRawQuery.getString(i20);
                    columnIndexOrThrow18 = i20;
                    int i21 = columnIndexOrThrow19;
                    int i22 = cursorRawQuery.getInt(i21);
                    columnIndexOrThrow19 = i21;
                    int i23 = columnIndexOrThrow20;
                    String string11 = cursorRawQuery.getString(i23);
                    columnIndexOrThrow20 = i23;
                    int i24 = columnIndexOrThrow7;
                    int i25 = columnIndexOrThrow21;
                    int i26 = columnIndexOrThrow6;
                    long j8 = cursorRawQuery.getLong(i25);
                    int i27 = columnIndexOrThrow22;
                    int i28 = columnIndexOrThrow8;
                    String string12 = cursorRawQuery.getString(i27);
                    int i29 = columnIndexOrThrow23;
                    String string13 = cursorRawQuery.getString(i29);
                    columnIndexOrThrow23 = i29;
                    int i30 = columnIndexOrThrow24;
                    String string14 = cursorRawQuery.getString(i30);
                    columnIndexOrThrow24 = i30;
                    int i31 = columnIndexOrThrow25;
                    String string15 = cursorRawQuery.getString(i31);
                    columnIndexOrThrow25 = i31;
                    int i32 = columnIndexOrThrow9;
                    p0 p0VarB2 = v.b(list, j8);
                    if (j2 == j8) {
                        p0VarB = p0VarB2;
                        j = j2;
                    } else {
                        j = j2;
                        p0VarB = v.b(list, j);
                    }
                    if (j2 != j8) {
                        z = true;
                    } else {
                        if (string12 != null) {
                            try {
                                if (!string12.equals(string)) {
                                    z = true;
                                }
                            } catch (Throwable th) {
                                th = th;
                                cursorRawQuery = cursorRawQuery;
                            }
                        }
                        z = false;
                    }
                    if (p0VarB2 == null || p0VarB == null || z) {
                        i2 = columnIndexOrThrow10;
                        p0 p0Var2 = p0VarB;
                        StringBuilder sbAppend = new StringBuilder().append("queryToSendEventList failByQuery idsTtId=").append(j).append(",idsId=").append(j3).append(",idsAppId=").append(string).append(",idsCTime=").append(com.hihonor.hianalytics.util.r.a(j4)).append(",evtTtId=").append(j8).append(",evtId=").append(j5).append(",eventId=").append(string7).append(",eventState=").append(i18).append(",evtAppId=").append(string12).append(",evtTime=").append(com.hihonor.hianalytics.util.r.a(j6)).append(",evtTimeZone=").append(string8).append(",source=").append(str2).append(",tagTypeInfo=").append(p0VarB2).append(",idsTagTypeInfo=");
                        p0Var = p0Var2;
                        j2.g("EventSqliteHandler", sbAppend.append(p0Var).toString());
                        if (p0VarB2 == null) {
                            i++;
                        }
                        if (p0Var == null) {
                            i5++;
                        }
                        if (p0VarB2 == null || p0Var == null) {
                            map = map2;
                        }
                        columnIndexOrThrow5 = i17;
                        map2 = map;
                        columnIndexOrThrow6 = i26;
                        columnIndexOrThrow8 = i28;
                        columnIndexOrThrow11 = i6;
                        i4 = i;
                        columnIndexOrThrow14 = i14;
                        columnIndexOrThrow = i8;
                        columnIndexOrThrow2 = i9;
                        columnIndexOrThrow3 = i10;
                        columnIndexOrThrow4 = i11;
                        columnIndexOrThrow15 = i13;
                        columnIndexOrThrow12 = i7;
                        columnIndexOrThrow17 = i16;
                        columnIndexOrThrow7 = i24;
                        columnIndexOrThrow21 = i25;
                        columnIndexOrThrow22 = i27;
                        columnIndexOrThrow9 = i32;
                        cursorRawQuery = cursorRawQuery;
                        columnIndexOrThrow10 = i2;
                    } else {
                        p0Var = p0VarB;
                        i2 = columnIndexOrThrow10;
                    }
                    j0 j0Var = new j0(j3, string, string2, j4, string3, p0Var, string4, string5, string6);
                    String str3 = string + com.huawei.openalliance.ad.constant.x.A + p0Var.b + com.huawei.openalliance.ad.constant.x.A + p0Var.c;
                    map = map2;
                    map.put(str3, j0Var);
                    if (z) {
                        n0Var = new n0(j5, new j0(p0VarB2).a(string12), string7, i12, j6, string8, j7, i18, string9, string10, i22, string11, string13, string14, string15);
                        linkedList2 = linkedList5;
                    } else {
                        n0Var = new n0(j5, j0Var, string7, i12, j6, string8, j7, i18, string9, string10, i22, string11, string13, string14, string15);
                        linkedList2 = linkedList4;
                    }
                    linkedList2.add(n0Var);
                    columnIndexOrThrow5 = i17;
                    map2 = map;
                    columnIndexOrThrow6 = i26;
                    columnIndexOrThrow8 = i28;
                    columnIndexOrThrow11 = i6;
                    i4 = i;
                    columnIndexOrThrow14 = i14;
                    columnIndexOrThrow = i8;
                    columnIndexOrThrow2 = i9;
                    columnIndexOrThrow3 = i10;
                    columnIndexOrThrow4 = i11;
                    columnIndexOrThrow15 = i13;
                    columnIndexOrThrow12 = i7;
                    columnIndexOrThrow17 = i16;
                    columnIndexOrThrow7 = i24;
                    columnIndexOrThrow21 = i25;
                    columnIndexOrThrow22 = i27;
                    columnIndexOrThrow9 = i32;
                    cursorRawQuery = cursorRawQuery;
                    columnIndexOrThrow10 = i2;
                    th = th;
                    cursorRawQuery = cursorRawQuery;
                    com.hihonor.hianalytics.util.k.a(cursorRawQuery);
                    throw th;
                }
                cursorRawQuery = cursorRawQuery;
                HashMap map3 = map2;
                int size = linkedList5.size();
                int i33 = size - 1;
                while (i33 >= 0) {
                    LinkedList linkedList6 = linkedList5;
                    n0 n0Var2 = (n0) linkedList6.get(i33);
                    j0 j0Var2 = (j0) map3.get(n0Var2.d() + com.huawei.openalliance.ad.constant.x.A + n0Var2.l() + com.huawei.openalliance.ad.constant.x.A + n0Var2.o());
                    if (j0Var2 == null) {
                        linkedList = linkedList4;
                    } else {
                        n0Var2.a(j0Var2);
                        linkedList = linkedList4;
                        linkedList.add(n0Var2);
                        linkedList6.remove(i33);
                    }
                    i33--;
                    linkedList5 = linkedList6;
                    linkedList4 = linkedList;
                }
                LinkedList linkedList7 = linkedList4;
                LinkedList linkedList8 = linkedList5;
                if (size > 0 || i > 0 || i5 > 0) {
                    j2.g("EventSqliteHandler", "queryToSendEventList failByQuery size=" + size + ",remainSize=" + linkedList8.size() + ",tagTypeNullNum=" + i + ",idsTagTypeNullNum=" + i5 + ",source=" + str2);
                }
                com.hihonor.hianalytics.util.k.a(cursorRawQuery);
                return linkedList7;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            cursorRawQuery = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00ce A[PHI: r14
  0x00ce: PHI (r14v8 long) = (r14v7 long), (r14v7 long), (r14v7 long), (r14v13 long), (r14v13 long), (r14v13 long) binds: [B:10:0x0074, B:12:0x007e, B:14:0x0088, B:21:0x00b7, B:23:0x00c1, B:25:0x00cb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:32:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:34:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:36:0x00ed A[Catch: all -> 0x012a, TRY_LEAVE, TryCatch #1 {all -> 0x012a, blocks: (B:33:0x00dd, B:44:0x0134, B:36:0x00ed), top: B:56:0x00d7 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0130  */
    /* JADX WARN: Code duplicated, block: B:44:0x0134 A[Catch: all -> 0x012a, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x012a, blocks: (B:33:0x00dd, B:44:0x0134, B:36:0x00ed), top: B:56:0x00d7 }] */
    private boolean a(SQLiteDatabase sQLiteDatabase, j0 j0Var) throws Throwable {
        long jInsertWithOnConflict;
        boolean z;
        Cursor cursor = null;
        try {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT _id,_crMd,_kMd,_ksMd,_idsInfo FROM idsInfo WHERE _appId = ? AND _url = ? AND _idsInfoHash = ? AND _iiTtId = ?", new String[]{j0Var.c(), j0Var.p(), String.valueOf(j0Var.h()), String.valueOf(j0Var.o().a())});
            try {
                int columnIndexOrThrow = cursorRawQuery.getColumnIndexOrThrow("_id");
                int columnIndexOrThrow2 = cursorRawQuery.getColumnIndexOrThrow("_idsInfo");
                int columnIndexOrThrow3 = cursorRawQuery.getColumnIndexOrThrow("_crMd");
                int columnIndexOrThrow4 = cursorRawQuery.getColumnIndexOrThrow("_kMd");
                int columnIndexOrThrow5 = cursorRawQuery.getColumnIndexOrThrow("_ksMd");
                while (true) {
                    try {
                        if (cursorRawQuery.moveToNext()) {
                            String string = cursorRawQuery.getString(columnIndexOrThrow2);
                            if (Objects.equals(string, j0Var.d())) {
                                jInsertWithOnConflict = cursorRawQuery.getLong(columnIndexOrThrow);
                                if (TextUtils.isEmpty(cursorRawQuery.getString(columnIndexOrThrow3)) || TextUtils.isEmpty(cursorRawQuery.getString(columnIndexOrThrow4)) || TextUtils.isEmpty(cursorRawQuery.getString(columnIndexOrThrow5))) {
                                    z = false;
                                }
                            } else {
                                Pair<Boolean, String> pairA = k.c().a(string);
                                if (((Boolean) pairA.first).booleanValue() && com.hihonor.hianalytics.util.l.a((String) pairA.second, j0Var.g(), true)) {
                                    jInsertWithOnConflict = cursorRawQuery.getLong(columnIndexOrThrow);
                                    if (TextUtils.isEmpty(cursorRawQuery.getString(columnIndexOrThrow3)) || TextUtils.isEmpty(cursorRawQuery.getString(columnIndexOrThrow4)) || TextUtils.isEmpty(cursorRawQuery.getString(columnIndexOrThrow5))) {
                                        z = false;
                                    }
                                }
                            }
                            if (jInsertWithOnConflict < 0) {
                                jInsertWithOnConflict = sQLiteDatabase.insertWithOnConflict("idsInfo", null, j0Var.a(this.b), 5);
                            } else if (!z) {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("_crMd", j0Var.e());
                                contentValues.put("_kMd", j0Var.l());
                                contentValues.put("_ksMd", j0Var.m());
                                sQLiteDatabase.updateWithOnConflict("idsInfo", contentValues, "_id = " + jInsertWithOnConflict, null, 5);
                            }
                            if (jInsertWithOnConflict < 0) {
                                com.hihonor.hianalytics.util.k.a(cursorRawQuery);
                                return false;
                            }
                            j0Var.a(jInsertWithOnConflict);
                            com.hihonor.hianalytics.util.k.a(cursorRawQuery);
                            return true;
                        }
                        jInsertWithOnConflict = -1;
                        if (jInsertWithOnConflict < 0) {
                            jInsertWithOnConflict = sQLiteDatabase.insertWithOnConflict("idsInfo", null, j0Var.a(this.b), 5);
                        } else if (!z) {
                            ContentValues contentValues2 = new ContentValues();
                            contentValues2.put("_crMd", j0Var.e());
                            contentValues2.put("_kMd", j0Var.l());
                            contentValues2.put("_ksMd", j0Var.m());
                            sQLiteDatabase.updateWithOnConflict("idsInfo", contentValues2, "_id = " + jInsertWithOnConflict, null, 5);
                        }
                        if (jInsertWithOnConflict < 0) {
                            com.hihonor.hianalytics.util.k.a(cursorRawQuery);
                            return false;
                        }
                        j0Var.a(jInsertWithOnConflict);
                        com.hihonor.hianalytics.util.k.a(cursorRawQuery);
                        return true;
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursorRawQuery;
                        com.hihonor.hianalytics.util.k.a(cursor);
                        throw th;
                    }
                    z = true;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private boolean a(SQLiteDatabase sQLiteDatabase, o0 o0Var) throws Throwable {
        Cursor cursor = null;
        try {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT _id FROM processes WHERE _pName = ?", new String[]{o0Var.c});
            try {
                long j = cursorRawQuery.moveToFirst() ? cursorRawQuery.getLong(cursorRawQuery.getColumnIndexOrThrow("_id")) : sQLiteDatabase.insertWithOnConflict("processes", null, o0Var.a(this.b), 5);
                if (j < 0) {
                    com.hihonor.hianalytics.util.k.a(cursorRawQuery);
                    return false;
                }
                o0Var.a(j);
                com.hihonor.hianalytics.util.k.a(cursorRawQuery);
                return true;
            } catch (Throwable th) {
                th = th;
                cursor = cursorRawQuery;
                com.hihonor.hianalytics.util.k.a(cursor);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private boolean a(SQLiteDatabase sQLiteDatabase, p0 p0Var) throws Throwable {
        Cursor cursor = null;
        try {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT _id FROM tagTypes WHERE _tag = ? AND _type = ? AND _ttpId = ?", new String[]{p0Var.b, String.valueOf(p0Var.c), String.valueOf(p0Var.e.a())});
            try {
                long j = cursorRawQuery.moveToFirst() ? cursorRawQuery.getLong(cursorRawQuery.getColumnIndexOrThrow("_id")) : sQLiteDatabase.insertWithOnConflict("tagTypes", null, p0Var.a(this.b), 5);
                if (j < 0) {
                    com.hihonor.hianalytics.util.k.a(cursorRawQuery);
                    return false;
                }
                p0Var.a(j);
                com.hihonor.hianalytics.util.k.a(cursorRawQuery);
                return true;
            } catch (Throwable th) {
                th = th;
                cursor = cursorRawQuery;
                com.hihonor.hianalytics.util.k.a(cursor);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ l0 b(k0 k0Var) {
        SQLiteDatabase sQLiteDatabaseA = this.f3617a.a(true);
        sQLiteDatabaseA.beginTransaction();
        try {
            return a(1, k0Var.c, k0Var, sQLiteDatabaseA);
        } finally {
            sQLiteDatabaseA.endTransaction();
            this.f3617a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer b(ContentValues contentValues, Pair pair) {
        long jA = com.hihonor.hianalytics.util.r.a();
        SQLiteDatabase sQLiteDatabaseA = this.f3617a.a(true);
        sQLiteDatabaseA.beginTransaction();
        try {
            int iUpdateWithOnConflict = sQLiteDatabaseA.updateWithOnConflict("events", contentValues, (String) pair.first, (String[]) pair.second, 5);
            sQLiteDatabaseA.setTransactionSuccessful();
            j2.a("EventSqliteHandler", "updateSendingMarkByStart spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",num=" + iUpdateWithOnConflict);
            return Integer.valueOf(iUpdateWithOnConflict);
        } finally {
            sQLiteDatabaseA.endTransaction();
            this.f3617a.b();
            h();
        }
    }

    private List<n0> b(SQLiteDatabase sQLiteDatabase, List<p0> list, long j, long j2) {
        Pair<String, String[]> pairA = v.a(list, j, j2);
        return a(sQLiteDatabase, (String) pairA.first, (String[]) pairA.second, list, "newFirst");
    }

    private void b(k0 k0Var, SQLiteDatabase sQLiteDatabase) {
        long jA = com.hihonor.hianalytics.util.r.a();
        List<p0> list = k0Var.f3652a;
        Pair<String, String[]> pairH = v.h(list);
        try {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery((String) pairH.first, (String[]) pairH.second);
            int columnIndexOrThrow = cursorRawQuery.getColumnIndexOrThrow("reqIdSize");
            int columnIndexOrThrow2 = cursorRawQuery.getColumnIndexOrThrow("_reqId");
            if (!cursorRawQuery.moveToFirst()) {
                j2.a("EventSqliteHandler", "fillToSendEventReqIdParam spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",tagTypeSize=" + list.size() + " no sendFailData");
                com.hihonor.hianalytics.util.k.a(cursorRawQuery);
                return;
            }
            StringBuilder sbAppend = new StringBuilder().append("(");
            int i = 0;
            while (true) {
                long j = cursorRawQuery.getLong(columnIndexOrThrow);
                String string = cursorRawQuery.getString(columnIndexOrThrow2);
                int i2 = columnIndexOrThrow;
                sbAppend.append(string).append(",").append(j).append(",");
                k0Var.a(string, j);
                i++;
                if (!cursorRawQuery.moveToNext()) {
                    j2.a("EventSqliteHandler", "fillToSendEventReqIdParam spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",tagTypeSize=" + list.size() + ",num=" + i + ",nowSize=" + k0Var.b() + ",reqIdValues=" + ((Object) sbAppend.append(")")));
                    com.hihonor.hianalytics.util.k.a(cursorRawQuery);
                    return;
                }
                columnIndexOrThrow = i2;
            }
        } catch (Throwable th) {
            com.hihonor.hianalytics.util.k.a((Closeable) null);
            throw th;
        }
    }

    private boolean b(final List<n0> list) {
        if (list.isEmpty()) {
            return true;
        }
        final HashSet hashSet = new HashSet();
        final HashSet hashSet2 = new HashSet();
        final HashSet hashSet3 = new HashSet();
        for (n0 n0Var : list) {
            p0 p0VarX = n0Var.x();
            if (!p0VarX.e.e()) {
                o0 o0Var = (o0) com.hihonor.hianalytics.util.b.a(hashSet, p0VarX.e);
                if (o0Var != null) {
                    j2.a("EventSqliteHandler", "checkEvents same processInfo=" + o0Var);
                    p0VarX.a(o0Var);
                } else if (!hashSet.add(p0VarX.e)) {
                    j2.g("EventSqliteHandler", "checkEvents addFail processInfo=" + p0VarX.e);
                }
            }
            if (!p0VarX.f()) {
                p0 p0Var = (p0) com.hihonor.hianalytics.util.b.a(hashSet2, p0VarX);
                if (p0Var != null) {
                    j2.a("EventSqliteHandler", "checkEvents same tagTypeInfo=" + p0Var);
                    n0Var.a(p0Var);
                } else if (!hashSet2.add(p0VarX)) {
                    j2.g("EventSqliteHandler", "checkEvents addFail tagTypeInfo=" + p0VarX);
                }
            }
            j0 j0VarJ = n0Var.j();
            if (!j0VarJ.q()) {
                j0 j0Var = (j0) com.hihonor.hianalytics.util.b.a(hashSet3, j0VarJ);
                if (j0Var != null) {
                    j2.a("EventSqliteHandler", "checkEvents same idAttrs=" + j0Var);
                    n0Var.a(j0Var);
                } else if (!hashSet3.add(j0VarJ)) {
                    j2.g("EventSqliteHandler", "checkEvents addFail idAttrs=" + j0VarJ);
                }
            }
        }
        if (hashSet.isEmpty() && hashSet2.isEmpty() && hashSet3.isEmpty()) {
            return true;
        }
        return ((Boolean) u3.a(3, Boolean.FALSE, new q3() { // from class: com.hihonor.hianalytics.hnha.a0$$ExternalSyntheticLambda9
            @Override // com.hihonor.hianalytics.hnha.q3
            public final Object a() {
                return this.f$0.a(hashSet, hashSet2, hashSet3, list);
            }
        })).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List c(long j) throws Throwable {
        SQLiteDatabase sQLiteDatabase;
        long j2;
        SQLiteDatabase sQLiteDatabase2;
        long j3;
        a0 a0Var;
        SQLiteDatabase sQLiteDatabase3;
        a0 a0Var2 = this;
        long jA = com.hihonor.hianalytics.util.r.a();
        SQLiteDatabase sQLiteDatabaseA = a0Var2.f3617a.a(true);
        sQLiteDatabaseA.beginTransaction();
        LinkedList linkedList = new LinkedList();
        String[] strArr = null;
        long j4 = 0;
        Cursor cursorRawQuery = null;
        int i = 0;
        boolean z = false;
        while (true) {
            try {
                cursorRawQuery = sQLiteDatabaseA.rawQuery(v.a(30, i), strArr);
                int columnIndexOrThrow = cursorRawQuery.getColumnIndexOrThrow("_id");
                int columnIndexOrThrow2 = cursorRawQuery.getColumnIndexOrThrow("eTime");
                int columnIndexOrThrow3 = cursorRawQuery.getColumnIndexOrThrow("_uTime");
                int columnIndexOrThrow4 = cursorRawQuery.getColumnIndexOrThrow("_cTimeZone");
                long jK = j4;
                int columnIndexOrThrow5 = cursorRawQuery.getColumnIndexOrThrow("_evtId");
                int columnIndexOrThrow6 = cursorRawQuery.getColumnIndexOrThrow("_sourceType");
                boolean z2 = z;
                int columnIndexOrThrow7 = cursorRawQuery.getColumnIndexOrThrow("_cnt");
                int i2 = i;
                int columnIndexOrThrow8 = cursorRawQuery.getColumnIndexOrThrow("_state");
                try {
                    int columnIndexOrThrow9 = cursorRawQuery.getColumnIndexOrThrow("_sId");
                    j2 = jA;
                    int columnIndexOrThrow10 = cursorRawQuery.getColumnIndexOrThrow("_sState");
                    int columnIndexOrThrow11 = cursorRawQuery.getColumnIndexOrThrow("_tag");
                    sQLiteDatabase2 = sQLiteDatabaseA;
                    try {
                        int columnIndexOrThrow12 = cursorRawQuery.getColumnIndexOrThrow("_type");
                        int columnIndexOrThrow13 = cursorRawQuery.getColumnIndexOrThrow("_reqId");
                        if (!cursorRawQuery.moveToFirst()) {
                            j3 = j;
                            break;
                        }
                        while (true) {
                            long j5 = cursorRawQuery.getLong(columnIndexOrThrow);
                            long j6 = cursorRawQuery.getLong(columnIndexOrThrow2);
                            long j7 = cursorRawQuery.getLong(columnIndexOrThrow3);
                            n0 n0Var = new n0(j5, cursorRawQuery.getString(columnIndexOrThrow11), cursorRawQuery.getInt(columnIndexOrThrow12), cursorRawQuery.getString(columnIndexOrThrow5), cursorRawQuery.getInt(columnIndexOrThrow6), j6, cursorRawQuery.getString(columnIndexOrThrow4), j7, cursorRawQuery.getInt(columnIndexOrThrow8), cursorRawQuery.getString(columnIndexOrThrow7), cursorRawQuery.getString(columnIndexOrThrow9), cursorRawQuery.getInt(columnIndexOrThrow10), cursorRawQuery.getString(columnIndexOrThrow13));
                            linkedList.add(n0Var);
                            jK += n0Var.k();
                            int i3 = columnIndexOrThrow9;
                            int i4 = columnIndexOrThrow13;
                            j3 = j;
                            if (jK >= j3) {
                                z = true;
                                break;
                            }
                            if (!cursorRawQuery.moveToNext()) {
                                z = z2;
                                break;
                            }
                            columnIndexOrThrow9 = i3;
                            columnIndexOrThrow13 = i4;
                        }
                        if (z) {
                            break;
                        }
                        a0Var = this;
                        sQLiteDatabase3 = sQLiteDatabase2;
                        try {
                            com.hihonor.hianalytics.util.k.a(cursorRawQuery);
                            i = i2 + 30;
                            a0Var2 = a0Var;
                            sQLiteDatabaseA = sQLiteDatabase3;
                            j4 = jK;
                            jA = j2;
                            strArr = null;
                        } catch (Throwable th) {
                            th = th;
                        }
                        th = th;
                        a0Var2 = a0Var;
                        sQLiteDatabase = sQLiteDatabase3;
                        com.hihonor.hianalytics.util.k.a(cursorRawQuery);
                        sQLiteDatabase.endTransaction();
                        a0Var2.f3617a.b();
                        h();
                        throw th;
                    } catch (Throwable th2) {
                        th = th2;
                        a0Var2 = this;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    a0Var2 = this;
                    sQLiteDatabase = sQLiteDatabaseA;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
        try {
            int size = linkedList.size();
            if (size <= 0) {
                try {
                    sQLiteDatabase2.setTransactionSuccessful();
                    j2.c("EventSqliteHandler", "delOldestEvent spendTime=" + com.hihonor.hianalytics.util.r.e(j2) + ",emptyEventWithOverSize=" + j3);
                    com.hihonor.hianalytics.util.k.a(cursorRawQuery);
                    sQLiteDatabase2.endTransaction();
                    a0Var = this;
                } catch (Throwable th5) {
                    th = th5;
                    a0Var2 = this;
                    sQLiteDatabase = sQLiteDatabase2;
                    com.hihonor.hianalytics.util.k.a(cursorRawQuery);
                    sQLiteDatabase.endTransaction();
                    a0Var2.f3617a.b();
                    h();
                    throw th;
                }
            } else {
                a0Var = this;
                try {
                    List<Pair<String, String[]>> listD = v.d(linkedList);
                    ContentValues contentValuesA = v.a(1);
                    int iUpdate = 0;
                    for (Pair<String, String[]> pair : listD) {
                        SQLiteDatabase sQLiteDatabase4 = sQLiteDatabase2;
                        iUpdate += sQLiteDatabase4.update("events", contentValuesA, (String) pair.first, (String[]) pair.second);
                        sQLiteDatabase2 = sQLiteDatabase4;
                    }
                    sQLiteDatabase3 = sQLiteDatabase2;
                    sQLiteDatabase3.setTransactionSuccessful();
                    j2.c("EventSqliteHandler", "delOldestEvent spendTime=" + com.hihonor.hianalytics.util.r.e(j2) + ",delNum=" + iUpdate + ",overSize=" + j3 + ",eventSize=" + size);
                    com.hihonor.hianalytics.util.k.a(cursorRawQuery);
                    sQLiteDatabase3.endTransaction();
                } catch (Throwable th6) {
                    th = th6;
                    sQLiteDatabase3 = sQLiteDatabase2;
                    a0Var2 = a0Var;
                    sQLiteDatabase = sQLiteDatabase3;
                    com.hihonor.hianalytics.util.k.a(cursorRawQuery);
                    sQLiteDatabase.endTransaction();
                    a0Var2.f3617a.b();
                    h();
                    throw th;
                }
            }
            a0Var.f3617a.b();
            h();
            return linkedList;
        } catch (Throwable th7) {
            th = th7;
            a0Var = this;
        }
    }

    private boolean c(final List<p0> list) {
        if (list.isEmpty()) {
            return true;
        }
        final HashSet hashSet = new HashSet();
        final HashSet hashSet2 = new HashSet();
        for (p0 p0Var : list) {
            if (!p0Var.e.e()) {
                hashSet.add(p0Var.e);
            }
            if (!p0Var.f()) {
                hashSet2.add(p0Var);
            }
        }
        if (hashSet.isEmpty() && hashSet2.isEmpty()) {
            return true;
        }
        return ((Boolean) u3.a(3, Boolean.FALSE, new q3() { // from class: com.hihonor.hianalytics.hnha.a0$$ExternalSyntheticLambda13
            @Override // com.hihonor.hianalytics.hnha.q3
            public final Object a() {
                return this.f$0.a(hashSet, hashSet2, list);
            }
        })).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ j0 d(long j) throws Throwable {
        long jA = com.hihonor.hianalytics.util.r.a();
        int i = 0;
        SQLiteDatabase sQLiteDatabaseA = this.f3617a.a(false);
        Cursor cursor = null;
        if (j > 0) {
            try {
                Cursor cursorRawQuery = sQLiteDatabaseA.rawQuery("SELECT * FROM idsInfo WHERE _id = ?", new String[]{String.valueOf(j)});
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        j0 j0VarA = a(cursorRawQuery);
                        if (!TextUtils.isEmpty(j0VarA.g())) {
                            j2.a("EventSqliteHandler", "getStatUseIdAttrs spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",memId=" + j + ",idAttrs=" + j0VarA);
                            com.hihonor.hianalytics.util.k.a(cursorRawQuery);
                            this.f3617a.b();
                            return j0VarA;
                        }
                        j2.g("EventSqliteHandler", "getStatUseIdAttrs spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",memId=" + j + ",illegalIdAttrs=" + j0VarA);
                    }
                    com.hihonor.hianalytics.util.k.a(cursorRawQuery);
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorRawQuery;
                    com.hihonor.hianalytics.util.k.a(cursor);
                    this.f3617a.b();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        Cursor cursorRawQuery2 = sQLiteDatabaseA.rawQuery("SELECT * FROM idsInfo ORDER BY _priority DESC", null);
        if (!cursorRawQuery2.moveToFirst()) {
            j2.g("EventSqliteHandler", "getStatUseIdAttrs spendTime2=" + com.hihonor.hianalytics.util.r.e(jA) + ",memId=" + j + ",noIdAttrs");
            com.hihonor.hianalytics.util.k.a(cursorRawQuery2);
            this.f3617a.b();
            return null;
        }
        int count = cursorRawQuery2.getCount();
        do {
            j0 j0VarA2 = a(cursorRawQuery2);
            if (!TextUtils.isEmpty(j0VarA2.g())) {
                j2.a("EventSqliteHandler", "getStatUseIdAttrs spendTime2=" + com.hihonor.hianalytics.util.r.e(jA) + ",memId=" + j + ",failCount=" + i + ",totalCount=" + count + ",idAttrs=" + j0VarA2);
                com.hihonor.hianalytics.util.k.a(cursorRawQuery2);
                this.f3617a.b();
                return j0VarA2;
            }
            i++;
        } while (cursorRawQuery2.moveToNext());
        j2.g("EventSqliteHandler", "getStatUseIdAttrs spendTime2=" + com.hihonor.hianalytics.util.r.e(jA) + ",memId=" + j + ",failCount=" + i + ",totalCount=" + count + ",noIdAttrs2");
        com.hihonor.hianalytics.util.k.a(cursorRawQuery2);
        this.f3617a.b();
        return null;
    }

    private Map<String, List<n0>> d(List<n0> list) {
        HashMap map = new HashMap();
        if (list == null) {
            return map;
        }
        for (n0 n0Var : list) {
            if (n0Var != null) {
                List arrayList = (List) map.get(n0Var.s());
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map.put(n0Var.s(), arrayList);
                }
                arrayList.add(n0Var);
            }
        }
        return map;
    }

    private synchronized void h() {
        long jA = com.hihonor.hianalytics.util.r.a(true);
        t3.a(this.d);
        long j = this.c;
        long j2 = jA - j;
        long j3 = j <= 0 ? -1000L : ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT - j2;
        if (j3 <= 0) {
            j3 = 10;
        }
        j2.a("EventSqliteHandler", "checkToClearDeletableEvents lastMillis=" + this.c + ",interval=" + j2);
        t3.a(this.d, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.c = com.hihonor.hianalytics.util.r.a(true);
        long jA = com.hihonor.hianalytics.util.r.a();
        int iIntValue = ((Integer) u3.a(3, 0, new q3() { // from class: com.hihonor.hianalytics.hnha.a0$$ExternalSyntheticLambda6
            @Override // com.hihonor.hianalytics.hnha.q3
            public final Object a() {
                return this.f$0.j();
            }
        })).intValue();
        long jD = com.hihonor.hianalytics.util.h.d(iIntValue);
        j2.c("EventSqliteHandler", "doClearDeletableEvents spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",delNum=" + iIntValue + (jD > 0 ? ",totalDelNum=" + jD : ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer j() {
        SQLiteDatabase sQLiteDatabaseA = this.f3617a.a(true);
        sQLiteDatabaseA.beginTransaction();
        try {
            int iDelete = sQLiteDatabaseA.delete("events", "_dataState = 1", null);
            sQLiteDatabaseA.setTransactionSuccessful();
            return Integer.valueOf(iDelete);
        } finally {
            sQLiteDatabaseA.endTransaction();
            this.f3617a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List k() {
        long jA = com.hihonor.hianalytics.util.r.a();
        SQLiteDatabase sQLiteDatabaseA = this.f3617a.a(false);
        LinkedList linkedList = new LinkedList();
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = sQLiteDatabaseA.rawQuery("SELECT tagTypes._id as ttId,tagTypes._cTime as ttTime,_tag,_type,processes._id as pId,processes._cTime as pTime,_pName FROM tagTypes INNER JOIN processes ON tagTypes._ttpId = processes._id", null);
            int columnIndexOrThrow = cursorRawQuery.getColumnIndexOrThrow("pId");
            int columnIndexOrThrow2 = cursorRawQuery.getColumnIndexOrThrow("pTime");
            int columnIndexOrThrow3 = cursorRawQuery.getColumnIndexOrThrow("_pName");
            int columnIndexOrThrow4 = cursorRawQuery.getColumnIndexOrThrow("ttId");
            int columnIndexOrThrow5 = cursorRawQuery.getColumnIndexOrThrow("ttTime");
            int columnIndexOrThrow6 = cursorRawQuery.getColumnIndexOrThrow("_tag");
            int columnIndexOrThrow7 = cursorRawQuery.getColumnIndexOrThrow("_type");
            while (cursorRawQuery.moveToNext()) {
                linkedList.add(new p0(cursorRawQuery.getLong(columnIndexOrThrow4), cursorRawQuery.getLong(columnIndexOrThrow5), cursorRawQuery.getString(columnIndexOrThrow6), cursorRawQuery.getInt(columnIndexOrThrow7), new o0(cursorRawQuery.getLong(columnIndexOrThrow), cursorRawQuery.getLong(columnIndexOrThrow2), cursorRawQuery.getString(columnIndexOrThrow3))));
            }
            j2.a("EventSqliteHandler", "getAllTagTypeList spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",size=" + linkedList.size());
            return linkedList;
        } finally {
            com.hihonor.hianalytics.util.k.a(cursorRawQuery);
            this.f3617a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer l() {
        int iValueOf;
        int i;
        int i2;
        Integer numValueOf;
        long jA = com.hihonor.hianalytics.util.r.a();
        int i3 = 1;
        SQLiteDatabase sQLiteDatabaseA = this.f3617a.a(true);
        sQLiteDatabaseA.beginTransaction();
        try {
            LinkedList linkedList = new LinkedList();
            try {
                Pair<String, String[]> pairC = v.c(40);
                Cursor cursorRawQuery = sQLiteDatabaseA.rawQuery((String) pairC.first, (String[]) pairC.second);
                if (cursorRawQuery.moveToFirst()) {
                    List<String> listC = j.c();
                    int columnIndexOrThrow = cursorRawQuery.getColumnIndexOrThrow("_id");
                    int columnIndexOrThrow2 = cursorRawQuery.getColumnIndexOrThrow("_iiTtId");
                    HashMap map = new HashMap();
                    while (cursorRawQuery.moveToNext()) {
                        String strValueOf = String.valueOf(cursorRawQuery.getLong(columnIndexOrThrow2));
                        if (listC.contains(strValueOf)) {
                            String strValueOf2 = String.valueOf(cursorRawQuery.getLong(columnIndexOrThrow));
                            Integer num = (Integer) map.get(strValueOf);
                            if (num == null) {
                                numValueOf = Integer.valueOf(i3);
                                i2 = i3;
                            } else {
                                if (num.intValue() < 30) {
                                    i2 = 1;
                                    numValueOf = Integer.valueOf(num.intValue() + 1);
                                } else {
                                    i2 = 1;
                                    linkedList.add(strValueOf2);
                                }
                                i3 = i2;
                            }
                            map.put(strValueOf, numValueOf);
                            i3 = i2;
                        }
                    }
                    com.hihonor.hianalytics.util.k.a(cursorRawQuery);
                    if (linkedList.isEmpty()) {
                        j2.a("EventSqliteHandler", "removeNoUsedIdsInfo spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + " with emptyList");
                        i = 0;
                    } else {
                        Pair<String, String[]> pairB = v.b(linkedList);
                        try {
                            cursorRawQuery = sQLiteDatabaseA.rawQuery((String) pairB.first, (String[]) pairB.second);
                            int columnIndexOrThrow3 = cursorRawQuery.getColumnIndexOrThrow("_eIdsId");
                            int columnIndexOrThrow4 = cursorRawQuery.getColumnIndexOrThrow("totalCount");
                            while (cursorRawQuery.moveToNext()) {
                                String strValueOf3 = String.valueOf(cursorRawQuery.getLong(columnIndexOrThrow3));
                                if (cursorRawQuery.getInt(columnIndexOrThrow4) > 0) {
                                    linkedList.remove(strValueOf3);
                                }
                            }
                            com.hihonor.hianalytics.util.k.a(cursorRawQuery);
                            if (linkedList.isEmpty()) {
                                j2.a("EventSqliteHandler", "removeNoUsedIdsInfo spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + " with noNeedRemove");
                                i = 0;
                            } else {
                                Pair<String, String[]> pairE = v.e(linkedList);
                                int iDelete = sQLiteDatabaseA.delete("idsInfo", (String) pairE.first, (String[]) pairE.second);
                                j.a(linkedList);
                                sQLiteDatabaseA.setTransactionSuccessful();
                                j2.c("EventSqliteHandler", "removeNoUsedIdsInfo spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",num=" + iDelete + ",delIds=" + Arrays.toString(linkedList.toArray()));
                                iValueOf = Integer.valueOf(iDelete);
                            }
                        } catch (Throwable th) {
                            com.hihonor.hianalytics.util.k.a(cursorRawQuery);
                            throw th;
                        }
                    }
                    iValueOf = Integer.valueOf(i);
                } else {
                    j2.a("EventSqliteHandler", "removeNoUsedIdsInfo spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + " with no overNum");
                    iValueOf = 0;
                    com.hihonor.hianalytics.util.k.a(cursorRawQuery);
                }
                sQLiteDatabaseA.endTransaction();
                this.f3617a.b();
                return iValueOf;
            } catch (Throwable th2) {
                com.hihonor.hianalytics.util.k.a((Closeable) null);
                throw th2;
            }
        } catch (Throwable th3) {
            sQLiteDatabaseA.endTransaction();
            this.f3617a.b();
            throw th3;
        }
    }

    @Override // com.hihonor.hianalytics.hnha.w
    public int a(final String str) {
        if (TextUtils.isEmpty(str)) {
            j2.g("EventSqliteHandler", "delEventsByTag illegal tag=" + str);
            return 0;
        }
        final Pair<String, String[]> pairA = v.a(str);
        final ContentValues contentValuesA = v.a(1);
        return ((Integer) u3.a(3, 0, new q3() { // from class: com.hihonor.hianalytics.hnha.a0$$ExternalSyntheticLambda5
            @Override // com.hihonor.hianalytics.hnha.q3
            public final Object a() {
                return this.f$0.a(contentValuesA, pairA, str);
            }
        })).intValue();
    }

    @Override // com.hihonor.hianalytics.hnha.w
    public int a(List<n0> list) {
        final int size = list == null ? 0 : list.size();
        if (size <= 0) {
            j2.g("EventSqliteHandler", "delEvents empty directReturn");
            return 0;
        }
        final List<Pair<String, String[]>> listD = v.d(list);
        final ContentValues contentValuesA = v.a(1);
        return ((Integer) u3.a(3, 0, new q3() { // from class: com.hihonor.hianalytics.hnha.a0$$ExternalSyntheticLambda14
            @Override // com.hihonor.hianalytics.hnha.q3
            public final Object a() {
                return this.f$0.a(listD, contentValuesA, size);
            }
        })).intValue();
    }

    @Override // com.hihonor.hianalytics.hnha.w
    public int a(List<n0> list, int i, final boolean z) {
        final int size = list == null ? 0 : list.size();
        if (size <= 0) {
            j2.a("EventSqliteHandler", "updateEventsSendMark empty directReturn Success");
            return 0;
        }
        final ContentValues contentValuesB = v.b(i);
        final List<Pair<String, String[]>> listD = v.d(list);
        final int i2 = z ? 5 : 4;
        return ((Integer) u3.a(3, 0, new q3() { // from class: com.hihonor.hianalytics.hnha.a0$$ExternalSyntheticLambda15
            @Override // com.hihonor.hianalytics.hnha.q3
            public final Object a() {
                return this.f$0.a(listD, contentValuesB, i2, size, z);
            }
        })).intValue();
    }

    @Override // com.hihonor.hianalytics.hnha.w
    public l0 a(final k0 k0Var) {
        if (k0Var != null && !k0Var.c()) {
            return (l0) u3.a(3, new l0(false, Collections.emptyList()), new q3() { // from class: com.hihonor.hianalytics.hnha.a0$$ExternalSyntheticLambda4
                @Override // com.hihonor.hianalytics.hnha.q3
                public final Object a() {
                    return this.f$0.b(k0Var);
                }
            });
        }
        j2.g("EventSqliteHandler", "getToSendEventByTagType emptyTagTypeList=" + k0Var);
        return new l0(false, Collections.emptyList());
    }

    @Override // com.hihonor.hianalytics.hnha.w
    public m0 a(final List<p0> list, final boolean z) {
        return (m0) u3.a(3, new m0(), new q3() { // from class: com.hihonor.hianalytics.hnha.a0$$ExternalSyntheticLambda7
            @Override // com.hihonor.hianalytics.hnha.q3
            public final Object a() {
                return this.f$0.a(z, list);
            }
        });
    }

    @Override // com.hihonor.hianalytics.hnha.e0.a
    public z a() {
        return new b0();
    }

    @Override // com.hihonor.hianalytics.hnha.w
    public List<n0> a(final long j) {
        if (j > 0) {
            return (List) u3.a(3, Collections.emptyList(), new q3() { // from class: com.hihonor.hianalytics.hnha.a0$$ExternalSyntheticLambda1
                @Override // com.hihonor.hianalytics.hnha.q3
                public final Object a() {
                    return this.f$0.c(j);
                }
            });
        }
        j2.a("EventSqliteHandler", "delOldestEvent illegal overSize=" + j);
        return Collections.emptyList();
    }

    @Override // com.hihonor.hianalytics.hnha.w
    public int b() {
        final ContentValues contentValuesA = v.a(1);
        return ((Integer) u3.a(3, 0, new q3() { // from class: com.hihonor.hianalytics.hnha.a0$$ExternalSyntheticLambda8
            @Override // com.hihonor.hianalytics.hnha.q3
            public final Object a() {
                return this.f$0.a(contentValuesA);
            }
        })).intValue();
    }

    @Override // com.hihonor.hianalytics.hnha.w
    public Pair<Boolean, Throwable> b(final List<n0> list, final boolean z) {
        final int size = list == null ? 0 : list.size();
        if (size <= 0) {
            j2.g("EventSqliteHandler", "insertEventList illegal eventSize=" + size);
            return Pair.create(Boolean.FALSE, null);
        }
        if (b(list)) {
            final int i = z ? 5 : 4;
            return u3.b(3, Boolean.FALSE, new q3() { // from class: com.hihonor.hianalytics.hnha.a0$$ExternalSyntheticLambda10
                @Override // com.hihonor.hianalytics.hnha.q3
                public final Object a() {
                    return this.f$0.a(list, i, z, size);
                }
            });
        }
        j2.g("EventSqliteHandler", "insertEvents checkEvents fail");
        return Pair.create(Boolean.FALSE, new IllegalStateException("associated info not ready"));
    }

    @Override // com.hihonor.hianalytics.hnha.w
    public j0 b(final long j) {
        return (j0) u3.a(3, null, new q3() { // from class: com.hihonor.hianalytics.hnha.a0$$ExternalSyntheticLambda11
            @Override // com.hihonor.hianalytics.hnha.q3
            public final Object a() {
                return this.f$0.d(j);
            }
        });
    }

    @Override // com.hihonor.hianalytics.hnha.w
    public int c(List<n0> list, boolean z) {
        int size = list == null ? 0 : list.size();
        if (size <= 0) {
            j2.a("EventSqliteHandler", "updateEventsRequestId empty directReturn Success");
            return 0;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("_uTime", Long.valueOf(System.currentTimeMillis()));
        return a(d(list), z, size, contentValues).intValue();
    }

    @Override // com.hihonor.hianalytics.hnha.w
    public List<p0> d() {
        return (List) u3.a(3, Collections.emptyList(), new q3() { // from class: com.hihonor.hianalytics.hnha.a0$$ExternalSyntheticLambda3
            @Override // com.hihonor.hianalytics.hnha.q3
            public final Object a() {
                return this.f$0.k();
            }
        });
    }

    @Override // com.hihonor.hianalytics.hnha.w
    public int e() {
        return ((Integer) u3.a(3, 0, new q3() { // from class: com.hihonor.hianalytics.hnha.a0$$ExternalSyntheticLambda12
            @Override // com.hihonor.hianalytics.hnha.q3
            public final Object a() {
                return this.f$0.l();
            }
        })).intValue();
    }

    @Override // com.hihonor.hianalytics.hnha.w
    public int f() throws IllegalAccessException, InvocationTargetException {
        final ContentValues contentValuesB = v.b(0);
        final Pair<String, String[]> pairA = v.a();
        return ((Integer) u3.a(3, 0, new q3() { // from class: com.hihonor.hianalytics.hnha.a0$$ExternalSyntheticLambda16
            @Override // com.hihonor.hianalytics.hnha.q3
            public final Object a() {
                return this.f$0.a(contentValuesB, pairA);
            }
        })).intValue();
    }

    @Override // com.hihonor.hianalytics.hnha.w
    public int g() {
        final ContentValues contentValuesB = v.b(0);
        final Pair<String, String[]> pairB = v.b();
        return ((Integer) u3.a(3, 0, new q3() { // from class: com.hihonor.hianalytics.hnha.a0$$ExternalSyntheticLambda0
            @Override // com.hihonor.hianalytics.hnha.q3
            public final Object a() {
                return this.f$0.b(contentValuesB, pairB);
            }
        })).intValue();
    }
}
