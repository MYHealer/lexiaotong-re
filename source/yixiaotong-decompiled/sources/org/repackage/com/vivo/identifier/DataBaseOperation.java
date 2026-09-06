package org.repackage.com.vivo.identifier;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class DataBaseOperation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9730a = "VMS_IDLG_SDK_DB";
    private static final String b = "content://com.vivo.vms.IdProvider/IdentifierId";
    private static final String c = "value";
    private static final String d = "OAID";
    private static final String e = "AAID";
    private static final String f = "VAID";
    private static final String g = "OAIDSTATUS";
    private static final int h = 0;
    private static final int i = 1;
    private static final int j = 2;
    private static final int k = 4;
    private Context l;

    public DataBaseOperation(Context context) {
        this.l = context;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0054  */
    /* JADX WARN: Code duplicated, block: B:20:0x005a  */
    /* JADX WARN: Code duplicated, block: B:22:0x0069  */
    public String a(int i2, String str) {
        Uri uri;
        Uri uri2;
        Cursor cursorQuery;
        String string = null;
        if (i2 == 0) {
            uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
        } else if (i2 == 1) {
            uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str);
        } else if (i2 == 2) {
            uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str);
        } else {
            if (i2 != 4) {
                uri2 = null;
            } else {
                uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS");
            }
            cursorQuery = this.l.getContentResolver().query(uri2, null, null, null, null);
            if (cursorQuery != null) {
                string = cursorQuery.moveToNext() ? cursorQuery.getString(cursorQuery.getColumnIndex("value")) : null;
                cursorQuery.close();
            } else {
                Log.d(f9730a, "return cursor is null,return");
            }
            return string;
        }
        uri2 = uri;
        cursorQuery = this.l.getContentResolver().query(uri2, null, null, null, null);
        if (cursorQuery != null) {
            if (cursorQuery.moveToNext()) {
            }
            cursorQuery.close();
        } else {
            Log.d(f9730a, "return cursor is null,return");
        }
        return string;
    }
}
