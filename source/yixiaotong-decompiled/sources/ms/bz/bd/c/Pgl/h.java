package ms.bz.bd.c.Pgl;

import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
final class h extends pblz.pgla {
    h() {
    }

    @Override // ms.bz.bd.c.Pgl.pblz.pgla
    public final Object c(long j, String str, Object obj) throws Throwable {
        String str2;
        try {
            Locale locale = pblw.c().tt().getResources().getConfiguration().locale;
            str2 = locale.getLanguage() + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "bb6a63", new byte[]{76})) + locale.getCountry();
        } catch (Throwable unused) {
            str2 = null;
        }
        return v1.c(str2);
    }
}
