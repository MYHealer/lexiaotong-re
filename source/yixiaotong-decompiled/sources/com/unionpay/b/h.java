package com.unionpay.b;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.unionpay.UPSEInfoResp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class h implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f9315a;

    h(g gVar) {
        this.f9315a = gVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            this.f9315a.i.removeMessages(4);
            com.unionpay.utils.j.c("uppay", "msg error");
            g.a(this.f9315a, message.arg1, (String) message.obj);
            return false;
        }
        if (i == 4) {
            com.unionpay.utils.j.c("uppay", "timeout");
            g.a(this.f9315a, message.arg1, UPSEInfoResp.ERROR_TIMEOUT);
            g.b(this.f9315a);
            return false;
        }
        if (i != 4000) {
            return false;
        }
        this.f9315a.i.removeMessages(4);
        g.a(this.f9315a, (Bundle) message.obj);
        return false;
    }
}
