package com.ubixnow.ooooo;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface r0 extends IInterface {

    public static class OooO00o implements r0 {
        @Override // com.ubixnow.ooooo.r0
        public boolean OooO0oO() throws RemoteException {
            return false;
        }

        @Override // com.ubixnow.ooooo.r0
        public String OooOO0O() throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class OooO0O0 extends Binder implements r0 {
        private static final String OooO00o = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";
        public static final int OooO0O0 = 1;
        public static final int OooO0OO = 2;

        public static class OooO00o implements r0 {
            public static r0 OooO00o;
            private IBinder OooO0O0;

            public OooO00o(IBinder iBinder) {
                this.OooO0O0 = iBinder;
            }

            @Override // com.ubixnow.ooooo.r0
            public boolean OooO0oO() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(OooO0O0.OooO00o);
                    if (!this.OooO0O0.transact(2, parcelObtain, parcelObtain2, 0) && OooO0O0.OooOOO() != null) {
                        return OooO0O0.OooOOO().OooO0oO();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ubixnow.ooooo.r0
            public String OooOO0O() throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(OooO0O0.OooO00o);
                    if (this.OooO0O0.transact(1, parcelObtain, parcelObtain2, 0) || OooO0O0.OooOOO() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = OooO0O0.OooOOO().OooOO0O();
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

        public static r0 OooO00o(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(OooO00o);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof r0)) ? new OooO00o(iBinder) : (r0) iInterfaceQueryLocalInterface;
        }

        public static boolean OooO00o(r0 r0Var) {
            if (OooO00o.OooO00o != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (r0Var == null) {
                return false;
            }
            OooO00o.OooO00o = r0Var;
            return true;
        }

        public static r0 OooOOO() {
            return OooO00o.OooO00o;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(OooO00o);
                String strOooOO0O = OooOO0O();
                parcel2.writeNoException();
                parcel2.writeString(strOooOO0O);
                return true;
            }
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(OooO00o);
                return true;
            }
            parcel.enforceInterface(OooO00o);
            boolean zOooO0oO = OooO0oO();
            parcel2.writeNoException();
            parcel2.writeInt(zOooO0oO ? 1 : 0);
            return true;
        }
    }

    boolean OooO0oO() throws RemoteException;

    String OooOO0O() throws RemoteException;
}
