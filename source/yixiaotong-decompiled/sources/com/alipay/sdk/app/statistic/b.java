package com.alipay.sdk.app.statistic;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.packet.impl.d;
import com.alipay.sdk.util.j;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f1628a;
    final /* synthetic */ String b;

    b(Context context, String str) {
        this.f1628a = context;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar = new d();
        try {
            String strB = j.b(this.f1628a, a.f1627a, null);
            if (!TextUtils.isEmpty(strB) && dVar.a(this.f1628a, strB) != null) {
                j.b(this.f1628a, a.f1627a);
            }
        } catch (Throwable unused) {
        }
        try {
            if (TextUtils.isEmpty(this.b)) {
                return;
            }
            dVar.a(this.f1628a, this.b);
        } catch (IOException unused2) {
            j.a(this.f1628a, a.f1627a, this.b);
        } catch (Throwable unused3) {
        }
    }
}
