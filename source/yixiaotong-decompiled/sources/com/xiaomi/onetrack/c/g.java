package com.xiaomi.onetrack.c;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.common.base.Ascii;
import java.util.Calendar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f9468a;

    public g(c cVar) {
        this.f9468a = cVar;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x015a A[Catch: all -> 0x015e, TryCatch #3 {all -> 0x015e, blocks: (B:24:0x0115, B:38:0x0155, B:42:0x015a, B:43:0x015d, B:37:0x0152), top: B:49:0x0014 }] */
    @Override // java.lang.Runnable
    public void run() {
        Cursor cursor;
        if (this.f9468a.i == null) {
            return;
        }
        synchronized (this.f9468a.i) {
            try {
                try {
                    SQLiteDatabase writableDatabase = this.f9468a.i.getWritableDatabase();
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(System.currentTimeMillis());
                    calendar.set(6, calendar.get(6) - 7);
                    calendar.set(11, 0);
                    calendar.set(12, 0);
                    calendar.set(13, 0);
                    long timeInMillis = calendar.getTimeInMillis();
                    String strD = ijiami_1011.s.s.s.d(new byte[]{Ascii.DC2, 89, 90, 6, 70, 65, 0, 9, Ascii.SYN, 66, 13, 69, 89, 16}, "f07c55");
                    String[] strArr = {Long.toString(timeInMillis)};
                    Cursor cursorQuery = writableDatabase.query(ijiami_1011.s.s.s.d(new byte[]{7, Ascii.NAK, 6, 15, 66, 74}, "bcca69"), new String[]{ijiami_1011.s.s.s.d(new byte[]{69, 11, 84, 85, 66, Ascii.SYN, 0, 9, Ascii.SYN}, "1b901b")}, strD, strArr, null, null, ijiami_1011.s.s.s.d(new byte[]{65, 15, 9, 0, 69, Ascii.DC2, 0, 9, Ascii.SYN, 66, 112, 54, 118}, "5fde6f"));
                    try {
                        if (cursorQuery.getCount() != 0) {
                            com.xiaomi.onetrack.util.p.a(ijiami_1011.s.s.s.d(new byte[]{112, 79, 4, 92, Ascii.NAK, 43, 0, 10, 7, 5, 84, Ascii.ETB}, "59a2af"), ijiami_1011.s.s.s.d(new byte[]{Ascii.RS, 26, Ascii.RS, Ascii.DC2, 83, 86, 13, 1, Ascii.DC2, 7, 85, 69, 91, 82, 71, 93, 91, 86, Ascii.NAK, 1, 70, 11, 69, 0, 89, 16, 87, 93, 66, 93, Ascii.NAK, 89}, "404273") + writableDatabase.delete(ijiami_1011.s.s.s.d(new byte[]{83, Ascii.DC2, 87, 91, 76, 17}, "6d258b"), strD, strArr));
                        }
                        long jC = c.a().c();
                        com.xiaomi.onetrack.b.n.a(jC == 0);
                        com.xiaomi.onetrack.util.p.a(ijiami_1011.s.s.s.d(new byte[]{117, 16, 92, 91, 70, 116, 0, 10, 7, 5, 84, Ascii.ETB}, "0f9529"), ijiami_1011.s.s.s.d(new byte[]{82, 5, 68, 6, Ascii.ETB, 66, 5, 1, 10, 7, 69, 0, 19, 12, 82, 16, 10, 14, 4, 16, 3, 66, 67, 0, 80, 12, 66, 7, 69, 16, 4, 9, 7, 11, 95, Ascii.SYN, 14}, "3c0ceb") + jC);
                        cursorQuery.close();
                    } catch (Exception e) {
                        e = e;
                        cursor = cursorQuery;
                        try {
                            com.xiaomi.onetrack.util.p.d(ijiami_1011.s.s.s.d(new byte[]{124, 66, 84, 13, Ascii.NAK, 127, 0, 10, 7, 5, 84, Ascii.ETB}, "941ca2"), ijiami_1011.s.s.s.d(new byte[]{65, 4, 15, 89, 65, 86, 65, 11, 4, 17, 94, 9, 86, Ascii.NAK, 7, Ascii.SYN, 82, 69, 4, 10, Ascii.DC2, 17, 17, 3, 82, 8, 14, 83, 83, 19, Ascii.SYN, 13, Ascii.DC2, 10, 17}, "3ab673") + e);
                            if (cursor != null) {
                                cursor.close();
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = cursorQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th4) {
                th = th4;
                cursor = null;
            }
        }
    }
}
