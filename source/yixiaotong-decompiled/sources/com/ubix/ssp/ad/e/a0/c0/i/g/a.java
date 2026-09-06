package com.ubix.ssp.ad.e.a0.c0.i.g;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.ubix.ssp.ad.e.a0.c0.i.g.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC1082a extends Binder implements a {

        /* JADX INFO: renamed from: com.ubix.ssp.ad.e.a0.c0.i.g.a$a$a, reason: collision with other inner class name */
        private static class C1083a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static a f8679a;
            private IBinder b;

            C1083a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.ubix.ssp.ad.e.a0.c0.i.g.a
            public String a(String str, String str2, String str3) {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    if (this.b.transact(1, parcelObtain, parcelObtain2, 0) || AbstractBinderC1082a.m() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = AbstractBinderC1082a.m().a(str, str2, str3);
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }
        }

        public AbstractBinderC1082a() {
            attachInterface(this, "com.heytap.openid.IOpenID");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C1083a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static a m() {
            return C1083a.f8679a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.heytap.openid.IOpenID");
                return true;
            }
            parcel.enforceInterface("com.heytap.openid.IOpenID");
            String strA = a(parcel.readString(), parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(strA);
            return true;
        }
    }

    String a(String str, String str2, String str3);
}
