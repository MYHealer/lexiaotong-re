package com.huawei.hms.ml.common.card.bcr;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface IRemoteBcrCreator extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.ml.common.card.bcr.IRemoteBcrCreator";

    public static class Default implements IRemoteBcrCreator {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hms.ml.common.card.bcr.IRemoteBcrCreator
        public IRemoteBcrDecoderDelegate newRemoteBcrDecoderDelegate() throws RemoteException {
            return null;
        }
    }

    IRemoteBcrDecoderDelegate newRemoteBcrDecoderDelegate() throws RemoteException;

    public static abstract class Stub extends Binder implements IRemoteBcrCreator {
        static final int TRANSACTION_newRemoteBcrDecoderDelegate = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IRemoteBcrCreator.DESCRIPTOR);
        }

        public static IRemoteBcrCreator asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IRemoteBcrCreator.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IRemoteBcrCreator)) {
                return (IRemoteBcrCreator) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(IRemoteBcrCreator.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                parcel.enforceInterface(IRemoteBcrCreator.DESCRIPTOR);
                IRemoteBcrDecoderDelegate iRemoteBcrDecoderDelegateNewRemoteBcrDecoderDelegate = newRemoteBcrDecoderDelegate();
                parcel2.writeNoException();
                parcel2.writeStrongBinder(iRemoteBcrDecoderDelegateNewRemoteBcrDecoderDelegate != null ? iRemoteBcrDecoderDelegateNewRemoteBcrDecoderDelegate.asBinder() : null);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements IRemoteBcrCreator {
            public static IRemoteBcrCreator sDefaultImpl;
            private IBinder mRemote;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IRemoteBcrCreator.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.huawei.hms.ml.common.card.bcr.IRemoteBcrCreator
            public IRemoteBcrDecoderDelegate newRemoteBcrDecoderDelegate() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteBcrCreator.DESCRIPTOR);
                    if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().newRemoteBcrDecoderDelegate();
                    }
                    parcelObtain2.readException();
                    return IRemoteBcrDecoderDelegate.Stub.asInterface(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IRemoteBcrCreator iRemoteBcrCreator) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iRemoteBcrCreator == null) {
                return false;
            }
            Proxy.sDefaultImpl = iRemoteBcrCreator;
            return true;
        }

        public static IRemoteBcrCreator getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
