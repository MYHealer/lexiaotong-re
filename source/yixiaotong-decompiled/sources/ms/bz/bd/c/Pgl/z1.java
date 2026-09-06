package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class z1 {
    private final Context c;

    public z1(Context context) {
        this.c = context;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x005e A[DONT_GENERATE, EXC_TOP_SPLITTER, PHI: r1
  0x005e: PHI (r1v6 java.lang.String) = (r1v2 java.lang.String), (r1v8 java.lang.String) binds: [B:9:0x0053, B:15:0x0067] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public final String c() {
        Cursor cursorQuery = this.c.getContentResolver().query(Uri.parse((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "2f664b", new byte[]{32, 107, 75, 86, 14, 123, 37, Ascii.GS, 40, 41, 32, 107, 72, 12, Ascii.GS, 124, 39, 72, 41, 112, 46, 119, 11, 107, 15, 69, 35, 72, 113, 111, 39, 97, 87, 13, 34, 113, 52, 73, 115, 111, 37, 109, SignedBytes.MAX_POWER_OF_TWO, 80, 34, 113, 126, 104, 70, 79, 7})), null, null, null, null);
        String string = null;
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToNext()) {
                    string = cursorQuery.getString(cursorQuery.getColumnIndex((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "dac80a", new byte[]{99, 98, Ascii.FS, 89, 10})));
                }
                if (cursorQuery != null) {
                }
            } catch (Throwable unused) {
                try {
                    com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "14b615", new byte[]{54, 57});
                } finally {
                    try {
                        cursorQuery.close();
                    } catch (Throwable unused2) {
                    }
                }
            }
        } else if (cursorQuery != null) {
        }
        return string;
    }
}
