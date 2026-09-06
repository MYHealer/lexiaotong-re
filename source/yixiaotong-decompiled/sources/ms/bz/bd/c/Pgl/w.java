package ms.bz.bd.c.Pgl;

import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
final class w extends pblz.pgla {
    w() {
    }

    @Override // ms.bz.bd.c.Pgl.pblz.pgla
    protected final Object c(long j, String str, Object obj) throws Throwable {
        Throwable thTt = u1.c().tt();
        return thTt != null ? Arrays.toString(thTt.getStackTrace()) : "";
    }
}
