package com.fancy;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.ubixnow.ooooo.oOOOoo00;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _p7 implements _eg {
    public final Context _a;

    public _p7(Context context) {
        this._a = context;
    }

    @Override // com.fancy._eg
    public final void _a(_a4 _a4Var) {
        String string = "";
        try {
            try {
                Cursor cursorQuery = this._a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
                if (cursorQuery != null) {
                    string = cursorQuery.moveToNext() ? cursorQuery.getString(cursorQuery.getColumnIndex(oOOOoo00.OooOo0o)) : "";
                    cursorQuery.close();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (_a4Var != null) {
                _a4Var._a(string);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
