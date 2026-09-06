package com.ubixnow.ooooo;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface s0 extends IInterface {

    public static class OooO00o implements s0 {
        @Override // com.ubixnow.ooooo.s0
        public String OooO00o() throws RemoteException {
            return null;
        }

        @Override // com.ubixnow.ooooo.s0
        public String OooO00o(String str) throws RemoteException {
            return null;
        }

        @Override // com.ubixnow.ooooo.s0
        public String OooO0O0() throws RemoteException {
            return null;
        }

        @Override // com.ubixnow.ooooo.s0
        public String OooO0OO(String str) throws RemoteException {
            return null;
        }

        @Override // com.ubixnow.ooooo.s0
        public boolean OooO0Oo() throws RemoteException {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class OooO0O0 extends Binder implements s0 {
        private static final String OooO00o = "com.android.creator.IdsSupplier";
        public static final int OooO0O0 = 1;
        public static final int OooO0OO = 2;
        public static final int OooO0Oo = 3;
        public static final int OooO0o = 5;
        public static final int OooO0o0 = 4;

        public static class OooO00o implements s0 {
            public static s0 OooO00o;
            private IBinder OooO0O0;

            public OooO00o(IBinder iBinder) {
                this.OooO0O0 = iBinder;
            }

            @Override // com.ubixnow.ooooo.s0
            public String OooO00o() throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(OooO0O0.OooO00o);
                    if (this.OooO0O0.transact(3, parcelObtain, parcelObtain2, 0) || OooO0O0.OooOOO() == null) {
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

            @Override // com.ubixnow.ooooo.s0
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

            @Override // com.ubixnow.ooooo.s0
            public String OooO0O0() throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(OooO0O0.OooO00o);
                    if (this.OooO0O0.transact(4, parcelObtain, parcelObtain2, 0) || OooO0O0.OooOOO() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = OooO0O0.OooOOO().OooO0O0();
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ubixnow.ooooo.s0
            public String OooO0OO(String str) throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(OooO0O0.OooO00o);
                    parcelObtain.writeString(str);
                    if (this.OooO0O0.transact(2, parcelObtain, parcelObtain2, 0) || OooO0O0.OooOOO() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = OooO0O0.OooOOO().OooO0OO(str);
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ubixnow.ooooo.s0
            public boolean OooO0Oo() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(OooO0O0.OooO00o);
                    if (!this.OooO0O0.transact(1, parcelObtain, parcelObtain2, 0) && OooO0O0.OooOOO() != null) {
                        return OooO0O0.OooOOO().OooO0Oo();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
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

        public static s0 OooO00o(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(OooO00o);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof s0)) ? new OooO00o(iBinder) : (s0) iInterfaceQueryLocalInterface;
        }

        public static boolean OooO00o(s0 s0Var) {
            if (OooO00o.OooO00o != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (s0Var == null) {
                return false;
            }
            OooO00o.OooO00o = s0Var;
            return true;
        }

        public static s0 OooOOO() {
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
            if (i == 1) {
                parcel.enforceInterface(OooO00o);
                boolean zOooO0Oo = OooO0Oo();
                parcel2.writeNoException();
                parcel2.writeInt(zOooO0Oo ? 1 : 0);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(OooO00o);
                String strOooO0OO = OooO0OO(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(strOooO0OO);
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(OooO00o);
                String strOooO00o = OooO00o();
                parcel2.writeNoException();
                parcel2.writeString(strOooO00o);
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface(OooO00o);
                String strOooO0O0 = OooO0O0();
                parcel2.writeNoException();
                parcel2.writeString(strOooO0O0);
                return true;
            }
            if (i != 5) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(OooO00o);
            String strOooO00o2 = OooO00o(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(strOooO00o2);
            return true;
        }
    }

    String OooO00o() throws RemoteException;

    String OooO00o(String str) throws RemoteException;

    String OooO0O0() throws RemoteException;

    String OooO0OO(String str) throws RemoteException;

    boolean OooO0Oo() throws RemoteException;
}
