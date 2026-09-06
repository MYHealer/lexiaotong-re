package com.meishu.sdk.core.oaid.impl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.meishu.sdk.core.oaid.OAIDException;
import com.ubixnow.ooooo.oOOOoo00;
import java.util.Objects;

/* JADX INFO: compiled from: MeizuImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class i implements com.meishu.sdk.core.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4834a;

    public i(Context context) {
        this.f4834a = context;
    }

    @Override // com.meishu.sdk.core.oaid.b
    public boolean a() {
        Context context = this.f4834a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.meishu.sdk.core.oaid.b
    public void a(com.meishu.sdk.core.oaid.a aVar) {
        if (this.f4834a == null || aVar == null) {
            return;
        }
        try {
            Cursor cursorQuery = this.f4834a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
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
