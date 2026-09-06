package com.jg.ids.e;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.ads.identifier.internal.IAdvertisingIdService;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
final class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IBinder f4598a;

    d(IBinder iBinder) {
        this.f4598a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f4598a;
    }

    @Override // com.jg.ids.e.b
    public final String a() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(IAdvertisingIdService.DESCRIPTOR);
            if (!this.f4598a.transact(1, parcelObtain, parcelObtain2, 0)) {
            }
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } catch (Exception e) {
            return "";
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.jg.ids.e.b
    public final boolean a(boolean z) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(IAdvertisingIdService.DESCRIPTOR);
            parcelObtain.writeInt(z ? 1 : 0);
            if (!this.f4598a.transact(2, parcelObtain, parcelObtain2, 0)) {
            }
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } catch (Exception e) {
            return false;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
