package com.fancy;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.ads.identifier.internal.IAdvertisingIdService;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public interface _ee extends IInterface {

    public static abstract class _a extends Binder implements _ee {
        public static final /* synthetic */ int _a = 0;

        /* JADX INFO: renamed from: com.fancy._ee$_a$_a, reason: collision with other inner class name */
        public static class C0364_a implements _ee {
            public IBinder _a;

            public C0364_a(IBinder iBinder) {
                this._a = iBinder;
            }

            @Override // com.fancy._ee
            public final String _b() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAdvertisingIdService.DESCRIPTOR);
                    if (!this._a.transact(1, parcelObtain, parcelObtain2, 0)) {
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

    String _b();
}
