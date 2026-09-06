package ms.bz.bd.c.Pgl;

import android.app.Application;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.Display;
import com.byazt.jtc.ve;
import com.google.common.base.Ascii;
import com.stub.StubApp;
import okio.Utf8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class r1 {
    private static r1 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private pbll f9705a;
    private DisplayManager n;
    private final HandlerThread tt;
    private boolean uj = false;
    private Context ve;

    final class pgla implements Runnable {
        pgla() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (r1.this.ve != null) {
                    r1.this.tt.start();
                    Handler handler = new Handler(r1.this.tt.getLooper());
                    r1 r1Var = r1.this;
                    r1Var.n = (DisplayManager) StubApp.getOrigApplicationContext(r1Var.ve.getApplicationContext()).getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3572f3", new byte[]{38, 62, 87, 86, 85, 37, 41}));
                    if (r1.this.n != null) {
                        Display[] displays = r1.this.n.getDisplays();
                        int length = displays.length;
                        if (length > 1) {
                            q1 q1VarC = q1.c();
                            q1VarC.getClass();
                            String strC = q1.c(displays);
                            String strTt = q1.tt(displays);
                            q1VarC.c(length);
                            q1VarC.tt();
                            if (!TextUtils.isEmpty(strC)) {
                                q1VarC.c(strC);
                            }
                            if (!TextUtils.isEmpty(strTt)) {
                                q1VarC.tt(strTt);
                            }
                        }
                        r1 r1Var2 = r1.this;
                        r1Var2.f9705a = new pbll(r1Var2.n);
                        r1.this.n.registerDisplayListener(r1.this.f9705a, handler);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private r1(Context context) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.ve = origApplicationContext;
        if (!(origApplicationContext instanceof Application)) {
            Context contextTt = tt();
            this.ve = contextTt == null ? this.ve : contextTt;
        }
        this.tt = new HandlerThread((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d432c3", new byte[]{88, 5, 115, 116}));
    }

    public static r1 c(Context context) {
        r1 r1Var;
        synchronized (r1.class) {
            if (c == null) {
                c = new r1(context);
            }
            r1Var = c;
        }
        return r1Var;
    }

    private static Application tt() {
        try {
            return (Application) Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "866d0b", new byte[]{40, 58, 65, 2, 0, 124, Utf8.REPLACEMENT_BYTE, 89, 102, 36, 57, 122, 100, 19, Ascii.ESC, 124, 45, Ascii.RS, 115, 45, Ascii.GS, 60, 87, Ascii.NAK, 14, 113})).getMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "38287b", new byte[]{33, 47, 83, 94, 13, 123, 36, 56, 115, 120, 46, 51, 66, 77, Ascii.FS, 124, Utf8.REPLACEMENT_BYTE, Ascii.ETB}), new Class[0]).invoke(null, null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final synchronized void c() {
        if (this.uj) {
            return;
        }
        this.uj = true;
        new ve(new pgla(), "z/bd/c/Pgl/r1").start();
    }

    protected final void finalize() throws Throwable {
        pbll pbllVar;
        synchronized (this) {
            try {
                DisplayManager displayManager = this.n;
                if (displayManager != null && (pbllVar = this.f9705a) != null) {
                    displayManager.unregisterDisplayListener(pbllVar);
                }
            } catch (Throwable unused) {
            }
            HandlerThread handlerThread = this.tt;
            if (handlerThread != null) {
                try {
                    handlerThread.quitSafely();
                } catch (Throwable unused2) {
                }
            }
        }
        super.finalize();
    }
}
