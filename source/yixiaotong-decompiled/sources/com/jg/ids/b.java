package com.jg.ids;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
final class b extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ a f4592a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    b(a aVar, Looper looper) {
        super(looper);
        this.f4592a = aVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        super.handleMessage(message);
        try {
            this.f4592a.a(message);
        } catch (Throwable th) {
        }
    }
}
