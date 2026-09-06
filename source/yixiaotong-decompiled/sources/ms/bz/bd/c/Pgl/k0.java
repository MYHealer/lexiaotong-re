package ms.bz.bd.c.Pgl;

import android.content.Context;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
final class k0 extends pblz.pgla {
    k0() {
    }

    @Override // ms.bz.bd.c.Pgl.pblz.pgla
    public final Object c(long j, String str, Object obj) throws Throwable {
        double dDoubleValue;
        Context contextTt = pblw.c().tt();
        try {
            Class<?> cls = Class.forName(new String(pblr.c((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "922ed4", new byte[]{126, 99, Ascii.ETB, Ascii.ETB, 13, 39, 104, Ascii.SYN, 53, 100, 126, 53, Ascii.ETB, 69, 12, 113, 108, Ascii.NAK, 53, 108, 126, 100, 19, Ascii.DC4, 13, 122, 108, Ascii.SYN, 52, 97, 126, 101, Ascii.SYN, 67, 13, 38, 108, 66, 53, 54, 122, 53, Ascii.ETB, Ascii.ETB, 12, 112, 104, Ascii.SYN, 54, 101, 126, 54, Ascii.SYN, 70, 13, 118, 109, 65, 54, 101, 127, 98, Ascii.ETB, Ascii.ETB, 13, 117, 108, 74, 53, 54, 126, 101}))));
            Object objNewInstance = cls.getConstructor(Context.class).newInstance(contextTt);
            Method declaredMethod = cls.getDeclaredMethod(new String(pblr.c((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "81e6d5", new byte[]{127, 100, SignedBytes.MAX_POWER_OF_TWO, Ascii.ETB, 12, 118, 111, 65, 99, 48, 127, 102, 65, 16, 13, 115, 109, 71, 98, 51, 124, 99, SignedBytes.MAX_POWER_OF_TWO, 68, 12, 117, 109, 69, 99, 52}))), String.class);
            declaredMethod.setAccessible(true);
            dDoubleValue = ((Double) declaredMethod.invoke(objNewInstance, new String(pblr.c((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3a6d16", new byte[]{116, 49, 19, 65, 89, 117, 103, Ascii.DC4, 49, 97, 117, 49, Ascii.DC2, 73, 92, 36, 102, 19, 49, 101, 117, 51, 19, 65, 88, 114, 102, Ascii.EM, 48, 96, 117, 58}))))).doubleValue();
        } catch (Throwable unused) {
            dDoubleValue = 0.0d;
        }
        return Integer.toString((int) dDoubleValue);
    }
}
