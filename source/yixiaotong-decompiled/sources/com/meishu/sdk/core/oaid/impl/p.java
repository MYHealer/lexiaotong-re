package com.meishu.sdk.core.oaid.impl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.meishu.sdk.core.oaid.OAIDException;
import com.ubixnow.ooooo.oOOOoo00;
import java.util.Objects;

/* JADX INFO: compiled from: VivoImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class p implements com.meishu.sdk.core.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4842a;

    public p(Context context) {
        this.f4842a = context;
    }

    @Override // com.meishu.sdk.core.oaid.b
    public boolean a() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        return com.meishu.sdk.core.oaid.c.a("persist.sys.identifierid.supported", "0").equals("1");
    }

    @Override // com.meishu.sdk.core.oaid.b
    public void a(com.meishu.sdk.core.oaid.a aVar) {
        if (this.f4842a == null || aVar == null) {
            return;
        }
        try {
            Cursor cursorQuery = this.f4842a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            try {
                ((Cursor) Objects.requireNonNull(cursorQuery)).moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex(oOOOoo00.OooOo0o));
                if (string != null && string.length() != 0) {
                    ((com.meishu.sdk.core.utils.l) aVar).a(string);
                    cursorQuery.close();
                    return;
                }
                throw new OAIDException("OAID query failed");
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
            ((com.meishu.sdk.core.utils.l) aVar).a(e);
        }
    }
}
