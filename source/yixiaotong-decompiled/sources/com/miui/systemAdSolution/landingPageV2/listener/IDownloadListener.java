package com.miui.systemAdSolution.landingPageV2.listener;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface IDownloadListener extends IInterface {

    public static class Default implements IDownloadListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener
        public void onDownloadCancel() {
        }

        @Override // com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener
        public void onDownloadFail() {
        }

        @Override // com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener
        public void onDownloadProgress(int i) {
        }

        @Override // com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener
        public void onDownloadStart() {
        }

        @Override // com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener
        public void onDownloadSuccess() {
        }

        @Override // com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener
        public void onInstallFail() {
        }

        @Override // com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener
        public void onInstallStart() {
        }

        @Override // com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener
        public void onInstallSuccess() {
        }

        @Override // com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener
        public void onMarketDownloadDenied() {
        }
    }

    public static abstract class Stub extends Binder implements IDownloadListener {
        private static final String DESCRIPTOR = s.d(new byte[]{6, 13, 85, 76, 92, 91, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 17, 7, 85, 35, 85, 97, 14, 8, 19, Ascii.SYN, 88, 10, 11, 76, 84, 3, 95, 86, 8, 10, 1, 50, 80, 2, 0, 52, 10, 76, 93, 91, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB, 75, 43, 124, 13, 70, 92, 13, 11, 7, 6, 125, 12, Ascii.SYN, Ascii.SYN, 93, 12, 84, SignedBytes.MAX_POWER_OF_TWO}, "eb8b12");
        public static final int TRANSACTION_onDownloadCancel = 5;
        public static final int TRANSACTION_onDownloadFail = 4;
        public static final int TRANSACTION_onDownloadProgress = 3;
        public static final int TRANSACTION_onDownloadStart = 1;
        public static final int TRANSACTION_onDownloadSuccess = 2;
        public static final int TRANSACTION_onInstallFail = 7;
        public static final int TRANSACTION_onInstallStart = 8;
        public static final int TRANSACTION_onInstallSuccess = 6;
        public static final int TRANSACTION_onMarketDownloadDenied = 9;

        public static class Proxy implements IDownloadListener {
            public static IDownloadListener sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return s.d(new byte[]{2, 9, 12, 79, 15, 94, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, Ascii.NAK, 3, 12, 32, 6, 100, 14, 8, 19, Ascii.SYN, 88, 10, 15, 72, 13, 0, 12, 83, 8, 10, 1, 50, 80, 2, 4, 48, 83, 79, 14, 94, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB, 79, 47, 37, 14, Ascii.NAK, 89, 13, 11, 7, 6, 125, 12, Ascii.DC2, Ascii.DC2, 4, 15, 7, 69}, "afaab7");
            }

            @Override // com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener
            public void onDownloadCancel() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{7, 87, 9, 26, 9, 92, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 16, 93, 9, 117, 0, 102, 14, 8, 19, Ascii.SYN, 88, 10, 10, Ascii.SYN, 8, 85, 10, 81, 8, 10, 1, 50, 80, 2, 1, 110, 86, 26, 8, 92, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB, 74, 113, 32, 91, 19, 91, 13, 11, 7, 6, 125, 12, Ascii.ETB, 76, 1, 90, 1, 71}, "d8d4d5"));
                    if (this.mRemote.transact(5, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onDownloadCancel();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener
            public void onDownloadFail() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{90, 89, 93, Ascii.GS, 92, 93, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 77, 83, 93, 114, 85, 103, 14, 8, 19, Ascii.SYN, 88, 10, 87, Ascii.CAN, 92, 82, 95, 80, 8, 10, 1, 50, 80, 2, 92, 96, 2, Ascii.GS, 93, 93, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB, Ascii.ETB, 127, 116, 92, 70, 90, 13, 11, 7, 6, 125, 12, 74, 66, 85, 93, 84, 70}, "960314"));
                    if (this.mRemote.transact(4, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onDownloadFail();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener
            public void onDownloadProgress(int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{83, 95, 89, 77, 14, 11, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 68, 85, 89, 34, 7, 49, 14, 8, 19, Ascii.SYN, 88, 10, 94, Ascii.RS, 88, 2, 13, 6, 8, 10, 1, 50, 80, 2, 85, 102, 6, 77, 15, 11, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB, Ascii.RS, 121, 112, 12, Ascii.DC4, 12, 13, 11, 7, 6, 125, 12, 67, 68, 81, 13, 6, 16}, "004ccb"));
                    parcelObtain.writeInt(i);
                    if (this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onDownloadProgress(i);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener
            public void onDownloadStart() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{1, 94, 93, Ascii.ESC, 95, 93, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, Ascii.SYN, 84, 93, 116, 86, 103, 14, 8, 19, Ascii.SYN, 88, 10, 12, Ascii.US, 92, 84, 92, 80, 8, 10, 1, 50, 80, 2, 7, 103, 2, Ascii.ESC, 94, 93, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB, 76, 120, 116, 90, 69, 90, 13, 11, 7, 6, 125, 12, 17, 69, 85, 91, 87, 70}, "b10524"));
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onDownloadStart();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener
            public void onDownloadSuccess() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{90, 92, 88, 76, 93, 15, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 77, 86, 88, 35, 84, 53, 14, 8, 19, Ascii.SYN, 88, 10, 87, Ascii.GS, 89, 3, 94, 2, 8, 10, 1, 50, 80, 2, 92, 101, 7, 76, 92, 15, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB, Ascii.ETB, 122, 113, 13, 71, 8, 13, 11, 7, 6, 125, 12, 74, 71, 80, 12, 85, Ascii.DC4}, "935b0f"));
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onDownloadSuccess();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener
            public void onInstallFail() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{2, 12, 93, Ascii.US, 91, 90, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, Ascii.NAK, 6, 93, 112, 82, 96, 14, 8, 19, Ascii.SYN, 88, 10, 15, 77, 92, 80, 88, 87, 8, 10, 1, 50, 80, 2, 4, 53, 2, Ascii.US, 90, 90, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB, 79, 42, 116, 94, 65, 93, 13, 11, 7, 6, 125, 12, Ascii.DC2, Ascii.ETB, 85, 95, 83, 65}, "ac0163"));
                    if (this.mRemote.transact(7, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onInstallFail();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener
            public void onInstallStart() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{91, 89, 15, Ascii.RS, 85, 81, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 76, 83, 15, 113, 92, 107, 14, 8, 19, Ascii.SYN, 88, 10, 86, Ascii.CAN, 14, 81, 86, 92, 8, 10, 1, 50, 80, 2, 93, 96, 80, Ascii.RS, 84, 81, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB, Ascii.SYN, 127, 38, 95, 79, 86, 13, 11, 7, 6, 125, 12, 75, 66, 7, 94, 93, 74}, "86b088"));
                    if (this.mRemote.transact(8, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onInstallStart();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener
            public void onInstallSuccess() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{80, 95, 94, Ascii.CAN, 14, 88, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 71, 85, 94, 119, 7, 98, 14, 8, 19, Ascii.SYN, 88, 10, 93, Ascii.RS, 95, 87, 13, 85, 8, 10, 1, 50, 80, 2, 86, 102, 1, Ascii.CAN, 15, 88, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB, Ascii.GS, 121, 119, 89, Ascii.DC4, 95, 13, 11, 7, 6, 125, 12, SignedBytes.MAX_POWER_OF_TWO, 68, 86, 88, 6, 67}, "3036c1"));
                    if (this.mRemote.transact(6, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onInstallSuccess();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.landingPageV2.listener.IDownloadListener
            public void onMarketDownloadDenied() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{84, 12, 14, Ascii.ETB, 9, 12, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 67, 6, 14, 120, 0, 54, 14, 8, 19, Ascii.SYN, 88, 10, 89, 77, 15, 88, 10, 1, 8, 10, 1, 50, 80, 2, 82, 53, 81, Ascii.ETB, 8, 12, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB, Ascii.EM, 42, 39, 86, 19, 11, 13, 11, 7, 6, 125, 12, 68, Ascii.ETB, 6, 87, 1, Ascii.ETB}, "7cc9de"));
                    if (this.mRemote.transact(9, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onMarketDownloadDenied();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, s.d(new byte[]{80, 11, 92, 26, 94, 95, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 71, 1, 92, 117, 87, 101, 14, 8, 19, Ascii.SYN, 88, 10, 93, 74, 93, 85, 93, 82, 8, 10, 1, 50, 80, 2, 86, 50, 3, 26, 95, 95, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB, Ascii.GS, 45, 117, 91, 68, 88, 13, 11, 7, 6, 125, 12, SignedBytes.MAX_POWER_OF_TWO, 16, 84, 90, 86, 68}, "3d1436"));
        }

        public static IDownloadListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IDownloadListener)) ? new Proxy(iBinder) : (IDownloadListener) iInterfaceQueryLocalInterface;
        }

        public static IDownloadListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IDownloadListener iDownloadListener) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException(s.d(new byte[]{Ascii.DC2, 80, 71, 125, 1, 3, 0, 17, 10, Ascii.SYN, 120, 8, 17, 89, Ascii.ESC, 16, 68, 6, 0, 8, 10, 7, 85, 69, Ascii.NAK, 66, 90, 90, 1}, "a539de"));
            }
            if (iDownloadListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iDownloadListener;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            String str = DESCRIPTOR;
            if (i == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(str);
                    onDownloadStart();
                    break;
                case 2:
                    parcel.enforceInterface(str);
                    onDownloadSuccess();
                    break;
                case 3:
                    parcel.enforceInterface(str);
                    onDownloadProgress(parcel.readInt());
                    break;
                case 4:
                    parcel.enforceInterface(str);
                    onDownloadFail();
                    break;
                case 5:
                    parcel.enforceInterface(str);
                    onDownloadCancel();
                    break;
                case 6:
                    parcel.enforceInterface(str);
                    onInstallSuccess();
                    break;
                case 7:
                    parcel.enforceInterface(str);
                    onInstallFail();
                    break;
                case 8:
                    parcel.enforceInterface(str);
                    onInstallStart();
                    break;
                case 9:
                    parcel.enforceInterface(str);
                    onMarketDownloadDenied();
                    break;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void onDownloadCancel();

    void onDownloadFail();

    void onDownloadProgress(int i);

    void onDownloadStart();

    void onDownloadSuccess();

    void onInstallFail();

    void onInstallStart();

    void onInstallSuccess();

    void onMarketDownloadDenied();
}
