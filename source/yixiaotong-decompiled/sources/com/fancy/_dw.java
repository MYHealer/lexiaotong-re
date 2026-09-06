package com.fancy;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.ads.identifier.internal.IAdvertisingIdService;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _dw implements _eg {
    public final Context _a;
    public _a _b;
    public volatile boolean _c = false;

    public class _a implements ServiceConnection {
        public final /* synthetic */ _a4 _a;

        /* JADX INFO: renamed from: com.fancy._dw$_a$_a, reason: collision with other inner class name */
        public class RunnableC0360_a implements Runnable {
            public final /* synthetic */ _ee _a;

            /* JADX INFO: renamed from: com.fancy._dw$_a$_a$_a, reason: collision with other inner class name */
            public class RunnableC0361_a implements Runnable {
                public final /* synthetic */ String _a;

                public RunnableC0361_a(String str) {
                    this._a = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    _a _aVar = _a.this;
                    _dw _dwVar = _dw.this;
                    _a4 _a4Var = _aVar._a;
                    String str = this._a;
                    _dwVar.getClass();
                    if (_a4Var != null) {
                        _a4Var._a(str);
                    }
                    _dw.this._a();
                }
            }

            /* JADX INFO: renamed from: com.fancy._dw$_a$_a$_b */
            public class _b implements Runnable {
                public _b() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    _a _aVar = _a.this;
                    _dw _dwVar = _dw.this;
                    _a4 _a4Var = _aVar._a;
                    _dwVar.getClass();
                    if (_a4Var != null) {
                        _a4Var._a("");
                    }
                    _dw.this._a();
                }
            }

            public RunnableC0360_a(_ee _eeVar) {
                this._a = _eeVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.fancy.adsdk.lib.utils._d._c(new RunnableC0361_a(this._a._b()));
                } catch (Throwable unused) {
                    com.fancy.adsdk.lib.utils._d._c(new _b());
                }
            }
        }

        public _a(_a4 _a4Var) {
            this._a = _a4Var;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            _ee c0364_a;
            _dw.this._c = false;
            try {
                int i = _ee._a._a;
                if (iBinder == null) {
                    c0364_a = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IAdvertisingIdService.DESCRIPTOR);
                    c0364_a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof _ee)) ? new _ee._a.C0364_a(iBinder) : (_ee) iInterfaceQueryLocalInterface;
                }
                com.fancy.adsdk.lib.utils._d._b(new RunnableC0360_a(c0364_a));
            } catch (Throwable unused) {
                _dw _dwVar = _dw.this;
                _a4 _a4Var = this._a;
                _dwVar.getClass();
                if (_a4Var != null) {
                    _a4Var._a("");
                }
                _dw.this._a();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            _dw.this._c = false;
            _dw _dwVar = _dw.this;
            _a4 _a4Var = this._a;
            _dwVar.getClass();
            if (_a4Var != null) {
                _a4Var._a("");
            }
            _dw.this._a();
        }
    }

    public _dw(Context context) {
        this._a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public final void _a() {
        _a _aVar = this._b;
        if (_aVar != null) {
            try {
                this._a.unbindService(_aVar);
            } catch (Exception unused) {
            }
            this._b = null;
        }
    }

    @Override // com.fancy._eg
    public final void _a(_a4 _a4Var) {
        try {
            if (this._a == null) {
                if (_a4Var != null) {
                    _a4Var._a("");
                    return;
                }
                return;
            }
            if (this._c) {
                if (_a4Var != null) {
                    _a4Var._a("");
                    return;
                }
                return;
            }
            this._b = new _a(_a4Var);
            this._c = true;
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (this._a.bindService(intent, this._b, 1)) {
                return;
            }
            this._c = false;
            if (_a4Var != null) {
                _a4Var._a("");
            }
            _a();
        } catch (Throwable th) {
            th.printStackTrace();
            this._c = false;
            if (_a4Var != null) {
                _a4Var._a("");
            }
            _a();
        }
    }
}
