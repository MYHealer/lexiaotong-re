package com.ubix.ssp.ad.e.a0.c0.h.r.b.a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.ubix.ssp.ad.e.a0.c0.h.r.b.a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC1068a extends Binder implements a {
        public AbstractBinderC1068a() {
            attachInterface(this, "com.hihonor.cloudservice.oaid.IOAIDCallBack");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                int i3 = parcel.readInt();
                long j = parcel.readLong();
                boolean z = parcel.readInt() != 0;
                a(i3, j, z, parcel.readFloat(), parcel.readDouble(), parcel.readString());
            } else {
                if (i != 2) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                    return true;
                }
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                a(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void a(int i, long j, boolean z, float f, double d, String str);

    void a(int i, Bundle bundle);
}
