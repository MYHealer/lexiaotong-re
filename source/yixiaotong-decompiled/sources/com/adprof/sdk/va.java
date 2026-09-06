package com.adprof.sdk;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class va implements xa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IBinder f1476a;

    public va(IBinder iBinder) {
        this.f1476a = iBinder;
    }

    public String a() throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
            if (!this.f1476a.transact(1, parcelObtain, parcelObtain2, 0)) {
                int i = wa.f1496a;
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
        return this.f1476a;
    }
}
