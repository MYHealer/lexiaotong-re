package com.byazt.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public interface m extends IInterface {
    boolean c(long j, long j2, z zVar) throws RemoteException;

    @com.byazt.zqa.c(c = {0, 1, 20, 600})
    public static abstract class c extends Binder implements m {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public c() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
        }

        public static m c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof m)) {
                return (m) iInterfaceQueryLocalInterface;
            }
            return new C0110c(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
            boolean zC = c(parcel.readLong(), parcel.readLong(), z.c.c(parcel.readStrongBinder()));
            parcel2.writeNoException();
            parcel2.writeInt(zC ? 1 : 0);
            return true;
        }

        /* JADX INFO: renamed from: com.byazt.c.m$c$c, reason: collision with other inner class name */
        @com.byazt.zqa.c(c = {0, 1, 20, 1565})
        private static class C0110c implements m {
            public static m c;
            public IBinder tt;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.tt;
            }

            public C0110c(IBinder iBinder) {
                this.tt = iBinder;
            }

            @Override // com.byazt.c.m
            public boolean c(long j, long j2, z zVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
                    parcelObtain.writeLong(j);
                    parcelObtain.writeLong(j2);
                    parcelObtain.writeStrongBinder(zVar != null ? zVar.asBinder() : null);
                    if (!this.tt.transact(1, parcelObtain, parcelObtain2, 0) && c.c() != null) {
                        return c.c().c(j, j2, zVar);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static m c() {
            return C0110c.c;
        }
    }
}
