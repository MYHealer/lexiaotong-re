package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
final class t extends pblz.pgla {
    t() {
    }

    @Override // ms.bz.bd.c.Pgl.pblz.pgla
    protected final Object c(long j, String str, Object obj) throws Throwable {
        Context contextTt = pblw.c().tt();
        if (contextTt != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) contextTt.getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "7b00dc", new byte[]{37, 111, 77, 74, 94, 119, 32, 74, 119, 105, 50, 121}));
                Method declaredMethod = connectivityManager.getClass().getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "712c29", new byte[]{33, 54, 85, 54, 14, 58, Base64.padSymbol, 6, 102, Ascii.GS, 35, 39, 86, Ascii.CAN, Ascii.US, 37, Ascii.GS, Ascii.RS, 101, 60}), new Class[0]);
                declaredMethod.setAccessible(true);
                NetworkInfo networkInfo = (NetworkInfo) declaredMethod.invoke(connectivityManager, new Object[0]);
                if (networkInfo != null) {
                    Method declaredMethod2 = networkInfo.getClass().getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b1a2d9", new byte[]{122, 32, 51, 80, 90, 39, 109, 17, 50, 110, 118}), new Class[0]);
                    declaredMethod2.setAccessible(true);
                    return Boolean.valueOf(((Boolean) declaredMethod2.invoke(networkInfo, new Object[0])).booleanValue());
                }
            } catch (Throwable unused) {
            }
        }
        return Boolean.FALSE;
    }
}
