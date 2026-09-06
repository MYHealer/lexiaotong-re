package com.fancy;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _bq implements _eg {
    public final Context _a;

    public class _a implements ServiceConnection {
        public final /* synthetic */ _a4 _a;

        public _a(_a4 _a4Var) {
            this._a = _a4Var;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            _eh c0365_a;
            try {
                int i = _eh._a._a;
                if (iBinder == null) {
                    c0365_a = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    c0365_a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof _eh)) ? new _eh._a.C0365_a(iBinder) : (_eh) iInterfaceQueryLocalInterface;
                }
                if (this._a != null) {
                    this._a._a(c0365_a != null ? c0365_a._a(_bq.this._a.getPackageName()) : "");
                }
                _bq.this._a.unbindService(this);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            try {
                _a4 _a4Var = this._a;
                if (_a4Var != null) {
                    _a4Var._a("");
                }
                _bq.this._a.unbindService(this);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public _bq(Context context) {
        this._a = context instanceof Application ? context : StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    @Override // com.fancy._eg
    public final void _a(_a4 _a4Var) {
        try {
            if (this._a == null) {
                if (_a4Var != null) {
                    _a4Var._a("");
                }
            } else {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
                this._a.bindService(intent, new _a(_a4Var), 1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
