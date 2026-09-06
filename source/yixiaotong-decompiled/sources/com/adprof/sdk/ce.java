package com.adprof.sdk;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.ubixnow.ooooo.oOOOoo00;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ce implements jb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1110a;

    public ce(Context context) {
        this.f1110a = context;
    }

    @Override // com.adprof.sdk.jb
    public void a(eb ebVar) {
        if (this.f1110a == null || ebVar == null) {
            return;
        }
        try {
            Cursor cursorQuery = this.f1110a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
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
        Context context = this.f1110a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }
}
