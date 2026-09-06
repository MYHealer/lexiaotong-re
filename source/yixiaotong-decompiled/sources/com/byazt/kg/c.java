package com.byazt.kg;

import android.os.FileObserver;
import android.os.SystemClock;
import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 428, 20})
public class c extends FileObserver {
    public final ve c;
    public final int tt;
    public volatile boolean ve;

    public c(ve veVar, String str, int i) {
        super(str, i);
        this.tt = 5000;
        this.ve = true;
        if (veVar == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("params is not right path is null or ANRManager is null");
        }
        this.c = veVar;
    }

    @Override // android.os.FileObserver
    public void onEvent(int i, String str) {
        if (this.ve && i == 8 && !TextUtils.isEmpty(str) && str.contains("trace") && this.c != null) {
            this.ve = false;
            this.c.c(200, "/data/anr/".concat(String.valueOf(str)), 80);
            new C0201c(5000).start();
        }
    }

    /* JADX INFO: renamed from: com.byazt.kg.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 428, 44})
    private final class C0201c extends com.byazt.jtc.ve {
        public int tt;

        public C0201c(int i) {
            super("ANRFileObserver$RestartMonitorThread");
            this.tt = i;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            SystemClock.sleep(this.tt);
            c.this.ve = true;
        }
    }
}
