package com.ubixnow.ooooo;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface u0 extends IInterface {

    public static class OooO00o implements u0 {
        @Override // com.ubixnow.ooooo.u0
        public String OooO00o() throws RemoteException {
            return null;
        }

        @Override // com.ubixnow.ooooo.u0
        public String OooO00o(String str) throws RemoteException {
            return null;
        }

        @Override // com.ubixnow.ooooo.u0
        public String OooO0O0(String str) throws RemoteException {
            return null;
        }

        @Override // com.ubixnow.ooooo.u0
        public boolean OooO0o() throws RemoteException {
            return false;
        }

        @Override // com.ubixnow.ooooo.u0
        public String OooO0o0() throws RemoteException {
            return null;
        }

        @Override // com.ubixnow.ooooo.u0
        public String OooO0o0(String str) throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class OooO0O0 extends Binder implements u0 {
        private static final String OooO00o = "com.zui.deviceidservice.IDeviceidInterface";
        public static final int OooO0O0 = 1;
        public static final int OooO0OO = 2;
        public static final int OooO0Oo = 3;
        public static final int OooO0o = 5;
        public static final int OooO0o0 = 4;
        public static final int OooO0oO = 6;

        public static class OooO00o implements u0 {
            public static u0 OooO00o;
            private IBinder OooO0O0;

            public OooO00o(IBinder iBinder) {
                this.OooO0O0 = iBinder;
            }

            @Override // com.ubixnow.ooooo.u0
            public String OooO00o() throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(OooO0O0.OooO00o);
                    if (this.OooO0O0.transact(1, parcelObtain, parcelObtain2, 0) || OooO0O0.OooOOO() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = OooO0O0.OooOOO().OooO00o();
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ubixnow.ooooo.u0
            public String OooO00o(String str) throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(OooO0O0.OooO00o);
                    parcelObtain.writeString(str);
                    if (this.OooO0O0.transact(5, parcelObtain, parcelObtain2, 0) || OooO0O0.OooOOO() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = OooO0O0.OooOOO().OooO00o(str);
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ubixnow.ooooo.u0
            public String OooO0O0(String str) throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(OooO0O0.OooO00o);
                    parcelObtain.writeString(str);
                    if (this.OooO0O0.transact(4, parcelObtain, parcelObtain2, 0) || OooO0O0.OooOOO() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = OooO0O0.OooOOO().OooO0O0(str);
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ubixnow.ooooo.u0
            public boolean OooO0o() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(OooO0O0.OooO00o);
                    if (!this.OooO0O0.transact(3, parcelObtain, parcelObtain2, 0) && OooO0O0.OooOOO() != null) {
                        return OooO0O0.OooOOO().OooO0o();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ubixnow.ooooo.u0
            public String OooO0o0() throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(OooO0O0.OooO00o);
                    if (this.OooO0O0.transact(2, parcelObtain, parcelObtain2, 0) || OooO0O0.OooOOO() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = OooO0O0.OooOOO().OooO0o0();
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ubixnow.ooooo.u0
            public String OooO0o0(String str) throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(OooO0O0.OooO00o);
                    parcelObtain.writeString(str);
                    if (this.OooO0O0.transact(6, parcelObtain, parcelObtain2, 0) || OooO0O0.OooOOO() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = OooO0O0.OooOOO().OooO0o0(str);
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String OooOOO() {
                return OooO0O0.OooO00o;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.OooO0O0;
            }
        }

        public OooO0O0() {
            attachInterface(this, OooO00o);
        }

        public static u0 OooO00o(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(OooO00o);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof u0)) ? new OooO00o(iBinder) : (u0) iInterfaceQueryLocalInterface;
        }

        public static boolean OooO00o(u0 u0Var) {
            if (OooO00o.OooO00o != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (u0Var == null) {
                return false;
            }
            OooO00o.OooO00o = u0Var;
            return true;
        }

        public static u0 OooOOO() {
            return OooO00o.OooO00o;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(OooO00o);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(OooO00o);
                    String strOooO00o = OooO00o();
                    parcel2.writeNoException();
                    parcel2.writeString(strOooO00o);
                    return true;
                case 2:
                    parcel.enforceInterface(OooO00o);
                    String strOooO0o0 = OooO0o0();
                    parcel2.writeNoException();
                    parcel2.writeString(strOooO0o0);
                    return true;
                case 3:
                    parcel.enforceInterface(OooO00o);
                    boolean zOooO0o = OooO0o();
                    parcel2.writeNoException();
                    parcel2.writeInt(zOooO0o ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface(OooO00o);
                    String strOooO0O0 = OooO0O0(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strOooO0O0);
                    return true;
                case 5:
                    parcel.enforceInterface(OooO00o);
                    String strOooO00o2 = OooO00o(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strOooO00o2);
                    return true;
                case 6:
                    parcel.enforceInterface(OooO00o);
                    String strOooO0o1 = OooO0o0(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strOooO0o1);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String OooO00o() throws RemoteException;

    String OooO00o(String str) throws RemoteException;

    String OooO0O0(String str) throws RemoteException;

    boolean OooO0o() throws RemoteException;

    String OooO0o0() throws RemoteException;

    String OooO0o0(String str) throws RemoteException;
}
