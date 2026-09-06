package com.miui.systemAdSolution.cache;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface IMsaDiskLruCacheService extends IInterface {

    public static class Default implements IMsaDiskLruCacheService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.miui.systemAdSolution.cache.IMsaDiskLruCacheService
        public int copyCacheFileFromMimo(String str, ParcelFileDescriptor parcelFileDescriptor) {
            return 0;
        }

        @Override // com.miui.systemAdSolution.cache.IMsaDiskLruCacheService
        public int copyCacheFileToMimo(String str, String str2, IMsaDiskLruCacheListener iMsaDiskLruCacheListener) {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements IMsaDiskLruCacheService {
        private static final String DESCRIPTOR = s.d(new byte[]{6, 12, 93, 77, 93, 80, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 17, 6, 93, 34, 84, 106, 14, 8, 19, Ascii.SYN, 88, 10, 11, 77, 83, 2, 83, 81, 4, 74, 47, 47, 66, 4, 33, 10, 67, 8, 124, 75, Ascii.DC4, 39, 7, 1, 89, 0, 54, 6, 66, Ascii.NAK, 89, 90, 4}, "ec0c09");
        public static final int TRANSACTION_copyCacheFileFromMimo = 2;
        public static final int TRANSACTION_copyCacheFileToMimo = 1;

        public static class Proxy implements IMsaDiskLruCacheService {
            public static IMsaDiskLruCacheService sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.miui.systemAdSolution.cache.IMsaDiskLruCacheService
            public int copyCacheFileFromMimo(String str, ParcelFileDescriptor parcelFileDescriptor) {
                int iCopyCacheFileFromMimo;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{87, 12, 11, 72, 14, 12, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, SignedBytes.MAX_POWER_OF_TWO, 6, 11, 39, 7, 54, 14, 8, 19, Ascii.SYN, 88, 10, 90, 77, 5, 7, 0, 13, 4, 74, 47, 47, 66, 4, 112, 10, Ascii.NAK, 13, 47, Ascii.ETB, Ascii.DC4, 39, 7, 1, 89, 0, 103, 6, Ascii.DC4, 16, 10, 6, 4}, "4cffce"));
                    parcelObtain.writeString(str);
                    if (parcelFileDescriptor != null) {
                        parcelObtain.writeInt(1);
                        parcelFileDescriptor.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iCopyCacheFileFromMimo = parcelObtain2.readInt();
                    } else {
                        iCopyCacheFileFromMimo = Stub.getDefaultImpl().copyCacheFileFromMimo(str, parcelFileDescriptor);
                    }
                    return iCopyCacheFileFromMimo;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.systemAdSolution.cache.IMsaDiskLruCacheService
            public int copyCacheFileToMimo(String str, String str2, IMsaDiskLruCacheListener iMsaDiskLruCacheListener) {
                int iCopyCacheFileToMimo;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{80, 12, 14, 74, 11, 92, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 71, 6, 14, 37, 2, 102, 14, 8, 19, Ascii.SYN, 88, 10, 93, 77, 0, 5, 5, 93, 4, 74, 47, 47, 66, 4, 119, 10, 16, 15, 42, 71, Ascii.DC4, 39, 7, 1, 89, 0, 96, 6, 17, Ascii.DC2, 15, 86, 4}, "3ccdf5"));
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(iMsaDiskLruCacheListener != null ? iMsaDiskLruCacheListener.asBinder() : null);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iCopyCacheFileToMimo = parcelObtain2.readInt();
                    } else {
                        iCopyCacheFileToMimo = Stub.getDefaultImpl().copyCacheFileToMimo(str, str2, iMsaDiskLruCacheListener);
                    }
                    return iCopyCacheFileToMimo;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return s.d(new byte[]{5, 12, 12, Ascii.ESC, 94, 12, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, Ascii.DC2, 6, 12, 116, 87, 54, 14, 8, 19, Ascii.SYN, 88, 10, 8, 77, 2, 84, 80, 13, 4, 74, 47, 47, 66, 4, 34, 10, Ascii.DC2, 94, 127, Ascii.ETB, Ascii.DC4, 39, 7, 1, 89, 0, 53, 6, 19, 67, 90, 6, 4}, "fca53e");
            }
        }

        public Stub() {
            attachInterface(this, s.d(new byte[]{83, 91, 89, Ascii.GS, 92, 90, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 68, 81, 89, 114, 85, 96, 14, 8, 19, Ascii.SYN, 88, 10, 94, 26, 87, 82, 82, 91, 4, 74, 47, 47, 66, 4, 116, 93, 71, 88, 125, 65, Ascii.DC4, 39, 7, 1, 89, 0, 99, 81, 70, 69, 88, 80, 4}, "044313"));
        }

        public static IMsaDiskLruCacheService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMsaDiskLruCacheService)) ? new Proxy(iBinder) : (IMsaDiskLruCacheService) iInterfaceQueryLocalInterface;
        }

        public static IMsaDiskLruCacheService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IMsaDiskLruCacheService iMsaDiskLruCacheService) {
            if (Proxy.sDefaultImpl != null || iMsaDiskLruCacheService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iMsaDiskLruCacheService;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            int iCopyCacheFileToMimo;
            String str = DESCRIPTOR;
            if (i == 1) {
                parcel.enforceInterface(str);
                iCopyCacheFileToMimo = copyCacheFileToMimo(parcel.readString(), parcel.readString(), IMsaDiskLruCacheListener.Stub.asInterface(parcel.readStrongBinder()));
            } else {
                if (i != 2) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString(str);
                    return true;
                }
                parcel.enforceInterface(str);
                iCopyCacheFileToMimo = copyCacheFileFromMimo(parcel.readString(), parcel.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcel) : null);
            }
            parcel2.writeNoException();
            parcel2.writeInt(iCopyCacheFileToMimo);
            return true;
        }
    }

    int copyCacheFileFromMimo(String str, ParcelFileDescriptor parcelFileDescriptor);

    int copyCacheFileToMimo(String str, String str2, IMsaDiskLruCacheListener iMsaDiskLruCacheListener);
}
