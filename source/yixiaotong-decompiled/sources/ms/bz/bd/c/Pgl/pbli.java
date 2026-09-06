package ms.bz.bd.c.Pgl;

import com.google.common.base.Ascii;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class pbli {
    public static boolean c() {
        return c((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0494bf", new byte[]{34, 57, 71, 14, 95, 104, 39, 16, 108, 101, 47, 53, 79, 14, 91, 99, 50, Ascii.CAN, 127, 107, 51, Base64.padSymbol, 4, 67, 82, 99, 54, 91, 123, 96, 42, 59, 69, 78, 84, 101, 60, 7, 38, 84, 38, 58, 121, 100, 118, 92, 60, Ascii.ESC, 97, 112, 46, 36, 127, 84, 84, 125, 32}));
    }

    private static boolean c(String... strArr) {
        boolean z;
        boolean z2 = true;
        for (String str : strArr) {
            try {
                Class.forName(str);
                z = true;
            } catch (Throwable unused) {
                z = false;
            }
            z2 &= z;
            if (!z2) {
                break;
            }
        }
        return z2;
    }
}
