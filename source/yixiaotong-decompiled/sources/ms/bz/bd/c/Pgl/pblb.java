package ms.bz.bd.c.Pgl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class pblb implements IInterface {
    private final IBinder c;

    public pblb(IBinder iBinder) {
        this.c = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.c;
    }

    public final String c() {
        String string;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "7b1f8e", new byte[]{37, 111, 79, 92, 6, 97, 33, 80, 46, 59, 53, 97, 12, 33, Ascii.DC2, 98, 36, 79, 101, 59, 35, 110, 86, 19, Ascii.NAK, 107, 16, 106, 68, 120, 15, 68, 75, Ascii.SYN, 38, 123, 48, 79, 73, 56, 50, 101, 80, Ascii.DC4, 6, 113, 49}));
            this.c.transact(3, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            string = parcelObtain2.readString();
        } catch (Throwable unused) {
            parcelObtain.recycle();
            parcelObtain2.recycle();
            string = null;
        }
        parcelObtain.recycle();
        parcelObtain2.recycle();
        return string;
    }
}
