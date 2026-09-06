package com.kwad.sdk.core.e.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface f extends IInterface {
    String getSerID(String str, String str2, String str3);

    public static final class a implements f {
        private IBinder aUQ;

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.aUQ;
        }

        public a(IBinder iBinder) {
            this.aUQ = iBinder;
        }

        @Override // com.kwad.sdk.core.e.b.f
        public final String getSerID(String str, String str2, String str3) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                parcelObtain.writeString(str);
                parcelObtain.writeString(str2);
                parcelObtain.writeString(str3);
                this.aUQ.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
                return null;
            } finally {
                parcelObtain.recycle();
                parcelObtain2.recycle();
            }
        }
    }
}
