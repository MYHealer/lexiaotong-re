package com.hihonor.dlinstall.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface p extends IInterface {

    public static abstract class a extends Binder implements p {
        private static final String DESCRIPTOR = "com.hihonor.dlinstall.ipc.IQueryResultListener";
        public static final int TRANSACTION_onQueryResult = 1;

        /* JADX INFO: renamed from: com.hihonor.dlinstall.ipc.p$a$a, reason: collision with other inner class name */
        public static class C0477a implements p {
            public static p b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f3609a;

            public C0477a(IBinder iBinder) {
                this.f3609a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f3609a;
            }
        }

        public a() {
            attachInterface(this, DESCRIPTOR);
        }

        public static p asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof p)) ? new C0477a(iBinder) : (p) iInterfaceQueryLocalInterface;
        }

        public static p getDefaultImpl() {
            return C0477a.b;
        }

        public static boolean setDefaultImpl(p pVar) {
            if (C0477a.b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (pVar == null) {
                return false;
            }
            C0477a.b = pVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            onQueryResult(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    void onQueryResult(Bundle bundle) throws RemoteException;
}
