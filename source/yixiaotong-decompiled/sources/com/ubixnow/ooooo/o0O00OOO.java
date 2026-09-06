package com.ubixnow.ooooo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.exoplayer2.text.ttml.TtmlNode;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o0O00OOO extends o0OoO00O<o0oO0Ooo> {
    public static final String OooO0O0 = "SpDao";
    private static final String OooO0OO = "spinfo";

    public o0O00OOO(Context context) {
        super(context);
    }

    public static void OooO00o(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table spinfo(_id integer primary key autoincrement, keys text,body text)");
    }

    public static void OooO0O0(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("drop table if exists spinfo");
    }

    public String OooO00o(String str) {
        Cursor cursorRawQuery = OooO0O0().rawQuery("select * from spinfo where keys = ?", new String[]{str});
        o0oO0Ooo o0oo0ooo = new o0oO0Ooo();
        while (cursorRawQuery.moveToNext()) {
            o0oo0ooo.OooO00o = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("keys"));
            o0oo0ooo.OooO0O0 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(TtmlNode.TAG_BODY));
        }
        cursorRawQuery.close();
        return o0oo0ooo.OooO0O0;
    }

    public void OooO00o(o0oO0Ooo o0oo0ooo) {
        String str;
        SQLiteDatabase sQLiteDatabaseOooO0OO = OooO0OO();
        Cursor cursorRawQuery = sQLiteDatabaseOooO0OO.rawQuery("select * from spinfo where keys = ?", new String[]{o0oo0ooo.OooO00o});
        if (cursorRawQuery == null || cursorRawQuery.getCount() <= 0) {
            sQLiteDatabaseOooO0OO.execSQL("insert into spinfo(keys,body) values(?,?)", new Object[]{o0oo0ooo.OooO00o, o0oo0ooo.OooO0O0});
            str = "insert";
        } else {
            String str2 = o0oo0ooo.OooO00o;
            sQLiteDatabaseOooO0OO.execSQL("update spinfo set  keys=?,body=? where keys = ? ", new Object[]{str2, o0oo0ooo.OooO0O0, str2});
            str = "update";
        }
        ooooO000.OooO00o(OooO0O0, str);
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
}
