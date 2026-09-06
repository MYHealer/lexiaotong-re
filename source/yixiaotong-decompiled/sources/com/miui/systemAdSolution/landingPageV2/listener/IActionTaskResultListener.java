package com.miui.systemAdSolution.landingPageV2.listener;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface IActionTaskResultListener extends IInterface {

    public static class Default implements IActionTaskResultListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.miui.systemAdSolution.landingPageV2.listener.IActionTaskResultListener
        public void onActionTaskCreate(String str) {
        }

        @Override // com.miui.systemAdSolution.landingPageV2.listener.IActionTaskResultListener
        public void onResultFail() {
        }

        @Override // com.miui.systemAdSolution.landingPageV2.listener.IActionTaskResultListener
        public void onResultSuccess() {
        }
    }

    public static abstract class Stub extends Binder implements IActionTaskResultListener {
        private static final String DESCRIPTOR = s.d(new byte[]{82, 86, 91, 76, 95, 90, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 69, 92, 91, 35, 86, 96, 14, 8, 19, Ascii.SYN, 88, 10, 95, Ascii.ETB, 90, 3, 92, 87, 8, 10, 1, 50, 80, 2, 84, 111, 4, 76, 94, 90, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB, Ascii.US, 112, 119, 1, 70, 90, 14, 10, 50, 3, 66, 14, 99, 92, 69, Ascii.ETB, 94, 71, 45, 13, Ascii.NAK, Ascii.SYN, 84, 11, 84, 75}, "196b23");
        public static final int TRANSACTION_onActionTaskCreate = 1;
        public static final int TRANSACTION_onResultFail = 3;
        public static final int TRANSACTION_onResultSuccess = 2;

        public static class Proxy implements IActionTaskResultListener {
            public static IActionTaskResultListener sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return s.d(new byte[]{86, 92, 12, 75, 88, 81, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 65, 86, 12, 36, 81, 107, 14, 8, 19, Ascii.SYN, 88, 10, 91, Ascii.GS, 13, 4, 91, 92, 8, 10, 1, 50, 80, 2, 80, 101, 83, 75, 89, 81, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB, Ascii.ESC, 122, 32, 6, 65, 81, 14, 10, 50, 3, 66, 14, 103, 86, Ascii.DC2, 16, 89, 76, 45, 13, Ascii.NAK, Ascii.SYN, 84, 11, 80, 65}, "53ae58");
            }

            @Override // com.miui.systemAdSolution.landingPageV2.listener.IActionTaskResultListener
            public void onActionTaskCreate(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{83, 9, 94, 74, 14, 81, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 68, 3, 94, 37, 7, 107, 14, 8, 19, Ascii.SYN, 88, 10, 94, 72, 95, 5, 13, 92, 8, 10, 1, 50, 80, 2, 85, 48, 1, 74, 15, 81, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB, Ascii.RS, 47, 114, 7, Ascii.ETB, 81, 14, 10, 50, 3, 66, 14, 98, 3, SignedBytes.MAX_POWER_OF_TWO, 17, 15, 76, 45, 13, Ascii.NAK, Ascii.SYN, 84, 11, 85, Ascii.DC4}, "0f3dc8"));
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onActionTaskCreate(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.listener.IActionTaskResultListener
            public void onResultFail() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{85, 87, 9, Ascii.ETB, 95, 10, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 66, 93, 9, 120, 86, 48, 14, 8, 19, Ascii.SYN, 88, 10, 88, Ascii.SYN, 8, 88, 92, 7, 8, 10, 1, 50, 80, 2, 83, 110, 86, Ascii.ETB, 94, 10, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB, Ascii.CAN, 113, 37, 90, 70, 10, 14, 10, 50, 3, 66, 14, 100, 93, Ascii.ETB, 76, 94, Ascii.ETB, 45, 13, Ascii.NAK, Ascii.SYN, 84, 11, 83, 74}, "68d92c"));
                    if (this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onResultFail();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.listener.IActionTaskResultListener
            public void onResultSuccess() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{90, 88, 89, Ascii.CAN, 9, 93, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 77, 82, 89, 119, 0, 103, 14, 8, 19, Ascii.SYN, 88, 10, 87, Ascii.EM, 88, 87, 10, 80, 8, 10, 1, 50, 80, 2, 92, 97, 6, Ascii.CAN, 8, 93, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB, Ascii.ETB, 126, 117, 85, 16, 93, 14, 10, 50, 3, 66, 14, 107, 82, 71, 67, 8, SignedBytes.MAX_POWER_OF_TWO, 45, 13, Ascii.NAK, Ascii.SYN, 84, 11, 92, 69}, "9746d4"));
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onResultSuccess();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, s.d(new byte[]{86, 88, 90, 76, 85, 13, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 65, 82, 90, 35, 92, 55, 14, 8, 19, Ascii.SYN, 88, 10, 91, Ascii.EM, 91, 3, 86, 0, 8, 10, 1, 50, 80, 2, 80, 97, 5, 76, 84, 13, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB, Ascii.ESC, 126, 118, 1, 76, 13, 14, 10, 50, 3, 66, 14, 103, 82, 68, Ascii.ETB, 84, 16, 45, 13, Ascii.NAK, Ascii.SYN, 84, 11, 80, 69}, "577b8d"));
        }

        public static IActionTaskResultListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IActionTaskResultListener)) ? new Proxy(iBinder) : (IActionTaskResultListener) iInterfaceQueryLocalInterface;
        }

        public static IActionTaskResultListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IActionTaskResultListener iActionTaskResultListener) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException(s.d(new byte[]{69, 80, 69, 115, 86, 5, 0, 17, 10, Ascii.SYN, 120, 8, 70, 89, Ascii.EM, Ascii.RS, 19, 0, 0, 8, 10, 7, 85, 69, 66, 66, 88, 84, 86}, "65173c"));
            }
            if (iActionTaskResultListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iActionTaskResultListener;
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
                onActionTaskCreate(parcel.readString());
            } else if (i == 2) {
                parcel.enforceInterface(str);
                onResultSuccess();
            } else {
                if (i != 3) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString(str);
                    return true;
                }
                parcel.enforceInterface(str);
                onResultFail();
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void onActionTaskCreate(String str);

    void onResultFail();

    void onResultSuccess();
}
