package com.fancy;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _fk implements _eg {
    public final Context _a;
    public _a4 _b;
    public _a _c = new _a();

    public class _a implements ServiceConnection {
        public _a() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            String string;
            IInterface iInterfaceQueryLocalInterface;
            try {
                int i = _ei._a._a;
                if (iBinder != null && (iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface")) != null && (iInterfaceQueryLocalInterface instanceof _ei)) {
                }
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    iBinder.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    string = parcelObtain2.readString();
                } catch (Throwable th) {
                    try {
                        th.printStackTrace();
                        string = null;
                    } catch (Throwable th2) {
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th2;
                    }
                }
                parcelObtain2.recycle();
                parcelObtain.recycle();
                _a4 _a4Var = _fk.this._b;
                if (_a4Var != null) {
                    _a4Var._a(string);
                }
                _fk _fkVar = _fk.this;
                _fkVar._a.unbindService(_fkVar._c);
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            try {
                _a4 _a4Var = _fk.this._b;
                if (_a4Var != null) {
                    _a4Var._a("");
                }
                _fk _fkVar = _fk.this;
                _fkVar._a.unbindService(_fkVar._c);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public _fk(Context context) {
        this._a = context;
    }

    @Override // com.fancy._eg
    public final void _a(_a4 _a4Var) {
        try {
            this._b = _a4Var;
            if (this._a == null) {
                if (_a4Var != null) {
                    _a4Var._a("");
                }
            } else {
                Intent intent = new Intent();
                intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
                this._a.bindService(intent, this._c, 1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
