package com.adprof.sdk;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class jp extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fg f1255a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f408a;

    public jp() {
        this.f1255a = null;
    }

    public jp(fg fgVar) {
        this.f1255a = fgVar;
        if (fgVar != null) {
            this.f408a = String.format("http request error status code " + fgVar.f1172a, new Object[0]);
        }
    }

    public jp(String str) {
        super(str);
        this.f1255a = null;
    }

    public jp(Throwable th) {
        super(th);
        this.f1255a = null;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return !TextUtils.isEmpty(this.f408a) ? this.f408a : super.getMessage();
    }
}
