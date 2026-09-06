package com.adprof.sdk;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ya implements ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IBinder f1535a;

    public ya(IBinder iBinder) {
        this.f1535a = iBinder;
    }

    public String a() throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
            if (!this.f1535a.transact(1, parcelObtain, parcelObtain2, 0)) {
                int i = za.f1553a;
            }
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m730a() throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
            if (!this.f1535a.transact(3, parcelObtain, parcelObtain2, 0)) {
                int i = za.f1553a;
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
        return this.f1535a;
    }
}
