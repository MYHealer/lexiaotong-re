package com.adprof.sdk;

import android.text.TextUtils;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class y6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static y6 f1532a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f849a = 50;
    public int b = -1;
    public int c = 0;

    public static y6 a() {
        if (f1532a == null) {
            synchronized (y6.class) {
                if (f1532a == null) {
                    f1532a = new y6();
                }
            }
        }
        return f1532a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public int m729a() {
        String strOptString;
        int i = this.b;
        if (i > 0) {
            return i;
        }
        c1 c1Var = d1.f1121a;
        c1Var.a().getClass();
        int i2 = 10000;
        try {
            JSONObject jSONObject = c1Var.a().f210a;
            String str = "";
            if (jSONObject != null && (strOptString = jSONObject.optString("conn_timeout_mills", "")) != null) {
                str = strOptString;
            }
            pk.d(" server conn timeout = " + str);
            if (!TextUtils.isEmpty(str)) {
                i2 = Integer.parseInt(StringsKt.trim((CharSequence) str).toString());
            }
        } catch (Throwable th) {
            pk.c("get conn timeout parse error: ", th);
        }
        this.b = i2;
        if (pk.f594a) {
            pk.a(" connTimeout = " + this.b);
        }
        return this.b;
    }

    public void a(int i) {
        if (i > 0) {
            this.c = i;
        }
    }
}
