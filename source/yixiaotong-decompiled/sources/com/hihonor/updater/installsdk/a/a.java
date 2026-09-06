package com.hihonor.updater.installsdk.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f3725a = "com.hihonor.updater.iface.IControl";

    /* JADX INFO: renamed from: com.hihonor.updater.installsdk.a.a$a, reason: collision with other inner class name */
    public static class C0478a implements a {
        @Override // com.hihonor.updater.installsdk.a.a
        public String a(String str, int i, String str2) throws RemoteException {
            return null;
        }

        @Override // com.hihonor.updater.installsdk.a.a
        public void a(String str, int i, String str2, com.hihonor.updater.installsdk.a.b bVar) throws RemoteException {
        }

        @Override // com.hihonor.updater.installsdk.a.a
        public void a(String str, a aVar) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class b extends Binder implements a {
        static final int c = 1;
        static final int d = 2;
        static final int e = 3;

        /* JADX INFO: renamed from: com.hihonor.updater.installsdk.a.a$b$a, reason: collision with other inner class name */
        private static class C0479a implements a {
            public static a d;
            private IBinder c;

            C0479a(IBinder iBinder) {
                this.c = iBinder;
            }

            public String a() {
                return a.f3725a;
            }

            @Override // com.hihonor.updater.installsdk.a.a
            public String a(String str, int i, String str2) throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f3725a);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str2);
                    if (this.c.transact(2, parcelObtain, parcelObtain2, 0) || b.a() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = b.a().a(str, i, str2);
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.hihonor.updater.installsdk.a.a
            public void a(String str, int i, String str2, com.hihonor.updater.installsdk.a.b bVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f3725a);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    if (this.c.transact(3, parcelObtain, parcelObtain2, 0) || b.a() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.a().a(str, i, str2, bVar);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.hihonor.updater.installsdk.a.a
            public void a(String str, a aVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f3725a);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (this.c.transact(1, parcelObtain, parcelObtain2, 0) || b.a() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.a().a(str, aVar);
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

        public b() {
            attachInterface(this, a.f3725a);
        }

        public static a a() {
            return C0479a.d;
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(a.f3725a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0479a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static boolean a(a aVar) {
            if (C0479a.d != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (aVar == null) {
                return false;
            }
            C0479a.d = aVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(a.f3725a);
                return true;
            }
            if (i == 1) {
                parcel.enforceInterface(a.f3725a);
                a(parcel.readString(), a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(a.f3725a);
                String strA = a(parcel.readString(), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            }
            if (i != 3) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(a.f3725a);
            a(parcel.readString(), parcel.readInt(), parcel.readString(), com.hihonor.updater.installsdk.a.b.AbstractBinderC0480b.a(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }
    }

    String a(String str, int i, String str2) throws RemoteException;

    void a(String str, int i, String str2, com.hihonor.updater.installsdk.a.b bVar) throws RemoteException;

    void a(String str, a aVar) throws RemoteException;
}
