package com.byazt.uk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface ve extends IInterface {
    void c(int i) throws RemoteException;

    void c(int i, uj ujVar) throws RemoteException;

    boolean c(String str) throws RemoteException;

    boolean c(String str, String str2) throws RemoteException;

    int tt(String str) throws RemoteException;

    @com.byazt.zqa.c(c = {0, 1, 87, 24})
    public static abstract class c extends Binder implements ve {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public c() {
            attachInterface(this, "com.bytedance.pangle.IPackageManager");
        }

        public static ve c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.IPackageManager");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ve)) {
                return (ve) iInterfaceQueryLocalInterface;
            }
            return new C0290c(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                boolean zC = c(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(zC ? 1 : 0);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                int iTt = tt(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(iTt);
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                boolean zC2 = c(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(zC2 ? 1 : 0);
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                c(parcel.readInt(), uj.c.c(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i != 5) {
                if (i == 1598968902) {
                    parcel2.writeString("com.bytedance.pangle.IPackageManager");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
            c(parcel.readInt());
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: renamed from: com.byazt.uk.ve$c$c, reason: collision with other inner class name */
        @com.byazt.zqa.c(c = {0, 1, 87, 1241})
        private static class C0290c implements ve {
            public static ve c;
            public IBinder tt;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.tt;
            }

            public C0290c(IBinder iBinder) {
                this.tt = iBinder;
            }

            @Override // com.byazt.uk.ve
            public boolean c(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    parcelObtain.writeString(str);
                    if (!this.tt.transact(1, parcelObtain, parcelObtain2, 0) && c.c() != null) {
                        return c.c().c(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.uk.ve
            public int tt(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    parcelObtain.writeString(str);
                    if (!this.tt.transact(2, parcelObtain, parcelObtain2, 0) && c.c() != null) {
                        return c.c().tt(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.uk.ve
            public boolean c(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.tt.transact(3, parcelObtain, parcelObtain2, 0) && c.c() != null) {
                        return c.c().c(str, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.uk.ve
            public void c(int i, uj ujVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(ujVar != null ? ujVar.asBinder() : null);
                    if (!this.tt.transact(4, parcelObtain, parcelObtain2, 0) && c.c() != null) {
                        c.c().c(i, ujVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.uk.ve
            public void c(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    parcelObtain.writeInt(i);
                    if (!this.tt.transact(5, parcelObtain, parcelObtain2, 0) && c.c() != null) {
                        c.c().c(i);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static ve c() {
            return C0290c.c;
        }
    }
}
