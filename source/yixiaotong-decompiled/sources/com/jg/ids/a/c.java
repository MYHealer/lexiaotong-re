package com.jg.ids.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
public abstract class c extends Binder implements b {
    public static b a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        try {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new d(iBinder) : (b) iInterfaceQueryLocalInterface;
        } catch (Throwable th) {
            return null;
        }
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        boolean zOnTransact = true;
        try {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                        boolean zA = a();
                        parcel2.writeNoException();
                        parcel2.writeInt(zA ? 1 : 0);
                        break;
                    case 2:
                        parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                        String strB = b();
                        parcel2.writeNoException();
                        parcel2.writeString(strB);
                        break;
                    case 3:
                        parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                        String strC = c();
                        parcel2.writeNoException();
                        parcel2.writeString(strC);
                        break;
                    case 4:
                        parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                        String strD = d();
                        parcel2.writeNoException();
                        parcel2.writeString(strD);
                        break;
                    case 5:
                        parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                        String strE = e();
                        parcel2.writeNoException();
                        parcel2.writeString(strE);
                        break;
                    default:
                        try {
                            zOnTransact = super.onTransact(i, parcel, parcel2, i2);
                        } catch (RemoteException e) {
                        }
                        break;
                }
            } else {
                parcel2.writeString("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            }
        } catch (Throwable th) {
        }
        return zOnTransact;
    }
}
