package com.oplus.log;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class f extends com.oplus.log.f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.oplus.log.a.a f5827a;

    public f(com.oplus.log.a.a aVar) {
        this.f5827a = aVar;
    }

    @Override // com.oplus.log.f.b
    public final void a(String str, String str2, boolean z, byte b) {
        com.oplus.log.a.a aVar;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (a() != -1 && b >= a() && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (aVar = this.f5827a) != null) {
            aVar.a(str, str2, b, c());
        }
        if (!z || b() == -1 || b < b()) {
            return;
        }
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
