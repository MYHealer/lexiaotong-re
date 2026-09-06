package com.adprof.sdk;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class fb extends Binder implements gb {
    public fb() {
        attachInterface(this, "com.hihonor.cloudservice.oaid.IOAIDCallBack");
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
            int i3 = parcel.readInt();
            long j = parcel.readLong();
            boolean z = parcel.readInt() != 0;
            a(i3, j, z, parcel.readFloat(), parcel.readDouble(), parcel.readString());
        } else {
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                return true;
            }
            parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
            a(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
        }
        parcel2.writeNoException();
        return true;
    }
}
