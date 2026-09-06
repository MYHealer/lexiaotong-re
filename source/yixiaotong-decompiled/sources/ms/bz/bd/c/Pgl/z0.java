package ms.bz.bd.c.Pgl;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class z0 {

    final class pblb extends pblz.pgla {
        pblb() {
        }

        @Override // ms.bz.bd.c.Pgl.pblz.pgla
        public final Object c(long j, String str, Object obj) throws Throwable {
            d1.c(pblw.c().tt());
            return null;
        }
    }

    final class pblc extends pblz.pgla {
        pblc() {
        }

        @Override // ms.bz.bd.c.Pgl.pblz.pgla
        public final Object c(long j, String str, Object obj) throws Throwable {
            return d1.c(pblw.c().tt()).c();
        }
    }

    final class pbld extends pblz.pgla {
        pbld() {
        }

        @Override // ms.bz.bd.c.Pgl.pblz.pgla
        public final Object c(long j, String str, Object obj) throws Throwable {
            return m1.tt(pblw.c().tt());
        }
    }

    final class pble extends pblz.pgla {
        pble() {
        }

        @Override // ms.bz.bd.c.Pgl.pblz.pgla
        public final Object c(long j, String str, Object obj) throws Throwable {
            return l1.c(pblw.c().tt());
        }
    }

    final class pblf extends pblz.pgla {
        pblf() {
        }

        @Override // ms.bz.bd.c.Pgl.pblz.pgla
        public final Object c(long j, String str, Object obj) throws Throwable {
            return "np";
        }
    }

    final class pblg extends pblz.pgla {
        pblg() {
        }

        @Override // ms.bz.bd.c.Pgl.pblz.pgla
        public final Object c(long j, String str, Object obj) throws Throwable {
            return "np";
        }
    }

    final class pblh extends pblz.pgla {
        pblh() {
        }

        @Override // ms.bz.bd.c.Pgl.pblz.pgla
        public final Object c(long j, String str, Object obj) throws Throwable {
            return k1.c(pblw.c().tt());
        }
    }

    final class pbli extends pblz.pgla {
        pbli() {
        }

        @Override // ms.bz.bd.c.Pgl.pblz.pgla
        public final Object c(long j, String str, Object obj) throws Throwable {
            return k1.tt(pblw.c().tt());
        }
    }

    final class pblj extends pblz.pgla {
        pblj() {
        }

        @Override // ms.bz.bd.c.Pgl.pblz.pgla
        public final Object c(long j, String str, Object obj) throws Throwable {
            return ms.bz.bd.c.Pgl.pblh.c();
        }
    }

    final class pblk extends pblz.pgla {
        pblk() {
        }

        @Override // ms.bz.bd.c.Pgl.pblz.pgla
        public final Object c(long j, String str, Object obj) throws Throwable {
            return n1.c(pblw.c().tt());
        }
    }

    final class pbll extends pblz.pgla {
        pbll() {
        }

        @Override // ms.bz.bd.c.Pgl.pblz.pgla
        public final Object c(long j, String str, Object obj) throws Throwable {
            String str2;
            String str3;
            StringBuilder sbAppend;
            String strTrim = "0";
            String strTrim2 = "null";
            try {
                WifiInfo connectionInfo = ((WifiManager) pblw.c().tt().getSystemService("wifi")).getConnectionInfo();
                Class<?> cls = connectionInfo.getClass();
                Method declaredMethod = cls.getDeclaredMethod(new String(pblr.c("6765744253534944")), new Class[0]);
                declaredMethod.setAccessible(true);
                str2 = (String) declaredMethod.invoke(connectionInfo, new Object[0]);
                try {
                    Method declaredMethod2 = cls.getDeclaredMethod(new String(pblr.c("67657453534944")), new Class[0]);
                    declaredMethod2.setAccessible(true);
                    str3 = (String) declaredMethod2.invoke(connectionInfo, new Object[0]);
                    try {
                        Method declaredMethod3 = cls.getDeclaredMethod(new String(pblr.c("676574497041646472657373")), new Class[0]);
                        declaredMethod3.setAccessible(true);
                        String string = Integer.toString(((Integer) declaredMethod3.invoke(connectionInfo, new Object[0])).intValue());
                        String strC = v1.c(str3);
                        String strC2 = v1.c(str2);
                        String strC3 = v1.c(string);
                        StringBuilder sbAppend2 = new StringBuilder().append((strC2 == null || strC2.length() <= 0) ? "null" : strC2.trim()).append("[<!>]");
                        if (strC != null && strC.length() > 0) {
                            strTrim2 = strC.trim();
                        }
                        sbAppend = sbAppend2.append(strTrim2).append("[<!>]");
                        if (strC3 != null && strC3.length() > 0) {
                            strTrim = strC3.trim();
                        }
                    } catch (Throwable unused) {
                        String strC4 = v1.c(str3);
                        String strC5 = v1.c(str2);
                        String strC6 = v1.c(null);
                        StringBuilder sbAppend3 = new StringBuilder().append((strC5 == null || strC5.length() <= 0) ? "null" : strC5.trim()).append("[<!>]");
                        if (strC4 != null && strC4.length() > 0) {
                            strTrim2 = strC4.trim();
                        }
                        sbAppend = sbAppend3.append(strTrim2).append("[<!>]");
                        if (strC6 != null && strC6.length() > 0) {
                            strTrim = strC6.trim();
                        }
                    }
                } catch (Throwable unused2) {
                    str3 = null;
                }
            } catch (Throwable unused3) {
                str2 = null;
                str3 = null;
            }
            return sbAppend.append(strTrim).append("[<!>]").toString().trim();
        }
    }

    final class pblm extends pblz.pgla {
        pblm() {
        }

        @Override // ms.bz.bd.c.Pgl.pblz.pgla
        public final Object c(long j, String str, Object obj) throws Throwable {
            return m1.c(pblw.c().tt());
        }
    }

    final class pgla extends pblz.pgla {
        pgla() {
        }

        @Override // ms.bz.bd.c.Pgl.pblz.pgla
        public final Object c(long j, String str, Object obj) throws Throwable {
            return null;
        }
    }

    public static void c() {
        pblz.c(268435457, new pble());
        pblz.c(268435458, new pblf());
        pblz.c(268435459, new pblg());
        pblz.c(268435460, new pblh());
        pblz.c(268435461, new pbli());
        pblz.c(268435462, new pblj());
        pblz.c(268435463, new pblk());
        pblz.c(268435464, new pbll());
        pblz.c(268435465, new pblm());
        pblz.c(268435466, new pgla());
        pblz.c(268435467, new pblb());
        pblz.c(268435468, new pblc());
        pblz.c(268435469, new pbld());
    }
}
