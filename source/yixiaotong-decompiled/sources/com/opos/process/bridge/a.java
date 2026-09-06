package com.opos.process.bridge;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.opos.process.bridge.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC1042a extends Binder implements a {

        /* JADX INFO: renamed from: com.opos.process.bridge.a$a$a, reason: collision with other inner class name */
        private static class C1043a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static a f8415a;
            private IBinder b;

            C1043a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.opos.process.bridge.a
            public Bundle a(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.opos.process.bridge.IBridgeInterface");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.b.transact(1, parcelObtain, parcelObtain2, 0) && AbstractBinderC1042a.a() != null) {
                        return AbstractBinderC1042a.a().a(bundle);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
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

        public AbstractBinderC1042a() {
            attachInterface(this, "com.opos.process.bridge.IBridgeInterface");
        }

        public static a a() {
            return C1043a.f8415a;
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.opos.process.bridge.IBridgeInterface");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C1043a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.opos.process.bridge.IBridgeInterface");
                return true;
            }
            parcel.enforceInterface("com.opos.process.bridge.IBridgeInterface");
            Bundle bundleA = a(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            if (bundleA != null) {
                parcel2.writeInt(1);
                bundleA.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }
    }

    Bundle a(Bundle bundle) throws RemoteException;
}
