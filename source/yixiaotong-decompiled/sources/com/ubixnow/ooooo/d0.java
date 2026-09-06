package com.ubixnow.ooooo;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d0 implements j {
    private final Context OooO00o;

    public d0(Context context) {
        this.OooO00o = context;
    }

    @Override // com.ubixnow.ooooo.j
    public void OooO00o(i iVar) {
        if (this.OooO00o == null || iVar == null) {
            return;
        }
        try {
            Cursor cursorQuery = this.OooO00o.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            try {
                ((Cursor) Objects.requireNonNull(cursorQuery)).moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex(oOOOoo00.OooOo0o));
                if (string == null || string.length() == 0) {
                    throw new k("OAID query failed");
                }
                l.OooO00o("OAID query success: " + string);
                iVar.OooO00o(string);
                cursorQuery.close();
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            l.OooO00o(th3);
            iVar.OooO00o(th3);
        }
    }

    @Override // com.ubixnow.ooooo.j
    public boolean OooO00o() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        return m.OooO00o("persist.sys.identifierid.supported", "0").equals("1");
    }
}
