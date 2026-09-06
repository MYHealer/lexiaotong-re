package ms.bz.bd.c.Pgl;

import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
final class o0 extends pblz.pgla {
    o0() {
    }

    @Override // ms.bz.bd.c.Pgl.pblz.pgla
    public final Object c(long j, String str, Object obj) throws Throwable {
        String str2;
        try {
            Locale locale = pblw.c().tt().getResources().getConfiguration().locale;
            str2 = locale.getLanguage() + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f131b6", new byte[]{72})) + locale.getCountry();
        } catch (Throwable unused) {
            str2 = null;
        }
        return v1.c(str2);
    }
}
