package com.adprof.sdk;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class qe implements se {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IBinder f1385a;

    public qe(IBinder iBinder) {
        this.f1385a = iBinder;
    }

    public String a() throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
            if (!this.f1385a.transact(3, parcelObtain, parcelObtain2, 0)) {
                int i = re.f1403a;
            }
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m712a() throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
            if (!this.f1385a.transact(1, parcelObtain, parcelObtain2, 0)) {
                int i = re.f1403a;
            }
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f1385a;
    }
}
