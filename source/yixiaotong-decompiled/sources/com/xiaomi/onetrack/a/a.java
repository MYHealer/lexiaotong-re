package com.xiaomi.onetrack.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteBlobTooBigException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.xiaomi.onetrack.b.n;
import com.xiaomi.onetrack.util.p;
import ijiami_1011.s.s.s;
import java.util.ArrayList;
import java.util.Iterator;
import okio.Utf8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class a {
    private static final int b = 204800;
    private static final int c = 100;
    private static final int d = 4;
    private static final int e = 300;
    private static final int g = 7;
    private static a h;
    private final C1160a i = new C1160a(com.xiaomi.onetrack.f.a.a());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9389a = s.d(new byte[]{116, 92, 121, 91, 93, 13, Ascii.NAK, 11, Ascii.DC4, 47, 80, 11, 84, 95, 81, 70}, "58443d");
    private static final String f = s.d(new byte[]{106, 89, 5, Ascii.DC4, 115, 49, 34}, "50a42b");

    /* JADX INFO: renamed from: com.xiaomi.onetrack.a.a$a, reason: collision with other inner class name */
    public static class C1160a extends SQLiteOpenHelper {
        private static final int j = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f9390a = s.d(new byte[]{93, 11, 84, 65, 75, 89, 2, 15, 57, 3, 85}, "2e1598");
        public static final String b = s.d(new byte[]{84, 89, 93, 80, 77, 93, 19}, "963992");
        public static final String c = s.d(new byte[]{60, 92, 81}, "c557e6");
        public static final String d = s.d(new byte[]{86, 73, SignedBytes.MAX_POWER_OF_TWO, 10, 84}, "790c0c");
        public static final String e = s.d(new byte[]{68, 83, 86, 13, 0, 83, 4}, "425fa4");
        public static final String f = s.d(new byte[]{3, 78, 81, 8, 65, 107, 15, 5, 11, 7}, "f84f54");
        public static final String g = s.d(new byte[]{68, 65, 10}, "13f48c");
        public static final String h = s.d(new byte[]{77, 11, 94, 92, Ascii.ETB, 68, 0, 9, Ascii.SYN}, "9b39d0");
        public static final String i = s.d(new byte[]{Ascii.DC2, 85, 10, 0, 108, 80, 14, 17, 8, Ascii.SYN}, "a0dd33");
        private static final String k = s.d(new byte[]{37, 98, 36, 113, 103, 115, 65, 48, 39, 32, 125, 32, 70, 93, 14, 94, 90, 66, 14, Ascii.SYN, 70, 74, 110, 12, 2, 16, 40, 126, 103, 115, 38, 33, 52, 66, 97, 55, 47, 125, 32, 98, 106, Ascii.SYN, 42, 33, Utf8.REPLACEMENT_BYTE, 66, 112, 48, 50, 127, 40, 126, 112, 100, 36, 41, 35, 44, 101, 73, 7, SignedBytes.MAX_POWER_OF_TWO, 17, 89, 87, Ascii.SYN, 53, 33, 62, 54, Ascii.GS, Ascii.NAK, 7, 83, 10, 81, 84, 83, 65, 48, 35, 58, 101, 73, 3, 70, 4, 94, 71, 105, 15, 5, 11, 7, 17, 49, 35, 104, 53, Ascii.FS, 70, 68, 13, 68, 50, 39, 105, 49, 74, 67, 4, 94, 87, 105, 2, 11, 19, 12, 69, 69, 47, 126, 53, 117, 116, 115, 51, 68, 34, 39, 119, 36, 51, 124, 53, 16, 3, 26, Ascii.NAK, 13, 11, 7, 66, 17, 7, 93, 17, 16, 122, 120, 53, 33, 33, 39, 99, 76}, "f0a036");

        public C1160a(Context context) {
            super(context, s.d(new byte[]{87, 90, 85, 76, Ascii.ETB, 84, 2, 15, 57, 3, 85}, "8408e5"), (SQLiteDatabase.CursorFactory) null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(k);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        }
    }

    private a() {
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a(com.xiaomi.onetrack.a.b.a aVar) {
        synchronized (this.i) {
            try {
                if (!aVar.h()) {
                    p.c(f9389a, s.d(new byte[]{87, 83, 1, 35, 1, 47, 14, 10, 15, Ascii.SYN, 94, Ascii.ETB, 98, 88, 33, 3, 17, 3, 3, 5, Ascii.NAK, 7, 17, 0, SignedBytes.MAX_POWER_OF_TWO, 82, 11, Ascii.SYN, 69, 11, Ascii.DC2, 68, 15, 12, 103, 4, 90, 94, 1, 78, 69, 7, Ascii.ETB, 1, 8, Ascii.SYN, 11}, "67ebeb") + aVar.a());
                    return -1L;
                }
                SQLiteDatabase writableDatabase = this.i.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put(s.d(new byte[]{0, 67, 65, 89, 87}, "a31039"), aVar.e());
                contentValues.put(s.d(new byte[]{71, 4, 6, 9, 80, 80, 4}, "7eeb17"), aVar.f());
                contentValues.put(s.d(new byte[]{92, Ascii.NAK, 83, 95, 16, 57, 15, 5, 11, 7}, "9c61df"), aVar.a());
                contentValues.put(s.d(new byte[]{69, 95, 95, 4, 75, 69, 0, 9, Ascii.SYN}, "162a81"), Long.valueOf(aVar.d()));
                contentValues.put(s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 19, 94}, "5a2356"), aVar.c());
                long jInsert = writableDatabase.insert(s.d(new byte[]{93, 92, 89, 89, Ascii.SYN, 92, 19}, "0370b3"), null, contentValues);
                String str = f9389a;
                p.a(str, s.d(new byte[]{114, 123, 72, 49, 95, 69, 4, 5, 2, 88, 17, 36, 82, 116, 10, 11, 94, 67, 14, Ascii.SYN, 43, 3, 95, 4, 81, 92, Ascii.ETB, 75, 86, 83, 5, 37, 2, 47, 94, 11, 95, 77, 10, Ascii.ETB, 99, 88, 37, 5, Ascii.DC2, 3, 83, 4, 69, 92, 69, 73, Ascii.ETB, 69, 14, 19, 91}, "69ee77") + jInsert);
                if (p.f9551a) {
                    p.a(str, s.d(new byte[]{-45, -42, -114, -48, -20, -60, -124, -12, -24, -115, -115, -23, 84, 5, Ascii.NAK, 88, 9, 10, 8, 16, 9, 16, 17, 16, 71, 13, Ascii.NAK, -47, -34, -55, -123, -34, -19, -122, -118, -45, -47, -39, -97, -45, -13, -44, -123, -36, -36, 66}, "5a55fd") + e());
                }
                return jInsert;
            } catch (Throwable th) {
                p.a(f9389a, s.d(new byte[]{87, 86, 1, 121, 6, 44, 14, 10, 15, Ascii.SYN, 94, Ascii.ETB, 98, 93, 33, 89, Ascii.SYN, 0, 3, 5, Ascii.NAK, 7, 17, 49, 94, SignedBytes.MAX_POWER_OF_TWO, 10, 79, 3, 3, 13, 1, -119, -34, -85}, "62e8ba") + th.getMessage());
                return -1L;
            }
        }
    }

    public static a a() {
        if (h == null) {
            a(com.xiaomi.onetrack.f.a.a());
        }
        return h;
    }

    public static void a(Context context) {
        if (h == null) {
            synchronized (a.class) {
                if (h == null) {
                    h = new a();
                }
            }
        }
    }

    private void f() {
        try {
            this.i.getWritableDatabase().delete(s.d(new byte[]{88, 94, 13, 12, Ascii.ETB, 92, 19}, "51cec3"), null, null);
            p.a(f9389a, s.d(new byte[]{87, 0, 90, 82, 68, 87, 65, 16, 7, 0, 93, 0, 19, 8, 89, 89, 89, 70, 14, Ascii.SYN}, "3e6702"));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public int a(ArrayList<Integer> arrayList) {
        synchronized (this.i) {
            if (arrayList != null) {
                try {
                    if (arrayList.size() != 0) {
                        try {
                            SQLiteDatabase writableDatabase = this.i.getWritableDatabase();
                            StringBuilder sb = new StringBuilder(((Long.toString(arrayList.get(0).intValue()).length() + 1) * arrayList.size()) + 16);
                            sb.append(s.d(new byte[]{108, 94, 2}, "37f19a")).append(s.d(new byte[]{66, 12, 93, 68, Ascii.FS}, "be3d43"));
                            sb.append(arrayList.get(0));
                            int size = arrayList.size();
                            for (int i = 1; i < size; i++) {
                                sb.append(s.d(new byte[]{Ascii.FS}, "0e30e4")).append(arrayList.get(i));
                            }
                            sb.append(s.d(new byte[]{Ascii.CAN}, "12b775"));
                            int iDelete = writableDatabase.delete(s.d(new byte[]{15, 13, 89, 10, 17, 87, 19}, "bb7ce8"), sb.toString(), null);
                            String str = f9389a;
                            p.a(str, s.d(new byte[]{78, 79, 79, 68, Ascii.ESC, 26, 75, 68, 2, 7, 93, 0, 16, 0, 1, 68, 80, 84, 65, 9, 9, 12, 88, 17, 11, Ascii.ETB, 69, 7, 94, 69, 15, 16, 70}, "deed10") + iDelete);
                            if (p.f9551a) {
                                p.a(str, s.d(new byte[]{88, 94, 65, 85, 19, Ascii.SYN, 5, 1, 10, 7, 69, 0, Ascii.EM, 89, 81, 16, 12, 89, 15, 13, Ascii.DC2, 13, 67, 69, 75, 93, 86, 95, 19, 82, 65, Ascii.SYN, 3, 15, 80, 12, 87, 75, 8}, "9850a6") + e());
                            }
                            return iDelete;
                        } catch (Exception e2) {
                            p.b(f9389a, s.d(new byte[]{82, 92}, "7abb68") + e2);
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

    public void a(com.xiaomi.onetrack.f.b bVar) {
        try {
            com.xiaomi.onetrack.a.a.a.a(new b(this, bVar));
        } catch (Throwable th) {
            p.a(f9389a, s.d(new byte[]{4, 15, 13, 68, 82, Ascii.ETB, 32, 0, 43, 13, 95, 12, Ascii.SYN, 9, 19, 16, 99, 13, 19, 11, 17, 3, 83, 9, 7, -119, -35, -86}, "bfa07e") + th.getMessage());
        }
    }

    public boolean a(long j, long j2, int i) {
        if (i <= 0) {
            return true;
        }
        if (i < 4) {
            return Math.abs(j - j2) >= ((long) n.a(i - 1));
        }
        return false;
    }

    /* JADX WARN: Not initialized variable reg: 9, insn: 0x0169: MOVE (r17 I:??[OBJECT, ARRAY]) = (r9 I:??[OBJECT, ARRAY]), block:B:49:0x0169 */
    public com.xiaomi.onetrack.a.c.a b() {
        Cursor cursor;
        Cursor cursorQuery;
        int i;
        synchronized (this.i) {
            Cursor cursor2 = null;
            try {
                try {
                    try {
                        cursorQuery = this.i.getReadableDatabase().query(s.d(new byte[]{84, 10, 15, 12, 76, 95, 19}, "9eae80"), null, null, null, null, null, f);
                        try {
                            int columnIndex = cursorQuery.getColumnIndex(s.d(new byte[]{62, 15, 80}, "af4109"));
                            cursorQuery.getColumnIndex(s.d(new byte[]{3, 17, Ascii.DC2, 11, 82}, "babb6d"));
                            cursorQuery.getColumnIndex(s.d(new byte[]{70, 7, 84, 93, 83, 1, 4}, "6f762f"));
                            cursorQuery.getColumnIndex(s.d(new byte[]{3, Ascii.DC4, 6, 8, Ascii.DC2, 60, 15, 5, 11, 7}, "fbcffc"));
                            int columnIndex2 = cursorQuery.getColumnIndex(s.d(new byte[]{77, 8, 14, 84, 16, 70, 0, 9, Ascii.SYN}, "9ac1c2"));
                            int columnIndex3 = cursorQuery.getColumnIndex(s.d(new byte[]{65, 67, 9}, "41e13e"));
                            int columnIndex4 = cursorQuery.getColumnIndex(s.d(new byte[]{69, 7, 11, 0, 103, 87, 14, 17, 8, Ascii.SYN}, "6bed84"));
                            ArrayList arrayList = new ArrayList();
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            int i2 = 0;
                            while (true) {
                                if (!cursorQuery.moveToNext()) {
                                    i = i2;
                                    break;
                                }
                                int i3 = cursorQuery.getInt(columnIndex4);
                                long j = cursorQuery.getLong(columnIndex2);
                                if (a(jCurrentTimeMillis, j, i3)) {
                                    int i4 = cursorQuery.getInt(columnIndex);
                                    String string = cursorQuery.getString(columnIndex3);
                                    com.xiaomi.onetrack.a.b.a aVar = new com.xiaomi.onetrack.a.b.a();
                                    aVar.b(string);
                                    aVar.a(i4);
                                    aVar.a(j);
                                    aVar.b(i3);
                                    arrayList.add(aVar);
                                    i = i2 + 1;
                                    if (i >= 100) {
                                        break;
                                    }
                                    i2 = i;
                                }
                            }
                            boolean z = true;
                            if (arrayList.size() > 0) {
                                String str = f9389a;
                                p.a(str, s.d(new byte[]{85, 6, Ascii.NAK, Ascii.ETB, 4, 85, 65, 9, 9, 12, 88, 17, 93, 17, 65, 68, 12, 75, 4, 68, 92}, "2ca7e1") + arrayList.size());
                                if (cursorQuery.isAfterLast()) {
                                    p.a(str, s.d(new byte[]{1, 19, Ascii.ETB, 65, 89, 19, 65, 13, Ascii.NAK, 35, 87, 17, 7, Ascii.DC4, 41, 83, 69, Ascii.NAK}, "bfe26a"));
                                } else {
                                    z = false;
                                }
                            }
                            com.xiaomi.onetrack.a.c.a aVar2 = new com.xiaomi.onetrack.a.c.a(i, arrayList, z);
                            cursorQuery.close();
                            return aVar2;
                        } catch (SQLiteBlobTooBigException e2) {
                            e = e2;
                            p.b(f9389a, s.d(new byte[]{80, 95, 95, 86, 67, 16, 14, 11, 70, 0, 88, 2, Ascii.DC2, Ascii.EM, 26, Ascii.RS}, "2304cd"), e);
                            f();
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return null;
                        } catch (Exception e3) {
                            e = e3;
                            p.a(f9389a, "", e);
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return null;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                } catch (SQLiteBlobTooBigException e4) {
                    e = e4;
                    cursorQuery = null;
                } catch (Exception e5) {
                    e = e5;
                    cursorQuery = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
            }
        }
    }

    public void b(ArrayList<Integer> arrayList) {
        String str;
        StringBuilder sbAppend;
        synchronized (this.i) {
            if (arrayList != null) {
                try {
                    if (arrayList.size() > 0) {
                        SQLiteDatabase writableDatabase = null;
                        try {
                            try {
                                writableDatabase = this.i.getWritableDatabase();
                                writableDatabase.beginTransaction();
                                Iterator<Integer> it = arrayList.iterator();
                                while (it.hasNext()) {
                                    writableDatabase.execSQL(String.format(s.d(new byte[]{16, Ascii.DC4, 6, 2, Ascii.NAK, 93, 65, 65, Ascii.NAK, 66, 66, 0, 17, 68, 71, 16, 65, 5, 65, 65, Ascii.NAK, 66, 26, 69, 84, 68, Ascii.NAK, 11, 4, 74, 4, 68, 67, 17, 17, 88, 69, 65, 17}, "edbca8"), s.d(new byte[]{92, 94, 94, 12, 68, 94, 19}, "110e01"), s.d(new byte[]{16, 81, 93, 6, 110, 87, 14, 17, 8, Ascii.SYN}, "c43b14"), s.d(new byte[]{68, 84, 94, 0, 57, 2, 14, 17, 8, Ascii.SYN}, "710dfa"), s.d(new byte[]{107, 93, 84}, "440ff9"), Integer.valueOf(it.next().intValue())));
                                }
                                writableDatabase.setTransactionSuccessful();
                                try {
                                    writableDatabase.endTransaction();
                                    writableDatabase.close();
                                } catch (Exception e2) {
                                    str = f9389a;
                                    sbAppend = new StringBuilder().append(s.d(new byte[]{3, 1, 0, 37, 85, 44, 14, 10, 15, Ascii.SYN, 94, Ascii.ETB, 17, 55, 1, 16, 67, Ascii.CAN, 34, 11, 19, 12, 69, 69, 7, 11, 0, 48, 67, 0, 15, Ascii.ETB, 7, 1, 69, 12, 13, 11, 68, 1, 67, 19, 14, Ascii.SYN, 92, 66}, "bedd1a")).append(e2.getMessage());
                                    p.b(str, sbAppend.toString());
                                }
                            } catch (Exception e3) {
                                p.b(f9389a, s.d(new byte[]{4, 6, 84, 117, 0, 122, 14, 10, 15, Ascii.SYN, 94, Ascii.ETB, Ascii.SYN, 48, 85, SignedBytes.MAX_POWER_OF_TWO, Ascii.SYN, 78, 34, 11, 19, 12, 69, 69, 32, 26, 83, 81, Ascii.DC4, 67, 8, 11, 8, 88, 17}, "eb04d7") + e3.getMessage());
                                if (writableDatabase != null) {
                                    try {
                                        writableDatabase.endTransaction();
                                        writableDatabase.close();
                                    } catch (Exception e4) {
                                        str = f9389a;
                                        sbAppend = new StringBuilder().append(s.d(new byte[]{86, 5, 7, 113, 85, 127, 14, 10, 15, Ascii.SYN, 94, Ascii.ETB, 68, 51, 6, 68, 67, 75, 34, 11, 19, 12, 69, 69, 82, 15, 7, 100, 67, 83, 15, Ascii.ETB, 7, 1, 69, 12, 88, 15, 67, 85, 67, SignedBytes.MAX_POWER_OF_TWO, 14, Ascii.SYN, 92, 66}, "7ac012")).append(e4.getMessage());
                                        p.b(str, sbAppend.toString());
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            if (writableDatabase != null) {
                                try {
                                    writableDatabase.endTransaction();
                                    writableDatabase.close();
                                } catch (Exception e5) {
                                    p.b(f9389a, s.d(new byte[]{81, 5, 81, 117, 82, 41, 14, 10, 15, Ascii.SYN, 94, Ascii.ETB, 67, 51, 80, SignedBytes.MAX_POWER_OF_TWO, 68, Ascii.GS, 34, 11, 19, 12, 69, 69, 85, 15, 81, 96, 68, 5, 15, Ascii.ETB, 7, 1, 69, 12, 95, 15, Ascii.NAK, 81, 68, Ascii.SYN, 14, Ascii.SYN, 92, 66}, "0a546d") + e5.getMessage());
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    p.a(f9389a, s.d(new byte[]{81, 2, 6, 36, 0, 41, 14, 10, 15, Ascii.SYN, 94, Ascii.ETB, 67, 52, 7, 17, Ascii.SYN, Ascii.GS, 34, 11, 19, 12, 69, 69, 100, 14, 16, 10, 19, 5, 3, 8, 3, 88}, "0fbedd") + th2.getMessage());
                }
            }
        }
    }

    public void c() {
        com.xiaomi.onetrack.a.a.a.a(new c(this), 1000L);
    }

    public void d() {
        synchronized (this.i) {
            Cursor cursorQuery = null;
            try {
                try {
                    SQLiteDatabase writableDatabase = this.i.getWritableDatabase();
                    String strD = s.d(new byte[]{74, 93, 95, 83, 108, 80, 14, 17, 8, Ascii.SYN, 17, 91, 4, Ascii.CAN, 14, Ascii.ETB}, "981733");
                    String[] strArr = {Long.toString(4L)};
                    cursorQuery = writableDatabase.query(s.d(new byte[]{15, 89, 11, 80, Ascii.DC2, 10, 19}, "b6e9fe"), new String[]{s.d(new byte[]{71, 81, 91, 0, 17, Ascii.SYN, 0, 9, Ascii.SYN}, "386ebb")}, strD, strArr, null, null, f);
                    if (cursorQuery.getCount() != 0) {
                        p.a(f9389a, s.d(new byte[]{79, 76, 76, 17, 86, 3, 13, 1, Ascii.DC2, 7, 85, 69, 10, 4, Ascii.NAK, 94, 94, 3, Ascii.NAK, 1, 70, 3, 85, 69, 8, 9, 8, 88, 70, 9, 19, 68, 5, 13, 68, 11, 17, 91}, "eff12f") + writableDatabase.delete(s.d(new byte[]{12, 10, 91, 92, Ascii.NAK, 11, 19}, "ae55ad"), strD, strArr));
                    }
                    if (p.f9551a) {
                        p.a(f9389a, s.d(new byte[]{87, 95, Ascii.NAK, 3, 74, Ascii.EM, 5, 1, 10, 7, 69, 0, Ascii.SYN, 86, 3, Ascii.NAK, 87, 85, 4, 16, 3, 66, 80, 1, Ascii.SYN, 84, 14, 8, 81, 77, 14, Ascii.SYN, 70, 16, 84, 6, 89, 75, 5, 70, 74, 92, 12, 5, 15, 12, 66, 88}, "69af89") + e());
                    }
                } catch (Exception e2) {
                    p.d(f9389a, s.d(new byte[]{19, 1, 14, 89, 69, 84, 65, 11, 4, 17, 94, 9, 4, 16, 6, Ascii.SYN, 82, 85, 65, 9, 9, 12, 88, 17, 14, Ascii.SYN, 67, 80, 82, 88, 13, 1, 2, 66, 70, 12, Ascii.NAK, 12, 67}, "adc631") + e2);
                    if (cursorQuery != null) {
                    }
                }
                cursorQuery.close();
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        }
    }

    public long e() {
        try {
            return DatabaseUtils.queryNumEntries(this.i.getReadableDatabase(), s.d(new byte[]{95, 12, 93, 95, 71, 89, 19}, "2c3636"));
        } catch (Exception e2) {
            p.b(f9389a, s.d(new byte[]{82, 80, 17, 99, 87, 77, 0, 8, 35, Ascii.DC4, 84, 11, 65, 70, 43, 66, 85, 91, 4, Ascii.SYN, 53, Ascii.ESC, 95, 6, Ascii.NAK, 83, 4, 94, 84, 92, 5, 68, 17, 11, 69, 13, Ascii.NAK}, "55e789") + e2.getMessage());
            return 0L;
        }
    }
}
