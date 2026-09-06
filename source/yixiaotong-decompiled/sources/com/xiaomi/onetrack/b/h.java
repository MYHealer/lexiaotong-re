package com.xiaomi.onetrack.b;

import android.content.ContentValues;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.xiaomi.onetrack.util.p;
import ijiami_1011.s.s.s;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9454a = s.d(new byte[]{117, 90, 15, 2, 8, 84, 37, 6, 43, 3, 95, 4, 81, 80, 19}, "65ada3");
    private static final int e = 100;
    private g b;
    private ConcurrentHashMap<String, l> c;
    private ConcurrentHashMap<String, Boolean> d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final h f9455a = new h(null);

        private a() {
        }
    }

    private h() {
        this.c = new ConcurrentHashMap<>();
        this.d = new ConcurrentHashMap<>();
        this.b = new g(com.xiaomi.onetrack.f.a.a());
    }

    public /* synthetic */ h(i iVar) {
        this();
    }

    public static h a() {
        return a.f9455a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(JSONObject jSONObject) {
        try {
            int iOptInt = jSONObject.optInt(s.d(new byte[]{75, 0, 92, 66, 10, 7}, "8a12fb"), 100);
            if (iOptInt < 0 || iOptInt > 100) {
                return 100;
            }
            return iOptInt;
        } catch (Exception e2) {
            p.a(f9454a, s.d(new byte[]{94, 82, 17, 116, 14, 85, 12, 11, 8, 49, 80, 8, 73, 91, 0, Ascii.ETB, 36, SignedBytes.MAX_POWER_OF_TWO, 2, 1, Ascii.SYN, Ascii.SYN, 88, 10, 87, 13}, "97e7a8") + e2.getMessage());
            return 100;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ArrayList<l> arrayList) throws Throwable {
        StringBuilder sb;
        String strD;
        String str;
        String str2;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                SQLiteDatabase writableDatabase = this.b.getWritableDatabase();
                try {
                    writableDatabase.beginTransaction();
                    String strD2 = s.d(new byte[]{0, Ascii.DC2, 66, 103, 81, 81, 92, 91}, "ab2885");
                    for (l lVar : arrayList) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(s.d(new byte[]{84, 72, 68, 106, 8, 82}, "5845a6"), lVar.f9459a);
                        contentValues.put(s.d(new byte[]{16, 95, 91, 80, 66, 65, 0, 9, Ascii.SYN}, "d66515"), Long.valueOf(lVar.c));
                        JSONObject jSONObject = lVar.e;
                        if (jSONObject != null) {
                            contentValues.put(s.d(new byte[]{91, 93, 13, 17, 86, 111, 5, 5, Ascii.DC2, 3}, "81bd20"), jSONObject.toString());
                        }
                        String str3 = lVar.d;
                        if (str3 != null) {
                            contentValues.put(s.d(new byte[]{0, 80, 66, 89, 58, 11, 0, Ascii.ETB, 14}, "d168ec"), str3);
                        }
                        if (DatabaseUtils.queryNumEntries(writableDatabase, s.d(new byte[]{0, Ascii.ETB, 7, 92, Ascii.SYN, 70, 62, 7, 10, 13, 68, 1}, "eab2b5"), strD2, new String[]{lVar.f9459a}) > 0) {
                            int iUpdate = writableDatabase.update(s.d(new byte[]{81, 68, 0, 92, 71, 67, 62, 7, 10, 13, 68, 1}, "42e230"), contentValues, strD2, new String[]{lVar.f9459a});
                            str2 = f9454a;
                            str = s.d(new byte[]{6, 4, 66, 5, 83, 2, Ascii.DC2, 1, 70, Ascii.ETB, 65, 1, 3, 17, 83, 0, Ascii.GS, 67, 19, 11, 17, 88, 17}, "be6d1c") + iUpdate;
                        } else {
                            long jInsert = writableDatabase.insert(s.d(new byte[]{81, 70, 0, 93, 66, SignedBytes.MAX_POWER_OF_TWO, 62, 7, 10, 13, 68, 1}, "40e363"), null, contentValues);
                            String str4 = f9454a;
                            str = s.d(new byte[]{2, 86, 65, 4, 6, 81, Ascii.DC2, 1, 70, 11, 95, Ascii.SYN, 3, 69, 65, 0, 0, Ascii.FS, 65, Ascii.SYN, 9, Ascii.NAK, 11, 69}, "f75ed0") + jInsert;
                            str2 = str4;
                        }
                        p.a(str2, str);
                        this.d.put(lVar.f9459a, Boolean.TRUE);
                    }
                    writableDatabase.setTransactionSuccessful();
                    try {
                        writableDatabase.endTransaction();
                    } catch (Exception e2) {
                        e = e2;
                        sb = new StringBuilder();
                        strD = s.d(new byte[]{117, 76, 85, 4, 67, SignedBytes.MAX_POWER_OF_TWO, 8, 11, 8, 66, 70, 13, 89, 88, 83, 65, 86, 90, 5, 48, Ascii.DC4, 3, 95, Ascii.SYN, 81, 87, 66, 8, 92, 90, 91}, "046a34");
                        p.b(f9454a, sb.append(strD).append(e).toString());
                    }
                } catch (Exception e3) {
                    e = e3;
                    sQLiteDatabase = writableDatabase;
                    p.b(f9454a, s.d(new byte[]{16, 72, 83, 80, Ascii.SYN, 84, 53, 11, 34, 0, 17, 0, Ascii.ETB, 74, 88, 67, 88, 17}, "e871b1"), e);
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (Exception e4) {
                            e = e4;
                            sb = new StringBuilder();
                            strD = s.d(new byte[]{114, 73, 5, 84, Ascii.DC4, 66, 8, 11, 8, 66, 70, 13, 94, 93, 3, 17, 1, 88, 5, 48, Ascii.DC4, 3, 95, Ascii.SYN, 86, 82, Ascii.DC2, 88, 11, 88, 91}, "71f1d6");
                            p.b(f9454a, sb.append(strD).append(e).toString());
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    sQLiteDatabase = writableDatabase;
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (Exception e5) {
                            p.b(f9454a, s.d(new byte[]{114, Ascii.GS, 5, 80, 72, 69, 8, 11, 8, 66, 70, 13, 94, 9, 3, Ascii.NAK, 93, 95, 5, 48, Ascii.DC4, 3, 95, Ascii.SYN, 86, 6, Ascii.DC2, 92, 87, 95, 91}, "7ef581") + e5);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            e = e6;
        }
    }

    private JSONObject c(String str, String str2) {
        JSONObject jSONObject;
        JSONArray jSONArrayOptJSONArray;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                if (this.c.get(str) == null || (this.d.containsKey(str) && this.d.get(str).booleanValue())) {
                    b(str);
                }
                l lVar = this.c.get(str);
                if (lVar != null && (jSONObject = lVar.e) != null && (jSONArrayOptJSONArray = jSONObject.optJSONArray(s.d(new byte[]{4, 70, 6, 95, 69, Ascii.SYN}, "a0c11e"))) != null) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                        if (TextUtils.equals(str2, jSONObject2.optString(s.d(new byte[]{81, 19, 1, 89, Ascii.NAK}, "4ed7a3")))) {
                            if (p.f9551a) {
                                p.a(f9454a, s.d(new byte[]{3, 0, Ascii.NAK, 112, Ascii.DC4, 83, 15, 16, 37, 13, 95, 3, 13, 2, 91}, "dea5b6") + jSONObject2.toString());
                            }
                            return jSONObject2;
                        }
                    }
                }
            } catch (Exception e2) {
                Log.e(f9454a, s.d(new byte[]{80, 86, 68, 35, 19, 84, 15, 16, 37, 13, 95, 3, 94, 84, 16, 3, Ascii.ETB, 67, 14, Ascii.SYN, 92, 66}, "730fe1") + e2.toString());
            }
        }
        return null;
    }

    public double a(String str, String str2, String str3, double d) {
        try {
            JSONObject jSONObjectC = c(str, str2);
            if (jSONObjectC != null) {
                return jSONObjectC.getDouble(str3);
            }
            p.a(f9454a, s.d(new byte[]{1, 14, 90, 95, 94, 95, 65, 10, 9, Ascii.SYN, 17, 4, Ascii.DC4, 0, 93, 85, 86, 90, 13, 1, 74, 66, 68, Ascii.SYN, 7, 65, 80, 92, 81, 89, Ascii.DC4, 8, Ascii.DC2, 66, 71, 4, 14, Ascii.DC4, 81}, "ba4978"));
            return d;
        } catch (Exception e2) {
            p.b(f9454a, s.d(new byte[]{84, 1, 16, 37, 87, 70, 3, 8, 3, 88, 17}, "3dda83") + e2.toString());
            return d;
        }
    }

    public int a(String str, String str2, String str3, int i) {
        try {
            JSONObject jSONObjectC = c(str, str2);
            if (jSONObjectC != null) {
                return jSONObjectC.getInt(str3);
            }
            p.a(f9454a, s.d(new byte[]{2, 86, 94, 83, 88, 95, 65, 10, 9, Ascii.SYN, 17, 4, Ascii.ETB, 88, 89, 89, 80, 90, 13, 1, 74, 66, 68, Ascii.SYN, 4, Ascii.EM, 84, 80, 87, 89, Ascii.DC4, 8, Ascii.DC2, 66, 71, 4, 13, 76, 85}, "a90518"));
            return i;
        } catch (Exception e2) {
            p.b(f9454a, s.d(new byte[]{95, 80, 77, 45, 15, 76, 91, 68}, "859da8") + e2.toString());
            return i;
        }
    }

    public long a(String str, String str2, String str3, long j) {
        try {
            JSONObject jSONObjectC = c(str, str2);
            if (jSONObjectC != null) {
                return jSONObjectC.getLong(str3);
            }
            p.a(f9454a, s.d(new byte[]{87, 95, 10, 84, 80, 84, 65, 10, 9, Ascii.SYN, 17, 4, 66, 81, 13, 94, 88, 81, 13, 1, 74, 66, 68, Ascii.SYN, 81, 16, 0, 87, 95, 82, Ascii.DC4, 8, Ascii.DC2, 66, 71, 4, 88, 69, 1}, "40d293"));
            return j;
        } catch (Exception e2) {
            p.b(f9454a, s.d(new byte[]{2, 82, Ascii.ETB, 125, 11, 10, 6, 94, 70}, "e7c1dd") + e2.toString());
            return j;
        }
    }

    public String a(String str, String str2, String str3, String str4) {
        try {
            JSONObject jSONObjectC = c(str, str2);
            if (jSONObjectC != null) {
                return jSONObjectC.getString(str3);
            }
            p.a(f9454a, s.d(new byte[]{0, 95, 92, 3, 15, 5, 65, 10, 9, Ascii.SYN, 17, 4, Ascii.NAK, 81, 91, 9, 7, 0, 13, 1, 74, 66, 68, Ascii.SYN, 6, 16, 86, 0, 0, 3, Ascii.DC4, 8, Ascii.DC2, 66, 71, 4, 15, 69, 87}, "c02efb"));
            return str4;
        } catch (Exception e2) {
            p.b(f9454a, s.d(new byte[]{4, 84, 77, 53, 16, 19, 8, 10, 1, 88, 17}, "c19fda") + e2.toString());
            return str4;
        }
    }

    public void a(String str) {
        FutureTask futureTask = new FutureTask(new j(this, str), null);
        com.xiaomi.onetrack.c.b.a(futureTask);
        try {
            futureTask.get();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(ArrayList<l> arrayList) {
        com.xiaomi.onetrack.c.b.a(new i(this, arrayList));
    }

    public boolean a(String str, String str2) {
        JSONObject jSONObject;
        try {
            l lVarF = f(str);
            if (lVarF == null || (jSONObject = lVarF.e) == null || !jSONObject.has(str2)) {
                return false;
            }
            return lVarF.e.optBoolean(str2);
        } catch (Exception e2) {
            p.b(f9454a, s.d(new byte[]{1, 80, 17, 117, 65, 73, 45, 1, 16, 7, 93, 39, 9, 90, 9, 81, 80, 87}, "f5e419") + e2.toString());
            return false;
        }
    }

    public boolean a(String str, String str2, String str3, boolean z) {
        try {
            JSONObject jSONObjectC = c(str, str2);
            if (jSONObjectC != null) {
                return jSONObjectC.getBoolean(str3);
            }
            p.a(f9454a, s.d(new byte[]{1, 12, 95, 80, 80, 80, 65, 10, 9, Ascii.SYN, 17, 4, Ascii.DC4, 2, 88, 90, 88, 85, 13, 1, 74, 66, 68, Ascii.SYN, 7, 67, 85, 83, 95, 86, Ascii.DC4, 8, Ascii.DC2, 66, 71, 4, 14, Ascii.SYN, 84}, "bc1697"));
            return z;
        } catch (Exception e2) {
            p.b(f9454a, s.d(new byte[]{5, 87, 17, 114, 87, 94, 13, 1, 7, 12, 11, 69}, "b2e081") + e2.toString());
            return z;
        }
    }

    public long b(String str, String str2) {
        l lVar;
        if (TextUtils.isEmpty(str)) {
            return 100L;
        }
        try {
            if (this.c.get(str) == null) {
                b(str);
            }
            if (this.c.get(str) != null) {
                int iA = a(str, str2, s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 89, 93, Ascii.SYN, 88, 84}, "380f41"), -1);
                if (iA != -1 || (lVar = this.c.get(str)) == null) {
                    p.a(f9454a, s.d(new byte[]{79, 90, 10, 90, 19, 70, 4, 16, 19, 16, 95, 69, 93, 69, 3, 88, 71, Ascii.DC4, Ascii.DC2, 5, 11, Ascii.DC2, 93, 0, Ascii.CAN}, "83f634") + iA);
                    return iA;
                }
                p.a(f9454a, s.d(new byte[]{78, 89, 90, 90, Ascii.DC4, 19, 4, 16, 19, 16, 95, 69, 90, 95, 91, 91, 91, 15, 65, Ascii.ETB, 7, 15, 65, 9, 92, 16}, "90664a") + lVar.b);
                return lVar.b;
            }
        } catch (Exception e2) {
            p.b(f9454a, s.d(new byte[]{6, 87, 76, 117, Ascii.SYN, 67, 36, Ascii.DC2, 3, 12, 69, 54, 0, 95, 72, 88, 3}, "a284f3") + e2.toString());
        }
        p.a(f9454a, s.d(new byte[]{70, 15, 91, 84, Ascii.EM, 67, 4, 16, 19, 16, 95, 69, 85, 3, 81, Ascii.CAN, 74, 80, 12, Ascii.DC4, 10, 7}, "1f7891"));
        return 100L;
    }

    public void b(String str) {
        FutureTask futureTask = new FutureTask(new k(this, str));
        com.xiaomi.onetrack.c.b.a(futureTask);
        try {
            l lVar = (l) futureTask.get(5L, TimeUnit.SECONDS);
            if (lVar != null) {
                this.c.put(str, lVar);
                this.d.put(str, Boolean.FALSE);
            }
        } catch (Exception e2) {
            p.b(f9454a, s.d(new byte[]{87, 0, 17, 38, 93, 90, 7, 13, 1, 66, 84, Ascii.ETB, 66, 10, Ascii.ETB, 95, Ascii.DC2}, "0eee24") + e2.toString());
        }
    }

    public String c(String str) {
        JSONObject jSONObject;
        l lVarF = f(str);
        return (lVarF == null || (jSONObject = lVarF.e) == null) ? "" : jSONObject.optString(s.d(new byte[]{4, 84, 15, 11, 86, 0, 49, 5, Ascii.DC4, 3, 92, Ascii.SYN}, "f5ae3d"));
    }

    public String d(String str) {
        l lVarF = f(str);
        return lVarF != null ? lVarF.d : "";
    }

    public int e(String str) {
        JSONObject jSONObject;
        l lVarF = f(str);
        if (lVarF == null || (jSONObject = lVarF.e) == null) {
            return 0;
        }
        return jSONObject.optInt(s.d(new byte[]{78, 83, 68, 65, 81, 9, 15}, "86628f"));
    }

    public l f(String str) {
        p.a(f9454a, s.d(new byte[]{82, 87, Ascii.NAK, 120, Ascii.SYN, 68, 34, 11, 8, 4, 88, 2, 113, 83, Ascii.NAK, 88, 70, 71, Ascii.NAK, 5, Ascii.DC4, Ascii.SYN, Ascii.GS, 69, 84, 66, 17, 112, 2, 14, 65}, "52a9f4") + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (this.c.get(str) == null || (this.d.containsKey(str) && this.d.get(str).booleanValue())) {
                b(str);
            }
        } catch (Exception e2) {
            p.b(f9454a, s.d(new byte[]{84, 85, 17, 115, 88, 90, 7, 13, 1, 66, 84, Ascii.ETB, 65, 95, Ascii.ETB, 10, Ascii.ETB}, "30e074") + e2.getMessage());
        }
        return this.c.get(str);
    }
}
