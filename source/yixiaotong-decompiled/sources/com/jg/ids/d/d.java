package com.jg.ids.d;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
final class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IBinder f4596a;

    d(IBinder iBinder) {
        this.f4596a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f4596a;
    }

    @Override // com.jg.ids.d.b
    public final boolean a() {
        boolean zA;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.android.creator.IdsSupplier");
            if (!this.f4596a.transact(1, parcelObtain, parcelObtain2, 0) && c.d() != null) {
                zA = c.d().a();
            } else {
                parcelObtain2.readException();
                zA = parcelObtain2.readInt() != 0;
            }
            return zA;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.jg.ids.d.b
    public final String a(String str) {
        String string;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.android.creator.IdsSupplier");
            parcelObtain.writeString(str);
            if (!this.f4596a.transact(2, parcelObtain, parcelObtain2, 0) && c.d() != null) {
                string = c.d().a(str);
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

    @Override // com.jg.ids.d.b
    public final String b() {
        String string;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.android.creator.IdsSupplier");
            if (!this.f4596a.transact(3, parcelObtain, parcelObtain2, 0) && c.d() != null) {
                string = c.d().b();
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

    @Override // com.jg.ids.d.b
    public final String c() {
        String string;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.android.creator.IdsSupplier");
            if (!this.f4596a.transact(4, parcelObtain, parcelObtain2, 0) && c.d() != null) {
                string = c.d().c();
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

    @Override // com.jg.ids.d.b
    public final String b(String str) {
        String string;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.android.creator.IdsSupplier");
            parcelObtain.writeString(str);
            if (!this.f4596a.transact(5, parcelObtain, parcelObtain2, 0) && c.d() != null) {
                string = c.d().b(str);
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
}
