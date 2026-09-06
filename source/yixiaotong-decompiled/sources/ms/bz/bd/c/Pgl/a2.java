package ms.bz.bd.c.Pgl;

import android.content.Context;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.lang.reflect.Method;
import okio.Utf8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class a2 {
    private final Context c;
    private Class tt;
    private Method uj;
    private Object ve;

    public a2(Context context) {
        this.c = context;
        try {
            Class<?> cls = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6fd825", new byte[]{36, 107, 26, 2, 12, 44, 49, 85, 58, 97, 35, 42, Ascii.RS, 72, 67, 43, 56, 87, 57, 38, 14, 96, 39, 94, 2, 52, 60, 67, 48, 122, 14, 105, 7, SignedBytes.MAX_POWER_OF_TWO}));
            this.tt = cls;
            this.ve = cls.newInstance();
        } catch (Exception unused) {
        }
        try {
            this.uj = this.tt.getMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "589b43", new byte[]{35, Utf8.REPLACEMENT_BYTE, 94, 57, 42, 13, Ascii.DC2}), Context.class);
        } catch (Exception unused2) {
        }
    }

    public final String c() {
        Context context = this.c;
        Method method = this.uj;
        Object obj = this.ve;
        if (obj != null && method != null) {
            try {
                return (String) method.invoke(obj, context);
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
