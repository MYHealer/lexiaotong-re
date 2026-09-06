package com.jd.ad.sdk.jad_ir;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_er {
    public static final Executor jad_an = new jad_an();
    public static final Executor jad_bo = new jad_bo();

    public class jad_an implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            jad_ly.jad_bo().post(runnable);
        }
    }

    public class jad_bo implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            runnable.run();
        }
    }
}
