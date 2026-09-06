package com.byazt.omf;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public interface da extends IInterface {
    IBinder c(int i) throws RemoteException;

    @com.byazt.zqa.c(c = {0, 1, 31, 45})
    public static abstract class c extends Binder implements da {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public c() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.core.IBinderPool");
        }

        public static da c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.core.IBinderPool");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof da)) {
                return (da) iInterfaceQueryLocalInterface;
            }
            return new C0234c(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString("com.bytedance.sdk.openadsdk.core.IBinderPool");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IBinderPool");
            IBinder iBinderC = c(parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeStrongBinder(iBinderC);
            return true;
        }

        /* JADX INFO: renamed from: com.byazt.omf.da$c$c, reason: collision with other inner class name */
        @com.byazt.zqa.c(c = {0, 1, 31, 783})
        private static class C0234c implements da {
            public static da c;
            public IBinder tt;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.tt;
            }

            public C0234c(IBinder iBinder) {
                this.tt = iBinder;
            }

            @Override // com.byazt.omf.da
            public IBinder c(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IBinderPool");
                    parcelObtain.writeInt(i);
                    if (!this.tt.transact(1, parcelObtain, parcelObtain2, 0) && c.c() != null) {
                        return c.c().c(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readStrongBinder();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static da c() {
            return C0234c.c;
        }
    }
}
