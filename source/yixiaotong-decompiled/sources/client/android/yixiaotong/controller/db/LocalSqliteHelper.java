package client.android.yixiaotong.controller.db;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import client.android.yixiaotong.BaseApplication;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class LocalSqliteHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME_WALLET = "wallet";
    private static int sDBVersion = 9;

    public LocalSqliteHelper(String str) {
        super(BaseApplication.app, str, (SQLiteDatabase.CursorFactory) null, sDBVersion);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS wallet");
        sQLiteDatabase.execSQL("CREATE TABLE wallet (_id INTEGER PRIMARY KEY, ID INTEGER, name TEXT, subApp TEXT, typeId INTEGER, payType INTEGER, max INTEGER,refund INTEGER,icon TEXT,weiXinCharge INTEGER,aliCharge INTEGER,unionCharge INTEGER,IsUseCard INTEGER,IsRefund INTEGER,WeiXinRefund INTEGER,AliRefund INTEGER,wxAppid TEXT,wxGhId TEXT,WeiXinRefundAppId TEXT,WeiXinRefundSecret TEXT,serviceMobile TEXT,ABCCharge INTEGER)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (1 == i) {
            updateToVersion3F1(sQLiteDatabase);
        }
        if (2 == i) {
            updateToVersion3(sQLiteDatabase);
        }
        if (3 == i) {
            updateToVersion4(sQLiteDatabase);
        }
        if (4 == i) {
            updateToVersion5(sQLiteDatabase);
        }
        if (5 == i) {
            updateToVersion6(sQLiteDatabase);
        }
        if (6 == i) {
            updateToVersion7(sQLiteDatabase);
        }
        if (7 == i) {
            updateToVersion8(sQLiteDatabase);
        }
        if (8 == i) {
            updateToVersion9(sQLiteDatabase);
        }
    }

    private void updateToVersion3F1(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE wallet ADD refund INTEGER default 0");
        updateToVersion3(sQLiteDatabase);
    }

    private void updateToVersion3(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE wallet ADD weiXinCharge INTEGER default 0");
        sQLiteDatabase.execSQL("ALTER TABLE wallet ADD aliCharge INTEGER default 0");
        sQLiteDatabase.execSQL("ALTER TABLE wallet ADD unionCharge INTEGER default 0");
        updateToVersion4(sQLiteDatabase);
    }

    private void updateToVersion4(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE wallet ADD IsUseCard INTEGER default 0");
        updateToVersion5(sQLiteDatabase);
    }

    private void updateToVersion5(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE wallet ADD IsRefund INTEGER default 0");
        updateToVersion6(sQLiteDatabase);
    }

    private void updateToVersion6(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE wallet ADD WeiXinRefund INTEGER default 0");
        sQLiteDatabase.execSQL("ALTER TABLE wallet ADD AliRefund INTEGER default 0");
        updateToVersion7(sQLiteDatabase);
    }

    private void updateToVersion7(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE wallet ADD wxAppid TEXT");
        sQLiteDatabase.execSQL("ALTER TABLE wallet ADD wxGhId TEXT");
        updateToVersion8(sQLiteDatabase);
    }

    private void updateToVersion8(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE wallet ADD WeiXinRefundAppId TEXT");
        sQLiteDatabase.execSQL("ALTER TABLE wallet ADD WeiXinRefundSecret TEXT");
        sQLiteDatabase.execSQL("ALTER TABLE wallet ADD serviceMobile TEXT");
        updateToVersion9(sQLiteDatabase);
    }

    private void updateToVersion9(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE wallet ADD ABCCharge INTEGER default 0");
    }
}
