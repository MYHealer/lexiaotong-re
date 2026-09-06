package com.ubix.ssp.ad.e.a0.c0.i.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.ubix.ssp.ad.e.a0.c0.i.b.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC1071a extends Binder implements a {

        /* JADX INFO: renamed from: com.ubix.ssp.ad.e.a0.c0.i.b.a$a$a, reason: collision with other inner class name */
        private static class C1072a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static a f8673a;
            private IBinder b;

            C1072a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            @Override // com.ubix.ssp.ad.e.a0.c0.i.b.a
            public boolean g() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    if (!this.b.transact(2, parcelObtain, parcelObtain2, 0) && AbstractBinderC1071a.m() != null) {
                        return AbstractBinderC1071a.m().g();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ubix.ssp.ad.e.a0.c0.i.b.a
            public String i() {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    if (this.b.transact(1, parcelObtain, parcelObtain2, 0) || AbstractBinderC1071a.m() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = AbstractBinderC1071a.m().i();
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public AbstractBinderC1071a() {
            attachInterface(this, "com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C1072a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static a m() {
            return C1072a.f8673a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                String strI = i();
                parcel2.writeNoException();
                parcel2.writeString(strI);
                return true;
            }
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                return true;
            }
            parcel.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            boolean zG = g();
            parcel2.writeNoException();
            parcel2.writeInt(zG ? 1 : 0);
            return true;
        }
    }

    boolean g();

    String i();
}
