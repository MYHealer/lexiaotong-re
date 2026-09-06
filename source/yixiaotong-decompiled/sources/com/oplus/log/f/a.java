package com.oplus.log.f;

import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a extends b {
    @Override // com.oplus.log.f.b
    public void a(String str, String str2, boolean z, byte b) {
        if ((b >= b() || b() != -1) && z) {
            if (com.oplus.log.b.c() || com.oplus.log.b.d()) {
                if (b == 1) {
                    Log.v(str, str2);
                    return;
                }
                if (b == 2) {
                    Log.d(str, str2);
                    return;
                }
                if (b == 3) {
                    Log.i(str, str2);
                } else if (b == 4) {
                    Log.w(str, str2);
                } else {
                    if (b != 5) {
                        return;
                    }
                    Log.e(str, str2);
                }
            }
        }
    }
}
