package com.huawei.hms.ml.common.card.bcr;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface IRemoteBcrDecoderDelegate extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.ml.common.card.bcr.IRemoteBcrDecoderDelegate";

    public static class Default implements IRemoteBcrDecoderDelegate {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hms.ml.common.card.bcr.IRemoteBcrDecoderDelegate
        public int destroy() throws RemoteException {
            return 0;
        }

        @Override // com.huawei.hms.ml.common.card.bcr.IRemoteBcrDecoderDelegate
        public BcrDetectorParcel detect(Bundle bundle, BcrDetectorFrameParcel bcrDetectorFrameParcel, BcrDetectorOptionsParcel bcrDetectorOptionsParcel) throws RemoteException {
            return null;
        }

        @Override // com.huawei.hms.ml.common.card.bcr.IRemoteBcrDecoderDelegate
        public int initial(IObjectWrapper iObjectWrapper, BcrDetectorOptionsParcel bcrDetectorOptionsParcel) throws RemoteException {
            return 0;
        }
    }

    int destroy() throws RemoteException;

    BcrDetectorParcel detect(Bundle bundle, BcrDetectorFrameParcel bcrDetectorFrameParcel, BcrDetectorOptionsParcel bcrDetectorOptionsParcel) throws RemoteException;

    int initial(IObjectWrapper iObjectWrapper, BcrDetectorOptionsParcel bcrDetectorOptionsParcel) throws RemoteException;

    public static abstract class Stub extends Binder implements IRemoteBcrDecoderDelegate {
        static final int TRANSACTION_destroy = 3;
        static final int TRANSACTION_detect = 2;
        static final int TRANSACTION_initial = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IRemoteBcrDecoderDelegate.DESCRIPTOR);
        }

        public static IRemoteBcrDecoderDelegate asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IRemoteBcrDecoderDelegate.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IRemoteBcrDecoderDelegate)) {
                return (IRemoteBcrDecoderDelegate) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(IRemoteBcrDecoderDelegate.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                parcel.enforceInterface(IRemoteBcrDecoderDelegate.DESCRIPTOR);
                int iInitial = initial(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? BcrDetectorOptionsParcel.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(iInitial);
                return true;
            }
            if (i != 2) {
                if (i == 3) {
                    parcel.enforceInterface(IRemoteBcrDecoderDelegate.DESCRIPTOR);
                    int iDestroy = destroy();
                    parcel2.writeNoException();
                    parcel2.writeInt(iDestroy);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(IRemoteBcrDecoderDelegate.DESCRIPTOR);
            BcrDetectorParcel bcrDetectorParcelDetect = detect(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? BcrDetectorFrameParcel.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? BcrDetectorOptionsParcel.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            if (bcrDetectorParcelDetect != null) {
                parcel2.writeInt(1);
                bcrDetectorParcelDetect.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }

        private static class Proxy implements IRemoteBcrDecoderDelegate {
            public static IRemoteBcrDecoderDelegate sDefaultImpl;
            private IBinder mRemote;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IRemoteBcrDecoderDelegate.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.huawei.hms.ml.common.card.bcr.IRemoteBcrDecoderDelegate
            public int initial(IObjectWrapper iObjectWrapper, BcrDetectorOptionsParcel bcrDetectorOptionsParcel) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteBcrDecoderDelegate.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (bcrDetectorOptionsParcel != null) {
                        parcelObtain.writeInt(1);
                        bcrDetectorOptionsParcel.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().initial(iObjectWrapper, bcrDetectorOptionsParcel);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ml.common.card.bcr.IRemoteBcrDecoderDelegate
            public BcrDetectorParcel detect(Bundle bundle, BcrDetectorFrameParcel bcrDetectorFrameParcel, BcrDetectorOptionsParcel bcrDetectorOptionsParcel) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteBcrDecoderDelegate.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bcrDetectorFrameParcel != null) {
                        parcelObtain.writeInt(1);
                        bcrDetectorFrameParcel.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bcrDetectorOptionsParcel != null) {
                        parcelObtain.writeInt(1);
                        bcrDetectorOptionsParcel.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().detect(bundle, bcrDetectorFrameParcel, bcrDetectorOptionsParcel);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? BcrDetectorParcel.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ml.common.card.bcr.IRemoteBcrDecoderDelegate
            public int destroy() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteBcrDecoderDelegate.DESCRIPTOR);
                    if (!this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().destroy();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IRemoteBcrDecoderDelegate iRemoteBcrDecoderDelegate) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iRemoteBcrDecoderDelegate == null) {
                return false;
            }
            Proxy.sDefaultImpl = iRemoteBcrDecoderDelegate;
            return true;
        }

        public static IRemoteBcrDecoderDelegate getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
