package com.fancy;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public interface _er extends IInterface {

    public static abstract class _a extends Binder implements _er {
        public static final /* synthetic */ int _a = 0;

        /* JADX INFO: renamed from: com.fancy._er$_a$_a, reason: collision with other inner class name */
        public static class C0366_a implements _er {
            public IBinder _a;

            public C0366_a(IBinder iBinder) {
                this._a = iBinder;
            }

            @Override // com.fancy._er
            public final String _a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    if (!this._a.transact(3, parcelObtain, parcelObtain2, 0)) {
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

    String _a();
}
