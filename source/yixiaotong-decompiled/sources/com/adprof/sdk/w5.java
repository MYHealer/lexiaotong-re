package com.adprof.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class w5 extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z5 f1493a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w5(z5 z5Var, Looper looper) {
        super(looper);
        this.f1493a = z5Var;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what != 6000) {
            return;
        }
        z5 z5Var = this.f1493a;
        if (z5Var.f904a) {
            return;
        }
        z5Var.f904a = true;
        this.f1493a.setState(fo.STATE_BUFFERING_START);
    }
}
