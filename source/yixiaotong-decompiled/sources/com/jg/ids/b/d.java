package com.jg.ids.b;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
final class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IBinder f4593a;

    d(IBinder iBinder) {
        this.f4593a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f4593a;
    }

    @Override // com.jg.ids.b.b
    public final String a(String str) {
        String string;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
            parcelObtain.writeString(str);
            if (!this.f4593a.transact(1, parcelObtain, parcelObtain2, 0) && c.c() != null) {
                string = c.c().a(str);
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

    @Override // com.jg.ids.b.b
    public final String b(String str) {
        String string;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
            parcelObtain.writeString(str);
            if (!this.f4593a.transact(2, parcelObtain, parcelObtain2, 0) && c.c() != null) {
                string = c.c().b(str);
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

    @Override // com.jg.ids.b.b
    public final String c(String str) {
        String string;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
            parcelObtain.writeString(str);
            if (!this.f4593a.transact(3, parcelObtain, parcelObtain2, 0) && c.c() != null) {
                string = c.c().c(str);
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

    @Override // com.jg.ids.b.b
    public final String d(String str) {
        String string;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
            parcelObtain.writeString(str);
            if (!this.f4593a.transact(4, parcelObtain, parcelObtain2, 0) && c.c() != null) {
                string = c.c().d(str);
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

    @Override // com.jg.ids.b.b
    public final String e(String str) {
        String string;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
            parcelObtain.writeString(str);
            if (!this.f4593a.transact(5, parcelObtain, parcelObtain2, 0) && c.c() != null) {
                string = c.c().e(str);
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

    @Override // com.jg.ids.b.b
    public final boolean a() {
        boolean zA;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
            if (!this.f4593a.transact(6, parcelObtain, parcelObtain2, 0) && c.c() != null) {
                zA = c.c().a();
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

    @Override // com.jg.ids.b.b
    public final String b() {
        String string;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
            if (!this.f4593a.transact(7, parcelObtain, parcelObtain2, 0) && c.c() != null) {
                string = c.c().b();
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
