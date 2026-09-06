package ms.bz.bd.c.Pgl;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class f1 implements IInterface {
    public IBinder c;

    public f1(IBinder iBinder) {
        this.c = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.c;
    }
}
