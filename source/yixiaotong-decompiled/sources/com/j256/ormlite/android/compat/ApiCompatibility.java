package com.j256.ormlite.android.compat;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface ApiCompatibility {

    public interface CancellationHook {
        void cancel();
    }

    CancellationHook createCancellationHook();

    Cursor rawQuery(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, CancellationHook cancellationHook);
}
