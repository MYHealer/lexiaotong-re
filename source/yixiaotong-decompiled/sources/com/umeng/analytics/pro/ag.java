package com.umeng.analytics.pro;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: compiled from: NubiaDeviceIdSupplier.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class ag implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9096a = "content://cn.nubia.provider.deviceid.dataid/oaid";

    ag() {
    }

    @Override // com.umeng.analytics.pro.z
    public String a(Context context) {
        String string = null;
        if (context == null) {
            return null;
        }
        Cursor cursorQuery = context.getContentResolver().query(Uri.parse(f9096a), null, null, null, null);
        if (cursorQuery != null) {
            string = cursorQuery.moveToNext() ? cursorQuery.getString(cursorQuery.getColumnIndex("device_ids_grndid")) : null;
            cursorQuery.close();
        }
        return string;
    }
}
