package ms.bz.bd.c.Pgl;

import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import okio.Utf8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
final class x0 extends pblz.pgla {
    x0() {
    }

    @Override // ms.bz.bd.c.Pgl.pblz.pgla
    public final Object c(long j, String str, Object obj) throws Throwable {
        try {
            Class<?> cls = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fe9a42", new byte[]{116, 104, 71, 91, Ascii.CAN, 54, 43, 69, 102, 53, 101, 104, 67, 17, 69, 48, 98, 71, 38, 32, 98, 104, 94, Ascii.DC4, 69, 7, 65, 106, 109, 37, 96, 104, 88, Ascii.RS, Utf8.REPLACEMENT_BYTE, 36, 98, 103, 103, Utf8.REPLACEMENT_BYTE, 99, 98, 82, 1, 59, 55, 106, 82, 97, 53, 114, 117, 107, 17, 10, 53, 113, 65, 122}));
            Method declaredMethod = cls.getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "bff27e", new byte[]{126, 101, 7, 77, 41, 97, 79, 66, 32, 87, 96, 97, 7}), new Class[0]);
            declaredMethod.setAccessible(true);
            Object objNewInstance = cls.newInstance();
            if (objNewInstance == null || !((Boolean) declaredMethod.invoke(objNewInstance, new Object[0])).booleanValue()) {
                return null;
            }
            return (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "894e7b", new byte[]{39, 62, 80, 36, Ascii.ESC, 112, 41});
        } catch (Throwable unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "158d9a", new byte[]{39, 54, 77});
            return null;
        }
    }
}
