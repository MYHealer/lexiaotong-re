package com.miui.systemAdSolution.landingPageV2.listener;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.common.base.Ascii;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface IH5Listener extends IInterface {

    public static class Default implements IH5Listener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.miui.systemAdSolution.landingPageV2.listener.IH5Listener
        public void onH5Fail() {
        }

        @Override // com.miui.systemAdSolution.landingPageV2.listener.IH5Listener
        public void onH5Success() {
        }
    }

    public static abstract class Stub extends Binder implements IH5Listener {
        private static final String DESCRIPTOR = s.d(new byte[]{5, 90, 84, 77, 8, 13, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, Ascii.DC2, 80, 84, 34, 1, 55, 14, 8, 19, Ascii.SYN, 88, 10, 8, Ascii.ESC, 85, 2, 11, 0, 8, 10, 1, 50, 80, 2, 3, 99, 11, 77, 9, 13, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB, 72, 124, 113, 86, 41, 13, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB}, "f59ced");
        public static final int TRANSACTION_onH5Fail = 2;
        public static final int TRANSACTION_onH5Success = 1;

        public static class Proxy implements IH5Listener {
            public static IH5Listener sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return s.d(new byte[]{83, 91, 95, Ascii.GS, 15, 94, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 68, 81, 95, 114, 6, 100, 14, 8, 19, Ascii.SYN, 88, 10, 94, 26, 94, 82, 12, 83, 8, 10, 1, 50, 80, 2, 85, 98, 0, Ascii.GS, 14, 94, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB, Ascii.RS, 125, 122, 6, 46, 94, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB}, "0423b7");
            }

            @Override // com.miui.systemAdSolution.landingPageV2.listener.IH5Listener
            public void onH5Fail() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{7, 95, 8, Ascii.SYN, 14, 93, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 16, 85, 8, 121, 7, 103, 14, 8, 19, Ascii.SYN, 88, 10, 10, Ascii.RS, 9, 89, 13, 80, 8, 10, 1, 50, 80, 2, 1, 102, 87, Ascii.SYN, 15, 93, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB, 74, 121, 45, 13, 47, 93, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB}, "d0e8c4"));
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onH5Fail();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.listener.IH5Listener
            public void onH5Success() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{84, 90, 84, Ascii.ETB, 94, 94, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 67, 80, 84, 120, 87, 100, 14, 8, 19, Ascii.SYN, 88, 10, 89, Ascii.ESC, 85, 88, 93, 83, 8, 10, 1, 50, 80, 2, 82, 99, 11, Ascii.ETB, 95, 94, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB, Ascii.EM, 124, 113, 12, 127, 94, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB}, "759937"));
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onH5Success();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, s.d(new byte[]{91, 10, 9, Ascii.SYN, 93, 80, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 76, 0, 9, 121, 84, 106, 14, 8, 19, Ascii.SYN, 88, 10, 86, 75, 8, 89, 94, 93, 8, 10, 1, 50, 80, 2, 93, 51, 86, Ascii.SYN, 92, 80, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB, Ascii.SYN, 44, 44, 13, 124, 80, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB}, "8ed809"));
        }

        public static IH5Listener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IH5Listener)) ? new Proxy(iBinder) : (IH5Listener) iInterfaceQueryLocalInterface;
        }

        public static IH5Listener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IH5Listener iH5Listener) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException(s.d(new byte[]{70, 80, 77, 38, 80, 5, 0, 17, 10, Ascii.SYN, 120, 8, 69, 89, 17, 75, Ascii.NAK, 0, 0, 8, 10, 7, 85, 69, 65, 66, 80, 1, 80}, "559b5c"));
            }
            if (iH5Listener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iH5Listener;
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
                onH5Success();
            } else {
                if (i != 2) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString(str);
                    return true;
                }
                parcel.enforceInterface(str);
                onH5Fail();
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void onH5Fail();

    void onH5Success();
}
