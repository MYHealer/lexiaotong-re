package com.adprof.sdk;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class sa implements ua {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IBinder f1417a;

    public sa(IBinder iBinder) {
        this.f1417a = iBinder;
    }

    public String a(String str) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
            parcelObtain.writeString(str);
            if (!this.f1417a.transact(2, parcelObtain, parcelObtain2, 0)) {
                int i = ta.f1436a;
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
        return this.f1417a;
    }
}
