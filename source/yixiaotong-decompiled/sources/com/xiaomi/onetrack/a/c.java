package com.xiaomi.onetrack.a;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.xiaomi.onetrack.util.p;
import ijiami_1011.s.s.s;
import java.util.Calendar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f9394a;

    public c(a aVar) {
        this.f9394a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f9394a.i == null) {
            return;
        }
        synchronized (this.f9394a.i) {
            Cursor cursorQuery = null;
            try {
                try {
                    SQLiteDatabase writableDatabase = this.f9394a.i.getWritableDatabase();
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(System.currentTimeMillis());
                    calendar.set(6, calendar.get(6) - 7);
                    calendar.set(11, 0);
                    calendar.set(12, 0);
                    calendar.set(13, 0);
                    long timeInMillis = calendar.getTimeInMillis();
                    String strD = s.d(new byte[]{16, 11, 14, 93, 16, 17, 0, 9, Ascii.SYN, 66, 13, 69, 91, 66}, "dbc8ce");
                    String[] strArr = {Long.toString(timeInMillis)};
                    cursorQuery = writableDatabase.query(s.d(new byte[]{15, 93, 11, 15, 66, 9, 19}, "b2ef6f"), new String[]{s.d(new byte[]{65, 12, 84, 3, SignedBytes.MAX_POWER_OF_TWO, 76, 0, 9, Ascii.SYN}, "5e9f38")}, strD, strArr, null, null, s.d(new byte[]{70, 10, 8, 86, 67, 17, 0, 9, Ascii.SYN, 66, 112, 54, 113}, "2ce30e"));
                    if (cursorQuery.getCount() != 0) {
                        p.a(s.d(new byte[]{37, 85, 126, 93, 13, 13, Ascii.NAK, 11, Ascii.DC4, 47, 80, 11, 5, 86, 86, SignedBytes.MAX_POWER_OF_TWO}, "d132cd"), s.d(new byte[]{76, 76, 79, Ascii.CAN, 87, 80, 13, 1, Ascii.DC2, 7, 85, 69, 9, 4, Ascii.SYN, 87, 95, 80, Ascii.NAK, 1, 70, 3, 85, 69, 11, 9, 11, 81, 71, 90, 19, 68, 5, 13, 68, 11, Ascii.DC2, 91}, "ffe835") + writableDatabase.delete(s.d(new byte[]{12, 12, 92, 15, 69, 14, 19}, "ac2f1a"), strD, strArr));
                    }
                    if (p.f9551a) {
                        p.a(s.d(new byte[]{36, 1, 116, 14, 15, 91, Ascii.NAK, 11, Ascii.DC4, 47, 80, 11, 4, 2, 92, 19}, "ee9aa2"), s.d(new byte[]{2, 95, 68, 92, Ascii.SYN, 70, 5, 1, 10, 7, 69, 0, 67, 86, 82, 74, 11, 10, 4, 16, 3, 66, 80, 1, 67, 84, 95, 87, 13, Ascii.DC2, 14, Ascii.SYN, 70, 16, 84, 6, 12, 75, 84, Ascii.EM, Ascii.SYN, 3, 12, 5, 15, 12, 66, 88}, "c909df") + this.f9394a.e());
                    }
                } catch (Exception e) {
                    p.d(s.d(new byte[]{116, 93, 127, 9, 91, 89, Ascii.NAK, 11, Ascii.DC4, 47, 80, 11, 84, 94, 87, Ascii.DC4}, "592f50"), s.d(new byte[]{67, 93, 11, 11, 19, 84, 65, 11, 4, 17, 94, 9, 84, 76, 3, 68, 4, 85, 65, 9, 9, 12, 88, 17, 94, 74, 70, 2, 4, 88, 13, 1, 2, 66, 70, 12, 69, 80, 70}, "18fde1") + e);
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
}
