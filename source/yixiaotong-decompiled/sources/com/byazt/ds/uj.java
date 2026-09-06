package com.byazt.ds;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.pro.am;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1480, 15})
public class uj extends ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f2115a;
    public final Context n;

    public uj(Context context, x xVar) {
        super(true, false);
        this.n = context;
        this.f2115a = xVar;
    }

    @Override // com.byazt.ds.ve
    public boolean c(JSONObject jSONObject) throws JSONException, SecurityException {
        jSONObject.put(am.x, "Android");
        jSONObject.put("os_version", Build.VERSION.RELEASE);
        jSONObject.put("os_api", Build.VERSION.SDK_INT);
        jSONObject.put("device_model", com.byazt.yv.c.n());
        jSONObject.put(am.F, Build.BRAND);
        jSONObject.put(am.H, com.byazt.yv.c.a());
        jSONObject.put("cpu_abi", Build.CPU_ABI);
        jSONObject.put("build_serial", this.f2115a.aw() ? c(this.n) : this.f2115a.sv());
        return true;
    }

    private static String c(Context context) {
        String serial = null;
        if (context == null) {
            return null;
        }
        if (context.getApplicationInfo().targetSdkVersion >= 26) {
            try {
                serial = Build.getSerial();
            } catch (Throwable unused) {
            }
        }
        if (TextUtils.isEmpty(serial) || TextUtils.equals(serial, "unknown")) {
            serial = Build.SERIAL;
        }
        return (TextUtils.isEmpty(serial) || TextUtils.equals(serial, "unknown")) ? "" : serial;
    }
}
