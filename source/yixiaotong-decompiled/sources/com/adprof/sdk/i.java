package com.adprof.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class i extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1218a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ k f371a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f372a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(k kVar, Looper looper) {
        super(looper);
        this.f371a = kVar;
        this.f1218a = 100L;
        this.f372a = true;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (87108 == message.what) {
            k kVar = this.f371a;
            if (kVar.f411a != null) {
                kVar.a();
                try {
                    sendEmptyMessageDelayed(87108, this.f1218a);
                } catch (Throwable th) {
                    pk.a(th);
                }
            }
        }
    }
}
