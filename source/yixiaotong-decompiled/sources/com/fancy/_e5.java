package com.fancy;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _e5 implements ServiceConnection {
    public Context _a;
    public _5._a _b = new _5._a();
    public _b _c = new _b();
    public _a _d = new _a();
    public CountDownLatch _e = new CountDownLatch(2);

    public class _a extends _ek {
        public _a() {
        }

        @Override // com.fancy._ek
        public final void _a(int i, Bundle bundle) {
            if (i == 0 && bundle != null && _e5.this._b != null) {
                _e5.this._b._b = bundle.getBoolean("oa_id_limit_state");
            }
            _e5.this._e.countDown();
        }

        @Override // com.fancy._ek
        public final void _c() {
        }
    }

    public class _b extends _ek {
        public _b() {
        }

        @Override // com.fancy._ek
        public final void _c() {
        }

        @Override // com.fancy._ek
        public final void _a(int i, Bundle bundle) {
            if (i == 0 && bundle != null && _e5.this._b != null) {
                String string = bundle.getString("oa_id_flag");
                _e5.this._b._a = string;
                try {
                    _a3 _a3Var_a = _a3._a();
                    Context context = _e5.this._a;
                    _a3Var_a.getClass();
                    try {
                        _kr._a(context, "ptg_ids_sp_honor_oaid", string);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                } catch (Throwable unused) {
                }
            }
            _e5.this._e.countDown();
        }
    }

    public class _c implements Runnable {
        public final IBinder _a;

        public _c(IBinder iBinder) {
            this._a = iBinder;
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x001d, code lost:
        
            r0 = null;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void run() {
            _el _elVar;
            try {
                Binder.getCallingPid();
                IBinder iBinder = this._a;
                if (iBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.hihonor.cloudservice.oaid.IOAIDService");
                    _elVar = iInterfaceQueryLocalInterface instanceof _el ? (_el) iInterfaceQueryLocalInterface : new _el(this._a);
                } else {
                    _elVar = null;
                }
            } catch (Exception unused) {
                _elVar = null;
            }
            try {
                _elVar._a(_e5.this._c);
                _elVar._a(_e5.this._d);
            } catch (Exception unused2) {
                _e5.this._e.countDown();
                _e5.this._e.countDown();
                _e5 _e5Var = _e5.this;
                _e5Var.getClass();
                try {
                    _e5Var._a.unbindService(_e5Var);
                } catch (Exception unused3) {
                }
            }
        }
    }

    public static boolean _a(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            packageManager.getPackageInfo("com.hihonor.id", 0);
            Intent intent = new Intent("com.hihonor.id.HnOaIdService");
            intent.setPackage("com.hihonor.id");
            return !packageManager.queryIntentServices(intent, 0).isEmpty();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        new Thread(new _c(iBinder)).start();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this._e.countDown();
        this._e.countDown();
    }
}
