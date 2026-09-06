package com.hihonor.dlinstall.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface o extends IInterface {

    public static abstract class a extends Binder implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f3607a = 0;

        /* JADX INFO: renamed from: com.hihonor.dlinstall.ipc.o$a$a, reason: collision with other inner class name */
        public static class C0476a implements o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f3608a;

            public C0476a(IBinder iBinder) {
                this.f3608a = iBinder;
            }

            @Override // com.hihonor.dlinstall.ipc.o
            public void a(int i, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.dlinstall.ipc.IDownloadInstallService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(1);
                    bundle.writeToParcel(parcelObtain, 0);
                    if (!this.f3608a.transact(2, parcelObtain, parcelObtain2, 0)) {
                        int i2 = a.f3607a;
                    }
                    parcelObtain2.readException();
                    if (parcelObtain2.readInt() != 0) {
                        bundle.readFromParcel(parcelObtain2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.hihonor.dlinstall.ipc.o
            public void a(String str, n nVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.dlinstall.ipc.IDownloadInstallService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder((n.a) nVar);
                    if (!this.f3608a.transact(1, parcelObtain, parcelObtain2, 0)) {
                        int i = a.f3607a;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f3608a;
            }
        }
    }

    void a(int i, Bundle bundle) throws RemoteException;

    void a(String str, n nVar) throws RemoteException;
}
