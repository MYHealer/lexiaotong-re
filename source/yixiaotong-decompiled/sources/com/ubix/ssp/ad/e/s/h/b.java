package com.ubix.ssp.ad.e.s.h;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.ubix.ssp.ad.e.a0.u;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b extends SQLiteOpenHelper {
    public b(Context context) {
        super(context, "UbixDownload.db", (SQLiteDatabase.CursorFactory) null, 10000);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        u.b("DbOpenHelper", "onCreate() -> info=create table if not exists t_ubixad_download_info(id varchar(500),downloadUrl varchar(100),filePath varchar(100),size integer,downloadLocation integer,downloadStatus integer)");
        sQLiteDatabase.execSQL("create table if not exists t_ubixad_download_info(id varchar(500),downloadUrl varchar(100),filePath varchar(100),size integer,downloadLocation integer,downloadStatus integer)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("drop table if exists t_ubixad_download_info");
        onCreate(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("drop table if exists t_ubixad_download_info");
        onCreate(sQLiteDatabase);
    }
}
