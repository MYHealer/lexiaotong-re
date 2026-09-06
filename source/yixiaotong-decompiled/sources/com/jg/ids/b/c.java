package com.jg.ids.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
public abstract class c extends Binder implements b {
    public static b a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
        if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof b)) {
            return (b) iInterfaceQueryLocalInterface;
        }
        return new d(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                String strA = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            case 2:
                parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                String strB = b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(strB);
                return true;
            case 3:
                parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                String strC = c(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(strC);
                return true;
            case 4:
                parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                String strD = d(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(strD);
                return true;
            case 5:
                parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                String strE = e(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(strE);
                return true;
            case 6:
                parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                boolean zA = a();
                parcel2.writeNoException();
                parcel2.writeInt(zA ? 1 : 0);
                return true;
            case 7:
                parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                String strB2 = b();
                parcel2.writeNoException();
                parcel2.writeString(strB2);
                return true;
            case 1598968902:
                parcel2.writeString("com.coolpad.deviceidsupport.IDeviceIdManager");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }

    public static b c() {
        return null;
    }
}
