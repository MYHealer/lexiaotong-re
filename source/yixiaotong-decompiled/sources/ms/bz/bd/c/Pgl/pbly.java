package ms.bz.bd.c.Pgl;

import com.google.common.base.Ascii;
import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class pbly extends pblz.pgla {
    protected static void c(BufferedInputStream bufferedInputStream) {
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException unused) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "89a9c1", new byte[]{36, 56, 45, 78, 85});
            }
        }
    }

    protected static void c(DataOutputStream dataOutputStream) {
        if (dataOutputStream != null) {
            try {
                dataOutputStream.close();
            } catch (IOException unused) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "4633b1", new byte[]{40, 55, 127, 68, 82});
            }
        }
    }

    @Override // ms.bz.bd.c.Pgl.pblz.pgla
    public final Object c(int i, int i2, long j, String str, Object obj) throws Throwable {
        if (!g1.c((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "ebec9c", new byte[]{117, 110, Ascii.DC2, 5, 9, 125, 98, 13, 36, 54, 102, 109, Ascii.US, 4, Ascii.NAK, 125, 105, 77, 122, 26, 90, 84, 51, 37, 40, 81, 82}))) {
            return null;
        }
        switch (i) {
            case 196609:
                Object[] objArr = (Object[]) obj;
                return c(str, (byte[]) objArr[0], (String) objArr[1], (String) objArr[2]);
            case 196610:
                Object[] objArr2 = (Object[]) obj;
                return c(str, (String) objArr2[0], (String) objArr2[1]);
            case 196611:
                Object[] objArr3 = (Object[]) obj;
                return tt(str, (String) objArr3[0], (String) objArr3[1]);
            default:
                return super.c(i, i2, j, str, obj);
        }
    }

    public abstract Object[] c(String str, String str2, String str3);

    public abstract Object[] c(String str, byte[] bArr, String str2, String str3);

    public abstract Object[] tt(String str, String str2, String str3);
}
