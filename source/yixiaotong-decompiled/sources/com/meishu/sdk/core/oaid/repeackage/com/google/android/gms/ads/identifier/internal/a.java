package com.meishu.sdk.core.oaid.repeackage.com.google.android.gms.ads.identifier.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.identifier.internal.IAdvertisingIdService;

/* JADX INFO: compiled from: IAdvertisingIdService.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.meishu.sdk.core.oaid.repeackage.com.google.android.gms.ads.identifier.internal.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IAdvertisingIdService.java */
    public static abstract class AbstractBinderC0808a extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f4852a = 0;

        /* JADX INFO: renamed from: com.meishu.sdk.core.oaid.repeackage.com.google.android.gms.ads.identifier.internal.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IAdvertisingIdService.java */
        public static class C0809a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f4853a;

            public C0809a(IBinder iBinder) {
                this.f4853a = iBinder;
            }

            @Override // com.meishu.sdk.core.oaid.repeackage.com.google.android.gms.ads.identifier.internal.a
            public boolean a(boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAdvertisingIdService.DESCRIPTOR);
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (!this.f4853a.transact(2, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC0808a.f4852a;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f4853a;
            }

            @Override // com.meishu.sdk.core.oaid.repeackage.com.google.android.gms.ads.identifier.internal.a
            public String c() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAdvertisingIdService.DESCRIPTOR);
                    if (!this.f4853a.transact(1, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC0808a.f4852a;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }

    boolean a(boolean z) throws RemoteException;

    String c() throws RemoteException;
}
