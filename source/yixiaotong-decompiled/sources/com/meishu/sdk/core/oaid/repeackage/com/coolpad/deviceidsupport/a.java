package com.meishu.sdk.core.oaid.repeackage.com.coolpad.deviceidsupport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: IDeviceIdManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.meishu.sdk.core.oaid.repeackage.com.coolpad.deviceidsupport.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IDeviceIdManager.java */
    public static abstract class AbstractBinderC0806a extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f4850a = 0;

        /* JADX INFO: renamed from: com.meishu.sdk.core.oaid.repeackage.com.coolpad.deviceidsupport.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IDeviceIdManager.java */
        public static class C0807a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f4851a;

            public C0807a(IBinder iBinder) {
                this.f4851a = iBinder;
            }

            @Override // com.meishu.sdk.core.oaid.repeackage.com.coolpad.deviceidsupport.a
            public String a(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(str);
                    if (!this.f4851a.transact(2, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC0806a.f4850a;
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
                return this.f4851a;
            }
        }
    }

    String a(String str) throws RemoteException;
}
