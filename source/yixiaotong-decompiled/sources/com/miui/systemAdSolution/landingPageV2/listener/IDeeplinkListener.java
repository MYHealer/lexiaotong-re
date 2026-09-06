package com.miui.systemAdSolution.landingPageV2.listener;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface IDeeplinkListener extends IInterface {

    public static class Default implements IDeeplinkListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.miui.systemAdSolution.landingPageV2.listener.IDeeplinkListener
        public void onDeeplinkFail() {
        }

        @Override // com.miui.systemAdSolution.landingPageV2.listener.IDeeplinkListener
        public void onDeeplinkSuccess() {
        }
    }

    public static abstract class Stub extends Binder implements IDeeplinkListener {
        private static final String DESCRIPTOR = s.d(new byte[]{1, 89, 92, Ascii.SYN, 95, 13, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, Ascii.SYN, 83, 92, 121, 86, 55, 14, 8, 19, Ascii.SYN, 88, 10, 12, Ascii.CAN, 93, 89, 92, 0, 8, 10, 1, 50, 80, 2, 7, 96, 3, Ascii.SYN, 94, 13, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB, 76, 127, 117, 93, 87, Ascii.DC4, 13, 13, 8, 9, 125, 12, 17, 66, 84, 86, 87, Ascii.SYN}, "b6182d");
        public static final int TRANSACTION_onDeeplinkFail = 2;
        public static final int TRANSACTION_onDeeplinkSuccess = 1;

        public static class Proxy implements IDeeplinkListener {
            public static IDeeplinkListener sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return s.d(new byte[]{6, 11, 88, Ascii.CAN, 95, 80, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 17, 1, 88, 119, 86, 106, 14, 8, 19, Ascii.SYN, 88, 10, 11, 74, 89, 87, 92, 93, 8, 10, 1, 50, 80, 2, 0, 50, 7, Ascii.CAN, 94, 80, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB, 75, 45, 113, 83, 87, 73, 13, 13, 8, 9, 125, 12, Ascii.SYN, 16, 80, 88, 87, 75}, "ed5629");
            }

            @Override // com.miui.systemAdSolution.landingPageV2.listener.IDeeplinkListener
            public void onDeeplinkFail() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{91, 91, 93, Ascii.ESC, 8, 12, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 76, 81, 93, 116, 1, 54, 14, 8, 19, Ascii.SYN, 88, 10, 86, 26, 92, 84, 11, 1, 8, 10, 1, 50, 80, 2, 93, 98, 2, Ascii.ESC, 9, 12, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB, Ascii.SYN, 125, 116, 80, 0, Ascii.NAK, 13, 13, 8, 9, 125, 12, 75, SignedBytes.MAX_POWER_OF_TWO, 85, 91, 0, Ascii.ETB}, "8405ee"));
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onDeeplinkFail();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.listener.IDeeplinkListener
            public void onDeeplinkSuccess() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{80, 89, 92, Ascii.EM, 85, 8, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 71, 83, 92, 118, 92, 50, 14, 8, 19, Ascii.SYN, 88, 10, 93, Ascii.CAN, 93, 86, 86, 5, 8, 10, 1, 50, 80, 2, 86, 96, 3, Ascii.EM, 84, 8, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB, Ascii.GS, 127, 117, 82, 93, 17, 13, 13, 8, 9, 125, 12, SignedBytes.MAX_POWER_OF_TWO, 66, 84, 89, 93, 19}, "36178a"));
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onDeeplinkSuccess();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, s.d(new byte[]{2, 87, 95, 74, 15, 10, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, Ascii.NAK, 93, 95, 37, 6, 48, 14, 8, 19, Ascii.SYN, 88, 10, 15, Ascii.SYN, 94, 5, 12, 7, 8, 10, 1, 50, 80, 2, 4, 110, 0, 74, 14, 10, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB, 79, 113, 118, 1, 7, 19, 13, 13, 8, 9, 125, 12, Ascii.DC2, 76, 87, 10, 7, 17}, "a82dbc"));
        }

        public static IDeeplinkListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IDeeplinkListener)) ? new Proxy(iBinder) : (IDeeplinkListener) iInterfaceQueryLocalInterface;
        }

        public static IDeeplinkListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IDeeplinkListener iDeeplinkListener) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException(s.d(new byte[]{Ascii.ETB, 87, Ascii.ETB, 112, 80, 84, 0, 17, 10, Ascii.SYN, 120, 8, Ascii.DC4, 94, 75, Ascii.GS, Ascii.NAK, 81, 0, 8, 10, 7, 85, 69, 16, 69, 10, 87, 80}, "d2c452"));
            }
            if (iDeeplinkListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iDeeplinkListener;
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
                onDeeplinkSuccess();
            } else {
                if (i != 2) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString(str);
                    return true;
                }
                parcel.enforceInterface(str);
                onDeeplinkFail();
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void onDeeplinkFail();

    void onDeeplinkSuccess();
}
