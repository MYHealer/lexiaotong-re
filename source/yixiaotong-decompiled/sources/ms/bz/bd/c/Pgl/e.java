package ms.bz.bd.c.Pgl;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
final class e extends pblz.pgla {
    e() {
    }

    @Override // ms.bz.bd.c.Pgl.pblz.pgla
    public final Object c(long j, String str, Object obj) throws Throwable {
        Context contextTt = pblw.c().tt();
        return contextTt != null ? contextTt.getPackageName() : "";
    }
}
