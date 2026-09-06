package com.adprof.sdk;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ob implements qb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IBinder f1341a;

    public ob(IBinder iBinder) {
        this.f1341a = iBinder;
    }

    public String a() throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.android.creator.IdsSupplier");
            if (!this.f1341a.transact(3, parcelObtain, parcelObtain2, 0)) {
                int i = pb.f1362a;
            }
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f1341a;
    }
}
