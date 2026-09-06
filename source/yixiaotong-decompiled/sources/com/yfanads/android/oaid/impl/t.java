package com.yfanads.android.oaid.impl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.ubixnow.ooooo.oOOOoo00;
import com.yfanads.android.oaid.utils.RomUtils;
import com.yfanads.android.utils.YFLog;
import java.util.Objects;

/* JADX INFO: compiled from: VivoImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class t implements com.yfanads.android.oaid.ifs.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9675a;

    public t(Context context) {
        this.f9675a = context;
    }

    @Override // com.yfanads.android.oaid.ifs.b
    public final boolean a() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        return RomUtils.sysProperty("persist.sys.identifierid.supported", "0").equals("1");
    }

    @Override // com.yfanads.android.oaid.ifs.b
    public final void a(com.yfanads.android.oaid.ifs.a aVar) {
        if (this.f9675a != null) {
            try {
                Cursor cursorQuery = this.f9675a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
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
