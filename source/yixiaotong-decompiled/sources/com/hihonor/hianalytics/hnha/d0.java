package com.hihonor.hianalytics.hnha;

import android.database.sqlite.SQLiteDatabase;
import com.hihonor.hianalytics.util.SystemUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
class d0 extends z {
    public d0() {
        super(SystemUtils.getContext(), "hianalytics_kv.db", null, 1);
    }

    @Override // com.hihonor.hianalytics.hnha.z
    public String a() {
        return "KVSqliteHelper";
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS kvContent (_id INTEGER PRIMARY KEY AUTOINCREMENT,_key TEXT NOT NULL UNIQUE,_value TEXT)");
            sQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS kvKeyIndex ON kvContent (_key)");
            j2.a("KVSqliteHelper", "onCreate db=" + sQLiteDatabase);
        } catch (Throwable th) {
            j2.g("KVSqliteHelper", "onCreate db=" + sQLiteDatabase + ",failE=" + SystemUtils.getDesensitizedException(th));
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        j2.c("KVSqliteHelper", "onUpgrade oldVersion=" + i + ",newVersion=" + i2 + ",db=" + sQLiteDatabase);
    }
}
