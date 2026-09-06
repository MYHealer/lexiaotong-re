package com.fancy;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.security.MessageDigest;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _hm implements _eg {
    public Context _a;
    public String _b;

    public class _a implements ServiceConnection {
        public final /* synthetic */ _a4 _a;

        public _a(_a4 _a4Var) {
            this._a = _a4Var;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            _hn _aVar;
            try {
                int i = _hn._b._a;
                if (iBinder == null) {
                    _aVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
                    _aVar = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof _hn)) ? new _hn._a(iBinder) : (_hn) iInterfaceQueryLocalInterface;
                }
                if (_aVar == null) {
                    _a4 _a4Var = this._a;
                    if (_a4Var != null) {
                        _a4Var._a("");
                    }
                    _hm.this._a.unbindService(this);
                    return;
                }
                try {
                    String str_a = _hm._a(_hm.this, _aVar);
                    _a4 _a4Var2 = this._a;
                    if (_a4Var2 != null) {
                        _a4Var2._a(str_a);
                    }
                } catch (Exception e) {
                    _a4 _a4Var3 = this._a;
                    if (_a4Var3 != null) {
                        _a4Var3._a("");
                    }
                    e.printStackTrace();
                }
                _hm.this._a.unbindService(this);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            try {
                _a4 _a4Var = this._a;
                if (_a4Var != null) {
                    _a4Var._a("");
                }
                _hm.this._a.unbindService(this);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public _hm(Context context) {
        this._a = context;
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
                intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                this._a.bindService(intent, new _a(_a4Var), 1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0061  */
    public static String _a(_hm _hmVar, _hn _hnVar) {
        Signature[] signatureArr;
        String string;
        String packageName = _hmVar._a.getPackageName();
        String string2 = null;
        if (_hmVar._b == null) {
            try {
                signatureArr = _hmVar._a.getPackageManager().getPackageInfo(packageName, 64).signatures;
            } catch (Throwable th) {
                th.printStackTrace();
                signatureArr = null;
            }
            if (signatureArr == null || signatureArr.length <= 0) {
                string = null;
            } else {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] bArrDigest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b : bArrDigest) {
                            sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
                        }
                        string = sb.toString();
                    } else {
                        string = null;
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            _hmVar._b = string;
        }
        _hn._a _aVar = (_hn._a) _hnVar;
        String str = _hmVar._b;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
            parcelObtain.writeString(packageName);
            parcelObtain.writeString(str);
            parcelObtain.writeString("OUID");
            _aVar._a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            string2 = parcelObtain2.readString();
        } catch (Throwable th3) {
            try {
                th3.printStackTrace();
            } finally {
                parcelObtain.recycle();
                parcelObtain2.recycle();
            }
        }
        return string2;
    }
}
