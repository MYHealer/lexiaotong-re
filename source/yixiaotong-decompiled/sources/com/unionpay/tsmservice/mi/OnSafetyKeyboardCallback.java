package com.unionpay.tsmservice.mi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface OnSafetyKeyboardCallback extends IInterface {

    public abstract class Stub extends Binder implements OnSafetyKeyboardCallback {

        final class a implements OnSafetyKeyboardCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f9353a;

            a(IBinder iBinder) {
                this.f9353a = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f9353a;
            }

            @Override // com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback
            public final void onConfirmClicked() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
                    this.f9353a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback
            public final void onEditorChanged(int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
                    parcelObtain.writeInt(i);
                    this.f9353a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback
            public final void onHide() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
                    this.f9353a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback
            public final void onOutsideTouch(float f, float f2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
                    parcelObtain.writeFloat(f);
                    parcelObtain.writeFloat(f2);
                    this.f9353a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback
            public final void onShow() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
                    this.f9353a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
        }

        public static OnSafetyKeyboardCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof OnSafetyKeyboardCallback)) ? new a(iBinder) : (OnSafetyKeyboardCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
                onShow();
            } else if (i == 2) {
                parcel.enforceInterface("com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
                onHide();
            } else if (i == 3) {
                parcel.enforceInterface("com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
                onEditorChanged(parcel.readInt());
            } else if (i == 4) {
                parcel.enforceInterface("com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
                onOutsideTouch(parcel.readFloat(), parcel.readFloat());
            } else {
                if (i != 5) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString("com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
                    return true;
                }
                parcel.enforceInterface("com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
                onConfirmClicked();
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void onConfirmClicked();

    void onEditorChanged(int i);

    void onHide();

    void onOutsideTouch(float f, float f2);

    void onShow();
}
