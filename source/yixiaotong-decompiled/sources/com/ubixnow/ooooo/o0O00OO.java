package com.ubixnow.ooooo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o0O00OO extends o0OoO00O<ooOOOOoo.OooO0OO> {
    public static final String OooO0O0 = "ObjectDao";
    private static final String OooO0OO = "objectinfo";

    public o0O00OO(Context context) {
        super(context);
    }

    public static void OooO00o(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table objectinfo(_id integer primary key autoincrement, keys text,timestamp integer,value1 blob,value2 blob)");
    }

    public static void OooO0O0(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("drop table if exists objectinfo");
    }

    public List<ooOOOOoo.OooO0OO> OooO00o(String str) {
        Cursor cursorRawQuery = OooO0O0().rawQuery("select * from objectinfo where keys LIKE ?", new String[]{str + "%"});
        ArrayList arrayList = new ArrayList();
        while (cursorRawQuery.moveToNext()) {
            try {
                oO00OOO oo00oooOooO00o = oO00OOO.OooO00o(cursorRawQuery.getBlob(cursorRawQuery.getColumnIndex("value1")));
                ooOOOOoo.OooO0OO oooO0OO = new ooOOOOoo.OooO0OO();
                oooO0OO.OooO0OO = oo00oooOooO00o.OooO0Oo;
                oooO0OO.OooOO0 = oo00oooOooO00o.OooO0o0;
                oooO0OO.OooOO0o = oo00oooOooO00o.OooO0o;
                arrayList.add(oooO0OO);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        cursorRawQuery.close();
        return arrayList;
    }

    public void OooO00o(String str, long j) {
        SQLiteDatabase sQLiteDatabaseOooO0OO = OooO0OO();
        Cursor cursorRawQuery = sQLiteDatabaseOooO0OO.rawQuery("select * from objectinfo where keys = ?", new String[]{str});
        if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
            sQLiteDatabaseOooO0OO.execSQL("update objectinfo set  keys=?,timestamp=? where keys = ? ", new Object[]{str, Long.valueOf(j), str});
        }
        if (cursorRawQuery != null) {
            try {
                cursorRawQuery.close();
            } catch (Exception e) {
                ooooO000.OooO00o(OooO0O0, e.toString());
            }
        }
    }

    public void OooO00o(String str, long j, byte[] bArr) {
        SQLiteDatabase sQLiteDatabaseOooO0OO = OooO0OO();
        Cursor cursorRawQuery = sQLiteDatabaseOooO0OO.rawQuery("select * from objectinfo where keys = ?", new String[]{str});
        if (cursorRawQuery == null || cursorRawQuery.getCount() <= 0) {
            sQLiteDatabaseOooO0OO.execSQL("insert into objectinfo(keys,timestamp,value1) values(?,?,?)", new Object[]{str, Long.valueOf(j), bArr});
            ooooO000.OooO00o(OooO0O0, "insert");
        } else {
            sQLiteDatabaseOooO0OO.execSQL("update objectinfo set  keys=?,timestamp=?,value1=? where keys = ? ", new Object[]{str, Long.valueOf(j), bArr, str});
        }
        if (cursorRawQuery != null) {
            try {
                cursorRawQuery.close();
            } catch (Exception e) {
                ooooO000.OooO00o(OooO0O0, e.toString());
            }
        }
    }

    public void OooO00o(String str, long j, byte[] bArr, byte[] bArr2) {
        SQLiteDatabase sQLiteDatabaseOooO0OO = OooO0OO();
        Cursor cursorRawQuery = sQLiteDatabaseOooO0OO.rawQuery("select * from objectinfo where keys = ?", new String[]{str});
        if (cursorRawQuery == null || cursorRawQuery.getCount() <= 0) {
            sQLiteDatabaseOooO0OO.execSQL("insert into objectinfo(keys,timestamp,value1,value2) values(?,?,?,?)", new Object[]{str, Long.valueOf(j), bArr, bArr2});
            ooooO000.OooO00o(OooO0O0, "insert");
        } else {
            sQLiteDatabaseOooO0OO.execSQL("update objectinfo set  keys=?,timestamp=?,value1=?,value2=? where keys = ? ", new Object[]{str, Long.valueOf(j), bArr, bArr2, str});
        }
        if (cursorRawQuery != null) {
            try {
                cursorRawQuery.close();
            } catch (Exception e) {
                ooooO000.OooO00o(OooO0O0, e.toString());
            }
        }
    }

    public void OooO00o(String... strArr) {
        SQLiteDatabase sQLiteDatabaseOooO0OO = OooO0OO();
        if (sQLiteDatabaseOooO0OO != null) {
            for (String str : strArr) {
                sQLiteDatabaseOooO0OO.delete(OooO0OO, "keys LIKE ?", new String[]{"%" + str + "%"});
            }
        }
    }

    public long OooO0O0(String str) {
        try {
            Cursor cursorRawQuery = OooO0O0().rawQuery("select * from objectinfo where keys = ?", new String[]{str});
            if (cursorRawQuery.moveToNext()) {
                return cursorRawQuery.getLong(cursorRawQuery.getColumnIndex(com.alipay.sdk.tid.b.f));
            }
            cursorRawQuery.close();
            return 0L;
        } catch (Exception e) {
            ooooO000.OooO00o(OooO0O0, e.toString());
            return 0L;
        }
    }

    public byte[] OooO0OO(String str) {
        try {
            Cursor cursorRawQuery = OooO0O0().rawQuery("select * from objectinfo where keys = ?", new String[]{str});
            if (cursorRawQuery.moveToNext()) {
                return cursorRawQuery.getBlob(cursorRawQuery.getColumnIndex("value1"));
            }
            cursorRawQuery.close();
            return null;
        } catch (Exception e) {
            ooooO000.OooO00o(OooO0O0, e.toString());
            return null;
        }
    }

    public byte[] OooO0Oo(String str) {
        try {
            Cursor cursorRawQuery = OooO0O0().rawQuery("select * from objectinfo where keys = ?", new String[]{str});
            if (cursorRawQuery.moveToNext()) {
                return cursorRawQuery.getBlob(cursorRawQuery.getColumnIndex("value2"));
            }
            cursorRawQuery.close();
            return null;
        } catch (Exception e) {
            ooooO000.OooO00o(OooO0O0, e.toString());
            return null;
        }
    }
}
