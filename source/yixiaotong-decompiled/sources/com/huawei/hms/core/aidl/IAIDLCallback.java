package com.huawei.hms.core.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface IAIDLCallback extends IInterface {

    public static abstract class Stub extends Binder implements IAIDLCallback {
        static final int TRANSACTION_call = 1;

        private static class a implements IAIDLCallback {
            public static IAIDLCallback b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f3997a;

            a(IBinder iBinder) {
                this.f3997a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f3997a;
            }
        }

        public Stub() {
            attachInterface(this, "com.huawei.hms.core.aidl.IAIDLCallback");
        }

        public static IAIDLCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.core.aidl.IAIDLCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IAIDLCallback)) ? new a(iBinder) : (IAIDLCallback) iInterfaceQueryLocalInterface;
        }

        public static IAIDLCallback getDefaultImpl() {
            return a.b;
        }

        public static boolean setDefaultImpl(IAIDLCallback iAIDLCallback) {
            if (a.b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iAIDLCallback == null) {
                return false;
            }
            a.b = iAIDLCallback;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.huawei.hms.core.aidl.IAIDLCallback");
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.huawei.hms.core.aidl.IAIDLCallback");
            call(parcel.readInt() != 0 ? DataBuffer.CREATOR.createFromParcel(parcel) : null);
            return true;
        }
    }

    void call(DataBuffer dataBuffer) throws RemoteException;
}
