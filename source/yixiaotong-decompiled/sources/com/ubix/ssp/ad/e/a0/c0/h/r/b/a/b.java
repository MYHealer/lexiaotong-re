package com.ubix.ssp.ad.e.a0.c0.h.r.b.a;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IBinder f8671a;

    public b(IBinder iBinder) {
        this.f8671a = iBinder;
    }

    @Override // com.ubix.ssp.ad.e.a0.c0.h.r.b.a.c
    public void a(a.AbstractBinderC1068a abstractBinderC1068a) throws Throwable {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcel = null;
        try {
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain2.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                if (abstractBinderC1068a == null) {
                    abstractBinderC1068a = null;
                }
                parcelObtain2.writeStrongBinder(abstractBinderC1068a);
                this.f8671a.transact(2, parcelObtain2, parcelObtain, 0);
                parcelObtain.readException();
                parcelObtain.recycle();
                parcelObtain2.recycle();
            } catch (Throwable th) {
                th = th;
                parcel = parcelObtain2;
                parcelObtain.recycle();
                parcel.recycle();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f8671a;
    }

    @Override // com.ubix.ssp.ad.e.a0.c0.h.r.b.a.c
    public void b(a.AbstractBinderC1068a abstractBinderC1068a) throws Throwable {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcel = null;
        try {
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain2.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                if (abstractBinderC1068a == null) {
                    abstractBinderC1068a = null;
                }
                parcelObtain2.writeStrongBinder(abstractBinderC1068a);
                this.f8671a.transact(3, parcelObtain2, parcelObtain, 0);
                parcelObtain.readException();
                parcelObtain.recycle();
                parcelObtain2.recycle();
            } catch (Throwable th) {
                th = th;
                parcel = parcelObtain2;
                parcelObtain.recycle();
                parcel.recycle();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
