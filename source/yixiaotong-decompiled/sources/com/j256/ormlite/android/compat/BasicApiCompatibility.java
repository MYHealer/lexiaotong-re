package com.j256.ormlite.android.compat;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class BasicApiCompatibility implements ApiCompatibility {
    @Override // com.j256.ormlite.android.compat.ApiCompatibility
    public ApiCompatibility.CancellationHook createCancellationHook() {
        return null;
    }

    @Override // com.j256.ormlite.android.compat.ApiCompatibility
    public Cursor rawQuery(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, ApiCompatibility.CancellationHook cancellationHook) {
        return sQLiteDatabase.rawQuery(str, strArr);
    }
}
