package com.byazt.bu;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.byazt.dna.qp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 68, 20})
public final class c {
    public volatile uj<tt> c = uj.c(2);

    public tt c(qp.c cVar, final String str) {
        tt ttVar = this.c != null ? (tt) this.c.c() : null;
        if (ttVar != null) {
            ttVar.c(cVar);
            ttVar.post(new Runnable() { // from class: com.byazt.bu.c.1
                @Override // java.lang.Runnable
                public void run() {
                    Thread.currentThread().setName(str);
                }
            });
            return ttVar;
        }
        return tt(cVar, str);
    }

    public Handler c(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "csj-handler";
        }
        return c(null, str);
    }

    private tt tt(qp.c cVar, String str) {
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        return new tt(handlerThread.getLooper(), cVar);
    }

    public boolean c(Handler handler) {
        if (this.c == null) {
            if (handler != null) {
                handler.getLooper().quit();
            }
            return false;
        }
        if (!(handler instanceof tt)) {
            return false;
        }
        tt ttVar = (tt) handler;
        if (this.c.c(ttVar)) {
            return true;
        }
        ttVar.tt();
        return true;
    }

    public void c() {
        c(0);
        this.c = null;
    }

    private void c(int i) {
        tt ttVar;
        while (this.c.tt() > i && (ttVar = (tt) this.c.c()) != null) {
            ttVar.tt();
        }
    }
}
