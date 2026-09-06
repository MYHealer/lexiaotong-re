package ms.bz.bd.c.Pgl;

import com.byazt.nys.tt;
import com.google.common.base.Ascii;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
final class t0 extends pblz.pgla {
    t0() {
    }

    @Override // ms.bz.bd.c.Pgl.pblz.pgla
    public final Object c(long j, String str, Object obj) throws Throwable {
        File file = new File(tt.c(pblw.c().tt()), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "ecaf88", new byte[]{58, 108, 1, Ascii.SYN, 6, 59, 103}));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }
}
