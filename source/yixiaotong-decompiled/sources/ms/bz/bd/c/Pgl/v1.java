package ms.bz.bd.c.Pgl;

import kotlin.text.Typography;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class v1 {
    static {
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f62ed5", new byte[]{76, 104, 0, 79, 102});
    }

    public static String c(String str) {
        return (str == null || str.length() <= 0) ? "" : str.trim().replace('\'', ' ').replace(Typography.quote, ' ').replace('\r', ' ').replace('\n', ' ');
    }
}
