package com.google.android.gms.ads.identifier.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public interface IAdvertisingIdService extends IInterface {
    public static final String DESCRIPTOR = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";

    public static class Default implements IAdvertisingIdService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.google.android.gms.ads.identifier.internal.IAdvertisingIdService
        public String getId() throws RemoteException {
            return null;
        }

        @Override // com.google.android.gms.ads.identifier.internal.IAdvertisingIdService
        public boolean isLimitAdTrackingEnabled(boolean z) throws RemoteException {
            return false;
        }
    }

    String getId() throws RemoteException;

    boolean isLimitAdTrackingEnabled(boolean z) throws RemoteException;

    public static abstract class Stub extends Binder implements IAdvertisingIdService {
        static final int TRANSACTION_getId = 1;
        static final int TRANSACTION_isLimitAdTrackingEnabled = 2;

        public static class Proxy implements IAdvertisingIdService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.google.android.gms.ads.identifier.internal.IAdvertisingIdService
            public String getId() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAdvertisingIdService.DESCRIPTOR);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IAdvertisingIdService.DESCRIPTOR;
            }

            @Override // com.google.android.gms.ads.identifier.internal.IAdvertisingIdService
            public boolean isLimitAdTrackingEnabled(boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAdvertisingIdService.DESCRIPTOR);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IAdvertisingIdService.DESCRIPTOR);
        }

        public static IAdvertisingIdService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IAdvertisingIdService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IAdvertisingIdService)) ? new Proxy(iBinder) : (IAdvertisingIdService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IAdvertisingIdService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IAdvertisingIdService.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                String id = getId();
                parcel2.writeNoException();
                parcel2.writeString(id);
            } else {
                if (i != 2) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                boolean zIsLimitAdTrackingEnabled = isLimitAdTrackingEnabled(parcel.readInt() != 0);
                parcel2.writeNoException();
                parcel2.writeInt(zIsLimitAdTrackingEnabled ? 1 : 0);
            }
            return true;
        }
    }
}
