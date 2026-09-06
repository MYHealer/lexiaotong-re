package com.jg.ids.i;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IBinder f4606a;

    public c(IBinder iBinder) {
        this.f4606a = iBinder;
    }

    @Override // com.jg.ids.i.h
    public final String a(String str, String str2, String str3) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
            parcelObtain.writeString(str);
            parcelObtain.writeString(str2);
            parcelObtain.writeString(str3);
            this.f4606a.transact(1, parcelObtain, parcelObtain2, 0);
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
        return this.f4606a;
    }
}
