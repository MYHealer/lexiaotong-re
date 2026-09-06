package com.baidu.mobads.sdk.internal;

import android.content.SharedPreferences;
import android.os.Handler;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class cj extends j {
    final /* synthetic */ cb.c b;
    final /* synthetic */ Handler c;
    final /* synthetic */ cb d;

    cj(cb cbVar, cb.c cVar, Handler handler) {
        this.d = cbVar;
        this.b = cVar;
        this.c = handler;
    }

    @Override // com.baidu.mobads.sdk.internal.j
    protected Object i() {
        try {
            try {
                synchronized (cb.class) {
                    try {
                        this.d.b(this.b, this.c);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                SharedPreferences.Editor editorEdit = this.d.m().edit();
                editorEdit.putString(cb.d, this.d.a());
                editorEdit.apply();
                return null;
            } catch (Throwable th2) {
                try {
                    this.d.z.a(cb.f1765a, "Load APK Failed: " + th2.toString());
                    this.d.b(false);
                    SharedPreferences.Editor editorEdit2 = this.d.m().edit();
                    editorEdit2.putString(cb.d, this.d.a());
                    editorEdit2.apply();
                    return null;
                } catch (Throwable th3) {
                    try {
                        SharedPreferences.Editor editorEdit3 = this.d.m().edit();
                        editorEdit3.putString(cb.d, this.d.a());
                        editorEdit3.apply();
                    } catch (Throwable th4) {
                        this.d.z.a(cb.f1765a, th4);
                    }
                    throw th3;
                }
            }
        } catch (Throwable th5) {
            this.d.z.a(cb.f1765a, th5);
            return null;
        }
    }
}
