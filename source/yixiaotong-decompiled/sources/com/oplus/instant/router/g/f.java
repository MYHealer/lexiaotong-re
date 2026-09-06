package com.oplus.instant.router.g;

import android.database.Cursor;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class f {
    public static Map<String, Object> a(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        try {
            Map<String, Object> mapB = b(cursor);
            try {
                cursor.close();
            } catch (Throwable th) {
                d.a("ResponseUtil", th);
            }
            return mapB;
        } catch (Throwable th2) {
            try {
                d.a("ResponseUtil", th2);
                try {
                    return null;
                } catch (Throwable th3) {
                    return null;
                }
            } finally {
                try {
                    cursor.close();
                } catch (Throwable th4) {
                    d.a("ResponseUtil", th4);
                }
            }
        }
    }

    private static Map<String, Object> b(Cursor cursor) throws Throwable {
        HashMap map = new HashMap();
        if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
            do {
                map.putAll(c(cursor));
            } while (cursor.moveToNext());
        }
        return map;
    }

    private static Map<String, Object> c(Cursor cursor) {
        Object objValueOf;
        HashMap map = new HashMap();
        for (String str : cursor.getColumnNames()) {
            int columnIndex = cursor.getColumnIndex(str);
            int type = cursor.getType(columnIndex);
            if (type == 1) {
                objValueOf = Long.valueOf(cursor.getLong(columnIndex));
            } else if (type != 2) {
                if (type == 3) {
                    objValueOf = cursor.getString(columnIndex);
                } else if (type == 4) {
                    map.put(str, cursor.getBlob(columnIndex));
                }
            } else {
                objValueOf = Double.valueOf(cursor.getDouble(columnIndex));
            }
            map.put(str, objValueOf);
        }
        return map;
    }
}
