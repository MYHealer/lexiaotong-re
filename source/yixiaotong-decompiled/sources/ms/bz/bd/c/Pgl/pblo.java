package ms.bz.bd.c.Pgl;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class pblo {
    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                com.byazt.nr.m.c(e);
            }
        }
    }
}
