package com.byazt.sw;

import android.os.Handler;
import android.os.Message;
import com.byazt.nr.da;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 868, 54})
public class ve implements Handler.Callback {
    public Handler c;

    /* JADX INFO: renamed from: com.byazt.sw.ve$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 868, 79})
    static /* synthetic */ class AnonymousClass1 {
    }

    @com.byazt.zqa.c(c = {0, 1, 868, 24})
    private static class c {
        public static final ve c = new ve(null);
    }

    public /* synthetic */ ve(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static ve c() {
        return c.c;
    }

    private ve() {
        this.c = new Handler(da.c().getLooper(), this);
    }

    public void c(Runnable runnable) {
        Message messageObtain = Message.obtain();
        messageObtain.obj = runnable;
        this.c.sendMessage(messageObtain);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        ((Runnable) message.obj).run();
        return false;
    }

    public void c(Runnable runnable, long j) {
        this.c.postDelayed(runnable, j);
    }
}
