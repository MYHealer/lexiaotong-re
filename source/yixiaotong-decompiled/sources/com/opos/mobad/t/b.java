package com.opos.mobad.t;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: com.opos.mobad.t.b$a$a, reason: collision with other inner class name */
        private static class C1001a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f7396a;

            C1001a(IBinder iBinder) {
                this.f7396a = iBinder;
            }

            @Override // com.opos.mobad.t.b
            public void a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.opos.mobad.web.WebShowController");
                    this.f7396a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f7396a;
            }
        }

        public a() {
            attachInterface(this, "com.opos.mobad.web.WebShowController");
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.opos.mobad.web.WebShowController");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new C1001a(iBinder) : (b) iInterfaceQueryLocalInterface;
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
                parcel2.writeString("com.opos.mobad.web.WebShowController");
                return true;
            }
            parcel.enforceInterface("com.opos.mobad.web.WebShowController");
            a();
            parcel2.writeNoException();
            return true;
        }
    }

    void a() throws RemoteException;
}
