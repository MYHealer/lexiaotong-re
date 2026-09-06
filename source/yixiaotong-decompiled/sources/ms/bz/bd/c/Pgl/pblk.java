package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.byazt.jtc.ve;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class pblk {
    private final pblb c;

    public interface pblb {
        void c(String str);
    }

    final class pgla implements Runnable {
        final /* synthetic */ Context c;

        pgla(Context context) {
            this.c = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "479b8e", new byte[]{4, 6, 127, 37})).equals(pblk.c(pblk.this).toUpperCase())) {
                    new ms.bz.bd.c.Pgl.pgla(this.c).c(pblk.this.c);
                    return;
                }
                if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b88cb8", new byte[]{91, 15, 106, 32, 120, 6})).equals(pblk.c(pblk.this).toUpperCase())) {
                    new pblp(this.c).c(pblk.this.c);
                    return;
                }
                if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "583e7a", new byte[]{11, 10, 112, 62})).equals(pblk.c(pblk.this).toUpperCase()) || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "7cb84f", new byte[]{9, 79, 52, 124, 39, 68, 7})).equals(pblk.c(pblk.this).toUpperCase())) {
                    e1 e1Var = new e1(this.c);
                    e1Var.c(pblk.this.c);
                    return;
                }
                if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e9ad9a", new byte[]{78, 15, 55})).equals(pblk.c(pblk.this).toUpperCase()) || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fadcbc", new byte[]{81, 70, 37, 37, 112, 81, 74, 115})).equals(pblk.c(pblk.this).toUpperCase())) {
                    return;
                }
                pblk.this.getClass();
                if (pblk.c() || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e581bb", new byte[]{71, 4, 126, 108})).equals(pblk.c(pblk.this).toUpperCase())) {
                    return;
                }
                pblk.this.getClass();
                if (pblk.tt() || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a9510b", new byte[]{67, 26, 107, 118, 58, 91, 69})).equals(pblk.c(pblk.this).toUpperCase())) {
                    return;
                }
                if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f62680", new byte[]{91, 17, 111, 109, 49, 8})).equals(pblk.c(pblk.this).toUpperCase()) || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "36c235", new byte[]{15, Ascii.ESC, 36, 105, 32, 13, 2, 54})).equals(pblk.c(pblk.this).toUpperCase())) {
                    pblt pbltVar = new pblt(this.c);
                    pbltVar.c(pblk.this.c);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public pblk(pblb pblbVar) {
        this.c = pblbVar;
    }

    private static String c(String str) {
        if (str == null) {
            return null;
        }
        try {
            Class<?> cls = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6f53ff", new byte[]{38, 106, 66, 85, 86, 120, 49, 9, 107, 112, 105, 87, 95, 84, 77, 116, 56, 119, 118, 108, 55, 97, 84, 83, 80, 116, 38}));
            return (String) cls.getMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "058b47", new byte[]{38, 50, 95}), String.class, String.class).invoke(cls, str, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e71f7f", new byte[]{97, 59, 73, Ascii.FS, 7, 102, 104}));
        } catch (Exception unused) {
            return null;
        }
    }

    static String c(pblk pblkVar) {
        pblkVar.getClass();
        return Build.MANUFACTURER.toUpperCase();
    }

    public static boolean c() {
        String strC = c((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3fca99", new byte[]{48, 107, 94, Ascii.ETB, 19, 39, 60, 67, 124, 55, 48, 97, Ascii.NAK, Ascii.CAN, 3, 96, 60, 70, 48, 52, 46}));
        return !TextUtils.isEmpty(strC) && strC.equalsIgnoreCase((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "dff479", new byte[]{83, 86, 48, 101, 37, 11, 72, 116}));
    }

    private void tt(Context context) {
        new ve(new pgla(context), "bd/c/Pgl/pblk").start();
    }

    public static boolean tt() {
        String strC = c((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3cea58", new byte[]{48, 110, 88, 6, Ascii.EM, 58, 57, 12, 36, 35, 45, 101, 3, Ascii.SYN, Ascii.RS}));
        return (TextUtils.isEmpty(strC) || strC.equalsIgnoreCase((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "cc8470", new byte[]{103, 111, SignedBytes.MAX_POWER_OF_TWO, 78, 7, 48, 110}))) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x023e  */
    public final void c(Context context) {
        String strC;
        String str = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "7fd210", new byte[]{7, 87, 34, 117});
        String str2 = Build.MANUFACTURER;
        if (str.equals(str2.toUpperCase().toUpperCase()) || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a65732", new byte[]{88, 1, 103, 116, 41, 12})).equals(str2.toUpperCase().toUpperCase()) || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "184382", new byte[]{12, Ascii.US, 105, 104, 49, 10})).equals(str2.toUpperCase().toUpperCase()) || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "ddd091", new byte[]{88, 73, 35, 107, 42, 9, 85, 100})).equals(str2.toUpperCase().toUpperCase())) {
            tt(context);
            strC = null;
        } else {
            if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b50d91", new byte[]{94, Ascii.DC2, 106, 42, 51})).equals(str2.toUpperCase().toUpperCase())) {
                new a1(context).c(this.c);
            } else if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "ba8d8a", new byte[]{93, 86, 105, 57, 38})).equals(str2.toUpperCase().toUpperCase())) {
                strC = new c1(context).c();
            } else if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "82e3f9", new byte[]{6, 0, 38, 104})).equals(str2.toUpperCase().toUpperCase()) || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0c839d", new byte[]{Ascii.DC2, SignedBytes.MAX_POWER_OF_TWO, 102, 116, 51, 93, Ascii.DC4})).equals(str2.toUpperCase().toUpperCase())) {
                tt(context);
            } else if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "109b73", new byte[]{Ascii.SYN, Ascii.ESC, 124, 57})).equals(str2.toUpperCase().toUpperCase())) {
                strC = new z1(context).c();
            } else if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "16475b", new byte[]{Ascii.CAN, Ascii.GS, 102, 108, 39, 92})).equals(str2.toUpperCase().toUpperCase()) || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "9de541", new byte[]{10, 74, 55, 98, 32, Ascii.NAK, Ascii.DC2, 100, 6, 78})).equals(str2.toUpperCase().toUpperCase())) {
                strC = new a2(context).c();
            } else if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d3deb8", new byte[]{90, Ascii.US, 50, 33, 113, 26, 84})).equals(str2.toUpperCase().toUpperCase()) || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "13043a", new byte[]{26, 5, 102})).equals(str2.toUpperCase().toUpperCase()) || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "682784", new byte[]{1, Ascii.US, 115, 113, 42, 6, 26, 42})).equals(str2.toUpperCase().toUpperCase()) || c() || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "016c3d", new byte[]{Ascii.DC2, 0, 112, 62})).equals(str2.toUpperCase().toUpperCase()) || tt()) {
                tt(context);
            }
            strC = null;
        }
        pblb pblbVar = this.c;
        if (pblbVar != null) {
            pblbVar.c(strC);
        }
    }
}
