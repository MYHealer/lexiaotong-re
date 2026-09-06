package ms.bz.bd.c.Pgl;

import android.util.SparseArray;
import com.google.common.base.Ascii;
import okio.Utf8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class pblz {
    public static final /* synthetic */ int c = 0;
    private static final SparseArray<pgla> tt = new SparseArray<>();

    public static abstract class pgla {
        public Object c(int i, int i2, long j, String str, Object obj) throws Throwable {
            return c(j, str, obj);
        }

        protected Object c(long j, String str, Object obj) throws Throwable {
            return null;
        }
    }

    public static Object c(int i, int i2, long j, String str, Object obj) {
        pgla pglaVar = tt.get(i);
        if (pglaVar == null) {
            throw new RuntimeException(String.format((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "90798e", new byte[]{39, 34, 4, 78, 8, 118, Utf8.REPLACEMENT_BYTE, 81, 35, 109, 104, 59, 87, 13, 14, 124, 44, 16, 106, 96, 44}), Integer.valueOf(i)));
        }
        try {
            return pglaVar.c(i, i2, j, str, obj);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public static void c(int i, pgla pglaVar) {
        SparseArray<pgla> sparseArray = tt;
        pgla pglaVar2 = sparseArray.get(i);
        if (pglaVar2 != null) {
            throw new RuntimeException(String.format((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c6ad67", new byte[]{55, 39, 82, Ascii.CAN, 8, 36, 32, Ascii.NAK, 53, 49, 124, 116, 0, Ascii.NAK, 14, 41, 115, 3, 53, 38, 60}), pglaVar2.toString()));
        }
        sparseArray.put(i, pglaVar);
    }
}
