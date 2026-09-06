package com.miui.zeus.mimo.sdk;

import android.content.Context;
import com.miui.zeus.auth.aidl.ICheckListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
final /* synthetic */ class b$$Lambda$1 implements Runnable {
    private final Context arg$1;
    private final String arg$2;
    private final ICheckListener arg$3;

    private b$$Lambda$1(Context context, String str, ICheckListener iCheckListener) {
        this.arg$1 = context;
        this.arg$2 = str;
        this.arg$3 = iCheckListener;
    }

    public static Runnable lambdaFactory$(Context context, String str, ICheckListener iCheckListener) {
        return new b$$Lambda$1(context, str, iCheckListener);
    }

    @Override // java.lang.Runnable
    public void run() {
        b.b(this.arg$1, this.arg$2, this.arg$3);
    }
}
