package com.hihonor.cloudservice.oaid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f3589a = 0;

        /* JADX INFO: renamed from: com.hihonor.cloudservice.oaid.b$a$a, reason: collision with other inner class name */
        public static class C0474a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f3590a;

            public C0474a(IBinder iBinder) {
                this.f3590a = iBinder;
            }

            @Override // com.hihonor.cloudservice.oaid.b
            public void a(com.hihonor.cloudservice.oaid.a aVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                    parcelObtain.writeStrongBinder(aVar != null ? (com.hihonor.cloudservice.oaid.a.AbstractBinderC0473a) aVar : null);
                    if (!this.f3590a.transact(3, parcelObtain, parcelObtain2, 0)) {
                        int i = a.f3589a;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f3590a;
            }

            @Override // com.hihonor.cloudservice.oaid.b
            public void b(com.hihonor.cloudservice.oaid.a aVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                    parcelObtain.writeStrongBinder(aVar != null ? (com.hihonor.cloudservice.oaid.a.AbstractBinderC0473a) aVar : null);
                    if (!this.f3590a.transact(2, parcelObtain, parcelObtain2, 0)) {
                        int i = a.f3589a;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }

    void a(com.hihonor.cloudservice.oaid.a aVar);

    void b(com.hihonor.cloudservice.oaid.a aVar);
}
