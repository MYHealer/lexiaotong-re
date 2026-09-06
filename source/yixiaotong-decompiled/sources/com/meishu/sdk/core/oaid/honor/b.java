package com.meishu.sdk.core.oaid.honor;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.l;

/* JADX INFO: compiled from: IHonorBinder.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class b extends Binder implements IInterface {
    public b() {
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
            parcel.readInt();
            parcel.readLong();
            parcel.readInt();
            parcel.readFloat();
            parcel.readDouble();
            parcel.readString();
        } else {
            if (i != 2) {
                if (i == 1598968902) {
                    parcel2.writeString("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                    return true;
                }
                try {
                    return super.onTransact(i, parcel, parcel2, i2);
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }
            parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
            int i3 = parcel.readInt();
            Bundle bundle = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
            a.b bVar = (a.b) this;
            if (i3 == 0) {
                try {
                    bundle.keySet();
                    String string = bundle.getString("oa_id_flag");
                    LogUtil.d("HonorOaidUtil", "honorOaid=" + string);
                    a.c cVar = a.this.f4823a;
                    if (cVar != null) {
                        ((l.a) cVar).a(string);
                    }
                } catch (Exception e2) {
                    try {
                        Log.i("AdvertisingIdPlatform", "OAIDCallBack handleResult error: " + e2.getMessage());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                } catch (Throwable unused) {
                }
            }
        }
        parcel2.writeNoException();
        return true;
    }
}
