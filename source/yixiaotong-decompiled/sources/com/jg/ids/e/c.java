package com.jg.ids.e;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.ads.identifier.internal.IAdvertisingIdService;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
public abstract class c extends Binder implements b {
    public static b a(IBinder iBinder) {
        b dVar;
        if (iBinder == null) {
            return null;
        }
        try {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IAdvertisingIdService.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) {
                dVar = new d(iBinder);
            } else {
                dVar = (b) iInterfaceQueryLocalInterface;
            }
            return dVar;
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
                    parcel.enforceInterface(IAdvertisingIdService.DESCRIPTOR);
                    parcel2.writeNoException();
                    parcel2.writeString(a());
                    break;
                case 2:
                    parcel.enforceInterface(IAdvertisingIdService.DESCRIPTOR);
                    boolean zA = a(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(zA ? 1 : 0);
                    break;
                case 1598968902:
                    parcel2.writeString(IAdvertisingIdService.DESCRIPTOR);
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
