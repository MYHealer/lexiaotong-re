package ms.bz.bd.c.Pgl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.common.base.Ascii;
import okio.Utf8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class pblu implements IInterface {
    private final IBinder c;

    public pblu(IBinder iBinder) {
        this.c = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return null;
    }

    public final String c() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "88ccbe", new byte[]{42, 53, Ascii.GS, 89, 71, 103, 50, 87, 54, 54, Utf8.REPLACEMENT_BYTE, 51, 19, Ascii.DC2, 84, 118, 40, Ascii.FS, 32, 37, 32, 57, Ascii.NAK, 89, 116, 86, 62, 15, 59, 48, 44, 51, Ascii.DC4, 62, 83, 102, 62, 11, 52, 50, 42, Utf8.REPLACEMENT_BYTE}));
            this.c.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
            return null;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
