package com.adprof.sdk;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.ubixnow.ooooo.oOOOoo00;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ip implements jb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1239a;

    public ip(Context context) {
        this.f1239a = context;
    }

    @Override // com.adprof.sdk.jb
    public void a(eb ebVar) {
        if (this.f1239a == null || ebVar == null) {
            return;
        }
        try {
            Cursor cursorQuery = this.f1239a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            try {
                ((Cursor) Objects.requireNonNull(cursorQuery)).moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex(oOOOoo00.OooOo0o));
                if (string == null || string.length() == 0) {
                    throw new mg("OAID query failed");
                }
                ebVar.a(string);
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
        } catch (Exception e) {
            ebVar.a(e);
        }
    }

    @Override // com.adprof.sdk.jb
    public boolean a() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        return og.a("persist.sys.identifierid.supported", "0").equals("1");
    }
}
