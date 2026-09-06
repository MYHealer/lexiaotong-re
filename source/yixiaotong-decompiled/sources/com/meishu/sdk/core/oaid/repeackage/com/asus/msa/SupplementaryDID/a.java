package com.meishu.sdk.core.oaid.repeackage.com.asus.msa.SupplementaryDID;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: IDidAidlInterface.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.meishu.sdk.core.oaid.repeackage.com.asus.msa.SupplementaryDID.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IDidAidlInterface.java */
    public static abstract class AbstractBinderC0802a extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f4846a = 0;

        /* JADX INFO: renamed from: com.meishu.sdk.core.oaid.repeackage.com.asus.msa.SupplementaryDID.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IDidAidlInterface.java */
        public static class C0803a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f4847a;

            public C0803a(IBinder iBinder) {
                this.f4847a = iBinder;
            }

            @Override // com.meishu.sdk.core.oaid.repeackage.com.asus.msa.SupplementaryDID.a
            public String a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    if (!this.f4847a.transact(3, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC0802a.f4846a;
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
                return this.f4847a;
            }

            @Override // com.meishu.sdk.core.oaid.repeackage.com.asus.msa.SupplementaryDID.a
            public boolean b() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    if (!this.f4847a.transact(1, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC0802a.f4846a;
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
