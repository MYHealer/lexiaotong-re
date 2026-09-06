package com.hihonor.hianalytics.hnha;

import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public final class l2 extends i2 {
    private l2() {
    }

    public static n2 a() {
        return new l2();
    }

    @Override // com.hihonor.hianalytics.hnha.n2
    public n2 a(String str) {
        return this;
    }

    @Override // com.hihonor.hianalytics.hnha.n2
    public void a(String str, int i, String str2, String str3) {
        if (str == null) {
            return;
        }
        if (i == 3) {
            Log.d(str2, str);
        } else if (i == 5) {
            Log.w(str2, str);
        } else if (i != 6) {
            Log.i(str2, str);
        } else {
            Log.e(str2, str);
        }
        n2 n2Var = this.f3647a;
        if (n2Var != null) {
            n2Var.a(null, 0, str2, str3);
        }
    }
}
