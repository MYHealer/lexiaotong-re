package com.byazt.u;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.byazt.nr.m;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 67, 46})
public final class n implements Handler.Callback {
    public volatile Handler c = new Handler(c.c, this);

    public interface tt {
        long c();
    }

    @com.byazt.zqa.c(c = {0, 1, 67, 151})
    private static class c {
        public static final Looper c;

        static {
            HandlerThread handlerThread = new HandlerThread("DownloadWatchDog");
            handlerThread.start();
            c = handlerThread.getLooper();
        }
    }

    public static Looper c() {
        return c.c;
    }

    public void c(tt ttVar, long j) {
        Handler handler = this.c;
        if (handler == null) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 0;
        messageObtain.obj = ttVar;
        handler.sendMessageDelayed(messageObtain, j);
    }

    public void tt() {
        Handler handler = this.c;
        if (handler == null) {
            return;
        }
        this.c = null;
        handler.removeCallbacksAndMessages(null);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            return true;
        }
        try {
            tt ttVar = (tt) message.obj;
            long jC = ttVar.c();
            if (jC <= 0) {
                return true;
            }
            c(ttVar, jC);
            return true;
        } catch (Throwable th) {
            m.c(th);
            return true;
        }
    }
}
