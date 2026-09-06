package com.fancy;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.ubixnow.ooooo.oOOOoo00;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _g0 implements _eg {
    public final Context _a;

    public _g0(Context context) {
        this._a = context;
    }

    @Override // com.fancy._eg
    public final void _a(_a4 _a4Var) {
        try {
            Context context = this._a;
            if (context == null) {
                if (_a4Var != null) {
                    _a4Var._a("");
                    return;
                }
                return;
            }
            try {
                context.getPackageManager().getPackageInfo("com.meizu.flyme.openidsdk", 0);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                Cursor cursorQuery = this._a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
                String string = null;
                if (cursorQuery != null) {
                    try {
                        if (!cursorQuery.isClosed()) {
                            cursorQuery.moveToFirst();
                            int columnIndex = cursorQuery.getColumnIndex(oOOOoo00.OooOo0o);
                            string = columnIndex >= 0 ? cursorQuery.getString(columnIndex) : null;
                            int columnIndex2 = cursorQuery.getColumnIndex("code");
                            if (columnIndex2 > 0) {
                                cursorQuery.getInt(columnIndex2);
                            }
                            int columnIndex3 = cursorQuery.getColumnIndex("expired");
                            if (columnIndex3 > 0) {
                                cursorQuery.getLong(columnIndex3);
                            }
                        }
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
                if (_a4Var != null) {
                    _a4Var._a(string);
                }
                cursorQuery.close();
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        } catch (Throwable th4) {
            th4.printStackTrace();
        }
    }
}
