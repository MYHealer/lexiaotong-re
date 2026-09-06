package com.meishu.sdk.core.oaid.repeackage.com.zui.deviceidservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: IDeviceidInterface.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.meishu.sdk.core.oaid.repeackage.com.zui.deviceidservice.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IDeviceidInterface.java */
    public static abstract class AbstractBinderC0814a extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f4858a = 0;

        /* JADX INFO: renamed from: com.meishu.sdk.core.oaid.repeackage.com.zui.deviceidservice.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IDeviceidInterface.java */
        public static class C0815a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f4859a;

            public C0815a(IBinder iBinder) {
                this.f4859a = iBinder;
            }

            @Override // com.meishu.sdk.core.oaid.repeackage.com.zui.deviceidservice.a
            public String a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    if (!this.f4859a.transact(1, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC0814a.f4858a;
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
                return this.f4859a;
            }

            @Override // com.meishu.sdk.core.oaid.repeackage.com.zui.deviceidservice.a
            public boolean b() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    if (!this.f4859a.transact(3, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC0814a.f4858a;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }

    String a() throws RemoteException;

    boolean b() throws RemoteException;
}
