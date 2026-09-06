package com.xiaomi.onetrack.util.oaid.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public interface b extends IInterface {

    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private IBinder f9523a;

        public a(IBinder iBinder) {
            this.f9523a = iBinder;
        }

        @Override // com.xiaomi.onetrack.util.oaid.a.b
        public String a() {
            String string;
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(s.d(new byte[]{84, 9, 95, 76, 68, 89, 5, 13, Ascii.NAK, 76, 94, Ascii.NAK, 82, 8, 86, 7, 71, 95, 2, 1, 72, 3, 88, 1, 91, 72, 125, Ascii.DC2, 84, 88, 37, 1, 16, 11, 82, 0, 126, 2, 87, 12, 69, 95, 7, 13, 3, 16, 98, 0, 69, 16, 91, 1, 84}, "7f2b16"));
                this.f9523a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                string = parcelObtain2.readString();
            } catch (Throwable th) {
                parcelObtain.recycle();
                parcelObtain2.recycle();
                th.printStackTrace();
                string = null;
            }
            parcelObtain.recycle();
            parcelObtain2.recycle();
            return string;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f9523a;
        }

        @Override // com.xiaomi.onetrack.util.oaid.a.b
        public boolean b() {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            boolean z = false;
            try {
                parcelObtain.writeInterfaceToken(s.d(new byte[]{0, 14, 9, 77, 67, 9, 5, 13, Ascii.NAK, 76, 94, Ascii.NAK, 6, 15, 0, 6, SignedBytes.MAX_POWER_OF_TWO, 15, 2, 1, 72, 3, 88, 1, 15, 79, 43, 19, 83, 8, 37, 1, 16, 11, 82, 0, 42, 5, 1, 13, 66, 15, 7, 13, 3, 16, 98, 0, 17, Ascii.ETB, 13, 0, 83}, "cadc6f"));
                this.f9523a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                if (parcelObtain2.readInt() == 0) {
                    z = true;
                }
            } catch (Throwable unused) {
                parcelObtain.recycle();
                parcelObtain2.recycle();
            }
            parcelObtain.recycle();
            parcelObtain2.recycle();
            return z;
        }
    }

    String a();

    boolean b();
}
