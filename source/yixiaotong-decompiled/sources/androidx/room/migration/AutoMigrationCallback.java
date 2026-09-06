package androidx.room.migration;

import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public interface AutoMigrationCallback {
    default void onPostMigrate(SupportSQLiteDatabase db) {
    }
}
