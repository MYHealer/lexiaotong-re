package com.miui.zeus.mimo.msa;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface IRemoteAdViewService extends IInterface {

    public static class Default implements IRemoteAdViewService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.miui.zeus.mimo.msa.IRemoteAdViewService
        public void showAdView(IBinderViewCallBack iBinderViewCallBack) {
        }
    }

    public static abstract class Stub extends Binder implements IRemoteAdViewService {
        private static final String DESCRIPTOR = s.d(new byte[]{83, 10, 92, 77, 89, 90, Ascii.DC4, 13, 72, Ascii.CAN, 84, 16, 67, 75, 92, 10, 89, 92, 79, 9, Ascii.NAK, 3, Ascii.US, 44, 98, 0, 92, 12, SignedBytes.MAX_POWER_OF_TWO, 86, 32, 0, 48, 11, 84, Ascii.DC2, 99, 0, 67, Ascii.NAK, 93, 80, 4}, "0e1c43");
        public static final int TRANSACTION_showAdView = 1;

        public static class Proxy implements IRemoteAdViewService {
            public static IRemoteAdViewService sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return s.d(new byte[]{0, 90, 11, Ascii.ESC, 85, 95, Ascii.DC4, 13, 72, Ascii.CAN, 84, 16, 16, Ascii.ESC, 11, 92, 85, 89, 79, 9, Ascii.NAK, 3, Ascii.US, 44, 49, 80, 11, 90, 76, 83, 32, 0, 48, 11, 84, Ascii.DC2, 48, 80, Ascii.DC4, 67, 81, 85, 4}, "c5f586");
            }

            @Override // com.miui.zeus.mimo.msa.IRemoteAdViewService
            public void showAdView(IBinderViewCallBack iBinderViewCallBack) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{82, 94, 12, 74, 95, 91, Ascii.DC4, 13, 72, Ascii.CAN, 84, 16, 66, Ascii.US, 12, 13, 95, 93, 79, 9, Ascii.NAK, 3, Ascii.US, 44, 99, 84, 12, 11, 70, 87, 32, 0, 48, 11, 84, Ascii.DC2, 98, 84, 19, Ascii.DC2, 91, 81, 4}, "11ad22"));
                    parcelObtain.writeStrongBinder(iBinderViewCallBack != null ? iBinderViewCallBack.asBinder() : null);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().showAdView(iBinderViewCallBack);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, s.d(new byte[]{90, 88, 93, Ascii.FS, 12, 95, Ascii.DC4, 13, 72, Ascii.CAN, 84, 16, 74, Ascii.EM, 93, 91, 12, 89, 79, 9, Ascii.NAK, 3, Ascii.US, 44, 107, 82, 93, 93, Ascii.NAK, 83, 32, 0, 48, 11, 84, Ascii.DC2, 106, 82, 66, 68, 8, 85, 4}, "9702a6"));
        }

        public static IRemoteAdViewService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IRemoteAdViewService)) ? new Proxy(iBinder) : (IRemoteAdViewService) iInterfaceQueryLocalInterface;
        }

        public static IRemoteAdViewService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IRemoteAdViewService iRemoteAdViewService) {
            if (Proxy.sDefaultImpl != null || iRemoteAdViewService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iRemoteAdViewService;
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
            showAdView(IBinderViewCallBack.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }
    }

    void showAdView(IBinderViewCallBack iBinderViewCallBack);
}
