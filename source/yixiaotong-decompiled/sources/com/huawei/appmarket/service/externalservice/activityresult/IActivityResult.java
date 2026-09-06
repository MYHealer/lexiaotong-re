package com.huawei.appmarket.service.externalservice.activityresult;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface IActivityResult extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.appmarket.service.externalservice.activityresult.IActivityResult";

    public static class a implements IActivityResult {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.appmarket.service.externalservice.activityresult.IActivityResult
        public void onActivityCancel(int i) {
        }
    }

    public static abstract class b extends Binder implements IActivityResult {
        static final int Code = 1;

        private static class a implements IActivityResult {
            public static IActivityResult Code;
            private IBinder V;

            a(IBinder iBinder) {
                this.V = iBinder;
            }

            public String Code() {
                return IActivityResult.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.V;
            }

            @Override // com.huawei.appmarket.service.externalservice.activityresult.IActivityResult
            public void onActivityCancel(int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IActivityResult.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (this.V.transact(1, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().onActivityCancel(i);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, IActivityResult.DESCRIPTOR);
        }

        public static IActivityResult Code() {
            return a.Code;
        }

        public static IActivityResult Code(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IActivityResult.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IActivityResult)) ? new a(iBinder) : (IActivityResult) iInterfaceQueryLocalInterface;
        }

        public static boolean Code(IActivityResult iActivityResult) {
            if (a.Code != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iActivityResult == null) {
                return false;
            }
            a.Code = iActivityResult;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString(IActivityResult.DESCRIPTOR);
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(IActivityResult.DESCRIPTOR);
            onActivityCancel(parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
    }

    void onActivityCancel(int i);
}
