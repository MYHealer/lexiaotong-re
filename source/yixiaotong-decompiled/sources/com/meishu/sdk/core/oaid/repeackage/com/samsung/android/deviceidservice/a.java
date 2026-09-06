package com.meishu.sdk.core.oaid.repeackage.com.samsung.android.deviceidservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: IDeviceIdService.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.meishu.sdk.core.oaid.repeackage.com.samsung.android.deviceidservice.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IDeviceIdService.java */
    public static abstract class AbstractBinderC0812a extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f4856a = 0;

        /* JADX INFO: renamed from: com.meishu.sdk.core.oaid.repeackage.com.samsung.android.deviceidservice.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IDeviceIdService.java */
        public static class C0813a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f4857a;

            public C0813a(IBinder iBinder) {
                this.f4857a = iBinder;
            }

            @Override // com.meishu.sdk.core.oaid.repeackage.com.samsung.android.deviceidservice.a
            public String a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    if (!this.f4857a.transact(1, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC0812a.f4856a;
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
                return this.f4857a;
            }
        }
    }

    String a() throws RemoteException;
}
