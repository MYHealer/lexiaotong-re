package com.opos.mobad.o;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.opos.mobad.model.utils.AdHelper;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface c extends IInterface {

    public static abstract class a extends Binder implements c {

        /* JADX INFO: renamed from: com.opos.mobad.o.c$a$a, reason: collision with other inner class name */
        private static class C0980a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f7236a;

            C0980a(IBinder iBinder) {
                this.f7236a = iBinder;
            }

            @Override // com.opos.mobad.o.c
            public void a(AdHelper.AdHelperData adHelperData) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.opos.mobad.show.OnFallbackChangeListener");
                    if (adHelperData != null) {
                        parcelObtain.writeInt(1);
                        adHelperData.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f7236a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f7236a;
            }
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.opos.mobad.show.OnFallbackChangeListener");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c)) ? new C0980a(iBinder) : (c) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.opos.mobad.show.OnFallbackChangeListener");
                return true;
            }
            parcel.enforceInterface("com.opos.mobad.show.OnFallbackChangeListener");
            a(parcel.readInt() != 0 ? AdHelper.AdHelperData.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    void a(AdHelper.AdHelperData adHelperData) throws RemoteException;
}
