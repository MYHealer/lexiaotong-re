package com.jg.ids.j;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IBinder f4611a;

    c(IBinder iBinder) {
        this.f4611a = iBinder;
    }

    @Override // com.jg.ids.j.a
    public final String a() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
            this.f4611a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            String string = parcelObtain2.readString();
            try {
                parcelObtain2.recycle();
                parcelObtain.recycle();
                return string;
            } catch (Throwable th) {
                return string;
            }
        } catch (Throwable th2) {
            try {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            } catch (Throwable th3) {
            }
            throw th2;
        }
    }

    @Override // com.jg.ids.j.a
    public final String a(String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
            parcelObtain.writeString(str);
            this.f4611a.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            String string = parcelObtain2.readString();
            try {
                parcelObtain2.recycle();
                parcelObtain.recycle();
                return string;
            } catch (Throwable th) {
                return string;
            }
        } catch (Throwable th2) {
            try {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            } catch (Throwable th3) {
            }
            throw th2;
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f4611a;
    }

    @Override // com.jg.ids.j.a
    public final String b(String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
            parcelObtain.writeString(str);
            this.f4611a.transact(3, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            String string = parcelObtain2.readString();
            try {
                parcelObtain2.recycle();
                parcelObtain.recycle();
                return string;
            } catch (Throwable th) {
                return string;
            }
        } catch (Throwable th2) {
            try {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            } catch (Throwable th3) {
            }
            throw th2;
        }
    }
}
