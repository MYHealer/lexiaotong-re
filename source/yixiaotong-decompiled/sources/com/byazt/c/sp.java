package com.byazt.c;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public interface sp extends IInterface {
    Uri c(String str, String str2) throws RemoteException;

    @com.byazt.zqa.c(c = {0, 1, 20, 180})
    public static abstract class c extends Binder implements sp {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public c() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
        }

        public static sp c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof sp)) {
                return (sp) iInterfaceQueryLocalInterface;
            }
            return new C0115c(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
            Uri uriC = c(parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            if (uriC != null) {
                parcel2.writeInt(1);
                uriC.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }

        /* JADX INFO: renamed from: com.byazt.c.sp$c$c, reason: collision with other inner class name */
        @com.byazt.zqa.c(c = {0, 1, 20, 1063})
        private static class C0115c implements sp {
            public static sp c;
            public IBinder tt;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.tt;
            }

            public C0115c(IBinder iBinder) {
                this.tt = iBinder;
            }

            @Override // com.byazt.c.sp
            public Uri c(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.tt.transact(1, parcelObtain, parcelObtain2, 0) && c.c() != null) {
                        return c.c().c(str, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static sp c() {
            return C0115c.c;
        }
    }
}
