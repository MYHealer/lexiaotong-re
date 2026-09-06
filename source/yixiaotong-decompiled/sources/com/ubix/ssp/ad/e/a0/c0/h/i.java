package com.ubix.ssp.ad.e.a0.c0.h;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.ubixnow.ooooo.oOOOoo00;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class i implements com.ubix.ssp.ad.e.a0.c0.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8654a;

    public i(Context context) {
        this.f8654a = context;
    }

    @Override // com.ubix.ssp.ad.e.a0.c0.d
    public void a(com.ubix.ssp.ad.e.a0.c0.c cVar) {
        if (this.f8654a == null || cVar == null) {
            return;
        }
        try {
            Cursor cursorQuery = this.f8654a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            try {
                ((Cursor) Objects.requireNonNull(cursorQuery)).moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex(oOOOoo00.OooOo0o));
                if (string == null || string.length() == 0) {
                    throw new com.ubix.ssp.ad.e.a0.c0.e("OAID query failed");
                }
                com.ubix.ssp.ad.e.a0.c0.f.a("OAID query success: " + string);
                cVar.a(string);
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
            com.ubix.ssp.ad.e.a0.c0.f.a(e);
            cVar.a(e);
        }
    }

    @Override // com.ubix.ssp.ad.e.a0.c0.d
    public boolean a() {
        Context context = this.f8654a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null;
        } catch (Exception e) {
            com.ubix.ssp.ad.e.a0.c0.f.a(e);
            return false;
        }
    }
}
