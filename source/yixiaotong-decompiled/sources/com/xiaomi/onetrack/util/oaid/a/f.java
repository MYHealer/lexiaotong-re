package com.xiaomi.onetrack.util.oaid.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public interface f extends IInterface {

    public static class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private IBinder f9527a;

        public a(IBinder iBinder) {
            this.f9527a = iBinder;
        }

        @Override // com.xiaomi.onetrack.util.oaid.a.f
        public String a() {
            String string;
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(s.d(new byte[]{80, 10, 90, Ascii.US, 68, 4, 12, Ascii.ETB, 19, 12, 86, 75, 82, 11, 83, 67, 88, 12, 5, 74, 2, 7, 71, 12, 80, 0, 94, 85, 68, 0, 19, Ascii.DC2, 15, 1, 84, 75, 122, 33, 82, 71, 94, 6, 4, 45, 2, 49, 84, Ascii.ETB, 69, 12, 84, 84}, "3e717e"));
                this.f9527a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                string = parcelObtain2.readString();
            } catch (Throwable th) {
                parcelObtain2.recycle();
                parcelObtain.recycle();
                th.printStackTrace();
                string = null;
            }
            parcelObtain2.recycle();
            parcelObtain.recycle();
            return string;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f9527a;
        }
    }

    public static abstract class b extends Binder implements f {
        public b() {
            attachInterface(this, s.d(new byte[]{82, 89, 11, Ascii.CAN, Ascii.NAK, 87, 12, Ascii.ETB, 19, 12, 86, 75, 80, 88, 2, 68, 9, 95, 5, 74, 2, 7, 71, 12, 82, 83, 15, 82, Ascii.NAK, 83, 19, Ascii.DC2, 15, 1, 84, 75, 120, 114, 3, SignedBytes.MAX_POWER_OF_TWO, 15, 85, 4, 45, 2, 49, 84, Ascii.ETB, 71, 95, 5, 83}, "16f6f6"));
        }

        public f a(IBinder iBinder) {
            if (iBinder == null || iBinder.queryLocalInterface(s.d(new byte[]{86, 14, 8, Ascii.ETB, 65, 84, 12, Ascii.ETB, 19, 12, 86, 75, 84, 15, 1, 75, 93, 92, 5, 74, 2, 7, 71, 12, 86, 4, 12, 93, 65, 80, 19, Ascii.DC2, 15, 1, 84, 75, 124, 37, 0, 79, 91, 86, 4, 45, 2, 49, 84, Ascii.ETB, 67, 8, 6, 92}, "5ae925")) == null) {
                return null;
            }
            return new a(iBinder);
        }
    }

    String a();
}
