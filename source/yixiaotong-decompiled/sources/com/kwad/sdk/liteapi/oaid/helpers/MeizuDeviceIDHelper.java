package com.kwad.sdk.liteapi.oaid.helpers;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import com.kwad.sdk.liteapi.LiteApiLogger;
import com.ubixnow.ooooo.oOOOoo00;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MeizuDeviceIDHelper {
    private static final String TAG = "MeizuDeviceIDHelper";
    private Context mContext;

    public MeizuDeviceIDHelper(Context context) {
        this.mContext = context;
    }

    public String getOAID() {
        String oaid = "";
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.mContext.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
                oaid = getOaid(cursorQuery);
                LiteApiLogger.i(TAG, "getOAID oaid:" + oaid);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                } finally {
                    OaidInnerUtils.closeQuietly(cursorQuery);
                }
            }
        } catch (Exception e) {
            LiteApiLogger.i(TAG, "getOAID service not found;");
            LiteApiLogger.printStackTrace(e);
        }
        return oaid;
    }

    private String getOaid(Cursor cursor) {
        String string = "";
        if (cursor != null && !cursor.isClosed()) {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(oOOOoo00.OooOo0o);
            string = columnIndex > 0 ? cursor.getString(columnIndex) : "";
            int columnIndex2 = cursor.getColumnIndex("code");
            if (columnIndex2 > 0) {
                cursor.getInt(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex("expired");
            if (columnIndex3 > 0) {
                cursor.getLong(columnIndex3);
            }
        }
        return string;
    }

    private boolean isMeizuSupport() {
        try {
            PackageManager packageManager = this.mContext.getPackageManager();
            return (packageManager == null || packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) == null) ? false : true;
        } catch (Exception e) {
            LiteApiLogger.printStackTrace(e);
        }
    }
}
