package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class d1 {
    public static volatile boolean c = true;
    public static String tt;
    private static volatile d1 ve;
    private String n = null;
    private pblk uj;

    final class pgla implements pblk.pblb {
        pgla() {
        }

        @Override // ms.bz.bd.c.Pgl.pblk.pblb
        public final void c(String str) {
            d1.this.n = str;
        }
    }

    private d1(Context context) {
        try {
            this.uj = new pblk(new pgla());
            if (!c || Build.VERSION.SDK_INT > 32) {
                return;
            }
            this.uj.c(context);
        } catch (Throwable unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "60714a", new byte[]{40, 39, 71});
        }
    }

    public static d1 c(Context context) {
        if (ve == null) {
            synchronized (d1.class) {
                if (ve == null) {
                    ve = new d1(context);
                }
            }
        }
        return ve;
    }

    public final String c() {
        String str = tt;
        return str != null ? str : this.n;
    }
}
