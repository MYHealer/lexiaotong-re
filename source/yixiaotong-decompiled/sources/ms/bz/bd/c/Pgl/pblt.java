package ms.bz.bd.c.Pgl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.common.base.Ascii;
import okio.Utf8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class pblt {
    pblu c;
    ServiceConnection tt = new pgla();
    private final Context ve;

    final class pgla implements ServiceConnection {
        pgla() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            pblt.this.c = new pblu(iBinder);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public pblt(Context context) {
        this.ve = context;
    }

    public final void c(pblk.pblb pblbVar) {
        Intent intent = new Intent();
        intent.setClassName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b8e8d0", new byte[]{112, 53, Ascii.ESC, 2, 65, 50, 104, 87, 48, 109, 101, 51, Ascii.NAK, 73, 82, 35, 114, Ascii.FS, 38, 126, 122, 57, 19}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f452cd", new byte[]{116, 57, 75, 8, 70, 102, 108, 91, 96, 103, 97, Utf8.REPLACEMENT_BYTE, 69, 67, 85, 119, 118, 16, 118, 116, 126, 53, 67, 8, 120, 118, 115, Ascii.FS, 103, 103, 126, 50, 117, 67, 78, 101, 108, Ascii.SYN, 97}));
        if (this.ve.bindService(intent, this.tt, 1)) {
            try {
                pblu pbluVar = this.c;
                if (pbluVar != null) {
                    String strC = pbluVar.c();
                    if (pblbVar != null) {
                        pblbVar.c(strC);
                    }
                }
            } catch (Throwable unused) {
            }
            this.ve.unbindService(this.tt);
        }
    }
}
