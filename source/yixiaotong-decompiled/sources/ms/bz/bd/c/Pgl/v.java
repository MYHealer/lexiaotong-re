package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
final class v extends pblz.pgla {
    v() {
    }

    @Override // ms.bz.bd.c.Pgl.pblz.pgla
    public final Object c(long j, String str, Object obj) throws Throwable {
        Context contextTt = pblw.c().tt();
        ApplicationInfo applicationInfo = contextTt.getPackageManager().getApplicationInfo(contextTt.getPackageName(), 0);
        String str2 = applicationInfo.sourceDir;
        return str2 == null ? applicationInfo.publicSourceDir : str2;
    }
}
