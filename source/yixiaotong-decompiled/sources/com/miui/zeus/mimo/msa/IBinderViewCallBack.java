package com.miui.zeus.mimo.msa;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.common.base.Ascii;
import com.miui.zeus.mimo.sdk.z;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface IBinderViewCallBack extends IInterface {

    public static class Default implements IBinderViewCallBack {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.miui.zeus.mimo.msa.IBinderViewCallBack
        public void attachView(z zVar) {
        }
    }

    public static abstract class Stub extends Binder implements IBinderViewCallBack {
        private static final String DESCRIPTOR = s.d(new byte[]{86, 87, 89, 75, 12, 93, Ascii.DC4, 13, 72, Ascii.CAN, 84, 16, 70, Ascii.SYN, 89, 12, 12, 91, 79, 9, Ascii.NAK, 3, Ascii.US, 44, 119, 81, 90, 1, 4, 70, 55, 13, 3, Ascii.NAK, 114, 4, 89, 84, 118, 4, 2, 95}, "584ea4");
        public static final int TRANSACTION_attachView = 1;

        public static class Proxy implements IBinderViewCallBack {
            public static IBinderViewCallBack sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.miui.zeus.mimo.msa.IBinderViewCallBack
            public void attachView(z zVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{83, 90, 14, 76, 11, 89, Ascii.DC4, 13, 72, Ascii.CAN, 84, 16, 67, Ascii.ESC, 14, 11, 11, 95, 79, 9, Ascii.NAK, 3, Ascii.US, 44, 114, 92, 13, 6, 3, 66, 55, 13, 3, Ascii.NAK, 114, 4, 92, 89, 33, 3, 5, 91}, "05cbf0"));
                    if (zVar != null) {
                        parcelObtain.writeInt(1);
                        parcelObtain.writeInt(zVar.f5753a);
                        parcelObtain.writeString(zVar.b);
                        parcelObtain.writeString(zVar.c);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().attachView(zVar);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return s.d(new byte[]{1, 90, 92, Ascii.CAN, 12, 88, Ascii.DC4, 13, 72, Ascii.CAN, 84, 16, 17, Ascii.ESC, 92, 95, 12, 94, 79, 9, Ascii.NAK, 3, Ascii.US, 44, 32, 92, 95, 82, 4, 67, 55, 13, 3, Ascii.NAK, 114, 4, 14, 89, 115, 87, 2, 90}, "b516a1");
            }
        }

        public Stub() {
            attachInterface(this, s.d(new byte[]{90, 12, 9, 74, 11, 15, Ascii.DC4, 13, 72, Ascii.CAN, 84, 16, 74, 77, 9, 13, 11, 9, 79, 9, Ascii.NAK, 3, Ascii.US, 44, 123, 10, 10, 0, 3, Ascii.DC4, 55, 13, 3, Ascii.NAK, 114, 4, 85, 15, 38, 5, 5, 13}, "9cddff"));
        }

        public static IBinderViewCallBack asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IBinderViewCallBack)) ? new Proxy(iBinder) : (IBinderViewCallBack) iInterfaceQueryLocalInterface;
        }

        public static IBinderViewCallBack getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IBinderViewCallBack iBinderViewCallBack) {
            if (Proxy.sDefaultImpl != null || iBinderViewCallBack == null) {
                return false;
            }
            Proxy.sDefaultImpl = iBinderViewCallBack;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            String str = DESCRIPTOR;
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(str);
                return true;
            }
            parcel.enforceInterface(str);
            attachView(parcel.readInt() != 0 ? z.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    void attachView(z zVar);
}
