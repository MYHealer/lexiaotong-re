package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.google.common.base.Ascii;
import kotlin.io.encoding.Base64;
import okio.Utf8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class a1 {
    private final Context c;

    public a1(Context context) {
        this.c = context;
    }

    private static String c(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "37550b", new byte[]{52, 52, 74, 84, 10}));
        String string = columnIndex > 0 ? cursor.getString(columnIndex) : null;
        int columnIndex2 = cursor.getColumnIndex((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "81a346", new byte[]{42, 60, Ascii.SYN, 66}));
        if (columnIndex2 > 0) {
            cursor.getInt(columnIndex2);
        }
        int columnIndex3 = cursor.getColumnIndex((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fa1ba0", new byte[]{114, 123, 82, Ascii.US, 76, 34, 97}));
        if (columnIndex3 > 0) {
            cursor.getLong(columnIndex3);
        }
        return string;
    }

    public final void c(pblk.pblb pblbVar) {
        Cursor cursorQuery;
        try {
            this.c.getPackageManager().getPackageInfo((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "13a39e", new byte[]{35, 62, Ascii.US, 9, 11, 119, 59, 8, 37, 45, 38, Base64.padSymbol, 11, 74, 3, 60, Base64.padSymbol, 2, 53, 109, 41, 53, 1, 67, 13}), 0);
        } catch (Exception unused) {
        }
        Uri uri = Uri.parse((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fe0acc", new byte[]{116, 104, 77, 1, 89, 122, 113, Ascii.RS, 46, 126, 116, 104, 78, 91, 81, 113, 108, 94, 116, 127, 113, 107, 90, Ascii.CAN, 89, 58, 106, 84, 100, Utf8.REPLACEMENT_BYTE, 126, 99, 80, 17, 87, 59}));
        try {
            cursorQuery = this.c.getContentResolver().query(uri, null, null, new String[]{(String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fce8a6", new byte[]{120, 96, Ascii.US, 72})}, null);
            try {
                String strC = c(cursorQuery);
                if (pblbVar != null) {
                    pblbVar.c(strC);
                }
                if (cursorQuery == null) {
                    return;
                }
            } catch (Throwable unused2) {
                if (cursorQuery == null) {
                    return;
                }
            }
        } catch (Throwable unused3) {
            cursorQuery = null;
        }
        cursorQuery.close();
    }
}
