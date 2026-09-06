package com.umeng.analytics.process;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.umeng.analytics.pro.h;
import java.io.File;

/* JADX INFO: compiled from: UMProcessDBCreater.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class b extends SQLiteOpenHelper {
    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    b(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    static b a(Context context, String str) {
        String strB = b(context, str);
        a.h.equals(str);
        return new b(context, strB, null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("create table if not exists __et_p(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __pn TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    public static String a(Context context) {
        return h.b(context) + "subprocess/";
    }

    public static String b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = a.h;
        }
        String strB = h.b(context) + "subprocess/";
        if (a.h.equals(str)) {
            strB = h.b(context);
        }
        File file = new File(strB);
        if (!file.exists()) {
            file.mkdirs();
        }
        return String.format(strB + a.e, str);
    }
}
