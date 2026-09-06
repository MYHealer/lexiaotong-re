package com.xiaomi.ad.feedback;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import ijiami_1011.s.s.s;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public interface IAdFeedbackService extends IInterface {

    public static class Default implements IAdFeedbackService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.xiaomi.ad.feedback.IAdFeedbackService
        public void showFeedbackWindow(IAdFeedbackListener iAdFeedbackListener) {
        }

        @Override // com.xiaomi.ad.feedback.IAdFeedbackService
        public void showFeedbackWindowAndTrackResult(IAdFeedbackListener iAdFeedbackListener, String str, String str2, String str3) {
        }

        @Override // com.xiaomi.ad.feedback.IAdFeedbackService
        public void showFeedbackWindowAndTrackResultForMultiAds(IAdFeedbackListener iAdFeedbackListener, String str, String str2, List<String> list) {
        }
    }

    public static abstract class Stub extends Binder implements IAdFeedbackService {
        private static final String DESCRIPTOR = s.d(new byte[]{0, 88, 93, 75, 77, 10, 0, 11, 11, 11, Ascii.US, 4, 7, Ascii.EM, 86, 0, 80, 7, 3, 5, 5, 9, Ascii.US, 44, 34, 83, 118, 0, 80, 7, 3, 5, 5, 9, 98, 0, 17, 65, 89, 6, 80}, "c70e5c");
        public static final int TRANSACTION_showFeedbackWindow = 1;
        public static final int TRANSACTION_showFeedbackWindowAndTrackResult = 2;
        public static final int TRANSACTION_showFeedbackWindowAndTrackResultForMultiAds = 3;

        public static class Proxy implements IAdFeedbackService {
            public static IAdFeedbackService sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return s.d(new byte[]{1, 86, 9, Ascii.ETB, 26, 88, 0, 11, 11, 11, Ascii.US, 4, 6, Ascii.ETB, 2, 92, 7, 85, 3, 5, 5, 9, Ascii.US, 44, 35, 93, 34, 92, 7, 85, 3, 5, 5, 9, 98, 0, 16, 79, 13, 90, 7}, "b9d9b1");
            }

            @Override // com.xiaomi.ad.feedback.IAdFeedbackService
            public void showFeedbackWindow(IAdFeedbackListener iAdFeedbackListener) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{91, 14, 8, 77, 73, 94, 0, 11, 11, 11, Ascii.US, 4, 92, 79, 3, 6, 84, 83, 3, 5, 5, 9, Ascii.US, 44, 121, 5, 35, 6, 84, 83, 3, 5, 5, 9, 98, 0, 74, Ascii.ETB, 12, 0, 84}, "8aec17"));
                    parcelObtain.writeStrongBinder(iAdFeedbackListener != null ? iAdFeedbackListener.asBinder() : null);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().showFeedbackWindow(iAdFeedbackListener);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.xiaomi.ad.feedback.IAdFeedbackService
            public void showFeedbackWindowAndTrackResult(IAdFeedbackListener iAdFeedbackListener, String str, String str2, String str3) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{87, 87, 8, 77, 65, 12, 0, 11, 11, 11, Ascii.US, 4, 80, Ascii.SYN, 3, 6, 92, 1, 3, 5, 5, 9, Ascii.US, 44, 117, 92, 35, 6, 92, 1, 3, 5, 5, 9, 98, 0, 70, 78, 12, 0, 92}, "48ec9e"));
                    parcelObtain.writeStrongBinder(iAdFeedbackListener != null ? iAdFeedbackListener.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().showFeedbackWindowAndTrackResult(iAdFeedbackListener, str, str2, str3);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.xiaomi.ad.feedback.IAdFeedbackService
            public void showFeedbackWindowAndTrackResultForMultiAds(IAdFeedbackListener iAdFeedbackListener, String str, String str2, List<String> list) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{0, 89, 8, Ascii.CAN, 73, 81, 0, 11, 11, 11, Ascii.US, 4, 7, Ascii.CAN, 3, 83, 84, 92, 3, 5, 5, 9, Ascii.US, 44, 34, 82, 35, 83, 84, 92, 3, 5, 5, 9, 98, 0, 17, SignedBytes.MAX_POWER_OF_TWO, 12, 85, 84}, "c6e618"));
                    parcelObtain.writeStrongBinder(iAdFeedbackListener != null ? iAdFeedbackListener.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStringList(list);
                    if (this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().showFeedbackWindowAndTrackResultForMultiAds(iAdFeedbackListener, str, str2, list);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, s.d(new byte[]{1, 11, 8, Ascii.CAN, Ascii.RS, 11, 0, 11, 11, 11, Ascii.US, 4, 6, 74, 3, 83, 3, 6, 3, 5, 5, 9, Ascii.US, 44, 35, 0, 35, 83, 3, 6, 3, 5, 5, 9, 98, 0, 16, Ascii.DC2, 12, 85, 3}, "bde6fb"));
        }

        public static IAdFeedbackService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IAdFeedbackService)) ? new Proxy(iBinder) : (IAdFeedbackService) iInterfaceQueryLocalInterface;
        }

        public static IAdFeedbackService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IAdFeedbackService iAdFeedbackService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException(s.d(new byte[]{17, 93, 71, 114, 4, 95, 0, 17, 10, Ascii.SYN, 120, 8, Ascii.DC2, 84, Ascii.ESC, Ascii.US, 65, 90, 0, 8, 10, 7, 85, 69, Ascii.SYN, 79, 90, 85, 4}, "b836a9"));
            }
            if (iAdFeedbackService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iAdFeedbackService;
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
                showFeedbackWindow(IAdFeedbackListener.Stub.asInterface(parcel.readStrongBinder()));
            } else if (i == 2) {
                parcel.enforceInterface(str);
                showFeedbackWindowAndTrackResult(IAdFeedbackListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readString());
            } else {
                if (i != 3) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString(str);
                    return true;
                }
                parcel.enforceInterface(str);
                showFeedbackWindowAndTrackResultForMultiAds(IAdFeedbackListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.createStringArrayList());
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void showFeedbackWindow(IAdFeedbackListener iAdFeedbackListener);

    void showFeedbackWindowAndTrackResult(IAdFeedbackListener iAdFeedbackListener, String str, String str2, String str3);

    void showFeedbackWindowAndTrackResultForMultiAds(IAdFeedbackListener iAdFeedbackListener, String str, String str2, List<String> list);
}
