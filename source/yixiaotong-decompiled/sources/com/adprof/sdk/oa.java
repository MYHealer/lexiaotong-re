package com.adprof.sdk;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.identifier.internal.IAdvertisingIdService;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class oa implements qa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IBinder f1340a;

    public oa(IBinder iBinder) {
        this.f1340a = iBinder;
    }

    public String a() throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(IAdvertisingIdService.DESCRIPTOR);
            if (!this.f1340a.transact(1, parcelObtain, parcelObtain2, 0)) {
                int i = pa.f1361a;
            }
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    public boolean a(boolean z) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(IAdvertisingIdService.DESCRIPTOR);
            parcelObtain.writeInt(z ? 1 : 0);
            if (!this.f1340a.transact(2, parcelObtain, parcelObtain2, 0)) {
                int i = pa.f1361a;
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
        return this.f1340a;
    }
}
