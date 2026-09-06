package com.hihonor.hianalytics.hnha;

import android.database.sqlite.SQLiteDatabase;
import com.hihonor.hianalytics.util.SystemUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
class b0 extends z {
    public b0() {
        super(SystemUtils.getContext(), "hianalytics_data.db", null, 4);
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
        if (a(sQLiteDatabase, "events", "_reqId")) {
            return;
        }
        sQLiteDatabase.execSQL("ALTER TABLE  events ADD COLUMN _reqId");
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        if (!a(sQLiteDatabase, "events", "_crMd")) {
            sQLiteDatabase.execSQL("ALTER TABLE  events ADD COLUMN _crMd TEXT");
        }
        if (!a(sQLiteDatabase, "events", "_kMd")) {
            sQLiteDatabase.execSQL("ALTER TABLE  events ADD COLUMN _kMd TEXT");
        }
        if (!a(sQLiteDatabase, "events", "_ksMd")) {
            sQLiteDatabase.execSQL("ALTER TABLE  events ADD COLUMN _ksMd TEXT");
        }
        if (!a(sQLiteDatabase, "events", "_dataState")) {
            sQLiteDatabase.execSQL("ALTER TABLE  events ADD COLUMN _dataState INTEGER NOT NULL DEFAULT 0");
        }
        if (!a(sQLiteDatabase, "idsInfo", "_crMd")) {
            sQLiteDatabase.execSQL("ALTER TABLE  idsInfo ADD COLUMN _crMd TEXT");
        }
        if (!a(sQLiteDatabase, "idsInfo", "_kMd")) {
            sQLiteDatabase.execSQL("ALTER TABLE  idsInfo ADD COLUMN _kMd TEXT");
        }
        if (a(sQLiteDatabase, "idsInfo", "_ksMd")) {
            return;
        }
        sQLiteDatabase.execSQL("ALTER TABLE  idsInfo ADD COLUMN _ksMd TEXT");
    }

    private void f(SQLiteDatabase sQLiteDatabase) {
        if (!a(sQLiteDatabase, "events", "_evtAppId")) {
            sQLiteDatabase.execSQL("ALTER TABLE  events ADD COLUMN _evtAppId TEXT");
        }
        if (a(sQLiteDatabase, "events", "_sdkVersion")) {
            return;
        }
        sQLiteDatabase.execSQL("ALTER TABLE  events ADD COLUMN _sdkVersion TEXT");
    }

    @Override // com.hihonor.hianalytics.hnha.z
    public String a() {
        return "EventSqliteHelper";
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS processes (_id INTEGER PRIMARY KEY AUTOINCREMENT,_cTime INTEGER NOT NULL DEFAULT 0,_pName TEXT NOT NULL UNIQUE)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS tagTypes (_id INTEGER PRIMARY KEY AUTOINCREMENT,_ttpId INTEGER NOT NULL,_cTime INTEGER NOT NULL DEFAULT 0,_tag TEXT NOT NULL,_type INTEGER NOT NULL DEFAULT 0)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS idsInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT,_iiTtId INTEGER NOT NULL,_cTime INTEGER NOT NULL DEFAULT 0,_appId TEXT NOT NULL,_url TEXT NOT NULL,_priority INTEGER NOT NULL DEFAULT 0,_crMd TEXT,_kMd TEXT,_ksMd TEXT,_idsInfoHash INTEGER NOT NULL DEFAULT 0,_idsInfo TEXT NOT NULL)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS events (_id INTEGER PRIMARY KEY AUTOINCREMENT,_eTtId INTEGER NOT NULL,_eIdsId INTEGER NOT NULL,_cTime INTEGER NOT NULL DEFAULT 0,_cTimeZone TEXT,_uTime INTEGER NOT NULL DEFAULT 0,_evtId TEXT NOT NULL,_sourceType INTEGER NOT NULL DEFAULT 0,_size INTEGER NOT NULL DEFAULT 0,_cnt TEXT NOT NULL,_state INTEGER NOT NULL DEFAULT 0,_sPId INTEGER NOT NULL DEFAULT 0,_evtAppId TEXT,_sdkVersion TEXT,_sId TEXT,_reqId TEXT,_crMd TEXT,_kMd TEXT,_ksMd TEXT,_dataState INTEGER NOT NULL DEFAULT 0,_sState INTEGER NOT NULL DEFAULT 0)");
            sQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS ttpIdIndex ON tagTypes (_tag,_type,_ttpId)");
            sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS iiTtIdIndex ON idsInfo (_appId,_url,_idsInfoHash,_iiTtId)");
            j2.a("EventSqliteHelper", "onCreate db=" + sQLiteDatabase);
        } catch (Throwable th) {
            j2.g("EventSqliteHelper", "onCreate db=" + sQLiteDatabase + ",failE=" + SystemUtils.getDesensitizedException(th));
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        j2.c("EventSqliteHelper", "onUpgrade oldVersion=" + i + ",newVersion=" + i2 + ",db=" + sQLiteDatabase);
        if (i <= 1 && i2 > 1) {
            d(sQLiteDatabase);
        }
        if (i <= 2 && i2 > 2) {
            e(sQLiteDatabase);
        }
        if (i > 3 || i2 <= 3) {
            return;
        }
        f(sQLiteDatabase);
    }
}
