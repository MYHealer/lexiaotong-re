package com.ubixnow.ooooo;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface w0 extends IInterface {

    public static class OooO00o implements w0 {
        @Override // com.ubixnow.ooooo.w0
        public boolean OooO00o(boolean z) throws RemoteException {
            return false;
        }

        @Override // com.ubixnow.ooooo.w0
        public String OooO0oo() throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class OooO0O0 extends Binder implements w0 {
        private static final String OooO00o = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";
        public static final int OooO0O0 = 1;
        public static final int OooO0OO = 2;

        public static class OooO00o implements w0 {
            public static w0 OooO00o;
            private IBinder OooO0O0;

            public OooO00o(IBinder iBinder) {
                this.OooO0O0 = iBinder;
            }

            @Override // com.ubixnow.ooooo.w0
            public boolean OooO00o(boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (!this.OooO0O0.transact(2, parcelObtain, parcelObtain2, 0) && OooO0O0.OooOOO() != null) {
                        return OooO0O0.OooOOO().OooO00o(z);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ubixnow.ooooo.w0
            public String OooO0oo() throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    if (this.OooO0O0.transact(1, parcelObtain, parcelObtain2, 0) || OooO0O0.OooOOO() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = OooO0O0.OooOOO().OooO0oo();
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String OooOOO() {
                return "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.OooO0O0;
            }
        }

        public OooO0O0() {
            attachInterface(this, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        }

        public static w0 OooO00o(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof w0)) ? new OooO00o(iBinder) : (w0) iInterfaceQueryLocalInterface;
        }

        public static boolean OooO00o(w0 w0Var) {
            if (OooO00o.OooO00o != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (w0Var == null) {
                return false;
            }
            OooO00o.OooO00o = w0Var;
            return true;
        }

        public static w0 OooOOO() {
            return OooO00o.OooO00o;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                String strOooO0oo = OooO0oo();
                parcel2.writeNoException();
                parcel2.writeString(strOooO0oo);
                return true;
            }
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                return true;
            }
            parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            boolean zOooO00o = OooO00o(parcel.readInt() != 0);
            parcel2.writeNoException();
            parcel2.writeInt(zOooO00o ? 1 : 0);
            return true;
        }
    }

    boolean OooO00o(boolean z) throws RemoteException;

    String OooO0oo() throws RemoteException;
}
