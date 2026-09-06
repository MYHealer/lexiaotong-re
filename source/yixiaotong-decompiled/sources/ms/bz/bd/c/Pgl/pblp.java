package ms.bz.bd.c.Pgl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import com.google.common.base.Ascii;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class pblp {
    public final LinkedBlockingQueue<IBinder> c = new LinkedBlockingQueue<>(1024);
    ServiceConnection tt = new pgla();
    private final Context ve;

    final class pgla implements ServiceConnection {
        pgla() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                pblp.this.c.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public pblp(Context context) {
        this.ve = context;
    }

    public final void c(pblk.pblb pblbVar) {
        int i = Build.VERSION.SDK_INT;
        if (i != 28 && i < 33) {
            try {
                this.ve.getPackageManager().getPackageInfo((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "ab123b", new byte[]{115, 111, 79, 8, 4, 96, 99, 84, 101, 107, 62, 104, 85, 79, 8}), 0);
            } catch (Exception unused) {
            }
            Intent intent = new Intent((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c519dc", new byte[]{113, 56, 79, 3, 78, 123, 100, Ascii.GS, 115, 39, 125, 39, 71, 67, 95, 113, 118, Ascii.GS, 99, 108, 60, Ascii.CAN, 114, 104, 117, 93, 68, 39, 95, 90, 87, 5, 116, 100, 120, 81}));
            intent.setPackage((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "dfcef6", new byte[]{118, 107, Ascii.GS, 95, 81, 52, 102, 80, 55, 60, 59, 108, 7, Ascii.CAN, 93}));
            if (this.ve.bindService(intent, this.tt, 1)) {
                try {
                    String strC = new pbla(this.c.take()).c();
                    if (pblbVar != null) {
                        pblbVar.c(strC);
                    }
                } catch (Exception unused2) {
                } finally {
                    this.ve.unbindService(this.tt);
                }
            }
        }
    }
}
