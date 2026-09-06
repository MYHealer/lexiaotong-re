package com.kwad.sdk.core.e.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface e extends IInterface {
    String getOaid();

    public static final class a implements e {
        private IBinder aUQ;

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.aUQ;
        }

        public a(IBinder iBinder) {
            this.aUQ = iBinder;
        }

        @Override // com.kwad.sdk.core.e.b.e
        public final String getOaid() {
            String string;
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                try {
                    parcelObtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.aUQ.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    string = parcelObtain2.readString();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.printStackTrace(e);
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    string = null;
                }
                return string;
            } catch (Throwable th) {
                parcelObtain2.recycle();
                parcelObtain.recycle();
                throw th;
            }
        }
    }
}
