package com.miui.systemAdSolution.landingPageV2.listener;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface IInstallListener extends IInterface {

    public static class Default implements IInstallListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.miui.systemAdSolution.landingPageV2.listener.IInstallListener
        public void onInstallFail() {
        }

        @Override // com.miui.systemAdSolution.landingPageV2.listener.IInstallListener
        public void onInstallStart() {
        }

        @Override // com.miui.systemAdSolution.landingPageV2.listener.IInstallListener
        public void onInstallSuccess() {
        }
    }

    public static abstract class Stub extends Binder implements IInstallListener {
        private static final String DESCRIPTOR = s.d(new byte[]{2, 12, 95, Ascii.CAN, 91, 12, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, Ascii.NAK, 6, 95, 119, 82, 54, 14, 8, 19, Ascii.SYN, 88, 10, 15, 77, 94, 87, 88, 1, 8, 10, 1, 50, 80, 2, 4, 53, 0, Ascii.CAN, 90, 12, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB, 79, 42, 123, 88, 69, 17, 0, 8, 10, 46, 88, Ascii.SYN, Ascii.NAK, 6, 92, 83, 68}, "ac266e");
        public static final int TRANSACTION_onInstallFail = 3;
        public static final int TRANSACTION_onInstallStart = 1;
        public static final int TRANSACTION_onInstallSuccess = 2;

        public static class Proxy implements IInstallListener {
            public static IInstallListener sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return s.d(new byte[]{85, 90, 88, Ascii.ETB, 85, 12, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 66, 80, 88, 120, 92, 54, 14, 8, 19, Ascii.SYN, 88, 10, 88, Ascii.ESC, 89, 88, 86, 1, 8, 10, 1, 50, 80, 2, 83, 99, 7, Ascii.ETB, 84, 12, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB, Ascii.CAN, 124, 124, 87, 75, 17, 0, 8, 10, 46, 88, Ascii.SYN, 66, 80, 91, 92, 74}, "65598e");
            }

            @Override // com.miui.systemAdSolution.landingPageV2.listener.IInstallListener
            public void onInstallFail() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{91, 13, 14, 26, 93, 93, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 76, 7, 14, 117, 84, 103, 14, 8, 19, Ascii.SYN, 88, 10, 86, 76, 15, 85, 94, 80, 8, 10, 1, 50, 80, 2, 93, 52, 81, 26, 92, 93, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB, Ascii.SYN, 43, 42, 90, 67, SignedBytes.MAX_POWER_OF_TWO, 0, 8, 10, 46, 88, Ascii.SYN, 76, 7, 13, 81, 66}, "8bc404"));
                    if (this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onInstallFail();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.listener.IInstallListener
            public void onInstallStart() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{82, 91, 90, 26, 15, 88, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 69, 81, 90, 117, 6, 98, 14, 8, 19, Ascii.SYN, 88, 10, 95, 26, 91, 85, 12, 85, 8, 10, 1, 50, 80, 2, 84, 98, 5, 26, 14, 88, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB, Ascii.US, 125, 126, 90, 17, 69, 0, 8, 10, 46, 88, Ascii.SYN, 69, 81, 89, 81, 16}, "1474b1"));
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onInstallStart();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.listener.IInstallListener
            public void onInstallSuccess() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{81, 9, 90, Ascii.ESC, 93, 10, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 70, 3, 90, 116, 84, 48, 14, 8, 19, Ascii.SYN, 88, 10, 92, 72, 91, 84, 94, 7, 8, 10, 1, 50, 80, 2, 87, 48, 5, Ascii.ESC, 92, 10, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB, Ascii.FS, 47, 126, 91, 67, Ascii.ETB, 0, 8, 10, 46, 88, Ascii.SYN, 70, 3, 89, 80, 66}, "2f750c"));
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onInstallSuccess();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, s.d(new byte[]{2, 14, 95, 26, 15, 80, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, Ascii.NAK, 4, 95, 117, 6, 106, 14, 8, 19, Ascii.SYN, 88, 10, 15, 79, 94, 85, 12, 93, 8, 10, 1, 50, 80, 2, 4, 55, 0, 26, 14, 80, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB, 79, 40, 123, 90, 17, 77, 0, 8, 10, 46, 88, Ascii.SYN, Ascii.NAK, 4, 92, 81, 16}, "aa24b9"));
        }

        public static IInstallListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IInstallListener)) ? new Proxy(iBinder) : (IInstallListener) iInterfaceQueryLocalInterface;
        }

        public static IInstallListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IInstallListener iInstallListener) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException(s.d(new byte[]{65, 3, 16, 33, 84, 87, 0, 17, 10, Ascii.SYN, 120, 8, 66, 10, 76, 76, 17, 82, 0, 8, 10, 7, 85, 69, 70, 17, 13, 6, 84}, "2fde11"));
            }
            if (iInstallListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iInstallListener;
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
                onInstallStart();
            } else if (i == 2) {
                parcel.enforceInterface(str);
                onInstallSuccess();
            } else {
                if (i != 3) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString(str);
                    return true;
                }
                parcel.enforceInterface(str);
                onInstallFail();
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void onInstallFail();

    void onInstallStart();

    void onInstallSuccess();
}
