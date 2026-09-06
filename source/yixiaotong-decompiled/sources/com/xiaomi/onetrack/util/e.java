package com.xiaomi.onetrack.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class e extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f9511a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, Looper looper) {
        super(looper);
        this.f9511a = dVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what != 100) {
            return;
        }
        this.f9511a.c(message.getData().getString(ijiami_1011.s.s.s.d(new byte[]{95, 12, 12, Ascii.SYN}, "7ebbcf")));
    }
}
