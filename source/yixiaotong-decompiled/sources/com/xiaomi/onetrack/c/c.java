package com.xiaomi.onetrack.c;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteBlobTooBigException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.xiaomi.onetrack.util.aa;
import java.util.ArrayList;
import kotlin.io.encoding.Base64;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class c {
    private static final boolean b = false;
    private static final int c = 204800;
    private static final int d = 307200;
    private static final int e = 300;
    private static final int g = 7;
    private static c h;
    private a i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9464a = ijiami_1011.s.s.s.d(new byte[]{125, 19, 83, 91, 65, 122, 0, 10, 7, 5, 84, Ascii.ETB}, "8e6557");
    private static final String f = ijiami_1011.s.s.s.d(new byte[]{73, 71, 12, 9, 69, 95, Ascii.NAK, Ascii.GS, 70, 35, 98, 38, Ascii.NAK, Ascii.NAK, 58, 15, 83, Ascii.SYN, 32, 55, 37}, "95ef76");
    private static BroadcastReceiver j = new d();

    public static class a extends SQLiteOpenHelper {
        private static final int j = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f9465a = ijiami_1011.s.s.s.d(new byte[]{94, 92, 87, 16, 71, 4, 2, 15}, "122d5e");
        public static final String b = ijiami_1011.s.s.s.d(new byte[]{93, Ascii.NAK, 6, 89, SignedBytes.MAX_POWER_OF_TWO, SignedBytes.MAX_POWER_OF_TWO}, "8cc743");
        public static final String c = ijiami_1011.s.s.s.d(new byte[]{104, 10, 83}, "7c78b7");
        public static final String d = ijiami_1011.s.s.s.d(new byte[]{85, 68, 66, 80, 81}, "442954");
        public static final String e = ijiami_1011.s.s.s.d(new byte[]{72, 2, 82, 88, 0, 81, 4}, "8c13a6");
        public static final String f = ijiami_1011.s.s.s.d(new byte[]{86, 71, 0, 11, 16, 58, 15, 5, 11, 7}, "31eede");
        public static final String g = ijiami_1011.s.s.s.d(new byte[]{Ascii.NAK, Ascii.ETB, 80, 10, Ascii.ETB, 8, Ascii.NAK, Ascii.GS}, "ee9eea");
        public static final String h = ijiami_1011.s.s.s.d(new byte[]{81, 88, Ascii.NAK, 84}, "59a5de");
        public static final String i = ijiami_1011.s.s.s.d(new byte[]{70, 12, 85, 93, 16, Ascii.DC2, 0, 9, Ascii.SYN}, "2e88cf");
        private static final String k = ijiami_1011.s.s.s.d(new byte[]{117, 96, 124, 118, 108, 124, 65, 48, 39, 32, 125, 32, Ascii.SYN, 87, 79, 82, 86, 77, Ascii.DC2, 68, 78, Base64.padSymbol, 88, 1, Ascii.SYN, 123, 119, 99, 125, 126, 36, 54, 70, 50, 99, 44, 123, 115, 107, 110, Ascii.CAN, 114, 36, Base64.padSymbol, 70, 35, 100, 49, 121, 123, 119, 116, 106, 124, 44, 33, 40, 54, Ascii.GS, 4, 70, 66, 80, 83, Ascii.CAN, 109, 36, 60, 50, 78, 65, 4, 85, 89, 88, 80, 93, Ascii.EM, 53, 33, 62, 54, Ascii.GS, 0, SignedBytes.MAX_POWER_OF_TWO, 87, 87, 67, 103, 87, 0, 9, 3, 66, 101, 32, 110, 102, Ascii.NAK, 71, 74, 80, 14, Ascii.SYN, 15, Ascii.SYN, 72, 69, 127, 124, 109, 114, 127, 124, 51, 72, 2, 3, 69, 4, Ascii.SYN, 112, 117, 120, 122, Ascii.NAK, Ascii.NAK, 13, 11, 7, 66, 17, 87, 95, 73, Ascii.ETB, 113, 119, 53, 33, 33, 39, 99, 76}, "629789");

        public a(Context context) {
            super(context, ijiami_1011.s.s.s.d(new byte[]{13, 86, 86, 65, 66, 85, 2, 15}, "b83504"), (SQLiteDatabase.CursorFactory) null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(k);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        }
    }

    private c() {
        Context contextA = com.xiaomi.onetrack.f.a.a();
        this.i = new a(contextA);
        b();
        b(contextA);
    }

    public static c a() {
        if (h == null) {
            a(com.xiaomi.onetrack.f.a.b());
        }
        return h;
    }

    public static String a(byte[] bArr) {
        return new String(com.xiaomi.onetrack.d.a.b(bArr, com.xiaomi.onetrack.d.d.a(com.xiaomi.onetrack.d.c.a(), true).getBytes()));
    }

    public static void a(Context context) {
        if (h == null) {
            synchronized (c.class) {
                if (h == null) {
                    h = new c();
                }
            }
        }
    }

    public static byte[] a(String str) {
        return com.xiaomi.onetrack.d.a.a(str.getBytes(), com.xiaomi.onetrack.d.d.a(com.xiaomi.onetrack.d.c.a(), true).getBytes());
    }

    private static void b(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ijiami_1011.s.s.s.d(new byte[]{80, 15, 7, 66, 11, 89, 5, 74, 15, 12, 69, 0, 95, Ascii.NAK, 77, 81, 7, 68, 8, 11, 8, 76, 98, 38, 99, 36, 38, 126, 59, 127, 47}, "1ac0d0"));
        intentFilter.addAction(ijiami_1011.s.s.s.d(new byte[]{3, 92, 86, Ascii.DC4, 93, 93, 5, 74, 15, 12, 69, 0, 12, 70, Ascii.FS, 7, 81, SignedBytes.MAX_POWER_OF_TWO, 8, 11, 8, 76, 98, 38, 48, 119, 119, 40, 109, 123, 39, 34}, "b22f24"));
        context.registerReceiver(j, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.xiaomi.onetrack.f.b bVar) {
        synchronized (this.i) {
            if (!bVar.i()) {
                com.xiaomi.onetrack.util.p.c(f9464a, ijiami_1011.s.s.s.d(new byte[]{7, 1, 92, 35, 79, 92, 15, 16, 50, 13, 117, 4, Ascii.DC2, 4, 90, 7, 74, 92, 65, 1, 16, 7, 95, 17, 70, 12, 75, 70, 80, 87, 55, 5, 10, 11, 85, 73, 70, 0, 78, 3, 87, 77, 91}, "fe8f99") + bVar.e());
                return;
            }
            SQLiteDatabase writableDatabase = this.i.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(ijiami_1011.s.s.s.d(new byte[]{88, 72, 68, 81, 84}, "984802"), bVar.c());
            contentValues.put(ijiami_1011.s.s.s.d(new byte[]{70, 84, 6, 15, 89, 6, 4}, "65ed8a"), bVar.d());
            contentValues.put(ijiami_1011.s.s.s.d(new byte[]{80, 67, 92, 90, 77, 109, 15, 5, 11, 7}, "559492"), bVar.e());
            contentValues.put(ijiami_1011.s.s.s.d(new byte[]{66, Ascii.SYN, 10, 95, SignedBytes.MAX_POWER_OF_TWO, 88, Ascii.NAK, Ascii.GS}, "2dc021"), Integer.valueOf(bVar.f()));
            contentValues.put(ijiami_1011.s.s.s.d(new byte[]{Ascii.ETB, 93, 11, 3, 65, Ascii.DC2, 0, 9, Ascii.SYN}, "c4ff2f"), Long.valueOf(System.currentTimeMillis()));
            byte[] bArrA = a(bVar.g().toString());
            if (bArrA.length > c) {
                com.xiaomi.onetrack.util.p.b(f9464a, ijiami_1011.s.s.s.d(new byte[]{102, 10, 11, 70, 14, 87, 19, 3, 3, 66, 85, 4, 70, 4, 72, 70, 6, 95, Ascii.DC2, 7, 7, 16, 85, 69, Ascii.CAN, 79, 78}, "2edfb6"));
                return;
            }
            contentValues.put(ijiami_1011.s.s.s.d(new byte[]{83, 4, 71, 4}, "7e3e23"), bArrA);
            long jInsert = writableDatabase.insert(ijiami_1011.s.s.s.d(new byte[]{1, 67, 0, 8, 68, SignedBytes.MAX_POWER_OF_TWO}, "d5ef03"), null, contentValues);
            String str = f9464a;
            com.xiaomi.onetrack.util.p.a(str, ijiami_1011.s.s.s.d(new byte[]{117, 39, Ascii.RS, 109, 93, 67, 4, 5, 2, 88, 17, 32, 71, 0, 93, 77, 120, 80, 15, 5, 1, 7, 67, 75, 80, 1, 87, 124, 67, 84, 15, 16, 50, 13, 117, 4, 69, 4, 81, 88, 70, 84, 65, 72, 70, 16, 94, Ascii.DC2, 12}, "1e3951") + jInsert);
            if (jInsert != -1) {
                if (com.xiaomi.onetrack.util.p.f9551a) {
                    com.xiaomi.onetrack.util.p.a(str, ijiami_1011.s.s.s.d(new byte[]{-46, -121, -33, -42, -65, -58, -124, -12, -24, -115, -115, -23, 112, 114, 68, -41, -115, -53, -123, -34, -19, -122, -118, -45, -48, -120, -50, -43, -96, -42, -123, -36, -36, 66}, "40d35f") + c());
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (ijiami_1011.s.s.s.d(new byte[]{12, 95, 80, 69, Ascii.SYN, 5, 2, 15, 57, 3, 82, 17, 10, 71, 80}, "c151dd").equals(bVar.e())) {
                    aa.a(jCurrentTimeMillis);
                }
                com.xiaomi.onetrack.b.n.a(false);
            }
        }
    }

    private void d() {
        try {
            this.i.getWritableDatabase().delete(ijiami_1011.s.s.s.d(new byte[]{87, Ascii.ETB, 81, 95, 16, 74}, "2a41d9"), null, null);
            com.xiaomi.onetrack.util.p.a(f9464a, ijiami_1011.s.s.s.d(new byte[]{6, 81, 91, 3, Ascii.SYN, 6, 65, 16, 7, 0, 93, 0, 66, 81, 65, 3, 12, Ascii.ETB, Ascii.DC2}, "b47fbc"));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public int a(ArrayList<Long> arrayList) {
        synchronized (this.i) {
            if (arrayList != null) {
                try {
                    if (arrayList.size() != 0) {
                        try {
                            SQLiteDatabase writableDatabase = this.i.getWritableDatabase();
                            boolean z = true;
                            StringBuilder sb = new StringBuilder(((Long.toString(arrayList.get(0).longValue()).length() + 1) * arrayList.size()) + 16);
                            sb.append(ijiami_1011.s.s.s.d(new byte[]{110, 80, 1}, "19e62b")).append(ijiami_1011.s.s.s.d(new byte[]{67, 10, 94, Ascii.CAN, Ascii.GS}, "cc085f"));
                            sb.append(arrayList.get(0));
                            int size = arrayList.size();
                            for (int i = 1; i < size; i++) {
                                sb.append(ijiami_1011.s.s.s.d(new byte[]{79}, "c3a83d")).append(arrayList.get(i));
                            }
                            sb.append(ijiami_1011.s.s.s.d(new byte[]{76}, "e17b55"));
                            int iDelete = writableDatabase.delete(ijiami_1011.s.s.s.d(new byte[]{93, 16, 84, 91, Ascii.ETB, Ascii.ETB}, "8f15cd"), sb.toString(), null);
                            String str = f9464a;
                            com.xiaomi.onetrack.util.p.a(str, ijiami_1011.s.s.s.d(new byte[]{84, 85, 94, 80, Ascii.NAK, 4, 5, 68, 3, Ascii.DC4, 84, 11, 68, 67, Ascii.DC2, 86, 14, Ascii.DC4, 15, 16, 70}, "0025aa") + iDelete);
                            long jC = a().c();
                            if (jC != 0) {
                                z = false;
                            }
                            com.xiaomi.onetrack.b.n.a(z);
                            com.xiaomi.onetrack.util.p.a(str, ijiami_1011.s.s.s.d(new byte[]{85, 3, Ascii.SYN, 86, 16, Ascii.CAN, 5, 1, 10, 7, 69, 0, Ascii.DC4, 33, 32, 19, 16, 93, 2, 11, Ascii.DC4, 6, 17, Ascii.ETB, 81, 8, 3, 90, 12, 75, 92}, "4eb3b8") + jC);
                            return iDelete;
                        } catch (Exception e2) {
                            com.xiaomi.onetrack.util.p.b(f9464a, ijiami_1011.s.s.s.d(new byte[]{4, 5}, "a8d563") + e2);
                            return 0;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return 0;
        }
    }

    /* JADX WARN: Code duplicated, block: B:65:0x01cd  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x01ca: MOVE (r10 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:63:0x01ca */
    public h a(int i) throws Throwable {
        Cursor cursor;
        Cursor cursorQuery;
        Cursor cursor2;
        boolean z;
        boolean z2;
        h hVar = null;
        try {
            try {
                cursorQuery = this.i.getReadableDatabase().query(ijiami_1011.s.s.s.d(new byte[]{84, 79, 93, 11, 16, 17}, "198edb"), null, null, null, null, null, f);
                try {
                    int columnIndex = cursorQuery.getColumnIndex(ijiami_1011.s.s.s.d(new byte[]{62, 90, 80}, "a3454e"));
                    int columnIndex2 = cursorQuery.getColumnIndex(ijiami_1011.s.s.s.d(new byte[]{2, 69, 71, 94, 1}, "c577e9"));
                    cursorQuery.getColumnIndex(ijiami_1011.s.s.s.d(new byte[]{67, 80, 84, 14, 85, 81, 4}, "317e46"));
                    cursorQuery.getColumnIndex(ijiami_1011.s.s.s.d(new byte[]{82, 69, 7, 12, 66, 107, 15, 5, 11, 7}, "73bb64"));
                    int columnIndex3 = cursorQuery.getColumnIndex(ijiami_1011.s.s.s.d(new byte[]{17, 71, 15, 91, 74, 13, Ascii.NAK, Ascii.GS}, "a5f48d"));
                    int columnIndex4 = cursorQuery.getColumnIndex(ijiami_1011.s.s.s.d(new byte[]{0, 87, 68, 80}, "d601b4"));
                    int columnIndex5 = cursorQuery.getColumnIndex(ijiami_1011.s.s.s.d(new byte[]{67, 89, 88, 0, 16, 66, 0, 9, Ascii.SYN}, "705ec6"));
                    JSONArray jSONArray = new JSONArray();
                    ArrayList arrayList = new ArrayList();
                    boolean z3 = true;
                    int i2 = 0;
                    int length = 0;
                    while (cursorQuery.moveToNext()) {
                        long j2 = cursorQuery.getLong(columnIndex);
                        cursorQuery.getLong(columnIndex5);
                        cursorQuery.getString(columnIndex2);
                        byte[] blob = cursorQuery.getBlob(columnIndex4);
                        String strA = blob != null ? a(blob) : hVar;
                        if (z3) {
                            int i3 = cursorQuery.getInt(columnIndex3);
                            if (i3 > i) {
                                com.xiaomi.onetrack.util.p.a(f9464a, ijiami_1011.s.s.s.d(new byte[]{124, 10, Ascii.EM, 71, 93, 86, 14, Ascii.SYN, 2, 17, 17, 10, 84, 69, 73, 71, 81, 90, 19, 13, Ascii.DC2, Ascii.ESC, 106}, "2e9585") + i + ijiami_1011.s.s.s.d(new byte[]{111, Ascii.ESC, Ascii.CAN, 80, 13, 68, Ascii.DC2, 16, 70, 16, 84, 6, 93, 69, 92, Ascii.SYN, Ascii.DC4, 68, 8, 11, Ascii.DC4, 11, 69, Ascii.FS, 15}, "2786d6") + i3);
                                cursorQuery.close();
                                return hVar;
                            }
                            z2 = false;
                        } else {
                            z2 = z3;
                        }
                        try {
                            jSONArray.put(new JSONObject(strA));
                            arrayList.add(Long.valueOf(j2));
                            i2++;
                        } catch (Exception e2) {
                            com.xiaomi.onetrack.util.p.b(f9464a, ijiami_1011.s.s.s.d(new byte[]{Ascii.CAN, 72, Ascii.RS, 69, 1, 68, 19, 11, Ascii.DC4, 66, Ascii.ESC, 79, Ascii.CAN}, "2b4ed6"), e2);
                        }
                        length += strA.length();
                        if (length >= d) {
                            com.xiaomi.onetrack.util.p.a(f9464a, ijiami_1011.s.s.s.d(new byte[]{19, 84, 4, 83, 89, 7, 5, 68, 11, 3, 73, 69, 13, 84, 11, 10, 17}, "a1e01b") + length);
                            break;
                        }
                        z3 = z2;
                        columnIndex = columnIndex;
                        hVar = null;
                    }
                    if (arrayList.size() > 0) {
                        if (!cursorQuery.isAfterLast()) {
                            if (cursorQuery.getInt(columnIndex3) <= i) {
                                z = false;
                            }
                            h hVar2 = new h(jSONArray, i2, arrayList, z);
                            cursorQuery.close();
                            return hVar2;
                        }
                        com.xiaomi.onetrack.util.p.a(f9464a, ijiami_1011.s.s.s.d(new byte[]{83, 66, 16, SignedBytes.MAX_POWER_OF_TWO, 87, Ascii.SYN, 65, 13, Ascii.NAK, 35, 87, 17, 85, 69, 46, 82, 75, 16}, "07b38d"));
                        z = true;
                        h hVar3 = new h(jSONArray, i2, arrayList, z);
                        cursorQuery.close();
                        return hVar3;
                    }
                } catch (SQLiteBlobTooBigException e3) {
                    e = e3;
                    com.xiaomi.onetrack.util.p.b(f9464a, ijiami_1011.s.s.s.d(new byte[]{87, 93, 13, 4, Ascii.EM, 67, 14, 11, 70, 0, 88, 2, Ascii.NAK, Ascii.ESC, 72, 76}, "51bf97"), e);
                    d();
                    if (cursorQuery != null) {
                    }
                    return null;
                } catch (Exception e4) {
                    e = e4;
                    com.xiaomi.onetrack.util.p.a(f9464a, "", e);
                    if (cursorQuery != null) {
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor = cursor2;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteBlobTooBigException e5) {
            e = e5;
            cursorQuery = null;
        } catch (Exception e6) {
            e = e6;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        cursorQuery.close();
        return null;
    }

    public synchronized void a(com.xiaomi.onetrack.f.b bVar) {
        b.a(new f(this, bVar));
    }

    public void b() {
        b.a(new g(this), 1000L);
    }

    public long c() {
        try {
            return DatabaseUtils.queryNumEntries(this.i.getReadableDatabase(), ijiami_1011.s.s.s.d(new byte[]{85, 68, 0, 89, 71, 16}, "02e73c"));
        } catch (Exception e2) {
            com.xiaomi.onetrack.util.p.b(f9464a, ijiami_1011.s.s.s.d(new byte[]{87, 93, 77, 101, 94, Ascii.DC2, 0, 8, 35, Ascii.DC4, 84, 11, 68, 75, 119, 68, 92, 4, 4, Ascii.SYN, 53, Ascii.ESC, 95, 6, 16, 94, 88, 88, 93, 3, 5, 68, 17, 11, 69, 13, 16}, "08911f") + e2.getMessage());
            return 0L;
        }
    }
}
