package com.jg.ids.j;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
public abstract class b extends Binder implements a {
    public static a a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        try {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new c(iBinder) : (a) iInterfaceQueryLocalInterface;
        } catch (Throwable th) {
            return null;
        }
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        boolean zOnTransact = true;
        try {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                    String strA = a();
                    parcel2.writeNoException();
                    parcel2.writeString(strA);
                    break;
                case 2:
                    parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                    String strA2 = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strA2);
                    break;
                case 3:
                    parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                    String strB = b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strB);
                    break;
                case 1598968902:
                    parcel2.writeString("com.samsung.android.deviceidservice.IDeviceIdService");
                    break;
                default:
                    zOnTransact = super.onTransact(i, parcel, parcel2, i2);
                    break;
            }
        } catch (Throwable th) {
        }
        return zOnTransact;
    }
}
