package com.hihonor.hianalytics.hnha;

import android.database.sqlite.SQLiteDatabase;
import com.hihonor.hianalytics.util.SystemUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
class g0 extends z {
    public g0() {
        super(SystemUtils.getContext(), "hianalytics_stat.db", null, 3);
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
        if (!a(sQLiteDatabase, "statEvents", "_reqId")) {
            sQLiteDatabase.execSQL("ALTER TABLE statEvents ADD COLUMN _reqId TEXT");
        }
        if (!a(sQLiteDatabase, "statEvents", "_dataState")) {
            sQLiteDatabase.execSQL("ALTER TABLE  statEvents ADD COLUMN _dataState INTEGER NOT NULL DEFAULT 0");
        }
        if (!a(sQLiteDatabase, "statReports", "_reqId")) {
            sQLiteDatabase.execSQL("ALTER TABLE statReports ADD COLUMN _reqId TEXT");
        }
        if (!a(sQLiteDatabase, "statReports", "_dataState")) {
            sQLiteDatabase.execSQL("ALTER TABLE  statReports ADD COLUMN _dataState INTEGER NOT NULL DEFAULT 0");
        }
        if (!a(sQLiteDatabase, "statNetSends", "_reqId")) {
            sQLiteDatabase.execSQL("ALTER TABLE statNetSends ADD COLUMN _reqId TEXT");
        }
        if (a(sQLiteDatabase, "statNetSends", "_dataState")) {
            return;
        }
        sQLiteDatabase.execSQL("ALTER TABLE  statNetSends ADD COLUMN _dataState INTEGER NOT NULL DEFAULT 0");
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        if (!a(sQLiteDatabase, "statEvents", "_otherDesc")) {
            sQLiteDatabase.execSQL("ALTER TABLE statEvents ADD COLUMN _otherDesc TEXT");
        }
        if (!a(sQLiteDatabase, "statEvents", "_cTime")) {
            sQLiteDatabase.execSQL("ALTER TABLE  statEvents ADD COLUMN _cTime INTEGER NOT NULL DEFAULT 0");
        }
        if (!a(sQLiteDatabase, "statReports", "_otherDesc")) {
            sQLiteDatabase.execSQL("ALTER TABLE statReports ADD COLUMN _otherDesc TEXT");
        }
        if (!a(sQLiteDatabase, "statReports", "_cTime")) {
            sQLiteDatabase.execSQL("ALTER TABLE  statReports ADD COLUMN _cTime INTEGER NOT NULL DEFAULT 0");
        }
        if (!a(sQLiteDatabase, "statNetSends", "_otherDesc")) {
            sQLiteDatabase.execSQL("ALTER TABLE statNetSends ADD COLUMN _otherDesc TEXT");
        }
        if (a(sQLiteDatabase, "statNetSends", "_cTime")) {
            return;
        }
        sQLiteDatabase.execSQL("ALTER TABLE  statNetSends ADD COLUMN _cTime INTEGER NOT NULL DEFAULT 0");
    }

    @Override // com.hihonor.hianalytics.hnha.z
    public String a() {
        return "StatSqliteHelper";
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS statEvents (_id INTEGER PRIMARY KEY AUTOINCREMENT,_statType INTEGER NOT NULL DEFAULT 0,_sTime INTEGER NOT NULL DEFAULT 0,_sTimeZone TEXT NOT NULL,_cTime INTEGER NOT NULL DEFAULT 0,_appId TEXT NOT NULL,_sdkVersion TEXT NOT NULL,_appVersion TEXT NOT NULL,_statNum INTEGER NOT NULL DEFAULT 0,_state INTEGER NOT NULL DEFAULT 0,_tag TEXT NOT NULL,_type INTEGER NOT NULL DEFAULT 0,_evtId TEXT NOT NULL,_reqId TEXT,_otherDesc TEXT,_dataState INTEGER NOT NULL DEFAULT 0,_sourceType INTEGER NOT NULL DEFAULT 0)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS statReports (_id INTEGER PRIMARY KEY AUTOINCREMENT,_statType INTEGER NOT NULL DEFAULT 0,_sTime INTEGER NOT NULL DEFAULT 0,_sTimeZone TEXT NOT NULL,_cTime INTEGER NOT NULL DEFAULT 0,_appId TEXT NOT NULL,_sdkVersion TEXT NOT NULL,_appVersion TEXT NOT NULL,_statNum INTEGER NOT NULL DEFAULT 0,_state INTEGER NOT NULL DEFAULT 0,_tag TEXT NOT NULL,_type INTEGER NOT NULL DEFAULT 0,_reqId TEXT,_otherDesc TEXT,_dataState INTEGER NOT NULL DEFAULT 0,_reportType INTEGER NOT NULL DEFAULT 0)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS statNetSends (_id INTEGER PRIMARY KEY AUTOINCREMENT,_statType INTEGER NOT NULL DEFAULT 0,_sTime INTEGER NOT NULL DEFAULT 0,_sTimeZone TEXT NOT NULL,_cTime INTEGER NOT NULL DEFAULT 0,_appId TEXT NOT NULL,_sdkVersion TEXT NOT NULL,_appVersion TEXT NOT NULL,_statNum INTEGER NOT NULL DEFAULT 0,_state INTEGER NOT NULL DEFAULT 0,_type INTEGER NOT NULL DEFAULT 0,_reportType INTEGER NOT NULL DEFAULT 0,_url TEXT NOT NULL,_reqId TEXT,_otherDesc TEXT,_dataState INTEGER NOT NULL DEFAULT 0,_netCode INTEGER NOT NULL DEFAULT 0)");
            j2.a("StatSqliteHelper", "onCreate db=" + sQLiteDatabase);
        } catch (Throwable th) {
            j2.g("StatSqliteHelper", "onCreate db=" + sQLiteDatabase + ",failE=" + SystemUtils.getDesensitizedException(th));
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        j2.c("StatSqliteHelper", "onUpgrade oldVersion=" + i + ",newVersion=" + i2 + ",db=" + sQLiteDatabase);
        if (i <= 1 && i2 > 1) {
            d(sQLiteDatabase);
        }
        if (i > 2 || i2 <= 2) {
            return;
        }
        e(sQLiteDatabase);
    }
}
