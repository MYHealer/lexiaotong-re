package com.yfanads.android.oaid.repackage.com.hihonor.cloudservice.oaid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface IOAIDService extends IInterface {

    public static class Default implements IOAIDService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.yfanads.android.oaid.repackage.com.hihonor.cloudservice.oaid.IOAIDService
        public void basicTypes(int i, long j, boolean z, float f, double d, String str) throws RemoteException {
        }

        @Override // com.yfanads.android.oaid.repackage.com.hihonor.cloudservice.oaid.IOAIDService
        public void getOAID(IOAIDCallBack iOAIDCallBack) throws RemoteException {
        }

        @Override // com.yfanads.android.oaid.repackage.com.hihonor.cloudservice.oaid.IOAIDService
        public void isOAIDTrackingLimited(IOAIDCallBack iOAIDCallBack) throws RemoteException {
        }
    }

    void basicTypes(int i, long j, boolean z, float f, double d, String str) throws RemoteException;

    void getOAID(IOAIDCallBack iOAIDCallBack) throws RemoteException;

    void isOAIDTrackingLimited(IOAIDCallBack iOAIDCallBack) throws RemoteException;

    public static abstract class Stub extends Binder implements IOAIDService {
        private static final String DESCRIPTOR = "com.hihonor.cloudservice.oaid.IOAIDService";
        static final int TRANSACTION_basicTypes = 1;
        static final int TRANSACTION_getOAID = 2;
        static final int TRANSACTION_isOAIDTrackingLimited = 3;

        public static class Proxy implements IOAIDService {
            public static IOAIDService sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.yfanads.android.oaid.repackage.com.hihonor.cloudservice.oaid.IOAIDService
            public void basicTypes(int i, long j, boolean z, float f, double d, String str) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeFloat(f);
                    parcelObtain.writeDouble(d);
                    parcelObtain.writeString(str);
                    try {
                        if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().basicTypes(i, j, z, f, d, str);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return;
                        }
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.yfanads.android.oaid.repackage.com.hihonor.cloudservice.oaid.IOAIDService
            public void getOAID(IOAIDCallBack iOAIDCallBack) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iOAIDCallBack != null ? iOAIDCallBack.asBinder() : null);
                    if (!this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().getOAID(iOAIDCallBack);
                        return;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.yfanads.android.oaid.repackage.com.hihonor.cloudservice.oaid.IOAIDService
            public void isOAIDTrackingLimited(IOAIDCallBack iOAIDCallBack) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iOAIDCallBack != null ? iOAIDCallBack.asBinder() : null);
                    if (this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().isOAIDTrackingLimited(iOAIDCallBack);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IOAIDService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IOAIDService)) ? new Proxy(iBinder) : (IOAIDService) iInterfaceQueryLocalInterface;
        }

        public static IOAIDService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IOAIDService iOAIDService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iOAIDService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iOAIDService;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                basicTypes(parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                getOAID(IOAIDCallBack.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            isOAIDTrackingLimited(IOAIDCallBack.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }
    }
}
