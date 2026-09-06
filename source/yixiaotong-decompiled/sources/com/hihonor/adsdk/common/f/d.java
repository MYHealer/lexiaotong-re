package com.hihonor.adsdk.common.f;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class d extends Handler {
    public l hnadsa;

    public d(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        try {
            super.dispatchMessage(message);
        } catch (Exception e) {
            l lVar = this.hnadsa;
            if (lVar != null) {
                lVar.hnadsa(e, (message == null || message.getCallback() == null) ? "" : message.getCallback().toString());
            }
        }
    }
}
