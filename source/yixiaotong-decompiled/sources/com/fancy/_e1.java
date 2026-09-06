package com.fancy;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.Parcel;
import android.provider.Settings;
import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _e1 implements _eg {
    public final Context _a;
    public _a4 _b;
    public _a _c = new _a();

    public class _a implements ServiceConnection {

        /* JADX INFO: renamed from: com.fancy._e1$_a$_a, reason: collision with other inner class name */
        public class RunnableC0362_a implements Runnable {
            public final /* synthetic */ IBinder _a;

            /* JADX INFO: renamed from: com.fancy._e1$_a$_a$_a, reason: collision with other inner class name */
            public class RunnableC0363_a implements Runnable {
                public final /* synthetic */ String _a;

                public RunnableC0363_a(String str) {
                    this._a = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    _a4 _a4Var = _e1.this._b;
                    if (_a4Var != null) {
                        _a4Var._a(this._a);
                    }
                    _e1 _e1Var = _e1.this;
                    _e1Var._a.unbindService(_e1Var._c);
                }
            }

            public RunnableC0362_a(IBinder iBinder) {
                this._a = iBinder;
            }

            @Override // java.lang.Runnable
            public final void run() {
                String string;
                try {
                    IBinder iBinder = this._a;
                    Parcel parcelObtain = Parcel.obtain();
                    Parcel parcelObtain2 = Parcel.obtain();
                    try {
                        parcelObtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                        iBinder.transact(1, parcelObtain, parcelObtain2, 0);
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
                    com.fancy.adsdk.lib.utils._d._c(new RunnableC0363_a(string));
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }

        public _a() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.fancy.adsdk.lib.utils._d._b(new RunnableC0362_a(iBinder));
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            try {
                _a4 _a4Var = _e1.this._b;
                if (_a4Var != null) {
                    _a4Var._a("");
                }
                _e1 _e1Var = _e1.this;
                _e1Var._a.unbindService(_e1Var._c);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public _e1(Context context) {
        this._a = context;
    }

    public static boolean _a(String str) {
        if (str != null) {
            return "00000000-0000-0000-0000-000000000000".equals(str);
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0052 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:29:0x0054 A[Catch: all -> 0x006a, TRY_ENTER, TryCatch #2 {all -> 0x006a, blocks: (B:3:0x0006, B:7:0x000e, B:9:0x0012, B:11:0x0022, B:14:0x002a, B:17:0x0030, B:29:0x0054, B:31:0x0058, B:20:0x003d, B:23:0x0045), top: B:42:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0058 A[Catch: all -> 0x006a, TRY_LEAVE, TryCatch #2 {all -> 0x006a, blocks: (B:3:0x0006, B:7:0x000e, B:9:0x0012, B:11:0x0022, B:14:0x002a, B:17:0x0030, B:29:0x0054, B:31:0x0058, B:20:0x003d, B:23:0x0045), top: B:42:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:45:? A[RETURN, SYNTHETIC] */
    @Override // com.fancy._eg
    public final void _a(_a4 _a4Var) {
        String str = "com.huawei.hwid.tv";
        String str2 = "com.huawei.hwid";
        this._b = _a4Var;
        try {
            Context context = this._a;
            if (context == null) {
                if (_a4Var != null) {
                    _a4Var._a("");
                    return;
                }
                return;
            }
            try {
                String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
                if (!TextUtils.isEmpty(string) && !_a(string)) {
                    if (_a4Var != null) {
                        _a4Var._a(string);
                        return;
                    }
                    return;
                }
            } catch (Exception unused) {
            }
            boolean z = false;
            try {
                PackageManager packageManager = this._a.getPackageManager();
                if (packageManager.getPackageInfo("com.huawei.hwid", 0) == null) {
                    if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                        z = true;
                    } else {
                        str2 = "com.huawei.hms";
                        if (packageManager.getPackageInfo("com.huawei.hms", 0) == null) {
                            str = str2;
                        }
                    }
                    if (z) {
                        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
                        intent.setPackage(str);
                        this._a.bindService(intent, this._c, 1);
                    } else if (_a4Var != null) {
                        _a4Var._a("");
                    }
                }
                str = str2;
                z = true;
            } catch (Exception unused2) {
            }
            if (z) {
                if (_a4Var != null) {
                    _a4Var._a("");
                }
            } else {
                Intent intent2 = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
                intent2.setPackage(str);
                this._a.bindService(intent2, this._c, 1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
