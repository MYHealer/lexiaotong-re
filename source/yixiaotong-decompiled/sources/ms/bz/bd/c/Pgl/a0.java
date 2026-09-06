package ms.bz.bd.c.Pgl;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
final class a0 extends pblz.pgla {
    a0() {
    }

    @Override // ms.bz.bd.c.Pgl.pblz.pgla
    protected final Object c(long j, String str, Object obj) throws Throwable {
        Boolean bool = Boolean.FALSE;
        try {
            Context contextTt = pblw.c().tt();
            if (contextTt != null) {
                return Boolean.valueOf((contextTt.getApplicationInfo() == null || (contextTt.getApplicationInfo().flags & 2) == 0) ? false : true);
            }
            return bool;
        } catch (Throwable unused) {
            return Boolean.FALSE;
        }
    }
}
