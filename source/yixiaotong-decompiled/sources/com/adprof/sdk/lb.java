package com.adprof.sdk;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class lb implements nb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IBinder f1283a;

    public lb(IBinder iBinder) {
        this.f1283a = iBinder;
    }

    public String a(String str, String str2, String str3) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
            parcelObtain.writeString(str);
            parcelObtain.writeString(str2);
            parcelObtain.writeString(str3);
            if (!this.f1283a.transact(1, parcelObtain, parcelObtain2, 0)) {
                int i = mb.f1304a;
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
        return this.f1283a;
    }
}
