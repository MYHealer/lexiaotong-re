package com.fancy;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.ExoPlayer;
import com.huawei.openalliance.ad.constant.x;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _5 {

    public static final class _a {
        public String _a;
        public boolean _b;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x009b  */
    /* JADX WARN: Code duplicated, block: B:48:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static _a _a(Context context) {
        try {
            _e5 _e5Var = new _e5();
            _e5Var._a = context;
            if (!_e5._a(context)) {
                return null;
            }
            _a _aVar = _e5Var._b;
            try {
                try {
                    String string = Settings.Global.getString(context.getContentResolver(), "oaid");
                    String str = "";
                    if (TextUtils.isEmpty(string)) {
                        _a3._a().getClass();
                        try {
                            string = _kr._d(context, "ptg_ids_sp_honor_oaid");
                        } catch (Throwable th) {
                            th.printStackTrace();
                            string = "";
                        }
                    }
                    if (!TextUtils.isEmpty(string)) {
                        String strReplace = string.replace(x.A, "");
                        for (int i = 0; i < strReplace.length(); i++) {
                            if (strReplace.charAt(i) == '0') {
                            }
                        }
                        if (TextUtils.isEmpty(str)) {
                            _aVar._b = false;
                            _aVar._a = str;
                            return _aVar;
                        }
                        try {
                            try {
                                Intent intent = new Intent("com.hihonor.id.HnOaIdService");
                                intent.setPackage("com.hihonor.id");
                                context.bindService(intent, _e5Var, 1);
                                _e5Var._e.await(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
                            } catch (Exception e) {
                                Log.e("AdvertisingIdPlatform", "getAdvertisingIdInfo error=" + e.getMessage());
                            }
                            try {
                                _e5Var._a.unbindService(_e5Var);
                            } catch (Exception unused) {
                            }
                            return _aVar;
                        } catch (Exception e2) {
                            Log.e("AdvertisingIdPlatform", "getAdvertisingIdInfo error=" + e2.getMessage());
                            _e5Var._a.unbindService(_e5Var);
                            return _aVar;
                        }
                        Log.e("AdvertisingIdPlatform", "getAdvertisingIdInfo error=" + e2.getMessage());
                        _e5Var._a.unbindService(_e5Var);
                        return _aVar;
                    }
                    str = string;
                    if (TextUtils.isEmpty(str)) {
                        _aVar._b = false;
                        _aVar._a = str;
                        return _aVar;
                    }
                    Intent intent2 = new Intent("com.hihonor.id.HnOaIdService");
                    intent2.setPackage("com.hihonor.id");
                    context.bindService(intent2, _e5Var, 1);
                    _e5Var._e.await(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
                    _e5Var._a.unbindService(_e5Var);
                    return _aVar;
                } catch (Exception unused2) {
                    Intent intent3 = new Intent("com.hihonor.id.HnOaIdService");
                    intent3.setPackage("com.hihonor.id");
                    context.bindService(intent3, _e5Var, 1);
                    _e5Var._e.await(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
                    _e5Var._a.unbindService(_e5Var);
                    return _aVar;
                }
                _e5Var._a.unbindService(_e5Var);
            } catch (Exception unused3) {
            }
            Log.e("AdvertisingIdPlatform", "getAdvertisingIdInfo error=" + e2.getMessage());
            return _aVar;
        } catch (Exception unused4) {
            return null;
        }
    }
}
