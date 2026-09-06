package com.kwad.sdk.liteapi.oaid.interfaces;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.kwad.sdk.liteapi.LiteApiLogger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface HWIDInterface extends IInterface {
    boolean getBoos();

    String getIDs();

    public static final class a implements HWIDInterface {
        private IBinder aUQ;

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.aUQ;
        }

        public a(IBinder iBinder) {
            this.aUQ = iBinder;
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.HWIDInterface
        public final String getIDs() {
            String string;
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                try {
                    parcelObtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    this.aUQ.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    string = parcelObtain2.readString();
                    parcelObtain.recycle();
                    parcelObtain2.recycle();
                } catch (Exception e) {
                    LiteApiLogger.printStackTrace(e);
                    parcelObtain.recycle();
                    parcelObtain2.recycle();
                    string = null;
                }
                return string;
            } catch (Throwable th) {
                parcelObtain.recycle();
                parcelObtain2.recycle();
                throw th;
            }
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.HWIDInterface
        public final boolean getBoos() {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            boolean z = false;
            try {
                parcelObtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                this.aUQ.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                if (parcelObtain2.readInt() == 0) {
                    z = true;
                }
            } catch (Exception e) {
                LiteApiLogger.printStackTrace(e);
            } finally {
                parcelObtain.recycle();
                parcelObtain2.recycle();
            }
            return z;
        }
    }
}
