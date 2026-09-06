package com.kwad.sdk.core.e.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.kwad.sdk.core.e.b.a$a, reason: collision with other inner class name */
    public static final class C0744a implements a {
        private final IBinder aUQ;

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.aUQ;
        }

        public C0744a(IBinder iBinder) {
            this.aUQ = iBinder;
        }

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
