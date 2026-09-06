package com.yfanads.android.adx.thirdpart.filedownload.i;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface IFileDownloadIPCCallback extends IInterface {
    public static final String DESCRIPTOR = "com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCCallback";

    public static class Default implements IFileDownloadIPCCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCCallback
        public void callback(MessageSnapshot messageSnapshot) throws RemoteException {
        }
    }

    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t, int i) {
            if (t == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            }
        }
    }

    void callback(MessageSnapshot messageSnapshot) throws RemoteException;

    public static abstract class Stub extends Binder implements IFileDownloadIPCCallback {
        static final int TRANSACTION_callback = 1;

        public static class Proxy implements IFileDownloadIPCCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCCallback
            public void callback(MessageSnapshot messageSnapshot) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IFileDownloadIPCCallback.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, messageSnapshot, 0);
                    this.mRemote.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IFileDownloadIPCCallback.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, IFileDownloadIPCCallback.DESCRIPTOR);
        }

        public static IFileDownloadIPCCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IFileDownloadIPCCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IFileDownloadIPCCallback)) ? new Proxy(iBinder) : (IFileDownloadIPCCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IFileDownloadIPCCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IFileDownloadIPCCallback.DESCRIPTOR);
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            callback((MessageSnapshot) _Parcel.readTypedObject(parcel, MessageSnapshot.CREATOR));
            return true;
        }
    }
}
