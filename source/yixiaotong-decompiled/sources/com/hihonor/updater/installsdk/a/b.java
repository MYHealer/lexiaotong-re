package com.hihonor.updater.installsdk.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface b extends IInterface {
    public static final String b = "com.hihonor.updater.iface.IResponse";

    public static class a implements b {
        @Override // com.hihonor.updater.installsdk.a.b
        public void a(int i, String str) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* JADX INFO: renamed from: com.hihonor.updater.installsdk.a.b$b, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0480b extends Binder implements b {
        static final int c = 1;

        /* JADX INFO: renamed from: com.hihonor.updater.installsdk.a.b$b$a */
        private static class a implements b {
            public static b d;
            private IBinder c;

            a(IBinder iBinder) {
                this.c = iBinder;
            }

            public String a() {
                return b.b;
            }

            @Override // com.hihonor.updater.installsdk.a.b
            public void a(int i, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.b);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    if (this.c.transact(1, parcelObtain, parcelObtain2, 0) || AbstractBinderC0480b.a() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0480b.a().a(i, str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.c;
            }
        }

        public AbstractBinderC0480b() {
            attachInterface(this, b.b);
        }

        public static b a() {
            return a.d;
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(b.b);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new a(iBinder) : (b) iInterfaceQueryLocalInterface;
        }

        public static boolean a(b bVar) {
            if (a.d != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (bVar == null) {
                return false;
            }
            a.d = bVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(b.b);
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(b.b);
            a(parcel.readInt(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }
    }

    void a(int i, String str) throws RemoteException;
}
