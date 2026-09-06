package com.xiaomi.onetrack.util.oaid.helpers;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.google.common.base.Ascii;
import com.xiaomi.onetrack.util.p;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9549a = s.d(new byte[]{98, 90, Ascii.DC4, 10, 39, 0, Ascii.ETB, 13, 5, 7, 120, 33, 124, 86, 14, Ascii.NAK, 6, Ascii.ETB}, "43bece");

    public String a(Context context) {
        String string = "";
        try {
            Cursor cursorQuery = context.getContentResolver().query(Uri.parse(s.d(new byte[]{83, 90, 13, 76, 0, 11, Ascii.NAK, 94, 73, 77, 82, 10, 93, Ascii.ESC, Ascii.NAK, 81, 19, 10, 79, Ascii.DC2, 11, 17, Ascii.US, 44, 84, 101, 17, 87, 19, 12, 5, 1, Ascii.DC4, 77, 120, 1, 85, 91, Ascii.ETB, 81, 3, 12, 4, Ascii.SYN, 47, 6, Ascii.RS, 42, 113, 124, 39}, "05c8ee")), null, null, null, null);
            if (cursorQuery != null) {
                string = cursorQuery.moveToNext() ? cursorQuery.getString(cursorQuery.getColumnIndex(s.d(new byte[]{Ascii.DC2, 83, 9, 68, 84}, "d2e11d"))) : "";
                cursorQuery.close();
            }
        } catch (Exception e) {
            p.a(f9549a, e.getMessage());
        }
        return string;
    }
}
