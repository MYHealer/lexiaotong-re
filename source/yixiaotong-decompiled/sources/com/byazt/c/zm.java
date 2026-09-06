package com.byazt.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.byazt.t.DownloadInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public interface zm extends IInterface {
    String c() throws RemoteException;

    void c(int i, DownloadInfo downloadInfo, String str, String str2) throws RemoteException;

    boolean c(boolean z) throws RemoteException;

    @com.byazt.zqa.c(c = {0, 1, 20, 21})
    public static abstract class c extends Binder implements zm {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public c() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
        }

        public static zm c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof zm)) {
                return (zm) iInterfaceQueryLocalInterface;
            }
            return new C0119c(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                c(parcel.readInt(), parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                boolean zC = c(parcel.readInt() != 0);
                parcel2.writeNoException();
                parcel2.writeInt(zC ? 1 : 0);
                return true;
            }
            if (i != 3) {
                if (i == 1598968902) {
                    parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
            String strC = c();
            parcel2.writeNoException();
            parcel2.writeString(strC);
            return true;
        }

        /* JADX INFO: renamed from: com.byazt.c.zm$c$c, reason: collision with other inner class name */
        @com.byazt.zqa.c(c = {0, 1, 20, 1483})
        private static class C0119c implements zm {
            public static zm c;
            public IBinder tt;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.tt;
            }

            public C0119c(IBinder iBinder) {
                this.tt = iBinder;
            }

            @Override // com.byazt.c.zm
            public void c(int i, DownloadInfo downloadInfo, String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                    parcelObtain.writeInt(i);
                    if (downloadInfo != null) {
                        parcelObtain.writeInt(1);
                        downloadInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.tt.transact(1, parcelObtain, parcelObtain2, 0) && c.tt() != null) {
                        c.tt().c(i, downloadInfo, str, str2);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.c.zm
            public boolean c(boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (!this.tt.transact(2, parcelObtain, parcelObtain2, 0) && c.tt() != null) {
                        return c.tt().c(z);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.c.zm
            public String c() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                    if (!this.tt.transact(3, parcelObtain, parcelObtain2, 0) && c.tt() != null) {
                        return c.tt().c();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static zm tt() {
            return C0119c.c;
        }
    }
}
