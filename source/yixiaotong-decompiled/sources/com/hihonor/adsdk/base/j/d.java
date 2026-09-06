package com.hihonor.adsdk.base.j;

import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class d {
    private static final String hnadsa = "DBUtil";

    public static Boolean hnadsa(SupportSQLiteDatabase supportSQLiteDatabase, String str, String str2) {
        boolean z = false;
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = supportSQLiteDatabase.query("Select * from " + str + " limit 1");
                boolean z2 = cursorQuery.getColumnIndex(str2) != -1;
                try {
                    cursorQuery.close();
                } catch (Exception e) {
                    com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "isFieldExist, close error, Exception: " + e.getMessage(), new Object[0]);
                }
                z = z2;
            } catch (Exception e2) {
                com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "isFieldExist, query error, Exception: " + e2.getMessage(), new Object[0]);
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Exception e3) {
                        com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "isFieldExist, close error, Exception: " + e3.getMessage(), new Object[0]);
                    }
                }
            }
            return Boolean.valueOf(z);
        } catch (Throwable th) {
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Exception e4) {
                    com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "isFieldExist, close error, Exception: " + e4.getMessage(), new Object[0]);
                }
            }
            throw th;
        }
    }
}
