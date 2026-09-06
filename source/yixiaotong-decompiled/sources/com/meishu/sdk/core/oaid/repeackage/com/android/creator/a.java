package com.meishu.sdk.core.oaid.repeackage.com.android.creator;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: IdsSupplier.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.meishu.sdk.core.oaid.repeackage.com.android.creator.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IdsSupplier.java */
    public static abstract class AbstractBinderC0800a extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f4844a = 0;

        /* JADX INFO: renamed from: com.meishu.sdk.core.oaid.repeackage.com.android.creator.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IdsSupplier.java */
        public static class C0801a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f4845a;

            public C0801a(IBinder iBinder) {
                this.f4845a = iBinder;
            }

            @Override // com.meishu.sdk.core.oaid.repeackage.com.android.creator.a
            public String a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    if (!this.f4845a.transact(3, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC0800a.f4844a;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f4845a;
            }
        }
    }

    String a() throws RemoteException;
}
