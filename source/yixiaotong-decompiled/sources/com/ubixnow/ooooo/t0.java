package com.ubixnow.ooooo;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface t0 extends IInterface {

    public static class OooO00o implements t0 {
        @Override // com.ubixnow.ooooo.t0
        public String OooO00o() throws RemoteException {
            return null;
        }

        @Override // com.ubixnow.ooooo.t0
        public String OooO00o(String str) throws RemoteException {
            return null;
        }

        @Override // com.ubixnow.ooooo.t0
        public String OooO0O0(String str) throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class OooO0O0 extends Binder implements t0 {
        private static final String OooO00o = "com.samsung.android.deviceidservice.IDeviceIdService";
        public static final int OooO0O0 = 1;
        public static final int OooO0OO = 2;
        public static final int OooO0Oo = 3;

        public static class OooO00o implements t0 {
            public static t0 OooO00o;
            private IBinder OooO0O0;

            public OooO00o(IBinder iBinder) {
                this.OooO0O0 = iBinder;
            }

            @Override // com.ubixnow.ooooo.t0
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

            @Override // com.ubixnow.ooooo.t0
            public String OooO00o(String str) throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(OooO0O0.OooO00o);
                    parcelObtain.writeString(str);
                    if (this.OooO0O0.transact(3, parcelObtain, parcelObtain2, 0) || OooO0O0.OooOOO() == null) {
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

            @Override // com.ubixnow.ooooo.t0
            public String OooO0O0(String str) throws RemoteException {
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
                        string = OooO0O0.OooOOO().OooO0O0(str);
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

        public static t0 OooO00o(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(OooO00o);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof t0)) ? new OooO00o(iBinder) : (t0) iInterfaceQueryLocalInterface;
        }

        public static boolean OooO00o(t0 t0Var) {
            if (OooO00o.OooO00o != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (t0Var == null) {
                return false;
            }
            OooO00o.OooO00o = t0Var;
            return true;
        }

        public static t0 OooOOO() {
            return OooO00o.OooO00o;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String strOooO00o;
            if (i == 1) {
                parcel.enforceInterface(OooO00o);
                strOooO00o = OooO00o();
            } else if (i == 2) {
                parcel.enforceInterface(OooO00o);
                strOooO00o = OooO0O0(parcel.readString());
            } else {
                if (i != 3) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString(OooO00o);
                    return true;
                }
                parcel.enforceInterface(OooO00o);
                strOooO00o = OooO00o(parcel.readString());
            }
            parcel2.writeNoException();
            parcel2.writeString(strOooO00o);
            return true;
        }
    }

    String OooO00o() throws RemoteException;

    String OooO00o(String str) throws RemoteException;

    String OooO0O0(String str) throws RemoteException;
}
