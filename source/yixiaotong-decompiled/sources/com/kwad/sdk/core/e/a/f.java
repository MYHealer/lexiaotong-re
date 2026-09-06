package com.kwad.sdk.core.e.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.ubixnow.ooooo.oOOOoo00;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class f {
    private Context mContext;

    public f(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        String oaid = "";
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.mContext.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
                oaid = getOaid(cursorQuery);
                com.kwad.sdk.core.d.c.i("MeizuDeviceIDHelper", "getOAID oaid:" + oaid);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                } finally {
                    h.closeQuietly(cursorQuery);
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.i("MeizuDeviceIDHelper", "getOAID service not found;");
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
        return oaid;
    }

    private static String getOaid(Cursor cursor) {
        String string = "";
        if (cursor != null && !cursor.isClosed()) {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(oOOOoo00.OooOo0o);
            string = columnIndex > 0 ? cursor.getString(columnIndex) : "";
            int columnIndex2 = cursor.getColumnIndex("code");
            if (columnIndex2 > 0) {
                cursor.getInt(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex("expired");
            if (columnIndex3 > 0) {
                cursor.getLong(columnIndex3);
            }
        }
        return string;
    }
}
