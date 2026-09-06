package com.hihonor.hianalytics.hnha;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Pair;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public final class f0 extends y implements e0.a {
    private final ContentValues b = new ContentValues();
    private long c = -1;
    private final s3 d = new s3(new Runnable() { // from class: com.hihonor.hianalytics.hnha.f0$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.e();
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e0 f3636a = new e0(this);

    private int a(SQLiteDatabase sQLiteDatabase, String str, String str2, int[] iArr) {
        Cursor cursorRawQuery = null;
        try {
            StringBuilder sb = new StringBuilder();
            int length = iArr.length;
            for (int i = 0; i < length; i++) {
                sb.append(iArr[i]);
                if (i != length - 1) {
                    sb.append(",");
                }
            }
            cursorRawQuery = sQLiteDatabase.rawQuery("SELECT COUNT(*) FROM " + str + " WHERE  _dataState != 1 AND " + str2 + " NOT IN (" + ((Object) sb) + ")", null);
            cursorRawQuery.moveToFirst();
            return cursorRawQuery.getInt(0);
        } finally {
            com.hihonor.hianalytics.util.k.a(cursorRawQuery);
        }
    }

    private Pair<Integer, Integer> a(SQLiteDatabase sQLiteDatabase, int i, String str, List<h3> list, List<h3> list2) {
        int iUpdateWithOnConflict = 0;
        int i2 = 0;
        for (h3 h3Var : list) {
            int iIndexOf = list2.indexOf(h3Var);
            if (iIndexOf < 0) {
                h3Var.a(sQLiteDatabase.insertWithOnConflict(str, null, h3Var.a(this.b), i));
                if (h3Var.b()) {
                    i2++;
                }
            } else {
                h3 h3Var2 = list2.get(iIndexOf);
                h3Var2.a(h3Var.c());
                ContentValues contentValues = new ContentValues();
                contentValues.put("_statNum", Integer.valueOf(h3Var2.c()));
                iUpdateWithOnConflict += sQLiteDatabase.updateWithOnConflict(str, contentValues, "_id = ?", new String[]{String.valueOf(h3Var2.a())}, i);
            }
        }
        return Pair.create(Integer.valueOf(iUpdateWithOnConflict), Integer.valueOf(i2));
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00ab  */
    private Pair<Integer, Integer> a(SQLiteDatabase sQLiteDatabase, String str, int i, List<h3> list) {
        int i2;
        byte b = 0;
        if (list.isEmpty()) {
            return Pair.create(0, 0);
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        for (h3 h3Var : list) {
            hashSet.add(String.valueOf(h3Var.f()));
            hashSet2.add(String.valueOf(h3Var.e()));
            if (h3Var instanceof k3) {
                i2 = ((k3) h3Var).i();
            } else if (h3Var instanceof j3) {
                i2 = ((j3) h3Var).i();
            }
            hashSet3.add(String.valueOf(i2));
        }
        Pair<String, String[]> pairA = v.a(str, hashSet, hashSet2, hashSet3);
        LinkedList linkedList = new LinkedList();
        try {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery((String) pairA.first, (String[]) pairA.second);
            int iHashCode = str.hashCode();
            if (iHashCode != -1122909043) {
                if (iHashCode != -77014846) {
                    if (iHashCode == 2020662475 && str.equals("statReports")) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                } else if (str.equals("statNetSends")) {
                    b = 2;
                } else {
                    b = -1;
                }
            } else if (!str.equals("statEvents")) {
                b = -1;
            }
            if (b == 0) {
                a(cursorRawQuery, linkedList);
            } else if (b == 1) {
                c(cursorRawQuery, linkedList);
            } else if (b != 2) {
                j2.g("StatSqliteHandler", "checkAddOrUpdateStatList illegal tableName=" + str);
            } else {
                b(cursorRawQuery, linkedList);
            }
            com.hihonor.hianalytics.util.k.a(cursorRawQuery);
            return a(sQLiteDatabase, i, str, list, linkedList);
        } catch (Throwable th) {
            com.hihonor.hianalytics.util.k.a((Closeable) null);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0070  */
    private Pair<Boolean, List<h3>> a(SQLiteDatabase sQLiteDatabase, String str, long j, long j2, int i) {
        byte b;
        LinkedList linkedList = new LinkedList();
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM " + str + " WHERE _sTime<" + j + " AND _dataState != 1 AND _id > " + j2 + " ORDER BY _id ASC LIMIT " + (i + 1), null);
            int iHashCode = str.hashCode();
            boolean z = false;
            if (iHashCode != -1122909043) {
                if (iHashCode != -77014846) {
                    if (iHashCode == 2020662475 && str.equals("statReports")) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                } else if (str.equals("statNetSends")) {
                    b = 2;
                } else {
                    b = -1;
                }
            } else if (str.equals("statEvents")) {
                b = 0;
            } else {
                b = -1;
            }
            if (b == 0) {
                a(cursorRawQuery, linkedList);
            } else if (b == 1) {
                c(cursorRawQuery, linkedList);
            } else if (b != 2) {
                j2.g("StatSqliteHandler", "doGetStatList illegal tableName=" + str + ",maxStatTime=" + j + ",statId=" + j2 + ",maxStatSize=" + i);
            } else {
                b(cursorRawQuery, linkedList);
            }
            if (i >= 0 && linkedList.size() > i) {
                z = true;
            }
            if (z) {
                linkedList.removeLast();
            }
            return Pair.create(Boolean.valueOf(z), linkedList);
        } finally {
            com.hihonor.hianalytics.util.k.a(cursorRawQuery);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean a(int i, List list, List list2, List list3, int i2, int i3, int i4, boolean z, int i5) {
        long jA = com.hihonor.hianalytics.util.r.a();
        SQLiteDatabase sQLiteDatabaseA = this.f3636a.a(true);
        sQLiteDatabaseA.beginTransaction();
        try {
            Pair<Integer, Integer> pairA = a(sQLiteDatabaseA, "statEvents", i, (List<h3>) list);
            Pair<Integer, Integer> pairA2 = a(sQLiteDatabaseA, "statReports", i, (List<h3>) list2);
            Pair<Integer, Integer> pairA3 = a(sQLiteDatabaseA, "statNetSends", i, (List<h3>) list3);
            sQLiteDatabaseA.setTransactionSuccessful();
            j2.a((((Integer) pairA.first).intValue() + ((Integer) pairA.second).intValue() == i2 && ((Integer) pairA2.first).intValue() + ((Integer) pairA2.second).intValue() == i3 && ((Integer) pairA3.first).intValue() + ((Integer) pairA3.second).intValue() == i4) ? 2 : 5, "StatSqliteHandler", "insertEvents spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",isConflictReplace=" + z + ",size=(" + i5 + "," + i2 + "," + i3 + "," + i4 + ")result=(" + pairA.first + com.huawei.openalliance.ad.constant.x.A + pairA.second + "," + pairA2.first + com.huawei.openalliance.ad.constant.x.A + pairA2.second + "," + pairA3.first + com.huawei.openalliance.ad.constant.x.A + pairA3.second + ")");
            return Boolean.TRUE;
        } finally {
            sQLiteDatabaseA.endTransaction();
            this.f3636a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer a(int i, List list, ContentValues contentValues, int i2, int i3, List list2, int i4, List list3, int i5, boolean z) throws Throwable {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        f0 f0Var = this;
        long jA = com.hihonor.hianalytics.util.r.a();
        SQLiteDatabase sQLiteDatabaseA = f0Var.f3636a.a(true);
        sQLiteDatabaseA.beginTransaction();
        if (i > 0) {
            try {
                int iUpdateWithOnConflict = 0;
                for (Pair<String, String[]> pair : v.g(list)) {
                    iUpdateWithOnConflict += sQLiteDatabaseA.updateWithOnConflict("statEvents", contentValues, (String) pair.first, (String[]) pair.second, i2);
                }
                i6 = iUpdateWithOnConflict;
            } catch (Throwable th) {
                th = th;
                sQLiteDatabaseA.endTransaction();
                f0Var.f3636a.b();
                throw th;
            }
        } else {
            i6 = 0;
        }
        if (i3 > 0) {
            int iUpdateWithOnConflict2 = 0;
            for (Pair<String, String[]> pair2 : v.g(list2)) {
                int i11 = i6;
                iUpdateWithOnConflict2 += sQLiteDatabaseA.updateWithOnConflict("statReports", contentValues, (String) pair2.first, (String[]) pair2.second, i2);
                i6 = i11;
            }
            i7 = i6;
            i8 = iUpdateWithOnConflict2;
        } else {
            i7 = i6;
            i8 = 0;
        }
        if (i4 > 0) {
            try {
                int iUpdateWithOnConflict3 = 0;
                for (Pair<String, String[]> pair3 : v.g(list3)) {
                    iUpdateWithOnConflict3 += sQLiteDatabaseA.updateWithOnConflict("statNetSends", contentValues, (String) pair3.first, (String[]) pair3.second, i2);
                    i8 = i8;
                }
                i9 = i8;
                i10 = iUpdateWithOnConflict3;
            } catch (Throwable th2) {
                th = th2;
                f0Var = this;
                sQLiteDatabaseA.endTransaction();
                f0Var.f3636a.b();
                throw th;
            }
        } else {
            i9 = i8;
            i10 = 0;
        }
        sQLiteDatabaseA.setTransactionSuccessful();
        int i12 = i7 + i9 + i10;
        j2.a(i12 != i5 ? 5 : 3, "StatSqliteHandler", "updateStatSendMark spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",isConflictReplace=" + z + ",num=(" + i7 + "," + i9 + "," + i10 + "),size=(" + i5 + "," + i + "," + i3 + "," + i4 + ")");
        Integer numValueOf = Integer.valueOf(i12);
        sQLiteDatabaseA.endTransaction();
        this.f3636a.b();
        return numValueOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer a(int i, List list, ContentValues contentValues, int i2, List list2, int i3, List list3, int i4) {
        int iUpdate;
        int iUpdate2;
        long jA = com.hihonor.hianalytics.util.r.a();
        SQLiteDatabase sQLiteDatabaseA = this.f3636a.a(true);
        sQLiteDatabaseA.beginTransaction();
        int iUpdate3 = 0;
        if (i > 0) {
            try {
                iUpdate = 0;
                for (Pair<String, String[]> pair : v.g(list)) {
                    iUpdate += sQLiteDatabaseA.update("statEvents", contentValues, (String) pair.first, (String[]) pair.second);
                }
            } finally {
                sQLiteDatabaseA.endTransaction();
                this.f3636a.b();
            }
        } else {
            iUpdate = 0;
        }
        if (i2 > 0) {
            iUpdate2 = 0;
            for (Pair<String, String[]> pair2 : v.g(list2)) {
                iUpdate2 += sQLiteDatabaseA.update("statReports", contentValues, (String) pair2.first, (String[]) pair2.second);
            }
        } else {
            iUpdate2 = 0;
        }
        if (i3 > 0) {
            for (Pair<String, String[]> pair3 : v.g(list3)) {
                iUpdate3 += sQLiteDatabaseA.update("statNetSends", contentValues, (String) pair3.first, (String[]) pair3.second);
            }
        }
        sQLiteDatabaseA.setTransactionSuccessful();
        j2.a("StatSqliteHandler", "delStatList spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",num=(" + iUpdate + "," + iUpdate2 + "," + iUpdate3 + "),size=(" + i4 + "," + i + "," + i2 + "," + i3 + ")");
        d();
        return Integer.valueOf(iUpdate + iUpdate2 + iUpdate3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer a(int i, Map map, ContentValues contentValues, int i2, int i3, Map map2, int i4, Map map3, int i5, boolean z) throws Throwable {
        String str;
        String str2;
        String str3;
        String str4;
        int i6;
        int i7;
        int i8;
        f0 f0Var = this;
        String str5 = ",";
        long jA = com.hihonor.hianalytics.util.r.a();
        SQLiteDatabase sQLiteDatabaseA = f0Var.f3636a.a(true);
        sQLiteDatabaseA.beginTransaction();
        String str6 = "requestIdMapDefault";
        String str7 = "StatSqliteHandler";
        String str8 = "_reqId";
        int iUpdateWithOnConflict = 0;
        if (i > 0) {
            try {
                int i9 = 0;
                for (Map.Entry entry : map.entrySet()) {
                    List list = (List) entry.getValue();
                    if (list != null && list.size() > 0) {
                        int i10 = i9;
                        if (str6.equals(entry.getKey())) {
                            contentValues.remove(str8);
                        } else {
                            contentValues.put(str8, (String) entry.getKey());
                        }
                        int iUpdateWithOnConflict2 = i10;
                        for (Pair<String, String[]> pair : v.g(list)) {
                            iUpdateWithOnConflict2 += sQLiteDatabaseA.updateWithOnConflict("statEvents", contentValues, (String) pair.first, (String[]) pair.second, i2);
                            str7 = str7;
                            str8 = str8;
                            str6 = str6;
                            str5 = str5;
                        }
                        f0Var = this;
                        i9 = iUpdateWithOnConflict2;
                    } else {
                        try {
                            j2.a(str7, "updateStatRequestId eventStatListByReqId empty");
                        } catch (Throwable th) {
                            th = th;
                            sQLiteDatabaseA.endTransaction();
                            f0Var.f3636a.b();
                            throw th;
                        }
                    }
                }
                str = str8;
                str2 = str7;
                str3 = str5;
                str4 = str6;
                i6 = i9;
            } catch (Throwable th2) {
                th = th2;
                f0Var = this;
            }
        } else {
            str = "_reqId";
            str2 = "StatSqliteHandler";
            str3 = ",";
            str4 = "requestIdMapDefault";
            i6 = 0;
        }
        if (i3 > 0) {
            int i11 = 0;
            for (Map.Entry entry2 : map2.entrySet()) {
                List list2 = (List) entry2.getValue();
                if (list2 != null && list2.size() > 0) {
                    if (str4.equals(entry2.getKey())) {
                        contentValues.remove(str);
                    } else {
                        contentValues.put(str, (String) entry2.getKey());
                    }
                    int iUpdateWithOnConflict3 = i11;
                    for (Pair<String, String[]> pair2 : v.g(list2)) {
                        iUpdateWithOnConflict3 += sQLiteDatabaseA.updateWithOnConflict("statReports", contentValues, (String) pair2.first, (String[]) pair2.second, i2);
                        i6 = i6;
                    }
                    i11 = iUpdateWithOnConflict3;
                } else {
                    j2.a(str2, "updateStatRequestId reportStatListByReqId empty");
                }
            }
            i7 = i6;
            i8 = i11;
        } else {
            i7 = i6;
            i8 = 0;
        }
        if (i4 > 0) {
            for (Map.Entry entry3 : map3.entrySet()) {
                List list3 = (List) entry3.getValue();
                if (list3 != null && list3.size() > 0) {
                    if (str4.equals(entry3.getKey())) {
                        contentValues.remove(str);
                    } else {
                        contentValues.put(str, (String) entry3.getKey());
                    }
                    for (Pair<String, String[]> pair3 : v.g(list3)) {
                        iUpdateWithOnConflict += sQLiteDatabaseA.updateWithOnConflict("statNetSends", contentValues, (String) pair3.first, (String[]) pair3.second, i2);
                        i8 = i8;
                        str2 = str2;
                    }
                } else {
                    j2.a(str2, "updateStatRequestId netSendStatListByReqId empty");
                }
            }
        }
        String str9 = str2;
        int i12 = i8;
        int i13 = iUpdateWithOnConflict;
        sQLiteDatabaseA.setTransactionSuccessful();
        int i14 = i7 + i12 + i13;
        String str10 = str3;
        j2.a(i14 != i5 ? 5 : 3, str9, "updateStatRequestId spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",isConflictReplace=" + z + ",num=(" + i7 + str10 + i12 + str10 + i13 + "),size=(" + i5 + str10 + i + str10 + i3 + str10 + i4 + ")");
        Integer numValueOf = Integer.valueOf(i14);
        sQLiteDatabaseA.endTransaction();
        this.f3636a.b();
        return numValueOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ContentValues contentValues, Pair pair, long j) {
        long jA = com.hihonor.hianalytics.util.r.a();
        SQLiteDatabase sQLiteDatabaseA = this.f3636a.a(true);
        sQLiteDatabaseA.beginTransaction();
        try {
            int iUpdate = sQLiteDatabaseA.update("statEvents", contentValues, (String) pair.first, (String[]) pair.second);
            int iUpdate2 = sQLiteDatabaseA.update("statReports", contentValues, (String) pair.first, (String[]) pair.second);
            int iUpdate3 = sQLiteDatabaseA.update("statNetSends", contentValues, (String) pair.first, (String[]) pair.second);
            sQLiteDatabaseA.setTransactionSuccessful();
            j2.a((iUpdate + iUpdate2) + iUpdate3 > 0 ? 5 : 3, "StatSqliteHandler", "delExpiredStatInfo spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",num=(" + iUpdate + "," + iUpdate2 + "," + iUpdate3 + "),time=" + com.hihonor.hianalytics.util.r.a(j));
            d();
        } finally {
            sQLiteDatabaseA.endTransaction();
            this.f3636a.b();
        }
    }

    private void a(Cursor cursor, List<h3> list) {
        Cursor cursor2 = cursor;
        if (!cursor.moveToFirst()) {
            return;
        }
        int columnIndexOrThrow = cursor2.getColumnIndexOrThrow("_id");
        int columnIndexOrThrow2 = cursor2.getColumnIndexOrThrow("_statType");
        int columnIndexOrThrow3 = cursor2.getColumnIndexOrThrow("_sTime");
        int columnIndexOrThrow4 = cursor2.getColumnIndexOrThrow("_sTimeZone");
        int columnIndexOrThrow5 = cursor2.getColumnIndexOrThrow("_cTime");
        int columnIndexOrThrow6 = cursor2.getColumnIndexOrThrow("_appId");
        int columnIndexOrThrow7 = cursor2.getColumnIndexOrThrow("_sdkVersion");
        int columnIndexOrThrow8 = cursor2.getColumnIndexOrThrow("_appVersion");
        int columnIndexOrThrow9 = cursor2.getColumnIndexOrThrow("_statNum");
        int columnIndexOrThrow10 = cursor2.getColumnIndexOrThrow("_state");
        int columnIndexOrThrow11 = cursor2.getColumnIndexOrThrow("_tag");
        int columnIndexOrThrow12 = cursor2.getColumnIndexOrThrow("_type");
        int columnIndexOrThrow13 = cursor2.getColumnIndexOrThrow("_evtId");
        int columnIndexOrThrow14 = cursor2.getColumnIndexOrThrow("_sourceType");
        int columnIndexOrThrow15 = cursor2.getColumnIndexOrThrow("_reqId");
        int columnIndexOrThrow16 = cursor2.getColumnIndexOrThrow("_otherDesc");
        while (true) {
            long j = cursor2.getLong(columnIndexOrThrow);
            int i = cursor2.getInt(columnIndexOrThrow2);
            long j2 = cursor2.getLong(columnIndexOrThrow3);
            String string = cursor2.getString(columnIndexOrThrow4);
            int i2 = columnIndexOrThrow;
            int i3 = columnIndexOrThrow2;
            long j3 = cursor2.getLong(columnIndexOrThrow5);
            String string2 = cursor2.getString(columnIndexOrThrow6);
            String string3 = cursor2.getString(columnIndexOrThrow7);
            String string4 = cursor2.getString(columnIndexOrThrow8);
            int i4 = cursor2.getInt(columnIndexOrThrow9);
            int i5 = cursor2.getInt(columnIndexOrThrow10);
            String string5 = cursor2.getString(columnIndexOrThrow11);
            int i6 = cursor2.getInt(columnIndexOrThrow12);
            String string6 = cursor2.getString(columnIndexOrThrow13);
            int i7 = cursor2.getInt(columnIndexOrThrow14);
            int i8 = columnIndexOrThrow3;
            String string7 = cursor2.getString(columnIndexOrThrow15);
            list.add(new i3(j, string5, i6, string6, i7, i, j2, string, string2, string3, string4, i4, i5, string7).b(j3).a(cursor2.getString(columnIndexOrThrow16)));
            if (!cursor.moveToNext()) {
                return;
            }
            cursor2 = cursor;
            columnIndexOrThrow = i2;
            columnIndexOrThrow2 = i3;
            columnIndexOrThrow3 = i8;
        }
    }

    private void a(List<h3> list, List<h3> list2, List<h3> list3, List<h3> list4) {
        for (h3 h3Var : list) {
            if (h3Var instanceof i3) {
                list2.add(h3Var);
            } else if (h3Var instanceof k3) {
                list3.add(h3Var);
            } else if (h3Var instanceof j3) {
                list4.add(h3Var);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Pair b(long j, long j2, int i, long j3, int i2, long j4, int i3) throws Throwable {
        f0 f0Var;
        String str;
        int i4;
        int iUpdateWithOnConflict;
        int iUpdateWithOnConflict2;
        Map mapEmptyMap;
        Boolean boolValueOf;
        long jA = com.hihonor.hianalytics.util.r.a();
        SQLiteDatabase sQLiteDatabaseA = this.f3636a.a(true);
        sQLiteDatabaseA.beginTransaction();
        try {
            Pair<Boolean, List<h3>> pairA = a(sQLiteDatabaseA, "statEvents", j, j2, i);
            try {
                Pair<Boolean, List<h3>> pairA2 = a(sQLiteDatabaseA, "statReports", j, j3, i2);
                Pair<Boolean, List<h3>> pairA3 = a(sQLiteDatabaseA, "statNetSends", j, j4, i3);
                int size = ((List) pairA.second).size();
                int size2 = ((List) pairA2.second).size();
                int size3 = ((List) pairA3.second).size();
                String str2 = com.huawei.openalliance.ad.constant.x.A;
                if (size > 0 || size2 > 0 || size3 > 0) {
                    HashMap map = new HashMap();
                    map.put("eventStatData", (List) pairA.second);
                    map.put("reportStatData", (List) pairA2.second);
                    map.put("netSendStatData", (List) pairA3.second);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("_state", (Integer) 1);
                    List<h3> listA = v.a((List<h3>) pairA.second);
                    List<h3> listA2 = v.a((List<h3>) pairA2.second);
                    List<h3> listA3 = v.a((List<h3>) pairA3.second);
                    int size4 = listA.size();
                    int size5 = listA2.size();
                    int size6 = listA3.size();
                    if (size4 > 0) {
                        Iterator<Pair<String, String[]>> it = v.g(listA).iterator();
                        int iUpdateWithOnConflict3 = 0;
                        while (it.hasNext()) {
                            Iterator<Pair<String, String[]>> it2 = it;
                            Pair<String, String[]> next = it.next();
                            String str3 = str2;
                            iUpdateWithOnConflict3 += sQLiteDatabaseA.updateWithOnConflict("statEvents", contentValues, (String) next.first, (String[]) next.second, 5);
                            it = it2;
                            str2 = str3;
                        }
                        str = str2;
                        i4 = iUpdateWithOnConflict3;
                    } else {
                        str = com.huawei.openalliance.ad.constant.x.A;
                        i4 = 0;
                    }
                    if (size5 > 0) {
                        Iterator<Pair<String, String[]>> it3 = v.g(listA2).iterator();
                        iUpdateWithOnConflict = 0;
                        while (it3.hasNext()) {
                            Iterator<Pair<String, String[]>> it4 = it3;
                            Pair<String, String[]> next2 = it3.next();
                            iUpdateWithOnConflict += sQLiteDatabaseA.updateWithOnConflict("statReports", contentValues, (String) next2.first, (String[]) next2.second, 5);
                            it3 = it4;
                        }
                    } else {
                        iUpdateWithOnConflict = 0;
                    }
                    if (size6 > 0) {
                        iUpdateWithOnConflict2 = 0;
                        for (Pair<String, String[]> pair : v.g(listA3)) {
                            iUpdateWithOnConflict2 += sQLiteDatabaseA.updateWithOnConflict("statNetSends", contentValues, (String) pair.first, (String[]) pair.second, 5);
                        }
                    } else {
                        iUpdateWithOnConflict2 = 0;
                    }
                    sQLiteDatabaseA.setTransactionSuccessful();
                    int i5 = i4 + iUpdateWithOnConflict + iUpdateWithOnConflict2;
                    int i6 = size4 + size5 + size6;
                    boolean z = ((Boolean) pairA.first).booleanValue() || ((Boolean) pairA2.first).booleanValue() || ((Boolean) pairA3.first).booleanValue();
                    String str4 = str;
                    mapEmptyMap = map;
                    j2.a(i5 != i6 ? 5 : 3, "StatSqliteHandler", "getToSendSatInfo spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",maxStatTime=" + com.hihonor.hianalytics.util.r.a(j) + ",eventStat=(" + j2 + str4 + i + "),reportStat=(" + j3 + str4 + i2 + "),netSendStat=(" + j4 + str4 + i3 + "),hasNext=" + z + ",num=(" + i4 + "," + iUpdateWithOnConflict + "," + iUpdateWithOnConflict2 + "),normalSize=(" + size4 + "," + size5 + "," + size6 + ")),size=(" + size + "," + size2 + "," + size3 + ")");
                    boolValueOf = Boolean.valueOf(z);
                } else {
                    j2.a("StatSqliteHandler", "getToSendSatInfo spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",maxStatTime=" + com.hihonor.hianalytics.util.r.a(j) + ",eventStat=(" + j2 + com.huawei.openalliance.ad.constant.x.A + i + "),reportStat=(" + j3 + com.huawei.openalliance.ad.constant.x.A + i2 + "),netSendStat=(" + j4 + com.huawei.openalliance.ad.constant.x.A + i3 + ") no data");
                    boolValueOf = Boolean.FALSE;
                    mapEmptyMap = Collections.emptyMap();
                }
                Pair pairCreate = Pair.create(boolValueOf, mapEmptyMap);
                sQLiteDatabaseA.endTransaction();
                this.f3636a.b();
                return pairCreate;
            } catch (Throwable th) {
                th = th;
                f0Var = this;
                sQLiteDatabaseA.endTransaction();
                f0Var.f3636a.b();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            f0Var = this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean b(String str, String str2, int[] iArr) {
        try {
            return Boolean.valueOf(a(this.f3636a.a(false), str, str2, iArr) > 0);
        } finally {
            this.f3636a.b();
        }
    }

    private Map<String, List<h3>> b(List<h3> list) {
        HashMap map = new HashMap();
        if (list == null) {
            return map;
        }
        for (h3 h3Var : list) {
            if (h3Var != null) {
                List arrayList = (List) map.get(h3Var.d());
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map.put(h3Var.d(), arrayList);
                }
                arrayList.add(h3Var);
            }
        }
        return map;
    }

    private void b(Cursor cursor, List<h3> list) {
        Cursor cursor2 = cursor;
        int columnIndexOrThrow = cursor2.getColumnIndexOrThrow("_id");
        int columnIndexOrThrow2 = cursor2.getColumnIndexOrThrow("_statType");
        int columnIndexOrThrow3 = cursor2.getColumnIndexOrThrow("_sTime");
        int columnIndexOrThrow4 = cursor2.getColumnIndexOrThrow("_sTimeZone");
        int columnIndexOrThrow5 = cursor2.getColumnIndexOrThrow("_cTime");
        int columnIndexOrThrow6 = cursor2.getColumnIndexOrThrow("_appId");
        int columnIndexOrThrow7 = cursor2.getColumnIndexOrThrow("_sdkVersion");
        int columnIndexOrThrow8 = cursor2.getColumnIndexOrThrow("_appVersion");
        int columnIndexOrThrow9 = cursor2.getColumnIndexOrThrow("_statNum");
        int columnIndexOrThrow10 = cursor2.getColumnIndexOrThrow("_state");
        int columnIndexOrThrow11 = cursor2.getColumnIndexOrThrow("_type");
        int columnIndexOrThrow12 = cursor2.getColumnIndexOrThrow("_reportType");
        int columnIndexOrThrow13 = cursor2.getColumnIndexOrThrow("_url");
        int columnIndexOrThrow14 = cursor2.getColumnIndexOrThrow("_netCode");
        int columnIndexOrThrow15 = cursor2.getColumnIndexOrThrow("_reqId");
        int columnIndexOrThrow16 = cursor2.getColumnIndexOrThrow("_otherDesc");
        while (cursor.moveToNext()) {
            long j = cursor2.getLong(columnIndexOrThrow);
            int i = cursor2.getInt(columnIndexOrThrow2);
            long j2 = cursor2.getLong(columnIndexOrThrow3);
            String string = cursor2.getString(columnIndexOrThrow4);
            int i2 = columnIndexOrThrow;
            long j3 = cursor2.getLong(columnIndexOrThrow5);
            String string2 = cursor2.getString(columnIndexOrThrow6);
            String string3 = cursor2.getString(columnIndexOrThrow7);
            String string4 = cursor2.getString(columnIndexOrThrow8);
            int i3 = cursor2.getInt(columnIndexOrThrow9);
            int i4 = cursor2.getInt(columnIndexOrThrow10);
            int i5 = cursor2.getInt(columnIndexOrThrow12);
            String string5 = cursor2.getString(columnIndexOrThrow13);
            int i6 = cursor2.getInt(columnIndexOrThrow11);
            int i7 = cursor2.getInt(columnIndexOrThrow14);
            int i8 = columnIndexOrThrow3;
            String string6 = cursor2.getString(columnIndexOrThrow15);
            list.add(new j3(j, i6, i5, i, i7, string5, j2, string, string2, string3, string4, i3, i4, string6).b(j3).a(cursor2.getString(columnIndexOrThrow16)));
            cursor2 = cursor;
            columnIndexOrThrow = i2;
            columnIndexOrThrow2 = columnIndexOrThrow2;
            columnIndexOrThrow3 = i8;
        }
    }

    private void c(Cursor cursor, List<h3> list) {
        Cursor cursor2 = cursor;
        int columnIndexOrThrow = cursor2.getColumnIndexOrThrow("_id");
        int columnIndexOrThrow2 = cursor2.getColumnIndexOrThrow("_statType");
        int columnIndexOrThrow3 = cursor2.getColumnIndexOrThrow("_sTime");
        int columnIndexOrThrow4 = cursor2.getColumnIndexOrThrow("_sTimeZone");
        int columnIndexOrThrow5 = cursor2.getColumnIndexOrThrow("_cTime");
        int columnIndexOrThrow6 = cursor2.getColumnIndexOrThrow("_appId");
        int columnIndexOrThrow7 = cursor2.getColumnIndexOrThrow("_sdkVersion");
        int columnIndexOrThrow8 = cursor2.getColumnIndexOrThrow("_appVersion");
        int columnIndexOrThrow9 = cursor2.getColumnIndexOrThrow("_statNum");
        int columnIndexOrThrow10 = cursor2.getColumnIndexOrThrow("_state");
        int columnIndexOrThrow11 = cursor2.getColumnIndexOrThrow("_tag");
        int columnIndexOrThrow12 = cursor2.getColumnIndexOrThrow("_type");
        int columnIndexOrThrow13 = cursor2.getColumnIndexOrThrow("_reportType");
        int columnIndexOrThrow14 = cursor2.getColumnIndexOrThrow("_reqId");
        int columnIndexOrThrow15 = cursor2.getColumnIndexOrThrow("_otherDesc");
        while (cursor.moveToNext()) {
            long j = cursor2.getLong(columnIndexOrThrow);
            int i = cursor2.getInt(columnIndexOrThrow2);
            long j2 = cursor2.getLong(columnIndexOrThrow3);
            String string = cursor2.getString(columnIndexOrThrow4);
            int i2 = columnIndexOrThrow;
            long j3 = cursor2.getLong(columnIndexOrThrow5);
            String string2 = cursor2.getString(columnIndexOrThrow6);
            String string3 = cursor2.getString(columnIndexOrThrow7);
            String string4 = cursor2.getString(columnIndexOrThrow8);
            int i3 = cursor2.getInt(columnIndexOrThrow9);
            int i4 = cursor2.getInt(columnIndexOrThrow10);
            String string5 = cursor2.getString(columnIndexOrThrow11);
            int i5 = cursor2.getInt(columnIndexOrThrow12);
            int i6 = cursor2.getInt(columnIndexOrThrow13);
            String string6 = cursor2.getString(columnIndexOrThrow14);
            int i7 = columnIndexOrThrow3;
            list.add(new k3(j, string5, i5, i6, i, j2, string, string2, string3, string4, i3, i4, string6).b(j3).a(cursor2.getString(columnIndexOrThrow15)));
            cursor2 = cursor;
            columnIndexOrThrow = i2;
            columnIndexOrThrow2 = columnIndexOrThrow2;
            columnIndexOrThrow3 = i7;
        }
    }

    private synchronized void d() {
        long jA = com.hihonor.hianalytics.util.r.a(true);
        t3.a(this.d);
        long j = this.c;
        long j2 = jA - j;
        long j3 = j <= 0 ? -1000L : ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT - j2;
        if (j3 <= 0) {
            j3 = 10;
        }
        j2.a("StatSqliteHandler", "checkToClearDeletableStats lastMillis=" + this.c + ",interval=" + j2);
        t3.a(this.d, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.c = com.hihonor.hianalytics.util.r.a(true);
        u3.a(3, new Runnable() { // from class: com.hihonor.hianalytics.hnha.f0$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.f();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        long jA = com.hihonor.hianalytics.util.r.a();
        SQLiteDatabase sQLiteDatabaseA = this.f3636a.a(true);
        sQLiteDatabaseA.beginTransaction();
        try {
            j2.c("StatSqliteHandler", "doClearDeletableStats spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",num=(" + sQLiteDatabaseA.delete("statEvents", "_dataState = 1", null) + "," + sQLiteDatabaseA.delete("statReports", "_dataState = 1", null) + "," + sQLiteDatabaseA.delete("statNetSends", "_dataState = 1", null) + ")");
            sQLiteDatabaseA.setTransactionSuccessful();
        } finally {
            sQLiteDatabaseA.endTransaction();
            this.f3636a.b();
        }
    }

    @Override // com.hihonor.hianalytics.hnha.y
    public int a(List<h3> list) {
        final int size = list == null ? 0 : list.size();
        if (size <= 0) {
            j2.g("StatSqliteHandler", "delStatList empty directReturn");
            return 0;
        }
        final LinkedList linkedList = new LinkedList();
        final LinkedList linkedList2 = new LinkedList();
        final LinkedList linkedList3 = new LinkedList();
        a(list, linkedList, linkedList2, linkedList3);
        final int size2 = linkedList.size();
        final int size3 = linkedList2.size();
        final int size4 = linkedList3.size();
        final ContentValues contentValuesA = v.a(1);
        return ((Integer) u3.a(3, 0, new q3() { // from class: com.hihonor.hianalytics.hnha.f0$$ExternalSyntheticLambda4
            @Override // com.hihonor.hianalytics.hnha.q3
            public final Object a() {
                return this.f$0.a(size2, linkedList, contentValuesA, size3, linkedList2, size4, linkedList3, size);
            }
        })).intValue();
    }

    @Override // com.hihonor.hianalytics.hnha.y
    public int a(List<h3> list, int i, final boolean z) {
        final int size = list == null ? 0 : list.size();
        if (size <= 0) {
            j2.a("StatSqliteHandler", "updateStatSendMark empty directReturn Success");
            return 0;
        }
        final LinkedList linkedList = new LinkedList();
        final LinkedList linkedList2 = new LinkedList();
        final LinkedList linkedList3 = new LinkedList();
        a(list, linkedList, linkedList2, linkedList3);
        final int size2 = linkedList.size();
        final int size3 = linkedList2.size();
        final int size4 = linkedList3.size();
        final ContentValues contentValues = new ContentValues();
        contentValues.put("_state", Integer.valueOf(i));
        final int i2 = z ? 5 : 4;
        return ((Integer) u3.a(3, 0, new q3() { // from class: com.hihonor.hianalytics.hnha.f0$$ExternalSyntheticLambda7
            @Override // com.hihonor.hianalytics.hnha.q3
            public final Object a() {
                return this.f$0.a(size2, linkedList, contentValues, i2, size3, linkedList2, size4, linkedList3, size, z);
            }
        })).intValue();
    }

    @Override // com.hihonor.hianalytics.hnha.y
    public Pair<Boolean, Map<String, List<h3>>> a(final long j, final long j2, final int i, final long j3, final int i2, final long j4, final int i3) {
        return (Pair) u3.a(3, Pair.create(Boolean.FALSE, Collections.emptyMap()), new q3() { // from class: com.hihonor.hianalytics.hnha.f0$$ExternalSyntheticLambda2
            @Override // com.hihonor.hianalytics.hnha.q3
            public final Object a() {
                return this.f$0.b(j, j2, i, j3, i2, j4, i3);
            }
        });
    }

    @Override // com.hihonor.hianalytics.hnha.e0.a
    public z a() {
        return new g0();
    }

    @Override // com.hihonor.hianalytics.hnha.y
    public void a(final long j) {
        final Pair<String, String[]> pairA = v.a(j);
        final ContentValues contentValuesA = v.a(1);
        u3.a(3, new Runnable() { // from class: com.hihonor.hianalytics.hnha.f0$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(contentValuesA, pairA, j);
            }
        });
    }

    @Override // com.hihonor.hianalytics.hnha.y
    public boolean a(final String str, final String str2, final int[] iArr) {
        return ((Boolean) u3.a(3, Boolean.FALSE, new q3() { // from class: com.hihonor.hianalytics.hnha.f0$$ExternalSyntheticLambda6
            @Override // com.hihonor.hianalytics.hnha.q3
            public final Object a() {
                return this.f$0.b(str, str2, iArr);
            }
        })).booleanValue();
    }

    @Override // com.hihonor.hianalytics.hnha.y
    public boolean a(List<h3> list, final boolean z) {
        final int size = list == null ? 0 : list.size();
        if (size <= 0) {
            j2.g("StatSqliteHandler", "insertStatInfoList illegal statSize=" + size);
            return false;
        }
        final LinkedList linkedList = new LinkedList();
        final LinkedList linkedList2 = new LinkedList();
        final LinkedList linkedList3 = new LinkedList();
        a(list, linkedList, linkedList2, linkedList3);
        final int size2 = linkedList.size();
        final int size3 = linkedList2.size();
        final int size4 = linkedList3.size();
        final int i = z ? 5 : 4;
        return ((Boolean) u3.a(3, Boolean.FALSE, new q3() { // from class: com.hihonor.hianalytics.hnha.f0$$ExternalSyntheticLambda3
            @Override // com.hihonor.hianalytics.hnha.q3
            public final Object a() {
                return this.f$0.a(i, linkedList, linkedList2, linkedList3, size2, size3, size4, z, size);
            }
        })).booleanValue();
    }

    @Override // com.hihonor.hianalytics.hnha.y
    public int b(List<h3> list, final boolean z) {
        final int size = list == null ? 0 : list.size();
        if (size <= 0) {
            j2.a("StatSqliteHandler", "updateStatRequestId empty directReturn Success");
            return 0;
        }
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        a(list, linkedList, linkedList2, linkedList3);
        final int size2 = linkedList.size();
        final int size3 = linkedList2.size();
        final int size4 = linkedList3.size();
        final Map<String, List<h3>> mapB = b(linkedList);
        final Map<String, List<h3>> mapB2 = b(linkedList2);
        final Map<String, List<h3>> mapB3 = b(linkedList3);
        final ContentValues contentValues = new ContentValues();
        final int i = z ? 5 : 4;
        return ((Integer) u3.a(3, 0, new q3() { // from class: com.hihonor.hianalytics.hnha.f0$$ExternalSyntheticLambda0
            @Override // com.hihonor.hianalytics.hnha.q3
            public final Object a() {
                return this.f$0.a(size2, mapB, contentValues, i, size3, mapB2, size4, mapB3, size, z);
            }
        })).intValue();
    }

    @Override // com.hihonor.hianalytics.hnha.y
    public void c() {
        d();
    }
}
