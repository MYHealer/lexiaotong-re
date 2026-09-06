package ms.bz.bd.c.Pgl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.common.base.Ascii;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.io.encoding.Base64;
import okio.Utf8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class pgla {
    public final LinkedBlockingQueue<IBinder> c = new LinkedBlockingQueue<>(1024);
    ServiceConnection tt = new ServiceConnectionC1184pgla();
    private final Context ve;

    /* JADX INFO: renamed from: ms.bz.bd.c.Pgl.pgla$pgla, reason: collision with other inner class name */
    final class ServiceConnectionC1184pgla implements ServiceConnection {
        ServiceConnectionC1184pgla() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                pgla.this.c.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public pgla(Context context) {
        this.ve = context;
    }

    public final void c(pblk.pblb pblbVar) {
        try {
            this.ve.getPackageManager().getPackageInfo((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e5f052", new byte[]{119, 56, Ascii.CAN, 10, 11, 54, 115, 7, 121, 109, 103, 54, 91, 119, Ascii.US, 53, 118, Ascii.CAN, 50, 109, 113, 57, 1, 69, Ascii.CAN, 60, 66, Base64.padSymbol, 19}), 0);
        } catch (Exception unused) {
        }
        Intent intent = new Intent();
        intent.setAction((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "366278", new byte[]{33, 59, 72, 8, 9, 60, 37, 4, 41, 111, 49, 53, 11, 71, 11, 59, 57, Ascii.CAN, 105, 44, 3, Ascii.ETB, 102, 99, 59, Ascii.FS, 15, 51, 78, 70}));
        intent.setComponent(new ComponentName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b5cfb4", new byte[]{112, 56, Ascii.GS, 92, 92, 48, 116, 7, 124, 59, 96, 54, 94, 33, 72, 51, 113, Ascii.CAN, 55, 59, 118, 57, 4, 19, 79, 58, 69, Base64.padSymbol, Ascii.SYN}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "72fab2", new byte[]{37, Utf8.REPLACEMENT_BYTE, Ascii.CAN, 91, 92, 54, 33, 0, 121, 60, 53, 49, 91, 38, 72, 53, 36, Ascii.US, 50, 60, 35, 62, 1, Ascii.DC4, 79, 60, 16, 58, 19, 127, Ascii.NAK, 37, 5, 5, 81, 32, 57, Ascii.SYN, 57, 37, 39, 34, 12, 49, 116, 1, 7, Ascii.SYN, 37, 39, 47, 51, 16})));
        if (this.ve.bindService(intent, this.tt, 1)) {
            try {
                String strC = new pblb(this.c.take()).c();
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
