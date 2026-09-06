package com.byazt.tv;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.byazt.yv.u;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 239, 13})
public class tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.byazt.tv.c[] f2759a;
    public static final int[] c = {1};
    public static final HashMap<String, com.byazt.tv.c> tt = new HashMap<>();
    public static final C0285tt[] ve;
    public final c n;
    public String sp;
    public final com.byazt.lu.uj uj;

    private String c(String str, boolean z) {
        return "SELECT * FROM page WHERE session_id" + (z ? "='" : "!='") + str + "' ORDER BY " + (z ? "session_id," : "") + "duration DESC LIMIT 500";
    }

    private String tt(String str, boolean z) {
        return "DELETE FROM page WHERE session_id" + (z ? "='" : "!='") + str + "'";
    }

    private String c(com.byazt.tv.c cVar, String str, boolean z, int i, int i2) {
        return "SELECT * FROM " + cVar.uj() + " WHERE session_id" + (z ? "='" : "!='") + str + "' AND event_type='" + i2 + "' ORDER BY _id LIMIT " + i;
    }

    private String c(String str, int i, String str2, boolean z, long j) {
        return "DELETE FROM " + str + " WHERE session_id" + (z ? "='" : "!='") + str2 + "' AND event_type='" + i + "' AND _id<=" + j;
    }

    private String c(long j, int i) {
        return "UPDATE pack SET _fail=" + i + " WHERE _id=" + j;
    }

    public tt(com.byazt.lu.uj ujVar) {
        this.n = new c(ujVar.getContext(), "bd_embed_tea_agent.db", null, 30);
        this.uj = ujVar;
    }

    private static void c(com.byazt.tv.c cVar) {
        tt.put(cVar.uj(), cVar);
    }

    /* JADX INFO: renamed from: com.byazt.tv.tt$tt, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 239, 240})
    static class C0285tt {
        public String c;
        public int tt;
        public int ve;

        /* JADX INFO: Access modifiers changed from: private */
        public static void tt() {
            for (C0285tt c0285tt : tt.ve) {
                c0285tt.c = "";
                c0285tt.tt = 0;
                c0285tt.ve = 0;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.byazt.tv.c cVar) {
            String strI = cVar.i();
            if (strI == null || strI.length() <= this.tt) {
                return;
            }
            this.c = cVar.x();
            this.tt = strI.length();
        }

        public String toString() {
            return new StringBuilder(this.ve).append(com.huawei.openalliance.ad.constant.x.A).append(this.c).append(com.huawei.openalliance.ad.constant.x.A).append(this.tt).toString();
        }
    }

    private boolean c(String str) {
        com.byazt.yv.da.c("needLaunch, " + this.sp + ", " + str);
        if (TextUtils.equals(str, this.sp)) {
            return false;
        }
        this.sp = str;
        return true;
    }

    static {
        c(new i());
        c(new a(true));
        c(new da());
        c(new x());
        com.byazt.tv.c[] cVarArr = {new ve(), new n(null, false, null), new uj("", new JSONObject())};
        f2759a = cVarArr;
        for (int i = 0; i < 3; i++) {
            c(cVarArr[i]);
        }
        ve = new C0285tt[]{new C0285tt(), new C0285tt(), new C0285tt()};
    }

    /* JADX WARN: Code duplicated, block: B:108:0x0164 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public synchronized ArrayList<x> c(JSONObject jSONObject) {
        ArrayList<x> arrayList;
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase2;
        JSONObject jSONObject2;
        SQLiteDatabase sQLiteDatabase3;
        HashMap<String, com.byazt.tv.c> map = tt;
        a aVar = (a) map.get("launch");
        da daVar = (da) map.get("terminate");
        i iVar = (i) map.get("page");
        x xVar = (x) map.get("pack");
        arrayList = new ArrayList<>();
        Cursor cursor2 = null;
        try {
            JSONArray[] jSONArrayArr = new JSONArray[3];
            long[] jArr = new long[3];
            SQLiteDatabase writableDatabase = this.n.getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                Cursor cursorRawQuery = writableDatabase.rawQuery("SELECT * FROM launch ORDER BY _id LIMIT 5", null);
                try {
                    com.byazt.lu.sp spVarA = this.uj.a();
                    String strC = spVarA.c();
                    boolean zTt = spVarA.tt();
                    JSONObject jSONObject3 = jSONObject;
                    long j = Long.MIN_VALUE;
                    long j2 = Long.MAX_VALUE;
                    while (cursorRawQuery.moveToNext()) {
                        try {
                            aVar.c(cursorRawQuery);
                            xVar.uj = aVar.uj;
                            JSONObject jSONObjectC = c(aVar, jSONObject);
                            if (TextUtils.equals(aVar.uj, strC)) {
                                try {
                                    aVar.yp = !zTt;
                                    jSONObject2 = jSONObjectC;
                                    cursor = cursorRawQuery;
                                    sQLiteDatabase3 = writableDatabase;
                                    try {
                                        c(jSONObjectC, aVar, xVar, writableDatabase, jSONArrayArr, jArr, arrayList);
                                    } catch (Throwable th) {
                                        th = th;
                                        cursor2 = cursor;
                                        sQLiteDatabase = sQLiteDatabase3;
                                        try {
                                            com.byazt.yv.da.tt(th);
                                            if (cursor2 != null) {
                                                try {
                                                    cursor2.close();
                                                } catch (Throwable th2) {
                                                    com.byazt.yv.da.tt(th2);
                                                }
                                            }
                                            u.c(sQLiteDatabase);
                                            return arrayList;
                                        } catch (Throwable th3) {
                                            if (cursor2 != null) {
                                                try {
                                                    cursor2.close();
                                                } catch (Throwable th4) {
                                                    com.byazt.yv.da.tt(th4);
                                                }
                                            }
                                            u.c(sQLiteDatabase);
                                            throw th3;
                                        }
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    cursor = cursorRawQuery;
                                    sQLiteDatabase3 = writableDatabase;
                                }
                            } else {
                                jSONObject2 = jSONObjectC;
                                cursor = cursorRawQuery;
                                sQLiteDatabase3 = writableDatabase;
                                try {
                                    if (aVar.c < j2) {
                                        j2 = aVar.c;
                                    }
                                    if (aVar.c > j) {
                                        j = aVar.c;
                                    }
                                    c(jSONObject2, aVar, xVar, iVar, daVar, sQLiteDatabase3, jSONArrayArr, jArr);
                                } catch (Throwable th6) {
                                    th = th6;
                                    sQLiteDatabase = sQLiteDatabase3;
                                    cursor2 = cursor;
                                    com.byazt.yv.da.tt(th);
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    u.c(sQLiteDatabase);
                                    return arrayList;
                                }
                            }
                            JSONObject jSONObject4 = jSONObject2;
                            sQLiteDatabase = sQLiteDatabase3;
                            try {
                                c(jSONObject4, true, xVar, sQLiteDatabase);
                                jSONObject3 = jSONObject4;
                                writableDatabase = sQLiteDatabase;
                                strC = strC;
                                cursorRawQuery = cursor;
                                jArr = jArr;
                            } catch (Throwable th7) {
                                th = th7;
                                cursor2 = cursor;
                                com.byazt.yv.da.tt(th);
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                u.c(sQLiteDatabase);
                                return arrayList;
                            }
                        } catch (Throwable th8) {
                            th = th8;
                            cursor = cursorRawQuery;
                            sQLiteDatabase = writableDatabase;
                        }
                    }
                    String str = strC;
                    cursor = cursorRawQuery;
                    long[] jArr2 = jArr;
                    sQLiteDatabase = writableDatabase;
                    if (j2 != Long.MAX_VALUE && j != Long.MIN_VALUE) {
                        sQLiteDatabase.execSQL("DELETE FROM launch WHERE _id>=? AND _id<=?", new String[]{String.valueOf(j2), String.valueOf(j)});
                    }
                    try {
                        if (cursor.getCount() >= 5 || TextUtils.isEmpty(str)) {
                            sQLiteDatabase2 = sQLiteDatabase;
                        } else {
                            JSONObject jSONObject5 = jSONObject3;
                            sQLiteDatabase2 = sQLiteDatabase;
                            try {
                                c(jSONObject3, aVar, daVar, iVar, xVar, sQLiteDatabase, str, jSONArrayArr, jArr2);
                                c(jSONObject5, false, xVar, sQLiteDatabase2);
                            } catch (Throwable th9) {
                                th = th9;
                                sQLiteDatabase = sQLiteDatabase2;
                                cursor2 = cursor;
                                com.byazt.yv.da.tt(th);
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                u.c(sQLiteDatabase);
                            }
                        }
                        sQLiteDatabase2.setTransactionSuccessful();
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Throwable th10) {
                                com.byazt.yv.da.tt(th10);
                            }
                        }
                        u.c(sQLiteDatabase2);
                    } catch (Throwable th11) {
                        th = th11;
                        cursor2 = cursor;
                        com.byazt.yv.da.tt(th);
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        u.c(sQLiteDatabase);
                    }
                } catch (Throwable th12) {
                    th = th12;
                    cursor = cursorRawQuery;
                    sQLiteDatabase2 = writableDatabase;
                }
            } catch (Throwable th13) {
                th = th13;
                sQLiteDatabase = writableDatabase;
            }
        } catch (Throwable th14) {
            th = th14;
            sQLiteDatabase = null;
        }
        return arrayList;
    }

    private void c(JSONObject jSONObject, boolean z, x xVar, SQLiteDatabase sQLiteDatabase) {
        for (int i : c) {
            JSONArray[] jSONArrayArr = new JSONArray[3];
            long[] jArr = new long[3];
            int iC = c(0, sQLiteDatabase, xVar.uj, z, i, jSONArrayArr, jArr);
            if (c(jArr)) {
                int i2 = iC;
                while (true) {
                    xVar.c(jSONObject, null, null, null, jSONArrayArr, jArr, i);
                    c(xVar, z, sQLiteDatabase, true);
                    int iC2 = i2;
                    while (true) {
                        if (iC2 < f2759a.length) {
                            iC2 = c(iC2, sQLiteDatabase, xVar.uj, z, i, jSONArrayArr, jArr);
                            if (c(jArr)) {
                                i2 = iC2;
                            }
                        }
                    }
                }
            }
        }
    }

    private JSONObject c(a aVar, JSONObject jSONObject) {
        if (TextUtils.equals(aVar.u, this.uj.uj().ve()) && aVar.t == this.uj.uj().tt()) {
            return jSONObject;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            u.ve(jSONObject2, jSONObject);
            jSONObject2.put("app_version", aVar.u);
            jSONObject2.put("version_code", aVar.t);
            return jSONObject2;
        } catch (JSONException e) {
            com.byazt.yv.da.tt(e);
            return jSONObject;
        }
    }

    private void c(JSONObject jSONObject, a aVar, x xVar, SQLiteDatabase sQLiteDatabase, JSONArray[] jSONArrayArr, long[] jArr, ArrayList<x> arrayList) {
        SQLiteDatabase sQLiteDatabase2;
        tt ttVar;
        x xVar2;
        int iC;
        com.byazt.yv.da.c("packCurrentData, " + aVar.uj);
        boolean zC = c(aVar.uj);
        int iC2 = c(0, sQLiteDatabase, aVar.uj, true, 0, jSONArrayArr, jArr);
        if (zC || c(jArr)) {
            xVar.c(jSONObject, zC ? aVar : null, null, null, jSONArrayArr, jArr, 0);
            if (iC2 >= f2759a.length) {
                x xVar3 = (x) xVar.clone();
                xVar3.da();
                arrayList.add(xVar3);
                sQLiteDatabase2 = sQLiteDatabase;
                iC = iC2;
                ttVar = this;
                xVar2 = xVar;
            } else {
                sQLiteDatabase2 = sQLiteDatabase;
                ttVar = this;
                xVar2 = xVar;
                ttVar.c(xVar2, true, sQLiteDatabase2, true);
                iC = iC2;
            }
        } else {
            sQLiteDatabase2 = sQLiteDatabase;
            iC = iC2;
            ttVar = this;
            xVar2 = xVar;
        }
        while (iC < f2759a.length) {
            iC = ttVar.c(iC, sQLiteDatabase2, aVar.uj, true, 0, jSONArrayArr, r2);
            if (ttVar.c(r2)) {
                xVar2.c(jSONObject, ttVar.c(aVar.uj) ? aVar : null, null, null, jSONArrayArr, jArr, 0);
                ttVar.c(xVar2, true, sQLiteDatabase2, true);
                iC = iC;
            }
        }
    }

    private void c(JSONObject jSONObject, a aVar, x xVar, i iVar, da daVar, SQLiteDatabase sQLiteDatabase, JSONArray[] jSONArrayArr, long[] jArr) {
        com.byazt.yv.da.c("packHistoryData, " + aVar.uj);
        JSONArray jSONArrayC = c(aVar, true, daVar, iVar, sQLiteDatabase);
        boolean z = true;
        aVar.yp = jSONArrayC.length() == 0;
        int iC = c(0, sQLiteDatabase, aVar.uj, true, 0, jSONArrayArr, jArr);
        if (aVar.yp) {
            xVar.c(jSONObject, c(aVar.uj) ? aVar : null, null, null, jSONArrayArr, jArr, 0);
        } else {
            xVar.c(jSONObject, null, daVar, jSONArrayC, jSONArrayArr, jArr, 0);
        }
        while (true) {
            c(xVar, z, sQLiteDatabase, z);
            int iC2 = iC;
            while (iC2 < f2759a.length) {
                boolean z2 = z;
                iC2 = c(iC2, sQLiteDatabase, aVar.uj, true, 0, jSONArrayArr, jArr);
                if (c(jArr)) {
                    xVar.c(jSONObject, null, null, null, jSONArrayArr, jArr, 0);
                    iC = iC2;
                    z = z2;
                } else {
                    z = z2;
                }
            }
            return;
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:30:0x00d1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:? A[LOOP:0: B:22:0x00b0->B:32:?, LOOP_END, SYNTHETIC] */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private void c(org.json.JSONObject r17, com.byazt.tv.a r18, com.byazt.tv.da r19, com.byazt.tv.i r20, com.byazt.tv.x r21, android.database.sqlite.SQLiteDatabase r22, java.lang.String r23, org.json.JSONArray[] r24, long[] r25) {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.byazt.tv.tt.c(org.json.JSONObject, com.byazt.tv.a, com.byazt.tv.da, com.byazt.tv.i, com.byazt.tv.x, android.database.sqlite.SQLiteDatabase, java.lang.String, org.json.JSONArray[], long[]):void");
    }

    private boolean c(long[] jArr) {
        return jArr[0] > 0 || jArr[1] > 0 || jArr[2] > 0;
    }

    public void c(x xVar, boolean z, SQLiteDatabase sQLiteDatabase, boolean z2) {
        boolean z3;
        if (sQLiteDatabase == null) {
            sQLiteDatabase = this.n.getWritableDatabase();
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            try {
                sQLiteDatabase.beginTransaction();
            } catch (Throwable th) {
                try {
                    com.byazt.yv.da.tt(th);
                    if (z3) {
                        return;
                    } else {
                        return;
                    }
                } finally {
                    if (z3) {
                        u.c(sQLiteDatabase);
                    }
                }
            }
        }
        if (z2 && sQLiteDatabase.insert("pack", null, xVar.tt((ContentValues) null)) < 0) {
            if (xVar.my != null) {
                c((String) null);
            }
            if (z3) {
                u.c(sQLiteDatabase);
                return;
            }
            return;
        }
        if (xVar.m > 0) {
            sQLiteDatabase.execSQL(c(NotificationCompat.CATEGORY_EVENT, xVar.da, xVar.uj, z, xVar.m));
        }
        if (xVar.rh > 0) {
            sQLiteDatabase.execSQL(c("eventv3", xVar.da, xVar.uj, z, xVar.rh));
        }
        if (xVar.rl > 0) {
            sQLiteDatabase.execSQL(c("event_misc", xVar.da, xVar.uj, z, xVar.rl));
        }
        if (z3) {
            sQLiteDatabase.setTransactionSuccessful();
        }
        if (z3) {
            u.c(sQLiteDatabase);
        }
    }

    private int c(int i, SQLiteDatabase sQLiteDatabase, String str, boolean z, int i2, JSONArray[] jSONArrayArr, long[] jArr) {
        C0285tt.tt();
        int i3 = 0;
        while (i3 < i) {
            jSONArrayArr[i3] = null;
            jArr[i3] = 0;
            i3++;
        }
        int i4 = i3;
        int i5 = 200;
        while (i5 > 0 && i4 < f2759a.length) {
            c(sQLiteDatabase, str, i5, i4, z, jSONArrayArr, jArr, i2);
            int length = jSONArrayArr[i4].length();
            i5 -= length;
            ve[i4].ve = length;
            if (i5 > 0) {
                i4++;
            }
        }
        for (int i6 = i4 + 1; i6 < jSONArrayArr.length; i6++) {
            jSONArrayArr[i6] = null;
            jArr[i6] = 0;
        }
        return i4;
    }

    private void c(SQLiteDatabase sQLiteDatabase, String str, int i, int i2, boolean z, JSONArray[] jSONArrayArr, long[] jArr, int i3) {
        com.byazt.tv.c cVar = f2759a[i2];
        JSONArray jSONArray = new JSONArray();
        Cursor cursor = null;
        long j = 0;
        try {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery(c(cVar, str, z, i, i3), null);
            for (int i4 = 0; cursorRawQuery.moveToNext() && i4 <= 200; i4++) {
                try {
                    cVar.c(cursorRawQuery);
                    ve[i2].c(cVar);
                    if (com.byazt.yv.da.tt) {
                        com.byazt.yv.da.c("queryEvent, " + cVar, null);
                    }
                    jSONArray.put(cVar.a());
                    if (cVar.c > j) {
                        j = cVar.c;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorRawQuery;
                    try {
                        com.byazt.yv.da.tt(th);
                        if (cursor != null) {
                            cursor.close();
                        }
                    } catch (Throwable th2) {
                        if (cursor == null) {
                            throw th2;
                        }
                        cursor.close();
                        throw th2;
                    }
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (Throwable th3) {
            th = th3;
        }
        jSONArrayArr[i2] = jSONArray;
        jArr[i2] = j;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00e0 A[PHI: r12 r15 r17 r18
  0x00e0: PHI (r12v2 android.database.Cursor) = (r12v3 android.database.Cursor), (r12v6 android.database.Cursor) binds: [B:46:0x00de, B:36:0x00ca] A[DONT_GENERATE, DONT_INLINE]
  0x00e0: PHI (r15v2 long) = (r15v3 long), (r15v5 long) binds: [B:46:0x00de, B:36:0x00ca] A[DONT_GENERATE, DONT_INLINE]
  0x00e0: PHI (r17v3 java.lang.String) = (r17v4 java.lang.String), (r17v7 java.lang.String) binds: [B:46:0x00de, B:36:0x00ca] A[DONT_GENERATE, DONT_INLINE]
  0x00e0: PHI (r18v2 java.lang.String) = (r18v3 java.lang.String), (r18v5 java.lang.String) binds: [B:46:0x00de, B:36:0x00ca] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:50:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:52:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:55:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:56:0x0101  */
    /* JADX WARN: Code duplicated, block: B:59:0x0134  */
    /* JADX WARN: Code duplicated, block: B:60:0x0139  */
    /* JADX WARN: Code duplicated, block: B:62:0x013f  */
    private JSONArray c(a aVar, boolean z, da daVar, i iVar, SQLiteDatabase sQLiteDatabase) {
        Cursor cursorRawQuery;
        String str;
        String str2;
        long j;
        String str3;
        String str4;
        long j2;
        JSONArray jSONArray = new JSONArray();
        try {
            cursorRawQuery = sQLiteDatabase.rawQuery(c(aVar.uj, z), null);
            try {
                HashMap map = new HashMap(8);
                boolean z2 = false;
                str = null;
                str2 = null;
                j = 0;
                while (cursorRawQuery.moveToNext()) {
                    try {
                        iVar.c(cursorRawQuery);
                        if (com.byazt.yv.da.tt) {
                            com.byazt.yv.da.c("queryPage, " + iVar, null);
                        }
                        Integer num = (Integer) map.get(iVar.yp);
                        z2 = true;
                        if (!iVar.da()) {
                            map.put(iVar.yp, Integer.valueOf(num != null ? num.intValue() + 1 : 1));
                            j = iVar.t >= 1000 ? j + iVar.t : j + 1000;
                            jSONArray.put(iVar.a());
                            if (TextUtils.isEmpty(iVar.gt)) {
                                continue;
                            } else {
                                String str5 = iVar.gt;
                                try {
                                    str = str5;
                                    str2 = iVar.f2757a;
                                } catch (Throwable th) {
                                    th = th;
                                    str = str5;
                                    try {
                                        com.byazt.yv.da.tt(th);
                                        if (cursorRawQuery != null) {
                                            cursorRawQuery.close();
                                        }
                                        str3 = str;
                                        str4 = str2;
                                        if (jSONArray.length() > 0) {
                                            j2 = j > 1000 ? j : 1000L;
                                            daVar.t = j2;
                                            if (z) {
                                                daVar.uj = aVar.uj;
                                                daVar.c(aVar.tt + j2);
                                            } else {
                                                daVar.uj = UUID.randomUUID().toString();
                                                daVar.c(0L);
                                            }
                                            daVar.n = aVar.n;
                                            daVar.f2757a = aVar.f2757a;
                                            daVar.sp = aVar.sp;
                                            daVar.x = aVar.x;
                                            daVar.u = daVar.tt;
                                            daVar.ve = com.byazt.lu.sp.uj();
                                            daVar.yp = null;
                                            if (!TextUtils.isEmpty(aVar.z)) {
                                                daVar.yp = aVar.z;
                                            } else if (!TextUtils.isEmpty(str3)) {
                                                daVar.yp = str3;
                                                daVar.f2757a = str4;
                                            }
                                        }
                                        return jSONArray;
                                    } catch (Throwable th2) {
                                        if (cursorRawQuery == null) {
                                            throw th2;
                                        }
                                        cursorRawQuery.close();
                                        throw th2;
                                    }
                                }
                            }
                        } else if (num != null) {
                            Integer numValueOf = Integer.valueOf(num.intValue() - 1);
                            if (numValueOf.intValue() > 0) {
                                map.put(iVar.yp, numValueOf);
                            } else {
                                map.remove(iVar.yp);
                            }
                        } else {
                            iVar.t = 1000L;
                            j += iVar.t;
                            jSONArray.put(iVar.a());
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                if (z2) {
                    sQLiteDatabase.execSQL(tt(aVar.uj, z));
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            } catch (Throwable th4) {
                th = th4;
                str = null;
                str2 = str;
                j = 0;
                com.byazt.yv.da.tt(th);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                str3 = str;
                str4 = str2;
                if (jSONArray.length() > 0) {
                    if (j > 1000) {
                    }
                    daVar.t = j2;
                    if (z) {
                        daVar.uj = aVar.uj;
                        daVar.c(aVar.tt + j2);
                    } else {
                        daVar.uj = UUID.randomUUID().toString();
                        daVar.c(0L);
                    }
                    daVar.n = aVar.n;
                    daVar.f2757a = aVar.f2757a;
                    daVar.sp = aVar.sp;
                    daVar.x = aVar.x;
                    daVar.u = daVar.tt;
                    daVar.ve = com.byazt.lu.sp.uj();
                    daVar.yp = null;
                    if (!TextUtils.isEmpty(aVar.z)) {
                        daVar.yp = aVar.z;
                    } else if (!TextUtils.isEmpty(str3)) {
                        daVar.yp = str3;
                        daVar.f2757a = str4;
                    }
                }
                return jSONArray;
            }
        } catch (Throwable th5) {
            th = th5;
            cursorRawQuery = null;
            str = null;
        }
        str3 = str;
        str4 = str2;
        if (jSONArray.length() > 0) {
            if (j > 1000) {
            }
            daVar.t = j2;
            if (z) {
                daVar.uj = aVar.uj;
                daVar.c(aVar.tt + j2);
            } else {
                daVar.uj = UUID.randomUUID().toString();
                daVar.c(0L);
            }
            daVar.n = aVar.n;
            daVar.f2757a = aVar.f2757a;
            daVar.sp = aVar.sp;
            daVar.x = aVar.x;
            daVar.u = daVar.tt;
            daVar.ve = com.byazt.lu.sp.uj();
            daVar.yp = null;
            if (!TextUtils.isEmpty(aVar.z)) {
                daVar.yp = aVar.z;
            } else if (!TextUtils.isEmpty(str3)) {
                daVar.yp = str3;
                daVar.f2757a = str4;
            }
        }
        return jSONArray;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003b A[PHI: r3
  0x003b: PHI (r3v2 android.database.Cursor) = (r3v1 android.database.Cursor), (r3v6 android.database.Cursor) binds: [B:15:0x0039, B:8:0x002f] A[DONT_GENERATE, DONT_INLINE]] */
    public ArrayList<x> c() {
        Cursor cursorRawQuery;
        ArrayList<x> arrayList = new ArrayList<>();
        x xVar = (x) tt.get("pack");
        try {
            cursorRawQuery = this.n.getWritableDatabase().rawQuery("SELECT * FROM pack ORDER BY _id DESC LIMIT 8", null);
            while (cursorRawQuery.moveToNext()) {
                try {
                    xVar = (x) xVar.clone();
                    xVar.c(cursorRawQuery);
                    arrayList.add(xVar);
                } catch (Throwable th) {
                    th = th;
                    try {
                        com.byazt.yv.da.tt(th);
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                    } catch (Throwable th2) {
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        throw th2;
                    }
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (Throwable th3) {
            th = th3;
            cursorRawQuery = null;
        }
        com.byazt.yv.da.c("queryPack, " + arrayList, null);
        return arrayList;
    }

    public void setResult(ArrayList<x> arrayList, ArrayList<x> arrayList2, ArrayList<x> arrayList3) {
        SQLiteDatabase sQLiteDatabase = null;
        com.byazt.yv.da.c("setResult, " + arrayList + ", " + arrayList2, null);
        Iterator<x> it = arrayList2.iterator();
        while (it.hasNext()) {
            x next = it.next();
            if (!arrayList3.contains(next) && Math.abs(System.currentTimeMillis() - next.tt) > 864000000) {
                arrayList.add(next);
                it.remove();
            }
        }
        try {
            SQLiteDatabase writableDatabase = this.n.getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                try {
                    for (x xVar : arrayList) {
                        if (arrayList3.contains(xVar)) {
                            c(xVar, true, writableDatabase, false);
                        } else {
                            writableDatabase.execSQL("DELETE FROM pack WHERE _id=?", new String[]{String.valueOf(xVar.c)});
                        }
                    }
                } catch (Throwable th) {
                    com.byazt.yv.da.tt(th);
                }
                for (x xVar2 : arrayList2) {
                    if (xVar2.my != null) {
                        c((String) null);
                    }
                    if (!arrayList3.contains(xVar2)) {
                        long j = xVar2.c;
                        int i = xVar2.u + 1;
                        xVar2.u = i;
                        writableDatabase.execSQL(c(j, i));
                    }
                }
                writableDatabase.setTransactionSuccessful();
                u.c(writableDatabase);
            } catch (Throwable th2) {
                th = th2;
                sQLiteDatabase = writableDatabase;
                try {
                    com.byazt.yv.da.tt(th);
                } finally {
                    u.c(sQLiteDatabase);
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public void c(ArrayList<com.byazt.tv.c> arrayList) {
        ArrayList arrayList2 = new ArrayList(4);
        ArrayList arrayList3 = new ArrayList(4);
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase writableDatabase = this.n.getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                ContentValues contentValuesTt = null;
                for (com.byazt.tv.c cVar : arrayList) {
                    String strUj = cVar.uj();
                    contentValuesTt = cVar.tt(contentValuesTt);
                    cVar.c = writableDatabase.insert(strUj, null, contentValuesTt);
                    if (NotificationCompat.CATEGORY_EVENT.equals(cVar.uj())) {
                        arrayList3.add(cVar);
                    } else if ("eventv3".equals(cVar.uj())) {
                        arrayList3.add(cVar);
                    } else if (cVar instanceof a) {
                        arrayList2.add((a) cVar);
                    }
                }
                writableDatabase.setTransactionSuccessful();
                u.c(writableDatabase);
            } catch (Throwable th) {
                th = th;
                sQLiteDatabase = writableDatabase;
                try {
                    com.byazt.yv.da.tt(th);
                } finally {
                    u.c(sQLiteDatabase);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 239, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    private static class c extends SQLiteOpenHelper {
        public c(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
            super(new com.byazt.nys.c(context), str, cursorFactory, i);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.beginTransaction();
                Iterator<com.byazt.tv.c> it = tt.tt.values().iterator();
                while (it.hasNext()) {
                    String strVe = it.next().ve();
                    if (strVe != null) {
                        sQLiteDatabase.execSQL(strVe);
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                u.c(sQLiteDatabase);
            } catch (Throwable th) {
                try {
                    com.byazt.yv.da.tt(th);
                } finally {
                    u.c(sQLiteDatabase);
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            com.byazt.yv.da.uj("onUpgrade, " + i + ", " + i2, null);
            try {
                sQLiteDatabase.beginTransaction();
                Iterator<com.byazt.tv.c> it = tt.tt.values().iterator();
                while (it.hasNext()) {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + it.next().uj());
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Throwable th) {
                try {
                    com.byazt.yv.da.ve("", th);
                } catch (Throwable th2) {
                    u.c(sQLiteDatabase);
                    throw th2;
                }
            }
            u.c(sQLiteDatabase);
            onCreate(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            onUpgrade(sQLiteDatabase, i, i2);
        }
    }
}
