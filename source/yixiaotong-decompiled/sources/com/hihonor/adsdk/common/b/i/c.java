package com.hihonor.adsdk.common.b.i;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.hihonor.adsdk.common.b.g;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c implements g {
    private static final String hnadsb = "HandlerLogStrategy";
    private final a hnadsa;

    static class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Throwable {
            super.handleMessage(message);
            com.hihonor.adsdk.common.b.j.a.hnadsa((String) message.obj);
        }
    }

    public c(a aVar) {
        this.hnadsa = aVar;
    }

    @Override // com.hihonor.adsdk.common.b.g
    public void hnadsa(int i, String str, String str2) {
        Log.d(hnadsb, "log#Send write log msg");
        a aVar = this.hnadsa;
        aVar.sendMessage(aVar.obtainMessage(i, str2));
    }
}
