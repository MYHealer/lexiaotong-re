package com.fancy;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _dv implements _eg {
    public final Context _a;

    public class _a implements ServiceConnection {
        public final /* synthetic */ _a4 _a;

        public _a(_a4 _a4Var) {
            this._a = _a4Var;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            _er c0366_a;
            try {
                int i = _er._a._a;
                if (iBinder == null) {
                    c0366_a = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.android.creator.IdsSupplier");
                    c0366_a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof _er)) ? new _er._a.C0366_a(iBinder) : (_er) iInterfaceQueryLocalInterface;
                }
                if (this._a != null) {
                    this._a._a(c0366_a != null ? c0366_a._a() : "");
                }
                _dv.this._a.unbindService(this);
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
                _dv.this._a.unbindService(this);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public _dv(Context context) {
        this._a = context;
    }

    @Override // com.fancy._eg
    public final void _a(_a4 _a4Var) {
        if (this._a == null) {
            if (_a4Var != null) {
                _a4Var._a("");
            }
        } else {
            Intent intent = new Intent("android.service.action.msa");
            intent.setPackage("com.android.creator");
            this._a.bindService(intent, new _a(_a4Var), 1);
        }
    }
}
