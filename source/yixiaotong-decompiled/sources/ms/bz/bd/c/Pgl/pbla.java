package ms.bz.bd.c.Pgl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.common.base.Ascii;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class pbla implements IInterface {
    private final IBinder c;

    public pbla(IBinder iBinder) {
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
            parcelObtain.writeInterfaceToken((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "90fe61", new byte[]{43, Base64.padSymbol, Ascii.CAN, 95, Ascii.FS, 41, 62, Ascii.CAN, 36, 123, 39, 34, 16, Ascii.US, 13, 35, 44, Ascii.CAN, 52, 48, 102, 51, Ascii.FS, Ascii.NAK, 5, 104, Ascii.NAK, 1, 50, 59, 12, 55, 3, Ascii.CAN, 10, 35, 19, Ascii.NAK, 50, 59, 60, 59, 19, Ascii.CAN, 12, 52, 9, Ascii.DC4, 37, 35, 33, 49, 16}));
            this.c.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            string = parcelObtain2.readString();
        } catch (Throwable th) {
            parcelObtain.recycle();
            parcelObtain2.recycle();
            com.byazt.nr.m.c(th);
            string = null;
        }
        parcelObtain.recycle();
        parcelObtain2.recycle();
        return string;
    }
}
