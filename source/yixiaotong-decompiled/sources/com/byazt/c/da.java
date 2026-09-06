package com.byazt.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public interface da extends IInterface {
    String c() throws RemoteException;

    void c(String str) throws RemoteException;

    int[] tt() throws RemoteException;

    @com.byazt.zqa.c(c = {0, 1, 20, 45})
    public static abstract class c extends Binder implements da {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public c() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
        }

        public static da c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof da)) {
                return (da) iInterfaceQueryLocalInterface;
            }
            return new C0107c(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                c(parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                String strC = c();
                parcel2.writeNoException();
                parcel2.writeString(strC);
                return true;
            }
            if (i != 3) {
                if (i == 1598968902) {
                    parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
            int[] iArrTt = tt();
            parcel2.writeNoException();
            parcel2.writeIntArray(iArrTt);
            return true;
        }

        /* JADX INFO: renamed from: com.byazt.c.da$c$c, reason: collision with other inner class name */
        @com.byazt.zqa.c(c = {0, 1, 20, 783})
        private static class C0107c implements da {
            public static da c;
            public IBinder tt;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.tt;
            }

            public C0107c(IBinder iBinder) {
                this.tt = iBinder;
            }

            @Override // com.byazt.c.da
            public void c(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                    parcelObtain.writeString(str);
                    if (!this.tt.transact(1, parcelObtain, parcelObtain2, 0) && c.ve() != null) {
                        c.ve().c(str);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.c.da
            public String c() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                    if (!this.tt.transact(2, parcelObtain, parcelObtain2, 0) && c.ve() != null) {
                        return c.ve().c();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.c.da
            public int[] tt() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                    if (!this.tt.transact(3, parcelObtain, parcelObtain2, 0) && c.ve() != null) {
                        return c.ve().tt();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createIntArray();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static da ve() {
            return C0107c.c;
        }
    }
}
