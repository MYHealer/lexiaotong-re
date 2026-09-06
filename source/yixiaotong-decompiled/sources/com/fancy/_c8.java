package com.fancy;

import android.content.pm.Signature;
import android.text.TextUtils;
import com.fancy.adsdk.lib.PtgAdSdk;
import java.net.URLEncoder;
import java.security.MessageDigest;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _c8 implements Runnable {
    public final /* synthetic */ _c7 _a;

    public _c8(_c7 _c7Var) {
        this._a = _c7Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String strEncode = "";
        try {
            Signature signature = PtgAdSdk.getContext().getPackageManager().getPackageInfo(PtgAdSdk.getContext().getPackageName(), 64).signatures[0];
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(signature.toByteArray());
            String str_a = _c9._a(messageDigest.digest());
            try {
                if (!TextUtils.isEmpty(str_a)) {
                    strEncode = URLEncoder.encode(str_a, "UTF-8");
                }
            } catch (Exception unused) {
                strEncode = str_a;
            }
        } catch (Exception unused2) {
        }
        _c7 _c7Var = this._a;
        if (_c7Var != null) {
            _c7Var._A = strEncode;
        }
    }
}
