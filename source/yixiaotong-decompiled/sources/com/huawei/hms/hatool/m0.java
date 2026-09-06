package com.huawei.hms.hatool;

import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f4095a = false;
    private int b = 4;

    private static String a() {
        return "FormalHASDK_2.2.0.313" + p.a();
    }

    public void a(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator()).append("======================================= ").append(System.lineSeparator()).append(a()).append("").append(System.lineSeparator()).append("=======================================");
        Log.i("FormalHASDK", sb.toString());
        this.b = i;
        this.f4095a = true;
    }

    public void a(int i, String str, String str2) {
        if (i == 3) {
            Log.d(str, str2);
            return;
        }
        if (i == 5) {
            Log.w(str, str2);
        } else if (i != 6) {
            Log.i(str, str2);
        } else {
            Log.e(str, str2);
        }
    }

    public void b(int i, String str, String str2) {
        a(i, "FormalHASDK", str + "=> " + str2);
    }

    public boolean b(int i) {
        return this.f4095a && i >= this.b;
    }
}
