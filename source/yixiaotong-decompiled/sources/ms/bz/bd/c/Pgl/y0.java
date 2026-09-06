package ms.bz.bd.c.Pgl;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.google.common.base.Ascii;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class y0 {
    public static void c() {
        pblz.c(65537, new r0());
        pblz.c(65538, new s0());
        pblz.c(65539, new t0());
        pblz.c(InputDeviceCompat.SOURCE_TRACKBALL, new u0());
        pblz.c(65541, new v0());
        pblz.c(65542, new w0());
        pblz.c(65543, new x0());
        w1 w1Var = new w1();
        pblz.c(196609, w1Var);
        pblz.c(196610, w1Var);
        pblz.c(196611, w1Var);
        pblx t1Var = pbli.c() ? new t1() : new pblj();
        pblx.c(t1Var);
        pblz.c(131073, t1Var);
        pblz.c(131074, t1Var);
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e925f1", new byte[]{113, 45, 68, 79, 77, 10, 105, Ascii.US, 78, 100, 122, 58, 70, 68, 75, 102, 101, Ascii.DC4, 98, 118, 103, 123, 72, 82, Ascii.EM});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean tt(Context context, String str, String str2) {
        try {
            String[] list = context.getAssets().list(str);
            if (list.length <= 0) {
                try {
                    throw null;
                } catch (Throwable th) {
                    throw th;
                }
            }
            new File(str2).mkdirs();
            for (String str3 : list) {
                tt(context, str + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "33cbef", new byte[]{109})) + str3, str2 + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "025736", new byte[]{110})) + str3);
            }
            return true;
        } catch (Exception unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d4d5d7", new byte[]{118, 55, 17});
            return false;
        }
    }
}
