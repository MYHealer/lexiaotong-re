package com.meishu.sdk.core.oaid.repeackage.com.heytap.openid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: IOpenID.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.meishu.sdk.core.oaid.repeackage.com.heytap.openid.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IOpenID.java */
    public static abstract class AbstractBinderC0810a extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f4854a = 0;

        /* JADX INFO: renamed from: com.meishu.sdk.core.oaid.repeackage.com.heytap.openid.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IOpenID.java */
        public static class C0811a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f4855a;

            public C0811a(IBinder iBinder) {
                this.f4855a = iBinder;
            }

            @Override // com.meishu.sdk.core.oaid.repeackage.com.heytap.openid.a
            public String a(String str, String str2, String str3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    if (!this.f4855a.transact(1, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC0810a.f4854a;
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
                return this.f4855a;
            }
        }
    }

    String a(String str, String str2, String str3) throws RemoteException;
}
