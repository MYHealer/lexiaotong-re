package com.hihonor.id.router;

import android.content.ComponentName;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class d extends Binder implements e {
    public d() {
        attachInterface(this, "com.hihonor.id.router.IServiceConnection");
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1598968902) {
            parcel2.writeString("com.hihonor.id.router.IServiceConnection");
            return true;
        }
        if (i == 1) {
            parcel.enforceInterface("com.hihonor.id.router.IServiceConnection");
            a(parcel.readInt() != 0 ? (ComponentName) ComponentName.CREATOR.createFromParcel(parcel) : null, parcel.readStrongBinder());
        } else if (i == 2) {
            parcel.enforceInterface("com.hihonor.id.router.IServiceConnection");
            a(parcel.readInt() != 0 ? (ComponentName) ComponentName.CREATOR.createFromParcel(parcel) : null);
        } else if (i == 3) {
            parcel.enforceInterface("com.hihonor.id.router.IServiceConnection");
            b(parcel.readInt() != 0 ? (ComponentName) ComponentName.CREATOR.createFromParcel(parcel) : null);
        } else {
            if (i != 4) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.hihonor.id.router.IServiceConnection");
            c(parcel.readInt() != 0 ? (ComponentName) ComponentName.CREATOR.createFromParcel(parcel) : null);
        }
        parcel2.writeNoException();
        return true;
    }
}
