package com.xiaomi.onetrack.util.oaid.helpers;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class f {
    private String a(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(s.d(new byte[]{69, 81, 92, 16, 93}, "300e8d"));
        String string = columnIndex > 0 ? cursor.getString(columnIndex) : null;
        int columnIndex2 = cursor.getColumnIndex(s.d(new byte[]{84, 12, 1, 93}, "7ce8eb"));
        if (columnIndex2 > 0) {
            cursor.getInt(columnIndex2);
        }
        int columnIndex3 = cursor.getColumnIndex(s.d(new byte[]{86, Ascii.FS, 73, 93, 71, 93, 5}, "3d9458"));
        if (columnIndex3 > 0) {
            cursor.getLong(columnIndex3);
        }
        return string;
    }

    public String a(Context context) {
        Uri uri = Uri.parse(s.d(new byte[]{84, 95, 94, SignedBytes.MAX_POWER_OF_TWO, 92, 90, Ascii.NAK, 94, 73, 77, 82, 10, 90, Ascii.RS, 93, 81, 80, 78, Ascii.DC4, 74, 0, 14, 72, 8, 82, Ascii.RS, 95, 68, 92, 90, 8, 0, Ascii.NAK, 6, 90, 74}, "700494"));
        String strA = "";
        try {
            Cursor cursorQuery = context.getContentResolver().query(uri, null, null, new String[]{s.d(new byte[]{92, 87, 89, 87}, "360344")}, null);
            strA = a(cursorQuery);
            cursorQuery.close();
            return strA;
        } catch (Throwable th) {
            th.printStackTrace();
            return strA;
        }
    }
}
