package com.yfanads.android.oaid.impl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.ubixnow.ooooo.oOOOoo00;
import com.yfanads.android.utils.YFLog;
import java.util.Objects;

/* JADX INFO: compiled from: MeizuImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class j implements com.yfanads.android.oaid.ifs.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9666a;

    public j(Context context) {
        this.f9666a = context;
    }

    @Override // com.yfanads.android.oaid.ifs.b
    public final boolean a() {
        Context context = this.f9666a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null;
        } catch (Exception e) {
            YFLog.debug(e);
            return false;
        }
    }

    @Override // com.yfanads.android.oaid.ifs.b
    public final void a(com.yfanads.android.oaid.ifs.a aVar) {
        if (this.f9666a != null) {
            try {
                Cursor cursorQuery = this.f9666a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
                try {
                    ((Cursor) Objects.requireNonNull(cursorQuery)).moveToFirst();
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex(oOOOoo00.OooOo0o));
                    if (string != null && string.length() != 0) {
                        YFLog.debug("OAID query success: ".concat(string));
                        aVar.onOAIDGetSuccess(string);
                        cursorQuery.close();
                        return;
                    }
                    throw new com.yfanads.android.oaid.a("OAID query failed");
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
                YFLog.debug(e);
                aVar.onOAIDGetFail(e);
            }
        }
    }
}
