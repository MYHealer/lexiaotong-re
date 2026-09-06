package com.fancy;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _n3 implements _eg {
    public final Context _a;
    public _a4 _b;
    public _a _c = new _a();

    public class _a implements ServiceConnection {
        public _a() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            String string;
            try {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    iBinder.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    string = parcelObtain2.readString();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    th.printStackTrace();
                    string = null;
                }
                parcelObtain2.recycle();
                parcelObtain.recycle();
                _a4 _a4Var = _n3.this._b;
                if (_a4Var != null) {
                    _a4Var._a(string);
                }
                _n3 _n3Var = _n3.this;
                _n3Var._a.unbindService(_n3Var._c);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            try {
                _a4 _a4Var = _n3.this._b;
                if (_a4Var != null) {
                    _a4Var._a("");
                }
                _n3 _n3Var = _n3.this;
                _n3Var._a.unbindService(_n3Var._c);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public _n3(Context context) {
        this._a = context;
    }

    @Override // com.fancy._eg
    public final void _a(_a4 _a4Var) {
        this._b = _a4Var;
        if (this._a == null) {
            if (_a4Var != null) {
                _a4Var._a("");
            }
        } else {
            try {
                Intent intent = new Intent();
                intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
                this._a.bindService(intent, this._c, 1);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
