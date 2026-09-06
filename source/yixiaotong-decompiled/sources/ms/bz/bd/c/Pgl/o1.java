package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class o1 {
    private static o1 c;
    private Context tt;
    private ArrayList ve = new ArrayList();

    private o1(Context context) {
        this.tt = null;
        this.tt = context;
    }

    public static o1 c(Context context) {
        if (c == null) {
            synchronized (o1.class) {
                if (c == null) {
                    c = new o1(context);
                }
            }
        }
        return c;
    }

    public final int c() {
        Intent intentRegisterReceiver = this.tt.registerReceiver(null, new IntentFilter((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "9ac916", new byte[]{41, 109, Ascii.DC4, 95, 1, 40, 62, 14, 59, 103, 60, 102, Ascii.RS, 89, SignedBytes.MAX_POWER_OF_TWO, 32, 57, 84, 59, 102, 38, 45, 50, 108, 58, Ascii.NAK, Ascii.US, 114, 11, 86, 11, 75, 49, 99, 41, 4, Ascii.RS})));
        if (intentRegisterReceiver == null) {
            return -1;
        }
        return Math.round(((intentRegisterReceiver.getIntExtra((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "5aa482", new byte[]{40, 102, 4, 69, 11}), -1) / intentRegisterReceiver.getIntExtra((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "eeb620", new byte[]{103, 100, 16, 78, 8}), -1)) * 100.0f) * 10.0f) / 10;
    }

    public final synchronized int[] n() {
        int size = this.ve.size();
        if (size <= 0) {
            return new int[0];
        }
        if (size == 1) {
            return new int[]{((Integer) this.ve.get(0)).intValue()};
        }
        try {
            ArrayList arrayList = this.ve;
            int i = size - 10;
            if (i <= 0) {
                i = 0;
            }
            List listSubList = arrayList.subList(i, size);
            int[] iArr = new int[listSubList.size()];
            for (int i2 = 0; i2 < listSubList.size(); i2++) {
                iArr[i2] = ((Integer) listSubList.get(i2)).intValue();
            }
            return iArr;
        } catch (Throwable unused) {
            return new int[0];
        }
    }

    public final int tt() {
        Intent intentRegisterReceiver = this.tt.registerReceiver(null, new IntentFilter((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "9db7e8", new byte[]{41, 104, Ascii.NAK, 81, 85, 38, 62, 11, 58, 105, 60, 99, Ascii.US, 87, Ascii.DC4, 46, 57, 81, 58, 104, 38, 40, 51, 98, 110, Ascii.ESC, Ascii.US, 119, 10, 88, 11, 78, 48, 109, 125, 10, Ascii.RS})));
        if (intentRegisterReceiver == null) {
            return -1;
        }
        int intExtra = intentRegisterReceiver.getIntExtra((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "121b32", new byte[]{51, 36, 67, 2, Ascii.EM, 54}), -1);
        return (intExtra == 2 || intExtra == 5) ? 1 : 0;
    }

    public final void uj() {
        int i;
        int iVe;
        int iC;
        try {
            if (pble.c() != null) {
                try {
                    synchronized (this) {
                        try {
                            iVe = ve();
                            iC = c();
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    i = (iVe * 10000) + iC;
                } catch (Exception unused) {
                    i = -10001;
                }
                Integer numValueOf = Integer.valueOf(i);
                if (numValueOf == null) {
                    return;
                }
                this.ve.add(numValueOf);
                try {
                    int size = this.ve.size();
                    if (size > 20) {
                        ArrayList arrayList = new ArrayList(this.ve.subList(size - 10, size));
                        this.ve.clear();
                        this.ve = arrayList;
                        return;
                    }
                    return;
                } catch (Throwable unused2) {
                    return;
                }
            }
        } catch (Throwable unused3) {
        }
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d997ca", new byte[]{118, 51, 79, SignedBytes.MAX_POWER_OF_TWO, 87, 54, 97, Ascii.GS, 124, 100, 125, Ascii.EM, 75, 87, 72, 115, 117, 1, 91, 115, 116, 47, 95, 80, 111, 98, 117, 17, 102, 96, 53, 50, 68, 3, 94, 119, 100, 19, 111, 117, 122, 46, 68, 71});
    }

    public final int ve() {
        Intent intentRegisterReceiver = this.tt.registerReceiver(null, new IntentFilter((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "06808f", new byte[]{32, 58, 79, 86, 8, 120, 55, 89, 96, 110, 53, 49, 69, 80, 73, 112, 48, 3, 96, 111, 47, 122, 105, 101, 51, 69, Ascii.SYN, 37, 80, 95, 2, Ascii.FS, 106, 106, 32, 84, Ascii.ETB})));
        if (intentRegisterReceiver == null) {
            return -1;
        }
        return intentRegisterReceiver.getIntExtra((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d6bce0", new byte[]{101, 56, 4, 16, 93, 34, 99}), -1);
    }
}
