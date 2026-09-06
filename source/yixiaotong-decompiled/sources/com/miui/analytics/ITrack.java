package com.miui.analytics;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.common.base.Ascii;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface ITrack extends IInterface {

    public static abstract class Stub extends Binder implements ITrack {
        private static final String DESCRIPTOR = s.d(new byte[]{86, 9, 95, 76, 90, 92, Ascii.DC4, 13, 72, 3, 95, 4, 89, Ascii.US, 70, 11, 84, 70, 79, 45, 50, 16, 80, 6, 94}, "5f2b75");
        public static final int TRANSACTION_trackEvent = 1;

        public static class Proxy implements ITrack {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return s.d(new byte[]{84, 10, 12, 77, 14, 12, Ascii.DC4, 13, 72, 3, 95, 4, 91, Ascii.FS, Ascii.NAK, 10, 0, Ascii.SYN, 79, 45, 50, 16, 80, 6, 92}, "7eacce");
            }

            @Override // com.miui.analytics.ITrack
            public void trackEvent(String str, String str2, String str3, String str4) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{83, 10, 93, Ascii.ETB, 91, 93, Ascii.DC4, 13, 72, 3, 95, 4, 92, Ascii.FS, 68, 80, 85, 71, 79, 45, 50, 16, 80, 6, 91}, "0e0964"));
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, s.d(new byte[]{87, 10, 9, Ascii.EM, 91, 10, Ascii.DC4, 13, 72, 3, 95, 4, 88, Ascii.FS, 16, 94, 85, 16, 79, 45, 50, 16, 80, 6, 95}, "4ed76c"));
        }

        public static ITrack asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ITrack)) ? new Proxy(iBinder) : (ITrack) iInterfaceQueryLocalInterface;
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
            trackEvent(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }
    }

    void trackEvent(String str, String str2, String str3, String str4);
}
