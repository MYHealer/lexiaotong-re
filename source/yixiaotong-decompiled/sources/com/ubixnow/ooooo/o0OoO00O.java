package com.ubixnow.ooooo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class o0OoO00O<T> {
    private o0O00O0o OooO00o;

    public o0OoO00O(Context context) {
        this.OooO00o = new o0O00O0o(context, "ubixmdnow.db");
    }

    public void OooO00o() {
        this.OooO00o.close();
    }

    public SQLiteDatabase OooO0O0() {
        return this.OooO00o.getReadableDatabase();
    }

    public SQLiteDatabase OooO0OO() {
        return this.OooO00o.getWritableDatabase();
    }
}
