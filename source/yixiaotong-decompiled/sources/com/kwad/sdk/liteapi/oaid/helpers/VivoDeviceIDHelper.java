package com.kwad.sdk.liteapi.oaid.helpers;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.kwad.sdk.liteapi.LiteApiLogger;
import com.ubixnow.ooooo.oOOOoo00;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class VivoDeviceIDHelper {
    private static final String TAG = "VivoDeviceIDHelper";
    private Context mContext;

    public VivoDeviceIDHelper(Context context) {
        this.mContext = context;
    }

    public String getOAID() {
        String string = "";
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.mContext.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
                if (cursorQuery != null && cursorQuery.moveToNext()) {
                    string = cursorQuery.getString(cursorQuery.getColumnIndex(oOOOoo00.OooOo0o));
                    LiteApiLogger.i(TAG, "getOAID oaid:" + string);
                }
            } catch (Exception e) {
                LiteApiLogger.i(TAG, "getOAID fail");
                LiteApiLogger.printStackTraceOnly(e);
            }
            return string;
        } finally {
            OaidInnerUtils.closeQuietly(cursorQuery);
        }
    }
}
