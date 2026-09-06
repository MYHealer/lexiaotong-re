package com.byazt.fp;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.facebook.imageutils.JfifUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public interface c extends IInterface {
    String c(String str) throws RemoteException;

    boolean c() throws RemoteException;

    String n(String str) throws RemoteException;

    String tt() throws RemoteException;

    String tt(String str) throws RemoteException;

    String uj(String str) throws RemoteException;

    String ve(String str) throws RemoteException;

    /* JADX INFO: renamed from: com.byazt.fp.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, JfifUtil.MARKER_SOS, 44})
    public static abstract class AbstractBinderC0150c extends Binder implements c {
        public static c c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof c)) {
                return (c) iInterfaceQueryLocalInterface;
            }
            return new C0151c(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.coolpad.deviceidsupport.IDeviceIdManager");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    String strC = c(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strC);
                    return true;
                case 2:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    String strTt = tt(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strTt);
                    return true;
                case 3:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    String strVe = ve(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strVe);
                    return true;
                case 4:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    String strUj = uj(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strUj);
                    return true;
                case 5:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    String strN = n(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strN);
                    return true;
                case 6:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    boolean zC = c();
                    parcel2.writeNoException();
                    parcel2.writeInt(zC ? 1 : 0);
                    return true;
                case 7:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    String strTt2 = tt();
                    parcel2.writeNoException();
                    parcel2.writeString(strTt2);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: com.byazt.fp.c$c$c, reason: collision with other inner class name */
        @com.byazt.zqa.c(c = {0, 1, JfifUtil.MARKER_SOS, 810})
        private static class C0151c implements c {
            public static c c;
            public IBinder tt;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.tt;
            }

            public C0151c(IBinder iBinder) {
                this.tt = iBinder;
            }

            @Override // com.byazt.fp.c
            public String c(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(str);
                    if (!this.tt.transact(1, parcelObtain, parcelObtain2, 0) && AbstractBinderC0150c.ve() != null) {
                        return AbstractBinderC0150c.ve().c(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.fp.c
            public String tt(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(str);
                    if (!this.tt.transact(2, parcelObtain, parcelObtain2, 0) && AbstractBinderC0150c.ve() != null) {
                        return AbstractBinderC0150c.ve().tt(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.fp.c
            public String ve(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(str);
                    if (!this.tt.transact(3, parcelObtain, parcelObtain2, 0) && AbstractBinderC0150c.ve() != null) {
                        return AbstractBinderC0150c.ve().ve(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.fp.c
            public String uj(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(str);
                    if (!this.tt.transact(4, parcelObtain, parcelObtain2, 0) && AbstractBinderC0150c.ve() != null) {
                        return AbstractBinderC0150c.ve().uj(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.fp.c
            public String n(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(str);
                    if (!this.tt.transact(5, parcelObtain, parcelObtain2, 0) && AbstractBinderC0150c.ve() != null) {
                        return AbstractBinderC0150c.ve().n(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.fp.c
            public boolean c() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    if (!this.tt.transact(6, parcelObtain, parcelObtain2, 0) && AbstractBinderC0150c.ve() != null) {
                        return AbstractBinderC0150c.ve().c();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.fp.c
            public String tt() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    if (!this.tt.transact(7, parcelObtain, parcelObtain2, 0) && AbstractBinderC0150c.ve() != null) {
                        return AbstractBinderC0150c.ve().tt();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static c ve() {
            return C0151c.c;
        }
    }
}
