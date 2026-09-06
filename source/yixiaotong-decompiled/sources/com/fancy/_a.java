package com.fancy;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _a implements _eg {
    public final Context _a;
    public _a4 _b;
    public ServiceConnectionC0358_a _c = new ServiceConnectionC0358_a();

    /* JADX INFO: renamed from: com.fancy._a$_a, reason: collision with other inner class name */
    public class ServiceConnectionC0358_a implements ServiceConnection {
        public ServiceConnectionC0358_a() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            String string;
            try {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    iBinder.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    string = parcelObtain2.readString();
                } catch (Throwable th) {
                    parcelObtain.recycle();
                    parcelObtain2.recycle();
                    th.printStackTrace();
                    string = null;
                }
                parcelObtain.recycle();
                parcelObtain2.recycle();
                _a4 _a4Var = _a.this._b;
                if (_a4Var != null) {
                    _a4Var._a(string);
                }
                _a _aVar = _a.this;
                _aVar._a.unbindService(_aVar._c);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            try {
                _a4 _a4Var = _a.this._b;
                if (_a4Var != null) {
                    _a4Var._a("");
                }
                _a _aVar = _a.this;
                _aVar._a.unbindService(_aVar._c);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public _a(Context context) {
        this._a = context;
    }

    @Override // com.fancy._eg
    public final void _a(_a4 _a4Var) {
        this._b = _a4Var;
        try {
            if (this._a == null) {
                if (_a4Var != null) {
                    _a4Var._a("");
                }
            } else {
                Intent intent = new Intent();
                intent.setAction("com.asus.msa.action.ACCESS_DID");
                intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
                this._a.bindService(intent, this._c, 1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
