package ms.bz.bd.c.Pgl;

import java.util.TimeZone;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
final class n0 extends pblz.pgla {
    n0() {
    }

    @Override // ms.bz.bd.c.Pgl.pblz.pgla
    public final Object c(long j, String str, Object obj) throws Throwable {
        String id;
        int rawOffset;
        try {
            TimeZone timeZone = TimeZone.getDefault();
            id = timeZone.getID();
            try {
                rawOffset = ((timeZone.getRawOffset() / 60) / 60) / 1000;
            } catch (Throwable unused) {
                rawOffset = 0;
            }
        } catch (Throwable unused2) {
            id = null;
        }
        return id + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "62dc3d", new byte[]{107})) + rawOffset;
    }
}
