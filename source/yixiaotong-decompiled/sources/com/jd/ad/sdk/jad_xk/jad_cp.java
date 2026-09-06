package com.jd.ad.sdk.jad_xk;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.jd.ad.sdk.fdt.utils.ANEProxy;
import com.jd.ad.sdk.logger.Logger;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: DataBaseEventsStorage.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_cp extends com.jd.ad.sdk.jad_sf.jad_an {
    public static jad_cp jad_bo;

    public jad_cp(Context context, String str, int i) {
        super(context, str, i);
    }

    /* JADX INFO: Removed unreachable split cross block B:26:0x0047 */
    public synchronized void jad_an(jad_dq jad_dqVar, String str) {
        if (jad_dqVar != null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    getWritableDatabase();
                    if (!jad_bo()) {
                        return;
                    }
                    ContentValues contentValuesJad_bo = jad_bo(jad_dqVar, str);
                    int i = jad_dqVar.jad_an;
                    if (i > 0) {
                        this.jad_an.update("events", contentValuesJad_bo, "_id=?", new String[]{String.valueOf(i)});
                    } else {
                        this.jad_an.insert("events", null, contentValuesJad_bo);
                    }
                } catch (Throwable th) {
                    Logger.w("Exception while saving events: ", th);
                }
            }
        }
    }

    public final ContentValues jad_bo(jad_dq jad_dqVar, String str) {
        ContentValues contentValues;
        byte[] bytes;
        try {
            contentValues = new ContentValues(4);
            try {
                String string = jad_dqVar.jad_an().toString();
                if (!TextUtils.isEmpty(string)) {
                    String strJa = ANEProxy.ja(string);
                    if (!TextUtils.isEmpty(strJa) && (bytes = strJa.getBytes(StandardCharsets.UTF_8)) != null && bytes.length > 0) {
                        contentValues.put(NotificationCompat.CATEGORY_EVENT, new String(bytes));
                        if (!TextUtils.isEmpty(str)) {
                            contentValues.put(ContentProviderManager.PLUGIN_PROCESS_NAME, str);
                        }
                    }
                    return contentValues;
                }
            } catch (Exception e) {
                e = e;
                Logger.w("Exception while add event: ", e.getMessage());
            }
        } catch (Exception e2) {
            e = e2;
            contentValues = null;
        }
        return contentValues;
    }

    public void jad_cp() {
        try {
            getWritableDatabase();
            if (jad_bo()) {
                this.jad_an.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id INTEGER PRIMARY KEY AUTOINCREMENT,%s ,%s)", "events", NotificationCompat.CATEGORY_EVENT, ContentProviderManager.PLUGIN_PROCESS_NAME));
            }
        } catch (Exception e) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_CREATE_DB_ERROR;
            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id INTEGER PRIMARY KEY AUTOINCREMENT,%s,%s)", "events", NotificationCompat.CATEGORY_EVENT, ContentProviderManager.PLUGIN_PROCESS_NAME));
        } catch (Exception e) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_CREATE_DB_ERROR;
            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
        }
        this.jad_an = sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS events");
        onCreate(sQLiteDatabase);
    }

    public synchronized Cursor jad_an(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            getReadableDatabase();
            if (!jad_bo()) {
                return null;
            }
            return this.jad_an.query("events", null, "process_name =?", new String[]{str}, null, null, null);
        } catch (Throwable th) {
            Logger.w("Exception while loading events: ", th.getMessage());
            return null;
        }
        throw th;
    }

    public synchronized void jad_an(String str, String[] strArr) {
        try {
            try {
                getWritableDatabase();
                if (!jad_bo()) {
                    SQLiteDatabase sQLiteDatabase = this.jad_an;
                    if (sQLiteDatabase != null && sQLiteDatabase.inTransaction()) {
                        this.jad_an.endTransaction();
                    }
                    return;
                }
                this.jad_an.beginTransaction();
                this.jad_an.delete("events", str, strArr);
                this.jad_an.setTransactionSuccessful();
                SQLiteDatabase sQLiteDatabase2 = this.jad_an;
                if (sQLiteDatabase2 != null && sQLiteDatabase2.inTransaction()) {
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Throwable th) {
            try {
                Logger.w("Exception while clearing event: ", th.getMessage());
                SQLiteDatabase sQLiteDatabase3 = this.jad_an;
                if (sQLiteDatabase3 != null && sQLiteDatabase3.inTransaction()) {
                }
            } catch (Throwable th2) {
                SQLiteDatabase sQLiteDatabase4 = this.jad_an;
                if (sQLiteDatabase4 != null && sQLiteDatabase4.inTransaction()) {
                    this.jad_an.endTransaction();
                }
                throw th2;
            }
        }
        this.jad_an.endTransaction();
    }
}
