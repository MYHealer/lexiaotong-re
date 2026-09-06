package com.fancy;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public interface _eh extends IInterface {

    public static abstract class _a extends Binder implements _eh {
        public static final /* synthetic */ int _a = 0;

        /* JADX INFO: renamed from: com.fancy._eh$_a$_a, reason: collision with other inner class name */
        public static class C0365_a implements _eh {
            public IBinder _a;

            public C0365_a(IBinder iBinder) {
                this._a = iBinder;
            }

            @Override // com.fancy._eh
            public final String _a(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(str);
                    if (!this._a.transact(2, parcelObtain, parcelObtain2, 0)) {
                        int i = _a._a;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this._a;
            }
        }
    }

    String _a(String str);
}
