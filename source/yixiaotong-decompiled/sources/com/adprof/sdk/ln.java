package com.adprof.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ln extends Handler {
    public ln(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what != 1) {
            super.handleMessage(message);
            return;
        }
        Object obj = message.obj;
        v9 v9Var = obj instanceof v9 ? (v9) obj : null;
        fn.a aVar = v9Var != null ? (fn.a) v9Var.f1475a : null;
        if (v9Var != null) {
            v9Var.f1475a = null;
        }
        if (aVar == null) {
            return;
        }
        try {
            if (aVar.isCancelled()) {
                return;
            }
            aVar.callback(aVar.mError);
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
    }
}
