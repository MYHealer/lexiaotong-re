package com.kwad.sdk.liteapi.oaid.interfaces;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface ASUSIDInterface extends IInterface {
    String getID();

    public static final class a implements ASUSIDInterface {
        private final IBinder aUQ;

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.aUQ;
        }

        public a(IBinder iBinder) {
            this.aUQ = iBinder;
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.ASUSIDInterface
        public final String getID() {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                this.aUQ.transact(3, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } catch (Exception unused) {
                return null;
            } finally {
                parcelObtain.recycle();
                parcelObtain2.recycle();
            }
        }
    }
}
