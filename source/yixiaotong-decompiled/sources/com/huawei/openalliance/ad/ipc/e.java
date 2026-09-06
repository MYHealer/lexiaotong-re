package com.huawei.openalliance.ad.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.ads.fh;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface e extends IInterface {

    public static abstract class a extends Binder implements e {
        static final int Code = 1;
        private static final String I = "com.huawei.android.hms.ppskit.IPPSResultCallback";
        private static final String V = "IPPSResultCallback";

        /* JADX INFO: renamed from: com.huawei.openalliance.ad.ipc.e$a$a, reason: collision with other inner class name */
        private static class C0537a implements e {
            private IBinder Code;

            C0537a(IBinder iBinder) {
                this.Code = iBinder;
            }

            public String Code() {
                return a.I;
            }

            @Override // com.huawei.openalliance.ad.ipc.e
            public void Code(String str, int i, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.I);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str2);
                    this.Code.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.Code;
            }
        }

        public a() {
            attachInterface(this, I);
        }

        public static e Code(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            try {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(I);
                return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof e)) ? new C0537a(iBinder) : (e) iInterfaceQueryLocalInterface;
            } catch (Throwable th) {
                fh.I(V, "IPPSResultCallback err: " + th.getClass().getSimpleName());
                return null;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(I);
                return true;
            }
            parcel.enforceInterface(I);
            Code(parcel.readString(), parcel.readInt(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }
    }

    void Code(String str, int i, String str2);
}
