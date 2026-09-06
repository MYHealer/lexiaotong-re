package com.byazt.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public interface qp extends IInterface {
    void c(int i, int i2) throws RemoteException;

    @com.byazt.zqa.c(c = {0, 1, 20, 2246})
    public static abstract class c extends Binder implements qp {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public c() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
        }

        public static qp c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof qp)) {
                return (qp) iInterfaceQueryLocalInterface;
            }
            return new C0113c(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
            c(parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: renamed from: com.byazt.c.qp$c$c, reason: collision with other inner class name */
        @com.byazt.zqa.c(c = {0, 1, 20, 2197})
        private static class C0113c implements qp {
            public static qp c;
            public IBinder tt;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.tt;
            }

            public C0113c(IBinder iBinder) {
                this.tt = iBinder;
            }

            @Override // com.byazt.c.qp
            public void c(int i, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    if (!this.tt.transact(1, parcelObtain, parcelObtain2, 0) && c.c() != null) {
                        c.c().c(i, i2);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static qp c() {
            return C0113c.c;
        }
    }
}
