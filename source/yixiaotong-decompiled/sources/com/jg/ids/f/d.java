package com.jg.ids.f;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
final class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IBinder f4600a;

    d(IBinder iBinder) {
        this.f4600a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f4600a;
    }

    @Override // com.jg.ids.f.b
    public final String a() {
        String string;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            if (!this.f4600a.transact(1, parcelObtain, parcelObtain2, 0) && c.c() != null) {
                string = c.c().a();
            } else {
                parcelObtain2.readException();
                string = parcelObtain2.readString();
            }
            return string;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.jg.ids.f.b
    public final boolean b() {
        boolean zB;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            if (!this.f4600a.transact(2, parcelObtain, parcelObtain2, 0) && c.c() != null) {
                zB = c.c().b();
            } else {
                parcelObtain2.readException();
                zB = parcelObtain2.readInt() != 0;
            }
            return zB;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
