package com.miui.zeus.mimo.sdk;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.google.common.base.Ascii;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class x6 implements Callable<Boolean> {
    @Override // java.util.concurrent.Callable
    public Boolean call() {
        Boolean boolValueOf;
        Context context = y8.f5752a;
        if (context == null) {
            return Boolean.FALSE;
        }
        Cursor cursorQuery = null;
        try {
            cursorQuery = context.getContentResolver().query(Uri.parse(ijiami_1011.s.s.s.d(new byte[]{1, 9, 92, 76, 87, 11, Ascii.NAK, 94, 73, 77, 82, 10, 15, 72, 74, 81, 83, 10, 12, 13, 72, 15, 80, Ascii.ETB, 9, 3, 70, Ascii.SYN, 66, Ascii.ETB, 14, Ascii.DC2, 15, 6, 84, Ascii.ETB, 76, 34, 91, 74, 87, 6, Ascii.NAK, 41, 7, 11, 93, 53, 16, 9, 68, 81, 86, 0, 19}, "bf282e")), null, null, null, null);
            if (cursorQuery != null) {
                cursorQuery.moveToFirst();
                w6.c = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow(ijiami_1011.s.s.s.d(new byte[]{16, Ascii.ETB, 72, 73, 12, 68, Ascii.NAK, 53, 19, 11, 82, 14, 36, 3, 85, 92, 42, 88, Ascii.DC2, 16, 7, 14, 93}, "cb89c6")));
            }
            m.a(w6.f5726a, ijiami_1011.s.s.s.d(new byte[]{11, 71, 98, 19, 19, 73, 14, Ascii.SYN, Ascii.DC2, 51, 68, 12, 1, 95, 118, 7, 14, 92, 40, 10, Ascii.NAK, Ascii.SYN, 80, 9, 14, Ascii.CAN, 17, 11, 48, 76, 17, Ascii.DC4, 9, 16, 69, 55, 7, 71, 68, 10, Ascii.ETB, Ascii.EM, 92, 68}, "b41fc9") + w6.c);
            boolValueOf = Boolean.valueOf(w6.c == 0);
            if (cursorQuery == null) {
                return boolValueOf;
            }
        } catch (Exception e) {
            m.b(w6.f5726a, ijiami_1011.s.s.s.d(new byte[]{95, Ascii.SYN, 106, 16, 68, 19, 14, Ascii.SYN, Ascii.DC2, 51, 68, 12, 85, 14, 126, 4, 89, 6, 40, 10, Ascii.NAK, Ascii.SYN, 80, 9, 90}, "6e9e4c"), e);
            w6.c = -1;
            boolValueOf = Boolean.FALSE;
            if (cursorQuery == null) {
                return boolValueOf;
            }
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
        return boolValueOf;
    }
}
