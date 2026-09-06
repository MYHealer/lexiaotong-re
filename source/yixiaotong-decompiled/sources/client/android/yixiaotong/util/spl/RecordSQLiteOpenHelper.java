package client.android.yixiaotong.util.spl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class RecordSQLiteOpenHelper extends SQLiteOpenHelper {
    private static String name = "record.db";
    private static Integer version = 1;

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public RecordSQLiteOpenHelper(Context context) {
        super(context, name, (SQLiteDatabase.CursorFactory) null, version.intValue());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table records(id integer primary key autoincrement,name varchar(200))");
    }
}
