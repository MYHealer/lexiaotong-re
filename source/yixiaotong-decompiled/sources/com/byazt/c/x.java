package com.byazt.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public interface x extends IInterface {
    boolean c() throws RemoteException;

    @com.byazt.zqa.c(c = {0, 1, 20, 62})
    public static abstract class c extends Binder implements x {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public c() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
        }

        public static x c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof x)) {
                return (x) iInterfaceQueryLocalInterface;
            }
            return new C0117c(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
            boolean zC = c();
            parcel2.writeNoException();
            parcel2.writeInt(zC ? 1 : 0);
            return true;
        }

        /* JADX INFO: renamed from: com.byazt.c.x$c$c, reason: collision with other inner class name */
        @com.byazt.zqa.c(c = {0, 1, 20, 960})
        private static class C0117c implements x {
            public static x c;
            public IBinder tt;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.tt;
            }

            public C0117c(IBinder iBinder) {
                this.tt = iBinder;
            }

            @Override // com.byazt.c.x
            public boolean c() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
                    if (!this.tt.transact(1, parcelObtain, parcelObtain2, 0) && c.tt() != null) {
                        return c.tt().c();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static x tt() {
            return C0117c.c;
        }
    }
}
