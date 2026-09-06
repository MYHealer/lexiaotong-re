package com.umeng.analytics.pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.stub.StubApp;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: UMStoreManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f9160a = 2049;
    public static final int b = 2050;
    private static final int c = 1000;
    private static Context d = null;
    private static String e = null;
    private static final String f = "umeng+";
    private static final String g = "ek__id";
    private static final String h = "ek_key";
    private List<String> i;
    private List<Integer> j;
    private String k;
    private List<String> l;

    /* JADX INFO: renamed from: com.umeng.analytics.pro.i$1, reason: invalid class name */
    /* JADX INFO: compiled from: UMStoreManager.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: UMStoreManager.java */
    public enum a {
        AUTOPAGE,
        PAGE,
        BEGIN,
        END,
        NEWSESSION,
        INSTANTSESSIONBEGIN
    }

    /* synthetic */ i(AnonymousClass1 anonymousClass1) {
        this();
    }

    /* JADX INFO: compiled from: UMStoreManager.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final i f9162a = new i(null);

        private b() {
        }
    }

    private i() {
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = null;
        this.l = new ArrayList();
    }

    public static i a(Context context) {
        i iVar = b.f9162a;
        if (d == null && context != null) {
            d = StubApp.getOrigApplicationContext(context.getApplicationContext());
            iVar.k();
        }
        return iVar;
    }

    private void k() {
        synchronized (this) {
            l();
            this.i.clear();
            this.l.clear();
            this.j.clear();
        }
    }

    private Cursor a(String str, SQLiteDatabase sQLiteDatabase, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        if (sQLiteDatabase == null) {
            return null;
        }
        try {
            if (sQLiteDatabase.isOpen()) {
                return sQLiteDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a() {
        this.i.clear();
    }

    public void b() {
        this.l.clear();
    }

    public boolean c() {
        return this.l.isEmpty();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x009a, code lost:
    
        if (r2 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x009c, code lost:
    
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ae, code lost:
    
        if (r2 != null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(JSONArray jSONArray) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseA = g.a(d).a();
                try {
                    sQLiteDatabaseA.beginTransaction();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            ContentValues contentValues = new ContentValues();
                            String strOptString = jSONObject.optString("__i");
                            if (TextUtils.isEmpty(strOptString) || "-1".equals(strOptString)) {
                                strOptString = u.a().b();
                                if (TextUtils.isEmpty(strOptString)) {
                                    strOptString = "-1";
                                }
                            }
                            contentValues.put("__i", strOptString);
                            contentValues.put("__e", jSONObject.optString("id"));
                            contentValues.put("__t", Integer.valueOf(jSONObject.optInt("__t")));
                            contentValues.put("__av", UMUtils.getAppVersionName(d));
                            contentValues.put("__vc", UMUtils.getAppVersionCode(d));
                            jSONObject.remove("__i");
                            jSONObject.remove("__t");
                            contentValues.put("__s", c(jSONObject.toString()));
                            sQLiteDatabaseA.insert(e.b.f9147a, null, contentValues);
                        } catch (Exception unused) {
                        }
                    }
                    sQLiteDatabaseA.setTransactionSuccessful();
                    if (sQLiteDatabaseA != null) {
                        sQLiteDatabaseA.endTransaction();
                    }
                } catch (SQLiteDatabaseCorruptException unused2) {
                    sQLiteDatabase = sQLiteDatabaseA;
                    try {
                        h.a(d);
                    } finally {
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.endTransaction();
                            } catch (Throwable unused3) {
                            }
                        }
                        g.a(d).b();
                    }
                } catch (Throwable unused4) {
                    sQLiteDatabase = sQLiteDatabaseA;
                }
            } catch (Throwable unused5) {
            }
        } catch (SQLiteDatabaseCorruptException unused6) {
        } catch (Throwable unused7) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0058, code lost:
    
        if (r0 != null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x005a, code lost:
    
        r0.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x006c, code lost:
    
        if (r0 != null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str, String str2, int i) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseA = g.a(d).a();
                try {
                    sQLiteDatabaseA.beginTransaction();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("__i", str);
                    String strC = c(str2);
                    if (!TextUtils.isEmpty(strC)) {
                        contentValues.put("__a", strC);
                        contentValues.put("__t", Integer.valueOf(i));
                        contentValues.put("__av", UMUtils.getAppVersionName(d));
                        contentValues.put("__vc", UMUtils.getAppVersionCode(d));
                        sQLiteDatabaseA.insert(e.a.f9144a, null, contentValues);
                    }
                    sQLiteDatabaseA.setTransactionSuccessful();
                    if (sQLiteDatabaseA != null) {
                        sQLiteDatabaseA.endTransaction();
                    }
                } catch (SQLiteDatabaseCorruptException unused) {
                    sQLiteDatabase = sQLiteDatabaseA;
                    try {
                        h.a(d);
                    } finally {
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.endTransaction();
                            } catch (Throwable unused2) {
                            }
                        }
                        g.a(d).b();
                    }
                } catch (Throwable unused3) {
                    sQLiteDatabase = sQLiteDatabaseA;
                }
            } catch (Throwable unused4) {
            }
        } catch (SQLiteDatabaseCorruptException unused5) {
        } catch (Throwable unused6) {
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0079 A[DONT_GENERATE, EXC_TOP_SPLITTER, PHI: r0
  0x0079: PHI (r0v6 android.database.sqlite.SQLiteDatabase) = 
  (r0v4 android.database.sqlite.SQLiteDatabase)
  (r0v5 android.database.sqlite.SQLiteDatabase)
  (r0v9 android.database.sqlite.SQLiteDatabase)
 binds: [B:16:0x0077, B:20:0x008b, B:14:0x0074] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public void d() {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            try {
                sQLiteDatabaseA = g.a(d).a();
                sQLiteDatabaseA.beginTransaction();
                String strC = u.a().c();
                if (!TextUtils.isEmpty(strC)) {
                    String[] strArr = {"", "-1"};
                    for (int i = 0; i < 2; i++) {
                        sQLiteDatabaseA.execSQL("update __et set __i=\"" + strC + "\" where __i=\"" + strArr[i] + "\"");
                    }
                    sQLiteDatabaseA.setTransactionSuccessful();
                    if (sQLiteDatabaseA != null) {
                    }
                } else {
                    if (sQLiteDatabaseA != null) {
                        try {
                            sQLiteDatabaseA.endTransaction();
                        } catch (Throwable unused) {
                        }
                    }
                    g.a(d).b();
                }
            } finally {
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused2) {
                    }
                }
                g.a(d).b();
            }
        } catch (SQLiteDatabaseCorruptException unused3) {
            h.a(d);
        } catch (Throwable unused4) {
            if (sQLiteDatabaseA != null) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0087, code lost:
    
        if (r2 != null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0089, code lost:
    
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009b, code lost:
    
        if (r2 != null) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str, JSONObject jSONObject, a aVar) {
        if (jSONObject == null) {
            return false;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseA = g.a(d).a();
                try {
                    sQLiteDatabaseA.beginTransaction();
                    if (aVar == a.BEGIN) {
                        long jLongValue = ((Long) jSONObject.opt("__e")).longValue();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("__ii", str);
                        contentValues.put("__e", String.valueOf(jLongValue));
                        contentValues.put("__av", UMUtils.getAppVersionName(d));
                        contentValues.put("__vc", UMUtils.getAppVersionCode(d));
                        sQLiteDatabaseA.insert(e.d.f9153a, null, contentValues);
                    } else if (aVar == a.INSTANTSESSIONBEGIN) {
                        b(str, jSONObject, sQLiteDatabaseA);
                    } else if (aVar == a.END) {
                        a(str, jSONObject, sQLiteDatabaseA);
                    } else if (aVar == a.PAGE) {
                        a(str, jSONObject, sQLiteDatabaseA, "__a");
                    } else if (aVar == a.AUTOPAGE) {
                        a(str, jSONObject, sQLiteDatabaseA, e.d.a.c);
                    } else if (aVar == a.NEWSESSION) {
                        c(str, jSONObject, sQLiteDatabaseA);
                    }
                    sQLiteDatabaseA.setTransactionSuccessful();
                    if (sQLiteDatabaseA != null) {
                        sQLiteDatabaseA.endTransaction();
                    }
                } catch (SQLiteDatabaseCorruptException unused) {
                    sQLiteDatabase = sQLiteDatabaseA;
                    try {
                        h.a(d);
                    } finally {
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.endTransaction();
                            } catch (Throwable unused2) {
                            }
                        }
                        g.a(d).b();
                    }
                } catch (Throwable unused3) {
                    sQLiteDatabase = sQLiteDatabaseA;
                }
            } catch (Throwable unused4) {
            }
        } catch (SQLiteDatabaseCorruptException unused5) {
        } catch (Throwable unused6) {
        }
        return false;
    }

    private void a(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long jLongValue = ((Long) jSONObject.opt(e.d.a.g)).longValue();
            Object objOpt = jSONObject.opt(e.d.a.h);
            long jLongValue2 = (objOpt == null || !(objOpt instanceof Long)) ? 0L : ((Long) objOpt).longValue();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("__pp");
            String strC = "";
            String strC2 = (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.length() <= 0) ? "" : c(jSONObjectOptJSONObject.toString());
            if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.length() > 0) {
                strC = c(jSONObjectOptJSONObject2.toString());
            }
            sQLiteDatabase.execSQL("update __sd set __f=\"" + jLongValue + "\", __g=\"" + jLongValue2 + "\", __sp=\"" + strC2 + "\", __pp=\"" + strC + "\" where __ii=\"" + str + "\"");
        } catch (Throwable unused) {
        }
    }

    private void b(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long jLongValue = ((Long) jSONObject.get("__e")).longValue();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("__pp");
            String strC = "";
            String strC2 = (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.length() <= 0) ? "" : c(jSONObjectOptJSONObject.toString());
            if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.length() > 0) {
                strC = c(jSONObjectOptJSONObject2.toString());
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("__ii", str);
            contentValues.put("__e", String.valueOf(jLongValue));
            contentValues.put("__sp", strC2);
            contentValues.put("__pp", strC);
            contentValues.put("__av", UMGlobalContext.getInstance(d).getAppVersion());
            contentValues.put("__vc", UMUtils.getAppVersionCode(d));
            sQLiteDatabase.insert(e.c.f9150a, null, contentValues);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x004a A[Catch: Exception -> 0x004d, TRY_LEAVE, TryCatch #1 {Exception -> 0x004d, blocks: (B:16:0x0045, B:18:0x004a), top: B:31:0x0045 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x005f A[Catch: Exception -> 0x0062, PHI: r2 r4
  0x005f: PHI (r2v3 long) = (r2v0 long), (r2v6 long) binds: [B:24:0x005d, B:9:0x003c] A[DONT_GENERATE, DONT_INLINE]
  0x005f: PHI (r4v4 android.database.sqlite.SQLiteDatabase) = (r4v3 android.database.sqlite.SQLiteDatabase), (r4v7 android.database.sqlite.SQLiteDatabase) binds: [B:24:0x005d, B:9:0x003c] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #4 {Exception -> 0x0062, blocks: (B:8:0x0039, B:25:0x005f, B:23:0x005a), top: B:33:0x0005 }] */
    public long a(String str) throws Throwable {
        SQLiteDatabase sQLiteDatabaseA;
        Cursor cursorA = null;
        long j = 0;
        try {
            try {
                sQLiteDatabaseA = g.a(d).a();
                try {
                    sQLiteDatabaseA.beginTransaction();
                    cursorA = a(e.d.f9153a, sQLiteDatabaseA, new String[]{e.d.a.g}, "__ii=? ", new String[]{str}, null, null, null, null);
                    if (cursorA != null) {
                        cursorA.moveToFirst();
                        j = cursorA.getLong(cursorA.getColumnIndex(e.d.a.g));
                    }
                    if (cursorA != null) {
                        cursorA.close();
                    }
                    if (sQLiteDatabaseA != null) {
                        sQLiteDatabaseA.endTransaction();
                    }
                } catch (Exception unused) {
                    if (cursorA != null) {
                        cursorA.close();
                    }
                    if (sQLiteDatabaseA != null) {
                        sQLiteDatabaseA.endTransaction();
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursorA != null) {
                        try {
                            cursorA.close();
                            if (sQLiteDatabaseA != null) {
                                sQLiteDatabaseA.endTransaction();
                            }
                        } catch (Exception unused2) {
                            g.a(d).b();
                            throw th;
                        }
                    } else if (sQLiteDatabaseA != null) {
                        sQLiteDatabaseA.endTransaction();
                    }
                    g.a(d).b();
                    throw th;
                }
            } catch (Exception unused3) {
            }
        } catch (Exception unused4) {
            sQLiteDatabaseA = null;
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabaseA = null;
        }
        g.a(d).b();
        return j;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x012c  */
    /* JADX WARN: Code duplicated, block: B:47:? A[RETURN, SYNTHETIC] */
    private void c(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        JSONObject jSONObject2;
        String str2;
        Cursor cursor2;
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(e.d.a.e);
            if (jSONObjectOptJSONObject != null) {
                jSONObject2 = jSONObjectOptJSONObject;
                Cursor cursorA = a(e.d.f9153a, sQLiteDatabase, new String[]{e.d.a.e}, "__ii=? ", new String[]{str}, null, null, null, null);
                if (cursorA != null) {
                    String strD = null;
                    while (cursorA.moveToNext()) {
                        try {
                            strD = d(cursorA.getString(cursorA.getColumnIndex(e.d.a.e)));
                        } catch (Throwable unused) {
                            cursor = cursorA;
                            if (cursor != null) {
                                cursor.close();
                                return;
                            }
                            return;
                        }
                    }
                    String str3 = strD;
                    cursor2 = cursorA;
                    str2 = str3;
                } else {
                    cursor2 = cursorA;
                    str2 = null;
                }
            } else {
                jSONObject2 = jSONObjectOptJSONObject;
                str2 = null;
                cursor2 = null;
            }
            if (jSONObject2 != null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONArray = new JSONArray(str2);
                    }
                    jSONArray.put(jSONObject2);
                    String strC = c(jSONArray.toString());
                    if (!TextUtils.isEmpty(strC)) {
                        sQLiteDatabase.execSQL("update  __sd set __d=\"" + strC + "\" where __ii=\"" + str + "\"");
                    }
                } catch (Throwable unused2) {
                    cursor = cursor2;
                    if (cursor != null) {
                        cursor.close();
                        return;
                    }
                    return;
                }
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(e.d.a.d);
            if (jSONObjectOptJSONObject2 != null) {
                String strC2 = c(jSONObjectOptJSONObject2.toString());
                if (!TextUtils.isEmpty(strC2)) {
                    sQLiteDatabase.execSQL("update  __sd set __c=\"" + strC2 + "\" where __ii=\"" + str + "\"");
                }
            }
            sQLiteDatabase.execSQL("update  __sd set __f=\"" + String.valueOf(jSONObject.optLong(e.d.a.g)) + "\" where __ii=\"" + str + "\"");
            if (cursor2 != null) {
                cursor2.close();
            }
        } catch (Throwable unused3) {
            cursor = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0055 A[Catch: all -> 0x0062, LOOP:1: B:54:0x004f->B:24:0x0055, LOOP_END, TryCatch #1 {all -> 0x0062, blocks: (B:22:0x004f, B:24:0x0055, B:26:0x0065, B:28:0x0070, B:29:0x0075, B:36:0x0084, B:38:0x008a, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:41:0x0093), top: B:54:0x004f }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0070 A[Catch: all -> 0x0062, TryCatch #1 {all -> 0x0062, blocks: (B:22:0x004f, B:24:0x0055, B:26:0x0065, B:28:0x0070, B:29:0x0075, B:36:0x0084, B:38:0x008a, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:41:0x0093), top: B:54:0x004f }] */
    /* JADX WARN: Code duplicated, block: B:32:0x007d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:33:0x007f  */
    /* JADX WARN: Code duplicated, block: B:35:0x0083  */
    /* JADX WARN: Code duplicated, block: B:40:0x0090 A[Catch: all -> 0x0062, TRY_ENTER, TryCatch #1 {all -> 0x0062, blocks: (B:22:0x004f, B:24:0x0055, B:26:0x0065, B:28:0x0070, B:29:0x0075, B:36:0x0084, B:38:0x008a, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:41:0x0093), top: B:54:0x004f }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00a4 A[Catch: all -> 0x0062, TRY_LEAVE, TryCatch #1 {all -> 0x0062, blocks: (B:22:0x004f, B:24:0x0055, B:26:0x0065, B:28:0x0070, B:29:0x0075, B:36:0x0084, B:38:0x008a, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:41:0x0093), top: B:54:0x004f }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:52:0x008a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x004f A[EXC_TOP_SPLITTER, LOOP:1: B:54:0x004f->B:24:0x0055, LOOP_START, PHI: r13
  0x004f: PHI (r13v2 java.lang.String) = (r13v7 java.lang.String), (r13v3 java.lang.String) binds: [B:21:0x004d, B:24:0x0055] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x0093 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:? A[RETURN, SYNTHETIC] */
    private void a(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase, String str2) throws JSONException {
        JSONArray jSONArray;
        JSONArray jSONArrayOptJSONArray;
        Cursor cursorA;
        JSONArray jSONArray2;
        int i;
        String strC;
        JSONObject jSONObject2;
        Cursor cursor = null;
        strD = null;
        String strD = null;
        try {
            if ("__a".equals(str2)) {
                jSONArrayOptJSONArray = jSONObject.optJSONArray("__a");
                if (jSONArrayOptJSONArray == null) {
                    return;
                }
                if (jSONArrayOptJSONArray.length() <= 0) {
                    return;
                }
            } else {
                if (e.d.a.c.equals(str2)) {
                    jSONArrayOptJSONArray = jSONObject.optJSONArray(e.d.a.c);
                    if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                        return;
                    }
                } else {
                    jSONArray = null;
                }
                cursorA = a(e.d.f9153a, sQLiteDatabase, new String[]{str2}, "__ii=? ", new String[]{str}, null, null, null, null);
                if (cursorA != null) {
                    while (cursorA.moveToNext()) {
                        try {
                            strD = d(cursorA.getString(cursorA.getColumnIndex(str2)));
                        } catch (Throwable unused) {
                            cursor = cursorA;
                            if (cursor != null) {
                                cursor.close();
                                return;
                            }
                            return;
                        }
                    }
                }
                jSONArray2 = new JSONArray();
                if (!TextUtils.isEmpty(strD)) {
                    jSONArray2 = new JSONArray(strD);
                }
                if (jSONArray2.length() > 1000) {
                    if (cursorA != null) {
                        cursorA.close();
                        return;
                    }
                    return;
                }
                for (i = 0; i < jSONArray.length(); i++) {
                    try {
                        jSONObject2 = jSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            jSONArray2.put(jSONObject2);
                        }
                    } catch (JSONException unused2) {
                    }
                }
                strC = c(jSONArray2.toString());
                if (!TextUtils.isEmpty(strC)) {
                    sQLiteDatabase.execSQL("update __sd set " + str2 + "=\"" + strC + "\" where __ii=\"" + str + "\"");
                }
                if (cursorA != null) {
                    cursorA.close();
                }
            }
            jSONArray = jSONArrayOptJSONArray;
            cursorA = a(e.d.f9153a, sQLiteDatabase, new String[]{str2}, "__ii=? ", new String[]{str}, null, null, null, null);
            if (cursorA != null) {
                while (cursorA.moveToNext()) {
                    strD = d(cursorA.getString(cursorA.getColumnIndex(str2)));
                }
            }
            jSONArray2 = new JSONArray();
            if (!TextUtils.isEmpty(strD)) {
                jSONArray2 = new JSONArray(strD);
            }
            if (jSONArray2.length() > 1000) {
                if (cursorA != null) {
                    cursorA.close();
                    return;
                }
                return;
            }
            while (i < jSONArray.length()) {
                jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2 != null) {
                    jSONArray2.put(jSONObject2);
                }
            }
            strC = c(jSONArray2.toString());
            if (!TextUtils.isEmpty(strC)) {
                sQLiteDatabase.execSQL("update __sd set " + str2 + "=\"" + strC + "\" where __ii=\"" + str + "\"");
            }
            if (cursorA != null) {
                cursorA.close();
            }
        } catch (Throwable unused3) {
        }
    }

    public boolean e() {
        return this.i.isEmpty();
    }

    public JSONObject a(boolean z) {
        a();
        this.j.clear();
        JSONObject jSONObject = new JSONObject();
        if (!z) {
            a(jSONObject, z);
            b(jSONObject, (String) null);
            a(jSONObject, (String) null);
        } else {
            String strA = a(jSONObject, z);
            if (!TextUtils.isEmpty(strA)) {
                b(jSONObject, strA);
                a(jSONObject, strA);
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Code duplicated, block: B:54:0x0085 A[DONT_GENERATE, EXC_TOP_SPLITTER, PHI: r2 r5
  0x0085: PHI (r2v5 android.database.sqlite.SQLiteDatabase) = (r2v4 android.database.sqlite.SQLiteDatabase), (r2v6 android.database.sqlite.SQLiteDatabase) binds: [B:28:0x0083, B:35:0x009f] A[DONT_GENERATE, DONT_INLINE]
  0x0085: PHI (r5v3 org.json.JSONObject) = (r5v2 org.json.JSONObject), (r5v5 org.json.JSONObject) binds: [B:28:0x0083, B:35:0x009f] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public JSONObject f() {
        SQLiteDatabase sQLiteDatabaseA;
        JSONObject jSONObject;
        Cursor cursor = null;
        jSONObject = null;
        jSONObject = null;
        jSONObject = null;
        JSONObject jSONObject2 = null;
        cursor = null;
        cursor = null;
        Cursor cursor2 = null;
        if (this.l.isEmpty()) {
            return null;
        }
        try {
            sQLiteDatabaseA = g.a(d).a();
            try {
                sQLiteDatabaseA.beginTransaction();
                Cursor cursorA = a(e.c.f9150a, sQLiteDatabaseA, null, "__ii=? ", new String[]{this.l.get(0)}, null, null, null, null);
                if (cursorA != null) {
                    try {
                        if (cursorA.moveToNext()) {
                            jSONObject = new JSONObject();
                            try {
                                String string = cursorA.getString(cursorA.getColumnIndex("__av"));
                                String string2 = cursorA.getString(cursorA.getColumnIndex("__vc"));
                                jSONObject.put("__av", string);
                                jSONObject.put("__vc", string2);
                                jSONObject2 = jSONObject;
                            } catch (SQLiteDatabaseCorruptException unused) {
                                cursor2 = cursorA;
                                try {
                                    h.a(d);
                                    return jSONObject;
                                } finally {
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    if (sQLiteDatabaseA != null) {
                                        try {
                                            sQLiteDatabaseA.endTransaction();
                                        } catch (Throwable unused2) {
                                        }
                                    }
                                    g.a(d).b();
                                }
                            } catch (Throwable unused3) {
                                cursor = cursorA;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (sQLiteDatabaseA != null) {
                                }
                                return jSONObject;
                            }
                        }
                    } catch (SQLiteDatabaseCorruptException unused4) {
                        jSONObject = jSONObject2;
                    } catch (Throwable unused5) {
                        jSONObject = jSONObject2;
                    }
                }
                sQLiteDatabaseA.setTransactionSuccessful();
                if (cursorA != null) {
                    cursorA.close();
                }
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused6) {
                    }
                }
                g.a(d).b();
                return jSONObject2;
            } catch (SQLiteDatabaseCorruptException unused7) {
                jSONObject = null;
            } catch (Throwable unused8) {
                jSONObject = null;
            }
        } catch (SQLiteDatabaseCorruptException unused9) {
            sQLiteDatabaseA = null;
            jSONObject = null;
        } catch (Throwable unused10) {
            sQLiteDatabaseA = null;
            jSONObject = null;
        }
    }

    public JSONObject b(boolean z) {
        JSONObject jSONObject = new JSONObject();
        b(jSONObject, z);
        return jSONObject;
    }

    private void a(JSONObject jSONObject, String str) {
        SQLiteDatabase sQLiteDatabaseA;
        Cursor cursorA = null;
        try {
            try {
                sQLiteDatabaseA = g.a(d).a();
                try {
                    sQLiteDatabaseA.beginTransaction();
                    cursorA = !TextUtils.isEmpty(str) ? a(e.b.f9147a, sQLiteDatabaseA, null, "__i=? ", new String[]{str}, null, null, null, null) : a(e.b.f9147a, sQLiteDatabaseA, null, null, null, null, null, null, null);
                    if (cursorA != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        JSONObject jSONObject3 = new JSONObject();
                        String strB = u.a().b();
                        while (cursorA.moveToNext()) {
                            int i = cursorA.getInt(cursorA.getColumnIndex("__t"));
                            String string = cursorA.getString(cursorA.getColumnIndex("__i"));
                            String string2 = cursorA.getString(cursorA.getColumnIndex("__s"));
                            if (TextUtils.isEmpty(string) || "-1".equals(string)) {
                                if (!TextUtils.isEmpty(strB)) {
                                    string = strB;
                                }
                            }
                            this.j.add(Integer.valueOf(cursorA.getInt(0)));
                            if (i != 2049) {
                                if (i == 2050 && !TextUtils.isEmpty(string2)) {
                                    JSONObject jSONObject4 = new JSONObject(d(string2));
                                    JSONArray jSONArrayOptJSONArray = jSONObject3.has(string) ? jSONObject3.optJSONArray(string) : new JSONArray();
                                    jSONArrayOptJSONArray.put(jSONObject4);
                                    jSONObject3.put(string, jSONArrayOptJSONArray);
                                }
                            } else if (!TextUtils.isEmpty(string2)) {
                                JSONObject jSONObject5 = new JSONObject(d(string2));
                                JSONArray jSONArrayOptJSONArray2 = jSONObject2.has(string) ? jSONObject2.optJSONArray(string) : new JSONArray();
                                jSONArrayOptJSONArray2.put(jSONObject5);
                                jSONObject2.put(string, jSONArrayOptJSONArray2);
                            }
                        }
                        if (jSONObject2.length() > 0) {
                            JSONArray jSONArray = new JSONArray();
                            Iterator<String> itKeys = jSONObject2.keys();
                            while (itKeys.hasNext()) {
                                JSONObject jSONObject6 = new JSONObject();
                                String next = itKeys.next();
                                jSONObject6.put(next, new JSONArray(jSONObject2.optString(next)));
                                if (jSONObject6.length() > 0) {
                                    jSONArray.put(jSONObject6);
                                }
                            }
                            if (jSONArray.length() > 0) {
                                jSONObject.put("ekv", jSONArray);
                            }
                        }
                        if (jSONObject3.length() > 0) {
                            JSONArray jSONArray2 = new JSONArray();
                            Iterator<String> itKeys2 = jSONObject3.keys();
                            while (itKeys2.hasNext()) {
                                JSONObject jSONObject7 = new JSONObject();
                                String next2 = itKeys2.next();
                                jSONObject7.put(next2, new JSONArray(jSONObject3.optString(next2)));
                                if (jSONObject7.length() > 0) {
                                    jSONArray2.put(jSONObject7);
                                }
                            }
                            if (jSONArray2.length() > 0) {
                                jSONObject.put(d.T, jSONArray2);
                            }
                        }
                    }
                    sQLiteDatabaseA.setTransactionSuccessful();
                    if (cursorA != null) {
                        cursorA.close();
                    }
                    if (sQLiteDatabaseA != null) {
                        try {
                            sQLiteDatabaseA.endTransaction();
                        } catch (Throwable unused) {
                        }
                    }
                } catch (SQLiteDatabaseCorruptException unused2) {
                    h.a(d);
                    if (cursorA != null) {
                        cursorA.close();
                    }
                    if (sQLiteDatabaseA != null) {
                    }
                    g.a(d).b();
                } catch (Throwable unused3) {
                    h.a(d);
                    if (cursorA != null) {
                        cursorA.close();
                    }
                    if (sQLiteDatabaseA != null) {
                    }
                    g.a(d).b();
                }
            } catch (Throwable th) {
                if (cursorA != null) {
                    cursorA.close();
                }
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused4) {
                    }
                }
                g.a(d).b();
                throw th;
            }
        } catch (SQLiteDatabaseCorruptException unused5) {
            sQLiteDatabaseA = null;
        } catch (Throwable unused6) {
            sQLiteDatabaseA = null;
        }
        g.a(d).b();
    }

    private void b(JSONObject jSONObject, String str) {
        SQLiteDatabase sQLiteDatabaseA;
        Cursor cursorA = null;
        try {
            try {
                sQLiteDatabaseA = g.a(d).a();
                try {
                    sQLiteDatabaseA.beginTransaction();
                    cursorA = !TextUtils.isEmpty(str) ? a(e.a.f9144a, sQLiteDatabaseA, null, "__i=? ", new String[]{str}, null, null, null, null) : a(e.a.f9144a, sQLiteDatabaseA, null, null, null, null, null, null, null);
                    if (cursorA != null) {
                        JSONArray jSONArray = new JSONArray();
                        while (cursorA.moveToNext()) {
                            String string = cursorA.getString(cursorA.getColumnIndex("__a"));
                            if (!TextUtils.isEmpty(string)) {
                                jSONArray.put(new JSONObject(d(string)));
                            }
                        }
                        if (jSONArray.length() > 0) {
                            jSONObject.put("error", jSONArray);
                        }
                    }
                    sQLiteDatabaseA.setTransactionSuccessful();
                    if (cursorA != null) {
                        cursorA.close();
                    }
                    if (sQLiteDatabaseA != null) {
                        try {
                            sQLiteDatabaseA.endTransaction();
                        } catch (Throwable unused) {
                        }
                    }
                } catch (SQLiteDatabaseCorruptException unused2) {
                    h.a(d);
                    if (cursorA != null) {
                        cursorA.close();
                    }
                    if (sQLiteDatabaseA != null) {
                    }
                    g.a(d).b();
                } catch (Throwable unused3) {
                    h.a(d);
                    if (cursorA != null) {
                        cursorA.close();
                    }
                    if (sQLiteDatabaseA != null) {
                    }
                    g.a(d).b();
                }
            } catch (Throwable th) {
                if (cursorA != null) {
                    cursorA.close();
                }
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused4) {
                    }
                }
                g.a(d).b();
                throw th;
            }
        } catch (SQLiteDatabaseCorruptException unused5) {
            sQLiteDatabaseA = null;
        } catch (Throwable unused6) {
            sQLiteDatabaseA = null;
        }
        g.a(d).b();
    }

    /* JADX WARN: Code duplicated, block: B:54:0x0085 A[DONT_GENERATE, EXC_TOP_SPLITTER, PHI: r2 r5
  0x0085: PHI (r2v5 android.database.sqlite.SQLiteDatabase) = (r2v4 android.database.sqlite.SQLiteDatabase), (r2v6 android.database.sqlite.SQLiteDatabase) binds: [B:28:0x0083, B:35:0x009f] A[DONT_GENERATE, DONT_INLINE]
  0x0085: PHI (r5v3 org.json.JSONObject) = (r5v2 org.json.JSONObject), (r5v5 org.json.JSONObject) binds: [B:28:0x0083, B:35:0x009f] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public JSONObject g() {
        SQLiteDatabase sQLiteDatabaseA;
        JSONObject jSONObject;
        Cursor cursor = null;
        jSONObject = null;
        jSONObject = null;
        jSONObject = null;
        JSONObject jSONObject2 = null;
        cursor = null;
        cursor = null;
        Cursor cursor2 = null;
        if (this.i.isEmpty()) {
            return null;
        }
        try {
            sQLiteDatabaseA = g.a(d).a();
            try {
                sQLiteDatabaseA.beginTransaction();
                Cursor cursorA = a(e.d.f9153a, sQLiteDatabaseA, null, "__ii=? ", new String[]{this.i.get(0)}, null, null, null, null);
                if (cursorA != null) {
                    try {
                        if (cursorA.moveToNext()) {
                            jSONObject = new JSONObject();
                            try {
                                String string = cursorA.getString(cursorA.getColumnIndex("__av"));
                                String string2 = cursorA.getString(cursorA.getColumnIndex("__vc"));
                                jSONObject.put("__av", string);
                                jSONObject.put("__vc", string2);
                                jSONObject2 = jSONObject;
                            } catch (SQLiteDatabaseCorruptException unused) {
                                cursor2 = cursorA;
                                try {
                                    h.a(d);
                                    return jSONObject;
                                } finally {
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    if (sQLiteDatabaseA != null) {
                                        try {
                                            sQLiteDatabaseA.endTransaction();
                                        } catch (Throwable unused2) {
                                        }
                                    }
                                    g.a(d).b();
                                }
                            } catch (Throwable unused3) {
                                cursor = cursorA;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (sQLiteDatabaseA != null) {
                                }
                                return jSONObject;
                            }
                        }
                    } catch (SQLiteDatabaseCorruptException unused4) {
                        jSONObject = jSONObject2;
                    } catch (Throwable unused5) {
                        jSONObject = jSONObject2;
                    }
                }
                sQLiteDatabaseA.setTransactionSuccessful();
                if (cursorA != null) {
                    cursorA.close();
                }
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused6) {
                    }
                }
                g.a(d).b();
                return jSONObject2;
            } catch (SQLiteDatabaseCorruptException unused7) {
                jSONObject = null;
            } catch (Throwable unused8) {
                jSONObject = null;
            }
        } catch (SQLiteDatabaseCorruptException unused9) {
            sQLiteDatabaseA = null;
            jSONObject = null;
        } catch (Throwable unused10) {
            sQLiteDatabaseA = null;
            jSONObject = null;
        }
    }

    private JSONArray b(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optLong("duration") > 0) {
                jSONArray2.put(jSONObjectOptJSONObject);
            }
        }
        return jSONArray2;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0231  */
    /* JADX WARN: Code duplicated, block: B:128:0x0236 A[EXC_TOP_SPLITTER, PHI: r0 r12 r14
  0x0236: PHI (r0v5 java.lang.String) = (r0v2 java.lang.String), (r0v3 java.lang.String), (r0v39 java.lang.String) binds: [B:95:0x0225, B:101:0x0234, B:87:0x0212] A[DONT_GENERATE, DONT_INLINE]
  0x0236: PHI (r12v6 android.database.sqlite.SQLiteDatabase) = 
  (r12v3 android.database.sqlite.SQLiteDatabase)
  (r12v4 android.database.sqlite.SQLiteDatabase)
  (r12v7 android.database.sqlite.SQLiteDatabase)
 binds: [B:95:0x0225, B:101:0x0234, B:87:0x0212] A[DONT_GENERATE, DONT_INLINE]
  0x0236: PHI (r14v6 android.database.Cursor) = (r14v3 android.database.Cursor), (r14v4 android.database.Cursor), (r14v33 android.database.Cursor) binds: [B:95:0x0225, B:101:0x0234, B:87:0x0212] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x0222  */
    private String a(JSONObject jSONObject, boolean z) {
        SQLiteDatabase sQLiteDatabaseA;
        Cursor cursorA;
        JSONArray jSONArray;
        String str;
        String string = null;
        try {
            try {
                sQLiteDatabaseA = g.a(d).a();
                try {
                    sQLiteDatabaseA.beginTransaction();
                    cursorA = a(e.d.f9153a, sQLiteDatabaseA, null, null, null, null, null, null, null);
                    if (cursorA != null) {
                        try {
                            JSONArray jSONArray2 = new JSONArray();
                            while (true) {
                                if (!cursorA.moveToNext()) {
                                    cursorA = cursorA;
                                    jSONArray = jSONArray2;
                                    break;
                                }
                                JSONObject jSONObject2 = new JSONObject();
                                String string2 = cursorA.getString(cursorA.getColumnIndex(e.d.a.g));
                                String string3 = cursorA.getString(cursorA.getColumnIndex("__e"));
                                String string4 = cursorA.getString(cursorA.getColumnIndex(e.d.a.h));
                                string = cursorA.getString(cursorA.getColumnIndex("__ii"));
                                try {
                                    if (TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
                                        str = string;
                                        cursorA = cursorA;
                                        jSONArray = jSONArray2;
                                    } else {
                                        if (Long.parseLong(string2) - Long.parseLong(string3) > 0) {
                                            String string5 = cursorA.getString(cursorA.getColumnIndex("__a"));
                                            String string6 = cursorA.getString(cursorA.getColumnIndex(e.d.a.c));
                                            String string7 = cursorA.getString(cursorA.getColumnIndex(e.d.a.d));
                                            String string8 = cursorA.getString(cursorA.getColumnIndex(e.d.a.e));
                                            this.i.add(string);
                                            String string9 = cursorA.getString(cursorA.getColumnIndex("__sp"));
                                            String string10 = cursorA.getString(cursorA.getColumnIndex("__pp"));
                                            jSONObject2.put("id", string);
                                            jSONObject2.put(d.p, string3);
                                            jSONObject2.put(d.q, string2);
                                            str = string;
                                            if (FieldManager.allow(com.umeng.commonsdk.utils.b.E)) {
                                                try {
                                                    if (Long.parseLong(string4) <= 0) {
                                                        jSONObject2.put("duration", Long.parseLong(string2) - Long.parseLong(string3));
                                                    } else {
                                                        jSONObject2.put("duration", Long.parseLong(string4));
                                                        jSONObject2.put(d.s, Long.parseLong(string2) - Long.parseLong(string3));
                                                    }
                                                } catch (SQLiteDatabaseCorruptException unused) {
                                                    cursorA = cursorA;
                                                    string = str;
                                                    h.a(d);
                                                    if (cursorA != null) {
                                                        cursorA.close();
                                                    }
                                                    if (sQLiteDatabaseA != null) {
                                                        try {
                                                            sQLiteDatabaseA.endTransaction();
                                                        } catch (Throwable unused2) {
                                                        }
                                                    }
                                                    g.a(d).b();
                                                    return string;
                                                } catch (Throwable unused3) {
                                                    cursorA = cursorA;
                                                    string = str;
                                                    h.a(d);
                                                    if (cursorA != null) {
                                                        cursorA.close();
                                                    }
                                                    if (sQLiteDatabaseA != null) {
                                                        sQLiteDatabaseA.endTransaction();
                                                    }
                                                    g.a(d).b();
                                                    return string;
                                                }
                                            } else {
                                                jSONObject2.put("duration", Long.parseLong(string2) - Long.parseLong(string3));
                                            }
                                            try {
                                                if (!TextUtils.isEmpty(string5)) {
                                                    jSONObject2.put(d.t, new JSONArray(d(string5)));
                                                }
                                                boolean z2 = UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO;
                                                if (!TextUtils.isEmpty(string6) && z2) {
                                                    JSONArray jSONArray3 = new JSONArray(d(string6));
                                                    JSONArray jSONArray4 = new JSONArray();
                                                    if (jSONArray3.length() > 0) {
                                                        jSONArray4 = b(jSONArray3);
                                                    }
                                                    jSONObject2.put(d.u, jSONArray4);
                                                }
                                                if (!TextUtils.isEmpty(string7)) {
                                                    jSONObject2.put(d.F, new JSONObject(d(string7)));
                                                }
                                                if (!TextUtils.isEmpty(string8)) {
                                                    jSONObject2.put(d.B, new JSONArray(d(string8)));
                                                }
                                                if (!TextUtils.isEmpty(string9)) {
                                                    jSONObject2.put(d.au, new JSONObject(d(string9)));
                                                }
                                                if (!TextUtils.isEmpty(string10)) {
                                                    jSONObject2.put(d.av, new JSONObject(d(string10)));
                                                }
                                                if (jSONObject2.length() > 0) {
                                                    jSONArray = jSONArray2;
                                                    jSONArray.put(jSONObject2);
                                                } else {
                                                    jSONArray = jSONArray2;
                                                }
                                            } catch (SQLiteDatabaseCorruptException unused4) {
                                                string = str;
                                                h.a(d);
                                                if (cursorA != null) {
                                                    cursorA.close();
                                                }
                                                if (sQLiteDatabaseA != null) {
                                                }
                                                g.a(d).b();
                                                return string;
                                            } catch (Throwable unused5) {
                                                string = str;
                                                h.a(d);
                                                if (cursorA != null) {
                                                    cursorA.close();
                                                }
                                                if (sQLiteDatabaseA != null) {
                                                }
                                                g.a(d).b();
                                                return string;
                                            }
                                        } else {
                                            str = string;
                                            cursorA = cursorA;
                                            jSONArray = jSONArray2;
                                        }
                                        if (z) {
                                            string = str;
                                            break;
                                        }
                                    }
                                    jSONArray2 = jSONArray;
                                    cursorA = cursorA;
                                    string = str;
                                } catch (SQLiteDatabaseCorruptException unused6) {
                                    cursorA = cursorA;
                                    h.a(d);
                                    if (cursorA != null) {
                                        cursorA.close();
                                    }
                                    if (sQLiteDatabaseA != null) {
                                        sQLiteDatabaseA.endTransaction();
                                    }
                                    g.a(d).b();
                                    return string;
                                } catch (Throwable unused7) {
                                    cursorA = cursorA;
                                    h.a(d);
                                    if (cursorA != null) {
                                        cursorA.close();
                                    }
                                    if (sQLiteDatabaseA != null) {
                                        sQLiteDatabaseA.endTransaction();
                                    }
                                    g.a(d).b();
                                    return string;
                                }
                            }
                            try {
                                if (this.i.size() < 1) {
                                    if (cursorA != null) {
                                        cursorA.close();
                                    }
                                    if (sQLiteDatabaseA != null) {
                                        try {
                                            sQLiteDatabaseA.endTransaction();
                                        } catch (Throwable unused8) {
                                        }
                                    }
                                    g.a(d).b();
                                    return string;
                                }
                                if (jSONArray.length() > 0) {
                                    jSONObject.put(d.n, jSONArray);
                                }
                            } catch (SQLiteDatabaseCorruptException unused9) {
                                h.a(d);
                                if (cursorA != null) {
                                    cursorA.close();
                                }
                                if (sQLiteDatabaseA != null) {
                                }
                                g.a(d).b();
                                return string;
                            } catch (Throwable unused10) {
                                h.a(d);
                                if (cursorA != null) {
                                    cursorA.close();
                                }
                                if (sQLiteDatabaseA != null) {
                                }
                                g.a(d).b();
                                return string;
                            }
                        } catch (SQLiteDatabaseCorruptException unused11) {
                        } catch (Throwable unused12) {
                        }
                    } else {
                        cursorA = cursorA;
                    }
                    sQLiteDatabaseA.setTransactionSuccessful();
                    if (cursorA != null) {
                        cursorA.close();
                    }
                    if (sQLiteDatabaseA != null) {
                        sQLiteDatabaseA.endTransaction();
                    }
                } catch (SQLiteDatabaseCorruptException unused13) {
                    cursorA = null;
                } catch (Throwable unused14) {
                    cursorA = null;
                }
            } catch (Throwable th) {
                if (cursorA != null) {
                    cursorA.close();
                }
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused15) {
                    }
                }
                g.a(d).b();
                throw th;
            }
        } catch (SQLiteDatabaseCorruptException unused16) {
            sQLiteDatabaseA = null;
            cursorA = null;
        } catch (Throwable unused17) {
            sQLiteDatabaseA = null;
            cursorA = null;
        }
        g.a(d).b();
        return string;
    }

    /* JADX WARN: Code duplicated, block: B:65:0x00e8 A[EXC_TOP_SPLITTER, PHI: r1 r13
  0x00e8: PHI (r1v4 android.database.sqlite.SQLiteDatabase) = (r1v3 android.database.sqlite.SQLiteDatabase), (r1v6 android.database.sqlite.SQLiteDatabase) binds: [B:38:0x00d7, B:44:0x00e6] A[DONT_GENERATE, DONT_INLINE]
  0x00e8: PHI (r13v5 ??) = (r13v4 ??), (r13v7 ??) binds: [B:38:0x00d7, B:44:0x00e6] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r13v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9 */
    private String b(JSONObject jSONObject, boolean z) {
        ?? r13;
        SQLiteDatabase sQLiteDatabaseA;
        ?? r0 = 0;
        String string = null;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        cursor = null;
        cursor = null;
        Cursor cursor = null;
        Cursor cursor2 = null;
        try {
            try {
                sQLiteDatabaseA = g.a(d).a();
                try {
                    sQLiteDatabaseA.beginTransaction();
                    Cursor cursorA = a(e.c.f9150a, sQLiteDatabaseA, null, null, null, null, null, null, null);
                    if (cursorA != null) {
                        try {
                            JSONArray jSONArray = new JSONArray();
                            while (cursorA.moveToNext()) {
                                JSONObject jSONObject2 = new JSONObject();
                                String string2 = cursorA.getString(cursorA.getColumnIndex("__e"));
                                string = cursorA.getString(cursorA.getColumnIndex("__ii"));
                                this.l.add(string);
                                String string3 = cursorA.getString(cursorA.getColumnIndex("__sp"));
                                String string4 = cursorA.getString(cursorA.getColumnIndex("__pp"));
                                if (!TextUtils.isEmpty(string3)) {
                                    jSONObject2.put(d.au, new JSONObject(d(string3)));
                                }
                                if (!TextUtils.isEmpty(string4)) {
                                    jSONObject2.put(d.av, new JSONObject(d(string4)));
                                }
                                if (!TextUtils.isEmpty(string2)) {
                                    jSONObject2.put("id", string);
                                    jSONObject2.put(d.p, string2);
                                    if (jSONObject2.length() > 0) {
                                        jSONArray.put(jSONObject2);
                                    }
                                    if (z) {
                                        break;
                                    }
                                }
                            }
                            r0 = string;
                            if (jSONArray.length() > 0) {
                                jSONObject.put(d.n, jSONArray);
                                r0 = string;
                            }
                        } catch (SQLiteDatabaseCorruptException unused) {
                            r13 = r0;
                            cursor = cursorA;
                            h.a(d);
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (sQLiteDatabaseA != null) {
                                try {
                                    sQLiteDatabaseA.endTransaction();
                                } catch (Throwable unused2) {
                                }
                            }
                            g.a(d).b();
                            r0 = r13;
                        } catch (Throwable unused3) {
                            r13 = r0;
                            cursor2 = cursorA;
                            h.a(d);
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            if (sQLiteDatabaseA != null) {
                                sQLiteDatabaseA.endTransaction();
                            }
                            g.a(d).b();
                            r0 = r13;
                        }
                    }
                    sQLiteDatabaseA.setTransactionSuccessful();
                    if (cursorA != null) {
                        cursorA.close();
                    }
                    if (sQLiteDatabaseA != null) {
                        try {
                            sQLiteDatabaseA.endTransaction();
                        } catch (Throwable unused4) {
                        }
                    }
                    g.a(d).b();
                } catch (SQLiteDatabaseCorruptException unused5) {
                    r13 = 0;
                } catch (Throwable unused6) {
                    r13 = 0;
                }
            } catch (Throwable th) {
                if (r0 != 0) {
                    r0.close();
                }
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused7) {
                    }
                }
                g.a(d).b();
                throw th;
            }
        } catch (SQLiteDatabaseCorruptException unused8) {
            r13 = 0;
            sQLiteDatabaseA = null;
        } catch (Throwable unused9) {
            r13 = 0;
            sQLiteDatabaseA = null;
        }
        return r0;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x006a A[DONT_GENERATE, EXC_TOP_SPLITTER, PHI: r0
  0x006a: PHI (r0v4 android.database.sqlite.SQLiteDatabase) = 
  (r0v1 android.database.sqlite.SQLiteDatabase)
  (r0v2 android.database.sqlite.SQLiteDatabase)
  (r0v5 android.database.sqlite.SQLiteDatabase)
 binds: [B:24:0x0068, B:22:0x0062, B:18:0x0058] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public void a(boolean z, boolean z2) {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            sQLiteDatabaseA = g.a(d).a();
            sQLiteDatabaseA.beginTransaction();
            if (!z2) {
                int size = this.l.size();
                if (size > 0) {
                    boolean z3 = false;
                    for (int i = 0; i < size; i++) {
                        String str = this.l.get(i);
                        if (str == null) {
                            z3 = true;
                        }
                        sQLiteDatabaseA.execSQL("delete from __is where __ii=\"" + str + "\"");
                    }
                    if (z3) {
                        sQLiteDatabaseA.execSQL("delete from __is where __ii is null");
                    }
                }
            } else if (z) {
                sQLiteDatabaseA.execSQL("delete from __is");
            }
            sQLiteDatabaseA.setTransactionSuccessful();
        } catch (SQLiteDatabaseCorruptException unused) {
            h.a(d);
        } catch (Throwable unused2) {
            h.a(d);
        } finally {
            if (sQLiteDatabaseA != null) {
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Throwable unused3) {
                }
            }
            g.a(d).b();
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0058 A[DONT_GENERATE, EXC_TOP_SPLITTER, PHI: r0
  0x0058: PHI (r0v4 android.database.sqlite.SQLiteDatabase) = 
  (r0v2 android.database.sqlite.SQLiteDatabase)
  (r0v3 android.database.sqlite.SQLiteDatabase)
  (r0v5 android.database.sqlite.SQLiteDatabase)
 binds: [B:16:0x0056, B:20:0x006a, B:14:0x0053] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public void b(boolean z, boolean z2) {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            try {
                sQLiteDatabaseA = g.a(d).a();
                sQLiteDatabaseA.beginTransaction();
                if (z2) {
                    if (z) {
                        sQLiteDatabaseA.execSQL("delete from __sd");
                    }
                } else if (this.i.size() > 0) {
                    for (int i = 0; i < this.i.size(); i++) {
                        sQLiteDatabaseA.execSQL("delete from __sd where __ii=\"" + this.i.get(i) + "\"");
                    }
                }
                sQLiteDatabaseA.setTransactionSuccessful();
                if (sQLiteDatabaseA != null) {
                }
            } finally {
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                g.a(d).b();
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            h.a(d);
        } catch (Throwable unused3) {
            if (sQLiteDatabaseA != null) {
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x004b A[DONT_GENERATE, EXC_TOP_SPLITTER, PHI: r0
  0x004b: PHI (r0v6 android.database.sqlite.SQLiteDatabase) = 
  (r0v4 android.database.sqlite.SQLiteDatabase)
  (r0v5 android.database.sqlite.SQLiteDatabase)
  (r0v9 android.database.sqlite.SQLiteDatabase)
 binds: [B:12:0x0049, B:16:0x005d, B:10:0x0046] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public void h() {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            try {
                sQLiteDatabaseA = g.a(d).a();
                sQLiteDatabaseA.beginTransaction();
                if (this.j.size() > 0) {
                    for (int i = 0; i < this.j.size(); i++) {
                        sQLiteDatabaseA.execSQL("delete from __et where rowid=" + this.j.get(i));
                    }
                }
                this.j.clear();
                sQLiteDatabaseA.setTransactionSuccessful();
                if (sQLiteDatabaseA != null) {
                }
            } finally {
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                g.a(d).b();
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            h.a(d);
        } catch (Throwable unused3) {
            if (sQLiteDatabaseA != null) {
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x001b A[DONT_GENERATE, EXC_TOP_SPLITTER, PHI: r0
  0x001b: PHI (r0v6 android.database.sqlite.SQLiteDatabase) = 
  (r0v4 android.database.sqlite.SQLiteDatabase)
  (r0v5 android.database.sqlite.SQLiteDatabase)
  (r0v9 android.database.sqlite.SQLiteDatabase)
 binds: [B:6:0x0019, B:10:0x002d, B:4:0x0016] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public void i() {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            try {
                sQLiteDatabaseA = g.a(d).a();
                sQLiteDatabaseA.beginTransaction();
                sQLiteDatabaseA.execSQL("delete from __er");
                sQLiteDatabaseA.setTransactionSuccessful();
                if (sQLiteDatabaseA != null) {
                }
            } finally {
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                g.a(d).b();
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            h.a(d);
        } catch (Throwable unused3) {
            if (sQLiteDatabaseA != null) {
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0051 A[EXC_TOP_SPLITTER, PHI: r3
  0x0051: PHI (r3v6 android.database.sqlite.SQLiteDatabase) = 
  (r3v4 android.database.sqlite.SQLiteDatabase)
  (r3v5 android.database.sqlite.SQLiteDatabase)
  (r3v9 android.database.sqlite.SQLiteDatabase)
 binds: [B:9:0x004f, B:14:0x0064, B:6:0x004b] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public void j() {
        SQLiteDatabase sQLiteDatabaseA;
        if (!TextUtils.isEmpty(this.k)) {
            try {
                sQLiteDatabaseA = g.a(d).a();
                try {
                    sQLiteDatabaseA.beginTransaction();
                    sQLiteDatabaseA.execSQL("delete from __er where __i=\"" + this.k + "\"");
                    sQLiteDatabaseA.execSQL("delete from __et where __i=\"" + this.k + "\"");
                    sQLiteDatabaseA.setTransactionSuccessful();
                    if (sQLiteDatabaseA != null) {
                        try {
                            sQLiteDatabaseA.endTransaction();
                        } catch (Throwable unused) {
                        }
                    }
                } catch (SQLiteDatabaseCorruptException unused2) {
                    try {
                        h.a(d);
                        if (sQLiteDatabaseA != null) {
                            sQLiteDatabaseA.endTransaction();
                        }
                    } catch (Throwable th) {
                        if (sQLiteDatabaseA != null) {
                            try {
                                sQLiteDatabaseA.endTransaction();
                            } catch (Throwable unused3) {
                            }
                        }
                        g.a(d).b();
                        throw th;
                    }
                } catch (Throwable unused4) {
                    if (sQLiteDatabaseA != null) {
                        sQLiteDatabaseA.endTransaction();
                    }
                }
            } catch (SQLiteDatabaseCorruptException unused5) {
                sQLiteDatabaseA = null;
            } catch (Throwable unused6) {
                sQLiteDatabaseA = null;
            }
            g.a(d).b();
        }
        this.k = null;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0065 A[DONT_GENERATE, EXC_TOP_SPLITTER, PHI: r3
  0x0065: PHI (r3v4 android.database.sqlite.SQLiteDatabase) = 
  (r3v2 android.database.sqlite.SQLiteDatabase)
  (r3v3 android.database.sqlite.SQLiteDatabase)
  (r3v5 android.database.sqlite.SQLiteDatabase)
 binds: [B:9:0x0063, B:13:0x0077, B:7:0x0060] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public void a(boolean z, String str) {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            try {
                sQLiteDatabaseA = g.a(d).a();
                sQLiteDatabaseA.beginTransaction();
                if (!TextUtils.isEmpty(str)) {
                    sQLiteDatabaseA.execSQL("delete from __er where __i=\"" + str + "\"");
                    sQLiteDatabaseA.execSQL("delete from __et where __i=\"" + str + "\"");
                    this.j.clear();
                    sQLiteDatabaseA.execSQL("delete from __sd where __ii=\"" + str + "\"");
                }
                sQLiteDatabaseA.setTransactionSuccessful();
                if (sQLiteDatabaseA != null) {
                }
            } finally {
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                g.a(d).b();
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            h.a(d);
        } catch (Throwable unused3) {
            if (sQLiteDatabaseA != null) {
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0034 A[DONT_GENERATE, EXC_TOP_SPLITTER, PHI: r1
  0x0034: PHI (r1v4 android.database.sqlite.SQLiteDatabase) = 
  (r1v2 android.database.sqlite.SQLiteDatabase)
  (r1v3 android.database.sqlite.SQLiteDatabase)
  (r1v5 android.database.sqlite.SQLiteDatabase)
 binds: [B:9:0x0032, B:13:0x0046, B:7:0x002f] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public void b(String str) {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            try {
                sQLiteDatabaseA = g.a(d).a();
                sQLiteDatabaseA.beginTransaction();
                if (!TextUtils.isEmpty(str)) {
                    sQLiteDatabaseA.execSQL("delete from __is where __ii=\"" + str + "\"");
                }
                sQLiteDatabaseA.setTransactionSuccessful();
                if (sQLiteDatabaseA != null) {
                }
            } finally {
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                g.a(d).b();
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            h.a(d);
        } catch (Throwable unused3) {
            if (sQLiteDatabaseA != null) {
            }
        }
    }

    private void l() {
        try {
            if (TextUtils.isEmpty(e)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(d, g);
                if (TextUtils.isEmpty(multiProcessSP)) {
                    multiProcessSP = PreferenceWrapper.getDefault(d).getString(g, null);
                    if (TextUtils.isEmpty(multiProcessSP)) {
                        multiProcessSP = UMUtils.genId();
                    }
                    if (!TextUtils.isEmpty(multiProcessSP)) {
                        UMUtils.setMultiProcessSP(d, g, multiProcessSP);
                    }
                }
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    String strSubstring = multiProcessSP.substring(1, 9);
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < strSubstring.length(); i++) {
                        char cCharAt = strSubstring.charAt(i);
                        if (Character.isDigit(cCharAt)) {
                            if (Integer.parseInt(Character.toString(cCharAt)) == 0) {
                                sb.append(0);
                            } else {
                                sb.append(10 - Integer.parseInt(Character.toString(cCharAt)));
                            }
                        } else {
                            sb.append(cCharAt);
                        }
                    }
                    e = sb.toString();
                }
                if (TextUtils.isEmpty(e)) {
                    return;
                }
                e += new StringBuilder(e).reverse().toString();
                String multiProcessSP2 = UMUtils.getMultiProcessSP(d, h);
                if (TextUtils.isEmpty(multiProcessSP2)) {
                    UMUtils.setMultiProcessSP(d, h, c(f));
                } else {
                    if (f.equals(d(multiProcessSP2))) {
                        return;
                    }
                    b(true, false);
                    a(true, false);
                    h();
                    i();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public String c(String str) {
        try {
            return TextUtils.isEmpty(e) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), e.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }

    public String d(String str) {
        try {
            return TextUtils.isEmpty(e) ? str : new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), e.getBytes()));
        } catch (Exception unused) {
            if (Build.VERSION.SDK_INT >= 29 && !TextUtils.isEmpty(str)) {
                try {
                    new JSONObject(str);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> UMStoreManager decrypt failed, return origin data.");
                    return str;
                } catch (Throwable unused2) {
                    return null;
                }
            }
            return null;
        }
    }
}
