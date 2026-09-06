package com.ubix.ssp.ad.e.a0.c0.i.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.ubix.ssp.ad.e.a0.c0.i.c.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC1073a extends Binder implements a {

        /* JADX INFO: renamed from: com.ubix.ssp.ad.e.a0.c0.i.c.a$a$a, reason: collision with other inner class name */
        private static class C1074a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static a f8674a;
            private IBinder b;

            C1074a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.ubix.ssp.ad.e.a0.c0.i.c.a
            public String a() {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    if (this.b.transact(3, parcelObtain, parcelObtain2, 0) || AbstractBinderC1073a.m() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = AbstractBinderC1073a.m().a();
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

        public AbstractBinderC1073a() {
            attachInterface(this, "com.android.creator.IdsSupplier");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.android.creator.IdsSupplier");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C1074a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static a m() {
            return C1074a.f8674a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString("com.android.creator.IdsSupplier");
                return true;
            }
            if (i == 1) {
                parcel.enforceInterface("com.android.creator.IdsSupplier");
                boolean zD = d();
                parcel2.writeNoException();
                parcel2.writeInt(zD ? 1 : 0);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.android.creator.IdsSupplier");
                String strC = c(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(strC);
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface("com.android.creator.IdsSupplier");
                String strA = a();
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface("com.android.creator.IdsSupplier");
                String strB = b();
                parcel2.writeNoException();
                parcel2.writeString(strB);
                return true;
            }
            if (i != 5) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.android.creator.IdsSupplier");
            String strA2 = a(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(strA2);
            return true;
        }
    }

    String a();

    String a(String str);

    String b();

    String c(String str);

    boolean d();
}
