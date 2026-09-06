package com.opos.mobad.t;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.opos.mobad.t.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0999a extends Binder implements a {

        /* JADX INFO: renamed from: com.opos.mobad.t.a$a$a, reason: collision with other inner class name */
        private static class C1000a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f7395a;

            C1000a(IBinder iBinder) {
                this.f7395a = iBinder;
            }

            @Override // com.opos.mobad.t.a
            public void a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.opos.mobad.web.WebShowCallback");
                    this.f7395a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.opos.mobad.t.a
            public void a(b bVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.opos.mobad.web.WebShowCallback");
                    parcelObtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.f7395a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.opos.mobad.t.a
            public void a(Map map) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.opos.mobad.web.WebShowCallback");
                    parcelObtain.writeMap(map);
                    this.f7395a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f7395a;
            }
        }

        public AbstractBinderC0999a() {
            attachInterface(this, "com.opos.mobad.web.WebShowCallback");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.opos.mobad.web.WebShowCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C1000a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.opos.mobad.web.WebShowCallback");
                a(b.a.a(parcel.readStrongBinder()));
            } else if (i == 2) {
                parcel.enforceInterface("com.opos.mobad.web.WebShowCallback");
                a();
            } else {
                if (i != 3) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString("com.opos.mobad.web.WebShowCallback");
                    return true;
                }
                parcel.enforceInterface("com.opos.mobad.web.WebShowCallback");
                a(parcel.readHashMap(getClass().getClassLoader()));
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void a() throws RemoteException;

    void a(b bVar) throws RemoteException;

    void a(Map map) throws RemoteException;
}
