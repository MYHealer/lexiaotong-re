package com.miui.zeus.auth.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface ICheckListener extends IInterface {

    public static class Default implements ICheckListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.miui.zeus.auth.aidl.ICheckListener
        public void onFailure(String str, int i) {
        }

        @Override // com.miui.zeus.auth.aidl.ICheckListener
        public void onSuccess(String str) {
        }
    }

    public static abstract class Stub extends Binder implements ICheckListener {
        private static final String DESCRIPTOR = s.d(new byte[]{91, 10, 90, Ascii.EM, 85, 12, Ascii.DC4, 13, 72, Ascii.CAN, 84, 16, 75, 75, 86, 66, 76, 13, 79, 5, 15, 6, 93, 75, 113, 38, 95, 82, 91, 14, 45, 13, Ascii.NAK, Ascii.SYN, 84, 11, 93, Ascii.ETB}, "8e778e");
        public static final int TRANSACTION_onFailure = 2;
        public static final int TRANSACTION_onSuccess = 1;

        public static class Proxy implements ICheckListener {
            public static ICheckListener sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return s.d(new byte[]{90, 9, 89, Ascii.RS, 15, 94, Ascii.DC4, 13, 72, Ascii.CAN, 84, 16, 74, 72, 85, 69, Ascii.SYN, 95, 79, 5, 15, 6, 93, 75, 112, 37, 92, 85, 1, 92, 45, 13, Ascii.NAK, Ascii.SYN, 84, 11, 92, Ascii.DC4}, "9f40b7");
            }

            @Override // com.miui.zeus.auth.aidl.ICheckListener
            public void onFailure(String str, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{83, 93, 84, Ascii.EM, 94, 94, Ascii.DC4, 13, 72, Ascii.CAN, 84, 16, 67, Ascii.FS, 88, 66, 71, 95, 79, 5, 15, 6, 93, 75, 121, 113, 81, 82, 80, 92, 45, 13, Ascii.NAK, Ascii.SYN, 84, 11, 85, SignedBytes.MAX_POWER_OF_TWO}, "029737"));
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onFailure(str, i);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.zeus.auth.aidl.ICheckListener
            public void onSuccess(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{91, 95, 11, Ascii.ESC, 88, 92, Ascii.DC4, 13, 72, Ascii.CAN, 84, 16, 75, Ascii.RS, 7, SignedBytes.MAX_POWER_OF_TWO, 65, 93, 79, 5, 15, 6, 93, 75, 113, 115, 14, 80, 86, 94, 45, 13, Ascii.NAK, Ascii.SYN, 84, 11, 93, 66}, "80f555"));
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onSuccess(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, s.d(new byte[]{91, 11, 90, 26, 12, 13, Ascii.DC4, 13, 72, Ascii.CAN, 84, 16, 75, 74, 86, 65, Ascii.NAK, 12, 79, 5, 15, 6, 93, 75, 113, 39, 95, 81, 2, 15, 45, 13, Ascii.NAK, Ascii.SYN, 84, 11, 93, Ascii.SYN}, "8d74ad"));
        }

        public static ICheckListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ICheckListener)) ? new Proxy(iBinder) : (ICheckListener) iInterfaceQueryLocalInterface;
        }

        public static ICheckListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICheckListener iCheckListener) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException(s.d(new byte[]{67, 4, SignedBytes.MAX_POWER_OF_TWO, 124, 4, 81, 0, 17, 10, Ascii.SYN, 120, 8, SignedBytes.MAX_POWER_OF_TWO, 13, Ascii.FS, 17, 65, 84, 0, 8, 10, 7, 85, 69, 68, Ascii.SYN, 93, 91, 4}, "0a48a7"));
            }
            if (iCheckListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iCheckListener;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            String str = DESCRIPTOR;
            if (i == 1) {
                parcel.enforceInterface(str);
                onSuccess(parcel.readString());
            } else {
                if (i != 2) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString(str);
                    return true;
                }
                parcel.enforceInterface(str);
                onFailure(parcel.readString(), parcel.readInt());
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void onFailure(String str, int i);

    void onSuccess(String str);
}
