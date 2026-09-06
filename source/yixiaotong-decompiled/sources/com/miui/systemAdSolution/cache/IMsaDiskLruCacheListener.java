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
public interface IMsaDiskLruCacheListener extends IInterface {

    public static class Default implements IMsaDiskLruCacheListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.miui.systemAdSolution.cache.IMsaDiskLruCacheListener
        public int onCopyInput(ParcelFileDescriptor parcelFileDescriptor) {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements IMsaDiskLruCacheListener {
        private static final String DESCRIPTOR = s.d(new byte[]{90, 93, 94, 26, 88, 88, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 77, 87, 94, 117, 81, 98, 14, 8, 19, Ascii.SYN, 88, 10, 87, Ascii.FS, 80, 85, 86, 89, 4, 74, 47, 47, 66, 4, 125, 91, SignedBytes.MAX_POWER_OF_TWO, 95, 121, 67, Ascii.DC4, 39, 7, 1, 89, 0, 117, 91, SignedBytes.MAX_POWER_OF_TWO, SignedBytes.MAX_POWER_OF_TWO, 80, 95, 4, Ascii.SYN}, "923451");
        public static final int TRANSACTION_onCopyInput = 1;

        public static class Proxy implements IMsaDiskLruCacheListener {
            public static IMsaDiskLruCacheListener sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return s.d(new byte[]{0, 94, 85, 26, 8, 10, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, Ascii.ETB, 84, 85, 117, 1, 48, 14, 8, 19, Ascii.SYN, 88, 10, 13, Ascii.US, 91, 85, 6, 11, 4, 74, 47, 47, 66, 4, 39, 88, 75, 95, 41, 17, Ascii.DC4, 39, 7, 1, 89, 0, 47, 88, 75, SignedBytes.MAX_POWER_OF_TWO, 0, 13, 4, Ascii.SYN}, "c184ec");
            }

            @Override // com.miui.systemAdSolution.cache.IMsaDiskLruCacheListener
            public int onCopyInput(ParcelFileDescriptor parcelFileDescriptor) {
                int iOnCopyInput;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{82, 12, 93, Ascii.ETB, 15, 13, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 69, 6, 93, 120, 6, 55, 14, 8, 19, Ascii.SYN, 88, 10, 95, 77, 83, 88, 1, 12, 4, 74, 47, 47, 66, 4, 117, 10, 67, 82, 46, Ascii.SYN, Ascii.DC4, 39, 7, 1, 89, 0, 125, 10, 67, 77, 7, 10, 4, Ascii.SYN}, "1c09bd"));
                    if (parcelFileDescriptor != null) {
                        parcelObtain.writeInt(1);
                        parcelFileDescriptor.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iOnCopyInput = parcelObtain2.readInt();
                    } else {
                        iOnCopyInput = Stub.getDefaultImpl().onCopyInput(parcelFileDescriptor);
                    }
                    return iOnCopyInput;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, s.d(new byte[]{86, 9, 93, Ascii.ETB, 85, 95, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 65, 3, 93, 120, 92, 101, 14, 8, 19, Ascii.SYN, 88, 10, 91, 72, 83, 88, 91, 94, 4, 74, 47, 47, 66, 4, 113, 15, 67, 82, 116, 68, Ascii.DC4, 39, 7, 1, 89, 0, 121, 15, 67, 77, 93, 88, 4, Ascii.SYN}, "5f0986"));
        }

        public static IMsaDiskLruCacheListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMsaDiskLruCacheListener)) ? new Proxy(iBinder) : (IMsaDiskLruCacheListener) iInterfaceQueryLocalInterface;
        }

        public static IMsaDiskLruCacheListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IMsaDiskLruCacheListener iMsaDiskLruCacheListener) {
            if (Proxy.sDefaultImpl != null || iMsaDiskLruCacheListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iMsaDiskLruCacheListener;
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
            int iOnCopyInput = onCopyInput(parcel.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            parcel2.writeInt(iOnCopyInput);
            return true;
        }
    }

    int onCopyInput(ParcelFileDescriptor parcelFileDescriptor);
}
