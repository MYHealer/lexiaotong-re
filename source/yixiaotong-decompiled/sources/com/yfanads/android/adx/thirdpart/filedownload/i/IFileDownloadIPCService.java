package com.yfanads.android.adx.thirdpart.filedownload.i;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.yfanads.android.adx.thirdpart.filedownload.model.FileDownloadHeader;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface IFileDownloadIPCService extends IInterface {
    public static final String DESCRIPTOR = "com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService";

    public static class Default implements IFileDownloadIPCService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
        public boolean checkDownloading(String str, String str2) throws RemoteException {
            return false;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
        public void clearAllTaskData() throws RemoteException {
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
        public boolean clearTaskData(int i) throws RemoteException {
            return false;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
        public long getSofar(int i) throws RemoteException {
            return 0L;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
        public byte getStatus(int i) throws RemoteException {
            return (byte) 0;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
        public long getTotal(int i) throws RemoteException {
            return 0L;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
        public boolean isIdle() throws RemoteException {
            return false;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
        public boolean pause(int i) throws RemoteException {
            return false;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
        public void pauseAllTasks() throws RemoteException {
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
        public void registerCallback(IFileDownloadIPCCallback iFileDownloadIPCCallback) throws RemoteException {
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
        public boolean setMaxNetworkThreadCount(int i) throws RemoteException {
            return false;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
        public void start(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, FileDownloadHeader fileDownloadHeader, boolean z3) throws RemoteException {
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
        public void startForeground(int i, Notification notification) throws RemoteException {
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
        public void stopForeground(boolean z) throws RemoteException {
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
        public void unregisterCallback(IFileDownloadIPCCallback iFileDownloadIPCCallback) throws RemoteException {
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

    boolean checkDownloading(String str, String str2) throws RemoteException;

    void clearAllTaskData() throws RemoteException;

    boolean clearTaskData(int i) throws RemoteException;

    long getSofar(int i) throws RemoteException;

    byte getStatus(int i) throws RemoteException;

    long getTotal(int i) throws RemoteException;

    boolean isIdle() throws RemoteException;

    boolean pause(int i) throws RemoteException;

    void pauseAllTasks() throws RemoteException;

    void registerCallback(IFileDownloadIPCCallback iFileDownloadIPCCallback) throws RemoteException;

    boolean setMaxNetworkThreadCount(int i) throws RemoteException;

    void start(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, FileDownloadHeader fileDownloadHeader, boolean z3) throws RemoteException;

    void startForeground(int i, Notification notification) throws RemoteException;

    void stopForeground(boolean z) throws RemoteException;

    void unregisterCallback(IFileDownloadIPCCallback iFileDownloadIPCCallback) throws RemoteException;

    public static abstract class Stub extends Binder implements IFileDownloadIPCService {
        static final int TRANSACTION_checkDownloading = 3;
        static final int TRANSACTION_clearAllTaskData = 15;
        static final int TRANSACTION_clearTaskData = 14;
        static final int TRANSACTION_getSofar = 8;
        static final int TRANSACTION_getStatus = 10;
        static final int TRANSACTION_getTotal = 9;
        static final int TRANSACTION_isIdle = 11;
        static final int TRANSACTION_pause = 5;
        static final int TRANSACTION_pauseAllTasks = 6;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_setMaxNetworkThreadCount = 7;
        static final int TRANSACTION_start = 4;
        static final int TRANSACTION_startForeground = 12;
        static final int TRANSACTION_stopForeground = 13;
        static final int TRANSACTION_unregisterCallback = 2;

        public static class Proxy implements IFileDownloadIPCService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
            public boolean checkDownloading(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IFileDownloadIPCService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
            public void clearAllTaskData() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IFileDownloadIPCService.DESCRIPTOR);
                    this.mRemote.transact(15, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
            public boolean clearTaskData(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IFileDownloadIPCService.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(14, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IFileDownloadIPCService.DESCRIPTOR;
            }

            @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
            public long getSofar(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IFileDownloadIPCService.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
            public byte getStatus(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IFileDownloadIPCService.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readByte();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
            public long getTotal(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IFileDownloadIPCService.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
            public boolean isIdle() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IFileDownloadIPCService.DESCRIPTOR);
                    this.mRemote.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
            public boolean pause(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IFileDownloadIPCService.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
            public void pauseAllTasks() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IFileDownloadIPCService.DESCRIPTOR);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
            public void registerCallback(IFileDownloadIPCCallback iFileDownloadIPCCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IFileDownloadIPCService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iFileDownloadIPCCallback);
                    this.mRemote.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
            public boolean setMaxNetworkThreadCount(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IFileDownloadIPCService.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
            public void start(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, FileDownloadHeader fileDownloadHeader, boolean z3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IFileDownloadIPCService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    _Parcel.writeTypedObject(parcelObtain, fileDownloadHeader, 0);
                    parcelObtain.writeInt(z3 ? 1 : 0);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
            public void startForeground(int i, Notification notification) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IFileDownloadIPCService.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    _Parcel.writeTypedObject(parcelObtain, notification, 0);
                    this.mRemote.transact(12, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
            public void stopForeground(boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IFileDownloadIPCService.DESCRIPTOR);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(13, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
            public void unregisterCallback(IFileDownloadIPCCallback iFileDownloadIPCCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IFileDownloadIPCService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iFileDownloadIPCCallback);
                    this.mRemote.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IFileDownloadIPCService.DESCRIPTOR);
        }

        public static IFileDownloadIPCService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IFileDownloadIPCService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IFileDownloadIPCService)) ? new Proxy(iBinder) : (IFileDownloadIPCService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IFileDownloadIPCService.DESCRIPTOR);
            }
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        registerCallback(IFileDownloadIPCCallback.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 2:
                        unregisterCallback(IFileDownloadIPCCallback.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 3:
                        boolean zCheckDownloading = checkDownloading(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(zCheckDownloading ? 1 : 0);
                        return true;
                    case 4:
                        start(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, (FileDownloadHeader) _Parcel.readTypedObject(parcel, FileDownloadHeader.CREATOR), parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        boolean zPause = pause(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(zPause ? 1 : 0);
                        return true;
                    case 6:
                        pauseAllTasks();
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        boolean maxNetworkThreadCount = setMaxNetworkThreadCount(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(maxNetworkThreadCount ? 1 : 0);
                        return true;
                    case 8:
                        long sofar = getSofar(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeLong(sofar);
                        return true;
                    case 9:
                        long total = getTotal(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeLong(total);
                        return true;
                    case 10:
                        byte status = getStatus(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeByte(status);
                        return true;
                    case 11:
                        boolean zIsIdle = isIdle();
                        parcel2.writeNoException();
                        parcel2.writeInt(zIsIdle ? 1 : 0);
                        return true;
                    case 12:
                        startForeground(parcel.readInt(), (Notification) _Parcel.readTypedObject(parcel, Notification.CREATOR));
                        return true;
                    case 13:
                        stopForeground(parcel.readInt() != 0);
                        return true;
                    case 14:
                        boolean zClearTaskData = clearTaskData(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(zClearTaskData ? 1 : 0);
                        return true;
                    case 15:
                        clearAllTaskData();
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString(IFileDownloadIPCService.DESCRIPTOR);
            return true;
        }
    }
}
