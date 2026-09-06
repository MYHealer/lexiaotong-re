package com.meishu.sdk.core.oaid.repeackage.com.bun.lib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: MsaIdInterface.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.meishu.sdk.core.oaid.repeackage.com.bun.lib.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MsaIdInterface.java */
    public static abstract class AbstractBinderC0804a extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f4848a = 0;

        /* JADX INFO: renamed from: com.meishu.sdk.core.oaid.repeackage.com.bun.lib.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: MsaIdInterface.java */
        public static class C0805a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f4849a;

            public C0805a(IBinder iBinder) {
                this.f4849a = iBinder;
            }

            @Override // com.meishu.sdk.core.oaid.repeackage.com.bun.lib.a
            public String a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.f4849a.transact(3, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC0804a.f4848a;
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
                return this.f4849a;
            }

            @Override // com.meishu.sdk.core.oaid.repeackage.com.bun.lib.a
            public boolean d() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.f4849a.transact(1, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC0804a.f4848a;
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

    boolean d() throws RemoteException;
}
