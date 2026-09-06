package com.unionpay.tsmservice.mi;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface ITsmCallback extends IInterface {

    public abstract class Stub extends Binder implements ITsmCallback {

        final class a implements ITsmCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f9350a;

            a(IBinder iBinder) {
                this.f9350a = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f9350a;
            }

            @Override // com.unionpay.tsmservice.mi.ITsmCallback
            public final void onError(String str, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmCallback");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.f9350a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmCallback
            public final void onResult(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmCallback");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f9350a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.unionpay.tsmservice.mi.ITsmCallback");
        }

        public static ITsmCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.unionpay.tsmservice.mi.ITsmCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ITsmCallback)) ? new a(iBinder) : (ITsmCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmCallback");
                onResult(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            } else {
                if (i != 2) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString("com.unionpay.tsmservice.mi.ITsmCallback");
                    return true;
                }
                parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmCallback");
                onError(parcel.readString(), parcel.readString());
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void onError(String str, String str2);

    void onResult(Bundle bundle);
}
