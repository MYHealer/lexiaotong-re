package com.ubix.ssp.ad.e.a0.c0.i.d;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.ubix.ssp.ad.e.a0.c0.i.d.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC1075a extends Binder implements a {

        /* JADX INFO: renamed from: com.ubix.ssp.ad.e.a0.c0.i.d.a$a$a, reason: collision with other inner class name */
        private static class C1076a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static a f8675a;
            private IBinder b;

            C1076a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.ubix.ssp.ad.e.a0.c0.i.d.a
            public String a() {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    if (this.b.transact(1, parcelObtain, parcelObtain2, 0) || AbstractBinderC1075a.m() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = AbstractBinderC1075a.m().a();
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }
        }

        public AbstractBinderC1075a() {
            attachInterface(this, "com.samsung.android.deviceidservice.IDeviceIdService");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C1076a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static a m() {
            return C1076a.f8675a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            String strA;
            if (i == 1) {
                parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                strA = a();
            } else if (i == 2) {
                parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                strA = b(parcel.readString());
            } else {
                if (i != 3) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString("com.samsung.android.deviceidservice.IDeviceIdService");
                    return true;
                }
                parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                strA = a(parcel.readString());
            }
            parcel2.writeNoException();
            parcel2.writeString(strA);
            return true;
        }
    }

    String a();

    String a(String str);

    String b(String str);
}
