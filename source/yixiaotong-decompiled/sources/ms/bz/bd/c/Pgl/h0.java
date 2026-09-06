package ms.bz.bd.c.Pgl;

import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import java.util.HashSet;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
final class h0 extends pblz.pgla {
    h0() {
    }

    @Override // ms.bz.bd.c.Pgl.pblz.pgla
    public final Object c(long j, String str, Object obj) throws Throwable {
        String[] strArr = {(String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fed4f9", new byte[]{120, 119, 7, 79}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "180b4e", new byte[]{45, 51, 86, Ascii.US}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "411fb1", new byte[]{51, 58, 84, Ascii.GS}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f724c7", new byte[]{122, 48, 72, 90, 73}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a30e30", new byte[]{98, 52, 71, Ascii.FS, 5}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c0a91c", new byte[]{106, 59, 19, 66, 3, 125}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "dab23c", new byte[]{125, 118, 16, 81, 9, 125}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3da7cb", new byte[]{45, 104, Ascii.ETB, 83, 80, 96, 35}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "7577cb", new byte[]{42, 62, 74, 70, 93, 114, 49}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3a73c2", new byte[]{49, 98, 73, 84, 73, 43, 55}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "91d06e", new byte[]{48, 35, Ascii.CAN, 87, 12, 118}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "683138", new byte[]{105, 54, 69, 80, 5, 97}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "2becee", new byte[]{49, 101, Ascii.ETB, Ascii.ESC, 87, 119}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "01cded", new byte[]{32, 32, 5, 3}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "38318d", new byte[]{32, 54, 65, 70, 12, 96, 56, Ascii.CAN, 112, 106}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "ded861", new byte[]{120, 98, Ascii.RS, 88, Ascii.FS}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "825fba", new byte[]{37, 57, 68, 1, 72}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c1863b", new byte[]{125, 35, 71, 87, Ascii.US}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "513756", new byte[]{44, 60, 78, 76, Ascii.CAN})};
        HashSet hashSet = new HashSet();
        try {
            Method declaredMethod = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "56003b", new byte[]{37, 58, 71, 86, 3, 124, 50, 89, 110, 115, 106, 7, 70, 86, 26, 124, 53, Ascii.DC2, 76, 97, 42, 53, 68, 65, Ascii.RS})).getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a580bc", new byte[]{124, 62, 88, 80, 110, 113, 112, 2, 96, 99, 117, 36}), new Class[0]);
            declaredMethod.setAccessible(true);
            String[] strArr2 = (String[]) declaredMethod.invoke(null, new Object[0]);
            if (strArr2 != null) {
                for (String str2 : strArr2) {
                    for (int i = 0; i < 19; i++) {
                        String str3 = strArr[i];
                        if (str2.toLowerCase().contains(str3)) {
                            hashSet.add(str3);
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return hashSet.toString();
    }
}
