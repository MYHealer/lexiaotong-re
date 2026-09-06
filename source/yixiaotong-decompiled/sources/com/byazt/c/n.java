package com.byazt.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public interface n extends IInterface {
    int c(long j) throws RemoteException;

    @com.byazt.zqa.c(c = {0, 1, 20, 151})
    public static abstract class c extends Binder implements n {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public c() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
        }

        public static n c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof n)) {
                return (n) iInterfaceQueryLocalInterface;
            }
            return new C0111c(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString("com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
            int iC = c(parcel.readLong());
            parcel2.writeNoException();
            parcel2.writeInt(iC);
            return true;
        }

        /* JADX INFO: renamed from: com.byazt.c.n$c$c, reason: collision with other inner class name */
        @com.byazt.zqa.c(c = {0, 1, 20, 156})
        private static class C0111c implements n {
            public static n c;
            public IBinder tt;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.tt;
            }

            public C0111c(IBinder iBinder) {
                this.tt = iBinder;
            }

            @Override // com.byazt.c.n
            public int c(long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
                    parcelObtain.writeLong(j);
                    if (!this.tt.transact(1, parcelObtain, parcelObtain2, 0) && c.c() != null) {
                        return c.c().c(j);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static n c() {
            return C0111c.c;
        }
    }
}
