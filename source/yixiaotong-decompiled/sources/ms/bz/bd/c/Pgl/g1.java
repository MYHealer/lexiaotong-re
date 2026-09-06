package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.os.Process;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class g1 {
    public static boolean c(String... strArr) {
        try {
            Context contextTt = pblw.c().tt();
            for (String str : strArr) {
                if (contextTt.checkPermission(str, Process.myPid(), Process.myUid()) != 0) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
