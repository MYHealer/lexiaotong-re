package com.ubixnow.ooooo;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface h0 extends IInterface {

    public static abstract class OooO00o extends Binder implements h0 {
        private static final String OooO00o = "com.hihonor.cloudservice.oaid.IOAIDCallBack";

        public OooO00o() {
            attachInterface(this, OooO00o);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(OooO00o);
                int i3 = parcel.readInt();
                long j = parcel.readLong();
                boolean z = parcel.readInt() != 0;
                OooO00o(i3, j, z, parcel.readFloat(), parcel.readDouble(), parcel.readString());
            } else {
                if (i != 2) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString(OooO00o);
                    return true;
                }
                parcel.enforceInterface(OooO00o);
                OooO00o(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void OooO00o(int i, long j, boolean z, float f, double d, String str);

    void OooO00o(int i, Bundle bundle);
}
