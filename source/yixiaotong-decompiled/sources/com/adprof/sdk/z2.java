package com.adprof.sdk;

import android.text.TextUtils;
import android.util.Log;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class z2 implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1548a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ul f891a;

    public z2(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (pk.m706a()) {
            pk.d("server返回数据 ext string = " + str);
        }
        try {
            String strOptString = new JSONObject(str).optString("slot_ext", "");
            if (!TextUtils.isEmpty(strOptString)) {
                this.f891a = new ul(new JSONObject(strOptString));
            }
        } catch (Throwable th) {
            pk.b(Log.getStackTraceString(th));
        }
        try {
            this.f1548a = new JSONObject(str).optInt("dsp_id", 0);
            pk.d(" server  dsp_id  =  " + this.f1548a);
        } catch (Throwable th2) {
            pk.b(Log.getStackTraceString(th2));
        }
    }

    public final ul a() {
        return this.f891a;
    }
}
