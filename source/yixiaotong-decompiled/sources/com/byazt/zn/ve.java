package com.byazt.zn;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.byazt.gq.t;
import com.byazt.nr.m;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 501, 54})
public class ve {
    public static volatile ve tt;
    public SQLiteDatabase c;

    public static ve c() {
        if (tt == null) {
            synchronized (ve.class) {
                if (tt == null) {
                    tt = new ve();
                }
            }
        }
        return tt;
    }

    private ve() {
        try {
            this.c = new tt(t.getContext()).getWritableDatabase();
        } catch (Throwable th) {
            com.byazt.dm.ve.c().c(th, "ClickEventHelper");
        }
    }

    public boolean tt() {
        return com.byazt.k.c.ve().c("click_event_switch", 0) == 1;
    }

    public boolean ve() {
        return com.byazt.k.c.ve().c("click_event_switch", 0) == 2;
    }

    public void c(long j, String str) {
        SQLiteDatabase sQLiteDatabase = this.c;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String strOptString = new JSONObject(str).optString("req_id");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("ad_id", Long.valueOf(j));
            contentValues.put("req_id", strOptString);
            contentValues.put(CrashHianalyticsData.TIME, Long.valueOf(System.currentTimeMillis()));
            this.c.insert("click_event", null, contentValues);
        } catch (Exception e) {
            m.c(e);
        }
        ve(j, str);
    }

    public boolean tt(long j, String str) {
        SQLiteDatabase sQLiteDatabase = this.c;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursorQuery = null;
        try {
            try {
                String strOptString = new JSONObject(str).optString("req_id");
                if (TextUtils.isEmpty(strOptString)) {
                    return false;
                }
                cursorQuery = this.c.query("click_event", tt.c, "time > ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j), strOptString}, null, null, null, null);
                boolean z = cursorQuery.getCount() > 0;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return z;
            } catch (Exception e) {
                m.c(e);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return false;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    private void ve(long j, String str) {
        SQLiteDatabase sQLiteDatabase = this.c;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String strOptString = new JSONObject(str).optString("req_id");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            this.c.delete("click_event", "time < ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j), strOptString});
        } catch (Exception e) {
            m.c(e);
        }
    }
}
