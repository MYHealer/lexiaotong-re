package com.hihonor.hianalytics.hnha;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Pair;
import com.hihonor.hianalytics.util.SystemUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public final class c0 extends x implements e0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e0 f3628a = new e0(this);

    private Pair<Integer, Long> a(SQLiteDatabase sQLiteDatabase, String str, String str2) throws Throwable {
        long j;
        Cursor cursor = null;
        try {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT _id,_value FROM kvContent WHERE _key = ?", new String[]{str});
            try {
                if (cursorRawQuery.moveToFirst()) {
                    j = cursorRawQuery.getLong(cursorRawQuery.getColumnIndexOrThrow("_id"));
                    if (Objects.equals(cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("_value")), str2)) {
                        Pair<Integer, Long> pairCreate = Pair.create(-1, Long.valueOf(j));
                        com.hihonor.hianalytics.util.k.a(cursorRawQuery);
                        return pairCreate;
                    }
                } else {
                    j = -1;
                }
                com.hihonor.hianalytics.util.k.a(cursorRawQuery);
                ContentValues contentValues = new ContentValues();
                if (j > 0) {
                    contentValues.put("_value", str2);
                    return Pair.create(Integer.valueOf(sQLiteDatabase.updateWithOnConflict("kvContent", contentValues, "_id = ?", new String[]{String.valueOf(j)}, 5)), Long.valueOf(j));
                }
                contentValues.put("_key", str);
                contentValues.put("_value", str2);
                return Pair.create(-2, Long.valueOf(sQLiteDatabase.insertWithOnConflict("kvContent", null, contentValues, 5)));
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

    private String a(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        Cursor cursor = null;
        try {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT _value FROM kvContent WHERE _key = ?", new String[]{str});
            try {
                if (!cursorRawQuery.moveToFirst()) {
                    com.hihonor.hianalytics.util.k.a(cursorRawQuery);
                    return null;
                }
                String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("_value"));
                com.hihonor.hianalytics.util.k.a(cursorRawQuery);
                return string;
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
    public /* synthetic */ Pair b(String str, List list) {
        long jA = com.hihonor.hianalytics.util.r.a();
        SQLiteDatabase sQLiteDatabaseA = this.f3628a.a(true);
        sQLiteDatabaseA.beginTransaction();
        try {
            Map<String, String> mapC = c(sQLiteDatabaseA, str);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                mapC.keySet().remove((String) it.next());
            }
            JSONObject jSONObjectA = com.hihonor.hianalytics.util.l.a(mapC);
            Pair<Integer, Long> pairA = a(sQLiteDatabaseA, str, jSONObjectA.toString());
            sQLiteDatabaseA.setTransactionSuccessful();
            j2.a("KVSqliteHandler", "removeItemMap success = " + com.hihonor.hianalytics.util.r.e(jA) + ",first=" + pairA.first + ",second=" + pairA.second + ",key=" + str + ",remove-finish-value=" + jSONObjectA);
            return Pair.create(Boolean.TRUE, mapC);
        } finally {
            sQLiteDatabaseA.endTransaction();
            this.f3628a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Pair b(String str, Map map) {
        long jA = com.hihonor.hianalytics.util.r.a();
        SQLiteDatabase sQLiteDatabaseA = this.f3628a.a(true);
        sQLiteDatabaseA.beginTransaction();
        try {
            Map<String, String> mapC = c(sQLiteDatabaseA, str);
            HashMap map2 = new HashMap();
            if (!mapC.isEmpty()) {
                map2.putAll(mapC);
            }
            map2.putAll(map);
            map2.remove(null);
            JSONObject jSONObjectA = com.hihonor.hianalytics.util.l.a(map2);
            Pair<Integer, Long> pairA = a(sQLiteDatabaseA, str, jSONObjectA.toString());
            sQLiteDatabaseA.setTransactionSuccessful();
            j2.a("KVSqliteHandler", "addItemMap success =" + com.hihonor.hianalytics.util.r.e(jA) + ",first=" + pairA.first + ",second=" + pairA.second + ",key=" + str + ",value=" + jSONObjectA);
            return Pair.create(Boolean.TRUE, map2);
        } finally {
            sQLiteDatabaseA.endTransaction();
            this.f3628a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean b(String str, String str2) {
        long jA = com.hihonor.hianalytics.util.r.a();
        SQLiteDatabase sQLiteDatabaseA = this.f3628a.a(true);
        sQLiteDatabaseA.beginTransaction();
        try {
            Pair<Integer, Long> pairA = a(sQLiteDatabaseA, str, str2);
            sQLiteDatabaseA.setTransactionSuccessful();
            Object obj = pairA.second;
            j2.a((obj == null || ((Long) obj).longValue() <= 0) ? 5 : 3, "KVSqliteHandler", "putValueSpendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",first=" + pairA.first + ",second=" + pairA.second + ",key=" + str + ",value=" + str2);
            return Boolean.TRUE;
        } finally {
            sQLiteDatabaseA.endTransaction();
            this.f3628a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean b(boolean z) {
        long jA = com.hihonor.hianalytics.util.r.a();
        SQLiteDatabase sQLiteDatabaseA = this.f3628a.a(true);
        sQLiteDatabaseA.beginTransaction();
        try {
            long jA2 = com.hihonor.hianalytics.util.b.a(a(sQLiteDatabaseA, "statLastSendingTime"), 0L);
            if (jA2 <= 0) {
                j2.a("KVSqliteHandler", "updateStatSendingMarkBySendEnd first=" + com.hihonor.hianalytics.util.r.e(jA) + ",isSuccess=" + z + ",lastSendingTime=" + jA2);
            } else {
                String strA = a(sQLiteDatabaseA, "statLastSendProcessName");
                if (TextUtils.isEmpty(strA) || strA.equals(SystemUtils.getProcessName()) || !SystemUtils.b(strA)) {
                    if (z) {
                        a(sQLiteDatabaseA, "statLastSendSuccessTime", String.valueOf(com.hihonor.hianalytics.util.r.b()));
                    }
                    Pair<Integer, Long> pairA = a(sQLiteDatabaseA, "statLastSendingTime", String.valueOf(0));
                    sQLiteDatabaseA.setTransactionSuccessful();
                    j2.a("KVSqliteHandler", "updateStatSendingMarkBySendEnd second=" + com.hihonor.hianalytics.util.r.e(jA) + ",isSuccess=" + z + ",first=" + pairA.first + ",second=" + pairA.second + ",lastSendingTime=" + jA2 + ",processName=" + strA);
                } else {
                    j2.a("KVSqliteHandler", "updateStatSendingMarkBySendEnd third=" + com.hihonor.hianalytics.util.r.e(jA) + ",isSuccess=" + z + ",lastSendingTime=" + jA2 + ",processName=" + strA);
                }
            }
            return Boolean.TRUE;
        } finally {
            sQLiteDatabaseA.endTransaction();
            this.f3628a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer b(long j) {
        int i;
        int iValueOf;
        long jA = com.hihonor.hianalytics.util.r.a();
        SQLiteDatabase sQLiteDatabaseA = this.f3628a.a(true);
        sQLiteDatabaseA.beginTransaction();
        try {
            long jA2 = com.hihonor.hianalytics.util.b.a(a(sQLiteDatabaseA, "statLastSendSuccessTime"), 0L);
            if (jA2 > 0) {
                long jB = com.hihonor.hianalytics.util.r.b() - jA2;
                if (j <= 0 || jB < -300000 || jB >= j) {
                    long jA3 = com.hihonor.hianalytics.util.b.a(a(sQLiteDatabaseA, "statLastSendingTime"), 0L);
                    if (jA3 <= 0) {
                        a(sQLiteDatabaseA, "statLastSendProcessName", SystemUtils.getProcessName());
                        a(sQLiteDatabaseA, "statLastSendingTime", String.valueOf(com.hihonor.hianalytics.util.r.b()));
                        sQLiteDatabaseA.setTransactionSuccessful();
                        j2.a("KVSqliteHandler", "updateStatSendingMarkByPreSend third=" + com.hihonor.hianalytics.util.r.e(jA) + ",lastSuccessTime=" + com.hihonor.hianalytics.util.r.a(jA2) + ",reportInterval=" + com.hihonor.hianalytics.util.r.f(j) + ",lastSendingTime=" + com.hihonor.hianalytics.util.r.a(jA3) + ",successInterval=" + com.hihonor.hianalytics.util.r.f(jB));
                        iValueOf = 0;
                    } else {
                        long jB2 = com.hihonor.hianalytics.util.r.b() - jA3;
                        String strA = a(sQLiteDatabaseA, "statLastSendProcessName");
                        if (TextUtils.isEmpty(strA) || strA.equals(SystemUtils.getProcessName()) || !SystemUtils.b(strA) || jB2 < -300000 || jB2 > 180000) {
                            a(sQLiteDatabaseA, "statLastSendProcessName", SystemUtils.getProcessName());
                            Pair<Integer, Long> pairA = a(sQLiteDatabaseA, "statLastSendingTime", String.valueOf(com.hihonor.hianalytics.util.r.b()));
                            sQLiteDatabaseA.setTransactionSuccessful();
                            j2.a("KVSqliteHandler", "updateStatSendingMarkByPreSend fourth=" + com.hihonor.hianalytics.util.r.e(jA) + ",lastSuccessTime=" + com.hihonor.hianalytics.util.r.a(jA2) + ",reportInterval=" + com.hihonor.hianalytics.util.r.f(j) + ",lastSendingTime=" + com.hihonor.hianalytics.util.r.a(jA3) + ",successInterval=" + com.hihonor.hianalytics.util.r.f(jB) + ",first=" + pairA.first + ",second=" + pairA.second + ",interval=" + com.hihonor.hianalytics.util.r.f(jB2) + ",processName=" + strA);
                            i = 0;
                        } else {
                            j2.a("KVSqliteHandler", "updateStatSendingMarkByPreSend fifth=" + com.hihonor.hianalytics.util.r.e(jA) + ",lastSuccessTime=" + com.hihonor.hianalytics.util.r.a(jA2) + ",reportInterval=" + com.hihonor.hianalytics.util.r.f(j) + ",lastSendingTime=" + com.hihonor.hianalytics.util.r.a(jA3) + ",successInterval=" + com.hihonor.hianalytics.util.r.f(jB) + ",interval=" + com.hihonor.hianalytics.util.r.f(jB2) + ",processName=" + strA);
                            iValueOf = 3;
                        }
                    }
                } else {
                    j2.a("KVSqliteHandler", "updateStatSendingMarkByPreSend second=" + com.hihonor.hianalytics.util.r.e(jA) + ",lastSuccessTime=" + com.hihonor.hianalytics.util.r.a(jA2) + ",reportInterval=" + com.hihonor.hianalytics.util.r.f(j) + ",successInterval=" + com.hihonor.hianalytics.util.r.f(jB));
                    iValueOf = 2;
                }
                return iValueOf;
            }
            a(sQLiteDatabaseA, "statLastSendProcessName", SystemUtils.getProcessName());
            a(sQLiteDatabaseA, "statLastSendSuccessTime", String.valueOf(com.hihonor.hianalytics.util.r.b()));
            sQLiteDatabaseA.setTransactionSuccessful();
            j2.a("KVSqliteHandler", "updateStatSendingMarkByPreSend first=" + com.hihonor.hianalytics.util.r.e(jA) + ",lastSuccessTime=" + com.hihonor.hianalytics.util.r.a(jA2) + ",reportInterval=" + com.hihonor.hianalytics.util.r.f(j));
            i = 1;
            iValueOf = Integer.valueOf(i);
            return iValueOf;
        } finally {
            sQLiteDatabaseA.endTransaction();
            this.f3628a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String b(String str, String str2, boolean z, String str3) {
        Pair<Integer, Long> pairA;
        long jA = com.hihonor.hianalytics.util.r.a();
        SQLiteDatabase sQLiteDatabaseA = this.f3628a.a(true);
        sQLiteDatabaseA.beginTransaction();
        try {
            String strA = a(sQLiteDatabaseA, str);
            if (Objects.equals(strA, str2) || (z && strA == null)) {
                pairA = a(sQLiteDatabaseA, str, str3);
                if (((Long) pairA.second).longValue() > 0) {
                    strA = str3;
                }
            } else {
                pairA = Pair.create(-100, -1L);
            }
            sQLiteDatabaseA.setTransactionSuccessful();
            Object obj = pairA.second;
            j2.a((obj == null || ((Long) obj).longValue() <= 0) ? 5 : 3, "KVSqliteHandler", "putValueSpendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",expectValue=" + str2 + ",isContainNull=" + z + ",newValue=" + str3 + ",first=" + pairA.first + ",second=" + pairA.second + ",key=" + str + ",value=" + strA);
            return strA;
        } finally {
            sQLiteDatabaseA.endTransaction();
            this.f3628a.b();
        }
    }

    private List<String> b(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        String strA = a(sQLiteDatabase, str);
        if (TextUtils.isEmpty(strA)) {
            j2.a("KVSqliteHandler", "getItemList value is empty,key=" + str);
            return new ArrayList();
        }
        j2.a("KVSqliteHandler", "getItemList success = ,key=" + str + ",value=" + strA);
        return com.hihonor.hianalytics.util.l.b(strA);
    }

    private Map<String, String> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        String strA = a(sQLiteDatabase, str);
        if (TextUtils.isEmpty(strA)) {
            j2.a("KVSqliteHandler", "getItemMapNoRepeat value is empty,key=" + str);
            return new HashMap();
        }
        j2.a("KVSqliteHandler", "getItemMapNoRepeat success = ,key=" + str + ",value=" + strA);
        return com.hihonor.hianalytics.util.l.c(strA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean d() {
        long jA = com.hihonor.hianalytics.util.r.a();
        SQLiteDatabase sQLiteDatabaseA = this.f3628a.a(true);
        sQLiteDatabaseA.beginTransaction();
        try {
            long jA2 = com.hihonor.hianalytics.util.b.a(a(sQLiteDatabaseA, "statLastSendSuccessTime"), 0L);
            if (jA2 <= 0) {
                a(sQLiteDatabaseA, "statLastSendProcessName", SystemUtils.getProcessName());
                a(sQLiteDatabaseA, "statLastSendSuccessTime", String.valueOf(com.hihonor.hianalytics.util.r.b()));
            }
            long jA3 = com.hihonor.hianalytics.util.b.a(a(sQLiteDatabaseA, "statLastSendingTime"), 0L);
            if (jA3 <= 0) {
                sQLiteDatabaseA.setTransactionSuccessful();
                j2.a("KVSqliteHandler", "updateStatSendingMarkByStart first=" + com.hihonor.hianalytics.util.r.e(jA) + ",lastSuccessTime=" + com.hihonor.hianalytics.util.r.a(jA2) + ",lastSendingTime=" + com.hihonor.hianalytics.util.r.a(jA3));
            } else {
                String strA = a(sQLiteDatabaseA, "statLastSendProcessName");
                if (TextUtils.isEmpty(strA) || strA.equals(SystemUtils.getProcessName()) || !SystemUtils.b(strA)) {
                    Pair<Integer, Long> pairA = a(sQLiteDatabaseA, "statLastSendingTime", String.valueOf(0));
                    sQLiteDatabaseA.setTransactionSuccessful();
                    j2.a("KVSqliteHandler", "updateStatSendingMarkByStart second=" + com.hihonor.hianalytics.util.r.e(jA) + ",lastSuccessTime=" + com.hihonor.hianalytics.util.r.a(jA2) + ",lastSendingTime=" + com.hihonor.hianalytics.util.r.a(jA3) + ",first=" + pairA.first + ",second=" + pairA.second + ",processName=" + strA);
                } else {
                    sQLiteDatabaseA.setTransactionSuccessful();
                    j2.a("KVSqliteHandler", "updateStatSendingMarkByStart third=" + com.hihonor.hianalytics.util.r.e(jA) + ",lastSuccessTime=" + com.hihonor.hianalytics.util.r.a(jA2) + ",lastSendingTime=" + com.hihonor.hianalytics.util.r.a(jA3) + ",processName=" + strA);
                }
            }
            return Boolean.TRUE;
        } finally {
            sQLiteDatabaseA.endTransaction();
            this.f3628a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List d(String str) {
        long jA = com.hihonor.hianalytics.util.r.a();
        try {
            List<String> listB = b(this.f3628a.a(false), str);
            j2.a("KVSqliteHandler", "getItemList success = " + com.hihonor.hianalytics.util.r.e(jA) + ",key=" + str);
            return listB;
        } finally {
            this.f3628a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Map e(String str) {
        long jA = com.hihonor.hianalytics.util.r.a();
        try {
            Map<String, String> mapC = c(this.f3628a.a(false), str);
            j2.a("KVSqliteHandler", "getItemMap success = " + com.hihonor.hianalytics.util.r.e(jA) + ",key=" + str);
            return mapC;
        } finally {
            this.f3628a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String f(String str) {
        long jA = com.hihonor.hianalytics.util.r.a();
        try {
            String strA = a(this.f3628a.a(false), str);
            j2.a("KVSqliteHandler", "getValueSpendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",key=" + str + ",value=" + strA);
            return strA;
        } finally {
            this.f3628a.b();
        }
    }

    @Override // com.hihonor.hianalytics.hnha.x
    public int a(final long j) {
        return ((Integer) u3.a(3, 4, new q3() { // from class: com.hihonor.hianalytics.hnha.c0$$ExternalSyntheticLambda1
            @Override // com.hihonor.hianalytics.hnha.q3
            public final Object a() {
                return this.f$0.b(j);
            }
        })).intValue();
    }

    @Override // com.hihonor.hianalytics.hnha.x
    public Pair<Boolean, Map<String, String>> a(final String str, final List<String> list) {
        if (list != null && !list.isEmpty()) {
            return (Pair) u3.a(3, Pair.create(Boolean.FALSE, b(str)), new q3() { // from class: com.hihonor.hianalytics.hnha.c0$$ExternalSyntheticLambda0
                @Override // com.hihonor.hianalytics.hnha.q3
                public final Object a() {
                    return this.f$0.b(str, list);
                }
            });
        }
        j2.a("KVSqliteHandler", "removeItemMap is empty");
        return Pair.create(Boolean.FALSE, b(str));
    }

    @Override // com.hihonor.hianalytics.hnha.x
    public Pair<Boolean, Map<String, String>> a(final String str, final Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            return (Pair) u3.a(3, Pair.create(Boolean.FALSE, b(str)), new q3() { // from class: com.hihonor.hianalytics.hnha.c0$$ExternalSyntheticLambda8
                @Override // com.hihonor.hianalytics.hnha.q3
                public final Object a() {
                    return this.f$0.b(str, map);
                }
            });
        }
        j2.a("KVSqliteHandler", "addItemMap is empty");
        return Pair.create(Boolean.FALSE, b(str));
    }

    @Override // com.hihonor.hianalytics.hnha.e0.a
    public z a() {
        return new d0();
    }

    @Override // com.hihonor.hianalytics.hnha.x
    public String a(final String str, final String str2, final boolean z, final String str3) {
        return (String) u3.a(3, null, new q3() { // from class: com.hihonor.hianalytics.hnha.c0$$ExternalSyntheticLambda9
            @Override // com.hihonor.hianalytics.hnha.q3
            public final Object a() {
                return this.f$0.b(str, str2, z, str3);
            }
        });
    }

    @Override // com.hihonor.hianalytics.hnha.x
    public List<String> a(final String str) {
        return (List) u3.a(3, new ArrayList(), new q3() { // from class: com.hihonor.hianalytics.hnha.c0$$ExternalSyntheticLambda2
            @Override // com.hihonor.hianalytics.hnha.q3
            public final Object a() {
                return this.f$0.d(str);
            }
        });
    }

    @Override // com.hihonor.hianalytics.hnha.x
    public boolean a(final String str, final String str2) {
        return ((Boolean) u3.a(3, Boolean.FALSE, new q3() { // from class: com.hihonor.hianalytics.hnha.c0$$ExternalSyntheticLambda3
            @Override // com.hihonor.hianalytics.hnha.q3
            public final Object a() {
                return this.f$0.b(str, str2);
            }
        })).booleanValue();
    }

    @Override // com.hihonor.hianalytics.hnha.x
    public boolean a(final boolean z) {
        return ((Boolean) u3.a(3, Boolean.FALSE, new q3() { // from class: com.hihonor.hianalytics.hnha.c0$$ExternalSyntheticLambda7
            @Override // com.hihonor.hianalytics.hnha.q3
            public final Object a() {
                return this.f$0.b(z);
            }
        })).booleanValue();
    }

    @Override // com.hihonor.hianalytics.hnha.x
    public Map<String, String> b(final String str) {
        return (Map) u3.a(3, new HashMap(), new q3() { // from class: com.hihonor.hianalytics.hnha.c0$$ExternalSyntheticLambda4
            @Override // com.hihonor.hianalytics.hnha.q3
            public final Object a() {
                return this.f$0.e(str);
            }
        });
    }

    @Override // com.hihonor.hianalytics.hnha.x
    public String c(final String str) {
        return (String) u3.a(3, null, new q3() { // from class: com.hihonor.hianalytics.hnha.c0$$ExternalSyntheticLambda5
            @Override // com.hihonor.hianalytics.hnha.q3
            public final Object a() {
                return this.f$0.f(str);
            }
        });
    }

    @Override // com.hihonor.hianalytics.hnha.x
    public boolean c() {
        return ((Boolean) u3.a(3, Boolean.FALSE, new q3() { // from class: com.hihonor.hianalytics.hnha.c0$$ExternalSyntheticLambda6
            @Override // com.hihonor.hianalytics.hnha.q3
            public final Object a() {
                return this.f$0.d();
            }
        })).booleanValue();
    }
}
